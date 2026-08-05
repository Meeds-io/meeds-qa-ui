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

import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;

public class AgendaPage extends GenericPage {

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

}
