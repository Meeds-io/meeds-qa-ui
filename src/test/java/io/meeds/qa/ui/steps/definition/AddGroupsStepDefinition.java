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

import io.cucumber.java.en.Given;
import io.meeds.qa.ui.steps.AddGroupsSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AddGroupsStepDefinition {

  @Steps
  private AddGroupsSteps addGroupsSteps;

  @Steps
  private HomeSteps      homeSteps;

  @Given("^I add the role '(.*)' to the (.*) created user$")
  public void addMemberInGroup(String role, String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    addGroupsSteps.addMemberInGroup(role, userLastName);
  }

  @Given("^I open the group '(.*)'$")
  public void openGroup(String group) {
    addGroupsSteps.openGroup(group);
  }

  @Given("^I select the group '(.*)'$")
  public void selectGroup(String group) {
    addGroupsSteps.selectGroup(group);
  }

}
