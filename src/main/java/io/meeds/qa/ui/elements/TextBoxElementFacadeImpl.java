package io.meeds.qa.ui.elements;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoaded;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.utils.ExceptionLauncher;
import net.serenitybdd.core.pages.WebElementFacade;

public class TextBoxElementFacadeImpl extends BaseElementFacadeImpl implements TextBoxElementFacade {

  static final Logger LOGGER = LoggerFactory.getLogger(TextBoxElementFacadeImpl.class);

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

  public TextBoxElementFacadeImpl(WebDriver driver,
                                  ElementLocator locator,
                                  WebElement element,
                                  long timeoutInMilliseconds,
                                  long waitForTimeoutInMilliseconds) {
    super(driver, locator, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  @Override
  public String getTextBoxValue() {
    waitForPageLoaded();
    String textValue = null;
    try {
      waitUntilVisible();
      textValue = getValue();
    } catch (Exception e) {
      ExceptionLauncher.throwSerenityExeption(e,
                                              String.format("Text can't be extracted from The element [%s]", this));
    }
    return textValue;

  }

  @Override
  public void sendKeys(CharSequence... value) {
    sendValueWithKeys(false, null, value);
  }

  public void sendValueWithKeys(boolean clear, Keys keys, CharSequence... value) {
    retryOnCondition(() -> sendValueWithKeysOnElement(clear, keys, value));
  }

  public void sendValueWithKeysOnElement(boolean clear, Keys keys, CharSequence... value) {
    if (clear) {
      clear();
      String currentValue = getValue();
      if (StringUtils.isNotBlank(currentValue)) {
        List<Keys> backSpace = Collections.nCopies(currentValue.length(), Keys.BACK_SPACE);
        super.sendKeys(backSpace.toArray(new Keys[0]));
      }
    }
    super.sendKeys(value);
    if (keys != null) {
      super.sendKeys(keys);
    }
  }

  @Override
  public void setTextValue(String value) {
    setTextValue(value, null);
  }

  @Override
  public void setTextValue(String value, Keys keys) {
    try {
      sendValueWithKeys(true, keys, value);
    } catch (WebDriverException | IllegalArgumentException e) {
      ExceptionLauncher.throwSerenityExeption(e,
                                              String.format(
                                                            "The element [%s] is not visible. "
                                                                + "The new value [%s] cannot be entered.",
                                                            this,
                                                            value));
    }
  }
}
