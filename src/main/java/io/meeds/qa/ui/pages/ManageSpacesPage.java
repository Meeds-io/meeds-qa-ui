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
import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ButtonElementFacade;
import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class ManageSpacesPage extends GenericPage {

  private SpacePage spaceHomePage;

  public ManageSpacesPage(WebDriver driver) {
    super(driver);
  }

  public void addUserToSpace(String user) {
    spaceMembersTabElement().click();
    ElementFacade inviteUserButtonElement = inviteUserButton();
    inviteUserButtonElement.waitUntilVisible();
    ElementFacade memberCard = findByXPathOrCSS(String.format("//*[contains(@class, 'userFullname') and contains(text(), '%s')]",
                                                              user));
    if (memberCard.isPresent()) {
      spaceHomePage.removeMember(user);
    }
    inviteUserButtonElement.click();
    inviteUserToSpace(user);
    inviteUserButtonDrawerElement().click();
  }

  public void checkAvatarSection() {
    avatarSectionElement().assertVisible();
  }

  public void checkCancelButton() {
    cancelButtonElement().assertVisible();
  }

  public void checkDescriptionSpaceSection() {
    ckEditorDescription().assertVisible();
  }

  public void checkFavIconInSpaceCard() {
    findByXPathOrCSS("//*[@id = 'spacesListBody']//*[contains(@class,'fa-star')]").assertVisible();
  }

  public void checkFavIconInSpacePopoverFromTopbar() {
    findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fa-star')]").assertVisible();
  }

  public void checkFavIconInThirdNavigationLevel() {
    findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fa-star')]").assertVisible();
  }

  public void checkGeneralSpaceSettings() {
    editIconOfGeneralSpaceSettingsElement().assertVisible();
  }

  public void checkHiddenAndSwitchButtonSection() {
    hiddenSectionElement().assertVisible();
    switchButtonElement().assertVisible();
  }

  public void checkNameSpaceSection() {
    nameSpaceSectionElement().assertVisible();
  }

  public void checkRegistrationSection() {
    registrationSectionElement().assertVisible();
  }

  public void checkSpaceBookmarkStatusFromSpaceCard(boolean shouldBeBookmarked) {
    if (shouldBeBookmarked) {
      findByXPathOrCSS("//*[@id = 'spacesListBody']//*[contains(@class,'fas fa-star')]").assertVisible();
    } else {
      findByXPathOrCSS("//*[@id = 'spacesListBody']//*[contains(@class,'far fa-star')]").assertVisible();
    }
  }

  public void checkSpaceBookmarkStatusFromThirdNavigationLevel(boolean shouldBeBookmarked) {
    if (shouldBeBookmarked) {
      findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fas fa-star')]").assertVisible();
    } else {
      findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'far fa-star')]").assertVisible();
    }
  }

  public void checkSpaceBookmarkStatusFromTopbarSpacePopover(boolean shouldBeBookmarked) {
    if (shouldBeBookmarked) {
      findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fas fa-star')]").assertVisible();
    } else {
      findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'far fa-star')]").assertVisible();
    }
  }

  public void checkSpaceRegistration(String registration) {
    switch (registration) {
    case "Open":
      // Select Open
      openRadioBtnElement().click();
      break;
    case "Validation":
      // Select Validation
      validationRadioBtnElement().click();
      break;
    case "Closed":
      // Select Closed
      closedRadioBtnElement().click();
      break;
    default:
      // Do nothing
      break;
    }
  }

  public void checkSpaceTemplateSection() {
    spaceTemplateSectionElement().assertVisible();
  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayed(String spaceName, String members) {
    spaceSearchDetailsAvatarElement(spaceName).assertVisible();
    spaceSearchDetailsInfoElement(spaceName).assertVisible();
    spaceThreeDotsButtonElement(spaceName).assertVisible();
    spaceSearchDetailsSpaceName(spaceName).assertVisible();
    spaceSearchDetailsSpaceMembers(members).assertVisible();
  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String spaceName, String members) {
    spaceSearchDetailsAvatarElement(spaceName).assertVisible();
    spaceSearchDetailsInfoElement(spaceName).assertVisible();
    spaceSearchDetailsSpaceName(spaceName).assertVisible();
    spaceSearchDetailsSpaceMembers(members).assertVisible();
  }

  public void checkThatSpaceInSearchResultsIsNotDisplayed(String spaceName) {
    spaceSearchDetailsSpaceName(spaceName).assertNotVisible();
  }

  public void checkThatSpaceTopBarElementsAreDisplayed() {
    spaceMenuItemElement().assertVisible();
  }

  public void saveSpace() {
    addSpaceButtonElement().click();
    waitForDrawerToClose();
    waitForLoading();
    assertThat(getCurrentUrl()).contains("/g/");
  }

  public void clickFirstProcessButton() {
    firstProcessButtonElement().click();
  }

  public void clickOnGeneralSpaceSettings() {
    editIconOfGeneralSpaceSettingsElement().click();
  }

  public void clickOnSpaceBookmarkIconFromSpaceCard() {
    findByXPathOrCSS("//*[@id = 'spacesListBody']//*[contains(@class,'fa-star')]").click();
  }

  public void clickOnSpaceBookmarkIconFromThirdNavigationLevel() {
    findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fa-star')]").click();
  }

  public void clickOnSpaceBookmarkIconFromTopbarSpacePopover() {
    findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fa-star')]").click();
  }

  public void clickSecondProcessButton() {
    secondProcessButtonElement().click();
  }

  public void clickSpaceAction(String action) {
    ElementFacade spaceFirstNavigationTab = getSpaceFirstNavigationTab();
    if (spaceFirstNavigationTab.isPresent()) {
      clickOnElement(spaceFirstNavigationTab);
    } else {
      ElementFacade spaceAction = getSpaceAction(action);
      if (spaceAction != null) {
        clickOnElement(spaceAction);
      }
    }
  }

  public boolean clickSpaceActionToJoin() {
    ElementFacade spaceAction = getSpaceAction("Join");
    if (spaceAction != null) {
      spaceAction.click();
      waitFor(50).milliseconds();
      verifyPageLoaded();
      return true;
    } else {
      spaceAction = getSpaceAction("Accept");
      if (spaceAction != null) {
        spaceAction.click();
        waitFor(50).milliseconds();
        verifyPageLoaded();
        return true;
      }
    }
    return false;
  }

  public void deleteSpace(String spaceName) {
    insertSpaceNameInSearchField(spaceName);
    getSpaceMenu(spaceName).click();
    getDeleteSpaceButton(spaceName).click();
    TextBoxElementFacade okButtonElement = okButtonElement();
    okButtonElement.click();
    okButtonElement.waitUntilNotVisible();
  }

  public void goToMembersTab() {
    spaceHomePage.goToSpecificTab("Members");
  }

  public void goToSettingsTab() {
    spaceHomePage.goToSpecificTab("Settings");
  }

  public void goToTasksTab() {
    spaceHomePage.goToSpecificTab("Tasks");
  }

  public void goToSpaceHomeViaSpaceAvatar() {
    spaceAvatarElement().click();
  }

  public void goToSpecificSpace(String spaceName) {
    getSpaceNameInListOfSpace(spaceName).click();
    waitForPageLoading();
  }

  public void hoverOnSpaceName() {
    spaceName().hover();
  }

  public void insertSpaceNameInSearchField(String spaceName) {
    openAdvancedSpacesFilterToolbar();
    TextBoxElementFacade searchSpaceInputElement = searchSpaceInputElement();
    searchSpaceInputElement.waitUntilVisible();
    searchSpaceInputElement.setTextValue(spaceName);
    waitFor(200).milliseconds();
    waitForProgressBar();
  }

  public void leaveSpace() {
    if (spaceLeaveButtonElement().isVisible()) {
      spaceLeaveButtonElement().click();
    } else {
      spaceThreeDotsButtonElement().click();
      spaceLeaveMenuItem().click();
    }
    waitFor(200).milliseconds(); // Wait for animation until the home icon changes its location
    clickToConfirmDialog();
    waitFor(200).milliseconds(); // Wait for animation until the home icon changes its location
  }

  public void inviteUserToSpace(String user) {
    mentionInField(inviteUserInputElement(), user, 5);
  }

  public boolean isLoadMoreButtonPresent() {
    return findByXPathOrCSS("#spacesListFooter .loadMoreButton").isPresent();
  }

  public boolean isSpaceCardDisplayed(String space, boolean mandatory) {
    try {
      ElementFacade webElementFacade =
                                     findByXPathOrCSS(String.format("//*[@id = 'spacesListBody']//*[contains(text(), '%s')]//ancestor::a[@href]",
                                                                    space));
      if (mandatory) {
        webElementFacade.checkVisible();
        return true;
      } else {
        return webElementFacade.isCurrentlyVisible();
      }
    } catch (RuntimeException e) {
      if (mandatory) {
        throw e;
      } else {
        return false;
      }
    }
  }

  public boolean isSpaceCardJoinButtonDisplayed(String space) {
    try {
      ElementFacade webElementFacade =
                                     findByXPathOrCSS(String.format("//*[@id = 'spacesListBody']//*[contains(text(), '%s')]//ancestor::a[@href]//*[contains(text(), 'Join')]//ancestor::button",
                                                                    space));
      return webElementFacade.isCurrentlyVisible();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpaceMenuDisplayed() {
    try {
      ElementFacade webElementFacade = findByXPathOrCSS("#topBarMenu .v-tab--active");
      return webElementFacade.isCurrentlyVisible();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpacePageOpened(String space) {
    return getSpaceElement(space).isVisible();
  }

  public void joinSpaceFromCard(String space) {
    ElementFacade webElementFacade =
                                   findByXPathOrCSS(String.format("//*[@id = 'spacesListBody']//*[contains(text(), '%s')]//ancestor::a[@href]//*[contains(text(), 'Join')]//ancestor::button",
                                                                  space));
    webElementFacade.click();
  }

  public void openSpaceFormDrawer() {
    if (applicationToolbarCollpseButton().isCurrentlyEnabled()) {
      applicationToolbarCollpseButton().click();
      waitFor(200).milliseconds();
    }
    addNewSpaceButtonElement().click();
    waitForDrawerToOpen();
  }

  public void selectFilter(String filter) {
    ElementFacade selectSpaceFilterElement = selectSpaceFilterElement();
    if (filter.equals("My spaces"))
      selectSpaceFilterElement.select().byValue("member");
    else
      selectSpaceFilterElement.select().byValue("all");
  }

  public String selectTemplate(int index) {
    ElementFacade spaceTemplateFilterElement = spaceTemplateFilterElement();
    spaceTemplateFilterElement.click();
    spaceTemplateFilterElement.selectByIndex(index);
    return spaceTemplateFilterElement.getSelectedValue();
  }

  public void setSpaceName(String spaceName) {
    spaceNameInputElement().setTextValue(spaceName);
  }

  public void setSpaceDescription(String spaceDescription) {
    waitForDrawerToOpen(OPENED_DRAWER_XPATH, false);
    waitCKEditorLoading(OPENED_DRAWER_XPATH);
    retryOnCondition(() -> {
      ElementFacade ckEditorFrameKudos = ckEditorDescription();
      ckEditorFrameKudos.waitUntilVisible();
      getDriver().switchTo().frame(ckEditorFrameKudos);
    }, () -> {
      getDriver().switchTo().defaultContent();
      waitFor(500).milliseconds(); // Kudos Iframe seems very slow
    });
    try {
      TextBoxElementFacade kudosFieldElement = ckEditorDescriptionElement();
      kudosFieldElement.waitUntilVisible();
      kudosFieldElement.setTextValue(spaceDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    getDriver().switchTo().defaultContent();
  }

  public void showMoreSpaces() {
    spacesPageElement().scrollDown();
    showMoreButtonElement().click();
  }

  public void spaceAvatarIsDisplayed() {
    spaceAvatarElement().assertVisible();
  }

  public void spaceNameIsDisplayed(String space) {
    spaceName(space).assertVisible();
  }

  public void uploadSpaceBanner(String fileName) {
    spaceBannerButton().click();
    uploadSpaceBannerButtonElement().click();
    ElementFacade fileInput = findByXPathOrCSS(".v-navigation-drawer--open input[type=file]");
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(fileInput);
    waitForProgressBar();
    ElementFacade imageApplyButton = findByXPathOrCSS("#imageCropDrawerApply");
    imageApplyButton.click();
    spaceBannerResetButton().assertVisible();
  }

  public void openSpaceInvitationDrawer() {
    inviteUserButton().click();
    findByXPathOrCSS("#InvitePlatformUserToSpaceButton").click();
    waitForDrawerToOpen();
  }

  public void openSpaceExternalInvitationDrawer() {
    inviteUserButton().click();
    findByXPathOrCSS("#InviteUserByEmailToSpaceButton").click();
    waitForDrawerToOpen();
  }

  public void inviteEmailAsSpaceMember(String email) {
    inviteEmailAsSpaceMemberInput().setTextValue(email);
    inviteEmailAsSpaceMemberInput().sendKeys(Keys.ENTER);
  }

  public void emailIsListedInInvitationList(String email, String status) {
    inviteEmailStatusElement(email, status).assertVisible();
  }

  public void emailIsNotListedInInvitationList(String email) {
    inviteEmailStatusElement(email).assertNotVisible();
  }
  
  public void openSpacePendingInvitationsDrawer() {
    findByXPathOrCSS("#SpacePendingUsersButton").click();
  }

  public void openSpaceExternalInvitationsTab() {
    findByXPathOrCSS("[tab-value='external']").click();
  }

  public void checkExternalInviteButtonNotDisplayed() {
    inviteUserButton().assertNotVisible();
    invitePlatformUserButton().assertVisible();
  }

  private ElementFacade applicationToolbarCollpseButton() {
    return findByXPathOrCSS("#applicationToolbarRight .fa-arrow-left");
  }

  private ElementFacade invitePlatformUserButton() {
    return findByXPathOrCSS("#spaceSettingUsersListToolbar");
  }

  private ElementFacade addNewSpaceButtonElement() {
    return findByXPathOrCSS("#spacesListApplication button#addNewSpaceButton");
  }

  private ElementFacade addSpaceButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private ElementFacade avatarSectionElement() {
    return findByXPathOrCSS("//*[@class='v-avatar spaceAvatar mx-auto mb-6 mt-2 rounded-0 spaceAvatarHoverEdit']");
  }

  private ElementFacade cancelButtonElement() {
    return findByXPathOrCSS("//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']");
  }

  private ElementFacade closedRadioBtnElement() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-radio')])[3]");
  }

  private ElementFacade editIconOfGeneralSpaceSettingsElement() {
    return findByXPathOrCSS("//*[contains(text(), 'General')]//ancestor::*[contains(@class, 'v-application')]//*[contains(@class, 'fa-edit')]");
  }

  private ElementFacade firstProcessButtonElement() {
    return findByXPathOrCSS("(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[1]");
  }

  private ElementFacade getDeleteSpaceButton(String spaceName) {
    return findByXPathOrCSS(String.format("//a[contains(@title,'%s')]//following::i[contains(@class,'uiIconTrash')]", spaceName));
  }

  private ElementFacade getSpaceAction(String action) {
    try {
      ElementFacade webElementFacade = findByXPathOrCSS(String.format("//*[@id = 'SpaceAccess']//button//*[contains(text(), '%s')]", action));
      return webElementFacade.isVisible() ? webElementFacade : null;
    } catch (RuntimeException e) {
      return null;
    }
  }

  public void openAdvancedSpacesFilterToolbar() {
    ButtonElementFacade spacesListFilterButton = spacesListFilterButton();
    if (spacesListFilterButton.isVisible()) {
      spacesListFilterButton.click();
      waitFor(200).milliseconds();
    }
  }

  public ButtonElementFacade spacesListFilterButton() {
    return findButtonByXPathOrCSS("#spacesListToolbar #applicationToolbarConeButton");
  }

  private ElementFacade getSpaceElement(String space) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'brandingContainer space')]//*[contains(text(),'%s')]", space));
  }

  private ElementFacade getSpaceFirstNavigationTab() {
    return findByXPathOrCSS("//*[contains(@class, 'spaceNavigationTab')]");
  }

  private ElementFacade getSpaceMenu(String spaceName) {
    return findByXPathOrCSS(String.format("//a[contains(@title,'%s')]/../..//button[contains(@class,'spaceMenuIcon')]",
                                          spaceName));
  }

  private ElementFacade getSpaceNameInListOfSpace(String spaceName) {
    return findByXPathOrCSS(String.format("//*[@id = 'spacesListBody']//*[contains(text(), '%s')]//ancestor::a[@href]", spaceName));
  }

  private ElementFacade hiddenSectionElement() {
    return findByXPathOrCSS("//*[@for='hidden']");
  }

  private ElementFacade inviteUserButtonDrawerElement() {
    return findByXPathOrCSS("//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']");
  }

  private ElementFacade inviteUserButton() {
    return findByXPathOrCSS("#InviteUserToSpaceButton");
  }

  private TextBoxElementFacade inviteUserInputElement() {
    return findTextBoxByXPathOrCSS("(//div[@name='inviteMembers']//input)[1]");
  }

  private TextBoxElementFacade inviteEmailAsSpaceMemberInput() {
    return findTextBoxByXPathOrCSS("#spaceEmailInvitationDrawer [contenteditable=true]");
  }

  private ElementFacade inviteEmailStatusElement(String email, String status) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'v-list-item')]//*[contains(text(), '%s')]",
                                          email,
                                          status));
  }

  private ElementFacade inviteEmailStatusElement(String email) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'v-list-item')]",
                                          email));
  }

  private ElementFacade nameSpaceSectionElement() {
    return findByXPathOrCSS("//*[@for='name']");
  }

  private TextBoxElementFacade okButtonElement() {
    return findTextBoxByXPathOrCSS("//button[contains(text(),'OK')]");
  }

  private ElementFacade openRadioBtnElement() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-radio')])[1]");
  }

  private ElementFacade registrationSectionElement() {
    return findByXPathOrCSS("//div[contains(@class,'v-input--selection-controls v-input--radio-group')]");
  }

  private TextBoxElementFacade searchSpaceInputElement() {
    return findTextBoxByXPathOrCSS("#spacesListToolbar #applicationToolbarFilterInput");
  }

  private ElementFacade secondProcessButtonElement() {
    return findByXPathOrCSS("(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[2]");
  }

  private ElementFacade selectSpaceFilterElement() {
    return findByXPathOrCSS("//select");
  }

  private ElementFacade showMoreButtonElement() {
    return findByXPathOrCSS("//*[@id='spacesListFooter']//button");
  }

  private ElementFacade spaceAvatarElement() {
    return findByXPathOrCSS("//*[@id='UserHomePortalLink']");
  }

  private TextBoxElementFacade spaceBannerButton() {
    return findTextBoxByXPathOrCSS("//*[@id='spaceBannerEditButton']");
  }

  private TextBoxElementFacade spaceBannerResetButton() {
    return findTextBoxByXPathOrCSS("//*[@id='spaceBannerDeleteButton']");
  }

  private ElementFacade spaceMembersTabElement() {
    return findByXPathOrCSS("(//a[contains(@href,'/members') and @tabindex='0'])");
  }

  private ElementFacade spaceMenuItemElement() {
    return findByXPathOrCSS("#topBarMenu .v-tabs-bar .v-tab");
  }

  private ElementFacade spaceName() {
    return findByXPathOrCSS("//*[contains(@class,'UITopBarContainerItem')]//*[contains(@class,'logoTitle')]");
  }

  private ElementFacade spaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'brandingContainer')]//div[contains(text(),'%s')]", spaceName));
  }

  private TextBoxElementFacade spaceNameInputElement() {
    return findTextBoxByXPathOrCSS("//*[@name='name']");
  }

  private TextBoxElementFacade spaceSearchDetailsAvatarElement(String spaceName) {
    return findTextBoxByXPathOrCSS(String.format("//*[@id = 'spacesListBody']//*[contains(text(), '%s')]//ancestor::a[@href]//img[contains(@src,'/avatar')]",
                                                 spaceName));
  }

  private TextBoxElementFacade spaceSearchDetailsInfoElement(String spaceName) {
    return findTextBoxByXPathOrCSS(String.format("//*[@id = 'spacesListBody']//*[contains(text(), '%s')]//ancestor::a[@href]//*[contains(text(),'Members')]",
                                                 spaceName));
  }

  private TextBoxElementFacade spaceLeaveButtonElement() {
    return findTextBoxByXPathOrCSS("//*[@id = 'spacesListBody']//*[contains(text(), '%s')]//ancestor::a[@href]//*[contains(text(),'Leave')]");
  }

  private TextBoxElementFacade spaceLeaveMenuItem() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'sign-out')]");
  }

  private TextBoxElementFacade spaceThreeDotsButtonElement(String spaceName) {
    return findTextBoxByXPathOrCSS(String.format("//*[@id = 'spacesListBody']//*[contains(text(), '%s')]//ancestor::a[@href]//*[contains(@class,'fa-ellipsis-v')]", spaceName));
  }

  private TextBoxElementFacade spaceThreeDotsButtonElement() {
    return findTextBoxByXPathOrCSS("//*[@id = 'spacesListBody']//a[@href]//*[contains(@class,'fa-ellipsis-v')]");
  }

  private ElementFacade spaceSearchDetailsSpaceMembers(String members) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceMembersLabel') and contains(text(),'%s')]", members));
  }

  private ElementFacade spaceSearchDetailsSpaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceCardBody')]//a[contains(text(),'%s')]", spaceName));
  }

  private ElementFacade spacesPageElement() {
    return findByXPathOrCSS("//*[@id='UISiteBody']");
  }

  private ElementFacade spaceTemplateFilterElement() {
    return findByXPathOrCSS("//select[contains(@class,'input-block-level ignore-vuetify-classes my-3')]");
  }

  private ElementFacade spaceTemplateSectionElement() {
    return findByXPathOrCSS("//*[@for='spaceTemplate']");
  }

  private ElementFacade switchButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'drawerContent ')]//input[contains(@id,'input') and @type='checkbox']");
  }

  private TextBoxElementFacade uploadSpaceBannerButtonElement() {
    return findTextBoxByXPathOrCSS("#spaceBannerEditButton");
  }

  private ElementFacade validationRadioBtnElement() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-radio')])[2]");
  }

  private ElementFacade ckEditorDescription() {
    return findByXPathOrCSS(OPENED_DRAWER_XPATH + "//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private TextBoxElementFacade ckEditorDescriptionElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable')]");
  }

}
