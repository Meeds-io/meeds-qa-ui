package io.meeds.qa.ui.pages.page.factory.space;

import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static org.junit.Assert.assertTrue;

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
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SpaceHomePage extends GenericPage {
  private static final String  CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR = "//*[contains(text(),'Yes')]";

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade activityContentTextBox;

  @FindBy(css = "[data-widget='embedSemantic']")
  private ElementFacade    activityLinkPreview;

  @FindBy(xpath = "//div[@id='MiddleToolBar']//a[@tabindex='0'][1]")
  private ElementFacade    activityTab;

  @FindBy(xpath = "//div[contains(@class,'attachmentsFooter')]//a")
  private ElementFacade    applyDownloadButton;

  @FindBy(xpath = "//*[@id='createPollDrawer']//*[contains(@class, 'drawerFooter')]//button[contains(@class, 'primary')]")
  private ElementFacade    buttonCreatePoll;

  @FindBy(xpath = "//*[@class='v-card__actions']//button[2]")
  private ElementFacade    cancelDeleteCommentBtn;

  @FindBy(xpath = "(//*[@id='createPollDrawer']//*[contains(@class, 'custom-poll-textarea')]//textarea)[2]")
  private TextBoxElementFacade choiceOnePoll;

  @FindBy(xpath = "(//*[@id='createPollDrawer']//*[contains(@class, 'custom-poll-textarea')]//textarea)[4]")
  private TextBoxElementFacade choiceThreePoll;

  @FindBy(xpath = "(//*[@id='createPollDrawer']//*[contains(@class, 'custom-poll-textarea')]//textarea)[3]")
  private TextBoxElementFacade choiceTwoPoll;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade ckEditorBodyComment;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private ElementFacade    ckEditorFrame;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private ElementFacade    ckEditorFrameComment;

  @FindBy(xpath = "//*[contains(@class,'drawerContent')]//*[@class='v-btn__content' and contains(text(),'Comment')]")
  private ElementFacade    commentButtonInDrawer;

  @FindBy(xpath = "(//*[contains(@class, 'v-pagination__item')])[1]")
  private ElementFacade    commentsDrawerFirstPageBtn;

  @FindBy(xpath = "(//*[contains(@class, 'v-pagination__item')])[2]")
  private ElementFacade    commentsDrawerSecondPageBtn;

  @FindBy(xpath = "//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div")
  private ElementFacade    commentTitleInDrawer;

  @FindBy(xpath = "//*[contains(@class,'createPollComposerIcon')]//ancestor::*[contains(@class, 'actionItem')]")
  private ElementFacade    createPollLink;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[8]")
  private ElementFacade    eighthCommentInDrawer;

  @FindBy(xpath = "//div[contains(@class,'contentBox')]//*[contains(@class,'postContent ')]//div")
  private ElementFacade    activityTitle;

  @FindBy(xpath = "//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//p//div")
  private ElementFacade    commentTitle;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[5]")
  private ElementFacade    fifthCommentInDrawer;

  @FindBy(xpath = "(//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//p//div)[1]")
  private ElementFacade    firstASDisplayedComment;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[1]")
  private ElementFacade    firstCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[4]")
  private ElementFacade    fourthCommentInDrawer;

  @FindBy(xpath = "//i[contains(@class,'mdi-chevron-left')]")
  private ElementFacade    goToLeftTabs;

  @FindBy(xpath = "//i[contains(@class,'mdi-chevron-right')]")
  private ElementFacade    goToRightTabs;

  @FindBy(xpath = "//*[@id='activityCommentsDrawer']//*[contains(@id,'KudosActivity') and not(@disabled='disabled')]")
  private ElementFacade    kudosButtonFromCommentsDrawerToCommentActivity;

  @FindBy(xpath = "//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-footer-comment-action')]//div[@class='d-inline-flex']//button[contains(@class,'primary--text font-weight')][1]")
  private ElementFacade    kudosButtonNumberFromCommentsDrawerToCommentActivity;

  @FindBy(xpath = "(//button[contains(@id,'KudusCountLinkcomment') and @style=''])[1]")
  private ElementFacade    kudosButtonNumberToCommentActivity;

  @FindBy(xpath = "//div[contains(@class,'white border-radius')][1]//div[contains(@class,'v-list flex')]//div[contains(@class,'d-inline-flex')][1]//div[@role='button']//span[@class='v-btn__content'][last()]")
  private ElementFacade    kudosButtonToCommentActivity;

  @FindBy(xpath = "//*[contains(@class,'v-btn--block v-btn--contained theme--light')]//span")
  private ElementFacade    loadMoreActivitiesBtn;

  @FindBy(xpath = "//a[contains(@href,'members') and @tabindex='0']")
  private ElementFacade    membersTab;

  @FindBy(css = ".newActivitiesButton")
  private ElementFacade    newActivityButton;

  @FindBy(xpath = "//button[contains(@class,'primary btn no-box-shadow ms-auto v-btn v-btn--contained')]")
  private ElementFacade    newActivityButtonInArabicLanguage;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[9]")
  private ElementFacade    ninthCommentInDrawer;

  @FindBy(xpath = "//a[contains(@href,'/notes') and @tabindex='0']")
  private ElementFacade    notesTab;

  @FindBy(xpath = "//div[@class='progress']")
  private ElementFacade    progressDownloadBar;

  @FindBy(xpath = "//*[contains(@class,'uiIcon uiIconMemberAdmin')]")
  private ElementFacade    promoteAsManagerBtn;

  @FindBy(xpath = "//*[contains(@class,'v-navigation-drawer--open')]//button[@aria-label='Post']")
  private ElementFacade    publishActivityButton;

  @FindBy(xpath = "//*[contains(@class,'drawerContent ')]//button//span[contains(text(),'Comment')]")
  private ElementFacade    replyButtonInDrawer;

  @FindBy(xpath = "(//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//div)[2]")
  private ElementFacade    secondASDisplayedComment;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[2]")
  private ElementFacade    secondCommentInDrawer;

  @FindBy(xpath = "//i[contains(@class,'iconCloud')]")
  private ElementFacade    selectFromDocument;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[7]")
  private ElementFacade    seventhCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[6]")
  private ElementFacade    sixthPositionInDrawer;

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  public TextBoxElementFacade  spaceMembersFilterTextBox;

  @FindBy(xpath = "//a[contains(@href,'tasks') and @tabindex='0']")
  private ElementFacade    spaceTasksTab;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[10]")
  private ElementFacade    tenthCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[3]")
  private ElementFacade    thirdCommentInDrawer;

  @FindBy(xpath = "(//*[@id='createPollDrawer']//*[contains(@class, 'custom-poll-textarea')]//textarea)[1]")
  private TextBoxElementFacade titlePoll;

  @FindBy(xpath = "//*[contains(@class,'v-navigation-drawer--open')]//button[@aria-label='Update']")
  private ElementFacade    updateActivityButton;

  @FindBy(xpath = "//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'Update')]")
  private ElementFacade    updateButtonInDrawer;

  @FindBy(xpath = "//button[contains(@class,'primary--text font-weight-bold mb-1')]")
  private ElementFacade    viewallXcomments;

  @FindBy(xpath = "//a[contains(text(),'Yes')]")
  private ElementFacade    yesConfirmationButton;

  public SpaceHomePage(WebDriver driver) {
    super(driver);
  }

  public void addActivity(String activity) {
    waitCKEditorLoading();

    ckEditorFrame.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrame);

    try {
      if (activity.contains("https")) {
        // A workaround to the fact that the preview isn't triggered only by a
        // Paste Event
        activityContentTextBox.sendKeys(activity);
        activityContentTextBox.sendKeys(Keys.CONTROL + "a");
        activityContentTextBox.sendKeys(Keys.CONTROL + "x");
        getDriver().switchTo().defaultContent();
        closeDrawerIfDisplayed();
        clickPostIcon();
        waitForDrawerToOpen();
        ckEditorFrame.waitUntilVisible();
        getDriver().switchTo().frame(ckEditorFrame);
        activityContentTextBox.sendKeys(Keys.CONTROL + "v");
        activityLinkPreview.waitUntilVisible();
      } else if (activity.contains("lien")) {
        activityContentTextBox.clickOnElement();
        activityContentTextBox.sendKeys(Keys.PAGE_UP);
        activityContentTextBox.sendKeys(activity);
      } else {
        activityContentTextBox.setTextValue(activity);
        Serenity.setSessionVariable("activity").to(activity);
      }
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void addActivityComments(String activity, List<String> comments) {
    getActivityCommentButton(activity).clickOnElement();
    waitForDrawerToOpen();

    Iterator<String> commentsIterator = comments.iterator();
    while (commentsIterator.hasNext()) {
      String comment = commentsIterator.next();
      waitOnCommentRichText();
      addActivityCommentEditorContent(comment);
      if (commentsIterator.hasNext()) {
        waitFor(100).milliseconds(); // Wait for CKEditor to completely close
        ElementFacade addCommentInDrawerButton = findByXPathOrCSS(".v-navigation-drawer--open .drawerIcons > button:first-of-type");
        addCommentInDrawerButton.clickOnElement();
      }
    }
    closeDrawerIfDisplayed();
  }

  public void addActivityComment(String activity, String comment) {
    getActivityCommentButton(activity).clickOnElement();
    waitForDrawerToOpen();

    addActivityCommentEditorContent(comment);
    closeDrawerIfDisplayed();
  }

  public void addCommentReplies(List<String> replies, String comment, String activity) {
    clickOnReplyToComment(comment, activity, false);
    Iterator<String> repliesIterator = replies.iterator();
    while (repliesIterator.hasNext()) {
      String reply = repliesIterator.next();
      waitOnCommentRichText();
      addCommentReplyEditorContent(reply);
      waitForDrawerToLoad();
      if (repliesIterator.hasNext()) {
        waitFor(100).milliseconds(); // Wait for CKEditor to completely close
        clickOnReplyToComment(comment, activity, true);
      }
    }
    closeDrawerIfDisplayed();
  }

  public void addCommentReply(String reply, String comment, String activity) {
    clickOnReplyToComment(comment, activity, false);

    waitOnCommentRichText();
    addCommentReplyEditorContent(reply);
    closeDrawerIfDisplayed();
  }

  public void addDescriptionLess1000CharsInThePoll(String choiceThree) {
    choiceThreePoll.waitUntilVisible();
    choiceThreePoll.setTextValue(choiceThree);
  }

  public void addOptionThreeInThePoll(String choiceThree) {
    choiceThreePoll.clickOnElement();
    choiceThreePoll.setTextValue(choiceThree);
  }

  public void addOptionTwoInThePoll(String choiceTow) {
    choiceTwoPoll.clickOnElement();
    choiceTwoPoll.setTextValue(choiceTow);
  }

  public void cancelDeleteComment() {
    cancelDeleteCommentBtn.clickOnElement();
  }

  public void checkActivityComment(String comment) {
    Assert.assertEquals(commentTitle.getText(), comment);
  }

  public void checkActivityCommentInDrawer(String comment) {
    Assert.assertEquals(commentTitleInDrawer.getText(), comment);
    closeDrawerIfDisplayed();
  }

  public void checkActivityCommentNotDisplayed(String activity, String comment) {
    assertWebElementNotVisible(getDropDownCommentMenu(activity, comment));
  }

  public void checkActivityTitle(String activity) {
    Assert.assertEquals(activityTitle.getText(), activity);
  }

  public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
    assertWebElementVisible(getReplyBox(comment, reply, StringUtils.isBlank(activity)));
  }

  public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
    assertWebElementNotVisible(getReplyBox(comment, reply, StringUtils.isBlank(activity)));
  }

  public void checkFirstActivityComment(String comment) {
    Assert.assertEquals(firstASDisplayedComment.getText(), comment);
  }

  public void checkFirstCommentInDrawer(String comment) {
    Assert.assertEquals(firstCommentInDrawer.getText(), comment);
    closeDrawerIfDisplayed();
  }

  public void checkFourCommentIsDisplayedInDrawer() {
    assertWebElementVisible(firstCommentInDrawer);
    assertWebElementVisible(secondCommentInDrawer);
    assertWebElementVisible(thirdCommentInDrawer);
    assertWebElementVisible(fourthCommentInDrawer);
    closeDrawerIfDisplayed();
  }

  public void checkFourthCommentInDrawer(String comment) {
    assertWebElementVisible(fourthCommentInDrawer);
    closeDrawerIfDisplayed();
  }

  public void checkSecondActivityComment(String comment) {
    assertWebElementVisible(secondASDisplayedComment);
  }

  public void checkSecondCommentInDrawer(String comment) {
    assertWebElementVisible(secondCommentInDrawer);
    closeDrawerIfDisplayed();
  }

  public void checkSixthPositionInDrawer(String comment) {
    assertWebElementVisible(sixthPositionInDrawer);
    closeDrawerIfDisplayed();
  }

  public void checkTenCommentIsDisplayedInDrawer() {
    assertWebElementVisible(firstCommentInDrawer);
    assertWebElementVisible(secondCommentInDrawer);
    assertWebElementVisible(thirdCommentInDrawer);
    assertWebElementVisible(fourthCommentInDrawer);
    assertWebElementVisible(fifthCommentInDrawer);
    assertWebElementVisible(sixthPositionInDrawer);
    assertWebElementVisible(seventhCommentInDrawer);
    assertWebElementVisible(eighthCommentInDrawer);
    assertWebElementVisible(ninthCommentInDrawer);
    assertWebElementVisible(tenthCommentInDrawer);
    closeDrawerIfDisplayed();
  }

  public void checkThirdCommentInDrawer(String comment) {
    assertWebElementVisible(thirdCommentInDrawer);
    closeDrawerIfDisplayed();
  }

  public void clickApplyDownload() {
    applyDownloadButton.clickOnElement();
  }

  public void clickCreatePoll() {
    createPollLink.clickOnElement();
  }

  public void clickCreatePollButton() {
    buttonCreatePoll.clickOnElement();
  }

  public void clickDeleteActivityButton(String activity) {
    getDeleteActivityIcon(activity).clickOnElement();
  }

  public void clickPinActivityButton(String activity) {
    getPinActivityIcon(activity).clickOnElement();
  }

  public void clickUnpinActivityButton(String activity) {
    getUnpinActivityIcon(activity).clickOnElement();
  }

  public void clickOnActivityComment(String comment) {
    getCommentTitleActivityStream(comment).clickOnElement();
  }

  public void clickOnCommentActivityButton(String activity) {
    getActivityCommentButton(activity).clickOnElement();
  }

  private void waitOnCommentRichText() {
    waitCKEditorLoading();
    ckEditorFrameComment.waitUntilVisible();
  }

  public void clickOnCommentsDrawerFirstPage() {
    commentsDrawerFirstPageBtn.clickOnElement();
  }

  public void clickOnCommentsDrawerSecondPage() {
    commentsDrawerSecondPageBtn.clickOnElement();
  }

  public void clickOnCommentThreeDotsButton(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).clickOnElement();
  }

  public void clickOnCommentThreeDotsButtonFromCommentsDrawer(String comment) {
    getDropDownCommentMenuFromCommentsDrawer(comment).clickOnElement();
  }

  public void clickOnCommentThreeDotsInCommentsDrawer(String comment) {
    ElementFacade commentsDrawerDropDownMenu = getCommentsDrawerDropDownMenu(comment);
    clickOnElement(commentsDrawerDropDownMenu);
  }

  public void clickOnConfirmButton() {
    getConfirmButton("Confirm").clickOnElement();
  }

  public void clickOnDeleteReplyButton(String activity, String comment, String reply) {
    getDropDownReplyMenu(activity, comment, reply).clickOnElement();
  }

  public void clickOnkudosButtonFromCommentsDrawerToCommentActivity() {
    kudosButtonFromCommentsDrawerToCommentActivity.clickOnElement();
    waitForDrawerToOpen("#activityKudosDrawer", false);
  }

  public void clickOnKudosButtonNumberFromCommentsDrawerToCommentActivity() {
    assertWebElementVisible(kudosButtonNumberFromCommentsDrawerToCommentActivity);
    kudosButtonNumberFromCommentsDrawerToCommentActivity.clickOnElement();
    waitForDrawerToOpen(".v-navigation-drawer--open .kudos-list", false);
  }

  public void clickOnKudosButtonNumberToCommentActivity() {
    kudosButtonNumberToCommentActivity.clickOnElement();
  }

  public void clickOnkudosButtonToActivityStream() {
    ElementFacade firstActivityKudosButton =
                                               findByXPathOrCSS("(//*[contains(@class, 'activity-detail')])[1]//*[contains(@class, 'activity-footer-actions')]//*[contains(@id, 'KudosActivity')]");
    firstActivityKudosButton.clickOnElement();
  }

  public void clickOnkudosButtonToCommentActivity() {
    kudosButtonToCommentActivity.clickOnElement();
  }

  public void clickOnLoadMoreActivities() {
    loadMoreActivitiesBtn.clickOnElement();
  }

  public void clickOnNotesTab() {
    notesTab.clickOnElement();
  }

  public void clickOnReplyDropDownMenu(String activity, String comment, String reply) {
    ElementFacade threeDots = getDropDownReplyMenu(activity, comment, reply);
    threeDots.waitUntilVisible();
    threeDots.clickOnElement();
  }

  public void clickOnReplyKudos(String reply) {
    getBlackKudosCommentIcon(reply).clickOnElement();
  }

  public void clickOnTheUserPopover(String user) {
    getUserPopover(user).clickOnElement();
  }

  public void clickOnViewallXcomments() {
    viewallXcomments.clickOnElement();
  }

  public void clickPostIcon() {
    if (activityTab.getAttribute("aria-selected").equals("false")) {
      goToSpecificTab("Stream");
      waitFor(500).milliseconds();
    }
    verifyPageLoaded();
    ElementFacade activityPostLink = findByXPathOrCSS(".activityComposer .openLink");
    activityPostLink.clickOnElement();
  }

  public void clickYesbutton() {
    findByXPathOrCSS(CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR).clickOnElement();
  }

  public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
    assertTrue(String.format("Comment '%s' should be displayed in drawer with drawer title '%s'", comment, commentsNumber),
               getDrawerCommentsNumberAndNames(commentsNumber, comment).isDisplayed());
  }

  public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
    ElementFacade element = getDrawerCommentsNumberAndNames(commentsNumber, comment);
    Assert.assertFalse(String.format("Comment '%s' shouldn't be displayed in drawer with drawer title '%s'",
                                     comment,
                                     commentsNumber),
                       element.isDisplayed(SHORT_WAIT_DURATION_MILLIS));
  }

  public void commentNameIsNotDisplayedInDrawer(String comment) {
    assertWebElementNotVisible(getDrawerCommentName(comment));
  }

  public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
    assertTrue(getCommentLikesNumberCommentsDrawer(comment).getTextContent().contains(number));
  }

  public void commentsDrawerlikeActivityComment(String activityComment) {
    getCommentsDrawerLikeCommentIcon(activityComment).clickOnElement();
  }

  public void copyLinkActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(getCopyLinkActivityIcon(activity));
  }

  public void createPoll(String pollTitle, String choiceOne, String choiceTow) {
    waitForDrawerToOpen("#createPollDrawer", false);
    titlePoll.setTextValue(pollTitle);
    choiceOnePoll.setTextValue(choiceOne);
    choiceTwoPoll.setTextValue(choiceTow);
    buttonCreatePoll.clickOnElement();
    waitForDrawerToClose("#createPollDrawer", false);
  }

  public void createPollButton() {
    buttonCreatePoll.isDisabled();
  }

  public void createPollDrawerClosed() {
    assertWebElementNotVisible(titlePoll);
  }

  public void createPollWithOneChoice(String pollTitle, String choiceOne) {
    titlePoll.clickOnElement();
    titlePoll.setTextValue(pollTitle);
    choiceOnePoll.clickOnElement();
    choiceOnePoll.setTextValue(choiceOne);
  }

  public void deleteActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(getDeleteActivityIcon(activity));
  }

  public void pinActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(getPinActivityIcon(activity));
  }

  public void unPinActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(getUnpinActivityIcon(activity));
  }

  public void deleteComment(String comment) {
    getDeleteCommentLabel(comment).clickOnElement();
  }

  public void deleteReply(String reply) {
    getDeleteReplyLabel(reply).clickOnElement();
  }

  public void displayedLikesOnComment(String comment, String number) {
    assertTrue(getCommentLikesNumber(comment).getTextContent().contains(number));
  }

  public void downloadActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(getDownloadActivityIcon(activity));
  }

  public void editActivity() {
    updateActivityButton.clickOnElement();
    verifyPageLoaded();
    waitFor(200).milliseconds(); // Update doesn't trigger a loading effect, bad
                                 // UX
  }

  public void editActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(getEditActivityIcon(activity));
  }

  public void editComment(String comment) {
    getEditCommentLabel(comment).clickOnElement();
  }

  public void editCommentFromCommentsDrawer(String comment) {
    getEditCommentLabelFromCommentsDrawer(comment).clickOnElement();
  }

  public void editPoll(String pollTitle, String choiceOne, String choiceTow) {
    titlePoll.clickOnElement();
    titlePoll.setTextValue(pollTitle);
    choiceOnePoll.clickOnElement();
    choiceOnePoll.setTextValue(choiceOne);
    choiceTwoPoll.clickOnElement();
    choiceTwoPoll.setTextValue(choiceTow);
    buttonCreatePoll.clickOnElement();
  }

  public void enterActivityCommentWithUser(String comment, String user) {
    mentionUserInCKEditor(ckEditorFrameComment, ckEditorBodyComment, comment, user, true);
  }

  public void enterActivityCommentWithUserNoMention(String comment, String user) {
    mentionUserInCKEditor(ckEditorFrameComment, ckEditorBodyComment, comment, user, false);
  }

  public void enterActivityText(String activity) {
    ckEditorFrame.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrame);
    try {
      activityContentTextBox.waitUntilVisible();
      activityContentTextBox.sendKeys(activity);
      activityContentTextBox.sendKeys(Keys.SPACE);
      activityContentTextBox.sendKeys(Keys.BACK_SPACE);
      waitFor(100).milliseconds();
    } finally {
      getDriver().switchTo().defaultContent();
    }
    Serenity.setSessionVariable("activity").to(activity);
  }

  public void enterCommentLink(String activity, String comment) {

    getActivityCommentButton(activity).clickOnElement();

    waitOnCommentRichText();
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      if (comment.contains("https")) {
        ckEditorBodyComment.sendKeys(comment);
        ckEditorBodyComment.sendKeys(Keys.CONTROL + "a" + "x");
        getDriver().navigate().refresh();
        getActivityCommentButton(activity).clickOnElement();
        ckEditorFrameComment.waitUntilVisible();
        waitOnCommentRichText();
        getDriver().switchTo().frame(ckEditorFrameComment);

        ckEditorBodyComment.waitUntilVisible();
        ckEditorBodyComment.clickOnElement();
        ckEditorBodyComment.sendKeys(Keys.CONTROL + "v");
      } else if (comment.contains("lien")) {
        ckEditorBodyComment.clickOnElement();
        ckEditorBodyComment.sendKeys(Keys.PAGE_UP);
        ckEditorBodyComment.sendKeys(comment);
      } else {
        ckEditorBodyComment.setTextValue(comment);
        Serenity.setSessionVariable("comment").to(comment);
      }
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void enterCommentText(String comment) {
    ckEditorFrameComment.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      ckEditorBodyComment.waitUntilVisible();
      ckEditorBodyComment.sendKeys(comment);
      ckEditorBodyComment.sendKeys(Keys.SPACE);
      ckEditorBodyComment.sendKeys(Keys.BACK_SPACE);
      waitFor(100).milliseconds();
    } finally {
      getDriver().switchTo().defaultContent();
    }
    Serenity.setSessionVariable("comment").to(comment);
  }

  private ElementFacade getDeleteActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                          activity));
  }

  private ElementFacade getPinActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[contains(@class,'mdi mdi-pin')]" ,
            activity));
  }

  private ElementFacade getUnpinActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[contains(@class,'mdi-pin-off')]",
            activity));
  }

  private ElementFacade getEditActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::div[contains(@class,'contentBox')]//*[contains(@class, 'activity-head')]//*[contains(@class, 'v-menu')]//*[contains(@class,'fa-edit')]",
                                          activity));
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

  private ElementFacade getPinnedActivity(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'pinnedActivity')]",
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

  private ElementFacade getCommentLikesNumber(String comment) {
    return findByXPathOrCSS(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikersListLinkcomment')])[1]//span",
                                          comment));
  }

  private ElementFacade getCommentLikesNumberCommentsDrawer(String comment) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikersListLinkcomment')])[1]//span",
                                          comment));
  }

  private ElementFacade getCommentReply(String activity, String comment, boolean drawer) {
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

  private ElementFacade getCommentTitleActivityStream(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//a[contains(text(),'%s')]",
                                          comment));
  }

  private ElementFacade getConfirmButton(String buttonName) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s')]", buttonName));
  }

  private ElementFacade getCopyLinkActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Copy link')]",
                                          activity));
  }

  private ElementFacade getDeleteCommentLabel(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                          comment));
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
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::div[contains(@class,'contentBox')]//*[contains(@class, 'activity-head')]//*[contains(@class,'fa-ellipsis-v')]",
                                          activity));
  }

  private ElementFacade getDropDownCommentMenu(String activity, String comment) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//following::*[contains(@class,'activity-comment')]//*[contains(@class,'rich-editor-content')]//*[contains(text(),'%s')]/preceding::button[@class='v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--small'][1]",
                                          activity,
                                          comment));
  }

  private ElementFacade getDropDownCommentMenuFromCommentsDrawer(String comment) {
    return findByXPathOrCSS(String.format("(//*[@id='activityCommentsDrawer']//*[contains(@class,'d-inline-flex flex-column activity-comment')][4]//*[contains(@class,'v-icon notranslate primary--text')])[1]",
                                          comment));
  }

  private ElementFacade getDropDownReplyMenu(String activity, String comment, String reply) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'activity-detail')]//*[contains(@class, 'postContent')]//*[contains(text(),'%s')]//ancestor::*[contains(@class,'activity-detail')]//*[contains(@class,'activity-comment')]//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]//i[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                          activity,
                                          reply));
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

  private ElementFacade getActivityCommentButton(String activity) {
    return getActivityFooterButton(activity, "CommentLink");
  }

  private ElementFacade getActivityLikeButton(String activity) {
    return getActivityFooterButton(activity, "LikeLink");
  }

  private ElementFacade getActivityFooterButton(String activity, String buttonIdPart) {
    return findByXPathOrCSS(String.format("//div[contains(text(),'%s')]//ancestor::*[contains(@class, 'activity-detail')]//*[contains(@class, 'activity-footer-actions')]//button[contains(@id,'%s')]",
                                          activity,
                                          buttonIdPart));
  }

  private ElementFacade getCommentFooterButton(String comment, String buttonIdPart) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'v-list-item')]//*[contains(@id, 'Extactivity-comment-footer-action')]//button[contains(@id,'%s')]",
                                          comment,
                                          buttonIdPart));
  }

  private ElementFacade getCommentDrawerButton(String comment, String buttonIdPart) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'v-list-item')]//*[contains(@id, 'Extactivity-comment-footer-action')]//button[contains(@id,'%s')]",
                                          comment,
                                          buttonIdPart));
  }

  private ElementFacade getMentionedUserInCommentEntered(String user) {
    return findByXPathOrCSS(String.format("//*[@class='atwho-inserted']//*[contains(text(),'%s')]", user));
  }

  private ElementFacade getNormalLinkPreview(String link) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content-extensions')]//*[contains(@class,'activity-thumbnail-box') and @href='%s']",
                                          link));
  }

  private ElementFacade getReceivedKudosNumberInDrawer(String kudosNumber) {
    return findByXPathOrCSS(String.format("//div[@class='v-slide-group__wrapper']//a[@href='#kudos']//span[contains(.,'%s')]",
                                          kudosNumber));
  }

  public void getReceivedKudosSectionIsDisplayed(String kudosNumber) {
    assertWebElementVisible(getReceivedKudosNumberInDrawer(kudosNumber));
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

  private ElementFacade getUserMentionedInPost(String activity, String user) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content')]//*[contains(text(),'%s')]//*[contains(text(),'%s')]",
                                          activity,
                                          user));
  }

  private ElementFacade getUserPopover(String user) {
    return findByXPathOrCSS(String.format("//*[@id='profileName']//*[contains(text(),'%s')]", user));
  }

  public void goToSpaceMembersTab() {
    membersTab.clickOnElement();
  }

  public void goToSpaceTasksTab() {
    spaceTasksTab.clickOnElement();
  }

  public void goToSpecificTab(String tabName) {
    switch (tabName) {
    case "Members":
      if (!membersTab.isVisible())
        goToLeftTabs.waitUntilVisible();
      membersTab.sendKeys(Keys.ENTER);
      break;
    case "Activité":
    case "Stream":
      if (!activityTab.isVisible())
        goToLeftTabs.clickOnElement();
      activityTab.sendKeys(Keys.ENTER);
      break;
    }
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

  public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
    assertWebElementVisible(getActivityNameUserSpace(activity, user, space));
  }

  public void checkActivityVisible(String activity) {
    assertWebElementVisible(getActivityText(activity));
  }

  public void checkActivityPinned(String activity) {
    assertWebElementVisible(getPinnedActivity(activity));
  }

  public void pinnedActivityDisappears(String activity) {
    assertWebElementNotVisible(getPinnedActivity(activity));
  }

  public void checkActivityNotVisible(String activity) {
    assertWebElementNotVisible(getActivityText(activity));
  }

  public void checkConfirmationPopupVisible() {
    assertWebElementVisible(findByXPathOrCSS(CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR));
  }

  public void checkConfirmationPopupNotVisible() {
    assertWebElementNotVisible(findByXPathOrCSS(CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR));
  }

  public void checkLinkPreviewVisible() {
    assertWebElementVisible(findByXPathOrCSS("//*[contains(@id,'Extactivity-content-extensions')]//following::*[@src]//following::*[@class='my-4']//*[contains(@class,'font-weight-bold')]"));
  }

  public void isMentionedUserDisplayedInPost(String activity, String user) {
    assertWebElementVisible(getUserMentionedInPost(activity, user));
  }

  public void checkVideoActivityVisible(String videoLink) {
    assertWebElementVisible(getSharedVideoPreview(videoLink));
  }

  public void isUserPopoverDisplayed(String user) {
    assertWebElementVisible(getUserPopover(user));
  }

  public void kudosLabelIsBlack(String comment) {
    assertWebElementVisible(getBlackKudosCommentIcon(comment));
    assertWebElementNotVisible(getBlueKudosCommentIcon(comment));
  }

  public void kudosLabelIsBlue(String comment) {
    assertWebElementNotVisible(getBlackKudosCommentIcon(comment));
    assertWebElementVisible(getBlueKudosCommentIcon(comment));
  }

  public void likeActivity(String activity) {
    getActivityLikeButton(activity).clickOnElement();
  }

  public void likeActivityComment(String activityComment) {
    getLikeCommentIcon(activityComment).clickOnElement();
  }

  public void likeLabelInCommentsDrawerIsBlack(String comment) {
    assertWebElementNotVisible(getCommentsDrawerBlueLikeCommentIcon(comment));
  }

  public void likeLabelInCommentsDrawerIsBlue(String comment) {
    assertWebElementVisible(getCommentsDrawerBlueLikeCommentIcon(comment));
  }

  public void likeLabelIsBlack(String comment) {
    assertWebElementNotVisible(getBlueLikeCommentIcon(comment));
  }

  public void likeLabelIsBlue(String comment) {
    assertWebElementVisible(getBlueLikeCommentIcon(comment));
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
    assertWebElementVisible(findByXPathOrCSS("//*[@class='text-capitalize-first-letter' and contains(text(),'No comment yet')]"));
  }

  public void normalLinkPreviewIsVisible(String link) {
    assertWebElementVisible(getNormalLinkPreview(link));
  }

  public void openCommentsDrawer(String activity) {
    getActivityCommentButton(activity).clickOnElement();
    waitForDrawerToLoad();
  }

  public void openDeleteActivityMenu(String activity) {
    getDropDownActivityMenu(activity).clickOnElement();
    getDeleteActivityIcon(activity).clickOnElement();
  }

  public void openDeleteCommentMenu(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).clickOnElement();
    getDeleteCommentLabel(comment).clickOnElement();
  }

  public void openEditActivityMenu(String activity) {
    openThreeDotsActivityMenu(activity);
    getEditActivityIcon(activity).clickOnElement();
  }

  public void openLinkInNewTab(String link) {
    Actions newTab = new Actions(getDriver());
    newTab.keyDown(Keys.CONTROL).click(getCommentTitleActivityStream(link)).keyUp(Keys.CONTROL).build().perform();
  }

  public void openThreeDotsActivityMenu(String activity) {
    getDropDownActivityMenu(activity).clickOnElement();
  }

  public void pollButton() {
    buttonCreatePoll.isEnabled();
  }

  public void promoteSpaceMemberAsManager(String name) {
    searchMember(name);
    ElementFacade threeDots =
                                findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'peopleCardItem')]//*[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                                               name));
    threeDots.clickOnElement();
    ElementFacade promoteAsAdminButton =
                                           findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'peopleCardItem')]//ancestor::*[contains(@class, 'v-list-item')]//*[contains(@class, 'uiIconMemberAdmin')]",
                                                                          name));
    promoteAsAdminButton.clickOnElement();
  }

  public void publishActivity(boolean refreshStream) {
    publishActivityButton.clickOnElement();
    try {
      waitForDrawerToClose();
      if (refreshStream) {
        refreshStream();
      }
      verifyPageLoaded();
    } catch (Exception e) {
      refreshPage();
    }
  }

  public void refreshStream() {
    if (newActivityButton.isDisplayed(SHORT_WAIT_DURATION_MILLIS)) {
      newActivityButton.clickOnElement();
    } else {
      refreshPage();
    }
  }

  public void publishActivityInArabicLanguage() {
    newActivityButtonInArabicLanguage.clickOnElement();
  }

  public void publishComment() {
    commentButtonInDrawer.clickOnElement();
    closeDrawerIfDisplayed();
  }

  public void removeMember(String name) {
    searchMember(name);
    ElementFacade threeDots =
                                findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'peopleCardItem')]//*[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                                               name));
    threeDots.clickOnElement();
    ElementFacade removeMemberButton =
                                         findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'peopleCardItem')]//*[contains(@class, 'uiIconTrash')]//ancestor::*[contains(@class, 'v-list-item')]",
                                                                        name));
    removeMemberButton.clickOnElement();
  }

  public void replyInDrawerIsNotDisplayed(String reply) {
    ElementFacade element = getDrawerReplyName(reply);
    assertWebElementNotVisible(element);
  }

  public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
    assertWebElementVisible(getReplyBox(comment, reply, true));
  }

  public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
    assertWebElementNotVisible(getReplyBox(comment, reply, true));
  }

  public void searchMember(String name) {
    spaceMembersFilterTextBox.waitUntilVisible();
    spaceMembersFilterTextBox.setTextValue(name);
    waitForProgressBar();
    waitFor(500).milliseconds(); // Wait until UI refreshes
  }

  public void tooltipActivityStreamIsDisplayed(String comment) {
    assertTrue(getLikeCommentIcon(comment).getAttribute("aria-expanded").contains("true"));
  }

  public void tooltipCommentsDrawerIsDisplayed(String comment) {
    assertTrue(getCommentsDrawerLikeCommentIcon(comment).getAttribute("aria-expanded").contains("true"));
  }

  public void updateComment() {
    updateButtonInDrawer.clickOnElement();
    closeDrawerIfDisplayed();
  }

  public void updateCommentText(String comment) {
    ckEditorFrameComment.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      ckEditorBodyComment.clear();
      ckEditorBodyComment.sendKeys(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    Serenity.setSessionVariable("comment").to(comment);
  }

  public void userIsMentionedInCommentEntered(String user) {
    ckEditorFrameComment.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      assertWebElementVisible(getMentionedUserInCommentEntered(user));
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void userIsNotMentionedInCommentEntered(String user) {
    ckEditorFrameComment.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      assertWebElementNotVisible(getMentionedUserInCommentEntered(user), 2);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void viewAllRepliesInActivityStream(String comment) {
    getActivityStreamViewAllReplies(comment).clickOnElement();
  }

  public void viewAllRepliesInCommentsDrawer(String comment) {
    getCommentsDrawerViewAllReplies(comment).clickOnElement();
  }

  public void openActivityReactionsDrawer(String activity) {
    getReactionActivityLink(activity).clickOnElement();
    waitForDrawerToOpen();
  }

  public void checkUserDisplayedInReactionsDrawer(String userLastName) {
    assertWebElementVisible(getUserElementFromReactionsDrawer(userLastName));
  }

  public void goToUserProfileFromLikersDrawer(String userLastName) {
    getUserElementFromReactionsDrawer(userLastName).clickOnElement();
  }

  private ElementFacade getReactionActivityLink(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'activity-detail')]//*[contains(@class,'likersNumber')]",
                                          activity));
  }

  private ElementFacade getUserElementFromReactionsDrawer(String userLastName) {
    return findByXPathOrCSS(String.format("//*[@class='likers-list']//*[contains(text(),'%s')]", userLastName));
  }

  public void selectPinnedActivity(String filter) {
    WebElement staticDropdown= findByXPathOrCSS("//*[contains(@class,'ignore-vuetify-classes')]");
    Select dropdown = new Select(staticDropdown);
    dropdown.selectByVisibleText(filter);
  }

  private void addActivityCommentEditorContent(String comment) {
    waitOnCommentRichText();
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      ckEditorBodyComment.waitUntilVisible();
      ckEditorBodyComment.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    commentButtonInDrawer.clickOnElement();
  }

  private void addCommentReplyEditorContent(String reply) {
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      ckEditorBodyComment.waitUntilVisible();
      ckEditorBodyComment.setTextValue(reply);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    replyButtonInDrawer.clickOnElement();
  }

  private void clickOnReplyToComment(String comment, String activity, boolean inDrawer) {
    ElementFacade commentReplyButton = getCommentReply(activity, comment, inDrawer);
    clickOnElement(commentReplyButton);
    waitForDrawerToOpen();
  }

}
