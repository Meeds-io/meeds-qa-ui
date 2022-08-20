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

  @And("Add challenge button should be displayed")
  public void checkAddChallengeBtn() {
    challengesSteps.checkAddChallengeBtn();
  }

  @And("Add challenge button should not be displayed")
  public void checkAddChallengeBtnNotDispayed() {
    challengesSteps.checkAddChallengeBtnNotDispayed();
  }

  @When("^I click on the button add challenge$")
  public void clickAddChallengeBtn() {
    challengesSteps.clickAddChallengeBtn();
  }

  @Then("^The drawer add challenge should be displayed$")
  public void checkAddChallengeDrawer() {
    challengesSteps.checkAddChallengeDrawer();
  }

  @And("^I enter the challenge title '(.*)'$")
  public void enterChallengeTitle(String challengeTitle) {
    challengesSteps.enterChallengeTitle(challengeTitle);
  }

  @And("I select a space audience")
  public void enterSpaceAudience() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    challengesSteps.addSpaceAudience(randomSpaceName);
  }

  @And("^I select the program '(.*)'$")
  public void addProgramName(String programName) {
    challengesSteps.addProgramName(programName);
  }

  @And("I select tomorrow for start date")
  public void selectStartDateTomorrow() {
    challengesSteps.selectStartDateTomorrow();
  }

  @And("^I select next week for end date$")
  public void selectEndDateNextWeek() {
    challengesSteps.selectEndDateNextWeek();
  }

  @And("^I add challenge with description '(.*)'$")
  public void addChallengeWithDescription(String description) {
    challengesSteps.addChallengeWithDescription(description);
  }

  @Then("^The message '(.*)' should be displayed$")
  public void checkSuccessMessage(String message) {
    challengesSteps.checkSuccessMessage(message);
  }

  @And("^I select today for start date$")
  public void selectStartDateToday() {
    challengesSteps.selectStartDateToday();
  }

  @And("^I filter challenges by value '(.*)'$")
  public void selectChallengesFilter(String value) {
    challengesSteps.selectChallengesFilter(value);
  }

  @Then("^The challenge card title '(.*)' should be displayed$")
  public void checkChallengeCardTitle(String title) {
    challengesSteps.checkChallengeCardTitle(title);
  }

  @Then("^The challenge card title '(.*)' should not be displayed$")
  public void checkNoChallengeCardTitle(String title) {
    challengesSteps.checkNoChallengeCardTitle(title);
  }

  @And("^I enter a random challenge title$")
  public void enterRandomChallengeTitle() {
    String challengeName = "challengeName" + getRandomNumber();
    Serenity.setSessionVariable("challengeName").to(challengeName);
    challengesSteps.enterRandomChallengeTitle(challengeName);
  }

  @And("^I add challenge with random description$")
  public void addChallengeWithRandomDescription() {
    String challengeDescription = "challengeDescription" + getRandomNumber();
    Serenity.setSessionVariable("challengeDescription").to(challengeDescription);
    challengesSteps.addChallengeWithRandomDescription(challengeDescription);
  }

  @And("^I select tomorrow for end date$")
  public void selectEndDateTomorrow() {
    challengesSteps.selectEndDateTomorrow();
  }

  @Then("^The challenge title should be displayed on the card$")
  public void checkTitleDisplayOnCard() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkTitleDisplayOnCard(challengeName);
  }

  @And("^Three dots icon should be displayed on the challenge card$")
  public void checkThreeDotsIconDisplay() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkThreeDotsIconDisplay(challengeName);
  }

  @And("^Announce button should be displayed on the challenge card$")
  public void checkAnnounceBtn() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkAnnounceBtn(challengeName);
  }

  @And("^Date indication should be displayed on the challenge card$")
  public void checkDateField() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkDateField(challengeName);
  }

  @And("^I click on the announce button$")
  public void clickAnnounceBtn() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.clickAnnounceBtn(challengeName);
  }

  @Then("^The announcement drawer should be displayed$")
  public void checkAnnouncementDrawer() {
    challengesSteps.checkAnnouncementDrawer();
  }

  @And("^I assign the announcement to the (.*) user$")
  public void assignChallengeToRandomUser(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    challengesSteps.assignChallengeToUser(userLastName);
  }

  @And("^I create announcement with random description$")
  public void addAnnouncementWithRandomDescription() {
    String announcementDescription = "announcementDescription" + getRandomNumber();
    Serenity.setSessionVariable("announcementDescription").to(announcementDescription);
    challengesSteps.addAnnouncementWithRandomDescription(announcementDescription);
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

  @And("^The challenge title should be displayed on the announcement activity$")
  public void checkChallengeTitleOnAnnouncement() {
    String challengeName = Serenity.sessionVariableCalled("challengeName");
    challengesSteps.checkChallengeTitleOnAnnouncement(challengeName);
  }

  @And("^Achievement description should be displayed on the announcement activity$")
  public void checkAchievementDescriptionOnAnnouncement() {
    String announcementDescription = Serenity.sessionVariableCalled("announcementDescription");
    challengesSteps.checkAchievementDescriptionOnAnnouncement(announcementDescription);
  }

}
