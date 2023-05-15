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
package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.meeds.qa.ui.steps.AchievementsSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AchievementsStepDefinition {

  @Steps
  private AchievementsSteps achievementsSteps;

  @Then("^Achievement for '(.*)' is accepted$")
  public void checkThatAchievementIsAccepted(String appDescription) {
    achievementsSteps.checkThatAchievementIsAccepted(appDescription);
  }

  @Then("^Achievement for '(.*)' is rejected$")
  public void checkThatAchievementIsRejected(String actionTitle) {
    achievementsSteps.checkThatAchievementIsRejected(actionTitle);
  }

  @Then("^Achievement for '(.*)' is canceled$")
  public void checkThatAchievementIsCanceled(String actionTitle) {
    achievementsSteps.checkThatAchievementIsCanceled(actionTitle);
  }

  @Then("^Achievement for '(.*)' is rejected due to activity deletion$")
  public void checkThatAchievementIsDeleted(String actionTitle) {
    achievementsSteps.checkThatAchievementIsDeleted(actionTitle);
  }

  @Then("^The achievement '(.*)' is displayed '(.*)' times$")
  public void checkThatAchievementIsDisplayed(String actionTitle, String times) {
    achievementsSteps.checkThatAchievementIsDisplayed(actionTitle, Long.parseLong(times));
  }

  @Then("^The achievement '(.*)' is displayed '(.*)' times for '(.*)' random program$")
  public void checkThatAchievementIsDisplayed(String actionTitle, String times, String randomProgramSuffix) {
    String programName = Serenity.sessionVariableCalled("programName" + randomProgramSuffix);
    achievementsSteps.checkThatAchievementIsDisplayed(actionTitle, Long.parseLong(times), programName);
  }

  @And("^I filter achievements using '(.*)' program$")
  public void filterAchievementByProgram(String programTitle) {
    achievementsSteps.filterAchievementByProgram(programTitle);
  }

  @And("^I filter achievements using '(.*)' random program$")
  public void filterAchievementByRandomProgram(String suffix) {
    String programName = Serenity.sessionVariableCalled("programName" + suffix);
    achievementsSteps.filterAchievementByProgram(programName);
  }

}
