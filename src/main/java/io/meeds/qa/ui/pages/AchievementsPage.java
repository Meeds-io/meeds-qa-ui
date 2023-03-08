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

import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;

public class AchievementsPage extends GenericPage {

  public AchievementsPage(WebDriver driver) {
    super(driver);
  }

  public void checkThatAchievementIsAccepted(String actionTitle) {
    waitForPageLoading();
    ElementFacade acceptedAchievementElement = acceptedAchievementElement(actionTitle);
    acceptedAchievementElement.assertVisible();

  }

  public void checkThatAchievementIsRejected(String actionTitle) {
    waitForPageLoading();
    ElementFacade rejectedAchievementElement = rejectedAchievementElement(actionTitle);
    rejectedAchievementElement.assertVisible();
    rejectedAchievementElement.hover();
    ElementFacade tooltipRejectedElement = tooltipRejectedElement();
    tooltipRejectedElement.assertVisible();
  }

  public void checkThatAchievementIsCanceled(String actionTitle) {
    waitForPageLoading();
    ElementFacade rejectedAchievementElement = rejectedAchievementElement(actionTitle);
    rejectedAchievementElement.assertVisible();
    rejectedAchievementElement.hover();
    ElementFacade tooltipCanceledElement = tooltipCanceledElement();
    tooltipCanceledElement.assertVisible();
  }

  public void checkThatAchievementIsDeleted(String actionTitle) {
    waitForPageLoading();
    ElementFacade rejectedAchievementElement = rejectedAchievementElement(actionTitle);
    rejectedAchievementElement.assertVisible();
    rejectedAchievementElement.hover();
    ElementFacade tooltipDeletedActivity = tooltipDeletedActivity();
    tooltipDeletedActivity.assertVisible();
  }

  private ElementFacade rejectedAchievementElement(String actionTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'GamificationRealizationItem')]//*[contains(@class, 'fa-times-circle')]",
                                          actionTitle));
  }

  private ElementFacade acceptedAchievementElement(String actionTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'GamificationRealizationItem')]//*[contains(@class, 'fa-check-circle')]",
                                          actionTitle));
  }

  private ElementFacade tooltipRejectedElement() {
    return findByXPathOrCSS("//span[contains(text(), 'Rejected')]//ancestor::*[contains(@class, 'v-tooltip__content')]");
  }

  private ElementFacade tooltipCanceledElement() {
    return findByXPathOrCSS("//span[contains(text(), 'Canceled')]//ancestor::*[contains(@class, 'v-tooltip__content')]");
  }

  private ElementFacade tooltipDeletedActivity() {
    return findByXPathOrCSS("//span[contains(text(), 'Rejected due to activity')]//ancestor::*[contains(@class, 'v-tooltip__content')]");
  }
}
