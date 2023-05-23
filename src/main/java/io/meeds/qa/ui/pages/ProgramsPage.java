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

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class ProgramsPage extends GenericPage {

  public ProgramsPage(WebDriver driver) {
    super(driver);
  }

  public void saveProgram(String programName, String programDescription, String programAudience) {
    if (StringUtils.isNotBlank(programName)) {
      enterProgramTitle(programName);
    }
    if (StringUtils.isNotBlank(programAudience)) {
      addProgramWithRandomDescription(programDescription);
    }
    if (StringUtils.isNotBlank(programAudience)) {
      addSpaceAudience(programAudience);
    }
    saveButtonElement().click();
    waitForDrawerToClose();
    waitForLoading();
  }

  public void addDisabledProgramWithRandomDescription(String disabledProgramDescription) {
    addProgramWithRandomDescription(disabledProgramDescription);
    selectStatusSwitcher();
  }

  public void addProgramWithRandomDescription(String programDescription) {
    waitDrawerCKEditorLoading();
    ElementFacade ckEditorFrameProgramElement = ckEditorFrameElement();
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

  public void clickSaveProgramButton() {
    createButtonElement().click();
    waitForDrawerToClose();
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

    saveProgram(newProgramName, newProgramDescription, null);
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

  public void openProgramCard(String value) {
    getProgramCard(value).click();
  }

  public void changeProgramActionsFilter(String value) {
    filterActionsDropdown().selectByValue(value);
    waitForLoading();
  }

  public void checkCannotAnnounceAction() {
    announceChallengeActionFromDrawer().assertNotVisible();
  }

  public void checkProgramActionNotContainsDurationLimitation() {
    daysLeftInfoFromDrawer().assertNotVisible();
  }

  public void checkProgramActionContainsDurationLimitation() {
    daysLeftInfoFromDrawer().assertVisible();
  }

  public void closeProgramCard() {
    closeProgramCardIcon().click();
  }

  public void editProgramAction(String actionTitle) {
    getChallengeItemElement(actionTitle).hover();
    actionMenuButton().click();
    editActionMenuItem().click();
  }

  public void announceChallenge(String challengeTitle, String announcementMessage) {
    getChallengeItemElement(challengeTitle).hover();
    announceButton().click();
    ElementFacade ckEditorFrameAnnouncementElement = ckEditorFrameElement();
    ckEditorFrameAnnouncementElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameAnnouncementElement);
    try {
      TextBoxElementFacade challengeAnnouncementFieldElement = challengeAnnouncementFieldElement();
      challengeAnnouncementFieldElement.waitUntilVisible();
      challengeAnnouncementFieldElement.setTextValue(announcementMessage);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    saveButtonElement().click();
  }

  public void selectStatusSwitcher() {
    WebElement checkbox = getDriver().findElement(By.xpath("//*[@class='v-input--selection-controls__ripple primary--text']"));
    checkbox.click();
  }

  public void checkProgramPositionInTopPrograms(String programName, int listPosition) {
    topProgramsElement(programName, listPosition).assertVisible();
  }

  public void checkProgramNotDisplayedInTopPrograms(String programName) {
    topProgramsElement(programName).assertNotVisible();
  }

  public void addProgramOwner(String fullName) {
    addProgramOwnerButton().click();
    mentionInField(programOwnerSuggester(), fullName, 3);
  }

  public void checkAdminActionsFilterIsDisplayed() {
    filterAdminActionsDropdown().assertVisible();
  }

  public void checkAdminActionsFilterIsNotDisplayed() {
    filterAdminActionsDropdown().assertNotVisible();
  }

  public void checkActionsFilterIsDisplayed() {
    filterActionsDropdown().assertVisible();
  }

  private TextBoxElementFacade programOwnerSuggester() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'assignChallengeMenu')]//*[contains(@class, 'identitySuggesterInputStyle')]//input[@type = 'text']");
  }

  private ElementFacade addProgramOwnerButton() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'Add Owners')]");
  }

  private ElementFacade topProgramsElement(String programName, int listPosition) {
    return findByXPathOrCSS(String.format("(//*[@id='programsOverview']//a[contains(@href, 'programs/')])[%s]//*[contains(text(), '%s')]", listPosition, programName));
  }
  
  private ElementFacade topProgramsElement(String programName) {
    return findByXPathOrCSS(String.format("//*[@id='programsOverview']//a[contains(@href, 'programs/')]//*[contains(text(), '%s')]", programName));
  }

  private ElementFacade addProgramBtnElement() {
    return findByXPathOrCSS("//*[contains(text(), 'Add program')]//ancestor::*[contains(@class, 'btn-primary')]");
  }

  private TextBoxElementFacade audienceSpaceFieldElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class, 'v-navigation-drawer--open')]//*[@name='programSpaceAutocomplete']//input)[01]");
  }

  private ElementFacade ckEditorFrameElement() {
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
    return findByXPathOrCSS(String.format("//*[contains(@class,'engagement-center-card')]//*[contains(text(),'%s')]",
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

  private ElementFacade getChallengeItemElement(String challengeTitle) {
    return findByXPathOrCSS(String.format("//ancestor::tbody//ancestor::*[contains(@title,'%s')]", challengeTitle));
  }

  private ElementFacade announceButton() {
    return findByXPathOrCSS("//*[@id = 'engagementCenterProgramDetail']//*[contains(@class, 'v-data-table')]//*[contains(@class, 'fa-bullhorn')]");
  }

  private ElementFacade actionMenuButton() {
    return findByXPathOrCSS("//*[@id = 'engagementCenterProgramDetail']//*[contains(@class, 'v-data-table')]//*[contains(@class, 'fa-ellipsis-v')]");
  }

  private ElementFacade editActionMenuItem() {
    return findByXPathOrCSS("//*[@id = 'engagementCenterProgramDetail']//*[contains(@class, 'v-menu')]//*[contains(text(), 'Edit')]");
  }

  private ElementFacade closeProgramCardIcon() {
    return findByXPathOrCSS("//*[@id = 'engagementCenterProgramDetail']//*[contains(@class, 'fa-arrow-left')]");
  }

  private TextBoxElementFacade challengeAnnouncementFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade filterActionsDropdown() {
    return findByXPathOrCSS("//*[@id='engagementCenterProgramDetail']//option[@value='ALL']/parent::select");
  }

  private ElementFacade filterAdminActionsDropdown() {
    return findByXPathOrCSS("//*[@id='engagementCenterProgramDetail']//option[@value='DISABLED']/parent::select");
  }

  private ElementFacade announceChallengeActionFromDrawer() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'Announce your achievement']");
  }

  private ElementFacade daysLeftInfoFromDrawer() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'fa-calendar-day')]");
  }

}
