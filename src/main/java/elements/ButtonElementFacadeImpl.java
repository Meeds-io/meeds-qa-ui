package elements;

import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class ButtonElementFacadeImpl extends BaseElementFacadeImpl implements ButtonElementFacade {

	static final Logger LOGGER = LogManager.getLogger();

	public ButtonElementFacadeImpl(WebDriver driver, ElementLocator locator, WebElement element,
			long timeoutInMilliseconds, long waitForTimeoutInMilliseconds) {
		super(driver, locator, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
	}

	@SuppressWarnings("unchecked")
	public static <T extends ButtonElementFacade> T wrapWebElementFacadeInButtonElement(final WebDriver driver,
			final WebElementFacade element, final long implicitTimeoutInMilliseconds,
			final long waitForTimeoutInMilliseconds) {
		return (T) new ButtonElementFacadeImpl(driver, null, element, implicitTimeoutInMilliseconds,
				waitForTimeoutInMilliseconds);
	}
}
