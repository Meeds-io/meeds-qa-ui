package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.waitForPageLoaded;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
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
    this(null);
  }

  public BasePageImpl(WebDriver driver) {
    super(driver);
    this.driver = getDriver();
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

  private WebElementFacade getWebElementFacadeByXpathOrCSS(String xpath) {
    waitForPageLoaded(getDriver());
    return findBy(xpath);
  }

  public <T extends BaseElementFacade> T findByXpathOrCSS(String xpathOrCSSSelector) {
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpathOrCSSSelector);

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
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return TextBoxElementFacadeImpl.wrapWebElementFacadeInTextBoxElement(getDriver(),
                                                                         nestedElement,
                                                                         getImplicitWaitTimeout().toMillis(),
                                                                         getWaitForTimeout().toMillis());
  }

  public <T extends ButtonElementFacade> T findButtonElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      exceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format("The format for the xpath [%s] is not correct.", xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

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
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(getDriver(),
                                                                   nestedElement,
                                                                   getImplicitWaitTimeout().toMillis(),
                                                                   getWaitForTimeout().toMillis());
  }

}
