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

import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ButtonElementFacade;
import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class ManageSpacesPage extends GenericPage {
  private static final String SPACE_SETTING_APPLICATION_CARD_TEMPLATE = "(//*[contains(@class, 'SpaceApplicationCard')][1]/parent::*[1])[1]/*[contains(@class, 'SpaceApplicationCard')][%s]";
  private SpaceHomePage spaceHomePage;

  public ManageSpacesPage(WebDriver driver) {
    super(driver);
  }

  public void addUserToSpace(String user) {
    spaceMembersTabElement().click();
    ElementFacade inviteUserButtonElement = inviteUserButtonElement();
    inviteUserButtonElement.waitUntilVisible();
    ElementFacade memberCard =
                             findByXPathOrCSS(String.format("//*[contains(@class, 'userFullname') and contains(text(), '%s')]",
                                                            user));
    if (memberCard.isPresent()) {
      spaceHomePage.removeMember(user);
    }
    inviteUserButtonElement.click();
    inviteUserToSpace(user);
    inviteUserButtonDrawerElement().click();
  }

  public void appCardIsDisplayed() {
    appCardElement().assertVisible();
  }

  public void checkApplicationsAreDisplayed() {
    addAppButtonElement().assertVisible();
  }

  public void checkApplicationsSpaceSettings() {
    arrowIconOfApplicationsSpaceSettingsElement().assertVisible();
  }

  public void checkAvatarSection() {
    avatarSectionElement().assertVisible();
  }

  public void checkCancelButton() {
    cancelButtonElement().assertVisible();
  }

  public void checkDescriptionSpaceSection() {
    descriptionSpaceSectionElement().assertVisible();
  }

  public void checkDisplayOfOtherSpaces() {
    spaceCardN21Element().assertVisible();
  }

  public void checkDisplayOfTwentySpaces() {
    spaceCardN20Element().assertVisible();
    spaceCardN21Element().assertNotVisible();
  }

  public void checkFavIconInSpaceCard() {
    findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'fa-star')]").assertVisible();
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

  public void checkOptionFromApplicationMenuIsDisplayed(String appName, String option) {
    getOptionFromApplicationMenu(appName, option).assertVisible();
  }

  public void checkRegistrationSection() {
    registrationSectionElement().assertVisible();
  }

  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    spaceAppInstallerDrawerElement().click();
  }

  public void checkSpaceBookmarkStatusFromSpaceCard(boolean shouldBeBookmarked) {
    if (shouldBeBookmarked) {
      findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'fas fa-star')]").assertVisible();
    } else {
      findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'far fa-star')]").assertVisible();
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

  public void checkThatAppIsAdded(String application) {
    getAppCardNameDisplayed(application).assertVisible();
  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayed(String spaceName, String members) {
    spaceSearchDetailsCoverElement().assertVisible();
    spaceSearchDetailsAvatarElement().assertVisible();
    spaceSearchDetailsInfoElement().assertVisible();
    spaceSearchDetailsThreeDotsElement().assertVisible();
    spaceSearchDetailsLeaveButtonElement().assertVisible();
    spaceSearchDetailsSpaceName(spaceName).assertVisible();
    spaceSearchDetailsSpaceMembers(members).assertVisible();

  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String spaceName, String members) {
    spaceSearchDetailsCoverElement().assertVisible();
    spaceSearchDetailsAvatarElement().assertVisible();
    spaceSearchDetailsInfoElement().assertVisible();
    spaceSearchDetailsLeaveButtonElement().assertVisible();
    spaceSearchDetailsSpaceName(spaceName).assertVisible();
    spaceSearchDetailsSpaceMembers(members).assertVisible();

  }

  public void checkThatSpaceInSearchResultsIsNotDisplayed(String spaceName) {
    spaceSearchDetailsSpaceName(spaceName).assertNotVisible();
  }

  public void checkThatSpaceTabsAreDisplayedInOrder(String space) {
    // Top Bar Tabs after Space Creation are displayed in order
    Assert.assertTrue(spaceMenuItemByOrderElement("1").getAttribute("href")
                                                      .contains(homeSpaceMenuItemElement(space.toLowerCase()).getAttribute("href")));

    Assert.assertTrue(spaceMenuItemByOrderElement("2").getAttribute("href")
                                                      .contains(spaceMembersMenuItemElement(space.toLowerCase()).getAttribute("href")));
  }

  public void checkThatSpaceTopBarElementsAreDisplayed() {
    spaceMenuItemElement().assertVisible();
  }

  public void checkUpdateButton() {
    spaceAppInstallerDrawerElement().assertVisible();
  }

  public void clickAddSpaceButton() {
    addSpaceButtonElement().click();
  }

  public void clickFirstProcessButton() {
    firstProcessButtonElement().click();
  }

  public void clickOn3dotsAppCard() {
    button3dotAppCardElement().click();
  }

  public void clickOnArrowIconAppSpaceSettings() {
    arrowIconAppSpaceSettingsElement().click();
  }

  public void clickOnGeneralSpaceSettings() {
    editIconOfGeneralSpaceSettingsElement().click();
  }

  public void clickOnPlusButton() {
    plusButtonAppSpaceSettingsElement().click();
  }

  public void clickOnSpaceBookmarkIconFromSpaceCard() {
    findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'fa-star')]").click();
  }

  public void clickOnSpaceBookmarkIconFromThirdNavigationLevel() {
    findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fa-star')]").click();
  }

  public void clickOnSpaceBookmarkIconFromTopbarSpacePopover() {
    findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fa-star')]").click();
  }

  public void clickOnThreeDotsAppCard(String appName) {
    getApplicationThreeDotsMenu(appName).click();
  }

  public void clickOptionApplicationCard(String appName, String option) {
    getOptionFromApplicationMenu(appName, option).click();
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
      if (spaceAction != null && spaceAction.isVisible()) {
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

  public void clickToAddApp(String application) {
    getAppCardNameDrawer(application).click();
  }

  public void confirmRemoveApplication() {
    removeConfirmationButtonElement().click();
  }

  public void deleteSpace(String spaceName) {
    searchSpaceInputElement().setTextValue(spaceName);
    getSpaceMenu(spaceName).click();
    getDeleteSpaceButton(spaceName).click();
    TextBoxElementFacade okButtonElement = okButtonElement();
    okButtonElement.click();
    okButtonElement.waitUntilNotVisible();
  }

  public void goToMembersTab() {
    ElementFacade spaceMembersTabElement = spaceMembersTabElement();
    if (spaceMembersTabElement.isNotVisible()) {
      goToSpaceRightTabsElement().click();
    }
    spaceMembersTabElement.click();
  }

  public void goToSettingsTab() {
    ElementFacade spaceSettingsTabElement = spaceSettingsTabElement();
    if (!spaceSettingsTabElement.isCurrentlyVisible()) {
      goToSpaceRightTabsElement().click();
    }
    spaceSettingsTabElement.click();
  }

  public void goToSpaceHomeViaSpaceAvatar() {
    spaceAvatarElement().click();
  }

  public void goToSpecificSpace(String spaceName) {
    getSpaceNameInListOfSpace(spaceName).click();
    waitForPageLoading();
  }

  public void goToTasksTab() {
    spaceTasksTabElement().click();
  }

  public void hoverOnSpaceName() {
    spaceName().hover();
  }

  public void insertSpaceNameInSearchField(String spaceName) {
    TextBoxElementFacade searchSpaceInputElement = searchSpaceInputElement();
    searchSpaceInputElement.waitUntilVisible();
    searchSpaceInputElement.setTextValue(spaceName);
    waitForProgressBar();
  }

  public void inviteUserToSpace(String user) {
    mentionInField(inviteUserInputElement(), user, 5);
  }

  public boolean isLoadMoreButtonDisplayed() {
    return findByXPathOrCSS("#spacesListFooter .loadMoreButton").isCurrentlyVisible();
  }

  public void isSpaceBannerUpdated() {
    spaceBannerUpdatedElement().assertVisible();
  }

  public boolean isSpaceCardDisplayed(String space) {
    try {
      ElementFacade webElementFacade =
                                     findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]",
                                                                    space.toLowerCase()));
      return webElementFacade.isCurrentlyVisible();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpaceCardJoinButtonDisplayed(String space) {
    try {
      ElementFacade webElementFacade =
                                     findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]//ancestor::*[contains(@class, 'spaceCardItem')]//*[contains(text(), 'Join')]//ancestor::button",
                                                                    space.toLowerCase()));
      return webElementFacade.isCurrentlyVisible();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpaceMenuDisplayed() {
    try {
      ElementFacade webElementFacade = findByXPathOrCSS("#SpaceMenu .v-tab--active");
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
                                   findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]//ancestor::*[contains(@class, 'spaceCardItem')]//*[contains(text(), 'Join')]//ancestor::button",
                                                                  space.toLowerCase()));
    webElementFacade.click();
  }

  public void moveAfterAppButtonIsDisplayed() {
    moveAfterAppButtonElement().assertVisible();
  }

  public void moveBeforeAppButtonIsDisplayed() {
    moveBeforeAppButtonElement().assertVisible();
  }

  public void openSpaceFormDrawer() {
    addNewSpaceButtonElement().click();
  }

  public void plusButtonIsDisplayed() {
    plusButtonAppSpaceSettingsElement().assertVisible();
  }

  public void removeAppButtonIsDisplayed() {
    removeAppButtonElement().assertVisible();
  }

  public void selectFilter(String filter) {
    ElementFacade selectSpaceFilterElement = selectSpaceFilterElement();
    if (filter.equals("My spaces"))
      selectSpaceFilterElement.select().byValue("member");
    else
      selectSpaceFilterElement.select().byValue("all");
  }

  public void selectTemplate(int index) {
    ElementFacade spaceTemplateFilterElement = spaceTemplateFilterElement();
    spaceTemplateFilterElement.click();
    spaceTemplateFilterElement.selectByIndex(index);
  }

  public void setSpaceName(String spaceName) {
    spaceNameInputElement().setTextValue(spaceName);
  }

  public void setSpaceDescription(String spaceDescription) {
    descriptionSpaceSectionElement().setTextValue(spaceDescription);
  }

  public void showMoreSpaces() {
    spacesPageElement().scrollDown();
    showMoreButtonElement().click();
  }

  public void spaceAppSettingsIsOpened() {
    spaceAppSettingsPageElement().assertVisible();
  }

  public void spaceAvatarIsDisplayed() {
    spaceAvatarElement().assertVisible();
  }

  public void spaceNameIsDisplayed(String space) {
    spaceName(space).assertVisible();
  }

  public void uploadSpaceBanner(String fileName) {
    spaceBannerElement().click();
    uploadSpaceBannerButtonElement().click();
    waitForDrawerToOpen();
    ElementFacade fileInput = findByXPathOrCSS(".v-navigation-drawer--open input[type=file]");
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(fileInput);
    waitForProgressBar();
    ElementFacade imageApplyButton = findByXPathOrCSS("#imageCropDrawerApply");
    imageApplyButton.click();
    waitForDrawerToClose();
  }

  public String moveApplicationAfter(int appPosition) {
    return moveApplication(appPosition, "Move after");
  }

  public String moveApplicationBefore(int appPosition) {
    return moveApplication(appPosition, "Move before");
  }

  private String moveApplication(int appPosition, String actionName) {
    String appTitle = spaceSettingAppTitle(appPosition).getText();
    spaceSettingAppMenu(appPosition).click();
    spaceSettingAppMenuItem(appPosition, actionName).click();
    return appTitle;
  }

  private ButtonElementFacade spaceSettingAppTitle(int appPosition) {
    return findButtonByXPathOrCSS(String.format(SPACE_SETTING_APPLICATION_CARD_TEMPLATE + "//*[contains(@class, 'SpaceApplicationCardTitle')]", appPosition));
  }

  private ButtonElementFacade spaceSettingAppMenu(int appPosition) {
    return findButtonByXPathOrCSS(String.format(SPACE_SETTING_APPLICATION_CARD_TEMPLATE + "//*[contains(@class, 'SpaceApplicationCardAction')]//button", appPosition));
  }

  private ButtonElementFacade spaceSettingAppMenuItem(int appPosition, String actionName) {
    return findButtonByXPathOrCSS(String.format(SPACE_SETTING_APPLICATION_CARD_TEMPLATE + "//*[contains(@class, 'menuable__content__active')]//*[contains(text(), '%s')]", appPosition, actionName));
  }

  private ElementFacade addAppButtonElement() {
    return findByXPathOrCSS("(//*[@class='d-flex flex-no-wrap']//i[@class='v-icon notranslate mdi mdi-plus theme--light'])[1]");
  }

  private ElementFacade addNewSpaceButtonElement() {
    return findByXPathOrCSS("#spacesListApplication button#addNewSpaceButton");
  }

  private ElementFacade addSpaceButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private ElementFacade appCardElement() {
    return findByXPathOrCSS("//*[@class='SpaceApplicationCard my-1 mx-auto mx-sm-1 col']");
  }

  private ElementFacade arrowIconAppSpaceSettingsElement() {
    return findByXPathOrCSS("//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']");
  }

  private ElementFacade arrowIconOfApplicationsSpaceSettingsElement() {
    return findByXPathOrCSS("//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']");
  }

  private ElementFacade avatarSectionElement() {
    return findByXPathOrCSS("//*[@class='v-avatar spaceAvatar mx-auto mb-6 mt-2 rounded-0 spaceAvatarHoverEdit']");
  }

  private ElementFacade button3dotAppCardElement() {
    return findByXPathOrCSS("(//*[@class='v-icon notranslate mdi mdi-dots-vertical theme--light'])[2]");
  }

  private ElementFacade cancelButtonElement() {
    return findByXPathOrCSS("//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']");
  }

  private ElementFacade closedRadioBtnElement() {
    return findByXPathOrCSS("//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Closed')]");
  }

  private TextBoxElementFacade descriptionSpaceSectionElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//textarea[@name='description']");
  }

  private ElementFacade editIconOfGeneralSpaceSettingsElement() {
    return findByXPathOrCSS("//i[@class='uiIconEdit uiIconLightBlue pb-2']");
  }

  private ElementFacade firstProcessButtonElement() {
    return findByXPathOrCSS("(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[1]");
  }

  private ElementFacade getAppCardNameDisplayed(String application) {
    return findByXPathOrCSS(String.format("//*[contains(@title,'%s') and @class='text-truncate subtitle-1 px-1 pt-4 text-color SpaceApplicationCardTitle']",
                                          application));
  }

  private ElementFacade getAppCardNameDrawer(String application) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'d-flex')]//ancestor::*[@class='SpaceApplicationCardAction']",
                                          application));
  }

  private ElementFacade getApplicationThreeDotsMenu(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@Class,'SpaceApplicationCard')]//*[contains(@Class, 'mdi-dots-vertical')]//ancestor::button",
                                          appName));
  }

  private ElementFacade getDeleteSpaceButton(String spaceName) {
    return findByXPathOrCSS(String.format("//a[contains(@title,'%s')]//following::i[contains(@class,'uiIconTrash')]", spaceName));
  }

  private ElementFacade getOptionFromApplicationMenu(String appName, String option) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'SpaceApplicationCard')]//ancestor::*[contains(@class,'v-list--dense')]//*[contains(text(),'%s')]",
                                          appName,
                                          option));
  }

  private ElementFacade getSpaceAction(String action) {
    try {
      ElementFacade webElementFacade = findByXPathOrCSS(String.format("//a[@title='%s']", action));
      return webElementFacade.isCurrentlyVisible() ? webElementFacade : null;
    } catch (RuntimeException e) {
      return null;
    }
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
    return findByXPathOrCSS(String.format("//a[@title = '%s']", spaceName));
  }

  private ElementFacade goToSpaceRightTabsElement() {
    return findByXPathOrCSS("//i[contains(@class,'mdi-chevron-right')]");
  }

  private ElementFacade hiddenSectionElement() {
    return findByXPathOrCSS("//*[@for='hidden']");
  }

  private ElementFacade homeSpaceMenuItemElement(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s')][1]", space));
  }

  private ElementFacade inviteUserButtonDrawerElement() {
    return findByXPathOrCSS("//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']");
  }

  private ElementFacade inviteUserButtonElement() {
    return findByXPathOrCSS("//*[@class='uiIconInviteUser ms-2 me-1']");
  }

  private TextBoxElementFacade inviteUserInputElement() {
    return findTextBoxByXPathOrCSS("(//div[@name='inviteMembers']//input)[1]");
  }

  private ElementFacade moveAfterAppButtonElement() {
    return findByXPathOrCSS("(//div[contains(text(), 'Move after')])[2]");
  }

  private ElementFacade moveBeforeAppButtonElement() {
    return findByXPathOrCSS("//div[contains(text(), 'Move before')]");
  }

  private ElementFacade nameSpaceSectionElement() {
    return findByXPathOrCSS("//*[@for='name']");
  }

  private TextBoxElementFacade okButtonElement() {
    return findTextBoxByXPathOrCSS("//button[contains(text(),'OK')]");
  }

  private ElementFacade openRadioBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//input[@value='open']//ancestor::*[contains(@class,'v-radio')]");
  }

  private ElementFacade plusButtonAppSpaceSettingsElement() {
    return findByXPathOrCSS("//*[@class='v-icon notranslate mdi mdi-plus theme--light']");
  }

  private ElementFacade registrationSectionElement() {
    return findByXPathOrCSS("//div[contains(@class,'v-input--selection-controls v-input--radio-group')]");
  }

  private ElementFacade removeAppButtonElement() {
    return findByXPathOrCSS("(//div[contains(text(), 'Remove')])[2]");
  }

  private ElementFacade removeConfirmationButtonElement() {
    return findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//button[contains(@class, 'btn-primary')]");
  }

  private TextBoxElementFacade searchSpaceInputElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'inputSpacesFilter')]//input");
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

  private ElementFacade spaceAppInstallerDrawerElement() {
    return findByXPathOrCSS("//div[@class='v-list-item__content drawerTitle align-start text-header-title text-truncate']");
  }

  private ElementFacade spaceAppSettingsPageElement() {
    return findByXPathOrCSS("//*[@class='v-toolbar__title ps-0']");
  }

  private ElementFacade spaceAvatarElement() {
    return findByXPathOrCSS("//*[@id='UserHomePortalLink']");
  }

  private TextBoxElementFacade spaceBannerElement() {
    return findTextBoxByXPathOrCSS("//*[@id='spaceAvatarImg']");
  }

  private TextBoxElementFacade spaceBannerUpdatedElement() {
    return findTextBoxByXPathOrCSS("//*[@id='SpaceHeader']//*[@class='v-responsive__content']");
  }

  private ElementFacade spaceCardN20Element() {
    return findByXPathOrCSS("(//*[contains(@class, 'spaceCardFlip')])[20]");
  }

  private ElementFacade spaceCardN21Element() {
    return findByXPathOrCSS("(//*[contains(@class, 'spaceCardFlip')])[21]");
  }

  private ElementFacade spaceMembersMenuItemElement(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s/members')]", space));
  }

  private ElementFacade spaceMembersTabElement() {
    return findByXPathOrCSS("(//a[contains(@href,'/members') and @tabindex='0'])");
  }

  private ElementFacade spaceMenuItemByOrderElement(String order) {
    return findByXPathOrCSS(String.format("//*[@class='v-application--wrap']//*[@class='v-slide-group__wrapper']//*[@tabindex][%s]",
                                          order));
  }

  private ElementFacade spaceMenuItemElement() {
    return findByXPathOrCSS("#SpaceMenu .v-tabs-bar .v-tab");
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

  private TextBoxElementFacade spaceSearchDetailsAvatarElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='spaceCardFront']//*[@class='v-responsive__content'])[2]");
  }

  private TextBoxElementFacade spaceSearchDetailsCoverElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='spaceCardFront']//*[@class='v-image__image v-image__image--cover'])[1]");
  }

  private TextBoxElementFacade spaceSearchDetailsInfoElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'spaceToolbarIcons')]//*[contains(@class,'spaceInfoIcon')]");
  }

  private TextBoxElementFacade spaceSearchDetailsLeaveButtonElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'spaceMembershipButtonText') and contains(text(),'Leave')]");
  }

  private ElementFacade spaceSearchDetailsSpaceMembers(String members) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceMembersLabel') and contains(text(),'%s')]", members));
  }

  private ElementFacade spaceSearchDetailsSpaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceCardBody')]//a[contains(text(),'%s')]", spaceName));
  }

  private TextBoxElementFacade spaceSearchDetailsThreeDotsElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'spaceToolbarIcons')]//button[contains(@class,'spaceMenuIcon')]");
  }

  private ElementFacade spaceSettingsTabElement() {
    return findByXPathOrCSS("//*[@id='UITopBarContainerParent']//*[contains(@class, 'spaceMenuParent')]//a[contains(@href,'/settings')]");
  }

  private ElementFacade spacesPageElement() {
    return findByXPathOrCSS("//*[@id='UISiteBody']");
  }

  private ElementFacade spaceTasksTabElement() {
    return findByXPathOrCSS("(//a[contains(@href,'/tasks')])");
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
    return findByXPathOrCSS("//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Validation')]");
  }

}
