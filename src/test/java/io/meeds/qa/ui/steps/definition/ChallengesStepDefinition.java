package io.meeds.qa.ui.steps.definition;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ChallengeSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ChallengesStepDefinition {
  @Steps
  ChallengeSteps challengesSteps;

  @And("^I create announcement with random description$")
  public void addAnnouncementWithRandomDescription() {
    String announcementDescription = "announcementDescription" + getRandomNumber();
    Serenity.setSessionVariable("announcementDescription").to(announcementDescription);
    challengesSteps.addAnnouncementWithRandomDescription(announcementDescription);
  }

  @And("^I add challenge with description '(.*)'$")
  public void addChallengeWithDescription(String description) {
    challengesSteps.addChallengeWithDescription(description);
  }

  @And("^I add challenge with random description$")
  public void addChallengeWithRandomDescription() {
    String challengeDescription = "challengeDescription" + getRandomNumber();
    Serenity.setSessionVariable("challengeDescription").to(challengeDescription);
    challengesSteps.addChallengeWithRandomDescription(challengeDescription);
  }

  @And("^I select the program '(.*)'$")
  public void addProgramName(String programName) {
    challengesSteps.addProgramName(programName);
  }

  @And("^I assign the announcement to the (.*) user$")
  public void assignChallengeToRandomUser(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    challengesSteps.assignChallengeToUser(userLastName);
  }

  @And("^Achievement description should be displayed on the announcement activity$")
  public void checkAchievementDescriptionOnAnnouncement() {
    String announcementDescription = Serenity.sessionVariableCalled("announcementDescription");
    challengesSteps.checkAchievementDescriptionOnAnnouncement(announcementDescription);
  }

  @And("Add challenge button should be displayed")
  public void checkAddChallengeBtn() {
    challengesSteps.checkAddChallengeBtn();
  }

  @And("Add challenge button should not be displayed")
  public void checkAddChallengeBtnNotDispayed() {
    challengesSteps.checkAddChallengeBtnNotDispayed();
  }

  @Then("^The drawer add challenge should be displayed$")
  public void checkAddChallengeDrawer() {
    challengesSteps.checkAddChallengeDrawer();
  }

  @And("^Announce button should be displayed on the challenge card$")
  public void checkAnnounceBtn() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkAnnounceBtn(challengeName);
  }

  @And(
    "^The announcement activity with random description and random challenge title is posted by the '(.*)' with winner name '(.*)'$"
  )
  public void checkAnnouncementActivityTopBar(String posterPrefix, String winnerPrefix) {
    String posterLastName = Serenity.sessionVariableCalled(posterPrefix + "UserLastName");
    String winnerLastName = Serenity.sessionVariableCalled(winnerPrefix + "UserLastName");
    String announcementDescription = Serenity.sessionVariableCalled("announcementDescription");
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkAnnouncementActivity(posterLastName, winnerLastName, challengeName, announcementDescription);
  }

  @Then("^The announcement drawer should be displayed$")
  public void checkAnnouncementDrawer() {
    challengesSteps.checkAnnouncementDrawer();
  }

  @Then("^The challenge card title '(.*)' should be displayed$")
  public void checkChallengeCardTitle(String title) {
    challengesSteps.checkChallengeCardTitle(title);
  }

  @And("^The challenge title should be displayed on the announcement activity$")
  public void checkChallengeTitleOnAnnouncement() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkChallengeTitleOnAnnouncement(challengeName);
  }

  @And("^Date indication should be displayed on the challenge card$")
  public void checkDateField() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkDateField(challengeName);
  }

  @Then("^The challenge card title '(.*)' should not be displayed$")
  public void checkNoChallengeCardTitle(String title) {
    challengesSteps.checkNoChallengeCardTitle(title);
  }

  @Then("^The message '(.*)' should be displayed$")
  public void checkSuccessMessage(String message) {
    challengesSteps.checkSuccessMessage(message);
  }

  @And("^Three dots icon should be displayed on the challenge card$")
  public void checkThreeDotsIconDisplay() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkThreeDotsIconDisplay(challengeName);
  }

  @Then("^The challenge title should be displayed on the card$")
  public void checkTitleDisplayOnCard() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkTitleDisplayOnCard(challengeName);
  }

  @When("^I click on the button add challenge$")
  public void clickAddChallengeBtn() {
    challengesSteps.clickAddChallengeBtn();
  }

  @And("^I click on the announce button$")
  public void clickAnnounceBtn() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.clickAnnounceBtn(challengeName);
  }

  @And("^I enter the challenge title '(.*)'$")
  public void enterChallengeTitle(String challengeTitle) {
    challengesSteps.enterChallengeTitle(challengeTitle);
  }

  @And("^I enter a random challenge title$")
  public void enterRandomChallengeTitle() {
    String challengeName = "challengeName" + getRandomNumber();
    Serenity.setSessionVariable("challengeName").to(challengeName);
    challengesSteps.enterRandomChallengeTitle(challengeName);
  }

  @And("I select a space audience")
  public void enterSpaceAudience() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    challengesSteps.addSpaceAudience(randomSpaceName);
  }

  @And("^I filter challenges by value '(.*)'$")
  public void selectChallengesFilter(String value) {
    challengesSteps.selectChallengesFilter(value);
  }

  @And("^I select next week for end date$")
  public void selectEndDateNextWeek() {
    challengesSteps.selectEndDateNextWeek();
  }

  @And("^I select tomorrow for end date$")
  public void selectEndDateTomorrow() {
    challengesSteps.selectEndDateTomorrow();
  }

  @And("^I select today for start date$")
  public void selectStartDateToday() {
    challengesSteps.selectStartDateToday();
  }

  @And("I select tomorrow for start date")
  public void selectStartDateTomorrow() {
    challengesSteps.selectStartDateTomorrow();
  }

  @Then("Engagement application center is displayed")
  public void isEngagementAppOpened() {
    challengesSteps.isEngagementAppOpened();
  }

  @When("^I select engagement (.*) tab$")
  public void selectEngagementTab(String tab) {
    challengesSteps.selectEngagementTab(tab);
  }

}
