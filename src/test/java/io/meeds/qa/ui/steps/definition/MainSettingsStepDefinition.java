/**
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
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package io.meeds.qa.ui.steps.definition;

import static io.meeds.qa.ui.steps.definition.ManageSpaceStepDefinitions.RANDOM_SPACE_NAME;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;

import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.MainSettingsSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MainSettingsStepDefinition {

  @Steps
  private MainSettingsSteps mainSettingsSteps;

  @Steps
  private HomeSteps         homeSteps;

  @When("I go to main settings page")
  public void goToMainSettingsPage() {
    homeSteps.goToMainSettings();
  }

  @When("I open access customizations settings")
  public void goToAccessCustomization() {
    mainSettingsSteps.goToAccessCustomization();
  }

  @When("I open branding customizations settings")
  public void goToBrandingCustomization() {
    mainSettingsSteps.goToBrandingCustomization();
  }

  @When("I open login customizations settings")
  public void goToLoginCustomization() {
    mainSettingsSteps.goToLoginCustomization();
  }

  @When("I go back to Main Settings page")
  public void goBackToMainSettings() {
    mainSettingsSteps.goBackToMainSettings();
  }

  @Then("Access customization settings is displayed")
  public void checkAccessCustomization() {
    mainSettingsSteps.checkAccessCustomization();
  }

  @Then("Branding customization settings is displayed")
  public void checkBrandingCustomization() {
    mainSettingsSteps.checkBrandingCustomization();
  }

  @Then("Login customization settings is displayed")
  public void checkLoginCustomization() {
    mainSettingsSteps.checkLoginCustomization();
  }

  @When("^I add login page title '(.*)'$")
  public void setLoginTitle(String title) {
    mainSettingsSteps.setLoginTitle(title);
  }

  @When("^I add login page sub title '(.*)'$")
  public void setLoginSubTitle(String title) {
    mainSettingsSteps.setLoginSubTitle(title);
  }

  @When("I select random space as default for registered users")
  public void selectAccessDefaultSpace() {
    String randomSpaceName = sessionVariableCalled(RANDOM_SPACE_NAME);
    mainSettingsSteps.selectAccessDefaultSpace(randomSpaceName);
  }

  @Then("^'(.*)' default spaces are selected for registered users$")
  public void checkAccessDefaultSpacesCount(int count) {
    mainSettingsSteps.checkAccessDefaultSpacesCount(count);
  }

  @When("I apply main settings customizations")
  public void applyCustomization() {
    mainSettingsSteps.applyCustomization();
  }

  @When("I select 'Open' access type")
  public void selectOpenAccessCustomization() {
    mainSettingsSteps.selectOpenAccessCustomization();
  }

  @When("I select 'Restricted' access type")
  public void selectRestrictedAccessCustomization() {
    mainSettingsSteps.selectRestrictedAccessCustomization();
  }

  @When("I switch 'Restricted' access type to enable external users registration")
  @And("I switch 'Restricted' access type to disabled external users registration")
  public void switchRestrictedExternalUsers() {
    mainSettingsSteps.switchRestrictedExternalUsers();
  }

  @When("I cancel main settings customizations")
  public void cancelCustomization() {
    mainSettingsSteps.cancelCustomization();
  }

  @Then("The apply button is disabled in Main settings customization")
  public void checkApplyButtonIsDisabled() {
    mainSettingsSteps.checkApplyButtonIsDisabled();
  }

  @Then("The apply button is enabled in Main settings customization")
  public void checkApplyButtonIsEnabled() {
    mainSettingsSteps.checkApplyButtonIsEnabled();
  }

  @Then("The 'Restricted' external user switch button is disabled")
  public void checkRestrictedExternalUserSwitchButtonIsDisabled() {
    mainSettingsSteps.checkRestrictedExternalUserSwitchButtonIsDisabled();
  }

  @Then("The 'Open' external user switch button is disabled")
  public void checkOpenExternalUserSwitchButtonIsDisabled() {
    mainSettingsSteps.checkOpenExternalUserSwitchButtonIsDisabled();
  }

}
