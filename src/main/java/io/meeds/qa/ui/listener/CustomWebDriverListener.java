package io.meeds.qa.ui.listener;

import static io.meeds.qa.ui.utils.Utils.releaseCurrentWindow;
import static io.meeds.qa.ui.utils.Utils.switchToCurrentWindow;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import io.meeds.qa.ui.utils.ExceptionLauncher;

public class CustomWebDriverListener implements WebDriverListener {

  private WebDriver webDriver;

  public CustomWebDriverListener(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  @Override
  public void beforeImplicitlyWait(Timeouts timeouts, Duration duration) {
    switchToCurrentWindow(webDriver, null, "beforeImplicitlyWait");
  }

  @Override
  public void afterImplicitlyWait(Timeouts timeouts, Duration duration) {
    releaseCurrentWindow(webDriver, null, "afterImplicitlyWait");
  }

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    switchToCurrentWindow(driver, locator, "beforeFindElement");
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    releaseCurrentWindow(driver, locator, "afterFindElement");
  }

  @Override
  public void beforeClick(WebElement element) {
    switchToCurrentWindow(webDriver, element, "beforeClick");
  }

  @Override
  public void afterClick(WebElement element) {
    releaseCurrentWindow(webDriver, element, "afterClick");
  }

  @Override
  public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    switchToCurrentWindow(webDriver, element, "beforeSendKeys");
  }

  @Override
  public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    releaseCurrentWindow(webDriver, null, "afterSendKeys");
  }

  @Override
  public void onError(Object target, Method method, Object[] args, InvocationTargetException e) { // NOSONAR
    String methodName = method == null ? StringUtils.EMPTY : method.getName();
    switch (methodName) {
      case "findElement":
        By locator = Arrays.isNullOrEmpty(args) || !(args[0] instanceof By) ? null : (By) args[0];
        afterFindElement(webDriver,
                         locator,
                         null);
        break;
      case "click":
        WebElement clickElement = Arrays.isNullOrEmpty(args) || !(args[0] instanceof WebElement) ? null : (WebElement) args[0];
        afterClick(clickElement);
        break;
      case "implicitlyWait":
        Timeouts timeouts = Arrays.isNullOrEmpty(args) || !(args[0] instanceof Timeouts) ? null : (Timeouts) args[0];
        Duration duration = Arrays.isNullOrEmpty(args) || args.length < 2 || !(args[1] instanceof Duration) ? null
                                                                                                            : (Duration) args[1];
        afterImplicitlyWait(timeouts, duration);
        break;
      case "sendKeys":
        WebElement sendKeysElement = Arrays.isNullOrEmpty(args) || !(args[0] instanceof WebElement) ? null : (WebElement) args[0];
        afterSendKeys(sendKeysElement, (CharSequence[]) null);
        break;
      default:
        ExceptionLauncher.LOGGER.debug("onError callled: - \n target = \n {} \n - method = \n {} \n - args = \n {}",
                                       target,
                                       methodName,
                                       args);
        break;
    }
  }
}
