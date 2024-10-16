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
package io.meeds.qa.ui.steps;

import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.meeds.qa.ui.hook.TestInitHook;
import io.meeds.qa.ui.pages.HomePage;
import io.meeds.qa.ui.pages.ManageSpacesPage;
import io.meeds.qa.ui.utils.Utils;

import net.serenitybdd.core.Serenity;

public class ManageSpaceSteps {

  private static final String CREATE_SPACE_SCRIPT                        =
                                                  """
                                                       const callback = arguments[arguments.length - 1];
                                                       fetch("/portal/rest/v1/social/spaces/", {
                                                         "headers": {
                                                           "content-type": "application/json",
                                                         },
                                                         "body": `{"subscription":"%s","visibility":"%s","template":"%s","invitedMembers":[],"displayName":"%s","description":"%s"}`,
                                                         "method": "POST",
                                                         "credentials": "include"
                                                       })
                                                       .then(resp => {
                                                         if (!resp || !resp.ok) {
                                                           throw new Error("Error creating space");
                                                         }
                                                       })
                                                       .then(() => callback(true))
                                                       .catch(() => callback(false));
                                                      """;

  private static final String CONFIGURE_SPACE_CREATION_PERMISSION_SCRIPT =
                                                                         """
                                                                              const callback = arguments[arguments.length - 1];
                                                                              fetch("/portal/rest/v1/social/spacesAdministration/permissions/spacesCreators", {
                                                                                "headers": {
                                                                                  "content-type": "application/json",
                                                                                },
                                                                                "body": `[{"membershipType":"*","group":"/platform/users"}]`,
                                                                                "method": "PUT",
                                                                                "credentials": "include"
                                                                              })
                                                                              .then(resp => {
                                                                                if (!resp || !resp.ok) {
                                                                                  throw new Error("Error changing space creation permissions");
                                                                                }
                                                                              })
                                                                              .then(() => callback(true))
                                                                              .catch(() => callback(false));
                                                                             """;

  private static final int    SPACE_TEMPLATE_INDEX                       =
                                                   Integer.parseInt(System.getProperty("io.meeds.space.template.index", "0"));

  private String              spaceTemplate;

  private HomePage            homePage;

  private ManageSpacesPage    manageSpacesPage;

  public void joinOrGoToSpace(String spaceNamePrefix) {
    String spaceName = sessionVariableCalled(spaceNamePrefix);
    homePage.goToSpacesPage(false);
    if (findSpaceCard(spaceName, true)) {
      goOrJoinToSpace(spaceName);
    }
  }

  public void addOrGoToSpace(String spaceNamePrefix) {
    String spaceName = sessionVariableCalled(spaceNamePrefix);
    String spaceUrl = sessionVariableCalled(spaceNamePrefix + "-url");
    if (StringUtils.isNotBlank(spaceUrl)) {
      homePage.openUrl(spaceUrl);
      waitForPageLoading();
      if (StringUtils.equals(homePage.getCurrentUrl(), spaceUrl)) {
        return;
      } else if (!manageSpacesPage.isSpaceMenuDisplayed()) {
        boolean joined = manageSpacesPage.clickSpaceActionToJoin();
        if (joined) {
          waitForLoading();
          return;
        }
      }
    }
    homePage.goToSpacesPage(false);
    if (StringUtils.isBlank(spaceName)) {
      spaceName = Utils.getRandomString(spaceNamePrefix);
      if (findSpaceCard(spaceName)) {
        goOrJoinToSpace(spaceName);
      } else {
        addSpaceWithRegistration(spaceName, "Open");
      }
      TestInitHook.spaceWithPrefixCreated(spaceNamePrefix, spaceName, homePage.getCurrentUrl());
    } else if (findSpaceCard(spaceName, true)) {
      goOrJoinToSpace(spaceName);
    }
  }

  public void addSpaceWithInviteUser(String spaceName, String user) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.setSpaceDescription(spaceName);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.inviteUserToSpace(user);
    manageSpacesPage.saveSpace();
  }

  public void addSpaceWithRegistrationAndInviteUser(String spaceName, String registration, String user) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.setSpaceDescription(spaceName);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.checkSpaceRegistration(registration);
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.inviteUserToSpace(user);
    manageSpacesPage.saveSpace();
  }

  public void addSpaceWithRegistration(String spaceName, String registration) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.setSpaceDescription(spaceName);
    this.spaceTemplate = manageSpacesPage.selectTemplate(SPACE_TEMPLATE_INDEX);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.checkSpaceRegistration(registration);
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.saveSpace();
  }

  public void addUserToSpace(String user) {
    manageSpacesPage.addUserToSpace(user);
  }

  public void checkAvatarSection() {
    manageSpacesPage.checkAvatarSection();
  }

  public void checkCancelButton() {
    manageSpacesPage.checkCancelButton();
  }

  public void checkDescriptionSpaceSection() {
    manageSpacesPage.checkDescriptionSpaceSection();
  }

  public void checkFavIconInSpaceCard() {
    manageSpacesPage.checkFavIconInSpaceCard();
  }

  public void checkFavIconInSpacePopoverFromTopbar() {
    manageSpacesPage.checkFavIconInSpacePopoverFromTopbar();
  }

  public void checkFavIconInThirdNavigationLevel() {
    manageSpacesPage.checkFavIconInThirdNavigationLevel();
  }

  public void checkGeneralSpaceSettings() {
    manageSpacesPage.checkGeneralSpaceSettings();
  }

  public void checkHiddenAndSwitchButtonSection() {
    manageSpacesPage.checkHiddenAndSwitchButtonSection();
  }

  public void checkNameSpaceSection() {
    manageSpacesPage.checkNameSpaceSection();
  }

  public void checkRegistrationSection() {
    manageSpacesPage.checkRegistrationSection();
  }

  public void checkSpaceBookmarkedFromSpaceCard() {
    manageSpacesPage.checkSpaceBookmarkStatusFromSpaceCard(true);
  }

  public void checkSpaceBookmarkedFromTopbarSpacePopover() {
    manageSpacesPage.checkSpaceBookmarkStatusFromTopbarSpacePopover(true);
  }

  public void checkSpaceBookmarkThirdNavigationLevel() {
    manageSpacesPage.checkSpaceBookmarkStatusFromThirdNavigationLevel(true);
  }

  public void checkSpaceTemplateSection() {
    manageSpacesPage.checkSpaceTemplateSection();
  }

  public void checkSpaceUnBookmarkFromSpaceCard() {
    manageSpacesPage.checkSpaceBookmarkStatusFromSpaceCard(false);
  }

  public void checkSpaceUnBookmarkFromThirdNavigationLevel() {
    manageSpacesPage.checkSpaceBookmarkStatusFromThirdNavigationLevel(false);
  }

  public void checkSpaceUnBookmarkFromTopbarSpacePopover() {
    manageSpacesPage.checkSpaceBookmarkStatusFromTopbarSpacePopover(false);
  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayed(String spaceName, String members) {
    manageSpacesPage.checkThatSpaceDetailsInSearchResultsAreDisplayed(spaceName, members);
  }

  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String spaceName, String members) {
    manageSpacesPage.checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(spaceName, members);
  }

  public void checkThatSpaceInSearchResultsIsNotDisplayed(String spaceName) {
    manageSpacesPage.checkThatSpaceInSearchResultsIsNotDisplayed(spaceName);
  }

  public void checkThirtyRandomSpacesArePresent() {
    homePage.goToSpacesPage(true);
    waitForLoading();
    if (!manageSpacesPage.isLoadMoreButtonPresent()) {
      for (int i = 0; i < 30; i++) {
        injectRandomSpace("randomSpaceName");
      }
      homePage.goToSpacesPage(true);
      waitForLoading();
      assertThat(manageSpacesPage.isLoadMoreButtonPresent()).as("Spaces Load More button isn't displayed after adding 30 spaces")
                                                            .isTrue();
    }
  }

  public void clickOnGeneralSpaceSettings() {
    manageSpacesPage.clickOnGeneralSpaceSettings();
  }

  public void clickOnSpaceBookmarkIconFromSpaceCard() {
    manageSpacesPage.clickOnSpaceBookmarkIconFromSpaceCard();
  }

  public void clickOnSpaceBookmarkIconFromThirdNavigationLevel() {
    manageSpacesPage.clickOnSpaceBookmarkIconFromThirdNavigationLevel();
  }

  public void clickOnSpaceBookmarkIconFromTopbarSpacePopover() {
    manageSpacesPage.clickOnSpaceBookmarkIconFromTopbarSpacePopover();
  }

  public void clickSpaceAction(String action) {
    manageSpacesPage.clickSpaceAction(action);
  }

  public void deleteSpace(String spaceName) {
    manageSpacesPage.deleteSpace(spaceName);
  }

  public void deleteSpacesList(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      Utils.refreshPage();
      manageSpacesPage.deleteSpace(spaceName);
    }
  }

  public void goToMembersTab() {
    manageSpacesPage.goToMembersTab();
  }

  public void goToSettingsTab() {
    manageSpacesPage.goToSettingsTab();
  }

  public void goToSpaceHomeViaSpaceAvatar() {
    manageSpacesPage.goToSpaceHomeViaSpaceAvatar();
  }

  public void goToTasksTab() {
    manageSpacesPage.goToTasksTab();
  }

  public void hoverOnSpaceName() {
    manageSpacesPage.hoverOnSpaceName();
  }

  public void searchSpace(String spaceName) {
    manageSpacesPage.insertSpaceNameInSearchField(spaceName);
  }

  public void leaveSpace() {
    manageSpacesPage.leaveSpace();
  }

  public void selectFilter(String filter) {
    manageSpacesPage.selectFilter(filter);
  }

  public void showMoreSpaces() {
    manageSpacesPage.showMoreSpaces();
  }

  public void spaceAvatarIsDisplayed() {
    manageSpacesPage.spaceAvatarIsDisplayed();
  }

  public void spaceNameIsDisplayed(String space) {
    manageSpacesPage.spaceNameIsDisplayed(space);
  }

  public void uploadSpaceBanner(String fileName) {
    manageSpacesPage.uploadSpaceBanner(fileName);
  }
  
  private boolean findSpaceCard(String spaceName) {
    return findSpaceCard(spaceName, false);
  }

  private boolean findSpaceCard(String spaceName, boolean mandatory) {
    manageSpacesPage.insertSpaceNameInSearchField(spaceName);
    return manageSpacesPage.isSpaceCardDisplayed(spaceName, mandatory);
  }

  private void goOrJoinToSpace(String spaceName) {
    if (manageSpacesPage.isSpaceCardJoinButtonDisplayed(spaceName)) {
      manageSpacesPage.joinSpaceFromCard(spaceName);
    }
    manageSpacesPage.goToSpecificSpace(spaceName);
    if (!manageSpacesPage.isSpaceMenuDisplayed()) {
      manageSpacesPage.clickSpaceActionToJoin();
    }
  }

  public void openSpaceInvitationDrawer() {
    manageSpacesPage.openSpaceInvitationDrawer();
  }

  public void openSpaceExternalInvitationDrawer() {
    manageSpacesPage.openSpaceExternalInvitationDrawer();
  }

  public void inviteEmailAsSpaceMember(String email) {
    manageSpacesPage.inviteEmailAsSpaceMember(email);
  }

  public void emailIsListedInInvitationList(String email, String status) {
    manageSpacesPage.emailIsListedInInvitationList(email, status);
  }

  public void openSpacePendingInvitationsDrawer() {
    manageSpacesPage.openSpacePendingInvitationsDrawer();
  }

  public void openSpaceExternalInvitationsTab() {
    manageSpacesPage.openSpaceExternalInvitationsTab();
  }

  public void checkExternalInviteButtonNotDisplayed() {
    manageSpacesPage.checkExternalInviteButtonNotDisplayed();
  }

  public void emailIsNotListedInInvitationList(String email) {
    manageSpacesPage.emailIsNotListedInInvitationList(email);
  }

  public void injectRandomSpace(String spaceNamePrefix) {
    String spaceName = Utils.getRandomString(spaceNamePrefix);
    String addSpaceScript =
                          String.format(CREATE_SPACE_SCRIPT,
                                        "open",
                                        "private",
                                        spaceTemplate == null ? "" : spaceTemplate,
                                        spaceName,
                                        spaceName);
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(),
                                           Duration.ofSeconds(10),
                                           Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeAsyncScript(addSpaceScript)
                                                            .toString()
                                                            .equals("true"));
    String spaceUrl = homePage.getCurrentUrl().split("/portal")[0] + "/portal/g/:spaces:" + spaceName;
    TestInitHook.spaceWithPrefixCreated(spaceNamePrefix, spaceName, spaceUrl);
  }

  public void configureSpaceCreationPermission() {
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(),
                                           Duration.ofSeconds(10),
                                           Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeAsyncScript(CONFIGURE_SPACE_CREATION_PERMISSION_SCRIPT)
                                                            .toString()
                                                            .equals("true"));
  }

}
