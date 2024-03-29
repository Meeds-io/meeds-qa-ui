/*
 * This file is part of the Meeds project (https://meeds.io/).
 * 
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.utils;

import static io.meeds.qa.ui.utils.ExceptionLauncher.LOGGER;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SystemTimeouts;

public class Utils {

  public static final int      DEFAULT_WAIT_PAGE_LOADING         =
                                                         Integer.parseInt(System.getProperty("io.meeds.page.loading.wait",
                                                                                             "10"));

  public static final int      MAX_WAIT_RETRIES                  =
                                                Integer.parseInt(System.getProperty("io.meeds.retry.max", "3"));

  private static final Random  RANDOM                            = new Random();

  public static final long     DEFAULT_WAIT_FOR_TIMEOUT          = SystemTimeouts.forTheCurrentTest().getWaitForTimeout();

  public static final long     DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT = SystemTimeouts.forTheCurrentTest().getImplicitTimeout();

  public static final int      SHORT_WAIT_DURATION_MILLIS        =
                                                          Integer.parseInt(System.getProperty("io.meeds.retry.wait.millis",
                                                                                              "300"));

  public static final Duration SHORT_WAIT_DURATION               = Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS);

  public static String getRandomNumber() {
    char[] chars = "0123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      char c = chars[RANDOM.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  public static String getRandomString() {
    return getRandomString("");
  }

  public static String getRandomString(String base) {
    return getRandomString(base, 8);
  }

  public static String getRandomString(String base, int length) {
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    StringBuilder sb = new StringBuilder(base);
    for (int i = 0; i < length; i++) {
      char c = chars[RANDOM.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  public static boolean isStaleElementException(Throwable e) {
    return e instanceof StaleElementReferenceException || (e.getCause() != null && isStaleElementException(e.getCause()));
  }

  public static void refreshPage() {
    refreshPage(true);
  }

  public static void refreshPage(boolean waitAppsLoading) {
    Serenity.getDriver().navigate().refresh();
    try {
      Serenity.getDriver().switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
    if (waitAppsLoading) {
      waitForLoading();
    } else {
      waitForPageLoading();
    }
  }

  public static void retryOnCondition(Runnable task) {
    retryGetOnCondition(() -> runTask(task), null);
  }

  public static void retryOnCondition(Runnable task, long retry) {
    retryGetOnCondition(() -> runTask(task), null, retry);
  }

  public static void retryOnCondition(Runnable task, Runnable onError) {
    retryGetOnCondition(() -> runTask(task), onError);
  }

  public static void retryOnCondition(Runnable task, Runnable onError, long retry) {
    retryGetOnCondition(() -> runTask(task), onError, retry);
  }

  public static <T> T retryGetOnCondition(Supplier<T> supplier) {
    return retryGetOnCondition(supplier, null);
  }

  public static <T> T retryGetOnCondition(Supplier<T> supplier, long retry) {
    return retryGetOnCondition(supplier, null, retry);
  }

  public static <T> T retryGetOnCondition(Supplier<T> supplier, Runnable onError) { // NOSONAR
    return retryGetOnCondition(supplier, onError, MAX_WAIT_RETRIES);
  }

  public static <T> T retryGetOnCondition(Supplier<T> supplier, Runnable onError, final long retry) { // NOSONAR
    long retryIndex = retry;
    do {
      try {
        return supplier.get();
      } catch (Throwable e) {// NOSONAR
        if (--retryIndex <= 0) {
          if (e instanceof RuntimeException) {
            throw e;
          } else {
            throw new IllegalStateException("Unable to process on element after " + retry + " retries", e);
          }
        } else {
          LOGGER.info("Error executing tentative {}/{}", (retry - retryIndex), retry, new IOMeedsTraceException(e));
          if (onError != null) {
            runTask(onError);
          }
        }
      }
    } while (retryIndex > 0);
    return null;
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

  public static void waitForLoading() {
    waitForLoading(DEFAULT_WAIT_PAGE_LOADING, true);
  }

  public static void waitForLoading(int loadingWait, boolean includeApps) {
    waitForLoading(loadingWait, includeApps, 1);
  }

  public static void waitForLoading(int loadingWait, boolean includeApps, int retries) {
    long start = System.currentTimeMillis();
    try {
      WebDriverWait wait = new WebDriverWait(Serenity.getDriver(),
                                             Duration.ofSeconds(loadingWait),
                                             Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS));
      wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript(getPageLoadingScript(includeApps))
                                                              .toString()
                                                              .equals("true"));
    } catch (TimeoutException | JsonException e) {
      if (++retries > MAX_WAIT_RETRIES) {
        throw new IllegalStateException(String.format("Loading effect is still displayed on page after %s retries with timeout interval %s",
                                                      (retries - 1),
                                                      loadingWait));
      } else {
        LOGGER.info("Loading wait timed out. Retry {}/{}. Refresh page to try again.",
                    retries,
                    MAX_WAIT_RETRIES,
                    e);
        if (!includeApps) {
          refreshPage(false); // Must remain false to avoid infinite loop
        }
        waitForLoading(loadingWait, includeApps, retries);
      }
    } catch (Throwable e) { // NOSONAR
      waitRemainingTime(loadingWait * 1000l, start);
    }
  }

  public static int getIndexFomName(String appSettingPosition) {
    return switch (appSettingPosition) {
    case "first": {
      yield 1;
    }
    case "second": {
      yield 2;
    }
    case "third": {
      yield 3;
    }
    case "fourth": {
      yield 4;
    }
    case "fifth": {
      yield 5;
    }
    case "sixth": {
      yield 6;
    }
    default:
      throw new IllegalArgumentException("Unexpected value: " + appSettingPosition);
    };
  }

  public static void waitForPageLoading() {
    // Nothing for now
  }

  public static void waitRemainingTime(long loadingWaitMilliseconds, long start) {
    long remainingTime = loadingWaitMilliseconds - (System.currentTimeMillis() - start);
    if (remainingTime > 10) {
      LOGGER.debug("Waiting on element to refresh state within {}ms", remainingTime);
      waitForInMillis(remainingTime);
    } else {
      LOGGER.debug("Refresh element right away since the timeout is already elasped since {}ms", -remainingTime);
    }
  }

  private static String getPageLoadingScript(boolean includeApps) {
    String pageLoadingScript = "return document.readyState === 'complete'";
    return includeApps ? pageLoadingScript
        + " && (!document.getElementById('TopbarLoadingContainer') || !!document.querySelector('.TopbarLoadingContainer.hidden'))"
        + " && !document.querySelector('.v-card .v-progress-linear__indeterminate')"
        + " && !document.querySelector('.v-navigation-drawer--open .v-progress-linear__indeterminate')"
        + " && !document.querySelector('.v-card .v-progress-circular--indeterminate')"
        + " && !document.querySelector('.v-navigation-drawer--open .v-progress-circular--indeterminate')"
                       : pageLoadingScript;
  }

  private static Object runTask(Runnable task) {
    task.run();
    return null;
  }

  private Utils() {
    // Class containing static methods only
  }

}
