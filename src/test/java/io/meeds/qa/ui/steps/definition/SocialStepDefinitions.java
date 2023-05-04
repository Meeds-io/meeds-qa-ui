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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.SocialSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class SocialStepDefinitions {

  @Steps
  private SocialSteps socialSteps;

  @When("^I set the new comment '(.*)' and I click on cancel button$")
  public void cancelUpdateActivityComment(String comment) {
    socialSteps.cancelUpdateActivityComment(comment);
  }

  @Given("The search result is well matched with the username entered of the first user")
  public void checkSearchedFirstUserWellMatched() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    socialSteps.checkSearchedUserWellMatched(firstUserName);
  }

  @Given("The search result is well matched with the username entered of the second user")
  public void checkSearchedSecondUserWellMatched() {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    socialSteps.checkSearchedUserWellMatched(secondUserName);
  }

  @Given("^The search result is well matched with the username entered '(.*)'$")
  public void checkSearchedUserWellMatched(String user) {
    socialSteps.checkSearchedUserWellMatched(user);
  }

  @And("I Select the comment added and I click on edit button")
  public void editComment() {
    socialSteps.editComment();
  }

  @And("I click on People filter and I select My connections")
  public void filterByMyConnections() {
    socialSteps.filterByMyConnections();

  }

  @When("^I go to people page$")
  public void goToPeoplePage() {
    socialSteps.goToPeopleMenu();
  }

  @And("^I search for '(.*)' random user$")
  public void searchRandomUser(String suffix) {
    String firstName = Serenity.sessionVariableCalled(suffix + "UserFirstName");
    String lastName = Serenity.sessionVariableCalled(suffix + "UserLastName");
    String fullName = firstName + " " + lastName;

    socialSteps.insertNameContact(fullName);
  }

  @And("^I enter the contact name '(.*)'$")
  public void insertNameContact(String user) {
    socialSteps.insertNameContact(user);
  }

  @And("I enter the contact name of the first user")
  public void insertNameOfFirstContact() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String fullName = firstUserFirstName + " " + firstUserLastName;
    socialSteps.insertNameContact(fullName);
  }

  @And("I enter the contact name of the second user")
  public void insertNameOfSecondContact() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    socialSteps.insertNameContact(fullName);
  }

  @When("^I set the new comment '(.*)' and I click on update button$")
  public void updateActivityComment(String comment) {
    socialSteps.updateActivityComment(comment);
  }

}
