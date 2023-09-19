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
package io.meeds.qa.ui.steps.definition;

import static org.assertj.core.api.Assertions.assertThat;
import static io.meeds.qa.ui.utils.Utils.getIndexFomName;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.PeopleSteps;
import io.meeds.qa.ui.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class HomeStepDefinition {
  @Steps
  private HomeSteps   homeSteps;

  @Steps
  private PeopleSteps peopleSteps;

  @When("^I accept the following connection invitation$")
  public void acceptConnection(List<String> listOfPeople) {
    homeSteps.acceptConnectionInvitation(listOfPeople);
  }

  @When("^I accept the connection invitation sent by '(.*)' user$")
  public void acceptConnectionInvitationSentByRandomUser(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + "UserFirstName");
    homeSteps.acceptSingleConnectionInvitation(userFirstName);
  }

  @When("^I accept the following connection invitation from random user$")
  public void acceptConnexion(List<String> listOfPeople) {
    listOfPeople.forEach(userPrefix -> {
      String userFirstName = Serenity.sessionVariableCalled(userPrefix + "UserFirstName");
      homeSteps.acceptSingleConnectionInvitation(userFirstName);
    });
  }

  @When("^I accept the invitation of the following four random spaces$")
  public void acceptFourRandomSpaces() {
    List<String> spaces = new ArrayList<>();
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");
    String fourthRandomSpaceName = Serenity.sessionVariableCalled("fourthRandomSpaceName");

    spaces.add(randomSpaceName);
    spaces.add(secondRandomSpaceName);
    spaces.add(thirdRandomSpaceName);
    spaces.add(fourthRandomSpaceName);
    homeSteps.acceptSpaceInvitation(spaces);
  }

  @When("^I accept the following connection invitation sent by first user and second user$")
  public void acceptRandomConnections() {
    List<String> connections = new ArrayList<>();
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");

    connections.add(firstUserFirstName);
    connections.add(secondUserFirstName);

    homeSteps.acceptConnectionInvitation(connections);
  }

  @When("^I accept the invitation of the following spaces$")
  public void acceptSpaces(List<String> listOfSpace) {
    homeSteps.acceptSpaceInvitation(listOfSpace);
  }

  @When("^I accept the invitation of the following three random spaces$")
  public void acceptThreeRandomSpaces() {
    List<String> spaces = new ArrayList<>();
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");

    spaces.add(randomSpaceName);
    spaces.add(secondRandomSpaceName);
    spaces.add(thirdRandomSpaceName);
    homeSteps.acceptSpaceInvitation(spaces);
  }

  @When("^I access to Recent spaces$")
  public void accessToRecentSpaces() {
    homeSteps.accessToRecentSpaces();
  }

  @And("I unbookmark the activity '{}'")
  @When("I bookmark the activity '{}'")
  public void bookmarkActivity(String activity) {
    homeSteps.bookmarkActivity(activity);
  }

  @Then("^the invitation number for spaces is '(.*)'$")
  public void checkBagde(String number) {
    assertThat(homeSteps.isSpacesBadgeWithNumberVisible(number)).as(String.format("The spaces invitation badge must be %s",
                                                                                  number))
                                                                .isTrue();
  }

  @When("The 'Connections' badge is '{}'")
  public void checkConnectionsBadge(String badgeNumber) {
    homeSteps.checkConnectionsBadge(badgeNumber);
  }

  @Then("^the number of connection requests is '(.*)'$")
  public void checkConnectionBagde(String number) {
    assertThat(homeSteps.isConnectionsBadgeWithNumberVisible(number)).as(String.format("The badge must contains %s connections",
                                                                                       number))
                                                                     .isTrue();
  }

  @Then("^the drawer with '(.*)' connections is opened$")
  public void checkNumberOfConnectionsInDrawer(String number) {
    homeSteps.checkNumberOfConnectionsInDrawer(number);
  }

  @When("the following Space is displayed in Spaces Requests section")
  public void checkDisplaySpaceInvitation(List<String> listOfSpace) {
    homeSteps.checkDisplaySpaceInvitation(listOfSpace);
  }

  @Then("^The favorite star should be displayed in the published activity '(.*)'$")
  public void checkFavIcon(String activity) {
    homeSteps.checkFavIcon(activity);
  }

  @Then("^The favorite success message '(.*)' should be displayed$")
  public void checkFavSuccessMessage(String message) {
    homeSteps.checkFavSuccessMessage(message);
  }

  @Given("No activity is displayed in stream$")
  public void checkNoActivityDisplayed() {
    homeSteps.checkNoActivityDisplayed();
  }

  @When("the following Space is not displayed in Spaces Requests section")
  public void checkNotDisplaySpaceInvitation(List<String> listOfSpace) {
    homeSteps.checkNotDisplaySpaceInvitation(listOfSpace);
  }

  @When("The page '(.*)' is opened$")
  public void checkPageTitle(String uriPart) {
    homeSteps.isPageOpened(uriPart);
  }

  @When("^The Spaces badge is '(.*)'$")
  public void checkSpaceBadge(String badgeNumber) {
    homeSteps.checkSpacesBadge(badgeNumber);
  }

  @Then("^the drawer with '(.*)' spaces is opened$")
  public void checkSpaceDrawer(String number) {
    assertThat(homeSteps.isNumberOfSpacesInDrawer(number)).as(String.format("Le nombre d'espace dans le drawer n'est pas égale à %s",
                                                                            number))
                                                          .isTrue();
  }

  @Then("^'(.*)' page is displayed$")
  public void checkPageIsDisplayed(String pageUri) {
    homeSteps.checkPageIsDisplayed(pageUri);
  }

  @Then("^The '(.*)' number is '(.*)'$")
  public void checkWidgetContent(String widget, String number) {
    assertThat(homeSteps.isWidgetWithNumberVisible(widget, number)).as(String.format("La widget %s doit avoir le nombre %s",
                                                                                     widget,
                                                                                     number))
                                                                   .isTrue();
  }

  @And("^I click on the arrow displayed when hovering the searched space in Side Bar Filter$")
  public void clickOnArrowIcon() {
    homeSteps.clickOnArrowIcon();
  }

  @When("^I click on connections badge$")
  public void clickOnConnectionsBadge() {
    homeSteps.clickOnConnectionsBagde();
  }

  @Given("I close current browser tab")
  public void closeCurrentBrowserTab() {
    Serenity.getDriver().close();
    Serenity.getDriver().switchTo().window(Serenity.sessionVariableCalled("windowHandle"));
  }

  @When("^I click on the notification that shows that activity '(.*)' posted by first user is commented by second user with comment '(.*)'$")
  public void clickOnFirstUserActivityCommentedBySecondUserNotification(String activity, String comment) {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");
    String secondUserFullName = secondUserFirstName + " " + secondUserLastName;

    homeSteps.commentActivityNotificationIsDisplayed("has commented on a post", activity, comment);
    homeSteps.clickOnCommentActivityNotification(secondUserFullName, activity, comment);
  }

  @Given("^My home icon is on '(.*)'")
  public void checkHomeButtonPosition(String pageName) {
    homeSteps.checkHomeButtonPosition(pageName);
  }

  @And("^I click on home page link$")
  public void clickOnHomeLink() {
    homeSteps.clickOnHomeLink();
  }

  @And("^I click on home icon$")
  public void clickOnHomeIcon() {
    homeSteps.clickOnHomeIcon(Serenity.sessionVariableCalled("hoverHomeLink").toString());
  }

  @When("^I click on the notification that shows that comment '(.*)' posted by second user is replied by first user with '(.*)'$")
  public void clickOnSecondUserCommentRepliedByFirstUserNotification(String comment, String reply) {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;

    homeSteps.commentActivityNotificationIsDisplayed("replied to your comment", comment, reply);
    homeSteps.clickOnCommentActivityNotification(firstUserFullName, comment, reply);
  }

  @When("^I click on space invitation widget$")
  public void clickOnSpaceInvitationWidget() {
    homeSteps.clickOnSpaceInvitationWidget();
  }

  @When("^I click on spaces badge$")
  public void clickOnSpacesBadge() {
    homeSteps.clickOnSpacesBagde();
  }

  @Given("^I click on see all$")
  public void clickSeeAll() {
    homeSteps.clickSeeAll();
  }

  @Then("^I click to confirm the new home page$")
  public void confirmationForChangeSiteHomeLink() {
    homeSteps.confirmationForChangeSiteHomeLink();
  }

  @When("^I favorite the activity posted in the space$")
  public void favoriteActivity() {
    String oldActiviyy = Serenity.sessionVariableCalled("activity");
    homeSteps.favoriteActivity(oldActiviyy);
  }

  @Then("^The notification that shows that activity '(.*)' posted by first user is commented by second user with comment '(.*)', is displayed$")
  public void firstUserActivityCommentedBySecondUserNotificationIsDisplayed(String activity, String comment) {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String secondUserFullName = secondUserFirstName + " " + secondUserLastName;

    homeSteps.commentActivityNotificationIsDisplayed("has commented on a post", activity, comment);
    homeSteps.commentActivityNotificationIsDisplayed(secondUserFullName, activity, comment);
  }

  @When("^I go to groups Management page$")
  public void goToAddGroups() {
    homeSteps.goToAddGroups();
  }

  @Given("^I go to Administer application center Page$")
  public void goToAppCenterAdminSetupPage() {
    homeSteps.goToAppCenterAdminSetupPage();
  }

  @Given("I go to notification administration Page")
  public void goToNotificationAdminPage() {
    homeSteps.goToNotificationAdminPage();
  }

  @When("^I go to the home page$")
  public void goToHomePage() {
    homeSteps.goToHomePage();
  }

  @When("^I go to People Page$")
  public void goToPeoplePage() {
    homeSteps.goToPeoplePage();
  }

  @When("^I go to My Profile page$")
  public void goToProfilePage() {
    homeSteps.goToMyProfile();
  }

  @Given("I go to Settings page")
  public void goToSettingsPage() {
    homeSteps.goToSettingsPage();
  }

  @Given("^I go to spaces page$")
  public void goToSpacesPage() {
    homeSteps.goToManageSpacesPage();
  }

  @Given("^I go to Stream page$")
  public void goToStreamPage() {
    homeSteps.goToStreamPage();
  }

  @Given("^I go to Overview page$")
  public void goToOverviewPage() {
    homeSteps.goToOverviewPage();
  }

  @And("^I mouse over the '(.*)' icon in sidebar menu$")
  public void hoverOnPageHomeIcon(String pageName) {
    Serenity.setSessionVariable("hoverHomeLink").to(pageName);
    homeSteps.hoverOnPageHomeIcon(pageName);
  }

  @And("^I hover on the (.*) searched Space In side bar filter$")
  public void hoverSearchedSpaceInSideBarFilter(String spacePrefix) {
    String spaceName = Serenity.sessionVariableCalled(spacePrefix + "RandomSpaceName");
    homeSteps.hoverSearchedSpaceInSideBarFilter(spaceName);
  }

  @And("^The arrow is displayed when hovering on searched space in Side Bar Filter$")
  public void isArrowDisplayedAfterHoveringOnSpaceName() {
    homeSteps.isArrowDisplayedAfterHoveringOnSpaceName();
  }

  @Then("The badge isn't displayed")
  public void isNoConnectionsBadge() {
    assertThat(homeSteps.isNoConnectionsBadge()).as("The badge shouldn't be displayed")
                                                .isTrue();
  }

  @And("^The third level Navigation should display the space details panel$")
  public void checkThirdLevelNavigationDisplayed() {
    homeSteps.checkThirdLevelNavigationDisplayed();
  }

  @When("^I open all application page$")
  public void openAllApplicationPage() {
    homeSteps.openAllApplicationPage();
  }

  @When("^I open the app center menu$")
  public void openAppCenterMenu() {
    homeSteps.openAppCenterMenu();
  }

  @When("^I open Notifications$")
  public void openNotifications() {
    homeSteps.openNotifications();
  }

  @When("^(.*) searched space is displayed in Side Bar Filter$")
  public void randomSearchedSpaceIsDisplayedInSideBarFilter(String spacePrefix) {
    String randomSpaceName = Serenity.sessionVariableCalled(spacePrefix.toLowerCase() + "RandomSpaceName");
    homeSteps.searchedSpaceIsDisplayedInSideBarFilter(randomSpaceName);
  }

  @When("^(.*) searched space is not displayed in Side Bar Filter$")
  public void randomSearchedSpaceIsNotDisplayedInSideBarFilter(String spacePrefix) {
    String randomSpaceName = Serenity.sessionVariableCalled(spacePrefix.toLowerCase() + "RandomSpaceName");
    homeSteps.searchedSpaceIsNotDisplayedInSideBarFilter(randomSpaceName);
  }

  @When("I refresh the page")
  public void refreshPage() {
    Utils.refreshPage();
  }

  @When("^I reject the following connection invitation sent by second user$")
  public void rejectConnectionInvitationSentBySecondUser() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    homeSteps.rejectSingleConnectionInvitation(secondUserFirstName);
  }

  @When("^I reject the invitation of the following connections$")
  public void rejectConnexion(List<String> listOfPeople) {
    homeSteps.rejectConnexionInvitation(listOfPeople);
  }

  @When("^I reject the invitation of the following spaces$")
  public void rejectSpaces(List<String> listOfSpace) {
    homeSteps.rejectSpaceInvitation(listOfSpace);
  }

  @Then("I search for the random created application")
  public void searchApplicationCenter() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    homeSteps.searchApplicationCenter(randomApplicationTitle);
  }

  @Then("I search for the edited random application")
  public void searchEditedApplicationCenter() {
    String editedRandomApplicationTitle = Serenity.sessionVariableCalled("editedRandomApplicationTitle");
    homeSteps.searchApplicationCenter(editedRandomApplicationTitle);
  }

  @When("^Searched space '(.*)' is displayed in Side Bar Filter$")
  public void searchedSpaceIsDisplayedInSideBarFilter(String space) {
    homeSteps.searchedSpaceIsDisplayedInSideBarFilter(space);
  }

  @When("^Searched space '(.*)' is not displayed in Side Bar Filter$")
  public void searchedSpaceIsNotDisplayedInSideBarFilter(String space) {
    homeSteps.searchedSpaceIsNotDisplayedInSideBarFilter(space);
  }

  @When("^I search for the (.*) created space in Side Bar Filter$")
  public void searchRandomSpaceInSideBarFilter(String spacePrefix) {
    String spaceName = Serenity.sessionVariableCalled(spacePrefix + "RandomSpaceName");
    homeSteps.searchSpaceInSideBarFilter(spaceName);
  }

  @Then("I search for the second random created application")
  public void searchSecondApplicationCenter() {
    goToAppCenterAdminSetupPage();
    String secondRandomApplicationTitle = Serenity.sessionVariableCalled("secondRandomApplicationTitle");
    homeSteps.searchApplicationCenter(secondRandomApplicationTitle);
  }

  @When("^I search space '(.*)' in Side Bar Filter$")
  public void searchSpaceInSideBarFilter(String space) {
    homeSteps.searchSpaceInSideBarFilter(space);
  }

  @Then("^The notification that shows that comment '(.*)' posted by second user is replied by first user with '(.*)', is displayed$")
  public void secondUserCommentRepliedByFirstUserNotificationIsDisplayed(String comment, String reply) {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;

    homeSteps.commentActivityNotificationIsDisplayed("replied to your comment", comment, reply);
    homeSteps.commentActivityNotificationIsDisplayed(firstUserFullName, comment, reply);
  }

  @Given("^I select '(.*)'$")
  public void selectAllOrMySpaces(String filter) {
    homeSteps.selectAllOrMySpaces(filter);
  }

  @And("I unbookmark the favorite activity posted in the space")
  public void unbookmarkActivity() {
    String oldActiviyy = Serenity.sessionVariableCalled("activity");
    homeSteps.unbookmarkActivity(oldActiviyy);
  }

  @When("I open hamburger menu drawer")
  public void openHamburgerMenuDrawer() {
    homeSteps.openHamburgerMenuDrawer();
  }

  @When("I stick the hamburger menu")
  public void stickHamburgerMenu() {
    homeSteps.stickHamburgerMenu();
  }

  @When("I unstick the hamburger menu")
  public void unstickHamburgerMenu() {
    homeSteps.unstickHamburgerMenu();
  }

  @Then("The hamburger menu has all navigation elements into it")
  public void checkHamburgerMenuNavigations() {
    homeSteps.checkHamburgerMenuNavigations();
  }

  @Then("The hamburger menu is displayed as stickied")
  public void checkHamburgerMenuSticky() {
    homeSteps.checkHamburgerMenuSticky();
  }

  @Then("The hamburger menu is displayed as unstickied")
  public void checkHamburgerMenuUnsticked() {
    homeSteps.checkHamburgerMenuUnsticked();
  }

  @Then("^The (.*) random space is displayed as (.*) item in recent spaces menu$")
  public void checkHamburgerMenuSpacePosition(String spacePrefix, String spacePosition) {
    String spaceName = Serenity.sessionVariableCalled(spacePrefix + "RandomSpaceName");
    int spaceMenuPosition = getIndexFomName(spacePosition);
    homeSteps.checkHamburgerMenuSpacePosition(spaceName, spaceMenuPosition);
  }

  @Given("^The (.*) random space name and description are displayed in second menu level$")
  public void checkHamburgerMenuSpaceDescriptionAndName(String spacePrefix) {
    String randomSpaceName = sessionVariableCalled(spacePrefix + "RandomSpaceName");
    homeSteps.checkHamburgerMenuSpaceDescriptionAndName(randomSpaceName);
  }

  @Then("^Previously (.*) application in settings is displayed as (.*) menu item in (.*) random space left menu$")
  @And("^The (.*) application in settings is displayed as (.*) menu item in (.*) random space left menu$")
  public void checkHamburgerMenuRecentSpaceMenuApplication(String appSettingPosition, String appMenuPosition, String spacePrefix) {
    String spaceName = Serenity.sessionVariableCalled(spacePrefix + "RandomSpaceName");
    String appName = Serenity.sessionVariableCalled(appSettingPosition + "SettingApplication");
    int appPosition = getIndexFomName(appMenuPosition);
    homeSteps.checkHamburgerMenuRecentSpaceMenuApplication(spaceName, appName, appPosition);
  }

  @Then("^I open the (.*) random space menu details$")
  public void openHamburgerMenuRecentSpaceDetails(String spacePrefix) {
    String spaceName = Serenity.sessionVariableCalled(spacePrefix + "RandomSpaceName");
    homeSteps.openHamburgerMenuRecentSpaceDetails(spaceName);
  }
  
  @Then("The red dot is displayed in the hamburger menu")
  public void checkRedDotInHamburgerMenu() {
    homeSteps.checkRedDotInHamburgerMenu();
  }

  @Then("The red dot is not displayed in the hamburger menu")
  public void checkRedDotNotInHamburgerMenu() {
    homeSteps.checkRedDotNotInHamburgerMenu();
  }
  
  @When("I hover on the hambuger menu")
  public void hoverOnHamburgerMenu() {
    homeSteps.hoverOnHamburgerMenu();
  }
  
  @When("I hover on the drawer overlay")
  public void hoverOutsideHamburgerMenu() {
    homeSteps.hoverOutsideHamburgerMenu();
  }
  
  @Then ("The hamburger menu is closed")
  public void closeHamburgerMenu() {
    homeSteps.closeHamburgerMenu();
  }

}
