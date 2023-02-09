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

import io.meeds.qa.ui.pages.ProgramsPage;

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

  public void checkProgramCardDisplay(String programName) {
    programsPage.checkProgramCardDisplay(programName);
  }

  public void checkProgramCardTitle(String title) {
    programsPage.checkProgramCardTitle(title);
  }

  public void checkProgramDrawerDisplay() {
    programsPage.checkProgramDrawerDisplay();
  }

  public void checkProgramTitleDisplayOnCard(String programName) {
    programsPage.checkProgramTitleDisplayOnCard(programName);
  }

  public void checkProgramTitleUpdateOnCard(String newProgramName) {
    programsPage.checkProgramTitleUpdateOnCard(newProgramName);
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

  public void enterProgramRandomTitle(String programTitle) {
    programsPage.enterProgramRandomTitle(programTitle);
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

}
