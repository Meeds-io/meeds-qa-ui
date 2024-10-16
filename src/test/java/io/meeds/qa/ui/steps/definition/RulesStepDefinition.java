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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.RulesSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;

import java.util.Map;

public class RulesStepDefinition {
  @Steps
  private RulesSteps rulesSteps;

  @And("^I enter the rule title '(.*)'$")
  public void enterProgramTitle(String ruleTitle) {
    rulesSteps.enterRuleTitle(ruleTitle);
  }

  @And("I add rule random title")
  public void enterProgramTitle() {
    String ruleTitle = "ruleTitle" + getRandomNumber();
    Serenity.setSessionVariable("ruleTitle").to(ruleTitle);
    rulesSteps.enterRuleTitle(ruleTitle);
  }

  @And("^I select a '(.*)' application")
  public void selectActionApplication(String applicationLabel) {
    rulesSteps.selectActionApplication(applicationLabel);
  }

  @And("^I select a '(.*)' event")
  public void addRuleEvent(String triggerName) {
    rulesSteps.addRuleEvent(triggerName);
  }

  @And("^I select '(.*)' as default contribution status")
  public void selectDefaultContributionStatus(String status) {
    rulesSteps.selectDefaultContributionStatus(status);
  }

  @And("I set rule end date")
  public void setActionEndDate() {
    rulesSteps.setActionEndDate();
  }

  @And("I delete rule duration")
  public void deleteActionDuration() {
    rulesSteps.deleteActionDuration();
  }

  @And("I click on the button to add a rule")
  public void clickAddActionButton() {
    rulesSteps.clickAddActionButton();
  }

  @And("I add rule random description")
  public void addRuleRandomDescription() {
    String ruleDescription = "ruleDescription" + getRandomNumber();
    Serenity.setSessionVariable("ruleDescription").to(ruleDescription);
    rulesSteps.addRuleRandomDescription(ruleDescription);
  }

  @And("^I create the '(.*)' random manual action with$")
  public void createRandomManualRule(String suffix, Map<String, String> details) {
    String title = "actionName" + getRandomNumber();
    rulesSteps.createAction(title, true, details);
    Serenity.setSessionVariable("actionName" + suffix).to(title);
  }

  @When("^I search for the (.*) rule in program detail rule filter$")
  public void searchRuleInProgramRuleFilter(String ruleTitle) {
    rulesSteps.searchRuleInProgramRuleFilter(ruleTitle);
  }

  @Then("^Rule not found. Please try again is displayed$")
  public void ruleNotfoundTryAgain() {
    rulesSteps.ruleNotfoundTryAgain();
  }

  @When("^I clear rules search filter$")
  public void clearRulesSearchFilter() {
    rulesSteps.clearRulesSearchFilter();
  }

  @Then("^The action '(.*)' is displayed in program detail$")
  public void isRuleDisplayedInProgramDetail(String actionTitle) {
    rulesSteps.isActionDisplayedInProgramDetail(actionTitle);
  }

  @Then("^The action '(.*)' is not displayed in program detail$")
  public void isRuleNotDisplayedInProgramDetail(String actionTitle) {
    rulesSteps.isActionNotDisplayedInProgramDetail(actionTitle);
  }

  @Then("^I open program action '(.*)'$")
  public void openActionDrawer(String actionTitle) {
    rulesSteps.openActionDrawer(actionTitle);
  }

  @And("I attach an image to the program action")
  public void attachImageToProgramAction() {
    rulesSteps.attachImageToProgramAction();
  }

  @And("I attach an image to the announcement")
  public void attachImageToAnnouncement() {
    rulesSteps.attachImageToAnnouncement();
  }

}
