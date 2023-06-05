package io.meeds.qa.ui.steps.definition;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ActionsSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ActionsStepDefinition {

  @Steps
  private ActionsSteps actionsSteps;

  @And("^I update the '(.*)' random challenge with$")
  public void updateRandomChallenge(String suffix, Map<String, String> details) {
    String challengeName = Serenity.sessionVariableCalled("challengeName" + suffix);
    actionsSteps.updateAction(challengeName, details);
  }

  @And("^I search the '(.*)' random challenge$")
  public void searchChallenge(String suffix) {
    String challengeName = Serenity.sessionVariableCalled("challengeName" + suffix);
    actionsSteps.searchChallenge(challengeName);
  }

  @And("^The '(.*)' challenge is displayed with '(.*)' points$")
  public void checkChallengePoints(String suffix, String points) {
    String challengeName = Serenity.sessionVariableCalled("challengeName" + suffix);
    actionsSteps.checkChallengePoints(challengeName, points);
  }

  @When("^I cancel the announcement challenge '(.*)'")
  public void cancelAnnouncementChallenge(String announcement) {
    actionsSteps.cancelAnnouncementChallenge(announcement);
  }

  @Then("^'(.*)' is displayed in challenge portlet with '(.*)' participants$")
  public void isOverviewChallengeDisplayed(String challengeTitle, String participantsCount) {
    actionsSteps.isOverviewChallengeDisplayed(challengeTitle, participantsCount);
  }

  @Then("^'(.*)' with '(.*)' participants is not displayed in challenge portlet$")
  public void isOverviewChallengeNotDisplayed(String challengeTitle, String participantsCount) {
    actionsSteps.isOverviewChallengeNotDisplayed(challengeTitle, participantsCount);
  }
}
