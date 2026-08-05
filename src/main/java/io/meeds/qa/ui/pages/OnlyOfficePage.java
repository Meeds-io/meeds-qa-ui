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

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;

public class OnlyOfficePage extends GenericPage {

  public OnlyOfficePage(WebDriver driver) {
    super(driver);
  }

  public void attachFileToActivity(String fileName) {
    attachFileButtonElement().click();
    waitForDrawerToOpen(".attachmentsAppDrawer", true);
    waitFor(1).seconds();
    attachImageToFileInput(attachDrawerFileInputElement(), fileName);
    waitForLoading();
    checkConfirmMessageIsDisplayed("File list successfully updated");
    clickDrawerButton("Done");
  }

  public void openDocumentPreview(String fileName) {
    ElementFacade preview = documentPreviewElement(fileName);
    retryOnCondition(preview::checkVisible,
                     () -> waitFor(1).seconds(),
                     5);
    preview.hover();
    preview.click();
    waitForLoading();
  }

  public void checkEditOnlineButtonNotDisplayed() {
    editOnlineButtonElement().assertNotVisible();
  }

  private ElementFacade attachFileButtonElement() {
    return findByXPathOrCSS("//*[@class='cke_button_icon cke_button__attachfile_icon']/parent::a");
  }

  private ElementFacade attachDrawerFileInputElement() {
    return findByXPathOrCSS("//*[contains(@class,'attachmentsAppDrawer')]//input[@type='file']");
  }

  private ElementFacade documentPreviewElement(String fileName) {
    return findByXPathOrCSS(String.format("//*[contains(@alt,'%s') or contains(text(),'%s')]//ancestor::*[contains(@id,'PreviewAttachment')]",
                                          fileName,
                                          fileName));
  }

  private ElementFacade editOnlineButtonElement() {
    return findByXPathOrCSS("//div[contains(@class,'editorButtonContainer')]");
  }

}
