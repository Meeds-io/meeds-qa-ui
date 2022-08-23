package io.meeds.qa.ui.pages.page.factory.engagement;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ChallengesPage extends GenericPage {

  private static final String  CHALLENGE_CARD_ANNOUNCE_BUTTON_XPATH = "//button[contains(@class, 'btnAdd')]";

  private static final String  CHALLENGE_CARD_DATE_XPATH            = "//*[contains(@class, 'date')]";

  private static final String  CHALLENGE_CARD_THREE_DOTS_XPATH      = "//*[contains(@class ,'fa-ellipsis-v')]//ancestor::button";

  private static final String  CHALLENGE_CARD_TITLE_XPATH           = "//*[contains(text(),'%s')]"
      + "//ancestor::*[contains(@class, 'cardOfChallenge')]";

  private static final String  IDENTITY_SUGGESTER_ELEMENT           = "//div[contains(@class,'identitySuggestionMenuItemText') "
      + "and contains(text(),'%s')]";

  @FindBy(css = ".challenges-application .addChallengeButton button.btn-primary")
  private BaseElementFacade    addChallengeBtn;

  @FindBy(css = "#announcementDrawer.v-navigation-drawer--open")
  private BaseElementFacade    announcementHeaderDrawer;

  @FindBy(xpath = "(//div[@name='challengeSpaceAutocomplete']//input)[01]")
  private TextBoxElementFacade assignAnnouncementInput;

  @FindBy(xpath = "//a[@class='challengeAssignBtn align-end']")
  private BaseElementFacade    assignLink;

  @FindBy(xpath = "(//*[contains(@class, 'v-navigation-drawer--open')]//div[@name='challengeSpaceAutocomplete']//input)[01]")
  private TextBoxElementFacade audienceSpaceField;

  @FindBy(css = "body.cke_editable_themed")
  private TextBoxElementFacade challengeDescriptionField;

  @FindBy(css = ".challengeQuickFilter")
  private BaseElementFacade    challengeQuickFilterSelectBox;

  @FindBy(css = ".v-navigation-drawer--open .challenge-title textarea")
  private TextBoxElementFacade challengeTitleField;

  @FindBy(css = ".v-navigation-drawer--open iframe.cke_wysiwyg_frame")
  private BaseElementFacade    ckEditorFrameChallenge;

  @FindBy(css = ".v-navigation-drawer--open .drawerFooter button.btn-primary")
  private BaseElementFacade    createAnnouncement;

  @FindBy(css = ".v-navigation-drawer--open .drawerFooter button.btn-primary")
  private BaseElementFacade    createButton;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[2]//input")
  private TextBoxElementFacade endDateField;

  @FindBy(css = ".challengeDrawer.v-navigation-drawer--open")
  private BaseElementFacade    headerChallengeDrawer;

  @FindBy(
      xpath = "(//*[contains(@class, 'v-navigation-drawer--open')]//div[contains(@class, 'v-select__selections')]//input)[02]"
  )
  private TextBoxElementFacade programField;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[1]//input")
  private TextBoxElementFacade startDateField;

  public ChallengesPage(WebDriver driver) {
    super(driver);
  }

  @SwitchToWindow
  public void addAnnouncementWithRandomDescription(String announcementDescription) {
    ckEditorFrameChallenge.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameChallenge);
    try {
      challengeDescriptionField.waitUntilVisible();
      challengeDescriptionField.setTextValue(announcementDescription);
    } finally {
      driver.switchTo().defaultContent();
    }
    clickCreateAnnouncementButton();
  }

  @SwitchToWindow
  public void addChallengeWithDescription(String description) {
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ckEditorFrameChallenge.waitUntilVisible();
      driver.switchTo().frame(ckEditorFrameChallenge);
    }, driver.switchTo()::defaultContent);
    try {
      challengeDescriptionField.waitUntilVisible();
      challengeDescriptionField.setTextValue(description);
    } finally {
      driver.switchTo().defaultContent();
    }
    clickCreateChallengeButton();
  }

  @SwitchToWindow
  public void addChallengeWithRandomDescription(String challengeDescription) {
    ckEditorFrameChallenge.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameChallenge);
    try {
      challengeDescriptionField.waitUntilVisible();
      challengeDescriptionField.setTextValue(challengeDescription);
    } finally {
      driver.switchTo().defaultContent();
    }
    clickCreateChallengeButton();
  }

  @SwitchToWindow
  public void addProgramName(String programName) {
    programField.setTextValue(programName + " ");
    waitFor(100).milliseconds();
    programField.sendKeys(Keys.BACK_SPACE);
    waitFor(100).milliseconds();
    BaseElementFacade programSuggester = getSelectDomainInDropDown(programName);
    programSuggester.clickOnElement();
  }

  @SwitchToWindow
  public void addSpaceAudience(String randomSpaceName) {
    audienceSpaceField.waitUntilVisible();
    audienceSpaceField.setTextValue(randomSpaceName + " ");
    waitFor(100).milliseconds();
    audienceSpaceField.sendKeys(Keys.BACK_SPACE);
    waitFor(200).milliseconds();
    audienceSpaceField.sendKeys(Keys.BACK_SPACE);
    waitFor(200).milliseconds();
    BaseElementFacade audienceSuggester = getSelectSpaceInDropDown(randomSpaceName);
    audienceSuggester.waitUntilVisible();
    audienceSuggester.clickOnElement();
  }

  @SwitchToWindow
  public void assignChallengeToUser(String user) {
    assertWebElementVisible(assignLink);
    assignLink.clickOnElement();
    assignAnnouncementInput.setTextValue(user + " ");
    assignAnnouncementInput.sendKeys(Keys.BACK_SPACE);
    getSelectWinnerInDropDown(user).clickOnElement();
  }

  public void checkAchievementDescriptionOnAnnouncement(String description) {
    assertWebElementVisible(getAchievementDescriptionOnAnnouncement(description));
  }

  public void checkAddChallengeBtn() {
    assertWebElementVisible(addChallengeBtn); // NOSONAR
  }

  public void checkAddChallengeBtnNotDispayed() {
    assertWebElementNotVisible(addChallengeBtn);
  }

  public void checkAddChallengeDrawer() {
    assertWebElementVisible(headerChallengeDrawer);
  }

  public void checkAnnounceBtn(String title) {
    assertWebElementVisible(getChallengeCardTitle(title));
    assertWebElementVisible(getChallengeCardAnnounceButton(title));
  }

  public void checkAnnouncementActivity(String posterPrefix,
                                        String winnerPrefix,
                                        String challengeName,
                                        String announcementDescription) {
    assertTrue(getAnnouncementActivity(posterPrefix,
                                       winnerPrefix,
                                       challengeName,
                                       announcementDescription).isVisibleAfterWaiting());

  }

  public void checkAnnouncementDrawer() {
    assertWebElementVisible(announcementHeaderDrawer);
  }

  public void checkChallengeCardTitle(String title) {
    assertWebElementVisible(getChallengeCardTitle(title));
  }

  public void checkChallengeTitleOnAnnouncement(String name) {
    assertWebElementVisible(getChallengeTitleOnAnnouncement(name));
  }

  public void checkDateField(String title) {
    assertWebElementVisible(getChallengeCardTitle(title));
    assertWebElementVisible(getChallengeCardDate(title));
  }

  public void checkNoChallengeCardTitle(String title) {
    assertWebElementNotVisible(getChallengeCardTitle(title));
  }

  public void checkSuccessMessage(String message) {
    assertWebElementVisible(getChallengeSuccessMessage(message));
  }

  public void checkThreeDotsIconDisplay(String title) {
    assertWebElementVisible(getChallengeCardTitle(title));
    assertWebElementVisible(getChallengeCardThreeDots(title));
  }

  public void checkTitleDisplayOnCard(String title) {
    assertWebElementVisible(getChallengeCardTitle(title));
  }

  public void clickAddChallengeBtn() {
    addChallengeBtn.waitUntilVisible();
    addChallengeBtn.clickOnElement();
  }

  public void clickAnnounceBtn(String title) {
    getChallengeCardAnnounceButton(title).clickOnElement();
  }

  public void clickCreateAnnouncementButton() {
    createAnnouncement.waitUntilVisible();
    createAnnouncement.clickOnElement();
  }

  public void clickCreateChallengeButton() {
    createButton.clickOnElement();
  }

  public void enterChallengeTitle(String challengeTitle) {
    challengeTitleField.setTextValue(challengeTitle);
  }

  public void enterRandomChallengeTitle(String challengeName) {
    challengeTitleField.setTextValue(challengeName);
  }

  private BaseElementFacade getAchievementDescriptionOnAnnouncement(String description) {
    return findByXPathOrCSS(String.format("//*[contains(@class,' postContent')]/*[contains(text(),'%s')]", description));
  }

  private BaseElementFacade getAnnouncementActivity(String posterPrefix,
                                                    String winnerPrefix,
                                                    String challengeName,
                                                    String announcementDescription) {
    String posterXPath =
                       "//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'activity-head')]//ancestor::*[contains(@class, 'activity-detail')]";
    String winnerXPath =
                       "//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'activity-thumbnail-box')]//ancestor::*[contains(@class, 'activity-detail')]";
    String challengeNameXPath =
                              "//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'activity-thumbnail-box')]//ancestor::*[contains(@class, 'activity-detail')]";
    String announcementXPath = "//*[contains(@class,'postContent')]//*[contains(text(),'%s')]";
    String announcementActivityFormatXPath = posterXPath + winnerXPath + challengeNameXPath + announcementXPath;
    return findByXPathOrCSS(String.format(announcementActivityFormatXPath,
                                          posterPrefix,
                                          winnerPrefix,
                                          challengeName,
                                          announcementDescription));
  }

  private BaseElementFacade getChallengeCardAnnounceButton(String title) {
    return findByXPathOrCSS(String.format(CHALLENGE_CARD_TITLE_XPATH + CHALLENGE_CARD_ANNOUNCE_BUTTON_XPATH, title));
  }

  private BaseElementFacade getChallengeCardDate(String title) {
    return findByXPathOrCSS(String.format(CHALLENGE_CARD_TITLE_XPATH + CHALLENGE_CARD_DATE_XPATH, title));
  }

  private BaseElementFacade getChallengeCardThreeDots(String title) {
    return findByXPathOrCSS(String.format(CHALLENGE_CARD_TITLE_XPATH + CHALLENGE_CARD_THREE_DOTS_XPATH, title));
  }

  private BaseElementFacade getChallengeCardTitle(String title) {
    return findByXPathOrCSS(String.format(CHALLENGE_CARD_TITLE_XPATH, title));
  }

  private BaseElementFacade getChallengeSuccessMessage(String message) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", message));
  }

  private BaseElementFacade getChallengeTitleOnAnnouncement(String name) {
    return findByXPathOrCSS(String.format("//*[@class='caption text-wrap text-break rich-editor-content reset-style-box text-light-color text-truncate-3']/a[contains(text(),'%s')]",
                                          name));
  }

  private BaseElementFacade getSelectDomainInDropDown(String programName) {
    BaseElementFacade domainSelection = findByXPathOrCSS(String.format(
                                                                       IDENTITY_SUGGESTER_ELEMENT,
                                                                       programName));
    domainSelection.setImplicitTimeout(Duration.ofSeconds(10));
    domainSelection.waitUntilVisible();
    domainSelection.waitUntilClickable();
    return domainSelection;
  }

  private BaseElementFacade getSelectSpaceInDropDown(String spaceName) {
    BaseElementFacade spaceSuggester = findByXPathOrCSS(String.format(
                                                                      IDENTITY_SUGGESTER_ELEMENT,
                                                                      spaceName));
    spaceSuggester.setImplicitTimeout(Duration.ofSeconds(10));
    spaceSuggester.resetTimeouts();
    spaceSuggester.waitUntilVisible();
    spaceSuggester.waitUntilClickable();
    return spaceSuggester;
  }

  private BaseElementFacade getSelectWinnerInDropDown(String secondUserName) {
    return findByXPathOrCSS(String.format(IDENTITY_SUGGESTER_ELEMENT,
                                          secondUserName));
  }

  @SwitchToWindow
  public void selectChallengesFilter(String value) {
    challengeQuickFilterSelectBox.clickOnElement();
    challengeQuickFilterSelectBox.selectByValue(value);
    challengeQuickFilterSelectBox.clickOnElement();
    verifyPageLoaded();
  }

  public void selectEndDateNextWeek() {
    endDateField.waitUntilVisible();
    endDateField.clickOnElement();
    waitFor(200).milliseconds();
    BaseElementFacade endDateNextWeek =
                                      findByXPathOrCSS("(//*[contains(@class,'v-date-picker-table__current')])[2]/following::td[7]");
    endDateNextWeek.waitUntilVisible();
    clickOnElement(endDateNextWeek);
    endDateNextWeek.waitUntilNotVisible();
    endDateField.waitUntilClickable();
  }

  public void selectEndDateTomorrow() {
    endDateField.waitUntilVisible();
    endDateField.clickOnElement();
    waitFor(200).milliseconds();
    BaseElementFacade endDateTomorrow =
                                      findByXPathOrCSS("(//*[contains(@class,'v-date-picker-table__current')])[2]/following::td[1]");
    endDateTomorrow.waitUntilVisible();
    clickOnElement(endDateTomorrow);
    endDateTomorrow.waitUntilNotVisible();
    endDateField.waitUntilClickable();
  }

  public void selectStartDateToday() {
    startDateField.waitUntilVisible();
    startDateField.clickOnElement();
    waitFor(200).milliseconds();
    BaseElementFacade startDateToday = findByXPathOrCSS("(//*[contains(@class,'v-date-picker-table__current')])[1]");
    startDateToday.waitUntilVisible();
    clickOnElement(startDateToday);
    startDateToday.waitUntilNotVisible();
    startDateField.waitUntilClickable();
  }

  public void selectStartDateTomorrow() {
    startDateField.waitUntilVisible();
    startDateField.clickOnElement();
    waitFor(200).milliseconds();
    BaseElementFacade startDateTomorrow =
                                        findByXPathOrCSS("(//*[contains(@class,'v-date-picker-table__current')])[1]/following::td[1]");
    startDateTomorrow.waitUntilVisible();
    clickOnElement(startDateTomorrow);
    startDateTomorrow.waitUntilNotVisible();
    startDateField.waitUntilClickable();
  }

}
