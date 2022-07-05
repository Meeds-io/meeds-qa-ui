package pages.page.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import pages.GenericPage;

public class HomePage extends GenericPage {

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  private BaseElementFacade    hamburgerNavigationMenuLink;

  @FindBy(xpath = "//*[contains(@class,'selectSpacesFilter')]")
  private BaseElementFacade    selectSpacesFilter;

  @FindBy(xpath = "//a[@href='/portal/meeds/spaces']")
  private BaseElementFacade    openSpacesPageLink;

  @FindBy(xpath = "//a[@href='/portal/meeds/stream']")
  private BaseElementFacade    streamPageLink;

  @FindBy(xpath = "(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[2]")
  private BaseElementFacade    connectionsBadge;

  @FindBy(xpath = "(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[1]")
  private BaseElementFacade    spacesBadge;

  @FindBy(xpath = "//*[@id='ActivityContextBoxWelcomeActivity']")
  private BaseElementFacade    contextBoxWelcomeActivity;

  @FindBy(xpath = "//a[@href='/portal/dw/home']")
  private BaseElementFacade    homePageLink;

  @FindBy(xpath = "//*[@id='tasks']//*[@class='body-1 text-uppercase color-title px-0']")
  private BaseElementFacade    tasksSnapshotPageButton;

  @FindBy(xpath = "//i[contains(@class,'uiIconPeople')]")
  private BaseElementFacade    personnePageLink;

  @FindBy(xpath = "//i[contains(@class,'settingsIcon')]")
  private BaseElementFacade    settingsPageLink;

  @FindBy(xpath = "//a[@href='/portal/dw/profile']")
  private BaseElementFacade    myProfilePageLink;

  @FindBy(xpath = "//a[contains(@class,'seeAllApplicationsBtn')]")
  private BaseElementFacade    viewAllApplicationLink;

  @FindBy(xpath = "//*[@class='v-text-field__slot']//input")
  private TextBoxElementFacade searchApplicationCenterInput;

  @FindBy(id = "appcenterLauncherButton")
  private BaseElementFacade    appCenterButton;

  @FindBy(xpath = "//*[contains(@class,'spacesNavigationTitle')]//*[contains(@class,'titleLabel')]")
  private BaseElementFacade    recentSpacesBtn;

  @FindBy(xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]")
  private TextBoxElementFacade sideBarFilterSpaces;

  @FindBy(
      xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]//*[contains(@class,'v-input recentSpacesFilter')]//input"
  )
  private TextBoxElementFacade sideBarFilterSpacesInput;

  @FindBy(xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleIcon')]//button")
  private BaseElementFacade    filterSpacesSearchIcon;

  @FindBy(xpath = "//*[contains(@class,'recentSpacesWrapper')]//*[@class='v-list-item__content']//div")
  private BaseElementFacade    sideBarFilterSearchedSpace;

  @FindBy(id = "profile-stats-portlet")
  private BaseElementFacade    profileStatsPortlet;

  @FindBy(id = "tasks")
  private BaseElementFacade    tasksContainer;

  @FindBy(xpath = "//*[@id='WalletApp']")
  private BaseElementFacade    walletApplication;

  @FindBy(id = "walletBalance")
  private BaseElementFacade    walletBalance;

  @FindBy(xpath = "//*[@id='walletBalance']//*[contains(@class,'big-number')]")
  private BaseElementFacade    walletBalanceNumber;

  @FindBy(xpath = "//i[contains(@class,'uiAdministrationIcon')]")
  private BaseElementFacade    addministrationMenu;

  @FindBy(xpath = "//a[contains(@href,'appCenterAdminSetup')]")
  private BaseElementFacade    applicationAdminPageLink;

  @FindBy(id = "NotificationPopoverPortlet")
  private BaseElementFacade    notificationIcon;

  @FindBy(xpath = "//i[contains(@class,'logoutIcon')]")
  private BaseElementFacade    logOutMenu;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/usersManagement']")
  private BaseElementFacade    addUserLink;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/groupsManagement']")
  private BaseElementFacade    addGroupsLink;

  @FindBy(xpath = "//a[@href='/portal/dw/profile']")
  private BaseElementFacade    myProfileButton;

  @FindBy(xpath = "//aside[contains(@class,'spaceDrawer')]//button[contains(@class,'closeIcon')]")
  private BaseElementFacade    closeSpaceDrawerButton;

  @FindBy(xpath = "//aside[contains(@class,'v-navigation-drawer')]//span[contains(text(),'See all')]")
  private BaseElementFacade    seeAllLink;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/webconferencing']")
  private BaseElementFacade    webConferencingLink;

  @FindBy(xpath = "(//*[@class='providersTableRow']//*[@class='center actionContainer']/div)[1]")
  private BaseElementFacade    switcherButton;

  @FindBy(xpath = "//a[@href='/portal/dw/stream']//div[@class='v-list-item__icon']")
  private BaseElementFacade    homeIcon;

  @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[1]")
  private BaseElementFacade    firstNotificationContent;

  @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[2]")
  private BaseElementFacade    secondNotificationContent;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private BaseElementFacade    confirmationForChangeSiteHomeLink;

  @FindBy(xpath = "//*[@id='UserHomePortalLink']")
  private BaseElementFacade    homePageButton;

  @FindBy(xpath = "(//*[@class='lastUpdatedTime'])[1]")
  private BaseElementFacade    firstNotificationTimeStamp;

  @FindBy(xpath = "(//*[@class='lastUpdatedTime'])[2]")
  private BaseElementFacade    secondNotificationTimeStamp;

  @FindBy(xpath = "//*[@id='StreamPage']")
  private BaseElementFacade    streamPageView;

  @FindBy(
      xpath = "//*[@class='v-card v-card--flat v-sheet theme--light']//div[@class='headline text-color font-weight-bold pa-1']"
  )
  private BaseElementFacade    spaceInvitaitationWidget;

  private BaseElementFacade getProfileWidgetContent(String widget, String number) {
    return findByXpath(String.format("//div[contains(@class,'profileCard')]//div[contains(@class,'mx-0')]//span[text()='%s']/../..//span[text()='%s']",
                                     widget,
                                     number));
  }

  private List<WebElementFacade> getListSpaceInDrawer() {
    return findAll("//aside[contains(@class,'spaceDrawer ')]//div[@role='list']//descendant::div[@role='listitem']");
  }

  private List<WebElementFacade> getListConnectionInDrawer() {
    return findAll("//aside[contains(@class,'connectionsDrawer ')]//div[@role='list']//descendant::div[@role='listitem']");
  }

  private BaseElementFacade getConnectionsBadgeWithNumber(String number) {
    return findByXpath(
                       String.format("//div[contains(@class,'profileCard')]//*[contains(text(),'Connections')]/preceding::*[@class='v-btn__content' and contains(text(),'%s')][1]",
                                     number));
  }

  private BaseElementFacade getSpacesBadgeWithNumber(String number) {
    return findByXpath(
                       String.format("//div[contains(@class,'profileCard')]//*[contains(text(),'Spaces')]/preceding::*[@class='v-btn__content' and contains(text(),'%s')][1]",
                                     number));
  }

  private BaseElementFacade getRejectIconSpaceFromDrawer(String spaceName) {
    return findByXpath(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
                                     spaceName));
  }

  private BaseElementFacade getAcceptIconSpaceFromDrawer(String spaceName) {
    return findByXpath(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                                     spaceName));
  }

  private BaseElementFacade getAcceptIconConnexionFromDrawer(String spaceName) {
    return findByXpath(String.format("//aside[contains(@class,'connectionsDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                                     spaceName));
  }

  private BaseElementFacade getRejectIconConnexionFromDrawer(String spaceName) {
    return findByXpath(String.format("//aside[contains(@class,'connectionsDrawer')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
                                     spaceName));
  }

  private BaseElementFacade checkSpaceFromDrawer(String spaceName) {
    return findByXpath(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                                     spaceName));
  }

  private Map<String, BaseElementFacade> MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH = new HashMap<>();

  public HomePage(WebDriver driver) {
    super(driver);
    MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.put("Statistique", profileStatsPortlet);
    MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.put("Taches", tasksContainer);
    MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.put("Wallet", walletBalance);
  }

  public void hoverOnRecentSpaces() {
    hamburgerNavigationMenuLink.clickOnElement();
    recentSpacesBtn.hover("//*[contains(@class,'spacesNavigationTitle')]//*[contains(@class,'titleLabel')]");
  }

  public void goToSpacesPage() {
    hamburgerNavigationMenuLink.clickOnElement();
    openSpacesPageLink.clickOnElement();
  }

  public void searchSpaceInSideBarFilter(String space) {
    sideBarFilterSpaces.clickOnElement();
    sideBarFilterSpacesInput.setTextValue(space);
    filterSpacesSearchIcon.clickOnElement();
  }

  public void checkNoActivityDisplayed() {
    contextBoxWelcomeActivity.isVisibleAfterWaiting();
  }

  public void goToStreamPage() {
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    hamburgerNavigationMenuLink.clickOnElement();
    streamPageLink.clickOnElement();
  }

  public void selectAllOrMySpaces(String filter) {
    selectSpacesFilter.selectByVisibleText(filter);
  }

  public void commentActivityNotificationIsDisplayed(String message, String activity, String comment) {
    if (firstNotificationContent.getText().contains(message)) {
      Assert.assertTrue(firstNotificationContent.getText().contains(message));
      Assert.assertTrue(firstNotificationContent.getText().contains(activity));
      Assert.assertTrue(firstNotificationContent.getText().contains(comment));

    } else {
      Assert.assertTrue(secondNotificationContent.getText().contains(message));
      Assert.assertTrue(secondNotificationContent.getText().contains(activity));
      Assert.assertTrue(secondNotificationContent.getText().contains(comment));
    }
  }

  public void clickOnCommentActivityNotification(String message, String activity, String comment) {
    if (firstNotificationContent.getText().contains(message)) {
      Assert.assertTrue(firstNotificationContent.getText().contains(message));
      Assert.assertTrue(firstNotificationContent.getText().contains(activity));
      Assert.assertTrue(firstNotificationContent.getText().contains(comment));
      firstNotificationContent.clickOnElement();

    } else {
      Assert.assertTrue(secondNotificationContent.getText().contains(message));
      Assert.assertTrue(secondNotificationContent.getText().contains(activity));
      Assert.assertTrue(secondNotificationContent.getText().contains(comment));
      secondNotificationContent.clickOnElement();
    }
  }

  public void openAppCenterMenu() {
    appCenterButton.clickOnElement();
  }

  public void goToAddUser() {
    hamburgerNavigationMenuLink.clickOnElement();
    addministrationMenu.clickOnElement();
    addUserLink.clickOnElement();
  }

  public void goToAddGroups() {
    hamburgerNavigationMenuLink.clickOnElement();
    addministrationMenu.clickOnElement();
    addGroupsLink.clickOnElement();
  }

  public boolean isHomePageDisplayed() {
    return hamburgerNavigationMenuLink.isVisibleAfterWaiting();
  }

  public boolean isElementVisible(String elementName) {
    return MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.get(elementName).isVisibleAfterWaiting();
  }

  public void goToHomePage() {
    hamburgerNavigationMenuLink.clickOnElement();
    homePageLink.clickOnElement();
  }

  public void refreshPage() {
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
  }

  public void openNotifications() {
    notificationIcon.clickOnElement();
  }

  public void goToSettingsPageViaUrl() {
    hamburgerNavigationMenuLink.clickOnElement();
    homePageLink.clickOnElement();
  }

  public void goToPeoplePage() {
    hamburgerNavigationMenuLink.clickOnElement();
    personnePageLink.clickOnElement();
  }

  public void searchedSpaceIsDisplayedInSideBarFilter(String space) {
    Assert.assertTrue(sideBarFilterSearchedSpace.getTextValue().contains(space));
  }

  public void searchedSpaceIsNotDisplayedInSideBarFilter(String space) {
    Assert.assertFalse(sideBarFilterSearchedSpace.getTextValue().contains(space));
  }

  public void clickWalletWidget() {
    walletBalanceNumber.waitUntilVisible();
    walletBalanceNumber.clickOnElement();
  }

  public boolean isWalletPageOpened() throws InterruptedException {
    Thread.sleep(5000);
    walletApplication.isVisibleAfterWaiting();
    return Serenity.getWebdriverManager().getCurrentDriver().getTitle().equals("Wallet");
  }

  public boolean isPageOpened(String page) {
    return Serenity.getWebdriverManager().getCurrentDriver().getTitle().equals(page);
  }

  public void logout() {
    hamburgerNavigationMenuLink.clickOnElement();
    logOutMenu.clickOnElement();
  }

  public boolean isWidgetWithNumberVisible(String widget, String number) {
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    return getProfileWidgetContent(widget, number).isVisibleAfterWaiting();
  }

  public boolean isConnectionsBadgeWithNumberVisible(String number) {
    return getConnectionsBadgeWithNumber(number).isVisibleAfterWaiting();
  }

  public boolean isSpacesBadgeWithNumberVisible(String number) {
    return getSpacesBadgeWithNumber(number).isVisibleAfterWaiting();
  }

  public void clickOnSpacesBagde() {
    spacesBadge.clickOnElement();
  }

  public void clickOnConnectionsBagde() {
    connectionsBadge.clickOnElement();
  }

  public boolean isNumberOfSpacesInDrawer(int expectedNumber) {
    int listOfSpaces = getListSpaceInDrawer().size();
    return listOfSpaces == expectedNumber;
  }

  public boolean isNumberOfConnectionsInDrawer(int expectedNumber) {
    int listOfSpaces = getListConnectionInDrawer().size();
    return listOfSpaces == expectedNumber;
  }

  public void rejectSpaceInvitation(String spaceName) {
    getRejectIconSpaceFromDrawer(spaceName).clickOnElement();
  }

  public void acceptSpaceInvitation(String spaceName) {
    getAcceptIconSpaceFromDrawer(spaceName).clickOnElement();
  }

  public void acceptConnexionInvitation(String userName) {
    getAcceptIconConnexionFromDrawer(userName).clickOnElement();
  }

  public void rejectConnexionInvitation(String userName) {
    getRejectIconConnexionFromDrawer(userName).clickOnElement();
  }

  public void closeSpaceDrawer() {
    closeSpaceDrawerButton.clickOnElement();
  }

  public void openAllApplicationPage() {
    viewAllApplicationLink.clickOnElement();
  }

  public void searchApplicationCenter(String app) {
    searchApplicationCenterInput.setTextValue(app);
  }

  public void goToappCenterAdminSetupPage() {
    hamburgerNavigationMenuLink.clickOnElement();
    addministrationMenu.clickOnElement();
    applicationAdminPageLink.clickOnElement();
  }

  public void publishedArticleNotificationIsDisplayed(String message, String article, String space) {
    if (firstNotificationContent.getText().contains(message)) {
      Assert.assertTrue(firstNotificationContent.getText().contains(message));
      Assert.assertTrue(firstNotificationContent.getText().contains(article));
      Assert.assertTrue(firstNotificationContent.getText().contains(space));
      firstNotificationTimeStamp.isVisibleAfterWaiting();

    } else {
      Assert.assertTrue(secondNotificationContent.getText().contains(message));
      Assert.assertTrue(secondNotificationContent.getText().contains(article));
      Assert.assertTrue(secondNotificationContent.getText().contains(space));
      secondNotificationTimeStamp.isVisibleAfterWaiting();
    }
  }

  public void clickOnPublishedArticleNotification(String message, String article, String space) {
    if (firstNotificationContent.getText().contains(message)) {
      Assert.assertTrue(firstNotificationContent.getText().contains(message));
      Assert.assertTrue(firstNotificationContent.getText().contains(article));
      Assert.assertTrue(firstNotificationContent.getText().contains(space));
      firstNotificationTimeStamp.isVisibleAfterWaiting();
      firstNotificationContent.clickOnElement();

    } else {
      Assert.assertTrue(secondNotificationContent.getText().contains(message));
      Assert.assertTrue(secondNotificationContent.getText().contains(article));
      Assert.assertTrue(secondNotificationContent.getText().contains(space));
      secondNotificationTimeStamp.isVisibleAfterWaiting();
      secondNotificationContent.clickOnElement();
    }
  }

  public void goToSettingsPage() {
    hamburgerNavigationMenuLink.clickOnElement();
    settingsPageLink.clickOnElement();
  }

  public void goToMyProfile() {
    hamburgerNavigationMenuLink.clickOnElement();
    myProfileButton.clickOnElement();
  }

  public void goToProfilePage() {
    hamburgerNavigationMenuLink.clickOnElement();
    myProfilePageLink.clickOnElement();
  }

  public void goToTasksPage() {
    tasksSnapshotPageButton.waitUntilVisible();
    tasksSnapshotPageButton.clickOnElement();
  }

  public void clickSeeAll() {
    seeAllLink.clickOnElement();
  }

  public void goToWebConferencingAdminPage() {
    hamburgerNavigationMenuLink.clickOnElement();
    addministrationMenu.clickOnElement();
    webConferencingLink.clickOnElement();
  }

  public void deactivateSwitcher() {
    switcherButton.isVisible();
    switcherButton.clickOnElement();
  }

  public void clickOnHamburgerIcon() {
    hamburgerNavigationMenuLink.clickOnElement();
  }

  public void hoverOnStreamIcon() {
    streamPageLink.hover("//a[@href='/portal/dw/stream']");
  }

  public void clickOnHomeIcon() {
    homeIcon.clickOnElement();
  }

  public void confirmationForChangeSiteHomeLink() {
    confirmationForChangeSiteHomeLink.clickOnElement();
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
  }

  public void clickOnHomePageButton() {
    homePageButton.clickOnElement();
  }

  public void checkThatStreamPageIsDisplayed() {
    streamPageView.isDisplayed();
  }

  public void clickOnSpaceInvitationWidget() {
    spaceInvitaitationWidget.clickOnElement();
  }

  public void checkExistingSpaceInvitation(String spaceName) {
    checkSpaceFromDrawer(spaceName).isDisplayed();
  }

  public void checkNotExistingSpaceInvitation(String spaceName) {
    checkSpaceFromDrawer(spaceName).isNotVisibleAfterWaiting();
  }

  private BaseElementFacade getFavoriteIconActivity(String activity) {
    return findByXpath(String.format(
                                     "//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::i[contains(@class,'fa-star')][01]",
                                     activity));
  }

  public void checkFavIcon(String activity) {
    getFavoriteIconActivity(activity).shouldBeVisible();
  }

  public void favoriteActivity(String activity) {
    getFavoriteIconActivity(activity).clickOnElement();
  }

  private BaseElementFacade getFavoriteSucessMessage(String message) {
    return findByXpath(String.format("//div[@class='v-alert__content']//*[contains(text(),'%s')]", message));
  }

  public void checkFavSuccessMessage(String message) {
    getFavoriteSucessMessage(message).isVisibleAfterWaiting();
  }

  public void unbookmarkActivity(String activity) {
    getFavoriteIconActivity(activity).clickOnElement();
  }

  public void bookmarkActivity(String activity) {
    getFavoriteIconActivity(activity).clickOnElement();
  }

}
