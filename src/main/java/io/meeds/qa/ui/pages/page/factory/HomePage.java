package io.meeds.qa.ui.pages.page.factory;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends GenericPage {

  private static final Map<String, BaseElementFacade> MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH = new HashMap<>();

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  private BaseElementFacade                           hamburgerNavigationMenuLink;

  @FindBy(xpath = "//*[contains(@class,'selectSpacesFilter')]")
  private BaseElementFacade                           selectSpacesFilter;

  @FindBy(xpath = "//a[@href='/portal/meeds/spaces']")
  private BaseElementFacade                           openSpacesPageLink;

  @FindBy(xpath = "(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[2]")
  private BaseElementFacade                           connectionsBadge;

  @FindBy(xpath = "(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[1]")
  private BaseElementFacade                           spacesBadge;

  @FindBy(xpath = "//*[@id='ActivityContextBoxWelcomeActivity']")
  private BaseElementFacade                           contextBoxWelcomeActivity;

  @FindBy(xpath = "//*[@id='tasks']//*[@class='body-1 text-uppercase color-title px-0']")
  private BaseElementFacade                           tasksSnapshotPageButton;

  @FindBy(xpath = "//i[contains(@class,'uiIconStream')]")
  private BaseElementFacade                           streamPageLink;

  @FindBy(xpath = "//i[contains(@class,'uiIconPeople')]")
  private BaseElementFacade                           personnePageLink;

  @FindBy(xpath = "//i[contains(@class,'settingsIcon')]")
  private BaseElementFacade                           settingsPageLink;

  @FindBy(xpath = "//a[@href='/portal/meeds/profile']")
  private BaseElementFacade                           myProfilePageLink;

  @FindBy(xpath = "//a[contains(@class,'seeAllApplicationsBtn')]")
  private BaseElementFacade                           viewAllApplicationLink;

  @FindBy(xpath = "//*[@class='v-text-field__slot']//input")
  private TextBoxElementFacade                        searchApplicationCenterInput;

  @FindBy(id = "appcenterLauncherButton")
  private BaseElementFacade                           appCenterButton;

  @FindBy(xpath = "//*[contains(@class,'spacesNavigationTitle')]//*[contains(@class,'titleLabel')]")
  private BaseElementFacade                           recentSpacesBtn;

  @FindBy(xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]")
  private TextBoxElementFacade                        sideBarFilterSpaces;

  @FindBy(
      xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]//*[contains(@class,'v-input recentSpacesFilter')]//input"
  )
  private TextBoxElementFacade                        sideBarFilterSpacesInput;

  @FindBy(xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleIcon')]//button")
  private BaseElementFacade                           filterSpacesSearchIcon;

  @FindBy(xpath = "//*[contains(@class,'recentSpacesWrapper')]//*[@class='v-list-item__content']//div")
  private BaseElementFacade                           sideBarFilterSearchedSpace;

  @FindBy(id = "profile-stats-portlet")
  private BaseElementFacade                           profileStatsPortlet;

  @FindBy(id = "tasks")
  private BaseElementFacade                           tasksContainer;

  @FindBy(xpath = "//*[@id='WalletApp']")
  private BaseElementFacade                           walletApplication;

  @FindBy(id = "walletBalance")
  private BaseElementFacade                           walletBalance;

  @FindBy(xpath = "//*[@id='walletBalance']//*[contains(@class,'big-number')]")
  private BaseElementFacade                           walletBalanceNumber;

  @FindBy(xpath = "//i[contains(@class,'uiAdministrationIcon')]")
  private BaseElementFacade                           administrationMenu;

  @FindBy(xpath = "//a[contains(@href,'appCenterAdminSetup')]")
  private BaseElementFacade                           applicationAdminPageLink;

  @FindBy(id = "NotificationPopoverPortlet")
  private BaseElementFacade                           notificationIcon;

  @FindBy(xpath = "//i[contains(@class,'logoutIcon')]")
  private BaseElementFacade                           logOutMenu;

  @FindBy(xpath = "//a[contains(@href, 'usersManagement')]")
  private BaseElementFacade                           addUserLink;

  @FindBy(xpath = "//a[contains(@href, 'groupsManagement')]")
  private BaseElementFacade                           addGroupsLink;

  @FindBy(xpath = "//a[@href='/portal/meeds/profile']")
  private BaseElementFacade                           myProfileButton;

  @FindBy(xpath = "//aside[contains(@class,'spaceDrawer')]//button[contains(@class,'closeIcon')]")
  private BaseElementFacade                           closeSpaceDrawerButton;

  @FindBy(xpath = "//aside[contains(@class,'v-navigation-drawer')]//span[contains(text(),'See all')]")
  private BaseElementFacade                           seeAllLink;

  @FindBy(xpath = "(//*[@class='providersTableRow']//*[@class='center actionContainer']/div)[1]")
  private BaseElementFacade                           switcherButton;

  @FindBy(xpath = "//a[@href='/portal/meeds/stream']//div[@class='v-list-item__icon']")
  private BaseElementFacade                           homeIcon;

  @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[1]")
  private BaseElementFacade                           firstNotificationContent;

  @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[2]")
  private BaseElementFacade                           secondNotificationContent;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private BaseElementFacade                           confirmationForChangeSiteHomeLink;

  @FindBy(xpath = "//*[@id='UserHomePortalLink']")
  private BaseElementFacade                           homePageButton;

  @FindBy(xpath = "(//*[@class='lastUpdatedTime'])[1]")
  private BaseElementFacade                           firstNotificationTimeStamp;

  @FindBy(xpath = "(//*[@class='lastUpdatedTime'])[2]")
  private BaseElementFacade                           secondNotificationTimeStamp;

  @FindBy(xpath = "//*[@id='StreamPage']")
  private BaseElementFacade                           streamPageView;

  @FindBy(
      xpath = "//*[@class='v-card v-card--flat v-sheet theme--light']//div[@class='headline text-color font-weight-bold pa-1']"
  )
  private BaseElementFacade                           spaceInvitaitationWidget;

  private BaseElementFacade getProfileWidgetContent(String widget, String number) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'profileCard')]//div[contains(@class,'mx-0')]//span[text()='%s']/../..//span[text()='%s']",
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
    return findByXPathOrCSS(
                            String.format("//div[contains(@class,'profileCard')]//*[contains(text(),'Connections')]/preceding::*[@class='v-btn__content' and contains(text(),'%s')][1]",
                                          number));
  }

  private BaseElementFacade getConnectionsBadge() {
    return findByXPathOrCSS("//div[contains(@class,'profileCard')]//*[contains(text(),'Connections')]/preceding::*[@class='v-btn__content'][1]");
  }

  private BaseElementFacade getSpacesBadgeWithNumber(String number) {
    return findByXPathOrCSS(
                            String.format("//div[contains(@class,'profileCard')]//*[contains(text(),'Spaces')]/preceding::*[@class='v-btn__content' and contains(text(),'%s')][1]",
                                          number));
  }

  private BaseElementFacade getRejectIconSpaceFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
                                          spaceName));
  }

  private BaseElementFacade getAcceptIconSpaceFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                                          spaceName));
  }

  private BaseElementFacade getAcceptIconConnectionFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'connectionsDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                                          spaceName));
  }

  private BaseElementFacade getRejectIconConnectionFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'connectionsDrawer')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
                                          spaceName));
  }

  private BaseElementFacade checkSpaceFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                                          spaceName));
  }

  public HomePage(WebDriver driver) {
    super(driver);
    MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.put("Statistique", profileStatsPortlet);
    MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.put("Taches", tasksContainer);
    MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.put("Wallet", walletBalance);
  }

  public void hoverOnRecentSpaces() {
    clickOnHamburgerMenu();
    retryOnCondition(() -> {
      recentSpacesBtn.waitUntilVisible();
      recentSpacesBtn.hover("//*[contains(@class,'spacesNavigationTitle')]//*[contains(@class,'titleLabel')]");
      waitFor(300).milliseconds(); // Wait until drawer 'open' animation
                                   // finishes
    }, () -> {
      if (!hamburgerNavigationMenuLink.isVisible()) {
        this.refreshPage();
        this.clickOnHamburgerIcon();
      }
    });
  }

  public void hoverOnAdministrationMenu() {
    clickOnHamburgerMenu();
    retryOnCondition(() -> {
      administrationMenu.waitUntilVisible();
      administrationMenu.hover("//*[contains(@class,'administrationTitle')]//*[contains(@class,'titleLabel')]");
      waitFor(300).milliseconds(); // Wait until drawer 'open' animation
      // finishes
      BaseElementFacade administrationMenuElement = findByXPathOrCSS("#AdministrationHamburgerNavigation");
      administrationMenuElement.waitUntilVisible();
    }, () -> {
      if (!hamburgerNavigationMenuLink.isVisible()) {
        this.refreshPage();
        this.clickOnHamburgerIcon();
      }
    });
  }

  public void goToSpacesPage() {
    clickOnHamburgerMenu();
    clickOnElement(openSpacesPageLink);
  }

  public void searchSpaceInSideBarFilter(String space) {
    clickOnElement(sideBarFilterSpaces);
    sideBarFilterSpacesInput.setTextValue(space);
    clickOnElement(filterSpacesSearchIcon);
  }

  public void checkNoActivityDisplayed() {
    contextBoxWelcomeActivity.isVisibleAfterWaiting();
  }

  public void goToStreamPage() {
    if (!hamburgerNavigationMenuLink.isClickable()) {
      driver.navigate().refresh();
    }
    clickOnHamburgerMenu();
    clickOnElement(streamPageLink);
  }

  public void selectAllOrMySpaces(String filter) {
    selectSpacesFilter.selectByVisibleText(filter);
  }

  public void commentActivityNotificationIsDisplayed(String message, String activity, String comment) {
    if (firstNotificationContent.getText().contains(message)) {
      Assert.assertTrue(firstNotificationContent.getText().contains(message)); // NOSONAR
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
      clickOnElement(firstNotificationContent);

    } else {
      Assert.assertTrue(secondNotificationContent.getText().contains(message));
      Assert.assertTrue(secondNotificationContent.getText().contains(activity));
      Assert.assertTrue(secondNotificationContent.getText().contains(comment));
      clickOnElement(secondNotificationContent);
    }
  }

  public void openAppCenterMenu() {
    clickOnElement(appCenterButton);
  }

  @SwitchToWindow
  public void goToAddUser() {
    if (!StringUtils.contains(driver.getCurrentUrl(), "usersManagement")) {
      hoverOnAdministrationMenu();
      clickOnElement(addUserLink);
    }
  }

  @SwitchToWindow
  public void goToAddGroups() {
    if (!StringUtils.contains(driver.getCurrentUrl(), "groupsManagement")) {
      hoverOnAdministrationMenu();
      clickOnElement(addGroupsLink);
    }
  }

  public boolean isHomePageDisplayed() {
    return hamburgerNavigationMenuLink.isVisibleAfterWaiting();
  }

  public boolean isElementVisible(String elementName) {
    return MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.get(elementName).isVisibleAfterWaiting();
  }

  public void goToHomePage() {
    try {
      driver.switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
    driver.get(driver.getCurrentUrl().split("/portal/")[0]);
    verifyPageLoaded();
  }

  public void openNotifications() {
    clickOnElement(notificationIcon);
  }

  public void goToPeoplePage() {
    clickOnHamburgerMenu();
    clickOnElement(personnePageLink);
  }

  public void searchedSpaceIsDisplayedInSideBarFilter(String space) {
    Assert.assertTrue(sideBarFilterSearchedSpace.getTextValue().contains(space));
  }

  public void searchedSpaceIsNotDisplayedInSideBarFilter(String space) {
    Assert.assertFalse(sideBarFilterSearchedSpace.getTextValue().contains(space));
  }

  public void clickWalletWidget() {
    clickOnElement(walletBalanceNumber);
  }

  public boolean isWalletPageOpened() {
    walletApplication.isVisibleAfterWaiting();
    return driver.getTitle().equals("Wallet");
  }

  public boolean isPageOpened(String page) {
    return driver.getTitle().equals(page);
  }

  public void logout() {
    if (hamburgerNavigationMenuLink.isPresent()) {
      clickOnHamburgerMenu();
      logOutMenu.clickOnElement();
      verifyPageLoaded();
    }
  }

  public boolean isWidgetWithNumberVisible(String widget, String number) {
    driver.navigate().refresh();
    return getProfileWidgetContent(widget, number).isVisibleAfterWaiting();
  }

  public boolean isConnectionsBadgeWithNumberVisible(String number) {
    return getConnectionsBadgeWithNumber(number).isVisibleAfterWaiting();
  }

  public boolean isNoConnectionsBadge() {
    return !getConnectionsBadge().isVisible();
  }

  public boolean isSpacesBadgeWithNumberVisible(String number) {
    return getSpacesBadgeWithNumber(number).isVisibleAfterWaiting();
  }

  public void clickOnSpacesBagde() {
    clickOnElement(spacesBadge);
  }

  public void clickOnConnectionsBagde() {
    clickOnElement(connectionsBadge);
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
    clickOnElement(getRejectIconSpaceFromDrawer(spaceName));
  }

  public void acceptSpaceInvitation(String spaceName) {
    clickOnElement(getAcceptIconSpaceFromDrawer(spaceName));
  }

  public void acceptConnectionInvitation(String userName) {
    clickOnElement(getAcceptIconConnectionFromDrawer(userName));
  }

  public void rejectConnexionInvitation(String userName) {
    clickOnElement(getRejectIconConnectionFromDrawer(userName));
  }

  public void closeSpaceDrawer() {
    clickOnElement(closeSpaceDrawerButton);
  }

  public void openAllApplicationPage() {
    clickOnElement(viewAllApplicationLink);
  }

  public void searchApplicationCenter(String app) {
    searchApplicationCenterInput.setTextValue(app);
  }

  @SwitchToWindow
  public void goToAppCenterAdminSetupPage() {
    hoverOnAdministrationMenu();
    clickOnElement(applicationAdminPageLink);
  }

  public void goToSettingsPage() {
    clickOnHamburgerMenu();
    clickOnElement(settingsPageLink);
  }

  public void goToMyProfile() {
    clickOnHamburgerMenu();
    clickOnElement(myProfileButton);
  }

  public void goToProfilePage() {
    clickOnHamburgerMenu();
    clickOnElement(myProfilePageLink);
  }

  public void goToTasksPage() {
    clickOnElement(tasksSnapshotPageButton);
  }

  public void clickSeeAll() {
    clickOnElement(seeAllLink);
  }

  public void deactivateSwitcher() {
    switcherButton.isVisible();
    clickOnElement(switcherButton);
  }

  public void clickOnHamburgerIcon() {
    clickOnHamburgerMenu();
  }

  @SwitchToWindow
  public void hoverOnStreamIcon() {
    waitFor(300).milliseconds(); // Wait until drawer 'open' animation finishes
    streamPageLink.hover("//a[@href='/portal/meeds/stream']");
  }

  public void clickOnHomeIcon() {
    clickOnElement(homeIcon);
  }

  public void confirmationForChangeSiteHomeLink() {
    clickOnElement(confirmationForChangeSiteHomeLink);
    driver.navigate().refresh();
  }

  public void clickOnHomePageButton() {
    clickOnElement(homePageButton);
  }

  public void checkThatStreamPageIsDisplayed() {
    streamPageView.isDisplayed();
  }

  public void clickOnSpaceInvitationWidget() {
    clickOnElement(spaceInvitaitationWidget);
  }

  public void checkExistingSpaceInvitation(String spaceName) {
    checkSpaceFromDrawer(spaceName).isDisplayed();
  }

  public void checkNotExistingSpaceInvitation(String spaceName) {
    checkSpaceFromDrawer(spaceName).isNotVisibleAfterWaiting();
  }

  private BaseElementFacade getFavoriteIconActivity(String activity) {
    return findByXPathOrCSS(String.format(
                                          "//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::i[contains(@class,'fa-star')][01]",
                                          activity));
  }

  public void checkFavIcon(String activity) {
    getFavoriteIconActivity(activity).shouldBeVisible();
  }

  public void favoriteActivity(String activity) {
    clickOnElement(getFavoriteIconActivity(activity));
  }

  private BaseElementFacade getFavoriteSucessMessage(String message) {
    return findByXPathOrCSS(String.format("//div[@class='v-alert__content']//*[contains(text(),'%s')]", message));
  }

  public void checkFavSuccessMessage(String message) {
    getFavoriteSucessMessage(message).isVisibleAfterWaiting();
  }

  public void unbookmarkActivity(String activity) {
    clickOnElement(getFavoriteIconActivity(activity));
  }

  public void bookmarkActivity(String activity) {
    clickOnElement(getFavoriteIconActivity(activity));
  }

  private void clickOnHamburgerMenu() {
    retryOnCondition(hamburgerNavigationMenuLink::clickOnElement, this::refreshPage);
  }

  public void goToAppCenterApplications() {
    appCenterButton.clickOnElement();
  }

  public void openConnectionRequestDrawer() {
    BaseElementFacade badgeButton = findByXPathOrCSS("#profile-stats-connectionsCount .v-badge button");
    clickOnElement(badgeButton);
  }

}
