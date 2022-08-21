package io.meeds.qa.ui.elements;

import static io.meeds.qa.ui.utils.Utils.decorateDriver;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoaded;

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
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.pages.DefaultTimeouts;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;

public class BaseElementFacadeImpl extends WebElementFacadeImpl implements BaseElementFacade {

  static final Logger  LOGGER = LoggerFactory.getLogger(BaseElementFacadeImpl.class);

  protected WebDriver  driver;

  protected WebElement webElement;

  public BaseElementFacadeImpl(WebDriver driver,
                               ElementLocator locator,
                               WebElement element,
                               long implicitTimeoutInMilliseconds,
                               long waitForTimeoutInMilliseconds) {
    super(decorateDriver(driver), locator, element, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
    this.driver = decorateDriver(driver);
  }

  /**
   * This method has the goal of creating a BaseElementFacade instance from a
   * WebElementFacade instance. Consequently, it would have the access to the
   * BaseElementFacade interface methods
   * 
   * @param driver {@link WebDriver}
   * @param element {@link WebElementFacade}
   * @param implicitTimeoutInMilliseconds configured implicit timeout
   * @param waitForTimeoutInMilliseconds configured general timeout
   * @param <T> type of return which extends {@link BaseElementFacade}
   * @return a wrapped BaseElementFacade of the webElementFacade
   */
  @SuppressWarnings("unchecked")
  public static <T extends BaseElementFacade> T wrapWebElementFacade(final WebDriver driver,
                                                                     final WebElementFacade element,
                                                                     final long implicitTimeoutInMilliseconds,
                                                                     final long waitForTimeoutInMilliseconds) {
    return (T) new BaseElementFacadeImpl(driver,
                                         null,
                                         element,
                                         implicitTimeoutInMilliseconds,
                                         waitForTimeoutInMilliseconds);
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

  protected WebElementFacade getWebElementFacadeByXpath(String xpath) {
    return findBy(String.format(".%s", xpath));
  }

  protected long defaultWait() {
    EnvironmentVariables environmentVariables = Injectors.getInjector()
                                                         .getProvider(EnvironmentVariables.class)
                                                         .get();
    return ThucydidesSystemProperty.WEBDRIVER_WAIT_FOR_TIMEOUT.integerFrom(environmentVariables,
                                                                           (int) DefaultTimeouts.DEFAULT_WAIT_FOR_TIMEOUT.toMillis());
  }

  public <T extends BaseElementFacade> T findByXPath(String xpath) {
    checkXpathFormat(xpath);
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);
    return BaseElementFacadeImpl.wrapWebElementFacade(driver,
                                                      nestedElement,
                                                      timeoutInMilliseconds(),
                                                      defaultWait());
  }

  public <T extends TextElementFacade> T findTextElementByXPath(String xpath) {
    checkXpathFormat(xpath);
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);
    return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(driver,
                                                                   nestedElement,
                                                                   timeoutInMilliseconds(),
                                                                   defaultWait());
  }

  public <T extends ButtonElementFacade> T findButtonElementByXpath(String xpath) {
    checkXpathFormat(xpath);
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

    return ButtonElementFacadeImpl.wrapWebElementFacadeInButtonElement(driver,
                                                                       nestedElement,
                                                                       timeoutInMilliseconds(),
                                                                       defaultWait());
  }

  /*********************************************************************************************************/

  public void clickOnElement() {
    LOGGER.debug("clicking on the element [{}]", this);
    try {
      resetTimeouts();
      waitForPageLoaded();
      clickOnCurrentElement();
      resetTimeouts();
      waitForPageLoaded();
    } catch (WebDriverException e) {
      throw new ElementClickInterceptedException(String.format("[%s] The element [%s] cannot be clicked.",
                                                               driver.getWindowHandle(),
                                                               this),
                                                 e);
    }
  }

  @Override
  public void click() {
    clickOnCurrentElement();
  }

  public void clickOnCurrentElement() {
    retryOnCondition(this::clickOnCurrentElementWindowSwitch);
  }

  @SwitchToWindow
  public void clickOnCurrentElementWindowSwitch() {
    waitUntilVisible();
    super.click();
  }

  @Override
  @SwitchToWindow
  public WebElement getElement() {
    return retryOnCondition(() -> {
      try {
        return super.getElement();
      } catch (Throwable e) {
        LOGGER.debug("Can't find element {}. Procees after switching window.", this, e);
        return getCurrentElement();
      }
    });
  }

  @SwitchToWindow
  public WebElement getCurrentElement() {
    return super.getElement();
  }

  @SwitchToWindow
  public boolean isVisibleAfterWaiting() {
    LOGGER.debug("Checking if the element [{}] is visible ", this);
    try {
      waitUntilVisible();
    } catch (Throwable e) {
      return false;
    }
    LOGGER.debug("The element [{}] is visible ", this);
    return true;
  }

  @SwitchToWindow
  public boolean isNotVisibleAfterWaiting() {
    LOGGER.debug("Checking if the element [{}] is not visible ", this);
    try {
      waitUntilNotVisible();
    } catch (Throwable e) {
      return false;
    }
    LOGGER.debug("The element [{}] is not visible ", this);
    return true;
  }

  @SwitchToWindow
  public boolean isDisabledAfterWaiting() {

    LOGGER.debug("Checking if the element [{}] is disabled ", this);
    try {
      waitUntilDisabled();
    } catch (Throwable e) {
      return false;
    }
    LOGGER.debug("The element [{}] isdisabled ", this);
    return true;

  }

  public boolean isEnabledAfterWaiting() {
    LOGGER.debug("Checking if the element [{}] is enabled ", this);
    try {
      waitUntilEnabled();
    } catch (Throwable e) {
      return false;
    }
    LOGGER.debug("The element [{}] is enabled ", this);
    return true;
  }

  @Override
  @SwitchToWindow
  public boolean isDisplayed() {
    try {
      return super.isDisplayed();
    } catch (Throwable e) {
      return false;
    }
  }

  @Override
  @SwitchToWindow
  public boolean isVisible() {
    try {
      return super.isVisible();
    } catch (Throwable e) {
      return false;
    }
  }

  @Override
  @SwitchToWindow
  public boolean isClickable() {
    try {
      return super.isClickable();
    } catch (Throwable e) {
      return false;
    }
  }

  @Override
  @SwitchToWindow
  public boolean isPresent() {
    try {
      WebElement element = getElement();
      return element != null && element.isDisplayed();
    } catch (Exception | ElementNotFoundAfterTimeoutError e) {
      return false;
    }
  }

  @Override
  @SwitchToWindow
  public boolean isSelected() {
    return super.isSelected();
  }

  @Override
  @SwitchToWindow
  public boolean isCurrentlyEnabled() {
    try {
      return super.isCurrentlyEnabled();
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  @SwitchToWindow
  public boolean isCurrentlyVisible() {
    try {
      return super.isCurrentlyVisible();
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  @SwitchToWindow
  public WebElementFacade waitUntilClickable() {
    return super.waitUntilClickable();
  }

  @Override
  @SwitchToWindow
  public WebElementFacade waitUntilNotVisible() {
    return super.waitUntilNotVisible();
  }

  @Override
  @SwitchToWindow
  public WebElementFacade waitUntilVisible() {
    return super.waitUntilVisible();
  }

  @Override
  @SwitchToWindow
  public WebElementFacade waitUntilPresent() {
    return super.waitUntilPresent();
  }

  public void scrollToTheRight() {
    JavascriptExecutorFacade javascriptExecutorFacade = new JavascriptExecutorFacade(driver);
    javascriptExecutorFacade.executeScript("arguments[0].scrollBy(300, 0);", this);

  }

  public void scrollDown() {

    JavascriptExecutorFacade javascriptExecutorFacade = new JavascriptExecutorFacade(driver);
    javascriptExecutorFacade.executeScript("arguments[0].scrollBy(0, 200);", this);

  }

  public void scrollToWebElement() {
    JavascriptExecutorFacade javascriptExecutorFacade = new JavascriptExecutorFacade(driver);
    javascriptExecutorFacade.executeScript("arguments[0].scrollIntoView();", this);

  }

  public void hover(String xpath) {
    Actions action = new Actions(driver);
    WebElement we = driver.findElement(By.xpath(xpath));
    action.moveToElement(we).build().perform();
  }

  public void hover() {
    Actions action = new Actions(driver);
    action.moveToElement(this).build().perform();
  }

  @Override
  public WebDriver getDriver() {
    return driver;
  }

  @Override
  public String getFoundBy() {
    WebElement element = getElement();
    if (element instanceof WebElementFacadeImpl) {
      return ((WebElementFacadeImpl) element).getFoundBy();
    } else {
      return null;
    }
  }

  @Override
  public ElementLocator getLocator() {
    WebElement element = getElement();
    if (element instanceof WebElementFacadeImpl) {
      return ((WebElementFacadeImpl) element).getLocator();
    } else {
      return null;
    }
  }

  @Override
  @SwitchToWindow
  public String getText() {
    return super.getText();
  }

  @Override
  @SwitchToWindow
  public String getValue() {
    return super.getValue();
  }
}
