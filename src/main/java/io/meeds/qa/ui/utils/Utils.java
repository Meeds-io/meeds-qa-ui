package io.meeds.qa.ui.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.Serenity;

public class Utils {

  private static final Random RANDOM = new Random();

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
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(120));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState === 'complete' "
        + " && (!document.getElementById('TopbarLoadingContainer') || !!document.querySelector('.TopbarLoadingContainer.hidden'))"
        + " && !document.querySelector('.v-navigation-drawer--open .v-progress-linear')")
                                                            .toString()
                                                            .equals("true"));
  }

  public static void switchToTabByIndex(int index) {
    ArrayList<String> newTab = new ArrayList<>(Serenity.getWebdriverManager().getCurrentDriver().getWindowHandles());
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().window(newTab.get(index));
  }

}
