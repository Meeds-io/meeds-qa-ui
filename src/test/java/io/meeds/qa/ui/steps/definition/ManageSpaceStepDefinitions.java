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

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.hook.TestInitHook;
import io.meeds.qa.ui.pages.ManageSpacesPage;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ManageSpaceStepDefinitions {

  private static final String RANDOM_SPACE_NAME2 = "RandomSpaceName";

  private static final String THIRD_RANDOM_SPACE_NAME = "thirdRandomSpaceName";

  private static final String USER_FIRST_NAME = "UserFirstName";

  private static final String SECOND_RANDOM_SPACE_NAME = "secondRandomSpaceName";

  private static final String SPACE_NAME = "spaceName";

  public static final String RANDOM_SPACE_NAME = "randomSpaceName";

  @Steps
  private HomeSteps        homeSteps;

  private ManageSpacesPage manageSpacesPage;

  @Steps
  private ManageSpaceSteps manageSpaceSteps;

  @When("I accept the invitation of the random space")
  public void acceptInvitationRandomSpace() {
    String randomSpaceName = sessionVariableCalled(RANDOM_SPACE_NAME);
    homeSteps.acceptRandomSpaceInvitation(randomSpaceName);
  }

  @When("^I accept the invitation of the (.*) created space$")
  public void acceptRandomSpace(String spacePrefix) {
    String randomSpaceName = sessionVariableCalled(spacePrefix + RANDOM_SPACE_NAME2);
    homeSteps.acceptRandomSpaceInvitation(randomSpaceName);
  }

  @When("^I accept the invitation of the third created space$")
  public void acceptThirdRandomSpace() {
    String thirdRandomSpaceName = sessionVariableCalled(THIRD_RANDOM_SPACE_NAME);
    homeSteps.acceptRandomSpaceInvitation(thirdRandomSpaceName);
  }

  @Given("I create a random space")
  public void addARandomSpace() {
    String randomSpaceName = RANDOM_SPACE_NAME + getRandomNumber();
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithRegistration(randomSpaceName, "Open");
    TestInitHook.spaceWithPrefixCreated(RANDOM_SPACE_NAME, randomSpaceName, Serenity.getDriver().getCurrentUrl());
  }

  @Given("^I create a random space with the (.*) random user$")
  public void addARandomSpaceWithRandomUserInvited(String userPrefix) {
    String randomSpaceName = RANDOM_SPACE_NAME + getRandomNumber();
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, userFirstName);
    setSessionVariable(RANDOM_SPACE_NAME).to(randomSpaceName);
  }

  @Given("^I create the '(.*)' random space with the '(.*)' random user as member and registration '(.*)'$")
  public void addARandomSpaceWithRegistrationAndRandomUserInvited(String spacePrefix, String userPrefix, String registration) {
    String randomSpaceName = RANDOM_SPACE_NAME + getRandomNumber();
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithRegistrationAndInviteUser(randomSpaceName, registration, userFirstName);
    setSessionVariable(spacePrefix + RANDOM_SPACE_NAME2).to(randomSpaceName);
  }

  @Given("^I create the '(.*)' random space with registration '(.*)'$")
  public void addARandomSpaceWithRegistration(String spacePrefix, String registration) {
    String randomSpaceName = RANDOM_SPACE_NAME + getRandomNumber();
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithRegistration(randomSpaceName, registration);
    TestInitHook.spaceWithPrefixCreated(spacePrefix + RANDOM_SPACE_NAME2, randomSpaceName, Serenity.getDriver().getCurrentUrl());
  }

  @Given("I open space invitation drawer")
  public void openSpaceInvitationDrawer() {
    manageSpaceSteps.openSpaceInvitationDrawer();
  }

  @Given("I open space external invitation drawer")
  public void openSpaceExternalInvitationDrawer() {
    manageSpaceSteps.openSpaceExternalInvitationDrawer();
  }
  
  @Given("^I enter email '(.*)' to invite in random space$")
  public void inviteEmailAsSpaceMember(String email) {
    manageSpaceSteps.inviteEmailAsSpaceMember(email);
  }
  
  @Then("^The email '(.*)' is set to '(.*)' in invitations list$")
  public void emailIsListedInInvitationList(String email, String status) {
    manageSpaceSteps.emailIsListedInInvitationList(email, status);
  }

  @Then("I open the space pending invitations drawer")
  public void openSpacePendingInvitationsDrawer() {
    manageSpaceSteps.openSpacePendingInvitationsDrawer();
  }

  @Then("I open the space extenal invitations tab")
  public void openSpaceExternalInvitationsTab() {
    manageSpaceSteps.openSpaceExternalInvitationsTab();
  }

  @Then("I cannot access space external invitation drawer")
  public void checkExternalInviteButtonNotDisplayed() {
    manageSpaceSteps.checkExternalInviteButtonNotDisplayed();
  }

  @Then("^The email '(.*)' is not displayed in invitations list$")
  public void emailIsNotListedInInvitationList(String email) {
    manageSpaceSteps.emailIsNotListedInInvitationList(email);
  }

  @Given("^I create a (.*) random space$")
  @And("^I create the (.*) random space$")
  public void addARandomSpace(String spacePrefix) {
    String randomSpaceName = RANDOM_SPACE_NAME + getRandomNumber();
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithRegistration(randomSpaceName, "Open");
    TestInitHook.spaceWithPrefixCreated(spacePrefix + RANDOM_SPACE_NAME2, randomSpaceName, Serenity.getDriver().getCurrentUrl());
  }

  @Given("^I create a (.*) random space with the (.*) created user as member$")
  @And("^I create the (.*) random space with the (.*) random user as member$")
  public void addARandomSpaceWithRandomUserInvited(String spacePrefix, String userPrefix) {
    String randomSpaceName = RANDOM_SPACE_NAME + getRandomNumber();
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, userFirstName);
    setSessionVariable(spacePrefix + RANDOM_SPACE_NAME2).to(randomSpaceName);
  }

  @Given("^I check that avatar section is displayed$")
  public void checkAvatarSection() {
    manageSpaceSteps.checkAvatarSection();
  }

  @Given("^I check that cancel button is displayed$")
  public void checkCancelButton() {
    manageSpaceSteps.checkCancelButton();
  }

  @Given("^I check that space description section is displayed$")
  public void checkDescriptionSpaceSection() {
    manageSpaceSteps.checkDescriptionSpaceSection();
  }

  @Then("The favorite icon should be displayed in space card")
  public void checkFavIconInSpaceCard() {
    manageSpaceSteps.checkFavIconInSpaceCard();
  }

  @Then("The favorite icon should be displayed in space popover from topbar")
  public void checkFavIconInSpacePopoverFromTopbar() {
    manageSpaceSteps.checkFavIconInSpacePopoverFromTopbar();
  }

  @Then("The favorite icon should be displayed on space details panel")
  public void checkFavIconInThirdNavigationLevel() {
    manageSpaceSteps.checkFavIconInThirdNavigationLevel();
  }

  @When("The first created space is not displayed in Spaces Requests section")
  public void checkFirstRandomDisplaySpaceInvitation() {
    String randomSpaceName = sessionVariableCalled(RANDOM_SPACE_NAME);
    homeSteps.checkRandomNotDisplaySpaceInvitation(randomSpaceName);
  }

  @Given("^I check that general settings section is displayed with his edit icon$")
  public void checkGeneralSpaceSettings() {
    manageSpaceSteps.checkGeneralSpaceSettings();
  }

  @Given("^I check that hidden section and switch button are displayed$")
  public void checkHiddenAndSwitchButtonSection() {
    manageSpaceSteps.checkHiddenAndSwitchButtonSection();
  }

  @Given("^I check that space name section is displayed$")
  public void checkNameSpaceSection() {
    manageSpaceSteps.checkNameSpaceSection();
  }

  @Given("^I check that registration section is displayed$")
  public void checkRegistrationSection() {
    manageSpaceSteps.checkRegistrationSection();
  }

  @When("The second created space is not displayed in Spaces Requests section")
  public void checkSecondRandomNotDisplaySpaceInvitation() {
    String secondRandomSpaceName = sessionVariableCalled(SECOND_RANDOM_SPACE_NAME);
    homeSteps.checkRandomNotDisplaySpaceInvitation(secondRandomSpaceName);
  }

  @When("I check that the random space is bookmarked as favorite from space card")
  public void checkSpaceBookmarkedFromSpaceCard() {
    manageSpaceSteps.checkSpaceBookmarkedFromSpaceCard();
  }

  @When("I check that the random space is bookmarked as favorite from topbar space popover")
  public void checkSpaceBookmarkedFromTopbarSpacePopover() {
    manageSpaceSteps.checkSpaceBookmarkedFromTopbarSpacePopover();
  }

  @When("I check that the random space is bookmarked as favorite from Third Navigation Level")
  public void checkSpaceBookmarkThirdNavigationLevel() {
    manageSpaceSteps.checkSpaceBookmarkThirdNavigationLevel();
  }

  @Given("^I check that space template section is displayed$")
  public void checkSpaceTemplateSection() {
    manageSpaceSteps.checkSpaceTemplateSection();
  }

  @When("I check that the random space is unbookmarked from space card")
  public void checkSpaceUnBookmarkFromSpaceCard() {
    manageSpaceSteps.checkSpaceUnBookmarkFromSpaceCard();
  }

  @When("I check that the random space is unbookmarked from Third Navigation Level")
  public void checkSpaceUnBookmarkFromThirdNavigationLevel() {
    manageSpaceSteps.checkSpaceUnBookmarkFromThirdNavigationLevel();
  }

  @When("I check that the random space is unbookmarked from topbar space popover")
  public void checkSpaceUnBookmarkFromTopbarSpacePopover() {
    manageSpaceSteps.checkSpaceUnBookmarkFromTopbarSpacePopover();
  }

  @Given("^First space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatFirstSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(sessionVariableCalled(SPACE_NAME), members);
  }

  @Given("First space name is not displayed in spaces page search results$")
  public void checkThatFirstSpaceInSearchResultsIsNotDisplayed() {
    manageSpaceSteps.checkThatSpaceInSearchResultsIsNotDisplayed(sessionVariableCalled(SPACE_NAME));
  }

  @Given("^Second space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatSecondSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(sessionVariableCalled(SECOND_RANDOM_SPACE_NAME), members);
  }

  @Given("Second space name is not displayed in spaces page search results$")
  public void checkThatSecondSpaceInSearchResultsIsNotDisplayed() {
    manageSpaceSteps.checkThatSpaceInSearchResultsIsNotDisplayed(sessionVariableCalled(SECOND_RANDOM_SPACE_NAME));
  }

  @Given("^The created space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(sessionVariableCalled(RANDOM_SPACE_NAME),
                                                                                 members);
  }

  @Given("Space Top Bar Elements are displayed")
  public void checkThatSpaceTopBarElementsAreDisplayed() {
    manageSpacesPage.checkThatSpaceTopBarElementsAreDisplayed();
  }

  @Given("^Third space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatThirdSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(sessionVariableCalled(THIRD_RANDOM_SPACE_NAME), members);
  }

  @When("The third created space is displayed in Spaces Requests section")
  public void checkThirdRandomDisplaySpaceInvitation() {
    String thirdRandomSpaceName = sessionVariableCalled(THIRD_RANDOM_SPACE_NAME);
    homeSteps.checkRandomDisplaySpaceInvitation(thirdRandomSpaceName);
  }

  @Given("I create or check that thirty spaces are created")
  public void checkThirtyRandomSpacesArePresent() {
    manageSpaceSteps.checkThirtyRandomSpacesArePresent();
  }

  @Given("^I click on edit general space settings$")
  public void clickOnGeneralSpaceSettings() {
    manageSpaceSteps.clickOnGeneralSpaceSettings();
  }

  @Then("I bookmark the random space as favorite from space card")
  @When("I unfavorite the random space from space card")
  public void clickOnSpaceBookmarkIconFromSpaceCard() {
    manageSpaceSteps.clickOnSpaceBookmarkIconFromSpaceCard();
  }

  @Then("I bookmark the random space as favorite from Third Navigation Level")
  @When("I unfavorite the random space from Third Navigation Level")
  public void clickOnSpaceBookmarkIconFromThirdNavigationLevel() {
    manageSpaceSteps.clickOnSpaceBookmarkIconFromThirdNavigationLevel();
  }

  @Then("I bookmark the random space as favorite from topbar space popover")
  @When("I unfavorite the random space from topbar space popover")
  public void clickOnSpaceBookmarkIconFromTopbarSpacePopover() {
    manageSpaceSteps.clickOnSpaceBookmarkIconFromTopbarSpacePopover();
  }

  @Given("^The First space was deleted successfully$")
  public void deleteFirstSpace() {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.deleteSpace(sessionVariableCalled(SPACE_NAME));
    TestInitHook.spaceWithPrefixDeleted(SPACE_NAME);
  }

  @Given("^The Second space was deleted successfully$")
  public void deleteSecondSpace() {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.deleteSpace(SECOND_RANDOM_SPACE_NAME);
    TestInitHook.spaceWithPrefixDeleted(SECOND_RANDOM_SPACE_NAME);
  }

  @Given("I go to members tab")
  public void goToMembersTab() {
    manageSpaceSteps.goToMembersTab();
  }

  @Given("I go to the random space")
  public void goToRandomSpace() {
    manageSpaceSteps.addOrGoToSpace(RANDOM_SPACE_NAME);
  }

  @Given("I join the random space")
  public void joinRandomSpace() {
    manageSpaceSteps.joinOrGoToSpace(RANDOM_SPACE_NAME);
  }

  @Given("I create the random space if not existing")
  public void goToRandomSpaceIfNotExisting() {
    if (StringUtils.isBlank(sessionVariableCalled(RANDOM_SPACE_NAME))) {
      manageSpaceSteps.addOrGoToSpace(RANDOM_SPACE_NAME);
    }
  }

  @Given("^I go to the (.*) random space$")
  @And("^I create the (.*) random space if not existing$")
  @And("^I create or go to the (.*) random space$")
  public void goToRandomSpaceWithPrefix(String spacePrefix) {
    manageSpaceSteps.addOrGoToSpace(spacePrefix + RANDOM_SPACE_NAME2);
  }

  @Given("I inject the random space")
  @And("I inject a random space")
  public void injectRandomSpace() {
    manageSpaceSteps.injectRandomSpace(RANDOM_SPACE_NAME);
  }

  @Given("I inject the random space if not existing")
  public void injectRandomSpaceIfNotExisting() {
    if (StringUtils.isBlank(sessionVariableCalled(RANDOM_SPACE_NAME))) {
      manageSpaceSteps.injectRandomSpace(RANDOM_SPACE_NAME);
    }
  }

  @Given("^I inject the (.*) random space$")
  public void injectRandomSpace(String spacePrefix) {
    manageSpaceSteps.injectRandomSpace(spacePrefix);
  }

  @Given("^I go to Settings in space tab$")
  public void goToSettingsTab() {
    manageSpaceSteps.goToSettingsTab();
  }

  @Given("^I go to space Home$")
  public void goToSpaceHomeViaSpaceAvatar() {
    manageSpaceSteps.goToSpaceHomeViaSpaceAvatar();
  }

  @Given("^I go to Tasks in space tab$")
  public void goToTasksTab() {
    manageSpaceSteps.goToTasksTab();
  }

  @When("^I hover on space name from top bar$")
  public void hoverOnSpaceName() {
    manageSpaceSteps.hoverOnSpaceName();
  }

  @Then("^The space page is displayed '(.*)'$")
  public void isSpacePageOpened(String space) {
    manageSpacesPage.isSpacePageOpened(space);
  }

  @Given("^The created space name is displayed$")
  public void randomSpaceNameIsDisplayed() {
    String randomSpaceName = sessionVariableCalled(RANDOM_SPACE_NAME);
    manageSpaceSteps.spaceNameIsDisplayed(randomSpaceName);
  }

  @When("^I reject the invitation of the (.*) created space$")
  public void rejectRandomSpace(String spacePrefix) {
    String randomSpaceName = sessionVariableCalled(spacePrefix + RANDOM_SPACE_NAME2);
    homeSteps.rejectRandomSpaceInvitation(randomSpaceName);
  }

  @Given("^I search the space '(.*)'$")
  public void searchSpace(String spaceName) {
    manageSpaceSteps.searchSpace(spaceName);
  }

  @Given("^The second created space name is displayed$")
  public void secondRandomSpaceNameIsDisplayed() {
    String secondRandomSpaceName = sessionVariableCalled(SECOND_RANDOM_SPACE_NAME);
    manageSpaceSteps.spaceNameIsDisplayed(secondRandomSpaceName);
  }

  @Given("^I select the filter '(.*)'$")
  public void selectFilter(String filter) {
    manageSpaceSteps.selectFilter(filter);
  }

  @Given("^I '(.*)'$")
  public void sendRequestToJoin(String action) {
    manageSpaceSteps.clickSpaceAction(action);
  }

  @When("I search for the random space")
  public void setInSearchRandomSpaceField() {
    String randomSpaceName = Serenity.sessionVariableCalled(RANDOM_SPACE_NAME);
    manageSpaceSteps.searchSpace(randomSpaceName);
  }

  @When("I leave found space")
  public void leaveSpace() {
    manageSpaceSteps.leaveSpace();
  }

  @Given("^I click on Show more button$")
  public void showMoreSpaces() {
    manageSpaceSteps.showMoreSpaces();
  }

  @Given("^Space Avatar is displayed$")
  public void spaceAvatarIsDisplayed() {
    manageSpaceSteps.spaceAvatarIsDisplayed();
  }

  @Given("^Space Name is displayed '(.*)'$")
  public void spaceNameIsDisplayed(String space) {
    manageSpaceSteps.spaceNameIsDisplayed(space);
  }

  @Given("^I upload the Space banner '(.*)'$")
  public void uploadSpaceBanner(String fileName) {
    manageSpaceSteps.uploadSpaceBanner(fileName);
  }
}
