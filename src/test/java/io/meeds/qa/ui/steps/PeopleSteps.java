package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.HomePage;
import io.meeds.qa.ui.pages.page.factory.people.PeoplePage;
import net.serenitybdd.core.Serenity;

public class PeopleSteps {

  private HomePage   homePage;

  private PeoplePage peoplePage;

  public void areCurrentUserPositionAndPointsOnLeaderboardDisplayed() {
    peoplePage.areCurrentUserPositionAndPointsOnLeaderboardDisplayed();
  }

  public void areTwoFirstPlacesOnLeaderboardDisplayed() {
    peoplePage.areTwoFirstPlacesOnLeaderboardDisplayed();
  }

  public void areTwoFirstUsersPointsOnLeaderboardDisplayed() {
    peoplePage.areTwoFirstUsersPointsOnLeaderboardDisplayed();
  }

  public void checkThatAddContactButtonIsDisplayed() {
    peoplePage.checkThatAddContactButtonIsDisplayed();
  }

  public void checkThatAddedUserSuggestionIsDisplayed() {
    peoplePage.checkThatAddedUserSuggestionIsDisplayed();
  }

  public void checkThatCircularAvatarIsDisplayed() {
    peoplePage.checkThatCircularAvatarIsDisplayed();
  }

  public void checkThatDeletedUserSuggestionIsNotDisplayed() {
    peoplePage.checkThatDeletedUserSuggestionIsNotDisplayed();
    // Check that the deleted user suggestion is not displayed
    String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
    String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

    peoplePage.checkThatUserSuggestionIsDisplayed(thirdUserFirstName, thirdUserLastName);
  }

  public void checkThatFilterIsDisplayed() {
    peoplePage.checkThatFilterIsDisplayed();
  }

  public void checkThatFullNameIsDisplayed() {
    peoplePage.checkThatFullNameIsDisplayed();
  }

  public void checkThatJobIsDisplayed() {
    peoplePage.checkThatJobIsDisplayed();

  }

  public void checkThatMyConnectionsPulldownFiltersIsDisplayed(String user) {
    peoplePage.checkThatMyConnectionsPulldownFiltersIsDisplayed(user);
  }

  public void checkThatPeopleShowingResultsIsDisplayed() {
    peoplePage.checkThatPeopleShowingResultsIsDisplayed();
  }

  public void checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons() {
    peoplePage.checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons();
  }

  public void checkThatTheCoverIsDisplayed() {
    peoplePage.checkThatTheCoverIsDisplayed();
  }

  public void checkThatUserSuggestionIsNotDisplayed() {
    String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
    String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");
    peoplePage.checkThatUserSuggestionIsNotDisplayed(thirdUserFirstName, thirdUserLastName);
  }

  public void closeSentRequestsButton() {
    peoplePage.closeSentRequestsButton();
  }

  public void connectToUser(String user) {
    homePage.goToPeoplePage();
    peoplePage.connectToUser(user);
  }

  public void connectUserProfile() {
    peoplePage.connectUserProfile();
  }

  public void deleteSentRequest() {
    String fourthUserFirstName = Serenity.sessionVariableCalled("fourthUserFirstName");
    String fourthUserLastName = Serenity.sessionVariableCalled("fourthUserLastName");
    peoplePage.deleteSentRequest(fourthUserFirstName, fourthUserLastName);
  }

  public void deleteUserSuggestion() {
    peoplePage.deleteUserSuggestion();
  }

  public void goToSentRequests() {
    peoplePage.goToSentRequests();
  }

  public void goToUserProfile(String user) {
    homePage.goToPeoplePage();
    peoplePage.goToUserProfile(user);
  }

  public void isLeaderBoardWidgetDisplayed(String title) {
    peoplePage.isLeaderBoardWidgetDisplayed(title);
  }

}
