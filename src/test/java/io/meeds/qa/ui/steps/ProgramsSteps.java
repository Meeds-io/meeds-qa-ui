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

import io.meeds.qa.ui.pages.ProgramsPage;
import net.serenitybdd.core.Serenity;

public class ProgramsSteps {
  private ProgramsPage programsPage;

  public void addDisabledProgramWithRandomDescription(String disabledProgramDescription) {
    programsPage.addDisabledProgramWithRandomDescription(disabledProgramDescription);
  }

  public void addProgramWithRandomDescription(String programDescription) {
    programsPage.addProgramWithRandomDescription(programDescription);
  }

  public void addSpaceAudience(String randomSpaceName) {
    programsPage.addSpaceAudience(randomSpaceName);
  }

  public void clickSaveProgramButton() {
    programsPage.clickSaveProgramButton();
  }

  public void checkProgramCardDisplay(String programName) {
    programsPage.checkProgramCardDisplay(programName);
  }

  public void checkProgramCardTitle(String title) {
    programsPage.checkProgramCardTitle(title);
  }

  public void checkProgramDrawerDisplay() {
    programsPage.checkProgramDrawerDisplay();
  }

  public void clickAddProgramBtn() {
    programsPage.clickAddProgramBtn();
  }

  public void deleteCreatedProgram(String programName) {
    programsPage.deleteCreatedProgram(programName);
  }

  public void editProgramWithDescription(String programName, String newProgramName, String newProgramDescription) {
    programsPage.editProgramWithDescription(programName, newProgramName, newProgramDescription);
  }

  public void enterProgramTitle(String programTitle) {
    programsPage.enterProgramTitle(programTitle);
  }

  public void isEngagementAppOpened() {
    programsPage.checkEngagementAppOpened();
  }

  public void selectEngagementTab(String tab) {
    programsPage.selectEngagementTab(tab);
  }

  public void selectProgramsFilter(String value) {
    programsPage.selectProgramsFilter(value);
  }

  public void selectProgramActionsFilter(String value) {
    programsPage.selectProgramActionsFilter(value);
  }

  public void openProgramCard(String value) {
    programsPage.openProgramCard(value);
  }

  public void editProgramAction(String actionTitle) {
    programsPage.editProgramAction(actionTitle);
  }

  public void checkCannotAnnounceAction() {
    programsPage.checkCannotAnnounceAction();
  }

  public void checkProgramActionNotContainsDurationLimitation() {
    programsPage.checkProgramActionNotContainsDurationLimitation();
  }

  public void checkProgramActionContainsDurationLimitation() {
    programsPage.checkProgramActionContainsDurationLimitation();
  }

  public void closeProgramCard() {
    programsPage.closeProgramCard();
  }

  public void announceChallenge(String challengeTitle, String announcementMessage) {
    programsPage.announceChallenge(challengeTitle, announcementMessage);
  }

  public void createRandomProgram(String programName, Map<String, String> details) {
    clickAddProgramBtn();

    String programDescription = details.get("description");
    String programAudience = details.get("audience");
    if (StringUtils.isBlank(programDescription)) {
      programDescription = "programDescription" + getRandomNumber();
    }
    if (StringUtils.isNotBlank(programAudience)) {
      programAudience = Serenity.sessionVariableCalled(programAudience + "RandomSpaceName");
    }
    programsPage.saveProgram(programName, programDescription, programAudience);
    programsPage.closeAlert();
  }

  public void checkProgramPositionInTopPrograms(String programName, int listPosition) {
    programsPage.checkProgramPositionInTopPrograms(programName, listPosition);
  }

  public void checkProgramNotDisplayedInTopPrograms(String programName) {
    programsPage.checkProgramNotDisplayedInTopPrograms(programName);
  }

  public void addProgramOwner(String fullName) {
    programsPage.addProgramOwner(fullName);
  }

  public void checkActionsFilterIsDisplayed() {
    programsPage.checkActionsFilterIsDisplayed();
  }

  public void checkAdminActionsFilterIsNotDisplayed() {
    programsPage.checkAdminActionsFilterIsNotDisplayed();
  }
  
  public void checkAdminActionsFilterIsDisplayed() {
    programsPage.checkAdminActionsFilterIsDisplayed();
  }

}
