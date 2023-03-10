package io.meeds.qa.ui.pages;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import org.openqa.selenium.WebDriver;

public class ChallengesPage extends GenericPage {

  public ChallengesPage(WebDriver driver) {
    super(driver);
  }

  public void clickAddChallengeBtn() {
    clickOnElement(addChallengeBtnElement());
    waitForDrawerToOpen();
  }

  public void enterChallengeTitle(String challengeTitle) {
    challengeTitleFieldElement().setTextValue(challengeTitle);
  }

  public void addProgram(String programTitle) {
    programFieldElement().waitUntilVisible();
    mentionInField(programFieldElement(), programTitle, 5);
  }

  public void enterStartedChallenge() {
    challengeStartDateCalenderElement().click();
    currentDateCalenderElement().waitUntilVisible();
    currentDateCalenderElement().click();
    challengeEndDateCalenderElement().click();
    randomDateCalenderElement().waitUntilVisible();
    randomDateCalenderElement().click();
  }

  public void addChallengeRandomDescription(String challengeDescription) {
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
    createButtonElement().click();
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

  private ElementFacade addChallengeBtnElement() {
    return findByXPathOrCSS("//*[@id='engagementCenterAddChallengeBtn']");
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
    return findTextBoxByXPathOrCSS("//ancestor::*[contains(@id,'engagementCenterChallengeStartDatePicker')]//*[contains(@class, 'v-date-picker-table__current') and not(@disabled)]");
  }

  private TextBoxElementFacade randomDateCalenderElement() {
    return findTextBoxByXPathOrCSS("//ancestor::*[contains(@id,'engagementCenterChallengeEndDatePicker')]//*[contains(@class, 'v-btn--rounded') and not(@disabled)]");
  }

  private ElementFacade ckEditorFrameRuleElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open iframe.cke_wysiwyg_frame");
  }

  private TextBoxElementFacade challengeDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade createButtonElement() {
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
