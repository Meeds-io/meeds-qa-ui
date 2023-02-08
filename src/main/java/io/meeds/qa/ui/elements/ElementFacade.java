package io.meeds.qa.ui.elements;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeInvisibleException;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeVisibleException;

@ImplementedBy(ElementFacadeImpl.class)
public interface ElementFacade extends WebElementFacade {

  /**
   * Wrapper which is meant to click on a clickable element.
   */
  public void click();

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

  /**
   * this method is to make the mouse hover over the selected element.
   */
  public void hover();

  /**
   * This method will scroll up or down until it reaches the web element
   */
  public void scrollToWebElement();

  default void assertDisabled() {
    long start = System.currentTimeMillis();
    boolean disabled = isDisabled();
    assertTrue(String.format("Element %s wasn't disabled after waiting %s ms",
                             this,
                             System.currentTimeMillis() - start),
               disabled);
  }

  default void assertEnabled() {
    long start = System.currentTimeMillis();
    boolean enabled = isEnabled();
    assertTrue(String.format("Element %s wasn't enabled after waiting %s ms",
                             this,
                             System.currentTimeMillis() - start),
               enabled);
  }

  default void assertNotVisible() {
    long start = System.currentTimeMillis();
    boolean notVisible = isNotVisible();
    assertTrue(String.format("Element %s was visible after waiting %s ms",
                             this,
                             System.currentTimeMillis() - start),
               notVisible);
  }

  default void assertVisible() {
    long start = System.currentTimeMillis();
    boolean visible = isVisible();
    assertTrue(String.format("Element %s wasn't visible after waiting %s ms",
                             this,
                             System.currentTimeMillis() - start),
               visible);
  }

  default void checkClickable() {
    long start = System.currentTimeMillis();
    if (!isClickable()) {
      throw new ElementClickInterceptedException(String.format("Unable to locate a clickable element %s after %s ms",
                                                               this,
                                                               System.currentTimeMillis() - start));
    }
  }

  default void checkNotVisible() {
    long start = System.currentTimeMillis();
    if (!isNotVisible()) {
      throw new ElementShouldBeInvisibleException(String.format("Element is still visible %s after %s ms",
                                                                this,
                                                                System.currentTimeMillis() - start),
                                                  null);
    }
  }

  default void checkVisible() {
    long start = System.currentTimeMillis();
    if (!isVisible()) {
      throw new ElementShouldBeVisibleException(String.format("Unable to locate a visible element %s after %s ms",
                                                              this,
                                                              System.currentTimeMillis() - start),
                                                null);
    }
  }

  /**
   * this method will check if element is displayed or not without implicit
   * timeout
   * 
   * @return true if displayed else false
   */
  boolean isCurrentlyVisible();

  /**
   * Is this web element present and not visible on the screen This method will
   * not throw an exception if the element is visible. If the element is
   * visible, the method will wait a bit to see if it appears later on.
   * 
   * @return true if not visible else false
   */
  boolean isNotVisible();

  /**
   * This method will scroll down the element
   */
  void scrollDown();

  /**
   * This method will scroll the element to the right
   */
  void scrollToTheRight();

}
