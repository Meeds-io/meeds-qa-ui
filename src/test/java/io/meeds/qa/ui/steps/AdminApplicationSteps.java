package io.meeds.qa.ui.steps;

import java.util.Map;

import io.meeds.qa.ui.pages.page.factory.administration.ApplicationPage;

public class AdminApplicationSteps {
  private ApplicationPage applicationPage;

  public void openEditDrawerApp(String appName) {
    applicationPage.clickEditApp(appName);
  }

  public void goToEditTheApplication(String app) {
    applicationPage.goToEditTheApplication(app);
  }

  public void clickSaveApplicationDrawer() {
    applicationPage.clickSaveAddApplication();
  }

  public void enterApplicationValues(Map<String, String> applicationData) {
    applicationPage.clickAddApplicationButton();
    for (String fieldsName : applicationData.keySet()) {
      applicationPage.enterValueToField(fieldsName, applicationData.get(fieldsName));
    }
    applicationPage.clickSaveAddApplication();
  }

  public void enterApplicationTitleUrlDescriptionWithImage(String image, Map<String, String> applicationData) {
    applicationPage.clickAddApplicationButton();
    for (String fieldsName : applicationData.keySet()) {
      applicationPage.enterDataValueToField(fieldsName, applicationData.get(fieldsName));
    }

    applicationPage.addImageToApplication(image);
    applicationPage.clickSaveAddApplication();
  }

  public void removeFileFromApplicationDrawer() {
    applicationPage.removeFileFromApplicationDrawer();
  }

  public void checkThatApplicationImageIsDisplayedInDrawer(String image) {
    applicationPage.checkThatApplicationImageIsDisplayedInDrawer(image);
  }

  public void enterRandomApplicationTitleAndUrl(String title, String url) {
    applicationPage.clickAddApplicationButton();
    applicationPage.enterRandomAppDataTitleUrl(title, url);
    applicationPage.clickSaveAddApplication();
  }

  public void editRandomApplicationTitleUrlDescription(String appName, String title, String url, String desc) {
    applicationPage.goToEditTheApplication(appName);
    applicationPage.enterRandomAppDataTitleUrlDescription(title, url, desc);
    applicationPage.clickSaveAddApplication();
  }

  public void enterRandomApplicationTitleUrlDescriptionImage(String title, String url, String desc, String image) {
    applicationPage.clickAddApplicationButton();
    applicationPage.enterRandomAppDataTitleUrlDescription(title, url, desc);
    applicationPage.addImageToApplication(image);
    applicationPage.clickSaveAddApplication();
  }

  public void enterRandomApplicationTitleUrlDescription(String title, String url, String desc) {
    applicationPage.clickAddApplicationButton();
    applicationPage.enterRandomAppDataTitleUrlDescription(title, url, desc);
    applicationPage.clickSaveAddApplication();
  }

  public void checkThatApplicationImageIsNotDisplayedInDrawer(String image) {
    applicationPage.checkThatApplicationImageIsNotDisplayedInDrawer(image);
  }

  public void enterApplicationTitleUrlDescription(Map<String, String> applicationData) {
    applicationPage.clickAddApplicationButton();
    for (String fieldsName : applicationData.keySet()) {
      applicationPage.enterDataValueToField(fieldsName, applicationData.get(fieldsName));
    }
    applicationPage.clickSaveAddApplication();
  }

  public void editApplicationTitleUrlDescription(String appName, Map<String, String> applicationData) {
    applicationPage.goToEditTheApplication(appName);
    for (String fieldsName : applicationData.keySet()) {
      applicationPage.enterDataValueToField(fieldsName, applicationData.get(fieldsName));
    }
    applicationPage.clickSaveAddApplication();
  }

  public void appTitleInApplicationsTableIsDisplayed(String appTitle) {
    applicationPage.appTitleInApplicationsTableIsDisplayed(appTitle);
  }

  public void checkThatApplicationImageIsNotDisplayedInApplicationsTable(String appTitle) {
    applicationPage.checkThatApplicationImageIsNotDisplayedInApplicationsTable(appTitle);
  }

  public void appUrlInApplicationsTableIsDisplayed(String appUrl) {
    applicationPage.appUrlInApplicationsTableIsDisplayed(appUrl);
  }

  public void appPermissionInApplicationsTableIsDisplayed(String appTitle, String permission) {
    applicationPage.appPermissionInApplicationsTableIsDisplayed(appTitle, permission);
  }

  public void appDescriptionInApplicationsTableIsDisplayed(String appDescription) {
    applicationPage.appDescriptionInApplicationsTableIsDisplayed(appDescription);
  }

  public void applicationDrawerTitleIsDisplayed(String title) {

    applicationPage.applicationDrawerTitleIsDisplayed(title);
  }

  public void enableDisableMandatoryApplication(String appTitle) throws InterruptedException {

    applicationPage.enableDisableMandatoryApplication(appTitle);
  }

  public void enableDisableActiveApplication(String appTitle) {

    applicationPage.enableDisableActiveApplication(appTitle);
  }

  public void applicationDrawerUrlIsDisplayed(String url) {
    applicationPage.applicationDrawerUrlIsDisplayed(url);
  }

  public void applicationDrawerImageIsDisplayed(String image) {
    applicationPage.applicationDrawerImageIsDisplayed(image);
  }

  public void applicationDrawerEnabledButtonsAreIsDisplayed() {
    applicationPage.applicationDrawerEnabledButtonsAreIsDisplayed();
  }

  public void applicationDrawerPermissionsIsDisplayed(String firstPermission, String secondPermission) {
    applicationPage.applicationDrawerPermissionsIsDisplayed(firstPermission, secondPermission);

  }

  public void searchApp(String appTitle) {
    applicationPage.searchApp(appTitle);
  }

  public boolean isAppExists(String appTitle) {
    return applicationPage.isAppExists(appTitle);
  }

  public void clickActiveApp(String appName) {
    applicationPage.clickActiveApp(appName);
  }

  public void deleteApp(String appName, boolean confirm) {
    applicationPage.deleteApp(appName, confirm);
  }

  public void clickCancelDelete() {
    applicationPage.clickCancelDelete();
  }

  public void clickCloseDeletePopup() {
    applicationPage.clickCloseDeletePopup();
  }

  public boolean isPopupConfirmDeleteDisplayed() {
    return applicationPage.isPopupConfirmDeleteDisplayed();
  }

  public boolean isPopupConfirmDeleteNotDisplayed() {
    return applicationPage.isPopupConfirmDeleteNotDisplayed();
  }
}
