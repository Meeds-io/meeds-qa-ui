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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
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
    waitFor(50).milliseconds();

    // Add/ Remove the application To Favorites
    getFavoriteButton(app).click();
  }

  public void bookmarkApplication(String appTitle) {
    getNonFavoriteApplicationElement(appTitle).click();
  }

  public void checkApplicationIsNotVisible(String application) {
    getApplicationInsideAppPage(application).assertNotVisible();
  }

  public void checkApplicationIsVisible(String application) {
    getApplicationInsideAppPage(application).assertVisible();
  }

  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {
    // Check that add application to favorites Button is displayed
    getFavoriteButton(app).assertVisible();
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
    getApplicationsCard(app).assertVisible();
  }

  public void clickOnOpenApplicationButton(String app) {
    // Click on open application
    getApplicationsCard(app).click();
  }

  public void clickOnTheAppLauncherIcon() {
    if (getCurrentUrl().contains("/portal/administration")) {
      getDriver().navigate().to(getCurrentUrl().split("/portal")[0]);
      verifyPageLoaded();
    }
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
    expandDrawer();
  }

  public void settingsPageIsOpened() {
    settingsPageElement().assertVisible();
  }

  public void starButtonIsDisabled(String appTitle) {
    disabledFavoriteIsDisplayed(appTitle).assertVisible();
  }

  public void starButtonIsNotSelected(String appTitle) {
    getNonFavoriteApplicationElement(appTitle).assertVisible();
  }

  public void starButtonIsSelected(String appTitle) {
    getFavoriteApplicationElement(appTitle).assertVisible();
  }

  public void unbookmarkApplication(String appTitle) {
    getFavoriteApplicationElement(appTitle).click();
  }

  public void addImageToApplication(String image) {
    ElementFacade hiddenInput = findByXPathOrCSS("//input[@id='iconFileInput']//ancestor::*[contains(@class, 'v-input__control')]");
    String js = "arguments[0].style.display='block';";
    ((JavascriptExecutor) getDriver()).executeScript(js, hiddenInput.getWrappedElement());

    WebElement elem = getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='iconFileInput']"));
    upload(UPLOAD_DIRECTORY_PATH + image).fromLocalMachine().to(elem);

    js = "arguments[0].style.display='none';";
    ((JavascriptExecutor) getDriver()).executeScript(js, hiddenInput.getWrappedElement());
  }

  public void applicationDrawerEnabledButtonsAreIsDisplayed() {
    findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[1]//ancestor::*[contains(@class, 'v-input')]").assertVisible();
    findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[2]//ancestor::*[contains(@class, 'v-input')]").assertVisible();
    findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[3]//ancestor::*[contains(@class, 'v-input')]").assertVisible();
  }

  public void applicationDrawerImageIsDisplayed(String image) {
    assertEquals(editApplicationDrawerImageElement().getText(), image);
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
    assertEquals(editApplicationDrawerTitleElement().getTextValue(), title);
  }

  public void appTitleInApplicationsTableIsDisplayed(String appTitle) {
    appTitleInApplicationsTable(appTitle).assertVisible();
  }

  public void checkPopupDeleteNotVisible() {
    confirmDeleteElement().assertNotVisible();
  }

  public void checkThatApplicationImageIsDisplayedInDrawer() {
    getApplicationImageInDrawer().assertVisible();
  }

  public void checkThatApplicationImageIsNotDisplayedInApplicationsTable(String appTitle) {
    appTitleNoImageElement(appTitle).assertVisible();
  }

  public void checkThatApplicationImageIsNotDisplayedInDrawer() {
    getApplicationImageInDrawer().assertNotVisible();
  }

  public void clickActiveApp(String appTitle) {
    searchAppByTitle(appTitle);
    enableDisableActiveApplication(appTitle);
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
    clickDrawerButton("Save");
    waitForDrawerToClose();
  }

  public void deleteApp(String appTitle, boolean confirm) {
    openMenu(appTitle);
    getDeleteButton().click();
    if (confirm) {
      waitFor(200).milliseconds();
      clickConfirm();
    }
    waitForLoading();
  }

  public void enableDisableActiveApplication(String appTitle) {
    getActiveApplication(appTitle).click();
  }

  public void enableMandatoryApplication(String appTitle) {
    searchAppByTitle(appTitle);
    waitFor(50).milliseconds();

    openMenu(appTitle);
    getEditButton().click();

    ElementFacade mandatoryApplication = getMandatorySwitch();
    mandatoryApplication.checkVisible();
    String enabled = getMandatorySwitchInput().getAttribute("aria-checked");
    if (StringUtils.equals(enabled, "false")) {
      clickOnElement(mandatoryApplication);
      waitFor(200).milliseconds();
      enabled = getMandatorySwitchInput().getAttribute("aria-checked");
      assertEquals("true", enabled);
      clickDrawerButton("Save");
    } else {
      assertEquals("true", enabled);
      closeDrawerIfDisplayed();
    }
  }

  public void disableMandatoryApplication(String appTitle) {
    goToEditTheApplication(appTitle);

    ElementFacade mandatoryApplication = getMandatorySwitch();
    mandatoryApplication.checkVisible();
    String enabled = getMandatorySwitchInput().getAttribute("aria-checked");
    if (StringUtils.equals(enabled, "true")) {
      clickOnElement(mandatoryApplication);
      waitFor(200).milliseconds();
      enabled = getMandatorySwitchInput().getAttribute("aria-checked");
      assertEquals("false", enabled);
      clickDrawerButton("Save");
    } else {
      assertEquals("false", enabled);
      closeDrawerIfDisplayed();
    }
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

  public void goToEditTheApplication(String appTitle) {
    searchAppByTitle(appTitle);
    waitFor(50).milliseconds();
    openMenu(appTitle);
    getEditButton().click();
    waitForDrawerToOpen();
  }

  public void selectApplicationIconFromDrawer(String icon) {
    clickDrawerButton("Choose");
    waitForDrawerToOpen("#nodeIconPickerDrawer", false);
    searchIconInput().setTextValue(icon);
    waitFor(50).milliseconds();
    iconCard().click();
    waitFor(50).milliseconds();
    iconSaveButton().click();
  }

  public void searchApp(String appTitle) {
    searchAppByTitle(appTitle);
  }

  private void openMenu(String appTitle) {
    ElementFacade menuThreeDots = editApplication(appTitle);
    menuThreeDots.waitUntilVisible();
    menuThreeDots.click();
  }

  private ElementFacade addApplicationButtonElement() {
    return findByXPathOrCSS("//*[contains(@class, 'btn-primary')]//*[contains(text(), 'Add')]//ancestor::button");
  }

  private ElementFacade appTitleInApplicationsTable(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::tr", appTitle));
  }

  private ElementFacade appTitleNoImageElement(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr/td[1]//*[contains(@class, 'v-icon')]",
                                          appTitle));
  }

  private ElementFacade myApplicationDrawerElement() {
    return findByXPathOrCSS("//*[@id='appLauncher']");
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

  private ElementFacade getActiveApplication(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::tr//*[@class='v-input--selection-controls__input']",
                                          appTitle));
  }

  private ElementFacade getApplicationImageInDrawer() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@class, 'v-image')]");
  }

  private ElementFacade getDeleteButton() {
    return findByXPathOrCSS("//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'fa-trash')]");
  }

  private ElementFacade getEditButton() {
    return findByXPathOrCSS("//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'fa-edit')]");
  }

  private ElementFacade getMandatorySwitch() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(), 'Mandatory')]/parent::*//*[@class='v-input--selection-controls__input']");
  }

  private ElementFacade getMandatorySwitchInput() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(), 'Mandatory')]/parent::*//*[@class='v-input--selection-controls__input']//input");
  }

  private ElementFacade getFavoriteButton(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'appLauncherItemContainer')]//*[contains(@class, 'fa-star')]",
                                          app));
  }

  private ElementFacade disabledFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'appLauncherItemContainer')]//*[contains(@class, 'fa-star')]//ancestor::button[@disabled]",
                                          app));
  }

  private ElementFacade elementApplicationsTopbarElement() {
    return findByXPathOrCSS("//*[@id='appcenterLauncherButton']");
  }

  private ElementFacade getApplicationsCard(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'appLauncherItemContainer')]",
                                          app));
  }

  private ElementFacade getApplication(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@class,'appLauncherTitle') and contains(text(),'%s')]",
                                          appName));
  }

  private ElementFacade getApplicationInsideAppPage(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'appLauncherItemContainer')]",
                                          appName));
  }

  private ElementFacade getFavoriteApplicationElement(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'appLauncherItemContainer')]//*[contains(@class, 'fa-star') and contains(@class, 'yellow--text')]",
                                          appName));
  }

  private ElementFacade getNonFavoriteApplicationElement(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'appLauncherItemContainer')]//*[contains(@class, 'fa-star') and not(contains(@class, 'yellow--text'))]",
                                          appName));
  }

  private ElementFacade settingsPageElement() {
    return findByXPathOrCSS("//*[@class='drawer filterSpacesDrawer open']//*[@class='btn reset']");
  }

  private ElementFacade editApplication(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::tr//*[contains(@class, 'fa-ellipsis-v')]",
                                          appName));
  }

  private void searchAppByTitle(String appTitle) {
    refreshPage();
    searchAppInputElementInAdmin().setTextValue(appTitle);
    // when searching
    waitForSearchToComplete();
  }

  private TextBoxElementFacade searchAppInputElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'appSearch')]//input");
  }

  private TextBoxElementFacade searchAppInputElementInAdmin() {
    return findTextBoxByXPathOrCSS("#applicationToolbarFilterInput");
  }

  private TextBoxElementFacade searchIconInput() {
    return findTextBoxByXPathOrCSS("#nodeIconPickerDrawer input");
  }

  private ElementFacade iconCard() {
    return findTextBoxByXPathOrCSS("#nodeIconPickerDrawer .v-card--link");
  }
  private ElementFacade iconSaveButton() {
    return findTextBoxByXPathOrCSS("#nodeIconPickerDrawer .btn-primary");
  }

  private TextBoxElementFacade titleAppInputElement() {
    return findTextBoxByXPathOrCSS("//input[@name='applicationName']");
  }

  private TextBoxElementFacade applicationDescriptionElement() {
    return findTextBoxByXPathOrCSS("//input[@name='applicationDescription']");
  }

  private TextBoxElementFacade urlAppInputElement() {
    return findTextBoxByXPathOrCSS("//input[@name='applicationUrl']");
  }

  private void waitForSearchToComplete() {
    try {
      findByXPathOrCSS("(//*[contains(@class, 'tableAppTitle')])[2]").checkNotVisible();
    } catch (Exception e) {
      LOGGER.debug("Search on AppCenter hasn't finished loading at time", e);
    }
    waitFor(500).milliseconds(); // Wait until application finishes its display
  }

  public void isMyApplicationButtonDisplayed() {
    elementApplicationsTopbarElement().assertVisible();
  }
  public void isMyApplicationDrawerDisplayed() {
    myApplicationDrawerElement().assertVisible();
  }
}
