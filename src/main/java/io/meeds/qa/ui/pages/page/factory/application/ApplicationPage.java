package io.meeds.qa.ui.pages.page.factory.application;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

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
    closeAllDrawers();
    elementApplicationsTopbarElement().click();
    waitForDrawerToOpen();
  }

  public void goToApplication(String application) {
    clickOnTheAppLauncherIcon();
    getApplication(application).click();
  }

  public void maxFavoriteAppsIsDisplayed() {
    maxFavoriteAppsElement().assertVisible();
  }

  public void seeAllApplications() {
    // Click on App Center Application Button
    elementApplicationsTopbarElement().click();
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
    return findByXPathOrCSS("(//*[contains(@class,'drawerParent appCenterDrawer')]//*[@class='v-btn__content'])[2]");
  }

  private ElementFacade elementApplicationsTopbarElement() {
    return findByXPathOrCSS("//*[@id='appcenterLauncherButton']");
  }

  private ElementFacade getAppCenterAllApplicationsButton(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[contains (@class,'appTitle') and contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//a)[01]",
                                          app));
  }

  private ElementFacade getApplication(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'appLauncherTitle') and contains(text(),'%s')]", appName));
  }

  private ElementFacade getApplicationInsideAppPage(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'authorizedApplication')]//*[contains(text(),'%s')]", appName));
  }

  private ElementFacade getFavoriteApplicationElement(String appName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'favoriteApplication')]//*[contains(text(),'%s')]", appName));
  }

  private ElementFacade maxFavoriteAppsElement() {
    return findByXPathOrCSS("//*[@class='maxFavorite']//span[contains(text(),'You can’t set more than 12 favorites')]");
  }

  private ElementFacade removeFromAppCenterFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star-outline')]",
                                          app));
  }

  private TextBoxElementFacade searchAppInputElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'appSearch')]//input");
  }

  private ElementFacade settingsPageElement() {
    return findByXPathOrCSS("//*[@class='drawer filterSpacesDrawer open']//*[@class='btn reset']");
  }

}
