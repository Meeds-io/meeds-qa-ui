package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.engagement.ProgramsPage;

public class ProgramsSteps {
  private ProgramsPage programsPage;

  public void clickAddProgramBtn() {
    programsPage.clickAddProgramBtn();
  }

  public void checkProgramDrawerDisplay() {
    programsPage.checkProgramDrawerDisplay();
  }

  public void enterProgramRandomTitle(String programTitle) {
    programsPage.enterProgramRandomTitle(programTitle);
  }

  public void addProgramWithRandomDescription(String programDescription) {
    programsPage.addProgramWithRandomDescription(programDescription);
  }

  public void addDisabledProgramWithRandomDescription(String disabledProgramDescription) {
    programsPage.addDisabledProgramWithRandomDescription(disabledProgramDescription);
  }

  public void checkProgramTitleDisplayOnCard(String programName) {
    programsPage.checkProgramTitleDisplayOnCard(programName);
  }

  public void checkProgramCardDisplay(String programName) {
    programsPage.checkProgramCardDisplay(programName);
  }

  public void editProgramWithDescription(String programName, String newProgramName, String newProgramDescription) {
    programsPage.editProgramWithDescription(programName, newProgramName, newProgramDescription);
  }

  public void checkProgramTitleUpdateOnCard(String newProgramName) {
    programsPage.checkProgramTitleUpdateOnCard(newProgramName);
  }
}
