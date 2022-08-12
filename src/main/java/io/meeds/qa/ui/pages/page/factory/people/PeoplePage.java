package io.meeds.qa.ui.pages.page.factory.people;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PeoplePage extends GenericPage {

  public PeoplePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  private TextBoxElementFacade searchPeopleInput;

  @FindBy(xpath = "//*[@class='v-card__text peopleCardBody align-center pt-2 pb-1']//a")
  public BaseElementFacade     ELEMENT_ADD_CONTACT_FULLNAME;

  @FindBy(xpath = "//button[contains(text(),'OK')]")
  private TextBoxElementFacade okButton;

  @FindBy(xpath = "//*[@class='showingPeopleText text-sub-title ms-3 d-none d-sm-flex']")
  public TextBoxElementFacade  ELEMENT_PEOPLE_SHOWING_RESULTS;

  @FindBy(xpath = "//*[@id='usersLeaderboard']//*[@class='d-inline-block']")
  public TextBoxElementFacade  ELEMENT_LEADER_BOARD_TITLE;

  @FindBy(xpath = "//*[@class='d-inline peopleRelationshipButtonText' and contains(text(),'Disconnect')]")
  public TextBoxElementFacade  disconnectLabel;

  @FindBy(xpath = "(//*[@class='v-list-item__title']//a)[1]")
  public TextBoxElementFacade  ELEMENT_FIRST_USER_LEADER_BOARD_POSITION;

  @FindBy(xpath = "(//*[@class='v-list-item__title']//a)[2]")
  public TextBoxElementFacade  ELEMENT_SECOND_USER_LEADER_BOARD_POSITION;

  @FindBy(xpath = "(//*[@class='v-list-item__title']//a/following::*[@class='v-list-item__action me-4'])[1]")
  public TextBoxElementFacade  ELEMENT_FIRST_USER_LEADER_BOARD_POINTS;

  @FindBy(xpath = "(//*[@class='v-list-item__title']//a/following::*[@class='v-list-item__action me-4'])[2]")
  public TextBoxElementFacade  ELEMENT_SECOND_USER_LEADER_BOARD_POINTS;

  @FindBy(xpath = "//*[@class='v-avatar tertiary']")
  public TextBoxElementFacade  ELEMENT_CURRENT_USER_LEADER_BOARD_POSITION;

  @FindBy(xpath = "(//*[@class='v-input__prepend-inner']/following::*[@class='v-text-field__slot']/input/following::select)[1]")
  public TextBoxElementFacade  ELEMENT_PEOPLE_PULLDOWN_FILTER;

  @FindBy(xpath = "//*[@class='peopleAvatar']//*[@class='v-image__image v-image__image--cover']")
  public BaseElementFacade     ELEMENT_CONTACT_AVATAR;

  @FindBy(xpath = "(//*[@class='v-list-item__content pb-3']//a)[1]")
  public BaseElementFacade     ELEMENT_FIRST_SUGGESTION;

  @FindBy(xpath = "(//*[@class='v-list-item__content pb-3']//a)[2]")
  public BaseElementFacade     ELEMENT_SECOND_SUGGESTION;

  @FindBy(xpath = "//*[@class='peopleOverviewCard d-flex flex-column clickable']")
  public BaseElementFacade     ELEMENT_SENT_REQUESTS_BTN;

  @FindBy(xpath = "//*[@class='d-inline peopleRelationshipButtonText']")
  public BaseElementFacade     ELEMENT_ADD_CONTACT_TITLE;

  @FindBy(xpath = "//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light']")
  public BaseElementFacade     ELEMENT_CLOSE_SENT_REQUESTS_BTN;

  @FindBy(xpath = "(//*[@class='uiIconInviteUser'])[1]")
  public BaseElementFacade     ELEMENT_ADD_FIRST_USER_SUGGESTION;

  @FindBy(xpath = "(//*[@class='uiIconInviteUser'])[2]")
  public BaseElementFacade     ELEMENT_ADD_SECOND_USER_SUGGESTION;

  @FindBy(xpath = "(//*[@class='uiIconCloseCircled'])[1]")
  public BaseElementFacade     ELEMENT_DELETE_FIRST_SUGGESTION;

  @FindBy(xpath = "(//*[@class='uiIconCloseCircled'])[2]")
  public BaseElementFacade     ELEMENT_DELETE_SECOND_SUGGESTION;

  @FindBy(xpath = "//*[@class='peopleCardFront']/div/div/div[@class='v-image__image v-image__image--cover']")
  public BaseElementFacade     ELEMENT_ADD_CONTACT_COVER;

  @FindBy(xpath = "//*[@class='peopleCardFront']/div/div/div[@class='v-image__image v-image__image--cover']")
  public BaseElementFacade     ELEMENT_ADD_CONTACT_COVER_WIDTH;

  @FindBy(xpath = "//*[@class='v-card__subtitle userPositionLabel text-truncate py-0']")
  public BaseElementFacade     ELEMENT_ADD_CONTACT_JOB;

  @FindBy(xpath = "//*[@class='uiIconSocConnectUser']")
  public BaseElementFacade     connectUserProfile;

  private BaseElementFacade getConnectUserButton(String user) {
    return findByXpathOrCSS(String
                             .format("//a[contains(@href,'%s')]//following::i[contains(@class,'uiIconSocConnectUser')]", user));
  }

  private BaseElementFacade getDisconnectUserButton(String user) {
    return findByXpathOrCSS(String.format(
                                     "//a[contains(@href,'%s')]//following::i[contains(@class,'uiIconSocCancelConnectUser')]",
                                     user));
  }

  public BaseElementFacade ELEMENT_CURRENT_USER_LEADER_BOARD_POINTS(String id) {
    return findByXpathOrCSS(String
                             .format("(//*[@class='v-list-item__title']//a/following::*[@class='v-list-item__action me-4'])['%s']",
                                     id));
  }

  public BaseElementFacade ELEMENT_SENT_REQUESTS_USERS(String user) {
    return findByXpathOrCSS(String
                             .format("//*[@class='layout column']//*[@class='v-list-item__title']//a[contains(text(),'%s')]",
                                     user));
  }

  public BaseElementFacade ELEMENT_ADD_CONTACT_FULLNAM_WITH_PARAM(String user) {
    return findByXpathOrCSS(String
                             .format("//*[@class='v-card__text peopleCardBody align-center pt-2 pb-1']//a[contains(text(),'%s')]",
                                     user));
  }

  public BaseElementFacade ELEMENT_DELETE_SENT_REQUESTS_USERS(String user) {
    return findByXpathOrCSS(String
                             .format("//*[@class='layout column']//*[@class='v-list-item__title']//a[contains(text(),'%s')]/following::button[1]",
                                     user));
  }

  private BaseElementFacade getUserProfileButton(String user) {
    return findByXpathOrCSS(String.format("//a[contains(@href,'%s')and contains(@class,'userFullname')]", user));
  }

  private BaseElementFacade getUserMenu(String user) {
    return findByXpathOrCSS(
                       String.format("//a[contains(@href,'%s')]/../..//button[contains(@class,'peopleMenuIcon')]", user));
  }

  public void checkConnectToUser(String user) {
    getDriver().navigate().refresh();
    searchPeopleInput.waitUntilVisible();
    searchPeopleInput.sendKeys(user);
    if (getDisconnectUserButton(user).isVisibleAfterWaiting() && disconnectLabel.isVisibleAfterWaiting()) {
      getDisconnectUserButton(user).clickOnElement();
      okButton.clickOnElement();
      getDisconnectUserButton(user).waitUntilNotVisible();
      getConnectUserButton(user).waitUntilVisible();
    }

    if (getDisconnectUserButton(user).isVisibleAfterWaiting() && disconnectLabel.isNotVisibleAfterWaiting()) {
      getDisconnectUserButton(user).clickOnElement();
      getConnectUserButton(user).waitUntilVisible();
    }

    getConnectUserButton(user).clickOnElement();
    getConnectUserButton(user).waitUntilNotVisible();
  }

  public void goToUserProfile(String user) {
    searchPeopleInput.setTextValue(user);
    getUserProfileButton(user).clickOnElement();
  }

  public void connectUserProfile() {
    getDriver().navigate().refresh();
    connectUserProfile.waitUntilVisible();
    connectUserProfile.clickOnElement();
  }

  public void checkThatFilterIsDisplayed() {
    // Check that Filter is displayed
    searchPeopleInput.isDisplayed();
    Assert.assertEquals(searchPeopleInput.getAttribute("placeholder"), "Filter by name, position or skill");
  }

}
