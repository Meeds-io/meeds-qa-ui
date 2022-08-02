package io.meeds.qa.ui.steps;

import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_ALL_APPLICATIONS_PAGE;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_PERK_STORE;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_SEE_ALL_APPLICATIONS;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_TASKS;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_WALLET;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_APPLICATIONS_TOPBAR;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_NOTES_APPLICATION_PAGE;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_PERK_STORE_APPLICATION_PAGE;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_SEND_FEEDBACK_APPLICATION_PAGE;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.ELEMENT_TASKS_APPLICATION_PAGE;
import static io.meeds.qa.ui.pages.page.factory.application.ApplicationPage.elementChallengeApplicationPage;

import java.util.ArrayList;
import java.util.List;

import io.meeds.qa.ui.pages.page.factory.application.ApplicationPage;
import net.serenitybdd.core.Serenity;

public class ApplicationSteps {

  private ApplicationPage applicationPage;

  public List<String> isAppDisplayedInFavoriteList(List<String> listOfApp) {
    List<String> missingValues = new ArrayList<>();
    for (String appName : listOfApp) {
      if (!applicationPage.isAppDisplayedInFavoriteList(appName))
        missingValues.add(appName);
    }
    return missingValues;
  }

  public List<String> isAppNotDisplayedInFavoriteList(List<String> listOfApp) {
    List<String> missingValues = new ArrayList<>();
    for (String appName : listOfApp) {
      if (!applicationPage.isAppNotDisplayedInFavoriteList(appName))
        missingValues.add(appName);
    }
    return missingValues;
  }

  public boolean isApplicationVisible(String applicationName) {
    return applicationPage.isApplicationVisible(applicationName);
  }

  public boolean isWalletPageOpened() {
    return applicationPage.isWalletPageOpened();
  }

  public void clickOnTheAppLauncherIcon() {
    ELEMENT_APPLICATIONS_TOPBAR.waitUntilVisible();
    ELEMENT_APPLICATIONS_TOPBAR.clickOnElement();
  }

  public boolean isNotesPageOpened() {

    return ELEMENT_NOTES_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public void settingsPageIsOpened() {
    applicationPage.settingsPageIsOpened();
  }

  public void goToTasksAppCenterApplication() {

    // Click on App Center Tasks Application Button
    ELEMENT_APPCENTER_TASKS.clickOnElement();

  }

  public boolean isTasksPageOpened() {
    // Tasks Application Page is displayed
    return ELEMENT_TASKS_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public void goToWalletAppCenterApplication() {
    // Click on App Center Wallet Application Button
    ELEMENT_APPCENTER_WALLET.clickOnElement();
  }

  public void goToPerkStoreAppCenterApplication() {
    // Click on App Center Perk Store Application Button
    ELEMENT_APPCENTER_PERK_STORE.clickOnElement();
  }

  public boolean isPerkStorePageOpened() {
    // Perk Store Application Page is displayed
    return ELEMENT_PERK_STORE_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public boolean isSendFeedbackPageOpened() {
    // Send Feedback Application Page is displayed
    return ELEMENT_SEND_FEEDBACK_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public void seeAllApplications() {
    // Click on App Center Application Button
    ELEMENT_APPLICATIONS_TOPBAR.waitUntilClickable();
    ELEMENT_APPLICATIONS_TOPBAR.clickOnElement();

    ELEMENT_APPCENTER_SEE_ALL_APPLICATIONS.waitUntilVisible();
    ELEMENT_APPCENTER_SEE_ALL_APPLICATIONS.clickOnElement();
  }

  public void starButtonIsNotSelected(String appTitle) {
    applicationPage.starButtonIsNotSelected(appTitle);
  }

  public void starButtonIsSelected(String appTitle) {
    applicationPage.starButtonIsSelected(appTitle);
  }

  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {

    applicationPage.checkThatAddApplicationBtnToFavoritesIsDisplayed(app);
  }

  public boolean isAllApplicationsPageDisplayed() {

    // All Applications Page is displayed
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    return ELEMENT_APPCENTER_ALL_APPLICATIONS_PAGE.isVisibleAfterWaiting();
  }

  public void addRemoveApplicationToFavorites(String app) {
    applicationPage.addRemoveApplicationToFavorites(app);
  }

  public void closeAppCenterDrawer() {
    applicationPage.ELEMENT_CLOSE_APPCENTER_DRAWER.clickOnElement();
  }

  public void checkThatAppcenterApplicationIsDisplayed(String app) {

    applicationPage.checkThatAppcenterApplicationIsDisplayed(app);
  }

  public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {

    applicationPage.checkThatApplicationIsDisplayedInFavoriteApps(app);
  }

  public void maxFavoriteAppsIsDisplayed() {

    applicationPage.maxFavoriteAppsIsDisplayed();
  }

  public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {

    applicationPage.checkThatApplicationIsNotDisplayedInFavoriteApps(app);
  }

  public void checkThatAppcenterApplicationIsNotDisplayed(String app) {

    applicationPage.checkThatAppcenterApplicationIsNotDisplayed(app);
  }

  public void goToTheAppcenterApplicationPage(String app) {

    applicationPage.goToTheAppcenterApplicationPage(app);
  }

  public void checkThatOpenApplicationButtonIsDisplayed(String app) {
    applicationPage.checkThatOpenApplicationButtonIsDisplayed(app);
  }

  public void clickOnOpenApplicationButton(String app) {
    applicationPage.clickOnOpenApplicationButton(app);
  }

  public void goToApplication(String applicationName) {
    applicationPage.goToApplication(applicationName);
  }

  public void goToChallengeApplication() {
    applicationPage.goToChallengeApplication();
  }

  public boolean isChallengePageOpened() {
    // Challenges Application Page is displayed
    return elementChallengeApplicationPage.isVisibleAfterWaiting();
  }
}
