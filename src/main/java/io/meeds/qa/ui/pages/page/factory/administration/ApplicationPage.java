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

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.ExceptionLauncher;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ApplicationPage extends GenericPage {

  public final Map<String, BaseElementFacade>    MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH                = new HashMap<>();

  public final Map<String, TextBoxElementFacade> MAPPING_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH             = new HashMap<>();

  public final Map<String, TextBoxElementFacade> MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH = new HashMap<>();

  public ApplicationPage(WebDriver driver) {
    super(driver);
    MAPPING_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.put("Application title", titleAppInput);
    MAPPING_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.put("Application url", urlAppInput);
    MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.put("Application title", titleAppInput);
    MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.put("Application url", urlAppInput);
    MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.put("Application description", applicationDescription);
  }

  @FindBy(xpath = "//button[contains(@class,'addApplicationBtn')]")
  private BaseElementFacade    addApplicationButton;

  @FindBy(xpath = "//input[@name='title']")
  private TextBoxElementFacade titleAppInput;

  @FindBy(xpath = "//*[@class='appLauncherDrawerTitle']/following::*[@name='title']")
  private TextBoxElementFacade editApplicationDrawerTitle;

  @FindBy(xpath = "//*[@name='description']")
  private TextBoxElementFacade applicationDescription;

  @FindBy(xpath = "//*[@class='appLauncherDrawerTitle']/following::input[@type='url'][1]")
  private TextBoxElementFacade editApplicationDrawerUrl;

  @FindBy(xpath = "//*[@class='appLauncherDrawerTitle']/following::*[@class='imageTitle']")
  private BaseElementFacade    editApplicationDrawerImage;

  @FindBy(
      xpath = "(//*[contains(@class, 'appCenterDrawer')]//*[@for='permissions']/following::*[@class='item'])[1]"
  )
  private TextBoxElementFacade editApplicationDrawerPermissionsFirst;

  @FindBy(
      xpath = "(//*[contains(@class, 'appCenterDrawer')]//*[@for='permissions']/following::*[@class='item'])[2]"
  )
  private BaseElementFacade    editApplicationDrawerPermissionsSecond;

  @FindBy(xpath = "//input[@name='url']")
  private TextBoxElementFacade urlAppInput;

  @FindBy(xpath = "//*[contains(@class,'remove-file')]//i")
  private TextBoxElementFacade removeFileInApplicationDrawerButton;

  @FindBy(xpath = "//button[contains(@class,'applicationsActionBtn')][2]")
  private BaseElementFacade    saveAddApplicationButton;

  @FindBy(xpath = "//div[contains(@class,'appSearch')]//input")
  private TextBoxElementFacade searchAppInput;

  @FindBy(xpath = "//div[@id='deleteBtn']")
  private BaseElementFacade    confirmDelete;

  @FindBy(xpath = "//div[@class='btn']")
  private BaseElementFacade    cancelDeleteButton;

  @FindBy(xpath = "//button[contains(@class,'closeBindingModal')]")
  private BaseElementFacade    closeDeletePopupButton;

  private BaseElementFacade getActiveButton(String appTitle) {
    return findByXPathOrCSS(String.format("(//td[contains(text(),'%s')]/..//input)[2]/..", appTitle));
  }

  private BaseElementFacade getApplicationImageInDrawer(String image) {
    return findByXPathOrCSS(String.format("//*[@class='imageTitle' and contains(text(),'%s')]", image));
  }

  private BaseElementFacade editTheApplication(String appTitle) {
    return findByXPathOrCSS(String.format("//td[contains(text(),'%s')]/..//i[contains(@class,'mdi-pencil')]", appTitle));
  }

  private BaseElementFacade appTitleInApplicationsTable(String appTitle) {
    return findByXPathOrCSS(String.format("//td[contains(@class, 'tableAppTitle') and contains(text(),'%s')]", appTitle));
  }

  private BaseElementFacade appPermissionInApplicationsTable(String appTitle, String permission) {
    return findByXPathOrCSS(String.format("//td[contains(text(),'%s')]/following::*[contains(@class,'permission')][1]//span[contains(text(),'%s')]",
                                          appTitle,
                                          permission));
  }

  private BaseElementFacade appUrlInApplicationsTable(String appUrl) {
    return findByXPathOrCSS(String.format("//td[contains(@class,'appUrl') and contains(text(),'%s')]", appUrl));
  }

  private BaseElementFacade appDescriptionInApplicationsTable(String appDescription) {
    return findByXPathOrCSS(String.format("//td[contains(@class,'tableAppDescription') and contains(text(),'%s')]",
                                          appDescription));
  }

  private BaseElementFacade getMandatoryApplication(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'tableAppTitle') and contains(text(),'%s')]/following::*[@class='v-input--selection-controls__input'][1]",
                                          appTitle));
  }

  private BaseElementFacade getActiveApplication(String appTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'tableAppTitle') and contains(text(),'%s')]/following::*[@class='v-input--selection-controls__input'][2]",
                                          appTitle));
  }

  private BaseElementFacade getDeleteButton(String appTitle) {
    return findByXPathOrCSS(String.format("//td[contains(text(),'%s')]//following::i[contains(@class,'mdi-delete')]", appTitle));
  }

  public void clickEditApp(String app) {
    MAPPING_FIELD_NAME_TO_BASEELEMENTFACADE_XPATH.get(app).clickOnElement();
  }

  public void checkThatApplicationImageIsNotDisplayedInApplicationsTable(String appTitle) {
    assertTrue(appTitleInApplicationsTable(appTitle).isVisibleAfterWaiting());
  }

  public void checkThatApplicationImageIsDisplayedInDrawer(String image) {
    assertTrue(getApplicationImageInDrawer(image).isVisibleAfterWaiting());
  }

  public void removeFileFromApplicationDrawer() {
    removeFileInApplicationDrawerButton.clickOnElement();
  }

  public void checkThatApplicationImageIsNotDisplayedInDrawer(String image) {
    assertTrue(getApplicationImageInDrawer(image).isNotVisibleAfterWaiting());
  }

  public void goToEditTheApplication(String app) {
    editTheApplication(app).clickOnElement();
  }

  public void enterValueToField(String field, String value) {
    MAPPING_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.get(field).setTextValue(value);
  }

  public void enterDataValueToField(String field, String value) {
    MAPPING_APPLICATION_FIELD_NAME_TO_TEXTBOXELEMENTFACADE_XPATH.get(field).setTextValue(value);
  }

  public void appTitleInApplicationsTableIsDisplayed(String appTitle) {
    assertTrue(appTitleInApplicationsTable(appTitle).isVisibleAfterWaiting());
  }

  public void appUrlInApplicationsTableIsDisplayed(String appUrl) {
    assertTrue(appUrlInApplicationsTable(appUrl).isVisibleAfterWaiting());
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

  public void appDescriptionInApplicationsTableIsDisplayed(String appDescription) {
    assertTrue(appDescriptionInApplicationsTable(appDescription).isVisibleAfterWaiting());
  }

  public void appPermissionInApplicationsTableIsDisplayed(String appTitle, String permission) {
    assertTrue(appPermissionInApplicationsTable(appTitle, permission).isVisibleAfterWaiting());
  }

  public void applicationDrawerTitleIsDisplayed(String title) {
    Assert.assertEquals(editApplicationDrawerTitle.getTextValue(), title);
  }

  public void applicationDrawerUrlIsDisplayed(String url) {
    Assert.assertEquals(editApplicationDrawerUrl.getTextValue(), url);
  }

  public void applicationDrawerImageIsDisplayed(String image) {
    Assert.assertEquals(editApplicationDrawerImage.getText(), image);
  }

  public void applicationDrawerEnabledButtonsAreIsDisplayed() {
    assertWebElementVisible(findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[1]//ancestor::*[contains(@class, 'v-input')]"));
    assertWebElementVisible(findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[2]//ancestor::*[contains(@class, 'v-input')]"));
    assertWebElementVisible(findByXPathOrCSS("(//*[contains(@class, 'appCenterDrawer')]//*[contains(@class, 'applicationProperties')]//input[@aria-checked='true'])[3]//ancestor::*[contains(@class, 'v-input')]"));
  }

  public void enableMandatoryApplication(String appTitle) {
    searchAppByTitle(appTitle);
    retryOnCondition(() -> {
      BaseElementFacade mandatoryApplication = getMandatoryApplication(appTitle);
      if (mandatoryApplication.findByXPath("//input").getAttribute("aria-checked").equals("false")) {
        clickOnElement(mandatoryApplication);
      }
    });
  }

  public void disableMandatoryApplication(String appTitle) {
    searchAppByTitle(appTitle);
    retryOnCondition(() -> {
      BaseElementFacade mandatoryApplication = getMandatoryApplication(appTitle);
      if (mandatoryApplication.findByXPath("//input").getAttribute("aria-checked").equals("true")) {
        clickOnElement(mandatoryApplication);
      }
    });
  }

  public void enableDisableActiveApplication(String appTitle) {
    BaseElementFacade activeApplicationSwitchButton = getActiveApplication(appTitle);
    activeApplicationSwitchButton.waitUntilVisible();
    activeApplicationSwitchButton.clickOnElement();
  }

  public void applicationDrawerPermissionsIsDisplayed(String firstPermission, String secondPermission) {
    String firstValue = editApplicationDrawerPermissionsFirst.getAttribute("data-value");
    assertEquals(firstPermission, firstValue);
    assertTrue(editApplicationDrawerPermissionsFirst.getTextValue().contains(firstPermission));
    String secondValue = editApplicationDrawerPermissionsSecond.getAttribute("data-value");
    assertEquals(secondPermission, secondValue);
    assertTrue(editApplicationDrawerPermissionsSecond.getTextValue().contains(secondPermission));
  }

  public void clickAddApplicationButton() {
    addApplicationButton.waitUntilVisible();
    addApplicationButton.clickOnElement();
  }

  public void addImageToApplication(String image) {
    WebElement elem = getDriver().findElement(By.xpath("//*[contains(@class,'uploadImage')]//*[@id='imageFile']"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + image).fromLocalMachine().to(elem);
  }

  public void clickSaveAddApplication() {
    saveAddApplicationButton.clickOnElement();
  }

  public void clickActiveApp(String appTitle) {
    searchAppByTitle(appTitle);
    getActiveButton(appTitle).clickOnElement();
  }

  public void deleteApp(String appTitle, boolean confirm) {
    getDeleteButton(appTitle).clickOnElement();
    if (confirm) {
      confirmDelete.clickOnElement();
    }
  }

  public void clickCancelDelete() {
    cancelDeleteButton.waitUntilVisible();
    cancelDeleteButton.clickOnElement();
  }

  public void searchApp(String appTitle) {
    searchAppByTitle(appTitle);
  }

  public boolean isAppExists(String appTitle) {
    searchAppByTitle(appTitle);
    return getActiveButton(appTitle).isCurrentlyVisible();
  }

  public void clickCloseDeletePopup() {
    closeDeletePopupButton.clickOnElement();
  }

  public boolean isPopupConfirmDeleteDisplayed() {
    return confirmDelete.isVisibleAfterWaiting() && cancelDeleteButton.isVisibleAfterWaiting()
        && closeDeletePopupButton.isVisibleAfterWaiting();
  }

  public boolean isPopupConfirmDeleteNotDisplayed() {
    return confirmDelete.isNotVisibleAfterWaiting() && cancelDeleteButton.isNotVisibleAfterWaiting()
        && closeDeletePopupButton.isNotVisibleAfterWaiting();
  }

  private void searchAppByTitle(String appTitle) {
    refreshPage();
    searchAppInput.setTextValue(appTitle);
    waitForSearchToComplete();
  }

  private void waitForSearchToComplete() {
    try {
      findByXPathOrCSS("(//*[contains(@class, 'tableAppTitle')])[2]").waitUntilNotVisible();
      waitFor(200).milliseconds(); // Wait until application finishes its
                                   // display
    } catch (Exception e) {
      ExceptionLauncher.LOGGER.debug("Search on AppCenter hasn't finished loading at time", e);
    }
  }
}
