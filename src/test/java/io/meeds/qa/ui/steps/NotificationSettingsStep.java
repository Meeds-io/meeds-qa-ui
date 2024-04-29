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

package io.meeds.qa.ui.steps;

import java.util.Map;

import io.meeds.qa.ui.pages.NotificationSettingsPage;

public class NotificationSettingsStep {

  private NotificationSettingsPage notificationSettingsPage;

  public void disableEmailNotificationForAll() {
    notificationSettingsPage.disableEmailNotificationForAll();
  }

  public void enableEmailNotificationForAll() {
    notificationSettingsPage.enableEmailNotificationForAll();
  }

  public void checkEmailNotificationIsHidden() {
    notificationSettingsPage.checkEmailNotificationIsHidden();
  }

  public void checkEmailNotificationIsDisplayed() {
    notificationSettingsPage.checkEmailNotificationIsDisplayed();
  }

  public void goToNotificationSettingDetails() {
    notificationSettingsPage.goToNotificationSettingDetails();
  }

  public void checkEmailNotificationIsHiddenForAllTypes() {
    notificationSettingsPage.checkEmailNotificationIsHiddenForAllTypes();
  }

  public void disableEmailNotification(String notificationType) {
    notificationSettingsPage.disableEmailNotification(notificationType);
  }

  public void enableEmailNotification(String notificationType) {
    notificationSettingsPage.enableEmailNotification(notificationType);
  }

  public void checkEmailNotificationIsHiddenFor(String notificationType) {
    notificationSettingsPage.checkEmailNotificationIsHiddenFor(notificationType);
  }

  public void checkEmailNotificationIsDisplayedFor(String notificationType) {
    notificationSettingsPage.checkEmailNotificationIsDisplayedFor(notificationType);
  }

  public void editNotificationSender() {
    notificationSettingsPage.editNotificationSender();
  }

  public void setNotificationSenderInput(Map<String, String> values) {
    notificationSettingsPage.setNotificationSenderInput(values);
  }

  public void enablePersonalEmailNotification() {
    notificationSettingsPage.enablePersonalEmailNotification();
  }

}
