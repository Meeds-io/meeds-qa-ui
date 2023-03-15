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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.KudosSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class KudosStepDefinitions {

  @Steps
  private KudosSteps kudoSteps;

  @When("^I send to the comment activity a kudos message '(.*)'$")
  public void addActivityCommentKudos(String kudos) {
    kudoSteps.addActivityCommentKudos(kudos);
  }

  @When("^I send in the activity '(.*)' a kudos message '(.*)'$")
  public void addActivityKudos(String activity, String kudos) {
    kudoSteps.addActivityKudos(activity, kudos);
  }

  @When("^I send in the activity '(.*)' a kudos message '(.*)' to '(.*)' user$")
  public void addActivityKudosToSomeoneDifferent(String activity, String message, String userPrefix) {
    String firstName = Serenity.sessionVariableCalled(userPrefix + "UserFirstName");
    String lastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    String fullName = firstName + " " + lastName;
    kudoSteps.addActivityKudosToSomeoneDifferent(activity, message, fullName);
  }

  @And("^the kudos activity UI '(.*)' is displayed in stream page$")
  @Then("^the updated Kudos activity '(.*)' is displayed in stream page$")
  public void checkkudosActivity(String message) {
    kudoSteps.isKudosActivityVisible(message);
  }

  @And("^kudos icon of the activity '(.*)' is Disabled$")
  public void checkKudosIconDisabled(String activityId) {
    kudoSteps.checkKudosIconDisabled(activityId);
  }

  @Then("The kudos settings saved with a kudos number equal to '{}' and '{}' period type")
  public void checkKudosSettings(String val, String semester) {
    kudoSteps.checkKudosSettings(val, semester);
  }

  @Given("^I click to edit the kudos text$")
  public void clickEditKudos() {
    kudoSteps.clickEditKudos();
  }

  @Given("^I click to edit the kudos from a reply comment$")
  public void clickEditKudosFromReply() {
    kudoSteps.clickEditKudosFromReply();
  }

  @And("I click on three dots menu click on the edit button")
  public void editKudos() {
    kudoSteps.editKudos();
  }

  @When("^I cancel the sent kudos activity '(.*)'")
  public void cancelKudosActivity(String activity) {
    kudoSteps.cancelActivityKudos(activity);
  }

  @When("^In activity '(.*)' I cancel the sent kudos comment '(.*)'")
  public void cancelKudosComment(String activity, String comment) {
    kudoSteps.cancelCommentKudos(activity, comment);
  }

  @When("^I go to administration then reward then kudos$")
  public void goToAdmin() {
    kudoSteps.goToKudosMenu();
  }

  @And("^I enter a number of kudos'(.*)'$")
  public void kudosSettings(String val) {
    kudoSteps.enterKudosNumber(val);
  }

  @And("I save all changes")
  public void saveChanges() {
    kudoSteps.saveChanges();
  }

  @And("I search for second user card")
  public void searchSecondUserCard() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    kudoSteps.searchUserCard(fullName);
  }

  @And("I search for '{}' card")
  public void searchUserCard(String user) {
    kudoSteps.searchUserCard(user);
  }

  @And("I select type period per semester")
  public void selectType() {
    kudoSteps.selectType();
  }

  @And("^I click on send kudos button and I send kudos with message '(.*)'$")
  public void threeDotsMenuSendKudos(String kudosMessage) {
    kudoSteps.threeDotsMenuSendKudos(kudosMessage);
  }

  @Given("^I set the new kudos '(.*)' and I click on update button$")
  public void updateKudosMessage(String kudos) {
    kudoSteps.updateKudosMessage(kudos);
  }

  @Given("^I set the new kudos comment text '(.*)' and I click on update button$")
  public void updateKudosCommentMessage(String kudos) {
    kudoSteps.updateKudosCommentMessage(kudos);
  }

  @Then("^In kudos activity '(.*)' the cancel option is not displayed$")
  public void checkCancelKudosActivityIsNotVisible(String kudos) {
    kudoSteps.checkCancelKudosActivityIsNotVisible(kudos);
  }

  @Then("^In activity '(.*)' the cancel option in kudos comment '(.*)' is not displayed$")
  public void checkCancelKudosCommentIsNotVisible(String activity, String kudos) {
    kudoSteps.checkCancelKudosCommentIsNotVisible(activity, kudos);
  }

}
