package io.meeds.qa.ui.elements;

import static io.meeds.qa.ui.utils.Utils.decorateDriver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.utils.ExceptionLauncher;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.pages.WebElementFacade;

public class TextElementFacadeImpl extends BaseElementFacadeImpl implements TextElementFacade {

  static final Logger LOGGER = LoggerFactory.getLogger(TextElementFacadeImpl.class);

  public TextElementFacadeImpl(WebDriver driver,
                               ElementLocator locator,
                               WebElement element,
                               long timeoutInMilliseconds,
                               long waitForTimeoutInMilliseconds) {
    super(decorateDriver(driver), locator, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  @SuppressWarnings("unchecked")
  public static <T extends TextElementFacade> T wrapWebElementFacadeInTextElement(final WebDriver driver,
                                                                                  final WebElementFacade element,
                                                                                  final long implicitTimeoutInMilliseconds,
                                                                                  final long waitForTimeoutInMilliseconds) {
    return (T) new TextElementFacadeImpl(driver,
                                         null,
                                         element,
                                         implicitTimeoutInMilliseconds,
                                         waitForTimeoutInMilliseconds);
  }

  public String getContent() {
    String textValue = null;
    try {
      waitUntilVisible();
      textValue = getText();
    } catch (Exception e) {
      ExceptionLauncher.throwSerenityExeption(e,
                                              String.format("Text can't be extracted from The element [%s]", this));
    }
    return textValue;

  }

  @Override
  public void sendKeys(CharSequence... value) {
    sendValueWithKeys(null, value);
  }

  public void sendValueWithKeys(Keys keys, CharSequence... value) {
    boolean finishedRetries = false;
    long retry = 0;
    do {
      try {
        WebElement element = getElement();
        sendValueWithKeysOnElement(element, keys, value);
        finishedRetries = true;
      } catch (RuntimeException e) {
        finishedRetries = (++retry == 5);
        if (finishedRetries) {
          throw new IllegalStateException("Unable to sendKeys on element " + this + " after " + retry + " retries", e);
        } else {
          LOGGER.warn("Error sending keys on element {}. retry = {}", this, retry);
        }
      }
    } while (!finishedRetries);
  }

  @SwitchToWindow
  public void sendValueWithKeysOnElement(WebElement element, Keys keys, CharSequence... value) {
    element.clear();
    element.sendKeys(value);
    if (keys != null) {
      element.sendKeys(keys);
    }
  }

}
