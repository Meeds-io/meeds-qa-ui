package io.meeds.qa.ui.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.WebElementFacade;

public class TextElementFacadeImpl extends BaseElementFacadeImpl implements TextElementFacade {

  static final Logger  LOGGER = LoggerFactory.getLogger(TextElementFacadeImpl.class);

  public TextElementFacadeImpl(WebDriver driver,
                               ElementLocator locator,
                               WebElement element,
                               long timeoutInMilliseconds,
                               long waitForTimeoutInMilliseconds) {
    super(driver, locator, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
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
    LOGGER.debug(String.format("Getting text of the element [%s]", this));
    String textValue = null;
    try {
      waitUntilVisible();
      textValue = getText();
    } catch (Exception e) {
      exceptionLauncher.throwSerenityExeption(e,
                                              String.format("Text can't be extracted from The element [%s]", this));
    }
    return textValue;

  }

}
