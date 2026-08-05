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
import io.meeds.qa.ui.steps.OnlyOfficeSteps;
import net.thucydides.core.annotations.Steps;

public class OnlyOfficeStepDefinitions {

  @Steps
  private OnlyOfficeSteps onlyOfficeSteps;

  @When("^I attach the file '(.*)' to the activity$")
  public void attachFileToActivity(String fileName) {
    onlyOfficeSteps.attachFileToActivity(fileName);
  }

  @When("^I open the document preview '(.*)'$")
  public void openDocumentPreview(String fileName) {
    onlyOfficeSteps.openDocumentPreview(fileName);
  }

  @Then("^The edit online button is not displayed$")
  public void checkEditOnlineButtonNotDisplayed() {
    onlyOfficeSteps.checkEditOnlineButtonNotDisplayed();
  }

}
