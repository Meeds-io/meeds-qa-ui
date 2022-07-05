package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.jodah.failsafe.Failsafe;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.DefaultTimeouts;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import utils.ExceptionLauncher;
import utils.RetryOnFailure;

public class BaseElementFacadeImpl extends WebElementFacadeImpl implements BaseElementFacade {

  static final Logger  LOGGER = LogManager.getLogger();

  ExceptionLauncher    exceptionLauncher;

  protected WebDriver  driver;

  protected WebElement webElement;

  public BaseElementFacadeImpl(WebDriver driver,
                               ElementLocator locator,
                               WebElement element,
                               long implicitTimeoutInMilliseconds,
                               long waitForTimeoutInMilliseconds) {
    super(driver, locator, element, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
    this.driver = driver;
    exceptionLauncher = new ExceptionLauncher();
  }

  /**
   * This method has the goal of creating a BaseElementFacade instance from a
   * WebElementFacade instance. Consequently, it would have the access to the
   * BaseElementFacade interface methods
   * 
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
      exceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format("The format for the xpath [%s] is not correct.", xpath));
    }
  }

  protected WebElementFacade getWebElementFacadeByXpath(String xpath) {
    return Failsafe.with(RetryOnFailure.getRetryPolicy(1, 3)).get(() -> findBy(String.format(".%s", xpath)));
  }

  protected long defaultWait() {
    EnvironmentVariables environmentVariables = Injectors.getInjector()
                                                         .getProvider(EnvironmentVariables.class)
                                                         .get();
    return ThucydidesSystemProperty.WEBDRIVER_WAIT_FOR_TIMEOUT.integerFrom(environmentVariables,
                                                                           (int) DefaultTimeouts.DEFAULT_WAIT_FOR_TIMEOUT.toMillis());
  }

  public <T extends BaseElementFacade> T findByXpath(String xpath) {
    checkXpathFormat(xpath);
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);
    return BaseElementFacadeImpl.wrapWebElementFacade(driver,
                                                      nestedElement,
                                                      timeoutInMilliseconds(),
                                                      defaultWait());
  }

  public <T extends TextElementFacade> T findTextElementByXpath(String xpath) {
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

  public void waitForPageLoaded() {
    ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                                            .toString()
                                            .equals("complete");
      }
    };
    try {
      Thread.sleep(1000);
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(expectation);
    } catch (Exception error) {
      exceptionLauncher.throwSerenityExeption(error, "Timeout waiting for Page Load Request to complete.");
    }
  }

  public void clickOnElement() {
    LOGGER.debug(String.format("clicking on the element [%s]", this));
    try {
      waitForPageLoaded();
      waitUntilClickable();
      click();
      waitForPageLoaded();
    } catch (WebDriverException e) {
      exceptionLauncher.throwSerenityExeption(e, String.format("The element [%s] cannot be clicked.", this));
    }
  }

  public boolean isVisibleAfterWaiting() {
    LOGGER.debug(String.format("Checking if the element [%s] is visible ", this));
    try {
      waitUntilVisible();
    } catch (Exception e) {
      return false;
    }
    LOGGER.debug(String.format("The element [%s] is visible ", this));
    return true;
  }

  public boolean isNotVisibleAfterWaiting() {
    LOGGER.debug(String.format("Checking if the element [%s] is not visible ", this));
    try {
      waitUntilNotVisible();
    } catch (Exception e) {
      return false;
    }
    LOGGER.debug(String.format("The element [%s] is not visible ", this));
    return true;
  }

  public boolean isDisabledAfterWaiting() {

    LOGGER.debug(String.format("Checking if the element [%s] is disabled ", this));
    try {
      waitUntilDisabled();
    } catch (Exception e) {
      return false;
    }
    LOGGER.debug(String.format("The element [%s] isdisabled ", this));
    return true;

  }

  public boolean isEnabledAfterWaiting() {
    LOGGER.debug(String.format("Checking if the element [%s] is enabled ", this));
    try {
      waitUntilEnabled();
    } catch (Exception e) {
      return false;
    }
    LOGGER.debug(String.format("The element [%s] is enabled ", this));
    return true;
  }

  public boolean isDisplayed() {
    try {
      return super.isDisplayed();
    } catch (Exception e) {
      return false;
    }
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
}
