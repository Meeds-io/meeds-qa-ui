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

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.pages.NotificationSettingsPage;
import net.serenitybdd.core.Serenity;

public class NotificationSettingsStep {

  private static final Logger LOGGER                               = LoggerFactory.getLogger(NotificationSettingsStep.class);

  private static final String RECORDED_NOTIFICATION_SETTINGS       = "recordedNotificationSettings";

  private static final String GET_NOTIFICATION_SETTINGS_SCRIPT     = """
      const callback = arguments[arguments.length - 1];
      fetch("/portal/rest/notifications/settings", {
        "credentials": "include"
      })
        .then(resp => resp?.ok && resp.text() || null)
        .then(settings => callback(settings))
        .catch(() => callback(null));
      """;

  // A channel disabled globally reads all its notification types as
  // inactive: the types are compared only for the channels active in both
  // the recorded and the current settings
  private static final String RESTORE_NOTIFICATION_SETTINGS_SCRIPT = """
      const recorded = JSON.parse(arguments[0]);
      const callback = arguments[arguments.length - 1];
      const getSettings = () => fetch("/portal/rest/notifications/settings", {
        "credentials": "include"
      }).then(resp => resp.json());
      const patch = (path, body) => fetch(`/portal/rest/notifications/settings${path}`, {
        "headers": {
          "content-type": "application/x-www-form-urlencoded",
        },
        "body": body,
        "method": "PATCH",
        "credentials": "include"
      }).then(resp => resp.ok);
      (async () => {
        let restored = true;
        let current = await getSettings();
        for (const [channelId, enable] of Object.entries(recorded.channelStatus || {})) {
          if (current.channelStatus?.[channelId] !== enable) {
            restored = await patch(`/channel/${channelId}`, `enable=${enable}`) && restored;
          }
        }
        for (const [channelId, enable] of Object.entries(recorded.channelDefaultValue || {})) {
          if (current.channelDefaultValue?.[channelId] !== enable) {
            restored = await patch(`/channel/${channelId}/defaultvalue`, `enable=${enable}`) && restored;
          }
        }
        if (current.senderName !== recorded.senderName || current.senderEmail !== recorded.senderEmail) {
          restored = await patch("", `name=${encodeURIComponent(recorded.senderName || "")}&email=${encodeURIComponent(recorded.senderEmail || "")}`) && restored;
        }
        current = await getSettings();
        for (const choice of recorded.channelCheckBoxList || []) {
          if (!recorded.channelStatus?.[choice.channelId] || !current.channelStatus?.[choice.channelId]) {
            continue;
          }
          const currentChoice = (current.channelCheckBoxList || []).find(c => c.channelId === choice.channelId && c.pluginId === choice.pluginId);
          if (currentChoice && currentChoice.channelActive !== choice.channelActive) {
            restored = await patch(`/plugin/${choice.pluginId}`, `channels=${encodeURIComponent(`${choice.channelId}=${choice.channelActive}`)}`) && restored;
          }
        }
        callback(restored);
      })().catch(() => callback(false));
      """;

  private NotificationSettingsPage notificationSettingsPage;

  /**
   * Records the notification administration settings before a scenario
   * changes them, once per scenario, so that they can be restored after it.
   */
  public void recordNotificationSettings() {
    if (Serenity.hasASessionVariableCalled(RECORDED_NOTIFICATION_SETTINGS)) {
      return;
    }
    Object settings = ((JavascriptExecutor) Serenity.getDriver()).executeAsyncScript(GET_NOTIFICATION_SETTINGS_SCRIPT);
    if (settings == null) {
      throw new IllegalStateException("Error when retrieving the notification settings to restore after the scenario");
    }
    Serenity.setSessionVariable(RECORDED_NOTIFICATION_SETTINGS).to(settings.toString());
  }

  public void restoreNotificationSettings() {
    if (!Serenity.hasASessionVariableCalled(RECORDED_NOTIFICATION_SETTINGS)) {
      return;
    }
    String settings = Serenity.sessionVariableCalled(RECORDED_NOTIFICATION_SETTINGS);
    Object restored = null;
    try {
      restored = ((JavascriptExecutor) Serenity.getDriver()).executeAsyncScript(RESTORE_NOTIFICATION_SETTINGS_SCRIPT, settings);
    } catch (RuntimeException e) {
      LOGGER.warn("Error when restoring the notification settings", e);
    }
    if (!Boolean.TRUE.equals(restored)) {
      LOGGER.warn("The notification settings weren't restored, to restore by hand: {}", settings);
    }
  }

  public void disableEmailNotificationForAll() {
    recordNotificationSettings();
    notificationSettingsPage.disableEmailNotificationForAll();
  }

  public void enableEmailNotificationForAll() {
    recordNotificationSettings();
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
    recordNotificationSettings();
    notificationSettingsPage.disableEmailNotification(notificationType);
  }

  public void enableEmailNotification(String notificationType) {
    recordNotificationSettings();
    notificationSettingsPage.enableEmailNotification(notificationType);
  }

  public void checkEmailNotificationIsHiddenFor(String notificationType) {
    notificationSettingsPage.checkEmailNotificationIsHiddenFor(notificationType);
  }

  public void checkEmailNotificationIsDisplayedFor(String notificationType) {
    notificationSettingsPage.checkEmailNotificationIsDisplayedFor(notificationType);
  }

  public void editNotificationSender() {
    recordNotificationSettings();
    notificationSettingsPage.editNotificationSender();
  }

  public void setNotificationSenderInput(Map<String, String> values) {
    notificationSettingsPage.setNotificationSenderInput(values);
  }

  public void enablePersonalEmailNotification() {
    notificationSettingsPage.enablePersonalEmailNotification();
  }

}
