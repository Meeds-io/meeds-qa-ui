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
package io.meeds.qa.ui.steps;

import java.util.ArrayList;
import java.util.List;

import io.meeds.qa.ui.pages.HomePage;

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

  public void checkPageIsDisplayed(String pageUri) {
    homePage.checkPageIsDisplayed(pageUri);
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

  public void clickOnHomeLink() {
    homePage.clickOnHomeLink();
  }

  public void clickOnHomeIcon(String pageName) {
    homePage.clickOnHomeIcon(pageName);
  }

  public void checkHomeButtonPosition(String pageName) {
    homePage.checkHomeButtonPosition(pageName);
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

  public void goToSettingsPage() {
    homePage.goToSettingsPage();
  }

  public void goToStreamPage() {
    homePage.goToStreamPage();
  }

  public void goToOverviewPage() {
    homePage.goToOverviewPage();
  }

  public void goToTasksPage() {
    homePage.goToTasksPage();
  }

  public void hoverOnPageHomeIcon(String pageName) {
    homePage.hoverOnPageHomeIcon(pageName);
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

  public void checkThirdLevelNavigationDisplayed() {
    homePage.checkThirdLevelNavigationDisplayed();
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

  public void openNotifications() {
    homePage.openNotifications();
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
    for (String spaceName : listOfSpaces) {
      homePage.rejectSpaceInvitation(spaceName);
    }
  }

  public void checkHamburgerMenuSpacePosition(String spaceName, int spaceMenuPosition) {
    homePage.checkHamburgerMenuSpacePosition(spaceName, spaceMenuPosition);
  }

  public void checkHamburgerMenuRecentSpaceMenuApplication(String spaceName, String appName, int appPosition) {
    homePage.checkHamburgerMenuRecentSpaceMenuApplication(spaceName, appName, appPosition);
  }

  public void openHamburgerMenuRecentSpaceDetails(String spaceName) {
    homePage.openHamburgerMenuRecentSpaceDetails(spaceName);
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

  public void checkHamburgerMenuUnsticked() {
    homePage.checkHamburgerMenuUnsticked();
  }

  public void checkHamburgerMenuSticky() {
    homePage.checkHamburgerMenuSticked();
  }

  public void openHamburgerMenuDrawer() {
    homePage.openHamburgerMenuDrawer();
  }

  public void checkHamburgerMenuNavigations() {
    homePage.checkHamburgerMenuNavigations();
  }

  public void stickHamburgerMenu() {
    homePage.stickHamburgerMenu();
  }

  public void unstickHamburgerMenu() {
    homePage.unstickHamburgerMenu();
  }

  public boolean isPortalDisplayed() {
    return homePage.isPortalDisplayed();
  }

  public void checkHamburgerMenuSpaceDescriptionAndName(String randomSpaceName) {
    homePage.checkHamburgerMenuSpaceDescriptionAndName(randomSpaceName);
  }
  
  public void checkRedDotInHamburgerMenu() {
    homePage.checkRedDotInHamburgerMenu();
  }

  public void checkRedDotNotInHamburgerMenu() {
    homePage.checkRedDotNotInHamburgerMenu();
  }

}
