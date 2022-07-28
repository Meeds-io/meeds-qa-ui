package io.meeds.qa.ui.steps;

import java.util.List;

import io.meeds.qa.ui.pages.page.factory.space.ManageSpacesPage;
import net.serenitybdd.core.Serenity;

public class ManageSpaceSteps {
  private ManageSpacesPage manageSpacesPage;

  public void addSimpleSpace(String spaceName) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.clickAddSpaceButton();
  }

  public void addSpaceWithRegistration(String spaceName, String registration) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.checkSpaceRegistration(registration);
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.clickAddSpaceButton();
  }

  public void addSpaceWithRegistrationWithInvitedUser(String spaceName, String registration, String user) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.checkSpaceRegistration(registration);
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.inviteUserToSpace(user);
    manageSpacesPage.clickAddSpaceButton();
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

  public void goToSpeceficSpace(String space) {
    manageSpacesPage.insertSpaceNameInSearchField(space);
    manageSpacesPage.goToSpecificSpace(space);
  }

  public void addSpaceWithInviteUser(String spaceName, String user) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.inviteUserToSpace(user);
    manageSpacesPage.clickAddSpaceButton();
  }

  public void spaceNameIsDisplayed(String space) {
    manageSpacesPage.spaceNameIsDisplayed(space);
  }

  public void clickSpaceAction(String action) {
    manageSpacesPage.clickSpaceAction(action);
  }

  public void deleteSpace(String spaceName) {
    manageSpacesPage.deleteSpace(spaceName);
  }

  public void deleteSpacesList(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
      manageSpacesPage.deleteRandomSpace(spaceName);
    }
  }

  public void checkThatSpaceTabsAreDisplayedInOrder(String space) {
    manageSpacesPage.checkThatSpaceTabsAreDisplayedInOrder(space);
  }

  public void goToSpaceToAcceptInvitation(String space) {
    manageSpacesPage.insertSpaceNameInSearchField(space);
    manageSpacesPage.goToSpaceToAcceptInvitation(space);
  }

  public void checkThatSpaceTopBarElementsAreDisplayed() {
    manageSpacesPage.checkThatSpaceTopBarElementsAreDisplayed();
  }

  public void isSpaceBannerUpdated() {
    manageSpacesPage.isSpaceBannerUpdated();
  }

  public void uploadSpaceBanner(String fileName) {
    manageSpacesPage.uploadSpaceBanner(fileName);
  }

  public void searchSpace(String spaceName) {
    manageSpacesPage.insertSpaceNameInSearchField(spaceName);
  }

  public void goToSpaceHomeViaSpaceAvatar() {
    manageSpacesPage.goToSpaceHomeViaSpaceAvatar();
  }

  public void spaceAvatarIsDisplayed() {
    manageSpacesPage.spaceAvatarIsDisplayed();
  }

  public void selectFilter(String filter) {
    manageSpacesPage.selectFilter(filter);
  }

  public void checkDisplayOfTwentySpaces() {
    manageSpacesPage.checkDisplayOfTwentySpaces();
  }

  public void showMoreSpaces() {
    manageSpacesPage.showMoreSpaces();
  }

  public void checkDisplayOfOtherSpaces() {
    manageSpacesPage.checkDisplayOfOtherSpaces();
  }

  public void clickOnSpaceSettingsTab() {
    manageSpacesPage.clickOnSpaceSettingsTab();
  }

  public void checkGeneralSpaceSettings() {
    manageSpacesPage.checkGeneralSpaceSettings();
  }

  public void checkApplicationsSpaceSettings() {
    manageSpacesPage.checkApplicationsSpaceSettings();
  }

  public void clickOnGeneralSpaceSettings() {
    manageSpacesPage.clickOnGeneralSpaceSettings();
  }

  public void checkAvatarSection() {
    manageSpacesPage.checkAvatarSection();
  }

  public void checkNameSpaceSection() {
    manageSpacesPage.checkNameSpaceSection();
  }

  public void checkDescriptionSpaceSection() {
    manageSpacesPage.checkDescriptionSpaceSection();
  }

  public void checkSpaceTemplateSection() {
    manageSpacesPage.checkSpaceTemplateSection();
  }

  public void checkHiddenAndSwitchButtonSection() {
    manageSpacesPage.checkHiddenAndSwitchButtonSection();
  }

  public void checkRegistrationSection() {
    manageSpacesPage.checkRegistrationSection();
  }

  public void checkCancelButton() {
    manageSpacesPage.checkCancelButton();
  }

  public void checkUpdateButton() {
    manageSpacesPage.checkUpdateButton();
  }

  public void addSpaceCommunity(String spaceName) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.selectCommunityTemplate();
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.clickAddSpaceButton();
  }

  public void clickOnArrowIconAppSpaceSettings() {
    manageSpacesPage.clickOnArrowIconAppSpaceSettings();
  }

  public void spaceAppSettingsIsOpened() {
    manageSpacesPage.spaceAppSettingsIsOpened();
  }

  public void appCardIsDisplayed() {
    manageSpacesPage.appCardIsDisplayed();
  }

  public void plusButtonIsDisplayed() {
    manageSpacesPage.plusButtonIsDisplayed();
  }

  public void clickOn3dotsAppCard() {
    manageSpacesPage.clickOn3dotsAppCard();
  }

  public void removeAppButtonIsDisplayed() {
    manageSpacesPage.removeAppButtonIsDisplayed();
  }

  public void moveBeforeAppButtonIsDisplayed() {
    manageSpacesPage.moveBeforeAppButtonIsDisplayed();
  }

  public void moveAfterAppButtonIsDisplayed() {
    manageSpacesPage.moveAfterAppButtonIsDisplayed();
  }

  public void clickOnPlusButton() {
    manageSpacesPage.clickOnPlusButton();
  }

  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    manageSpacesPage.checkSpaceAppInstallerDrawerIsDisplayed();
  }

  public void checkApplicationsAreDisplayed() {
    manageSpacesPage.checkApplicationsAreDisplayed();
  }

  public void clickToAddApp(String application) {
    manageSpacesPage.clickToAddApp(application);
  }

  public void checkThatAppIsDisplayed(String application) {
    manageSpacesPage.checkThatAppIsAdded(application);
  }

  public void goToMembersTab() {
    manageSpacesPage.goToMembersTab();
  }

  public void goToTasksTab() {
    manageSpacesPage.goToTasksTab();
  }

  public void goToSettingsTab() {
    manageSpacesPage.goToSettingsTab();
  }

  public void addUserToSpace(String user) {
    manageSpacesPage.addUserToSpace(user);
  }

  public void addCommunitySpaceWithFirstUser(String randomSpaceName, String firstUserName) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(randomSpaceName);
    manageSpacesPage.selectCommunityTemplate();
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.inviteUserToSpace(firstUserName);
    manageSpacesPage.clickAddSpaceButton();

  }
}
