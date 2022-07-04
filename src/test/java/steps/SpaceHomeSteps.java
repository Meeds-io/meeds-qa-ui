package steps;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.page.factory.space.SpaceHomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static steps.GenericSteps.switchToTabByIndex;

public class SpaceHomeSteps {

    private SpaceHomePage spaceHomePage;
    public void clickPostIcon() {
        spaceHomePage.clickPostIcon();
    }

    public void postThirtyActivities(String activityNumber) {
        for (int i = 0; i < Integer.parseInt(activityNumber) + 1; i++) {
            String activity = "act" + i;
            spaceHomePage.clickPostIcon();
            spaceHomePage.addActivity(activity);
            spaceHomePage.publishActivity();
        }
    }

    public void clickCloseActivityDrawerbutton() {
        spaceHomePage.clickCloseActivityDrawerbutton();
    }

    public boolean isWriteArticleLinkDisplayed() {
        return spaceHomePage.isWriteAnArticleLinkDisplayed();
    }

    public void clickWriteArticle() {
        spaceHomePage.clickWriteArticle();
    }

    public void clickCreatePoll() {
        spaceHomePage.clickCreatePoll();
    }

    public void createPoll(String pollTitle, String choiceOne, String choiceTow) {
        spaceHomePage.createPoll(pollTitle, choiceOne, choiceTow);
    }

    public void createPollWithOneChoice(String pollTitle, String choiceOne) {
        spaceHomePage.createPollWithOneChoice(pollTitle, choiceOne);
    }

    public void createPollButton() {
        spaceHomePage.createPollButton();
    }

    public void addOptionTwoInThePoll(String choiceTow) {
        spaceHomePage.addOptionTwoInThePoll(choiceTow);
    }

    public void pollButton() {
        spaceHomePage.pollButton();
    }

    public void addOptionThreeInThePoll(String choiceThree) {
        spaceHomePage.addOptionThreeInThePoll(choiceThree);
    }

    public void addDescriptionLess1000CharsInThePoll(String choiceThree) {
        spaceHomePage.addDescriptionLess1000CharsInThePoll(choiceThree);
    }

    public void clickCreatePollButton() {
        spaceHomePage.clickCreatePollButton();
    }

    public void editPoll(String pollTitle, String choiceOne, String choiceTow) {
        spaceHomePage.createPoll(pollTitle, choiceOne, choiceTow);
    }
    public void createPollDrawerClosed() { spaceHomePage.createPollDrawerClosed(); }

    public void clickwriteArticleLinkSimpleUser() {
        spaceHomePage.clickwriteArticleLinkSimpleUser();
    }

    public List<String> checkArticleDetails() {
        Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        List<String> missingValues = new ArrayList<>();
        for (String fieldsName : expectedArticle.keySet()) {
            if (!spaceHomePage.getFieldContent(fieldsName).equals(expectedArticle.get(fieldsName)))
                missingValues.add(fieldsName);
        }
        return missingValues;
    }

    public void clickArticleTitle() {
        Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
        String articleTitle = expectedArticle.get("Titre");
        spaceHomePage.clickArticleTitle(articleTitle);
    }

    public void archivedArticleNotClickableInActivityStream(String summary, String title) {
        spaceHomePage.archivedArticleNotClickableInActivityStream(summary, title);
    }

    public void clickReadMore() {
        Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
        String articleTitle = expectedArticle.get("Titre");
        spaceHomePage.clickReadMore(articleTitle);
    }

    public List<String> checkUpdatedArticleDetails() {
        Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedUpdatedArticleValues");
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        List<String> missingValues = new ArrayList<>();
        for (String fieldsName : expectedArticle.keySet()) {
            if (!spaceHomePage.getFieldContent(fieldsName).equals(expectedArticle.get(fieldsName)))
                missingValues.add(fieldsName);
        }
        return missingValues;
    }

    public void addActivity(String activity) {
        spaceHomePage.addActivity(activity);
    }

    public void publishActicity() {
        spaceHomePage.publishActivity();
    }

    public void editActivity() {
        spaceHomePage.editActivity();
    }

    public void clickOnLoadMoreActivities() {
        spaceHomePage.clickOnLoadMoreActivities();
    }

    public void enterActivityText(String activity) {
        spaceHomePage.enterActivityText(activity);
    }

    public boolean isActivityVisible(String activity) {
        return spaceHomePage.isActivityVisible(activity);
    }

    public void enterActivityCommentWithUser(String comment, String user) {
        spaceHomePage.enterActivityCommentWithUser(comment, user);
    }

    public void publishActivityInArabicLanguage() {
        spaceHomePage.publishActivityInArabicLanguage();
    }

    public void enterCommentText(String comment) {
        spaceHomePage.enterCommentText(comment);
    }

    public void updateCommentText(String comment) {
        spaceHomePage.updateCommentText(comment);
    }

    public void publishComment() {
        spaceHomePage.publishComment();
    }

    public void updateComment() {
        spaceHomePage.updateComment();
    }

    public void userIsMentionedInCommentEntered(String user) {
        spaceHomePage.userIsMentionedInCommentEntered(user);
    }

    public void userIsNotMentionedInCommentEntered(String user) {
        spaceHomePage.userIsNotMentionedInCommentEntered(user);
    }

    public void isActivityNameUserSpaceDisplayed(String activity, String user, String space) {
        spaceHomePage.isActivityNameUserSpaceDisplayed(activity, user, space);
    }

    public void hoverOnLikeIcon(String comment) {
        spaceHomePage.hoverOnLikeIcon(comment);
    }

    public void hoverOnMentionedUserInPost(String activity, String user) {
        spaceHomePage.hoverOnMentionedUserInPost(activity, user);
    }

    public void tooltipActivityStreamIsDisplayed(String comment) {
        spaceHomePage.tooltipActivityStreamIsDisplayed(comment);
    }

    public void tooltipCommentsDrawerIsDisplayed(String comment) {
        spaceHomePage.tooltipCommentsDrawerIsDisplayed(comment);
    }

    public void hoverOnLikeIconCommentsDrawer(String comment) {
        spaceHomePage.hoverOnLikeIconCommentsDrawer(comment);
    }

    public void clickOnTheUserPopover(String user) {
        spaceHomePage.clickOnTheUserPopover(user);
    }

    public void isMentionedUserDisplayedInPost(String activity, String user) {
        spaceHomePage.isMentionedUserDisplayedInPost(activity, user);
    }

    public void isUserPopoverDisplayed(String user) {
        spaceHomePage.isUserPopoverDisplayed(user);
    }

    public boolean isSwitchToArticleLinkDisplayed() {
        return spaceHomePage.isSwitchToArticleLinkDisplayed();
    }

    public void closeWriteMessageDrawer() {
        spaceHomePage.closeWriteMessageDrawer();
    }

    public void clickSwitchToArticleLink() {
        spaceHomePage.clickSwitchToArticleLink();
    }

    public void attachFile(String fileName) {
        Serenity.setSessionVariable("fileName").to(fileName);
        spaceHomePage.attachFile(fileName);
        spaceHomePage.closeDocumentsDrawer();
    }

    public boolean isSharedVideoDisplayed(String videoLink) {
        return spaceHomePage.isSharedVideoDisplayed(videoLink);
    }

    public boolean isLinkPreviewVisible() {
        return spaceHomePage.isLinkPreviewVisible();
    }

    public boolean isSharedFileVisible(String fileName) {
        return spaceHomePage.isSharedFileVisible(fileName);
    }

    public boolean isUploadedFileNotDisplayed(String fileName) {
        return spaceHomePage.isUploadedFileNotDisplayed(fileName);
    }

    public void cancelDeleteComment() {
        spaceHomePage.cancelDeleteComment();
    }

    public boolean isSharedImageVisible(String fileName) {
        return spaceHomePage.isSharedImageVisible(fileName);
    }

    public void goToSpecificTab(String tabName) {
        spaceHomePage.goToSpecificTab(tabName);
    }

    public void deleteFileInDocumentsTab(String uploadedFileName) {
        spaceHomePage.deleteFileInDocumentsTab(uploadedFileName);
    }

    public void fileIsNotDisplayedInDocumentsTab(String uploadedFileName) {
        spaceHomePage.fileIsNotDisplayedInDocumentsTab(uploadedFileName);
    }

    public void goToSpaceMembersTab() {
        spaceHomePage.goToSpaceMembersTab();
    }

    public void selectFileExiste(String fileName) {
        spaceHomePage.selectExistFile(fileName);
        spaceHomePage.clickSelectFileButton();
        spaceHomePage.clickApplyDownload();
    }

    public void selectFromDrives() {
        spaceHomePage.selectFromDrives();
    }

    public void clickOnCurrentSpaceAsDrive() {
        spaceHomePage.clickOnCurrentSpaceAsDrive();
    }

    public void createFolderInDocumentsTab(String folderTitle) {
        spaceHomePage.createFolderInDocumentsTab(folderTitle);

    }

    public void openFolderInDocumentsTab(String folderTitle) {
        spaceHomePage.openFolderInDocumentsTab(folderTitle);
    }

    public void openEditActivityMenu(String activity) {
        spaceHomePage.openEditActivityMenu(activity);
    }

    public void editActivityButtonIsDisplayed(String activity) {
        spaceHomePage.editActivityButtonIsDisplayed(activity);
    }

    public void copyLinkActivityButtonIsDisplayed(String activity) {
        spaceHomePage.copyLinkActivityButtonIsDisplayed(activity);
    }

    public void downloadActivityButtonIsDisplayed(String activity) {
        spaceHomePage.downloadActivityButtonIsDisplayed(activity);
    }

    public void deleteActivityButtonIsDisplayed(String activity) {
        spaceHomePage.deleteActivityButtonIsDisplayed(activity);
    }

    public void openThreeDotsActivityMenu(String activity) {
        spaceHomePage.openThreeDotsActivityMenu(activity);
    }

    public void openDeleteActivityMenu(String activity) {
        spaceHomePage.openDeleteActivityMenu(activity);
    }

    public void clickSpace(String spaceName) {
        spaceHomePage.clickSpace(spaceName);
    }


    public void selectDrive(String drive, String fileName) {
        spaceHomePage.selectFileFromOtherDrive(drive, fileName);
        spaceHomePage.clickSelectFileButton();
        spaceHomePage.closeDocumentsDrawer();
    }

    public void clickSelectFromDrive() {
        spaceHomePage.clickSelectFromDrive();
    }

    public boolean isSelectFromDrivesButtonVisible() {
        return spaceHomePage.isSelectFromDrivesButtonVisible();
    }

    public void clickAddDrive() {
        spaceHomePage.clickAddDriveButton();
    }

    public void commentsDrawerlikeActivityComment(String activityComment) {
        spaceHomePage.commentsDrawerlikeActivityComment(activityComment);
    }

    public void likeActivity(String activity) {
        spaceHomePage.likeActivity(activity);
    }

    public void likeActivityComment(String activity) {
        spaceHomePage.likeActivityComment(activity);
    }

    public void displayedLikesOnComment(String comment, String number) {
        spaceHomePage.displayedLikesOnComment(comment, number);
    }

    public void likeLabelIsBlue(String comment) {
        spaceHomePage.likeLabelIsBlue(comment);
    }

    public void likeLabelIsBlack(String comment) {
        spaceHomePage.likeLabelIsBlack(comment);
    }

    public void checkActivityTitle(String activity) {
        spaceHomePage.checkActivityTitle(activity);
    }

    public void checkActivityComment(String comment) {
        spaceHomePage.checkActivityComment(comment);
    }

    public void commentsDrawerDisplayedLikesOnComment(String comment, String number) {
        spaceHomePage.commentsDrawerDisplayedLikesOnComment(comment, number);
    }

    public void linkIsOpenedNewTab(String link) {
        switchToTabByIndex(1);
        spaceHomePage.linkIsOpenedNewTab(link);
        Serenity.getWebdriverManager().getCurrentDriver().close();
        switchToTabByIndex(0);
    }

    public void clickOnActivityComment(String comment) {
        spaceHomePage.clickOnActivityComment(comment);
    }

    public void openLinkInNewTab(String link) {
        spaceHomePage.openLinkInNewTab(link);
    }

    public void checkFirstActivityComment(String comment) {
        spaceHomePage.checkFirstActivityComment(comment);
    }

    public void checkSecondActivityComment(String comment) {
        spaceHomePage.checkSecondActivityComment(comment);
    }

    public void checkPreviewFile(String file) {
        spaceHomePage.checkPreviewFile(file);
    }

    public void commentIsDisplayedInDrawer(String commentsNumber, String comment) {
        spaceHomePage.commentIsDisplayedInDrawer(commentsNumber, comment);
    }

    public void likeLabelInCommentsDrawerIsBlue(String comment) {
        spaceHomePage.likeLabelInCommentsDrawerIsBlue(comment);
    }

    public void likeLabelInCommentsDrawerIsBlack(String comment) {
        spaceHomePage.likeLabelInCommentsDrawerIsBlack(comment);
    }

    public void commentNameIsNotDisplayedInDrawer(String comment) {
        spaceHomePage.commentNameIsNotDisplayedInDrawer(comment);
    }

    public void replyIsNotDisplayedInCommentsDrawer(String comment, String reply) {
        spaceHomePage.replyIsNotDisplayedInCommentsDrawer(comment, reply);
    }

    public void replyIsDisplayedInCommentsDrawer(String comment, String reply) {
        spaceHomePage.replyIsDisplayedInCommentsDrawer(comment, reply);
    }

    public void closeCommentsDrawer() {
        spaceHomePage.closeCommentsDrawer();
    }

    public void noCommentDisplayedInDrawer() {
        spaceHomePage.noCommentDisplayedInDrawer();
    }

    public void commentIsNotDisplayedInDrawer(String commentsNumber, String comment) {
        spaceHomePage.commentIsNotDisplayedInDrawer(commentsNumber, comment);
    }

    public void replyInDrawerIsNotDisplayed(String reply) {
        spaceHomePage.replyInDrawerIsNotDisplayed(reply);
    }

    public void selectFolder() {
        spaceHomePage.selectFolder();
    }

    public void connectYourServiceDrawerGoogleDriveButtonIsDisplayed() {
        spaceHomePage.connectYourServiceDrawerGoogleDriveButtonIsDisplayed();
    }

    public void normalLinkPreviewIsVisible(String link) {
        spaceHomePage.normalLinkPreviewIsVisible(link);
    }

    public void checkActivityCommentNotDisplayed(String activity, String comment) {
        spaceHomePage.checkActivityCommentNotDisplayed(activity, comment);
    }

    public void checkCommentReplyNotDisplayed(String activity, String comment, String reply) {
        spaceHomePage.checkCommentReplyNotDisplayed(activity, comment, reply);
    }

    public void clickOnReplyDropDownMenu(String activity, String comment, String reply) {
        spaceHomePage.clickOnReplyDropDownMenu(activity, comment, reply);
    }

    public void checkCommentReplyDisplayed(String activity, String comment, String reply) {
        spaceHomePage.checkCommentReplyDisplayed(activity, comment, reply);
    }

    public void clickOnViewallXcomments() {
        spaceHomePage.clickOnViewallXcomments();
    }

    public void checkPreviewFileExtension(String fileExtension) {
        spaceHomePage.checkPreviewFileExtension(fileExtension);
    }

    public void checkActivityCommentInDrawer(String comment) {
        spaceHomePage.checkActivityCommentInDrawer(comment);
    }

    public void connectYourServiceDrawerOneDriveButtonIsDisplayed() {
        spaceHomePage.connectYourServiceDrawerOneDriveButtonIsDisplayed();
    }

    public void createFolder(String folderTitle) {
        spaceHomePage.createFolder(folderTitle);
    }

    public void checkThatDeleteAndEditFolderButtonsAreDisplayed() {
        spaceHomePage.checkThatDeleteAndEditFolderButtonsAreDisplayed();
    }

    public void deleteReply(String reply) {
        spaceHomePage.deleteReply(reply);
    }

    public void checkThatCreatedFolderIsDisplayed() {
        spaceHomePage.checkThatCreatedFolderIsDisplayed();
    }

    public void deleteFolder() {
        spaceHomePage.deleteFolder();
    }

    public void promoteSpaceMemberAsManager(String name) {
        spaceHomePage.promoteSpaceMemberAsManager(name);
    }

    public void deleteComment(String comment) {
        spaceHomePage.deleteComment(comment);
    }

    public void editComment(String comment) {
        spaceHomePage.editComment(comment);
    }

    public void editCommentFromCommentsDrawer(String comment) {
        spaceHomePage.editCommentFromCommentsDrawer(comment);
    }

    public void checkThatFolderIsDeleted(String folderName) {
        spaceHomePage.checkThatFolderIsDeleted(folderName);
    }

    public void deleteactivity() {
        spaceHomePage.clickYesbutton();
    }

    public boolean isconfirmationpopupNotdisplayed() {
        return spaceHomePage.isconfirmationpopupNotdisplayed();
    }

    public void clickDeleteActivityButton(String activity) {
        spaceHomePage.clickDeleteActivityButton(activity);
    }

    public boolean isActivityBlockNotdisplayed() {
        return spaceHomePage.isActivityBlockNotdisplayed();
    }

    public void openDeleteCommentMenu(String activity, String comment) {
        spaceHomePage.openDeleteCommentMenu(activity, comment);
    }

    public void checkFirstCommentInDrawer(String comment) {
        spaceHomePage.checkFirstCommentInDrawer(comment);
    }

    public void checkSecondCommentInDrawer(String comment) {
        spaceHomePage.checkSecondCommentInDrawer(comment);
    }

    public void checkThirdCommentInDrawer(String comment) {
        spaceHomePage.checkThirdCommentInDrawer(comment);
    }

    public void clickOnCommentsDrawerSecondPage() {
        spaceHomePage.clickOnCommentsDrawerSecondPage();
    }

    public void clickOnCommentsDrawerFirstPage() {
        spaceHomePage.clickOnCommentsDrawerFirstPage();
    }


    public void checkFourCommentIsDisplayedInDrawer() {
        spaceHomePage.checkFourCommentIsDisplayedInDrawer();
    }

    public void checkTenCommentIsDisplayedInDrawer() {
        spaceHomePage.checkTenCommentIsDisplayedInDrawer();
    }

    public void checkFourthCommentInDrawer(String comment) {
        spaceHomePage.checkFourthCommentInDrawer(comment);
    }

    public void viewAllRepliesInCommentsDrawer(String comment) {
        spaceHomePage.viewAllRepliesInCommentsDrawer(comment);
    }

    public void checkSixthPositionInDrawer(String comment) {
        spaceHomePage.checkSixthPositionInDrawer(comment);
    }

    public void clickOnCommentThreeDotsButton(String activity, String comment) {
        spaceHomePage.clickOnCommentThreeDotsButton(activity, comment);
    }

    public void viewAllRepliesInActivityStream(String comment) {
        spaceHomePage.viewAllRepliesInActivityStream(comment);
    }

    public void clickOnCommentThreeDotsInCommentsDrawer(String comment) {
        spaceHomePage.clickOnCommentThreeDotsInCommentsDrawer(comment);
    }

    public boolean isActivityCommentNotdisplayed() {
        return spaceHomePage.isActivityCommentNotdisplayed();
    }

    public void checkThatFolderIsDisplayed(String folderName) {
        spaceHomePage.checkThatFolderIsDisplayed(folderName);
    }

    public void accessNotesApp() {
        spaceHomePage.clickOnNotesTab();
    }

    public void checkShareArticleButtonStream() {
        spaceHomePage.checkShareArticleButtonStream();
    }

    public void postManyActivities(String activityNumber) {
        for (int i = 0; i < Integer.parseInt(activityNumber) + 1; i++) {
            String activity = "activity" + i;
            spaceHomePage.clickPostIcon();
            spaceHomePage.addActivity(activity);
            spaceHomePage.publishActivity();
        }
    }

    public void clickKudosFromComment() {
        spaceHomePage.clickOnkudosButtonToCommentActivity();
    }

    public void clickKudosFromCommentsDrawer() {
        spaceHomePage.clickOnkudosButtonFromCommentsDrawerToCommentActivity();
    }

    public void clickOnCommentThreeDotsButtonFromCommentsDrawer(String comment) {
        spaceHomePage.clickOnCommentThreeDotsButtonFromCommentsDrawer(comment);
    }

    public void kudosLabelIsBlue(String comment) {
        spaceHomePage.kudosLabelIsBlue(comment);
    }

    public void kudosLabelIsBlack(String comment) {
        spaceHomePage.kudosLabelIsBlack(comment);
    }

    public void clickOnKudosNumberButton() {
        spaceHomePage.clickOnKudosButtonNumberToCommentActivity();
    }

    public void clickOnKudosNumberButtonFromTheCommentsDrawer() {
        spaceHomePage.clickOnKudosButtonNumberFromCommentsDrawerToCommentActivity();
    }

    public void receivedKudosDrawerIsDisplayed(String kudosNumber) {
        spaceHomePage.getReceivedKudosSectionIsDisplayed(kudosNumber);
    }

    public void accessNewsDetails(String articleName) {
        spaceHomePage.accessNewsDetails(articleName);
    }

    public void ReplaykudosLabelIsBlue(String comment) { spaceHomePage.ReplaykudosLabelIsBlue(comment); }

    public void ReplaykudosLabelIsBlack(String comment) { spaceHomePage.ReplaykudosLabelIsBlack(comment); }

    public void clickOnReplyKudos(String reply) { spaceHomePage.clickOnReplyKudos(reply); }

    public void clickKudosFromActivityStream() { spaceHomePage.clickOnkudosButtonToActivityStream(); }

    public void checkArticleSharedInSpace(String description) { spaceHomePage.checkArticleSharedInSpace(description); }

    public void goToSpaceTasksTab() { spaceHomePage.goToSpaceTasksTab(); }
}

