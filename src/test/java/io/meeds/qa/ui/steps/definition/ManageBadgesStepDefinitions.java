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

import static io.meeds.qa.ui.utils.Utils.getRandomString;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ManageBadgesSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ManageBadgesStepDefinitions {

  @Steps
  private ManageBadgesSteps manageBadgesSteps;

  @And("I add new Badge with random name, description '{}', score '{}', icon '{}', and domain '{}'")
  public void addRandomBadge(String description, String score, String icon, String domain) {
    String badgeName = "badge1" + getRandomString();
    manageBadgesSteps.addBadge(badgeName, description, score, icon, domain);
    Serenity.setSessionVariable("badgeName").to(badgeName);
  }

  @And("^I add new Badge to be deleted with random name, description '(.*)', score '(.*)', icon '(.*)', and domain '(.*)'$")
  public void addRandomBadgeToBeDeleted(String description, String score, String icon, String domain) {
    String badgeName = "badge1" + getRandomString();
    manageBadgesSteps.addBadge(badgeName, description, score, icon, domain);
    Serenity.setSessionVariable("badgeNameToBeDeleted").to(badgeName);
  }

  @And("^I add new Badge to be updated with random name, description '(.*)', score '(.*)', icon '(.*)', and domain '(.*)'$")
  public void addRandomBadgeToBeUpdated(String description, String score, String icon, String domain) {
    String badgeNameToBeUpdated = "badge1" + getRandomString();
    manageBadgesSteps.addBadge(badgeNameToBeUpdated, description, score, icon, domain);
    Serenity.setSessionVariable("badgeNameToBeUpdated").to(badgeNameToBeUpdated);
  }

  @And("I click on badge name Delete button")
  public void clickOnDeleteBadge() {
    String badgeName = Serenity.sessionVariableCalled("badgeNameToBeDeleted");
    manageBadgesSteps.clickOnDeleteBadge(badgeName);
  }

  @And("^I click on badge '(.*)' Delete button$")
  public void clickOnDeleteBadge(String badgeName) {
    manageBadgesSteps.clickOnDeleteBadge(badgeName);

  }

  @And("^I click on badge '(.*)' Edit button$")
  public void clickOnEditBadge(String badgeName) {
    manageBadgesSteps.clickOnEditBadge(badgeName);

  }

  @And("I click on the Edit button of the added badge")
  public void clickOnEditRandomBadge() {
    String badgeNameToBeUpdated = Serenity.sessionVariableCalled("badgeNameToBeUpdated");
    manageBadgesSteps.clickOnEditBadge(badgeNameToBeUpdated);
  }

  @Then("I confirm the addition of the new badge")
  public void confirmBadgeDomain() {
    manageBadgesSteps.confirmAdditionNewBadge();

  }

  @And("I confirm the deletion of the badge")
  public void confirmDeletionBadge() {
    manageBadgesSteps.confirmDeletionBadge();

  }

  @And("I confirm the edit of the badge")
  public void confirmEditBadge() {
    manageBadgesSteps.confirmEditBadge();

  }

  @And("^I enter the new badge description '(.*)'$")
  public void editBadgeDescription(String description) {
    manageBadgesSteps.editBadgeDescription(description);

  }

  @And("^I select the new badge domain '(.*)'$")
  public void editBadgeDomain(String domain) {
    manageBadgesSteps.editBadgeDomain(domain);

  }

  @And("^I enter the new badge name '(.*)'$")
  public void editBadgeName(String name) {
    manageBadgesSteps.editBadgeName(name);

  }

  @And("^I enter the new badge score '(.*)'$")
  public void editBadgeScore(String score) {
    manageBadgesSteps.editBadgeScore(score);

  }

  @And("I enter the new badge name")
  public void editRandomBadgeName() {
    String updatedBadgeName = "badge2" + getRandomString();
    manageBadgesSteps.editBadgeName(updatedBadgeName);
    Serenity.setSessionVariable("updatedBadgeName").to(updatedBadgeName);
  }

  @When("^I go to administration then I select manage badges$")
  public void goToManageBadgesMenu() {
    manageBadgesSteps.goToManageBadgesMenu();

  }

  @And("^I search for the badge '(.*)'$")
  public void insertBadgeNameInSearchField(String badgeName) {
    manageBadgesSteps.insertBadgeNameInSearchField(badgeName);

  }

  @And("I search for the random badge name")
  public void insertRandomBadgeNameInSearchField() {
    String badgeName = Serenity.sessionVariableCalled("badgeName");
    manageBadgesSteps.insertBadgeNameInSearchField(badgeName);

  }

  @Then("^The new badge is added successfully and is displayed with name '(.*)', description '(.*)', score '(.*)', domain '(.*)', and enabled status in badges list")
  @And("^The badge has been updated successfully and is displayed with name '(.*)', description '(.*)', score '(.*)', domain '(.*)', and enabled status in badges list")
  public void isBadgeDisplayedWithEnabledStatus(String badgeName,
                                                String badgeDescription,
                                                String badgeScore,
                                                String badgeDomain) {
    manageBadgesSteps.isBadgeDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

  }

  @And("^The badge with name '(.*)', description '(.*)', score '(.*)', domain '(.*)' is no longer displayed in badges list$")
  public void isBadgeNotDisplayedWithEnabledStatus(String badgeName,
                                                   String badgeDescription,
                                                   String badgeScore,
                                                   String badgeDomain) {
    manageBadgesSteps.isBadgeNotDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

  }

  @And("^The deleted badge with random name, description '(.*)', score '(.*)', domain '(.*)' is no longer displayed in badges list")
  public void isDeletedRandomBadgeNotDisplayedWithEnabledStatus(String badgeDescription, String badgeScore, String badgeDomain) {
    String badgeName = Serenity.sessionVariableCalled("badgeNameToBeDeleted");
    manageBadgesSteps.isBadgeNotDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

  }

  @Then("^The new badge is added successfully and is displayed with random name, description '(.*)', score '(.*)', domain '(.*)', and enabled status in badges list")
  public void isRandomBadgeDisplayedWithEnabledStatus(String badgeDescription, String badgeScore, String badgeDomain) {
    String badgeName = Serenity.sessionVariableCalled("badgeName");
    manageBadgesSteps.isBadgeDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

  }

  @And("^The badge with random name, description '(.*)', score '(.*)', domain '(.*)' is no longer displayed in badges list$")
  public void isRandomBadgeNotDisplayedWithEnabledStatus(String badgeDescription, String badgeScore, String badgeDomain) {
    String badgeName = Serenity.sessionVariableCalled("badgeName");
    manageBadgesSteps.isBadgeNotDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

  }

  @Then("^The new badge to be deleted is added successfully and is displayed with random name, description '(.*)', score '(.*)', domain '(.*)', and enabled status in badges list")
  public void isRandomBadgeToBeDeletedDisplayedWithEnabledStatus(String badgeDescription, String badgeScore, String badgeDomain) {
    String badgeNameToBeUpdated = Serenity.sessionVariableCalled("badgeNameToBeDeleted");
    manageBadgesSteps.isBadgeDisplayedWithEnabledStatus(badgeNameToBeUpdated, badgeDescription, badgeScore, badgeDomain);

  }

  @Then("^The new badge to be updated is added successfully and is displayed with random name, description '(.*)', score '(.*)', domain '(.*)', and enabled status in badges list")
  public void isRandomBadgeToBeUpdatedDisplayedWithEnabledStatus(String badgeDescription, String badgeScore, String badgeDomain) {
    String badgeNameToBeUpdated = Serenity.sessionVariableCalled("badgeNameToBeUpdated");
    manageBadgesSteps.isBadgeDisplayedWithEnabledStatus(badgeNameToBeUpdated, badgeDescription, badgeScore, badgeDomain);

  }

  @Then("Success alert '{}' is displayed")
  public void isSuccessAlertDisplayed(String message) {
    manageBadgesSteps.isSuccessAlertDisplayed(message);

  }

  @Then("^The badge has been updated successfully and is displayed with random name, description '(.*)', score '(.*)', domain '(.*)', and enabled status in badges list")
  public void isUpdatedRandomBadgeDisplayedWithEnabledStatus(String badgeDescription, String badgeScore, String badgeDomain) {
    String updatedBadgeName = Serenity.sessionVariableCalled("updatedBadgeName");
    manageBadgesSteps.isBadgeDisplayedWithEnabledStatus(updatedBadgeName, badgeDescription, badgeScore, badgeDomain);

  }

}
