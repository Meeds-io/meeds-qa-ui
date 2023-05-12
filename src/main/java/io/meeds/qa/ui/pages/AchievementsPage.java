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

import static io.meeds.qa.ui.utils.Utils.*;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;

public class AchievementsPage extends GenericPage {

  public AchievementsPage(WebDriver driver) {
    super(driver);
  }

  public void filterAchievementByProgram(String programTitle) {
    achievementsFilterButton().click();
    waitForDrawerToOpen();
    mentionInField(achievementsFilterProgramSuggester(), programTitle, 3);
    getDrawerButton("Confirm").click();
    waitForLoading();
  }

  public void checkThatAchievementIsAccepted(String actionTitle) {
    waitForPageLoading();
    retryOnCondition(() -> acceptedAchievementElement(actionTitle).checkVisible(),
                     () -> {
                       waitFor(3).seconds();
                       Utils.refreshPage();
                     });
  }

  public void checkThatAchievementIsRejected(String actionTitle) {
    waitForPageLoading();
    retryOnCondition(() -> {
      ElementFacade rejectedAchievementElement = rejectedAchievementElement(actionTitle);
      rejectedAchievementElement.checkVisible();
      rejectedAchievementElement.hover();
      ElementFacade tooltipRejectedElement = tooltipRejectedElement();
      tooltipRejectedElement.checkVisible();
    }, () -> {
      waitFor(3).seconds();
      Utils.refreshPage();
    });
  }

  public void checkThatAchievementIsCanceled(String actionTitle) {
    waitForPageLoading();
    retryOnCondition(() -> {
      ElementFacade rejectedAchievementElement = rejectedAchievementElement(actionTitle);
      rejectedAchievementElement.checkVisible();
      rejectedAchievementElement.hover();
      ElementFacade tooltipCanceledElement = tooltipCanceledElement();
      tooltipCanceledElement.checkVisible();
    }, () -> {
      waitFor(3).seconds();
      Utils.refreshPage();
    });
  }

  public void checkThatAchievementIsDeleted(String actionTitle) {
    waitForPageLoading();
    retryOnCondition(() -> {
      ElementFacade rejectedAchievementElement = rejectedAchievementElement(actionTitle);
      rejectedAchievementElement.checkVisible();
      rejectedAchievementElement.hover();
      ElementFacade tooltipDeletedActivity = tooltipDeletedActivity();
      tooltipDeletedActivity.checkVisible();
    }, () -> {
      waitFor(3).seconds();
      Utils.refreshPage();
    });
  }

  public void checkThatAchievementIsDisplayed(String actionTitle, long times) {
    int found = findAll(By.xpath(String.format("//*[contains(@id, 'GamificationRealizationItem')]//*[contains(text(), '%s')]",
                                               actionTitle))).size();
    assertEquals("Achievements count doesn't match",
                 times,
                 found);
  }

  private ElementFacade rejectedAchievementElement(String actionTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'GamificationRealizationItem')]//*[contains(@class, 'fa-times-circle')]",
                                          actionTitle));
  }

  private ElementFacade achievementsFilterButton() {
    return findByXPathOrCSS("//*[@id = 'Realizations']//*[contains(text(), 'Filter')]//ancestor-or-self::button");
  }

  private TextBoxElementFacade achievementsFilterProgramSuggester() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'Program')]/parent::*//*[contains(@class, 'identitySuggesterInputStyle')]//input[@type = 'text']");
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
