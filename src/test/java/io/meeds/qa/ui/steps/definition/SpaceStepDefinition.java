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

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.pages.SpacePage;
import io.meeds.qa.ui.steps.SpaceSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class SpaceStepDefinition {

  private static final String USER_LAST_NAME = "UserLastName";

  private static final String ACTIVITY = "activity";

  private static final String USER_FIRST_NAME = "UserFirstName";

  private SpacePage  spacePage;

  @Steps
  private SpaceSteps spaceSteps;

  @When("^I enter an activity '(.*)'$")
  @And("^I add a short message '(.*)' for the Poll$")
  public void addActivity(String activity) {
    spaceSteps.addActivity(activity);
  }

  @When("^I add in activity '(.*)' a comment '(.*)'$")
  public void addActivityComment(String activity, String comment) {
    spacePage.addActivityComment(activity, comment);
  }

  @When("^I add in activity '(.*)' the following comments$")
  public void addActivityComments(String activity, List<String> comments) {
    spacePage.addActivityComments(activity, comments);
  }

  @When("^I add in comment '(.*)' of activity '(.*)' the following replies$")
  public void addActivityComments(String comment, String activity, List<String> replies) {
    spacePage.addCommentReplies(replies, comment, activity);
  }

  @When("^I enter an activity more than 1300 characters$")
  public void addActivityExceed() {
    String activity = StringUtils.repeat("activity to add", 90);
    spaceSteps.addActivity(activity);
    Serenity.setSessionVariable(ACTIVITY).to(activity);
  }

  @When("^I enter an activity '(.*)' mentioning the (.*) user$")
  public void addActivityMentioningRandomUser(String activity, String userPrefix) {
    String userName = Serenity.sessionVariableCalled(userPrefix + "UserName");
    String newActivity = activity + " @" + userName;
    spaceSteps.addActivity(newActivity);
  }

  @When("^I add a reply '(.*)' to comment '(.*)' in activity '(.*)'$")
  public void addCommentReply(String reply, String comment, String activity) {
    spacePage.addCommentReply(reply, comment, activity);
  }

  @When("^I add description with less than 1000 characters In the poll$")
  public void addDescriptionLess1000CharsInThePoll() {
    String description = StringUtils.repeat("Description ", 80);
    spaceSteps.addDescriptionLess1000CharsInThePoll(description);
  }

  @When("^I add description with more than 1000 characters In the poll$")
  public void addDescriptionMore1000CharsInThePoll() {
    String description = StringUtils.repeat("Description ", 100);
    spaceSteps.addOptionThreeInThePoll(description);
  }

  @When("^I add in activity '(.*)' an internal link '(.*)' as a comment$")
  public void addInternalLinkComment(String activity, String comment) {
    spacePage.addActivityComment(activity, spacePage.getCurrentUrl() + comment);
  }

  @When("^I added the second choice '(.*)' in the poll$")
  public void addOptionTwoInThePoll(String choiceTow) {
    spaceSteps.addOptionTwoInThePoll(choiceTow);
  }

  @Then("^I click on Cancel button$")
  public void cancelDeleteComment() {
    spaceSteps.cancelDeleteComment();
  }

  @Then("^The comment '(.*)' is displayed in Comments drawer$")
  public void checkActivityCommentInDrawer(String comment) {
    spaceSteps.checkActivityCommentInDrawer(comment);
  }

  @Then("^The comment '(.*)' is displayed in Comments drawer of activity '(.*)'$")
  public void checkActivityCommentInDrawer(String comment, String activity) {
    spaceSteps.checkActivityCommentDisplayed(activity, comment);
  }

  @Then("^The comment '(.*)' is not displayed in Comments drawer of activity '(.*)'$")
  public void checkActivityCommentNotDisplayed(String comment, String activity) {
    spaceSteps.checkActivityCommentNotDisplayed(activity, comment);
  }

  @And("^the activity '(.*)' is no more displayed in the activity stream$")
  @Then("^the activity '(.*)' is not displayed in activity stream$")
  @When("^the activity '(.*)' is not displayed in stream page$")
  @And("^The activity '(.*)' is not displayed$")
  public void checkActivityNotVisible(String activity) {
    spaceSteps.checkActivityNotVisible(activity);
  }

  @Then("^The activity '(.*)' is pinned in space stream$")
  public void checkActivityPinned(String activity) {
    spaceSteps.checkActivityPinned(activity);
  }

  @Then("^The activity page is opened '(.*)'$")
  public void checkActivityTitle(String activity) {
    spaceSteps.checkActivityTitle(activity);
  }

  @When("^the activity '(.*)' is displayed in activity stream$")
  @Then("^the activity '(.*)' is displayed in stream page$")
  @And("^The Poll '(.*)' is displayed in stream page$")
  @And("^The activity '(.*)' is displayed$")
  public void checkActivityVisible(String activity) {
    spaceSteps.checkActivityVisible(activity);
  }

  @When("^The comment '(.*)' is displayed$")
  public void checkCommentVisible(String comment) {
    spaceSteps.checkCommentVisible(comment);
  }

  @Then("^Comment is displayed in comments drawer at the sixth position$")
  public void checkCommentInDrawerSixthPosition() {
    spaceSteps.checkSixthPositionInDrawer();
  }

  @When("^In activity '(.*)' with comment '(.*)', the reply '(.*)' is displayed$")
  public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
    spaceSteps.checkCommentReplyDisplayed(activity, comment, reply);
  }

  @And("^In activity '(.*)' with comment '(.*)', the reply '(.*)' is displayed in Comment Drawer$")
  public void checkCommentReplyDisplayedInDrawer(String activity, String comment, String reply) {
    spaceSteps.checkCommentReplyDisplayedInDrawer(activity, comment, reply);
  }

  @When("^In activity '(.*)' with comment '(.*)', the reply '(.*)' is not displayed$")
  public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
    spaceSteps.checkCommentReplyNotDisplayed(activity, comment, reply);
  }

  @Then("The confirmation popup is displayed")
  public void checkConfirmationPopupIsVisible() {
    spaceSteps.checkConfirmationPopupVisible();
  }

  @Then("the confirmation popup is not displayed")
  public void checkConfirmationPopupNotVisible() {
    spaceSteps.checkConfirmationPopupNotVisible();
  }

  @When("^Create Poll Button is Disabled$")
  public void checkCreatePollButtonIsDisabled() {
    spaceSteps.checkCreatePollButtonIsDisabled();
  }

  @When("^Create Poll Button is Enabled$")
  public void checkCreatePollButtonIsEnabled() {
    spaceSteps.checkCreatePollButtonIsEnabled();
  }

  @Then("^the video '(.*)' is displayed in the activity stream$")
  public void checkDisplayVideo(String videoLink) {
    spaceSteps.checkVideoActivityVisible(videoLink);
  }

  @Then("^First comment '(.*)' is displayed in activity stream$")
  public void checkFirstActivityComment(String comment) {
    spaceSteps.checkFirstActivityComment(comment);
  }

  @Then("^First comment '(.*)' is displayed in comments drawer$")
  public void checkFirstCommentInDrawer(String comment) {
    spaceSteps.checkFirstCommentInDrawer(comment);
  }

  @Then("Check Four comment is displayed in comments drawer")
  public void checkFourCommentIsDisplayedInDrawer() {
    spaceSteps.checkFourCommentIsDisplayedInDrawer();
  }

  @Then("^Fourth comment is displayed in comments drawer$")
  public void checkFourthCommentInDrawer() {
    spaceSteps.checkFourthCommentInDrawer();
  }

  @Then("^Internal link '(.*)' is displayed in Comments drawer of activity '(.*)'$")
  public void checkInternalLinkCommentInDrawer(String comment, String activity) {
    spaceSteps.checkActivityCommentDisplayed(activity, currentUrlNoProtocol() + comment);
  }

  @Then("The link is displayed with the preview")
  public void checkPreviewLink() {
    spaceSteps.checkLinkPreviewVisible();
  }

  @Then("^The (.*) user is displayed in activity likers drawer$")
  public void checkReactionsDrawerDisplay(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + USER_LAST_NAME);
    spaceSteps.checkUserDisplayedInReactionsDrawer(userLastName);
  }

  @Then("^Second comment is displayed in activity stream$")
  public void checkSecondActivityComment() {
    spaceSteps.checkSecondActivityComment();
  }

  @Then("^Second comment is displayed in comments drawer$")
  public void checkSecondCommentInDrawer() {
    spaceSteps.checkSecondCommentInDrawer();
  }

  @Then("Check Ten comment is displayed in comments drawer")
  public void checkTenCommentIsDisplayedInDrawer() {
    spaceSteps.checkTenCommentIsDisplayedInDrawer();
  }

  @Then("^Third comment is displayed in comments drawer$")
  public void checkThirdCommentInDrawer() {
    spaceSteps.checkThirdCommentInDrawer();
  }

  @When("^I click on Create Poll$")
  public void clickCreatePoll() {
    spaceSteps.clickCreatePoll();
  }

  @When("^I click on send kudos$")
  public void clickSendKudos() {
    spaceSteps.clickSendKudos();
  }

  @When("^I send kudos to '(.*)' with message '(.*)'$")
  public void sendKudosWithReceiver(String receiver, String message) {
    spaceSteps.sendKudosWithReceiver(message, receiver);
  }

  @When("^I click Create Poll$")
  public void clickCreatePollButton() {
    spaceSteps.clickCreatePollButton();
  }

  @When("^I click on Delete button related to activity '(.*)'$")
  public void clickDeleteActivityButton(String activity) {
    spaceSteps.clickDeleteActivityButton(activity);
  }

  @When("^I click on '(.*)' button related to comment '(.*)'$")
  public void clickCommentButton(String buttonName, String comment) {
    spaceSteps.clickCommentButton(buttonName, comment);
  }

  @When("^I click on comment '(.*)'$")
  public void clickOnActivityComment(String comment) {
    spaceSteps.clickOnActivityComment(comment);
  }

  @When("^I click on comment button related to activity '(.*)'$")
  public void clickOnCommentActivity(String activity) {
    spacePage.clickOnCommentActivityButton(activity);
  }

  @When("^I go to the comments drawer first page$")
  public void clickOnCommentsDrawerFirstPage() {
    spaceSteps.clickOnCommentsDrawerFirstPage();
  }

  @When("^I go to the comments drawer second page$")
  public void clickOnCommentsDrawerSecondPage() {
    spaceSteps.clickOnCommentsDrawerSecondPage();
  }

  @Then("^I click on the comment '(.*)' three dots icon from comments drawer$")
  @And("^I click on the first comment '(.*)' three dots icon from comments drawer$")
  public void clickOnCommentThreeDotsButtonFromCommentsDrawer(String comment) {
    spaceSteps.clickOnCommentThreeDotsButtonFromCommentsDrawer(comment, false);
  }

  @When("^I click on the reply '(.*)' three dots icon from comments drawer$")
  public void clickOnReplyThreeDotsButtonFromCommentsDrawer(String comment) {
    spaceSteps.clickOnCommentThreeDotsButtonFromCommentsDrawer(comment, true);
  }

  @When("^I click on the internal link '(.*)'$")
  public void clickOnInternalLinkComment(String comment) {
    spaceSteps.clickOnActivityComment(currentUrlNoProtocol() + comment);
  }

  @When("^I click on Load more button$")
  public void clickOnLoadMoreActivities() {
    spaceSteps.clickOnLoadMoreActivities();
  }

  @Then("^In reply '(.*)', I click on kudos button$")
  public void clickOnReplyKudos(String reply) {
    spaceSteps.clickOnReplyKudos(reply);
  }

  @Then("I click on the kudos button on first displayed Activity")
  public void clickOnTheKudosButtonFromTheActivityStream() {
    spaceSteps.clickKudosFromActivityStream();
  }

  @Then("I click on the kudos button from the comment '(.*)'$")
  public void clickOnCommentKudosButton(String comment) {
    spaceSteps.clickOnCommentKudosButton(comment);
  }

  @Then("I click on the kudos button from the comments drawer")
  public void clickOnTheKudosButtonFromTheCommentsDrawer() {
    spaceSteps.clickKudosFromCommentsDrawer();
  }

  @And("I click on the kudos button number")
  public void clickOnTheKudosButtonNumber() {
    spaceSteps.clickOnKudosNumberButton();
  }

  @And("I click on the kudos button number from the comments drawer")
  public void clickOnTheKudosButtonNumberFromTheCommentsDrawer() {
    spaceSteps.clickOnKudosNumberButtonFromTheCommentsDrawer();
  }

  @Then("^I click on the (.*) user Popover$")
  public void clickOnTheRandomUserPopover(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    String userLastName = Serenity.sessionVariableCalled(userPrefix + USER_LAST_NAME);

    String fullName = userFirstName + " " + userLastName;
    spaceSteps.clickOnTheUserPopover(fullName);
  }

  @Then("^I click on the user Popover '(.*)'$")
  public void clickOnTheUserPopover(String user) {
    spaceSteps.clickOnTheUserPopover(user);
  }

  @When("^I click on View all X comments$")
  public void clickOnViewallXcomments() {
    spaceSteps.clickOnViewallXcomments();
  }

  @When("^I click on Pin button related to activity '(.*)'$")
  public void clickPinActivityButton(String activity) {
    spaceSteps.clickPinActivityButton(activity);
  }

  @When("I click on post in space")
  public void clickPostIcon() {
    spaceSteps.clickPostIcon();
  }

  @When("I click on user avatar in space stream")
  public void clickUserAvatar() {
    spaceSteps.clickUserAvatar();
  }

  @When("^I click on kudos button below the post field$")
  public void clickKudosBtnBelowPostField() {
    spaceSteps.clickKudosBtnBelowPostField();
  }

  @When("^I click on poll button below the post field$")
  public void clickPollBtnBelowPostField() {
    spaceSteps.clickPollBtnBelowPostField();
  }

  @Then("the composer is opened")
  public void composerDrawerIsDisplayed() {
    spaceSteps.composerDrawerIsDisplayed();
  }

  @Then("the kudos drawer is opened")
  public void kudosDrawerIsDisplayed() {
    spaceSteps.kudosDrawerIsDisplayed();
  }

  @When("^I close kudos drawer$")
  public void clickCloseKudosDrawer() {
    spaceSteps.clickCloseKudosDrawer();
  }

  @Then("The Poll drawer is opened")
  public void pollDrawerIsDisplayed() {
    spaceSteps.pollDrawerIsDisplayed();
  }

  @When("^I click to the Unpin button related to activity '(.*)'$")
  public void clickUnpinActivityButton(String activity) {
    spaceSteps.clickUnpinActivityButton(activity);
  }

  @Then("^'(.*)' among them '(.*)' are displayed in Comments drawer$")
  @And("^'(.*)', only '(.*)' is displayed in Comments drawer$")
  public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
    spaceSteps.commentIsDisplayedInDrawer(commentsNumber, comment);
  }

  @Then("^'(.*)' among them '(.*)' are not displayed in Comments drawer$")
  @And("^'(.*)', only '(.*)' is not displayed in Comments drawer$")
  public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
    spaceSteps.commentIsNotDisplayedInDrawer(commentsNumber, comment);
  }

  @When("^Comment '(.*)' is not displayed in the drawer$")
  public void commentNameIsNotDisplayedInDrawer(String comment) {
    spaceSteps.commentNameIsNotDisplayedInDrawer(comment);
  }

  @Then("^In comments drawer, on comment '(.*)', '(.*)' like is displayed$")
  public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
    spaceSteps.commentsDrawerDisplayedLikesOnComment(comment, number);
  }

  @When("^In comments drawer, I like the activity comment '(.*)'$")
  @And("^In comments drawer, I unlike the activity comment '(.*)'$")
  public void commentsDrawerlikeActivityComment(String activityComment) {
    spaceSteps.commentsDrawerlikeActivityComment(activityComment);
  }

  @When("^Copy link button related to activity '(.*)' is displayed$")
  public void copyLinkActivityButtonIsDisplayed(String activity) {
    spaceSteps.copyLinkActivityButtonIsDisplayed(activity);
  }

  @When("^I create a simple poll with title '(.*)' and Choice One '(.*)' and Choice Two '(.*)'$")
  public void createPoll(String pollTitle, String choiceOne, String choiceTow) {
    spaceSteps.createPoll(pollTitle, choiceOne, choiceTow);
  }

  @When("^create poll drawer is closed$")
  public void createPollDrawerClosed() {
    spaceSteps.createPollDrawerClosed();
  }

  @When("^I try to create a poll with title '(.*)' and with a single choice '(.*)'$")
  public void createPollWithOneChoice(String pollTitle, String choiceOne) {
    spaceSteps.createPollWithOneChoice(pollTitle, choiceOne);
  }

  @When("^Delete button related to activity '(.*)' is displayed$")
  public void deleteActivityButtonIsDisplayed(String activity) {
    spaceSteps.deleteActivityButtonIsDisplayed(activity);
  }

  @When("^In comment '(.*)', I click on delete button$")
  public void deleteComment(String comment) {
    spaceSteps.deleteComment(comment);
  }

  @When("^In reply '(.*)', I click on delete button$")
  public void deleteReply(String reply) {
    spaceSteps.deleteReply(reply);
  }

  @Then("^On comment '(.*)', '(.*)' like is displayed$")
  public void displayedLikesOnComment(String comment, String number) {
    spaceSteps.displayedLikesOnComment(comment, number);
  }

  @When("^Download button related to activity '(.*)' is displayed$")
  public void downloadActivityButtonIsDisplayed(String activity) {
    spaceSteps.downloadActivityButtonIsDisplayed(activity);
  }

  @When("I click on Update")
  public void editActivity() {
    spaceSteps.editActivity();
  }

  @When("^Edit button related to activity '(.*)' is displayed$")
  public void editActivityButtonIsDisplayed(String activity) {
    spaceSteps.editActivityButtonIsDisplayed(activity);
  }

  @When("^In comment '(.*)', I click on edit button$")
  public void editComment(String comment) {
    spaceSteps.editComment(comment);
  }

  @When("^In comment '(.*)', I click on edit button from comments drawer$")
  public void editCommentFromCommentsDrawer(String comment) {
    spaceSteps.editCommentFromCommentsDrawer(comment);
  }

  @When("^I edited created poll with title '(.*)' and Choice One '(.*)' and Choice Two '(.*)'$")
  public void editPoll(String pollTitle, String choiceOne, String choiceTow) {
    spaceSteps.editPoll(pollTitle, choiceOne, choiceTow);
  }

  @When("^I enter a comment '(.*)' with mentioning the (.*) user$")
  public void enterActivityCommentWithRandomUser(String comment, String userPrefix) {
    String lastName = Serenity.sessionVariableCalled(userPrefix + USER_LAST_NAME);
    spaceSteps.enterActivityCommentWithUser(comment, lastName);
  }

  @When("^I enter a comment '(.*)' with attempting to mention the (.*) user$")
  public void enterActivityCommentWithRandomUserNoMention(String comment, String userPrefix) {
    String lastName = Serenity.sessionVariableCalled(userPrefix + USER_LAST_NAME);
    spaceSteps.enterActivityCommentWithUserNoMention(comment, lastName);
  }

  @When("^I insert text '(.*)'$")
  public void enterActivityText(String activity) {
    spaceSteps.enterActivityText(activity);
  }

  @When("^In activity '(.*)' I enter the link '(.*)' as comment$")
  public void enterCommentLink(String activity, String link) {
    spacePage.enterCommentLink(activity, link);
  }

  @When("^I insert text '(.*)' as comment$")
  public void enterCommentText(String comment) {
    spaceSteps.enterCommentText(comment);
  }

  @Then("^I click on '(.*)' space menu tab$")
  public void goToTab(String tabName) {
    spaceSteps.goToSpecificTab(tabName);
  }

  @Given("^I add application '(.*)' in random space if not existing$")
  public void addSpaceApplicationIfNotExisting(String appName) {
    spaceSteps.addSpaceApplicationIfNotExisting(appName);
  }

  @When("^I open user profile of (.*) user from activity likers drawer$")
  public void goToUserProfileFromLikersDrawer(String prefix) {
    spaceSteps.goToUserProfileFromLikersDrawer(prefix);
  }

  @When("^In comment '(.*)', I hover on Like icon$")
  public void hoverOnLikeIcon(String comment) {
    spaceSteps.hoverOnLikeIcon(comment);
  }

  @When("^In comments drawer, in comment '(.*)', I hover on Like icon$")
  public void hoverOnLikeIconCommentsDrawer(String comment) {
    spaceSteps.hoverOnLikeIconCommentsDrawer(comment);
  }

  @When("^In post '(.*)', I mouse over the mentioned (.*) user$")
  public void hoverOnMentionedRandomUserInPost(String activity, String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    String userLastName = Serenity.sessionVariableCalled(userPrefix + USER_LAST_NAME);

    String fullName = userFirstName + " " + userLastName;
    spaceSteps.hoverOnMentionedUserInPost(activity, fullName);
  }

  @When("^In post '(.*)', I mouse over the mentioned user '(.*)'$")
  public void hoverOnMentionedUserInPost(String activity, String user) {
    spaceSteps.hoverOnMentionedUserInPost(activity, user);
  }

  @Then("^The internal link '(.*)' is opened in new tab$")
  public void internalLinkIsOpenedNewTab(String link) {
    spaceSteps.linkIsOpenedNewTab(link);
  }

  @Then("^The activity '(.*)' posted by the (.*) user in the created space is displayed with its timestamp in space stream page$")
  @And("^The activity '(.*)' posted by the (.*) user in the created space is displayed with its timestamp in streams page$")
  public void isActivityNamePostedByRandomUserSpaceDisplayed(String activity, String userPrefix) {
    String user = Serenity.sessionVariableCalled(userPrefix + "UserName");
    String space = Serenity.sessionVariableCalled("randomSpaceName");

    spaceSteps.isActivityNameUserSpaceDisplayed(activity, user, space);
  }

  @Then("^The activity '(.*)' posted by the user '(.*)' in space '(.*)' is displayed with its timestamp in activity stream$")
  @And("^The activity '(.*)' posted by the user '(.*)' in space '(.*)' is displayed with its timestamp in streams page$")
  public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
    spaceSteps.isActivityNameUserSpaceDisplayed(activity, user, space);
  }

  @When("^In post '(.*)', the mentioned (.*) user is displayed$")
  public void isMentionedRandomUserDisplayedInPost(String activity, String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    String userLastName = Serenity.sessionVariableCalled(userPrefix + USER_LAST_NAME);

    String fullName = userFirstName + " " + userLastName;
    spaceSteps.isMentionedUserDisplayedInPost(activity, fullName);
  }

  @When("^In post '(.*)', the mentioned user '(.*)' is displayed$")
  public void isMentionedUserDisplayedInPost(String activity, String user) {
    spaceSteps.isMentionedUserDisplayedInPost(activity, user);
  }

  @Then("User Popover of the (.*) user is displayed")
  public void isRandomUserPopoverDisplayed(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    String userLastName = Serenity.sessionVariableCalled(userPrefix + USER_LAST_NAME);

    String fullName = userFirstName + " " + userLastName;
    spaceSteps.isUserPopoverDisplayed(fullName);
  }

  @Then("^User Popover '(.*)' is displayed$")
  public void isUserPopoverDisplayed(String user) {
    spaceSteps.isUserPopoverDisplayed(user);
  }

  @Then("^In comment '(.*)', Kudos label should be black$")
  public void kudosLabelIsBlack(String comment) {
    spaceSteps.kudosLabelIsBlack(comment);
  }

  @Then("^In comment '(.*)', Kudos label should be blue$")
  public void kudosLabelIsBlue(String comment) {
    spaceSteps.kudosLabelIsBlue(comment);
  }

  @When("^I like the activity '(.*)'$")
  @And("^I unlike the activity '(.*)'$")
  public void likeActivity(String activity) {
    spaceSteps.likeActivity(activity);
  }

  @When("^I like the activity comment '(.*)'$")
  @And("^I unlike the activity comment '(.*)'$")
  public void likeActivityComment(String activityComment) {
    spaceSteps.likeActivityComment(activityComment);
  }

  @When("^In comments drawer, Like label in comment '(.*)' should be black$")
  @And("^In comments drawer, in comment '(.*)', Like label should be black$")
  public void likeLabelInCommentsDrawerIsBlack(String comment) {
    spaceSteps.likeLabelInCommentsDrawerIsBlack(comment);
  }

  @When("^In comments drawer, Like label in comment '(.*)' should be blue$")
  @And("^In comments drawer, in comment '(.*)', Like label should be blue$")
  public void likeLabelInCommentsDrawerIsBlue(String comment) {
    spaceSteps.likeLabelInCommentsDrawerIsBlue(comment);
  }

  @When("^In comment '(.*)', Like label should be black$")
  public void likeLabelIsBlack(String comment) {
    spaceSteps.likeLabelIsBlack(comment);
  }

  @When("^In comment '(.*)', Like label should be blue$")
  public void likeLabelIsBlue(String comment) {
    spaceSteps.likeLabelIsBlue(comment);
  }

  @Then("^Link '(.*)' is opened in new tab$")
  public void linkIsOpenedNewTab(String link) {
    spaceSteps.linkIsOpenedNewTab(link);
  }

  @When("^No comments displayed in the drawer$")
  public void noCommentDisplayedInDrawer() {
    spaceSteps.noCommentDisplayedInDrawer();
  }

  @When("^I click on likers number of the activity '(.*)'$")
  public void openActivityReactionsDrawer(String activity) {
    spaceSteps.openActivityReactionsDrawer(activity);
  }

  @Then("^The activity likers number is diplayed in '(.*)'$")
  public void checkActivityReactionsNumberDisplayed(String activity) {
    spaceSteps.checkActivityReactionsNumberDisplayed(activity);
  }
  @And("^The activity likers number is not diplayed in '(.*)'$")
  public void checkActivityReactionsNumberNotDisplayed(String activity) {
    spaceSteps.checkActivityReactionsNumberNotDisplayed(activity);
  }

  @When("^I open in activity '(.*)' the Comments drawer$")
  public void openCommentsDrawer(String activity) {
    spacePage.openCommentsDrawer(activity);
  }

  @When("^I click to delete from the dropdownActivitymenu$")
  public void openDeleteActivityMenu() {
    String oldActiviyy = Serenity.sessionVariableCalled(ACTIVITY);
    spaceSteps.openDeleteActivityMenu(oldActiviyy);
  }

  @When("^I click on modify the activity$")
  public void openEditActivityMenu() {
    String oldActiviyy = Serenity.sessionVariableCalled(ACTIVITY);
    spaceSteps.openEditActivityMenu(oldActiviyy);
  }

  @When("^I click on modify the activity '(.*)'$")
  public void openEditSpecificActivityMenu(String activiyy) {
    spaceSteps.openEditActivityMenu(activiyy);
  }

  @Then("^I open the internal link '(.*)' in new tab$")
  public void openInternalLinkInNewTab(String link) {
    spaceSteps.openLinkInNewTab(currentUrlNoProtocol() + link);
  }

  @Then("^I open link '(.*)' in new tab$")
  public void openLinkInNewTab(String link) {
    spaceSteps.openLinkInNewTab(link);
  }

  @When("^I click on three dots button related to activity '(.*)'$")
  public void openThreeDotsActivityMenu(String activity) {
    spaceSteps.openThreeDotsActivityMenu(activity);
  }

  @When("^Pin button related to activity '(.*)' is displayed$")
  public void pinActivityButtonIsDisplayed(String activity) {
    spaceSteps.pinActivityButtonIsDisplayed(activity);
  }

  @When("^Pin button related to activity '(.*)' is not displayed$")
  public void pinActivityButtonIsNotDisplayed(String activity) {
    spaceSteps.pinActivityButtonIsNotDisplayed(activity);
  }

  @Then("^The activity '(.*)' should be not pinned in space stream$")
  public void pinnedActivityDisappears(String activity) {
    spaceSteps.pinnedActivityDisappears(activity);
  }

  @When("^I post '(.*)' activities with prefix '(.*)'$")
  public void postManyActivities(String activityNumber, String activityPrefix) {
    spaceSteps.postManyActivities(activityNumber, activityPrefix);
  }

  @When("^I promote '(.*)' random user as a space manager$")
  public void promoteRandomUserAsSpaceManager(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + USER_LAST_NAME);
    spaceSteps.promoteSpaceMemberAsManager(userLastName);
  }

  @When("^I promote '(.*)' as a space manager$")
  public void promoteSpaceMemberAsManager(String name) {
    spaceSteps.promoteSpaceMemberAsManager(name);
  }

  @When("^I publish the activity$")
  @And("^I publish the Poll$")
  public void publishActivity() {
    spaceSteps.publishActicity();
  }

  @And("I attach an image to the activity")
  public void attachImageToActivity() {
    spaceSteps.attachImageToActivity();
  }
  
  @And("I attach a gif image to the activity")
  public void attachGifImageToActivity() {
    spaceSteps.attachGifImageToActivity();
  }
  
  @And("the crop zone should be blurred")
  public void checkCropDrawerBlurredZone() {
    spaceSteps.checkCropDrawerBlurredZone();
  }
  
  @And("I attach an image to the kudos")
  public void attachImageToKudos() {
    spaceSteps.attachImageToKudos();
  }
  
  @And("I attach an image to the activity comment")
  public void attachImageToActivityComment() {
    spaceSteps.attachImageToActivityComment();
  }

  @When("^I publish the activity stream in arabic language$")
  public void publishActivityInArabicLanguage() {
    spaceSteps.publishActivityInArabicLanguage();
  }

  @When("^I publish the comment$")
  public void publishComment() {
    spaceSteps.publishComment();
  }

  @When("^(.*) User is mentioned in the comment$")
  public void randomUserIsMentionedInCommentEntered(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix.toLowerCase() + USER_FIRST_NAME);
    String userLastName = Serenity.sessionVariableCalled(userPrefix.toLowerCase() + USER_LAST_NAME);
    String fullName = userFirstName + " " + userLastName;
    spaceSteps.userIsMentionedInCommentEntered(fullName);
  }

  @When("^(.*) User is not mentioned in the comment$")
  public void randomUserIsNotMentionedInCommentEntered(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix.toLowerCase() + USER_FIRST_NAME);
    String userLastName = Serenity.sessionVariableCalled(userPrefix.toLowerCase() + USER_LAST_NAME);
    String fullName = userFirstName + " " + userLastName;
    spaceSteps.userIsNotMentionedInCommentEntered(fullName);
  }

  @Then("^'(.*)' kudos are displayed on the reaction drawer$")
  public void receivedKudosOnDrawerIsDisplayed(String kudosNumber) {
    spaceSteps.receivedKudosDrawerIsDisplayed(kudosNumber);
  }

  @And("^I click on Yes button$")
  public void removeactivity() {
    spaceSteps.deleteactivity();
  }

  @When("^The reply '(.*)' is not displayed in the drawer$")
  public void replyInDrawerIsNotDisplayed(String reply) {
    spaceSteps.replyInDrawerIsNotDisplayed(reply);
  }

  @When("^In comment '(.*)', the reply '(.*)' is displayed in the drawer$")
  public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
    spaceSteps.replyIsDisplayedInCommentsDrawer(comment, reply);
  }

  @When("^In comment '(.*)', the reply '(.*)' is not displayed in the drawer$")
  public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
    spaceSteps.replyIsNotDisplayedInCommentsDrawer(comment, reply);
  }

  @Then("^In reply '(.*)', Kudos label should be black$")
  public void replyKudosLabelIsBlack(String comment) {
    spaceSteps.replyKudosLabelIsBlack(comment);
  }

  @Then("^In reply '(.*)', Kudos label should be blue$")
  public void replyKudosLabelIsBlue(String comment) {
    spaceSteps.replykudosLabelIsBlue(comment);
  }

  @When("^I click on filter icon from composer$")
  public void clickFilterIconFromComposer() {
    spaceSteps.clickFilterIconFromComposer();
  }

  @Then("^I click on '(.*)' activity filter radio button$")
  public void selectActivityFilter(String filter) {
    spaceSteps.selectActivityFilter(filter);
  }

  @Then("^the stream filter is selected$")
  public void filterIsSelected() {
    spaceSteps.filterIsSelected();
  }

  @Then("^the stream filter isn't selected$")
  public void filterIsntSelected() {
    spaceSteps.filterIsntSelected();
  }

  @When("^Tooltip Like on '(.*)' is displayed in comments drawer$")
  @And("^Tooltip Remove Like on '(.*)' is displayed in comments drawer$")
  public void tooltipCommentsDrawerIsDisplayed(String comment) {
    spaceSteps.tooltipCommentsDrawerIsDisplayed(comment);
  }

  @When("^Unpin button related to activity '(.*)' is displayed$")
  public void unPinActivityButtonIsDisplayed(String activity) {
    spaceSteps.unPinActivityButtonIsDisplayed(activity);
  }

  @When("^I click on update comment$")
  public void updateComment() {
    spaceSteps.updateComment();
  }

  @When("^I update comment with a new one '(.*)'$")
  public void updateCommentText(String comment) {
    spaceSteps.updateCommentText(comment);
  }

  @Then("^I click on View All replies related to the comment '(.*)' in activity stream$")
  public void viewAllRepliesInActivityStream(String comment) {
    spaceSteps.viewAllRepliesInActivityStream(comment);
  }

  @Then("^I click on View All replies related to the comment '(.*)'$")
  public void viewAllRepliesInCommentsDrawer(String comment) {
    spaceSteps.viewAllRepliesInCommentsDrawer(comment);
  }

  private String currentUrlNoProtocol() {
    return spacePage.getCurrentUrl().replace("https://", "").replace("http://", "").replace("www.", "");
  }

  @Then("^The attached images should be displayed in the published activity '(.*)'$")
  public void checkActivityAttachedImages(String activity) {
    spaceSteps.checkActivityAttachedImages(activity);
  }
  
  @And("^The second attached image should be displayed in the published activity '(.*)'$")
  public void checkActivitySecondAttachedImage(String activity) {
    spaceSteps.checkActivitySecondAttachedImage(activity);
  }
  
  @Then("^The attached images should be displayed in the activity comment '(.*)'$")
  public void checkKudosCommentAttachedImages(String comment) {
    spaceSteps.checkKudosCommentAttachedImages(comment);
  }

  @When("^I click on attached image related to activity '(.*)'$")
  public void clickPreviewAttachedImage(String activity) {
    spaceSteps.clickPreviewAttachedImage(activity);
  }

  @Then("^the preview of the attached image is displayed")
  public void previewAttachedImage() {
    spaceSteps.previewAttachedImage();
  }
  
  @And("^The preview arrows are not displayed")
  public void checkPreviewAttachedImageArrows() {
    spaceSteps.checkPreviewAttachedImageArrows();
  }

  @When("^I click on close icon in preview attached image")
  public void clickClosePreviewAttachedImage() {
    spaceSteps.clickClosePreviewAttachedImage();
  }

  @Then("^the preview of the attached image is not displayed")
  public void checkPreviewAttachedImageIsClosed() {
    spaceSteps.checkPreviewAttachedImageIsClosed();
  }
  
  @Then("^The attached images should be displayed in the activity '(.*)' drawer with the delete icon")
  public void checkActivityDrawerAttachedImagesDeleteIcon(String activity) {
    spaceSteps.checkActivityDrawerAttachedImagesDeleteIcon(activity);
  }
  
  @Then("^The attached images should be displayed in the activity '(.*)' drawer with the edit icon")
  public void checkActivityDrawerAttachedImagesEditIcon(String activity) {
    spaceSteps.checkActivityDrawerAttachedImagesEditIcon(activity);
  }
  
  @Then("^I click on delete an attached image")
  public void clickDeleteAttachment() {
    spaceSteps.clickDeleteAttachment();
  }
  
  @Then("^I update the attached image")
  public void clickUpdateAttachment() {
    spaceSteps.clickEditAttachment();
  }
  
  @Then("^I click on edit an attached image")
  public void clickEditAttachment() {
    spaceSteps.clickEditAttachment();
  }
  
  @When("^I click to zoom attached image")
  public void zoomAttachedImage() {
    spaceSteps.zoomAttachedImage();
  }
  
  @When("^The cancel option is displayed")
  public void checkAttachedImageCropDrawerCancelOption() {
    spaceSteps.checkAttachedImageCropDrawerCancelOption();
  }
  
  
  @Then("^The attached image crop drawer displayed")
  public void checkAttachedImageCropDrawer() {
    spaceSteps.checkAttachedImageCropDrawer();
  }
  
  @Then("^The attached image is not displayed")
  public void checkActivityAttachImageDeleted () {
    spaceSteps.checkActivityAttachImageDeleted();
  }
  
  @Then("^The attached images should not be displayed in the published activity '(.*)'$")
  public void checkActivityAttachedImagesIsNotDisplayed(String activity) {
    spaceSteps.checkActivityAttachedImagesIsNotDisplayed(activity);
  }

  @When("^I open '(.*)' Section from Space Settings$")
  public void openSpaceSettingsSection(String sectionId) {
    spaceSteps.openSpaceSettingsSection(sectionId);
  }

  @When("I enable redactional settings for the space")
  public void enableRedactionalSpaceSettings() {
    spaceSteps.enableRedactionalSpaceSettings();
  }

  @When("^I add the '(.*)' user as redactor$")
  public void promoteUserAsSpaceRedactor(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    spaceSteps.promoteUserAsSpaceRedactor(userFirstName);
  }

  @When("^I open the drawer to add a '(.*)'$")
  public void openSpaceSettingsRoleDrawer(String role) {
    spaceSteps.openSpaceSettingsRoleDrawer(role);
  }

  @When("^I promote the '(.*)' user as manager$")
  @When("^I promote the '(.*)' user as publisher$")
  @When("^I promote the '(.*)' user as redactor$")
  public void addUserWithRoleInSpace(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + USER_FIRST_NAME);
    spaceSteps.addUserWithRoleInSpace(userFirstName);
  }

}
