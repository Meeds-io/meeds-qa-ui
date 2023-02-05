package io.meeds.qa.ui.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.WebElementFacade;

public class ButtonElementFacadeImpl extends ElementFacadeImpl implements ButtonElementFacade {

  static final Logger LOGGER = LoggerFactory.getLogger(ButtonElementFacadeImpl.class);

  @SuppressWarnings("unchecked")
  public static <T extends ButtonElementFacade> T wrapWebElementFacadeInButtonElement(final WebDriver driver,
                                                                                      final WebElementFacade element,
                                                                                      final ElementLocator locator,
                                                                                      final String xPathOrCSSSelector,
                                                                                      final long implicitTimeoutInMilliseconds,
                                                                                      final long waitForTimeoutInMilliseconds) {
    return (T) new ButtonElementFacadeImpl(driver,
                                           locator,
                                           xPathOrCSSSelector,
                                           element,
                                           implicitTimeoutInMilliseconds,
                                           waitForTimeoutInMilliseconds);
  }

  public ButtonElementFacadeImpl(WebDriver driver,
                                 ElementLocator locator,
                                 String xPathOrCSSSelector,
                                 WebElement element,
                                 long timeoutInMilliseconds,
                                 long waitForTimeoutInMilliseconds) {
    super(driver, locator, xPathOrCSSSelector, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  public ButtonElementFacadeImpl(WebDriver driver,
                                 ElementLocator locator,
                                 WebElement element,
                                 long timeoutInMilliseconds,
                                 long waitForTimeoutInMilliseconds) {
    super(driver, locator, null, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }
}
