package elements;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WebElementFacade;

@ImplementedBy(BaseElementFacadeImpl.class)
public interface BaseElementFacade extends WebElementFacade {

	/**
	 * Wrapper which is meant to click on a clickable element.
	 */
	public void clickOnElement();

	/**
	 * This method checks the visibility of a webElement. It waits for the element
	 * to appear.
	 * 
	 * @return : true if the element is visible after the explicit timeout, false if
	 *         it did not appear.
	 */
	public boolean isVisibleAfterWaiting();

	/**
	 * This method checks the invisibility of a webElement. It waits for the element
	 * to disappear.
	 * 
	 * @return : true if the element is invisible after the explicit timeout, false
	 *         if it did appear.
	 */
	public boolean isNotVisibleAfterWaiting();

	public boolean isDisabledAfterWaiting();

	public boolean isEnabledAfterWaiting();

	/**
	 * Method to find an element inside an element using the xpath and to wrapp it
	 * in a BaseElementFacade instance
	 * 
	 * @return BaseElementFacade instance of the found element
	 */
	public <T extends BaseElementFacade> T findByXpath(String xpath);

	/**
	 * Method to find an element inside an element using the xpath and to wrapp it
	 * in a ButtonElementFacade instance
	 * 
	 * @return ButtonElementFacade instance of the found element
	 */
	public <T extends ButtonElementFacade> T findButtonElementByXpath(String xpath);

	/**
	 * Method to find an element inside an element using the xpath and to wrapp it
	 * in a TextElementFacade instance
	 * 
	 * @return TextElementFacade instance of the found element
	 */
	public <T extends TextElementFacade> T findTextElementByXpath(String xpath);



	/**
	 * This method will scroll the element to the right
	 */
	void scrollToTheRight();

	/**
	 * This method will scroll down the element
	 */
	void scrollDown();

	/**
	 * This method will scroll up or down until it reaches the web element
	 */
	public void scrollToWebElement();

	/**
	 * this method will check if element is displayed or not
	 * 
	 * @return : true if the element is displayed, false if it not.
	 */
	boolean isDisplayed();

	/**
	 * this method is to make the mouse hover over the selected element.
	 */
	public void hover(String xpath);
}
