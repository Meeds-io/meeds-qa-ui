package io.meeds.qa.ui.steps.definition;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.PeopleSteps;
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

  @And("I unbookmark the activity '{}'")
  @When("I bookmark the activity '{}'")
  public void bookmarkActivity(String activity) {
    homeSteps.bookmarkActivity(activity);
  }

  @Then("^the invitation number for spaces is '(.*)'$")
  public void checkBagde(String number) {
    assertThat(homeSteps.isSpacesBadgeWithNumberVisible(number)).as(String.format("La badge doit avoir le nombre %s", number))
                                                                .isTrue();
  }

  @When("The 'Connections' badge is '{}'")
  public void checkConnectionsBadge(String badgeNumber) {
    homeSteps.checkConnectionsBadge(badgeNumber);
  }

  @Then("^the number of connection requests is '(.*)'$")
  public void checkConnexionBagde(String number) {
    assertThat(homeSteps.isConnectionsBadgeWithNumberVisible(number)).as(String.format("The badge must contains %s connections",
                                                                                       number))
                                                                     .isTrue();
  }

  @Then("^the drawer with '(.*)' connections is opened$")
  public void checkConnexionDrawer(String number) {
    assertThat(homeSteps.isNumberOfConnectionsInDrawer(number)).as(String.format("Le nombre de connexions dans le drawer n'est pas égale à %s",
                                                                                 number))
                                                               .isTrue();
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

  @When("^The '(.*)' page is opened$")
  public void checkPage(String page) {
    assertThat(homeSteps.checkPage(page)).as(page + " page is not opened").isTrue();
  }

  @When("the following sections are displayed")
  public void checkSections(List<String> sliderList) {
    assertThat(homeSteps.checkSections(sliderList)).as(String.format("The section %s is not visible",
                                                                     homeSteps.checkSections(sliderList)))
                                                   .isEmpty();
  }

  @When("The 'Spaces' badge is '{}'")
  public void checkSpaceBadge(String badgeNumber) {
    homeSteps.checkSpacesBadge(badgeNumber);
  }

  @Then("^the drawer with '(.*)' spaces is opened$")
  public void checkSpaceDrawer(String number) {
    assertThat(homeSteps.isNumberOfSpacesInDrawer(number)).as(String.format("Le nombre d'espace dans le drawer n'est pas égale à %s",
                                                                            number))
                                                          .isTrue();
  }

  @Then("^Activity Stream page is displayed$")
  public void checkThatStreamPageIsDisplayed() {
    homeSteps.checkThatStreamPageIsDisplayed();
  }

  @Then("The wallet page is opened")
  public void checkWalletPage() throws InterruptedException {
    assertThat(homeSteps.checkWalletPage()).as("Wallet page is not opened").isTrue();
  }

  @Then("^The '(.*)' number is '(.*)'$")
  public void checkWidgetContent(String widget, String number) {
    assertThat(homeSteps.isWidgetWithNumberVisible(widget, number)).as(String.format("La widget %s doit avoir le nombre %s",
                                                                                     widget,
                                                                                     number))
                                                                   .isTrue();
  }

  @When("^I click on connections badge$")
  public void clickOnConnectionsBadge() {
    homeSteps.clickOnConnectionsBagde();
  }

  @When(
    "^I click on the notification that shows that activity '(.*)' posted by first user is commented by second user with comment '(.*)'$"
  )
  public void clickOnFirstUserActivityCommentedBySecondUserNotification(String activity, String comment) {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String secondUserFullName = secondUserFirstName + " " + secondUserLastName;

    String message = secondUserFullName + " has commented on a post";
    homeSteps.clickOnCommentActivityNotification(message, activity, comment);
  }

  @And("^I click on home page button$")
  public void clickOnHomeButton() {
    homeSteps.clickOnHomeButton();
  }

  @And("^I click on home icon$")
  public void clickOnHomeIcon() {
    homeSteps.clickOnHomeIcon();
  }

  @When("^I click on the notification that shows that comment '(.*)' posted by second user is replied by first user with '(.*)'$")
  public void clickOnSecondUserCommentRepliedByFirstUserNotification(String comment, String reply) {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;

    String message = firstUserFullName + " replied to your comment";
    homeSteps.clickOnCommentActivityNotification(message, comment, reply);
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

  @When("^I click on wallet label$")
  public void clickWallet() {
    homeSteps.clickWalletWidget();
  }

  @Then("^I close Space Drawer$")
  public void closeSpaceDrawer() {
    homeSteps.closeSpaceDrawer();

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

  @When("^(.*) searched space is not displayed in Side Bar Filter$")
  public void randomSearchedSpaceIsNotDisplayedInSideBarFilter(String spacePrefix) {
    String randomSpaceName = Serenity.sessionVariableCalled(spacePrefix.toLowerCase() + "RandomSpaceName");
    homeSteps.searchedSpaceIsNotDisplayedInSideBarFilter(randomSpaceName);
  }

  @Then(
    "^The notification that shows that activity '(.*)' posted by first user is commented by second user with comment '(.*)', is displayed$"
  )
  public void firstUserActivityCommentedBySecondUserNotificationIsDisplayed(String activity, String comment) {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String secondUserFullName = secondUserFirstName + " " + secondUserLastName;

    String message = secondUserFullName + " has commented on a post";
    homeSteps.commentActivityNotificationIsDisplayed(message, activity, comment);
  }

  @When("^I go to groups Management page$")
  public void goToAddGroups() {
    homeSteps.goToAddGroups();
  }

  @Given("^I go to Administer application center Page$")
  public void goToAppCenterAdminSetupPage() {
    homeSteps.goToAppCenterAdminSetupPage();
  }

  @Then("my applications button is displayed")
  public void goToAppCenterApplications() {
    homeSteps.goToAppCenterApplications();
  }

  @When("^I go to the home page$")
  public void goToHomePage() {
    homeSteps.goToHomePage();
  }

  @When("^I go to my profile$")
  public void goToMyProfile() {
    homeSteps.goToMyProfile();
  }

  @When("^I go to Person Page$")
  public void goToPeoplePage() {
    homeSteps.goToPeoplePage();
  }

  @When("^I go to My Profile page$")
  public void goToProfilePage() {
    homeSteps.goToProfilePage();
  }

  @Given("^I go to Settings page$")
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

  @When("^I go to Tasks Page$")
  public void goToTasksPage() {
    homeSteps.goToTasksPage();
  }

  @When("^I hover on Recent spaces$")
  public void hoverOnRecentSpaces() {
    homeSteps.hoverOnRecentSpaces();
  }

  @And("^I mouse over the stream icon in sidebar menu$")
  public void hoverOnStreamIcon() {
    homeSteps.hoverOnStreamIcon();
  }

  @Then("The badge isn't displayed")
  public void isNoConnectionsBadge() {
    assertThat(homeSteps.isNoConnectionsBadge()).as("The badge shouldn't be displayed")
                                                .isTrue();
  }

  @When("^I open all application page$")
  public void openAllApplicationPage() {
    homeSteps.openAllApplicationPage();
  }

  @When("^I open the app center menu$")
  public void openAppCenterMenu() {
    homeSteps.openAppCenterMenu();
  }

  @And("^I open Navigation menu$")
  public void openNavigationMenu() {
    homeSteps.openNavigationMenu();
  }

  @When("^I open Notifications$")
  public void openNotifications() {
    homeSteps.openNotifications();
  }

  @When("^I refresh the page$")
  public void refreshPage() {
    homeSteps.refreshPage();
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

  @When("^(.*) searched space is displayed in Side Bar Filter$")
  public void randomSearchedSpaceIsDisplayedInSideBarFilter(String spacePrefix) {
    String randomSpaceName = Serenity.sessionVariableCalled(spacePrefix.toLowerCase() + "RandomSpaceName");
    homeSteps.searchedSpaceIsDisplayedInSideBarFilter(randomSpaceName);
  }

  @Then(
    "^The notification that shows that comment '(.*)' posted by second user is replied by first user with '(.*)', is displayed$"
  )
  public void secondUserCommentRepliedByFirstUserNotificationIsDisplayed(String comment, String reply) {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;

    String message = firstUserFullName + " replied to your comment";
    homeSteps.commentActivityNotificationIsDisplayed(message, comment, reply);
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

}
