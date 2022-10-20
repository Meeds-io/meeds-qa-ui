package io.meeds.qa.ui.pages.page.factory.engagement;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertTrue;

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

  @FindBy(xpath = "//*[@id='engagementCenterAddChallengeBtn']")
  private BaseElementFacade    addChallengeBtn;

  @FindBy(css = "#announcementDrawer.v-navigation-drawer--open")
  private BaseElementFacade    announcementHeaderDrawer;

  @FindBy(xpath = "//*[contains(@content-class,'identitySuggester')]")
  private TextBoxElementFacade assignAnnouncementInput;

  @FindBy(xpath = "//*[@id='EngagementCenterAssignmentBtn']")
  private BaseElementFacade    assignLink;

  @FindBy(xpath = "(//*[contains(@class, 'v-navigation-drawer--open')]//div[@name='challengeSpaceAutocomplete']//input)[01]")
  private TextBoxElementFacade audienceSpaceField;

  @FindBy(css = "body.cke_editable_themed")
  private TextBoxElementFacade challengeDescriptionField;

  @FindBy(css = ".challengeQuickFilter")
  private BaseElementFacade    challengeQuickFilterSelectBox;

  @FindBy(xpath = "//*[@id='EngagementCenterChallengeDrawerTitleTextArea']")
  private TextBoxElementFacade challengeTitleField;

  @FindBy(css = ".v-navigation-drawer--open iframe.cke_wysiwyg_frame")
  private BaseElementFacade    ckEditorFrameChallenge;

  @FindBy(css = ".v-navigation-drawer--open .drawerFooter button.btn-primary")
  private BaseElementFacade    createAnnouncement;

  @FindBy(css = ".v-navigation-drawer--open .drawerFooter button.btn-primary")
  private BaseElementFacade    createButton;

  @FindBy(xpath = "//*[@id='engagementCenterChallengeEndDatePicker']")
  private TextBoxElementFacade endDateField;

  @FindBy(xpath = "//*[@id='EngagementCenterChallengeDrawer']")
  private BaseElementFacade    headerChallengeDrawer;

  @FindBy(xpath = "(//*[contains(@class, 'v-navigation-drawer--open')]//div[contains(@class, 'v-select__selections')]//input)[02]")
  private TextBoxElementFacade programField;

  @FindBy(xpath = "//*[@id='engagementCenterChallengeStartDatePicker']")
  private TextBoxElementFacade startDateField;

  @FindBy(xpath="//*[@id='EngagementCenterApplication']")
  public BaseElementFacade engagementCenterApplication ;

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
    mentionInField(programField, programName, 5);
  }

  @SwitchToWindow
  public void addSpaceAudience(String randomSpaceName) {
    mentionInField(audienceSpaceField, randomSpaceName, 5);
  }

  @SwitchToWindow
  public void assignChallengeToUser(String user) {
    assertWebElementVisible(assignLink);
    assignLink.clickOnElement();
    assertWebElementVisible(findByXPathOrCSS("//*[contains(@content-class,'identitySuggester')]"));
    findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]").sendKeys(user);
    selectUser(user).clickOnElement();
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
    BaseElementFacade announcementActivityElement = getAnnouncementActivity(posterPrefix,
                                                                            winnerPrefix,
                                                                            challengeName,
                                                                            announcementDescription);
    assertWebElementVisible(announcementActivityElement);
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
                                      findByXPathOrCSS("//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table__current')]/following::td[7]");
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
                                      findByXPathOrCSS("//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table__current')]/following::td[1]");
    endDateTomorrow.waitUntilVisible();
    clickOnElement(endDateTomorrow);
    endDateTomorrow.waitUntilNotVisible();
    endDateField.waitUntilClickable();
  }

  public void selectStartDateToday() {
    startDateField.waitUntilVisible();
    startDateField.clickOnElement();
    waitFor(200).milliseconds();
    BaseElementFacade startDateToday =
                                     findByXPathOrCSS("//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table__current')]");
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
                                        findByXPathOrCSS("//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table__current')]/following::td[1]");
    startDateTomorrow.waitUntilVisible();
    clickOnElement(startDateTomorrow);
    startDateTomorrow.waitUntilNotVisible();
    startDateField.waitUntilClickable();
  }

  public void checkAddChallengeBtnNotDisplayed() {
    assertWebElementNotVisible(addChallengeBtn);
  }

  public void isEngagementAppOpened() {
    assertWebElementVisible(engagementCenterApplication);
  }

  public void selectEngagementTab(String tab) {
    clickOnElement(getEngagementTab(tab));
    verifyPageLoaded();
    waitFor(300).milliseconds(); // Wait for Tab switch
  }

  private BaseElementFacade getEngagementTab(String tab) {
    return findByXPathOrCSS(String.format("//*[@id='engagementCenterTabs']//*[contains(text(),'%s')]", tab));
  }

  private BaseElementFacade selectUser(String user)
  {
    return findByXPathOrCSS(String.format("//*[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]", user));
  }
}
