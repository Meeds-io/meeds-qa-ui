package io.meeds.qa.ui.pages.page.factory.administration;

import static io.meeds.qa.ui.utils.ExceptionLauncher.LOGGER;
import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class ApplicationPage extends GenericPage {

  public ApplicationPage(WebDriver driver) {
    super(driver);
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
    if (deleteButton.isCurrentlyVisible()) {
      deleteButton.click();
      waitFor(100).milliseconds();
    }
    ElementFacade confirmDeleteElement = confirmDeleteElement();
    if (confirm && confirmDeleteElement.isVisible()) {
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

  private ElementFacade cancelDeleteButtonElement() {
    return findByXPathOrCSS("//div[@class='btn']");
  }

  private ElementFacade closeDeletePopupButtonElement() {
    return findByXPathOrCSS("//button[contains(@class,'closeBindingModal')]");
  }

  private ElementFacade confirmDeleteElement() {
    return findByXPathOrCSS("//div[@id='deleteBtn']");
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
