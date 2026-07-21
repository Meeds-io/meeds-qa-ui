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
import io.meeds.qa.ui.steps.ChatSteps;
import net.thucydides.core.annotations.Steps;

public class ChatStepDefinitions {

  @Steps
  private ChatSteps chatSteps;

  @When("^I open the chat drawer$")
  public void openChatDrawer() {
    chatSteps.openChatDrawer();
  }

  @Then("^the chat drawer is opened$")
  public void checkChatDrawerOpened() {
    chatSteps.checkChatDrawerOpened();
  }

  @Then("^the chat rooms list is displayed$")
  public void checkChatRoomsListDisplayed() {
    chatSteps.checkChatRoomsListDisplayed();
  }

}
