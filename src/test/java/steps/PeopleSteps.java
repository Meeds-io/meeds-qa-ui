package steps;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.page.factory.HomePage;
import pages.page.factory.people.PeoplePage;

import static org.aspectj.bridge.MessageUtil.info;

public class PeopleSteps {

	private PeoplePage peoplePage;
	private HomePage homePage;

	String firstUserSuggestion = "Bilel Bouseha";
	String secondUserSuggestion = "Amin Mejri";

	public void connectToUser(String user) {
		homePage.goToPeoplePage();
		peoplePage.connectToUser(user);
	}

	public void connectWithUser(String user) {
		homePage.goToPeoplePage();
		peoplePage.checkConnectToUser(user);
	}

	public void checkThatFilterIsDisplayed() {
		peoplePage.checkThatFilterIsDisplayed();
	}

	public void checkThatPeopleShowingResultsIsDisplayed() {
		peoplePage.ELEMENT_PEOPLE_SHOWING_RESULTS_DW.isDisplayed();
		String resultsNumber = peoplePage.ELEMENT_PEOPLE_SHOWING_RESULTS_DW.getText().split("Showing ")[1].split("results")[0];
		info(resultsNumber + "Results are displayed");
	}

	public void checkThatPulldownFiltersIsDisplayed() {
		info("Check that Pulldown Filter is displayed");
		peoplePage.ELEMENT_PEOPLE_PULLDOWN_FILTER_DW.isDisplayed();
	}

	public void checkThatMyConnectionsPulldownFiltersIsDisplayed(String user) {
		peoplePage.ELEMENT_PEOPLE_PULLDOWN_FILTER_DW.selectByValue("connections");
		info("Check My Connections Pull Down Filter");
		peoplePage.ELEMENT_ADD_CONTACT_FULLNAM_WITH_PARAM_DW(user).waitUntilVisible();
	}

	public void goToUserProfile(String user) {
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
		homePage.goToPeoplePage();
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
		peoplePage.goToUserProfile(user);
	}

	public void connectUserProfile() {
		peoplePage.connectUserProfile();
	}

	public void openChatDrawer(String user) {
		peoplePage.openChatDrawer(user);
	}

	public void closeChatDrawer() {
		peoplePage.closeChatDrawer();
	}

	public void isLeaderBoardWidgetDisplayed(String title) {
		info("Check that the Leaderboard Widget is displayed");
		peoplePage.ELEMENT_LEADER_BOARD_TITLE_DW.waitUntilVisible();
		Assert.assertEquals(peoplePage.ELEMENT_LEADER_BOARD_TITLE_DW.getText(), title);
	}

	public void areTwoFirstPlacesOnLeaderboardDisplayed() {
		info("Display the 2 first places on Leaderboard");
		peoplePage.ELEMENT_FIRST_USER_LEADER_BOARD_POSITION_DW.waitUntilVisible();
		peoplePage.ELEMENT_SECOND_USER_LEADER_BOARD_POSITION_DW.waitUntilVisible();
		String firstUserLeaderboard = peoplePage.ELEMENT_FIRST_USER_LEADER_BOARD_POSITION_DW.getText();
		String secondUserLeaderboard = peoplePage.ELEMENT_SECOND_USER_LEADER_BOARD_POSITION_DW.getText();
	}

	public void areTwoFirstUsersPointsOnLeaderboardDisplayed() {
		info("Display the 2 first users points on Leaderboard");
		peoplePage.ELEMENT_FIRST_USER_LEADER_BOARD_POINTS_DW.waitUntilVisible();
		peoplePage.ELEMENT_SECOND_USER_LEADER_BOARD_POINTS_DW.waitUntilVisible();
		String firstUsePointsLeaderboard = peoplePage.ELEMENT_FIRST_USER_LEADER_BOARD_POINTS_DW.getText();
		String secondUserPointsLeaderboard = peoplePage.ELEMENT_SECOND_USER_LEADER_BOARD_POINTS_DW.getText();

		info("First User Points On Leaderboard is" + firstUsePointsLeaderboard);
		info("Second User Points On Leaderboard is" + secondUserPointsLeaderboard);
	}

	public void areCurrentUserPositionAndPointsOnLeaderboardDisplayed() {
		String currentUserPositionLeaderboard = peoplePage.ELEMENT_CURRENT_USER_LEADER_BOARD_POSITION_DW.getText();
		String currentUserPointsLeaderboard = peoplePage.ELEMENT_CURRENT_USER_LEADER_BOARD_POINTS_DW(currentUserPositionLeaderboard).getText();

		info("Current user position on Leaderboard" + currentUserPositionLeaderboard);
		info("Current user points on Leaderboard" + currentUserPointsLeaderboard);
	}

	public void checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons()
	{
		info("The suggestion widget is existing and displayed only 2 users with Add button and Delete buttons");
		peoplePage.ELEMENT_FIRST_SUGGESTION_DW.isVisible();
		peoplePage.ELEMENT_SECOND_SUGGESTION_DW.isVisible();
		peoplePage.ELEMENT_ADD_FIRST_USER_SUGGESTION_DW.isVisible();
		peoplePage.ELEMENT_ADD_SECOND_USER_SUGGESTION_DW.isVisible();
		peoplePage.ELEMENT_DELETE_FIRST_SUGGESTION_DW.isVisible();
		peoplePage.ELEMENT_DELETE_SECOND_SUGGESTION_DW.isVisible();

	}

	public void addFirstUserSuggestion()
	{
		peoplePage.ELEMENT_ADD_FIRST_USER_SUGGESTION_DW.clickOnElement();
	}

	public void deleteUserSuggestion()
	{
		info("Delete the user suggestion");
		peoplePage.ELEMENT_DELETE_FIRST_SUGGESTION_DW.clickOnElement();
	}

	public void checkThatUserSuggestionIsNotDisplayed()
	{
		String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
		String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

		String isSecondUserSuggestion = thirdUserFirstName + " " + thirdUserLastName;

		Assert.assertNotEquals(peoplePage.ELEMENT_FIRST_SUGGESTION_DW.getText(), isSecondUserSuggestion);
	}

	public String getFirstUserSuggestion()
	{
		info("Get First Suggestion");
		peoplePage.ELEMENT_FIRST_SUGGESTION_DW.getText();
		return getFirstUserSuggestion();
	}

	public String getSecondUserSuggestion()
	{
		info("Get Second Suggestion");
		peoplePage.ELEMENT_SECOND_SUGGESTION_DW.getText();
		return getSecondUserSuggestion();
	}

	public void goToSentRequests()
	{
		peoplePage.ELEMENT_SENT_REQUESTS_BTN_DW.waitUntilClickable();
		peoplePage.ELEMENT_SENT_REQUESTS_BTN_DW.clickOnElement();
	}

	public void checkThatAddedUserSuggestionIsDisplayed()
	{
		info("Check that the added user suggestion is displayed");
		String fourthUserFirstName = Serenity.sessionVariableCalled("fourthUserFirstName");
		String fourthUserLastName = Serenity.sessionVariableCalled("fourthUserLastName");

		String isFirstUserSuggestion = fourthUserFirstName + " " + fourthUserLastName;

		peoplePage.ELEMENT_SENT_REQUESTS_USERS_DW(isFirstUserSuggestion).waitUntilVisible();
	}

	public void checkThatDeletedUserSuggestionIsNotDisplayed()
	{
		info("Check that the deleted user suggestion is not displayed");
		String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
		String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

		String isSecondUserSuggestion = thirdUserFirstName + " " + thirdUserLastName;

		peoplePage.ELEMENT_SENT_REQUESTS_USERS_DW(isSecondUserSuggestion).waitUntilNotVisible();
	}

	public void checkThatFirstUserSuggestionIsNotDisplayed()
	{
		String fourthUserFirstName = Serenity.sessionVariableCalled("fourthUserFirstName");
		String fourthUserLastName = Serenity.sessionVariableCalled("fourthUserLastName");

		String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
		String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

		String isFirstUserSuggestion = fourthUserFirstName + " " + fourthUserLastName;
		String isSecondUserSuggestion = thirdUserFirstName + " " + thirdUserLastName;

		Assert.assertNotEquals(peoplePage.ELEMENT_FIRST_SUGGESTION_DW.getText(), isFirstUserSuggestion);
		Assert.assertEquals(peoplePage.ELEMENT_FIRST_SUGGESTION_DW.getText(), isSecondUserSuggestion);
	}

	public void deleteSentRequest() throws InterruptedException {
		Thread.sleep(3000);
		info("Delete the Sent Request");
		String fourthUserFirstName = Serenity.sessionVariableCalled("fourthUserFirstName");
		String fourthUserLastName = Serenity.sessionVariableCalled("fourthUserLastName");

		String isFirstUserSuggestion = fourthUserFirstName + " " + fourthUserLastName;
		peoplePage.ELEMENT_DELETE_SENT_REQUESTS_USERS_DW(isFirstUserSuggestion).clickOnElement();
	}

	public void closeSentRequestsButton()
	{
		info("Close Sent Requests Button");
		peoplePage.ELEMENT_CLOSE_SENT_REQUESTS_BTN_DW.clickOnElement();
	}

	public void checkThatFullNameIsDisplayed()
	{
		info("Check that the Fullname is displayed");
		peoplePage.ELEMENT_ADD_CONTACT_FULLNAME.isDisplayed();

	}

	public void checkThatCircularAvatarIsDisplayed()
	{
		info("Check that the circular avatar is displayed");
		peoplePage.ELEMENT_CONTACT_AVATAR.isDisplayed();

	}

	public void checkThatAddContactButtonIsDisplayed()
	{
		info("Check that the Add Contact Button is displayed");
		peoplePage.ELEMENT_ADD_CONTACT_TITLE.isDisplayed();
		Assert.assertEquals(peoplePage.ELEMENT_ADD_CONTACT_TITLE.getText(), "Connect");

	}

	public void checkThatTheCoverIsDisplayed()
	{
		info("Check that Contact cover is displayed");
		peoplePage.ELEMENT_ADD_CONTACT_COVER_WIDTH.isDisplayed();

	}

	public void checkThatJobIsDisplayed() {
		info("Check that the job is displayed");
		peoplePage.ELEMENT_ADD_CONTACT_JOB.isDisplayed();

	}


}
