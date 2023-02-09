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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.fr.Et;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.ManageUnifiedSearchSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ManageUnifiedSearchStepDefinitions {
  @Steps
  private HomeSteps                homeSteps;

  @Steps
  private ManageUnifiedSearchSteps manageUnifiedSearchSteps;

  @And("I access to the unified search page")
  public void accessUnifiedSearchPage() {
    manageUnifiedSearchSteps.accessUnifiedSearchPage();
  }

  @When("^I click on the favorite button$")
  public void clickFavoriteBtn() {
    manageUnifiedSearchSteps.clickFavoriteBtn();
  }

  @When("^I favorite the activity '(.*)' from the search page$")
  public void favoriteSearchedActivity(String activity) {
    manageUnifiedSearchSteps.favoriteSearchedActivity(activity);
  }

  @When("^I click on the first created space$")
  public void goToTheFirsRandomSearchedSpace() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageUnifiedSearchSteps.goToTheSearchedSpace(randomSpaceName);
  }

  @When("^I click on the activity '(.*)'$")
  public void goToTheSearchedActivity(String activity) {
    manageUnifiedSearchSteps.goToTheSearchedActivity();
  }

  @When("^I click on the application '(.*)'$")
  public void goToTheSearchedApplication(String appName) {
    manageUnifiedSearchSteps.goToTheSearchedApplication(appName);
  }

  @When("^I click on the space '(.*)'$")
  public void goToTheSearchedSpace(String space) {
    manageUnifiedSearchSteps.goToTheSearchedSpace(space);
  }

  @When("^The activity is not displayed in the search '(.*)'$")
  public void isSearchedActivityTitleNotVisible(String activity) {
    manageUnifiedSearchSteps.isSearchedActivityTitleNotVisible(activity);
  }

  @Then("^The task is displayed in the search '(.*)'$")
  @When("^The activity is displayed in the search '(.*)'$")
  public void isSearchedActivityTitleVisible(String activity) {
    manageUnifiedSearchSteps.isSearchedActivityTitleVisible(activity);
  }

  @Then("^The description of the application is displayed in the search '(.*)'$")
  public void isSearchedApplicationDescriptionVisible(String appDesc) {
    manageUnifiedSearchSteps.isSearchedApplicationDescriptionVisible(appDesc);
  }

  @Then("^The full name of the application is displayed in the search '(.*)'$")
  public void isSearchedApplicationNameVisible(String appName) {
    manageUnifiedSearchSteps.isSearchedApplicationNameVisible(appName);
  }

  @Then("^The app logo is displayed in the search$")
  public void isSearchedApplicationPictureVisible() {
    manageUnifiedSearchSteps.isSearchedApplicationPictureVisible();
  }

  @Then("^The full name of the first created space is displayed in the search$")
  public void isSearchedFirsRandomSpaceNameVisible() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageUnifiedSearchSteps.isSearchedSpaceNameVisible(randomSpaceName);
  }

  @Then("^The user's full name is displayed in the search with last name Smith$")
  public void isSearchedRandomUserNameVisibleWithSameLastName() {
    String randomUserFirstName = Serenity.sessionVariableCalled("randomUserFirstName");
    String randomUserLastName = Serenity.sessionVariableCalled("randomUserLastName");

    String fullName = randomUserFirstName + " " + randomUserLastName;
    manageUnifiedSearchSteps.isSearchedUserNameVisible(fullName);
  }

  @Then("^The full name of the space is displayed in the search '(.*)'$")
  public void isSearchedSpaceNameVisible(String space) {
    manageUnifiedSearchSteps.isSearchedSpaceNameVisible(space);
  }

  @Then("^The user's full name is displayed in the search '(.*)'$")
  public void isSearchedUserNameVisible(String fullname) {
    manageUnifiedSearchSteps.isSearchedUserNameVisible(fullname);
  }

  @When("^I start the search for the user created by the name '(.*)'$")
  @Et("^I launch the search for the space created '(.*)'$")
  @Then("^I start the search for '(.*)'$")
  public void search(String element) {
    manageUnifiedSearchSteps.search(element);
  }

  @And("^I launch the search for the first random created space$")
  @Then("^I start the search for the first random created space$")
  public void searchForFirstRandomCreatedSpace() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageUnifiedSearchSteps.search(randomSpaceName);
  }

  @And("^I select an object from the drop-down menu '(.*)'$")
  public void selectDropDown(String object) {
    manageUnifiedSearchSteps.selectDropDown(object);
  }

}
