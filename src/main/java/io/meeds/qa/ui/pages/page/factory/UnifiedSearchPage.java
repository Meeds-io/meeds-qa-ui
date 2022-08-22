package io.meeds.qa.ui.pages.page.factory;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class UnifiedSearchPage extends GenericPage {
  @FindBy(xpath = "(//*[@class='v-list-item__content']//*[@class='v-list-item__title'])[1]")
  private BaseElementFacade    elementAccessToSearchedActivity;

  @FindBy(xpath = "//*[@class='v-responsive v-image appImage']")
  private BaseElementFacade    elementApplicationSearchPicture;

  @FindBy(xpath = "//*[@id='SearchApplication']//input[@id = 'searchInput']")
  private TextBoxElementFacade searchInput;

  @FindBy(xpath = "//*[@id='SearchApplication']//i[contains(@class,'fa-search')]//ancestor::button")
  private BaseElementFacade    toolbarSearchButton;

  @FindBy(
      xpath = "//*[contains(@class, 'searchConnectorsParent')]//i[contains(@class, 'fa-star')]//ancestor::*[contains(@class, 'v-chip--clickable')]"
  )
  private BaseElementFacade    favoritesBtn;

  @FindBy(xpath = "//span[@class='me-8' and contains(text(),'All')]")
  private BaseElementFacade    shipFormAll;

  public UnifiedSearchPage(WebDriver driver) {
    super(driver);
  }

  public void clickFavoriteBtn() {
    verifyPageLoaded();
    favoritesBtn.waitUntilVisible();
    favoritesBtn.waitUntilClickable();
    favoritesBtn.clickOnElement();
    verifyPageLoaded();
  }

  private BaseElementFacade getActivitySearchTitle(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s') or contains(@title, '%s')]//ancestor::*[contains(@class, 'searchCard')]",
                                          activity,
                                          activity));
  }

  private BaseElementFacade getApplicationSearchDescription(String appDesc) {
    return findByXPathOrCSS(String.format("//*[@title='%s']", appDesc));
  }

  private BaseElementFacade getApplicationSearchTitle(String appName) {
    return findByXPathOrCSS(String.format("//*[@title='%s']", appName));
  }

  private BaseElementFacade getSpaceSearchTitle(String space) {
    return findByXPathOrCSS(String.format("//*[@class='spaceCardFront']//*[contains(text(),'%s')]", space));
  }

  private BaseElementFacade getUserSearchTitle(String user) {
    return findByXPathOrCSS(String.format("//*[@id='searchDialog']//a[@title='%s']", user));
  }

  public void favoriteSearchedActivity(String activity) {
    getFavoriteIconSearchedActivity(activity).clickOnElement();
    toolbarSearchButton.hover(); // A trick to hover outside user popover to be
                                 // closed
  }

  private BaseElementFacade getFavoriteIconSearchedActivity(String activity) {
    return findByXPathOrCSS(String.format(
                                          "(//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'searchCard')]//*[contains(@class, 'fa-star')])[1]",
                                          activity));
  }

  private BaseElementFacade getObjectFromDropDown(String object) {
    return findByXPathOrCSS(String.format("//div[@class='v-input--selection-controls__input']//preceding::span[@class='subtitle-1'and contains(text(),'%s')]",
                                          object));
  }

  public void goToTheSearchedActivity() {
    elementAccessToSearchedActivity.clickOnElement();
  }

  public void goToTheSearchedApplication(String appName) {
    getApplicationSearchTitle(appName).clickOnElement();
  }

  public void goToTheSearchedSpace(String space) {
    getSpaceSearchTitle(space).clickOnElement();
  }

  public void isSearchedActivityTitleNotVisible(String activity) {
    retryOnCondition(() -> assertWebElementNotVisible(getActivitySearchTitle(activity)), () -> {
      waitFor(1).seconds(); // The element can be not indexed yet
      refreshPage();
    });
  }

  public void isSearchedActivityTitleVisible(String activity) {
    retryOnCondition(() -> assertWebElementVisible(getActivitySearchTitle(activity)), () -> {
      waitFor(1).seconds(); // The element can be not indexed yet
      refreshPage();
    });
  }

  public void isSearchedApplicationDescriptionVisible(String appDesc) {
    assertWebElementVisible(getApplicationSearchDescription(appDesc));
  }

  public void isSearchedApplicationNameVisible(String appName) {
    assertWebElementVisible(getApplicationSearchTitle(appName));
  }

  public void isSearchedApplicationPictureVisible() {
    assertWebElementVisible(elementApplicationSearchPicture);
  }

  public void isSearchedSpaceNameVisible(String space) {
    assertWebElementVisible(getSpaceSearchTitle(space));
  }

  public void isSearchedUserNameVisible(String user) {
    assertWebElementVisible(getUserSearchTitle(user));
  }

  public void openSearchApplication() {
    toolbarSearchButton.waitUntilVisible();
    toolbarSearchButton.clickOnElement();
  }

  public void search(String text) {
    openSearchApplication();
    searchInput.setTextValue(text);
    waitFor(300).milliseconds(); // Wait for search to be used
    verifyPageLoaded();
  }

  public void selectDropDown(String object) {
    shipFormAll.clickOnElement();
    getObjectFromDropDown(object).clickOnElement();

  }

}
