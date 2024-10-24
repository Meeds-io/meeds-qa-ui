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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.pages.ProgramsPage;
import net.serenitybdd.core.Serenity;

public class ProgramsSteps {
  private ProgramsPage        programsPage;

  private String              currentProgramTitle;

  private Map<String, String> programUrls = new HashMap<>();

  public void enableDisableProgram() {
    programsPage.enableDisableProgram();
  }

  public void checkProgramStatusSwitchNotDisplayed() {
    programsPage.checkProgramStatusSwitchNotDisplayed();
  }

  public void goBackUsingProgramTitle(String programName) {
    programsPage.goBackUsingProgramTitle(programName);
  }

  public void enterProgramDescription(String programDescription) {
    programsPage.enterProgramDescription(programDescription);
  }

  public void addSpaceAudience(String randomSpaceName) {
    programsPage.addSpaceAudience(randomSpaceName);
  }

  public void clickSaveProgramButton() {
    programsPage.clickSaveProgramButton();
    if (currentProgramTitle != null && programsPage.getCurrentUrl().contains("programs/")) {
      programUrls.put(currentProgramTitle, programsPage.getCurrentUrl());
    }
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

  public void editProgram() {
    programsPage.editProgram();
  }

  public void editProgram(String programName) {
    programsPage.editProgram(programName);
  }

  public void editProgramWithDescription(String programName, String newProgramName, String newProgramDescription) {
    programsPage.editProgramWithDescription(programName, newProgramName, newProgramDescription);
    programUrls.remove(programName);
  }

  public void enterProgramTitle(String programTitle) {
    programsPage.enterProgramTitle(programTitle);
    currentProgramTitle = programTitle;
  }

  public void selectEngagementApplication(String tab) {
    programsPage.selectEngagementApplication(tab);
  }

  public void selectProgramsFilter(String value) {
    programsPage.selectProgramsFilter(value);
  }

  public void selectProgramActionsFilter(String value) {
    programsPage.selectProgramActionsFilter(value);
  }

  public void openProgramCard(String programTitle) {
    programUrls.compute(programTitle, (k, v) -> {
      if (StringUtils.isBlank(v)) {
        programsPage.openProgramCard(programTitle);
      } else {
        programsPage.getDriver().navigate().to(v);
      }
      return v;
    });
  }

  public void editProgramAction(String actionTitle) {
    programsPage.editProgramAction(actionTitle);
  }

  public void enableProgramAction(String actionTitle) {
    programsPage.enableProgramAction(actionTitle);
  }

  public void disableProgramAction(String actionTitle) {
    programsPage.disableProgramAction(actionTitle);
  }

  public void deleteProgramAction(String actionTitle) {
    programsPage.deleteProgramAction(actionTitle);
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

  public void announceAction(String challengeTitle, String announcementMessage) {
    programsPage.announceAction(challengeTitle, announcementMessage);
  }

  public void announceActionFromActivity(String challengeTitle, String announcementMessage) {
    programsPage.announceActionFromActivity(challengeTitle, announcementMessage);
  }

  public void sendAnnouncementMessage(String announcementMessage) {
    programsPage.sendAnnouncementMessage(announcementMessage);
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
    programsPage.closeToastNotification(false);
    if (programName != null && programsPage.getCurrentUrl().contains("programs/")) {
      programUrls.put(programName, programsPage.getCurrentUrl());
    }
  }

  public void checkProgramPositionInTopPrograms(String programName, int listPosition) {
    programsPage.checkProgramPositionInTopPrograms(programName, listPosition);
  }

  public void checkProgramNotDisplayedInTopPrograms(String programName) {
    programsPage.checkProgramNotDisplayedInTopPrograms(programName);
  }

  public void addProgramOwner(String firstName) {
    programsPage.addProgramOwner(firstName);
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

  public void attachAvatarToProgram() {
    programsPage.attachAvatarToProgram();
  }

  public void attachCoverToProgram() {
    programsPage.attachCoverToProgram();
  }

  public void deleteAvatarFromProgram() {
    programsPage.deleteAvatarFromProgram();
  }

  public void deleteCoverFromProgram() {
    programsPage.deleteCoverFromProgram();
  }

  public void checkProgramAvatarIsSpecificInDetail() {
    programsPage.checkProgramAvatarIsSpecificInDetail();
  }

  public void checkProgramCoverIsSpecificInDetail() {
    programsPage.checkProgramCoverIsSpecificInDetail();
  }

  public void checkProgramAvatarIsDefaultInDetail() {
    programsPage.checkProgramAvatarIsDefaultInDetail();
  }

  public void checkProgramCoverIsDefaultInDetail() {
    programsPage.checkProgramCoverIsDefaultInDetail();
  }

}
