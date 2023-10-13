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

import io.meeds.qa.ui.pages.SettingsPage;

public class SettingsSteps {

  private SettingsPage settingsPage;

  public void acceptEditLanguage() {
    settingsPage.acceptEditLanguage();
  }

  public void acceptEditPassword() {
    settingsPage.acceptEditPassword();
  }

  public void applyEditGeneralNotifications() {
    settingsPage.applyEditGeneralNotifications();

  }

  public void cancelEditLanguage() {
    settingsPage.cancelEditLanguage();

  }

  public void cancelEditPassword() {
    settingsPage.cancelEditPassword();

  }

  public void checkThatActivityStreamSectionIsDisplayed() {
    settingsPage.checkThatActivityStreamSectionIsDisplayed();

  }

  public void checkThatConnectionsSectionIsDisplayed() {
    settingsPage.checkThatConnectionsSectionIsDisplayed();

  }

  public void checkThatGeneralSectionIsDisplayed() {
    settingsPage.checkThatGeneralSectionIsDisplayed();

  }

  public void checkThatKudosSectionIsDisplayed() {
    settingsPage.checkThatKudosSectionIsDisplayed();

  }

  public void checkThatLanguageIsDisplayed(String language) {
    settingsPage.checkThatLanguageIsDisplayed(language);

  }

  public void checkThatManageNotificationPageIsOpened() {
    settingsPage.checkThatManageNotificationPageIsOpened();

  }

  public void checkThatNotesSectionIsDisplayed() {
    settingsPage.checkThatNotesSectionIsDisplayed();

  }

  public void checkThatNotificationOnMobileIsDisabled() {
    settingsPage.checkThatNotificationOnMobileIsDisabled();

  }

  public void checkThatNotificationOnMobileIsEnabled() {
    settingsPage.checkThatNotificationOnMobileIsEnabled();

  }

  public void checkThatNotificationOnSiteIsDisabled() {
    settingsPage.checkThatNotificationOnSiteIsDisabled();

  }

  public void checkThatNotificationOnSiteIsEnabled() {
    settingsPage.checkThatNotificationOnSiteIsEnabled();

  }

  public void checkThatNotificationViaMailIsDisabled() {
    settingsPage.checkThatNotificationViaMailIsDisabled();

  }

  public void checkThatNotificationViaMailIsEnabled() {
    settingsPage.checkThatNotificationViaMailIsEnabled();

  }

  public void checkThatPerkStoreSectionIsDisplayed() {
    settingsPage.checkThatPerkStoreSectionIsDisplayed();

  }

  public void checkThatSettingsPageIsOpened() {
    settingsPage.checkThatSettingsPageIsOpened();

  }

  public void checkThatSpacesSectionIsDisplayed() {
    settingsPage.checkThatSpacesSectionIsDisplayed();

  }

  public void checkThatTasksSectionIsDisplayed() {
    settingsPage.checkThatTasksSectionIsDisplayed();

  }

  public void checkThatWalletSectionIsDisplayed() {
    settingsPage.checkThatWalletSectionIsDisplayed();

  }

  public void dailyEmailIsDisplayedInGeneralNotificationsSection() {
    settingsPage.dailyEmailIsDisplayedInGeneralNotificationsSection();

  }

  public void editLanguage(String language) {
    settingsPage.editLanguage(language);

  }

  public void editPassword(String oldPassword, String password) {
    settingsPage.editPassword(oldPassword, password);

  }

  public void enableDisableNotificationOnMobile() {
    settingsPage.enableDisableNotificationOnMobile();
  }

  public void enableDisableNotificationOnSite() {
    settingsPage.enableDisableNotificationOnSite();
  }

  public void enableDisableNotificationViaMail() {
    settingsPage.enableDisableNotificationViaMail();

  }

  public void generalNotificationsSendingMailTypeIsDaily() {
    settingsPage.generalNotificationsSendingMailTypeIsDaily();

  }

  public void generalNotificationsSendingMailTypeIsNever() {
    settingsPage.generalNotificationsSendingMailTypeIsNever();

  }

  public void generalNotificationsSendingMailTypeIsWeekly() {
    settingsPage.generalNotificationsSendingMailTypeIsWeekly();

  }

  public void goToManageNotifications() {
    settingsPage.goToManageNotifications();

  }

  public void noEmailIsDisplayedInGeneralNotificationsSection() {
    settingsPage.noEmailIsDisplayedInGeneralNotificationsSection();

  }

  public void notifyMeByEmailIsDisplayedInGeneralNotificationsSection() {
    settingsPage.notifyMeByEmailIsDisplayedInGeneralNotificationsSection();

  }

  public void notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection() {
    settingsPage.notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection();

  }

  public void notifyMeOnMobileIsDisplayedInGeneralNotificationsSection() {
    settingsPage.notifyMeOnMobileIsDisplayedInGeneralNotificationsSection();

  }

  public void notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection() {
    settingsPage.notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection();

  }

  public void notifyMeOnSiteIsDisplayedInGeneralNotificationsSection() {
    settingsPage.notifyMeOnSiteIsDisplayedInGeneralNotificationsSection();

  }

  public void notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection() {
    settingsPage.notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection();

  }

  public void selectSendMeASummaryEmail(String mailSendingType) {
    settingsPage.selectSendMeASummaryEmail(mailSendingType);

  }

  public void weeklyEmailIsDisplayedInGeneralNotificationsSection() {
    settingsPage.weeklyEmailIsDisplayedInGeneralNotificationsSection();

  }

}
