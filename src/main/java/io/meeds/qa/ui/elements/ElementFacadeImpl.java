package io.meeds.qa.ui.elements;

import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoaded;
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
import net.serenitybdd.core.pages.DefaultTimeouts;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;

public class ElementFacadeImpl extends WebElementFacadeImpl implements ElementFacade {

  static final Logger LOGGER = LoggerFactory.getLogger(ElementFacadeImpl.class);

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
    try {
      assertVisible();
      super.click();
      waitForPageLoaded();
    } catch (WebDriverException e) {
      throw new ElementClickInterceptedException(String.format("[%s] The element [%s] cannot be clicked.",
                                                               getDriver().getWindowHandle(),
                                                               this),
                                                 e);
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public ElementFacadeImpl findByXPath(String xpath) {
    checkXpathFormat(xpath);
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);
    return ElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                  nestedElement,
                                                  null,
                                                  xpath,
                                                  timeoutInMilliseconds(),
                                                  defaultWait());
  }

  public WebElement getCurrentElement() {
    return super.getElement();
  }

  @Override
  public WebDriver getDriver() {
    return driver;
  }

  @Override
  public WebElement getElement() {
    return retryOnCondition(() -> {
      try {
        return super.getElement();
      } catch (Throwable e) { // NOSONAR
        return getCurrentElement();
      }
    });
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
  public boolean isDisabledAfterWaiting() {
    try {
      waitUntilDisabled();
    } catch (Throwable e) { // NOSONAR
      return false;
    }
    return true;

  }

  @Override
  public boolean isDisplayed() {
    try {
      return super.isDisplayed();
    } catch (Throwable e) { // NOSONAR
      return false;
    }
  }

  @Override
  public boolean isDisplayed(long implicitWaitInMillis) {
    Duration defaultTimeout = getImplicitTimeout();
    setImplicitTimeout(Duration.ofMillis(implicitWaitInMillis));
    try {
      return isDisplayed();
    } finally {
      setImplicitTimeout(defaultTimeout);
    }
  }

  @Override
  public boolean isDisplayedNoWait() {
    return isDisplayed(0);
  }

  @Override
  public boolean isEnabledAfterWaiting() {
    try {
      waitUntilEnabled();
    } catch (Throwable e) { // NOSONAR
      return false;
    }
    return true;
  }

  @Override
  public boolean isNotVisibleAfterWaiting() {
    boolean notVisible = false;
    long retry = 0;
    long maxRetries = getImplicitTimeoutInMilliseconds() / SHORT_WAIT_DURATION_MILLIS;
    do {
      notVisible = !isDisplayed(SHORT_WAIT_DURATION_MILLIS);
    } while (!notVisible && ++retry < maxRetries);
    return notVisible;
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
  public void assertVisible() {
    assertTrue(String.format("Unable to locate a visible element %s", this), isVisible(MAX_WAIT_RETRIES));
  }

  @Override
  public void assertNotVisible() {
    assertTrue(String.format("Element %s is still visible after waiting", this), isNotVisible(MAX_WAIT_RETRIES));
  }

  @Override
  public boolean isVisibleAfterWaiting() {
    Boolean visible = false;
    long retry = 0;
    long maxRetries = getImplicitTimeoutInMilliseconds() / SHORT_WAIT_DURATION_MILLIS;
    do {
      visible = isDisplayed(SHORT_WAIT_DURATION_MILLIS);
    } while (visible != null && !visible.booleanValue() && ++retry < maxRetries);
    return visible != null && visible.booleanValue();
  }

  @Override
  public boolean isNotVisible(long maxRetries) {
    waitForPageLoaded();
    setImplicitTimeout(SHORT_WAIT_DURATION);
    boolean notVisible = false;
    int retry = 0;
    do {
      notVisible = !isDisplayed(SHORT_WAIT_DURATION_MILLIS);
    } while (!notVisible && retry++ < maxRetries);
    return notVisible || isNotVisibleAfterWaiting();
  }

  @Override
  public boolean isVisible(long maxRetries) {
    waitForPageLoaded();
    boolean visible = false;
    int retry = 0;
    ElementFacade element = this;
    do {
      element.setImplicitTimeout(SHORT_WAIT_DURATION);
      visible = element.isDisplayed(SHORT_WAIT_DURATION_MILLIS);
      if (visible) {
        return true;
      } else {
        element = findAgain();
      }
    } while (retry++ < maxRetries);
    return isVisibleAfterWaiting();
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

  protected long defaultWait() {
    EnvironmentVariables environmentVariables = Injectors.getInjector()
                                                         .getProvider(EnvironmentVariables.class)
                                                         .get();
    return ThucydidesSystemProperty.WEBDRIVER_WAIT_FOR_TIMEOUT.integerFrom(environmentVariables,
                                                                           (int) DefaultTimeouts.DEFAULT_WAIT_FOR_TIMEOUT.toMillis());
  }

  protected WebElementFacade getWebElementFacadeByXpath(String xpath) {
    return findBy(String.format(".%s", xpath));
  }

  protected ElementFacade findAgain() {
    WebElementFacade nestedElement;
    if (StringUtils.isNotBlank(xPathOrCSSSelector)) {
      if (StringUtils.contains(xPathOrCSSSelector, "//")) {
        nestedElement = findBy(By.xpath(xPathOrCSSSelector));
      } else {
        nestedElement = findBy(By.cssSelector(xPathOrCSSSelector));
      }
    } else if (getFoundBy() != null) {
      nestedElement = findBy(getFoundBy());
    } else {
      return this;
    }

    return ElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                  nestedElement,
                                                  null,
                                                  xPathOrCSSSelector,
                                                  getImplicitTimeoutInMilliseconds(),
                                                  getImplicitTimeoutInMilliseconds());
  }

}
