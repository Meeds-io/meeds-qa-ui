package io.meeds.qa.ui.steps.definition;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ChallengesSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ChallengesStepDefinition {

  @Steps
  private ChallengesSteps challengesSteps;

  @And("^I update the '(.*)' random challenge with$")
  public void updateRandomChallenge(String suffix, Map<String, String> details) {
    String challengeName = Serenity.sessionVariableCalled("challengeName" + suffix);
    challengesSteps.updateChallenge(challengeName, details);
  }

  @And("^I search the '(.*)' random challenge$")
  public void searchChallenge(String suffix) {
    String challengeName = Serenity.sessionVariableCalled("challengeName" + suffix);
    challengesSteps.searchChallenge(challengeName);
  }

  @And("^The '(.*)' challenge is displayed with '(.*)' points$")
  public void checkChallengePoints(String suffix, String points) {
    String challengeName = Serenity.sessionVariableCalled("challengeName" + suffix);
    challengesSteps.checkChallengePoints(challengeName, points);
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
