package steps;

import static org.aspectj.bridge.MessageUtil.info;
import static pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_ALL_APPLICATIONS_PAGE;
import static pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_PERK_STORE;
import static pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_SEE_ALL_APPLICATIONS;
import static pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_TASKS;
import static pages.page.factory.application.ApplicationPage.ELEMENT_APPCENTER_WALLET;
import static pages.page.factory.application.ApplicationPage.ELEMENT_APPLICATIONS_TOPBAR;
import static pages.page.factory.application.ApplicationPage.ELEMENT_DRIVES_APPLICATION_PAGE;
import static pages.page.factory.application.ApplicationPage.ELEMENT_NOTES_APPLICATION_PAGE;
import static pages.page.factory.application.ApplicationPage.ELEMENT_PERK_STORE_APPLICATION_PAGE;
import static pages.page.factory.application.ApplicationPage.ELEMENT_SEND_FEEDBACK_APPLICATION_PAGE;
import static pages.page.factory.application.ApplicationPage.ELEMENT_TASKS_APPLICATION_PAGE;
import static pages.page.factory.application.ApplicationPage.elementChallengeApplicationPage;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;
import pages.page.factory.application.ApplicationPage;

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

  public boolean isDrivesPageOpened() {

    return ELEMENT_DRIVES_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public boolean isNotesPageOpened() {

    return ELEMENT_NOTES_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public void settingsPageIsOpened() {
    applicationPage.settingsPageIsOpened();
  }

  public void goToTasksAppCenterApplication() {

    info("Click on App Center Tasks Application Button");
    ELEMENT_APPCENTER_TASKS.clickOnElement();

  }

  public boolean isTasksPageOpened() {
    info("Tasks Application Page is displayed");
    return ELEMENT_TASKS_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public void goToWalletAppCenterApplication() {
    info("Click on App Center Wallet Application Button");
    ELEMENT_APPCENTER_WALLET.clickOnElement();
  }

  public void goToPerkStoreAppCenterApplication() {
    info("Click on App Center Perk Store Application Button");
    ELEMENT_APPCENTER_PERK_STORE.clickOnElement();
  }

  public boolean isPerkStorePageOpened() {
    info("Perk Store Application Page is displayed");
    return ELEMENT_PERK_STORE_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public boolean isSendFeedbackPageOpened() {
    info("Send Feedback Application Page is displayed");
    return ELEMENT_SEND_FEEDBACK_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public void seeAllApplications() {
    info("Click on App Center Application Button");
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

    info("All Applications Page is displayed");
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
    info("Challenges Application Page is displayed");
    return elementChallengeApplicationPage.isVisibleAfterWaiting();
  }
}
