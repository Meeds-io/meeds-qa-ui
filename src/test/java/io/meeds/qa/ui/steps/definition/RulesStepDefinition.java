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

public class RulesStepDefinition {
  @Steps
  private RulesSteps rulesSteps;

  @And("^I enter the rule title '(.*)'$")
  public void enterProgramTitle(String ruleTitle) {
    rulesSteps.enterRuleTitle(ruleTitle);
  }

  @And("^I add an event '(.*)'")
  public void addAudienceSpace(String eventName) {
    rulesSteps.addRuleEvent(eventName);
  }

  @And("^I click on the button add action$")
  public void clickAddProgramBtn() {
    rulesSteps.clickAddRuleBtn();
  }

  @And("^I add rule random description$")
  public void addRuleRandomDescription() {
    String ruleDescription = "ruleDescription" + getRandomNumber();
    Serenity.setSessionVariable("ruleDescription").to(ruleDescription);
    rulesSteps.addRuleRandomDescription(ruleDescription);
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

  @Then("^The Rule (.*) is displayed$")
  public void ruleDisplayed(String ruleTitle) {
    rulesSteps.isRuleDisplayed(ruleTitle);
  }
}
