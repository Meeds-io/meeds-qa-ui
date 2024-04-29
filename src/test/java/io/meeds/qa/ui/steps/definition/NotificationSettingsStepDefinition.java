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

package io.meeds.qa.ui.steps.definition;

import java.util.Map;

import io.meeds.qa.ui.steps.NotificationSettingsStep;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class NotificationSettingsStepDefinition {

  @Steps
  private NotificationSettingsStep notificationSettingsStep;

  @When("I disable email notifications for all users")
  public void disableEmailNotificationForAll() {
    notificationSettingsStep.disableEmailNotificationForAll();
  }

  @When("I enable email notifications for all users")
  public void enableEmailNotificationForAll() {
    notificationSettingsStep.enableEmailNotificationForAll();
  }

  @Then("The email notification setting is hidden")
  public void checkEmailNotificationIsHidden() {
    notificationSettingsStep.checkEmailNotificationIsHidden();
  }

  @Then("The email notification setting is displayed")
  public void checkEmailNotificationIsDisplayed() {
    notificationSettingsStep.checkEmailNotificationIsDisplayed();
  }

  @When("I go to manage notifications from settings page")
  public void goToNotificationSettingDetails() {
    notificationSettingsStep.goToNotificationSettingDetails();
  }

  @Then("The email notification settings are hidden in all notification types")
  public void checkEmailNotificationIsHiddenForAllTypes() {
    notificationSettingsStep.checkEmailNotificationIsHiddenForAllTypes();
  }

  @When("I enable email notification personal setting")
  public void enablePersonalEmailNotification() {
    notificationSettingsStep.enablePersonalEmailNotification();
  }

  @When("^I disable email notification for '(.*)'$")
  public void disableEmailNotification(String notificationType) {
    notificationSettingsStep.disableEmailNotification(notificationType);
  }

  @When("^I enable email notification for '(.*)'$")
  public void enableEmailNotification(String notificationType) {
    notificationSettingsStep.enableEmailNotification(notificationType);
  }

  @Then("^The email notification setting for '(.*)' is hidden$")
  public void checkEmailNotificationIsHiddenFor(String notificationType) {
    notificationSettingsStep.checkEmailNotificationIsHiddenFor(notificationType);
  }

  @Then("^The email notification setting for '(.*)' is displayed$")
  public void checkEmailNotificationIsDisplayedFor(String notificationType) {
    notificationSettingsStep.checkEmailNotificationIsDisplayedFor(notificationType);
  }

  @When("I edit notification sender information")
  public void editNotificationSender() {
    notificationSettingsStep.editNotificationSender();
  }

  @When("^I set the following information$")
  public void setNotificationSenderInput(Map<String, String> values) {
    notificationSettingsStep.setNotificationSenderInput(values);
  }

}
