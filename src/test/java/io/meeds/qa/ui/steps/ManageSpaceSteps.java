package io.meeds.qa.ui.steps;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.hook.TestHooks;
import io.meeds.qa.ui.pages.page.factory.HomePage;
import io.meeds.qa.ui.pages.page.factory.space.ManageSpacesPage;
import io.meeds.qa.ui.utils.Utils;

public class ManageSpaceSteps {

  private static final String SPACE_TEMPLATE = System.getProperty("io.meeds.space.template");

  private HomePage            homePage;

  private ManageSpacesPage    manageSpacesPage;

  public void addOrGoToSpace(String spaceNamePrefix) {
    String spaceName = sessionVariableCalled(spaceNamePrefix);
    String spaceUrl = sessionVariableCalled(spaceNamePrefix + "-url");
    if (StringUtils.isNotBlank(spaceUrl)) {
      homePage.openUrl(spaceUrl);
      homePage.verifyPageLoaded();
      if (StringUtils.equals(homePage.getCurrentUrl(), spaceUrl)) {
        return;
      } else if (!manageSpacesPage.isSpaceMenuDisplayed()) {
        boolean joined = manageSpacesPage.clickSpaceActionToJoin();
        if (joined) {
          homePage.verifyPageLoaded();
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
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.inviteUserToSpace(user);
    manageSpacesPage.clickAddSpaceButton();
  }

  public void addSpaceWithRegistration(String spaceName, String registration) {
    manageSpacesPage.openSpaceFormDrawer();
    manageSpacesPage.setSpaceName(spaceName);
    manageSpacesPage.selectTemplate(SPACE_TEMPLATE);
    manageSpacesPage.clickFirstProcessButton();
    manageSpacesPage.checkSpaceRegistration(registration);
    manageSpacesPage.clickSecondProcessButton();
    manageSpacesPage.clickAddSpaceButton();
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

  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    manageSpacesPage.checkSpaceAppInstallerDrawerIsDisplayed();
  }

  public void checkSpaceTemplateSection() {
    manageSpacesPage.checkSpaceTemplateSection();
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

  public void checkThatSpaceTabsAreDisplayedInOrder(String space) {
    manageSpacesPage.checkThatSpaceTabsAreDisplayedInOrder(space);
  }

  public void checkThatSpaceTopBarElementsAreDisplayed() {
    manageSpacesPage.checkThatSpaceTopBarElementsAreDisplayed();
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

  public void clickOnThreeDotsAppCard(String appName) {
    manageSpacesPage.clickOnThreeDotsAppCard(appName);
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

  public void clickSpaceAction(String action) {
    manageSpacesPage.clickSpaceAction(action);
  }

  public void clickToAddApp(String application) {
    manageSpacesPage.clickToAddApp(application);
  }

  public void deleteSpace(String spaceName) {
    manageSpacesPage.deleteSpace(spaceName);
  }

  public void deleteSpacesList(List<String> listOfSpaces) {
    for (String spaceName : listOfSpaces) {
      manageSpacesPage.refreshPage();
      manageSpacesPage.deleteSpace(spaceName);
    }
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

  public void goToMembersTab() {
    manageSpacesPage.goToMembersTab();
  }

  public void goToSettingsTab() {
    manageSpacesPage.goToSettingsTab();
  }

  public void goToSpaceHomeViaSpaceAvatar() {
    manageSpacesPage.goToSpaceHomeViaSpaceAvatar();
  }

  public void goToSpaceToAcceptInvitation(String space) {
    manageSpacesPage.insertSpaceNameInSearchField(space);
    manageSpacesPage.goToSpaceToAcceptInvitation(space);
  }

  public void goToTasksTab() {
    manageSpacesPage.goToTasksTab();
  }

  public void isSpaceBannerUpdated() {
    manageSpacesPage.isSpaceBannerUpdated();
  }

  public void plusButtonIsDisplayed() {
    manageSpacesPage.plusButtonIsDisplayed();
  }

  public void checkOptionFromApplicationMenuIsDisplayed(String appName, String option) {
    manageSpacesPage.checkOptionFromApplicationMenuIsDisplayed(appName, option);
  }

  public void searchSpace(String spaceName) {
    manageSpacesPage.insertSpaceNameInSearchField(spaceName);
  }

  public void searchRandomSpace(String space) {
    manageSpacesPage.insertSpaceNameInSearchField(space);
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


  public void confirmRemoveApplication(){
    manageSpacesPage.confirmRemoveApplication();
  }

  public void clickOptionApplicationCard(String appName, String option) {
    manageSpacesPage.clickOptionApplicationCard(appName, option);
  }

}
