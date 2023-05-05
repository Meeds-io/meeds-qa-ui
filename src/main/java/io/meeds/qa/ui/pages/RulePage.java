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

import io.meeds.qa.ui.elements.ButtonElementFacade;

import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class RulePage extends GenericPage {

  public RulePage(WebDriver driver) {
    super(driver);
  }

  public void clickAddActionButton() {
    addActionButton().click();
  }

  public void saveAction(String title,
                         String description,
                         String points,
                         boolean declarative,
                         boolean changeDates,
                         boolean newRule) {
    setActionTitle(title);
    setActionDescription(description);
    setActionPoints(points);

    if (newRule) {
      if (declarative) {
        declarativeChoiceButton().click();
      } else {
        automaticChoiceButton().click();
      }
    }

    clickOnNextButton();

    if (changeDates) {
      selectDurationChoice();
      setActionEndDate();
    }

    clickOnSaveButton(newRule);
    waitForDrawerToClose();
    waitForLoading();
  }

  public void selectDurationChoice() {
    durationChip().click();
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

  public void setActionEvent(String eventName) {
    eventSelectAutoComplete().click();
    do {
      findTextBoxByXPathOrCSS("(//*[contains(@class,'v-menu__content theme--light v-menu__content--fixed')])").scrollDown();
    } while (!isEventDisplayed(eventName));
    ruleEventsMenuItem(eventName).click();
  }

  public void setActionEndDate() {
    actionEndDateElement().click();
    waitForMenuToOpen();
    randomDateCalenderElement().waitUntilVisible();
    randomDateCalenderElement().click();
    waitForMenuToClose();
  }

  public void clickOnNextButton() {
    nextStepButton().click();
  }

  public void changeRuleEnablement() {
    ruleEnableSwitchButton().click();
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

  private ElementFacade ruleEnableSwitchButton() {
    return findByXPathOrCSS("//*[contains(text(), 'Enabled')]/parent::*//*[contains(@class, 'v-input--switch') and contains(@class, 'v-input--selection-controls')]");
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

  private ElementFacade durationChip() {
    return findByXPathOrCSS("//*[contains(text(),'Duration')]//ancestor-or-self::*[contains(@class, 'v-chip')]");
  }

  private ElementFacade declarativeChoiceButton() {
    return findByXPathOrCSS("//*[contains(text(),'Declarative')]//ancestor-or-self::button");
  }

  private ElementFacade automaticChoiceButton() {
    return findByXPathOrCSS("//*[contains(text(),'Automatic')]//ancestor-or-self::button");
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
    return findByXPathOrCSS("//*[@id = 'engagementCenterProgramDetail']//*[contains(text(), 'Add Action')]//ancestor::button");
  }

  private ButtonElementFacade ruleEventsMenuItem(String eventName) {
    return findButtonByXPathOrCSS(String.format("//*[contains(@class, 'menuable__content__active')]//*[contains(text(), '%s')]/parent::*",
                                                eventName));
  }

  private ElementFacade eventSelectAutoComplete() {
    return findByXPathOrCSS("#EventSelectAutoComplete");
  }

  private TextBoxElementFacade actionPointsTextbox() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'Points')]/parent::*//input[@type = 'number']");
  }

  private ElementFacade ckEditorFrameRuleElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open iframe.cke_wysiwyg_frame");
  }

  private TextBoxElementFacade actionEndDateElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'challengeDates')]//*[contains(@class, 'datePickerText')]");
  }

  private TextBoxElementFacade randomDateCalenderElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table')]//button[not(@disabled)]");
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
    return findByXPathOrCSS("//button[contains(@class, 'fa-times')]");
  }

}
