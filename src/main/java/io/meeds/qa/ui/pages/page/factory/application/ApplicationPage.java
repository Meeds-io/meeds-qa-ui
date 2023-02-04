package io.meeds.qa.ui.pages.page.factory.application;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ApplicationPage extends GenericPage {

  @FindBy(xpath = "//*[@href='/portal/meeds/contributions']//*[@class='appLauncherImage']")
  public static BaseElementFacade contributionsApplication;

  @FindBy(xpath = "//*[@class='userAuthorizedApplications']")
  public static BaseElementFacade ELEMENT_APPCENTER_ALL_APPLICATIONS_PAGE;

  @FindBy(xpath = "//*[@href='/portal/meeds/perkstore']//*[@class='appLauncherImage']")
  public static BaseElementFacade ELEMENT_APPCENTER_PERK_STORE;

  @FindBy(xpath = "(//*[contains(@class,'drawerParent appCenterDrawer')]//*[@class='v-btn__content'])[2]")
  public static BaseElementFacade ELEMENT_APPCENTER_SEE_ALL_APPLICATIONS;

  @FindBy(xpath = "//*[@href='/portal/meeds/tasks']//*[@class='appLauncherImage']")
  public static BaseElementFacade ELEMENT_APPCENTER_TASKS;

  @FindBy(xpath = "//*[@href='/portal/meeds/wallet']//*[@class='appLauncherImage']")
  public static BaseElementFacade ELEMENT_APPCENTER_WALLET;

  @FindBy(xpath = "//*[@id='appcenterLauncherButton']")
  public static BaseElementFacade ELEMENT_APPLICATIONS_TOPBAR;

  @FindBy(xpath = "(//*[contains(@class,'drawerParent appCenterDrawer')]//*[@class='v-btn__content'])[1]")
  public static BaseElementFacade ELEMENT_CLOSE_APPCENTER_DRAWER;

  @FindBy(xpath = "//*[@id='UIForumPortlet']")
  public static BaseElementFacade ELEMENT_FORUMS_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@id='UIWikiPortlet']")
  public static BaseElementFacade ELEMENT_NOTES_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@id='PerkStoreApp']")
  public static BaseElementFacade ELEMENT_PERK_STORE_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@id='TasksManagementPortlet']")
  public static BaseElementFacade ELEMENT_TASKS_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@id='WalletApp']")
  public static BaseElementFacade ELEMENT_WALLET_APPLICATION_PAGE;

  @FindBy(xpath = "//*[@id='ChallengesApplication']")
  public static BaseElementFacade elementChallengeApplicationPage;

  @FindBy(xpath = "//*[@id='UISiteBody']")
  public static BaseElementFacade elementChallengesApplicationPage;

  private static final Map<String, BaseElementFacade> MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH = new HashMap<>();

  @FindBy(xpath = "//*[@class='drawer filterSpacesDrawer open']//*[@class='btn reset']")
  public static BaseElementFacade settingsPage;

  @FindBy(xpath = "//*[@class='maxFavorite']//span[contains(text(),'You can’t set more than 12 favorites')]")
  private BaseElementFacade                           maxFavoriteApps;

  @FindBy(xpath = "//div[contains(@class,'appSearch')]//input")
  private TextBoxElementFacade                        searchAppInput;

  public ApplicationPage(WebDriver driver) {
    super(driver);
  }

  private BaseElementFacade addApplicationAFavoriteInApplicationCenter(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[contains (@class,'appTitle') and contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//i[contains(@class, 'mdi-star')])[01]",
                                          app));
  }

  public void addRemoveApplicationToFavorites(String app) {
    searchAppInput.setTextValue(app);

    // Add/ Remove the application To Favorites
    BaseElementFacade appAsFavoriteInApplicationCenter = addApplicationAFavoriteInApplicationCenter(app);
    clickOnElement(appAsFavoriteInApplicationCenter);
  }

  private BaseElementFacade addToAppCenterFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star')]",
                                          app));
  }

  public void bookmarkApplication(String appTitle) {
    findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star-outline')]//ancestor::button",
                                   appTitle)).clickOnElement();
  }

  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {
    // Check that add application to favorites Button is displayed
    assertWebElementVisible(addApplicationAFavoriteInApplicationCenter(app));
  }

  public void checkThatAppcenterApplicationIsDisplayed(String app) {
    // Check that AppCenter Application is displayed
    ELEMENT_APPLICATIONS_TOPBAR.clickOnElement();
    assertWebElementVisible(getAppCenterApplicationElement(app));
  }

  public void checkThatAppcenterApplicationIsNotDisplayed(String app) {
    // Check that AppCenter Application app is not displayed
    ELEMENT_APPLICATIONS_TOPBAR.clickOnElement();
    assertWebElementNotVisible(getAppCenterApplicationElement(app));
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
    getAppCenterAllApplicationsButton(app).waitUntilVisible();
    getAppCenterAllApplicationsButton(app).clickOnElement();
  }

  public void clickOnTheAppLauncherIcon() {
    ELEMENT_APPLICATIONS_TOPBAR.waitUntilVisible();
    ELEMENT_APPLICATIONS_TOPBAR.clickOnElement();
  }

  private BaseElementFacade disabledFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star')]//ancestor::button[@disabled]",
                                          app));
  }

  private BaseElementFacade getAppCenterAllApplicationsButton(String app) {
    return findByXPathOrCSS(String.format("(//*[@class='authorisedAppContent']//*[contains (@class,'appTitle') and contains(text(),'%s')]/following::*[contains(@class, 'applicationActions')]//a)[01]",
                                          app));
  }

  private BaseElementFacade getAppCenterApplicationElement(String app) {
    return findByXPathOrCSS(String.format("//*[@class='appLauncherTitle' and contains(text(),'%s')]", app));
  }

  private BaseElementFacade getApplication(String appName) {
    return findByXPathOrCSS(String.format("//div[@class='authorisedAppContent']//div[contains(text(),'%s')]", appName));
  }

  private BaseElementFacade getFavoriteApplicationElement(String app) {
    return findByXPathOrCSS(String.format("//*[@class='userFavoriteApplications']//*[contains(@class, 'favoriteApplication')]//*[contains(text(),'%s') ]",
                                          app));
  }

  public void goToApplication(String application) {
    getApplication(application).clickOnElement();
  }

  public void goToContributionsApplication() {
    contributionsApplication.waitUntilVisible();
    contributionsApplication.clickOnElement();
  }

  public void goToTasksAppCenterApplication() {
    retryOnCondition(() -> {
      // Click on App Center Tasks Application Button
      ELEMENT_APPCENTER_TASKS.clickOnElement();
    }, () -> {
      refreshPage();
      clickOnTheAppLauncherIcon();
    });
  }

  public void goToTheAppcenterApplicationPage(String app) {
    getAppCenterApplicationElement(app).clickOnElement();
  }

  public boolean isAppDisplayedInFavoriteList(String appName) {
    return MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH.get(appName).isVisibleAfterWaiting();
  }

  public void checkApplicationIsVisible(String application) {
    assertWebElementVisible(getApplication(application));
  }

  public void checkApplicationIsNotVisible(String application) {
    assertWebElementNotVisible(getApplication(application));
  }

  public boolean isAppNotDisplayedInFavoriteList(String appName) {
    return MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH.get(appName).isNotVisibleAfterWaiting();
  }

  public boolean isChallengesPageOpened() {
    return elementChallengesApplicationPage.isVisibleAfterWaiting();
  }

  public boolean isWalletPageOpened() {
    return ELEMENT_WALLET_APPLICATION_PAGE.isVisibleAfterWaiting();
  }

  public void maxFavoriteAppsIsDisplayed() {
    assertWebElementVisible(maxFavoriteApps);
  }

  private BaseElementFacade removeFromAppCenterFavoriteIsDisplayed(String app) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'userAuthorizedApplications')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-card')]//i[contains(@class, 'mdi-star-outline')]",
                                          app));
  }

  public void settingsPageIsOpened() {
    assertWebElementVisible(settingsPage);
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

}
