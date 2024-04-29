/**
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
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package io.meeds.qa.ui.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;

public class NotificationSettingsPage extends GenericPage {

  public NotificationSettingsPage(WebDriver driver) {
    super(driver);
  }

  public void disableEmailNotificationForAll() {
    emailNotifSwitchInput().assertEnabled();
    if (emailNotifSwitchInput().isSelected()) {
      emailNotifSwitch().click();
      // Wait for animation to finish
      waitFor(500).milliseconds();
      Utils.waitForLoading();
    }
  }

  public void enableEmailNotificationForAll() {
    emailNotifSwitchInput().assertEnabled();
    if (!emailNotifSwitchInput().isSelected()) {
      emailNotifSwitch().click();
      // Wait for animation to finish
      waitFor(500).milliseconds();
      Utils.waitForLoading();
    }
  }

  public void checkEmailNotificationIsHidden() {
    personalEmailSettingNotifSwitch().assertNotVisible();
  }

  public void checkEmailNotificationIsDisplayed() {
    personalEmailSettingNotifSwitch().assertVisible();
  }

  public void goToNotificationSettingDetails() {
    personalSettingNotificationDetailButton().click();
  }

  public void checkEmailNotificationIsHiddenForAllTypes() {
    personalSettingEmailNotificationElement().assertNotVisible();
  }

  public void disableEmailNotification(String notificationType) {
    personalSettingNotificationTypeButton(notificationType).click();
    waitForDrawerToOpen();
    if (emailNotifDrawerInput().isSelected()) {
      emailNotifDrawerSwitch().click();
      // Wait for animation to finish
      waitFor(500).milliseconds();
      clickDrawerButton("Apply");
      waitForDrawerToClose();
    }
  }

  public void enableEmailNotification(String notificationType) {
    personalSettingNotificationTypeButton(notificationType).click();
    waitForDrawerToOpen();
    if (!emailNotifDrawerInput().isSelected()) {
      emailNotifDrawerSwitch().click();
      // Wait for animation to finish
      waitFor(500).milliseconds();
      clickDrawerButton("Apply");
    }
  }

  public void checkEmailNotificationIsHiddenFor(String notificationType) {
    personalSettingEmailNotificationElement(notificationType).assertNotVisible();
  }

  public void checkEmailNotificationIsDisplayedFor(String notificationType) {
    personalSettingEmailNotificationElement(notificationType).assertVisible();
  }

  public void editNotificationSender() {
    editNotificationSenderButton().click();
  }

  public void setNotificationSenderInput(Map<String, String> values) {
    notificationSenderNameInput().setTextValue(values.get("name"));
    notificationSenderEmailInput().setTextValue(values.get("email"));
  }

  public void enablePersonalEmailNotification() {
    if (!personalEmailSettingNotifInput().isSelected()) {
      personalEmailSettingNotifSwitch().click();
      // Wait for animation to finish
      waitFor(500).milliseconds();
    }
  }

  private ElementFacade emailNotifDrawerSwitch() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'email') or contains(text(), 'Email')]/parent::*/parent::*//*[contains(@class, 'v-input--switch') and contains(@class, 'v-input--selection-controls')]");
  }

  private ElementFacade emailNotifDrawerInput() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'email') or contains(text(), 'Email')]/parent::*/parent::*//*[contains(@class, 'v-input--switch') and contains(@class, 'v-input--selection-controls')]//input");
  }

  private ElementFacade personalSettingNotificationDetailButton() {
    return findByXPathOrCSS("(//*[contains(text(), 'Manage notifications')]//ancestor::*[@role=\"listitem\"])[1]//button");
  }

  private ElementFacade personalSettingEmailNotificationElement() {
    return findByXPathOrCSS("//*[contains(text(), 'by email')]");
  }

  private ElementFacade personalEmailSettingNotifSwitch() {
    return findByXPathOrCSS("(//*[contains(text(), 'by email')]//ancestor::*[@role='listitem'])[1]//*[contains(@class, 'v-input--switch') and contains(@class, 'v-input--selection-controls')]");
  }

  private ElementFacade personalEmailSettingNotifInput() {
    return findByXPathOrCSS("(//*[contains(text(), 'by email')]//ancestor::*[@role='listitem'])[1]//*[contains(@class, 'v-input--switch') and contains(@class, 'v-input--selection-controls')]//input");
  }

  private ElementFacade personalSettingEmailNotificationElement(String notificationType) {
    return findByXPathOrCSS(String.format("(//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'v-list-item')])[1]/parent::*//*[contains(text(), 'by email')]",
                                          notificationType));
  }

  private ElementFacade personalSettingNotificationTypeButton(String notificationType) {
    return findByXPathOrCSS(String.format("(//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'v-list-item')])[1]//button",
                                          notificationType));
  }

  private ElementFacade editNotificationSenderButton() {
    return findByXPathOrCSS("(//*[contains(text(), 'Notification Sender')]/following::button)[1]");
  }

  private TextBoxElementFacade notificationSenderNameInput() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//input[@name='companyName']");
  }

  private TextBoxElementFacade notificationSenderEmailInput() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//input[@name='companyEmail']");
  }

  private ElementFacade emailNotifSwitch() {
    return findByXPathOrCSS("//*[contains(text(), 'Enable email')]//ancestor::*[contains(@class, 'v-input--switch')]");
  }

  private ElementFacade emailNotifSwitchInput() {
    return findByXPathOrCSS("//*[contains(text(), 'Enable email')]//ancestor::*[contains(@class, 'v-input--switch')]//input");
  }

}
