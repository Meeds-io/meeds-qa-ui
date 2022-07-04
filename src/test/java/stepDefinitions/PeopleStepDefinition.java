package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import steps.PeopleSteps;

public class PeopleStepDefinition {

	@Steps
	private PeopleSteps peopleSteps;

	@Given("^I connect with the user'(.*)'$")
	public void connectToUser(String user) {
		peopleSteps.connectToUser(user);
	}

	@Given("^Search Filter is displayed in People page$")
	public void checkThatFilterIsDisplayed()
	{
		peopleSteps.checkThatFilterIsDisplayed();
	}

	@Given("^I connect to second user$")
	public void connectToSecondUser() {
		String secondUserName = Serenity.sessionVariableCalled("secondUserName");
		peopleSteps.connectToUser(secondUserName);
	}

	@Given("^I connect to first user$")
	public void connectToFirstUser() {
		String firstUserName = Serenity.sessionVariableCalled("firstUserName");
		peopleSteps.connectToUser(firstUserName);
	}

	@Given("^I connect to third user$")
	public void connectToThirdUser() {
		String thirdUserName = Serenity.sessionVariableCalled("thirdUserName");
		peopleSteps.connectToUser(thirdUserName);
	}

	@Given("^I connect to fourth user$")
	public void connectToFourthUser() {
		String fourthUserName = Serenity.sessionVariableCalled("fourthUserName");
		peopleSteps.connectToUser(fourthUserName);
	}

	@Given("^I connect to fifth user$")
	public void connectToFifthUser() {
		String fifthUserName = Serenity.sessionVariableCalled("fifthUserName");
		peopleSteps.connectToUser(fifthUserName);
	}

	@Given("^Pulldown Filter is displayed in People page$")
	public void checkThatPulldownFiltersIsDisplayed()
	{
		peopleSteps.checkThatPulldownFiltersIsDisplayed();
	}

	@Given("^People Showing Results is displayed in People page$")
	public void checkThatPeopleShowingResultsIsDisplayed()
	{
		peopleSteps.checkThatPeopleShowingResultsIsDisplayed();
	}

	@Given("^I connect with this user'(.*)'$")
	public void connectWithUser(String user) {
		peopleSteps.connectWithUser(user);
	}

	@Given("^My Connections Pulldown Filter with user '(.*)' is displayed in People page$")
	public void checkThatMyConnectionsPulldownFiltersIsDisplayed(String user)
	{
		peopleSteps.checkThatMyConnectionsPulldownFiltersIsDisplayed(user);
	}

	@Given("^The suggestion widget is existing and displayed two users with Add button and Delete buttons$")
	public void checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons()
	{
		peopleSteps.checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons();
	}

	@Given("I go to the profile '(.*)'")
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
	public void isLeaderBoardWidgetDisplayed(String title)
	{
		peopleSteps.isLeaderBoardWidgetDisplayed(title);
	}

	@Given("^I add the first user suggestion$")
	public void addFirstUserSuggestion()
	{
		peopleSteps.addFirstUserSuggestion();
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
	}

	@Then("^First two places on Leaderboard are displayed$")
	public void areTwoFirstPlacesOnLeaderboardDisplayed()
	{
		peopleSteps.areTwoFirstPlacesOnLeaderboardDisplayed();
	}

	@Then("^First two users points on Leaderboard are displayed$")
	public void areTwoFirstUsersPointsOnLeaderboardDisplayed()
	{
		peopleSteps.areTwoFirstUsersPointsOnLeaderboardDisplayed();
	}

	@Then("^Current User position and points on Leaderboard are displayed$")
	public void areCurrentUserPositionAndPointsOnLeaderboardDisplayed()
	{
		peopleSteps.areCurrentUserPositionAndPointsOnLeaderboardDisplayed();
	}

	@Given("^First User Suggestion is not displayed$")
	public void checkThatFirstUserSuggestionIsNotDisplayed()
	{
		peopleSteps.checkThatFirstUserSuggestionIsNotDisplayed();
	}

	@Given("^I delete the user suggestion$")
	public void deleteUserSuggestion()
	{
		peopleSteps.deleteUserSuggestion();
	}

	@Given("^User Suggestion after deletion is not displayed$")
	public void checkThatUserSuggestionIsNotDisplayed()
	{
		peopleSteps.checkThatUserSuggestionIsNotDisplayed();
	}

	@When("^I open the chat drawer with user '(.*)'$")
	public void openUserChatDrawer(String user) {
		peopleSteps.openChatDrawer(user);
	}

	@When("^I close the chat drawer$")
	public void closeChatDrawer() {
		peopleSteps.closeChatDrawer();
	}

	@Given("^I go to Sent Requests$")
	public void goToSentRequests()
	{
		peopleSteps.goToSentRequests();
	}

	@Given("^The added user suggestion is displayed$")
	public void checkThatAddedUserSuggestionIsDisplayed()
	{
		peopleSteps.checkThatAddedUserSuggestionIsDisplayed();
	}

	@Given("^The deleted user suggestion is not displayed$")
	public void checkThatDeletedUserSuggestionIsNotDisplayed()
	{
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
	public void closeSentRequestsButton()
	{
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
