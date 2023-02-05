package io.meeds.qa.ui.elements;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WebElementFacade;

@ImplementedBy(ElementFacadeImpl.class)
public interface ElementFacade extends WebElementFacade {

  /**
   * Wrapper which is meant to click on a clickable element.
   */
  public void clickOnElement();

  /**
   * Method to find an element inside an element using the xpath and to wrapp it
   * in a BaseElementFacade instance
   * 
   * @param  xpath XPath of Sub element
   * @return       BaseElementFacade instance of the found element
   */
  public <T extends ElementFacade> T findByXPath(String xpath);

  /**
   * @return currently used {@link WebDriver}
   */
  public WebDriver getDriver();

  public String getXPathOrCSSSelector();

  /**
   * this method is to make the mouse hover over the selected element.
   */
  public void hover();

  /**
   * this method is to make the mouse hover over the selected element.
   *
   * @param xpath XPath of Sub element
   */
  public void hover(String xpath);

  public boolean isDisabledAfterWaiting();

  public boolean isEnabledAfterWaiting();

  /**
   * This method checks the invisibility of a webElement. It waits for the
   * element to disappear.
   *
   * @return : true if the element is invisible after the explicit timeout,
   *         false if it did appear.
   */
  public boolean isNotVisibleAfterWaiting();

  /**
   * This method checks the visibility of a webElement. It waits for the element
   * to appear.
   *
   * @return : true if the element is visible after the explicit timeout, false
   *         if it did not appear.
   */
  public boolean isVisibleAfterWaiting();

  /**
   * This method will scroll up or down until it reaches the web element
   */
  public void scrollToWebElement();

  /**
   * this method will check if element is displayed or not
   *
   * @return : true if the element is displayed, false if it not.
   */
  @Override
  boolean isDisplayed();

  /**
   * this method will check if element is displayed or not with a given implicit
   * wait time in milliseconds
   * 
   * @param  implicitWaitInMillis wait time in milliseconds
   * @return                      true if displayed else false
   */
  boolean isDisplayed(long implicitWaitInMillis);

  /**
   * this method will check if element is displayed or not without implicit
   * timeout
   * 
   * @return true if displayed else false
   */
  boolean isDisplayedNoWait();

  /**
   * This method will scroll down the element
   */
  void scrollDown();

  /**
   * This method will scroll the element to the right
   */
  void scrollToTheRight();
}
