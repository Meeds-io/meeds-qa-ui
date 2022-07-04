package pages;


import elements.*;
import net.jodah.failsafe.Failsafe;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.pages.PageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ExceptionLauncher;
import utils.RetryOnFailure;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class BasePageImpl extends PageObject implements BasePage {

    static final Logger LOGGER = LogManager.getLogger();
    public String url;
    protected WebDriver driver;
    ExceptionLauncher exceptionLauncher;

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
                            .as(String.format("Could not find the element [%s] !", field.getName())).isTrue();
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    exceptionLauncher.throwSerenityExeption(e,
                            String.format("Could not find the element [%s] !", field.getName()));
                }
            }
        }
    }

    /**********************************************************
     * Methods for finding element facade in the page
     *
     **********************************************************/

    private WebElementFacade getWebElementFacadeByXpath(String xpath) {
        return Failsafe.with(RetryOnFailure.getRetryPolicy(1, 3)).get(() -> findBy(xpath));
    }

    public <T extends BaseElementFacade> T findByXpath(String xpath) {
        if (!Selectors.isXPath(xpath)) {
            exceptionLauncher.throwSerenityExeption(new Exception(),
                    String.format("The format for the xpath [%s] is not correct.", xpath));
        }
        WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

        return BaseElementFacadeImpl.wrapWebElementFacade(getDriver(), nestedElement,
                getImplicitWaitTimeout().toMillis(), getWaitForTimeout().toMillis());
    }

    public <T extends TextBoxElementFacade> T findTextBoxElementByXpath(String xpath) {
        if (!Selectors.isXPath(xpath)) {
            exceptionLauncher.throwSerenityExeption(new Exception(),
                    String.format("The format for the xpath [%s] is not correct.", xpath));
        }
        WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

        return TextBoxElementFacadeImpl.wrapWebElementFacadeInTextBoxElement(getDriver(), nestedElement,
                getImplicitWaitTimeout().toMillis(), getWaitForTimeout().toMillis());
    }

    public <T extends ButtonElementFacade> T findButtonElementByXpath(String xpath) {
        if (!Selectors.isXPath(xpath)) {
            exceptionLauncher.throwSerenityExeption(new Exception(),
                    String.format("The format for the xpath [%s] is not correct.", xpath));
        }
        WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

        return ButtonElementFacadeImpl.wrapWebElementFacadeInButtonElement(getDriver(), nestedElement,
                getImplicitWaitTimeout().toMillis(), getWaitForTimeout().toMillis());
    }


    public <T extends TextElementFacade> T findTextElementByXpath(String xpath) {
        if (!Selectors.isXPath(xpath)) {
            exceptionLauncher.throwSerenityExeption(new Exception(),
                    String.format("The format for the xpath [%s] is not correct.", xpath));
        }
        WebElementFacade nestedElement = getWebElementFacadeByXpath(xpath);

        return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(getDriver(), nestedElement,
                getImplicitWaitTimeout().toMillis(), getWaitForTimeout().toMillis());
    }

}