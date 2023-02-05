package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.application.ApplicationPage;

public class ApplicationSteps {

  private ApplicationPage applicationPage;

  public void addRemoveApplicationToFavorites(String app) {
    applicationPage.addRemoveApplicationToFavorites(app);
  }

  public void bookmarkApplication(String appTitle) {
    applicationPage.bookmarkApplication(appTitle);
  }

  public void checkApplicationIsNotVisible(String applicationName) {
    applicationPage.checkApplicationIsNotVisible(applicationName);
  }

  public void checkApplicationIsVisible(String applicationName) {
    applicationPage.checkApplicationIsVisible(applicationName);
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

  public void goToApplication(String applicationName) {
    applicationPage.goToApplication(applicationName);
  }

  public void maxFavoriteAppsIsDisplayed() {
    applicationPage.maxFavoriteAppsIsDisplayed();
  }

  public void seeAllApplications() {
    applicationPage.seeAllApplications();
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
