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

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.AgendaSteps;
import net.thucydides.core.annotations.Steps;

public class AgendaStepDefinitions {

  @Steps
  private AgendaSteps agendaSteps;

  @When("^I go to the Agenda application$")
  public void openAgendaApplication() {
    agendaSteps.openAgendaApplication();
  }

  @Then("^The Agenda application is displayed$")
  public void checkAgendaApplicationDisplayed() {
    agendaSteps.checkAgendaApplicationDisplayed();
  }

  @Then("^The add event button is displayed$")
  public void checkAddEventButtonDisplayed() {
    agendaSteps.checkAddEventButtonDisplayed();
  }

  @Then("^The agenda views switcher is displayed$")
  public void checkAgendaViewsSwitcherDisplayed() {
    agendaSteps.checkAgendaViewsSwitcherDisplayed();
  }

  @Then("^The agenda filter is displayed$")
  public void checkAgendaFilterDisplayed() {
    agendaSteps.checkAgendaFilterDisplayed();
  }

  @Then("^The agenda now line is displayed$")
  public void checkAgendaNowLineDisplayed() {
    agendaSteps.checkAgendaNowLineDisplayed();
  }

  @When("^I go to the '(.*)' agenda view$")
  public void goToAgendaView(String view) {
    agendaSteps.goToAgendaView(view);
  }

  @When("^I click on the add event button$")
  public void clickAddEventButton() {
    agendaSteps.clickAddEventButton();
  }

  @Then("^The event creation form step '(.*)' is displayed$")
  public void checkEventCreationFormStep(String stepLabel) {
    agendaSteps.checkEventCreationFormStep(stepLabel);
  }

  @When("^I go to the settings page$")
  public void openSettingsPage() {
    agendaSteps.openSettingsPage();
  }

  @Then("^The agenda settings section is displayed$")
  public void checkAgendaSettingsDisplayed() {
    agendaSteps.checkAgendaSettingsDisplayed();
  }

  @When("^I click on edit agenda settings$")
  public void clickEditAgendaSettings() {
    agendaSteps.clickEditAgendaSettings();
  }

  @Then("^The agenda preferences drawer is displayed$")
  public void checkAgendaPreferencesDrawerDisplayed() {
    agendaSteps.checkAgendaPreferencesDrawerDisplayed();
  }

  @When("^I close the event creation form$")
  public void closeEventCreationForm() {
    agendaSteps.closeEventCreationForm();
  }

  @When("^I press ESC in the event creation form$")
  public void pressEscapeInEventCreationForm() {
    agendaSteps.pressEscapeInEventCreationForm();
  }

  @Then("^The event creation form is closed$")
  public void checkEventCreationFormClosed() {
    agendaSteps.checkEventCreationFormClosed();
  }

  @When("^I click on the repetition select box$")
  public void clickRepetitionSelectBox() {
    agendaSteps.clickRepetitionSelectBox();
  }

  @Then("^The repetition option '(.*)' is displayed$")
  public void checkRepetitionOption(String option) {
    agendaSteps.checkRepetitionOption(option);
  }

  @When("^I add an event titled '(.*)'$")
  public void addEvent(String title) {
    agendaSteps.addEvent(title);
  }

  @Then("^The event is created with message '(.*)'$")
  public void checkEventCreatedAlert(String alertMessage) {
    agendaSteps.checkEventCreatedAlert(alertMessage);
  }

  @When("^I open the event '(.*)' details$")
  public void openEventDetails(String title) {
    agendaSteps.openEventDetails(title);
  }

  @When("^I press ESC in the event details$")
  public void pressEscapeInEventDetails() {
    agendaSteps.pressEscapeInEventDetails();
  }

  @Then("^The event details are not visible$")
  public void checkEventDetailsNotVisible() {
    agendaSteps.checkEventDetailsNotVisible();
  }

  @When("^I open the edit event form$")
  public void openEditEventForm() {
    agendaSteps.openEditEventForm();
  }

  @Then("^The edit event form is displayed$")
  public void checkEditEventFormDisplayed() {
    agendaSteps.checkEditEventFormDisplayed();
  }

  @When("^I open the delete event form$")
  public void openDeleteEventForm() {
    agendaSteps.openDeleteEventForm();
  }

  @Then("^The event button '(.*)' is displayed$")
  public void checkEventButtonDisplayed(String buttonName) {
    agendaSteps.checkEventButtonDisplayed(buttonName);
  }

  @When("^I click on the '(.*)' event button$")
  public void clickEventButton(String buttonName) {
    agendaSteps.clickEventButton(buttonName);
  }

  @Then("^The event '(.*)' is deleted from the agenda$")
  public void checkEventDeletedFromAgenda(String title) {
    agendaSteps.checkEventDeletedFromAgenda(title);
  }

}
