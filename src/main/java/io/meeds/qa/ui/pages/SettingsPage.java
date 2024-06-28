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

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class SettingsPage extends GenericPage {

  private static final String NOTIFICATION_SWITCH_BUTTON_XPATH          =
                                                               "(//*[@id='UserSettingNotifications']//*[contains(@class, 'v-input--switch')]//input)[%s]";

  private static final String NOTIFICATION_SWITCH_BUTTON_BY_STATE_XPATH = NOTIFICATION_SWITCH_BUTTON_XPATH
      + "//self::*[@aria-checked='%s']//ancestor::*[contains(@class, 'v-input')]";

  public SettingsPage(WebDriver driver) {
    super(driver);
  }

  public void acceptEditLanguage() {
    // Accept editing language
    ElementFacade applyChangeLanguageButtonElement = applyChangeLanguageButtonElement();
    applyChangeLanguageButtonElement.waitUntilClickable();
    applyChangeLanguageButtonElement.click();
    waitForDrawerToClose();
  }

  public void acceptEditPassword() {
    // Accept editing password
    ElementFacade confirmEditPasswordElement = confirmEditPasswordElement();
    confirmEditPasswordElement.waitUntilClickable();
    confirmEditPasswordElement.click();

  }

  public void applyEditGeneralNotifications() {
    ElementFacade applyEditGeneralNotificationsButtonElement = applyEditGeneralNotificationsButtonElement();
    applyEditGeneralNotificationsButtonElement.waitUntilClickable();
    applyEditGeneralNotificationsButtonElement.click();
    refreshPage();
  }

  public void cancelEditLanguage() {
    // Cancel editing language
    ElementFacade cancelChangeLanguageButtonElement = cancelChangeLanguageButtonElement();
    cancelChangeLanguageButtonElement.waitUntilClickable();
    cancelChangeLanguageButtonElement.click();
    waitForDrawerToClose();
  }

  public void cancelEditPassword() {
    // Cancel editing password
    ElementFacade cancelEditPasswordElement = cancelEditPasswordElement();
    cancelEditPasswordElement.waitUntilClickable();
    cancelEditPasswordElement.click();

  }

  public void checkThatActivityStreamSectionIsDisplayed() {
    // Check that Activity Stream Section Is Displayed
    manageNoticiationActivityStreamSectionElement().assertVisible();
  }

  public void checkThatConnectionsSectionIsDisplayed() {
    // Check that Connections Section Is Displayed
    manageNotificationConnectionsSectionElement().assertVisible();
  }

  public void checkThatGeneralSectionIsDisplayed() {
    // Check that General Section Is Displayed
    manageNotificationGeneralSectionElement().assertVisible();
  }

  public void checkThatKudosSectionIsDisplayed() {
    // Check that Kudos Section Is Displayed
    manageNotificationKudosSectionElement().assertVisible();
  }

  public void checkThatLanguageIsDisplayed(String language) {
    // Check that language is displayed
    Assert.assertTrue(languageTextElement().getText().contains(language));
  }

  public void checkThatManageNotificationPageIsOpened() {
    // Check that Manage Notification Page is opened
    manageNotificationPageElement().assertVisible();
  }

  public void checkThatNotesSectionIsDisplayed() {
    // Check that Notes Section Is Displayed
    manageNotificationNotesSectionElement().assertVisible();
  }

  public void checkThatNotificationOnMobileIsDisabled() {
    // Notification On Mobile is disabled
    checkNotificationSwitchButtonState(2, false);
  }

  public void checkThatNotificationOnMobileIsEnabled() {
    // Notification On Mobile is enabled
    checkNotificationSwitchButtonState(2, true);
  }

  public void checkThatNotificationOnSiteIsDisabled() {
    // Notification On Site is disabled
    checkNotificationSwitchButtonState(3, false);
  }

  public void checkThatNotificationOnSiteIsEnabled() {
    // Notification On Site is enabled
    checkNotificationSwitchButtonState(3, true);
  }

  public void checkThatNotificationViaMailIsDisabled() {
    // Notification Via Mail is disabled
    checkNotificationSwitchButtonState(1, false);
  }

  public void checkThatNotificationViaMailIsEnabled() {
    // Notification Via Mail is enabled
    checkNotificationSwitchButtonState(1, true);
  }

  public void checkThatPerkStoreSectionIsDisplayed() {
    // Check that Perk Store Section Is Displayed
    manageNotificationPerkStoreSectionElement().assertVisible();
  }

  public void checkThatSettingsPageIsOpened() {
    // Check that Settings Page is opened
    findByXPathOrCSS("#UserSettingLanguage").assertVisible();
  }

  public void checkThatSpacesSectionIsDisplayed() {
    // Check that Connections Section Is Displayed
    manageNotificationSpacesSectionElement().assertVisible();
  }

  public void checkThatTasksSectionIsDisplayed() {
    // Check that Tasks Section Is Displayed
    manageNotificationTasksSectionElement().assertVisible();
  }

  public void checkThatWalletSectionIsDisplayed() {
    // Check that Wallet Section Is Displayed
    manageNotificationWalletSectionElement().assertVisible();
  }

  public void dailyEmailIsDisplayedInGeneralNotificationsSection() {
    // Check that Daily Email is displayed in General Notifications Section
    Assert.assertTrue(generalNotificationsSectionElement().getText().contains("Daily digest email notification"));
  }

  public void editLanguage(String language) {
    // Select language and change it
    findByXPathOrCSS("#UserSettingLanguage button").click();

    ElementFacade changeLanguageElement = changeLanguageElement(language);
    changeLanguageElement.waitUntilClickable();
    changeLanguageElement.click();

  }

  public void editPassword(String oldPassword, String password) {

    // Go to Security Interface
    editPasswordElement().click();

    // Enter the current password
    oldPasswordElement().setTextValue(oldPassword);

    // Enter the new password
    newPasswordElement().setTextValue(password);

    // Confirm the new password
    newPasswordConfirmElement().setTextValue(password);

  }

  public void enableDisableNotificationOnMobile() {
    clickOnNotificationSwitchButton(2);
  }

  public void enableDisableNotificationOnSite() {
    clickOnNotificationSwitchButton(3);
  }

  public void enableDisableNotificationViaMail() {
    clickOnNotificationSwitchButton(1);
  }

  public void generalNotificationsSendingMailTypeIsDaily() {
    // Check that General Notifications Sending Mail Type is Daily
    Assert.assertTrue(generalNotificationsSelectMailSendingTypeElement().getText().contains("Daily"));

  }

  public void generalNotificationsSendingMailTypeIsNever() {
    // Check that General Notifications Sending Mail Type is Never
    Assert.assertTrue(generalNotificationsSelectMailSendingTypeElement().getText().contains("Never"));

  }

  public void generalNotificationsSendingMailTypeIsWeekly() {
    // Check that General Notifications Sending Mail Type is Weekly
    Assert.assertTrue(generalNotificationsSelectMailSendingTypeElement().getText().contains("Weekly"));

  }

  public void goToManageNotifications() {
    clickOnElement(manageNotificationsElement());
  }

  public void noEmailIsDisplayedInGeneralNotificationsSection() {
    // Check that no Email is displayed in General Notifications Section
    ElementFacade generalNotificationsSectionElement = generalNotificationsSectionElement();
    Assert.assertFalse(generalNotificationsSectionElement.getText().contains("Daily digest email notification"));
    Assert.assertFalse(generalNotificationsSectionElement.getText().contains("Weekly digest email notification"));
  }

  public void notifyMeByEmailIsDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me By Email is displayed in General Notifications
    // Section
    Assert.assertTrue(generalNotificationsSectionElement().getText().contains("Notify me by email"));

  }

  public void notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me By Email is not displayed in General Notifications
    // Section
    Assert.assertFalse(generalNotificationsSectionElement().getText().contains("Notify me by email"));

  }

  public void notifyMeOnMobileIsDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me On Mobile is displayed in General Notifications
    // Section
    Assert.assertTrue(generalNotificationsSectionElement().getText().contains("Notify me on mobile"));
  }

  public void notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me On Mobile is not displayed in General Notifications
    // Section
    Assert.assertFalse(generalNotificationsSectionElement().getText().contains("Notify me on mobile"));
  }

  public void notifyMeOnSiteIsDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me on Site is displayed in General Notifications
    // Section
    Assert.assertTrue(generalNotificationsSectionElement().getText().contains("Notify me on-site"));

  }

  public void notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me on Site is not displayed in General Notifications
    // Section
    Assert.assertFalse(generalNotificationsSectionElement().getText().contains("Notify me on-site"));

  }

  public void selectSendMeASummaryEmail(String mailSendingType) {

    switch (mailSendingType) {
    case "Daily":
      // Select Daily
      generalNotificationsSelectMailSendingTypeElement().selectByValue("Daily");
      break;
    case "Weekly":
      // Select Weekly
      generalNotificationsSelectMailSendingTypeElement().selectByValue("Weekly");
      break;
    case "Never":
      // Select Never
      generalNotificationsSelectMailSendingTypeElement().selectByValue("Never");
      break;
    default:
      // Do nothing
      break;

    }
  }

  public void weeklyEmailIsDisplayedInGeneralNotificationsSection() {
    // Check that Weeky Email is displayed in General Notifications Section
    Assert.assertTrue(generalNotificationsSectionElement().getText().contains("Weekly digest email notification"));
  }

  private ElementFacade applyChangeLanguageButtonElement() {
    return findByXPathOrCSS("(//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]");
  }

  private ElementFacade applyEditGeneralNotificationsButtonElement() {
    return findByXPathOrCSS("(//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]");
  }

  private ElementFacade cancelChangeLanguageButtonElement() {
    return findByXPathOrCSS("(//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]");
  }

  private ElementFacade cancelEditPasswordElement() {
    return findByXPathOrCSS("(//input[@type='password'])[3]/following::*[@class='v-btn__content'][1]");
  }

  private ElementFacade changeLanguageElement(String language) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", language));
  }

  private void checkNotificationSwitchButtonState(int switchButtonIndex, boolean expectedState) {
    findByXPathOrCSS(String.format(NOTIFICATION_SWITCH_BUTTON_BY_STATE_XPATH,
                                   String.valueOf(switchButtonIndex),
                                   String.valueOf(expectedState))).assertVisible();
  }

  private void clickOnNotificationSwitchButton(int switchButtonIndex) {
    ElementFacade element = findByXPathOrCSS(String.format(NOTIFICATION_SWITCH_BUTTON_XPATH,
                                                           String.valueOf(switchButtonIndex)));
    boolean beforeClickState = Boolean.parseBoolean(element.getAttribute("aria-checked"));
    element.findByXPath("//ancestor::*[contains(@class, 'v-input')]").click();

    boolean expectedNewState = !beforeClickState;
    element = findByXPathOrCSS(String.format(NOTIFICATION_SWITCH_BUTTON_BY_STATE_XPATH,
                                             String.valueOf(switchButtonIndex),
                                             String.valueOf(expectedNewState)));
    element.waitUntilVisible();
  }

  private ElementFacade confirmEditPasswordElement() {
    return findByXPathOrCSS("(//input[@type='password'])[3]/following::*[@class='v-btn__content'][2]");
  }

  private ElementFacade editPasswordElement() {
    return findByXPathOrCSS("//*[@class='v-list-item__action']//*[@data-original-title='Edit password']//button");
  }

  private ElementFacade generalNotificationsSectionElement() {
    return findByXPathOrCSS("//*[contains(text(), 'Manage notifications')]//ancestor::*[contains(@class, 'application-body')]");
  }

  private ElementFacade generalNotificationsSelectMailSendingTypeElement() {
    return findByXPathOrCSS("//select[@name='EMAIL_DIGEST']");
  }

  private ElementFacade languageTextElement() {
    return findByXPathOrCSS("//*[contains(text(), 'Language')]//ancestor::*[contains(@class, 'application-body')]//button");
  }

  private ElementFacade manageNoticiationActivityStreamSectionElement() {
    return findByXPathOrCSS("(//*[contains(text(),'Activity Stream')]");
  }

  private ElementFacade manageNotificationConnectionsSectionElement() {
    return findByXPathOrCSS("(//*[contains(text(),'Connections')]");
  }

  private ElementFacade manageNotificationGeneralSectionElement() {
    return findByXPathOrCSS("(//*[contains(text(),'Connections')]");
  }

  private ElementFacade manageNotificationKudosSectionElement() {
    return findByXPathOrCSS("(///div[@class='v-list-item__content']//*[contains(text(),'Kudos')]");
  }

  private ElementFacade manageNotificationNotesSectionElement() {
    return findByXPathOrCSS("(//div[@class='v-list-item__content']//*[contains(text(),'Notes')]");
  }

  private ElementFacade manageNotificationPageElement() {
    return findByXPathOrCSS("(//*[contains(text(),'Manage notifications')]");
  }

  private ElementFacade manageNotificationPerkStoreSectionElement() {
    return findByXPathOrCSS("(//*[contains(text(),'Perk store')]");
  }

  private ElementFacade manageNotificationsElement() {
    return findByXPathOrCSS("(//*[@class='v-list-item__action'])[7]//button");
  }

  private ElementFacade manageNotificationSpacesSectionElement() {
    return findByXPathOrCSS("(//*[contains(text(),'Spaces')]");
  }

  private ElementFacade manageNotificationTasksSectionElement() {
    return findByXPathOrCSS("(//*[contains(text(),'My Tasks')]");
  }

  private ElementFacade manageNotificationWalletSectionElement() {
    return findByXPathOrCSS("(//div[@class='v-list-item__content']//*[contains(text(),'Wallet')]");
  }

  private TextBoxElementFacade newPasswordConfirmElement() {
    return findTextBoxByXPathOrCSS("(//input[@type='password'])[3]");
  }

  private TextBoxElementFacade newPasswordElement() {
    return findTextBoxByXPathOrCSS("(//input[@type='password'])[2]");
  }

  private TextBoxElementFacade oldPasswordElement() {
    return findTextBoxByXPathOrCSS("(//input[@type='password'])[1]");
  }

  public enum mailSendingType {
    DAILY, NEVER, WEEKLY

  }

}
