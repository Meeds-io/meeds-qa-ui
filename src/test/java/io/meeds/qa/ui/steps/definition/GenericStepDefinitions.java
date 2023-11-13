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

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.GenericSteps;
import io.meeds.qa.ui.utils.Utils;
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

  @When("The button '{}' is not displayed")
  public void checkButtonNotdisplayed(String button) {
    assertThat(genericSteps.isButtonDisplayed(button)).as(String.format("The button %s should not be displayed but it was",
                                                                        button))
                                                      .isFalse();
  }

  @When("Confirmation message is displayed '{}'")
  public void checkConfirmMessage(String message) {
    genericSteps.checkConfirmMessageIsDisplayed(message);
  }

  @When("I switch the page to '{}' language")
  public void switchPageLanguage(String lang) {
    genericSteps.switchPageLanguage(lang);
  }

  @When("The '{}' translations button is primary")
  public void checkTranslationButtonIsPrimary(String indexName) {
    int index = Utils.getIndexFomName(indexName);
    genericSteps.checkTranslationButtonIsPrimary(index);
  }

  @When("The '{}' translations button is not primary")
  public void checkTranslationButtonIsNotPrimary(String indexName) {
    int index = Utils.getIndexFomName(indexName);
    genericSteps.checkTranslationButtonIsNotPrimary(index);
  }

  @When("I open translations drawer for the '{}' input")
  public void openTranslationsDrawer(String indexName) {
    int index = Utils.getIndexFomName(indexName);
    genericSteps.openTranslationsDrawer(index);
  }

  @When("I add the following '{}' translations")
  public void addTranslationValues(String fieldType, Map<String, String> valuesByLanguage) {
    genericSteps.addTranslationValues(fieldType, valuesByLanguage);
  }

  @When("The message '{}' is displayed")
  public void checkMessageIsDisplayed(String message) {
    genericSteps.checkMessageIsDisplayed(message);
  }

  @When("The message '{}' is displayed in page")
  public void checkMessageIsDisplayedInPage(String message) {
    genericSteps.checkMessageIsDisplayedInPage(message);
  }

  @When("The message '{}' is not displayed")
  public void checkMessageIsNotDisplayed(String message) {
    genericSteps.checkMessageIsNotDisplayed(message);
  }

  @When("The message '{}' is not displayed in page")
  public void checkMessageIsNotDisplayedInPage(String message) {
    genericSteps.checkMessageIsNotDisplayedInPage(message);
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

  @When("Success message is displayed")
  public void checkSuccessMessage() {
    genericSteps.checkSuccessMessageDisplayed();
  }

  @When("Information message is displayed")
  public void checkInformationMessageDisplayed() {
    genericSteps.checkInformationMessageDisplayed();
  }

  @When("^I confirm$")
  public void clickConfirm() {
    genericSteps.clickConfirm();
  }

  @When("^I click on '(.*)' button$")
  public void clickButton(String buttonText) {
    genericSteps.clickButton(buttonText);
  }

  @When("^I click on '(.*)' menu item$")
  public void clickMenuItem(String menuText) {
    genericSteps.clickMenuItem(menuText);
  }

  @When("^I click on '(.*)' link$")
  public void clickOnLink(String linkText) {
    genericSteps.clickLink(linkText);
  }

  @When("^I click on '(.*)' text$")
  public void clickOnText(String text) {
    genericSteps.clickOnText(text);
  }

  @When("^I click on '(.*)' button in drawer$")
  public void clickDrawerButton(String buttonText) {
    genericSteps.clickDrawerButton(buttonText);
  }

  @When("^I click on '(.*)' button in second level drawer$")
  public void clickSelecdLevelDrawerButton(String buttonText) {
    genericSteps.clickSelecdLevelDrawerButton(buttonText);
  }

  @Then("^The button '(.*)' is disabled$")
  public void buttonIsDisabled(String buttonText) {
    genericSteps.buttonIsDisabled(buttonText);
  }

  @Then("^The button '(.*)' is enabled")
  public void buttonIsEnabled(String buttonText) {
    genericSteps.buttonIsEnabled(buttonText);
  }

  @Then("^The button '(.*)' is disabled in drawer$")
  public void buttonInDrawerIsDisabled(String buttonText) {
    genericSteps.buttonInDrawerIsDisabled(buttonText);
  }

  @Then("^The button '(.*)' is enabled in drawer$")
  public void buttonInDrawerIsEnabled(String buttonText) {
    genericSteps.buttonInDrawerIsEnabled(buttonText);
  }

  @Then("^The button '(.*)' is not displayed in drawer$")
  public void buttonInDrawerIsNotDisplayed(String buttonText) {
    genericSteps.buttonInDrawerIsNotDisplayed(buttonText);
  }

  @Then("^The button '(.*)' is displayed in drawer$")
  public void buttonInDrawerIsDisplayed(String buttonText) {
    genericSteps.buttonInDrawerIsDisplayed(buttonText);
  }

  @When("I wait for drawer to open")
  public void waitForDrawerToOpen() {
    genericSteps.waitForDrawerToOpen();
  }

  @When("I wait for application loading")
  public void waitApplicationLoading() {
    Utils.waitForLoading();
  }

  @When("I sort table by '{}'")
  public void sortTableByField(String fieldText) {
    genericSteps.sortTableByField(fieldText);
  }

  @When("I wait for drawer to close")
  public void waitForDrawerToClose() {
    genericSteps.waitForDrawerToClose();
  }

  @When("I close the notification")
  public void closeToastNotification() {
    genericSteps.closeToastNotification();
  }

  @When("I close browser tab {int}")
  public void closeBrowserTab(int tabIndex) {
    genericSteps.closeBrowserTab(tabIndex);
  }

  @Then("I close the opened drawer")
  public void closeDrawerIfDisplayed() {
    genericSteps.closeDrawerIfDisplayed();
  }

  @Then("I expand the drawer")
  public void expandDrawer() {
    genericSteps.expandDrawer();
  }

  @Then("I click on go back button")
  public void clickOnGoBack() {
    genericSteps.clickOnGoBack();
  }

  @Then("I click on go back button in drawer")
  public void clickOnGoBackInDrawer() {
    genericSteps.clickOnGoBackInDrawer();
  }

  @When("I wait '{int}' seconds")
  @And("I wait for '{int}' seconds")
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
