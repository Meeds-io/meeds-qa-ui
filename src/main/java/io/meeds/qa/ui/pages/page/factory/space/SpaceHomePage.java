package io.meeds.qa.ui.pages.page.factory.space;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SpaceHomePage extends GenericPage {
  public SpaceHomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id='activityComposer']//i[@class='uiIconEdit']")
  private BaseElementFacade    postIcon;

  @FindBy(xpath = "//*[contains(@class,'drawerHeader')]//*[contains(@class,'mdi-close')]")
  private BaseElementFacade    closeActivityDrawerbutton;

  @FindBy(xpath = "//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div")
  private BaseElementFacade    commentTitleInDrawer;

  @FindBy(xpath = "//button[contains(@class,'primary--text font-weight-bold mb-1')]")
  private BaseElementFacade    viewallXcomments;

  @FindBy(xpath = "(//*[contains(@class,'composerActions')]//*[@class='actionItemIcon'])[1]")
  private BaseElementFacade    createPollLink;

  @FindBy(xpath = "(//div[@class='v-text-field__slot']//*[contains(@id,'input')])[1]")
  private TextBoxElementFacade titlePoll;

  @FindBy(xpath = "(//div[@class='v-text-field__slot']//*[contains(@id,'input')])[2]")
  private TextBoxElementFacade choiceOnePoll;

  @FindBy(xpath = "(//div[@class='v-text-field__slot']//*[contains(@id,'input')])[3]")
  private TextBoxElementFacade choiceTwoPoll;

  @FindBy(xpath = "(//div[@class='v-text-field__slot']//*[contains(@id,'input')])[4]")
  private TextBoxElementFacade choiceThreePoll;

  @FindBy(xpath = "//*[contains(@class,'no-box-shadow v-btn v-btn--contained')]")
  private BaseElementFacade    buttonCreatePoll;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade    ckEditorFrameComment;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade commentField;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade    ckEditorFrame;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade activityContentTextBox;

  @FindBy(xpath = "//*[contains(@class,'v-card__actions')]//button[@aria-label='Post']")
  private BaseElementFacade    publishActivityButton;

  @FindBy(xpath = "//button[contains(@class,'newActivitiesButton ')]")
  private BaseElementFacade    newActivityButton;

  @FindBy(xpath = "//*[contains(@class,'v-card__actions')]//button[@aria-label='Update']")
  private BaseElementFacade    updateActivityButton;

  @FindBy(xpath = "//*[contains(@class,'drawerTitle')]/following::*[contains(@class,'mdi-close')]")
  private BaseElementFacade    closeWriteMessageBtn;

  @FindBy(xpath = "//div[contains(@class,'attachmentsFooter')]//a")
  private BaseElementFacade    applyDownloadButton;

  @FindBy(xpath = "//div[@class='progress']")
  private BaseElementFacade    progressDownloadBar;

  @FindBy(xpath = "//*[contains(@id,'Extactivity-content-extensions')]//following::*[@src]//following::*[@class='my-4']//*[contains(@class,'font-weight-bold')]")
  private BaseElementFacade    linkPreview;

  @FindBy(xpath = "//*[@id='attachment']//*[contains(@class,'attachments-drawer')]//*[contains(@class,'mdi mdi-close')]")
  private BaseElementFacade    closeDocumentsDrawerBtn;

  @FindBy(xpath = "//i[contains(@class,'mdi-chevron-left')]")
  private BaseElementFacade    goToLeftTabs;

  @FindBy(xpath = "//a[contains(@href,'documents') and @tabindex='0']")
  private BaseElementFacade    documentTab;

  @FindBy(xpath = "//a[contains(@href,'members') and @tabindex='0']")
  private BaseElementFacade    membersTab;

  @FindBy(xpath = "//div[@id='MiddleToolBar']//a[@tabindex='0'][1]")
  private BaseElementFacade    activityTab;

  @FindBy(xpath = "//i[contains(@class,'iconCloud')]")
  private BaseElementFacade    selectFromDocument;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[1]")
  private BaseElementFacade    firstCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[2]")
  private BaseElementFacade    secondCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[3]")
  private BaseElementFacade    thirdCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[4]")
  private BaseElementFacade    fourthCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//div)[6]")
  private BaseElementFacade    sixthPositionInDrawer;

  private BaseElementFacade getConfirmButton(String buttonName) {
    return findByXpath(String.format("//a[contains(text(),'%s')]", buttonName));
  }

  private BaseElementFacade getNormalLinkPreview(String link) {
    return findByXpath(String.format("//*[contains(@id,'Extactivity-content-extensions')]//*[contains(@class,'activity-thumbnail-box') and @href='%s']//following::*[@class='v-image__image v-image__image--cover']/following::*[@class='my-4']",
                                     link));
  }

  @FindBy(xpath = "//*[contains(@class,'drawerContent')]//*[@class='v-btn__content' and contains(text(),'Comment')]")
  private BaseElementFacade          commentButtonInDrawer;

  @FindBy(xpath = "//*[contains(@class,'drawerContent')]//*[@class='v-btn__content' and contains(text(),'Update')]")
  private BaseElementFacade          updateButtonInDrawer;

  @FindBy(xpath = "//*[@class='v-card__actions']//button[2]")
  private BaseElementFacade          cancelDeleteCommentBtn;

  @FindBy(xpath = "//*[contains(@class,'drawerContent ')]//button//span[contains(text(),'Comment')]")
  private BaseElementFacade          replyButtonInDrawer;

  @FindBy(css = "#activityCommentsDrawer .drawerIcons button.mdi-close")
  private BaseElementFacade          closeCommentsDrawer;

  @FindBy(xpath = "//*[contains(@class,'v-btn--block v-btn--contained theme--light')]//span")
  private BaseElementFacade          loadMoreActivitiesBtn;

  @FindBy(xpath = "//button[contains(@class,'primary btn no-box-shadow ms-auto v-btn v-btn--contained')]")
  private BaseElementFacade          newActivityButtonInArabicLanguage;

  @FindBy(xpath = "//*[contains(@class,'peopleMenuIcon')]//*[contains(@class,'mdi-dots-vertical')]")
  private BaseElementFacade          spaceMemberCardThreeDotsBtn;

  @FindBy(xpath = "//*[contains(@class,'uiIcon uiIconMemberAdmin')]")
  private BaseElementFacade          promoteAsManagerBtn;

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  public static TextBoxElementFacade spaceMembersFilterTextBox;

  @FindBy(xpath = "//div[@id='UIActivitiesLoader']")
  private BaseElementFacade          activityBlock;

  @FindBy(xpath = "//a[contains(text(),'Yes')]")
  private BaseElementFacade          yesConfirmationButton;

  @FindBy(xpath = "//*[@class='text-capitalize-first-letter' and contains(text(),'No comment yet')]")
  private BaseElementFacade          noCommentYet;

  @FindBy(xpath = "//i[contains(@class,'mdi-chevron-right')]")
  private BaseElementFacade          goToRightTabs;

  @FindBy(xpath = "//*[contains(text(),'Yes')]")
  private BaseElementFacade          confirmationButtonToDeleteActivity;

  @FindBy(xpath = "//div[@class='authorCommentContainer clearfix']")
  private BaseElementFacade          commentBlock;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[5]")
  private BaseElementFacade          fifthCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[7]")
  private BaseElementFacade          seventhCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[8]")
  private BaseElementFacade          eighthCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[9]")
  private BaseElementFacade          ninthCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[10]")
  private BaseElementFacade          tenthCommentInDrawer;

  @FindBy(xpath = "(//*[contains(@class, 'v-pagination__item')])[1]")
  private BaseElementFacade          commentsDrawerFirstPageBtn;

  @FindBy(xpath = "(//*[contains(@class, 'v-pagination__item')])[2]")
  private BaseElementFacade          commentsDrawerSecondPageBtn;

  private BaseElementFacade getLikeIcon(String activity) {
    return findByXpath(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLink')])[1]", activity));
  }

  private BaseElementFacade getLikeCommentIcon(String activityComment) {
    return findByXpath(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment')])[1]",
                                     activityComment));
  }

  private BaseElementFacade getCommentLikesNumber(String comment) {
    return findByXpath(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikersListLinkcomment')])[1]//span",
                                     comment));
  }

  private BaseElementFacade getCommentsDrawerLikeCommentIcon(String activityComment) {
    return findByXpath(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment')])[1]",
                                     activityComment));
  }

  private BaseElementFacade getMentionedUserInCommentEntered(String user) {
    return findByXpath(String.format("//*[@class='atwho-inserted']//*[@class='exo-mention' and contains(text(),'%s')]", user));
  }

  private BaseElementFacade getBlueLikeCommentIcon(String activityComment) {
    return findByXpath(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment') and contains(@class,'v-size--x-small primary--text')])[1]",
                                     activityComment));
  }

  private BaseElementFacade getCommentLikesNumberCommentsDrawer(String comment) {
    return findByXpath(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikersListLinkcomment')])[1]//span",
                                     comment));
  }

  private BaseElementFacade getDrawerCommentsNumberAndNames(String commentsNumber, String comment) {
    return findByXpath(String.format("//*[@class='text-capitalize-first-letter' and contains(text(),'%s')]/following::*[contains(@id,'Extactivity-content-extensions')]/p/div[contains(text(),'%s')]",
                                     commentsNumber,
                                     comment));
  }

  private BaseElementFacade getCommentsDrawerBlueLikeCommentIcon(String activityComment) {
    return findByXpath(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment') and contains(@class,'v-size--x-small primary--text')])[1]",
                                     activityComment));
  }

  private BaseElementFacade getDrawerCommentName(String comment) {
    return findByXpath(String.format("(//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]/p/div[contains(text(),'%s')])[1]",
                                     comment));
  }

  private BaseElementFacade getDrawerReplyNameInComment(String comment, String reply) {
    return findByXpath(String.format("(//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]/p/div[contains(text(),'%s')]/following::*[contains(text(),'%s')])[1]",
                                     comment,
                                     reply));
  }

  private BaseElementFacade getActivityText(String activity) {
    return findByXpath(String.format("//div[contains(@class,'activity-detail')]//*[contains(@class,'postContent')]//*[contains(text(),'%s')]", activity));
  }

  private BaseElementFacade getActivityNameUserSpace(String activity, String user, String space) {
    return findByXpath(String.format("//*[contains(text(),'%s')]/preceding::*[contains(@class,'accountTitleLabel')][1]//*[contains(@id,'userAvatar') and contains(@href,'%s')]/following::*[contains(@id,'spaceAvatar') and contains(text(),'%s')][1]/following::*[contains(@class,'caption text-light-color text-truncate d-flex activity-head-time')][1]",
                                     activity,
                                     user,
                                     space));
  }

  private BaseElementFacade getDrawerReplyName(String reply) {
    return findByXpath(String.format("(//*[contains(@class,'drawerHeader')]/following::*[contains(@class,'rich-editor-content')]//following::*[contains(text(),'%s')])[1]",
                                     reply));
  }

  private BaseElementFacade getSharedVideoPreview(String link) {
    return findByXpath(String.format("//*[contains(@id,'Extactivity-content-extensions')]//following::*[@src]//following::*[@href='%s']//*[contains(@class,'font-weight-bold')]",
                                     link));
  }

  private BaseElementFacade getCommentTitleActivityStream(String comment) {
    return findByXpath(String.format("//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//a[contains(text(),'%s')]",
                                     comment));
  }

  @FindBy(xpath = "//a[contains(@href,'tasks') and @tabindex='0']")
  private BaseElementFacade spaceTasksTab;

  private BaseElementFacade getDropDownActivityMenu(String activity) {
    return findByXpath(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::i[contains(@class,'v-icon notranslate')][1]",
                                     activity));
  }

  private BaseElementFacade geEditActivityIcon(String activity) {
    return findByXpath(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Edit')][1]",
                                     activity));
  }

  private BaseElementFacade getDropDownCommentMenu(String activity, String comment) {
    return findByXpath(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//following::*[contains(@class,'activity-comment')]//*[contains(@class,'rich-editor-content')]//*[contains(text(),'%s')]/preceding::button[@class='v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--small'][1]",
                                     activity,
                                     comment));
  }

  private BaseElementFacade getCommentsDrawerDropDownMenu(String comment) {
    return findByXpath(String.format("//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/preceding::i[contains(@class,'mdi mdi-dots-vertical')][1]",
                                     comment));
  }

  private BaseElementFacade getCommentsDrawerViewAllReplies(String comment) {
    return findByXpath(String.format("//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/following::span[contains(text(),'View all')][1]",
                                     comment));
  }

  private BaseElementFacade getDropDownReplyMenu(String activity, String comment, String reply) {
    return findByXpath(String.format("(//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//following::*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]/following::*[contains(text(),'%s')]/preceding::button[@class='v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--small']//i)[last()]",
                                     activity,
                                     comment,
                                     reply));
  }

  private BaseElementFacade getDeleteCommentLabel(String comment) {
    return findByXpath(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                     comment));
  }

  private BaseElementFacade getEditCommentLabel(String comment) {
    return findByXpath(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Edit')]",
                                     comment));
  }

  private BaseElementFacade getEditCommentLabelFromCommentsDrawer(String comment) {
    return findByXpath(String.format("(//*[@id='activityCommentsDrawer']//*[contains(@class,'d-inline-flex flex-column activity-comment')][4]//*[contains(@class,'v-list-item v-list-item')])[1]",
                                     comment));
  }

  private BaseElementFacade getActivityStreamViewAllReplies(String comment) {
    return findByXpath(String.format("//*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/following::span[contains(text(),'replies')][1]",
                                     comment));
  }

  private BaseElementFacade geDeleteActivityIcon(String activity) {
    return findByXpath(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                     activity));
  }

  private BaseElementFacade getDeleteReplyLabel(String comment) {
    return findByXpath(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                     comment));
  }

  private BaseElementFacade getCopyLinkActivityIcon(String activity) {
    return findByXpath(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Copy link')]",
                                     activity));
  }

  private BaseElementFacade getDownloadActivityIcon(String activity) {
    return findByXpath(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Download')]",
                                     activity));
  }

  public void tooltipActivityStreamIsDisplayed(String comment) {
    Assert.assertTrue(getLikeCommentIcon(comment).getAttribute("aria-expanded").contains("true"));
  }

  public void tooltipCommentsDrawerIsDisplayed(String comment) {
    Assert.assertTrue(getCommentsDrawerLikeCommentIcon(comment).getAttribute("aria-expanded").contains("true"));
  }

  public void commentNameIsNotDisplayedInDrawer(String comment) {
    getDrawerCommentName(comment).isNotVisibleAfterWaiting();
  }

  public void noCommentDisplayedInDrawer() {
    noCommentYet.isVisibleAfterWaiting();
  }

  public void displayedLikesOnComment(String comment, String number) {
    Assert.assertTrue(getCommentLikesNumber(comment).getTextContent().contains(number));
  }

  public void likeLabelIsBlue(String comment) {
    getBlueLikeCommentIcon(comment).isVisibleAfterWaiting();
  }

  public void likeLabelIsBlack(String comment) {
    getBlueLikeCommentIcon(comment).isNotVisibleAfterWaiting();
  }

  public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
    Assert.assertTrue(getCommentLikesNumberCommentsDrawer(comment).getTextContent().contains(number));
  }

  public void likeLabelInCommentsDrawerIsBlack(String comment) {
    getCommentsDrawerBlueLikeCommentIcon(comment).isNotVisibleAfterWaiting();
  }

  public void userIsMentionedInCommentEntered(String user) {
    getMentionedUserInCommentEntered(user).isVisibleAfterWaiting();
  }

  public void userIsNotMentionedInCommentEntered(String user) {
    getMentionedUserInCommentEntered(user).isNotVisibleAfterWaiting();
  }

  public void likeLabelInCommentsDrawerIsBlue(String comment) {
    getCommentsDrawerBlueLikeCommentIcon(comment).isVisibleAfterWaiting();
  }

  public void clickCloseActivityDrawerbutton() {
    closeActivityDrawerbutton.clickOnElement();
  }

  public void replyInDrawerIsNotDisplayed(String reply) {
    getDrawerReplyName(reply).isNotVisibleAfterWaiting();
  }

  public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
    getDrawerReplyNameInComment(comment, reply).isNotVisibleAfterWaiting();
  }

  public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
    getDrawerReplyNameInComment(comment, reply).isVisibleAfterWaiting();
  }

  public void normalLinkPreviewIsVisible(String link) {
    getNormalLinkPreview(link).isVisibleAfterWaiting();
  }

  public void enterActivityText(String activity) {
    driver.switchTo().frame(ckEditorFrame);
    activityContentTextBox.sendKeys(activity);
    driver.switchTo().defaultContent();
    Serenity.setSessionVariable("activity").to(activity);
  }

  public void closeWriteMessageDrawer() {
    closeWriteMessageBtn.waitUntilVisible();
    closeWriteMessageBtn.clickOnElement();
  }

  public void promoteSpaceMemberAsManager(String name) {
    spaceMembersFilterTextBox.waitUntilVisible();
    spaceMembersFilterTextBox.setTextValue(name);
    spaceMemberCardThreeDotsBtn.clickOnElement();
    promoteAsManagerBtn.clickOnElement();
  }

  public void viewAllRepliesInCommentsDrawer(String comment) {
    getCommentsDrawerViewAllReplies(comment).clickOnElement();
  }

  public void clickPostIcon() {
    postIcon.waitUntilVisible();
    postIcon.clickOnElement();
  }

  public void viewAllRepliesInActivityStream(String comment) {
    getActivityStreamViewAllReplies(comment).clickOnElement();
  }

  public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
    getDrawerCommentsNumberAndNames(commentsNumber, comment).isVisibleAfterWaiting();
  }

  public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
    getDrawerCommentsNumberAndNames(commentsNumber, comment).isNotVisibleAfterWaiting();
  }

  public void clickOnLoadMoreActivities() {
    loadMoreActivitiesBtn.clickOnElement();
  }

  public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
    getActivityNameUserSpace(activity, user, space).isVisibleAfterWaiting();
  }

  public void addActivity(String activity) {
    ckEditorFrame.waitUntilVisible();
    ckEditorFrame.clickOnElement();
    driver.switchTo().frame(ckEditorFrame);
    if (activity.contains("https")) {
      activityContentTextBox.sendKeys(activity);
      activityContentTextBox.sendKeys(Keys.CONTROL + "a" + "x");
      driver.navigate().refresh();
      clickPostIcon();
      ckEditorFrame.waitUntilVisible();
      ckEditorFrame.clickOnElement();
      driver.switchTo().frame(ckEditorFrame);
      activityContentTextBox.sendKeys(Keys.CONTROL + "v");
    } else if (activity.contains("lien")) {
      activityContentTextBox.clickOnElement();
      activityContentTextBox.sendKeys(Keys.PAGE_UP);
      activityContentTextBox.sendKeys(activity);
    } else {
      activityContentTextBox.setTextValue(activity);
      Serenity.setSessionVariable("activity").to(activity);
    }

    driver.switchTo().defaultContent();
  }

  public void publishActivity() {
    publishActivityButton.clickOnElement();
    newActivityButton.clickOnElement();
  }

  public void editActivity() {
    updateActivityButton.clickOnElement();
  }

  public void clickApplyDownload() {
    applyDownloadButton.clickOnElement();
  }

  public boolean isLinkPreviewVisible() {
    return linkPreview.isVisibleAfterWaiting();
  }

  public void closeDocumentsDrawer() {
    closeDocumentsDrawerBtn.clickOnElement();
  }

  public void goToSpecificTab(String tabName) {
    switch (tabName) {
    case "Members":
      if (!membersTab.isVisible())
        goToLeftTabs.waitUntilVisible();
      membersTab.sendKeys(Keys.ENTER);
      break;
    case "Activité":
      if (!activityTab.isVisible())
        goToLeftTabs.clickOnElement();
      activityTab.sendKeys(Keys.ENTER);
      break;
    }
  }

  @FindBy(xpath = "//div[contains(@class,'contentBox')]//*[contains(@class,'postContent ')]//div")
  private BaseElementFacade ELEMENT_ACTIVITY_TITLE;

  @FindBy(xpath = "//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//p//div")
  private BaseElementFacade ELEMENT_COMMENT_TITLE;

  private BaseElementFacade ELEMENT_COMMENT_LINK(String id) {
    return findByXpath(String.format("(//*[@id='CommentLink%s'])[1]", id));
  }

  private BaseElementFacade getCommentReply(String comment, String id) {
    return findByXpath(String.format("(//*[contains(text(),'%s')]/following::*[@id='CommentLink%s']//span[contains(text(),'Reply')])[1]",
                                     comment,
                                     id));
  }

  @FindBy(xpath = "(//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//p//div)[1]")
  private BaseElementFacade firstASDisplayedComment;

  @FindBy(xpath = "(//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//div)[2]")
  private BaseElementFacade secondASDisplayedComment;

  private BaseElementFacade ELEMENT_COMMENT_INPUT(String id) {
    return findByXpath(String.format("//*[@id='cke_CommentTextarea%s']", id));
  }

  private BaseElementFacade ELEMENT_COMMENT_BUTTON(String id) {
    return findByXpath(String.format("//*[@id='CommentButton%s']", id));
  }

  public void addActivityComment(String activityId, String comment) {

    ELEMENT_COMMENT_LINK(activityId).clickOnElement();

    ckEditorFrameComment.clickOnElement();
    driver.switchTo().frame(ckEditorFrameComment);
    commentField.waitUntilVisible();
    commentField.setTextValue(comment);
    driver.switchTo().defaultContent();

    commentButtonInDrawer.clickOnElement();
    closeCommentsDrawer.clickOnElement();
    commentButtonInDrawer.isNotVisibleAfterWaiting();
  }

  public void clickOnCommentsDrawerSecondPage() {
    commentsDrawerSecondPageBtn.clickOnElement();
  }

  public void clickOnCommentsDrawerFirstPage() {
    commentsDrawerFirstPageBtn.clickOnElement();
  }

  public void checkFourCommentIsDisplayedInDrawer() {
    firstCommentInDrawer.isDisplayed();
    secondCommentInDrawer.isDisplayed();
    thirdCommentInDrawer.isDisplayed();
    fourthCommentInDrawer.isDisplayed();
    closeCommentsDrawer.clickOnElement();
  }

  public void checkTenCommentIsDisplayedInDrawer() {
    firstCommentInDrawer.isDisplayed();
    secondCommentInDrawer.isDisplayed();
    thirdCommentInDrawer.isDisplayed();
    fourthCommentInDrawer.isDisplayed();
    fifthCommentInDrawer.isDisplayed();
    sixthPositionInDrawer.isDisplayed();
    seventhCommentInDrawer.isDisplayed();
    eighthCommentInDrawer.isDisplayed();
    ninthCommentInDrawer.isDisplayed();
    tenthCommentInDrawer.isDisplayed();
    closeCommentsDrawer.clickOnElement();

  }

  public void publishComment() {
    commentButtonInDrawer.clickOnElement();
    closeCommentsDrawer.clickOnElement();
    commentButtonInDrawer.isNotVisibleAfterWaiting();
  }

  public void updateComment() {
    updateButtonInDrawer.clickOnElement();
    closeCommentsDrawer.clickOnElement();
    commentButtonInDrawer.isNotVisibleAfterWaiting();
  }

  public void enterCommentText(String comment) {
    driver.switchTo().frame(ckEditorFrameComment);
    commentField.sendKeys(comment);
    driver.switchTo().defaultContent();
    Serenity.setSessionVariable("comment").to(comment);
  }

  public void updateCommentText(String comment) {
    driver.switchTo().frame(ckEditorFrameComment);
    commentField.clear();
    commentField.sendKeys(comment);
    driver.switchTo().defaultContent();
    Serenity.setSessionVariable("comment").to(comment);
  }

  public void enterCommentLink(String activityId, String comment) {

    ELEMENT_COMMENT_LINK(activityId).clickOnElement();

    ckEditorFrameComment.clickOnElement();
    driver.switchTo().frame(ckEditorFrameComment);
    if (comment.contains("https")) {
      commentField.sendKeys(comment);
      commentField.sendKeys(Keys.CONTROL + "a" + "x");
      driver.navigate().refresh();
      ELEMENT_COMMENT_LINK(activityId).clickOnElement();
      ckEditorFrameComment.waitUntilVisible();
      ckEditorFrameComment.clickOnElement();
      driver.switchTo().frame(ckEditorFrameComment);
      commentField.waitUntilVisible();
      commentField.clickOnElement();
      commentField.sendKeys(Keys.CONTROL + "v");
    } else if (comment.contains("lien")) {
      commentField.clickOnElement();
      commentField.sendKeys(Keys.PAGE_UP);
      commentField.sendKeys(comment);
    } else {
      commentField.setTextValue(comment);
      Serenity.setSessionVariable("comment").to(comment);
    }

    driver.switchTo().defaultContent();
  }

  public void goToSpaceMembersTab() {
    membersTab.clickOnElement();
  }

  public void clickCreatePoll() {
    createPollLink.clickOnElement();
  }

  public void createPoll(String pollTitle, String choiceOne, String choiceTow) {
    titlePoll.clickOnElement();
    titlePoll.setTextValue(pollTitle);
    choiceOnePoll.clickOnElement();
    choiceOnePoll.setTextValue(choiceOne);
    choiceTwoPoll.clickOnElement();
    choiceTwoPoll.setTextValue(choiceTow);
    buttonCreatePoll.clickOnElement();
  }

  public void createPollWithOneChoice(String pollTitle, String choiceOne) {
    titlePoll.clickOnElement();
    titlePoll.setTextValue(pollTitle);
    choiceOnePoll.clickOnElement();
    choiceOnePoll.setTextValue(choiceOne);
  }

  public void createPollButton() {
    buttonCreatePoll.isDisabled();
  }

  public void addOptionTwoInThePoll(String choiceTow) {
    choiceTwoPoll.clickOnElement();
    choiceTwoPoll.setTextValue(choiceTow);
  }

  public void pollButton() {
    buttonCreatePoll.isEnabled();
  }

  public void addOptionThreeInThePoll(String choiceThree) {
    choiceThreePoll.clickOnElement();
    choiceThreePoll.sendKeys(choiceThree);
  }

  public void addDescriptionLess1000CharsInThePoll(String choiceThree) {
    choiceThreePoll.waitUntilVisible();
    Actions action = new Actions(driver);
    action.keyDown(choiceThreePoll, Keys.CONTROL).sendKeys("a").build().perform();
    choiceThreePoll.sendKeys(Keys.DELETE);
    choiceThreePoll.clickOnElement();
    choiceThreePoll.sendKeys(choiceThree);
  }

  public void createPollDrawerClosed() {
    titlePoll.isNotVisibleAfterWaiting();
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

  public void clickCreatePollButton() {
    buttonCreatePoll.clickOnElement();
  }

  public void addCommentReply(String reply, String comment, String activity) {
    String activityId = getActivityId(activity);
    getCommentReply(comment, activityId).clickOnElement();

    ckEditorFrameComment.clickOnElement();
    driver.switchTo().frame(ckEditorFrameComment);
    commentField.waitUntilVisible();
    commentField.setTextValue(reply);
    driver.switchTo().defaultContent();

    replyButtonInDrawer.clickOnElement();
    closeCommentsDrawer.clickOnElement();
    commentButtonInDrawer.isNotVisibleAfterWaiting();

  }

  public void clickOnConfirmButton() {
    getConfirmButton("Confirm").clickOnElement();
  }

  private BaseElementFacade getActivityElement(String activity) {
    return findByXpath(String.format("//*[contains(@class,'activity-detail')]//*[contains(text(),'%s')]/ancestor::*[contains(@class,'activity-detail')]",
                                     activity));
  }

  private BaseElementFacade getUserMentionedInPost(String activity, String user) {
    return findByXpath(String.format("//*[contains(@id,'Extactivity-content')]//*[contains(text(),'%s')]//*[contains(text(),'%s')]",
                                     activity,
                                     user));
  }

  private BaseElementFacade getUserPopover(String user) {
    return findByXpath(String.format("//*[@id='profileName']//*[contains(text(),'%s')]", user));
  }

  public void hoverOnLikeIcon(String comment) {
    Actions oAction = new Actions(driver);
    oAction.contextClick(getLikeCommentIcon(comment)).build().perform();
  }

  public String getActivityId(String activity) {
    BaseElementFacade activityElement = getActivityElement(activity);
    activityElement.waitUntilVisible();
    return activityElement.getAttribute("id").replace("activity-detail-", "");
  }

  public void checkActivityTitle(String activity) {
    Assert.assertEquals(ELEMENT_ACTIVITY_TITLE.getText(), activity);
  }

  public void checkActivityComment(String comment) {
    Assert.assertEquals(ELEMENT_COMMENT_TITLE.getText(), comment);
  }

  public void isUserPopoverDisplayed(String user) {
    getUserPopover(user).isVisibleAfterWaiting();
  }

  public void clickOnTheUserPopover(String user) {
    getUserPopover(user).clickOnElement();
  }

  public void checkFirstActivityComment(String comment) {
    Assert.assertEquals(firstASDisplayedComment.getText(), comment);
  }

  public void checkSecondActivityComment(String comment) {
    secondASDisplayedComment.isDisplayed();
  }

  public void checkActivityCommentInDrawer(String comment) {
    Assert.assertEquals(commentTitleInDrawer.getText(), comment);
    closeCommentsDrawer.clickOnElement();
  }

  public void hoverOnLikeIconCommentsDrawer(String comment) {
    Actions oAction = new Actions(driver);
    oAction.contextClick(getCommentsDrawerLikeCommentIcon(comment)).build().perform();
  }

  public void openCommentsDrawer(String activityId) {
    ELEMENT_COMMENT_LINK(activityId).clickOnElement();
  }

  public void closeCommentsDrawer() {
    closeCommentsDrawer.clickOnElement();
  }

  public boolean isActivityVisible(String activity) {
    return getActivityText(activity).isVisibleAfterWaiting();
  }

  public void clickOnCommentActivityButton(String activityId) {
    ELEMENT_COMMENT_LINK(activityId).clickOnElement();
  }

  public void enterActivityCommentWithUser(String comment, String user) {
    ckEditorFrameComment.clickOnElement();
    driver.switchTo().frame(ckEditorFrameComment);
    commentField.waitUntilVisible();
    commentField.clear();
    commentField.setTextValue(comment + ' ' + '@' + user);
    commentField.sendKeys(Keys.ENTER);
    driver.switchTo().defaultContent();
  }

  public void publishActivityInArabicLanguage() {
    newActivityButtonInArabicLanguage.clickOnElement();
  }

  public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
    getDropDownReplyMenu(activity, comment, reply).isNotVisibleAfterWaiting();
  }

  public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
    getDropDownReplyMenu(activity, comment, reply).isVisibleAfterWaiting();
  }

  public void clickOnViewallXcomments() {
    viewallXcomments.clickOnElement();
  }

  public void clickOnReplyDropDownMenu(String activity, String comment, String reply) {
    getDropDownReplyMenu(activity, comment, reply).waitUntilVisible();
    getDropDownReplyMenu(activity, comment, reply).clickOnElement();
  }

  public void clickOnDeleteReplyButton(String activity, String comment, String reply) {
    getDropDownReplyMenu(activity, comment, reply).clickOnElement();
  }

  public void checkActivityCommentNotDisplayed(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).isNotVisibleAfterWaiting();
  }

  public void hoverOnMentionedUserInPost(String activity, String user) {
    Actions oAction = new Actions(driver);
    oAction.contextClick(getUserMentionedInPost(activity, user)).build().perform();
  }

  public void isMentionedUserDisplayedInPost(String activity, String user) {
    getUserMentionedInPost(activity, user).isVisibleAfterWaiting();
  }

  public boolean isSharedVideoDisplayed(String videoLink) {
    return getSharedVideoPreview(videoLink).isVisibleAfterWaiting();
  }

  public void checkFirstCommentInDrawer(String comment) {
    Assert.assertEquals(firstCommentInDrawer.getText(), comment);
    closeCommentsDrawer.clickOnElement();
  }

  public void checkSecondCommentInDrawer(String comment) {
    secondCommentInDrawer.isDisplayed();
    closeCommentsDrawer.clickOnElement();
  }

  public void checkThirdCommentInDrawer(String comment) {
    thirdCommentInDrawer.isDisplayed();
    closeCommentsDrawer.clickOnElement();
  }

  public void checkFourthCommentInDrawer(String comment) {
    fourthCommentInDrawer.isDisplayed();
    closeCommentsDrawer.clickOnElement();
  }

  public void checkSixthPositionInDrawer(String comment) {
    sixthPositionInDrawer.isDisplayed();
    closeCommentsDrawer.clickOnElement();
  }

  public void openEditActivityMenu(String activity) {
    getDropDownActivityMenu(activity).clickOnElement();
    geEditActivityIcon(activity).clickOnElement();
  }

  public void openDeleteActivityMenu(String activity) {
    getDropDownActivityMenu(activity).clickOnElement();
    geDeleteActivityIcon(activity).clickOnElement();
  }

  public void editActivityButtonIsDisplayed(String activity) {
    geEditActivityIcon(activity).isVisibleAfterWaiting();
  }

  public void deleteActivityButtonIsDisplayed(String activity) {
    geDeleteActivityIcon(activity).isVisibleAfterWaiting();
  }

  public void openThreeDotsActivityMenu(String activity) {
    getDropDownActivityMenu(activity).clickOnElement();
  }

  public void clickOnActivityComment(String comment) {
    getCommentTitleActivityStream(comment).clickOnElement();
  }

  public void linkIsOpenedNewTab(String link) {
    Assert.assertTrue(driver.getCurrentUrl().contains(link));
  }

  public void copyLinkActivityButtonIsDisplayed(String activity) {
    getCopyLinkActivityIcon(activity).isVisibleAfterWaiting();
  }

  public void downloadActivityButtonIsDisplayed(String activity) {
    getDownloadActivityIcon(activity).isVisibleAfterWaiting();
  }

  public void openLinkInNewTab(String link) {
    Actions newTab = new Actions(driver);
    newTab.keyDown(Keys.CONTROL).click(getCommentTitleActivityStream(link)).keyUp(Keys.CONTROL).build().perform();
  }

  public void commentsDrawerlikeActivityComment(String activityComment) {
    getCommentsDrawerLikeCommentIcon(activityComment).clickOnElement();
  }

  public void likeActivity(String activity) {
    getLikeIcon(activity).clickOnElement();
  }

  public void likeActivityComment(String activityComment) {
    getLikeCommentIcon(activityComment).clickOnElement();
  }

  public void clickYesbutton() {
    confirmationButtonToDeleteActivity.clickOnElement();
  }

  public boolean isconfirmationpopupNotdisplayed() {
    return confirmationButtonToDeleteActivity.isNotVisibleAfterWaiting();
  }

  public void clickDeleteActivityButton(String activity) {
    geDeleteActivityIcon(activity).clickOnElement();
  }

  public void cancelDeleteComment() {
    cancelDeleteCommentBtn.clickOnElement();
  }

  public boolean isActivityBlockNotdisplayed() {
    return activityBlock.isVisibleAfterWaiting();
  }

  public void openDeleteCommentMenu(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).clickOnElement();
    getDeleteCommentLabel(comment).clickOnElement();
  }

  public boolean isActivityCommentNotdisplayed() {
    return commentBlock.isNotVisibleAfterWaiting();
  }

  public void deleteComment(String comment) {
    getDeleteCommentLabel(comment).clickOnElement();
  }

  public void editComment(String comment) {
    getEditCommentLabel(comment).clickOnElement();
  }

  public void editCommentFromCommentsDrawer(String comment) {
    getEditCommentLabelFromCommentsDrawer(comment).clickOnElement();
  }

  public void clickOnCommentThreeDotsButton(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).clickOnElement();
  }

  public void clickOnCommentThreeDotsInCommentsDrawer(String comment) {
    getCommentsDrawerDropDownMenu(comment).waitUntilVisible();
    getCommentsDrawerDropDownMenu(comment).clickOnElement();
  }

  public void deleteReply(String reply) {
    getDeleteReplyLabel(reply).clickOnElement();
  }

  @FindBy(xpath = "//a[contains(@href,'/notes') and @tabindex='0']")
  private BaseElementFacade notesTab;

  public void clickOnNotesTab() {
    notesTab.clickOnElement();
  }

  @FindBy(xpath = "//div[contains(@class,'white border-radius')][1]//div[contains(@class,'v-list flex')]//div[contains(@class,'d-inline-flex')][1]//div[@role='button']//span[@class='v-btn__content'][last()]")
  private BaseElementFacade kudosButtonToCommentActivity;

  @FindBy(xpath = "//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-footer-comment-action')]")
  private BaseElementFacade kudosButtonFromCommentsDrawerToCommentActivity;

  private BaseElementFacade getDropDownCommentMenuFromCommentsDrawer(String comment) {
    return findByXpath(String.format("(//*[@id='activityCommentsDrawer']//*[contains(@class,'d-inline-flex flex-column activity-comment')][4]//*[contains(@class,'v-icon notranslate primary--text')])[1]",
                                     comment));
  }

  public void clickOnkudosButtonToCommentActivity() {
    kudosButtonToCommentActivity.clickOnElement();
  }

  public void clickOnkudosButtonFromCommentsDrawerToCommentActivity() {
    kudosButtonFromCommentsDrawerToCommentActivity.clickOnElement();
  }

  public void clickOnCommentThreeDotsButtonFromCommentsDrawer(String comment) {
    getDropDownCommentMenuFromCommentsDrawer(comment).clickOnElement();
  }

  private BaseElementFacade getBlueKudosCommentIcon(String activityComment) {
    return findByXpath(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'KudosActivity') and contains(@class,'v-size--x-small primary--text')])[1]",
                                     activityComment));
  }

  public void kudosLabelIsBlue(String comment) {
    getBlueKudosCommentIcon(comment).isVisibleAfterWaiting();
  }

  public void kudosLabelIsBlack(String comment) {
    getBlueKudosCommentIcon(comment).isNotVisibleAfterWaiting();
  }

  @FindBy(xpath = "(//button[contains(@id,'KudusCountLinkcomment') and @style=''])[1]")
  private BaseElementFacade kudosButtonNumberToCommentActivity;

  public void clickOnKudosButtonNumberToCommentActivity() {
    kudosButtonNumberToCommentActivity.clickOnElement();
  }

  @FindBy(xpath = "//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-footer-comment-action')]//div[@class='d-inline-flex']//button[contains(@class,'primary--text font-weight')][1]")
  private BaseElementFacade kudosButtonNumberFromCommentsDrawerToCommentActivity;

  public void clickOnKudosButtonNumberFromCommentsDrawerToCommentActivity() {
    kudosButtonNumberFromCommentsDrawerToCommentActivity.isVisibleAfterWaiting();
    kudosButtonNumberFromCommentsDrawerToCommentActivity.clickOnElement();
  }

  private BaseElementFacade getReceivedKudosNumberInDrawer(String kudosNumber) {
    return findByXpath(String.format("//div[@class='v-slide-group__wrapper']//a[@href='#kudos']//span[contains(.,'%s')]",
                                     kudosNumber));
  }

  public void getReceivedKudosSectionIsDisplayed(String kudosNumber) {
    getReceivedKudosNumberInDrawer(kudosNumber).isVisibleAfterWaiting();
  }

  private BaseElementFacade getBlueKudosCommentReplayIcon(String activityComment) {
    return findByXpath(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'KudosActivity') and contains(@class,'v-size--x-small primary--text')])[1]",
                                     activityComment));
  }

  private BaseElementFacade getBlackKudosCommentReplayIcon(String activityComment) {
    return findByXpath(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'KudosActivity') and contains(@class,'v-size--x-small')])[1]",
                                     activityComment));
  }

  public void ReplaykudosLabelIsBlue(String comment) {
    getBlueKudosCommentReplayIcon(comment).isVisibleAfterWaiting();
  }

  public void ReplaykudosLabelIsBlack(String comment) {
    getBlackKudosCommentReplayIcon(comment).isVisibleAfterWaiting();
    getBlueKudosCommentReplayIcon(comment).isNotVisibleAfterWaiting();
  }

  public void clickOnReplyKudos(String reply) {
    getBlackKudosCommentReplayIcon(reply).clickOnElement();
  }

  @FindBy(xpath = "(//div[@class='d-flex flex-lg-row flex-column'])[4]")
  private BaseElementFacade kudosButtonToActivityStream;

  public void clickOnkudosButtonToActivityStream() {
    kudosButtonToActivityStream.clickOnElement();
  }

  public void goToSpaceTasksTab() {
    spaceTasksTab.clickOnElement();
  }
}
