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

import io.meeds.qa.ui.pages.MainSettingsPage;

public class MainSettingsSteps {

  private MainSettingsPage mainSettingsPage;

  public void goToAccessCustomization() {
    mainSettingsPage.goToAccessCustomization();
  }

  public void goToBrandingCustomization() {
    mainSettingsPage.goToBrandingCustomization();
  }

  public void goToLoginCustomization() {
    mainSettingsPage.goToLoginCustomization();
  }

  public void goBackToMainSettings() {
    mainSettingsPage.goBackToMainSettings();
  }

  public void checkAccessCustomization() {
    mainSettingsPage.checkAccessCustomization();
  }

  public void checkBrandingCustomization() {
    mainSettingsPage.checkBrandingCustomization();
  }

  public void checkLoginCustomization() {
    mainSettingsPage.checkLoginCustomization();
  }

  public void checkApplyButtonIsEnabled() {
    mainSettingsPage.checkApplyButtonIsEnabled();
  }

  public void checkApplyButtonIsDisabled() {
    mainSettingsPage.checkApplyButtonIsDisabled();
  }

  public void cancelCustomization() {
    mainSettingsPage.cancelCustomization();
  }

  public void applyCustomization() {
    mainSettingsPage.applyCustomization();
  }

  public void selectOpenAccessCustomization() {
    mainSettingsPage.selectOpenAccessCustomization();
  }

  public void selectRestrictedAccessCustomization() {
    mainSettingsPage.selectRestrictedAccessCustomization();
  }

  public void switchRestrictedExternalUsers() {
    mainSettingsPage.switchRestrictedExternalUsers();
  }

  public void setLoginTitle(String title) {
    mainSettingsPage.setLoginTitle(title);
  }

  public void setLoginSubTitle(String subtitle) {
    mainSettingsPage.setLoginSubTitle(subtitle);
  }

  public void checkAccessDefaultSpacesCount(int count) {
    mainSettingsPage.checkAccessDefaultSpacesCount(count);
  }

  public void selectAccessDefaultSpace(String randomSpaceName) {
    mainSettingsPage.selectAccessDefaultSpace(randomSpaceName);
  }

  public void checkRestrictedExternalUserSwitchButtonIsDisabled() {
    mainSettingsPage.checkRestrictedExternalUserSwitchButtonIsDisabled();
  }

  public void checkOpenExternalUserSwitchButtonIsDisabled() {
    mainSettingsPage.checkOpenExternalUserSwitchButtonIsDisabled();
  }

}
