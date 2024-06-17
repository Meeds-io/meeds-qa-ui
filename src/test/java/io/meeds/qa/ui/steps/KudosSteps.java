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

import static io.meeds.qa.ui.utils.Utils.*;

import io.meeds.qa.ui.pages.HomePage;
import io.meeds.qa.ui.pages.KudosPage;
import io.meeds.qa.ui.pages.SpaceHomePage;

public class KudosSteps {
  private HomePage                homePage;

  private KudosPage kudosPage;

  private SpaceHomePage           spaceHomePage;

  public void addActivityCommentKudos(String kudos) {
    kudosPage.sendKudosMessageFromOpenedDrawer(kudos);
  }

  public void addActivityKudos(String activity, String comment) {
    kudosPage.addActivityKudos(activity, comment);
  }

  public void addActivityKudosToSomeoneDifferent(String activity, String message, String user) {
    kudosPage.addActivityKudosToSomeoneDifferent(activity, message, user);
  }

  public void attemptSendActivityKudosToSomeoneDifferent(String activity, String message, String user) {
    kudosPage.attemptSendActivityKudosToSomeoneDifferent(activity, message, user);
  }

  public void checkKudosIconDisabled(String activityId) {
    kudosPage.checkKudosIconDisabled(activityId);
  }

  public void checkKudosSettings(String val, String period) {
    kudosPage.checkKudosSettings(val, period);
  }

  public void clickEditKudos() {
    kudosPage.clickEditKudos();
  }

  public void clickEditKudosFromReply() {
    kudosPage.clickEditKudosFromReply();
  }

  public void editKudos() {
    kudosPage.editKudos();
  }

  public void enterKudosNumber(String val) {
    kudosPage.enterKudosNumber(val);
  }

  public void goToKudosMenu() {
    kudosPage.goToKudosMenu();
  }

  public void isKudosActivityVisible(String message) {
    kudosPage.checkKudosActivityVisible(message);
  }

  public void saveChanges() {
    kudosPage.saveChange();
  }

  public void searchUserCard(String user) {
    refreshPage();
    homePage.goToPeoplePage();
    kudosPage.searchForUsersByName(user);
  }

  public void selectType() {
    kudosPage.selectType();
  }

  public void userCardMenuSendKudos(String kudosMessage) {
    retryOnCondition(() -> {
       kudosPage.userCardSendKudos();
       kudosPage.sendKudosMessageFromOpenedDrawer(kudosMessage);
     },
     () -> {
       kudosPage.closeAllDrawers();
       kudosPage.userCardSendKudos();
     });
  }

  public void updateKudosMessage(String kudos) {
    spaceHomePage.addActivityTextInOpenedEditor(kudos);
    spaceHomePage.clickOnUpdateActivity();
  }

  public void updateKudosCommentMessage(String kudos) {
    spaceHomePage.addActivityCommentEditorContent(kudos, true, true);
  }

  public void checkCancelKudosActivityIsNotVisible(String kudos) {
    spaceHomePage.openThreeDotsActivityMenu(kudos);
    kudosPage.checkCancelKudosActivityIsNotVisible(kudos);
  }

  public void checkCancelKudosCommentIsNotVisible(String activity, String kudos) {
    spaceHomePage.openCommentsDrawer(activity);
    spaceHomePage.clickOnCommentThreeDotsButtonFromCommentsDrawer(kudos, false);
    kudosPage.checkCancelKudosCommentIsNotVisible(kudos);
  }

  public void checkDeleteKudosCommentIsNotVisible(String activity, String kudos) {
    spaceHomePage.openCommentsDrawer(activity);
    spaceHomePage.clickOnCommentThreeDotsButtonFromCommentsDrawer(kudos, false);
    kudosPage.checkDeleteKudosCommentIsNotVisible(kudos);
  }

  public void checkDeleteKudosCommentIsVisible(String activity, String kudos) {
    spaceHomePage.openCommentsDrawer(activity);
    spaceHomePage.clickOnCommentThreeDotsButtonFromCommentsDrawer(kudos, false);
    kudosPage.checkDeleteKudosCommentIsVisible(kudos);
  }

  public void cancelCommentKudos(String activity, String comment) {
    spaceHomePage.openCommentsDrawer(activity);
    spaceHomePage.clickOnCommentThreeDotsButtonFromCommentsDrawer(comment, false);
    kudosPage.cancelKudosComment(activity, comment);
    spaceHomePage.clickYesbutton();
  }

  public void cancelActivityKudos(String activity) {
    kudosPage.cancelKudosActivity(activity);
    spaceHomePage.clickYesbutton();
  }

  public void sendKudosFromUserPopover(String user, String kudosMessage) {
    spaceHomePage.showUserPopover(user);
    kudosPage.clickOnKudosButtonFromOpenedUserPopover();
    kudosPage.sendKudosMessageFromOpenedDrawer(kudosMessage);
  }
}
