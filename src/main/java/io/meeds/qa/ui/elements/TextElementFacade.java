package io.meeds.qa.ui.elements;

import net.serenitybdd.core.annotations.ImplementedBy;

@ImplementedBy(TextElementFacadeImpl.class)
public interface TextElementFacade extends ElementFacade {

  /*
   * This method returns the text value of the WebElementFacade
   * @return text value
   */
  public String getContent();

}
