package io.meeds.qa.ui.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.BaseElementFacadeImpl;
import io.meeds.qa.ui.elements.ButtonElementFacade;
import io.meeds.qa.ui.elements.ButtonElementFacadeImpl;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacadeImpl;
import io.meeds.qa.ui.elements.TextElementFacade;
import io.meeds.qa.ui.elements.TextElementFacadeImpl;
import io.meeds.qa.ui.utils.ExceptionLauncher;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.pages.PageObject;

public class BasePageImpl extends PageObject implements BasePage {

  static final Logger LOGGER = LoggerFactory.getLogger(BasePageImpl.class);

  public String       url;

  protected WebDriver driver;

  ExceptionLauncher   exceptionLauncher;

  public BasePageImpl() {
  }

  public BasePageImpl(WebDriver driver) {
    super(driver);
    this.driver = driver;
    exceptionLauncher = new ExceptionLauncher();
  }

  public void verifyPageLoaded() {
    Field[] fields = getClass().getDeclaredFields();
    for (Field field : fields) {
      Class<?> fieldClass = field.getType();
      if (BaseElementFacade.class.isAssignableFrom(fieldClass)) {
        field.setAccessible(true);
        BaseElementFacade fieldInstance = null;
        try {
          fieldInstance = (BaseElementFacade) field.get(this);
          assertThat(fieldInstance.isPresent())
                                               .as(String.format("Could not find the element [%s] !", field.getName()))
                                               .isTrue();
        } catch (IllegalArgumentException | IllegalAccessException e) {
          exceptionLauncher.throwSerenityExeption(e,
                                                  String.format("Could not find the element [%s] !", field.getName()));
        }
      }
    }
  }

  /**********************************************************
   * Methods for finding element facade in the page
   **********************************************************/

  private WebElementFacade getWebElementFacadeByXpath(String xpath) {
    waitForPageLoaded();
    return findBy(xpath);
  }

  public <T extends BaseElementFacade> T findByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      exceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format("The format for the xpath [%s] is not correct.", xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

    return BaseElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                      nestedElement,
                                                      getImplicitWaitTimeout().toMillis(),
                                                      getWaitForTimeout().toMillis());
  }

  public <T extends TextBoxElementFacade> T findTextBoxElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      exceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format("The format for the xpath [%s] is not correct.", xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

    return TextBoxElementFacadeImpl.wrapWebElementFacadeInTextBoxElement(getDriver(),
                                                                         nestedElement,
                                                                         getImplicitWaitTimeout().toMillis(),
                                                                         getWaitForTimeout().toMillis());
  }

  public void waitForPageLoaded() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState === 'complete' && (!document.getElementById('TopbarLoadingContainer') || document.getElementById('TopbarLoadingContainer').className.indexOf('hidden') > 0)")
                                                              .toString()
                                                              .equals("true"));
    } catch (Exception error) {
      exceptionLauncher.throwSerenityExeption(error, "Timeout waiting for Page Load Request to complete.");
    }
  }

  public <T extends ButtonElementFacade> T findButtonElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      exceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format("The format for the xpath [%s] is not correct.", xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

    return ButtonElementFacadeImpl.wrapWebElementFacadeInButtonElement(getDriver(),
                                                                       nestedElement,
                                                                       getImplicitWaitTimeout().toMillis(),
                                                                       getWaitForTimeout().toMillis());
  }

  public <T extends TextElementFacade> T findTextElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      exceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format("The format for the xpath [%s] is not correct.", xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

    return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(getDriver(),
                                                                   nestedElement,
                                                                   getImplicitWaitTimeout().toMillis(),
                                                                   getWaitForTimeout().toMillis());
  }

}
