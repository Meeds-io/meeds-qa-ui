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

import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class AgendaPage extends GenericPage {

  private static int daySlot = 0;
  
  public AgendaPage(WebDriver driver) {
    super(driver);
  }

  public void openAgendaApplication() {
    goToPage("/portal/dw/agenda");
  }

  public void checkAgendaApplicationDisplayed() {
    agendaApplicationElement().assertVisible();
  }

  public void checkAddEventButtonDisplayed() {
    addEventButtonElement().assertVisible();
  }

  public void checkAgendaViewsSwitcherDisplayed() {
    agendaViewsSwitcherElement().assertVisible();
  }

  public void checkAgendaFilterDisplayed() {
    agendaFilterElement().assertVisible();
  }

  public void checkAgendaNowLineDisplayed() {
    agendaNowLineElement().assertVisible();
  }

  public void goToAgendaView(String view) {
    agendaViewsSwitcherElement().click();
    agendaViewButtonElement(view).click();
    waitForLoading();
  }

  public void clickAddEventButton() {
    addEventButtonElement().click();
  }

  public void checkEventCreationFormStep(String stepLabel) {
    eventFormStepElement(stepLabel).assertVisible();
  }

  public void openSettingsPage() {
    goToPage("/portal/dw/settings");
  }

  public void checkAgendaSettingsDisplayed() {
    agendaSettingsApplicationElement().assertVisible();
  }

  public void clickEditAgendaSettings() {
    editAgendaSettingsIconElement().click();
  }

  public void checkAgendaPreferencesDrawerDisplayed() {
    agendaPreferencesDrawerElement().assertVisible();
  }

  // --- Event creation form: close via icon / ESC ---
  // platform-qa-tribe follows both close paths with clickDiscardChangesPopup()
  // to confirm the "unsaved changes" popup that otherwise keeps the form open.

  public void closeEventCreationForm() {
    eventFormCloseIconElement().click();
    clickDiscardChangesPopup();
    waitForLoading();
  }

  public void pressEscapeInEventCreationForm() {
    eventTitleFieldElement().sendKeys(Keys.ESCAPE);
    clickDiscardChangesPopup();
    waitForLoading();
  }

  public void checkEventCreationFormClosed() {
    eventCreationFormElement().assertNotVisible();
  }

  // --- Repetition ---

  public void clickRepetitionSelectBox() {
    repetitionSelectBoxElement().click();
  }

  public void checkRepetitionOption(String option) {
    repetitionOptionElement(option).assertVisible();
  }

  public void addEvent(String title) {
    clickAddEventButton();
    eventTitleFieldElement().setTextValue(title);
    ElementFacade continueButtonElement = continueAddEventButtonElement();
    continueButtonElement.assertEnabled();
    continueButtonElement.click();
    ElementFacade eventDaySlotElement = eventDaySlotElement();
    eventDaySlotElement.assertVisible();
    eventDaySlotElement.click();
    ElementFacade createButtonElement = createEventButtonElement();
    createButtonElement.assertEnabled();
    createButtonElement.click();
    waitForLoading();
  }

  public void checkEventCreatedAlert(String alertMessage) {
    checkConfirmMessageIsDisplayed(alertMessage);
  }

  public void openEventDetails(String title) {
    eventByTitleElement(title).click();
    waitForLoading();
  }

  public void pressEscapeInEventDetails() {
    eventMenuElement().click();
    eventMenuActionElement("Edit").click();
    eventTitleFieldElement().sendKeys(Keys.ESCAPE);
    clickDiscardChangesPopup();
    waitForLoading();
  }

  public void checkEventDetailsNotVisible() {
    eventDetailsDialogElement().assertNotVisible();
  }

  public void openEditEventForm() {
    eventMenuElement().click();
    eventMenuActionElement("Edit").click();
    waitForLoading();
  }

  public void checkEditEventFormDisplayed() {
    eventCreationFormElement().assertVisible();
  }

  public void openDeleteEventForm() {
    eventMenuElement().click();
    eventMenuActionElement("Delete").click();
  }

  public void checkEventButtonDisplayed(String buttonName) {
    eventButtonByNameElement(buttonName).assertVisible();
  }

  public void clickEventButton(String buttonName) {
    eventButtonByNameElement(buttonName).click();
    waitForLoading();
  }

  public void checkEventDeletedFromAgenda(String title) {
    refreshPage();
    eventByTitleElement(title).assertNotVisible();
  }

  private static int incrementAndGetDayslot() {
    return 9 + ++daySlot % 10;
  }

  private void clickDiscardChangesPopup() {
    waitFor(200).milliseconds();
    closeConfirmDialogIfDisplayed();
  }

  private ElementFacade agendaSettingsApplicationElement() {
    return findByXPathOrCSS("//*[@id='AgendaSettingsApplication']");
  }

  private ElementFacade editAgendaSettingsIconElement() {
    return findByXPathOrCSS("(//*[@id='AgendaSettingsApplication']//i[contains(@class,'uiIconEdit')])[1]");
  }

  private ElementFacade agendaPreferencesDrawerElement() {
    return findByXPathOrCSS("//*[contains(@class,'UserSettingAgendaDrawer')]");
  }

  private ElementFacade agendaApplicationElement() {
    return findByXPathOrCSS("//*[@id='AgendaApplication']");
  }

  private ElementFacade addEventButtonElement() {
    return findByXPathOrCSS("//*[@id='AgendaApplication']//i[contains(@class,'fa-plus')]");
  }

  private ElementFacade agendaViewsSwitcherElement() {
    return findByXPathOrCSS("//*[@id='agendaDisplayOptions']");
  }

  private ElementFacade agendaFilterElement() {
    return findByXPathOrCSS("//*[@id='AgendaApplication']//i[contains(@class,'fa-sliders-h')]");
  }

  private ElementFacade agendaNowLineElement() {
    return findByXPathOrCSS("(//div[contains(@class,'v-present')])[2]");
  }

  private ElementFacade agendaViewButtonElement(String view) {
    return findByXPathOrCSS(String.format("//i[contains(@class,'fa-calendar-%s')]", view));
  }

  private ElementFacade eventFormStepElement(String stepLabel) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-stepper__label') and contains(text(),'%s')]",
                                          stepLabel));
  }

  private TextBoxElementFacade eventTitleFieldElement() {
    return findTextBoxByXPathOrCSS("//*[@id='eventTitle']");
  }

  private ElementFacade eventCreationFormElement() {
    return findByXPathOrCSS("//*[contains(@class,'event-form')]");
  }

  private ElementFacade eventFormCloseIconElement() {
    return findByXPathOrCSS("(//i[contains(@class,'mdi-close')])[1]");
  }

  private ElementFacade repetitionSelectBoxElement() {
    return findByXPathOrCSS("//select[contains(@class,'subtitle-1')]");
  }

  private ElementFacade repetitionOptionElement(String option) {
    return findByXPathOrCSS(String.format("//select[contains(@class,'subtitle-1')]//option[contains(text(),'%s')]",
                                          option));
  }

  private ElementFacade eventDaySlotElement() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-dialog--active')]//*[@class='v-calendar-daily__day v-future'][1]//*[@class='v-calendar-daily__day-interval'])[%s]".formatted(incrementAndGetDayslot()));
  }

  private ElementFacade continueAddEventButtonElement() {
    return findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//*[contains(@class, 'd-flex flex-grow-0')]//*[contains(@class, 'btn-primary')]");
  }

  private ElementFacade createEventButtonElement() {
    return findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//*[contains(@class, 'd-flex flex-grow-0')]//*[contains(@class, 'btn-primary')]");
  }

  private ElementFacade eventByTitleElement(String title) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", title));
  }

  private ElementFacade eventMenuElement() {
    return findByXPathOrCSS("//i[contains(@class,'mdi-dots-vertical')]");
  }

  private ElementFacade eventMenuActionElement(String action) {
    return findByXPathOrCSS(String.format("//div[contains(text(),'%s')]", action));
  }

  private ElementFacade eventDetailsDialogElement() {
    return findByXPathOrCSS("//div[contains(@class,'agendaEventDialog')]");
  }

  private ElementFacade eventButtonByNameElement(String buttonName) {
    return findByXPathOrCSS(String.format("//button[contains(text(),'%s')]", buttonName));
  }

}
