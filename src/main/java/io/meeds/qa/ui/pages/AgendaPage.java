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

  public void clickAddEventButton() {
    addEventButtonElement().click();
  }

  public void checkEventCreationFormStep(String stepLabel) {
    eventFormStepElement(stepLabel).assertVisible();
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

  private ElementFacade eventFormStepElement(String stepLabel) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-stepper__label') and contains(text(),'%s')]",
                                          stepLabel));
  }

}
