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
package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.switchToTabByIndex;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;

public class GenericPage extends BasePageImpl {

  public static final String UPLOAD_DIRECTORY_PATH = GenericPage.class.getResource(File.separator+"DataFiles"+File.separator).getFile();

  public GenericPage() {
    this(null);
  }

  public GenericPage(WebDriver driver) {
    super(driver);
    url = "genericPage";
  }

  public void checkConfirmMessageIsDisplayed(String message) {
    getConfirmMessage(message).assertVisible();
  }

  public void checkDrawerDisplayed(String title) {
    assertTrue(findByXPathOrCSS(String.format("//*[contains(@class, 'drawerTitle') and contains(text(),'%s')]",
                                              title)).isVisible());
  }

  public void clickConfirm() {
    clickToConfirmDialog();
    waitFor(200).milliseconds(); // Wait for animation until the home icon changes its location
  }

  public void closeBrowserTab(int index) {
    switchToTabByIndex(getDriver(), index);
    getDriver().close();
    if (index > 0) {
      switchToTabByIndex(getDriver(), index - 1);
    }
  }

  public boolean containsContent(String content) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", content)).isVisible();
  }

  public boolean isButtonDisplayed(String buttonName) {
    return getButton(buttonName).isVisible();
  }

  public void isPageOpened(String uriPart) {
    assertTrue(getDriver().getCurrentUrl().contains(uriPart));
  }

  public boolean isSuccessMessageDisplayed() {
    return findByXPathOrCSS("//div[contains(@class,'alert-success')]").isVisible();
  }

  public void checkSwitchButtonNotDisplayed(String buttonName) {
    findByXPathOrCSS(String.format("//*[contains(@class, 'v-input--switch')]/parent::*//*[contains(text(), '%s')]", buttonName)).assertNotVisible();
  }

  public void checkSwitchButtonDisplayed(String buttonName) {
    findByXPathOrCSS(String.format("//*[contains(@class, 'v-input--switch')]/parent::*//*[contains(text(), '%s')]", buttonName)).assertVisible();
  }

  public void enableSwitchButtonDisplayed(String buttonName) {
    findByXPathOrCSS(String.format("//*[contains(text(), '%s')]/parent::*//*[contains(@class, 'v-input--switch') and contains(@class, 'v-input--selection-controls')]", buttonName)).click();
  }

  private ElementFacade getConfirmMessage(String message) {
    return findByXPathOrCSS(String.format("//span[contains(text(),\"%s\")]", message));
  }

}
