package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.engagement.ProgramsPage;

public class ProgramsSteps {
  private ProgramsPage programsPage;

  public void addDisabledProgramWithRandomDescription(String disabledProgramDescription) {
    programsPage.addDisabledProgramWithRandomDescription(disabledProgramDescription);
  }

  public void addProgramWithRandomDescription(String programDescription) {
    programsPage.addProgramWithRandomDescription(programDescription);
  }

  public void addSpaceAudience(String randomSpaceName) {
    programsPage.addSpaceAudience(randomSpaceName);
  }

  public void checkProgramCardDisplay(String programName) {
    programsPage.checkProgramCardDisplay(programName);
  }

  public void checkProgramCardTitle(String title) {
    programsPage.checkProgramCardTitle(title);
  }

  public void checkProgramDrawerDisplay() {
    programsPage.checkProgramDrawerDisplay();
  }

  public void checkProgramTitleDisplayOnCard(String programName) {
    programsPage.checkProgramTitleDisplayOnCard(programName);
  }

  public void checkProgramTitleUpdateOnCard(String newProgramName) {
    programsPage.checkProgramTitleUpdateOnCard(newProgramName);
  }

  public void clickAddProgramBtn() {
    programsPage.clickAddProgramBtn();
  }

  public void deleteCreatedProgram(String programName) {
    programsPage.deleteCreatedProgram(programName);
  }

  public void editProgramWithDescription(String programName, String newProgramName, String newProgramDescription) {
    programsPage.editProgramWithDescription(programName, newProgramName, newProgramDescription);
  }

  public void enterProgramRandomTitle(String programTitle) {
    programsPage.enterProgramRandomTitle(programTitle);
  }

  public void enterProgramTitle(String programTitle) {
    programsPage.enterProgramTitle(programTitle);
  }

  public void selectProgramsFilter(String value) {
    programsPage.selectProgramsFilter(value);
  }

  public void isEngagementAppOpened() {
    programsPage.checkEngagementAppOpened();
  }

  public void selectEngagementTab(String tab) {
    programsPage.selectEngagementTab(tab);
  }

}
