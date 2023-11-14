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
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class ProgramsPage extends GenericPage {

  private static final boolean APPS_ACCESS_VIA_MENU              =
                                                    Boolean.parseBoolean(System.getProperty("io.meeds.engagementApps.useMenu",
                                                                                            "true"));

  private static final String PROGRAM_OVERVIEW_PARENT_ITEM_PATH =
                                                                "//*[@id='programsOverview']//*[contains(@class, 'v-avatar')]/parent::*/parent::*";

  private ApplicationPage applicationPage;

  public ProgramsPage(WebDriver driver) {
    super(driver);
  }

  public void saveProgram(String programName, String programDescription, String programAudience) {
    if (StringUtils.isNotBlank(programName)) {
      enterProgramTitle(programName);
    }
    if (StringUtils.isNotBlank(programAudience)) {
      enterProgramDescription(programDescription);
    }
    clickDrawerButton("Next");
    if (StringUtils.isNotBlank(programAudience)) {
      addSpaceAudience(programAudience);
    }
    saveButtonElement().click();
    waitForDrawerToClose();
    waitForLoading();
    waitFor(200).milliseconds();
  }

  public void enableDisableProgram() {
    programStatusSwitcher().click();
    waitForLoading();
    waitFor(200).milliseconds();
  }

  public void checkProgramStatusSwitchNotDisplayed() {
    programStatusSwitcher().assertNotVisible();
  }

  public void goBackUsingProgramTitle(String programName) {
    getProgramDetailTitle(programName).click();
  }

  public void addSpaceAudience(String randomSpaceName) {
    mentionInField(audienceSpaceFieldElement(), randomSpaceName, 5);
  }

  public void checkProgramCardDisplay(String title) {
    getProgramCardTitle(title).assertNotVisible();
  }

  public void checkProgramCardTitle(String title) {
    searchProgram(title);
    getProgramCardTitle(title).assertVisible();
  }

  public void checkProgramDrawerDisplay() {
    headerProgramDrawerElement().assertVisible();
  }

  public void clickAddProgramBtn() {
    clickOnElement(addProgramBtnElement());
  }

  public void clickSaveProgramButton() {
    createButtonElement().click();
    waitForDrawerToClose();
    waitForLoading();
    waitFor(200).milliseconds();
  }

  public void deleteCreatedProgram(String programName) {
    searchProgram(programName);
    getProgramCard(programName).assertVisible();
    programThreeDotsButtonElement(programName).click();
    deleteProgramButtonElement().click();
    yesConfirmButtonElement().click();
    waitForLoading();
  }

  public void editProgram() {
    programThreeDotsButtonElement().click();
    editProgramButtonElement().click();
  }

  public void editProgram(String programName) {
    searchProgram(programName);
    getProgramCard(programName).assertVisible();
    programThreeDotsButtonElement(programName).click();
    editActionMenuItem().click();
  }

  public void editProgramWithDescription(String programName, String newProgramName, String newProgramDescription) {
    searchProgram(programName);
    getProgramCard(programName).assertVisible();
    programThreeDotsButtonElement(programName).click();
    editProgramButtonElement().click();

    saveProgram(newProgramName, newProgramDescription, null);
  }

  public void enterProgramTitle(String programTitle) {
    programTitleFieldElement().setTextValue(programTitle);
  }

  public void enterProgramDescription(String programDescription) {
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

  public void selectEngagementApplication(String link) {
    if (APPS_ACCESS_VIA_MENU) {
      engagementApplicationLink().hover();
      ElementFacade engagementApplicationLink = engagementApplicationLink(link);
      engagementApplicationLink.waitUntilVisible();
      engagementApplicationLink.click();
      waitForLoading();
      waitFor(300).milliseconds(); // Wait for Tab switch
    } else {
      applicationPage.goToApplication("Contributions");
      if (!StringUtils.equals(link, "programs")) {
        String currentUrl = getDriver().getCurrentUrl();
        getDriver().navigate().to(currentUrl + "/" + link);
      }
    }
  }

  public void selectProgramsFilter(String value) {
    programFilterDropdown().selectByValue(value);
    waitForLoading();
  }

  public void selectProgramActionsFilter(String value) {
    rulesStatusDropdown().selectByValue(value);
    waitForLoading();
  }

  public void openProgramCard(String title) {
    searchProgram(title);
    getProgramCard(title).click();
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
    getActionItemElement(actionTitle).hover();
    actionMenuButton().click();
    editActionMenuItem().click();
  }

  public void deleteProgramAction(String actionTitle) {
    getActionItemElement(actionTitle).hover();
    actionMenuButton().click();
    deleteActionMenuItem().click();
    clickToConfirmDialog();
  }

  public void announceAction(String actionTitle, String announcementMessage) {
    getActionItemElement(actionTitle).hover();
    announceButton().click();
    sendAnnouncementMessage(announcementMessage);
  }

  public void announceActionFromActivity(String actionTitle, String announcementMessage) {
    activityAnnounceButton(actionTitle).click();
    sendAnnouncementMessage(announcementMessage);
  }

  public void sendAnnouncementMessage(String announcementMessage) {
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
    waitForDrawerToClose();
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
    rulesAdminStatusDropdown().assertVisible();
  }

  public void checkAdminActionsFilterIsNotDisplayed() {
    rulesAdminStatusDropdown().assertNotVisible();
  }

  public void checkActionsFilterIsDisplayed() {
    rulesStatusDropdown().assertVisible();
  }

  public void attachAvatarToProgram() {
    attachAvatarButton().click();
    waitForDrawerToOpen();
    attachImageToOpenedDrawer(true);
  }

  public void attachCoverToProgram() {
    attachCoverButton().click();
    waitForDrawerToOpen();
    attachImageToOpenedDrawer(true);
  }

  public void deleteAvatarFromProgram() {
    deleteAvatarButton().click();
  }

  public void deleteCoverFromProgram() {
    deleteCoverButton().click();
  }

  public void checkProgramAvatarIsSpecificInDetail() {
    waitForAvatarBackgroundToLoad();
    assertThat(avatarImageElement().getAttribute("style")).doesNotContain("default").as("Program Avatar should be specific");
  }

  public void checkProgramAvatarIsDefaultInDetail() {
    waitForAvatarBackgroundToLoad();
    assertThat(avatarImageElement().getAttribute("style")).contains("default").as("Program Avatar should be default");
  }

  public void checkProgramCoverIsSpecificInDetail() {
    assertThat(coverImageElement().getAttribute("src")).doesNotContain("default").as("Program Cover should be specific");
  }

  public void checkProgramCoverIsDefaultInDetail() {
    assertThat(coverImageElement().getAttribute("src")).contains("default").as("Program Cover should be default");
  }

  public String getProgramTitleFromDrawer() {
    TextBoxElementFacade programTitleElement = programTitleFieldElement();
    return programTitleElement.isCurrentlyVisible() ? programTitleElement.getTextValue() : null;
  }

  private void searchProgram(String title) {
    waitForLoading();
    while (getProgramCardTitle(title).isNotVisible() && getButton("Show More").isVisible()) {
      getButton("Show More").scrollToWebElement();
      getButton("Show More").click();
      waitFor(200).milliseconds();
      waitForLoading();
    }
  }

  private TextBoxElementFacade programOwnerSuggester() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'assignChallengeMenu')]//*[contains(@class, 'identitySuggesterInputStyle')]//input[@type = 'text']");
  }

  private ElementFacade addProgramOwnerButton() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'Add Owners')]");
  }

  private ElementFacade topProgramsElement(String programName, int listPosition) {
    return findByXPathOrCSS(String.format("(%s)[%s]//*[contains(text(), '%s')]",
                                          PROGRAM_OVERVIEW_PARENT_ITEM_PATH,
                                          listPosition,
                                          programName));
  }

  private ElementFacade topProgramsElement(String programName) {
    return findByXPathOrCSS(String.format("%s//*[contains(text(), '%s')]",
                                          PROGRAM_OVERVIEW_PARENT_ITEM_PATH,
                                          programName));
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

  private ElementFacade programStatusSwitcher() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//input[@id='engagementCenterProgramDrawerSwitch']/parent::*[contains(@class, 'v-input--selection-controls__input')]");
  }

  private ElementFacade deleteProgramButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'fas fa-trash-alt')]");
  }

  private ElementFacade editProgramButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'fas fa-edit')]");
  }

  private ElementFacade engagementApplicationLink() {
    return findByXPathOrCSS("//*[@id = 'topBarMenu']//a[contains(@href, 'contributions')]");
  }

  private ElementFacade engagementApplicationLink(String link) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-menu__content')]//a[contains(@href, 'contributions/%s')]",
                                          link));
  }

  private ElementFacade getProgramCard(String programName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'engagement-center-card')]//*[contains(text(),'%s')]",
                                          programName));
  }

  private ElementFacade getProgramCardTitle(String title) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'engagement-center-card')]",
                                          title));
  }

  private ElementFacade getProgramDetailTitle(String title) {
    return findByXPathOrCSS(String.format("//*[@id='engagementCenterProgramDetail']//*[contains(@class,'v-card')]//*[contains(text(),'%s')]",
                                          title));
  }

  private ElementFacade headerProgramDrawerElement() {
    return findByXPathOrCSS("//*[@id='EngagementCenterProgramDrawerForm']");
  }

  private TextBoxElementFacade programDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade programThreeDotsButtonElement(String programName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'engagement-center-card')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'engagement-center-card')]//*[contains(@class,'fa-ellipsis-v')]",
                                          programName));
  }

  private ElementFacade programThreeDotsButtonElement() {
    return findByXPathOrCSS("#engagementCenterProgramDetail .fa-ellipsis-v");
  }

  private TextBoxElementFacade programTitleFieldElement() {
    return findTextBoxByXPathOrCSS("//input[@name='programTitle']");
  }

  private ElementFacade saveButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private ElementFacade yesConfirmButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__actions']//button[contains(@class,'btn btn-primary')]");
  }

  private ElementFacade getActionItemElement(String challengeTitle) {
    return findByXPathOrCSS(String.format("//ancestor::tbody//ancestor::*[contains(@title,'%s')]", challengeTitle));
  }

  private ElementFacade activityAnnounceButton(String ruleTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'activity-detail')]//*[contains(@class, 'activity-footer')]//*[contains(@class, 'bullhorn')]",
                                          ruleTitle));
  }

  private ElementFacade announceButton() {
    return findByXPathOrCSS("//*[contains(@class, 'fa-bullhorn')]");
  }

  private ElementFacade actionMenuButton() {
    return findByXPathOrCSS("//*[@id = 'engagementCenterProgramDetail']//*[contains(@class, 'v-data-table')]//*[contains(@class, 'fa-ellipsis-v')]");
  }

  private ElementFacade editActionMenuItem() {
    return findByXPathOrCSS("//*[contains(@class, 'v-menu')]//*[contains(text(), 'Edit')]");
  }

  private ElementFacade deleteActionMenuItem() {
    return findByXPathOrCSS("//*[contains(@class, 'v-menu')]//*[contains(text(), 'Delete')]");
  }

  private ElementFacade closeProgramCardIcon() {
    return findByXPathOrCSS("//*[@id = 'engagementCenterProgramDetail']//*[contains(@class, 'fa-arrow-left')]");
  }

  private TextBoxElementFacade challengeAnnouncementFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade programFilterDropdown() {
    return findByXPathOrCSS("//*[@id='applicationToolbarFilterSelect']//option[@value='ALL']/parent::select");
  }

  private ElementFacade rulesStatusDropdown() {
    return findByXPathOrCSS("//*[@id='rulesStatusFilter']//option[@value='ALL']/parent::select");
  }

  private ElementFacade rulesAdminStatusDropdown() {
    return findByXPathOrCSS("//*[@id='rulesStatusFilter']//option[@value='DISABLED']/parent::select");
  }

  private ElementFacade announceChallengeActionFromDrawer() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'Announce your achievement']");
  }

  private ElementFacade daysLeftInfoFromDrawer() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'Ends in') or contains(text(), 'Available in')]");
  }

  private ElementFacade attachCoverButton() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'fa-file-image')])[1]");
  }

  private ElementFacade deleteCoverButton() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'fa-file-image')])[1]//ancestor::*[contains(@class, 'EngagementCenterImageSelector')]//i[contains(@class, 'delete')]");
  }

  private ElementFacade attachAvatarButton() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'fa-file-image')])[2]");
  }

  private ElementFacade deleteAvatarButton() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'fa-file-image')])[2]//ancestor::*[contains(@class, 'EngagementCenterImageSelector')]//i[contains(@class, 'delete')]");
  }

  private ElementFacade coverImageElement() {
    return findByXPathOrCSS("//*[@id='engagementCenterCoverImage']");
  }

  private ElementFacade avatarImageElement() {
    return findByXPathOrCSS(".rule-program-cover .v-image__image--cover");
  }

  private void waitForAvatarBackgroundToLoad() {
    retryOnCondition(() -> {
      if (!avatarImageElement().getAttribute("style").contains("background-image")) {
        throw new IllegalStateException(String.format("Element doesn't have adequate style for background image: %s",
                                                      avatarImageElement()));
      }
    }, () -> waitFor(200).milliseconds());
  }

}
