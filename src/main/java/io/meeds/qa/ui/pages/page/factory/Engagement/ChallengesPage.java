package io.meeds.qa.ui.pages.page.factory.Engagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ChallengesPage extends GenericPage {
  public ChallengesPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@class='v-toolbar__content']//*[contains(@class,'d-lg-inline')]")
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

  @FindBy(xpath = "(//div[@class='v-input__control']//input)[03]")
  private TextBoxElementFacade programField;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[1]//input")
  private TextBoxElementFacade startDateField;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[2]//input")
  private TextBoxElementFacade endDateField;

  @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[1]/following::td[1]")
  private TextBoxElementFacade startDateTomorrow;

  @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table')])[2]/following::td[7]")
  private TextBoxElementFacade endDateNextWeek;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade    ckEditorFrameChallenge;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade challengeDescriptionField;

  @FindBy(
      xpath = "//*[@class='v-form']//following::*[@class='flex drawerFooter border-box-sizing flex-grow-0 px-4 py-3']//button[2]"
  )
  private BaseElementFacade    createButton;

  @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[1]")
  private TextBoxElementFacade startDateToday;

  @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[2]/following::td[1]")
  private TextBoxElementFacade endDateTomorrow;

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
    if (audienceSpaceField.isNotVisibleAfterWaiting()) {
      Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    }
    audienceSpaceField.waitUntilVisible();
    audienceSpaceField.setTextValue(randomSpaceName + " ");
    audienceSpaceField.sendKeys(Keys.BACK_SPACE);
    getSelectSpaceInDropDown(randomSpaceName).clickOnElement();
  }

  private BaseElementFacade getSelectSpaceInDropDown(String spaceName) {
    return findByXpath(String.format(
                                     "//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                                     spaceName));
  }

  private BaseElementFacade getSelectDomainInDropDown(String programName) {
    return findByXpath(String.format(
                                     "//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                                     programName));
  }

  public void addProgramName(String programName) {
    programField.setTextValue(programName + " ");
    programField.sendKeys(Keys.BACK_SPACE);
    getSelectDomainInDropDown(programName).clickOnElement();
  }

  public void selectStartDateTomorrow() {
    startDateField.clickOnElement();
    startDateTomorrow.clickOnElement();
  }

  public void selectEndDateNextWeek() {
    endDateField.clickOnElement();
    endDateNextWeek.clickOnElement();
  }

  public void addChallengeWithDescription(String description) {
    ckEditorFrameChallenge.clickOnElement();
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameChallenge);
    challengeDescriptionField.waitUntilVisible();
    challengeDescriptionField.setTextValue(description);
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    createButton.clickOnElement();
  }

  private BaseElementFacade getChallengeSuccessMessage(String message) {
    return findByXpath(String.format("//div[@class='v-alert__content']//*[contains(text(),'%s')]", message));
  }

  public void checkSuccessMessage(String message) {
    getChallengeSuccessMessage(message).isVisibleAfterWaiting();
  }

  public void selectStartDateToday() {
    startDateField.clickOnElement();
    startDateToday.clickOnElement();
  }

  public void addSpaceAudienceWithSecondUser(String secondRandomSpaceName) {
    audienceSpaceField.waitUntilVisible();
    audienceSpaceField.setTextValue(secondRandomSpaceName + " ");
    audienceSpaceField.sendKeys(Keys.BACK_SPACE);
    getSelectSpaceInDropDown(secondRandomSpaceName).clickOnElement();
  }

  private BaseElementFacade getChallengeCardTitle(String title) {
    return findByXpath(String.format("//*[contains(@class,'subtitleChallenge') and contains(text(),'%s')]", title));
  }

  public void checkChallengeCardTitle(String title) {
    getChallengeCardTitle(title).isVisibleAfterWaiting();
  }

  public void enterRandomChallengeTitle(String challengeName) {
    challengeTitleField.setTextValue(challengeName);
  }

  public void addChallengeWithRandomDescription(String challengeDescription) {
    ckEditorFrameChallenge.clickOnElement();
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameChallenge);
    challengeDescriptionField.waitUntilVisible();
    challengeDescriptionField.setTextValue(challengeDescription);
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    createButton.clickOnElement();
  }

  public void selectEndDateTomorrow() {
    endDateField.clickOnElement();
    endDateTomorrow.clickOnElement();
  }

  public void checkTitleDisplayOnCard(String title) {
    getChallengeCardTitle(title).isVisibleAfterWaiting();
  }

  @FindBy(xpath = "//*[contains(@class,'ml-2 v-btn v-btn--flat v-btn--icon')]")
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

  @FindBy(xpath = "(//*[@class='v-list-item__content drawerTitle align-start text-header-title text-truncate'])[1]")
  private BaseElementFacade announcementHeaderDrawer;

  public void checkAnnouncementDrawer() {
    announcementHeaderDrawer.shouldBeVisible();
  }

  @FindBy(xpath = "//a[@class='challengeAssignBtn align-end']")
  private BaseElementFacade    assignLink;

  @FindBy(
      xpath = "//*[@class='flex drawerContent flex-grow-1 overflow-auto border-box-sizing']//following::*[@class='flex drawerFooter border-box-sizing flex-grow-0 px-4 py-3']//button[2]"
  )
  private BaseElementFacade    createAnnouncement;

  @FindBy(xpath = "(//div[@name='challengeSpaceAutocomplete']//input)[01]")
  private TextBoxElementFacade assignAnnouncementInput;

  public void addAnnouncementWithRandomDescription(String announcementDescription) {
    ckEditorFrameChallenge.clickOnElement();
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameChallenge);
    challengeDescriptionField.waitUntilVisible();
    challengeDescriptionField.setTextValue(announcementDescription);
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    createAnnouncement.clickOnElement();

  }

  private BaseElementFacade getSelectWinnerInDropDown(String secondUserName) {
    return findByXpath(String.format("//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
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
    return findByXpath(String.format("(//*[contains(@class,'accountTitleLabel')][1]//*[contains(@id,'userAvatar')and contains(@href,'%s')]/following::*[contains(@id,'spaceAvatar') and contains(text(),'%s')])[1]",
                                     user,
                                     space));
  }

  public void checkAnnouncementActivityTopBar(String user, String space) {
    getAnnouncementActivityTopBar(user, space).isVisibleAfterWaiting();

  }

  private BaseElementFacade getWinnerNameOnAnnouncement(String user) {
    return findByXpath(String.format("//*[@class='font-weight-bold text-color mx-0 mt-0 mb-2 text-wrap text-break text-truncate-2']/a[contains(@href,'%s')]",
                                     user));
  }

  public void checkWinnerNameOnAnnouncement(String user) {
    getWinnerNameOnAnnouncement(user).isVisibleAfterWaiting();
  }

  private BaseElementFacade getChallengeTitleOnAnnouncement(String name) {
    return findByXpath(String.format("//*[@class='caption text-wrap text-break rich-editor-content reset-style-box text-light-color text-truncate-3']/a[contains(text(),'%s')]",
                                     name));
  }

  public void checkChallengeTitleOnAnnouncement(String name) {
    getChallengeTitleOnAnnouncement(name).isVisibleAfterWaiting();
  }

  private BaseElementFacade getAchievementDescriptionOnAnnouncement(String description) {
    return findByXpath(String.format("//*[contains(@class,' postContent')]/*[contains(text(),'%s')]", description));
  }

  public void checkAchievementDescriptionOnAnnouncement(String description) {
    getAchievementDescriptionOnAnnouncement(description).isVisibleAfterWaiting();
  }

}
