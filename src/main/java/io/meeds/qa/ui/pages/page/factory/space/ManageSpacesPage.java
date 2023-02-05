package io.meeds.qa.ui.pages.page.factory.space;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ManageSpacesPage extends GenericPage {
  @FindBy(xpath = "//select[contains(@class,'input-block-level ignore-vuetify-classes my-3')]")
  private static ElementFacade spaceTemplateFilter;

  @FindBy(xpath = "(//*[@class='d-flex flex-no-wrap']//i[@class='v-icon notranslate mdi mdi-plus theme--light'])[1]")
  private ElementFacade        addAppButton;

  @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
  private ElementFacade        addNewSpaceButton;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[3]")
  private ElementFacade        addSpaceButton;

  @FindBy(xpath = "//*[@class='SpaceApplicationCard my-1 mx-auto mx-sm-1 col']")
  private ElementFacade        appCard;

  @FindBy(xpath = "//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']")
  private ElementFacade        arrowIconAppSpaceSettings;

  @FindBy(xpath = "//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']")
  private ElementFacade        arrowIconOfApplicationsSpaceSettings;

  @FindBy(xpath = "//*[@class='v-avatar spaceAvatar mx-auto mb-6 mt-2 rounded-0 spaceAvatarHoverEdit']")
  private ElementFacade        avatarSection;

  @FindBy(xpath = "(//*[@class='v-icon notranslate mdi mdi-dots-vertical theme--light'])[2]")
  private ElementFacade        button3dotAppCard;

  @FindBy(xpath = "//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']")
  private ElementFacade        cancelButton;

  @FindBy(xpath = "//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Closed')]")
  private ElementFacade        closedRadioBtn;

  @FindBy(xpath = "//*[@for='description']")
  private ElementFacade        descriptionSpaceSection;

  @FindBy(xpath = "//select[contains(@class,'selectSpacesFilter')]")
  private ElementFacade        dropDownListSpaces;

  @FindBy(xpath = "//i[@class='uiIconEdit uiIconLightBlue pb-2']")
  private ElementFacade        editIconOfGeneralSpaceSettings;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[1]")
  private ElementFacade        firstProcessButton;

  @FindBy(xpath = "//i[contains(@class,'mdi-chevron-right')]")
  private ElementFacade        goToSpaceRightTabs;

  @FindBy(xpath = "//*[@for='hidden']")
  private ElementFacade        hiddenSection;

  @FindBy(xpath = "//*[@class='uiIconInviteUser ms-2 me-1']")
  private ElementFacade        inviteUserButton;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private ElementFacade        inviteUserButtonDrawer;

  @FindBy(xpath = "(//div[@name='inviteMembers']//input)[1]")
  private TextBoxElementFacade     inviteUserInput;

  @FindBy(xpath = "(//div[contains(text(), 'Move after')])[2]")
  private ElementFacade        moveAfterAppButton;

  @FindBy(xpath = "//div[contains(text(), 'Move before')]")
  private ElementFacade        moveBeforeAppButton;

  @FindBy(xpath = "//*[@for='name']")
  private ElementFacade        nameSpaceSection;

  @FindBy(xpath = "//button[contains(text(),'OK')]")
  private TextBoxElementFacade     okButton;

  @FindBy(xpath = "//*[contains(@class,'v-navigation-drawer--open')]//input[@value='open']//ancestor::*[contains(@class,'v-radio')]")
  private ElementFacade        openRadioBtn;

  @FindBy(xpath = "//*[@class='v-icon notranslate mdi mdi-plus theme--light']")
  private ElementFacade        plusButtonAppSpaceSettings;

  @FindBy(xpath = "//div[contains(@class,'v-input--selection-controls v-input--radio-group')]")
  private ElementFacade        registrationSection;

  @FindBy(xpath = "(//div[contains(text(), 'Remove')])[2]")
  private ElementFacade        removeAppButton;

  @FindBy(xpath = "//div[contains(@class,'inputSpacesFilter')]//input")
  private TextBoxElementFacade     searchSpaceInput;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[2]")
  private ElementFacade        secondProcessButton;

  @FindBy(xpath = "//select")
  private ElementFacade        selectSpaceFilter;

  @FindBy(xpath = "//*[@id='spacesListToolbar']//*[@class='text-sub-title ms-3 d-none d-sm-flex']")
  private ElementFacade        showingSpacesSection;

  @FindBy(xpath = "//*[@id='spacesListFooter']//button")
  private ElementFacade        showMoreButton;

  @FindBy(xpath = "//div[@class='v-list-item__content drawerTitle align-start text-header-title text-truncate']")
  private ElementFacade        spaceAppInstallerDrawer;

  @FindBy(xpath = "//*[@class='v-toolbar__title ps-0']")
  private ElementFacade        spaceAppSettingsPage;

  @FindBy(xpath = "//*[@id='UserHomePortalLink']")
  private ElementFacade        spaceAvatar;

  @FindBy(xpath = "//*[@id='spaceAvatarImg']")
  private TextBoxElementFacade     spaceBanner;

  @FindBy(xpath = "//*[@id='SpaceHeader']//*[@class='v-responsive__content']")
  private TextBoxElementFacade     spaceBannerUpdated;

  @FindBy(xpath = "(//*[contains(@class, 'spaceCardFlip')])[20]")
  private ElementFacade        spaceCardN20;

  @FindBy(xpath = "(//*[contains(@class, 'spaceCardFlip')])[21]")
  private ElementFacade        spaceCardN21;

  @FindBy(xpath = "(//a[contains(@href,'/members') and @tabindex='0'])")
  private ElementFacade        spaceMembersTab;

  @FindBy(name = "name")
  private TextBoxElementFacade     spaceNameInput;

  @FindBy(xpath = "(//*[@class='spaceCardFront']//*[@class='v-responsive__content'])[2]")
  private TextBoxElementFacade     spaceSearchDetailsAvatar;

  @FindBy(xpath = "(//*[@class='spaceCardFront']//*[@class='v-image__image v-image__image--cover'])[1]")
  private TextBoxElementFacade     spaceSearchDetailsCover;

  @FindBy(xpath = "//*[contains(@class,'spaceToolbarIcons')]//*[contains(@class,'spaceInfoIcon')]")
  private TextBoxElementFacade     spaceSearchDetailsInfo;

  @FindBy(xpath = "//*[contains(@class,'spaceMembershipButtonText') and contains(text(),'Leave')]")
  private TextBoxElementFacade     spaceSearchDetailsLeaveButton;

  @FindBy(xpath = "//*[contains(@class,'spaceToolbarIcons')]//button[contains(@class,'spaceMenuIcon')]")
  private TextBoxElementFacade     spaceSearchDetailsThreeDots;

  @FindBy(xpath = "//*[@id='UITopBarContainerParent']//*[contains(@class, 'spaceMenuParent')]//a[contains(@href,'/settings')]")
  private ElementFacade        spaceSettingsTab;

  @FindBy(xpath = "//*[@class='v-input__icon v-input__icon--prepend-inner']//i")
  private ElementFacade        spacesFilterIcon;

  @FindBy(xpath = "//input[@placeholder='Filter by name or description']")
  private ElementFacade        spacesFilterText;

  @FindBy(xpath = "//*[@id='UISiteBody']")
  private ElementFacade        spacesPage;

  @FindBy(xpath = "(//a[contains(@href,'/tasks')])")
  private ElementFacade        spaceTasksTab;

  @FindBy(xpath = "//*[@for='spaceTemplate']")
  private ElementFacade        spaceTemplateSection;

  @FindBy(xpath = "//*[contains(@class,'drawerContent ')]//input[contains(@id,'input') and @type='checkbox']")
  private ElementFacade        switchButton;

  @FindBy(xpath = "//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private ElementFacade        updateButton;

  @FindBy(css = "#spaceBannerEditButton")
  private TextBoxElementFacade     uploadSpaceBannerButton;

  @FindBy(xpath = "//*[@for='inviteMembers']")
  private TextBoxElementFacade     usersLabel;

  @FindBy(xpath = "//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Validation')]")
  private ElementFacade        validationRadioBtn;

  @FindBy(xpath = "//*[contains(@class, 'v-dialog--active')]//button[contains(@class, 'btn-primary')]")
  private ElementFacade        removeConfirmationButton;

  @FindBy(xpath = "//*[contains(@class,'drawerFooter')]//*[contains(@class,'btn-primary')]")
  private ElementFacade applyButtonBanner;

  private ElementFacade spaceName() {
    return findByXPathOrCSS("//*[contains(@class,'UITopBarContainerItem')]//*[contains(@class,'logoTitle')]");
  }

  private SpaceHomePage            spaceHomePage;

  public ManageSpacesPage(WebDriver driver) {
    super(driver);
  }

  public void addUserToSpace(String user) {
    spaceMembersTab.clickOnElement();
    inviteUserButton.waitUntilVisible();
    ElementFacade memberCard =
                                 findByXPathOrCSS(String.format("//*[contains(@class, 'userFullname') and contains(text(), '%s')]",
                                                                user));
    if (memberCard.isPresent()) {
      spaceHomePage.removeMember(user);
    }
    inviteUserButton.clickOnElement();
    inviteUserToSpace(user);
    inviteUserButtonDrawer.clickOnElement();
  }

  public void appCardIsDisplayed() {
    assertWebElementVisible(appCard);
  }

  public void checkApplicationsAreDisplayed() {
    assertWebElementVisible(addAppButton);
  }

  public void checkApplicationsSpaceSettings() {
    assertWebElementVisible(arrowIconOfApplicationsSpaceSettings);
  }

  public void checkAvatarSection() {
    assertWebElementVisible(avatarSection);
  }

  public void checkCancelButton() {
    assertWebElementVisible(cancelButton);
  }

  public void checkDescriptionSpaceSection() {
    assertWebElementVisible(descriptionSpaceSection);
  }

  public void checkDisplayOfOtherSpaces() {
    assertWebElementVisible(spaceCardN21);
  }

  public void checkDisplayOfTwentySpaces() {
    assertWebElementVisible(spaceCardN20);
    assertWebElementNotVisible(spaceCardN21);
  }

  public void checkGeneralSpaceSettings() {
    assertWebElementVisible(editIconOfGeneralSpaceSettings);
  }

  public void checkHiddenAndSwitchButtonSection() {
    assertWebElementVisible(hiddenSection);
    assertWebElementVisible(switchButton);
  }

  public void checkNameSpaceSection() {
    assertWebElementVisible(nameSpaceSection);
  }

  public void checkRegistrationSection() {
    assertWebElementVisible(registrationSection);
  }

  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    spaceAppInstallerDrawer.clickOnElement();
  }

  public void checkSpaceRegistration(String registration) {
    switch (registration) {
    case "Open":
      // Select Open
      openRadioBtn.clickOnElement();
      break;
    case "Validation":
      // Select Validation
      validationRadioBtn.clickOnElement();
      break;
    case "Closed":
      // Select Closed
      closedRadioBtn.clickOnElement();
      break;
    default:
      // Do nothing
      break;
    }
  }

  public void checkSpaceTemplateSection() {
    assertWebElementVisible(spaceTemplateSection);
  }

  public void checkThatAppIsAdded(String application) {
    assertWebElementVisible(getAppCardNameDisplayed(application));
  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayed(String spaceName, String members) {
    assertWebElementVisible(spaceSearchDetailsCover);
    assertWebElementVisible(spaceSearchDetailsAvatar);
    assertWebElementVisible(spaceSearchDetailsInfo);
    assertWebElementVisible(spaceSearchDetailsThreeDots);
    assertWebElementVisible(spaceSearchDetailsLeaveButton);
    assertWebElementVisible(spaceSearchDetailsSpaceName(spaceName));
    assertWebElementVisible(spaceSearchDetailsSpaceMembers(members));

  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String spaceName, String members) {
    assertWebElementVisible(spaceSearchDetailsCover);
    assertWebElementVisible(spaceSearchDetailsAvatar);
    assertWebElementVisible(spaceSearchDetailsInfo);
    assertWebElementVisible(spaceSearchDetailsLeaveButton);
    assertWebElementVisible(spaceSearchDetailsSpaceName(spaceName));
    assertWebElementVisible(spaceSearchDetailsSpaceMembers(members));

  }

  public void checkThatSpaceInSearchResultsIsNotDisplayed(String spaceName) {
    assertWebElementNotVisible(spaceSearchDetailsSpaceName(spaceName));
  }

  public void checkThatSpaceTabsAreDisplayedInOrder(String space) {
    // Top Bar Tabs after Space Creation are displayed in order
    Assert.assertTrue(ELEMENT_SPACE_TABS_TOP_BAR_ORDER("1").getAttribute("href")
                                                           .contains(ELEMENT_HOME_SPACE_TAB_TOP_BAR(space.toLowerCase()).getAttribute("href")));

    Assert.assertTrue(ELEMENT_SPACE_TABS_TOP_BAR_ORDER("2").getAttribute("href")
                                                           .contains(ELEMENT_SPACE_MEMBERS_TAB_TOP_BAR(space.toLowerCase()).getAttribute("href")));
  }

  public void checkThatSpaceTopBarElementsAreDisplayed() {
    assertWebElementVisible(addNewSpaceButton);
    assertTrue(showingSpacesSection.getText().contains("Showing"));
    assertTrue(showingSpacesSection.getText().contains("spaces"));
    assertWebElementVisible(spacesFilterIcon);
    assertWebElementVisible(spacesFilterText);
    assertWebElementVisible(dropDownListSpaces);
    assertTrue(dropDownListSpaces.getText().contains("All spaces"));
  }

  public void checkUpdateButton() {
    assertWebElementVisible(spaceAppInstallerDrawer);
  }

  public void clickAddSpaceButton() {
    addSpaceButton.clickOnElement();
  }

  public void clickFirstProcessButton() {
    firstProcessButton.clickOnElement();
  }

  public void clickOn3dotsAppCard() {
    button3dotAppCard.clickOnElement();
  }

  public void clickOnArrowIconAppSpaceSettings() {
    arrowIconAppSpaceSettings.clickOnElement();
  }

  public void clickOnGeneralSpaceSettings() {
    editIconOfGeneralSpaceSettings.clickOnElement();
  }

  public void clickOnPlusButton() {
    plusButtonAppSpaceSettings.clickOnElement();
  }

  public void clickSecondProcessButton() {
    secondProcessButton.clickOnElement();
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

  public void deleteSpace(String spaceName) {
    searchSpaceInput.setTextValue(spaceName);
    getSpaceMenu(spaceName).clickOnElement();
    getDeleteSpaceButton(spaceName).clickOnElement();
    okButton.clickOnElement();
    okButton.waitUntilNotVisible();
  }

  private ElementFacade ELEMENT_HOME_SPACE_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s')][1]", space));
  }

  private ElementFacade ELEMENT_SPACE_MEMBERS_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s/members')]", space));
  }

  private ElementFacade ELEMENT_SPACE_SETTINGS_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s/settings')]", space));
  }

  private ElementFacade ELEMENT_SPACE_TABS_TOP_BAR_ORDER(String order) {
    return findByXPathOrCSS(String.format("//*[@class='v-application--wrap']//*[@class='v-slide-group__wrapper']//*[@tabindex][%s]",
                                          order));
  }

  private ElementFacade getAppCardNameDisplayed(String application) {
    return findByXPathOrCSS(String.format("//*[contains(@title,'%s') and @class='text-truncate subtitle-1 px-1 pt-4 text-color SpaceApplicationCardTitle']",
                                          application));
  }

  private ElementFacade getAppCardNameDrawer(String application) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'d-flex')]//ancestor::*[@class='SpaceApplicationCardAction']",
                                          application));
  }

  private ElementFacade getDeleteSpaceButton(String spaceName) {
    return findByXPathOrCSS(String.format("//a[contains(@title,'%s')]//following::i[contains(@class,'uiIconTrash')]", spaceName));
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

  public void goToMembersTab() {
    if (spaceMembersTab.isNotVisibleAfterWaiting()) {
      goToSpaceRightTabs.clickOnElement();
    }
    spaceMembersTab.clickOnElement();
  }

  public void goToSettingsTab() {
    if (!spaceSettingsTab.isDisplayedNoWait()) {
      goToSpaceRightTabs.clickOnElement();
    }
    spaceSettingsTab.clickOnElement();
  }

  public void goToSpaceHomeViaSpaceAvatar() {
    spaceAvatar.waitUntilVisible();
    spaceAvatar.clickOnElement();
  }

  public void goToSpaceToAcceptInvitation(String spaceName) {
    getSpaceNameInListOfSpace(spaceName).waitUntilVisible();
    getSpaceNameInListOfSpace(spaceName).clickOnElement();
  }

  public void goToSpecificSpace(String spaceName) {
    ElementFacade element = getSpaceNameInListOfSpace(spaceName);
    element.waitUntilVisible();
    element.clickOnElement();
    verifyPageLoaded();
  }

  public void goToTasksTab() {
    spaceTasksTab.clickOnElement();
  }

  public void insertSpaceNameInSearchField(String spaceName) {
    searchSpaceInput.waitUntilVisible();
    searchSpaceInput.setTextValue(spaceName);
    waitForProgressBar();
  }

  public void inviteUserToSpace(String user) {
    mentionInField(inviteUserInput, user, 5);
  }

  public boolean isLoadMoreButtonDisplayed() {
    return findByXPathOrCSS("#spacesListFooter .loadMoreButton").isCurrentlyVisible();
  }

  public void isSpaceBannerUpdated() {
    assertWebElementVisible(spaceBannerUpdated);
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
    assertWebElementVisible(moveAfterAppButton);
  }

  public void moveBeforeAppButtonIsDisplayed() {
    assertWebElementVisible(moveBeforeAppButton);
  }

  public void openSpaceFormDrawer() {
    addNewSpaceButton.clickOnElement();
  }

  public void plusButtonIsDisplayed() {
    assertWebElementVisible(plusButtonAppSpaceSettings);
  }

  public void removeAppButtonIsDisplayed() {
    assertWebElementVisible(removeAppButton);
  }

  public void selectFilter(String filter) {
    if (filter.equals("My spaces"))
      selectSpaceFilter.select().byValue("member");
    else
      selectSpaceFilter.select().byValue("all");
  }

  public void selectTemplate(int index) {
    spaceTemplateFilter.waitUntilVisible();
    spaceTemplateFilter.clickOnElement();
    spaceTemplateFilter.selectByIndex(index);
  }

  public void setSpaceName(String spaceName) {
    spaceNameInput.setTextValue(spaceName);
  }

  public void showMoreSpaces() {
    spacesPage.scrollDown();
    showMoreButton.clickOnElement();
  }

  public void spaceAppSettingsIsOpened() {
    assertWebElementVisible(spaceAppSettingsPage);
  }

  public void spaceAvatarIsDisplayed() {
    spaceAvatar.waitUntilVisible();
  }

  private ElementFacade spaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'brandingContainer')]//div[contains(text(),'%s')]", spaceName));
  }

  public void spaceNameIsDisplayed(String space) {
    spaceName(space).waitUntilVisible();
  }

  private ElementFacade spaceSearchDetailsSpaceMembers(String members) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceMembersLabel') and contains(text(),'%s')]", members));
  }

  private ElementFacade spaceSearchDetailsSpaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceCardBody')]//a[contains(text(),'%s')]", spaceName));
  }

  public void uploadSpaceBanner(String fileName) {
    spaceBanner.waitUntilVisible();
    ElementFacade spaceBannerImage = findByXPathOrCSS("#SpaceHeader .v-image");
    spaceBannerImage.clickOnElement();
    uploadSpaceBannerButton.waitUntilVisible();
    uploadSpaceBannerButton.clickOnElement();
    waitForDrawerToOpen();
    ElementFacade fileInput = findByXPathOrCSS(".v-navigation-drawer--open input[type=file]");
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(fileInput);
    waitForProgressBar();
    ElementFacade imageApplyButton = findByXPathOrCSS("#imageCropDrawerApply");
    imageApplyButton.clickOnElement();
    waitForDrawerToClose();
  }

  public void confirmRemoveApplication() {
    removeConfirmationButton.clickOnElement();
  }

  public void checkOptionFromApplicationMenuIsDisplayed(String appName, String option) {
    assertWebElementVisible(getOptionFromApplicationMenu(appName, option));
  }

  public void clickOnThreeDotsAppCard(String appName) {
    getApplicationThreeDotsMenu(appName).clickOnElement();
  }

  public void clickOptionApplicationCard(String appName, String option) {
    getOptionFromApplicationMenu(appName, option).clickOnElement();
  }

  private ElementFacade getApplicationThreeDotsMenu(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@Class,'SpaceApplicationCard')]//*[contains(@Class, 'mdi-dots-vertical')]//ancestor::button",
                                          appName));
  }

  private ElementFacade getOptionFromApplicationMenu(String appName, String option) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'SpaceApplicationCard')]//ancestor::*[contains(@class,'v-list--dense')]//*[contains(text(),'%s')]",
                                          appName,
                                          option));
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

  public void clickOnSpaceBookmarkIconFromSpaceCard() {
    findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'fa-star')]").clickOnElement();
  }

  public void clickOnSpaceBookmarkIconFromTopbarSpacePopover() {
    findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fa-star')]").clickOnElement();
  }

  public void clickOnSpaceBookmarkIconFromThirdNavigationLevel() {
    findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fa-star')]").clickOnElement();
  }

  public void checkSpaceBookmarkStatusFromSpaceCard( boolean ShouldBeBookmarked) {
    if (ShouldBeBookmarked) {
      assertWebElementVisible(findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'fas fa-star')]"));
    } else {
      assertWebElementVisible(findByXPathOrCSS("//* [@class='spaceCardFront']//*[contains(@class,'far fa-star')]"));
    }
  }

    public void checkSpaceBookmarkStatusFromTopbarSpacePopover( boolean ShouldBeBookmarked){
      if (ShouldBeBookmarked) {
        assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'fas fa-star')]"));
      } else {
        assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'v-card')]//*[contains(@class,'far fa-star')]"));
      }
    }

   public void checkSpaceBookmarkStatusFromThirdNavigationLevel( boolean shouldBeBookmarked){
    if (shouldBeBookmarked) {
      assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'fas fa-star')]"));
    } else {
      assertWebElementVisible(findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]//*[contains(@class,'far fa-star')]"));
    }
  }

    public void hoverOnSpaceName () {
      spaceName().hover();
    }
  }