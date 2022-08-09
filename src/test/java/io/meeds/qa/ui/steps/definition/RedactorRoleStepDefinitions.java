package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.meeds.qa.ui.steps.RedactorRoleSteps;
import net.thucydides.core.annotations.Steps;

public class RedactorRoleStepDefinitions {

  @Steps
  private RedactorRoleSteps redactorRoleSteps;

  @And("^I set as a redactor$")
  public void setRedactor() {
    redactorRoleSteps.setRedactor();
  }

  @And("^I set as a space manager$")
  public void setAsSpaceManager() {
    redactorRoleSteps.setAsSpaceManager();
  }

  @Then("^\"write a short message\" drawer  is visible$")
  public void checkPostDrawer() {
    redactorRoleSteps.checkPostDrawer();

  }

  @Then("I click on three dots menu$")
  public void dotsbtn() {
    redactorRoleSteps.ThreeDotsMenu();

  }
}
