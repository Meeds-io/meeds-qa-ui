package io.meeds.qa.ui.pages.page.factory.administration;

import static org.junit.Assert.assertTrue;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ManageDomainsPage extends GenericPage {

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  public static BaseElementFacade menuBtn;

  @FindBy(xpath = "//button[@class='btn btn-primary']")
  private BaseElementFacade       addDomainBtn;

  @FindBy(xpath = "//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'uiArrowRightIcon')]")
  private BaseElementFacade       adminBtn;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/automatic-translation']")
  private BaseElementFacade       automaticTranslation;

  @FindBy(xpath = "//button[@class='btn cancel pull-right']")
  public BaseElementFacade        closeConfirmDeletionPopup;

  @FindBy(xpath = "//a[@class='uiIconClose pull-right']")
  private BaseElementFacade       closeFormBtn;

  @FindBy(xpath = "//button[@class='btn-primary pull-right']")
  private BaseElementFacade       confirmBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[2]")
  private BaseElementFacade       confirmChangesBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[2]")
  public BaseElementFacade        confirmDeletionBtn;

  @FindBy(xpath = "//i[@class='uiIconDelete uiIconLightGray']")
  public BaseElementFacade        deleteBtn;

  @FindBy(xpath = "//*[@id='domainDescription']")
  private TextBoxElementFacade    domainDescription;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/gamification/domains']")
  private BaseElementFacade       domainLink;

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
    BaseElementFacade domainElement = getDomainNameInListOfDomains(domainName);
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

  private BaseElementFacade getAlertPublishingActivity(String alert) {
    return findByXPathOrCSS(
                            String.format("//*[@class='v-btn__content' and contains(text(),'%s')]", alert));
  }

  private BaseElementFacade getDomainNameInListOfDomains(String domainName) {
    return findByXPathOrCSS(String.format("//table[@class='uiGrid table table-hover domain-table']//*[not(@class='domain-desc-col')]/div[contains(text(),'%s')]",
                                          domainName));
  }

  public BaseElementFacade getTitlePage(String title) {
    return findByXPathOrCSS(String.format("//*[@class='row']//h4[@class='font-weight-bold' and contains(text(),'%s')]", title));
  }

  public void goToAdministration() {
    menuBtn.clickOnElement();
    adminBtn.clickOnElement();
  }

  public void goToAutomaticTranslation() {
    automaticTranslation.clickOnElement();
  }

  @SwitchToWindow
  public void goToManageDomainMenu() {
    menuBtn.clickOnElement();
    adminBtn.clickOnElement();
    domainLink.clickOnElement();
  }

  public void insertDomainNameInSearchField(String domainName) {
    searchDomainInput.waitUntilVisible();
    if (searchDomainInput.isNotVisibleAfterWaiting()) {
      driver.navigate().refresh();
    }
    searchDomainInput.waitUntilVisible();
    searchDomainInput.setTextValue(domainName);
  }

}
