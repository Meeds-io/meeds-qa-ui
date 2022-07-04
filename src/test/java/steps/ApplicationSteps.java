package steps;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.page.factory.application.ApplicationPage;

import static org.aspectj.bridge.MessageUtil.info;
import static pages.page.factory.application.ApplicationPage.*;

public class ApplicationSteps {

    private ApplicationPage applicationPage;

    public void clickStarIconAgenda() {
        applicationPage.clickFavoriteAgenda();
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    }

    public List<String> isAppDisplayedInFavoriteList(List<String> listOfApp) {
        List<String> missingValues = new ArrayList<>();
        for (String appName : listOfApp) {
            if (!applicationPage.isAppDisplayedInFavoriteList(appName))
                missingValues.add(appName);
        }
        return missingValues;
    }

    public List<String> isAppNotDisplayedInFavoriteList(List<String> listOfApp) {
        List<String> missingValues = new ArrayList<>();
        for (String appName : listOfApp) {
            if (!applicationPage.isAppNotDisplayedInFavoriteList(appName))
                missingValues.add(appName);
        }
        return missingValues;
    }

    public boolean isApplicationVisible(String applicationName) {
        return applicationPage.isApplicationVisible(applicationName);
    }

    public boolean isWalletPageOpened() {
        return applicationPage.isWalletPageOpened();
    }

    public void clickOnTheAppLauncherIcon() {
        ELEMENT_TRIBE_APPLICATIONS_TOPBAR.waitUntilVisible();
        ELEMENT_TRIBE_APPLICATIONS_TOPBAR.clickOnElement();
    }

    public void IsProcessesApplicationDisplayed() {
        Assert.assertTrue(ELEMENT_TRIBE_APPCENTER_PROCESSES.isDisplayed());
    }

    public void goToProcessesAppCenterApplication() {
        ELEMENT_TRIBE_APPCENTER_PROCESSES.clickOnElement();
    }

    public void isProcessesPageOpened() {
        Assert.assertTrue(ELEMENT_PROCESSES_APPLICATION_PAGE.isVisibleAfterWaiting());
    }

    public void goToAgendaAppCenterApplication() {
        info("Click on App Center Agenda Application Button");
        ELEMENT_TRIBE_APPCENTER_AGENDA.clickOnElement();

    }

    public boolean isDrivesPageOpened() {

        return ELEMENT_DRIVES_APPLICATION_PAGE.isVisibleAfterWaiting();
    }

    public boolean isAgendaPageOpened() {
        info("Agenda Application Page is displayed");
        return ELEMENT_AGENDA_APPLICATION_PAGE.isVisibleAfterWaiting();

    }

    public void selectFolder(String folderType) {
        applicationPage.selectFolder(folderType);
    }

    public boolean isNotesPageOpened() {

        return ELEMENT_NOTES_APPLICATION_PAGE.isVisibleAfterWaiting();
    }

    public void uploadedFileNameIsDisplayed(String uploadedFileName) {
        applicationPage.uploadedFileNameIsDisplayed(uploadedFileName);
    }

    public void settingsPageIsOpened() {
        applicationPage.settingsPageIsOpened();
    }

    public void uploadedFileNameIsNotDisplayed(String uploadedFileName) {
        applicationPage.uploadedFileNameIsNotDisplayed(uploadedFileName);
    }

    public void uploadedFileLabelIsDisplayed(String uploadedFileExtension) {
        applicationPage.uploadedFileLabelIsDisplayed(uploadedFileExtension);
    }

    public void deleteFileInDrives(String uploadedFileName) {
        applicationPage.deleteFileInDrives(uploadedFileName);
    }

    public void uploadedFileVersionIsDisplayed(String fileVersion) {
        applicationPage.uploadedFileVersionIsDisplayed(fileVersion);
    }

    public void uploadedFileMessageIsDisplayed(String fileMessage) {
        applicationPage.uploadedFileMessageIsDisplayed(fileMessage);
    }

    public void goToTasksAppCenterApplication() {

        info("Click on App Center Tasks Application Button");
        ELEMENT_TRIBE_APPCENTER_TASKS.clickOnElement();

    }

    public boolean isTasksPageOpened() {
        info("Tasks Application Page is displayed");
        return ELEMENT_TASKS_APPLICATION_PAGE.isVisibleAfterWaiting();

    }

    public void goToNewsAppCenterApplication() {
        info("Click on App Center News Application Button");
        ELEMENT_TRIBE_APPCENTER_NEWS.clickOnElement();

    }

    public boolean isNewsPageOpened() {
        info("News Application Page is displayed");
        return ELEMENT_NEWS_APPLICATION_PAGE.isVisibleAfterWaiting();

    }

    public void openNewsFilterDrawer() {
        applicationPage.openNewsFilterDrawer();
    }

    public void tickTheSearchedSpaceInNewsFilterDrawer(String spaceName) {
        applicationPage.tickTheSearchedSpaceInNewsFilterDrawer(spaceName);

    }

    public void resetNewsFilterDrawer() {
        applicationPage.resetNewsFilterDrawer();

    }

    public boolean checkThatSpaceIsNotSelectedInNewsFilterDrawer(String spaceName) {
        boolean isSpaceNameSelected = applicationPage.tickNewsFeedFilterSpaceName(spaceName).isSelected();
        return isSpaceNameSelected;
    }

    public void closeNewsFilterDrawer() {
        applicationPage.closeNewsFilterDrawer();
    }

    public void checkThatApplyBtnInFilterNewsDrawerIsDisabled() {
        applicationPage.checkThatApplyBtnInFilterNewsDrawerIsDisabled();
    }

    public void newsFilterDrawerClosed() {
        applicationPage.newsFilterDrawerClosed();
    }

    public void checkThatResetBtnInFilterNewsDrawerIsDisplayed() {
        applicationPage.checkThatResetBtnInFilterNewsDrawerIsDisplayed();
    }

    public void closeFilterBySpaces() {
        applicationPage.closeFilterBySpaces();

    }

    public void checkThatFilterIsApplied() {
        applicationPage.checkThatFilterIsApplied();
    }

    public void checkThatNewsArticleIsDisplayedInNewsFeedPage(String articleTitle, String articleSummary) {
        applicationPage.checkThatNewsArticleIsDisplayedInNewsFeedPage(articleTitle, articleSummary);
    }

    public void clickNewsArticleInNewsFeedPage(String articleTitle, String articleSummary) {
        applicationPage.clickNewsArticleInNewsFeedPage(articleTitle, articleSummary);
    }

    public void checkThatNewsArticleIsNotDisplayedInNewsFeedPage(String articleTitle, String articleSummary) {
        applicationPage.checkThatNewsArticleIsNotDisplayedInNewsFeedPage(articleTitle, articleSummary);
    }

    public void checkThatNewsArticleIsDisplayedInLatestNews(String articleTitle) {
        applicationPage.checkThatNewsArticleIsDisplayedInLatestNews(articleTitle);
    }

    public void checkThatNewsArticleIsDisplayedInSliderNews(String articleTitle) {
        applicationPage.checkThatNewsArticleIsDisplayedInSliderNews(articleTitle);
    }

    public void goToWalletAppCenterApplication() {
        info("Click on App Center Wallet Application Button");
        ELEMENT_TRIBE_APPCENTER_WALLET.clickOnElement();

    }

    public void goToPerkStoreAppCenterApplication() {
        info("Click on App Center Perk Store Application Button");
        ELEMENT_TRIBE_APPCENTER_PERK_STORE.clickOnElement();

    }

    public boolean isPerkStorePageOpened() {
        info("Perk Store Application Page is displayed");
        return ELEMENT_PERK_STORE_APPLICATION_PAGE.isVisibleAfterWaiting();

    }

    public void goToSendFeedbackAppCenterApplication() {
        info("Click on Send Feedback Perk Store Application Button");
        ELEMENT_TRIBE_APPCENTER_SEND_FEEDBACK.clickOnElement();

    }

    public boolean isSendFeedbackPageOpened() {
        info("Send Feedback Application Page is displayed");
        return ELEMENT_SEND_FEEDBACK_APPLICATION_PAGE.isVisibleAfterWaiting();

    }

    public void seeAllApplications() {

        info("Click on App Center News Application Button");
        ELEMENT_TRIBE_APPLICATIONS_TOPBAR.waitUntilClickable();
        ELEMENT_TRIBE_APPLICATIONS_TOPBAR.clickOnElement();

        ELEMENT_TRIBE_APPCENTER_SEE_ALL_APPLICATIONS.waitUntilVisible();
        ELEMENT_TRIBE_APPCENTER_SEE_ALL_APPLICATIONS.clickOnElement();
    }

    public void starButtonIsNotSelected(String appTitle) {

        applicationPage.starButtonIsNotSelected(appTitle);
    }

    public void starButtonIsSelected(String appTitle) {

        applicationPage.starButtonIsSelected(appTitle);
    }

    public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {

        applicationPage.checkThatAddApplicationBtnToFavoritesIsDisplayed(app);
    }

    public boolean isAllApplicationsPageDisplayed() {

        info("All Applications Page is displayed");
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        return ELEMENT_TRIBE_APPCENTER_ALL_APPLICATIONS_PAGE.isVisibleAfterWaiting();
    }

    public void addRemoveApplicationToFavorites(String app) {

        applicationPage.addRemoveApplicationToFavorites(app);
    }

    public void closeAppCenterDrawer() {

        applicationPage.ELEMENT_CLOSE_APPCENTER_DRAWER.clickOnElement();
    }

    public void checkThatAppcenterApplicationIsDisplayed(String app) {

        applicationPage.checkThatAppcenterApplicationIsDisplayed(app);
    }

    public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {

        applicationPage.checkThatApplicationIsDisplayedInFavoriteApps(app);
    }

    public void maxFavoriteAppsIsDisplayed() {

        applicationPage.maxFavoriteAppsIsDisplayed();
    }

    public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {

        applicationPage.checkThatApplicationIsNotDisplayedInFavoriteApps(app);
    }

    public void checkThatAppcenterApplicationIsNotDisplayed(String app) {

        applicationPage.checkThatAppcenterApplicationIsNotDisplayed(app);
    }

    public void goToTheAppcenterApplicationPage(String app) {

        applicationPage.goToTheAppcenterApplicationPage(app);
    }

    public boolean isForumsPageOpened() {

        return applicationPage.isForumsPageOpened();
    }

    public void checkThatOpenApplicationButtonIsDisplayed(String app) {

        applicationPage.checkThatOpenApplicationButtonIsDisplayed(app);
    }

    public void clickOnOpenApplicationButton(String app) {

        applicationPage.clickOnOpenApplicationButton(app);
    }

    public void goToApplication(String applicationName) {
        applicationPage.goToApplication(applicationName);
    }

    public void goToChallengeApplication() {
        applicationPage.goToChallengeApplication();
    }

    public boolean isChallengePageOpened() {
        info("Challenges Application Page is displayed");
        return elementChallengeApplicationPage.isVisibleAfterWaiting();
    }
}
