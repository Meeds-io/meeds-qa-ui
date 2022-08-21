package io.meeds.qa.ui.pages.page.factory.space;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ManageSpacesPage extends GenericPage {
  public ManageSpacesPage(WebDriver driver) {
    super(driver);
  }

  private SpaceHomePage        spaceHomePage;

  @FindBy(xpath = "//button[contains(@class,'addNewSpaceButton')]")
  private BaseElementFacade    addNewSpaceButton;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[1]")
  private BaseElementFacade    firstProcessButton;

  @FindBy(name = "name")
  private TextBoxElementFacade spaceNameInput;

  @FindBy(xpath = "(//*[@class='spaceCardFront']//*[@class='v-responsive__content'])[2]")
  private TextBoxElementFacade spaceSearchDetailsAvatar;

  @FindBy(xpath = "//*[contains(@class,'spaceToolbarIcons')]//*[contains(@class,'spaceInfoIcon')]")
  private TextBoxElementFacade spaceSearchDetailsInfo;

  @FindBy(xpath = "//*[@for='inviteMembers']")
  private TextBoxElementFacade usersLabel;

  @FindBy(xpath = "//*[contains(@class,'spaceToolbarIcons')]//button[contains(@class,'spaceMenuIcon')]")
  private TextBoxElementFacade spaceSearchDetailsThreeDots;

  @FindBy(xpath = "(//*[@class='spaceCardFront']//*[@class='v-image__image v-image__image--cover'])[1]")
  private TextBoxElementFacade spaceSearchDetailsCover;

  @FindBy(xpath = "//*[contains(@class,'spaceMembershipButtonText') and contains(text(),'Leave')]")
  private TextBoxElementFacade spaceSearchDetailsLeaveButton;

  @FindBy(xpath = "//*[@class='spaceAvatar']")
  private BaseElementFacade    spaceAvatar;

  @FindBy(xpath = "//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Open')]")
  private BaseElementFacade    openRadioBtn;

  @FindBy(xpath = "//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Closed')]")
  private BaseElementFacade    closedRadioBtn;

  @FindBy(xpath = "//*[@class='v-input--selection-controls__input']/following::label[contains(text(),'Validation')]")
  private BaseElementFacade    validationRadioBtn;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[3]")
  private BaseElementFacade    addSpaceButton;

  @FindBy(xpath = "//*[@id='spacesListToolbar']//*[@class='text-sub-title ms-3 d-none d-sm-flex']")
  private BaseElementFacade    showingSpacesSection;

  @FindBy(xpath = "//*[@class='v-input__icon v-input__icon--prepend-inner']//i")
  private BaseElementFacade    spacesFilterIcon;

  @FindBy(xpath = "//input[@placeholder='Filter by name or description']")
  private BaseElementFacade    spacesFilterText;

  @FindBy(xpath = "//select[contains(@class,'selectSpacesFilter')]")
  private BaseElementFacade    dropDownListSpaces;

  @FindBy(xpath = "//div[contains(@class,'inputSpacesFilter')]//input")
  private TextBoxElementFacade searchSpaceInput;

  @FindBy(xpath = "(//div[@name='inviteMembers']//input)[1]")
  private TextBoxElementFacade inviteUserInput;

  @FindBy(xpath = "//button[contains(text(),'OK')]")
  private TextBoxElementFacade okButton;

  @FindBy(xpath = "//*[@class='flex fill-height column']")
  private TextBoxElementFacade spaceBanner;

  @FindBy(xpath = "(//*[@class='flex fill-height column']//button)[1]")
  private TextBoxElementFacade uploadSpaceBannerButton;

  @FindBy(xpath = "//*[@id='SpaceHeader']//*[@class='v-responsive__content']")
  private TextBoxElementFacade spaceBannerUpdated;

  @FindBy(xpath = "//select")
  private BaseElementFacade    selectSpaceFilter;

  @FindBy(xpath = "(//*[contains(@class, 'spaceCardFlip')])[20]")
  private BaseElementFacade    spaceCardN20;

  @FindBy(xpath = "(//*[contains(@class, 'spaceCardFlip')])[21]")
  private BaseElementFacade    spaceCardN21;

  @FindBy(xpath = "//*[@id='spacesListFooter']//button")
  private BaseElementFacade    showMoreButton;

  @FindBy(xpath = "//*[@id='UISiteBody']")
  private BaseElementFacade    spacesPage;

  @FindBy(xpath = "//*[@class='v-slide-group__content v-tabs-bar__content']/a[5]")
  private BaseElementFacade    spaceSettingsTab;

  @FindBy(xpath = "//i[@class='uiIconEdit uiIconLightBlue pb-2']")
  private BaseElementFacade    editIconOfGeneralSpaceSettings;

  @FindBy(xpath = "//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']")
  private BaseElementFacade    arrowIconOfApplicationsSpaceSettings;

  @FindBy(xpath = "//*[@class='v-avatar spaceAvatar mx-auto mb-6 mt-2 rounded-0 spaceAvatarHoverEdit']")
  private BaseElementFacade    avatarSection;

  @FindBy(xpath = "//*[@for='name']")
  private BaseElementFacade    nameSpaceSection;

  @FindBy(xpath = "//*[@for='description']")
  private BaseElementFacade    descriptionSpaceSection;

  @FindBy(xpath = "//*[@for='spaceTemplate']")
  private BaseElementFacade    spaceTemplateSection;

  @FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[2]")
  private BaseElementFacade    secondProcessButton;

  @FindBy(xpath = "//*[@for='hidden']")
  private BaseElementFacade    hiddenSection;

  @FindBy(xpath = "//*[contains(@class,'drawerContent ')]//input[contains(@id,'input') and @type='checkbox']")
  private BaseElementFacade    switchButton;

  @FindBy(xpath = "//div[contains(@class,'v-input--selection-controls v-input--radio-group')]")
  private BaseElementFacade    registrationSection;

  @FindBy(xpath = "//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']")
  private BaseElementFacade    cancelButton;

  @FindBy(xpath = "//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private BaseElementFacade    updateButton;

  @FindBy(xpath = "//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']")
  private BaseElementFacade    arrowIconAppSpaceSettings;

  @FindBy(xpath = "//*[@class='v-toolbar__title ps-0']")
  private BaseElementFacade    spaceAppSettingsPage;

  @FindBy(xpath = "//*[@class='SpaceApplicationCard my-1 mx-auto mx-sm-1 col']")
  private BaseElementFacade    appCard;

  @FindBy(xpath = "//*[@class='v-icon notranslate mdi mdi-plus theme--light']")
  private BaseElementFacade    plusButtonAppSpaceSettings;

  @FindBy(xpath = "(//*[@class='v-icon notranslate mdi mdi-dots-vertical theme--light'])[2]")
  private BaseElementFacade    button3dotAppCard;

  @FindBy(xpath = "(//div[contains(text(), 'Remove')])[2]")
  private BaseElementFacade    removeAppButton;

  @FindBy(xpath = "//div[contains(text(), 'Move before')]")
  private BaseElementFacade    moveBeforeAppButton;

  @FindBy(xpath = "(//div[contains(text(), 'Move after')])[2]")
  private BaseElementFacade    moveAfterAppButton;

  @FindBy(xpath = "//div[@class='v-list-item__content drawerTitle align-start text-header-title text-truncate']")
  private BaseElementFacade    spaceAppInstallerDrawer;

  @FindBy(xpath = "(//a[contains(@href,'/tasks')])")
  private BaseElementFacade    spaceTasksTab;

  @FindBy(xpath = "(//a[contains(@href,'/settings')])")
  private BaseElementFacade    spaceCommunitySettingsTab;

  @FindBy(xpath = "(//*[@class='d-flex flex-no-wrap']//i[@class='v-icon notranslate mdi mdi-plus theme--light'])[1]")
  private BaseElementFacade    addAppButton;

  @FindBy(xpath = "(//a[contains(@href,'/members') and @tabindex='0'])")
  private BaseElementFacade    spaceMembersTab;

  @FindBy(xpath = "//*[@class='uiIconInviteUser ms-2 me-1']")
  private BaseElementFacade    inviteUserButton;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private BaseElementFacade    inviteUserButtonDrawer;

  @FindBy(xpath = "//i[contains(@class,'mdi-chevron-right')]")
  private BaseElementFacade    goToSpaceRightTabs;

  private BaseElementFacade getAppCardNameDisplayed(String application) {
    return findByXPathOrCSS(String.format("//*[contains(@title,'%s') and @class='text-truncate subtitle-1 px-1 pt-4 text-color SpaceApplicationCardTitle']",
                                          application));
  }

  private BaseElementFacade getAppCardNameDrawer(String application) {
    return findByXPathOrCSS(String.format("(//*[contains(@title,'%s') and @class='text-truncate subtitle-1 px-1 pt-4 text-color SpaceApplicationCardTitle']/following::*[contains(@class,'mdi mdi-plus')])[1]",
                                          application));
  }

  private BaseElementFacade spaceSearchDetailsSpaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceCardBody')]//a[contains(text(),'%s')]", spaceName));
  }

  private BaseElementFacade spaceSearchDetailsSpaceMembers(String members) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'spaceMembersLabel') and contains(text(),'%s')]", members));
  }

  private BaseElementFacade spaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'brandingContainer')]//div[contains(text(),'%s')]", spaceName));
  }

  private BaseElementFacade getSpaceNameInListOfSpace(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]",
                                          spaceName.toLowerCase()));
  }

  private BaseElementFacade getSpaceAction(String action) {
    try {
      BaseElementFacade webElementFacade = findByXPathOrCSS(String.format("//a[@title='%s']", action));
      webElementFacade.setImplicitTimeout(Duration.ofSeconds(0));
      return webElementFacade.isDisplayed() ? webElementFacade : null;
    } catch (RuntimeException e) {
      return null;
    }
  }

  private BaseElementFacade getSelectUserInDropDown(String userName) {
    return findByXPathOrCSS(String.format(
                                          "//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                                          userName));
  }

  private BaseElementFacade getSpaceMenu(String spaceName) {
    return findByXPathOrCSS(String.format("//a[contains(@title,'%s')]/../..//button[contains(@class,'spaceMenuIcon')]",
                                          spaceName));
  }

  private BaseElementFacade ELEMENT_SPACE_TABS_TOP_BAR_ORDER(String order) {
    return findByXPathOrCSS(String.format("//*[@class='v-application--wrap']//*[@class='v-slide-group__wrapper']//*[@tabindex][%s]",
                                          order));
  }

  private BaseElementFacade ELEMENT_HOME_SPACE_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s')][1]", space));
  }

  private BaseElementFacade getDeleteSpaceButton(String spaceName) {
    return findByXPathOrCSS(
                            String.format("//a[contains(@title,'%s')]//following::i[contains(@class,'uiIconTrash')]", spaceName));
  }

  private BaseElementFacade ELEMENT_SPACE_MEMBERS_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s/members')]", space));
  }

  private BaseElementFacade ELEMENT_SPACE_SETTINGS_TAB_TOP_BAR(String space) {
    return findByXPathOrCSS(String.format("//*[@id='MiddleToolBar']//*[contains(@href,'%s/settings')]", space));
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

  public void checkThatSpaceDetailsInSearchResultsAreDisplayed(String spaceName, String members) {
    assertWebElementVisible(spaceSearchDetailsCover);
    assertWebElementVisible(spaceSearchDetailsAvatar);
    assertWebElementVisible(spaceSearchDetailsInfo);
    assertWebElementVisible(spaceSearchDetailsThreeDots);
    assertWebElementVisible(spaceSearchDetailsLeaveButton);
    assertWebElementVisible(spaceSearchDetailsSpaceName(spaceName));
    assertWebElementVisible(spaceSearchDetailsSpaceMembers(members));

  }

  public void checkThatSpaceInSearchResultsIsNotDisplayed(String spaceName) {
    assertWebElementNotVisible(spaceSearchDetailsSpaceName(spaceName));
  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String spaceName, String members) {
    assertWebElementVisible(spaceSearchDetailsCover);
    assertWebElementVisible(spaceSearchDetailsAvatar);
    assertWebElementVisible(spaceSearchDetailsInfo);
    assertWebElementVisible(spaceSearchDetailsLeaveButton);
    assertWebElementVisible(spaceSearchDetailsSpaceName(spaceName));
    assertWebElementVisible(spaceSearchDetailsSpaceMembers(members));

  }

  public void uploadSpaceBanner(String fileName) {
    spaceBanner.waitUntilVisible();
    Actions builder = new Actions(driver);
    WebElement spaceBanner = driver.findElement(By.xpath("//*[@class='flex fill-height column']"));
    builder.moveToElement(spaceBanner).build().perform();
    uploadSpaceBannerButton.waitUntilVisible();
    WebElement elem = getDriver().findElement(By.xpath("//*[@class='v-input__prepend-outer']//button/following::input[1]"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(elem);
  }

  public void isSpaceBannerUpdated() {
    spaceBannerUpdated.waitUntilVisible();
    Assert.assertEquals(spaceBannerUpdated.getAttribute("style"), "width: 420px;");
  }

  public void checkThatSpaceTabsAreDisplayedInOrder(String space) {
    // Top Bar Tabs after Space Creation are displayed in order
    Assert.assertTrue(ELEMENT_SPACE_TABS_TOP_BAR_ORDER("1").getAttribute("href")
                                                           .contains(ELEMENT_HOME_SPACE_TAB_TOP_BAR(space.toLowerCase()).getAttribute("href")));

    Assert.assertTrue(ELEMENT_SPACE_TABS_TOP_BAR_ORDER("2").getAttribute("href")
                                                           .contains(ELEMENT_SPACE_MEMBERS_TAB_TOP_BAR(space.toLowerCase()).getAttribute("href")));
  }

  public void clickSecondProcessButton() {
    secondProcessButton.clickOnElement();
  }

  public void openSpaceFormDrawer() {
    addNewSpaceButton.clickOnElement();
  }

  public void setSpaceName(String spaceName) {
    spaceNameInput.setTextValue(spaceName);
  }

  public void spaceNameIsDisplayed(String space) {
    spaceName(space).waitUntilVisible();
  }

  public void spaceAvatarIsDisplayed() {
    spaceAvatar.waitUntilVisible();
  }

  public void goToSpaceHomeViaSpaceAvatar() {
    spaceAvatar.waitUntilVisible();
    spaceAvatar.clickOnElement();
  }

  public void clickFirstProcessButton() {
    firstProcessButton.clickOnElement();
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

  public void clickAddSpaceButton() {
    addSpaceButton.clickOnElement();
  }

  public void insertSpaceNameInSearchField(String spaceName) {
    searchSpaceInput.waitUntilVisible();
    searchSpaceInput.setTextValue(spaceName);

    waitForProgressBar();
  }

  public void goToSpecificSpace(String spaceName) {
    BaseElementFacade element = getSpaceNameInListOfSpace(spaceName);
    element.waitUntilVisible();
    element.clickOnElement();
    verifyPageLoaded();
  }

  public void inviteUserToSpace(String user) {
    inviteUserInput.setTextValue(user + " ");
    inviteUserInput.sendKeys(Keys.BACK_SPACE);
    getSelectUserInDropDown(user).clickOnElement();
  }

  public void deleteSpace(String spaceName) {
    searchSpaceInput.setTextValue(spaceName);
    getSpaceMenu(spaceName).clickOnElement();
    getDeleteSpaceButton(spaceName).clickOnElement();
    okButton.clickOnElement();
    okButton.waitUntilNotVisible();
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
  public void clickSpaceActionToJoin() {
    BaseElementFacade spaceAction = getSpaceAction("Join");
    if (spaceAction != null) {
      clickOnElement(spaceAction);
    } else {
      spaceAction = getSpaceAction("Accept");
      if (spaceAction != null) {
        clickOnElement(spaceAction);
      }
    }
  }

  @SwitchToWindow
  public boolean isSpaceMenuDisplayed() {
    try {
      BaseElementFacade webElementFacade = findByXPathOrCSS("//*[contains(@class, 'v-tab--active')]");
      webElementFacade.setImplicitTimeout(Duration.ofSeconds(0));
      return webElementFacade.isDisplayed();
    } catch (RuntimeException e) {
      return false;
    }
  }

  private BaseElementFacade getSpaceFirstNavigationTab() {
    return findByXPathOrCSS("//*[contains(@class, 'spaceNavigationTab')]");
  }

  private BaseElementFacade getSpaceElement(String space) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'brandingContainer space')]//*[contains(text(),'%s')]",
                                          space));
  }

  public void goToSpaceToAcceptInvitation(String spaceName) {
    getSpaceNameInListOfSpace(spaceName).waitUntilVisible();
    getSpaceNameInListOfSpace(spaceName).clickOnElement();
  }

  public boolean isSpacePageOpened(String space) {
    return getSpaceElement(space).isVisibleAfterWaiting();
  }

  public boolean isSpaceCardDisplayed(String space) {
    try {
      BaseElementFacade webElementFacade =
                                findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]",
                                                               space.toLowerCase()));
      webElementFacade.setImplicitTimeout(Duration.ofSeconds(0));
      return webElementFacade.isDisplayed();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public boolean isSpaceCardJoinButtonDisplayed(String space) {
    try {
      BaseElementFacade webElementFacade =
          findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]//ancestor::*[contains(@class, 'spaceCardItem')]//*[contains(text(), 'Join')]//ancestor::button",
                                         space.toLowerCase()));
      webElementFacade.setImplicitTimeout(Duration.ofSeconds(0));
      return webElementFacade.isDisplayed();
    } catch (RuntimeException e) {
      return false;
    }
  }

  public void joinSpaceFromCard(String space) {
    BaseElementFacade webElementFacade =
        findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDisplayName') and contains(@href, ':%s/')]//ancestor::*[contains(@class, 'spaceCardItem')]//*[contains(text(), 'Join')]//ancestor::button",
                                       space.toLowerCase()));
    webElementFacade.clickOnElement();
  }

  public void selectFilter(String filter) {
    if (filter.equals("My spaces"))
      selectSpaceFilter.select().byValue("member");
    else
      selectSpaceFilter.select().byValue("all");
  }

  public void checkDisplayOfTwentySpaces() {
    assertTrue(spaceCardN20.isVisible());
    assertWebElementNotVisible(spaceCardN21);
  }

  public void showMoreSpaces() {
    spacesPage.scrollDown();
    showMoreButton.clickOnElement();
  }

  public void checkDisplayOfOtherSpaces() {
    assertWebElementVisible(spaceCardN21);
  }

  public void clickOnSpaceSettingsTab() {
    spaceSettingsTab.clickOnElement();
  }

  public void checkGeneralSpaceSettings() {
    assertWebElementVisible(editIconOfGeneralSpaceSettings);
  }

  public void checkApplicationsSpaceSettings() {
    assertWebElementVisible(arrowIconOfApplicationsSpaceSettings);
  }

  public void clickOnGeneralSpaceSettings() {
    editIconOfGeneralSpaceSettings.clickOnElement();
  }

  public void checkAvatarSection() {
    assertWebElementVisible(avatarSection);
  }

  public void checkNameSpaceSection() {
    assertWebElementVisible(nameSpaceSection);
  }

  public void checkDescriptionSpaceSection() {
    assertWebElementVisible(descriptionSpaceSection);
  }

  public void checkSpaceTemplateSection() {
    assertWebElementVisible(spaceTemplateSection);
  }

  public void checkHiddenAndSwitchButtonSection() {
    assertWebElementVisible(hiddenSection);
    assertWebElementVisible(switchButton);
  }

  public void checkRegistrationSection() {
    assertWebElementVisible(registrationSection);
  }

  public void checkCancelButton() {
    assertWebElementVisible(cancelButton);
  }

  public void checkUpdateButton() {
    assertWebElementVisible(spaceAppInstallerDrawer);
  }

  public void clickOnArrowIconAppSpaceSettings() {
    arrowIconAppSpaceSettings.clickOnElement();
  }

  public void spaceAppSettingsIsOpened() {
    assertWebElementVisible(spaceAppSettingsPage);
  }

  public void appCardIsDisplayed() {
    assertWebElementVisible(appCard);
  }

  public void plusButtonIsDisplayed() {
    assertWebElementVisible(plusButtonAppSpaceSettings);
  }

  public void clickOn3dotsAppCard() {
    button3dotAppCard.clickOnElement();
  }

  public void removeAppButtonIsDisplayed() {
    assertWebElementVisible(removeAppButton);
  }

  public void moveBeforeAppButtonIsDisplayed() {
    assertWebElementVisible(moveBeforeAppButton);
  }

  public void moveAfterAppButtonIsDisplayed() {
    assertWebElementVisible(moveAfterAppButton);
  }

  public void clickOnPlusButton() {
    plusButtonAppSpaceSettings.clickOnElement();
  }

  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    spaceAppInstallerDrawer.clickOnElement();
  }

  public void checkApplicationsAreDisplayed() {
    assertWebElementVisible(addAppButton);
  }

  public void clickToAddApp(String application) {
    getAppCardNameDrawer(application).clickOnElement();
  }

  public void checkThatAppIsAdded(String application) {
    assertWebElementVisible(getAppCardNameDisplayed(application));
  }

  @FindBy(xpath = "//select[contains(@class,'input-block-level ignore-vuetify-classes my-3')]")
  private static BaseElementFacade spaceTemplateFilter;

  public void selectTemplate(String value) {
    spaceTemplateFilter.waitUntilVisible();
    spaceTemplateFilter.clickOnElement();
    spaceTemplateFilter.selectByValue(value);
  }

  public void goToTasksTab() {
    spaceTasksTab.clickOnElement();
  }

  public void goToSettingsTab() {
    goToSpaceRightTabs.clickOnElement();
    spaceCommunitySettingsTab.clickOnElement();
  }

  public void goToMembersTab() {
    if (spaceMembersTab.isNotVisibleAfterWaiting()) {
      goToSpaceRightTabs.clickOnElement();
    }
    spaceMembersTab.clickOnElement();
  }

  public void addUserToSpace(String user) {
    spaceMembersTab.clickOnElement();
    inviteUserButton.waitUntilVisible();
    BaseElementFacade memberCard = findByXPathOrCSS(String.format("//*[contains(@class, 'userFullname') and contains(text(), '%s')]",
                                                                user));
    if (memberCard.isPresent()) {
      spaceHomePage.removeMember(user);
    }
    inviteUserButton.clickOnElement();
    inviteUserInput.setTextValue(user + " ");
    inviteUserInput.sendKeys(Keys.BACK_SPACE);
    getSelectUserInDropDown(user).clickOnElement();
    inviteUserButtonDrawer.clickOnElement();
  }

  public boolean isLoadMoreButtonDisplayed() {
    return findByXPathOrCSS("#spacesListFooter .loadMoreButton").isCurrentlyVisible();
  }

}
