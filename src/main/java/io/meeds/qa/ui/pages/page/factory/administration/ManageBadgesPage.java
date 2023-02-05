package io.meeds.qa.ui.pages.page.factory.administration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class ManageBadgesPage extends GenericPage {

  public void addBadgeDescription(String description) {
    badgeDescriptionElement().setTextValue(description);

  }

  public void addBadgeDomain(String domain) {
    selectBadgeDomainElement().selectByVisibleText(domain);

  }

  public void addBadgeIcon(String icon) {
    WebElement elem = getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='iconInput']"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + icon).fromLocalMachine().to(elem);

  }

  public void addBadgeName(String name) {
    badgeNameElement().setTextValue(name);

  }

  public void addBadgeScore(String score) {
    badgeScoreElement().setTextValue(score);

  }

  public void clickOnAddBadge() {
    addBadgeBtnElement().clickOnElement();

  }

  public void clickOnDeleteBadge(String badgeName) {
    getBadgeDeleteButton(badgeName).clickOnElement();

  }

  public void clickOnEditBadge(String badgeName) {
    getBadgeEditButton(badgeName).clickOnElement();

  }

  public void confirmAdditionNewBadge() {
    confirmAddBadgeBtnElement().clickOnElement();

  }

  public void confirmDeletionBadge() {
    ElementFacade confirmDeleteBadgeBtnElement = confirmDeleteBadgeBtnElement();
    confirmDeleteBadgeBtnElement.waitUntilClickable();
    confirmDeleteBadgeBtnElement.clickOnElement();
  }

  public void confirmEditBadge() {
    confirmEditBadgeBtnElement().clickOnElement();

  }

  public void editBadgeDescription(String description) {
    TextBoxElementFacade editBadgeDescriptionElement = editBadgeDescriptionElement();
    editBadgeDescriptionElement.waitUntilVisible();
    editBadgeDescriptionElement.clear();
    editBadgeDescriptionElement.setTextValue(description);

  }

  public void editBadgeDomain(String domain) {
    TextBoxElementFacade editSelectBadgeDomainElement = editSelectBadgeDomainElement();
    editSelectBadgeDomainElement.waitUntilVisible();
    editSelectBadgeDomainElement.selectByVisibleText(domain);

  }

  public void editBadgeName(String name) {
    TextBoxElementFacade editBadgeNameElement = editBadgeNameElement();
    editBadgeNameElement.waitUntilVisible();
    editBadgeNameElement.clear();
    editBadgeNameElement.setTextValue(name);

  }

  public void editBadgeScore(String score) {
    TextBoxElementFacade editBadgeScoreElement = editBadgeScoreElement();
    editBadgeScoreElement.waitUntilVisible();
    editBadgeScoreElement.clear();
    editBadgeScoreElement.setTextValue(score);

  }

  public void fillForm(String name, String description, String score, String icon, String domain) {
    closeFormBtnElement().waitUntilVisible();
    addBadgeName(name);
    addBadgeDescription(description);
    addBadgeScore(score);
    addBadgeIcon(icon);
    addBadgeDomain(domain);

  }

  public void goToManageBadgesMenu() {
    menuBtnElement().clickOnElement();
    adminIconElement().hover();
    ElementFacade adminBtnElement = adminBtnElement();
    adminBtnElement.waitUntilVisible();
    adminBtnElement.clickOnElement();
    badgeLinkElement().clickOnElement();
  }

  public void insertBadgeNameInSearchField(String badgeName) {
    TextBoxElementFacade searchBadgeInputElement = searchBadgeInputElement();
    searchBadgeInputElement.waitUntilVisible();
    if (searchBadgeInputElement.isNotVisibleAfterWaiting()) {
      refreshPage();
    }
    searchBadgeInputElement = searchBadgeInputElement();
    searchBadgeInputElement.waitUntilVisible();
    searchBadgeInputElement.setTextValue(badgeName);
    waitForSearchToLoad();
  }

  public void isBadgeDisplayedWithEnabledStatus(String badgeName,
                                                String badgeDescription,
                                                String badgeScore,
                                                String badgeDomain) {
    ElementFacade badgeElement = getBadgeNameInListOfBadges(badgeName, badgeDescription, badgeScore, badgeDomain);
    assertWebElementVisible(badgeElement);
    Assert.assertTrue(badgeElement.getText().contains("Yes")); // NOSONAR
  }

  public void isBadgeNotDisplayedWithEnabledStatus(String badgeName,
                                                   String badgeDescription,
                                                   String badgeScore,
                                                   String badgeDomain) {
    ElementFacade badgeElement = getBadgeNameInListOfBadges(badgeName, badgeDescription, badgeScore, badgeDomain);
    assertWebElementNotVisible(badgeElement);
  }

  public void isSuccessAlertDisplayed(String message) {
    assertWebElementVisible(successAlertElement());
    Assert.assertTrue(successAlertElement().getText().contains(message)); // NOSONAR
  }

  private ElementFacade addBadgeBtnElement() {
    return findByXPathOrCSS("//button[@class='btn btn-primary']");
  }

  private ElementFacade adminBtnElement() {
    return findByXPathOrCSS("//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'fa fa-arrow')]");
  }

  private ElementFacade adminIconElement() {
    return findByXPathOrCSS("//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'titleIcon')]");
  }

  private TextBoxElementFacade badgeDescriptionElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='badgeDescription'])[1]");
  }

  private ElementFacade badgeLinkElement() {
    return findByXPathOrCSS("//a[@href='/portal/g/:platform:administrators/gamification/badges']");
  }

  private TextBoxElementFacade badgeNameElement() {
    return findTextBoxByXPathOrCSS("(//input[@id='titleInput'])[1]");
  }

  private TextBoxElementFacade badgeScoreElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='neededScoreInput'])[1]");
  }

  private ElementFacade closeFormBtnElement() {
    return findByXPathOrCSS("//a[@class='uiIconClose pull-right']");
  }

  private ElementFacade confirmAddBadgeBtnElement() {
    return findByXPathOrCSS("(//button[@class='btn-primary pull-right'])[1]");
  }

  private ElementFacade confirmDeleteBadgeBtnElement() {
    return findByXPathOrCSS("(//button[@class='btn-primary pull-right'])[3]");
  }

  private ElementFacade confirmEditBadgeBtnElement() {
    return findByXPathOrCSS("(//button[@class='btn-primary pull-right'])[2]");
  }

  private TextBoxElementFacade editBadgeDescriptionElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='badgeDescription'])[2]");
  }

  private TextBoxElementFacade editBadgeNameElement() {
    return findTextBoxByXPathOrCSS("(//input[@id='titleInput'])[2]");
  }

  private TextBoxElementFacade editBadgeScoreElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='neededScoreInput'])[2]");
  }

  private TextBoxElementFacade editSelectBadgeDomainElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='domainSelectboxGroup']//select)[2]");
  }

  private ElementFacade getBadgeDeleteButton(String badgeName) {
    return findByXPathOrCSS(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='uiIconDelete uiIconLightGray'][1]",
                                          badgeName));

  }

  private ElementFacade getBadgeEditButton(String badgeName) {
    return findByXPathOrCSS(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='uiIconEdit uiIconLightGray'][1]",
                                          badgeName));

  }

  private ElementFacade getBadgeNameInListOfBadges(String badgeName,
                                                   String badgeDescription,
                                                   String badgeScore,
                                                   String badgeDomain) {
    return findByXPathOrCSS(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='badge-desc-col']/div[contains(text(),'%s')]/following::*[@class='badge-needed-score-col']/div/div[contains(text(),'%s')]/following::*[contains(text(),'%s')]/following::*[@class='badge-status-col']//*[@class='slider round']",
                                          badgeName,
                                          badgeDescription,
                                          badgeScore,
                                          badgeDomain));

  }

  private ElementFacade menuBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'HamburgerNavigationMenuLink')]");
  }

  private TextBoxElementFacade searchBadgeInputElement() {
    return findTextBoxByXPathOrCSS("//input[@name='keyword']");
  }

  private TextBoxElementFacade selectBadgeDomainElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='domainSelectboxGroup']//select)[1]");
  }

  private ElementFacade successAlertElement() {
    return findByXPathOrCSS("//*[@class='alert alert-success']");
  }

  private void waitForSearchToLoad() {
    findByXPathOrCSS("(//*[contains(@class, 'badge-table')]//tr)[3]").waitUntilNotVisible();
  }

}
