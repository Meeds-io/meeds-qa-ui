package io.meeds.qa.ui.pages.page.factory.engagement;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ChallengesPage extends GenericPage {
  private static final String IDENTITY_SUGGESTER_ELEMENT = "//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]";

  public ChallengesPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "(//*[@class='v-toolbar__content']//*[contains(@class,'d-lg-inline')])[01]")
  private BaseElementFacade addChallengeBtn;

  public void checkAddChallengeBtn() {
    addChallengeBtn.isVisibleAfterWaiting();
  }

  public void isAddChallengeBtnDisplayed() {
    addChallengeBtn.shouldNotBeVisible();
  }

  @FindBy(xpath = "//*[contains(@class ,'v-list-item__content drawerTitle')]")
  private BaseElementFacade    headerChallengeDrawer;

  @FindBy(xpath = "//*[contains(@class,'challenge-title')]//textarea")
  private TextBoxElementFacade challengeTitleField;

  @FindBy(xpath = "(//div[@name='challengeSpaceAutocomplete']//input)[01]")
  private TextBoxElementFacade audienceSpaceField;

  @FindBy(xpath = "(//div[@class='v-select__selections']//input)[02]")
  private TextBoxElementFacade programField;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[1]//input")
  private TextBoxElementFacade startDateField;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[2]//input")
  private TextBoxElementFacade endDateField;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade    ckEditorFrameChallenge;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade challengeDescriptionField;

  @FindBy(
      xpath = "//*[@class='v-form']//following::*[@class='flex drawerFooter border-box-sizing flex-grow-0 px-4 py-3']//button[2]"
  )
  private BaseElementFacade    createButton;

  public void clickAddChallengeBtn() {
    addChallengeBtn.waitUntilVisible();
    addChallengeBtn.clickOnElement();
  }

  public void checkAddChallengeDrawer() {
    headerChallengeDrawer.shouldBeVisible();
  }

  public void enterChallengeTitle(String challengeTitle) {
    challengeTitleField.setTextValue(challengeTitle);
  }

  public void addSpaceAudience(String randomSpaceName) {
    audienceSpaceField.waitUntilVisible();
    audienceSpaceField.setTextValue(randomSpaceName + " ");
    waitFor(100).milliseconds();
    audienceSpaceField.sendKeys(Keys.BACK_SPACE);
    waitFor(100).milliseconds();
    audienceSpaceField.sendKeys(Keys.BACK_SPACE);
    waitFor(100).milliseconds();
    BaseElementFacade audienceSuggester = getSelectSpaceInDropDown(randomSpaceName);
    audienceSuggester.waitUntilVisible();
    audienceSuggester.clickOnElement();
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

  private BaseElementFacade getSelectDomainInDropDown(String programName) {
    BaseElementFacade domainSelection = findByXPathOrCSS(String.format(
                                                                       IDENTITY_SUGGESTER_ELEMENT,
                                                                       programName));
    domainSelection.setImplicitTimeout(Duration.ofSeconds(10));
    domainSelection.waitUntilVisible();
    domainSelection.waitUntilClickable();
    return domainSelection;
  }

  public void addProgramName(String programName) {
    programField.setTextValue(programName + " ");
    waitFor(100).milliseconds();
    programField.sendKeys(Keys.BACK_SPACE);
    waitFor(100).milliseconds();
    BaseElementFacade programSuggester = getSelectDomainInDropDown(programName);
    programSuggester.clickOnElement();
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

  @SwitchToWindow
  public void addChallengeWithDescription(String description) {
    clickOnElement(ckEditorFrameChallenge);
    driver.switchTo().frame(ckEditorFrameChallenge);
    try {
      challengeDescriptionField.waitUntilVisible();
      challengeDescriptionField.setTextValue(description);
    } finally {
      driver.switchTo().defaultContent();
    }
    createButton.clickOnElement();
  }

  private BaseElementFacade getChallengeSuccessMessage(String message) {
    return findByXPathOrCSS(String.format("//div[@class='v-alert__content']//*[contains(text(),'%s')]", message));
  }

  public void checkSuccessMessage(String message) {
    getChallengeSuccessMessage(message).isVisibleAfterWaiting();
  }

  private BaseElementFacade getChallengeCardTitle(String title) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'subtitleChallenge') and contains(text(),'%s')]", title));
  }

  public void checkChallengeCardTitle(String title) {
    getChallengeCardTitle(title).isVisibleAfterWaiting();
  }

  public void enterRandomChallengeTitle(String challengeName) {
    challengeTitleField.setTextValue(challengeName);
  }

  @SwitchToWindow
  public void addChallengeWithRandomDescription(String challengeDescription) {
    ckEditorFrameChallenge.waitUntilVisible();
    ckEditorFrameChallenge.clickOnElement();
    driver.switchTo().frame(ckEditorFrameChallenge);
    try {
      challengeDescriptionField.waitUntilVisible();
      challengeDescriptionField.setTextValue(challengeDescription);
    } finally {
      driver.switchTo().defaultContent();
    }
    createButton.clickOnElement();
  }

  public void checkTitleDisplayOnCard(String title) {
    getChallengeCardTitle(title).isVisibleAfterWaiting();
  }

  @FindBy(xpath = "//*[contains(@class,'me-2 v-btn v-btn--flat v-btn--icon v-btn--round')]")
  private BaseElementFacade threeDotsIcon;

  public void checkThreeDotsIconDisplay(String title) {
    getChallengeCardTitle(title).isVisibleAfterWaiting();
    threeDotsIcon.shouldBeVisible();
  }

  @FindBy(xpath = "//*[@class='v-btn__content' and contains(text(),'Announce')]")
  private BaseElementFacade announceBtn;

  public void checkAnnounceBtn(String title) {
    getChallengeCardTitle(title).isVisibleAfterWaiting();
    announceBtn.shouldBeVisible();
  }

  @FindBy(xpath = "//*[@class='date']")
  private BaseElementFacade dateField;

  public void checkDateField(String title) {
    getChallengeCardTitle(title).isVisibleAfterWaiting();
    dateField.shouldBeVisible();
  }

  public void clickAnnounceBtn() {
    announceBtn.clickOnElement();
  }

  @FindBy(xpath = "(//*[@class='v-list-item__content drawerTitle align-start text-header-title text-truncate'])[2]")
  private BaseElementFacade announcementHeaderDrawer;

  public void checkAnnouncementDrawer() {
    announcementHeaderDrawer.shouldBeVisible();
  }

  @FindBy(xpath = "//a[@class='challengeAssignBtn align-end']")
  private BaseElementFacade    assignLink;

  @FindBy(
      xpath = "(//*[@class='d-flex mr-2']//button[2])[2]"
  )
  private BaseElementFacade    createAnnouncement;

  @FindBy(xpath = "(//div[@name='challengeSpaceAutocomplete']//input)[01]")
  private TextBoxElementFacade assignAnnouncementInput;

  @SwitchToWindow
  public void addAnnouncementWithRandomDescription(String announcementDescription) {
    ckEditorFrameChallenge.clickOnElement();
    driver.switchTo().frame(ckEditorFrameChallenge);
    try {
      challengeDescriptionField.waitUntilVisible();
      challengeDescriptionField.setTextValue(announcementDescription);
    } finally {
      driver.switchTo().defaultContent();
    }
    createAnnouncement.waitUntilVisible();
    createAnnouncement.clickOnElement();

  }

  private BaseElementFacade getSelectWinnerInDropDown(String secondUserName) {
    return findByXPathOrCSS(String.format(IDENTITY_SUGGESTER_ELEMENT,
                                          secondUserName));
  }

  public void assignChallengeToSecondUser(String user) {
    assignLink.isVisibleAfterWaiting();
    assignLink.clickOnElement();
    assignAnnouncementInput.setTextValue(user + " ");
    assignAnnouncementInput.sendKeys(Keys.BACK_SPACE);
    getSelectWinnerInDropDown(user).clickOnElement();
  }

  private BaseElementFacade getAnnouncementActivityTopBar(String user, String space) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'accountTitleLabel')][1]//*[contains(@id,'userAvatar')and contains(@href,'%s')]/following::*[contains(@id,'spaceAvatar') and contains(text(),'%s')])[1]",
                                          user,
                                          space));
  }

  public void checkAnnouncementActivityTopBar(String user, String space) {
    getAnnouncementActivityTopBar(user, space).isVisibleAfterWaiting();

  }

  private BaseElementFacade getWinnerNameOnAnnouncement(String user) {
    return findByXPathOrCSS(String.format("//*[@class='font-weight-bold text-color mx-0 mt-0 mb-2 text-wrap text-break text-truncate-2']/a[contains(@href,'%s')]",
                                          user));
  }

  public void checkWinnerNameOnAnnouncement(String user) {
    getWinnerNameOnAnnouncement(user).isVisibleAfterWaiting();
  }

  private BaseElementFacade getChallengeTitleOnAnnouncement(String name) {
    return findByXPathOrCSS(String.format("//*[@class='caption text-wrap text-break rich-editor-content reset-style-box text-light-color text-truncate-3']/a[contains(text(),'%s')]",
                                          name));
  }

  public void checkChallengeTitleOnAnnouncement(String name) {
    getChallengeTitleOnAnnouncement(name).isVisibleAfterWaiting();
  }

  private BaseElementFacade getAchievementDescriptionOnAnnouncement(String description) {
    return findByXPathOrCSS(String.format("//*[contains(@class,' postContent')]/*[contains(text(),'%s')]", description));
  }

  public void checkAchievementDescriptionOnAnnouncement(String description) {
    getAchievementDescriptionOnAnnouncement(description).isVisibleAfterWaiting();
  }

}
