package io.meeds.qa.ui.pages.page.factory.application;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ApplicationPage extends GenericPage {
  public ApplicationPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@class='maxFavorite']//span[contains(text(),'You can’t set more than 12 favorites')]")
  private BaseElementFacade maxFavoriteApps;

  private BaseElementFacade getApplication(String appName) {
    return findByXPathOrCSS(String.format("//div[@class='authorisedAppContent']//div[contains(text(),'%s')]", appName));
  }

  Map<String, BaseElementFacade> MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH = new HashMap<>();

  public void maxFavoriteAppsIsDisplayed() {
    maxFavoriteApps.isVisibleAfterWaiting();
  }

  public boolean isAppDisplayedInFavoriteList(String appName) {
    return MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH.get(appName).isVisibleAfterWaiting();
  }

  public boolean isAppNotDisplayedInFavoriteList(String appName) {
    return MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH.get(appName).isNotVisibleAfterWaiting();
  }

  public boolean isApplicationVisible(String application) {
    return getApplication(application).isVisibleAfterWaiting();
  }

  @FindBy(xpath = "//*[@id='WalletApp']")
  public static BaseElementFacade ELEMENT_WALLET_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@id='UISiteBody']")
  public static BaseElementFacade elementChallengesApplicationPage;

  @FindBy(xpath = "//*[@id='TasksManagementPortlet']")
  public static BaseElementFacade ELEMENT_TASKS_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@class='drawer filterSpacesDrawer open']//*[@class='btn reset']")
  public static BaseElementFacade settingsPage;

  @FindBy(xpath = "//*[@id='UIWikiPortlet']")
  public static BaseElementFacade ELEMENT_NOTES_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@id='PerkStoreApp']")
  public static BaseElementFacade ELEMENT_PERK_STORE_APPLICATION_PAGE;

  @FindBy(xpath = "(//*[contains(@class,'drawerParent appCenterDrawer')]//*[@class='v-btn__content'])[1]")
  public static BaseElementFacade ELEMENT_CLOSE_APPCENTER_DRAWER;

  @FindBy(xpath = "//*[@id='UIForumPortlet']")
  public static BaseElementFacade ELEMENT_FORUMS_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@id='ticketAddon']")
  public static BaseElementFacade ELEMENT_SEND_FEEDBACK_APPLICATION_PAGE;

  @FindBy(xpath = "(//*[contains(@class,'drawerParent appCenterDrawer')]//*[@class='v-btn__content'])[2]")
  public static BaseElementFacade ELEMENT_APPCENTER_SEE_ALL_APPLICATIONS;

  @FindBy(xpath = "//*[@class='userAuthorizedApplications']")
  public static BaseElementFacade ELEMENT_APPCENTER_ALL_APPLICATIONS_PAGE;

  @FindBy(xpath = "//*[@href='/portal/meeds/tasks']//*[@class='appLauncherImage']")
  public static BaseElementFacade ELEMENT_APPCENTER_TASKS;

  @FindBy(xpath = "//*[@href='/portal/meeds/perkstore']//*[@class='appLauncherImage']")
  public static BaseElementFacade ELEMENT_APPCENTER_PERK_STORE;

  @FindBy(xpath = "//*[@href='/portal/meeds/wallet']//*[@class='appLauncherImage']")
  public static BaseElementFacade ELEMENT_APPCENTER_WALLET;

  @FindBy(xpath = "//*[@id='appcenterLauncherButton']")
  public static BaseElementFacade ELEMENT_APPLICATIONS_TOPBAR;

  @FindBy(xpath = "//*[@href='/portal/meeds/challenges']//*[@class='appLauncherImage']")
  public static BaseElementFacade challengeApplication;

  @FindBy(xpath = "//*[@id='ChallengesApplication']")
  public static BaseElementFacade elementChallengeApplicationPage;

  private BaseElementFacade addApplicationAFavoriteInApplicationCenter(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[contains (@class,'appTitle') and contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//i[contains(@class, 'mdi-star')])[01]",
                                     app));
  }

  private BaseElementFacade addToAppCenterFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[@class='appTitle']//div[contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//*[@title='Add to favorites applications']//button)[1]",
                                     app));
  }

  private BaseElementFacade removeFromAppCenterFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[@class='appTitle']//div[contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//*[@title='Remove from favorites']//button)[1]",
                                     app));
  }

  private BaseElementFacade ELEMENT_APPCENTER_ALL_APPLICATIONS_OPEN_APP_BTN(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[contains (@class,'appTitle') and contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//a)[01]",
                                     app));
  }

  private BaseElementFacade ELEMENT_APPCENTER_APPLICATION_TITLE(String app) {
    return findByXPathOrCSS(String.format("//*[@class='appLauncherTitle' and contains(text(),'%s')]", app));
  }

  private BaseElementFacade ELEMENT_FAVORITE_APPLICATION_TITLE(String app) {
    return findByXPathOrCSS(String.format("//*[@class='favAppTitle' and contains(text(),'%s')]", app));
  }

  public boolean isWalletPageOpened() {
    return ELEMENT_WALLET_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public boolean isChallengesPageOpened() {
    return elementChallengesApplicationPage.isVisibleAfterWaiting();
  }

  public void starButtonIsNotSelected(String appTitle) {
    addToAppCenterFavoriteIsDisplayed(appTitle).isVisibleAfterWaiting();
  }

  public void starButtonIsSelected(String appTitle) {
    removeFromAppCenterFavoriteIsDisplayed(appTitle).isVisibleAfterWaiting();
  }

  public void addRemoveApplicationToFavorites(String app) {
    // Add/ Remove the application To Favorites
    BaseElementFacade appAsFavoriteInApplicationCenter = addApplicationAFavoriteInApplicationCenter(app);
    clickOnElement(appAsFavoriteInApplicationCenter);
  }

  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {
    // Check that add application to favorites Button is displayed
    addApplicationAFavoriteInApplicationCenter(app).isVisibleAfterWaiting();
  }

  public void checkThatOpenApplicationButtonIsDisplayed(String app) {
    // Check that open application Button is displayed
    ELEMENT_APPCENTER_ALL_APPLICATIONS_OPEN_APP_BTN(app).isVisibleAfterWaiting();
  }

  public void settingsPageIsOpened() {
    settingsPage.isVisibleAfterWaiting();
  }

  public void clickOnOpenApplicationButton(String app) {
    // Click on open application
    ELEMENT_APPCENTER_ALL_APPLICATIONS_OPEN_APP_BTN(app).waitUntilVisible();
    ELEMENT_APPCENTER_ALL_APPLICATIONS_OPEN_APP_BTN(app).clickOnElement();
  }

  public void checkThatAppcenterApplicationIsDisplayed(String app) {
    // Check that AppCenter Application is displayed
    ELEMENT_APPLICATIONS_TOPBAR.clickOnElement();
    ELEMENT_APPCENTER_APPLICATION_TITLE(app).isVisibleAfterWaiting();
  }

  public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {
    // Check that app is displayed in Favorite Applications
    ELEMENT_FAVORITE_APPLICATION_TITLE(app).isVisibleAfterWaiting();
  }

  public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {
    // Check that app is not displayed in Favorite Applications
    ELEMENT_FAVORITE_APPLICATION_TITLE(app).isNotVisibleAfterWaiting();
  }

  public void checkThatAppcenterApplicationIsNotDisplayed(String app) {
    // Check that AppCenter Application app is not displayed
    ELEMENT_APPLICATIONS_TOPBAR.clickOnElement();
    ELEMENT_APPCENTER_APPLICATION_TITLE(app).isNotVisibleAfterWaiting();
  }

  public void goToTheAppcenterApplicationPage(String app) {
    ELEMENT_APPCENTER_APPLICATION_TITLE(app).clickOnElement();
  }

  public void goToApplication(String application) {
    getApplication(application).clickOnElement();
  }

  public void goToChallengeApplication() {
    challengeApplication.waitUntilVisible();
    challengeApplication.clickOnElement();
  }

}
