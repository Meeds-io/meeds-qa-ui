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

import io.cucumber.java.en.Given;
import io.meeds.qa.ui.steps.LoginSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {

  @Steps
  private LoginSteps loginSteps;

  @Given("^I am authenticated as (.*)$")
  public void authenticate(String username) {
    loginSteps.authenticate(username);
  }

  @Given("^I connect as (.*) if random space and random users doesn't exists$")
  public void authenticateIfRandomSpaceAndUsersNotExists(String username, List<String> userPrefixes) {
    loginSteps.authenticateIfRandomSpaceAndUsersNotExists(username, "randomSpaceName", userPrefixes);
  }

  @Given("^I connect as (.*) if random users doesn't exists$")
  public void authenticateIfUsersNotExists(String username, List<String> userPrefixes) {
    loginSteps.authenticateIfUsersNotExists(username, userPrefixes);
  }

  @Given("I logout")
  public void logout() {
    loginSteps.logout();
  }

  @Given("I check login page display")
  public void checkLoginPageDisplay() {
    loginSteps.checkLoginPageDisplay();
  }

  @Given("^I change user (.*)$")
  public void logOutLogin(String username) {
    authenticate(username);
  }

  @Given("I connect with admin")
  public void authenticateAdmin() {
    authenticate("admin");
  }

  @Given("^I connect with the dedicated user to be an administrator$")
  public void logOutLoginFirstAdminUser() {
    String firstAdminName = Serenity.sessionVariableCalled("firstAdminName");
    logOutLogin(firstAdminName);
  }

  @Given("I connect with the first created user with the edited password")
  public void logOutLoginFirstUserEditedPassword() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    logOutLogin(firstUserName);
  }

  @Given("^I connect with the (.*) created user$")
  public void logoutLoginUser(String userPrefix) {
    String userName = Serenity.sessionVariableCalled(userPrefix + "UserName");
    authenticate(userName);
  }

}
