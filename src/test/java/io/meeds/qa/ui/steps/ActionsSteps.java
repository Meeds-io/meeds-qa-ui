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

import java.util.Map;

import io.meeds.qa.ui.pages.ActionsPage;
import io.meeds.qa.ui.pages.RulePage;

public class ActionsSteps {

  private ActionsPage   actionsPage;

  private RulePage      rulePage;

  public void updateAction(String challengeName, Map<String, String> details) {
    actionsPage.openEditChallengeDrawer(challengeName);

    String title = details.get("title");
    String description = details.get("description");
    String points = details.get("points");
    rulePage.saveAction(title, description, points, true, false, false);
  }

  public void searchChallenge(String challengeName) {
    actionsPage.searchAction(challengeName);
  }

  public void isOverviewChallengeDisplayed(String challengeTitle, String participantsCount) {
    actionsPage.isOverviewChallengeDisplayed(challengeTitle, participantsCount);
  }

  public void isOverviewChallengeNotDisplayed(String challengeTitle, String participantsCount) {
    actionsPage.isOverviewChallengeNotDisplayed(challengeTitle, participantsCount);
  }

  public void checkChallengePoints(String challengeName, String points) {
    actionsPage.checkChallengePoints(challengeName, points);
  }

  public void openActionActivity() {
    actionsPage.openActionActivity();
  }

  public void openActionFromActivity() {
    actionsPage.openActionFromActivity();
  }

  public void checkParticipantsCount(int count) {
    actionsPage.checkParticipantsCount(count);
  }

  public void enableActionPublication() {
    actionsPage.enableActionPublication();
  }

  public void setActionPublicationMessage(String message) {
    actionsPage.setActionPublicationMessage(message);
  }

}
