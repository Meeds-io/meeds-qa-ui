package io.meeds.qa.ui.elements;

import static io.meeds.qa.ui.utils.Utils.DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.DEFAULT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static io.meeds.qa.ui.utils.Utils.waitRemainingTime;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import net.thucydides.core.webdriver.exceptions.ElementShouldBeInvisibleException;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeVisibleException;
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
    clickOnElement();
  }

  /*********************************************************************************************************/

  @Override
  public void clickOnElement() {
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
          throw new ElementClickInterceptedException(String.format("The element [%s] cannot be clicked after %s retries and % ms of waiting",
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
  public String getFoundBy() {
    WebElement element = getElement();
    if (element instanceof WebElementFacadeImpl) {
      return ((ElementFacadeImpl) element).getFoundBy();
    } else {
      return null;
    }
  }

  @Override
  public ElementLocator getLocator() {
    WebElement element = getElement();
    if (element instanceof WebElementFacadeImpl) {
      return ((ElementFacadeImpl) element).getLocator();
    } else {
      return null;
    }
  }

  @Override
  public String getXPathOrCSSSelector() {
    return xPathOrCSSSelector;
  }

  @Override
  public void hover() {
    Actions action = new Actions(getDriver());
    action.moveToElement(this).build().perform();
  }

  @Override
  public void hover(String xpath) {
    Actions action = new Actions(getDriver());
    WebElement we = getDriver().findElement(By.xpath(xpath));
    action.moveToElement(we).build().perform();
  }

  @Override
  public boolean isClickable() {
    try {
      return super.isClickable();
    } catch (Throwable e) { // NOSONAR
      this.webElement = null;
      return false;
    }
  }

  @Override
  public boolean isCurrentlyVisible() {
    return isDisplayedNoWait();
  }

  @Override
  public boolean isClickableNoWait() {
    Duration defaultTimeout = getImplicitTimeout();
    setImplicitTimeout(Duration.ofMillis(0));
    try {
      return isClickable();
    } finally {
      setImplicitTimeout(defaultTimeout);
    }
  }

  @Override
  public boolean isDisplayed() {
    try {
      return super.isDisplayed();
    } catch (Throwable e) { // NOSONAR
      this.webElement = null;
      return false;
    }
  }

  @Override
  public boolean isDisabled() {
    return isElementDisabled(SHORT_WAIT_DURATION_MILLIS);
  }

  @Override
  public boolean isEnabled() {
    return isElementEnabled(SHORT_WAIT_DURATION_MILLIS);
  }

  @Override
  public boolean isClickable(long implicitWaitInMillis) {
    long start = System.currentTimeMillis();
    Duration defaultTimeout = getImplicitTimeout();
    setImplicitTimeout(Duration.ofMillis(implicitWaitInMillis));
    try {
      if (isClickable()) {
        return true;
      } else if (implicitWaitInMillis > 0) {
        waitRemainingTime(implicitWaitInMillis, start);
      }
      return false;
    } finally {
      setImplicitTimeout(defaultTimeout);
    }
  }

  @Override
  public boolean isDisplayed(long implicitWaitInMillis) {
    long start = System.currentTimeMillis();
    Duration defaultTimeout = getImplicitTimeout();
    setImplicitTimeout(Duration.ofMillis(implicitWaitInMillis));
    try {
      if (isDisplayed()) {
        return true;
      } else if (implicitWaitInMillis > 0) {
        waitRemainingTime(implicitWaitInMillis, start);
      }
      return false;
    } finally {
      setImplicitTimeout(defaultTimeout);
    }
  }

  @Override
  public boolean isNotDisplayed(long implicitWaitInMillis) {
    long start = System.currentTimeMillis();
    Duration defaultTimeout = getImplicitTimeout();
    setImplicitTimeout(Duration.ofMillis(implicitWaitInMillis));
    try {
      if (!isDisplayed()) {
        return true;
      } else if (implicitWaitInMillis > 0) {
        waitRemainingTime(implicitWaitInMillis, start);
      }
      return false;
    } finally {
      setImplicitTimeout(defaultTimeout);
    }
  }

  @Override
  public boolean isNotVisible(long maxRetries) {
    int retry = 0;
    do {
      if (isNotDisplayed(SHORT_WAIT_DURATION_MILLIS)) {
        return true;
      } else {
        webElement = null;
      }
    } while (retry++ < maxRetries);
    // Element not displayed yet after X retries
    try {
      waitForLoading();
    } catch (Exception e) {
      LOGGER.info("The page seems not to be completely loaded, thus the element {} could be not built yet. Attempt to use !isDisplayedNoWait",
                  this);
    }
    return !isDisplayedNoWait();
  }

  @Override
  public boolean isVisible(long maxRetries) {
    int retry = 0;
    do {
      if (isDisplayed(SHORT_WAIT_DURATION_MILLIS)) {
        return true;
      } else {
        webElement = null;
      }
    } while (retry++ < maxRetries);
    // Element not displayed yet after X retries
    try {
      waitForLoading();
    } catch (Exception e) {
      LOGGER.info("The page seems not to be completely loaded, thus the element {} could be not built yet. Attempt to use isDisplayedNoWait",
                  this);
    }
    return isDisplayedNoWait();
  }

  @Override
  public boolean isDisplayedNoWait() {
    return isDisplayed(0);
  }

  @Override
  public boolean isNotVisibleAfterWaiting() {
    long maxRetries = getImplicitTimeoutInMilliseconds() / SHORT_WAIT_DURATION_MILLIS;
    return isNotVisible(maxRetries);
  }

  @Override
  public boolean isPresent() {
    return isDisplayedNoWait();
  }

  @Override
  public boolean isVisible() {
    return isDisplayed(SHORT_WAIT_DURATION_MILLIS);
  }

  @Override
  public void checkClickable() {
    long start = System.currentTimeMillis();
    if (!isClickable(SHORT_WAIT_DURATION_MILLIS)) {
      throw new ElementClickInterceptedException(String.format("Unable to locate a clickable element %s after %s ms",
                                                               this,
                                                               System.currentTimeMillis() - start));
    }
  }

  @Override
  public void checkVisible() {
    long start = System.currentTimeMillis();
    if (!isVisible(MAX_WAIT_RETRIES)) {
      throw new ElementShouldBeVisibleException(String.format("Unable to locate a visible element %s after %s ms",
                                                              this,
                                                              System.currentTimeMillis() - start),
                                                null);
    }
  }

  @Override
  public void checkNotVisible() {
    long start = System.currentTimeMillis();
    if (!isNotVisible(MAX_WAIT_RETRIES)) {
      throw new ElementShouldBeInvisibleException(String.format("Element is still visible %s after %s ms",
                                                                this,
                                                                System.currentTimeMillis() - start),
                                                  null);
    }
  }

  @Override
  public void assertNotVisible() {
    long start = System.currentTimeMillis();
    boolean notVisible = isNotVisible(MAX_WAIT_RETRIES);
    assertTrue(String.format("Element %s was visible after waiting %s ms",
                             this,
                             System.currentTimeMillis() - start),
               notVisible);
  }

  @Override
  public void assertVisible() {
    long start = System.currentTimeMillis();
    boolean visible = isVisible(MAX_WAIT_RETRIES);
    assertTrue(String.format("Element %s wasn't visible after waiting %s ms",
                             this,
                             System.currentTimeMillis() - start),
               visible);
  }

  @Override
  public void assertDisabled() {
    long start = System.currentTimeMillis();
    boolean disabled = isDisabled();
    assertTrue(String.format("Element %s wasn't disabled after waiting %s ms",
                             this,
                             System.currentTimeMillis() - start),
               disabled);
  }

  @Override
  public void assertEnabled() {
    long start = System.currentTimeMillis();
    boolean enabled = isEnabled();
    assertTrue(String.format("Element %s wasn't enabled after waiting %s ms",
                             this,
                             System.currentTimeMillis() - start),
               enabled);
  }

  @Override
  public boolean isVisibleAfterWaiting() {
    long maxRetries = getImplicitTimeoutInMilliseconds() / SHORT_WAIT_DURATION_MILLIS;
    return isVisible(maxRetries);
  }

  @Override
  public WebElementFacade waitUntilVisible() {
    checkVisible();
    return this;
  }

  @Override
  public WebElementFacade waitUntilNotVisible() {
    checkNotVisible();
    return this;
  }

  @Override
  public WebElementFacade waitUntilClickable() {
    checkClickable();
    return this;
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

  public WebElement getResolvedWebElement(WebElement element) {
    if (element instanceof WebElementFacadeImpl) { // NOSONAR
      return getResolvedWebElement(((WebElementFacadeImpl) element).getElement());
    } else {
      return element;
    }
  }

  public boolean isElementDisabled(long implicitWaitInMillis) {
    int retry = 0;
    do {
      long start = System.currentTimeMillis();
      if (isElementCurrentlyDisabled()) {
        return true;
      } else {
        webElement = null;
        waitRemainingTime(implicitWaitInMillis, start);
      }
    } while (retry++ < MAX_WAIT_RETRIES);
    // Element not Disabled yet after X retries
    try {
      waitForLoading();
    } catch (Exception e) {
      LOGGER.info("The page seems not to be completely loaded, thus the element {} could be not built yet. Attempt to use isDisabled",
                  this);
    }
    return isElementCurrentlyDisabled();
  }

  public boolean isElementEnabled(long implicitWaitInMillis) {
    int retry = 0;
    do {
      long start = System.currentTimeMillis();
      if (isElementCurrentlyEnabled()) {
        return true;
      } else {
        webElement = null;
        waitRemainingTime(implicitWaitInMillis, start);
      }
    } while (retry++ < MAX_WAIT_RETRIES);
    // Element not Disabled yet after X retries
    try {
      waitForLoading();
    } catch (Exception e) {
      LOGGER.info("The page seems not to be completely loaded, thus the element {} could be not built yet. Attempt to use isDisabled",
                  this);
    }
    return isElementCurrentlyEnabled();
  }

  private boolean isElementCurrentlyDisabled() {
    try {
      return !getResolvedWebElement(this).isEnabled();
    } catch (Throwable e) { // NOSONAR
      this.webElement = null;
      return false;
    }
  }

  private boolean isElementCurrentlyEnabled() {
    try {
      return getResolvedWebElement(this).isEnabled();
    } catch (Throwable e) { // NOSONAR
      this.webElement = null;
      return false;
    }
  }

}
