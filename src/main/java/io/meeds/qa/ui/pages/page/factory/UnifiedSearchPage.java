package io.meeds.qa.ui.pages.page.factory;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class UnifiedSearchPage extends GenericPage {
  public UnifiedSearchPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id='SearchApplication']//i[contains(@class,'fa-search')]//ancestor::button")
  public static BaseElementFacade    toolbarSearchButton;

  @FindBy(xpath = "//*[@id='SearchApplication']//input[@id = 'searchInput']")
  public static TextBoxElementFacade searchInput;

  @FindBy(xpath = "//*[@class='v-responsive v-image appImage']")
  public static BaseElementFacade    ELEMENT_APPLICATION_SEARCH_PICTURE;

  @FindBy(xpath = "(//*[@class='v-list-item__content']//*[@class='v-list-item__title'])[1]")
  public static BaseElementFacade    ELEMENT_ACCESS_TO_SEARCHED_ACTIVITY;

  private BaseElementFacade ELEMENT_USER_SEARCH_TITLE(String user) {
    return findByXPathOrCSS(String.format("//*[@id='searchDialog']//a[@title='%s']", user));
  }

  private BaseElementFacade ELEMENT_APPLICATION_SEARCH_TITLE(String appName) {
    return findByXPathOrCSS(String.format("//*[@title='%s']", appName));
  }

  private BaseElementFacade ELEMENT_SPACE_SEARCH_TITLE(String space) {
    return findByXPathOrCSS(String.format("//*[@class='spaceCardFront']//*[contains(text(),'%s')]", space));
  }

  private BaseElementFacade ELEMENT_ACTIVITY_SEARCH_TITLE(String activity) {
    return findByXPathOrCSS(String.format("//*[@class='searchMatchExcerpt' and text()='%s']", activity));
  }

  public boolean isSearchedActivityTitleVisible(String activity) {
    return ELEMENT_ACTIVITY_SEARCH_TITLE(activity).isVisibleAfterWaiting();
  }

  public boolean isSearchedUserNameVisible(String user) {
    return ELEMENT_USER_SEARCH_TITLE(user).isVisibleAfterWaiting();
  }

  public boolean isSearchedApplicationPictureVisible() {
    return ELEMENT_APPLICATION_SEARCH_PICTURE.isVisibleAfterWaiting();
  }

  private BaseElementFacade ELEMENT_APPLICATION_SEARCH_DESCRIPTION(String appDesc) {
    return findByXPathOrCSS(String.format("//*[@title='%s']", appDesc));
  }

  public boolean isSearchedSpaceNameVisible(String space) {
    return ELEMENT_SPACE_SEARCH_TITLE(space).isVisibleAfterWaiting();
  }

  public boolean isSearchedApplicationNameVisible(String appName) {
    return ELEMENT_APPLICATION_SEARCH_TITLE(appName).isVisibleAfterWaiting();
  }

  public boolean isSearchedApplicationDescriptionVisible(String appDesc) {
    return ELEMENT_APPLICATION_SEARCH_DESCRIPTION(appDesc).isVisibleAfterWaiting();
  }

  public void goToTheSearchedSpace(String space) {
    ELEMENT_SPACE_SEARCH_TITLE(space).clickOnElement();
  }

  public void goToTheSearchedApplication(String appName) {
    ELEMENT_APPLICATION_SEARCH_TITLE(appName).clickOnElement();
  }

  public void goToTheSearchedActivity() {
    ELEMENT_ACCESS_TO_SEARCHED_ACTIVITY.clickOnElement();
  }

  @FindBy(
      xpath = "//*[contains(@class, 'searchConnectorsParent')]//i[contains(@class, 'fa-star')]//ancestor::*[contains(@class, 'v-chip--clickable')]"
  )
  private BaseElementFacade favoritesBtn;

  public void clickFavoriteBtn() {
    verifyPageLoaded();
    favoritesBtn.waitUntilVisible();
    favoritesBtn.waitUntilClickable();
    favoritesBtn.clickOnElement();
    verifyPageLoaded();
  }

  public boolean isSearchedActivityTitleNotVisible(String activity) {
    return ELEMENT_ACTIVITY_SEARCH_TITLE(activity).isNotVisibleAfterWaiting();
  }

  private BaseElementFacade getFavoriteIconSearchedActivity(String activity) {
    return findByXPathOrCSS(String.format(
                                          "(//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'searchCard')]//*[contains(@class, 'fa-star')])[1]",
                                          activity));
  }

  public void favoriteSearchedActivity(String activity) {
    getFavoriteIconSearchedActivity(activity).clickOnElement();
    toolbarSearchButton.hover(); // A trick to hover outside user popover to be
                                 // closed
  }

  @FindBy(xpath = "//span[@class='me-8' and contains(text(),'All')]")
  private BaseElementFacade shipFormAll;

  private BaseElementFacade getObjectFromDropDown(String object) {
    return findByXPathOrCSS(String.format("//div[@class='v-input--selection-controls__input']//preceding::span[@class='subtitle-1'and contains(text(),'%s')]",
                                          object));
  }

  public void selectDropDown(String object) {
    shipFormAll.clickOnElement();
    getObjectFromDropDown(object).clickOnElement();

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

}
