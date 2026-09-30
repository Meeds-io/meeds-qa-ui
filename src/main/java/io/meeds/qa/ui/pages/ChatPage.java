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

public class ChatPage extends GenericPage {

  public ChatPage(WebDriver driver) {
    super(driver);
  }

  public void openChatDrawer() {
    chatButtonElement().click();
  }

  public void checkChatDrawerOpened() {
    chatDrawerElement().assertVisible();
  }

  public void checkChatRoomsListDisplayed() {
    chatRoomsListElement().assertVisible();
  }

  private ElementFacade chatButtonElement() {
    return findByXPathOrCSS("//*[@id='btnChatButtonNew']");
  }

  private ElementFacade chatDrawerElement() {
    return findByXPathOrCSS("//*[@id='meedsChatDrawer']");
  }

  private ElementFacade chatRoomsListElement() {
    return findByXPathOrCSS("//*[@id='initialRoomsElement']");
  }

}
