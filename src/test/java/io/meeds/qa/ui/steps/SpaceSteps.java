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

import io.meeds.qa.ui.pages.SpacePage;
import io.meeds.qa.ui.pages.KudosPage;
import io.meeds.qa.ui.utils.Utils;

public class SpaceSteps {

  private SpacePage spacePage;

  private KudosPage kudosPage;

  public void addActivity(String activity) {
    spacePage.addActivityTextInOpenedEditor(activity);
  }

  public void addDescriptionLess1000CharsInThePoll(String choiceThree) {
    spacePage.addDescriptionLess1000CharsInThePoll(choiceThree);
  }

  public void addOptionThreeInThePoll(String choiceThree) {
    spacePage.addOptionThreeInThePoll(choiceThree);
  }

  public void addOptionTwoInThePoll(String choiceTow) {
    spacePage.addOptionTwoInThePoll(choiceTow);
  }

  public void cancelDeleteComment() {
    spacePage.cancelDeleteComment();
  }

  public void checkActivityCommentDisplayed(String activity, String comment) {
    spacePage.checkActivityCommentDisplayed(activity, comment);
  }

  public void checkActivityCommentInDrawer(String comment) {
    spacePage.checkActivityCommentInDrawer(comment);
  }

  public void checkActivityCommentNotDisplayed(String activity, String comment) {
    spacePage.checkActivityCommentNotDisplayed(activity, comment);
  }

  public void checkActivityNotVisible(String activity) {
    spacePage.checkActivityNotVisible(activity);
  }

  public void checkActivityPinned(String activity) {
    spacePage.checkActivityPinned(activity);
  }

  public void checkActivityTitle(String activity) {
    spacePage.checkActivityTitle(activity);
  }

  public void checkActivityVisible(String activity) {
    spacePage.checkActivityVisible(activity);
  }

  public void checkCommentVisible(String comment) {
    spacePage.checkCommentVisible(comment);
  }

  public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
    spacePage.checkCommentReplyDisplayed(activity, comment, reply);
  }

  public void checkCommentReplyDisplayedInDrawer(String activity, String comment, String reply) {
    spacePage.checkCommentReplyDisplayed(activity, comment, reply);
  }

  public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
    spacePage.checkCommentReplyNotDisplayed(activity, comment, reply);
  }

  public void checkConfirmationPopupNotVisible() {
    spacePage.checkConfirmationPopupNotVisible();
  }

  public void checkConfirmationPopupVisible() {
    spacePage.checkConfirmationPopupVisible();
  }

  public void checkCreatePollButtonIsDisabled() {
    spacePage.checkCreatePollButtonIsDisabled();
  }

  public void checkCreatePollButtonIsEnabled() {
    spacePage.checkCreatePollButtonIsEnabled();
  }

  public void checkFirstActivityComment(String comment) {
    spacePage.checkFirstActivityComment(comment);
  }

  public void checkFirstCommentInDrawer(String comment) {
    spacePage.checkFirstCommentInDrawer(comment);
  }

  public void checkFourCommentIsDisplayedInDrawer() {
    spacePage.checkFourCommentIsDisplayedInDrawer();
  }

  public void checkFourthCommentInDrawer() {
    spacePage.checkFourthCommentInDrawer();
  }

  public void checkLinkPreviewVisible() {
    spacePage.checkLinkPreviewVisible();
  }

  public void checkSecondActivityComment() {
    spacePage.checkSecondActivityComment();
  }

  public void checkSecondCommentInDrawer() {
    spacePage.checkSecondCommentInDrawer();
  }

  public void checkSixthPositionInDrawer() {
    spacePage.checkSixthPositionInDrawer();
  }

  public void checkTenCommentIsDisplayedInDrawer() {
    spacePage.checkTenCommentIsDisplayedInDrawer();
  }

  public void checkThirdCommentInDrawer() {
    spacePage.checkThirdCommentInDrawer();
  }

  public void checkUserDisplayedInReactionsDrawer(String userLastName) {
    spacePage.checkUserDisplayedInReactionsDrawer(userLastName);
  }

  public void checkVideoActivityVisible(String videoLink) {
    spacePage.checkVideoActivityVisible(videoLink);
  }

  public void clickCreatePoll() {
    spacePage.clickCreatePoll();
  }

  public void clickSendKudos() {
    spacePage.clickSendKudos();
  }

  public void clickKudosBtnBelowPostField() {
    spacePage.clickKudosBtnBelowPostField();
  }

  public void clickPollBtnBelowPostField() {
    spacePage.clickPollBtnBelowPostField();
  }

  public void sendKudosWithReceiver(String kudos, String receiver) {
    kudosPage.sendKudosMessageWithReceiverFromOpenedDrawer(kudos, receiver);
  }

  public void clickCreatePollButton() {
    spacePage.clickCreatePollButton();
  }

  public void clickDeleteActivityButton(String activity) {
    spacePage.clickDeleteActivityButton(activity);
  }

  public void clickCommentButton(String buttonName, String comment) {
    spacePage.clickCommentButton(buttonName, comment);
  }

  public void clickKudosFromActivityStream() {
    spacePage.clickOnkudosButtonToActivityStream();
  }

  public void clickOnCommentKudosButton(String comment) {
    spacePage.getCommentKudosButton(comment);
  }
  
  public void clickKudosFromCommentsDrawer() {
    spacePage.clickOnkudosButtonFromCommentsDrawerToCommentActivity();
  }

  public void clickOnActivityComment(String comment) {
    spacePage.clickOnActivityComment(comment);
  }

  public void clickOnCommentsDrawerFirstPage() {
    spacePage.clickOnCommentsDrawerFirstPage();
  }

  public void clickOnCommentsDrawerSecondPage() {
    spacePage.clickOnCommentsDrawerSecondPage();
  }

  public void clickOnCommentThreeDotsButtonFromCommentsDrawer(String comment, boolean reply) {
    spacePage.clickOnCommentThreeDotsButtonFromCommentsDrawer(comment, reply);
  }

  public void clickOnKudosNumberButton() {
    spacePage.clickOnKudosButtonNumberToCommentActivity();
  }

  public void clickOnKudosNumberButtonFromTheCommentsDrawer() {
    spacePage.clickOnKudosButtonNumberFromCommentsDrawerToCommentActivity();
  }

  public void clickOnLoadMoreActivities() {
    spacePage.clickOnLoadMoreActivities();
  }

  public void clickOnReplyKudos(String reply) {
    spacePage.clickOnReplyKudos(reply);
  }

  public void clickOnTheUserPopover(String user) {
    spacePage.clickOnTheUserPopover(user);
  }

  public void clickOnViewallXcomments() {
    spacePage.clickOnViewallXcomments();
  }

  public void clickPinActivityButton(String activity) {
    spacePage.clickPinActivityButton(activity);
  }

  public void clickPostIcon() {
    spacePage.clickPostIcon();
  }

  public void clickUserAvatar() {
    spacePage.clickUserAvatar();
  }

  public void clickCloseKudosDrawer() {
    spacePage.clickCloseKudosDrawer();
  }

  public void composerDrawerIsDisplayed() {
    spacePage.composerDrawerIsDisplayed();
  }

  public void kudosDrawerIsDisplayed() {
    spacePage.kudosDrawerIsDisplayed();
  }

  public void pollDrawerIsDisplayed() {
    spacePage.pollDrawerIsDisplayed();
  }

  public void clickUnpinActivityButton(String activity) {
    spacePage.clickUnpinActivityButton(activity);
  }

  public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
    spacePage.commentIsDisplayedInDrawer(commentsNumber, comment);
  }

  public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
    spacePage.commentIsNotDisplayedInDrawer(commentsNumber, comment);
  }

  public void commentNameIsNotDisplayedInDrawer(String comment) {
    spacePage.commentNameIsNotDisplayedInDrawer(comment);
  }

  public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
    spacePage.commentsDrawerDisplayedLikesOnComment(comment, number);
  }

  public void commentsDrawerlikeActivityComment(String activityComment) {
    spacePage.commentsDrawerlikeActivityComment(activityComment);
  }

  public void copyLinkActivityButtonIsDisplayed(String activity) {
    spacePage.copyLinkActivityButtonIsDisplayed(activity);
  }

  public void createPoll(String pollTitle, String choiceOne, String choiceTow) {
    spacePage.createPoll(pollTitle, choiceOne, choiceTow);
  }

  public void createPollDrawerClosed() {
    spacePage.createPollDrawerClosed();
  }

  public void createPollWithOneChoice(String pollTitle, String choiceOne) {
    spacePage.createPollWithOneChoice(pollTitle, choiceOne);
  }

  public void deleteactivity() {
    spacePage.clickYesbutton();
  }

  public void deleteActivityButtonIsDisplayed(String activity) {
    spacePage.deleteActivityButtonIsDisplayed(activity);
  }

  public void deleteComment(String comment) {
    spacePage.deleteComment(comment);
  }

  public void deleteReply(String reply) {
    spacePage.deleteReply(reply);
  }

  public void displayedLikesOnComment(String comment, String number) {
    spacePage.displayedLikesOnComment(comment, number);
  }

  public void downloadActivityButtonIsDisplayed(String activity) {
    spacePage.downloadActivityButtonIsDisplayed(activity);
  }

  public void editActivity() {
    spacePage.clickOnUpdateActivity();
  }

  public void editActivityButtonIsDisplayed(String activity) {
    spacePage.editActivityButtonIsDisplayed(activity);
  }

  public void editComment(String comment) {
    spacePage.editComment(comment);
  }

  public void editCommentFromCommentsDrawer(String comment) {
    spacePage.editCommentFromCommentsDrawer(comment);
  }

  public void editPoll(String pollTitle, String choiceOne, String choiceTow) {
    spacePage.createPoll(pollTitle, choiceOne, choiceTow);
  }

  public void enterActivityCommentWithUser(String comment, String user) {
    spacePage.enterActivityCommentWithUser(comment, user);
  }

  public void enterActivityCommentWithUserNoMention(String comment, String user) {
    spacePage.enterActivityCommentWithUserNoMention(comment, user);
  }

  public void enterActivityText(String activity) {
    spacePage.enterActivityText(activity);
  }

  public void enterCommentText(String comment) {
    spacePage.enterCommentText(comment);
  }

  public void goToSpecificTab(String tabName) {
    spacePage.goToSpecificTab(tabName);
  }

  public void addSpaceApplicationIfNotExisting(String appName) {
    spacePage.addSpaceApplicationIfNotExisting(appName);
  }

  public void goToUserProfileFromLikersDrawer(String prefix) {
    spacePage.goToUserProfileFromLikersDrawer(prefix);
  }

  public void hoverOnLikeIcon(String comment) {
    spacePage.hoverOnLikeIcon(comment);
  }

  public void hoverOnLikeIconCommentsDrawer(String comment) {
    spacePage.hoverOnLikeIconCommentsDrawer(comment);
  }

  public void hoverOnMentionedUserInPost(String activity, String user) {
    spacePage.hoverOnMentionedUserInPost(activity, user);
  }

  public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
    spacePage.isActivityNameUserSpaceDisplayed(activity, user, space);
  }

  public void isMentionedUserDisplayedInPost(String activity, String user) {
    spacePage.isMentionedUserDisplayedInPost(activity, user);
  }

  public void isUserPopoverDisplayed(String user) {
    spacePage.isUserPopoverDisplayed(user);
  }

  public void kudosLabelIsBlack(String comment) {
    spacePage.kudosLabelIsBlack(comment);
  }

  public void kudosLabelIsBlue(String comment) {
    spacePage.kudosLabelIsBlue(comment);
  }

  public void likeActivity(String activity) {
    spacePage.likeActivity(activity);
  }

  public void likeActivityComment(String activity) {
    spacePage.likeActivityComment(activity);
  }

  public void likeLabelInCommentsDrawerIsBlack(String comment) {
    spacePage.likeLabelInCommentsDrawerIsBlack(comment);
  }

  public void likeLabelInCommentsDrawerIsBlue(String comment) {
    spacePage.likeLabelInCommentsDrawerIsBlue(comment);
  }

  public void likeLabelIsBlack(String comment) {
    spacePage.likeLabelIsBlack(comment);
  }

  public void likeLabelIsBlue(String comment) {
    spacePage.likeLabelIsBlue(comment);
  }

  public void linkIsOpenedNewTab(String link) {
    spacePage.linkIsOpenedNewTab(link);
    Utils.refreshPage();
  }

  public void noCommentDisplayedInDrawer() {
    spacePage.noCommentDisplayedInDrawer();
  }

  public void openActivityReactionsDrawer(String activity) {
    spacePage.openActivityReactionsDrawer(activity);
  }

  public void checkActivityReactionsNumberDisplayed(String activity) {
    spacePage.checkActivityReactionsNumberDisplayed(activity);
  }

  public void checkActivityReactionsNumberNotDisplayed(String activity) {
    spacePage.checkActivityReactionsNumberNotDisplayed(activity);
  }


  public void openDeleteActivityMenu(String activity) {
    spacePage.openDeleteActivityMenu(activity);
  }

  public void openEditActivityMenu(String activity) {
    spacePage.openEditActivityMenu(activity);
  }

  public void openLinkInNewTab(String link) {
    spacePage.openLinkInNewTab(link);
  }

  public void openThreeDotsActivityMenu(String activity) {
    spacePage.openThreeDotsActivityMenu(activity);
  }

  public void pinActivityButtonIsDisplayed(String activity) {
    spacePage.pinActivityButtonIsDisplayed(activity);
  }
  public void pinActivityButtonIsNotDisplayed(String activity) {
    spacePage.pinActivityButtonIsNotDisplayed(activity);
  }

  public void pinnedActivityDisappears(String activity) {
    spacePage.pinnedActivityDisappears(activity);
  }

  public void postManyActivities(String activityNumber, String activityPrefix) {
    for (int i = 0; i < Integer.parseInt(activityNumber) + 1; i++) {
      String activity = activityPrefix + i;
      spacePage.clickPostIcon();
      spacePage.addActivityTextInOpenedEditor(activity);
      spacePage.publishActivity(false);
    }
    spacePage.refreshStream();
  }

  public void promoteSpaceMemberAsManager(String name) {
    spacePage.promoteSpaceMemberAsManager(name);
  }

  public void publishActicity() {
    spacePage.publishActivity(true);
  }

  public void attachImageToActivity() {
    spacePage.attachImagesToActivity();
  }
  
  public void attachGifImageToActivity() {
    spacePage.attachGifImageToActivity();
  }
  
  public void checkCropDrawerBlurredZone() {
    spacePage.checkCropDrawerBlurredZone();
  }
  
  public void attachImageToKudos() {
    spacePage.attachImagesToKudos();
  }
  
  public void attachImageToActivityComment() {
    spacePage.attachImagesToActivityComment();
  }

  public void clickPreviewAttachedImage(String activity) {
    spacePage.clickPreviewAttachedImage(activity);
  }
  
  public void previewAttachedImage() {
    spacePage.previewAttachedImage();
  }
  
  public void checkPreviewAttachedImageArrows() {
    spacePage.checkPreviewAttachedImageArrows();
  }
  
  public void clickClosePreviewAttachedImage() {
    spacePage.clickClosePreviewAttachedImage();
  }
  
  public void checkPreviewAttachedImageIsClosed() {
    spacePage.checkPreviewAttachedImageIsClosed();
  }

  public void publishActivityInArabicLanguage() {
    spacePage.publishActivityInArabicLanguage();
  }

  public void publishComment() {
    spacePage.publishComment();
  }

  public void receivedKudosDrawerIsDisplayed(String kudosNumber) {
    spacePage.getReceivedKudosSectionIsDisplayed(kudosNumber);
  }

  public void replyInDrawerIsNotDisplayed(String reply) {
    spacePage.replyInDrawerIsNotDisplayed(reply);
  }

  public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
    spacePage.replyIsDisplayedInCommentsDrawer(comment, reply);
  }

  public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
    spacePage.replyIsNotDisplayedInCommentsDrawer(comment, reply);
  }

  public void replyKudosLabelIsBlack(String comment) {
    spacePage.kudosLabelIsBlack(comment);
  }

  public void replykudosLabelIsBlue(String comment) {
    spacePage.kudosLabelIsBlue(comment);
  }

  public void selectActivityFilter(String filter) {
    spacePage.selectActivityFilter(filter);
  }

  public void clickFilterIconFromComposer() {
    spacePage.clickFilterIconFromComposer();
  }

  public void filterIsSelected() {
    spacePage.filterIsSelected();
  }

  public void filterIsntSelected() {
    spacePage.filterIsntSelected();
  }

  public void tooltipCommentsDrawerIsDisplayed(String comment) {
    spacePage.tooltipCommentsDrawerIsDisplayed(comment);
  }

  public void unPinActivityButtonIsDisplayed(String activity) {
    spacePage.unPinActivityButtonIsDisplayed(activity);
  }

  public void updateComment() {
    spacePage.updateComment();
  }

  public void updateCommentText(String comment) {
    spacePage.updateCommentText(comment);
  }

  public void userIsMentionedInCommentEntered(String user) {
    spacePage.userIsMentionedInCommentEntered(user);
  }

  public void userIsNotMentionedInCommentEntered(String user) {
    spacePage.userIsNotMentionedInCommentEntered(user);
  }

  public void viewAllRepliesInActivityStream(String comment) {
    spacePage.viewAllRepliesInActivityStream(comment);
  }

  public void viewAllRepliesInCommentsDrawer(String comment) {
    spacePage.viewAllRepliesInCommentsDrawer(comment);
  }
  
  public void checkActivityAttachedImages(String activity) {
    spacePage.checkActivityAttachedImages(activity);
  }
  
  public void checkActivitySecondAttachedImage(String activity) {
    spacePage.checkActivitySecondAttachedImage(activity);
  }
  
  public void checkActivityDrawerAttachedImagesDeleteIcon(String activity) {
    spacePage.checkActivityDrawerAttachedImagesDeleteIcon(activity);
  }
  
  public void checkActivityDrawerAttachedImagesEditIcon(String activity) {
    spacePage.checkActivityDrawerAttachedImagesEditIcon(activity);
  }
  
  public void clickDeleteAttachment() {
    spacePage.clickDeleteAttachment();
  }
  
  public void clickEditAttachment() {
    spacePage.clickEditAttachment();
  }
  
  public void clickUpdateAttachment() {
    spacePage.clickUpdateAttachment();
  }
  
  public void zoomAttachedImage() {
    spacePage.zoomAttachedImage();
  }
  
  public void checkAttachedImageCropDrawerCancelOption() {
    spacePage.checkAttachedImageCropDrawerCancelOption();
  }
  
  public void checkAttachedImageCropDrawer() {
    spacePage.checkAttachedImageCropDrawer();
  }
  
  public void checkActivityAttachImageDeleted() {
    spacePage.checkActivityAttachImageDeleted();
  }
  
  public void checkActivityAttachedImagesIsNotDisplayed(String activity) {
    spacePage.checkActivityAttachedImagesIsNotDisplayed(activity);
  }
  
  public void checkActivityCommentKudos(String comment) {
    spacePage.checkActivityCommentKudos(comment);
  }
  
  public void checkKudosCommentAttachedImages(String comment) {
    spacePage.checkKudosCommentAttachedImages(comment);
  }

  public void openSpaceSettingsSection(String sectionId) {
    spacePage.openSpaceSettingsSection(sectionId);
  }

  public void enableRedactionalSpaceSettings() {
    spacePage.enableRedactionalSpaceSettings();
  }

  public void promoteUserAsSpaceRedactor(String userFirstName) {
    spacePage.promoteUserAsSpaceRedactor(userFirstName);
  }

  public void openSpaceSettingsRoleDrawer(String role) {
    spacePage.openSpaceSettingsRoleDrawer(role);
  }

  public void addUserWithRoleInSpace(String userFirstName) {
    spacePage.addUserWithRoleInSpace(userFirstName);
  }

}
