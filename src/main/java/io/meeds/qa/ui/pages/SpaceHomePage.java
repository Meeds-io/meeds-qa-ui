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
package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.*;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;
import net.serenitybdd.core.Serenity;

public class SpaceHomePage extends GenericPage {
  private static final String OPENED_ACTIVITY_COMMENTS_DRAWER_SELECTOR        =
                                                                       "//*[@id='activityCommentsDrawer' and contains(@class, 'v-navigation-drawer--open')]";

  private static final String OPENED_ACTIVITY_REPLIES_DRAWER_SELECTOR         =
                                                                      "//*[@id='activityCommentsDrawer' and contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'activity-comment')]";

  private static final String OPENED_ACTIVITY_COMPOSER_DRAWER_SELECTOR        =
                                                                       "//*[@id = 'activityComposerDrawer' and contains(@class, 'v-navigation-drawer--open')]";

  private static final String CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR = "//*[contains(text(),'Yes')]";

  public SpaceHomePage(WebDriver driver) {
    super(driver);
  }

  public void addActivityTextInOpenedEditor(String activity) {
    waitForDrawerToOpen();
    waitCKEditorLoading(OPENED_ACTIVITY_COMPOSER_DRAWER_SELECTOR);

    getDriver().switchTo().frame(ckEditorFrameElement());
    try {
      TextBoxElementFacade activityContentTextBoxElement = activityContentTextBoxElement();
      if (activity.contains("https")) {
        // A workaround to the fact that the preview isn't triggered only by a
        // Paste Event
        activityContentTextBoxElement.sendKeys(activity);
        activityContentTextBoxElement.sendKeys(Keys.CONTROL + "a");
        activityContentTextBoxElement.sendKeys(Keys.CONTROL + "x");
        getDriver().switchTo().defaultContent();
        closeDrawerIfDisplayed();
        clickPostIcon();
        waitForDrawerToOpen();

        getDriver().switchTo().frame(ckEditorFrameElement());
        activityContentTextBoxElement = activityContentTextBoxElement();
        activityContentTextBoxElement.sendKeys(Keys.CONTROL + "v");
        int i = MAX_WAIT_RETRIES;
        while (!activityLinkPreviewElement().isVisible() && i-- > 0) {
          waitFor(2).seconds();
        }
      } else if (activity.contains("lien")) {
        activityContentTextBoxElement.click();
        activityContentTextBoxElement.sendKeys(Keys.PAGE_UP);
        activityContentTextBoxElement.sendKeys(activity);
      } else {
        activityContentTextBoxElement.setTextValue(activity);
        Serenity.setSessionVariable("activity").to(activity);
      }
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void addActivityComment(String activity, String comment) {
    getActivityCommentButton(activity).click();
    waitForDrawerToOpen();
    waitForDrawerToLoad();

    addActivityCommentEditorContent(comment, false, true);
    closeDrawerIfDisplayed();
  }

  public void addActivityComments(String activity, List<String> comments) {
    getActivityCommentButton(activity).click();
    waitForDrawerToOpen();
    waitForDrawerToLoad();

    Iterator<String> commentsIterator = comments.iterator();
    while (commentsIterator.hasNext()) {
      String comment = commentsIterator.next();
      addActivityCommentEditorContent(comment, false, true);
      if (commentsIterator.hasNext()) {
        waitFor(100).milliseconds(); // Wait for CKEditor to completely close
        ElementFacade addCommentInDrawerButton =
                                               findByXPathOrCSS(".v-navigation-drawer--open .drawerIcons > button:first-of-type");
        addCommentInDrawerButton.click();
      }
    }
    closeDrawerIfDisplayed();
  }

  public void addActivityCommentEditorContent(String comment, boolean edit, boolean save) {
    retryOnCondition(() -> {
      if (!edit && !ckEditorFrameCommentElement().isCurrentlyVisible()) {
        addCommentButtonInDrawerElement().click();
        waitFor(200).milliseconds();
      }
      waitOnCommentRichText();
      getDriver().switchTo().frame(ckEditorFrameCommentElement());
      try {
        TextBoxElementFacade ckEditorBodyCommentElement = ckEditorBodyCommentElement();
        ckEditorBodyCommentElement.waitUntilVisible();
        ckEditorBodyCommentElement.setTextValue(comment);
      } finally {
        getDriver().switchTo().defaultContent();
      }
      if (save) {
        clickOnSaveComment();
      }
    });
    if (save) {
      waitForDrawerToLoad();
      ckEditorFrameCommentElement().waitUntilNotVisible();
    }
  }

  public void clickOnSaveComment() {
    ElementFacade saveCommentButtonInDrawerElement = saveCommentButtonInDrawerElement();
    saveCommentButtonInDrawerElement.click();
  }

  public void addCommentReplies(List<String> replies, String comment, String activity) {
    clickOnReplyToComment(comment, activity, false);
    Iterator<String> repliesIterator = replies.iterator();
    while (repliesIterator.hasNext()) {
      String reply = repliesIterator.next();
      waitOnReplyRichText();
      addReplyEditorContent(reply);
      waitForDrawerToLoad();
      if (repliesIterator.hasNext()) {
        ckEditorFrameCommentElement().checkNotVisible(); // Wait for CKEditor to
                                                         // completely close
        clickOnReplyToComment(comment, activity, true);
      }
    }
    closeDrawerIfDisplayed();
  }

  public void addCommentReply(String reply, String comment, String activity) {
    clickOnReplyToComment(comment, activity, false);
    waitForDrawerToOpen();
    waitForDrawerToLoad();

    waitOnReplyRichText();
    addReplyEditorContent(reply);
    closeDrawerIfDisplayed();
  }

  public void addDescriptionLess1000CharsInThePoll(String choiceThree) {
    TextBoxElementFacade choiceThreePollElement = choiceThreePollElement();
    choiceThreePollElement.waitUntilVisible();
    choiceThreePollElement.setTextValue(choiceThree);
  }

  public void addOptionThreeInThePoll(String choiceThree) {
    TextBoxElementFacade choiceThreePollElement = choiceThreePollElement();
    choiceThreePollElement.click();
    choiceThreePollElement.setTextValue(choiceThree);
  }

  public void addOptionTwoInThePoll(String choiceTow) {
    TextBoxElementFacade choiceTwoPollElement = choiceTwoPollElement();
    choiceTwoPollElement.click();
    choiceTwoPollElement.setTextValue(choiceTow);
  }

  public void cancelDeleteComment() {
    cancelDeleteCommentBtnElement().click();
  }

  public void cancelUpdateActivityComment(String comment) {
    waitOnCommentRichText();
    getDriver().switchTo().frame(ckEditorFrameCommentElement());
    try {
      TextBoxElementFacade commentFieldElement = commentFieldElement();
      commentFieldElement.waitUntilVisible();
      commentFieldElement.clear();
      commentFieldElement.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    cancelBtnElement().click();
    closeCommentsDrawerElement().click();
  }

  public void checkActivityComment(String comment) {
    Assert.assertEquals(commentTitleElement().getText(), comment);
  }

  public void checkActivityCommentInDrawer(String comment) {
    getCommentElementInDrawer(comment).assertVisible();
    closeDrawerIfDisplayed();
  }

  public void checkActivityCommentNotDisplayed(String activity, String comment) {
    waitForLoading();
    retryOnCondition(() -> getDropDownCommentMenu(activity, comment).checkNotVisible(), () -> {
      waitFor(3).seconds();
      Utils.refreshPage();
    });
  }

  public void checkActivityNotVisible(String activity) {
    getActivityText(activity).assertNotVisible();
  }

  public void checkActivityPinned(String activity) {
    getPinnedActivity(activity).assertVisible();
  }

  public void checkActivityTitle(String activity) {
    Assert.assertEquals(activityTitleElement().getText(), activity);
  }

  public void checkActivityVisible(String activity) {
    getActivityText(activity).assertVisible();
  }

  public void checkCommentVisible(String comment) {
    getCommentElement(comment).assertVisible();
  }

  public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
    getReplyBox(comment, reply, StringUtils.isBlank(activity)).assertVisible();
  }

  public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
    getReplyBox(comment, reply, StringUtils.isBlank(activity)).assertNotVisible();
  }

  public void checkConfirmationPopupNotVisible() {
    findByXPathOrCSS(CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR).assertNotVisible();
  }

  public void checkConfirmationPopupVisible() {
    findByXPathOrCSS(CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR).assertVisible();
  }

  public void checkCreatePollButtonIsDisabled() {
    buttonCreatePollElement().assertDisabled();
  }

  public void checkCreatePollButtonIsEnabled() {
    buttonCreatePollElement().assertEnabled();
  }

  public void checkFirstActivityComment(String comment) {
    Assert.assertEquals(firstASDisplayedCommentElement().getText(), comment);
  }

  public void checkFirstCommentInDrawer(String comment) {
    Assert.assertEquals(firstCommentInDrawerElement().getText(), comment);
    closeDrawerIfDisplayed();
  }

  public void checkFourCommentIsDisplayedInDrawer() {
    firstCommentInDrawerElement().assertVisible();
    secondCommentInDrawerElement().assertVisible();
    thirdCommentInDrawerElement().assertVisible();
    fourthCommentInDrawerElement().assertVisible();
    closeDrawerIfDisplayed();
  }

  public void checkFourthCommentInDrawer() {
    fourthCommentInDrawerElement().assertVisible();
    closeDrawerIfDisplayed();
  }

  public void checkLinkPreviewVisible() {
    findByXPathOrCSS("//*[contains(@class, 'activity-thumbnail-box')]//*[contains(@class, 'v-avatar')]").assertVisible();
  }

  public void checkSearchedUserWellMatched(String fullName) {
    insertNameContact(fullName);
    retryOnCondition(() -> getUserProfileButton(fullName).checkVisible(),
                     () -> {
                       filterTextBoxElement().sendKeys(Keys.BACK_SPACE);
                       waitFor(300).milliseconds();
                       waitForLoading();
                     });
  }

  public void checkSecondActivityComment() {
    secondASDisplayedCommentElement().assertVisible();
  }

  public void checkSecondCommentInDrawer() {
    secondCommentInDrawerElement().assertVisible();
    closeDrawerIfDisplayed();
  }

  public void checkSixthPositionInDrawer() {
    sixthPositionInDrawerElement().assertVisible();
    closeDrawerIfDisplayed();
  }

  public void checkTenCommentIsDisplayedInDrawer() {
    firstCommentInDrawerElement().assertVisible();
    secondCommentInDrawerElement().assertVisible();
    thirdCommentInDrawerElement().assertVisible();
    fourthCommentInDrawerElement().assertVisible();
    fifthCommentInDrawerElement().assertVisible();
    sixthPositionInDrawerElement().assertVisible();
    seventhCommentInDrawerElement().assertVisible();
    eighthCommentInDrawerElement().assertVisible();
    ninthCommentInDrawerElement().assertVisible();
    tenthCommentInDrawerElement().assertVisible();
    closeDrawerIfDisplayed();
  }

  public void checkThirdCommentInDrawer() {
    thirdCommentInDrawerElement().assertVisible();
    closeDrawerIfDisplayed();
  }

  public void checkUserDisplayedInReactionsDrawer(String userLastName) {
    getUserElementFromReactionsDrawer(userLastName).assertVisible();
  }

  public void checkVideoActivityVisible(String videoLink) {
    getSharedVideoPreview(videoLink).assertVisible();
  }

  public void clickApplyDownload() {
    applyDownloadButtonElement().click();
  }

  public void clickCreatePoll() {
    createPollLinkElement().click();
  }

  public void clickSendKudos() {
    sendKudosLinkElement().click();
  }

  public void clickKudosBtnBelowPostField() {
    ElementFacade sendKudos = findByXPathOrCSS("//*[contains(@class,'activityComposer')]//*[contains(@id,'kudosBtnToolbar')]");
    sendKudos.click();
  }

  public void clickPollBtnBelowPostField() {
    ElementFacade createPoll= findByXPathOrCSS("//*[contains(@class,'activityComposer')]//*[contains(@id,'pollBtnToolbar')]");
    createPoll.click();
  }

  public void clickCreatePollButton() {
    buttonCreatePollElement().click();
  }

  public void clickDeleteActivityButton(String activity) {
    getDeleteActivityIcon(activity).click();
  }

  public void clickCommentButton(String buttonName, String comment) {
    getCommentMenuButton(buttonName, comment).click();
  }

  public void clickOnActivityComment(String comment) {
    getCommentTitleActivityStream(comment).click();
  }

  public void clickOnCommentActivityButton(String activity) {
    getActivityCommentButton(activity).click();
  }

  public void clickOnCommentsDrawerFirstPage() {
    commentsDrawerFirstPageBtnElement().click();
  }

  public void clickOnCommentsDrawerSecondPage() {
    commentsDrawerSecondPageBtnElement().click();
  }

  public void clickOnCommentThreeDotsButton(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).click();
  }

  public void clickOnCommentThreeDotsButtonFromCommentsDrawer(String comment) {
    getDropDownCommentMenuFromCommentsDrawer(comment).click();
  }

  public void clickOnCommentThreeDotsInCommentsDrawer(String comment) {
    ElementFacade commentsDrawerDropDownMenu = getCommentsDrawerDropDownMenu(comment);
    clickOnElement(commentsDrawerDropDownMenu);
  }

  public void clickOnConfirmButton() {
    getConfirmButton("Confirm").click();
  }

  public void clickOnDeleteReplyButton(String activity, String comment, String reply) {
    getDropDownReplyMenu(activity, comment, reply).click();
  }

  public void clickOnkudosButtonFromCommentsDrawerToCommentActivity() {
    kudosButtonFromCommentsDrawerToCommentActivityElement().click();
    waitForDrawerToOpen("#activityKudosDrawer", false);
  }

  public void clickOnKudosButtonNumberFromCommentsDrawerToCommentActivity() {
    kudosButtonNumberFromCommentsDrawerToCommentActivityElement().assertVisible();
    kudosButtonNumberFromCommentsDrawerToCommentActivityElement().click();
    waitForDrawerToOpen(".v-navigation-drawer--open .kudos-list", false);
  }

  public void clickOnKudosButtonNumberToCommentActivity() {
    kudosButtonNumberToCommentActivityElement().click();
  }

  public void clickOnkudosButtonToActivityStream() {
    ElementFacade firstActivityKudosButton =
                                           findByXPathOrCSS("(//*[contains(@class, 'activity-detail')])[1]//*[contains(@class, 'activity-footer-actions')]//*[contains(@id, 'KudosActivity')]");
    firstActivityKudosButton.click();
  }

  public void clickOnkudosButtonToCommentActivity() {
    kudosButtonToCommentActivityElement().click();
  }

  public void clickOnLoadMoreActivities() {
    loadMoreActivitiesBtnElement().click();
  }

  public void clickOnReplyDropDownMenu(String activity, String comment, String reply) {
    ElementFacade threeDots = getDropDownReplyMenu(activity, comment, reply);
    threeDots.waitUntilVisible();
    threeDots.click();
  }

  public void clickOnReplyKudos(String reply) {
    getBlackKudosCommentIcon(reply).click();
  }

  public void clickOnTheUserPopover(String user) {
    getUserPopover(user).click();
  }

  public void clickOnViewallXcomments() {
    viewallXcommentsElement().click();
  }

  public void clickPinActivityButton(String activity) {
    getPinActivityIcon(activity).click();
  }

  public void clickPostIcon() {
    goToSpecificTab("Stream");
    waitForLoading();
    ElementFacade activityPostLink = findByXPathOrCSS(".activityComposer .openLink");
    activityPostLink.click();
  }

  public void composerDrawerIsDisplayed() {
    findByXPathOrCSS("#activityComposerDrawer").assertVisible(); 
  }

  public void kudosDrawerIsDisplayed() {
    findByXPathOrCSS("#activityKudosDrawer").assertVisible(); 
  }

  public void pollDrawerIsDisplayed() {
    findByXPathOrCSS("#createPollDrawer").assertVisible(); 
  }

  public void clickUserAvatar() {
    ElementFacade userAvatarLink = findByXPathOrCSS("//*[contains(@class,'activityComposer')]//descendant::*[starts-with(@id,'userAvatar')]");
    userAvatarLink.click();
  }

  public void clickCloseKudosDrawer() {
    ElementFacade closeKudosDrawerIcon = findByXPathOrCSS("//*[contains(@id,'activityKudosDrawer')]//*[contains(@class,'drawerIcons')]//button[@title='Close']");
    closeKudosDrawerIcon.click();
  }

  public void clickUnpinActivityButton(String activity) {
    getUnpinActivityIcon(activity).click();
  }

  public void clickYesbutton() {
    findByXPathOrCSS(CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR).click();
    waitFor(200).milliseconds();
    waitForLoading();
  }

  public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
    getDrawerCommentsNumberAndNames(commentsNumber, comment).assertVisible();
  }

  public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
    getDrawerCommentsNumberAndNames(commentsNumber, comment).assertNotVisible();
  }

  public void commentNameIsNotDisplayedInDrawer(String comment) {
    getDrawerCommentName(comment).assertNotVisible();
  }

  public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
    assertTrue(getCommentLikesNumberCommentsDrawer(comment).getTextContent().contains(number));
  }

  public void commentsDrawerlikeActivityComment(String activityComment) {
    getCommentsDrawerLikeCommentIcon(activityComment).click();
  }

  public void copyLinkActivityButtonIsDisplayed(String activity) {
    getCopyLinkActivityIcon(activity).assertVisible();
  }

  public void createPoll(String pollTitle, String choiceOne, String choiceTow) {
    waitForDrawerToOpen("#createPollDrawer", false);
    titlePollElement().setTextValue(pollTitle);
    choiceOnePollElement().setTextValue(choiceOne);
    choiceTwoPollElement().setTextValue(choiceTow);
    buttonCreatePollElement().click();
    waitForDrawerToClose("#createPollDrawer", false);
  }

  public void createPollDrawerClosed() {
    titlePollElement().assertNotVisible();
  }

  public void createPollWithOneChoice(String pollTitle, String choiceOne) {
    TextBoxElementFacade titlePollElement = titlePollElement();
    titlePollElement.click();
    titlePollElement.setTextValue(pollTitle);
    TextBoxElementFacade choiceOnePollElement = choiceOnePollElement();
    choiceOnePollElement.click();
    choiceOnePollElement.setTextValue(choiceOne);
  }

  public void deleteActivityButtonIsDisplayed(String activity) {
    getDeleteActivityIcon(activity).assertVisible();
  }

  public void deleteComment(String comment) {
    getDeleteCommentLabel(comment).click();
  }

  public void deleteReply(String reply) {
    getDeleteReplyLabel(reply).click();
  }

  public void displayedLikesOnComment(String comment, String number) {
    assertTrue(getCommentLikesNumber(comment).getTextContent().contains(number));
  }

  public void downloadActivityButtonIsDisplayed(String activity) {
    getDownloadActivityIcon(activity).assertVisible();
  }

  public void clickOnUpdateActivity() {
    updateActivityButtonElement().click();
    waitForLoading();
    waitFor(200).milliseconds(); // Update doesn't trigger a loading effect, bad
                                 // UX
  }

  public void editActivityButtonIsDisplayed(String activity) {
    getEditActivityIcon(activity).assertVisible();
  }

  public void editComment() {
    dotsMenuElement().click();
    editButtonElement().click();

  }

  public void editComment(String comment) {
    getEditCommentLabel(comment).click();
  }

  public void editCommentFromCommentsDrawer(String comment) {
    getEditCommentLabelFromCommentsDrawer(comment).click();
  }

  public void editPoll(String pollTitle, String choiceOne, String choiceTow) {
    TextBoxElementFacade titlePollElement = titlePollElement();
    titlePollElement.click();
    titlePollElement.setTextValue(pollTitle);
    TextBoxElementFacade choiceOnePollElement = choiceOnePollElement();
    choiceOnePollElement.click();
    choiceOnePollElement.setTextValue(choiceOne);
    TextBoxElementFacade choiceTwoPollElement = choiceTwoPollElement();
    choiceTwoPollElement.click();
    choiceTwoPollElement.setTextValue(choiceTow);
    buttonCreatePollElement().click();
  }

  public void enterActivityCommentWithUser(String comment, String user) {
    mentionUserInCKEditor(ckEditorFrameCommentElement(), ckEditorBodyCommentElement(), comment, user, true);
  }

  public void enterActivityCommentWithUserNoMention(String comment, String user) {
    mentionUserInCKEditor(ckEditorFrameCommentElement(), ckEditorBodyCommentElement(), comment, user, false);
  }

  public void enterActivityText(String activity) {
    ckEditorFrameElement().waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameElement());
    try {
      TextBoxElementFacade activityContentTextBoxElement = activityContentTextBoxElement();
      activityContentTextBoxElement.waitUntilVisible();
      activityContentTextBoxElement.sendKeys(activity);
      activityContentTextBoxElement.sendKeys(Keys.SPACE);
      activityContentTextBoxElement.sendKeys(Keys.BACK_SPACE);
      waitFor(100).milliseconds();
    } finally {
      getDriver().switchTo().defaultContent();
    }
    Serenity.setSessionVariable("activity").to(activity);
  }

  public void enterCommentLink(String activity, String comment) {

    getActivityCommentButton(activity).click();

    waitOnCommentRichText();
    ElementFacade ckEditorFrameCommentElement = ckEditorFrameCommentElement();
    getDriver().switchTo().frame(ckEditorFrameCommentElement);
    try {
      TextBoxElementFacade ckEditorBodyCommentElement = ckEditorBodyCommentElement();
      if (comment.contains("https")) {
        ckEditorBodyCommentElement.sendKeys(comment);
        ckEditorBodyCommentElement.sendKeys(Keys.CONTROL + "a" + "x");
        refreshPage();
        getActivityCommentButton(activity).click();
        ckEditorFrameCommentElement.waitUntilVisible();
        waitOnCommentRichText();
        getDriver().switchTo().frame(ckEditorFrameCommentElement);

        ckEditorBodyCommentElement.waitUntilVisible();
        ckEditorBodyCommentElement.click();
        ckEditorBodyCommentElement.sendKeys(Keys.CONTROL + "v");
      } else if (comment.contains("lien")) {
        ckEditorBodyCommentElement.click();
        ckEditorBodyCommentElement.sendKeys(Keys.PAGE_UP);
        ckEditorBodyCommentElement.sendKeys(comment);
      } else {
        ckEditorBodyCommentElement.setTextValue(comment);
        Serenity.setSessionVariable("comment").to(comment);
      }
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void enterCommentText(String comment) {
    ckEditorFrameCommentElement().waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameCommentElement());
    try {
      TextBoxElementFacade ckEditorBodyCommentElement = ckEditorBodyCommentElement();
      ckEditorBodyCommentElement.waitUntilVisible();
      ckEditorBodyCommentElement.sendKeys(comment);
      ckEditorBodyCommentElement.sendKeys(Keys.SPACE);
      ckEditorBodyCommentElement.sendKeys(Keys.BACK_SPACE);
      waitFor(100).milliseconds();
    } finally {
      getDriver().switchTo().defaultContent();
    }
    Serenity.setSessionVariable("comment").to(comment);
  }

  public void filterByMyConnections() {
    ElementFacade filterByMyConnectionsElement = filterByMyConnectionsElement();
    filterByMyConnectionsElement.waitUntilVisible();
    filterByMyConnectionsElement.click();
    filterByMyConnectionsElement.selectByValue("connections");
  }

  public void getReceivedKudosSectionIsDisplayed(String kudosNumber) {
    getReceivedKudosNumberInDrawer(kudosNumber).assertVisible();
  }

  public void goToPeopleMenu() {
    menuBtnElement().click();
    peopleBtnElement().click();
  }

  public void addSpaceApplicationIfNotExisting(String applicationName) {
    ElementFacade tabElement = searchSpaceTabElement(applicationName);
    if (tabElement.isCurrentlyVisible()) {
      return;
    }
    installedApplicationCard(applicationName).assertNotVisible(); // Check app
                                                                  // not already
                                                                  // added
    goToSpecificTab("Settings");
    verifyPageLoaded();
    arrowIconAppSpaceSettingsElement().click();
    plusButtonAppSpaceSettingsElement().click();
    waitForDrawerToOpen();
    addApplicationButton(applicationName).click();
    waitForDrawerToClose();
    refreshPage();
    waitForLoading();
  }

  public void goToSpecificTab(String tabName) {
    ElementFacade tabElement = searchSpaceTabElement(tabName);
    tabElement.assertVisible();
    if (!selectedTabElement(tabName).isCurrentlyVisible()) {
      tabElement.click();
      waitForLoading();
    }
    selectedTabElement(tabName).assertVisible();
  }

  public void goToUserProfileFromLikersDrawer(String userLastName) {
    getUserElementFromReactionsDrawer(userLastName).click();
  }

  public void hoverOnLikeIcon(String comment) {
    getLikeCommentIcon(comment).hover();
  }

  public void hoverOnLikeIconCommentsDrawer(String comment) {
    getCommentsDrawerLikeCommentIcon(comment).hover();
  }

  public void hoverOnMentionedUserInPost(String activity, String user) {
    getUserMentionedInPost(activity, user).hover();
  }

  public void insertNameContact(String contact) {
    filterTextBoxElement().setTextValue(contact);
    waitFor(500).milliseconds();
    waitForLoading();
  }

  public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
    getActivityNameUserSpace(activity, user, space).assertVisible();
  }

  public void isMentionedUserDisplayedInPost(String activity, String user) {
    getUserMentionedInPost(activity, user).assertVisible();
  }

  public void isUserPopoverDisplayed(String user) {
    getUserPopover(user).assertVisible();
  }

  public void kudosLabelIsBlack(String comment) {
    getBlackKudosCommentIcon(comment).assertVisible();
    getBlueKudosCommentIcon(comment).assertNotVisible();
  }

  public void kudosLabelIsBlue(String comment) {
    getBlackKudosCommentIcon(comment).assertNotVisible();
    getBlueKudosCommentIcon(comment).assertVisible();
  }

  public void likeActivity(String activity) {
    getActivityLikeButton(activity).click();
  }

  public void likeActivityComment(String activityComment) {
    getLikeCommentIcon(activityComment).click();
  }

  public void likeLabelInCommentsDrawerIsBlack(String comment) {
    getCommentsDrawerBlueLikeCommentIcon(comment).assertNotVisible();
  }

  public void likeLabelInCommentsDrawerIsBlue(String comment) {
    getCommentsDrawerBlueLikeCommentIcon(comment).assertVisible();
  }

  public void likeLabelIsBlack(String comment) {
    getBlueLikeCommentIcon(comment).assertNotVisible();
  }

  public void likeLabelIsBlue(String comment) {
    getBlueLikeCommentIcon(comment).assertVisible();
  }

  public void linkIsOpenedNewTab(String link) {
    Set<String> windowHandles = getDriver().getWindowHandles();
    try {
      boolean tabFound = windowHandles.size() > 1 && windowHandles.stream().anyMatch(windowId -> {
        getDriver().switchTo().window(windowId);
        String currentUrl = getDriver().getCurrentUrl();
        boolean found = currentUrl.contains(link);
        if (!currentUrl.contains("/portal")) {
          getDriver().close();
        }
        return found;
      });
      assertTrue(tabFound);
    } finally {
      getDriver().switchTo().window(windowHandles.iterator().next());
    }
  }

  public void noCommentDisplayedInDrawer() {
    findByXPathOrCSS("//*[@class='text-capitalize-first-letter' and contains(text(),'No comment yet')]").assertVisible();
  }

  public void openActivityReactionsDrawer(String activity) {
    getReactionActivityLink(activity).click();
    waitForDrawerToOpen();
  }

  public void openCommentsDrawer(String activity) {
    getActivityCommentButton(activity).click();
    waitForDrawerToLoad();
  }

  public void openDeleteActivityMenu(String activity) {
    getDropDownActivityMenu(activity).click();
    getDeleteActivityIcon(activity).click();
  }

  public void openDeleteCommentMenu(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).click();
    getDeleteCommentLabel(comment).click();
  }

  public void openEditActivityMenu(String activity) {
    openThreeDotsActivityMenu(activity);
    getEditActivityIcon(activity).click();
  }

  public void openLinkInNewTab(String link) {
    Actions newTab = new Actions(getDriver());
    newTab.keyDown(Keys.CONTROL).click(getCommentTitleActivityStream(link)).keyUp(Keys.CONTROL).build().perform();
  }

  public void openThreeDotsActivityMenu(String activity) {
    getDropDownActivityMenu(activity).click();
  }

  public void openThreeDotsCommentMenu(String comment) {
    getDropDownCommentMenu(comment).click();
  }

  public boolean isThreeDotsActivityMenuOpen(String activity) {
    return getDropDownActivityMenu(activity).isVisible();
  }

  public void openThreeDotsCommentMenu(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).click();
  }

  public boolean isThreeDotsCommentMenuOpen(String activity, String comment) {
    return getDropDownCommentMenu(activity, comment).isVisible();
  }

  public void pinActivityButtonIsDisplayed(String activity) {
    getPinActivityIcon(activity).assertVisible();
  }

  public void pinnedActivityDisappears(String activity) {
    getPinnedActivity(activity).assertNotVisible();
  }

  public void promoteSpaceMemberAsManager(String name) {
    searchMember(name);
    ElementFacade threeDots =
                            findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'peopleCardItem')]//*[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                                           name));
    threeDots.click();
    ElementFacade promoteAsAdminButton =
                                       findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'peopleCardItem')]//ancestor::*[contains(@class, 'v-list-item')]//*[contains(@class, 'uiIconMemberAdmin')]",
                                                                      name));
    promoteAsAdminButton.click();
  }

  public void publishActivity(boolean refreshStream) {
    publishActivityButtonElement().click();
    try {
      waitForDrawerToClose();
      if (refreshStream) {
        refreshStream();
      }
      waitForLoading();
    } catch (Exception e) {
      refreshPage();
    }
  }

  public void attachImagesToActivity() {
    waitCKEditorLoading(OPENED_ACTIVITY_COMPOSER_DRAWER_SELECTOR);
    ckEditorAttachImageButton().assertVisible();
    ElementFacade fileInput = ckEditorAttachImageInput();
    fileInput.assertEnabled();
    attachImageToFileInput(fileInput);
    waitForLoading();
    activityDrawerAttachedImagesCarousel().assertVisible();
    activityDrawerAttachedImagesCarouselPlusIcon().assertVisible();
  }

  public void clickPreviewAttachedImage(String activity) {
    getAttachedImagesActivity(activity).click();
  }
  
  public void clickClosePreviewAttachedImage() {
    previewAttachedImageCloseBtn().click();
  }

  public void checkPreviewAttachedImageIsClosed() {
    getPreviewAttachedImage().assertNotVisible();
  }

  public void previewAttachedImage() {
    getPreviewAttachedImage().assertVisible();
  }
  
  public void clickDeleteAttachment() {
    deleteAttachmentBtn().click();
  }
  
  public void checkActivityAttachImageDeleted() {
    getActivityAttachedImage().assertNotVisible();
  }
  
  public void publishActivityInArabicLanguage() {
    newActivityButtonInArabicLanguageElement().click();
  }

  public void publishComment() {
    saveCommentButtonInDrawerElement().click();
    closeDrawerIfDisplayed();
  }

  public void refreshStream() {
    ElementFacade newActivityButtonElement = newActivityButtonElement();
    if (newActivityButtonElement.isVisible()) {
      newActivityButtonElement.click();
    } else {
      refreshPage();
    }
  }

  public void removeMember(String name) {
    searchMember(name);
    ElementFacade threeDots =
                            findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'peopleCardItem')]//*[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                                           name));
    threeDots.click();
    ElementFacade removeMemberButton =
                                     findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'peopleCardItem')]//*[contains(@class, 'uiIconTrash')]//ancestor::*[contains(@class, 'v-list-item')]",
                                                                    name));
    removeMemberButton.click();
  }

  public void replyInDrawerIsNotDisplayed(String reply) {
    ElementFacade element = getDrawerReplyName(reply);
    element.assertNotVisible();
  }

  public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
    getReplyBox(comment, reply, true).assertVisible();
  }

  public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
    getReplyBox(comment, reply, true).assertNotVisible();
  }

  public void searchMember(String name) {
    spaceMembersFilterTextBoxElement().waitUntilVisible();
    spaceMembersFilterTextBoxElement().setTextValue(name);
    waitForProgressBar();
    waitFor(500).milliseconds(); // Wait until UI refreshes
  }

  public void selectActivityFilter(String filter) {
    ElementFacade ActivityFilterRadioButton = findByXPathOrCSS(String.format("//*[contains(@id,'filterStreamDrawer')]//*[contains(text(),'%s')]",filter));
    ActivityFilterRadioButton.click();
  }

  public void clickFilterIconFromComposer() {
    ElementFacade filterLink = findByXPathOrCSS(".activityComposer .v-btn--icon");
    filterLink.click();
    waitForDrawerToOpen();
  }

  public void filterIsSelected() {
    assertTrue(FilterIcon().getAttribute("class").contains("primary--text"));
  }

  public void filterIsntSelected() {
    assertFalse(FilterIcon().getAttribute("class").contains("primary--text"));
  }

  public void tooltipActivityStreamIsDisplayed(String comment) {
    assertTrue(getLikeCommentIcon(comment).getAttribute("aria-expanded").contains("true"));
  }

  public void tooltipCommentsDrawerIsDisplayed(String comment) {
    assertTrue(getCommentsDrawerLikeCommentIcon(comment).getAttribute("aria-expanded").contains("true"));
  }

  public void unPinActivityButtonIsDisplayed(String activity) {
    getUnpinActivityIcon(activity).assertVisible();
  }
  
  public void checkActivityAttachedImages(String activity) {
    getAttachedImagesActivity(activity).assertVisible();
  }
  
  public void checkActivityAttachedImagesIsNotDisplayed(String activity) {
    getAttachedImagesActivity(activity).assertNotVisible();
  }
  
  public void checkActivityDrawerAttachedImages(String activity) {
    getActivityAttachedImageWithDeleteIcon(activity).assertVisible();
  }


  public void updateActivityComment(String comment) {
    waitOnCommentRichText();
    ElementFacade ckEditorFrameCommentElement = ckEditorFrameCommentElement();
    ckEditorFrameCommentElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameCommentElement);
    try {
      TextBoxElementFacade commentFieldElement = commentFieldElement();
      commentFieldElement.waitUntilVisible();
      commentFieldElement.clear();
      commentFieldElement.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    updateButonElement().click();
    closeCommentsDrawerElement().click();
  }

  public void updateComment() {
    updateButtonInDrawerElement().click();
    closeDrawerIfDisplayed();
  }

  public void updateCommentText(String comment) {
    ElementFacade ckEditorFrameCommentElement = ckEditorFrameCommentElement();
    ckEditorFrameCommentElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameCommentElement);
    try {
      TextBoxElementFacade ckEditorBodyCommentElement = ckEditorBodyCommentElement();
      ckEditorBodyCommentElement.clear();
      ckEditorBodyCommentElement.sendKeys(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    Serenity.setSessionVariable("comment").to(comment);
  }

  public void userIsMentionedInCommentEntered(String user) {
    ElementFacade ckEditorFrameCommentElement = ckEditorFrameCommentElement();
    ckEditorFrameCommentElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameCommentElement);
    try {
      getMentionedUserInCommentEntered(user).assertVisible();
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void userIsNotMentionedInCommentEntered(String user) {
    ElementFacade ckEditorFrameCommentElement = ckEditorFrameCommentElement();
    ckEditorFrameCommentElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameCommentElement);
    try {
      getMentionedUserInCommentEntered(user).assertNotVisible();
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void viewAllRepliesInActivityStream(String comment) {
    getActivityStreamViewAllReplies(comment).click();
  }

  public void viewAllRepliesInCommentsDrawer(String comment) {
    getCommentsDrawerViewAllReplies(comment).click();
  }

  private ElementFacade searchSpaceTabElement(String tabName) {
    waitForLoading();
    selectedTabElement().waitUntilPresent();
    while (!tabElement(tabName).isCurrentlyVisible() && goToSpaceLeftTabsElement().isVisible()) {
      goToSpaceLeftTabsElement().click();
      waitFor(1000).milliseconds(); // Wait for animation end
    }
    while (!tabElement(tabName).isCurrentlyVisible() && goToSpaceRightTabsElement().isVisible()) {
      goToSpaceRightTabsElement().click();
      waitFor(1000).milliseconds(); // Wait for animation end
    }
    return tabElement(tabName);
  }

  private ElementFacade ckEditorAttachImageInput() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')]/parent::*//input[@type='file']");
  }

  private ElementFacade ckEditorAttachImageButton() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')]//a[contains(@class, 'cke_button__attachimage')]");
  }
  
  private ElementFacade activityDrawerAttachedImagesCarousel() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')]/parent::*//*[contains(@class, 'carousel-top-parent')]");
  }
  
  private ElementFacade activityDrawerAttachedImagesCarouselPlusIcon() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')]/parent::*//*[contains(@class, 'carousel-top-parent')]//*[contains(@class, 'fa-plus')]");
  }

  private ElementFacade installedApplicationCard(String applicationName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'SpaceApplicationCard')]//*[contains(text(), '%s')]",
                                          applicationName));
  }

  private ElementFacade addApplicationButton(String applicationName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'SpaceApplicationCard')]//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'SpaceApplicationCardBody')]/parent::*//button",
                                          applicationName));
  }

  private ElementFacade plusButtonAppSpaceSettingsElement() {
    return findByXPathOrCSS("//*[@class='v-icon notranslate mdi mdi-plus theme--light']");
  }

  private ElementFacade arrowIconAppSpaceSettingsElement() {
    return findByXPathOrCSS("//i[@class='v-icon notranslate text-sub-title fa fa-caret-right theme--light']");
  }

  private TextBoxElementFacade activityContentTextBoxElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade activityLinkPreviewElement() {
    return findByXPathOrCSS("[data-widget='embedSemantic']");
  }

  private ElementFacade activityTitleElement() {
    return findByXPathOrCSS("//div[contains(@class,'contentBox')]//*[contains(@class,'postContent ')]//div");
  }

  private void addReplyEditorContent(String reply) {
    ElementFacade ckEditorFrameCommentElement = ckEditorFrameReplyElement();
    getDriver().switchTo().frame(ckEditorFrameCommentElement);
    try {
      TextBoxElementFacade ckEditorBodyCommentElement = ckEditorBodyCommentElement();
      ckEditorBodyCommentElement.waitUntilVisible();
      ckEditorBodyCommentElement.setTextValue(reply);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    replyButtonInDrawerElement().click();
  }

  private ElementFacade applyDownloadButtonElement() {
    return findByXPathOrCSS("//div[contains(@class,'attachmentsFooter')]//a");
  }

  private ElementFacade buttonCreatePollElement() {
    return findByXPathOrCSS("//*[@id='createPollDrawer']//*[contains(@class, 'drawerFooter')]//button[contains(@class, 'primary')]");
  }

  private ElementFacade cancelBtnElement() {
    return findByXPathOrCSS("//button[@class='btn ms-2 v-btn v-btn--contained theme--light v-size--default']");
  }

  private ElementFacade cancelDeleteCommentBtnElement() {
    return findByXPathOrCSS("//*[@class='v-card__actions']//button[2]");
  }

  private TextBoxElementFacade choiceOnePollElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='createPollDrawer']//*[contains(@class, 'custom-poll-textarea')]//textarea)[2]");
  }

  private TextBoxElementFacade choiceThreePollElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='createPollDrawer']//*[contains(@class, 'custom-poll-textarea')]//textarea)[4]");
  }

  private TextBoxElementFacade choiceTwoPollElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='createPollDrawer']//*[contains(@class, 'custom-poll-textarea')]//textarea)[3]");
  }

  private TextBoxElementFacade ckEditorBodyCommentElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade ckEditorFrameCommentElement() {
    return findByXPathOrCSS(OPENED_ACTIVITY_COMMENTS_DRAWER_SELECTOR + "//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private ElementFacade ckEditorFrameReplyElement() {
    return findByXPathOrCSS(OPENED_ACTIVITY_REPLIES_DRAWER_SELECTOR + "//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private ElementFacade ckEditorFrameElement() {
    return findByXPathOrCSS(OPENED_ACTIVITY_COMPOSER_DRAWER_SELECTOR + "//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private void clickOnReplyToComment(String comment, String activity, boolean inDrawer) { // NOSONAR
    getCommentReply(comment, inDrawer).click();
    waitForDrawerToOpen();
  }

  private ElementFacade addCommentButtonInDrawerElement() {
    return findByXPathOrCSS("(" + OPENED_ACTIVITY_COMMENTS_DRAWER_SELECTOR + "//*[contains(@class,'drawerIcons')]//button)[1]");
  }

  private ElementFacade closeCommentsDrawerElement() {
    return findByXPathOrCSS(OPENED_ACTIVITY_COMMENTS_DRAWER_SELECTOR
        + "//button[contains(@class, 'close') or contains(@title, 'Close')]");
  }

  private ElementFacade saveCommentButtonInDrawerElement() {
    return findByXPathOrCSS(OPENED_ACTIVITY_COMMENTS_DRAWER_SELECTOR
        + "//*[contains(@class,'drawerContent')]//button//*[contains(text(),'Comment') or contains(text(),'Update')]");
  }

  private TextBoxElementFacade commentFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade commentsDrawerFirstPageBtnElement() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-pagination__item')])[1]");
  }

  private ElementFacade commentsDrawerSecondPageBtnElement() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-pagination__item')])[2]");
  }

  private ElementFacade commentTitleElement() {
    return findByXPathOrCSS("//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//p//div");
  }

  private ElementFacade createPollLinkElement() {
    return findByXPathOrCSS("//*[contains(@id,'activityComposerDrawer')]//*[contains(@id,'createPollComposerButton')]");
  }

  private ElementFacade sendKudosLinkElement() {
    return findByXPathOrCSS("//*[contains(@id,'activityComposerDrawer')]//*[contains(@id,'sendKudosComposerButton')]");
  }
  
  private ElementFacade dotsMenuElement() {
    return findByXPathOrCSS("//i[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light']");
  }

  private ElementFacade editButtonElement() {
    return findByXPathOrCSS("(//*[@class='v-list-item v-list-item--dense v-list-item--link theme--light']//*[@class='v-list-item__title pl-3'])[1]");
  }

  private ElementFacade eighthCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[8]");
  }

  private ElementFacade fifthCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[5]");
  }

  private ElementFacade filterByMyConnectionsElement() {
    return findByXPathOrCSS("//select[contains(@class,'selectPeopleFilter')]");
  }

  private TextBoxElementFacade filterTextBoxElement() {
    return findTextBoxByXPathOrCSS("//header[@id='peopleListToolbar']//input");
  }

  private ElementFacade firstASDisplayedCommentElement() {
    return findByXPathOrCSS("(//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//p//div)[1]");
  }

  private ElementFacade firstCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[1]");
  }

  private ElementFacade fourthCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[4]");
  }

  private ElementFacade getActivityCommentButton(String activity) {
    return getActivityFooterButton(activity, "CommentLink");
  }

  private ElementFacade getActivityFooterButton(String activity, String buttonIdPart) {
    return findByXPathOrCSS(String.format("//div[contains(text(),'%s')]//ancestor::*[contains(@class, 'activity-detail')]//*[contains(@class, 'activity-footer-actions')]//button[contains(@id,'%s')]",
                                          activity,
                                          buttonIdPart));
  }

  private ElementFacade getActivityLikeButton(String activity) {
    return getActivityFooterButton(activity, "LikeLink");
  }

  private ElementFacade getActivityNameUserSpace(String activity, String user, String space) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[contains(@class,'accountTitleLabel')][1]//*[contains(@id,'userAvatar') and contains(@href,'%s')]/following::*[contains(@id,'spaceAvatar') and contains(text(),'%s')][1]/following::*[contains(@class,'caption text-light-color text-truncate d-flex activity-head-time')][1]",
                                          activity,
                                          user,
                                          space));
  }

  private ElementFacade getActivityStreamViewAllReplies(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/following::span[contains(text(),'replies')][1]",
                                          comment));
  }

  private ElementFacade getActivityText(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'activity-detail')]//descendant::*[contains(text(),'%s')]",
                                          activity));
  }

  private ElementFacade getBlackKudosCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//*[contains(text(),'%s')]//ancestor::*[contains(@id, 'ActivityCommment')])[1]/*[1]//button[contains(@id,'KudosActivity') and not(contains(@class,'primary--text'))]",
                                          activityComment));
  }

  private ElementFacade getBlueKudosCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//*[contains(text(),'%s')]//ancestor::*[contains(@id, 'ActivityCommment')])[1]/*[1]//button[contains(@id,'KudosActivity') and contains(@class,'primary--text')]",
                                          activityComment));
  }

  private ElementFacade getBlueLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'activity-detail')]//div[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-list-item')]//button[contains(@id,'LikeLinkcomment') and contains(@class,'primary--text')]",
                                          activityComment));
  }

  private ElementFacade goToSpaceRightTabsElement() {
    return findByXPathOrCSS("//*[@id = 'SpaceMenu']//*[contains(@class,'chevron-right')]");
  }

  private ElementFacade goToSpaceLeftTabsElement() {
    return findByXPathOrCSS("//*[@id = 'SpaceMenu']//*[contains(@class,'chevron-left')]");
  }

  private ElementFacade getCommentDrawerButton(String comment, String buttonIdPart) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'v-list-item')]//*[contains(@id, 'Extactivity-comment-footer-action')]//button[contains(@id,'%s')]",
                                          comment,
                                          buttonIdPart));
  }

  private ElementFacade getCommentFooterButton(String comment, String buttonIdPart) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'v-list-item')]//*[contains(@id, 'Extactivity-comment-footer-action')]//button[contains(@id,'%s')]",
                                          comment,
                                          buttonIdPart));
  }

  private ElementFacade getCommentLikesNumber(String comment) {
    return findByXPathOrCSS(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikersListLinkcomment')])[1]//span",
                                          comment));
  }

  private ElementFacade getCommentLikesNumberCommentsDrawer(String comment) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikersListLinkcomment')])[1]//span",
                                          comment));
  }

  private ElementFacade getCommentReply(String comment, boolean drawer) {
    if (drawer) {
      return getCommentDrawerButton(comment, "CommentLink");
    } else {
      return getCommentFooterButton(comment, "CommentLink");
    }
  }

  private ElementFacade getCommentsDrawerBlueLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-list-item')]//button[contains(@id,'LikeLinkcomment') and contains(@class,'primary--text')]",
                                          activityComment));
  }

  private ElementFacade getCommentsDrawerDropDownMenu(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/preceding::i[contains(@class,'mdi mdi-dots-vertical')][1]/ancestor::button",
                                          comment));
  }

  private ElementFacade getCommentsDrawerLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment')])[1]",
                                          activityComment));
  }

  private ElementFacade getCommentsDrawerViewAllReplies(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/following::span[contains(text(),'View all')][1]",
                                          comment));
  }

  private ElementFacade getCommentElementInDrawer(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment')]",
                                          comment));
  }

  private ElementFacade getCommentTitleActivityStream(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//a[contains(text(),'%s')]",
                                          comment));
  }

  private ElementFacade getCommentElement(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment')]",
                                          comment));
  }

  private ElementFacade getConfirmButton(String buttonName) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s')]", buttonName));
  }

  private ElementFacade getCopyLinkActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Copy link')]",
                                          activity));
  }

  private ElementFacade getDeleteActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                          activity));
  }

  private ElementFacade getDeleteCommentLabel(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                          comment));
  }

  private ElementFacade getCommentMenuButton(String buttonName, String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment')]//*[@role='menuitem']//*[contains(text(), '%s')]",
                                          comment,
                                          buttonName));
  }

  private ElementFacade getDeleteReplyLabel(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                          comment));
  }

  private ElementFacade getDownloadActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Download')]",
                                          activity));
  }

  private ElementFacade getDrawerCommentName(String comment) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]/p/div[contains(text(),'%s')])[1]",
                                          comment));
  }

  private ElementFacade getDrawerCommentsNumberAndNames(String commentsNumber, String comment) {
    return findByXPathOrCSS(String.format("//*[@class='text-capitalize-first-letter' and contains(text(),'%s')]/following::*[contains(@class,'activity-comment-detail')]//*[contains(text(),'%s')]",
                                          commentsNumber,
                                          comment));
  }

  private ElementFacade getDrawerReplyName(String reply) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerHeader')]/following::*[contains(@class,'rich-editor-content')]//following::*[contains(text(),'%s')])[1]",
                                          reply));
  }

  private ElementFacade getDropDownActivityMenu(String activity) {
    return findByXPathOrCSS(String.format("(//*[contains(text(),'%s')]//ancestor::div[contains(@class,'contentBox')]//*[contains(@class, 'activity-head')]//*[contains(@class,'fa-ellipsis-v')])[1]",
                                          activity));
  }

  private ElementFacade getDropDownCommentMenu(String activity, String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'activity-detail')]//*[contains(@class, 'postContent')]//*[contains(text(),'%s')]//ancestor::*[contains(@class,'activity-detail')]//*[contains(@class,'activity-comment')]//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]//i[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                          activity,
                                          comment));
  }

  private ElementFacade getDropDownCommentMenu(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'activity-detail')]//*[contains(@class,'activity-comment')]//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]//i[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                          comment));
  }

  private ElementFacade getDropDownCommentMenuFromCommentsDrawer(String comment) {
    return findByXPathOrCSS(String.format("(//*[@id='activityCommentsDrawer']//*[contains(@class,'d-inline-flex flex-column activity-comment')][4]//*[contains(@class,'v-icon notranslate primary--text')])[1]", // NOSONAR
                                          comment));
  }

  private ElementFacade getDropDownReplyMenu(String activity, String comment, String reply) { // NOSONAR
    return findByXPathOrCSS(String.format("//*[contains(@class,'activity-detail')]//*[contains(@class, 'postContent')]//*[contains(text(),'%s')]//ancestor::*[contains(@class,'activity-detail')]//*[contains(@class,'activity-comment')]//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]//i[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                          activity,
                                          reply));
  }

  private ElementFacade getEditActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::div[contains(@class,'contentBox')]//*[contains(@class, 'activity-head')]//*[contains(@class, 'v-menu')]//*[contains(@class,'fa-edit')]",
                                          activity));
  }

  private ElementFacade getEditCommentLabel(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Edit')]",
                                          comment));
  }

  private ElementFacade getEditCommentLabelFromCommentsDrawer(String comment) {
    return findByXPathOrCSS(String.format("//*[@id='activityCommentsDrawer']//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]//i[contains(@class,'fa-edit')]/..",
                                          comment));
  }

  private ElementFacade getLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("//div[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-list-item')]//button[contains(@id,'LikeLinkcomment')]",
                                          activityComment));
  }

  private ElementFacade getMentionedUserInCommentEntered(String user) {
    return findByXPathOrCSS(String.format("//*[@class='atwho-inserted']//*[contains(text(),'%s')]", user));
  }

  private ElementFacade getPinActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[contains(@class,'mdi mdi-pin')]",
                                          activity));
  }

  private ElementFacade getPinnedActivity(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'pinnedActivity')]",
                                          activity));
  }
  

  private ElementFacade getAttachedImagesActivity(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'activityStream')]//*[contains(@class,'contentBox')][1]//*[contains(@class, 'attachments-image-item')][1]",
                                          activity));
  }
  
  private ElementFacade getPreviewAttachedImage() {
    return findByXPathOrCSS("//*[@id='previewCarousel-activity' and contains(@class, 'AttachmentCarouselPreview')]");
  }
  
  
  private ElementFacade previewAttachedImageCloseBtn() {
    return findByXPathOrCSS("//*[contains(@class,'preview-attachment-action')]//button[@id='preview-attachment-close']");
  }
  
  private ElementFacade deleteAttachmentBtn() {
    return findByXPathOrCSS(OPENED_ACTIVITY_COMPOSER_DRAWER_SELECTOR + "//*[contains(@class, 'activityRichEditor')]//*[contains(@class, 'carousel-top-parent')]//button[contains(@class, 'v-btn')][2]");
  }
  
  
  private ElementFacade getActivityAttachedImage() {
    return findByXPathOrCSS(OPENED_ACTIVITY_COMPOSER_DRAWER_SELECTOR + "//*[contains(@class, 'activityRichEditor')]//*[contains(@class, 'carousel-top-parent')]");
  }
  
  private ElementFacade getActivityAttachedImageWithDeleteIcon(String activity) {
    return findByXPathOrCSS(String.format(OPENED_ACTIVITY_COMPOSER_DRAWER_SELECTOR + "//*[contains(@class, 'activityRichEditor')]//*[contains(@class, 'carousel-top-parent')]//button[contains(@class, 'v-btn')]//*[contains(@class, 'fa-trash')]", activity));
  }

  private ElementFacade getReactionActivityLink(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'activity-detail')]//*[contains(@class,'likersNumber')]",
                                          activity));
  }

  private ElementFacade getReceivedKudosNumberInDrawer(String kudosNumber) {
    return findByXPathOrCSS(String.format("//div[@class='v-slide-group__wrapper']//a[@href='#kudos']//span[contains(.,'%s')]",
                                          kudosNumber));
  }

  private ElementFacade getReplyBox(String comment, String reply, boolean inDrawer) {
    String parentXPath = inDrawer ? "//*[@id='activityCommentsDrawer']" : "//*[contains(@class,'activity-detail')]";
    String replyXPath = parentXPath
        + String.format("//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]",
                        comment,
                        reply);
    return findByXPathOrCSS(replyXPath);
  }

  private ElementFacade getSharedVideoPreview(String link) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content-extensions')]//following::*[@src]//following::*[@href='%s']//*[contains(@class,'font-weight-bold')]",
                                          link));
  }

  private ElementFacade getUnpinActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[contains(@class,'mdi-pin-off')]",
                                          activity));
  }

  private ElementFacade getUserElementFromReactionsDrawer(String userLastName) {
    return findByXPathOrCSS(String.format("//*[@class='likers-list']//*[contains(text(),'%s')]", userLastName));
  }

  private ElementFacade getUserMentionedInPost(String activity, String user) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content')]//*[contains(text(),'%s')]//*[contains(text(),'%s')]",
                                          activity,
                                          user));
  }

  private ElementFacade getUserPopover(String user) {
    return findByXPathOrCSS(String.format("//*[@id='profileName']//*[contains(text(),'%s')]", user));
  }

  private ElementFacade getUserProfileButton(String fullName) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s')and contains(@class,'userFullname')]", fullName));
  }

  private ElementFacade kudosButtonFromCommentsDrawerToCommentActivityElement() {
    return findByXPathOrCSS("//*[@id='activityCommentsDrawer']//*[contains(@id,'KudosActivity') and not(@disabled='disabled')]");
  }

  private ElementFacade kudosButtonNumberFromCommentsDrawerToCommentActivityElement() {
    return findByXPathOrCSS("//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-footer-comment-action')]//div[@class='d-inline-flex']//button[contains(@class,'primary--text font-weight')][1]");
  }

  private ElementFacade kudosButtonNumberToCommentActivityElement() {
    return findByXPathOrCSS("(//button[contains(@id,'KudusCountLinkcomment') and @style=''])[1]");
  }

  private ElementFacade kudosButtonToCommentActivityElement() {
    return findByXPathOrCSS("//div[contains(@class,'white border-radius')][1]//div[contains(@class,'v-list flex')]//div[contains(@class,'d-inline-flex')][1]//div[@role='button']//span[@class='v-btn__content'][last()]");
  }

  private ElementFacade loadMoreActivitiesBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-btn--block v-btn--contained theme--light')]//span");
  }

  private ElementFacade menuBtnElement() {
    return findByXPathOrCSS("//a[@class='HamburgerNavigationMenuLink']");
  }

  private ElementFacade newActivityButtonElement() {
    return findByXPathOrCSS(".newActivitiesButton");
  }

  private ElementFacade newActivityButtonInArabicLanguageElement() {
    return findByXPathOrCSS("//button[contains(@class,'primary btn no-box-shadow ms-auto v-btn v-btn--contained')]");
  }

  private ElementFacade ninthCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[9]");
  }

  private ElementFacade peopleBtnElement() {
    return findByXPathOrCSS("//a[@class='v-list-item v-list-item--link theme--light UserPageLink']");
  }

  private ElementFacade publishActivityButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button#activityComposerPostButton");
  }

  private ElementFacade replyButtonInDrawerElement() {
    return findByXPathOrCSS(OPENED_ACTIVITY_REPLIES_DRAWER_SELECTOR + "//button//span[contains(text(),'Comment')]");
  }

  private ElementFacade secondASDisplayedCommentElement() {
    return findByXPathOrCSS("(//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//div)[2]");
  }

  private ElementFacade secondCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[2]");
  }

  private ElementFacade seventhCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[7]");
  }

  private ElementFacade sixthPositionInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[6]");
  }

  private TextBoxElementFacade spaceMembersFilterTextBoxElement() {
    return findTextBoxByXPathOrCSS("//header[@id='peopleListToolbar']//input");
  }

  private ElementFacade tabElement(String tabName) {
    return findByXPathOrCSS("//*[@id = 'SpaceMenu']//a[contains(text(),'" + tabName + "')]");
  }

  private ElementFacade selectedTabElement() {
    return findByXPathOrCSS("//*[@id = 'SpaceMenu']//a[contains(@class, 'SelectedTab')]");
  }

  private ElementFacade selectedTabElement(String tabName) {
    return findByXPathOrCSS("//*[@id = 'SpaceMenu']//a[contains(@class, 'SelectedTab') and contains(text(),'" + tabName + "')]");
  }

  private ElementFacade tenthCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[10]");
  }

  private ElementFacade thirdCommentInDrawerElement() {
    return findByXPathOrCSS("(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[3]");
  }

  private TextBoxElementFacade titlePollElement() {
    return findTextBoxByXPathOrCSS("(//*[@id='createPollDrawer']//*[contains(@class, 'custom-poll-textarea')]//textarea)[1]");
  }

  private ElementFacade updateActivityButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//button[@aria-label='Update']");
  }

  private ElementFacade updateButonElement() {
    return findByXPathOrCSS("//button[@class='btn btn-primary ms-10 v-btn v-btn--contained theme--light v-size--default primary']");
  }

  private ElementFacade updateButtonInDrawerElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'Update')]");
  }

  private ElementFacade viewallXcommentsElement() {
    return findByXPathOrCSS("//button[contains(@class,'primary--text font-weight-bold mb-1')]");
  }

  private void waitOnCommentRichText() {
    waitCKEditorLoading("//*[@id = 'activityCommentsDrawer' and contains(@class, 'v-navigation-drawer--open')]");
  }

  private void waitOnReplyRichText() {
    waitCKEditorLoading("//*[@id = 'activityCommentsDrawer' and contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'activity-comment')]");
  }

  private ElementFacade FilterIcon() {
    return findByXPathOrCSS(".activityComposer .v-btn--icon .fa-sliders-h");
  }

}
