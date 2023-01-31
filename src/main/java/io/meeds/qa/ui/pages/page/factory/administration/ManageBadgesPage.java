package io.meeds.qa.ui.pages.page.factory.administration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ManageBadgesPage extends GenericPage {

  @FindBy(xpath = "//button[@class='btn btn-primary']")
  private BaseElementFacade    addBadgeBtn;

  @FindBy(xpath = "//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'fa fa-arrow')]")
  private BaseElementFacade    adminBtn;

  @FindBy(xpath = "(//*[@id='badgeDescription'])[1]")
  private TextBoxElementFacade badgeDescription;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/gamification/badges']")
  private BaseElementFacade    badgeLink;

  @FindBy(xpath = "(//input[@id='titleInput'])[1]")
  private TextBoxElementFacade badgeName;

  @FindBy(xpath = "(//*[@id='neededScoreInput'])[1]")
  private TextBoxElementFacade badgeScore;

  @FindBy(xpath = "//a[@class='uiIconClose pull-right']")
  private BaseElementFacade    closeFormBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[1]")
  private BaseElementFacade    confirmAddBadgeBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[3]")
  private BaseElementFacade    confirmDeleteBadgeBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[2]")
  private BaseElementFacade    confirmEditBadgeBtn;

  @FindBy(xpath = "(//*[@id='badgeDescription'])[2]")
  private TextBoxElementFacade editBadgeDescription;

  @FindBy(xpath = "(//input[@id='titleInput'])[2]")
  private TextBoxElementFacade editBadgeName;

  @FindBy(xpath = "(//*[@id='neededScoreInput'])[2]")
  private TextBoxElementFacade editBadgeScore;

  @FindBy(xpath = "(//*[@id='domainSelectboxGroup']//select)[2]")
  private TextBoxElementFacade editSelectBadgeDomain;

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  private BaseElementFacade    menuBtn;

  @FindBy(xpath = "//input[@name='keyword']")
  private TextBoxElementFacade searchBadgeInput;

  @FindBy(xpath = "(//*[@id='domainSelectboxGroup']//select)[1]")
  private TextBoxElementFacade selectBadgeDomain;

  @FindBy(xpath = "//*[@class='alert alert-success']")
  private BaseElementFacade    successAlert;

  @FindBy(xpath = "//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'titleIcon')]")
  private BaseElementFacade       adminIcon;

  public void addBadgeDescription(String description) {
    badgeDescription.setTextValue(description);

  }

  public void addBadgeDomain(String domain) {
    selectBadgeDomain.selectByVisibleText(domain);

  }

  public void addBadgeIcon(String icon) {
    WebElement elem = getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='iconInput']"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + icon).fromLocalMachine().to(elem);

  }

  public void addBadgeName(String name) {
    badgeName.setTextValue(name);

  }

  public void addBadgeScore(String score) {
    badgeScore.setTextValue(score);

  }

  public void clickOnAddBadge() {
    addBadgeBtn.clickOnElement();

  }

  public void clickOnDeleteBadge(String badgeName) {
    getBadgeDeleteButton(badgeName).clickOnElement();

  }

  public void clickOnEditBadge(String badgeName) {
    getBadgeEditButton(badgeName).clickOnElement();

  }

  public void confirmAdditionNewBadge() {
    confirmAddBadgeBtn.clickOnElement();

  }

  public void confirmDeletionBadge() {
    confirmDeleteBadgeBtn.waitUntilClickable();
    confirmDeleteBadgeBtn.clickOnElement();
  }

  public void confirmEditBadge() {
    confirmEditBadgeBtn.clickOnElement();

  }

  public void editBadgeDescription(String description) {
    editBadgeDescription.waitUntilVisible();
    editBadgeDescription.clear();
    editBadgeDescription.setTextValue(description);

  }

  public void editBadgeDomain(String domain) {
    editSelectBadgeDomain.waitUntilVisible();
    editSelectBadgeDomain.selectByVisibleText(domain);

  }

  public void editBadgeName(String name) {
    editBadgeName.waitUntilVisible();
    editBadgeName.clear();
    editBadgeName.setTextValue(name);

  }

  public void editBadgeScore(String score) {
    editBadgeScore.waitUntilVisible();
    editBadgeScore.clear();
    editBadgeScore.setTextValue(score);

  }

  public void fillForm(String name, String description, String score, String icon, String domain) {
    closeFormBtn.waitUntilVisible();
    addBadgeName(name);
    addBadgeDescription(description);
    addBadgeScore(score);
    addBadgeIcon(icon);
    addBadgeDomain(domain);

  }

  private BaseElementFacade getBadgeDeleteButton(String badgeName) {
    return findByXPathOrCSS(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='uiIconDelete uiIconLightGray'][1]",
                                          badgeName));

  }

  private BaseElementFacade getBadgeEditButton(String badgeName) {
    return findByXPathOrCSS(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='uiIconEdit uiIconLightGray'][1]",
                                          badgeName));

  }

  private BaseElementFacade getBadgeNameInListOfBadges(String badgeName,
                                                       String badgeDescription,
                                                       String badgeScore,
                                                       String badgeDomain) {
    return findByXPathOrCSS(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='badge-desc-col']/div[contains(text(),'%s')]/following::*[@class='badge-needed-score-col']/div/div[contains(text(),'%s')]/following::*[contains(text(),'%s')]/following::*[@class='badge-status-col']//*[@class='slider round']",
                                          badgeName,
                                          badgeDescription,
                                          badgeScore,
                                          badgeDomain));

  }

  public void goToManageBadgesMenu() {
    menuBtn.clickOnElement();
    adminIcon.hover();
    adminBtn.waitUntilVisible();
    adminBtn.clickOnElement();
    badgeLink.clickOnElement();
  }

  public void insertBadgeNameInSearchField(String badgeName) {
    searchBadgeInput.waitUntilVisible();
    if (searchBadgeInput.isNotVisibleAfterWaiting()) {
      getDriver().navigate().refresh();
    }
    searchBadgeInput.waitUntilVisible();
    searchBadgeInput.setTextValue(badgeName);
    waitForSearchToLoad();
  }

  public void isBadgeDisplayedWithEnabledStatus(String badgeName,
                                                String badgeDescription,
                                                String badgeScore,
                                                String badgeDomain) {
    BaseElementFacade badgeElement = getBadgeNameInListOfBadges(badgeName, badgeDescription, badgeScore, badgeDomain);
    assertWebElementVisible(badgeElement);
    Assert.assertTrue(badgeElement.getText().contains("Yes")); // NOSONAR
  }

  public void isBadgeNotDisplayedWithEnabledStatus(String badgeName,
                                                   String badgeDescription,
                                                   String badgeScore,
                                                   String badgeDomain) {
    BaseElementFacade badgeElement = getBadgeNameInListOfBadges(badgeName, badgeDescription, badgeScore, badgeDomain);
    assertWebElementNotVisible(badgeElement);
  }

  public void isSuccessAlertDisplayed(String message) {
    assertWebElementVisible(successAlert);
    Assert.assertTrue(successAlert.getText().contains(message)); // NOSONAR
  }

  private void waitForSearchToLoad() {
    findByXPathOrCSS("(//*[contains(@class, 'badge-table')]//tr)[3]").waitUntilNotVisible();
  }

}
