package io.meeds.qa.ui.pages.page.factory.space;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ManageSpacesPage extends GenericPage {
  @FindBy(xpath = "//select[contains(@class,'input-block-level ignore-vuetify-classes my-3')]")
  private static BaseElementFacade spaceTemplateFilter;

  @FindBy(xpath = "(//*[@class='d-flex flex-no-wrap']//i[@class='v-icon notranslate mdi mdi-plus theme--light'])[1]")
  private BaseElementFacade    addAppButton;

  @FindBy(xpath = "//button[contains(@class,'addNewSpaceButton')]")
  private BaseElementFacade    addNewSpaceButton;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[3]")
  private BaseElementFacade    addSpaceButton;

  @FindBy(xpath = "//*[@class='SpaceApplicationCard my-1 mx-auto mx-sm-1 col']")
  private BaseElementFacade    appCard;

  @FindBy(xpath = "//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']")
  private BaseElementFacade    arrowIconAppSpaceSettings;

  @FindBy(xpath = "//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']")
  private BaseElementFacade    arrowIconOfApplicationsSpaceSettings;

  @FindBy(xpath = "//*[@class='v-avatar spaceAvatar mx-auto mb-6 mt-2 rounded-0 spaceAvatarHoverEdit']")
  private BaseElementFacade    avatarSection;

  @FindBy(xpath = "(//*[@class='v-icon notranslate mdi mdi-dots-vertical theme--light'])[2]")
  private BaseElementFacade    button3dotAppCard;

  @FindBy(xpath = "//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']")
  private BaseElementFacade    cancelButton;

  @FindBy(xpath = "//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Closed')]")
  private BaseElementFacade    closedRadioBtn;

  @FindBy(xpath = "//*[@for='description']")
  private BaseElementFacade    descriptionSpaceSection;

  @FindBy(xpath = "//select[contains(@class,'selectSpacesFilter')]")
  private BaseElementFacade    dropDownListSpaces;

  @FindBy(xpath = "//i[@class='uiIconEdit uiIconLightBlue pb-2']")
  private BaseElementFacade    editIconOfGeneralSpaceSettings;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[1]")
  private BaseElementFacade    firstProcessButton;

  @FindBy(xpath = "//i[contains(@class,'mdi-chevron-right')]")
  private BaseElementFacade    goToSpaceRightTabs;

  @FindBy(xpath = "//*[@for='hidden']")
  private BaseElementFacade    hiddenSection;

  @FindBy(xpath = "//*[@class='uiIconInviteUser ms-2 me-1']")
  private BaseElementFacade    inviteUserButton;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private BaseElementFacade    inviteUserButtonDrawer;

  @FindBy(xpath = "(//div[@name='inviteMembers']//input)[1]")
  private TextBoxElementFacade inviteUserInput;

  @FindBy(xpath = "(//div[contains(text(), 'Move after')])[2]")
  private BaseElementFacade    moveAfterAppButton;

  @FindBy(xpath = "//div[contains(text(), 'Move before')]")
  private BaseElementFacade    moveBeforeAppButton;

  @FindBy(xpath = "//*[@for='name']")
  private BaseElementFacade    nameSpaceSection;

  @FindBy(xpath = "//button[contains(text(),'OK')]")
  private TextBoxElementFacade okButton;

  @FindBy(xpath = "//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Open')]")
  private BaseElementFacade    openRadioBtn;

  @FindBy(xpath = "//*[@class='v-icon notranslate mdi mdi-plus theme--light']")
  private BaseElementFacade    plusButtonAppSpaceSettings;

  @FindBy(xpath = "//div[contains(@class,'v-input--selection-controls v-input--radio-group')]")
  private BaseElementFacade    registrationSection;

  @FindBy(xpath = "(//div[contains(text(), 'Remove')])[2]")
  private BaseElementFacade    removeAppButton;

  @FindBy(xpath = "//div[contains(@class,'inputSpacesFilter')]//input")
  private TextBoxElementFacade searchSpaceInput;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[2]")
  private BaseElementFacade    secondProcessButton;

  @FindBy(xpath = "//select")
  private BaseElementFacade    selectSpaceFilter;

  @FindBy(xpath = "//*[@id='spacesListToolbar']//*[@class='text-sub-title ms-3 d-none d-sm-flex']")
  private BaseElementFacade    showingSpacesSection;

  @FindBy(xpath = "//*[@id='spacesListFooter']//button")
  private BaseElementFacade    showMoreButton;

  @FindBy(xpath = "//div[@class='v-list-item__content drawerTitle align-start text-header-title text-truncate']")
  private BaseElementFacade    spaceAppInstallerDrawer;

  @FindBy(xpath = "//*[@class='v-toolbar__title ps-0']")
  private BaseElementFacade    spaceAppSettingsPage;

  @FindBy(xpath = "//*[@class='spaceAvatar']")
  private BaseElementFacade    spaceAvatar;

  @FindBy(xpath = "//*[@class='flex fill-height column']")
  private TextBoxElementFacade spaceBanner;

  @FindBy(xpath = "//*[@id='SpaceHeader']//*[@class='v-responsive__content']")
  private TextBoxElementFacade spaceBannerUpdated;

  @FindBy(xpath = "(//*[contains(@class, 'spaceCardFlip')])[20]")
  private BaseElementFacade    spaceCardN20;

  @FindBy(xpath = "(//*[contains(@class, 'spaceCardFlip')])[21]")
  private BaseElementFacade    spaceCardN21;

  @FindBy(xpath = "(//a[contains(@href,'/settings')])")
  private BaseElementFacade    spaceCommunitySettingsTab;

  private SpaceHomePage        spaceHomePage;

  @FindBy(xpath = "(//a[contains(@href,'/members') and @tabindex='0'])")
  private BaseElementFacade    spaceMembersTab;

  @FindBy(name = "name")
  private TextBoxElementFacade spaceNameInput;

  @FindBy(xpath = "(//*[@class='spaceCardFront']//*[@class='v-responsive__content'])[2]")
  private TextBoxElementFacade spaceSearchDetailsAvatar;

  @FindBy(xpath = "(//*[@class='spaceCardFront']//*[@class='v-image__image v-image__image--cover'])[1]")
  private TextBoxElementFacade spaceSearchDetailsCover;

  @FindBy(xpath = "//*[contains(@class,'spaceToolbarIcons')]//*[contains(@class,'spaceInfoIcon')]")
  private TextBoxElementFacade spaceSearchDetailsInfo;

  @FindBy(xpath = "//*[contains(@class,'spaceMembershipButtonText') and contains(text(),'Leave')]")
  private TextBoxElementFacade spaceSearchDetailsLeaveButton;

  @FindBy(xpath = "//*[contains(@class,'spaceToolbarIcons')]//button[contains(@class,'spaceMenuIcon')]")
  private TextBoxElementFacade spaceSearchDetailsThreeDots;

  @FindBy(xpath = "//*[@id='UITopBarContainerParent']//*[contains(@class, 'spaceMenuParent')]//a[contains(text(),'Settings')]")
  private BaseElementFacade    spaceSettingsTab;

  @FindBy(xpath = "//*[@class='v-input__icon v-input__icon--prepend-inner']//i")
  private BaseElementFacade    spacesFilterIcon;

  @FindBy(xpath = "//input[@placeholder='Filter by name or description']")
  private BaseElementFacade    spacesFilterText;

  @FindBy(xpath = "//*[@id='UISiteBody']")
  private BaseElementFacade    spacesPage;

  @FindBy(xpath = "(//a[contains(@href,'/tasks')])")
  private BaseElementFacade    spaceTasksTab;

  @FindBy(xpath = "//*[@for='spaceTemplate']")
  private BaseElementFacade    spaceTemplateSection;

  @FindBy(xpath = "//*[contains(@class,'drawerContent ')]//input[contains(@id,'input') and @type='checkbox']")
  private BaseElementFacade    switchButton;

  @FindBy(xpath = "//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private BaseElementFacade    updateButton;

  @FindBy(xpath = "(//*[@class='flex fill-height column']//button)[1]")
  private TextBoxElementFacade uploadSpaceBannerButton;

  @FindBy(xpath = "//*[@for='inviteMembers']")
  private TextBoxElementFacade usersLabel;

  @FindBy(xpath = "//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Validation')]")
  private BaseElementFacade    validationRadioBtn;

  @FindBy(xpath = "//*[contains(@class, 'v-dialog--active')]//button[contains(@class, 'btn-primary')]")
  private BaseElementFacade removeConfirmationButton;

  public ManageSpacesPage(WebDriver driver) {
    super(driver);
  }

  public void addUserToSpace(String user) {
    spaceMembersTab.clickOnElement();
    inviteUserButton.waitUntilVisible();
    BaseElementFacade memberCard =
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
    assertTrue(spaceCardN20.isVisible());
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

  public void clickOnSpaceSettingsTab() {
    spaceSettingsTab.clickOnElement();
  }

  public void clickSecondProcessButton() {
    secondProcessButton.clickOnElement();
  }

  @SwitchToWindow
  public void clickSpaceAction(String action) {
    BaseElementFacade spaceFirstNavigationTab = getSpaceFirstNavigationTab();
    if (spaceFirstNavigationTab.isPresent()) {
      clickOnElement(spaceFirstNavigationTab);
    } else {
      BaseElementFacade spaceAction = getSpaceAction(action);
      if (spaceAction != null) {
        clickOnElement(spaceAction);
      }
    }
  }

  @SwitchToWindow
  public boolean clickSpaceActionToJoin() {
    BaseElementFacade spaceAction = getSpaceAction("Join");
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

  private BaseElementFacade ELEMENT_HOME_SPACE_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s')][1]", space));
  }

  private BaseElementFacade ELEMENT_SPACE_MEMBERS_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s/members')]", space));
  }

  private BaseElementFacade ELEMENT_SPACE_SETTINGS_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s/settings')]", space));
  }

  private BaseElementFacade ELEMENT_SPACE_TABS_TOP_BAR_ORDER(String order) {
    return findByXPathOrCSS(String.format("//*[@class='v-application--wrap']//*[@class='v-slide-group__wrapper']//*[@tabindex][%s]",
                                          order));
  }

  private BaseElementFacade getAppCardNameDisplayed(String application) {
    return findByXPathOrCSS(String.format("//*[contains(@title,'%s') and @class='text-truncate subtitle-1 px-1 pt-4 text-color SpaceApplicationCardTitle']",
                                          application));
  }

  private BaseElementFacade getAppCardNameDrawer(String application) {
    return findByXPathOrCSS(String.format("(//*[contains(@title,'%s') and @class='text-truncate subtitle-1 px-1 pt-4 text-color SpaceApplicationCardTitle']/following::*[contains(@class,'mdi mdi-plus')])[1]",
                                          application));
  }

  private BaseElementFacade getDeleteSpaceButton(String spaceName) {
    return findByXPathOrCSS(
                            String.format("//a[contains(@title,'%s')]//following::i[contains(@class,'uiIconTrash')]", spaceName));
  }

  private BaseElementFacade getSpaceAction(String action) {
    try {
      BaseElementFacade webElementFacade = findByXPathOrCSS(String.format("//a[@title='%s']", action));
      return webElementFacade.isDisplayedNoWait() ? webElementFacade : null;
    } catch (RuntimeException e) {
      return null;
    }
  }

  private BaseElementFacade getSpaceElement(String space) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'brandingContainer space')]//*[contains(text(),'%s')]",
                                          space));
  }

  private BaseElementFacade getSpaceFirstNavigationTab() {
    return findByXPathOrCSS("//*[contains(@class, 'spaceNavigationTab')]");
  }

  private BaseElementFacade getSpaceMenu(String spaceName) {
    return findByXPathOrCSS(String.format("//a[contains(@title,'%s')]/../..//button[contains(@class,'spaceMenuIcon')]",
                                          spaceName));
  }

  private BaseElementFacade getSpaceNameInListOfSpace(String spaceName) {
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
    goToSpaceRightTabs.clickOnElement();
    spaceCommunitySettingsTab.clickOnElement();
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
    BaseElementFacade element = getSpaceNameInListOfSpace(spaceName);
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

  @SwitchToWindow
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
      BaseElementFacade webElementFacade =
                                         findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]",
                                                                        space.toLowerCase()));
      return webElementFacade.isDisplayedNoWait();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpaceCardJoinButtonDisplayed(String space) {
    try {
      BaseElementFacade webElementFacade =
                                         findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]//ancestor::*[contains(@class, 'spaceCardItem')]//*[contains(text(), 'Join')]//ancestor::button",
                                                                        space.toLowerCase()));
      return webElementFacade.isDisplayedNoWait();
    } catch (RuntimeException e) {
      return false;
    }
  }

  @SwitchToWindow
  public boolean isSpaceMenuDisplayed() {
    try {
      BaseElementFacade webElementFacade = findByXPathOrCSS("//*[contains(@class, 'v-tab--active')]");
      return webElementFacade.isDisplayedNoWait();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpacePageOpened(String space) {
    return getSpaceElement(space).isVisibleAfterWaiting();
  }

  public void joinSpaceFromCard(String space) {
    BaseElementFacade webElementFacade =
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

  public void selectTemplate(String value) {
    spaceTemplateFilter.waitUntilVisible();
    spaceTemplateFilter.clickOnElement();
    spaceTemplateFilter.selectByValue(value);
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

  private BaseElementFacade spaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'brandingContainer')]//div[contains(text(),'%s')]", spaceName));
  }

  public void spaceNameIsDisplayed(String space) {
    spaceName(space).waitUntilVisible();
  }

  private BaseElementFacade spaceSearchDetailsSpaceMembers(String members) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceMembersLabel') and contains(text(),'%s')]", members));
  }

  private BaseElementFacade spaceSearchDetailsSpaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceCardBody')]//a[contains(text(),'%s')]", spaceName));
  }

  public void uploadSpaceBanner(String fileName) {
    spaceBanner.waitUntilVisible();
    Actions builder = new Actions(driver);
    WebElement spaceBanner = driver.findElement(org.openqa.selenium.By.xpath("//*[@class='flex fill-height column']"));
    builder.moveToElement(spaceBanner).build().perform();
    uploadSpaceBannerButton.waitUntilVisible();
    WebElement elem =
                    getDriver().findElement(org.openqa.selenium.By.xpath("//*[@class='v-input__prepend-outer']//button/following::input[1]"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(elem);
  }

  public void confirmRemoveApplication() {
    removeConfirmationButton.clickOnElement();
  }

  public void checkOptionFromApplicationMenuIsDisplayed(String option , String appName) {
    assertWebElementVisible(getOptionFromApplicationMenu(appName,option));
  }

  public void clickOptionApplicationCard(String appName , String option){
    getApplicationThreeDotsMenu(appName).clickOnElement();
    getOptionFromApplicationMenu(option,appName);
    getOptionFromApplicationMenu(option,appName).clickOnElement();
  }

  private BaseElementFacade getApplicationThreeDotsMenu(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@Class,'SpaceApplicationCard')]//*[contains(@Class, 'mdi-dots-vertical')]//ancestor::button",
            appName));
  }

  private BaseElementFacade getOptionFromApplicationMenu(String appName , String option) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'SpaceApplicationCard')]//ancestor::*[contains(@class,'v-list--dense')]//*[contains(text(),'%s')]",appName,option));
  }

}

