package io.meeds.qa.ui.steps;

import java.util.ArrayList;
import java.util.List;

import io.meeds.qa.ui.pages.page.factory.HomePage;

public class HomeSteps {

  private HomePage homePage;

  public void acceptConnectionInvitation(List<String> listOfPeople) {
    for (String peopleName : listOfPeople)
      homePage.acceptConnectionInvitation(peopleName);
  }

  public void acceptRandomSpaceInvitation(String spaceName) {
    homePage.acceptSpaceInvitation(spaceName);
  }

  public void acceptSingleConnectionInvitation(String userName) {
    homePage.goToStreamPage();
    homePage.openConnectionRequestDrawer();
    homePage.acceptConnectionInvitation(userName);
  }

  public void acceptSpaceInvitation(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      homePage.acceptSpaceInvitation(spaceName);
    }

  }

  public void accessToRecentSpaces() {
    homePage.accessToRecentSpaces();
  }

  public void bookmarkActivity(String activity) {
    homePage.bookmarkActivity(activity);
  }

  public void checkConnectionsBadge(String badgeNumber) {
    homePage.isConnectionsBadgeWithNumberVisible(badgeNumber);
  }

  public void checkDisplaySpaceInvitation(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      homePage.checkExistingSpaceInvitation(spaceName);
    }
  }

  public void checkFavIcon(String activity) {
    homePage.checkFavIcon(activity);
  }

  public void checkFavSuccessMessage(String message) {
    homePage.checkFavSuccessMessage(message);
  }

  public void checkNoActivityDisplayed() {
    homePage.checkNoActivityDisplayed();
  }

  public void checkNotDisplaySpaceInvitation(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      homePage.checkNotExistingSpaceInvitation(spaceName);
    }
  }

  public void checkRandomDisplaySpaceInvitation(String space) {
    homePage.checkExistingSpaceInvitation(space);
  }

  public void checkRandomNotDisplaySpaceInvitation(String space) {
    homePage.checkNotExistingSpaceInvitation(space);
  }

  public List<String> checkSections(List<String> elementList) {
    List<String> missingValues = new ArrayList<>();
    for (String elementName : elementList) {
      if (!homePage.isElementVisible(elementName))
        missingValues.add(elementName);
    }
    return missingValues;
  }

  public void checkSpacesBadge(String badgeNumber) {
    homePage.isSpacesBadgeWithNumberVisible(badgeNumber);
  }

  public void checkThatStreamPageIsDisplayed() {
    homePage.checkThatStreamPageIsDisplayed();
  }

  public void clickOnArrowIcon() {
    homePage.clickOnArrowIcon();
  }

  public void clickOnCommentActivityNotification(String message, String activity, String comment) {
    homePage.clickOnCommentActivityNotification(message, activity, comment);
  }

  public void clickOnConnectionsBagde() {
    homePage.clickOnConnectionsBagde();
  }

  public void clickOnHomeButton() {
    homePage.clickOnHomePageButton();
  }

  public void clickOnHomeIcon() {
    homePage.clickOnHomeIcon();
  }

  public void clickOnSpaceInvitationWidget() {
    homePage.clickOnSpaceInvitationWidget();
  }

  public void clickOnSpacesBagde() {
    homePage.clickOnSpacesBagde();
  }

  public void clickSeeAll() {
    homePage.clickSeeAll();
  }

  public void commentActivityNotificationIsDisplayed(String message, String activity, String comment) {
    homePage.commentActivityNotificationIsDisplayed(message, activity, comment);
  }

  public void confirmationForChangeSiteHomeLink() {
    homePage.confirmationForChangeSiteHomeLink();
  }

  public void deactivateSwitcher() {
    homePage.deactivateSwitcher();
  }

  public void favoriteActivity(String activity) {
    homePage.favoriteActivity(activity);
  }

  public void goToAddGroups() {
    homePage.goToAddGroups();
  }

  public void goToAddUser() {
    homePage.goToAddUser();
  }

  public void goToAppCenterAdminSetupPage() {
    homePage.goToAppCenterAdminSetupPage();
  }

  public void goToHomePage() {
    homePage.goToHomePage();
  }

  public void goToManageSpacesPage() {
    homePage.goToSpacesPage();
  }

  public void goToMyProfile() {
    homePage.goToMyProfile();
  }

  public void goToPeoplePage() {
    homePage.goToPeoplePage();
  }

  public void goToProfilePage() {
    homePage.goToProfilePage();
  }

  public void goToSettingsPage() {
    homePage.goToSettingsPage();
  }

  public void goToStreamPage() {
    homePage.goToStreamPage();
  }

  public void goToTasksPage() {
    homePage.goToTasksPage();
  }

  public void hoverOnStreamIcon() {
    homePage.hoverOnStreamIcon();
  }

  public void hoverSearchedSpaceInSideBarFilter(String space) {
    homePage.hoverSearchedSpaceInSideBarFilter(space);
  }

  public void isArrowDisplayedAfterHoveringOnSpaceName() {
    homePage.isArrowDisplayedAfterHoveringOnSpaceName();
  }

  public boolean isConnectionsBadgeWithNumberVisible(String number) {
    return homePage.isConnectionsBadgeWithNumberVisible(number);
  }

  public boolean isNoConnectionsBadge() {
    homePage.goToStreamPage();
    return homePage.isNoConnectionsBadge();
  }

  public boolean isNumberOfConnectionsInDrawer(String number) {
    return homePage.isNumberOfConnectionsInDrawer(Integer.valueOf(number));
  }

  public boolean isNumberOfSpacesInDrawer(String number) {
    return homePage.isNumberOfSpacesInDrawer(Integer.valueOf(number));
  }

  public void isPageOpened(String uriPart) {
    homePage.isPageOpened(uriPart);
  }

  public boolean isSpacesBadgeWithNumberVisible(String number) {
    return homePage.isSpacesBadgeWithNumberVisible(number);
  }

  public void isThirdLevelNavigationDisplayed() {
    homePage.isThirdLevelNavigationDisplayed();
  }

  public boolean isWidgetWithNumberVisible(String widget, String number) {
    return homePage.isWidgetWithNumberVisible(widget, number);
  }

  public void openAllApplicationPage() {
    homePage.openAllApplicationPage();
  }

  public void openAppCenterMenu() {
    homePage.openAppCenterMenu();
  }

  public void openNavigationMenu() {
    homePage.clickOnHamburgerIcon();
  }

  public void openNotifications() {
    homePage.openNotifications();
  }

  public void refreshPage() {
    homePage.refreshPage();
  }

  public void rejectConnexionInvitation(List<String> listOfPeople) {
    for (String peopleName : listOfPeople)
      homePage.rejectConnexionInvitation(peopleName);
  }

  public void rejectRandomSpaceInvitation(String spaceName) {
    homePage.rejectSpaceInvitation(spaceName);
  }

  public void rejectSingleConnectionInvitation(String userName) {
    homePage.rejectConnexionInvitation(userName);
  }

  public void rejectSpaceInvitation(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces)
      homePage.rejectSpaceInvitation(spaceName);
  }

  public void searchApplicationCenter(String app) {
    homePage.searchApplicationCenter(app);
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

  public void selectAllOrMySpaces(String filter) {
    homePage.selectAllOrMySpaces(filter);
  }

  public void unbookmarkActivity(String activity) {
    homePage.unbookmarkActivity(activity);
  }
}
