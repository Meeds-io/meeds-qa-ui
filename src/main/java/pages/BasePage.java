package pages;


import elements.BaseElementFacade;

public interface BasePage {

	/**
	 * Method to verify the presence of all the elements that has the
	 * annotation @findBy in a page. Note : this method is called by default from
	 * the currentPage method unless it is overrided inside of the page
	 * 
	 */
	void verifyPageLoaded();

	/**
	 * Method to find an element that has the type BaseElementFacade using an xpath.
	 * 
	 * @param xpath:
	 *            xpath of the element
	 */
	<T extends BaseElementFacade> T findByXpath(String xpath);
}
