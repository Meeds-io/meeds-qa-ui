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
package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.GenericPage;

public class GenericSteps {
  private GenericPage genericPage;

  public void checkConfirmMessageIsDisplayed(String message) {
    genericPage.checkConfirmMessageIsDisplayed(message);
  }

  public void checkDrawerDisplayed(String title) {
    genericPage.checkDrawerDisplayed(title);
  }

  public void checkSwitchButtonNotDisplayed(String buttonName) {
    genericPage.checkSwitchButtonNotDisplayed(buttonName);
  }

  public void checkSwitchButtonDisplayed(String buttonName) {
    genericPage.checkSwitchButtonDisplayed(buttonName);
  }

  public void enableSwitchButtonDisplayed(String buttonName) {
    genericPage.enableSwitchButtonDisplayed(buttonName);
  }

  public void clickConfirm() {
    genericPage.clickConfirm();
  }

  public void clickButton(String buttonText) {
    genericPage.clickButton(buttonText);
  }

  public void clickDrawerButton(String buttonText) {
    genericPage.clickDrawerButton(buttonText);
  }

  public void buttonIsDisabled(String buttonText) {
    genericPage.buttonIsDisabled(buttonText);
  }

  public void buttonInDrawerIsDisabled(String buttonText) {
    genericPage.buttonInDrawerIsDisabled(buttonText);
  }

  public void buttonInDrawerIsNotDisplayed(String buttonText) {
    genericPage.buttonInDrawerIsNotDisplayed(buttonText);
  }

  public void buttonInDrawerIsDisplayed(String buttonText) {
    genericPage.buttonInDrawerIsDisplayed(buttonText);
  }

  public void waitForDrawerToOpen() {
    genericPage.waitForDrawerToOpen();
  }

  public void waitForDrawerToClose() {
    genericPage.waitForDrawerToClose();
  }

  public void closeOpenedNotification() {
    genericPage.closeDisplayedAlert();
  }

  public void closeAllDialogs() {
    genericPage.closeAllDialogs();
  }

  public void closeAllDrawers() {
    genericPage.closeAllDrawers();
  }

  public void closeBrowserTab(int tabIndex) {
    genericPage.closeBrowserTab(tabIndex);
  }

  public void closeDrawerIfDisplayed() {
    genericPage.closeDrawerIfDisplayed();
  }

  public boolean containsContent(String content) {
    return genericPage.containsContent(content);
  }

  public String getCurrentUrl() {
    return genericPage.getCurrentUrl();
  }

  public boolean isButtonDisplayed(String button) {
    return genericPage.isButtonDisplayed(button);
  }

  public void isPageOpened(String uriPart) {
    genericPage.isPageOpened(uriPart);
  }

  public boolean isSuccessMessageDisplayed() {
    return genericPage.isSuccessMessageDisplayed();
  }

  public void waitInSeconds(int seconds) {
    genericPage.waitFor(seconds).seconds();
  }
  
  public void waitInMilliseconds(int milliseconds) {
    genericPage.waitFor(milliseconds).milliseconds();
  }

}
