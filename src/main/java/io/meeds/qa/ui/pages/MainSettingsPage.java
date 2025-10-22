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
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class MainSettingsPage extends GenericPage {

  public MainSettingsPage(WebDriver driver) {
    super(driver);
  }

  public void goToBrandingCustomization() {
    brandingCustomizationEditButton().click();
  }

  public void goBackToMainSettings() {
    backToMainButton().click();
  }

  public void checkBrandingCustomization() {
    brandingCompanyNameInput().assertVisible();
    brandingLogoInput().assertVisible();
    brandingFaviconInput().assertVisible();
    brandingTopbarColorsInput().assertVisible();
    brandingSidebarColorsInput().assertVisible();
    brandingPageColorsInput().assertVisible();
    brandingDrawerColorsInput().assertVisible();
    cancelButton().assertVisible();
    cancelButton().assertEnabled();
    applyButton().assertVisible();
    applyButton().assertDisabled();
    backToMainButton().assertVisible();
  }

  public void checkAccessCustomization() {
    accessTypeOpenInput().assertVisible();
    accessTypeRestrictedInput().assertVisible();
    accessEditDefaultSpaceButton().assertVisible();
    accessExternalUserOpenSwitchButton().assertVisible();
    accessExternalUserRestrictedSwitchButton().assertVisible();
    cancelButton().assertVisible();
    cancelButton().assertEnabled();
    applyButton().assertVisible();
  }

  public void selectOpenAccessCustomization() {
    accessTypeOpenInput().click();
  }

  public void selectRestrictedAccessCustomization() {
    accessTypeRestrictedInput().click();
  }

  public void switchRestrictedExternalUsers() {
    accessExternalUserRestrictedSwitchButton().click();
  }

  public void checkApplyButtonIsEnabled() {
    applyButton().assertEnabled();
  }

  public void checkApplyButtonIsDisabled() {
    applyButton().assertDisabled();
  }

  public void cancelCustomization() {
    cancelButton().click();
  }

  public void applyCustomization() {
    if (applyButton().isEnabled()) {
      applyButton().click();
    }
  }

  public void selectAccessDefaultSpace(String randomSpaceName) {
    accessEditDefaultSpaceButton().click();
    waitForDrawerToOpen();
    while (accessDefaultSpaceDeleteIcon().isVisible()) {
      accessDefaultSpaceDeleteIcon().click();
    }
    mentionInField(accessDefaultSpaceInput(), randomSpaceName, 3);
    clickDrawerButton("Apply");
    waitForDrawerToClose();
  }

  public void checkRestrictedExternalUserSwitchButtonIsDisabled() {
    accessExternalUserOpenSwitchButtonInput().assertEnabled();
    accessExternalUserRestrictedSwitchButtonInput().assertDisabled();
  }

  public void checkOpenExternalUserSwitchButtonIsDisabled() {
    accessExternalUserOpenSwitchButtonInput().assertDisabled();
    accessExternalUserRestrictedSwitchButtonInput().assertEnabled();
  }

  public void checkAccessDefaultSpacesCount(int count) {
    findByXPathOrCSS(String.format("//*[@id='PlatformAccess']//*[contains(@class, 'v-list-item')]//*[contains(text(), '%s ') and contains(text(), 'space')]",
                                   count)).assertVisible();
  }

  private ElementFacade brandingCustomizationEditButton() {
    return findByXPathOrCSS("(//*[@id='generalSettings']//*[contains(@class, 'fa-caret')])[1]");
  }

  private TextBoxElementFacade brandingCompanyNameInput() {
    return findTextBoxByXPathOrCSS("//*[@id='generalSettings']//*[@name='companyName']");
  }

  private TextBoxElementFacade brandingLogoInput() {
    return findTextBoxByXPathOrCSS("//*[@id='generalSettings']//*[@id='logoFileInput']//ancestor::*[contains(@class, 'file-selector')]//ancestor::*[contains(@class, 'v-image')]");
  }

  private TextBoxElementFacade brandingFaviconInput() {
    return findTextBoxByXPathOrCSS("//*[@id='generalSettings']//*[@id='faviconFileInput']//ancestor::*[contains(@class, 'file-selector')]//ancestor::*[contains(@class, 'v-image')]");
  }

  private ElementFacade brandingTopbarColorsInput() {
    return findByXPathOrCSS("//*[@id='generalSettings']//*[contains(text(), 'Topbar')]/ancestor::*[contains(@class, 'option-item')]//*[contains(@class, 'fa-edit')]");
  }

  private ElementFacade brandingSidebarColorsInput() {
    return findByXPathOrCSS("//*[@id='generalSettings']//*[contains(text(), 'Sidebar')]/ancestor::*[contains(@class, 'option-item')]//*[contains(@class, 'fa-edit')]");
  }

  private ElementFacade brandingPageColorsInput() {
    return findByXPathOrCSS("//*[@id='generalSettings']//*[contains(text(), 'Page')]/ancestor::*[contains(@class, 'option-item')]//*[contains(@class, 'fa-edit')]");
  }

  private ElementFacade brandingDrawerColorsInput() {
    return findByXPathOrCSS("//*[@id='generalSettings']//*[contains(text(), 'Drawer')]/ancestor::*[contains(@class, 'option-item')]//*[contains(@class, 'fa-edit')]");
  }

  private ElementFacade cancelButton() {
    return findByXPathOrCSS("//button//*[contains(text(), 'Cancel')]//ancestor::button");
  }

  private ElementFacade applyButton() {
    return findByXPathOrCSS("//button//*[contains(text(), 'Apply')]//ancestor::button");
  }

  private ElementFacade backToMainButton() {
    return findByXPathOrCSS("//*[@id='generalSettings']//*[contains(@class, 'fa-arrow-left')]");
  }

  private ElementFacade accessTypeOpenInput() {
    return findByXPathOrCSS("//*[@id='PlatformAccess']//input[@value = 'OPEN' and @type = 'radio']//ancestor::*[contains(@class, 'v-radio')]");
  }

  private ElementFacade accessTypeRestrictedInput() {
    return findByXPathOrCSS("//*[@id='PlatformAccess']//input[@value = 'RESTRICTED' and @type = 'radio']//ancestor::*[contains(@class, 'v-radio')]");
  }

  private ElementFacade accessExternalUserOpenSwitchButtonInput() {
    return findByXPathOrCSS("(//*[@id='PlatformAccess']//input[@role = 'switch' and @type = 'checkbox'])[1]");
  }

  private ElementFacade accessExternalUserRestrictedSwitchButtonInput() {
    return findByXPathOrCSS("(//*[@id='PlatformAccess']//input[@role = 'switch' and @type = 'checkbox'])[2]");
  }

  private ElementFacade accessExternalUserOpenSwitchButton() {
    return findByXPathOrCSS("(//*[@id='PlatformAccess']//input[@role = 'switch' and @type = 'checkbox'])[1]//ancestor::*[contains(@class, 'v-input--switch')]");
  }

  private ElementFacade accessExternalUserRestrictedSwitchButton() {
    return findByXPathOrCSS("(//*[@id='PlatformAccess']//input[@role = 'switch' and @type = 'checkbox'])[2]//ancestor::*[contains(@class, 'v-input--switch')]");
  }

  private ElementFacade accessEditDefaultSpaceButton() {
    return findByXPathOrCSS("//*[@id='PlatformAccess']//*[contains(@class, 'v-list-item')]//*[contains(@class, 'fa-edit')]");
  }

  private TextBoxElementFacade accessDefaultSpaceInput() {
    return findTextBoxByXPathOrCSS("//*[@id='defaultSpacesInput']//input");
  }

  private TextBoxElementFacade accessDefaultSpaceDeleteIcon() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'identitySuggesterItem')]//button[contains(@class, 'close')]");
  }

}
