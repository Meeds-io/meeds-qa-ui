package io.meeds.qa.ui.utils;

import static io.meeds.qa.ui.utils.ExceptionLauncher.LOGGER;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.meeds.qa.ui.listener.CustomWebDriverListener;
import net.serenitybdd.core.Serenity;

public class Utils {

  public static final int            MAX_WAIT_RETRIES       =
                                                      Integer.parseInt(System.getProperty("io.meeds.parallel.retry.max", "5"));

  private static final AtomicInteger LOCK_COUNT             = new AtomicInteger(0);

  private static final Random        RANDOM                 = new Random();

  private static final int           TIMEOUT_CHECK_INTERVAL = 100;

  private static final int           TIMEOUT_MILLISECONDS   =
                                                          Integer.parseInt(System.getProperty("io.meeds.windowSwitch.timeout",
                                                                                              "20000"));

  private static final String        LOCK_FILE_PATH         = System.getProperty("io.meeds.windowSwitch.lockFile", "lockFile");

  private static final File          LOCK_FILE              = new File(LOCK_FILE_PATH);

  private static final int           PARALLEL_TESTS         =
                                                    Integer.parseInt(System.getProperty("io.meeds.parallel.tests", "1"));

  private static final boolean       PARALLEL_TESTING       = PARALLEL_TESTS > 1;

  private static WebDriver           decoratedWebDriver;

  private static String              windowId;

  private static boolean             locked;

  private Utils() {
    // Class containing static methods only
  }

  public static String getRandomNumber() {
    char[] chars = "0123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      char c = chars[RANDOM.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  public static int getRandomInteger(int bound) {
    return RANDOM.nextInt(bound);
  }

  public static String getRandomString() {
    return getRandomString("");
  }

  public static String getRandomString(String base) {
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    StringBuilder sb = new StringBuilder(base);
    for (int i = 0; i < 6; i++) {
      char c = chars[RANDOM.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  public static void waitForPageLoaded() {
    try {
      WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(10));
      wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState === 'complete' "
          + " && (!document.getElementById('TopbarLoadingContainer') || !!document.querySelector('.TopbarLoadingContainer.hidden'))"
          + " && !document.querySelector('.v-navigation-drawer--open .v-progress-linear')")
                                                              .toString()
                                                              .equals("true"));
    } catch (TimeoutException | JsonException e) {
      Serenity.getDriver().navigate().refresh();
      waitForPageLoaded();
    } catch (RuntimeException e) {
      String result =
                    ((JavascriptExecutor) Serenity.getDriver()).executeScript("return `document.readyState: ${document.readyState} ,"
                        + " TopbarLoadingContainer = ${(!document.getElementById('TopbarLoadingContainer') || !!document.querySelector('.TopbarLoadingContainer.hidden'))}, "
                        + " v-navigation-drawer--open = ${!document.querySelector('.v-navigation-drawer--open .v-progress-linear')}")
                                                               .toString();
      LOGGER.warn("Error on waiting document to be loaded. {}", result);
    }
  }

  public static void switchToTabByIndex(WebDriver driver, int index) {
    ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(newTab.get(index));
  }

  public static void switchToCurrentWindow(WebDriver driver, Object element, String reason) {
    switchToCurrentWindow(driver, element, reason, 1);
  }

  private static void switchToCurrentWindow(WebDriver driver, Object element, String reason, int retry) {
    if (!PARALLEL_TESTING) {
      return;
    }
    long start = System.currentTimeMillis();
    if (incrementLock()) {
      LOGGER.debug(".............. {} ignore locking {} - {}", LOCK_COUNT.get(), reason, windowId);
    } else if (tryLock()) {
      try {
        driver.switchTo().window(windowId);
        driver.switchTo().activeElement();
        LOGGER.debug("++++ LOCKED in {}ms. {} - {} - {}", (System.currentTimeMillis() - start), reason, windowId, element);
      } catch (Exception e) {
        unlock();
        LOGGER.warn("++++ LOCK ERROR {} times in {}ms. Will retry it. {} - {} - {}",
                    retry,
                    (System.currentTimeMillis() - start),
                    reason,
                    windowId,
                    element,
                    e);
        if (retry < 3) {
          // Try again
          switchToCurrentWindow(driver, element, reason, ++retry);
        }
      }
    } else {
      LOGGER.warn("++++ NOT locked in {}ms. {} - {} - {}", (System.currentTimeMillis() - start), reason, windowId, element);
    }
  }

  public static void releaseCurrentWindow(WebDriver driver, Object element, String reason) { // NOSONAR
    if (!PARALLEL_TESTING) {
      return;
    }
    long start = System.currentTimeMillis();
    if (decrementLock()) {
      LOGGER.debug(".............. {} ignore unlocking {} - {} - {}",
                   LOCK_COUNT.get(),
                   reason,
                   windowId,
                   element);
    } else if (unlock()) {
      LOGGER.debug("---- UNLOCKED in {}ms. {} - {} - {}",
                   (System.currentTimeMillis() - start),
                   reason,
                   windowId,
                   element);
    }
  }

  public static void releaseWindowTemporarely(WebDriver driver, Object element, String reason, long timeInMilliseconds) {
    if (!PARALLEL_TESTING) {
      waitForInMillis(timeInMilliseconds);
      return;
    }
    int times = 0;
    while (isLocked()) {
      releaseCurrentWindow(driver, element, reason);
      times++;
    }
    waitForInMillis(timeInMilliseconds * PARALLEL_TESTS);
    for (int i = 0; i < times; i++) {
      switchToCurrentWindow(driver, element, reason);
    }
  }

  public static void retryOnCondition(Runnable runnable) {
    retryOnCondition(runnable, null);
  }

  public static void retryOnCondition(Runnable task, Runnable onError) {
    retryOnCondition(() -> {
      task.run();
      return null;
    }, onError);
  }

  public static <T> T retryOnCondition(Supplier<T> supplier) {
    return retryOnCondition(supplier, null);
  }

  public static <T> T retryOnCondition(Supplier<T> supplier, Runnable onError) {
    long retry = 0;
    Thread currentThread = Thread.currentThread();
    String originalName = currentThread.getName();
    try {
      do {
        String threadName = originalName + "Retry = " + (retry + 1) + "/" + MAX_WAIT_RETRIES;
        currentThread.setName(threadName);
        try {
          return supplier.get();
        } catch (Throwable e) {// NOSONAR
          if (++retry == MAX_WAIT_RETRIES) {
            if (e instanceof RuntimeException) {
              throw e;
            } else {
              throw new IllegalStateException("Unable to process on element after " + retry + " retries", e);
            }
          } else {
            LOGGER.debug("Error processing event on element. retry = {}/{}", retry, MAX_WAIT_RETRIES);
            releaseWindowTemporarely(decoratedWebDriver, null, e.getMessage(), 200);
            if (onError != null) {
              onError.run();
            }
          }
        }
      } while (true);
    } finally {
      currentThread.setName(originalName);
    }
  }

  public static WebDriver decorateDriver(WebDriver driver) {
    if (!PARALLEL_TESTING) {
      decoratedWebDriver = driver;
      return driver;
    }
    if (decoratedWebDriver == null) {
      if (driver == null) {
        driver = Serenity.getDriver();
      }
      EventFiringDecorator eventDriver = new EventFiringDecorator(new CustomWebDriverListener(driver));
      decoratedWebDriver = eventDriver.decorate(driver);
      windowId = driver.getWindowHandle();
      Serenity.getWebdriverManager().setCurrentDriver(decoratedWebDriver);
    }
    return decoratedWebDriver;
  }

  public static boolean isParallelTesting() {
    return PARALLEL_TESTING;
  }

  public static boolean isLocked() {
    return locked;
  }

  private static boolean tryLock() {
    int elapsedTime = 0;
    while (!locked) {
      try {
        if (!LOCK_FILE.exists()) {
          locked = LOCK_FILE.createNewFile();
        }
      } catch (IOException e) {
        locked = false;
      }
      if (elapsedTime > TIMEOUT_MILLISECONDS) {
        return false;
      } else if (!locked) {
        LOGGER.debug(".............. wait locking {}", windowId);
        try {
          elapsedTime += TIMEOUT_CHECK_INTERVAL;
          Thread.sleep(TIMEOUT_CHECK_INTERVAL);
        } catch (InterruptedException e1) {
          Thread.currentThread().interrupt();
        }
      }
    }
    return isLocked();
  }

  private static boolean unlock() {
    if (isLocked()) {
      return unlockFile();
    }
    return false;
  }

  private static boolean unlockFile() {
    try {
      Files.delete(LOCK_FILE.toPath());
      return true;
    } catch (IOException e) {
      throw new IllegalStateException("Error while releasing lock", e);
    } finally {
      locked = false;
    }
  }

  private static boolean incrementLock() {
    return LOCK_COUNT.incrementAndGet() > 1;
  }

  private static boolean decrementLock() {
    int lockCount = LOCK_COUNT.get();
    if (lockCount <= 0) {
      LOGGER.warn("DECREMENT ERROR, currrent value = {}", lockCount);
      return true;
    } else {
      return LOCK_COUNT.decrementAndGet() > 0;
    }
  }

  private static void waitForInMillis(long timeInMilliseconds) {
    try {
      Thread.sleep(timeInMilliseconds);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

}
