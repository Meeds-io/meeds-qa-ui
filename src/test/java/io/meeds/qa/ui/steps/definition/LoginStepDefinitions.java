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

import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.meeds.qa.ui.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {

  @Steps
  private LoginSteps loginSteps;

  @Given("^I am authenticated as '(.*)' random user$")
  @And("^I login as '(.*)' random user$")
  public void loginUser(String userPrefix) {
    loginSteps.authenticate(userPrefix);
  }

  @Given("^I am authenticated as '(.*)' if random users doesn't exists$")
  public void authenticateIfUsersNotExists(String userPrefix, List<String> userPrefixes) {
    loginSteps.authenticateIfUsersNotExists(userPrefix, userPrefixes);
  }

  @Given("^I am authenticated as '(.*)' if random space and random users doesn't exists$")
  public void authenticateIfRandomSpaceAndUsersNotExists(String userPrefix, List<String> userPrefixes) {
    loginSteps.authenticateIfRandomSpaceAndUsersNotExists(userPrefix, "randomSpaceName", userPrefixes);
  }

  @Given("I logout")
  public void logout() {
    loginSteps.logout();
  }

  @Given("I check login page display")
  public void checkLoginPageDisplay() {
    loginSteps.checkLoginPageDisplay();
  }

  @Then("Register link is displayed")
  public void checkRegisterLinkIsDisplayed() {
    loginSteps.checkRegisterLinkIsDisplayed();
  }

  @Then("Register link is not displayed")
  public void checkRegisterLinkIsNotDisplayed() {
    loginSteps.checkRegisterLinkIsNotDisplayed();
  }

}
