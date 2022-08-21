package io.meeds.qa.ui.steps.definition;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.pages.page.factory.space.SpaceHomePage;
import io.meeds.qa.ui.steps.SpaceHomeSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class SpaceHomeStepDefinition {

  private SpaceHomePage  spaceHomePage;

  @Steps
  private SpaceHomeSteps spaceHomeSteps;

  @And("I go to notes application of the space")
  public void accessNotesApp() {
    spaceHomeSteps.accessNotesApp();
  }

  @When("^I enter an activity '(.*)'$")
  @And("^I add a short message '(.*)' for the Poll$")
  public void addActivity(String activity) {
    spaceHomeSteps.addActivity(activity);
  }

  @When("^I add in activity '(.*)' a comment '(.*)'$")
  public void addActivityComment(String activity, String comment) {
    spaceHomePage.getActivityId(activity);
    spaceHomePage.addActivityComment(spaceHomePage.getActivityId(activity), comment);
  }

  @When("^I enter an activity more than 1300 characters$")
  public void addActivityExceed() {
    String activity = StringUtils.repeat("activity to add", 90);
    spaceHomeSteps.addActivity(activity);
    Serenity.setSessionVariable("activity").to(activity);
  }

  @When("^I enter an activity '(.*)' mentioning the second user$")
  public void addActivityMentioningSecondUser(String activity) {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    String newActivity = activity + " @" + secondUserName;
    spaceHomeSteps.addActivity(newActivity);
  }

  @When("^I add a reply '(.*)' to comment '(.*)' in activity '(.*)'$")
  public void addCommentReply(String reply, String comment, String activity) {
    spaceHomePage.addCommentReply(reply, comment, activity);
  }

  @When("^I add description with less than 1000 characters In the poll$")
  public void addDescriptionLess1000CharsInThePoll() {
    String description = StringUtils.repeat("Description ", 80);
    spaceHomeSteps.addDescriptionLess1000CharsInThePoll(description);
  }

  @When("^I add description with more than 1000 characters In the poll$")
  public void addDescriptionMore1000CharsInThePoll() {
    String description = StringUtils.repeat("Description ", 100);
    spaceHomeSteps.addOptionThreeInThePoll(description);
  }

  @When("^I add in activity '(.*)' an internal link '(.*)' as a comment$")
  public void addInternalLinkComment(String activity, String comment) {
    String currentUrl = spaceHomePage.getCurrentUrl().split("portal")[0];
    spaceHomePage.getActivityId(activity);
    spaceHomePage.addActivityComment(spaceHomePage.getActivityId(activity), currentUrl + comment);
  }

  @When("^I added the second choice '(.*)' in the poll$")
  public void addOptionTwoInThePoll(String choiceTow) {
    spaceHomeSteps.addOptionTwoInThePoll(choiceTow);
  }

  @Then("^I click on Cancel button$")
  public void cancelDeleteComment() {
    spaceHomeSteps.cancelDeleteComment();
  }

  @When("^the activity '(.*)' is displayed in activity stream$")
  @Then("^the activity '(.*)' is displayed in stream page$")
  @And("^The Poll '(.*)' is displayed in stream page$")
  public void checkActivity(String activity) {
    assertThat(spaceHomeSteps.isActivityVisible(activity))
                                                          .as("The activity with expected content isn't displayed in activity stream")
                                                          .isTrue();
  }

  @Then("^Activity Comment '(.*)' is displayed in activity stream$")
  public void checkActivityComment(String comment) {
    spaceHomeSteps.checkActivityComment(comment);
  }

  @Then("^Activity Comment '(.*)' is displayed in Comments drawer$")
  public void checkActivityCommentInDrawer(String comment) {
    spaceHomeSteps.checkActivityCommentInDrawer(comment);
  }

  @Then("^Comment '(.*)' is not displayed in activity '(.*)'$")
  public void checkActivityCommentNotDisplayed(String comment, String activity) {
    spaceHomeSteps.checkActivityCommentNotDisplayed(activity, comment);
  }

  @And("^the activity '(.*)' is no more displayed in the activity stream$")
  @Then("^the activity '(.*)' is not displayed in activity stream$")
  @When("^the activity '(.*)' is not displayed in stream page$")
  public void checkActivityIsNotVisible(String activity) {
    assertThat(spaceHomeSteps.isActivityVisible(activity))
                                                          .as("Activity is displayed in activity stream")
                                                          .isFalse();
  }

  @Then("^The activity page is opened '(.*)'$")
  public void checkActivityTitle(String activity) {
    spaceHomeSteps.checkActivityTitle(activity);
  }

  @Then("^Comment '(.*)' is displayed in comments drawer at the sixth position$")
  public void checkCommentInDrawerSixthPosition(String comment) {
    spaceHomeSteps.checkSixthPositionInDrawer(comment);
  }

  @When("^In activity '(.*)' with comment '(.*)', the reply '(.*)' is displayed$")
  public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
    spaceHomeSteps.checkCommentReplyDisplayed(activity, comment, reply);
  }

  @When("^In activity '(.*)' with comment '(.*)', the reply '(.*)' is not displayed$")
  public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
    spaceHomeSteps.checkCommentReplyNotDisplayed(activity, comment, reply);
  }

  @Then("^The confirmation popup is displayed$")
  public void checkConfirmationPopupIsVisible() {
    assertThat(spaceHomeSteps.isConfirmationPopupNotDisplayed()).isFalse();
  }

  @Then("^the confirmation popup is not displayed$")
  public void checkConfirmationPopupNotVisible() {
    assertThat(spaceHomeSteps.isConfirmationPopupNotDisplayed()).isTrue();
  }

  @Then("^the video '(.*)' is displayed in the activity stream$")
  public void checkDisplayVideo(String videoLink) {
    assertThat(spaceHomeSteps.isSharedVideoDisplayed(videoLink))
                                                                .as("shared video link should be displayed but it is not")
                                                                .isTrue();
  }

  @Then("^First comment '(.*)' is displayed in activity stream$")
  public void checkFirstActivityComment(String comment) {
    spaceHomeSteps.checkFirstActivityComment(comment);
  }

  @Then("^First comment '(.*)' is displayed in comments drawer$")
  public void checkFirstCommentInDrawer(String comment) {
    spaceHomeSteps.checkFirstCommentInDrawer(comment);
  }

  @Then("Check Four comment is displayed in comments drawer")
  public void checkFourCommentIsDisplayedInDrawer() {
    spaceHomeSteps.checkFourCommentIsDisplayedInDrawer();
  }

  @Then("^Fourth comment '(.*)' is displayed in comments drawer$")
  public void checkFourthCommentInDrawer(String comment) {
    spaceHomeSteps.checkFourthCommentInDrawer(comment);
  }

  @Then("^Internal link '(.*)' is displayed in activity stream as a comment$")
  public void checkInternalLinkCommentAS(String comment) {
    String currentUrl = spaceHomePage.getCurrentUrl().split("portal")[0];
    spaceHomeSteps.checkActivityComment(currentUrl + comment);
  }

  @Then("^Internal link '(.*)' is displayed in Comments drawer as a comment$")
  public void checkInternalLinkCommentInDrawer(String comment) {
    String currentUrl = spaceHomePage.getCurrentUrl().split("portal")[0];
    spaceHomeSteps.checkActivityCommentInDrawer(currentUrl + comment);
  }

  @Then("The link is displayed with the preview")
  public void checkPreviewLink() {
    assertThat(spaceHomeSteps.isLinkPreviewVisible()).as("The link preview is not displayed").isTrue();
  }

  @Then("^Second comment '(.*)' is displayed in activity stream$")
  public void checkSecondActivityComment(String comment) {
    spaceHomeSteps.checkSecondActivityComment(comment);
  }

  @Then("^Second comment '(.*)' is displayed in comments drawer$")
  public void checkSecondCommentInDrawer(String comment) {
    spaceHomeSteps.checkSecondCommentInDrawer(comment);
  }

  @Then("Check Ten comment is displayed in comments drawer")
  public void checkTenCommentIsDisplayedInDrawer() {
    spaceHomeSteps.checkTenCommentIsDisplayedInDrawer();
  }

  @Then("^Third comment '(.*)' is displayed in comments drawer$")
  public void checkThirdCommentInDrawer(String comment) {
    spaceHomeSteps.checkThirdCommentInDrawer(comment);
  }

  @When("^I click on Create Poll$")
  public void clickCreatePoll() {
    spaceHomeSteps.clickCreatePoll();
  }

  @When("^I click Create Poll$")
  public void clickCreatePollButton() {
    spaceHomeSteps.clickCreatePollButton();
  }

  @When("^I click on Delete button related to activity '(.*)'$")
  public void clickDeleteActivityButton(String activity) {
    spaceHomeSteps.clickDeleteActivityButton(activity);
  }

  @When("^I click on comment '(.*)'$")
  public void clickOnActivityComment(String comment) {
    spaceHomeSteps.clickOnActivityComment(comment);
  }

  @When("^I click on comment button related to activity '(.*)'$")
  public void clickOnCommentActivity(String activity) {
    spaceHomePage.getActivityId(activity);
    spaceHomePage.clickOnCommentActivityButton(spaceHomePage.getActivityId(activity));
  }

  @When("^I go to the comments drawer first page$")
  public void clickOnCommentsDrawerFirstPage() {
    spaceHomeSteps.clickOnCommentsDrawerFirstPage();
  }

  @When("^I go to the comments drawer second page$")
  public void clickOnCommentsDrawerSecondPage() {
    spaceHomeSteps.clickOnCommentsDrawerSecondPage();
  }

  @Then("^In activity '(.*)', I click on the comment '(.*)' three dots icon$")
  public void clickOnCommentThreeDotsButton(String activity, String comment) {
    spaceHomeSteps.clickOnCommentThreeDotsButton(activity, comment);
  }

  @Then("^I click on the comment '(.*)' three dots icon from comments drawer$")
  public void clickOnCommentThreeDotsButtonFromCommentsDrawer(String comment) {
    spaceHomeSteps.clickOnCommentThreeDotsButtonFromCommentsDrawer(comment);
  }

  @Then("^In comments drawer, I click on the comment '(.*)' three dots icon$")
  @And("^In comments drawer, I click on the reply '(.*)' three dots icon$")
  public void clickOnCommentThreeDotsInCommentsDrawer(String comment) {
    spaceHomeSteps.clickOnCommentThreeDotsInCommentsDrawer(comment);
  }

  @When("^I click on the internal link '(.*)'$")
  public void clickOnInternalLinkComment(String comment) {
    String currentUrl = spaceHomePage.getCurrentUrl().split("portal")[0];
    spaceHomeSteps.clickOnActivityComment(currentUrl + comment);
  }

  @When("^I click on Load more button$")
  public void clickOnLoadMoreActivities() {
    spaceHomeSteps.clickOnLoadMoreActivities();
  }

  @Then("^In activity '(.*)' with comment '(.*)', I click on the reply '(.*)' three dots icon$")
  public void clickOnReplyDropDownMenu(String activity, String comment, String reply) {
    spaceHomeSteps.clickOnReplyDropDownMenu(activity, comment, reply);
  }

  @Then("^In reply '(.*)', I click on kudos button$")
  public void clickOnReplyKudos(String reply) {
    spaceHomeSteps.clickOnReplyKudos(reply);
  }

  @Then("I click on the kudos button from the Activity Stream")
  public void clickOnTheKudosButtonFromTheActivityStream() {
    spaceHomeSteps.clickKudosFromActivityStream();
  }

  @Then("I click on the kudos button from the comment")
  public void clickOnTheKudosButtonFromTheComment() {
    spaceHomeSteps.clickKudosFromComment();
  }

  @Then("I click on the kudos button from the comments drawer")
  public void clickOnTheKudosButtonFromTheCommentsDrawer() {
    spaceHomeSteps.clickKudosFromCommentsDrawer();
  }

  @And("I click on the kudos button number")
  public void clickOnTheKudosButtonNumber() {
    spaceHomeSteps.clickOnKudosNumberButton();
  }

  @And("I click on the kudos button number from the comments drawer")
  public void clickOnTheKudosButtonNumberFromTheCommentsDrawer() {
    spaceHomeSteps.clickOnKudosNumberButtonFromTheCommentsDrawer();
  }

  @Then("I click on the second user Popover")
  public void clickOnTheSecondUserPopover() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    spaceHomeSteps.clickOnTheUserPopover(fullName);
  }

  @Then("^I click on the user Popover '(.*)'$")
  public void clickOnTheUserPopover(String user) {
    spaceHomeSteps.clickOnTheUserPopover(user);
  }

  @When("^I click on View all X comments$")
  public void clickOnViewallXcomments() {
    spaceHomeSteps.clickOnViewallXcomments();
  }

  @When("I click on post in space")
  public void clickPostIcon() {
    spaceHomeSteps.clickPostIcon();
  }

  @Then("^I close activity drawer$")
  public void closeActivityDrawer() {
    spaceHomeSteps.clickCloseActivityDrawerbutton();
  }

  @Then("^I close the comments drawer$")
  public void closeCommentsDrawer() {
    spaceHomeSteps.closeCommentsDrawer();
  }

  @Then("I close the Write message drawer")
  public void closeWriteMessageDrawer() {
    spaceHomeSteps.closeWriteMessageDrawer();
  }

  @Then("^'(.*)' among them '(.*)' are displayed in Comments drawer$")
  @And("^'(.*)', only '(.*)' is displayed in Comments drawer$")
  public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
    spaceHomeSteps.commentIsDisplayedInDrawer(commentsNumber, comment);
  }

  @Then("^'(.*)' among them '(.*)' are not displayed in Comments drawer$")
  @And("^'(.*)', only '(.*)' is not displayed in Comments drawer$")
  public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
    spaceHomeSteps.commentIsNotDisplayedInDrawer(commentsNumber, comment);
  }

  @When("^Comment '(.*)' is not displayed in the drawer$")
  public void commentNameIsNotDisplayedInDrawer(String comment) {
    spaceHomeSteps.commentNameIsNotDisplayedInDrawer(comment);
  }

  @Then("^In comments drawer, on comment '(.*)', '(.*)' like is displayed$")
  public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
    spaceHomeSteps.commentsDrawerDisplayedLikesOnComment(comment, number);
  }

  @When("^In comments drawer, I like the activity comment '(.*)'$")
  public void commentsDrawerlikeActivityComment(String activityComment) {
    spaceHomeSteps.commentsDrawerlikeActivityComment(activityComment);
  }

  @When("^Copy link button related to activity '(.*)' is displayed$")
  public void copyLinkActivityButtonIsDisplayed(String activity) {
    spaceHomeSteps.copyLinkActivityButtonIsDisplayed(activity);
  }

  @When("^I create a simple poll with title '(.*)' and Choice One '(.*)' and Choice Two '(.*)'$")
  public void createPoll(String pollTitle, String choiceOne, String choiceTow) {
    spaceHomeSteps.createPoll(pollTitle, choiceOne, choiceTow);
  }

  @When("^Create Poll Button is Disabled$")
  public void createPollButton() {
    spaceHomeSteps.createPollButton();
  }

  @When("^create poll drawer is closed$")
  public void createPollDrawerClosed() {
    spaceHomeSteps.createPollDrawerClosed();
  }

  @When("^I try to create a poll with title '(.*)' and with a single choice '(.*)'$")
  public void createPollWithOneChoice(String pollTitle, String choiceOne) {
    spaceHomeSteps.createPollWithOneChoice(pollTitle, choiceOne);
  }

  @When("^Delete button related to activity '(.*)' is displayed$")
  public void deleteActivityButtonIsDisplayed(String activity) {
    spaceHomeSteps.deleteActivityButtonIsDisplayed(activity);
  }

  @When("^In comment '(.*)', I click on delete button$")
  public void deleteComment(String comment) {
    spaceHomeSteps.deleteComment(comment);
  }

  @When("^In reply '(.*)', I click on delete button$")
  public void deleteReply(String reply) {
    spaceHomeSteps.deleteReply(reply);
  }

  @Then("^On comment '(.*)', '(.*)' like is displayed$")
  public void displayedLikesOnComment(String comment, String number) {
    spaceHomeSteps.displayedLikesOnComment(comment, number);
  }

  @When("^Download button related to activity '(.*)' is displayed$")
  public void downloadActivityButtonIsDisplayed(String activity) {
    spaceHomeSteps.downloadActivityButtonIsDisplayed(activity);
  }

  @When("I click on Update")
  public void editActivity() {
    spaceHomeSteps.editActivity();
  }

  @When("^Edit button related to activity '(.*)' is displayed$")
  public void editActivityButtonIsDisplayed(String activity) {
    spaceHomeSteps.editActivityButtonIsDisplayed(activity);
  }

  @When("^In comment '(.*)', I click on edit button$")
  public void editComment(String comment) {
    spaceHomeSteps.editComment(comment);
  }

  @When("^In comment '(.*)', I click on edit button from comments drawer$")
  public void editCommentFromCommentsDrawer(String comment) {
    spaceHomeSteps.editCommentFromCommentsDrawer(comment);
  }

  @When("^I edited created poll with title '(.*)' and Choice One '(.*)' and Choice Two '(.*)'$")
  public void editPoll(String pollTitle, String choiceOne, String choiceTow) {
    spaceHomeSteps.editPoll(pollTitle, choiceOne, choiceTow);
  }

  @When("^I enter a comment '(.*)' with mentioning the (.*) user$")
  public void enterActivityCommentWithRandomUser(String comment, String userPrefix) {
    String lastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    spaceHomeSteps.enterActivityCommentWithUser(comment, lastName);
  }

  @When("^I insert text '(.*)'$")
  public void enterActivityText(String activity) {
    spaceHomeSteps.enterActivityText(activity);
  }

  @When("^In activity '(.*)' I enter the link '(.*)' as comment$")
  public void enterCommentLink(String activity, String link) {
    spaceHomePage.enterCommentLink(spaceHomePage.getActivityId(activity), link);
  }

  @When("^I insert text '(.*)' as comment$")
  public void enterCommentText(String comment) {
    spaceHomeSteps.enterCommentText(comment);
  }

  @Then("^I go to the Space Members tab$")
  public void goToSpaceMembersTab() {
    spaceHomeSteps.goToSpaceMembersTab();
  }

  @Then("^I go to the Tasks tab$")
  public void goToSpaceTasksTab() {
    spaceHomeSteps.goToSpaceTasksTab();
  }

  @Then("^I go to '(.*)' tab$")
  public void goToTab(String tabName) {
    spaceHomeSteps.goToSpecificTab(tabName);
  }

  @When("^In comment '(.*)', I hover on Like icon$")
  public void hoverOnLikeIcon(String comment) {
    spaceHomeSteps.hoverOnLikeIcon(comment);
  }

  @When("^In comments drawer, in comment '(.*)', I hover on Like icon$")
  public void hoverOnLikeIconCommentsDrawer(String comment) {
    spaceHomeSteps.hoverOnLikeIconCommentsDrawer(comment);
  }

  @When("^In post '(.*)', I mouse over the mentioned second user$")
  public void hoverOnMentionedSecondUserInPost(String activity) {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    spaceHomeSteps.hoverOnMentionedUserInPost(activity, fullName);
  }

  @When("^In post '(.*)', I mouse over the mentioned user '(.*)'$")
  public void hoverOnMentionedUserInPost(String activity, String user) {
    spaceHomeSteps.hoverOnMentionedUserInPost(activity, user);
  }

  @Then("^The internal link '(.*)' is opened in new tab$")
  public void internalLinkIsOpenedNewTab(String link) {
    spaceHomeSteps.linkIsOpenedNewTab(link);
  }

  @Then("^The activity '(.*)' posted by the second user in the created space is displayed with its timestamp in activity stream$")
  @And("^The activity '(.*)' posted by the second user in the created space is displayed with its timestamp in streams page$")
  public void isActivityNamePostedBySecondUserSpaceDisplayed(String activity) {
    String user = Serenity.sessionVariableCalled("secondUserName");
    String space = Serenity.sessionVariableCalled("randomSpaceName");

    spaceHomeSteps.isActivityNameUserSpaceDisplayed(activity, user, space);
  }

  @Then("^The activity '(.*)' posted by the user '(.*)' in space '(.*)' is displayed with its timestamp in activity stream$")
  @And("^The activity '(.*)' posted by the user '(.*)' in space '(.*)' is displayed with its timestamp in streams page$")
  public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
    spaceHomeSteps.isActivityNameUserSpaceDisplayed(activity, user, space);
  }

  @When("^In post '(.*)', the mentioned second user is displayed$")
  public void isMentionedSecondUserDisplayedInPost(String activity) {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    spaceHomeSteps.isMentionedUserDisplayedInPost(activity, fullName);
  }

  @When("^In post '(.*)', the mentioned user '(.*)' is displayed$")
  public void isMentionedUserDisplayedInPost(String activity, String user) {
    spaceHomeSteps.isMentionedUserDisplayedInPost(activity, user);
  }

  @Then("User Popover of the second user is displayed")
  public void isSecondUserPopoverDisplayed() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    spaceHomeSteps.isUserPopoverDisplayed(fullName);
  }

  @Then("^User Popover '(.*)' is displayed$")
  public void isUserPopoverDisplayed(String user) {
    spaceHomeSteps.isUserPopoverDisplayed(user);
  }

  @Then("^In comment '(.*)', Kudos label should be black$")
  public void kudosLabelIsBlack(String comment) {
    spaceHomeSteps.kudosLabelIsBlack(comment);
  }

  @Then("^In comment '(.*)', Kudos label should be blue$")
  public void kudosLabelIsBlue(String comment) {
    spaceHomeSteps.kudosLabelIsBlue(comment);
  }

  @When("^I like the activity '(.*)'$")
  public void likeActivity(String activity) {
    spaceHomeSteps.likeActivity(activity);
  }

  @When("^I like the activity comment '(.*)'$")
  public void likeActivityComment(String activityComment) {
    spaceHomeSteps.likeActivityComment(activityComment);
  }

  @When("^In comments drawer, Like label in comment '(.*)' should be black$")
  public void likeLabelInCommentsDrawerIsBlack(String comment) {
    spaceHomeSteps.likeLabelInCommentsDrawerIsBlack(comment);
  }

  @When("^In comments drawer, Like label in comment '(.*)' should be blue$")
  public void likeLabelInCommentsDrawerIsBlue(String comment) {
    spaceHomeSteps.likeLabelInCommentsDrawerIsBlue(comment);
  }

  @When("^In comment '(.*)', Like label should be black$")
  public void likeLabelIsBlack(String comment) {
    spaceHomeSteps.likeLabelIsBlack(comment);
  }

  @When("^In comment '(.*)', Like label should be blue$")
  public void likeLabelIsBlue(String comment) {
    spaceHomeSteps.likeLabelIsBlue(comment);
  }

  @Then("^Link '(.*)' is opened in new tab$")
  public void linkIsOpenedNewTab(String link) {
    spaceHomeSteps.linkIsOpenedNewTab(link);
  }

  @When("^No comments displayed in the drawer$")
  public void noCommentDisplayedInDrawer() {
    spaceHomeSteps.noCommentDisplayedInDrawer();
  }

  @Then("^The link preview '(.*)' is displayed in activity stream$")
  public void normalLinkPreviewIsVisible(String link) {
    spaceHomeSteps.normalLinkPreviewIsVisible(link);
  }

  @When("^I open in activity '(.*)' the Comments drawer$")
  public void openCommentsDrawer(String activity) {
    spaceHomePage.getActivityId(activity);
    spaceHomePage.openCommentsDrawer(spaceHomePage.getActivityId(activity));
  }

  @When("^I click to delete from the dropdownActivitymenu$")
  public void openDeleteActivityMenu() {
    String oldActiviyy = Serenity.sessionVariableCalled("activity");
    spaceHomeSteps.openDeleteActivityMenu(oldActiviyy);
  }

  @When("^In activity '(.*)' I delete the comment '(.*)'$")
  public void openDeleteCommentMenu(String activity, String comment) {
    spaceHomeSteps.openDeleteCommentMenu(activity, comment);
  }

  @When("^I click on modify the activity$")
  public void openEditActivityMenu() {
    String oldActiviyy = Serenity.sessionVariableCalled("activity");
    spaceHomeSteps.openEditActivityMenu(oldActiviyy);
  }

  @When("^I click on modify the activity '(.*)'$")
  public void openEditSpecificActivityMenu(String activiyy) {
    spaceHomeSteps.openEditActivityMenu(activiyy);
  }

  @Then("^I open the internal link '(.*)' in new tab$")
  public void openInternalLinkInNewTab(String link) {
    String currentUrl = spaceHomePage.getCurrentUrl().split("portal")[0];
    spaceHomeSteps.openLinkInNewTab(currentUrl + link);
  }

  @Then("^I open link '(.*)' in new tab$")
  public void openLinkInNewTab(String link) {
    spaceHomeSteps.openLinkInNewTab(link);
  }

  @When("^I click on three dots button related to activity '(.*)'$")
  public void openThreeDotsActivityMenu(String activity) {
    spaceHomeSteps.openThreeDotsActivityMenu(activity);
  }

  @When("^Create Poll Button is Enabled$")
  public void pollButton() {
    spaceHomeSteps.pollButton();
  }

  @When("^I post '(.*)' activities with prefix '(.*)'$")
  public void postManyActivities(String activityNumber, String activityPrefix) {
    spaceHomeSteps.postManyActivities(activityNumber, activityPrefix);
  }

  @When("^I post '(.*)' activities$")
  public void postThirtyActivities(String activityNumber) {
    spaceHomeSteps.postThirtyActivities(activityNumber);
  }

  @When("^I promote '(.*)' random user as a space manager$")
  public void promoteRandomUserAsSpaceManager(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    spaceHomeSteps.promoteSpaceMemberAsManager(userLastName);
  }

  @When("^I promote '(.*)' as a space manager$")
  public void promoteSpaceMemberAsManager(String name) {
    spaceHomeSteps.promoteSpaceMemberAsManager(name);
  }

  @When("^I publish the activity$")
  @And("^I publish the Poll$")
  public void publishActivity() {
    spaceHomeSteps.publishActicity();
  }

  @When("^I publish the activity stream in arabic language$")
  public void publishActivityInArabicLanguage() {
    spaceHomeSteps.publishActivityInArabicLanguage();
  }

  @When("^I publish the comment$")
  public void publishComment() {
    spaceHomeSteps.publishComment();
  }

  @When("^(.*) User is mentioned in the comment$")
  public void randomUserIsMentionedInCommentEntered(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix.toLowerCase() + "UserFirstName");
    String userLastName = Serenity.sessionVariableCalled(userPrefix.toLowerCase() + "UserLastName");
    String fullName = userFirstName + " " + userLastName;
    spaceHomeSteps.userIsMentionedInCommentEntered(fullName);
  }

  @When("^(.*) User is not mentioned in the comment$")
  public void randomUserIsNotMentionedInCommentEntered(String userPrefix) {
    String userFirstName = Serenity.sessionVariableCalled(userPrefix.toLowerCase() + "UserFirstName");
    String userLastName = Serenity.sessionVariableCalled(userPrefix.toLowerCase() + "UserLastName");
    String fullName = userFirstName + " " + userLastName;
    spaceHomeSteps.userIsNotMentionedInCommentEntered(fullName);
  }

  @Then("^'(.*)' kudos are displayed on the reaction drawer$")
  public void receivedKudosOnDrawerIsDisplayed(String kudosNumber) {
    spaceHomeSteps.receivedKudosDrawerIsDisplayed(kudosNumber);
  }

  @And("^I click on Yes button$")
  public void removeactivity() {
    spaceHomeSteps.deleteactivity();
  }

  @When("^The reply '(.*)' is not displayed in the drawer$")
  public void replyInDrawerIsNotDisplayed(String reply) {
    spaceHomeSteps.replyInDrawerIsNotDisplayed(reply);
  }

  @When("^In comment '(.*)', the reply '(.*)' is displayed in the drawer$")
  public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
    spaceHomeSteps.replyIsDisplayedInCommentsDrawer(comment, reply);
  }

  @When("^In comment '(.*)', the reply '(.*)' is not displayed in the drawer$")
  public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
    spaceHomeSteps.replyIsNotDisplayedInCommentsDrawer(comment, reply);
  }

  @Then("^In reply '(.*)', Kudos label should be black$")
  public void replyKudosLabelIsBlack(String comment) {
    spaceHomeSteps.replyKudosLabelIsBlack(comment);
  }

  @Then("^In reply '(.*)', Kudos label should be blue$")
  public void replyKudosLabelIsBlue(String comment) {
    spaceHomeSteps.replykudosLabelIsBlue(comment);
  }

  @When("^Tooltip Like on '(.*)' is displayed in activity stream$")
  @And("^Tooltip Remove Like on '(.*)' is displayed in activity stream$")
  public void tooltipActivityStreamIsDisplayed(String comment) {
    spaceHomeSteps.tooltipActivityStreamIsDisplayed(comment);
  }

  @When("^Tooltip Like on '(.*)' is displayed in comments drawer$")
  @And("^Tooltip Remove Like on '(.*)' is displayed in comments drawer$")
  public void tooltipCommentsDrawerIsDisplayed(String comment) {
    spaceHomeSteps.tooltipCommentsDrawerIsDisplayed(comment);
  }

  @When("^I click on update comment$")
  public void updateComment() {
    spaceHomeSteps.updateComment();
  }

  @When("^I update comment with a new one '(.*)'$")
  public void updateCommentText(String comment) {
    spaceHomeSteps.updateCommentText(comment);
  }

  @Then("^I click on View All replies related to the comment '(.*)' in activity stream$")
  public void viewAllRepliesInActivityStream(String comment) {
    spaceHomeSteps.viewAllRepliesInActivityStream(comment);
  }

  @Then("^I click on View All replies related to the comment '(.*)'$")
  public void viewAllRepliesInCommentsDrawer(String comment) {
    spaceHomeSteps.viewAllRepliesInCommentsDrawer(comment);
  }

}
