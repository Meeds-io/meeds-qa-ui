package io.meeds.qa.ui.pages.page.factory.administration;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.ExceptionLauncher;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ApplicationPage extends GenericPage {

  @FindBy(xpath = "//button[contains(@class,'addApplicationBtn')]")
  private ElementFacade    addApplicationButton;

  @FindBy(xpath = "//*[@name='description']")
  private TextBoxElementFacade applicationDescription;

  @FindBy(xpath = "//div[@class='btn']")
  private ElementFacade    cancelDeleteButton;

  @FindBy(xpath = "//button[contains(@class,'closeBindingModal')]")
  private ElementFacade    closeDeletePopupButton;

  @FindBy(xpath = "//div[@id='deleteBtn']")
  private ElementFacade    confirmDelete;

  @FindBy(xpath = "//*[@class='appLauncherDrawerTitle']/following::*[@class='imageTitle']")
  private ElementFacade    editApplicationDrawerImage;

  @FindBy(
      xpath = "(//*[contains(@class, 'appCenterDrawer')]//*[@for='permissions']/following::*[@class='item'])[1]"
  )
  private TextBoxElementFacade editApplicationDrawerPermissionsFirst;

  @FindBy(
      xpath = "(//*[contains(@class, 'appCenterDrawer')]//*[@for='permissions']/following::*[@class='item'])[2]"
  )
  private ElementFacade    editApplicationDrawerPermissionsSecond;

  @FindBy(xpath = "//*[@class='appLauncherDrawerTitle']/following::*[@name='title']")
  private TextBoxElementFacade editApplicationDrawerTitle;

  @FindBy(xpath = "//*[@class='appLauncherDrawerTitle']/following::input[@type='url'][1]")
  private TextBoxElementFacade editApplicationDrawerUrl;

  public final Map<String, TextBoxElementFacade> MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH = new HashMap<>();

  public final Map<String, ElementFacade>    MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH                = new HashMap<>();

  @FindBy(xpath = "//*[contains(@class,'remove-file')]//i")
  private TextBoxElementFacade removeFileInApplicationDrawerButton;

  @FindBy(xpath = "//button[contains(@class,'applicationsActionBtn')][2]")
  private ElementFacade    saveAddApplicationButton;

  @FindBy(xpath = "//div[contains(@class,'appSearch')]//input")
  private TextBoxElementFacade searchAppInput;

  @FindBy(xpath = "//input[@name='title']")
  private TextBoxElementFacade titleAppInput;

  @FindBy(xpath = "//input[@name='url']")
  private TextBoxElementFacade urlAppInput;

  public ApplicationPage(WebDriver driver) {
    super(driver);
    MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.put("Application title", titleAppInput);
    MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.put("Application url", urlAppInput);
    MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.put("Application description", applicationDescription);
  }

  public void addImageToApplication(String image) {
    WebElement elem =
                    getDriver().findElement(org.openqa.selenium.By.xpath("//*[contains(@class,'uploadImage')]//*[@id='imageFile']"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + image).fromLocalMachine().to(elem);
  }

  private ElementFacade appDescriptionInApplicationsTable(String appDescription) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr",
                                          appDescription));
  }

  public void appDescriptionInApplicationsTableIsDisplayed(String appDescription) {
    assertWebElementVisible(appDescriptionInApplicationsTable(appDescription));
  }

  public void applicationDrawerEnabledButtonsAreIsDisplayed() {
    assertWebElementVisible(findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[1]//ancestor::*[contains(@class, 'v-input')]"));
    assertWebElementVisible(findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[2]//ancestor::*[contains(@class, 'v-input')]"));
    assertWebElementVisible(findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[3]//ancestor::*[contains(@class, 'v-input')]"));
  }

  public void applicationDrawerImageIsDisplayed(String image) {
    Assert.assertEquals(editApplicationDrawerImage.getText(), image);
  }

  public void applicationDrawerPermissionsIsDisplayed(String firstPermission, String secondPermission) {
    String firstValue = editApplicationDrawerPermissionsFirst.getAttribute("data-value");
    assertEquals(firstPermission, firstValue);
    assertTrue(editApplicationDrawerPermissionsFirst.getTextValue().contains(firstPermission));
    String secondValue = editApplicationDrawerPermissionsSecond.getAttribute("data-value");
    assertEquals(secondPermission, secondValue);
    assertTrue(editApplicationDrawerPermissionsSecond.getTextValue().contains(secondPermission));
  }

  public void applicationDrawerTitleIsDisplayed(String title) {
    Assert.assertEquals(editApplicationDrawerTitle.getTextValue(), title);
  }

  public void applicationDrawerUrlIsDisplayed(String url) {
    Assert.assertEquals(editApplicationDrawerUrl.getTextValue(), url);
  }

  private ElementFacade appPermissionInApplicationsTable(String appTitle, String permission) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr//*[contains(text(),'%s')]",
                                          appTitle,
                                          permission));
  }

  public void appPermissionInApplicationsTableIsDisplayed(String appTitle, String permission) {
    assertWebElementVisible(appPermissionInApplicationsTable(appTitle, permission));
  }

  private ElementFacade appTitleInApplicationsTable(String appTitle) {
    return findByXPathOrCSS(String.format("//td[contains(@class, 'tableAppTitle') and contains(text(),'%s')]", appTitle));
  }

  public void appTitleInApplicationsTableIsDisplayed(String appTitle) {
    assertWebElementVisible(appTitleInApplicationsTable(appTitle));
  }

  private ElementFacade appTitleNoImageElement(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr//img[contains(@src, 'defaultApp.png')]",
                                          appTitle));
  }

  private ElementFacade appUrlInApplicationsTable(String appUrl) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::tr",
                                          appUrl));
  }

  public void appUrlInApplicationsTableIsDisplayed(String appUrl) {
    assertWebElementVisible(appUrlInApplicationsTable(appUrl));
  }

  public void checkThatApplicationImageIsDisplayedInDrawer(String image) {
    assertWebElementVisible(getApplicationImageInDrawer(image));
  }

  public void checkThatApplicationImageIsNotDisplayedInApplicationsTable(String appTitle) {
    assertWebElementVisible(appTitleNoImageElement(appTitle));
  }

  public void checkThatApplicationImageIsNotDisplayedInDrawer(String image) {
    assertWebElementNotVisible(getApplicationImageInDrawer(image));
  }

  public void clickActiveApp(String appTitle) {
    searchAppByTitle(appTitle);
    getActiveButton(appTitle).clickOnElement();
  }

  public void clickAddApplicationButton() {
    addApplicationButton.waitUntilVisible();
    addApplicationButton.clickOnElement();
  }

  public void clickCancelDelete() {
    cancelDeleteButton.waitUntilVisible();
    cancelDeleteButton.clickOnElement();
  }

  public void clickCloseDeletePopup() {
    closeDeletePopupButton.clickOnElement();
  }

  public void clickEditApp(String appTitle) {
    MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH.get(appTitle).clickOnElement();
  }

  public void clickSaveAddApplication() {
    saveAddApplicationButton.clickOnElement();
    waitForDrawerToClose();
  }

  public void deleteApp(String appTitle, boolean confirm) {
    ElementFacade deleteButton = getDeleteButton(appTitle);
    if (deleteButton.isDisplayedNoWait()) {
      deleteButton.clickOnElement();
      waitFor(100).milliseconds();
    }
    if (confirm && confirmDelete.isVisible()) {
      confirmDelete.clickOnElement();
    }
  }

  public void disableMandatoryApplication(String appTitle) {
    searchAppByTitle(appTitle);
    retryOnCondition(() -> {
      ElementFacade mandatoryApplication = getMandatoryApplication(appTitle);
      if (mandatoryApplication.findByXPath("//input").getAttribute("aria-checked").equals("true")) {
        clickOnElement(mandatoryApplication);
      }
    });
  }

  private ElementFacade editTheApplication(String appTitle) {
    return findByXPathOrCSS(String.format("//td[contains(text(),'%s')]/..//i[contains(@class,'mdi-pencil')]", appTitle));
  }

  public void enableDisableActiveApplication(String appTitle) {
    ElementFacade activeApplicationSwitchButton = getActiveApplication(appTitle);
    activeApplicationSwitchButton.waitUntilVisible();
    activeApplicationSwitchButton.clickOnElement();
  }

  public void enableMandatoryApplication(String appTitle) {
    searchAppByTitle(appTitle);
    retryOnCondition(() -> {
      ElementFacade mandatoryApplication = getMandatoryApplication(appTitle);
      if (mandatoryApplication.findByXPath("//input").getAttribute("aria-checked").equals("false")) {
        clickOnElement(mandatoryApplication);
      }
    });
  }

  public void enterDataValueToField(String field, String value) {
    MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.get(field).setTextValue(value);
  }

  public void enterRandomAppDataTitleUrl(String title, String url) {
    titleAppInput.setTextValue(title);
    urlAppInput.setTextValue(url);
  }

  public void enterRandomAppDataTitleUrlDescription(String title, String url, String desc) {
    titleAppInput.setTextValue(title);
    urlAppInput.setTextValue(url);
    applicationDescription.setTextValue(desc);
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

  public void goToEditTheApplication(String app) {
    editTheApplication(app).clickOnElement();
  }

  public boolean isAppExists(String appTitle) {
    searchAppByTitle(appTitle);
    return getActiveButton(appTitle).isCurrentlyVisible();
  }

  public void checkPopupDeleteNotVisible() {
    assertWebElementNotVisible(confirmDelete);
  }

  public void removeFileFromApplicationDrawer() {
    removeFileInApplicationDrawerButton.clickOnElement();
  }

  public void searchApp(String appTitle) {
    searchAppByTitle(appTitle);
  }

  private void searchAppByTitle(String appTitle) {
    refreshPage();
    searchAppInput.setTextValue(appTitle);
    // when searching
    waitForSearchToComplete();
  }

  private void waitForSearchToComplete() {
    try {
      findByXPathOrCSS("(//*[contains(@class, 'tableAppTitle')])[2]").waitUntilNotVisible();
    } catch (Exception e) {
      ExceptionLauncher.LOGGER.debug("Search on AppCenter hasn't finished loading at time", e);
    }
    waitFor(500).milliseconds(); // Wait until application finishes its
    // display
  }
}
