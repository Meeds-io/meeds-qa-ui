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

import static io.meeds.qa.ui.utils.Utils.getIndexFomName;
import static io.meeds.qa.ui.utils.Utils.getRandomNumber;
import static io.meeds.qa.ui.utils.Utils.getRandomString;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ProgramsSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ProgramsStepDefinition {
  @Steps
  private ProgramsSteps programsSteps;

  @And("I add an audience space")
  public void addAudienceSpace() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    programsSteps.addSpaceAudience(randomSpaceName);
  }

  @And("I save the program details")
  public void saveProgram() {
    programsSteps.clickSaveProgramButton();
  }

  @When("I switch program as disabled")
  @And("I switch program as enabled")
  public void enableDisableProgram() {
    programsSteps.enableDisableProgram();
  }

  @Then("The program status switch is not displayed")
  public void programStatusSwitchNotDisplayed() {
    programsSteps.checkProgramStatusSwitchNotDisplayed();
  }

  @Then("I attach an avatar to the program")
  public void attachAvatarToProgram() {
    programsSteps.attachAvatarToProgram();
  }

  @Then("I attach a cover to the program")
  public void attachCoverToProgram() {
    programsSteps.attachCoverToProgram();
  }

  @Then("The program is displayed with specific avatar")
  public void checkProgramAvatarIsSpecificInDetail() {
    programsSteps.checkProgramAvatarIsSpecificInDetail();
  }

  @Then("The program is displayed with specific cover")
  public void checkProgramCoverIsSpecificInDetail() {
    programsSteps.checkProgramCoverIsSpecificInDetail();
  }

  @Then("I delete the specific avatar of the program")
  public void deleteAvatarFromProgram() {
    programsSteps.deleteAvatarFromProgram();
  }

  @Then("I delete the specific cover of the program")
  public void deleteCoverFromProgram() {
    programsSteps.deleteCoverFromProgram();
  }

  @Then("The program is displayed with default avatar")
  public void checkProgramAvatarIsDefaultInDetail() {
    programsSteps.checkProgramAvatarIsDefaultInDetail();
  }

  @Then("The program is displayed with default cover")
  public void checkProgramCoverIsDefaultInDetail() {
    programsSteps.checkProgramCoverIsDefaultInDetail();
  }

  @Then("I click on program title to go back")
  public void goBackUsingProgramTitle() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.goBackUsingProgramTitle(programName);
  }

  @And("^I add program with random description$")
  @And("I enter a random description for program")
  public void enterProgramRandomDescription() {
    String programDescription = "programDescription" + getRandomNumber();
    Serenity.setSessionVariable("programDescription").to(programDescription);
    programsSteps.enterProgramDescription(programDescription);
  }

  @And("^I enter the program description '(.*)' '(.*)' times$")
  public void enterProgramDescription(String programDescription, String times) {
    StringBuilder programLongDescription = new StringBuilder();
    for (int i = 0; i < Integer.parseInt(times); i++) {
      programLongDescription.append(programDescription);
    }
    programsSteps.enterProgramDescription(programLongDescription.toString());
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
    programsSteps.checkProgramCardTitle(programName);
  }

  @And("^The program title should be updated on the card$")
  public void checkProgramTitleUpdateOnCard() {
    String newProgramName = Serenity.sessionVariableCalled("newProgramName");
    programsSteps.checkProgramCardTitle(newProgramName);
  }

  @And("^I create the '(.*)' random program with$")
  public void createRandomProgram(String suffix, Map<String, String> details) {
    String programName = "programName" + getRandomNumber();
    programsSteps.createRandomProgram(programName, details);
    Serenity.setSessionVariable("programName" + suffix).to(programName);
  }

  @Then("^The '(.*)' random program is not displayed in Top Programs widget$")
  public void checkProgramNotInTopPrograms(String suffix) {
    String programName = Serenity.sessionVariableCalled("programName" + suffix);
    programsSteps.checkProgramNotDisplayedInTopPrograms(programName);
  }

  @Then("^The '(.*)' random program is displayed in '(.*)' position in Top Programs widget$")
  public void checkProgramPositionInTopPrograms(String suffix, String position) {
    String programName = Serenity.sessionVariableCalled("programName" + suffix);
    int listPosition = getIndexFomName(position);
    programsSteps.checkProgramPositionInTopPrograms(programName, listPosition);
  }

  @And("^I click on the button add program(.*)$")
  public void clickAddProgramBtn(String message) {
    programsSteps.clickAddProgramBtn();
  }

  @And("^I delete the created program$")
  public void deleteCreatedProgram() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.deleteCreatedProgram(programName);
  }

  @And("I edit the program from detail")
  public void editProgram() {
    programsSteps.editProgram();
  }

  @And("I edit the program from list")
  public void editProgramFromList() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.editProgram(programName);
  }

  @And("I change the created program with a random description")
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
    programsSteps.enterProgramTitle(programName);
  }

  @And("^I enter the program title '(.*)'$")
  public void enterProgramTitle(String programTitle) {
    programsSteps.enterProgramTitle(programTitle);
  }

  @And("^I enter the random program title '(.*)'$")
  public void enterRandomProgramTitle(String suffix) {
    String programTitle = StringUtils.truncate(getRandomString(suffix, 20), 49);
    Serenity.setSessionVariable("programName" + suffix).to(programTitle);
    programsSteps.enterProgramTitle(programTitle);
  }

  @When("^I go to engagement application '(.*)'$")
  public void selectEngagementApplication(String tab) {
    programsSteps.selectEngagementApplication(tab);
  }

  @When("^I set user '(.*)' as program owner$")
  public void addProgramOwner(String suffix) {
    String firstName = Serenity.sessionVariableCalled(suffix + "UserFirstName");

    programsSteps.addProgramOwner(firstName);
  }

  @And("^I filter programs by value '(.*)'$")
  public void selectProgramsFilter(String value) {
    programsSteps.selectProgramsFilter(value);
  }

  @And("^I filter program actions by value '(.*)'$")
  public void selectProgramActionsFilter(String value) {
    programsSteps.selectProgramActionsFilter(value);
  }

  @And("^I open '(.*)' program card$")
  public void openProgramCard(String value) {
    programsSteps.openProgramCard(value);
  }

  @And("^I open '(.*)' random program card$")
  public void openRandomProgramCard(String suffix) {
    String programName = Serenity.sessionVariableCalled("programName" + suffix);
    programsSteps.openProgramCard(programName);
  }

  @And("I close program card")
  public void closeProgramCard() {
    programsSteps.closeProgramCard();
  }

  @And("^I open random program card$")
  public void openRandomProgramCard() {
    String programName = Serenity.sessionVariableCalled("programName");
    programsSteps.openProgramCard(programName);
  }

  @And("^I edit program action '(.*)'$")
  public void editProgramAction(String actionTitle) {
    programsSteps.editProgramAction(actionTitle);
  }

  @And("^I enable program action '(.*)'$")
  public void enableProgramAction(String actionTitle) {
    programsSteps.enableProgramAction(actionTitle);
  }

  @And("^I disable program action '(.*)'$")
  public void disableProgramAction(String actionTitle) {
    programsSteps.disableProgramAction(actionTitle);
  }

  @And("^I delete program action '(.*)'$")
  public void deleteProgramAction(String actionTitle) {
    programsSteps.deleteProgramAction(actionTitle);
  }

  @And("I cannot announce program action")
  public void checkCannotAnnounceAction() {
    programsSteps.checkCannotAnnounceAction();
  }

  @And("The program action does not contain duration limitation")
  public void checkProgramActionNotContainsDurationLimitation() {
    programsSteps.checkProgramActionNotContainsDurationLimitation();
  }

  @And("The program action contains duration limitation")
  public void checkProgramActionContainsDurationLimitation() {
    programsSteps.checkProgramActionContainsDurationLimitation();
  }

  @And("^I announce challenge '(.*)' with message '(.*)'$")
  public void announceAction(String challengeTitle, String announcementMessage) {
    programsSteps.announceAction(challengeTitle, announcementMessage);
  }

  @And("^I announce challenge '(.*)' with message '(.*)' from activity$")
  public void announceActionFromActivity(String challengeTitle, String announcementMessage) {
    programsSteps.announceActionFromActivity(challengeTitle, announcementMessage);
  }

  @And("^I announce action with message '(.*)'$")
  public void sendAnnouncementMessage(String announcementMessage) {
    programsSteps.sendAnnouncementMessage(announcementMessage);
  }

  @Then("Actions Filter dropdown is displayed")
  public void checkActionsFilterIsDisplayed() {
    programsSteps.checkActionsFilterIsDisplayed();
  }

  @Then("Admin Actions Filter dropdown is not displayed")
  public void checkAdminActionsFilterIsNotDisplayed() {
    programsSteps.checkAdminActionsFilterIsNotDisplayed();
  }

  @Then("Admin Actions Filter dropdown is displayed")
  public void checkAdminActionsFilterIsDisplayed() {
    programsSteps.checkAdminActionsFilterIsDisplayed();
  }

}
