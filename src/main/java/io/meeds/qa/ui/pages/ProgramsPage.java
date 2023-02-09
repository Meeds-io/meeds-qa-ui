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

import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class ProgramsPage extends GenericPage {

  public ProgramsPage(WebDriver driver) {
    super(driver);
  }

  public void addDisabledProgramWithRandomDescription(String disabledProgramDescription) {
    ElementFacade ckEditorFrameProgramElement = ckEditorFrameProgramElement();
    ckEditorFrameProgramElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameProgramElement);
    try {
      TextBoxElementFacade programDescriptionFieldElement = programDescriptionFieldElement();
      programDescriptionFieldElement.waitUntilVisible();
      programDescriptionFieldElement.setTextValue(disabledProgramDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    selectStatusSwitcher();
  }

  public void addProgramWithRandomDescription(String programDescription) {
    ElementFacade ckEditorFrameProgramElement = ckEditorFrameProgramElement();
    ckEditorFrameProgramElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameProgramElement);
    try {
      TextBoxElementFacade programDescriptionFieldElement = programDescriptionFieldElement();
      programDescriptionFieldElement.waitUntilVisible();
      programDescriptionFieldElement.setTextValue(programDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void addSpaceAudience(String randomSpaceName) {
    mentionInField(audienceSpaceFieldElement(), randomSpaceName, 5);
    clickCreateProgramButton();
  }

  public void checkEngagementAppOpened() {
    findByXPathOrCSS("//*[@id='EngagementCenterApplication']").assertVisible();
  }

  public void checkProgramCardDisplay(String title) {
    getProgramCardTitle(title).assertNotVisible();
  }

  public void checkProgramCardTitle(String title) {
    getProgramCardTitle(title).assertVisible();
  }

  public void checkProgramDrawerDisplay() {
    headerProgramDrawerElement().assertVisible();
  }

  public void checkProgramTitleDisplayOnCard(String title) {
    getProgramCardTitle(title).assertVisible();
  }

  public void checkProgramTitleUpdateOnCard(String title) {
    getProgramCardTitle(title).assertVisible();
  }

  public void clickAddProgramBtn() {
    clickOnElement(addProgramBtnElement());
  }

  public void clickCreateProgramButton() {
    createButtonElement().click();
  }

  public void deleteCreatedProgram(String programName) {
    getProgramCard(programName).assertVisible();
    programThreeDotsButtonElement().click();
    deleteProgramButtonElement().click();
    yesConfirmButtonElement().click();
  }

  public void editProgramWithDescription(String programName, String newProgramName, String newProgramDescription) {
    getProgramCard(programName).assertVisible();
    programThreeDotsButtonElement().click();
    editProgramButtonElement().click();
    programTitleFieldElement().setTextValue(newProgramName);
    waitCKEditorLoading();
    ElementFacade ckEditorFrameProgramElement = ckEditorFrameProgramElement();
    ckEditorFrameProgramElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameProgramElement);
    try {
      TextBoxElementFacade programDescriptionFieldElement = programDescriptionFieldElement();
      programDescriptionFieldElement.waitUntilVisible();
      programDescriptionFieldElement.setTextValue(newProgramDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    saveButtonElement().click();
  }

  public void enterProgramRandomTitle(String programTitle) {
    programTitleFieldElement().setTextValue(programTitle);
  }

  public void enterProgramTitle(String programTitle) {
    programTitleFieldElement().setTextValue(programTitle);
  }

  public void selectEngagementTab(String tab) {
    clickOnElement(getEngagementTab(tab));
    waitForLoading();
    waitFor(300).milliseconds(); // Wait for Tab switch
  }

  public void selectProgramsFilter(String value) {
    ElementFacade programQuickFilterSelectBoxElement = programQuickFilterSelectBoxElement();
    programQuickFilterSelectBoxElement.click();
    programQuickFilterSelectBoxElement.selectByValue(value);
    programQuickFilterSelectBoxElement.click();
    waitForLoading();
  }

  public void selectStatusSwitcher() {
    WebElement checkbox = getDriver().findElement(By.xpath("//*[@class='v-input--selection-controls__ripple primary--text']"));
    checkbox.click();
  }

  private ElementFacade addProgramBtnElement() {
    return findByXPathOrCSS("//*[@id='engagementCenterAddProgramBtn']");
  }

  private TextBoxElementFacade audienceSpaceFieldElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class, 'v-navigation-drawer--open')]//*[@name='programSpaceAutocomplete']//input)[01]");
  }

  private ElementFacade ckEditorFrameProgramElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open iframe.cke_wysiwyg_frame");
  }

  private ElementFacade createButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private ElementFacade deleteProgramButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'fas fa-trash-alt')]");
  }

  private ElementFacade editProgramButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'fas fa-edit')]");
  }

  private ElementFacade getEngagementTab(String tab) {
    return findByXPathOrCSS(String.format("//*[@id='engagementCenterTabs']//*[contains(text(),'%s')]", tab));
  }

  private ElementFacade getProgramCard(String programName) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'engagement-center-card')]",
                                          programName));
  }

  private ElementFacade getProgramCardTitle(String title) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'engagement-center-card')]",
                                          title));
  }

  private ElementFacade headerProgramDrawerElement() {
    return findByXPathOrCSS("//*[@id='EngagementCenterProgramDrawerForm']");
  }

  private TextBoxElementFacade programDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade programQuickFilterSelectBoxElement() {
    return findByXPathOrCSS("//*[@id='EngagementCenterApplicationCProgramsQuickFilter']");
  }

  private ElementFacade programThreeDotsButtonElement() {
    return findByXPathOrCSS("//button[contains(@class,'pull-right')]");
  }

  private TextBoxElementFacade programTitleFieldElement() {
    return findTextBoxByXPathOrCSS("//*[@id='EngagementCenterProgramDrawerTitleTextArea']");
  }

  private ElementFacade saveButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private ElementFacade yesConfirmButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__actions']//button[contains(@class,'btn btn-primary')]");
  }

}
