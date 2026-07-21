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

  @When("^I click on the add event button$")
  public void clickAddEventButton() {
    agendaSteps.clickAddEventButton();
  }

  @Then("^The event creation form step '(.*)' is displayed$")
  public void checkEventCreationFormStep(String stepLabel) {
    agendaSteps.checkEventCreationFormStep(stepLabel);
  }

}
