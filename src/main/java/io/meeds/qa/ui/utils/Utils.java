package io.meeds.qa.ui.utils;

import static io.meeds.qa.ui.utils.ExceptionLauncher.LOGGER;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.Serenity;

public class Utils {

  private static final int     DEFAULT_WAIT_PAGE_LOADING  = Integer.parseInt(System.getProperty("io.meeds.page.loading.wait",
                                                                                                "10"));

  public static final int      MAX_WAIT_RETRIES           = Integer.parseInt(System.getProperty("io.meeds.retry.max", "3"));

  private static final Random  RANDOM                     = new Random();

  public static final int      SHORT_WAIT_DURATION_MILLIS = Integer.parseInt(System.getProperty("io.meeds.retry.wait.millis",
                                                                                                "300"));

  public static final Duration SHORT_WAIT_DURATION        = Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS);

  public static String getRandomNumber() {
    char[] chars = "0123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      char c = chars[RANDOM.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
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

  public static String getTheRandomNumber() {
    char[] chars = "0123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      char c = chars[RANDOM.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  public static boolean isStaleElementException(Throwable e) {
    return e instanceof StaleElementReferenceException || (e.getCause() != null && isStaleElementException(e.getCause()));
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

  public static <T> T retryOnCondition(Supplier<T> supplier, Runnable onError) { // NOSONAR
    long retry = 0;
    do {
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
          if (onError != null) {
            onError.run();
          }
        }
      }
    } while (true);
  }

  public static void switchToTabByIndex(WebDriver driver, int index) {
    ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(newTab.get(index));
  }

  public static void waitForInMillis(long timeInMilliseconds) {
    try {
      Thread.sleep(timeInMilliseconds);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  public static void waitForPageLoaded() {
    waitForPageLoaded(DEFAULT_WAIT_PAGE_LOADING);
  }

  public static void waitForPageLoaded(int pageLoadingWait) {
    try {
      WebDriverWait wait = new WebDriverWait(Serenity.getDriver(),
                                             Duration.ofSeconds(pageLoadingWait),
                                             Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS));
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

  private Utils() {
    // Class containing static methods only
  }

}
