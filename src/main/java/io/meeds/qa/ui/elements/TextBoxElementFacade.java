/*
 * This file is part of the Meeds project (https://meeds.io/).
 * 
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
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
   * Enter would be:<br>
   * changeValueTo("abc", KEY.ENTER);
   *
   * @param newValue String to fill the textBox field with.
   * @param keys     Optional key to enter after having fulfilled the value in
   *                   the specific field.
   */
  public void setTextValue(String newValue, Keys keys);

}
