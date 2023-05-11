package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class ChallengesPage extends GenericPage {

  public ChallengesPage(WebDriver driver) {
    super(driver);
  }

  public void openEditChallengeDrawer(String challengeName) {
    searchChallenge(challengeName);
    editChallengeThreeDots(challengeName).click();
    editChallengeButton(challengeName).click();
  }

  public void searchChallenge(String challengeName) {
    searchChallengeElement().setTextValue("");
    waitFor(1).seconds();
    waitForLoading();
    searchChallengeElement().setTextValue(challengeName);
    waitFor(1).seconds();
    waitForLoading();
    TextBoxElementFacade expandProgramChallengesElement = expandProgramChallengesElement();
    if (expandProgramChallengesElement.isCurrentlyVisible()) {
      expandProgramChallengesElement.click();
    }
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

  public void checkChallengePoints(String challengeName, String points) {
    challengeByNameAndPoints(challengeName, points).assertVisible();
  }

  private TextBoxElementFacade searchChallengeElement() {
    return findTextBoxByXPathOrCSS("//input[@id='EngagementCenterApplicationSearchFilter']");
  }

  private TextBoxElementFacade expandProgramChallengesElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-expansion-panel-header')]//*[contains(@class, 'fa-chevron-down')]");
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

  private ElementFacade getCancelAnnouncementChallengeIcon(String announcement) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'activity-detail')]//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'undo')]",
                                          announcement));
  }

  private ElementFacade getOverviewChallengeItemElement(String challengeTitle, String participantsCount) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]/following::*[contains(text(), '%s')]",
            challengeTitle, participantsCount + " Participants"));
  }

}
