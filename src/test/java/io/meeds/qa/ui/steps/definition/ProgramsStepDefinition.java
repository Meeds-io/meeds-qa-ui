package io.meeds.qa.ui.steps.definition;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.meeds.qa.ui.steps.ChallengeSteps;
import io.meeds.qa.ui.steps.ProgramsSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ProgramsStepDefinition {
  @Steps
  ProgramsSteps          programsSteps;

  @Steps
  private ChallengeSteps challengeSteps;

  @And("^I click on the button add program$")
  public void clickAddProgramBtn() {
    programsSteps.clickAddProgramBtn();
  }

  @Then("^The drawer add program should be displayed$")
  public void checkAddProgramDrawerDisplay() {
    programsSteps.checkProgramDrawerDisplay();
  }

  @And("^I enter a random program title$")
  public void enterProgramTitle() {
    String programName = "programName" + getRandomNumber();
    Serenity.setSessionVariable("programName").to(programName);
    programsSteps.enterProgramRandomTitle(programName);
  }

  @And("^I add program with random description$")
  public void addProgramWithRandomDescription() {
    String programDescription = "programDescription" + getRandomNumber();
    Serenity.setSessionVariable("programDescription").to(programDescription);
    programsSteps.addProgramWithRandomDescription(programDescription);
  }

  @And("^I add a disabled program with random description$")
  public void addDisabledProgramWithRandomDescription() {
    String disabledProgramDescription = "disabledProgramDescription" + getRandomNumber();
    Serenity.setSessionVariable("disabledProgramDescription").to(disabledProgramDescription);
    programsSteps.addDisabledProgramWithRandomDescription(disabledProgramDescription);
  }

  @And("^The program title should be displayed on the card$")
  public void checkProgramTitleDisplayOnCard() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.checkProgramTitleDisplayOnCard(programName);
  }

  @And("^The program card should not be displayed$")
  public void checkProgramCardDisplay() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.checkProgramCardDisplay(programName);
  }

  @And("^I edit the created program$")
  public void editProgramWithDescription() {
    String programName = Serenity.sessionVariableCalled("programName");
    String newProgramName = "newProgramName" + getRandomNumber();
    String newProgramDescription = "newProgramDescription" + getRandomNumber();
    Serenity.setSessionVariable("newProgramName").to(newProgramName);
    Serenity.setSessionVariable("newProgramDescription").to(newProgramDescription);
    programsSteps.editProgramWithDescription(programName, newProgramName, newProgramDescription);
  }

  @And("^The program title should be updated on the card$")
  public void checkProgramTitleUpdateOnCard() {
    String newProgramName = Serenity.sessionVariableCalled("newProgramName");
    programsSteps.checkProgramTitleUpdateOnCard(newProgramName);
  }
}
