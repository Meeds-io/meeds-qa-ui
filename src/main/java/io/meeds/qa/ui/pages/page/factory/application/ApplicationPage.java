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
                                   appTitle)).clickOnElement();
  }

  public void checkApplicationIsNotVisible(String application) {
    assertWebElementNotVisible(getApplicationInsideAppPage(application));
  }

  public void checkApplicationIsVisible(String application) {
    assertWebElementVisible(getApplicationInsideAppPage(application));
  }

  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {
    // Check that add application to favorites Button is displayed
    assertWebElementVisible(addApplicationAFavoriteInApplicationCenter(app));
  }

  public void checkThatAppcenterApplicationIsDisplayed(String app) {
    // Check that AppCenter Application is displayed
    elementApplicationsTopbarElement().clickOnElement();
    assertWebElementVisible(getFavoriteApplicationElement(app));
    closeDrawerIfDisplayed();
  }

  public void checkThatAppcenterApplicationIsNotDisplayed(String app) {
    // Check that AppCenter Application app is not displayed
    elementApplicationsTopbarElement().clickOnElement();
    assertWebElementNotVisible(getFavoriteApplicationElement(app));
    closeDrawerIfDisplayed();
  }

  public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {
    // Check that app is displayed in Favorite Applications
    assertWebElementVisible(getFavoriteApplicationElement(app));
  }

  public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {
    // Check that app is not displayed in Favorite Applications
    assertWebElementNotVisible(getFavoriteApplicationElement(app));
  }

  public void checkThatOpenApplicationButtonIsDisplayed(String app) {
    // Check that open application Button is displayed
    assertWebElementVisible(getAppCenterAllApplicationsButton(app));
  }

  public void clickOnOpenApplicationButton(String app) {
    // Click on open application
    ElementFacade appCenterAllApplicationsButton = getAppCenterAllApplicationsButton(app);
    appCenterAllApplicationsButton.waitUntilVisible();
    appCenterAllApplicationsButton.clickOnElement();
  }

  public void clickOnTheAppLauncherIcon() {
    ElementFacade elementApplicationsTopbarElement = elementApplicationsTopbarElement();
    elementApplicationsTopbarElement.waitUntilVisible();
    elementApplicationsTopbarElement.clickOnElement();
  }

  public void goToApplication(String application) {
    getApplication(application).clickOnElement();
  }

  public void maxFavoriteAppsIsDisplayed() {
    assertWebElementVisible(maxFavoriteAppsElement());
  }

  public void seeAllApplications() {
    // Click on App Center Application Button
    ElementFacade elementApplicationsTopbarElement = elementApplicationsTopbarElement();
    elementApplicationsTopbarElement.waitUntilClickable();
    elementApplicationsTopbarElement.clickOnElement();
    ElementFacade elementAppcenterSeeAllApplicationsElement = elementAppcenterSeeAllApplicationsElement();
    elementAppcenterSeeAllApplicationsElement.waitUntilVisible();
    elementAppcenterSeeAllApplicationsElement.clickOnElement();
  }

  public void settingsPageIsOpened() {
    assertWebElementVisible(settingsPageElement());
  }

  public void starButtonIsDisabled(String appTitle) {
    assertWebElementVisible(disabledFavoriteIsDisplayed(appTitle));
  }

  public void starButtonIsNotSelected(String appTitle) {
    assertWebElementVisible(removeFromAppCenterFavoriteIsDisplayed(appTitle));
  }

  public void starButtonIsSelected(String appTitle) {
    assertWebElementVisible(addToAppCenterFavoriteIsDisplayed(appTitle));
  }

  public void unbookmarkApplication(String appTitle) {
    findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star')]//ancestor::button",
                                   appTitle)).clickOnElement();
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
    return findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star')]//ancestor::button[@disabled]",
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
