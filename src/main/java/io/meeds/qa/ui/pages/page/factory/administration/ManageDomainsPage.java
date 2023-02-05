package io.meeds.qa.ui.pages.page.factory.administration;

import static org.junit.Assert.assertTrue;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ManageDomainsPage extends GenericPage {

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  public static ElementFacade menuBtn;

  @FindBy(xpath = "//button[@class='btn btn-primary']")
  private ElementFacade       addDomainBtn;

  @FindBy(xpath = "//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'fa fa-arrow')]")
  private ElementFacade       adminBtn;

  @FindBy(xpath = "//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'titleIcon')]")
  private ElementFacade       adminIcon;
  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/automatic-translation']")
  private ElementFacade       automaticTranslation;

  @FindBy(xpath = "//button[@class='btn cancel pull-right']")
  public ElementFacade        closeConfirmDeletionPopup;

  @FindBy(xpath = "//a[@class='uiIconClose pull-right']")
  private ElementFacade       closeFormBtn;

  @FindBy(xpath = "//button[@class='btn-primary pull-right']")
  private ElementFacade       confirmBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[2]")
  private ElementFacade       confirmChangesBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[2]")
  public ElementFacade        confirmDeletionBtn;

  @FindBy(xpath = "//i[@class='uiIconDelete uiIconLightGray']")
  public ElementFacade        deleteBtn;

  @FindBy(xpath = "//*[@id='domainDescription']")
  private TextBoxElementFacade    domainDescription;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/gamification/domains']")
  private ElementFacade       domainLink;

  @FindBy(xpath = "//input[@id='titleInput']")
  private TextBoxElementFacade    domainName;

  @FindBy(xpath = "(//span[@class='PopupTitle popupTitle'])[2]")
  private TextBoxElementFacade    editDomainForm;

  @FindBy(xpath = "//i[@class='uiIconEdit uiIconLightGray']")
  private TextBoxElementFacade    editDomainIcon;

  @FindBy(xpath = "(//input[@id='titleInput'])[2]")
  private TextBoxElementFacade    editDomainNameField;

  @FindBy(xpath = "//input[@name='keyword']")
  private TextBoxElementFacade    searchDomainInput;

  public void addDomain() {
    addDomainBtn.clickOnElement();
  }

  public void addDomainDescription(String description) {
    domainDescription.setTextValue(description);

  }

  public void addDomainName(String name) {
    domainName.setTextValue(name);
  }

  public void checkAlertPublishingActivity(String alert) {
    assertTrue(getAlertPublishingActivity(alert).isVisible());
  }

  public void checkTheDomainNameDisplay(String domainName) {
    ElementFacade domainElement = getDomainNameInListOfDomains(domainName);
    domainElement.waitUntilVisible();
    domainElement.clickOnElement();
  }

  public void checkTitlePageAutomaticTranslation(String title) {
    assertTrue(getTitlePage(title).isVisible());
  }

  public void confirmDomain() {
    confirmBtn.clickOnElement();
  }

  public void confirmDomainDeletion() {
    confirmDeletionBtn.waitUntilVisible();
    confirmDeletionBtn.clickOnElement();
    searchDomainInput.clear();
  }

  public void deleteDomain() {
    deleteBtn.clickOnElement();
  }

  public void domainNameIsNotDisplayed(String domainName) {
    assertWebElementNotVisible(getDomainNameInListOfDomains(domainName));
  }

  public void editDomainName(String name) {
    editDomainIcon.waitUntilVisible();
    editDomainIcon.clickOnElement();
    editDomainForm.waitUntilVisible();
    editDomainNameField.clickOnElement();
    editDomainNameField.clear();
    editDomainNameField.setTextValue(name);
    confirmChangesBtn.clickOnElement();
    searchDomainInput.clear();
  }

  public void fillForm(String name, String description) {
    closeFormBtn.waitUntilVisible();
    addDomainName(name);
    addDomainDescription(description);
  }

  private ElementFacade getAlertPublishingActivity(String alert) {
    return findByXPathOrCSS(
                            String.format("//*[@class='v-btn__content' and contains(text(),'%s')]", alert));
  }

  private ElementFacade getDomainNameInListOfDomains(String domainName) {
    return findByXPathOrCSS(String.format("//table[@class='uiGrid table table-hover domain-table']//*[not(@class='domain-desc-col')]/div[contains(text(),'%s')]",
                                          domainName));
  }

  public ElementFacade getTitlePage(String title) {
    return findByXPathOrCSS(String.format("//*[@class='row']//h4[@class='font-weight-bold' and contains(text(),'%s')]", title));
  }

  public void goToAdministration() {
    menuBtn.clickOnElement();
    adminBtn.clickOnElement();
  }

  public void goToAutomaticTranslation() {
    automaticTranslation.clickOnElement();
  }

  public void goToManageDomainMenu() {
    menuBtn.clickOnElement();
    adminIcon.hover();
    adminBtn.waitUntilVisible();
    adminBtn.clickOnElement();
    domainLink.clickOnElement();
  }

  public void insertDomainNameInSearchField(String domainName) {
    searchDomainInput.waitUntilVisible();
    if (searchDomainInput.isNotVisibleAfterWaiting()) {
      getDriver().navigate().refresh();
    }
    searchDomainInput.waitUntilVisible();
    searchDomainInput.setTextValue(domainName);
  }

}
