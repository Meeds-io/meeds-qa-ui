package io.meeds.qa.ui.steps;

import java.util.ArrayList;
import java.util.List;

import io.meeds.qa.ui.pages.page.factory.application.ApplicationPage;

import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.*;

public class ApplicationSteps {

  private ApplicationPage applicationPage;

  public void addRemoveApplicationToFavorites(String app) {
    applicationPage.addRemoveApplicationToFavorites(app);
  }

  public void bookmarkApplication(String appTitle) {
    applicationPage.bookmarkApplication(appTitle);
  }

  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {

    applicationPage.checkThatAddApplicationBtnToFavoritesIsDisplayed(app);
  }

  public void checkThatAppcenterApplicationIsDisplayed(String app) {

    applicationPage.checkThatAppcenterApplicationIsDisplayed(app);
  }

  public void checkThatAppcenterApplicationIsNotDisplayed(String app) {

    applicationPage.checkThatAppcenterApplicationIsNotDisplayed(app);
  }

  public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {

    applicationPage.checkThatApplicationIsDisplayedInFavoriteApps(app);
  }

  public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {

    applicationPage.checkThatApplicationIsNotDisplayedInFavoriteApps(app);
  }

  public void checkThatOpenApplicationButtonIsDisplayed(String app) {
    applicationPage.checkThatOpenApplicationButtonIsDisplayed(app);
  }

  public void clickOnOpenApplicationButton(String app) {
    applicationPage.clickOnOpenApplicationButton(app);
  }

  public void clickOnTheAppLauncherIcon() {
    applicationPage.clickOnTheAppLauncherIcon();
  }

  public void closeAppCenterDrawer() {
    applicationPage.closeDrawer();
  }

  public void goToApplication(String applicationName) {
    applicationPage.goToApplication(applicationName);
  }

  public void goToContributionsAppCenterApplication() {
    // Click on App Center Contributions Application Button
   contributionsApplication.clickOnElement();
  }

  public void goToPerkStoreAppCenterApplication() {
    // Click on App Center Perk Store Application Button
    ELEMENT_APPCENTER_PERK_STORE.clickOnElement();
  }

  public void goToTasksAppCenterApplication() {
    applicationPage.goToTasksAppCenterApplication();
  }

  public void goToTheAppcenterApplicationPage(String app) {

    applicationPage.goToTheAppcenterApplicationPage(app);
  }

  public void goToWalletAppCenterApplication() {
    // Click on App Center Wallet Application Button
    ELEMENT_APPCENTER_WALLET.clickOnElement();
  }

  public boolean isAllApplicationsPageDisplayed() {

    // All Applications Page is displayed
    applicationPage.refreshPage();
    return ELEMENT_APPCENTER_ALL_APPLICATIONS_PAGE.isVisibleAfterWaiting();
  }

  public List<String> isAppDisplayedInFavoriteList(List<String> listOfApp) {
    List<String> missingValues = new ArrayList<>();
    for (String appName : listOfApp) {
      if (!applicationPage.isAppDisplayedInFavoriteList(appName))
        missingValues.add(appName);
    }
    return missingValues;
  }

  public void checkApplicationIsVisible(String applicationName) {
    applicationPage.checkApplicationIsVisible(applicationName);
  }

  public void checkApplicationIsNotVisible(String applicationName) {
    applicationPage.checkApplicationIsNotVisible(applicationName);
  }

  public List<String> isAppNotDisplayedInFavoriteList(List<String> listOfApp) {
    List<String> missingValues = new ArrayList<>();
    for (String appName : listOfApp) {
      if (!applicationPage.isAppNotDisplayedInFavoriteList(appName))
        missingValues.add(appName);
    }
    return missingValues;
  }

  public boolean isChallengePageOpened() {
    // Challenges Application Page is displayed
    return elementChallengeApplicationPage.isVisibleAfterWaiting();
  }

  public boolean isChallengesPageOpened() {
    return applicationPage.isChallengesPageOpened();
  }

  public boolean isNotesPageOpened() {
    return ELEMENT_NOTES_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public boolean isPerkStorePageOpened() {
    // Perk Store Application Page is displayed
    return ELEMENT_PERK_STORE_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public boolean isSendFeedbackPageOpened() {
    // Send Feedback Application Page is displayed
    return ELEMENT_SEND_FEEDBACK_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public boolean isTasksPageOpened() {
    // Tasks Application Page is displayed
    return ELEMENT_TASKS_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public boolean isWalletPageOpened() {
    return applicationPage.isWalletPageOpened();
  }

  public void maxFavoriteAppsIsDisplayed() {

    applicationPage.maxFavoriteAppsIsDisplayed();
  }

  public void seeAllApplications() {
    // Click on App Center Application Button
    ELEMENT_APPLICATIONS_TOPBAR.waitUntilClickable();
    ELEMENT_APPLICATIONS_TOPBAR.clickOnElement();

    ELEMENT_APPCENTER_SEE_ALL_APPLICATIONS.waitUntilVisible();
    ELEMENT_APPCENTER_SEE_ALL_APPLICATIONS.clickOnElement();
  }

  public void settingsPageIsOpened() {
    applicationPage.settingsPageIsOpened();
  }

  public void starButtonIsDisabled(String appTitle) {
    applicationPage.starButtonIsDisabled(appTitle);
  }

  public void starButtonIsNotSelected(String appTitle) {
    applicationPage.starButtonIsNotSelected(appTitle);
  }

  public void starButtonIsSelected(String appTitle) {
    applicationPage.starButtonIsSelected(appTitle);
  }

  public void unbookmarkApplication(String appTitle) {
    applicationPage.unbookmarkApplication(appTitle);
  }


}
