package io.meeds.qa.ui.steps;

import java.util.ArrayList;
import java.util.List;

import io.meeds.qa.ui.pages.page.factory.HomePage;

public class HomeSteps {

  private HomePage homePage;

  public void goToManageSpacesPage() {
    homePage.goToSpacesPage();
  }

  public void checkNoActivityDisplayed() {
    homePage.checkNoActivityDisplayed();
  }

  public void goToStreamPage() {
    homePage.goToStreamPage();
  }

  public void selectAllOrMySpaces(String filter) {
    homePage.selectAllOrMySpaces(filter);
  }

  public void hoverOnRecentSpaces() {
    homePage.hoverOnRecentSpaces();
  }

  public void searchedSpaceIsDisplayedInSideBarFilter(String space) {
    homePage.searchedSpaceIsDisplayedInSideBarFilter(space);
  }

  public void searchedSpaceIsNotDisplayedInSideBarFilter(String space) {
    homePage.searchedSpaceIsNotDisplayedInSideBarFilter(space);
  }

  public void searchSpaceInSideBarFilter(String space) {
    homePage.searchSpaceInSideBarFilter(space);
  }

  public void openAppCenterMenu() {
    homePage.openAppCenterMenu();
  }

  public void openAllApplicationPage() {
    homePage.openAllApplicationPage();
  }

  public void searchApplicationCenter(String app) {
    homePage.searchApplicationCenter(app);
  }

  public void goToProfilePage() {
    homePage.goToProfilePage();
  }

  public void goToTasksPage() {
    homePage.goToTasksPage();
  }

  public List<String> checkSections(List<String> elementList) {
    List<String> missingValues = new ArrayList<>();
    for (String elementName : elementList) {
      if (!homePage.isElementVisible(elementName))
        missingValues.add(elementName);
    }
    return missingValues;
  }

  public void commentActivityNotificationIsDisplayed(String message, String activity, String comment) {
    homePage.commentActivityNotificationIsDisplayed(message, activity, comment);
  }

  public void clickOnCommentActivityNotification(String message, String activity, String comment) {
    homePage.clickOnCommentActivityNotification(message, activity, comment);
  }

  public void goToHomePage() {
    homePage.goToHomePage();
  }

  public void openNotifications() {
    homePage.openNotifications();
  }

  public void refreshPage() {
    homePage.refreshPage();
  }

  public void clickWalletWidget() {
    homePage.clickWalletWidget();
  }

  public boolean checkWalletPage() throws InterruptedException {
    return homePage.isWalletPageOpened();
  }

  public boolean checkPage(String page) {
    return homePage.isPageOpened(page);
  }

  public void goToAddUser() {
    homePage.goToAddUser();
  }

  public void goToAddGroups() {
    homePage.goToAddGroups();
  }

  public boolean isWidgetWithNumberVisible(String widget, String number) {
    return homePage.isWidgetWithNumberVisible(widget, number);
  }

  public boolean isConnectionsBadgeWithNumberVisible(String number) {
    return homePage.isConnectionsBadgeWithNumberVisible(number);
  }

  public boolean isSpacesBadgeWithNumberVisible(String number) {
    return homePage.isSpacesBadgeWithNumberVisible(number);
  }

  public void clickOnConnectionsBagde() {
    homePage.clickOnConnectionsBagde();
  }

  public void checkConnectionsBadge(String badgeNumber) {
    homePage.isConnectionsBadgeWithNumberVisible(badgeNumber);
  }

  public void clickOnSpacesBagde() {
    homePage.clickOnSpacesBagde();
  }

  public void checkSpacesBadge(String badgeNumber) {
    homePage.isSpacesBadgeWithNumberVisible(badgeNumber);
  }

  public boolean isNumberOfSpacesInDrawer(String number) {
    return homePage.isNumberOfSpacesInDrawer(Integer.valueOf(number));
  }

  public boolean isNumberOfConnectionsInDrawer(String number) {
    return homePage.isNumberOfConnectionsInDrawer(Integer.valueOf(number));
  }

  public void rejectSpaceInvitation(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces)
      homePage.rejectSpaceInvitation(spaceName);
  }

  public void acceptSpaceInvitation(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      homePage.acceptSpaceInvitation(spaceName);
    }

  }

  public void acceptRandomSpaceInvitation(String spaceName) {
    homePage.acceptSpaceInvitation(spaceName);
  }

  public void rejectRandomSpaceInvitation(String spaceName) {
    homePage.rejectSpaceInvitation(spaceName);
  }

  public void closeSpaceDrawer() {
    homePage.closeSpaceDrawer();
  }

  public void acceptConnexionInvitation(List<String> listOfPeople) {
    for (String peopleName : listOfPeople)
      homePage.acceptConnexionInvitation(peopleName);
  }

  public void acceptSingleConnectionInvitation(String userName) {
    homePage.acceptConnexionInvitation(userName);
  }

  public void rejectSingleConnectionInvitation(String userName) {
    homePage.rejectConnexionInvitation(userName);
  }

  public void rejectConnexionInvitation(List<String> listOfPeople) {
    for (String peopleName : listOfPeople)
      homePage.rejectConnexionInvitation(peopleName);
  }

  public void goToPeoplePage() {
    homePage.goToPeoplePage();
  }

  public void goToAppCenterAdminSetupPage() {
    homePage.goToappCenterAdminSetupPage();
  }

  public void goToMyProfile() {
    homePage.goToMyProfile();
  }

  public void goToSettingsPage() {
    homePage.goToSettingsPage();
  }

  public void clickSeeAll() {
    homePage.clickSeeAll();
  }

  public void deactivateSwitcher() {
    homePage.deactivateSwitcher();
  }

  public void openNavigationMenu() {
    homePage.clickOnHamburgerIcon();
  }

  public void hoverOnStreamIcon() {
    homePage.hoverOnStreamIcon();
  }

  public void clickOnHomeIcon() {
    homePage.clickOnHomeIcon();
  }

  public void confirmationForChangeSiteHomeLink() {
    homePage.confirmationForChangeSiteHomeLink();
  }

  public void clickOnHomeButton() {
    homePage.clickOnHomePageButton();
  }

  public void checkThatStreamPageIsDisplayed() {
    homePage.checkThatStreamPageIsDisplayed();
  }

  public void clickOnSpaceInvitationWidget() {
    homePage.clickOnSpaceInvitationWidget();
  }

  public void checkDisplaySpaceInvitation(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      homePage.checkExistingSpaceInvitation(spaceName);
    }
  }

  public void checkRandomDisplaySpaceInvitation(String space) {
    homePage.checkExistingSpaceInvitation(space);
  }

  public void checkRandomNotDisplaySpaceInvitation(String space) {
    homePage.checkNotExistingSpaceInvitation(space);
  }

  public void checkNotDisplaySpaceInvitation(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      homePage.checkNotExistingSpaceInvitation(spaceName);
    }
  }

  public void checkFavIcon(String activity) {
    homePage.checkFavIcon(activity);
  }

  public void favoriteActivity(String activity) {
    homePage.favoriteActivity(activity);
  }

  public void checkFavSuccessMessage(String message) {
    homePage.checkFavSuccessMessage(message);
  }

  public void unbookmarkActivity(String activity) {
    homePage.unbookmarkActivity(activity);
  }

  public void bookmarkActivity(String activity) {
    homePage.bookmarkActivity(activity);
  }

  public void goToAppCenterApplications() {
    homePage.goToAppCenterApplications();
  }
}
