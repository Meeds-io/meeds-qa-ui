package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.meeds.qa.ui.steps.PeopleSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PeopleStepDefinition {

  @Steps
  private PeopleSteps peopleSteps;

  @Then("^Current User position and points on Leaderboard are displayed$")
  public void areCurrentUserPositionAndPointsOnLeaderboardDisplayed() {
    peopleSteps.areCurrentUserPositionAndPointsOnLeaderboardDisplayed();
  }

  @Then("^First two places on Leaderboard are displayed$")
  public void areTwoFirstPlacesOnLeaderboardDisplayed() {
    peopleSteps.areTwoFirstPlacesOnLeaderboardDisplayed();
  }

  @Then("^First two users points on Leaderboard are displayed$")
  public void areTwoFirstUsersPointsOnLeaderboardDisplayed() {
    peopleSteps.areTwoFirstUsersPointsOnLeaderboardDisplayed();
  }

  @Then("^Add Contact button in People page is displayed$")
  public void checkThatAddContactButtonIsDisplayed() {
    peopleSteps.checkThatAddContactButtonIsDisplayed();
  }

  @Given("^The added user suggestion is displayed$")
  public void checkThatAddedUserSuggestionIsDisplayed() {
    peopleSteps.checkThatAddedUserSuggestionIsDisplayed();
  }

  @Then("^Contact Circular avatar is displayed$")
  public void checkThatCircularAvatarIsDisplayed() {
    peopleSteps.checkThatCircularAvatarIsDisplayed();
  }

  @Given("^The deleted user suggestion is not displayed$")
  public void checkThatDeletedUserSuggestionIsNotDisplayed() {
    peopleSteps.checkThatDeletedUserSuggestionIsNotDisplayed();
  }

  @Given("^Search Filter is displayed in People page$")
  public void checkThatFilterIsDisplayed() {
    peopleSteps.checkThatFilterIsDisplayed();
  }

  @Then("^Contact Fullname in People page is displayed$")
  public void checkThatFullNameIsDisplayed() {
    peopleSteps.checkThatFullNameIsDisplayed();
  }

  @Then("^Contact job in People page is displayed$")
  public void checkThatJobIsDisplayed() {
    peopleSteps.checkThatJobIsDisplayed();
  }

  @Given("^My Connections Pulldown Filter with user '(.*)' is displayed in People page$")
  public void checkThatMyConnectionsPulldownFiltersIsDisplayed(String user) {
    peopleSteps.checkThatMyConnectionsPulldownFiltersIsDisplayed(user);
  }

  @Given("^People Showing Results is displayed in People page$")
  public void checkThatPeopleShowingResultsIsDisplayed() {
    peopleSteps.checkThatPeopleShowingResultsIsDisplayed();
  }

  @Given("^The suggestion widget is existing and displayed two users with Add button and Delete buttons$")
  public void checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons() {
    peopleSteps.checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons();
  }

  @Then("^Contact cover in People page is displayed$")
  public void checkThatTheCoverIsDisplayed() {
    peopleSteps.checkThatTheCoverIsDisplayed();
  }

  @Given("^User Suggestion after deletion is not displayed$")
  public void checkThatUserSuggestionIsNotDisplayed() {
    peopleSteps.checkThatUserSuggestionIsNotDisplayed();
  }

  @Given("^I close Sent Request button$")
  public void closeSentRequestsButton() {
    peopleSteps.closeSentRequestsButton();
  }

  @Given("^I connect to (.*) user$")
  public void connectToUserWithPrefix(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    peopleSteps.connectToUser(userLastName);
  }

  @Given("I connect to the user using the profile")
  public void connectUserProfile() {
    peopleSteps.connectUserProfile();
  }

  @Given("^I delete Sent Request$")
  public void deleteSentRequest() {
    peopleSteps.deleteSentRequest();
  }

  @Given("^I delete the user suggestion$")
  public void deleteUserSuggestion() {
    peopleSteps.deleteUserSuggestion();
  }

  @Given("^I go to the (.*) user profile$")
  public void goToRandomUserProfile(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    peopleSteps.goToUserProfile(userLastName);
  }

  @Given("^I go to Sent Requests$")
  public void goToSentRequests() {
    peopleSteps.goToSentRequests();
  }

  @Given("^I go to the profile '(.*)'$")
  public void goToUserProfile(String user) {
    peopleSteps.goToUserProfile(user);
  }

  @Then("^Leaderboard Widget is displayed with title '(.*)'$")
  public void isLeaderBoardWidgetDisplayed(String title) {
    peopleSteps.isLeaderBoardWidgetDisplayed(title);
  }

}
