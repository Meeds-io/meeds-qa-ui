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
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class RulePage extends GenericPage {

  public RulePage(WebDriver driver) {
    super(driver);
  }

  public void enterRuleTitle(String ruleTitle) {
    ruleTitleFieldElement().setTextValue(ruleTitle);
  }

  public void clickAddActionBtn() {
    clickOnElement(addRuleBtnElement());
  }

  public void addRuleEvent(String eventName) {
    findByXPathOrCSS("#EventSelectAutoComplete").click();
    do {
      findTextBoxByXPathOrCSS("(//*[contains(@class,'v-menu__content theme--light v-menu__content--fixed')])").scrollDown();
    } while (!isEventDisplayed(eventName));
    ruleEventsMenuItem(eventName).click();
  }

  private ElementFacade addRuleBtnElement() {
    return findByXPathOrCSS("//*[contains(text(), 'Add Action')]//ancestor::*[contains(@class, 'btn-primary')]");
  }

  private ButtonElementFacade ruleEventsMenuItem(String eventName) {
    return findButtonByXPathOrCSS(String.format("//*[contains(@class, 'menuable__content__active')]//*[contains(text(), '%s')]/parent::*",
                                                eventName));
  }

  public boolean isEventDisplayed(String eventName) {
    return ruleEventsMenuItem(eventName).isVisible();
  }

  public void addRuleRandomDescription(String ruleDescription) {
    ElementFacade ckEditorFrameRuleElement = ckEditorFrameRuleElement();
    ckEditorFrameRuleElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameRuleElement);
    try {
      TextBoxElementFacade ruleDescriptionFieldElement = ruleDescriptionFieldElement();
      ruleDescriptionFieldElement.waitUntilVisible();
      ruleDescriptionFieldElement.setTextValue(ruleDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    clickAddRuleButton();
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
    } while (++retry < tentatives && !getRuleElement(ruleTitle).isCurrentlyVisible());
  }

  public void ruleNotfoundTryAgain() {
    ruleNotfoundTryAgainElement().assertVisible();
  }

  public void clearRulesSearchFilter() {
    clearSearchBtnElement().click();
  }

  public void isRuleDisplayed(String ruleTitle) {
    getRuleElement(ruleTitle).isVisible();
  }

  public void clickAddRuleButton() {
    createButtonElement().click();
  }

  private ElementFacade ckEditorFrameRuleElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open iframe.cke_wysiwyg_frame");
  }

  private TextBoxElementFacade ruleDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private TextBoxElementFacade ruleTitleFieldElement() {
    return findTextBoxByXPathOrCSS("//*[@id='ruleTitle']");
  }

  private ElementFacade createButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private TextBoxElementFacade searchRulesFieldElement() {
    return findTextBoxByXPathOrCSS("//input[@placeholder='Filter by action']");
  }

  public ElementFacade getRuleElement(String ruleTitle) {
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
