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
package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;

public class PeoplePage extends GenericPage {

  public PeoplePage(WebDriver driver) {
    super(driver);
  }

  public ElementFacade addContactFullnameElement(String user) {
    return findByXPathOrCSS(String.format("//*[@class='v-card__text peopleCardBody align-center pt-2 pb-1']//a[contains(text(),'%s')]",
                                          user));
  }

  public void areCurrentUserPositionAndPointsOnLeaderboardDisplayed() {
    currentUserLeaderboardPositionElement().assertVisible();
  }

  public void areTwoFirstPlacesOnLeaderboardDisplayed() {
    // Display the 2 first places on Leaderboard
    firstUserLeaderboardPositionElement().assertVisible();
    secondUserLeaderboardPositionElement().assertVisible();
  }

  public void areTwoFirstUsersPointsOnLeaderboardDisplayed() {
    // Display the 2 first users points on Leaderboard
    firstUserLeaderboardPointsElement().assertVisible();
    secondUserLeaderboardPointsElement().assertVisible();
  }

  public void checkConnectToUser(String user) {
    assertThat(searchUser(user)).isTrue()
                                .as("User " + user + " wasn't found");
    ElementFacade userButton = getUserButton(user);
    userButton.checkClickable();
    if (!userButton.hasClass("connectUserButton")) {
      if (userButton.hasClass("acceptToConnectButton")) {
        ElementFacade invitationsRequestUserButton = getInvitationsRequestUserButton(user);
        clickOnElement(invitationsRequestUserButton);
        ElementFacade refuseInvitationUserButton = getRefuseInvitationUserButton(user);
        clickOnElement(refuseInvitationUserButton);
      } else if (userButton.hasClass("disconnectUserButton")) {
        clickOnElement(userButton);
        ElementFacade okButton = findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//button[contains(text(),'OK')]");
        okButton.waitUntilClickable();
        okButton.click();
      } else {
        clickOnElement(userButton);
      }
      userButton = getConnectUserButton(user);
      userButton.waitUntilVisible();
    }
    clickOnElement(userButton);
    getCancelRequestUserButton(user).waitUntilVisible();
  }

  public void checkThatAddContactButtonIsDisplayed() {
    // Check that the Add Contact Button is displayed
    ElementFacade addContactTitleElement = addContactTitleElement();
    addContactTitleElement.assertVisible();
    Assert.assertEquals(addContactTitleElement.getText(), "Connect");

  }

  public void checkThatAddedUserSuggestionIsDisplayed() {
    // Check that the added user suggestion is displayed
    String fourthUserFirstName = Serenity.sessionVariableCalled("fourthUserFirstName");
    String fourthUserLastName = Serenity.sessionVariableCalled("fourthUserLastName");

    String isFirstUserSuggestion = fourthUserFirstName + " " + fourthUserLastName;

    sentRequestsUsersElement(isFirstUserSuggestion).waitUntilVisible();
  }

  public void checkThatCircularAvatarIsDisplayed() {
    // Check that the circular avatar is displayed
    ElementFacade contactAvatarElement = contactAvatarElement();
    contactAvatarElement.assertVisible();
  }

  public void checkThatDeletedUserSuggestionIsNotDisplayed() {
    // Check that the deleted user suggestion is not displayed
    String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
    String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

    String isSecondUserSuggestion = thirdUserFirstName + " " + thirdUserLastName;

    sentRequestsUsersElement(isSecondUserSuggestion).waitUntilNotVisible();
  }

  public void checkThatFilterIsDisplayed() {
    // Check that Filter is displayed
    TextBoxElementFacade searchPeopleInputElement = searchPeopleInputElement();
    searchPeopleInputElement.assertVisible();
    Assert.assertEquals(searchPeopleInputElement.getAttribute("placeholder"), "Filter by name, position or skill");
  }

  public void checkThatFirstUserSuggestionIsNotDisplayed() {
    String thirdUserFirstName = Serenity.sessionVariableCalled("thirdUserFirstName");
    String thirdUserLastName = Serenity.sessionVariableCalled("thirdUserLastName");

    String isSecondUserSuggestion = thirdUserFirstName + " " + thirdUserLastName;

    ElementFacade firstSuggestionElement = firstSuggestionElement();
    Assert.assertEquals(firstSuggestionElement.getText(), isSecondUserSuggestion);
  }

  public void checkThatFullNameIsDisplayed() {
    // Check that the Fullname is displayed
    addContactFullnameElement().assertVisible();

  }

  public void checkThatJobIsDisplayed() {
    // Check that the job is displayed
    addContactJobElement().assertVisible();
  }

  public void checkThatMyConnectionsPulldownFiltersIsDisplayed(String user) {
    peoplePulldownFilterElement().selectByValue("connections");
    // Check My Connections Pull Down Filter
    addContactFullnameElement(user).waitUntilVisible();
  }

  public void checkThatPeopleShowingResultsIsDisplayed() {
    peopleShowingResultsElement().assertVisible();
  }

  public void checkThatPulldownFiltersIsDisplayed() {
    // Check that Pulldown Filter is displayed
    peoplePulldownFilterElement().assertVisible();
  }

  public void checkThatSuggestionWidgetDisplayedTwoUsersWithAddAndDeleteButtons() {
    // The suggestion widget is existing and displayed only 2 users with Add
    // button and Delete buttons
    firstSuggestionElement().assertVisible();
    secondSuggestionElement().assertVisible();
    addFirstUserSuggestionElement().assertVisible();
    addSecondUserSuggestionElement().assertVisible();
    deleteFirstSuggestionElement().assertVisible();
    deleteSecondSuggestionElement().assertVisible();
  }

  public void checkThatTheCoverIsDisplayed() {
    // Check that Contact cover is displayed
    addContactCoverWidthElement().assertVisible();
  }

  public void checkThatUserSuggestionIsDisplayed(String firstName, String lastName) {
    String fullName = firstName + " " + lastName;
    Assert.assertEquals(firstSuggestionElement().getText(), fullName);
  }

  public void checkThatUserSuggestionIsNotDisplayed(String firstName, String lastName) {
    String fullName = firstName + " " + lastName;
    Assert.assertNotEquals(firstSuggestionElement().getText(), fullName);
  }

  public void closeSentRequestsButton() {
    // Close Sent Requests Button
    closesendRequestButtonElement().click();
  }

  public void connectToUser(String user) {
    retryOnCondition(() -> checkConnectToUser(user));
  }

  public void connectUserProfile() {
    refreshPage();
    connectUserProfileButtonElement().click();
  }

  public ElementFacade currentUserLeaderboardPoints(String id) {
    return findByXPathOrCSS(String.format("(//*[@class='v-list-item__title']//a/following::*[@class='v-list-item__action me-4'])['%s']",
                                          id));
  }

  public void deleteSentRequest(String firstName, String lastName) {
    String userSuggestion = firstName + " " + lastName;
    deleteSentRequestsUsersElement(userSuggestion).click();
  }

  public ElementFacade deleteSentRequestsUsersElement(String user) {
    return findByXPathOrCSS(String.format("//*[@class='layout column']//*[@class='v-list-item__title']//a[contains(text(),'%s')]/following::button[1]",
                                          user));
  }

  public void deleteUserSuggestion() {
    // Delete the user suggestion
    deleteFirstSuggestionElement().click();
  }

  public void goToSentRequests() {
    ElementFacade sentRequestsButtonElement = sentRequestsButtonElement();
    sentRequestsButtonElement.waitUntilClickable();
    sentRequestsButtonElement.click();
  }

  public void goToUserProfile(String user) {
    retryOnCondition(() -> {
      searchPeopleInputElement().setTextValue(user);
      waitForLoading();
      getUserProfileButton(user).click();
    }, () -> waitFor(1).seconds() // User may not have been indexed yet
    );
  }

  public void isLeaderBoardWidgetDisplayed(String title) {
    // Check that the Leaderboard Widget is displayed
    TextBoxElementFacade leaderboardTitleElement = leaderboardTitleElement();
    leaderboardTitleElement.waitUntilVisible();
    Assert.assertEquals(leaderboardTitleElement.getText(), title);
  }

  public void checkThatPeopleCardItemDisplayed() {
    peopleCardItemElement().assertVisible();
  }

  public ElementFacade sentRequestsUsersElement(String user) {
    return findByXPathOrCSS(String.format("//*[@class='layout column']//*[@class='v-list-item__title']//a[contains(text(),'%s')]",
                                          user));
  }

  private ElementFacade addContactCoverWidthElement() {
    return findByXPathOrCSS("//*[@class='peopleCardFront']/div/div/div[@class='v-image__image v-image__image--cover']");
  }

  private ElementFacade addContactFullnameElement() {
    return findByXPathOrCSS("//*[@class='v-card__text peopleCardBody align-center pt-2 pb-1']//a");
  }

  private ElementFacade addContactJobElement() {
    return findByXPathOrCSS("//*[@class='v-card__subtitle userPositionLabel text-truncate py-0']");
  }

  private ElementFacade addContactTitleElement() {
    return findByXPathOrCSS("//*[@class='d-inline peopleRelationshipButtonText']");
  }

  private ElementFacade addFirstUserSuggestionElement() {
    return findByXPathOrCSS("(//*[@class='uiIconInviteUser'])[1]");
  }

  private ElementFacade addSecondUserSuggestionElement() {
    return findByXPathOrCSS("(//*[@class='uiIconInviteUser'])[2]");
  }

  private ElementFacade closesendRequestButtonElement() {
    return findByXPathOrCSS("//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light']");
  }

  private ElementFacade connectUserProfileButtonElement() {
    return findByXPathOrCSS("//*[@class='uiIconSocConnectUser']");
  }

  private ElementFacade contactAvatarElement() {
    return findByXPathOrCSS("//*[@class='peopleAvatar']//*[@class='v-image__image v-image__image--cover']");
  }

  private TextBoxElementFacade currentUserLeaderboardPositionElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-avatar tertiary']");
  }

  private ElementFacade deleteFirstSuggestionElement() {
    return findByXPathOrCSS("(//*[@class='uiIconCloseCircled'])[1]");
  }

  private ElementFacade deleteSecondSuggestionElement() {
    return findByXPathOrCSS("(//*[@class='uiIconCloseCircled'])[2]");
  }

  private ElementFacade firstSuggestionElement() {
    return findByXPathOrCSS("(//*[@class='v-list-item__content pb-3']//a)[1]");
  }

  private TextBoxElementFacade firstUserLeaderboardPointsElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='v-list-item__title']//a/following::*[@class='v-list-item__action me-4'])[1]");
  }

  private TextBoxElementFacade firstUserLeaderboardPositionElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='v-list-item__title']//a)[1]");
  }

  private ElementFacade getCancelRequestUserButton(String user) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s') and contains(@class,'userFullname')]//ancestor::*[contains(@class, 'peopleCardItem')]//button[contains(@class, 'cancelRequestButton')]",
                                          user));
  }

  private ElementFacade getConnectUserButton(String user) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s') and contains(@class,'userFullname')]//ancestor::*[contains(@class, 'peopleCardItem')]//button[contains(@class, 'connectUserButton')]",
                                          user));
  }

  private ElementFacade getInvitationsRequestUserButton(String user) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s') and contains(@class,'userFullname')]//ancestor::*[contains(@class, 'peopleCardItem')]//button[contains(@class, 'peopleButtonMenu')]",
                                          user));
  }

  private ElementFacade getRefuseInvitationUserButton(String user) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s') and contains(@class,'userFullname')]//ancestor::*[contains(@class, 'peopleCardItem')]//button[contains(@class, 'refuseToConnectButton')]",
                                          user));
  }

  private ElementFacade getUserButton(String user) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s') and contains(@class,'userFullname')]//ancestor::*[contains(@class, 'peopleCardItem')]//button[contains(@class, 'peopleRelationshipButton')]",
                                          user));
  }

  private ElementFacade getUserProfileButton(String user) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s') and contains(@class,'userFullname')]", user));
  }

  private TextBoxElementFacade leaderboardTitleElement() {
    return findTextBoxByXPathOrCSS("//*[@id='usersLeaderboard']//*[@class='d-inline-block']");
  }

  private TextBoxElementFacade peoplePulldownFilterElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='v-input__prepend-inner']/following::*[@class='v-text-field__slot']/input/following::select)[1]");
  }

  private TextBoxElementFacade peopleShowingResultsElement() {
    return findTextBoxByXPathOrCSS("//*[@class='showingPeopleText text-sub-title ms-3 d-none d-sm-flex']");
  }

  private TextBoxElementFacade searchPeopleInputElement() {
    return findTextBoxByXPathOrCSS("//header[@id='peopleListToolbar']//input");
  }

  private ElementFacade secondSuggestionElement() {
    return findByXPathOrCSS("(//*[@class='v-list-item__content pb-3']//a)[2]");
  }

  private TextBoxElementFacade secondUserLeaderboardPointsElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='v-list-item__title']//a/following::*[@class='v-list-item__action me-4'])[2]");
  }

  private TextBoxElementFacade secondUserLeaderboardPositionElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='v-list-item__title']//a)[2]");
  }

  private ElementFacade sentRequestsButtonElement() {
    return findByXPathOrCSS("//*[@class='peopleOverviewCard d-flex flex-column clickable']");
  }

  private ElementFacade peopleCardItemElement() {
    return findByXPathOrCSS(".peopleCardFront");
  }

  public boolean searchUser(String user) {
    TextBoxElementFacade inputField = searchPeopleInputElement();
    inputField.checkVisible();
    inputField.setTextValue(user + "x");

    boolean visible = false;
    int retry = 0;
    Duration retryWaitTime = Duration.ofSeconds(1);
    ElementFacade userCard;
    do {
      inputField.sendKeys(Keys.BACK_SPACE);
      waitFor(300).milliseconds();
      waitForLoading();
      userCard = getUserButton(user);
      userCard.setImplicitTimeout(retryWaitTime);
      visible = userCard.isVisible();
      if (visible) {
        return true;
      }
    } while (!visible && retry++ < MAX_WAIT_RETRIES); // NOSONAR
    return false;
  }

}
