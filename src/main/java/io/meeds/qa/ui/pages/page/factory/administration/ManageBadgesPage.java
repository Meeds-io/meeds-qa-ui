package io.meeds.qa.ui.pages.page.factory.administration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ManageBadgesPage extends GenericPage {

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  private BaseElementFacade    menuBtn;

  @FindBy(xpath = "//i[contains(@class,'uiIcon uiIconToolbarNavItem uiAdministrationIcon')]")
  private BaseElementFacade    adminBtn;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/gamification/badges']")
  private BaseElementFacade    badgeLink;

  @FindBy(xpath = "//*[@class='alert alert-success']")
  private BaseElementFacade    successAlert;

  @FindBy(xpath = "//button[@class='btn btn-primary']")
  private BaseElementFacade    addBadgeBtn;

  @FindBy(xpath = "//a[@class='uiIconClose pull-right']")
  private BaseElementFacade    closeFormBtn;

  @FindBy(xpath = "(//input[@id='titleInput'])[1]")
  private TextBoxElementFacade badgeName;

  @FindBy(xpath = "//input[@name='keyword']")
  private TextBoxElementFacade searchBadgeInput;

  @FindBy(xpath = "(//*[@id='badgeDescription'])[1]")
  private TextBoxElementFacade badgeDescription;

  @FindBy(xpath = "(//*[@id='neededScoreInput'])[1]")
  private TextBoxElementFacade badgeScore;

  @FindBy(xpath = "(//*[@id='domainSelectboxGroup']//select)[1]")
  private TextBoxElementFacade selectBadgeDomain;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[1]")
  private BaseElementFacade    confirmAddBadgeBtn;

  @FindBy(xpath = "(//input[@id='titleInput'])[2]")
  private TextBoxElementFacade editBadgeName;

  @FindBy(xpath = "(//*[@id='badgeDescription'])[2]")
  private TextBoxElementFacade editBadgeDescription;

  @FindBy(xpath = "(//*[@id='neededScoreInput'])[2]")
  private TextBoxElementFacade editBadgeScore;

  @FindBy(xpath = "(//*[@id='domainSelectboxGroup']//select)[2]")
  private TextBoxElementFacade editSelectBadgeDomain;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[2]")
  private BaseElementFacade    confirmEditBadgeBtn;

  @FindBy(xpath = "(//button[@class='btn-primary pull-right'])[3]")
  private BaseElementFacade    confirmDeleteBadgeBtn;

  @FindBy(xpath = "//*[@class='msg' and contains(text(),'Are you sure you want to delete this badge ?')]")
  private BaseElementFacade    confirmDeleteBadgeMessage;

  public void goToManageBadgesMenu() {
    menuBtn.clickOnElement();
    adminBtn.clickOnElement();
    badgeLink.clickOnElement();

  }

  public void clickOnAddBadge() {
    addBadgeBtn.clickOnElement();

  }

  public void addBadgeName(String name) {
    badgeName.setTextValue(name);

  }

  public void addBadgeDescription(String description) {
    badgeDescription.setTextValue(description);

  }

  public void addBadgeScore(String score) {
    badgeScore.setTextValue(score);

  }

  public void addBadgeIcon(String icon) {
    WebElement elem = getDriver().findElement(By.xpath("//input[@id='iconInput']"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + icon).fromLocalMachine().to(elem);

  }

  public void addBadgeDomain(String domain) {
    selectBadgeDomain.selectByVisibleText(domain);

  }

  public void editBadgeName(String name) {
    editBadgeName.waitUntilVisible();
    editBadgeName.clear();
    editBadgeName.setTextValue(name);

  }

  public void editBadgeDescription(String description) {
    editBadgeDescription.waitUntilVisible();
    editBadgeDescription.clear();
    editBadgeDescription.setTextValue(description);

  }

  public void editBadgeScore(String score) {
    editBadgeScore.waitUntilVisible();
    editBadgeScore.clear();
    editBadgeScore.setTextValue(score);

  }

  public void editBadgeDomain(String domain) {
    editSelectBadgeDomain.waitUntilVisible();
    editSelectBadgeDomain.selectByVisibleText(domain);

  }

  public void confirmEditBadge() {
    confirmEditBadgeBtn.clickOnElement();

  }

  public void confirmDeletionBadge() {
    confirmDeleteBadgeMessage.isVisibleAfterWaiting();
    confirmDeleteBadgeBtn.clickOnElement();

  }

  public void clickOnEditBadge(String badgeName) {
    getBadgeEditButton(badgeName).clickOnElement();

  }

  public void clickOnDeleteBadge(String badgeName) {
    getBadgeDeleteButton(badgeName).clickOnElement();

  }

  public void isSuccessAlertDisplayed(String message) {
    Assert.assertTrue(successAlert.getText().contains(message));

  }

  public void fillForm(String name, String description, String score, String icon, String domain) {
    closeFormBtn.isVisibleAfterWaiting();
    addBadgeName(name);
    addBadgeDescription(description);
    addBadgeScore(score);
    addBadgeIcon(icon);
    addBadgeDomain(domain);

  }

  public void confirmAdditionNewBadge() {
    confirmAddBadgeBtn.clickOnElement();

  }

  private BaseElementFacade getBadgeEditButton(String badgeName) {
    return findByXpath(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='uiIconEdit uiIconLightGray'][1]",
                                     badgeName));

  }

  private BaseElementFacade getBadgeDeleteButton(String badgeName) {
    return findByXpath(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='uiIconDelete uiIconLightGray'][1]",
                                     badgeName));

  }

  private BaseElementFacade getBadgeNameInListOfBadges(String badgeName,
                                                       String badgeDescription,
                                                       String badgeScore,
                                                       String badgeDomain) {
    return findByXpath(String.format("//*[@id='iconInputGroup']//img/following::*[@class='badge-title-col']/div[contains(text(),'%s')]/following::*[@class='badge-desc-col']/div[contains(text(),'%s')]/following::*[@class='badge-needed-score-col']/div/div[contains(text(),'%s')]/following::*[contains(text(),'%s')]/following::*[@class='badge-status-col']//*[@class='slider round']",
                                     badgeName,
                                     badgeDescription,
                                     badgeScore,
                                     badgeDomain));

  }

  public void insertBadgeNameInSearchField(String badgeName) {
    searchBadgeInput.waitUntilVisible();
    if (searchBadgeInput.isNotVisibleAfterWaiting()) {
      driver.navigate().refresh();
    }
    searchBadgeInput.waitUntilVisible();
    searchBadgeInput.setTextValue(badgeName);

  }

  public void isBadgeDisplayedWithEnabledStatus(String badgeName,
                                                String badgeDescription,
                                                String badgeScore,
                                                String badgeDomain) {
    getBadgeNameInListOfBadges(badgeName, badgeDescription, badgeScore, badgeDomain).isVisibleAfterWaiting();
    Assert.assertTrue(getBadgeNameInListOfBadges(badgeName, badgeDescription, badgeScore, badgeDomain).getText().contains("Yes"));

  }

  public void isBadgeNotDisplayedWithEnabledStatus(String badgeName,
                                                   String badgeDescription,
                                                   String badgeScore,
                                                   String badgeDomain) {
    getBadgeNameInListOfBadges(badgeName, badgeDescription, badgeScore, badgeDomain).isNotVisibleAfterWaiting();

  }

}
