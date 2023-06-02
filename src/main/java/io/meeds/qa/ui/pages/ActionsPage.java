package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class ActionsPage extends GenericPage {

  public ActionsPage(WebDriver driver) {
    super(driver);
  }

  public void openEditChallengeDrawer(String challengeName) {
    searchAction(challengeName);
    actionCard(challengeName).hover();
    ElementFacade menuThreeDots = editChallengeThreeDots(challengeName);
    menuThreeDots.assertVisible();
    menuThreeDots.click();
    editChallengeButton(challengeName).click();
    waitForDrawerToOpen();
    waitForLoading();
  }

  public void searchAction(String actionName) {
    TextBoxElementFacade searchField = searchChallengeElement();
    searchField.setTextValue("");
    waitFor(300).milliseconds();
    waitForLoading();
    searchField.setTextValue(actionName);
    waitFor(300).milliseconds();
    waitForLoading();

    boolean visible = actionCard(actionName).isVisible();
    int retry = 0;
    while (!visible && retry++ < MAX_WAIT_RETRIES) {
      searchField.sendKeys(Keys.BACK_SPACE);
      waitFor(300).milliseconds();
      waitForLoading();
      visible = actionCard(actionName).isVisible();
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
    return findTextBoxByXPathOrCSS("//input[@id='applicationToolbarFilterInput']");
  }

  private ElementFacade challengeByNameAndPoints(String challengeName, String points) {
    return findByXPathOrCSS(String.format("//*[@id='rulesList']//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'rule-card-info')]//*[contains(text(), '%s Points')]",
                                          challengeName,
                                          points));
  }

  private ElementFacade editChallengeThreeDots(String challengeName) {
    return findByXPathOrCSS(String.format("//*[@id='rulesList']//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'rule-card-info')]//*[contains(@class, 'fa-ellipsis')]",
                                          challengeName));
  }

  private ElementFacade actionCard(String challengeName) {
    return findByXPathOrCSS(String.format("//*[@id='rulesList']//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'rule-card-info')]",
                                          challengeName));
  }

  private ElementFacade editChallengeButton(String challengeName) {
    return findByXPathOrCSS(String.format("//*[@id='rulesList']//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'rule-card-info')]//*[contains(@class, 'v-menu')]//*[contains(text(), 'Edit')]",
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
