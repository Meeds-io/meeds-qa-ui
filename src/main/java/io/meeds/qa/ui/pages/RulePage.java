/*
 * This file is part of the Meeds project (https://meeds.io/).
 *
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ButtonElementFacade;
import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class RulePage extends GenericPage {

  private static final String MEEDS_APPLICATION                       = "meeds";

  private static final String MANUAL_SUBMISSION_APPLICATION           = "manual";

  private static final String OPENED_RULE_PUBLICATION_DRAWER_SELECTOR = "//*[@id='engagementCenterRulePublication']";

  private static final String OPENED_RULE_DRAWER_SELECTOR             =
                                                          "//*[@id = 'ruleDetailDrawer' and contains(@class, 'v-navigation-drawer--open')]";

  public RulePage(WebDriver driver) {
    super(driver);
  }

  public void clickAddActionButton() {
    addActionButton().click();
  }

  public void saveAction(String title,
                         String description,
                         String points,
                         boolean manual,
                         boolean changeDates,
                         boolean newRule) {
    if (StringUtils.isNotBlank(title)) {
      setActionTitle(title);
    }
    if (newRule) {
      if (manual) {
        applicationElement(MANUAL_SUBMISSION_APPLICATION).click();
      } else {
        applicationElement(MEEDS_APPLICATION).click();
      }
    }
    clickOnStartButton();

    if (StringUtils.isNotBlank(description)) {
      setActionDescription(description);
    }
    clickOnNextButton();
    if (changeDates) {
      selectDurationChoice();
      setActionEndDate();
    }
    clickOnNextButton();
    if (StringUtils.isNotBlank(points)) {
      setActionPoints(points);
    }
    clickOnNextButton();
    clickOnSaveButton(newRule);
    waitForDrawerToClose();
  }

  public void selectDurationChoice() {
    ElementFacade durationChip = durationDeselectedChip();
    durationChip.waitUntilVisible();
    durationChip.click();
    durationSelectedChip().assertVisible();
  }

  public void setActionTitle(String title) {
    ruleTitleFieldElement().setTextValue(title);
  }

  public void setActionDescription(String description) {
    ElementFacade ckEditorFrameRuleElement = ckEditorFrameRuleElement();
    ckEditorFrameRuleElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameRuleElement);
    try {
      TextBoxElementFacade ruleDescriptionFieldElement = ruleDescriptionFieldElement();
      ruleDescriptionFieldElement.waitUntilVisible();
      ruleDescriptionFieldElement.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void setActionPoints(String challengePoints) {
    actionPointsTextbox().setTextValue(challengePoints);
  }

  public void selectActionApplication(String applicationLabel) {
    applicationElement(applicationLabel).click();
  }

  public void setActionEvent(String triggerName) {
    ElementFacade triggerSelectAutoComplete = triggerSelectAutoComplete();
    triggerSelectAutoComplete.click();
    triggerSelectAutoComplete.type(triggerName);
    triggerSelectAutoComplete.type(Keys.ARROW_DOWN);
    triggerSelectAutoComplete.type(Keys.ENTER);
    triggerSelectedAutoComplete(triggerName).assertVisible();
  }

  public void selectDefaultContributionStatus(String status) {
    switch (status) {
    case "Accepted":
      acceptedRadioBtnElement().click();
      acceptedRadioBtnActiveElement().waitUntilVisible();
      break;
    case "Pending":
      pendingRadioBtnElement().click();
      pendingRadioBtnActiveElement().waitUntilVisible();
      break;
    default:
      break;
    }
  }

  public void deleteActionDuration() {
    durationSelectedChip().click();
  }

  public void setActionEndDate() {
    selectActionDateChoice("BEFORE");
    actionEndDateElement().click();
    waitForMenuToOpen("DatePickerMenu");
    if (!randomDateCalenderElement().isVisible()) {
      nextMonthDateCalenderButton().click();
    }
    randomDateCalenderElement().click();
    waitForMenuToClose("DatePickerMenu");
  }

  public void clickOnStartButton() {
    startButton().click();
  }

  public void clickOnNextButton() {
    nextStepButton().click();
  }

  public void clickOnSaveButton(boolean newRule) {
    if (newRule) {
      addButton().click();
    } else {
      updateButton().click();
    }
  }

  public boolean isEventDisplayed(String eventName) {
    return ruleEventsMenuItem(eventName).isVisible();
  }

  public void searchRuleInProgramRuleFilter(String ruleTitle) {
    searchRuleByTitle(ruleTitle, 1);
  }

  public void searchRuleByTitle(String ruleTitle, int tentatives) {
    int retry = 0;
    do {
      TextBoxElementFacade searchRulesFieldElement = searchRulesFieldElement();
      searchRulesFieldElement.setTextValue(ruleTitle);
      waitForProgressBar();
    } while (++retry < tentatives && !actionInProgramDetailElement(ruleTitle).isCurrentlyVisible());
  }

  public void ruleNotfoundTryAgain() {
    ruleNotfoundTryAgainElement().assertVisible();
  }

  public void clearRulesSearchFilter() {
    clearSearchBtnElement().click();
  }

  public void attachImageToAnnouncement() {
    waitCKEditorLoading(OPENED_RULE_DRAWER_SELECTOR);
    this.attachImageToCKeditor();
  }

  public void attachImageToProgramAction() {
    waitCKEditorLoading(OPENED_RULE_PUBLICATION_DRAWER_SELECTOR);
    attachImageToCKeditor();
  }

  public void isActionDisplayedInProgramDetail(String actionTitle) {
    actionInProgramDetailElement(actionTitle).assertVisible();
  }

  public void isActionNotDisplayedInProgramDetail(String actionTitle) {
    actionInProgramDetailElement(actionTitle).assertNotVisible();
  }

  public void openActionDrawer(String actionTitle) {
    actionInProgramDetailElement(actionTitle).click();
    waitForDrawerToOpen();
  }

  private void selectActionDateChoice(String value) {
    ElementFacade selectActionDateElement = selectActionDateElement(value);
    selectActionDateElement.waitUntilVisible();
    selectActionDateElement.waitUntilClickable();
    selectActionDateElement.selectByValue(value);
    waitFor(50).milliseconds();
  }

  private ElementFacade selectActionDateElement(String value) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//option[@value='%s']//parent::select",
                                          value));
  }

  private ElementFacade durationDeselectedChip() {
    return findByXPathOrCSS("//*[contains(text(),'Duration')]//ancestor-or-self::*[contains(@class, 'v-chip--clickable') and not(contains(@class, 'primary'))]");
  }

  private ElementFacade durationSelectedChip() {
    return findByXPathOrCSS("//*[contains(text(),'Duration')]//ancestor-or-self::*[contains(@class, 'v-chip--clickable') and contains(@class, 'primary')]");
  }

  private ElementFacade startButton() {
    return findByXPathOrCSS("//*[contains(text(),'Start')]//ancestor-or-self::button");
  }

  private ElementFacade nextStepButton() {
    return findByXPathOrCSS("//*[contains(text(),'Next')]//ancestor-or-self::button");
  }

  private ElementFacade addButton() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'Add')]//ancestor-or-self::button");
  }

  private ElementFacade updateButton() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'Update')]//ancestor-or-self::button");
  }

  private ElementFacade addActionButton() {
    return findByXPathOrCSS("//*[@id = 'engagementCenterProgramDetail']//*[contains(text(), 'Add Action') or contains(text(), 'Add action')]//ancestor::button");
  }

  private ButtonElementFacade ruleEventsMenuItem(String eventName) {
    return findButtonByXPathOrCSS(String.format("//*[contains(@class, 'menuable__content__active')]//*[contains(text(), '%s')]/parent::*",
                                                eventName));
  }

  private ElementFacade triggerSelectAutoComplete() {
    return findByXPathOrCSS("#triggerAutoComplete");
  }

  private ElementFacade triggerSelectedAutoComplete(String eventName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'v-chip')]//*[contains(text(), '%s')]",
                                          eventName));
  }

  private TextBoxElementFacade actionPointsTextbox() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'points') or contains(text(),'Points')]/ancestor::*//input[@type = 'number']");
  }

  private ElementFacade ckEditorFrameRuleElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open iframe.cke_wysiwyg_frame");
  }

  private TextBoxElementFacade actionEndDateElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@class,'ruleDates')]//*[contains(@class, 'datePickerText')]");
  }

  private TextBoxElementFacade randomDateCalenderElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table')]//button[not(@disabled)]");
  }

  private TextBoxElementFacade nextMonthDateCalenderButton() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-header')]//button[not(@disabled)]//i[contains(@class, 'right')]");
  }

  private TextBoxElementFacade ruleDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private TextBoxElementFacade ruleTitleFieldElement() {
    return findTextBoxByXPathOrCSS("//*[@id='ruleTitle']");
  }

  private TextBoxElementFacade searchRulesFieldElement() {
    return findTextBoxByXPathOrCSS("//input[@placeholder='Filter by action']");
  }

  public ElementFacade actionInProgramDetailElement(String ruleTitle) {
    return findByXPathOrCSS(String.format("//*[@class='v-data-table__wrapper']//*[@class='text-truncate' and contains(@title,'%s')][1]",
                                          ruleTitle));
  }

  public ElementFacade ruleNotfoundTryAgainElement() {
    return findByXPathOrCSS("//a[contains(text(), 'try again')]");
  }

  public ElementFacade clearSearchBtnElement() {
    return findByXPathOrCSS("#engagementCenterProgramDetail .v-input button.fa-times");
  }

  private ElementFacade applicationElement(String applicationLabel) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[@id = '%sApplicationSubmissionOption']",
                                          applicationLabel));
  }

  private ElementFacade acceptedRadioBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//input[@value='ACCEPTED']//ancestor::*[contains(@class,'v-radio')]");
  }

  private ElementFacade acceptedRadioBtnActiveElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//input[@value='ACCEPTED']//ancestor::*[contains(@class,'v-radio') and contains(@class,'v-item--active')]");
  }  

  private ElementFacade pendingRadioBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//input[@value='PENDING']//ancestor::*[contains(@class,'v-radio')]");
  }

  private ElementFacade pendingRadioBtnActiveElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//input[@value='PENDING']//ancestor::*[contains(@class,'v-radio') and contains(@class,'v-item--active')]");
  }

}
