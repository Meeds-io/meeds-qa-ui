package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static org.assertj.core.api.Assertions.assertThat;

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

  public void isOverviewChallengeDisplayed(String challengeTitle, String participantsCount) {
    getOverviewChallengeItemElement(challengeTitle, participantsCount).isVisible();
  }

  public void isOverviewChallengeNotDisplayed(String challengeTitle, String participantsCount) {
    getOverviewChallengeItemElement(challengeTitle, participantsCount).isNotVisible();
  }

  public void checkChallengePoints(String challengeName, String points) {
    challengeByNameAndPoints(challengeName, points).assertVisible();
  }

  public void enableActionPublication() {
    ElementFacade publicationSwitchButton = publicationSwitchButton();
    publicationSwitchButton.assertVisible();
    publicationSwitchButton.click();
    waitFor(200).milliseconds(); // Wait for animation
  }

  public void setActionPublicationMessage(String message) {
    waitCKEditorLoading("//*[@id='engagementCenterRulePublishMessage']");
    ElementFacade ckEditorFrame = ckEditorFramePublicationElement();
    ckEditorFrame.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrame);
    try {
      TextBoxElementFacade ckEditorTextBoxElement = ckEditorTextBoxElement();
      ckEditorTextBoxElement.waitUntilVisible();
      ckEditorTextBoxElement.setTextValue(message);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void openActionActivity() {
    waitForDrawerToOpen();
    ElementFacade actionDrawerThreeDots = actionDrawerThreeDots();
    actionDrawerThreeDots.assertVisible();
    actionDrawerThreeDots.click();
    waitFor(200).milliseconds(); // Wait for animation
    clickLink("Open activity");
    waitForLoading();
  }

  public void openActionFromActivity() {
    waitForDrawerToOpen();
    ElementFacade actionDrawerThreeDots = actionDrawerThreeDots();
    actionDrawerThreeDots.assertVisible();
    actionDrawerThreeDots.click();
    waitFor(200).milliseconds(); // Wait for animation
    clickLink("Open action");
    waitForLoading();
  }

  public void checkParticipantsCount(int count) {
    assertThat(findAll("//*[contains(@class, 'rule-realizations')]//button//*[contains(@class, 'v-avatar')]").size())
                                                                                                                     .isEqualTo(count)
                                                                                                                     .as("Number of participants doesn't match");
  }

  private TextBoxElementFacade searchChallengeElement() {
    return findTextBoxByXPathOrCSS("//input[@id='applicationToolbarFilterInput']");
  }

  private ElementFacade challengeByNameAndPoints(String challengeName, String points) {
    return findByXPathOrCSS(String.format("//*[@id='rulesList']//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'rule-card-info')]//*[contains(text(), '+ %s')]",
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

  private ElementFacade getOverviewChallengeItemElement(String challengeTitle, String participantsCount) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]/following::*[contains(text(), '%s')]",
                                          challengeTitle,
                                          participantsCount + " Participants"));
  }

  private ElementFacade publicationSwitchButton() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[@id='engagementCenterRulePublishSwitch' and @aria-checked='false']//ancestor::*[contains(@class, 'v-input--switch')]");
  }

  private ElementFacade actionDrawerThreeDots() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'drawerHeader')]//*[contains(@class, 'fa-ellipsis-v')]");
  }

  private ElementFacade ckEditorFramePublicationElement() {
    return findByXPathOrCSS("//*[@id='engagementCenterRulePublishMessage']//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private TextBoxElementFacade ckEditorTextBoxElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

}
