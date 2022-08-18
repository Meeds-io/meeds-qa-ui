package io.meeds.qa.ui.pages.page.factory.space;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SpaceHomePage extends GenericPage {
  private static final String CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR = "//*[contains(text(),'Yes')]";

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
  private TextBoxElementFacade ckEditorBodyComment;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade    ckEditorFrame;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade activityContentTextBox;

  @FindBy(xpath = "//*[contains(@class,'v-navigation-drawer--open')]//button[@aria-label='Post']")
  private BaseElementFacade    publishActivityButton;

  @FindBy(css = ".newActivitiesButton")
  private BaseElementFacade    newActivityButton;

  @FindBy(xpath = "//*[contains(@class,'v-card__actions')]//button[@aria-label='Update']")
  private BaseElementFacade    updateActivityButton;

  @FindBy(xpath = "//*[contains(@class,'drawerTitle')]/following::*[contains(@class,'mdi-close')]")
  private BaseElementFacade    closeWriteMessageBtn;

  @FindBy(xpath = "//div[contains(@class,'attachmentsFooter')]//a")
  private BaseElementFacade    applyDownloadButton;

  @FindBy(xpath = "//div[@class='progress']")
  private BaseElementFacade    progressDownloadBar;

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
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s')]", buttonName));
  }

  private BaseElementFacade getNormalLinkPreview(String link) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content-extensions')]//*[contains(@class,'activity-thumbnail-box') and @href='%s']//following::*[@class='v-image__image v-image__image--cover']/following::*[@class='my-4']",
                                          link));
  }

  @FindBy(xpath = "//*[contains(@class,'drawerContent')]//*[@class='v-btn__content' and contains(text(),'Comment')]")
  private BaseElementFacade   commentButtonInDrawer;

  @FindBy(xpath = "//*[contains(@class,'drawerContent')]//*[@class='v-btn__content' and contains(text(),'Update')]")
  private BaseElementFacade   updateButtonInDrawer;

  @FindBy(xpath = "//*[@class='v-card__actions']//button[2]")
  private BaseElementFacade   cancelDeleteCommentBtn;

  @FindBy(xpath = "//*[contains(@class,'drawerContent ')]//button//span[contains(text(),'Comment')]")
  private BaseElementFacade   replyButtonInDrawer;

  @FindBy(xpath = "//*[contains(@class,'v-btn--block v-btn--contained theme--light')]//span")
  private BaseElementFacade   loadMoreActivitiesBtn;

  @FindBy(xpath = "//button[contains(@class,'primary btn no-box-shadow ms-auto v-btn v-btn--contained')]")
  private BaseElementFacade   newActivityButtonInArabicLanguage;

  @FindBy(xpath = "//*[contains(@class,'peopleMenuIcon')]//*[contains(@class,'mdi-dots-vertical')]")
  private BaseElementFacade   spaceMemberCardThreeDotsBtn;

  @FindBy(xpath = "//*[contains(@class,'uiIcon uiIconMemberAdmin')]")
  private BaseElementFacade   promoteAsManagerBtn;

  @FindBy(xpath = "//*[contains(@class,'uiIcon uiIconTrash')]")
  private BaseElementFacade   removeMemberBtn;

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  public TextBoxElementFacade spaceMembersFilterTextBox;

  @FindBy(xpath = "//a[contains(text(),'Yes')]")
  private BaseElementFacade   yesConfirmationButton;

  @FindBy(xpath = "//i[contains(@class,'mdi-chevron-right')]")
  private BaseElementFacade   goToRightTabs;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[5]")
  private BaseElementFacade   fifthCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[7]")
  private BaseElementFacade   seventhCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[8]")
  private BaseElementFacade   eighthCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[9]")
  private BaseElementFacade   ninthCommentInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-content-extensions')]//p//div)[10]")
  private BaseElementFacade   tenthCommentInDrawer;

  @FindBy(xpath = "(//*[contains(@class, 'v-pagination__item')])[1]")
  private BaseElementFacade   commentsDrawerFirstPageBtn;

  @FindBy(xpath = "(//*[contains(@class, 'v-pagination__item')])[2]")
  private BaseElementFacade   commentsDrawerSecondPageBtn;

  private BaseElementFacade getLikeIcon(String activity) {
    return findByXPathOrCSS(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLink')])[1]",
                                          activity));
  }

  private BaseElementFacade getLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment')])[1]",
                                          activityComment));
  }

  private BaseElementFacade getCommentLikesNumber(String comment) {
    return findByXPathOrCSS(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikersListLinkcomment')])[1]//span",
                                          comment));
  }

  private BaseElementFacade getCommentsDrawerLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment')])[1]",
                                          activityComment));
  }

  private BaseElementFacade getMentionedUserInCommentEntered(String user) {
    return findByXPathOrCSS(String.format("//*[@class='atwho-inserted']//*[@class='exo-mention' and contains(text(),'%s')]",
                                          user));
  }

  private BaseElementFacade getBlueLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment') and contains(@class,'v-size--x-small primary--text')])[1]",
                                          activityComment));
  }

  private BaseElementFacade getCommentLikesNumberCommentsDrawer(String comment) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikersListLinkcomment')])[1]//span",
                                          comment));
  }

  private BaseElementFacade getDrawerCommentsNumberAndNames(String commentsNumber, String comment) {
    return findByXPathOrCSS(String.format("//*[@class='text-capitalize-first-letter' and contains(text(),'%s')]/following::*[contains(@class,'activity-comment-detail')]//*[contains(text(),'%s')]",
                                          commentsNumber,
                                          comment));
  }

  private BaseElementFacade getCommentsDrawerBlueLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerContent')]//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLinkcomment') and contains(@class,'v-size--x-small primary--text')])[1]",
                                          activityComment));
  }

  private BaseElementFacade getDrawerCommentName(String comment) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]/p/div[contains(text(),'%s')])[1]",
                                          comment));
  }

  private BaseElementFacade getActivityText(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'activity-detail')]//descendant::*[contains(text(),'%s')]",
                                          activity));
  }

  private BaseElementFacade getActivityNameUserSpace(String activity, String user, String space) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[contains(@class,'accountTitleLabel')][1]//*[contains(@id,'userAvatar') and contains(@href,'%s')]/following::*[contains(@id,'spaceAvatar') and contains(text(),'%s')][1]/following::*[contains(@class,'caption text-light-color text-truncate d-flex activity-head-time')][1]",
                                          activity,
                                          user,
                                          space));
  }

  private BaseElementFacade getDrawerReplyName(String reply) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'drawerHeader')]/following::*[contains(@class,'rich-editor-content')]//following::*[contains(text(),'%s')])[1]",
                                          reply));
  }

  private BaseElementFacade getSharedVideoPreview(String link) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content-extensions')]//following::*[@src]//following::*[@href='%s']//*[contains(@class,'font-weight-bold')]",
                                          link));
  }

  private BaseElementFacade getCommentTitleActivityStream(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//a[contains(text(),'%s')]",
                                          comment));
  }

  @FindBy(xpath = "//a[contains(@href,'tasks') and @tabindex='0']")
  private BaseElementFacade spaceTasksTab;

  @FindBy(xpath = "(//div[@class='d-flex flex-lg-row flex-column'])[4]")
  private BaseElementFacade kudosButtonToActivityStream;

  private BaseElementFacade getDropDownActivityMenu(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::i[contains(@class,'v-icon notranslate')][1]",
                                          activity));
  }

  private BaseElementFacade geEditActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Edit')][1]",
                                          activity));
  }

  private BaseElementFacade getDropDownCommentMenu(String activity, String comment) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//following::*[contains(@class,'activity-comment')]//*[contains(@class,'rich-editor-content')]//*[contains(text(),'%s')]/preceding::button[@class='v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--small'][1]",
                                          activity,
                                          comment));
  }

  private BaseElementFacade getCommentsDrawerDropDownMenu(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/preceding::i[contains(@class,'mdi mdi-dots-vertical')][1]/ancestor::button",
                                          comment));
  }

  private BaseElementFacade getCommentsDrawerViewAllReplies(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'drawerHeader')]/following::*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/following::span[contains(text(),'View all')][1]",
                                          comment));
  }

  private BaseElementFacade getDropDownReplyMenu(String activity, String comment, String reply) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'activity-detail')]//*[contains(@class, 'postContent')]//*[contains(text(),'%s')]//ancestor::*[contains(@class,'activity-detail')]//*[contains(@class,'activity-comment')]//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]//i[contains(@class, 'mdi-dots-vertical')]//ancestor::button",
                                          activity,
                                          reply));
  }

  private BaseElementFacade getReplyBox(String comment, String reply, boolean inDrawer) {
    String parentXPath = inDrawer ? "//*[@id='activityCommentsDrawer']"
                                  : "//*[contains(@class,'activity-detail')]";
    String replyXPath = parentXPath
        + String.format("//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]",
                        comment,
                        reply);
    return findByXPathOrCSS(replyXPath);
  }

  private BaseElementFacade getDeleteCommentLabel(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                          comment));
  }

  private BaseElementFacade getEditCommentLabel(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Edit')]",
                                          comment));
  }

  private BaseElementFacade getEditCommentLabelFromCommentsDrawer(String comment) {
    return findByXPathOrCSS(String.format("//*[@id='activityCommentsDrawer']//*[contains(@class,'activity-comment')]//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class,'activity-comment') and contains(@id, 'ActivityCommment_')][1]//i[contains(@class,'fa-edit')]/..",
                                          comment));
  }

  private BaseElementFacade getActivityStreamViewAllReplies(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content-extensions')]//div[contains(text(),'%s')]/following::span[contains(text(),'replies')][1]",
                                          comment));
  }

  private BaseElementFacade geDeleteActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                          activity));
  }

  private BaseElementFacade getDeleteReplyLabel(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]/preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Delete')]",
                                          comment));
  }

  private BaseElementFacade getCopyLinkActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Copy link')]",
                                          activity));
  }

  private BaseElementFacade getDownloadActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::*[@class='v-list-item__title pl-3' and contains(text(),'Download')]",
                                          activity));
  }

  public void tooltipActivityStreamIsDisplayed(String comment) {
    assertTrue(getLikeCommentIcon(comment).getAttribute("aria-expanded").contains("true"));
  }

  public void tooltipCommentsDrawerIsDisplayed(String comment) {
    assertTrue(getCommentsDrawerLikeCommentIcon(comment).getAttribute("aria-expanded").contains("true"));
  }

  public void commentNameIsNotDisplayedInDrawer(String comment) {
    assertWebElementNotVisible(getDrawerCommentName(comment));
  }

  public void noCommentDisplayedInDrawer() {
    assertWebElementVisible(findByXPathOrCSS("//*[@class='text-capitalize-first-letter' and contains(text(),'No comment yet')]"));
  }

  public void displayedLikesOnComment(String comment, String number) {
    assertTrue(getCommentLikesNumber(comment).getTextContent().contains(number));
  }

  public void likeLabelIsBlue(String comment) {
    assertWebElementVisible(getBlueLikeCommentIcon(comment));
  }

  public void likeLabelIsBlack(String comment) {
    BaseElementFacade element = getBlueLikeCommentIcon(comment);
    assertWebElementNotVisible(element);
  }

  public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
    assertTrue(getCommentLikesNumberCommentsDrawer(comment).getTextContent().contains(number));
  }

  public void likeLabelInCommentsDrawerIsBlack(String comment) {
    assertWebElementNotVisible(getCommentsDrawerBlueLikeCommentIcon(comment));
  }

  public void userIsMentionedInCommentEntered(String user) {
    driver.switchTo().frame(ckEditorFrameComment);
    try {
      assertWebElementVisible(getMentionedUserInCommentEntered(user));
    } finally {
      driver.switchTo().defaultContent();
    }
  }

  public void userIsNotMentionedInCommentEntered(String user) {
    driver.switchTo().frame(ckEditorFrameComment);
    try {
      assertWebElementNotVisible(getMentionedUserInCommentEntered(user));
    } finally {
      driver.switchTo().defaultContent();
    }
  }

  public void likeLabelInCommentsDrawerIsBlue(String comment) {
    assertWebElementVisible(getCommentsDrawerBlueLikeCommentIcon(comment));
  }

  public void clickCloseActivityDrawerbutton() {
    closeActivityDrawerbutton.clickOnElement();
  }

  public void replyInDrawerIsNotDisplayed(String reply) {
    BaseElementFacade element = getDrawerReplyName(reply);
    assertWebElementNotVisible(element);
  }

  public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
    assertWebElementNotVisible(getReplyBox(comment, reply, true));
  }

  public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
    assertWebElementVisible(getReplyBox(comment, reply, true));
  }

  public void normalLinkPreviewIsVisible(String link) {
    assertWebElementVisible(getNormalLinkPreview(link));
  }

  @SwitchToWindow
  public void enterActivityText(String activity) {

    try {
      driver.switchTo().frame(ckEditorFrame);
      activityContentTextBox.waitUntilVisible();
      activityContentTextBox.sendKeys(activity);
    } finally {
      driver.switchTo().defaultContent();
    }

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

  public void removeMember(String name) {
    spaceMembersFilterTextBox.waitUntilVisible();
    spaceMembersFilterTextBox.setTextValue(name);
    spaceMemberCardThreeDotsBtn.clickOnElement();
    removeMemberBtn.clickOnElement();
  }

  public void viewAllRepliesInCommentsDrawer(String comment) {
    getCommentsDrawerViewAllReplies(comment).clickOnElement();
  }

  public void clickPostIcon() {
    if (activityTab.getAttribute("aria-selected").equals("false")) {
      goToSpecificTab("Stream");
    }
    verifyPageLoaded();
    postIcon.clickOnElement();
  }

  public void viewAllRepliesInActivityStream(String comment) {
    getActivityStreamViewAllReplies(comment).clickOnElement();
  }

  public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
    assertTrue(String.format("Comment '%s' should be displayed in drawer with drawer title '%s'",
                             comment,
                             commentsNumber),
               getDrawerCommentsNumberAndNames(commentsNumber, comment).isDisplayed());
  }

  public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
    BaseElementFacade element = getDrawerCommentsNumberAndNames(commentsNumber, comment);
    element.setImplicitTimeout(Duration.ofMillis(200));
    Assert.assertFalse(String.format("Comment '%s' shouldn't be displayed in drawer with drawer title '%s'",
                                     comment,
                                     commentsNumber),
                       element.isDisplayed());
  }

  public void clickOnLoadMoreActivities() {
    loadMoreActivitiesBtn.clickOnElement();
  }

  public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
    assertWebElementVisible(getActivityNameUserSpace(activity, user, space));
  }

  @SwitchToWindow
  public void addActivity(String activity) {
    waitCKEditorLoading();

    ckEditorFrame.waitUntilVisible();
    ckEditorFrame.clickOnElement();
    driver.switchTo().frame(ckEditorFrame);

    try {
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
    } finally {
      driver.switchTo().defaultContent();
    }
  }

  public void publishActivity() {
    publishActivityButton.clickOnElement();
    refreshPage();
  }

  public void editActivity() {
    updateActivityButton.clickOnElement();
    verifyPageLoaded();
  }

  public void clickApplyDownload() {
    applyDownloadButton.clickOnElement();
  }

  public boolean isLinkPreviewVisible() {
    return isVisible("//*[contains(@id,'Extactivity-content-extensions')]//following::*[@src]//following::*[@class='my-4']//*[contains(@class,'font-weight-bold')]");
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
      case "Stream":
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

  private BaseElementFacade getCommentElementLink(String id) {
    return findByXPathOrCSS(String.format("(//*[@id='CommentLink%s'])[1]", id));
  }

  private BaseElementFacade getCommentReply(String comment, String id) {
    return findByXPathOrCSS(String.format("(//*[contains(text(),'%s')]/following::*[@id='CommentLink%s']//span[contains(text(),'Reply')])[1]",
                                          comment,
                                          id));
  }

  @FindBy(xpath = "(//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//p//div)[1]")
  private BaseElementFacade firstASDisplayedComment;

  @FindBy(xpath = "(//*[contains(@id,'activity-comment-detail')]//*[contains(@id,'Extactivity-content-extensions')]//div)[2]")
  private BaseElementFacade secondASDisplayedComment;

  @SwitchToWindow
  public void addActivityComment(String activityId, String comment) {

    getCommentElementLink(activityId).clickOnElement();

    clickOnCommentRichText();
    driver.switchTo().frame(ckEditorFrameComment);
    try {
      ckEditorBodyComment.waitUntilVisible();
      ckEditorBodyComment.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }

    commentButtonInDrawer.clickOnElement();
    closeCommentsDrawer();
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
    closeCommentsDrawer();
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
    closeCommentsDrawer();
  }

  public void publishComment() {
    commentButtonInDrawer.clickOnElement();
    closeCommentsDrawer();
  }

  public void updateComment() {
    updateButtonInDrawer.clickOnElement();
    closeCommentsDrawer();
  }

  @SwitchToWindow
  public void enterCommentText(String comment) {
    driver.switchTo().frame(ckEditorFrameComment);

    try {
      ckEditorBodyComment.sendKeys(comment);
    } finally {
      driver.switchTo().defaultContent();
    }

    Serenity.setSessionVariable("comment").to(comment);
  }

  @SwitchToWindow
  public void updateCommentText(String comment) {
    driver.switchTo().frame(ckEditorFrameComment);

    try {
      ckEditorBodyComment.clear();
      ckEditorBodyComment.sendKeys(comment);
    } finally {
      driver.switchTo().defaultContent();
    }

    Serenity.setSessionVariable("comment").to(comment);
  }

  @SwitchToWindow
  public void enterCommentLink(String activityId, String comment) {

    getCommentElementLink(activityId).clickOnElement();

    clickOnCommentRichText();
    driver.switchTo().frame(ckEditorFrameComment);
    try {
      if (comment.contains("https")) {
        ckEditorBodyComment.sendKeys(comment);
        ckEditorBodyComment.sendKeys(Keys.CONTROL + "a" + "x");
        driver.navigate().refresh();
        getCommentElementLink(activityId).clickOnElement();
        ckEditorFrameComment.waitUntilVisible();
        clickOnCommentRichText();
        driver.switchTo().frame(ckEditorFrameComment);

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
      driver.switchTo().defaultContent();
    }

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
    assertWebElementNotVisible(titlePoll);
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

  @SwitchToWindow
  public void addCommentReply(String reply, String comment, String activity) {
    String activityId = getActivityId(activity);
    getCommentReply(comment, activityId).clickOnElement();

    clickOnCommentRichText();
    driver.switchTo().frame(ckEditorFrameComment);
    try {
      ckEditorBodyComment.waitUntilVisible();
      ckEditorBodyComment.setTextValue(reply);
    } finally {
      driver.switchTo().defaultContent();
    }

    replyButtonInDrawer.clickOnElement();
    closeCommentsDrawer();
  }

  public void clickOnConfirmButton() {
    getConfirmButton("Confirm").clickOnElement();
  }

  private BaseElementFacade getActivityElement(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'activity-detail')]//*[contains(text(),'%s')]/ancestor::*[contains(@class,'activity-detail')]",
                                          activity));
  }

  private BaseElementFacade getUserMentionedInPost(String activity, String user) {
    return findByXPathOrCSS(String.format("//*[contains(@id,'Extactivity-content')]//*[contains(text(),'%s')]//*[contains(text(),'%s')]",
                                          activity,
                                          user));
  }

  private BaseElementFacade getUserPopover(String user) {
    return findByXPathOrCSS(String.format("//*[@id='profileName']//*[contains(text(),'%s')]", user));
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
    assertWebElementVisible(getUserPopover(user));
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
    closeCommentsDrawer();
  }

  public void hoverOnLikeIconCommentsDrawer(String comment) {
    Actions oAction = new Actions(driver);
    oAction.contextClick(getCommentsDrawerLikeCommentIcon(comment)).build().perform();
  }

  public void openCommentsDrawer(String activityId) {
    getCommentElementLink(activityId).clickOnElement();
    waitForDrawerToLoad();
  }

  public void closeCommentsDrawer() {
    BaseElementFacade closeDrawerButton =
                                        findByXPathOrCSS("//*[@id='activityCommentsDrawer']//*[contains(@class, 'drawerIcons')]//button[contains(@class, 'mdi-close')]");
    clickOnElement(closeDrawerButton);
    closeDrawerButton.waitUntilNotVisible();
  }

  public boolean isActivityVisible(String activity) {
    return isWebElementVisible(getActivityText(activity));
  }

  public void clickOnCommentActivityButton(String activityId) {
    getCommentElementLink(activityId).clickOnElement();
  }

  @SwitchToWindow
  public void enterActivityCommentWithUser(String comment, String user) {
    mentionUserWithContent(ckEditorFrameComment, ckEditorBodyComment, comment, user);
  }

  public void publishActivityInArabicLanguage() {
    newActivityButtonInArabicLanguage.clickOnElement();
  }

  public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
    assertWebElementNotVisible(getReplyBox(comment, reply, StringUtils.isBlank(activity)));
  }

  public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
    assertWebElementVisible(getReplyBox(comment, reply, StringUtils.isBlank(activity)));
  }

  public void clickOnViewallXcomments() {
    viewallXcomments.clickOnElement();
  }

  public void clickOnReplyDropDownMenu(String activity, String comment, String reply) {
    BaseElementFacade threeDots = getDropDownReplyMenu(activity, comment, reply);
    threeDots.waitUntilVisible();
    threeDots.clickOnElement();
  }

  public void clickOnDeleteReplyButton(String activity, String comment, String reply) {
    getDropDownReplyMenu(activity, comment, reply).clickOnElement();
  }

  public void checkActivityCommentNotDisplayed(String activity, String comment) {
    assertWebElementNotVisible(getDropDownCommentMenu(activity, comment));
  }

  public void hoverOnMentionedUserInPost(String activity, String user) {
    Actions oAction = new Actions(driver);
    oAction.contextClick(getUserMentionedInPost(activity, user)).build().perform();
  }

  public void isMentionedUserDisplayedInPost(String activity, String user) {
    assertWebElementVisible(getUserMentionedInPost(activity, user));
  }

  public boolean isSharedVideoDisplayed(String videoLink) {
    return isWebElementVisible(getSharedVideoPreview(videoLink));
  }

  public void checkFirstCommentInDrawer(String comment) {
    Assert.assertEquals(firstCommentInDrawer.getText(), comment);
    closeCommentsDrawer();
  }

  public void checkSecondCommentInDrawer(String comment) {
    secondCommentInDrawer.isDisplayed();
    closeCommentsDrawer();
  }

  public void checkThirdCommentInDrawer(String comment) {
    thirdCommentInDrawer.isDisplayed();
    closeCommentsDrawer();
  }

  public void checkFourthCommentInDrawer(String comment) {
    fourthCommentInDrawer.isDisplayed();
    closeCommentsDrawer();
  }

  public void checkSixthPositionInDrawer(String comment) {
    sixthPositionInDrawer.isDisplayed();
    closeCommentsDrawer();
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
    assertWebElementVisible(geEditActivityIcon(activity));
  }

  public void deleteActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(geDeleteActivityIcon(activity));
  }

  public void openThreeDotsActivityMenu(String activity) {
    getDropDownActivityMenu(activity).clickOnElement();
  }

  public void clickOnActivityComment(String comment) {
    getCommentTitleActivityStream(comment).clickOnElement();
  }

  public void linkIsOpenedNewTab(String link) {
    Set<String> windowHandles = driver.getWindowHandles();
    boolean tabFound = windowHandles.size() > 1 && windowHandles.stream().anyMatch(windowId -> {
      driver.switchTo().window(windowId);
      String currentUrl = driver.getCurrentUrl();
      boolean found = currentUrl.contains(link);
      if (!currentUrl.contains("/portal")) {
        driver.close();
      }
      return found;
    });
    assertTrue(tabFound);
    driver.switchTo().window(windowHandles.iterator().next());
  }

  public void copyLinkActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(getCopyLinkActivityIcon(activity));
  }

  public void downloadActivityButtonIsDisplayed(String activity) {
    assertWebElementVisible(getDownloadActivityIcon(activity));
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
    findByXPathOrCSS(CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR).clickOnElement();
  }

  public boolean isConfirmationPopupNotDisplayed() {
    return isNotVisible(CONFIRMATION_BUTTON_TO_DELETE_ACTIVITY_SELECTOR);
  }

  public void clickDeleteActivityButton(String activity) {
    geDeleteActivityIcon(activity).clickOnElement();
  }

  public void cancelDeleteComment() {
    cancelDeleteCommentBtn.clickOnElement();
  }

  public void openDeleteCommentMenu(String activity, String comment) {
    getDropDownCommentMenu(activity, comment).clickOnElement();
    getDeleteCommentLabel(comment).clickOnElement();
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
    BaseElementFacade commentsDrawerDropDownMenu = getCommentsDrawerDropDownMenu(comment);
    clickOnElement(commentsDrawerDropDownMenu);
  }

  public void deleteReply(String reply) {
    getDeleteReplyLabel(reply).clickOnElement();
  }

  @FindBy(xpath = "//a[contains(@href,'/notes') and @tabindex='0']")
  private BaseElementFacade notesTab;

  public void clickOnNotesTab() {
    notesTab.clickOnElement();
  }

  @FindBy(
      xpath = "//div[contains(@class,'white border-radius')][1]//div[contains(@class,'v-list flex')]//div[contains(@class,'d-inline-flex')][1]//div[@role='button']//span[@class='v-btn__content'][last()]"
  )
  private BaseElementFacade kudosButtonToCommentActivity;

  @FindBy(xpath = "//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-footer-comment-action')]")
  private BaseElementFacade kudosButtonFromCommentsDrawerToCommentActivity;

  private BaseElementFacade getDropDownCommentMenuFromCommentsDrawer(String comment) {
    return findByXPathOrCSS(String.format("(//*[@id='activityCommentsDrawer']//*[contains(@class,'d-inline-flex flex-column activity-comment')][4]//*[contains(@class,'v-icon notranslate primary--text')])[1]",
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
    return findByXPathOrCSS(String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'KudosActivity') and contains(@class,'v-size--x-small primary--text')])[1]",
                                          activityComment));
  }

  public void kudosLabelIsBlue(String comment) {
    assertWebElementVisible(getBlueKudosCommentIcon(comment));
  }

  public void kudosLabelIsBlack(String comment) {
    assertWebElementNotVisible(getBlueKudosCommentIcon(comment));
  }

  @FindBy(xpath = "(//button[contains(@id,'KudusCountLinkcomment') and @style=''])[1]")
  private BaseElementFacade kudosButtonNumberToCommentActivity;

  public void clickOnKudosButtonNumberToCommentActivity() {
    kudosButtonNumberToCommentActivity.clickOnElement();
  }

  @FindBy(
      xpath = "//*[@id='activityCommentsDrawer']//*[contains(@id,'Extactivity-footer-comment-action')]//div[@class='d-inline-flex']//button[contains(@class,'primary--text font-weight')][1]"
  )
  private BaseElementFacade kudosButtonNumberFromCommentsDrawerToCommentActivity;

  public void clickOnKudosButtonNumberFromCommentsDrawerToCommentActivity() {
    assertWebElementVisible(kudosButtonNumberFromCommentsDrawerToCommentActivity);
    kudosButtonNumberFromCommentsDrawerToCommentActivity.clickOnElement();
  }

  private BaseElementFacade getReceivedKudosNumberInDrawer(String kudosNumber) {
    return findByXPathOrCSS(String.format("//div[@class='v-slide-group__wrapper']//a[@href='#kudos']//span[contains(.,'%s')]",
                                          kudosNumber));
  }

  public void getReceivedKudosSectionIsDisplayed(String kudosNumber) {
    assertWebElementVisible(getReceivedKudosNumberInDrawer(kudosNumber));
  }

  private BaseElementFacade getBlueKudosCommentReplyIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//*[contains(text(),'%s')]//ancestor::*[contains(@id, 'ActivityCommment')])[1]/*[1]//button[contains(@id,'KudosActivity') and contains(@class,'primary--text')]",
                                          activityComment));
  }

  private BaseElementFacade getBlackKudosCommentReplyIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//*[contains(text(),'%s')]//ancestor::*[contains(@id, 'ActivityCommment')])[1]/*[1]//button[contains(@id,'KudosActivity') and not(contains(@class,'primary--text'))]",
                                          activityComment));
  }

  public void replyKudosLabelIsBlue(String comment) {
    assertWebElementVisible(getBlueKudosCommentReplyIcon(comment));
  }

  public void replyKudosLabelIsBlack(String comment) {
    assertWebElementVisible(getBlackKudosCommentReplyIcon(comment));
    assertWebElementNotVisible(getBlueKudosCommentReplyIcon(comment));
  }

  public void clickOnReplyKudos(String reply) {
    getBlackKudosCommentReplyIcon(reply).clickOnElement();
  }

  public void clickOnkudosButtonToActivityStream() {
    kudosButtonToActivityStream.clickOnElement();
  }

  public void goToSpaceTasksTab() {
    spaceTasksTab.clickOnElement();
  }

  private void clickOnCommentRichText() {
    waitCKEditorLoading();

    ckEditorFrameComment.waitUntilVisible();
    ckEditorFrameComment.clickOnElement();
  }

}
