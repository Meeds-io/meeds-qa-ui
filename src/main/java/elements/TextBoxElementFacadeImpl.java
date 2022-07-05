package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.pages.WebElementFacade;

public class TextBoxElementFacadeImpl extends BaseElementFacadeImpl implements TextBoxElementFacade {

  static final Logger LOGGER = LogManager.getLogger();

  public TextBoxElementFacadeImpl(WebDriver driver,
                                  ElementLocator locator,
                                  WebElement element,
                                  long timeoutInMilliseconds,
                                  long waitForTimeoutInMilliseconds) {
    super(driver, locator, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  @SuppressWarnings("unchecked")
  public static <T extends TextBoxElementFacade> T wrapWebElementFacadeInTextBoxElement(final WebDriver driver,
                                                                                        final WebElementFacade element,
                                                                                        final long implicitTimeoutInMilliseconds,
                                                                                        final long waitForTimeoutInMilliseconds) {
    return (T) new TextBoxElementFacadeImpl(driver,
                                            null,
                                            element,
                                            implicitTimeoutInMilliseconds,
                                            waitForTimeoutInMilliseconds);
  }

  public void setTextValue(String newValue, Keys keys) {
    try {
      waitUntilVisible();
    } catch (WebDriverException | IllegalArgumentException e) {
      exceptionLauncher.throwSerenityExeption(e,
                                              String.format(
                                                            "The element [%s] is not visible. "
                                                                + "The new value [%s] cannot be entered.",
                                                            this,
                                                            newValue));
    }
    clear();
    sendKeys(newValue);
    if (keys != null) {
      sendKeys(keys);
    }
    waitForPageLoaded();
  }

  public void setTextValue(String newValue) {
    setTextValue(newValue, null);
  }

  public String getTextBoxValue() {
    waitForPageLoaded();
    LOGGER.debug(String.format("Getting text of the element [%s]", this));
    String textValue = null;
    try {
      waitUntilVisible();
      textValue = getValue();
    } catch (Exception e) {
      exceptionLauncher.throwSerenityExeption(e,
                                              String.format("Text can't be extracted from The element [%s]", this));
    }
    return textValue;

  }
}
