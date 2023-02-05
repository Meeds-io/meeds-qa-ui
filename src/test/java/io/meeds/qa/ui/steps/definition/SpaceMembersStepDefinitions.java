package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.meeds.qa.ui.steps.SpaceMembersSteps;
import net.thucydides.core.annotations.Steps;

public class SpaceMembersStepDefinitions {

  @Steps
  private SpaceMembersSteps spaceMembersSteps;

  @Then("\"write a short message\" drawer  is visible")
  public void checkPostDrawer() {
    spaceMembersSteps.checkPostDrawer();
  }

  @Then("I click on three dots menu$")
  public void clickOnThreeDotsMenu() {
    spaceMembersSteps.clickOnThreeDotsMenu();

  }

  @And("^I set as a space manager$")
  public void setAsSpaceManager() {
    spaceMembersSteps.setAsSpaceManager();
  }

  @And("^I set as a redactor$")
  public void setRedactor() {
    spaceMembersSteps.setRedactor();
  }
}
