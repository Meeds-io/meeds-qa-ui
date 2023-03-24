package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class ChallengesPage extends GenericPage {

  public ChallengesPage(WebDriver driver) {
    super(driver);
  }

  public void saveChallenge(String challengeName,
                            String challengeDescription,
                            String challengeProgram,
                            String challengePoints,
                            boolean changeDates) {
    setChallengeTitle(challengeName);
    setChallengeProgram(challengeProgram);
    if (changeDates) {
      setChallengeStartDate();
      setChallengeEndDate();
    }
    setChallengePoints(challengePoints);
    setChallengeDescription(challengeDescription);
    clickOnSaveButton();
    waitForDrawerToClose();
    waitForLoading();
  }

  public void clickAddChallengeBtn() {
    clickOnElement(addChallengeBtnElement());
    waitForDrawerToOpen();
  }

  public void enterChallengeTitle(String challengeTitle) {
    challengeTitleFieldElement().setTextValue(challengeTitle);
  }

  public void addProgram(String programTitle) {
    mentionInField(programFieldElement(), programTitle, 5);
  }

  public void enterStartedChallenge() {
    setChallengeStartDate();
    setChallengeEndDate();
  }

  public void addChallengeDescription(String challengeDescription) {
    ElementFacade ckEditorFrameRuleElement = ckEditorFrameRuleElement();
    ckEditorFrameRuleElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameRuleElement);
    try {
      TextBoxElementFacade challengeDescriptionFieldElement = challengeDescriptionFieldElement();
      challengeDescriptionFieldElement.waitUntilVisible();
      challengeDescriptionFieldElement.setTextValue(challengeDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void clickOnSaveButton() {
    saveButtonElement().click();
  }

  public void openEditChallengeDrawer(String challengeName) {
    searchChallengeElement().setTextValue(challengeName);
    waitForLoading();
    editChallengeThreeDots(challengeName).click();
    editChallengeButton(challengeName).click();
  }

  public void cancelAnnouncementChallenge(String announcement) {
    getCancelAnnouncementChallengeIcon(announcement).click();
  }

  public void isOverviewChallengeDisplayed(String challengeTitle, String participantsCount) {
    getOverviewChallengeItemElement(challengeTitle, participantsCount).isVisible();
  }

  public void isOverviewChallengeNotDisplayed(String challengeTitle, String participantsCount) {
    getOverviewChallengeItemElement(challengeTitle, participantsCount).isNotVisible();
  }

  private void setChallengeTitle(String challengeName) {
    if (StringUtils.isNotBlank(challengeName)) {
      enterChallengeTitle(challengeName);
    }
  }

  public void setChallengeStartDate() {
    challengeStartDateCalenderElement().click();
    waitForMenuToOpen();
    currentDateCalenderElement().click();
    waitForMenuToClose();
  }

  public void checkChallengePoints(String challengeName, String points) {
    challengeByNameAndPoints(challengeName, points).assertVisible();
  }

  private void setChallengeEndDate() {
    challengeEndDateCalenderElement().click();
    waitForMenuToOpen();
    randomDateCalenderElement().click();
    waitForMenuToClose();
  }

  private void setChallengeDescription(String challengeDescription) {
    if (StringUtils.isNotBlank(challengeDescription)) {
      addChallengeDescription(challengeDescription);
    }
  }

  private void setChallengeProgram(String challengeProgram) {
    if (StringUtils.isNotBlank(challengeProgram)) {
      addProgram(challengeProgram);
    }
  }

  private void setChallengePoints(String challengePoints) {
    if (StringUtils.isNotBlank(challengePoints)) {
      challengePointsTextbox().setTextValue(challengePoints);
    }
  }

  private TextBoxElementFacade searchChallengeElement() {
    return findTextBoxByXPathOrCSS("//input[@id='EngagementCenterApplicationSearchFilter']");
  }

  private ElementFacade challengeByNameAndPoints(String challengeName, String points) {
    return findByXPathOrCSS(String.format("//*[@id='ChallengesApplication']//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'engagement-center-card')]//*[contains(text(), '%s Points')]",
                                          challengeName,
                                          points));
  }

  private ElementFacade editChallengeThreeDots(String challengeName) {
    return findByXPathOrCSS(String.format("//*[@id='ChallengesApplication']//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'engagement-center-card')]//*[contains(@class, 'fa-ellipsis')]",
                                          challengeName));
  }

  private ElementFacade editChallengeButton(String challengeName) {
    return findByXPathOrCSS(String.format("//*[@id='ChallengesApplication']//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'engagement-center-card')]//*[contains(@class, 'v-menu')]//*[contains(text(), 'Edit')]",
                                          challengeName));
  }

  private ElementFacade addChallengeBtnElement() {
    return findByXPathOrCSS("//*[@id='engagementCenterAddChallengeBtn']");
  }

  private TextBoxElementFacade challengePointsTextbox() {
    return findTextBoxByXPathOrCSS("//input[@id='EngagementCenterChallengeDrawerPoints']");
  }

  private TextBoxElementFacade challengeTitleFieldElement() {
    return findTextBoxByXPathOrCSS("//*[@id='EngagementCenterChallengeDrawerTitleTextArea']");
  }

  private TextBoxElementFacade programFieldElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[@id='EngagementCenterChallengeDrawerProgramSuggester']//input");
  }

  private TextBoxElementFacade challengeStartDateCalenderElement() {
    return findTextBoxByXPathOrCSS("//ancestor::*[contains(@id,'EngagementCenterChallengeDrawerDatePicker')]//*[contains(@class, 'challengePlanDateCalender')]");
  }

  private TextBoxElementFacade challengeEndDateCalenderElement() {
    return findTextBoxByXPathOrCSS("//ancestor::*[contains(@id,'EngagementCenterChallengeDrawerDatePicker')]//*[contains(@class, 'challengeEndDateCalender')]");
  }

  private TextBoxElementFacade currentDateCalenderElement() {
    return findTextBoxByXPathOrCSS("//*[@id='engagementCenterChallengeStartDatePicker']//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table')]//button[not(@disabled) and contains(@class, 'v-date-picker-table__current')]");
  }

  private TextBoxElementFacade randomDateCalenderElement() {
    return findTextBoxByXPathOrCSS("//*[@id='engagementCenterChallengeEndDatePicker']//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table')]//button[not(@disabled)]");
  }

  private ElementFacade ckEditorFrameRuleElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open iframe.cke_wysiwyg_frame");
  }

  private TextBoxElementFacade challengeDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade saveButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private ElementFacade getCancelAnnouncementChallengeIcon(String announcement) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'activity-detail')]//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'undo')]",
                                          announcement));
  }

  private ElementFacade getOverviewChallengeItemElement(String challengeTitle, String participantsCount) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]/following::*[contains(text(), '%s')]",
            challengeTitle, participantsCount + " Participants"));
  }

}
