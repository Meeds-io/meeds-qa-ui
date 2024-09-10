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

import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.meeds.qa.ui.pages.GenericPage;

import net.serenitybdd.core.Serenity;

public class GenericSteps {
  private static final String DISABLE_PWA_SCRIPT =
                                                 """
                                                      const callback = arguments[arguments.length - 1];
                                                      fetch("/pwa/rest/manifest", {
                                                        "headers": {
                                                          "content-type": "application/json",
                                                        },
                                                        "body": `{"enabled":false,"name":"Web3 Hub","description":"Your Application for Communication, Collaboration, Teamwork and Engagement","themeColor":"#BC99E7","backgroundColor":"#BC99E7"}`,
                                                        "method": "PUT",
                                                        "credentials": "include"
                                                      })
                                                     .then(resp => {
                                                       if (!resp || !resp.ok) {
                                                         throw new Error("Error changing space creation permissions");
                                                       }
                                                     })
                                                     .then(() => callback(true))
                                                     .catch(() => callback(false));
                                                      """;

  private GenericPage         genericPage;

  public void checkConfirmMessageIsDisplayed(String message) {
    genericPage.checkConfirmMessageIsDisplayed(message);
  }

  public void checkMessageIsDisplayed(String message) {
    genericPage.checkMessageIsDisplayed(message);
  }

  public void checkMessageIsNotDisplayed(String message) {
    genericPage.checkMessageIsNotDisplayed(message);
  }

  public void checkMessageIsDisplayedInPage(String message) {
    genericPage.checkMessageIsDisplayedInPage(message);
  }

  public void checkMessageIsNotDisplayedInPage(String message) {
    genericPage.checkMessageIsNotDisplayedInPage(message);
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

  public void clickMenuItem(String buttonText) {
    genericPage.clickMenuItem(buttonText);
  }

  public void clickLink(String linkText) {
    genericPage.clickLink(linkText);
  }

  public void clickOnText(String text) {
    genericPage.clickOnText(text);
  }

  public void clickDrawerButton(String buttonText) {
    genericPage.clickDrawerButton(buttonText);
  }

  public void clickSelecdLevelDrawerButton(String buttonText) {
    genericPage.clickSelecdLevelDrawerButton(buttonText);
  }

  public void buttonIsDisabled(String buttonText) {
    genericPage.buttonIsDisabled(buttonText);
  }

  public void buttonIsEnabled(String buttonText) {
    genericPage.buttonIsEnabled(buttonText);
  }

  public void buttonInDrawerIsDisabled(String buttonText) {
    genericPage.buttonInDrawerIsDisabled(buttonText);
  }

  public void buttonInDrawerIsEnabled(String buttonText) {
    genericPage.buttonInDrawerIsEnabled(buttonText);
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

  public void closeToastNotification() {
    genericPage.closeToastNotification(true);
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

  public void expandDrawer() {
    genericPage.expandDrawer();
  }

  public void clickOnGoBack() {
    genericPage.clickOnGoBack();
  }

  public void clickOnGoBackInDrawer() {
    genericPage.clickOnGoBackInDrawer();
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

  public void checkSuccessMessageDisplayed() {
    genericPage.checkSuccessMessageDisplayed();
  }

  public void checkInformationMessageDisplayed() {
    genericPage.checkInformationMessageDisplayed();
  }

  public void waitInSeconds(int seconds) {
    genericPage.waitFor(seconds).seconds();
  }

  public void waitInMilliseconds(int milliseconds) {
    genericPage.waitFor(milliseconds).milliseconds();
  }

  public void checkTranslationButtonIsPrimary(int index) {
    genericPage.checkTranslationButtonIsPrimary(index);
  }

  public void checkTranslationButtonIsNotPrimary(int index) {
    genericPage.checkTranslationButtonIsNotPrimary(index);
  }

  public void openTranslationsDrawer(int index) {
    genericPage.openTranslationsDrawer(index);
  }

  public void addTranslationValues(String fieldType, Map<String, String> valuesByLanguage) {
    genericPage.addTranslationValues(fieldType, valuesByLanguage);
  }

  public void switchPageLanguage(String lang) {
    genericPage.switchPageLanguage(lang);
  }

  public void sortTableByField(String fieldText) {
    genericPage.sortTableByField(fieldText);
  }

  public void disablePwa() {
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(),
                                           Duration.ofSeconds(10),
                                           Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeAsyncScript(DISABLE_PWA_SCRIPT)
                                                            .toString()
                                                            .equals("true"));
  }

  public void goToPage(String link) {
    genericPage.goToPage(link);
  }

}
