package io.meeds.qa.ui.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.WebElementFacade;

public class ButtonElementFacadeImpl extends BaseElementFacadeImpl implements ButtonElementFacade {

  static final Logger  LOGGER = LoggerFactory.getLogger(ButtonElementFacadeImpl.class);

  public ButtonElementFacadeImpl(WebDriver driver,
                                 ElementLocator locator,
                                 WebElement element,
                                 long timeoutInMilliseconds,
                                 long waitForTimeoutInMilliseconds) {
    super(driver, locator, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  @SuppressWarnings("unchecked")
  public static <T extends ButtonElementFacade> T wrapWebElementFacadeInButtonElement(final WebDriver driver,
                                                                                      final WebElementFacade element,
                                                                                      final long implicitTimeoutInMilliseconds,
                                                                                      final long waitForTimeoutInMilliseconds) {
    return (T) new ButtonElementFacadeImpl(driver,
                                           null,
                                           element,
                                           implicitTimeoutInMilliseconds,
                                           waitForTimeoutInMilliseconds);
  }
}
