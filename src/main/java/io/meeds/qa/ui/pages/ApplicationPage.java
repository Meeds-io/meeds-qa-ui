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
package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;

public class ApplicationPage extends GenericPage {

  public ApplicationPage(WebDriver driver) {
    super(driver);
  }

  public void addRemoveApplicationToFavorites(String app) {
    searchAppInputElement().setTextValue(app);

    // Add/ Remove the application To Favorites
    ElementFacade appAsFavoriteInApplicationCenter = addApplicationAFavoriteInApplicationCenter(app);
    clickOnElement(appAsFavoriteInApplicationCenter);
  }

  public void bookmarkApplication(String appTitle) {
    findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star-outline')]//ancestor::button",
                                   appTitle)).click();
  }

  public void checkApplicationIsNotVisible(String application) {
    getApplicationInsideAppPage(application).assertNotVisible();
  }

  public void checkApplicationIsVisible(String application) {
    getApplicationInsideAppPage(application).assertVisible();
  }

  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {
    // Check that add application to favorites Button is displayed
    addApplicationAFavoriteInApplicationCenter(app).assertVisible();
  }

  public void checkThatAppcenterApplicationIsDisplayed(String app) {
    // Check that AppCenter Application is displayed
    elementApplicationsTopbarElement().click();
    getFavoriteApplicationElement(app).assertVisible();
    closeDrawerIfDisplayed();
  }

  public void checkThatAppcenterApplicationIsNotDisplayed(String app) {
    // Check that AppCenter Application app is not displayed
    elementApplicationsTopbarElement().click();
    getFavoriteApplicationElement(app).assertNotVisible();
    closeDrawerIfDisplayed();
  }

  public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {
    // Check that app is displayed in Favorite Applications
    getFavoriteApplicationElement(app).assertVisible();
  }

  public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {
    // Check that app is not displayed in Favorite Applications
    getFavoriteApplicationElement(app).assertNotVisible();
  }

  public void checkThatOpenApplicationButtonIsDisplayed(String app) {
    // Check that open application Button is displayed
    getAppCenterAllApplicationsButton(app).assertVisible();
  }

  public void clickOnOpenApplicationButton(String app) {
    // Click on open application
    getAppCenterAllApplicationsButton(app).click();
  }

  public void clickOnTheAppLauncherIcon() {
    waitForLoading();
    closeAllDrawers();
    retryOnCondition(() -> {
      elementApplicationsTopbarElement().checkVisible();
      elementApplicationsTopbarElement().click();
      waitForDrawerToOpen();
      waitForDrawerToLoad();
    }, Utils::refreshPage);
  }

  public void goToApplication(String application) {
    clickOnTheAppLauncherIcon();
    getApplication(application).click();
    waitForLoading();
  }

  public void seeAllApplications() {
    // Click on App Center Application Button
    elementApplicationsTopbarElement().click();
    waitForDrawerToOpen();
    waitForDrawerToLoad();
    elementAppcenterSeeAllApplicationsElement().click();
  }

  public void settingsPageIsOpened() {
    settingsPageElement().assertVisible();
  }

  public void starButtonIsDisabled(String appTitle) {
    disabledFavoriteIsDisplayed(appTitle).assertVisible();
  }

  public void starButtonIsNotSelected(String appTitle) {
    removeFromAppCenterFavoriteIsDisplayed(appTitle).assertVisible();
  }

  public void starButtonIsSelected(String appTitle) {
    addToAppCenterFavoriteIsDisplayed(appTitle).assertVisible();
  }

  public void unbookmarkApplication(String appTitle) {
    findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star')]//ancestor::button",
                                   appTitle)).click();
  }

  public void addImageToApplication(String image) {
    WebElement elem =
                    getDriver().findElement(org.openqa.selenium.By.xpath("//*[contains(@class,'uploadImage')]//*[@id='imageFile']"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + image).fromLocalMachine().to(elem);
  }

  public void appDescriptionInApplicationsTableIsDisplayed(String appDescription) {
    appDescriptionInApplicationsTable(appDescription).assertVisible();
  }

  public void applicationDrawerEnabledButtonsAreIsDisplayed() {
    findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[1]//ancestor::*[contains(@class, 'v-input')]").assertVisible();
    findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[2]//ancestor::*[contains(@class, 'v-input')]").assertVisible();
    findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[3]//ancestor::*[contains(@class, 'v-input')]").assertVisible();
  }

  public void applicationDrawerImageIsDisplayed(String image) {
    Assert.assertEquals(editApplicationDrawerImageElement().getText(), image);
  }

  public void applicationDrawerPermissionsIsDisplayed(String firstPermission, String secondPermission) {
    TextBoxElementFacade editApplicationDrawerPermissionsFirstElement = editApplicationDrawerPermissionsFirstElement();
    String firstValue = editApplicationDrawerPermissionsFirstElement.getAttribute("data-value");
    assertEquals(firstPermission, firstValue);
    assertTrue(editApplicationDrawerPermissionsFirstElement.getTextValue().contains(firstPermission));
    ElementFacade editApplicationDrawerPermissionsSecondElement = editApplicationDrawerPermissionsSecondElement();
    String secondValue = editApplicationDrawerPermissionsSecondElement.getAttribute("data-value");
    assertEquals(secondPermission, secondValue);
    assertTrue(editApplicationDrawerPermissionsSecondElement.getTextValue().contains(secondPermission));
  }

  public void applicationDrawerTitleIsDisplayed(String title) {
    Assert.assertEquals(editApplicationDrawerTitleElement().getTextValue(), title);
  }

  public void applicationDrawerUrlIsDisplayed(String url) {
    Assert.assertEquals(editApplicationDrawerUrlElement().getTextValue(), url);
  }

  public void appPermissionInApplicationsTableIsDisplayed(String appTitle, String permission) {
    appPermissionInApplicationsTable(appTitle, permission).assertVisible();
  }

  public void appTitleInApplicationsTableIsDisplayed(String appTitle) {
    appTitleInApplicationsTable(appTitle).assertVisible();
  }

  public void appUrlInApplicationsTableIsDisplayed(String appUrl) {
    appUrlInApplicationsTable(appUrl).assertVisible();
  }

  public void checkPopupDeleteNotVisible() {
    confirmDeleteElement().assertNotVisible();
  }

  public void checkThatApplicationImageIsDisplayedInDrawer(String image) {
    getApplicationImageInDrawer(image).assertVisible();
  }

  public void checkThatApplicationImageIsNotDisplayedInApplicationsTable(String appTitle) {
    appTitleNoImageElement(appTitle).assertVisible();
  }

  public void checkThatApplicationImageIsNotDisplayedInDrawer(String image) {
    getApplicationImageInDrawer(image).assertNotVisible();
  }

  public void clickActiveApp(String appTitle) {
    searchAppByTitle(appTitle);
    getActiveButton(appTitle).click();
  }

  public void clickAddApplicationButton() {
    addApplicationButtonElement().click();
  }

  public void clickCancelDelete() {
    cancelDeleteButtonElement().click();
  }

  public void clickCloseDeletePopup() {
    closeDeletePopupButtonElement().click();
  }

  public void clickSaveAddApplication() {
    saveAddApplicationButtonElement().click();
    waitForDrawerToClose();
  }

  public void deleteApp(String appTitle, boolean confirm) {
    ElementFacade deleteButton = getDeleteButton(appTitle);
    deleteButton.click();
    waitFor(100).milliseconds();
    ElementFacade confirmDeleteElement = confirmDeleteElement();
    if (confirm) {
      confirmDeleteElement.click();
    }
  }

  public void disableMandatoryApplication(String appTitle) {
    searchAppByTitle(appTitle);
    retryOnCondition(() -> {
      ElementFacade mandatoryApplication = getMandatoryApplication(appTitle);
      mandatoryApplication.checkVisible();
      String enabled = mandatoryApplication.findByXPath("//input").getAttribute("aria-checked");
      if (StringUtils.equals(enabled, "true")) {
        clickOnElement(mandatoryApplication);
      }
    });
  }

  public void enableDisableActiveApplication(String appTitle) {
    getActiveApplication(appTitle).click();
  }

  public void enableMandatoryApplication(String appTitle) {
    searchAppByTitle(appTitle);
    retryOnCondition(() -> {
      ElementFacade mandatoryApplication = getMandatoryApplication(appTitle);
      mandatoryApplication.checkVisible();
      String enabled = mandatoryApplication.findByXPath("//input").getAttribute("aria-checked");
      if (StringUtils.isBlank(enabled) || StringUtils.equals(enabled, "false")) {
        clickOnElement(mandatoryApplication);
      }
    });
  }

  public void enterDataValueToField(String fieldName, String value) {
    switch (fieldName) {
    case "Application title":
      titleAppInputElement().setTextValue(value);
      break;
    case "Application url":
      urlAppInputElement().setTextValue(value);
      break;
    case "Application description":
      applicationDescriptionElement().setTextValue(value);
      break;
    default:
      break;
    }
  }

  public void enterRandomAppDataTitleUrl(String title, String url) {
    titleAppInputElement().setTextValue(title);
    urlAppInputElement().setTextValue(url);
  }

  public void enterRandomAppDataTitleUrlDescription(String title, String url, String desc) {
    titleAppInputElement().setTextValue(title);
    urlAppInputElement().setTextValue(url);
    applicationDescriptionElement().setTextValue(desc);
  }

  public void goToEditTheApplication(String app) {
    editTheApplication(app).click();
  }

  public boolean isAppExists(String appTitle) {
    searchAppByTitle(appTitle);
    return getActiveButton(appTitle).isCurrentlyVisible();
  }

  public void removeFileFromApplicationDrawer() {
    removeFileInApplicationDrawerButtonElement().click();
  }

  public void searchApp(String appTitle) {
    searchAppByTitle(appTitle);
  }

  private ElementFacade addApplicationButtonElement() {
    return findByXPathOrCSS("//button[contains(@class,'addApplicationBtn')]");
  }

  private ElementFacade appDescriptionInApplicationsTable(String appDescription) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr",
                                          appDescription));
  }

  private TextBoxElementFacade applicationDescriptionElement() {
    return findTextBoxByXPathOrCSS("//*[@name='description']");
  }

  private ElementFacade appPermissionInApplicationsTable(String appTitle, String permission) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr//*[contains(text(),'%s')]",
                                          appTitle,
                                          permission));
  }

  private ElementFacade appTitleInApplicationsTable(String appTitle) {
    return findByXPathOrCSS(String.format("//td[contains(@class, 'tableAppTitle') and contains(text(),'%s')]", appTitle));
  }

  private ElementFacade appTitleNoImageElement(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr//img[contains(@src, 'defaultApp.png')]",
                                          appTitle));
  }

  private ElementFacade appUrlInApplicationsTable(String appUrl) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr",
                                          appUrl));
  }

  private ElementFacade closeDeletePopupButtonElement() {
    return findByXPathOrCSS(".v-dialog--active .uiIconClose");
  }

  private ElementFacade confirmDeleteElement() {
    return findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//button[contains(text(), 'Delete')]");
  }

  private ElementFacade cancelDeleteButtonElement() {
    return findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//button[contains(text(), 'Cancel')]");
  }

  private ElementFacade editApplicationDrawerImageElement() {
    return findByXPathOrCSS("//*[@class='appLauncherDrawerTitle']/following::*[@class='imageTitle']");
  }

  private TextBoxElementFacade editApplicationDrawerPermissionsFirstElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[@for='permissions']/following::*[@class='item'])[1]");
  }

  private ElementFacade editApplicationDrawerPermissionsSecondElement() {
    return findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[@for='permissions']/following::*[@class='item'])[2]");
  }

  private TextBoxElementFacade editApplicationDrawerTitleElement() {
    return findTextBoxByXPathOrCSS("//*[@class='appLauncherDrawerTitle']/following::*[@name='title']");
  }

  private TextBoxElementFacade editApplicationDrawerUrlElement() {
    return findTextBoxByXPathOrCSS("//*[@class='appLauncherDrawerTitle']/following::input[@type='url'][1]");
  }

  private ElementFacade editTheApplication(String appTitle) {
    return findByXPathOrCSS(String.format("//td[contains(text(),'%s')]/..//i[contains(@class,'mdi-pencil')]", appTitle));
  }

  private ElementFacade getActiveApplication(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'tableAppTitle') and contains(text(),'%s')]/following::*[@class='v-input--selection-controls__input'][2]",
                                          appTitle));
  }

  private ElementFacade getActiveButton(String appTitle) {
    return findByXPathOrCSS(String.format("(//td[contains(text(),'%s')]/..//input)[2]/..", appTitle));
  }

  private ElementFacade getApplicationImageInDrawer(String image) {
    return findByXPathOrCSS(String.format("//*[@class='imageTitle' and contains(text(),'%s')]", image));
  }

  private ElementFacade getDeleteButton(String appTitle) {
    return findByXPathOrCSS(String.format("//td[contains(text(),'%s')]//following::i[contains(@class,'mdi-delete')]", appTitle));
  }

  private ElementFacade getMandatoryApplication(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'tableAppTitle') and contains(text(),'%s')]/following::*[@class='v-input--selection-controls__input'][1]",
                                          appTitle));
  }

  private TextBoxElementFacade removeFileInApplicationDrawerButtonElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'remove-file')]//i");
  }

  private ElementFacade saveAddApplicationButtonElement() {
    return findByXPathOrCSS("//button[contains(@class,'applicationsActionBtn')][2]");
  }

  private ElementFacade addApplicationAFavoriteInApplicationCenter(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[contains (@class,'appTitle') and contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//i[contains(@class, 'mdi-star')])[01]",
                                          app));
  }

  private ElementFacade addToAppCenterFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star')]",
                                          app));
  }

  private ElementFacade disabledFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'userFavoriteApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star')]//ancestor::button[@disabled]",
                                          app));
  }

  private ElementFacade elementAppcenterSeeAllApplicationsElement() {
    return findByXPathOrCSS("//*[contains(@class,'appCenterDrawer')]//*[contains(@href, 'appCenterUserSetup')]");
  }

  private ElementFacade elementApplicationsTopbarElement() {
    return findByXPathOrCSS("//*[@id='appcenterLauncherButton']");
  }

  private ElementFacade getAppCenterAllApplicationsButton(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[contains (@class,'appTitle') and contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//a)[01]",
                                          app));
  }

  private ElementFacade getApplication(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@class,'appLauncherTitle') and contains(text(),'%s')]", appName));
  }

  private ElementFacade getApplicationInsideAppPage(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'authorizedApplication')]//*[contains(text(),'%s')]", appName));
  }

  private ElementFacade getFavoriteApplicationElement(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'favoriteApplication')]//*[contains(text(),'%s')]", appName));
  }

  private ElementFacade removeFromAppCenterFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star-outline')]",
                                          app));
  }

  private ElementFacade settingsPageElement() {
    return findByXPathOrCSS("//*[@class='drawer filterSpacesDrawer open']//*[@class='btn reset']");
  }

  private void searchAppByTitle(String appTitle) {
    refreshPage();
    searchAppInputElement().setTextValue(appTitle);
    // when searching
    waitForSearchToComplete();
  }

  private TextBoxElementFacade searchAppInputElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'appSearch')]//input");
  }

  private TextBoxElementFacade titleAppInputElement() {
    return findTextBoxByXPathOrCSS("//input[@name='title']");
  }

  private TextBoxElementFacade urlAppInputElement() {
    return findTextBoxByXPathOrCSS("//input[@name='url']");
  }

  private void waitForSearchToComplete() {
    try {
      findByXPathOrCSS("(//*[contains(@class, 'tableAppTitle')])[2]").checkNotVisible();
    } catch (Exception e) {
      LOGGER.debug("Search on AppCenter hasn't finished loading at time", e);
    }
    waitFor(500).milliseconds(); // Wait until application finishes its display
  }
}
