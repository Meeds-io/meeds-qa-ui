package io.meeds.qa.ui.pages.page.factory.space;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class ManageSpacesPage extends GenericPage {
  private SpaceHomePage spaceHomePage;

  public ManageSpacesPage(WebDriver driver) {
    super(driver);
  }

  public void addUserToSpace(String user) {
    spaceMembersTabElement().clickOnElement();
    ElementFacade inviteUserButtonElement = inviteUserButtonElement();
    inviteUserButtonElement.waitUntilVisible();
    ElementFacade memberCard =
                             findByXPathOrCSS(String.format("//*[contains(@class, 'userFullname') and contains(text(), '%s')]",
                                                            user));
    if (memberCard.isPresent()) {
      spaceHomePage.removeMember(user);
    }
    inviteUserButtonElement.clickOnElement();
    inviteUserToSpace(user);
    inviteUserButtonDrawerElement().clickOnElement();
  }

  public void appCardIsDisplayed() {
    assertWebElementVisible(appCardElement());
  }

  public void checkApplicationsAreDisplayed() {
    assertWebElementVisible(addAppButtonElement());
  }

  public void checkApplicationsSpaceSettings() {
    assertWebElementVisible(arrowIconOfApplicationsSpaceSettingsElement());
  }

  public void checkAvatarSection() {
    assertWebElementVisible(avatarSectionElement());
  }

  public void checkCancelButton() {
    assertWebElementVisible(cancelButtonElement());
  }

  public void checkDescriptionSpaceSection() {
    assertWebElementVisible(descriptionSpaceSectionElement());
  }

  public void checkDisplayOfOtherSpaces() {
    assertWebElementVisible(spaceCardN21Element());
  }

  public void checkDisplayOfTwentySpaces() {
    assertWebElementVisible(spaceCardN20Element());
    assertWebElementNotVisible(spaceCardN21Element());
  }

  public void checkFavIconInSpaceCard() {
    assertWebElementVisible(findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'fa-star')]"));
  }

  public void checkFavIconInSpacePopoverFromTopbar() {
    assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fa-star')]"));
  }

  public void checkFavIconInThirdNavigationLevel() {
    assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fa-star')]"));
  }

  public void checkGeneralSpaceSettings() {
    assertWebElementVisible(editIconOfGeneralSpaceSettingsElement());
  }

  public void checkHiddenAndSwitchButtonSection() {
    assertWebElementVisible(hiddenSectionElement());
    assertWebElementVisible(switchButtonElement());
  }

  public void checkNameSpaceSection() {
    assertWebElementVisible(nameSpaceSectionElement());
  }

  public void checkOptionFromApplicationMenuIsDisplayed(String appName, String option) {
    assertWebElementVisible(getOptionFromApplicationMenu(appName, option));
  }

  public void checkRegistrationSection() {
    assertWebElementVisible(registrationSectionElement());
  }

  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    spaceAppInstallerDrawerElement().clickOnElement();
  }

  public void checkSpaceBookmarkStatusFromSpaceCard(boolean shouldBeBookmarked) {
    if (shouldBeBookmarked) {
      assertWebElementVisible(findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'fas fa-star')]"));
    } else {
      assertWebElementVisible(findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'far fa-star')]"));
    }
  }

  public void checkSpaceBookmarkStatusFromThirdNavigationLevel(boolean shouldBeBookmarked) {
    if (shouldBeBookmarked) {
      assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fas fa-star')]"));
    } else {
      assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'far fa-star')]"));
    }
  }

  public void checkSpaceBookmarkStatusFromTopbarSpacePopover(boolean shouldBeBookmarked) {
    if (shouldBeBookmarked) {
      assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fas fa-star')]"));
    } else {
      assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'far fa-star')]"));
    }
  }

  public void checkSpaceRegistration(String registration) {
    switch (registration) {
    case "Open":
      // Select Open
      openRadioBtnElement().clickOnElement();
      break;
    case "Validation":
      // Select Validation
      validationRadioBtnElement().clickOnElement();
      break;
    case "Closed":
      // Select Closed
      closedRadioBtnElement().clickOnElement();
      break;
    default:
      // Do nothing
      break;
    }
  }

  public void checkSpaceTemplateSection() {
    assertWebElementVisible(spaceTemplateSectionElement());
  }

  public void checkThatAppIsAdded(String application) {
    assertWebElementVisible(getAppCardNameDisplayed(application));
  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayed(String spaceName, String members) {
    assertWebElementVisible(spaceSearchDetailsCoverElement());
    assertWebElementVisible(spaceSearchDetailsAvatarElement());
    assertWebElementVisible(spaceSearchDetailsInfoElement());
    assertWebElementVisible(spaceSearchDetailsThreeDotsElement());
    assertWebElementVisible(spaceSearchDetailsLeaveButtonElement());
    assertWebElementVisible(spaceSearchDetailsSpaceName(spaceName));
    assertWebElementVisible(spaceSearchDetailsSpaceMembers(members));

  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String spaceName, String members) {
    assertWebElementVisible(spaceSearchDetailsCoverElement());
    assertWebElementVisible(spaceSearchDetailsAvatarElement());
    assertWebElementVisible(spaceSearchDetailsInfoElement());
    assertWebElementVisible(spaceSearchDetailsLeaveButtonElement());
    assertWebElementVisible(spaceSearchDetailsSpaceName(spaceName));
    assertWebElementVisible(spaceSearchDetailsSpaceMembers(members));

  }

  public void checkThatSpaceInSearchResultsIsNotDisplayed(String spaceName) {
    assertWebElementNotVisible(spaceSearchDetailsSpaceName(spaceName));
  }

  public void checkThatSpaceTabsAreDisplayedInOrder(String space) {
    // Top Bar Tabs after Space Creation are displayed in order
    Assert.assertTrue(spaceMenuItemByOrderElement("1").getAttribute("href")
                                                      .contains(homeSpaceMenuItemElement(space.toLowerCase()).getAttribute("href")));

    Assert.assertTrue(spaceMenuItemByOrderElement("2").getAttribute("href")
                                                      .contains(spaceMembersMenuItemElement(space.toLowerCase()).getAttribute("href")));
  }

  public void checkThatSpaceTopBarElementsAreDisplayed() {
    assertWebElementVisible(addNewSpaceButtonElement());
    ElementFacade showingSpacesSectionElement = showingSpacesSectionElement();
    assertTrue(showingSpacesSectionElement.getText().contains("Showing"));
    assertTrue(showingSpacesSectionElement.getText().contains("spaces"));
    assertWebElementVisible(spacesFilterIconElement());
    assertWebElementVisible(spacesFilterTextElement());
    ElementFacade dropDownListSpacesElement = dropDownListSpacesElement();
    assertWebElementVisible(dropDownListSpacesElement);
    assertTrue(dropDownListSpacesElement.getText().contains("All spaces"));
  }

  public void checkUpdateButton() {
    assertWebElementVisible(spaceAppInstallerDrawerElement());
  }

  public void clickAddSpaceButton() {
    addSpaceButtonElement().clickOnElement();
  }

  public void clickFirstProcessButton() {
    firstProcessButtonElement().clickOnElement();
  }

  public void clickOn3dotsAppCard() {
    button3dotAppCardElement().clickOnElement();
  }

  public void clickOnArrowIconAppSpaceSettings() {
    arrowIconAppSpaceSettingsElement().clickOnElement();
  }

  public void clickOnGeneralSpaceSettings() {
    editIconOfGeneralSpaceSettingsElement().clickOnElement();
  }

  public void clickOnPlusButton() {
    plusButtonAppSpaceSettingsElement().clickOnElement();
  }

  public void clickOnSpaceBookmarkIconFromSpaceCard() {
    findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'fa-star')]").clickOnElement();
  }

  public void clickOnSpaceBookmarkIconFromThirdNavigationLevel() {
    findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fa-star')]").clickOnElement();
  }

  public void clickOnSpaceBookmarkIconFromTopbarSpacePopover() {
    findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fa-star')]").clickOnElement();
  }

  public void clickOnThreeDotsAppCard(String appName) {
    getApplicationThreeDotsMenu(appName).clickOnElement();
  }

  public void clickOptionApplicationCard(String appName, String option) {
    getOptionFromApplicationMenu(appName, option).clickOnElement();
  }

  public void clickSecondProcessButton() {
    secondProcessButtonElement().clickOnElement();
  }

  public void clickSpaceAction(String action) {
    ElementFacade spaceFirstNavigationTab = getSpaceFirstNavigationTab();
    if (spaceFirstNavigationTab.isPresent()) {
      clickOnElement(spaceFirstNavigationTab);
    } else {
      ElementFacade spaceAction = getSpaceAction(action);
      if (spaceAction != null && spaceAction.isVisibleAfterWaiting()) {
        clickOnElement(spaceAction);
      }
    }
  }

  public boolean clickSpaceActionToJoin() {
    ElementFacade spaceAction = getSpaceAction("Join");
    if (spaceAction != null) {
      clickOnElement(spaceAction);
      return true;
    } else {
      spaceAction = getSpaceAction("Accept");
      if (spaceAction != null) {
        clickOnElement(spaceAction);
        return true;
      }
    }
    return false;
  }

  public void clickToAddApp(String application) {
    getAppCardNameDrawer(application).clickOnElement();
  }

  public void confirmRemoveApplication() {
    removeConfirmationButtonElement().clickOnElement();
  }

  public void deleteSpace(String spaceName) {
    searchSpaceInputElement().setTextValue(spaceName);
    getSpaceMenu(spaceName).clickOnElement();
    getDeleteSpaceButton(spaceName).clickOnElement();
    TextBoxElementFacade okButtonElement = okButtonElement();
    okButtonElement.clickOnElement();
    okButtonElement.waitUntilNotVisible();
  }

  public void goToMembersTab() {
    ElementFacade spaceMembersTabElement = spaceMembersTabElement();
    if (spaceMembersTabElement.isNotVisibleAfterWaiting()) {
      goToSpaceRightTabsElement().clickOnElement();
    }
    spaceMembersTabElement.clickOnElement();
  }

  public void goToSettingsTab() {
    ElementFacade spaceSettingsTabElement = spaceSettingsTabElement();
    if (!spaceSettingsTabElement.isDisplayedNoWait()) {
      goToSpaceRightTabsElement().clickOnElement();
    }
    spaceSettingsTabElement.clickOnElement();
  }

  public void goToSpaceHomeViaSpaceAvatar() {
    spaceAvatarElement().clickOnElement();
  }

  public void goToSpecificSpace(String spaceName) {
    getSpaceNameInListOfSpace(spaceName).clickOnElement();
    verifyPageLoaded();
  }

  public void goToTasksTab() {
    spaceTasksTabElement().clickOnElement();
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
    assertWebElementVisible(spaceBannerUpdatedElement());
  }

  public boolean isSpaceCardDisplayed(String space) {
    try {
      ElementFacade webElementFacade =
                                     findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]",
                                                                    space.toLowerCase()));
      return webElementFacade.isDisplayedNoWait();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpaceCardJoinButtonDisplayed(String space) {
    try {
      ElementFacade webElementFacade =
                                     findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]//ancestor::*[contains(@class, 'spaceCardItem')]//*[contains(text(), 'Join')]//ancestor::button",
                                                                    space.toLowerCase()));
      return webElementFacade.isDisplayedNoWait();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpaceMenuDisplayed() {
    try {
      ElementFacade webElementFacade = findByXPathOrCSS("//*[contains(@class, 'v-tab--active')]");
      return webElementFacade.isDisplayedNoWait();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpacePageOpened(String space) {
    return getSpaceElement(space).isVisibleAfterWaiting();
  }

  public void joinSpaceFromCard(String space) {
    ElementFacade webElementFacade =
                                   findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]//ancestor::*[contains(@class, 'spaceCardItem')]//*[contains(text(), 'Join')]//ancestor::button",
                                                                  space.toLowerCase()));
    webElementFacade.clickOnElement();
  }

  public void moveAfterAppButtonIsDisplayed() {
    assertWebElementVisible(moveAfterAppButtonElement());
  }

  public void moveBeforeAppButtonIsDisplayed() {
    assertWebElementVisible(moveBeforeAppButtonElement());
  }

  public void openSpaceFormDrawer() {
    addNewSpaceButtonElement().clickOnElement();
  }

  public void plusButtonIsDisplayed() {
    assertWebElementVisible(plusButtonAppSpaceSettingsElement());
  }

  public void removeAppButtonIsDisplayed() {
    assertWebElementVisible(removeAppButtonElement());
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
    spaceTemplateFilterElement.waitUntilVisible();
    spaceTemplateFilterElement.clickOnElement();
    spaceTemplateFilterElement.selectByIndex(index);
  }

  public void setSpaceName(String spaceName) {
    spaceNameInputElement().setTextValue(spaceName);
  }

  public void showMoreSpaces() {
    spacesPageElement().scrollDown();
    showMoreButtonElement().clickOnElement();
  }

  public void spaceAppSettingsIsOpened() {
    assertWebElementVisible(spaceAppSettingsPageElement());
  }

  public void spaceAvatarIsDisplayed() {
    assertWebElementVisible(spaceAvatarElement());
  }

  public void spaceNameIsDisplayed(String space) {
    assertWebElementVisible(spaceName(space));
  }

  public void uploadSpaceBanner(String fileName) {
    spaceBannerElement().clickOnElement();
    uploadSpaceBannerButtonElement().clickOnElement();
    waitForDrawerToOpen();
    ElementFacade fileInput = findByXPathOrCSS(".v-navigation-drawer--open input[type=file]");
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(fileInput);
    waitForProgressBar();
    ElementFacade imageApplyButton = findByXPathOrCSS("#imageCropDrawerApply");
    imageApplyButton.clickOnElement();
    waitForDrawerToClose();
  }

  private ElementFacade addAppButtonElement() {
    return findByXPathOrCSS("(//*[@class='d-flex flex-no-wrap']//i[@class='v-icon notranslate mdi mdi-plus theme--light'])[1]");
  }

  private ElementFacade addNewSpaceButtonElement() {
    return findByXPathOrCSS("//button[contains(@class,'btn-primary')]");
  }

  private ElementFacade addSpaceButtonElement() {
    return findByXPathOrCSS("(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[3]");
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

  private ElementFacade descriptionSpaceSectionElement() {
    return findByXPathOrCSS("//*[@for='description']");
  }

  private ElementFacade dropDownListSpacesElement() {
    return findByXPathOrCSS("//select[contains(@class,'selectSpacesFilter')]");
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
      return webElementFacade.isDisplayedNoWait() ? webElementFacade : null;
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
    return findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]",
                                          spaceName.toLowerCase()));
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

  private ElementFacade showingSpacesSectionElement() {
    return findByXPathOrCSS("//*[@id='spacesListToolbar']//*[@class='text-sub-title ms-3 d-none d-sm-flex']");
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

  private ElementFacade spacesFilterIconElement() {
    return findByXPathOrCSS("//*[@class='v-input__icon v-input__icon--prepend-inner']//i");
  }

  private ElementFacade spacesFilterTextElement() {
    return findByXPathOrCSS("//input[@placeholder='Filter by name or description']");
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
