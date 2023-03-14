/*
 * This file is part of the Meeds project (https://meeds.io/).
 * 
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.steps.definition;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ProgramsSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ProgramsStepDefinition {
  @Steps
  private ProgramsSteps programsSteps;

  @And("^I add an audience space$")
  public void addAudienceSpace() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    programsSteps.addSpaceAudience(randomSpaceName);
  }

  @And("^I add a disabled program with random description$")
  public void addDisabledProgramWithRandomDescription() {
    String disabledProgramDescription = "disabledProgramDescription" + getRandomNumber();
    Serenity.setSessionVariable("disabledProgramDescription").to(disabledProgramDescription);
    programsSteps.addDisabledProgramWithRandomDescription(disabledProgramDescription);
  }

  @And("^I add program with random description$")
  public void addProgramWithRandomDescription() {
    String programDescription = "programDescription" + getRandomNumber();
    Serenity.setSessionVariable("programDescription").to(programDescription);
    programsSteps.addProgramWithRandomDescription(programDescription);
  }

  @Then("^The drawer add program should be displayed$")
  public void checkAddProgramDrawerDisplay() {
    programsSteps.checkProgramDrawerDisplay();
  }

  @And("^The program card should not be displayed$")
  public void checkProgramCardDisplay() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.checkProgramCardDisplay(programName);
  }

  @Then("^The program card title '(.*)' should be displayed$")
  public void checkProgramCardTitle(String title) {
    programsSteps.checkProgramCardTitle(title);
  }

  @And("^The program title should be displayed on the card$")
  public void checkProgramTitleDisplayOnCard() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.checkProgramTitleDisplayOnCard(programName);
  }

  @And("^The program title should be updated on the card$")
  public void checkProgramTitleUpdateOnCard() {
    String newProgramName = Serenity.sessionVariableCalled("newProgramName");
    programsSteps.checkProgramTitleUpdateOnCard(newProgramName);
  }

  @And("^I click on the button add program$")
  public void clickAddProgramBtn() {
    programsSteps.clickAddProgramBtn();
  }

  @And("^I delete the created program$")
  public void deleteCreatedProgram() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.deleteCreatedProgram(programName);
  }

  @Given("^I enable the created program$")
  @And("^I disable the created program$")
  public void disableCreatedProgram() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.enableDisableProgram(programName);
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

  @And("^I enter a random program title$")
  public void enterProgramTitle() {
    String programName = "programName" + getRandomNumber();
    Serenity.setSessionVariable("programName").to(programName);
    programsSteps.enterProgramRandomTitle(programName);
  }

  @And("^I enter the program title '(.*)'$")
  public void enterProgramTitle(String programTitle) {
    programsSteps.enterProgramTitle(programTitle);
  }

  @Then("Engagement application center is displayed")
  public void isEngagementAppOpened() {
    programsSteps.isEngagementAppOpened();
  }

  @When("^I select engagement (.*) tab$")
  public void selectEngagementTab(String tab) {
    programsSteps.selectEngagementTab(tab);
  }

  @And("^I filter programs by value '(.*)'$")
  public void selectProgramsFilter(String value) {
    programsSteps.selectProgramsFilter(value);
  }

  @And("^I open '(.*)' program card$")
  public void openProgramCard(String value) {
    programsSteps.openProgramCard(value);
  }

  @And("^I open random program card$")
  public void openRandomProgramCard() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.openProgramCard(programName);
  }

  @And("^I announce challenge '(.*)'$")
  public void announceChallenge(String challengeTitle) {
    String announcementMessage = "announcementMessage" + getRandomNumber();
    Serenity.setSessionVariable("announcementMessage").to(announcementMessage);
    programsSteps.announceChallenge(challengeTitle, announcementMessage);
  }

  @Then("^The created program is the most awarded program$")
  public void isMostAwardedProgram() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.isMostAwardedProgram(programName);
  }

  @Then("^The created program is not the most awarded program$")
  public void isNotMostAwardedProgram() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.isNotMostAwardedProgram(programName);
  }

}
