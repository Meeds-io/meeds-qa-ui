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

import io.meeds.qa.ui.pages.SpaceHomePage;
import io.meeds.qa.ui.utils.Utils;

public class SpaceHomeSteps {

  private SpaceHomePage spaceHomePage;

  public void accessNotesApp() {
    spaceHomePage.clickOnNotesTab();
  }

  public void addActivity(String activity) {
    spaceHomePage.addActivityTextInOpenedEditor(activity);
  }

  public void addDescriptionLess1000CharsInThePoll(String choiceThree) {
    spaceHomePage.addDescriptionLess1000CharsInThePoll(choiceThree);
  }

  public void addOptionThreeInThePoll(String choiceThree) {
    spaceHomePage.addOptionThreeInThePoll(choiceThree);
  }

  public void addOptionTwoInThePoll(String choiceTow) {
    spaceHomePage.addOptionTwoInThePoll(choiceTow);
  }

  public void cancelDeleteComment() {
    spaceHomePage.cancelDeleteComment();
  }

  public void checkActivityComment(String comment) {
    spaceHomePage.checkActivityComment(comment);
  }

  public void checkActivityCommentInDrawer(String comment) {
    spaceHomePage.checkActivityCommentInDrawer(comment);
  }

  public void checkActivityCommentNotDisplayed(String activity, String comment) {
    spaceHomePage.checkActivityCommentNotDisplayed(activity, comment);
  }

  public void checkActivityNotVisible(String activity) {
    spaceHomePage.checkActivityNotVisible(activity);
  }

  public void checkActivityPinned(String activity) {
    spaceHomePage.checkActivityPinned(activity);
  }

  public void checkActivityTitle(String activity) {
    spaceHomePage.checkActivityTitle(activity);
  }

  public void checkActivityVisible(String activity) {
    spaceHomePage.checkActivityVisible(activity);
  }

  public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
    spaceHomePage.checkCommentReplyDisplayed(activity, comment, reply);
  }

  public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
    spaceHomePage.checkCommentReplyNotDisplayed(activity, comment, reply);
  }

  public void checkConfirmationPopupNotVisible() {
    spaceHomePage.checkConfirmationPopupNotVisible();
  }

  public void checkConfirmationPopupVisible() {
    spaceHomePage.checkConfirmationPopupVisible();
  }

  public void checkCreatePollButtonIsDisabled() {
    spaceHomePage.checkCreatePollButtonIsDisabled();
  }

  public void checkCreatePollButtonIsEnabled() {
    spaceHomePage.checkCreatePollButtonIsEnabled();
  }

  public void checkFirstActivityComment(String comment) {
    spaceHomePage.checkFirstActivityComment(comment);
  }

  public void checkFirstCommentInDrawer(String comment) {
    spaceHomePage.checkFirstCommentInDrawer(comment);
  }

  public void checkFourCommentIsDisplayedInDrawer() {
    spaceHomePage.checkFourCommentIsDisplayedInDrawer();
  }

  public void checkFourthCommentInDrawer() {
    spaceHomePage.checkFourthCommentInDrawer();
  }

  public void checkLinkPreviewVisible() {
    spaceHomePage.checkLinkPreviewVisible();
  }

  public void checkSecondActivityComment() {
    spaceHomePage.checkSecondActivityComment();
  }

  public void checkSecondCommentInDrawer() {
    spaceHomePage.checkSecondCommentInDrawer();
  }

  public void checkSixthPositionInDrawer() {
    spaceHomePage.checkSixthPositionInDrawer();
  }

  public void checkTenCommentIsDisplayedInDrawer() {
    spaceHomePage.checkTenCommentIsDisplayedInDrawer();
  }

  public void checkThirdCommentInDrawer() {
    spaceHomePage.checkThirdCommentInDrawer();
  }

  public void checkUserDisplayedInReactionsDrawer(String userLastName) {
    spaceHomePage.checkUserDisplayedInReactionsDrawer(userLastName);
  }

  public void checkVideoActivityVisible(String videoLink) {
    spaceHomePage.checkVideoActivityVisible(videoLink);
  }

  public void clickCreatePoll() {
    spaceHomePage.clickCreatePoll();
  }

  public void clickCreatePollButton() {
    spaceHomePage.clickCreatePollButton();
  }

  public void clickDeleteActivityButton(String activity) {
    spaceHomePage.clickDeleteActivityButton(activity);
  }

  public void clickKudosFromActivityStream() {
    spaceHomePage.clickOnkudosButtonToActivityStream();
  }

  public void clickKudosFromComment() {
    spaceHomePage.clickOnkudosButtonToCommentActivity();
  }

  public void clickKudosFromCommentsDrawer() {
    spaceHomePage.clickOnkudosButtonFromCommentsDrawerToCommentActivity();
  }

  public void clickOnActivityComment(String comment) {
    spaceHomePage.clickOnActivityComment(comment);
  }

  public void clickOnCommentsDrawerFirstPage() {
    spaceHomePage.clickOnCommentsDrawerFirstPage();
  }

  public void clickOnCommentsDrawerSecondPage() {
    spaceHomePage.clickOnCommentsDrawerSecondPage();
  }

  public void clickOnCommentThreeDotsButton(String activity, String comment) {
    spaceHomePage.clickOnCommentThreeDotsButton(activity, comment);
  }

  public void clickOnCommentThreeDotsButtonFromCommentsDrawer(String comment) {
    spaceHomePage.clickOnCommentThreeDotsButtonFromCommentsDrawer(comment);
  }

  public void clickOnCommentThreeDotsInCommentsDrawer(String comment) {
    spaceHomePage.clickOnCommentThreeDotsInCommentsDrawer(comment);
  }

  public void clickOnKudosNumberButton() {
    spaceHomePage.clickOnKudosButtonNumberToCommentActivity();
  }

  public void clickOnKudosNumberButtonFromTheCommentsDrawer() {
    spaceHomePage.clickOnKudosButtonNumberFromCommentsDrawerToCommentActivity();
  }

  public void clickOnLoadMoreActivities() {
    spaceHomePage.clickOnLoadMoreActivities();
  }

  public void clickOnReplyDropDownMenu(String activity, String comment, String reply) {
    spaceHomePage.clickOnReplyDropDownMenu(activity, comment, reply);
  }

  public void clickOnReplyKudos(String reply) {
    spaceHomePage.clickOnReplyKudos(reply);
  }

  public void clickOnTheUserPopover(String user) {
    spaceHomePage.clickOnTheUserPopover(user);
  }

  public void clickOnViewallXcomments() {
    spaceHomePage.clickOnViewallXcomments();
  }

  public void clickPinActivityButton(String activity) {
    spaceHomePage.clickPinActivityButton(activity);
  }

  public void clickPostIcon() {
    spaceHomePage.clickPostIcon();
  }

  public void clickUnpinActivityButton(String activity) {
    spaceHomePage.clickUnpinActivityButton(activity);
  }

  public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
    spaceHomePage.commentIsDisplayedInDrawer(commentsNumber, comment);
  }

  public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
    spaceHomePage.commentIsNotDisplayedInDrawer(commentsNumber, comment);
  }

  public void commentNameIsNotDisplayedInDrawer(String comment) {
    spaceHomePage.commentNameIsNotDisplayedInDrawer(comment);
  }

  public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
    spaceHomePage.commentsDrawerDisplayedLikesOnComment(comment, number);
  }

  public void commentsDrawerlikeActivityComment(String activityComment) {
    spaceHomePage.commentsDrawerlikeActivityComment(activityComment);
  }

  public void copyLinkActivityButtonIsDisplayed(String activity) {
    spaceHomePage.copyLinkActivityButtonIsDisplayed(activity);
  }

  public void createPoll(String pollTitle, String choiceOne, String choiceTow) {
    spaceHomePage.createPoll(pollTitle, choiceOne, choiceTow);
  }

  public void createPollDrawerClosed() {
    spaceHomePage.createPollDrawerClosed();
  }

  public void createPollWithOneChoice(String pollTitle, String choiceOne) {
    spaceHomePage.createPollWithOneChoice(pollTitle, choiceOne);
  }

  public void deleteactivity() {
    spaceHomePage.clickYesbutton();
  }

  public void deleteActivityButtonIsDisplayed(String activity) {
    spaceHomePage.deleteActivityButtonIsDisplayed(activity);
  }

  public void deleteComment(String comment) {
    spaceHomePage.deleteComment(comment);
  }

  public void deleteReply(String reply) {
    spaceHomePage.deleteReply(reply);
  }

  public void displayedLikesOnComment(String comment, String number) {
    spaceHomePage.displayedLikesOnComment(comment, number);
  }

  public void downloadActivityButtonIsDisplayed(String activity) {
    spaceHomePage.downloadActivityButtonIsDisplayed(activity);
  }

  public void editActivity() {
    spaceHomePage.clickOnUpdateActivity();
  }

  public void editActivityButtonIsDisplayed(String activity) {
    spaceHomePage.editActivityButtonIsDisplayed(activity);
  }

  public void editComment(String comment) {
    spaceHomePage.editComment(comment);
  }

  public void editCommentFromCommentsDrawer(String comment) {
    spaceHomePage.editCommentFromCommentsDrawer(comment);
  }

  public void editPoll(String pollTitle, String choiceOne, String choiceTow) {
    spaceHomePage.createPoll(pollTitle, choiceOne, choiceTow);
  }

  public void enterActivityCommentWithUser(String comment, String user) {
    spaceHomePage.enterActivityCommentWithUser(comment, user);
  }

  public void enterActivityCommentWithUserNoMention(String comment, String user) {
    spaceHomePage.enterActivityCommentWithUserNoMention(comment, user);
  }

  public void enterActivityText(String activity) {
    spaceHomePage.enterActivityText(activity);
  }

  public void enterCommentText(String comment) {
    spaceHomePage.enterCommentText(comment);
  }

  public void goToSpecificTab(String tabName) {
    spaceHomePage.goToSpecificTab(tabName);
  }

  public void goToUserProfileFromLikersDrawer(String prefix) {
    spaceHomePage.goToUserProfileFromLikersDrawer(prefix);
  }

  public void hoverOnLikeIcon(String comment) {
    spaceHomePage.hoverOnLikeIcon(comment);
  }

  public void hoverOnLikeIconCommentsDrawer(String comment) {
    spaceHomePage.hoverOnLikeIconCommentsDrawer(comment);
  }

  public void hoverOnMentionedUserInPost(String activity, String user) {
    spaceHomePage.hoverOnMentionedUserInPost(activity, user);
  }

  public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
    spaceHomePage.isActivityNameUserSpaceDisplayed(activity, user, space);
  }

  public void isMentionedUserDisplayedInPost(String activity, String user) {
    spaceHomePage.isMentionedUserDisplayedInPost(activity, user);
  }

  public void isUserPopoverDisplayed(String user) {
    spaceHomePage.isUserPopoverDisplayed(user);
  }

  public void kudosLabelIsBlack(String comment) {
    spaceHomePage.kudosLabelIsBlack(comment);
  }

  public void kudosLabelIsBlue(String comment) {
    spaceHomePage.kudosLabelIsBlue(comment);
  }

  public void likeActivity(String activity) {
    spaceHomePage.likeActivity(activity);
  }

  public void likeActivityComment(String activity) {
    spaceHomePage.likeActivityComment(activity);
  }

  public void likeLabelInCommentsDrawerIsBlack(String comment) {
    spaceHomePage.likeLabelInCommentsDrawerIsBlack(comment);
  }

  public void likeLabelInCommentsDrawerIsBlue(String comment) {
    spaceHomePage.likeLabelInCommentsDrawerIsBlue(comment);
  }

  public void likeLabelIsBlack(String comment) {
    spaceHomePage.likeLabelIsBlack(comment);
  }

  public void likeLabelIsBlue(String comment) {
    spaceHomePage.likeLabelIsBlue(comment);
  }

  public void linkIsOpenedNewTab(String link) {
    spaceHomePage.linkIsOpenedNewTab(link);
    Utils.refreshPage();
  }

  public void noCommentDisplayedInDrawer() {
    spaceHomePage.noCommentDisplayedInDrawer();
  }

  public void normalLinkPreviewIsVisible(String link) {
    spaceHomePage.normalLinkPreviewIsVisible(link);
  }

  public void openActivityReactionsDrawer(String activity) {
    spaceHomePage.openActivityReactionsDrawer(activity);
  }

  public void openDeleteActivityMenu(String activity) {
    spaceHomePage.openDeleteActivityMenu(activity);
  }

  public void openDeleteCommentMenu(String activity, String comment) {
    spaceHomePage.openDeleteCommentMenu(activity, comment);
  }

  public void openEditActivityMenu(String activity) {
    spaceHomePage.openEditActivityMenu(activity);
  }

  public void openLinkInNewTab(String link) {
    spaceHomePage.openLinkInNewTab(link);
  }

  public void openThreeDotsActivityMenu(String activity) {
    spaceHomePage.openThreeDotsActivityMenu(activity);
  }

  public void pinActivityButtonIsDisplayed(String activity) {
    spaceHomePage.pinActivityButtonIsDisplayed(activity);
  }

  public void pinnedActivityDisappears(String activity) {
    spaceHomePage.pinnedActivityDisappears(activity);
  }

  public void postManyActivities(String activityNumber, String activityPrefix) {
    for (int i = 0; i < Integer.parseInt(activityNumber) + 1; i++) {
      String activity = activityPrefix + i;
      spaceHomePage.clickPostIcon();
      spaceHomePage.addActivityTextInOpenedEditor(activity);
      spaceHomePage.publishActivity(false);
    }
    spaceHomePage.refreshStream();
  }

  public void promoteSpaceMemberAsManager(String name) {
    spaceHomePage.promoteSpaceMemberAsManager(name);
  }

  public void publishActicity() {
    spaceHomePage.publishActivity(true);
  }

  public void publishActivityInArabicLanguage() {
    spaceHomePage.publishActivityInArabicLanguage();
  }

  public void publishComment() {
    spaceHomePage.publishComment();
  }

  public void receivedKudosDrawerIsDisplayed(String kudosNumber) {
    spaceHomePage.getReceivedKudosSectionIsDisplayed(kudosNumber);
  }

  public void replyInDrawerIsNotDisplayed(String reply) {
    spaceHomePage.replyInDrawerIsNotDisplayed(reply);
  }

  public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
    spaceHomePage.replyIsDisplayedInCommentsDrawer(comment, reply);
  }

  public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
    spaceHomePage.replyIsNotDisplayedInCommentsDrawer(comment, reply);
  }

  public void replyKudosLabelIsBlack(String comment) {
    spaceHomePage.kudosLabelIsBlack(comment);
  }

  public void replykudosLabelIsBlue(String comment) {
    spaceHomePage.kudosLabelIsBlue(comment);
  }

  public void selectPinnedActivity(String filter) {
    spaceHomePage.selectPinnedActivity(filter);
  }

  public void tooltipActivityStreamIsDisplayed(String comment) {
    spaceHomePage.tooltipActivityStreamIsDisplayed(comment);
  }

  public void tooltipCommentsDrawerIsDisplayed(String comment) {
    spaceHomePage.tooltipCommentsDrawerIsDisplayed(comment);
  }

  public void unPinActivityButtonIsDisplayed(String activity) {
    spaceHomePage.unPinActivityButtonIsDisplayed(activity);
  }

  public void updateComment() {
    spaceHomePage.updateComment();
  }

  public void updateCommentText(String comment) {
    spaceHomePage.updateCommentText(comment);
  }

  public void userIsMentionedInCommentEntered(String user) {
    spaceHomePage.userIsMentionedInCommentEntered(user);
  }

  public void userIsNotMentionedInCommentEntered(String user) {
    spaceHomePage.userIsNotMentionedInCommentEntered(user);
  }

  public void viewAllRepliesInActivityStream(String comment) {
    spaceHomePage.viewAllRepliesInActivityStream(comment);
  }

  public void viewAllRepliesInCommentsDrawer(String comment) {
    spaceHomePage.viewAllRepliesInCommentsDrawer(comment);
  }
}
