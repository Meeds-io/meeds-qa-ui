package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ChallengesSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;

public class ChallengesStepDefinition {

  @Steps
  private ChallengesSteps challengesSteps;

  @And("^I click on the button add challenge$")
  public void clickAddChallengeBtn() {
    challengesSteps.clickAddChallengeBtn();
  }

  @And("^I enter the challenge title '(.*)'$")
  public void enterChallengeTitle(String challengeTitle) {
    challengesSteps.enterChallengeTitle(challengeTitle);
  }

  @And("^I add '(.*)' program$")
  public void enterProgramTitle(String programTitle) {
    challengesSteps.addProgram(programTitle);
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
}
