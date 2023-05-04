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

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.GenericSteps;
import net.thucydides.core.annotations.Steps;

public class GenericStepDefinitions {

  @Steps
  private GenericSteps genericSteps;

  @When("The button '{}' is displayed")
  public void checkButton(String button) {
    assertThat(genericSteps.isButtonDisplayed(button)).as(String.format("The button %s should be displayed but it is not",
                                                                        button))
                                                      .isTrue();
  }

  @When("Confirmation message is displayed '{}'")
  public void checkConfirmMessage(String message) {
    genericSteps.checkConfirmMessageIsDisplayed(message);
  }

  @When("^The '(.*)' drawer is displayed$")
  public void checkDrawerDisplayed(String title) {
    genericSteps.checkDrawerDisplayed(title);
  }

  @Then("The page {string} is displayed")
  public void checkPage(String pageUri) {
    String currentUrl = genericSteps.getCurrentUrl();
    assertThat(StringUtils.contains(currentUrl, pageUri)).as(String.format("Current URL '%s' doesn't end with '%s'",
                                                                           currentUrl,
                                                                           pageUri))
                                                         .isTrue();

  }

  @Then("The page {string} that contains {string} is displayed")
  public void checkPage(String pageUri, String content) {
    String currentUrl = genericSteps.getCurrentUrl();
    assertThat(StringUtils.contains(currentUrl, pageUri)).as(String.format("Current URL '%s' doesn't end with '%s'",
                                                                           currentUrl,
                                                                           pageUri))
                                                         .isTrue();

    assertThat(genericSteps.containsContent(content)).as(String.format("Current Page '%s' doesn't contain '%s'",
                                                                       currentUrl,
                                                                       content))
                                                     .isTrue();
  }

  @When("success message is displayed")
  public void checkSuccessMessage() {
    assertThat(genericSteps.isSuccessMessageDisplayed()).as("Success message should be displayed but it is not")
                                                        .isTrue();
  }

  @When("^I confirm$")
  public void clickConfirm() {
    genericSteps.clickConfirm();
  }

  @When("^I click on '(.*)' button$")
  public void clickButton(String buttonText) {
    genericSteps.clickButton(buttonText);
  }

  @When("^I click on '(.*)' button in drawer$")
  public void clickDrawerButton(String buttonText) {
    genericSteps.clickDrawerButton(buttonText);
  }

  @Then("^The button '(.*)' is disabled$")
  public void buttonIsDisabled(String buttonText) {
    genericSteps.buttonIsDisabled(buttonText);
  }

  @Then("^The button '(.*)' is disabled in drawer$")
  public void buttonInDrawerIsDisabled(String buttonText) {
    genericSteps.buttonInDrawerIsDisabled(buttonText);
  }

  @When("I wait for drawer to open")
  public void waitForDrawerToOpen() {
    genericSteps.waitForDrawerToOpen();
  }

  @When("I wait for drawer to close")
  public void waitForDrawerToClose() {
    genericSteps.waitForDrawerToClose();
  }

  @When("I close browser tab {int}")
  public void closeBrowserTab(int tabIndex) {
    genericSteps.closeBrowserTab(tabIndex);
  }

  @Then("I close the opened drawer")
  public void closeDrawerIfDisplayed() {
    genericSteps.closeDrawerIfDisplayed();
  }

  @When("I wait '{int}' seconds")
  public void waitInSeconds(int seconds) {
    genericSteps.waitInSeconds(seconds);
  }
  
  @When("I wait '{int}' milliseconds")
  public void waitInMilliseconds(int milliseconds) {
    genericSteps.waitInMilliseconds(milliseconds);
  }

  @Then("^The switch button '(.*)' is not displayed$")
  public void checkSwitchButtonNotDisplayed(String buttonName) {
    genericSteps.checkSwitchButtonNotDisplayed(buttonName);
  }

  @Then("^The switch button '(.*)' is displayed$")
  public void checkSwitchButtonDisplayed(String buttonName) {
    genericSteps.checkSwitchButtonDisplayed(buttonName);
  }

  @Then("^I enable the switch button '(.*)'$")
  public void enableSwitchButtonDisplayed(String buttonName) {
    genericSteps.enableSwitchButtonDisplayed(buttonName);
  }

}
