package io.meeds.qa.ui.pages.page.factory.administration;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ManageDomainsPage extends GenericPage {

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  public static BaseElementFacade menuBtn;

  @FindBy(xpath = "//i[contains(@class,'uiIcon uiIconToolbarNavItem uiAdministrationIcon')]")
  private BaseElementFacade       adminBtn;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/gamification/domains']")
  private BaseElementFacade       domainLink;

  @FindBy(xpath = "//button[@class='btn btn-primary']")
  private BaseElementFacade       addDomainBtn;

  @FindBy(xpath = "//a[@class='uiIconClose pull-right']")
  private BaseElementFacade       closeFormBtn;

  @FindBy(xpath = "//input[@id='titleInput']")
  private TextBoxElementFacade    domainName;

  @FindBy(xpath = "//*[@id='domainDescription']")
  private TextBoxElementFacade    domainDescription;

  @FindBy(xpath = "//button[@class='btn-primary pull-right']")
  private BaseElementFacade       confirmBtn;

  @FindBy(xpath = "//input[@name='keyword']")
  private TextBoxElementFacade    searchDomainInput;

  @FindBy(xpath = "//i[@class='uiIconEdit uiIconLightGray']")
  private TextBoxElementFacade    editDomainIcon;

  @FindBy(xpath = "(//span[@class='PopupTitle popupTitle'])[2]")
  private TextBoxElementFacade    editDomainForm;

  @FindBy(xpath = "(//input[@id='titleInput'])[2]")
  private TextBoxElementFacade    editDomainNameField;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[2]")
  private BaseElementFacade       confirmChangesBtn;

  @FindBy(xpath = "//i[@class='uiIconDelete uiIconLightGray']")
  public BaseElementFacade        deleteBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[2]")
  public BaseElementFacade        confirmDeletionBtn;

  @FindBy(xpath = "//button[@class='btn cancel pull-right']")
  public BaseElementFacade        closeConfirmDeletionPopup;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/automatic-translation']")
  private BaseElementFacade       automaticTranslation;

  public BaseElementFacade getTitlePage(String title) {
    return findByXpath(String.format("//*[@class='row']//h4[@class='font-weight-bold' and contains(text(),'%s')]", title));
  }

  private BaseElementFacade getAlertPublishingActivity(String alert) {
    return findByXpath(
                       String.format("//*[@class='v-btn__content' and contains(text(),'%s')]", alert));
  }

  public void goToManageDomainMenu() {
    menuBtn.clickOnElement();
    adminBtn.clickOnElement();
    domainLink.clickOnElement();
  }

  public void addDomain() {
    addDomainBtn.clickOnElement();
  }

  public void addDomainName(String name) {
    domainName.setTextValue(name);
  }

  public void addDomainDescription(String description) {
    domainDescription.setTextValue(description);

  }

  public void fillForm(String name, String description) {
    closeFormBtn.isVisibleAfterWaiting();
    addDomainName(name);
    addDomainDescription(description);
  }

  public void confirmDomain() {
    confirmBtn.clickOnElement();
  }

  public void insertDomainNameInSearchField(String domainName) {
    searchDomainInput.waitUntilVisible();
    if (searchDomainInput.isNotVisibleAfterWaiting()) {
      driver.navigate().refresh();
    }
    searchDomainInput.waitUntilVisible();
    searchDomainInput.setTextValue(domainName);
  }

  private BaseElementFacade getDomainNameInListOfDomains(String domainName) {
    return findByXpath(String.format("//table[@class='uiGrid table table-hover domain-table']//*[not(@class='domain-desc-col')]/div[contains(text(),'%s')]",
                                     domainName));
  }

  public void checkTheDomainNameDisplay(String domainName) {
    getDomainNameInListOfDomains(domainName).isVisibleAfterWaiting();
    getDomainNameInListOfDomains(domainName).clickOnElement();
  }

  public void editDomainName(String name) {
    editDomainIcon.isVisibleAfterWaiting();
    editDomainIcon.clickOnElement();
    editDomainForm.isVisibleAfterWaiting();
    editDomainNameField.clickOnElement();
    editDomainNameField.clear();
    editDomainNameField.setTextValue(name);
    confirmChangesBtn.clickOnElement();
    searchDomainInput.clear();
  }

  public void domainNameIsNotDisplayed(String domainName) {
    getDomainNameInListOfDomains(domainName).isNotVisibleAfterWaiting();
  }

  public void deleteDomain() {
    deleteBtn.clickOnElement();
  }

  public void goToAdministration() {
    menuBtn.clickOnElement();
    adminBtn.clickOnElement();
  }

  public void goToAutomaticTranslation() {
    automaticTranslation.clickOnElement();
  }

  public void checkTitlePageAutomaticTranslation(String title) {
    getTitlePage(title).isVisible();
  }

  public void checkAlertPublishingActivity(String alert) {
    getAlertPublishingActivity(alert).isVisible();
  }

  public void confirmDomainDeletion() {
    confirmDeletionBtn.isVisibleAfterWaiting();
    confirmDeletionBtn.clickOnElement();
    searchDomainInput.clear();
  }

}
