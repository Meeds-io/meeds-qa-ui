package io.meeds.qa.ui.elements;

import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoaded;

import java.time.Duration;

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

public class BaseElementFacadeImpl extends WebElementFacadeImpl implements BaseElementFacade {

  static final Logger     LOGGER = LoggerFactory.getLogger(BaseElementFacadeImpl.class);

  protected final String  xPathOrCSSSelector;

  protected WebElement    webElement;

  private final WebDriver driver;

  /**
   * This method has the goal of creating a BaseElementFacade instance from a
   * WebElementFacade instance. Consequently, it would have the access to the
   * BaseElementFacade interface methods
   *
   * @param driver {@link WebDriver}
   * @param element {@link WebElementFacade}
   * @param locator {@link ElementLocator}
   * @param xPathOrCSSSelector used xPath or CSS selector to find element
   * @param implicitTimeoutInMilliseconds configured implicit timeout
   * @param waitForTimeoutInMilliseconds configured general timeout
   * @return a wrapped {@link BaseElementFacadeImpl} of the webElementFacade
   */
  public static BaseElementFacadeImpl wrapWebElementFacade(final WebDriver driver,
                                                           final WebElementFacade element,
                                                           final ElementLocator locator,
                                                           final String xPathOrCSSSelector,
                                                           final long implicitTimeoutInMilliseconds,
                                                           final long waitForTimeoutInMilliseconds) {
    return new BaseElementFacadeImpl(driver,
                                     locator,
                                     xPathOrCSSSelector,
                                     element,
                                     implicitTimeoutInMilliseconds,
                                     waitForTimeoutInMilliseconds);
  }

  public BaseElementFacadeImpl(WebDriver driver,
                               ElementLocator locator,
                               String xPathOrCSSSelector,
                               WebElement element,
                               long implicitTimeoutInMilliseconds,
                               long waitForTimeoutInMilliseconds) {
    super(driver, locator, element, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
    this.driver = driver;
    this.xPathOrCSSSelector = xPathOrCSSSelector;
  }

  public BaseElementFacadeImpl(WebDriver driver,
                               ElementLocator locator,
                               WebElement element,
                               long implicitTimeoutInMilliseconds,
                               long waitForTimeoutInMilliseconds) {
    this(driver, locator, null, element, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
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

  @Override
  public void click() {
    clickOnElement();
  }

  /*********************************************************************************************************/

  @Override
  public void clickOnElement() {
    try {
      resetTimeouts();
      waitForPageLoaded();
      waitUntilVisible();
      super.click();
      resetTimeouts();
      waitForPageLoaded();
    } catch (WebDriverException e) {
      throw new ElementClickInterceptedException(String.format("[%s] The element [%s] cannot be clicked.",
                                                               getDriver().getWindowHandle(),
                                                               this),
                                                 e);
    }
  }

  protected long defaultWait() {
    EnvironmentVariables environmentVariables = Injectors.getInjector()
                                                         .getProvider(EnvironmentVariables.class)
                                                         .get();
    return ThucydidesSystemProperty.WEBDRIVER_WAIT_FOR_TIMEOUT.integerFrom(environmentVariables,
                                                                           (int) DefaultTimeouts.DEFAULT_WAIT_FOR_TIMEOUT.toMillis());
  }

  @Override
  public <T extends ButtonElementFacade> T findButtonElementByXpath(String xpath) {
    checkXpathFormat(xpath);
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

    return ButtonElementFacadeImpl.wrapWebElementFacadeInButtonElement(getDriver(),
                                                                       nestedElement,
                                                                       null,
                                                                       xpath,
                                                                       timeoutInMilliseconds(),
                                                                       defaultWait());
  }

  @Override
  @SuppressWarnings("unchecked")
  public BaseElementFacadeImpl findByXPath(String xpath) {
    checkXpathFormat(xpath);
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);
    return BaseElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                      nestedElement,
                                                      null,
                                                      xpath,
                                                      timeoutInMilliseconds(),
                                                      defaultWait());
  }

  @Override
  @SuppressWarnings("unchecked")
  public TextElementFacadeImpl findTextElementByXPath(String xPath) {
    checkXpathFormat(xPath);
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xPath);
    return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(getDriver(),
                                                                   nestedElement,
                                                                   null,
                                                                   xPath,
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
      return ((BaseElementFacadeImpl)element).getFoundBy();
    } else {
      return null;
    }
  }

  @Override
  public ElementLocator getLocator() {
    WebElement element = getElement();
    if (element instanceof WebElementFacadeImpl) {
      return ((BaseElementFacadeImpl)element).getLocator();
    } else {
      return null;
    }
  }

  protected WebElementFacade getWebElementFacadeByXpath(String xpath) {
    return findBy(String.format(".%s", xpath));
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
  public boolean isVisibleAfterWaiting() {
    boolean visible = false;
    long retry = 0;
    long maxRetries = getImplicitTimeoutInMilliseconds() / SHORT_WAIT_DURATION_MILLIS;
    do {
      visible = isDisplayed(SHORT_WAIT_DURATION_MILLIS);
    } while (!visible && ++retry < maxRetries);
    return visible;
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
  public String getXPathOrCSSSelector() {
    return xPathOrCSSSelector;
  }
}
