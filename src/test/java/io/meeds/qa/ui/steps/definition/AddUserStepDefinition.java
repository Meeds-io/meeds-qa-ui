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

import static net.serenitybdd.core.Serenity.sessionVariableCalled;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.meeds.qa.ui.steps.AddUserSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import net.thucydides.core.annotations.Steps;

public class AddUserStepDefinition {

  @Steps
  private AddUserSteps addUserSteps;

  @Steps
  private HomeSteps    homeSteps;

  @Given("^I create a dedicated user to be an administrator$")
  public void addRandomAdminUser() {
    addUserSteps.addRandomUser("firstAdmin", true);
  }

  @Given("^I create the (.*) random user if not existing$")
  @And("^I create the (.*) random user$")
  public void addRandomUser(String prefix) {
    addUserSteps.addRandomUser(prefix, true);
  }

  @Given("^I create the (.*) random user if not existing, no wait$")
  public void addRandomUserNoWait(String prefix) {
    addUserSteps.addRandomUser(prefix, false);
  }

  @Given("^The following user is created$")
  public void addUser(Map<String, String> userDetails) {
    homeSteps.goToAddUser();
    addUserSteps.addUser(userDetails);
  }

  @Given("^I check that the (.*) random user is deleted$")
  public void checkCreatedUserIsDeleted(String userPrefix) {
    String userLastName = sessionVariableCalled(userPrefix + "UserLastName");
    addUserSteps.checkUserIsDeleted(userLastName);
  }

  @Given("^Popup is displayed to inform user that we can't delete your user account while being logged in with it$")
  public void checkPopupCantDeleteLoggedUser() {
    addUserSteps.checkPopupCantDeleteLoggedUser();
  }

  @Given("^Add Users drawer is opened$")
  public void checkThatAddUserDrawerIsDisplayed() {
    addUserSteps.checkThatAddUserDrawerIsDisplayed();
  }

  @Given("^I check that '(.*)' is deleted'$")
  public void checkUserIsDeleted(String fullName) {
    addUserSteps.checkUserIsDeleted(fullName);
  }

  @Given("^I click to delete user$")
  public void clickToDeleteUser() {
    addUserSteps.clickToDeleteUser();
  }

  @Given("^I delete user$")
  public void deleteUser() {
    addUserSteps.deleteUser();
  }

  @Given("^I enable User Status '(.*)'$")
  @And("^I disable User Status '(.*)'$")
  public void enableDisableUser(String userPrefix) {
    addUserSteps.enableDisableUser(sessionVariableCalled(userPrefix + "UserName"));
  }

  @Given("^I enter the user's informations$")
  public void enterUserInformations(Map<String, String> userDetails) {
    homeSteps.goToAddUser();
    addUserSteps.enterUserInformations(userDetails);
  }

  @Given("^I go to Add Users page$")
  public void goToAddUser() {
    homeSteps.goToAddUser();
  }

  @Given("^The (.*) created user is displayed$")
  public void isFirstUserNameDisplayed(String userPrefix) {
    addUserSteps.isUserNameDisplayed(sessionVariableCalled(userPrefix + "UserName"));
  }

  @Given("^The user '(.*)' is displayed$")
  public void isUserNameDisplayed(String user) {
    addUserSteps.isUserNameDisplayed(user);
  }

  @Given("^I add the user$")
  public void saveAddingUser() {
    addUserSteps.saveAddingUser();
  }

  @Given("^I search for the (.*) random user$")
  public void searchForCreatedUser(String userPrefix) {
    String userName = sessionVariableCalled(userPrefix + "UserName");
    addUserSteps.searchForUsersByName(userName);
  }

  @Given("^I search for user '(.*)'$")
  public void searchForUser(String user) {
    addUserSteps.searchForUsersByName(user);
  }

  @Given("^I search for '(.*)' Users$")
  public void searchForUsersByStatus(String status) {
    addUserSteps.searchForUsersByStatus(status);
  }

}
