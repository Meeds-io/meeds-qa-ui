package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ChallengesSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;

import java.util.Map;

public class ChallengesStepDefinition {

  @Steps
  private ChallengesSteps challengesSteps;

  @And("^I click on the button add challenge$")
  public void clickAddChallengeBtn() {
    challengesSteps.clickAddChallengeBtn();
  }

  @And("^I create the '(.*)' random challenge with$")
  public void createRandomChallenge(String suffix, Map<String, String> details) {
    String challengeName = "challengeName" + getRandomNumber();
    challengesSteps.createdChallenge(challengeName, details);
    Serenity.setSessionVariable("challengeName" + suffix).to(challengeName);
  }
  
  @And("^I update the '(.*)' random challenge with$")
  public void updateRandomChallenge(String suffix, Map<String, String> details) {
    String challengeName = Serenity.sessionVariableCalled("challengeName" + suffix);
    challengesSteps.updateChallenge(challengeName, details);
  }

  @And("^I enter the challenge title '(.*)'$")
  public void enterChallengeTitle(String challengeTitle) {
    challengesSteps.enterChallengeTitle(challengeTitle);
  }

  @And("^The '(.*)' challenge is displayed with '(.*)' points$")
  public void checkChallengePoints(String suffix, String points) {
    String challengeName = Serenity.sessionVariableCalled("challengeName" + suffix);
    challengesSteps.checkChallengePoints(challengeName, points);
  }

  @And("^I add '(.*)' program$")
  public void enterProgramTitle(String programTitle) {
    challengesSteps.addProgram(programTitle);
  }

  @And("^I enter random program to challenge$")
  public void enterRandomProgramTitle() {
    String programName = Serenity.sessionVariableCalled("programName");
    challengesSteps.addProgram(programName);
  }

  @And("^I enter a started challenge$")
  public void enterStartedChallenge() {
    challengesSteps.enterStartedChallenge();
  }

  @And("^I add challenge random description$")
  public void addChallengeRandomDescription() {
    String challengeDescription = "challengeDescription" + getRandomNumber();
    Serenity.setSessionVariable("challengeDescription").to(challengeDescription);
    challengesSteps.addChallengeRandomDescription(challengeDescription);
  }

  @When("^I cancel the announcement challenge '(.*)'")
  public void cancelAnnouncementChallenge(String announcement) {
    challengesSteps.cancelAnnouncementChallenge(announcement);
  }

  @Then("^'(.*)' is displayed in challenge portlet with '(.*)' participants$")
  public void isOverviewChallengeDisplayed(String challengeTitle, String participantsCount) {
    challengesSteps.isOverviewChallengeDisplayed(challengeTitle, participantsCount);
  }

  @Then("^'(.*)' with '(.*)' participants is not displayed in challenge portlet$")
  public void isOverviewChallengeNotDisplayed(String challengeTitle, String participantsCount) {
    challengesSteps.isOverviewChallengeNotDisplayed(challengeTitle, participantsCount);
  }
}
