package io.meeds.qa.ui.elements;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.annotations.ImplementedBy;

@ImplementedBy(TextBoxElementFacadeImpl.class)
public interface TextBoxElementFacade extends ElementFacade {

  /*
   * This method returns the text value of the WebElement
   * @param newValue String to fill the textBox field with.
   */
  public String getTextBoxValue();

  /*
   * This method changes the text value of the WebElement
   * @param newValue String to fill the textBox field with.
   */
  public void setTextValue(String newValue);

  /**
   * This method changes the text value of the WebElement followed by some
   * Keys.<br>
   * Example: enter the value "abc" in the field MyWebElement then the Keys
   * Enter
   * would be:<br>
   * changeValueTo("abc", KEY.ENTER);
   *
   * @param newValue String to fill the textBox field with.
   * @param keys Optional key to enter after having fulfilled the value in the
   *          specific field.
   */
  public void setTextValue(String newValue, Keys keys);

}
