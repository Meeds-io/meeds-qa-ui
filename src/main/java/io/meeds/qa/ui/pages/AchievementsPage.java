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

import static io.meeds.qa.ui.utils.Utils.retryGetOnCondition;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;
import static org.assertj.core.api.Assertions.fail;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;

public class AchievementsPage extends GenericPage {

  private static final int MAX_REFRESH_RETRIES = 5;

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

  public void filterAchievementByUser(String userFullName) {
    achievementsFilterButton().click();
    waitForDrawerToOpen();
    mentionInField(achievementsFilterUserSuggester(), userFullName, 3);
    getDrawerButton("Confirm").click();
    waitForLoading();
  }

  public void checkThatAchievementIsAccepted(String actionTitle) {
    waitForPageLoading();
    retryOnCondition(() -> acceptedAchievementElement(actionTitle).checkVisible(),
                     () -> {
                       waitFor(2).seconds();
                       Utils.refreshPage(true);
                     },
                     MAX_REFRESH_RETRIES);
  }

  public void checkThatAchievementIsPending(String actionTitle) {
    waitForPageLoading();
    retryOnCondition(() -> pendingAchievementElement(actionTitle).checkVisible(),
                     () -> {
                       waitFor(2).seconds();
                       Utils.refreshPage(true);
                     },
                     MAX_REFRESH_RETRIES);
  }

  public void acceptAchievement(String actionTitle) {
    waitForPageLoading();
    acceptedAchievementElement(actionTitle).click();
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
      waitFor(2).seconds();
      Utils.refreshPage(true);
    }, MAX_REFRESH_RETRIES);
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
      waitFor(2).seconds();
      Utils.refreshPage(true);
    }, MAX_REFRESH_RETRIES);
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
      waitFor(2).seconds();
      Utils.refreshPage(true);
    }, MAX_REFRESH_RETRIES);
  }

  public void checkThatAchievementIsDisplayed(String actionTitle, long times) {
    String errorMessage = retryGetOnCondition(() -> {
      long found = achievementsCount(actionTitle);
      return checkAchievementsCount(actionTitle, times, found);
    }, () -> {
      waitFor(2).seconds();
      Utils.refreshPage(true);
    }, MAX_REFRESH_RETRIES);
    if (StringUtils.isNotBlank(errorMessage)) {
      fail(errorMessage);
    }
  }

  public void checkThatAchievementIsDisplayedWithProgramOwnerView(String actionTitle, long times, String programName) {
    String errorMessage = retryGetOnCondition(() -> {
      enableProgramOwnerView();
      filterAchievementByProgram(programName);
      long found = achievementsCount(actionTitle);
      return checkAchievementsCount(actionTitle, times, found);
    }, () -> {
      waitFor(2).seconds();
      Utils.refreshPage(true);
    }, MAX_REFRESH_RETRIES);
    if (StringUtils.isNotBlank(errorMessage)) {
      fail(errorMessage);
    }
  }

  public void checkThatAchievementIsDisplayed(String actionTitle, long times, String programName) {
    String errorMessage = retryGetOnCondition(() -> {
      filterAchievementByProgram(programName);
      long found = achievementsCount(actionTitle);
      return checkAchievementsCount(actionTitle, times, found);
    }, () -> {
      waitFor(2).seconds();
      Utils.refreshPage(true);
    }, MAX_REFRESH_RETRIES);
    if (StringUtils.isNotBlank(errorMessage)) {
      fail(errorMessage);
    }
  }

  public void checkThatAchievementIsDisplayedInPosition(String ruleTitle, String userName, int index) {
    achievementRowElement(ruleTitle, userName, index).assertVisible();
  }

  public void checkThatAchievementInDrawerIsDisplayedInPosition(String fullName, int index) {
    achievementDrawerElement(fullName, index).assertVisible();
  }

  public void checkThatAchievementIsDisplayedInPosition(String ruleTitle, int index) {
    achievementRowElement(ruleTitle, index).assertVisible();
  }

  public void openAchievementsDrawerFromProgramDetail(String ruleTitle) {
    achievementAvatarsElement(ruleTitle).click();
  }

  private ElementFacade achievementAvatarsElement(String ruleTitle) {
    return findByXPathOrCSS(String.format("(//tbody//*[contains(text(), '%s')]//ancestor::tr//*[contains(@class, 'profile-popover')])[last()]",
                                          ruleTitle));
  }

  private ElementFacade achievementRowElement(String ruleTitle, String userName, int index) {
    return findByXPathOrCSS(String.format("(//tbody//tr)[%s]//*[contains(text(), '%s')]//ancestor::tr//a[contains(@href, '/profile/%s')]",
                                          index,
                                          ruleTitle,
                                          userName));
  }

  private ElementFacade achievementRowElement(String ruleTitle, int index) {
    return findByXPathOrCSS(String.format("(//tbody//tr)[%s]//*[contains(text(), '%s')]",
                                          index,
                                          ruleTitle));
  }

  private ElementFacade achievementDrawerElement(String userName, int index) {
    return findByXPathOrCSS(String.format("(//*[@id = 'AchievementsDrawer']//*[contains(@class, 'profile-popover')])[%s]//*[contains(text(), '%s')]",
                                          index,
                                          userName));
  }

  private void enableProgramOwnerView() {
    getButton("Review").click();
    waitFor(200).milliseconds();
    waitForLoading();
  }

  private ElementFacade rejectedAchievementElement(String actionTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'GamificationRealizationItem')]//*[contains(@class, 'fas fa-times')]",
                                          actionTitle));
  }

  private ElementFacade achievementsFilterButton() {
    return findByXPathOrCSS("//*[@id = 'applicationToolbar']//*[contains(text(), 'Filter')]//ancestor-or-self::button");
  }

  private TextBoxElementFacade achievementsFilterProgramSuggester() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'Program')]/parent::*//*[contains(@class, 'identitySuggesterInputStyle')]//input[@type = 'text']");
  }

  private TextBoxElementFacade achievementsFilterUserSuggester() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), 'Contributor')]/parent::*//*[contains(@class, 'identitySuggesterInputStyle')]//input[@type = 'text']");
  }

  private ElementFacade acceptedAchievementElement(String actionTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'GamificationRealizationItem')]//*[contains(@class, 'fas fa-check')]",
                                          actionTitle));
  }

  private ElementFacade pendingAchievementElement(String actionTitle) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'GamificationRealizationItem')]//*[contains(@class, 'fas fa-question')]",
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

  private int achievementsCount(String actionTitle) {
    return findAll(By.xpath(String.format("//*[contains(@id, 'GamificationRealizationItem')]//td[1]//*[contains(text(), '%s')]",
                                          actionTitle))).size();
  }

  private String checkAchievementsCount(String actionTitle, long times, long found) {
    if (found < times) {
      throw new IllegalStateException(String.format("Expected to find '%s' achievement %s times, but was %s times",
                                                    actionTitle,
                                                    times,
                                                    found));
    } else if (found > times) {
      return String.format("Expected to find '%s' achievement %s times which was more than expected %s times",
                           actionTitle,
                           found,
                           times);
    } else {
      return null;
    }
  }

}
