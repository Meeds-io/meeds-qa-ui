package io.meeds.qa.ui.steps;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import io.meeds.qa.ui.pages.page.factory.HomePage;
import io.meeds.qa.ui.pages.page.factory.people.PeoplePage;
import net.serenitybdd.core.Serenity;

public class PeopleSteps {

  private PeoplePage peoplePage;

  private HomePage   homePage;

  public void connectToUser(String user) {
    homePage.goToPeoplePage();
    peoplePage.checkConnectToUser(user);
  }

  public void checkThatFilterIsDisplayed() {
    peoplePage.checkThatFilterIsDisplayed();
  }

  public void checkThatPeopleShowingResultsIsDisplayed() {
    peoplePage.ELEMENT_PEOPLE_SHOWING_RESULTS.isDisplayed();
  }

  public void checkThatPulldownFiltersIsDisplayed() {
    // Check that Pulldown Filter is displayed
    peoplePage.ELEMENT_PEOPLE_PULLDOWN_FILTER.isDisplayed();
  }

  public void checkThatMyConnectionsPulldownFiltersIsDisplayed(String user) {
    peoplePage.ELEMENT_PEOPLE_PULLDOWN_FILTER.selectByValue("connections");
    // Check My Connections Pull Down Filter
    peoplePage.ELEMENT_ADD_CONTACT_FULLNAM_WITH_PARAM(user).waitUntilVisible();
  }

  public void goToUserProfile(String user) {
    homePage.refreshPage();
    homePage.goToPeoplePage();
    peoplePage.goToUserProfile(user);
  }

  public void connectUserProfile() {
    peoplePage.connectUserProfile();
  }

  public void isLeaderBoardWidgetDisplayed(String title) {
    // Check that the Leaderboard Widget is displayed
    peoplePage.ELEMENT_LEADER_BOARD_TITLE.waitUntilVisible();
    Assert.assertEquals(peoplePage.ELEMENT_LEADER_BOARD_TITLE.getText(), title);
  }

  public void areTwoFirstPlacesOnLeaderboardDisplayed() {
    // Display the 2 first places on Leaderboard
    peoplePage.ELEMENT_FIRST_USER_LEADER_BOARD_POSITION.waitUntilVisible();
    peoplePage.ELEMENT_SECOND_USER_LEADER_BOARD_POSITION.waitUntilVisible();
    String firstUserLeaderboard = peoplePage.ELEMENT_FIRST_USER_LEADER_BOARD_POSITION.getText();
    String secondUserLeaderboard = peoplePage.ELEMENT_SECOND_USER_LEADER_BOARD_POSITION.getText();
  }

  public void areTwoFirstUsersPointsOnLeaderboardDisplayed() {
    // Display the 2 first users points on Leaderboard
    peoplePage.ELEMENT_FIRST_USER_LEADER_BOARD_POINTS.waitUntilVisible();
    peoplePage.ELEMENT_SECOND_USER_LEADER_BOARD_POINTS.waitUntilVisible();
    String firstUsePointsLeaderboard = peoplePage.ELEMENT_FIRST_USER_LEADER_BOARD_POINTS.getText();
    String secondUserPointsLeaderboard = peoplePage.ELEMENT_SECOND_USER_LEADER_BOARD_POINTS.getText();
  }

  public void areCurrentUserPositionAndPointsOnLeaderboardDisplayed() {
    String currentUserPositionLeaderboard = peoplePage.ELEMENT_CURRENT_USER_LEADER_BOARD_POSITION.getText();
    String currentUserPointsLeaderboard = peoplePage.ELEMENT_CURRENT_USER_LEADER_BOARD_POINTS(currentUserPositionLeaderboard)
                                                    .getText();
  }

  public void checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons() {
    // The suggestion widget is existing and displayed only 2 users with Add
    // button and Delete buttons
    assertTrue(peoplePage.ELEMENT_FIRST_SUGGESTION.isVisible());
    assertTrue(peoplePage.ELEMENT_SECOND_SUGGESTION.isVisible());
    assertTrue(peoplePage.ELEMENT_ADD_FIRST_USER_SUGGESTION.isVisible());
    assertTrue(peoplePage.ELEMENT_ADD_SECOND_USER_SUGGESTION.isVisible());
    assertTrue(peoplePage.ELEMENT_DELETE_FIRST_SUGGESTION.isVisible());
    assertTrue(peoplePage.ELEMENT_DELETE_SECOND_SUGGESTION.isVisible());

  }

  public void addFirstUserSuggestion() {
    peoplePage.ELEMENT_ADD_FIRST_USER_SUGGESTION.clickOnElement();
  }

  public void deleteUserSuggestion() {
    // Delete the user suggestion
    peoplePage.ELEMENT_DELETE_FIRST_SUGGESTION.clickOnElement();
  }

  public void checkThatUserSuggestionIsNotDisplayed() {
    String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
    String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

    String isSecondUserSuggestion = thirdUserFirstName + " " + thirdUserLastName;

    Assert.assertNotEquals(peoplePage.ELEMENT_FIRST_SUGGESTION.getText(), isSecondUserSuggestion);
  }

  public String getFirstUserSuggestion() {
    // Get First Suggestion
    peoplePage.ELEMENT_FIRST_SUGGESTION.getText();
    return getFirstUserSuggestion();
  }

  public String getSecondUserSuggestion() {
    // Get Second Suggestion
    peoplePage.ELEMENT_SECOND_SUGGESTION.getText();
    return getSecondUserSuggestion();
  }

  public void goToSentRequests() {
    peoplePage.ELEMENT_SENT_REQUESTS_BTN.waitUntilClickable();
    peoplePage.ELEMENT_SENT_REQUESTS_BTN.clickOnElement();
  }

  public void checkThatAddedUserSuggestionIsDisplayed() {
    // Check that the added user suggestion is displayed
    String fourthUserFirstName = Serenity.sessionVariableCalled("fourthUserFirstName");
    String fourthUserLastName = Serenity.sessionVariableCalled("fourthUserLastName");

    String isFirstUserSuggestion = fourthUserFirstName + " " + fourthUserLastName;

    peoplePage.ELEMENT_SENT_REQUESTS_USERS(isFirstUserSuggestion).waitUntilVisible();
  }

  public void checkThatDeletedUserSuggestionIsNotDisplayed() {
    // Check that the deleted user suggestion is not displayed
    String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
    String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

    String isSecondUserSuggestion = thirdUserFirstName + " " + thirdUserLastName;

    peoplePage.ELEMENT_SENT_REQUESTS_USERS(isSecondUserSuggestion).waitUntilNotVisible();
  }

  public void checkThatFirstUserSuggestionIsNotDisplayed() {
    String fourthUserFirstName = Serenity.sessionVariableCalled("fourthUserFirstName");
    String fourthUserLastName = Serenity.sessionVariableCalled("fourthUserLastName");

    String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
    String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

    String isFirstUserSuggestion = fourthUserFirstName + " " + fourthUserLastName;
    String isSecondUserSuggestion = thirdUserFirstName + " " + thirdUserLastName;

    Assert.assertNotEquals(peoplePage.ELEMENT_FIRST_SUGGESTION.getText(), isFirstUserSuggestion);
    Assert.assertEquals(peoplePage.ELEMENT_FIRST_SUGGESTION.getText(), isSecondUserSuggestion);
  }

  public void deleteSentRequest() throws InterruptedException {
    // Delete the Sent Request
    String fourthUserFirstName = Serenity.sessionVariableCalled("fourthUserFirstName");
    String fourthUserLastName = Serenity.sessionVariableCalled("fourthUserLastName");

    String isFirstUserSuggestion = fourthUserFirstName + " " + fourthUserLastName;
    peoplePage.ELEMENT_DELETE_SENT_REQUESTS_USERS(isFirstUserSuggestion).clickOnElement();
  }

  public void closeSentRequestsButton() {
    // Close Sent Requests Button
    peoplePage.ELEMENT_CLOSE_SENT_REQUESTS_BTN.clickOnElement();
  }

  public void checkThatFullNameIsDisplayed() {
    // Check that the Fullname is displayed
    peoplePage.ELEMENT_ADD_CONTACT_FULLNAME.isDisplayed();

  }

  public void checkThatCircularAvatarIsDisplayed() {
    // Check that the circular avatar is displayed
    peoplePage.ELEMENT_CONTACT_AVATAR.isDisplayed();

  }

  public void checkThatAddContactButtonIsDisplayed() {
    // Check that the Add Contact Button is displayed
    peoplePage.ELEMENT_ADD_CONTACT_TITLE.isDisplayed();
    Assert.assertEquals(peoplePage.ELEMENT_ADD_CONTACT_TITLE.getText(), "Connect");

  }

  public void checkThatTheCoverIsDisplayed() {
    // Check that Contact cover is displayed
    peoplePage.ELEMENT_ADD_CONTACT_COVER_WIDTH.isDisplayed();

  }

  public void checkThatJobIsDisplayed() {
    // Check that the job is displayed
    peoplePage.ELEMENT_ADD_CONTACT_JOB.isDisplayed();

  }

}
