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

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.hook.TestHooks;
import io.meeds.qa.ui.pages.HomePage;
import io.meeds.qa.ui.pages.ManageSpacesPage;
import io.meeds.qa.ui.utils.Utils;

public class ManageSpaceSteps {

  private static final int SPACE_TEMPLATE_INDEX = Integer.parseInt(System.getProperty("io.meeds.space.template.index", "0"));

  private HomePage         homePage;

  private ManageSpacesPage manageSpacesPage;

  public void joinOrGoToSpace(String spaceNamePrefix) {
    String spaceName = sessionVariableCalled(spaceNamePrefix);
    if (!manageSpacesPage.getCurrentUrl().contains("/spaces")) {
      homePage.goToSpacesPage();
    }
    if (findSpaceCard(spaceName)) {
      goOrJoinToSpace(spaceName);
    } else {
      throw new IllegalStateException("Can't find previously created space with name " + spaceName);
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
    if (!manageSpacesPage.getCurrentUrl().contains("/spaces")) {
      homePage.goToSpacesPage();
    }
    if (StringUtils.isBlank(spaceName)) {
      spaceName = Utils.getRandomString(spaceNamePrefix);
      if (findSpaceCard(spaceName)) {
        goOrJoinToSpace(spaceName);
      } else {
        addSpaceWithRegistration(spaceName, "Open");
      }
      TestHooks.spaceWithPrefixCreated(spaceNamePrefix, spaceName, homePage.getCurrentUrl());
    } else if (findSpaceCard(spaceName)) {
      goOrJoinToSpace(spaceName);
    } else {
      throw new IllegalStateException("Can't find previously created space with name " + spaceName);
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

  public void addSpaceWithRegistration(String spaceName, String registration) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.setSpaceDescription(spaceName);
    manageSpacesPage.selectTemplate(SPACE_TEMPLATE_INDEX);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.checkSpaceRegistration(registration);
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.saveSpace();

    String spaceNamePrefix = "randomSpaceName";
    setSessionVariable(spaceNamePrefix).to(spaceName);
    setSessionVariable(spaceNamePrefix + "-url").to(manageSpacesPage.getCurrentUrl());
  }

  public void addUserToSpace(String user) {
    manageSpacesPage.addUserToSpace(user);
  }

  public void appCardIsDisplayed() {
    manageSpacesPage.appCardIsDisplayed();
  }

  public void checkApplicationsAreDisplayed() {
    manageSpacesPage.checkApplicationsAreDisplayed();
  }

  public void checkApplicationsSpaceSettings() {
    manageSpacesPage.checkApplicationsSpaceSettings();
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

  public void checkDisplayOfOtherSpaces() {
    manageSpacesPage.checkDisplayOfOtherSpaces();
  }

  public void checkDisplayOfTwentySpaces() {
    manageSpacesPage.checkDisplayOfTwentySpaces();
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

  public void checkOptionFromApplicationMenuIsDisplayed(String appName, String option) {
    manageSpacesPage.checkOptionFromApplicationMenuIsDisplayed(appName, option);
  }

  public void checkRegistrationSection() {
    manageSpacesPage.checkRegistrationSection();
  }

  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    manageSpacesPage.checkSpaceAppInstallerDrawerIsDisplayed();
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

  public void checkThatAppIsDisplayed(String application) {
    manageSpacesPage.checkThatAppIsAdded(application);
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
    homePage.goToSpacesPage();
    if (!manageSpacesPage.isLoadMoreButtonDisplayed()) {
      for (int i = 0; i < 30; i++) {
        String randomSpaceName = "randomSpaceName" + getRandomNumber();
        addSpaceWithRegistration(randomSpaceName, "Open");
        homePage.goToSpacesPage();
      }
    }
  }

  public void checkUpdateButton() {
    manageSpacesPage.checkUpdateButton();
  }

  public void clickOnArrowIconAppSpaceSettings() {
    manageSpacesPage.clickOnArrowIconAppSpaceSettings();
  }

  public void clickOnGeneralSpaceSettings() {
    manageSpacesPage.clickOnGeneralSpaceSettings();
  }

  public void clickOnPlusButton() {
    manageSpacesPage.clickOnPlusButton();
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

  public void clickOnThreeDotsAppCard(String appName) {
    manageSpacesPage.clickOnThreeDotsAppCard(appName);
  }

  public void clickOptionApplicationCard(String appName, String option) {
    manageSpacesPage.clickOptionApplicationCard(appName, option);
  }

  public void clickSpaceAction(String action) {
    manageSpacesPage.clickSpaceAction(action);
  }

  public void clickToAddApp(String application) {
    manageSpacesPage.clickToAddApp(application);
  }

  public void confirmRemoveApplication() {
    manageSpacesPage.confirmRemoveApplication();
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

  public void isSpaceBannerUpdated() {
    manageSpacesPage.isSpaceBannerUpdated();
  }

  public void plusButtonIsDisplayed() {
    manageSpacesPage.plusButtonIsDisplayed();
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

  public void spaceAppSettingsIsOpened() {
    manageSpacesPage.spaceAppSettingsIsOpened();
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
    manageSpacesPage.insertSpaceNameInSearchField(spaceName);
    return manageSpacesPage.isSpaceCardDisplayed(spaceName);
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

  public String moveApplicationAfter(int appPosition) {
    return manageSpacesPage.moveApplicationAfter(appPosition);
  }

  public String moveApplicationBefore(int appPosition) {
    return manageSpacesPage.moveApplicationBefore(appPosition);
  }

  public void moveApplicationBefore(String appName) {
    manageSpacesPage.moveApplicationBefore(appName);
  }
}
