package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.meeds.qa.ui.steps.PeopleSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PeopleStepDefinition {

  @Steps
  private PeopleSteps peopleSteps;

  @Given("^Search Filter is displayed in People page$")
  public void checkThatFilterIsDisplayed() {
    peopleSteps.checkThatFilterIsDisplayed();
  }

  @Given("^I connect to (.*) user$")
  public void connectToUserWithPrefix(String userPrefix) {
    String userName = Serenity.sessionVariableCalled(userPrefix + "UserName");
    peopleSteps.connectToUser(userName);
  }

  @Given("^Pulldown Filter is displayed in People page$")
  public void checkThatPulldownFiltersIsDisplayed() {
    peopleSteps.checkThatPulldownFiltersIsDisplayed();
  }

  @Given("^People Showing Results is displayed in People page$")
  public void checkThatPeopleShowingResultsIsDisplayed() {
    peopleSteps.checkThatPeopleShowingResultsIsDisplayed();
  }

  @Given("^My Connections Pulldown Filter with user '(.*)' is displayed in People page$")
  public void checkThatMyConnectionsPulldownFiltersIsDisplayed(String user) {
    peopleSteps.checkThatMyConnectionsPulldownFiltersIsDisplayed(user);
  }

  @Given("^The suggestion widget is existing and displayed two users with Add button and Delete buttons$")
  public void checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons() {
    peopleSteps.checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons();
  }

  @Given("^I go to the profile '(.*)'$")
  public void goToUserProfile(String user) {
    peopleSteps.goToUserProfile(user);
  }

  @Given("I connect to the user using the profile")
  public void connectUserProfile() {
    peopleSteps.connectUserProfile();
  }

  @Given("I go to the second user profile")
  public void goToSecondUserProfile() {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    peopleSteps.goToUserProfile(secondUserName);
  }

  @Given("I go to the third user profile")
  public void goToThirdUserProfile() {
    String thirdUserName = Serenity.sessionVariableCalled("thirdUserName");
    peopleSteps.goToUserProfile(thirdUserName);
  }

  @Given("I go to the first user profile")
  public void goToFirstUserProfile() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    peopleSteps.goToUserProfile(firstUserName);
  }

  @Then("^Leaderboard Widget is displayed with title '(.*)'$")
  public void isLeaderBoardWidgetDisplayed(String title) {
    peopleSteps.isLeaderBoardWidgetDisplayed(title);
  }

  @Given("I add the first user suggestion")
  public void addFirstUserSuggestion() {
    peopleSteps.addFirstUserSuggestion();
  }

  @Then("^First two places on Leaderboard are displayed$")
  public void areTwoFirstPlacesOnLeaderboardDisplayed() {
    peopleSteps.areTwoFirstPlacesOnLeaderboardDisplayed();
  }

  @Then("^First two users points on Leaderboard are displayed$")
  public void areTwoFirstUsersPointsOnLeaderboardDisplayed() {
    peopleSteps.areTwoFirstUsersPointsOnLeaderboardDisplayed();
  }

  @Then("^Current User position and points on Leaderboard are displayed$")
  public void areCurrentUserPositionAndPointsOnLeaderboardDisplayed() {
    peopleSteps.areCurrentUserPositionAndPointsOnLeaderboardDisplayed();
  }

  @Given("^First User Suggestion is not displayed$")
  public void checkThatFirstUserSuggestionIsNotDisplayed() {
    peopleSteps.checkThatFirstUserSuggestionIsNotDisplayed();
  }

  @Given("^I delete the user suggestion$")
  public void deleteUserSuggestion() {
    peopleSteps.deleteUserSuggestion();
  }

  @Given("^User Suggestion after deletion is not displayed$")
  public void checkThatUserSuggestionIsNotDisplayed() {
    peopleSteps.checkThatUserSuggestionIsNotDisplayed();
  }

  @Given("^I go to Sent Requests$")
  public void goToSentRequests() {
    peopleSteps.goToSentRequests();
  }

  @Given("^The added user suggestion is displayed$")
  public void checkThatAddedUserSuggestionIsDisplayed() {
    peopleSteps.checkThatAddedUserSuggestionIsDisplayed();
  }

  @Given("^The deleted user suggestion is not displayed$")
  public void checkThatDeletedUserSuggestionIsNotDisplayed() {
    peopleSteps.checkThatDeletedUserSuggestionIsNotDisplayed();
  }

  @Then("^Contact Fullname in People page is displayed$")
  public void checkThatFullNameIsDisplayed() {
    peopleSteps.checkThatFullNameIsDisplayed();
  }

  @Given("^I delete Sent Request$")
  public void deleteSentRequest() throws InterruptedException {
    peopleSteps.deleteSentRequest();
  }

  @Given("^I close Sent Request button$")
  public void closeSentRequestsButton() {
    peopleSteps.closeSentRequestsButton();
  }

  @Then("^Contact Circular avatar is displayed$")
  public void checkThatCircularAvatarIsDisplayed() {
    peopleSteps.checkThatCircularAvatarIsDisplayed();
  }

  @Then("^Add Contact button in People page is displayed$")
  public void checkThatAddContactButtonIsDisplayed() {
    peopleSteps.checkThatAddContactButtonIsDisplayed();
  }

  @Then("^Contact cover in People page is displayed$")
  public void checkThatTheCoverIsDisplayed() {
    peopleSteps.checkThatTheCoverIsDisplayed();
  }

  @Then("^Contact job in People page is displayed$")
  public void checkThatJobIsDisplayed() {
    peopleSteps.checkThatJobIsDisplayed();
  }

}
