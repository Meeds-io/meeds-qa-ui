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

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.pages.RulePage;

public class RulesSteps {
  private RulePage rulePage;

  public void enterRuleTitle(String ruleTitle) {
    rulePage.setActionTitle(ruleTitle);
  }

  public void addRuleEvent(String eventName) {
    rulePage.setActionEvent(eventName);
  }

  public void clickAddActionButton() {
    rulePage.clickAddActionButton();
  }

  public void addRuleRandomDescription(String ruleDescription) {
    rulePage.setActionDescription(ruleDescription);
  }

  public void searchRuleInProgramRuleFilter(String ruleTitle) {
    rulePage.searchRuleInProgramRuleFilter(ruleTitle);
  }

  public void ruleNotfoundTryAgain() {
    rulePage.ruleNotfoundTryAgain();
  }

  public void clearRulesSearchFilter() {
    rulePage.clearRulesSearchFilter();
  }

  public void isActionDisplayedInProgramDetail(String ruleTitle) {
    rulePage.isActionDisplayedInProgramDetail(ruleTitle);
  }

  public void isActionNotDisplayedInProgramDetail(String ruleTitle) {
    rulePage.isActionNotDisplayedInProgramDetail(ruleTitle);
  }

  public void openActionDrawer(String ruleTitle) {
    rulePage.openActionDrawer(ruleTitle);
  }

  public void createAction(String title, boolean declarative, Map<String, String> details) {
    rulePage.clickAddActionButton();

    String description = details.get("description");
    if (StringUtils.isBlank(description)) {
      description = "challengeDescription" + getRandomNumber();
    }
    String points = details.get("points");
    rulePage.saveAction(title, description, points, declarative, true, true);
  }

  public void setActionEndDate() {
    rulePage.selectDurationChoice();
    rulePage.setActionEndDate();
  }

  public void changeRuleEnablement() {
    rulePage.changeRuleEnablement();
  }
}
