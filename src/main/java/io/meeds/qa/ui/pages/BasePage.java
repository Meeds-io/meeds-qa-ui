package io.meeds.qa.ui.pages;

import io.meeds.qa.ui.elements.ElementFacade;

public interface BasePage {

  /**
   * Method to find an element that has the type BaseElementFacade using an
   * xpath.
   * 
   * @param  xpath : xpath of the element
   * @param  <T>   an elemtn that inherits from {@link ElementFacade}
   * @return       {@link ElementFacade} object
   */
  <T extends ElementFacade> T findByXPathOrCSS(String xpath);
}
