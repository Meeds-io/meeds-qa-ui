package io.meeds.qa.ui.steps;

import java.util.Map;
import java.util.Map.Entry;

import io.meeds.qa.ui.pages.page.factory.administration.ApplicationPage;

public class AdminApplicationSteps {
  private ApplicationPage applicationPage;

  public void appDescriptionInApplicationsTableIsDisplayed(String appDescription) {
    applicationPage.appDescriptionInApplicationsTableIsDisplayed(appDescription);
  }

  public void applicationDrawerEnabledButtonsAreIsDisplayed() {
    applicationPage.applicationDrawerEnabledButtonsAreIsDisplayed();
  }

  public void applicationDrawerImageIsDisplayed(String image) {
    applicationPage.applicationDrawerImageIsDisplayed(image);
  }

  public void applicationDrawerPermissionsIsDisplayed(String firstPermission, String secondPermission) {
    applicationPage.applicationDrawerPermissionsIsDisplayed(firstPermission, secondPermission);

  }

  public void applicationDrawerTitleIsDisplayed(String title) {

    applicationPage.applicationDrawerTitleIsDisplayed(title);
  }

  public void applicationDrawerUrlIsDisplayed(String url) {
    applicationPage.applicationDrawerUrlIsDisplayed(url);
  }

  public void appPermissionInApplicationsTableIsDisplayed(String appTitle, String permission) {
    applicationPage.appPermissionInApplicationsTableIsDisplayed(appTitle, permission);
  }

  public void appTitleInApplicationsTableIsDisplayed(String appTitle) {
    applicationPage.appTitleInApplicationsTableIsDisplayed(appTitle);
  }

  public void appUrlInApplicationsTableIsDisplayed(String appUrl) {
    applicationPage.appUrlInApplicationsTableIsDisplayed(appUrl);
  }

  public void checkPopupDeleteNotVisible() {
    applicationPage.checkPopupDeleteNotVisible();
  }

  public void checkThatApplicationImageIsDisplayedInDrawer(String image) {
    applicationPage.checkThatApplicationImageIsDisplayedInDrawer(image);
  }

  public void checkThatApplicationImageIsNotDisplayedInApplicationsTable(String appTitle) {
    applicationPage.checkThatApplicationImageIsNotDisplayedInApplicationsTable(appTitle);
  }

  public void checkThatApplicationImageIsNotDisplayedInDrawer(String image) {
    applicationPage.checkThatApplicationImageIsNotDisplayedInDrawer(image);
  }

  public void clickActiveApp(String appName) {
    applicationPage.clickActiveApp(appName);
  }

  public void clickCancelDelete() {
    applicationPage.clickCancelDelete();
  }

  public void clickCloseDeletePopup() {
    applicationPage.clickCloseDeletePopup();
  }

  public void clickSaveApplicationDrawer() {
    applicationPage.clickSaveAddApplication();
  }

  public void deleteApp(String appName, boolean confirm) {
    applicationPage.deleteApp(appName, confirm);
  }

  public void disableMandatoryApplication(String appTitle) {
    applicationPage.disableMandatoryApplication(appTitle);
  }

  public void editApplicationTitleUrlDescription(String appName, Map<String, String> applicationData) {
    applicationPage.goToEditTheApplication(appName);
    for (Map.Entry<String, String> entry : applicationData.entrySet()) {
      applicationPage.enterDataValueToField(entry.getKey(), applicationData.get(entry.getValue()));
    }
    applicationPage.clickSaveAddApplication();
  }

  public void editRandomApplicationTitleUrlDescription(String appName, String title, String url, String desc) {
    applicationPage.goToEditTheApplication(appName);
    applicationPage.enterRandomAppDataTitleUrlDescription(title, url, desc);
    applicationPage.clickSaveAddApplication();
  }

  public void enableDisableActiveApplication(String appTitle) {

    applicationPage.enableDisableActiveApplication(appTitle);
  }

  public void enableMandatoryApplication(String appTitle) {
    applicationPage.enableMandatoryApplication(appTitle);
  }

  public void enterApplicationTitleUrlDescription(Map<String, String> applicationData) {
    applicationPage.clickAddApplicationButton();
    for (Map.Entry<String, String> entry : applicationData.entrySet()) {
      applicationPage.enterDataValueToField(entry.getKey(), applicationData.get(entry.getValue()));
    }
    applicationPage.clickSaveAddApplication();
  }

  public void enterApplicationTitleUrlDescriptionWithImage(String image, Map<String, String> applicationData) {
    applicationPage.clickAddApplicationButton();
    for (Entry<String, String> field : applicationData.entrySet()) {
      applicationPage.enterDataValueToField(field.getKey(), field.getValue());
    }
    applicationPage.addImageToApplication(image);
    applicationPage.clickSaveAddApplication();
  }

  public void enterApplicationValues(Map<String, String> applicationData) {
    applicationPage.clickAddApplicationButton();
    for (Entry<String, String> field : applicationData.entrySet()) {
      applicationPage.enterDataValueToField(field.getKey(), field.getValue());
    }
    applicationPage.clickSaveAddApplication();
  }

  public void enterRandomApplicationTitleAndUrl(String title, String url) {
    applicationPage.clickAddApplicationButton();
    applicationPage.enterRandomAppDataTitleUrl(title, url);
    applicationPage.clickSaveAddApplication();
  }

  public void enterRandomApplicationTitleUrlDescription(String title, String url, String desc) {
    applicationPage.clickAddApplicationButton();
    applicationPage.enterRandomAppDataTitleUrlDescription(title, url, desc);
    applicationPage.clickSaveAddApplication();
  }

  public void enterRandomApplicationTitleUrlDescriptionImage(String title, String url, String desc, String image) {
    applicationPage.clickAddApplicationButton();
    applicationPage.enterRandomAppDataTitleUrlDescription(title, url, desc);
    applicationPage.addImageToApplication(image);
    applicationPage.clickSaveAddApplication();
  }

  public void goToEditTheApplication(String app) {
    applicationPage.goToEditTheApplication(app);
  }

  public boolean isAppExists(String appTitle) {
    return applicationPage.isAppExists(appTitle);
  }

  public void removeFileFromApplicationDrawer() {
    applicationPage.removeFileFromApplicationDrawer();
  }

  public void searchApp(String appTitle) {
    applicationPage.searchApp(appTitle);
  }
}
