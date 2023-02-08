package io.meeds.qa.ui.elements;

import static io.meeds.qa.ui.utils.Utils.DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.DEFAULT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static io.meeds.qa.ui.utils.Utils.waitRemainingTime;

import java.time.Duration;
import java.util.function.BooleanSupplier;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.utils.ExceptionLauncher;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;

public class ElementFacadeImpl extends WebElementFacadeImpl implements ElementFacade {

  public static final Logger LOGGER = LoggerFactory.getLogger(ElementFacadeImpl.class);

  /**
   * This method has the goal of creating a BaseElementFacade instance from a
   * WebElementFacade instance. Consequently, it would have the access to the
   * BaseElementFacade interface methods
   *
   * @param  driver                        {@link WebDriver}
   * @param  element                       {@link WebElementFacade}
   * @param  locator                       {@link ElementLocator}
   * @param  xPathOrCSSSelector            used xPath or CSS selector to find
   *                                         element
   * @param  implicitTimeoutInMilliseconds configured implicit timeout
   * @param  waitForTimeoutInMilliseconds  configured general timeout
   * @return                               a wrapped {@link ElementFacadeImpl}
   *                                       of the webElementFacade
   */
  public static ElementFacadeImpl wrapWebElementFacade(final WebDriver driver,
                                                       final WebElementFacade element,
                                                       final ElementLocator locator,
                                                       final String xPathOrCSSSelector,
                                                       final long implicitTimeoutInMilliseconds,
                                                       final long waitForTimeoutInMilliseconds) {
    return new ElementFacadeImpl(driver,
                                 locator,
                                 xPathOrCSSSelector,
                                 element,
                                 implicitTimeoutInMilliseconds,
                                 waitForTimeoutInMilliseconds);
  }

  private final WebDriver driver;

  protected WebElement    webElement;

  protected final String  xPathOrCSSSelector;

  public ElementFacadeImpl(WebDriver driver,
                           ElementLocator locator,
                           String xPathOrCSSSelector,
                           WebElement element,
                           long implicitTimeoutInMilliseconds,
                           long waitForTimeoutInMilliseconds) {
    super(driver, locator, element, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
    this.driver = driver;
    this.webElement = element;
    this.xPathOrCSSSelector = xPathOrCSSSelector;
  }

  public ElementFacadeImpl(WebDriver driver,
                           ElementLocator locator,
                           WebElement element,
                           long implicitTimeoutInMilliseconds,
                           long waitForTimeoutInMilliseconds) {
    this(driver, locator, null, element, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  @Override
  public void click() {
    int retries = 0;
    long start = System.currentTimeMillis();
    do {
      try {
        checkVisible();
        getResolvedWebElement(this).click();
        return;
      } catch (ElementClickInterceptedException e) {
        // Normal behavior since this can happen when the page is reloaded
        return;
      } catch (WebDriverException e) {
        if (StringUtils.contains(e.getMessage(), "unexpected command response")) {
          // Normal behavior since this can happen when the page is reloaded
          return;
        } else if (++retries > MAX_WAIT_RETRIES) {
          throw new ElementClickInterceptedException(String.format("The element [%s] cannot be clicked after %s retries and %s ms of waiting",
                                                                   this,
                                                                   (retries - 1),
                                                                   System.currentTimeMillis() - start),
                                                     e);
        }
      }
    } while (retries <= MAX_WAIT_RETRIES); // NOSONAR
  }

  @Override
  @SuppressWarnings("unchecked")
  public ElementFacadeImpl findByXPath(String xpath) {
    checkXpathFormat(xpath);
    WebElementFacade nestedElement = findSubElementFacadeByXPathOrCSS(xpath);
    return ElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                  nestedElement,
                                                  null,
                                                  xpath,
                                                  DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT,
                                                  DEFAULT_WAIT_FOR_TIMEOUT);
  }

  @Override
  public WebDriver getDriver() {
    return driver;
  }

  @Override
  public WebElement getElement() {
    if (this.webElement == null) {
      this.webElement = getWebElementFacadeByXPathOrCSS(xPathOrCSSSelector);
    }
    return this.webElement;
  }

  @Override
  public void hover() {
    Actions action = new Actions(getDriver());
    action.moveToElement(this).build().perform();
  }

  @Override
  public boolean isClickable() {
    return isElementClickable(SHORT_WAIT_DURATION_MILLIS);
  }

  @Override
  public boolean isCurrentlyEnabled() {
    return isElementCurrentlyEnabled();
  }

  @Override
  public boolean isCurrentlyVisible() {
    return isElementCurrentlyDisplayed();
  }

  @Override
  public boolean isDisabled() {
    return isElementDisabled(SHORT_WAIT_DURATION_MILLIS);
  }

  @Override
  public boolean isDisplayed() {
    return isVisible();
  }

  public boolean isElementNotVisible(long implicitWaitInMillis) {
    return hasElementProperty(implicitWaitInMillis, this::isElementCurrentlyNotDisplayed);
  }

  public boolean isElementVisible(long implicitWaitInMillis) {
    return hasElementProperty(implicitWaitInMillis, this::isElementCurrentlyDisplayed);
  }

  @Override
  public boolean isEnabled() {
    return isElementEnabled(SHORT_WAIT_DURATION_MILLIS);
  }

  public boolean isNotVisible() {
    return isElementNotVisible(SHORT_WAIT_DURATION_MILLIS);
  }

  @Override
  public boolean isPresent() {
    return isElementCurrentlyDisplayed();
  }

  @Override
  public boolean isVisible() {
    return isElementVisible(SHORT_WAIT_DURATION_MILLIS);
  }

  @Override
  public void scrollDown() {
    JavascriptExecutorFacade javascriptExecutorFacade = new JavascriptExecutorFacade(getDriver());
    javascriptExecutorFacade.executeScript("arguments[0].scrollBy(0, 200);", this);
  }

  @Override
  public void scrollToTheRight() {
    JavascriptExecutorFacade javascriptExecutorFacade = new JavascriptExecutorFacade(getDriver());
    javascriptExecutorFacade.executeScript("arguments[0].scrollBy(300, 0);", this);
  }

  @Override
  public void scrollToWebElement() {
    JavascriptExecutorFacade javascriptExecutorFacade = new JavascriptExecutorFacade(getDriver());
    javascriptExecutorFacade.executeScript("arguments[0].scrollIntoView();", this);
  }

  @Override
  public WebElementFacade waitUntilClickable() {
    checkClickable();
    return this;
  }

  @Override
  public WebElementFacade waitUntilNotVisible() {
    checkNotVisible();
    return this;
  }

  @Override
  public WebElementFacade waitUntilVisible() {
    checkVisible();
    return this;
  }

  /**********************************************************
   * Methods for finding element facade inside of this element
   **********************************************************/

  protected void checkXpathFormat(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format("The format for the xpath [%s] is not correct.", xpath));
    }
  }

  protected WebElementFacade findSubElementFacadeByXPathOrCSS(String xpathOrCss) {
    if (StringUtils.contains(xpathOrCss, "//")) {
      return find(By.xpath(xpathOrCss));
    } else {
      return find(By.cssSelector(xpathOrCss));
    }
  }

  protected WebElementFacade getWebElementFacadeByXPathOrCSS(String xpathOrCss) {
    if (StringUtils.contains(xpathOrCss, "//")) {
      return WebElementFacadeImpl.wrapWebElement(driver,
                                                 By.xpath(xpathOrCss),
                                                 DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT,
                                                 DEFAULT_WAIT_FOR_TIMEOUT,
                                                 xpathOrCss);
    } else {
      return WebElementFacadeImpl.wrapWebElement(driver,
                                                 By.cssSelector(xpathOrCss),
                                                 DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT,
                                                 DEFAULT_WAIT_FOR_TIMEOUT,
                                                 xpathOrCss);
    }
  }

  private boolean isElementClickable(long implicitWaitInMillis) {
    return hasElementProperty(implicitWaitInMillis, this::isElementCurrentlyClickable);
  }

  private boolean isElementCurrentlyClickable() {
    return isElementCurrentlyEnabled() && isElementCurrentlyDisplayed();
  }

  private boolean isElementCurrentlyDisabled() {
    Duration defaultTimeout = getImplicitTimeout();
    setImplicitTimeout(Duration.ofMillis(0));
    try {
      WebElement resolvedWebElement = getResolvedWebElement();
      return resolvedWebElement != null && !resolvedWebElement.isEnabled();
    } finally {
      setImplicitTimeout(defaultTimeout);
    }
  }

  private boolean isElementCurrentlyNotDisplayed() {
    return !isElementCurrentlyDisplayed();
  }

  private boolean isElementCurrentlyDisplayed() {
    Duration defaultTimeout = getImplicitTimeout();
    setImplicitTimeout(Duration.ofMillis(0));
    try {
      WebElement resolvedWebElement = getResolvedWebElement();
      return resolvedWebElement != null && resolvedWebElement.isDisplayed();
    } finally {
      setImplicitTimeout(defaultTimeout);
    }
  }

  private boolean isElementCurrentlyEnabled() {
    Duration defaultTimeout = getImplicitTimeout();
    setImplicitTimeout(Duration.ofMillis(0));
    try {
      WebElement resolvedWebElement = getResolvedWebElement();
      return resolvedWebElement != null && resolvedWebElement.isEnabled();
    } finally {
      setImplicitTimeout(defaultTimeout);
    }
  }

  private boolean isElementDisabled(long implicitWaitInMillis) {
    return hasElementProperty(implicitWaitInMillis, this::isElementCurrentlyDisabled);
  }

  private boolean isElementEnabled(long implicitWaitInMillis) {
    return hasElementProperty(implicitWaitInMillis, this::isElementCurrentlyEnabled);
  }

  private WebElement getResolvedWebElement() {
    try {
      return getResolvedWebElement(this);
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  private WebElement getResolvedWebElement(WebElement element) {
    if (element instanceof WebElementFacadeImpl) { // NOSONAR
      return getResolvedWebElement(((WebElementFacadeImpl) element).getElement());
    } else {
      return element;
    }
  }

  private boolean hasElementProperty(long implicitWaitInMillis, BooleanSupplier checkPropertyMethod) {
    int retry = 0;
    do {
      long start = System.currentTimeMillis();
      if (checkPropertyMethod.getAsBoolean()) {
        return true;
      } else {
        resetAndWaitForRemainingTime(implicitWaitInMillis, start);
      }
    } while (retry++ < MAX_WAIT_RETRIES);
    waitForAppLoading();
    return checkPropertyMethod.getAsBoolean();
  }

  private void resetAndWaitForRemainingTime(long implicitWaitInMillis, long start) {
    waitRemainingTime(implicitWaitInMillis, start);
    webElement = null;
  }

  private void waitForAppLoading() {
    try {
      waitForLoading();
    } catch (Exception e) {
      LOGGER.info("The page seems not to be completely loaded, thus the element {} could be not built yet.",
                  this);
    }
  }

}
