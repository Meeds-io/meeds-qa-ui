package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import steps.ApplicationSteps;

public class ApplicationStepDefinition {
    @Steps
    private ApplicationSteps applicationSteps;

    @When("^I click on agenda star icon$")
    public void clickStarIconAgenda() {
        applicationSteps.clickStarIconAgenda();
    }

    @Then("^The application below are displayed in favorite list$")
    public void isAppDisplayedInFavoriteList(List<String> listOfApp) {
        assertThat(applicationSteps.isAppDisplayedInFavoriteList(listOfApp))
                .as(String.format("The app %s is not displayed in favorite list",
                        applicationSteps.isAppDisplayedInFavoriteList(listOfApp)))
                .isEmpty();
    }

    @Then("^The application below are not displayed in favorite list$")
    public void isAppNotDisplayedInFavoriteList(List<String> listOfApp) {
        assertThat(applicationSteps.isAppNotDisplayedInFavoriteList(listOfApp))
                .as(String.format("The app %s is displayed in favorite list",
                        applicationSteps.isAppNotDisplayedInFavoriteList(listOfApp)))
                .isEmpty();
    }

    @Then("The application '(.*)' is displayed in application list")
    public void checkApplicationVisible(String appName) {
        assertThat(applicationSteps.isApplicationVisible(appName)).as("The active application is not displayed")
                .isTrue();
    }

    @Then("The random application is displayed in application list")
    public void checkRandomApplicationVisible() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        assertThat(applicationSteps.isApplicationVisible(randomApplicationTitle)).as("The active application is not displayed")
                .isTrue();
    }

    @Then("The random application is not displayed in application list")
    public void checkRandomApplicationNotVisible() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        assertThat(applicationSteps.isApplicationVisible(randomApplicationTitle)).as("The disabled application is displayed")
                .isFalse();
    }

    @Then("The application '(.*)' is not displayed in application list")
    public void checkApplicationNotVisible(String appName) {
        assertThat(applicationSteps.isApplicationVisible(appName)).as("The disabled application is displayed")
                .isFalse();
    }

    @Then("^I go To AppCenter Drawer$")
    public void clickOnTheAppLauncherIcon() {
        applicationSteps.clickOnTheAppLauncherIcon();
    }

    @When("^Processes Application is displayed$")
    public void IsProcessesApplicationDisplayed() {
        applicationSteps.IsProcessesApplicationDisplayed();
    }

    @When("^I go to Processes Application$")
    public void goToProcessesAppCenterApplication() {
        applicationSteps.goToProcessesAppCenterApplication();
    }

    @Then("^Processes Application Page is displayed$")
    public void isProcessesPageOpened() {
        applicationSteps.isProcessesPageOpened();
    }

    @Then("^Wallet Application Page is displayed$")
    public void isWalletPageOpened() {
        applicationSteps.isWalletPageOpened();
    }

    @Then("^Forum Application Page is displayed$")
    public void isForumsPageOpened() {
        applicationSteps.isForumsPageOpened();
    }

    @Then("^Notes Application Page is displayed$")
    public void isNotesPageOpened() {
        applicationSteps.isNotesPageOpened();

    }

    @Then("^Settings Application Page is displayed$")
    public void settingsPageIsOpened() {
        applicationSteps.settingsPageIsOpened();
    }

    @Then("^Drives Application Page is displayed$")
    public void isDrivesPageOpened() {
        applicationSteps.isDrivesPageOpened();

    }

    @When("^I go to Wallet AppCenter Application$")
    public void goToWalletAppCenterApplication() {
        applicationSteps.goToWalletAppCenterApplication();

    }

    @When("^I Select the folder '(.*)' in Drives$")
    public void selectFolder(String folderType) {
        applicationSteps.selectFolder(folderType);
    }

    @When("^Uploaded File name is displayed '(.*)' in Drives$")
    public void uploadedFileNameIsDisplayed(String uploadedFileName) {
        applicationSteps.uploadedFileNameIsDisplayed(uploadedFileName);
    }

    @When("^Uploaded File extension is displayed '(.*)' in Drives$")
    public void uploadedFileLabelIsDisplayed(String uploadedFileExtension) {
        applicationSteps.uploadedFileLabelIsDisplayed(uploadedFileExtension);
    }

    @When("^I delete the file '(.*)' in Drives$")
    public void deleteFileInDrives(String uploadedFileName) {
        applicationSteps.deleteFileInDrives(uploadedFileName);
    }

    @When("^The file '(.*)' is not displayed in Drives$")
    public void uploadedFileNameIsNotDisplayed(String uploadedFileName) {
        applicationSteps.uploadedFileNameIsNotDisplayed(uploadedFileName);
    }

    @When("^Uploaded File version is displayed '(.*)' in Drives$")
    public void uploadedFileVersionIsDisplayed(String uploadedFileVersion) {
        applicationSteps.uploadedFileVersionIsDisplayed(uploadedFileVersion);
    }

    @When("^Uploaded File message is displayed '(.*)' in Drives$")
    public void uploadedFileMessageIsDisplayed(String uploadedFileMessage) {
        applicationSteps.uploadedFileMessageIsDisplayed(uploadedFileMessage);
    }

    @When("^I go to Agenda AppCenter Application$")
    public void goToAgendaAppCenterApplication() {
        applicationSteps.goToAgendaAppCenterApplication();

    }

    @Then("^Agenda Application Page is displayed$")
    public void isAgendaPageOpened() {
        applicationSteps.isAgendaPageOpened();

    }

    @When("^I go to News AppCenter Application$")
    public void goToNewsAppCenterApplication() {
        applicationSteps.goToNewsAppCenterApplication();

    }

    @Then("^News Application Page is displayed$")
    public void isNewsPageOpened() {
        applicationSteps.isNewsPageOpened();

    }

    @Then("I open the News Filter Drawer$")
    public void openNewsFilterDrawer() {
        applicationSteps.openNewsFilterDrawer();
    }

    @Then("I click on Reset button in News Filter Drawer$")
    public void resetNewsFilterDrawer() {
        applicationSteps.resetNewsFilterDrawer();

    }

    @Then("Space '(.*)' is not selected in News Filter Drawer$")
    public void checkThatSpaceIsNotSelectedInNewsFilterDrawer(String spaceName) {
        assertThat(applicationSteps.checkThatSpaceIsNotSelectedInNewsFilterDrawer(spaceName)).as("Space Is not selected in News Filter Drawer").isFalse();
    }

    @Then("Space '(.*)' is selected in News Filter Drawer$")
    public void checkThatSpaceIsSelectedInNewsFilterDrawer(String spaceName) {
        assertThat(applicationSteps.checkThatSpaceIsNotSelectedInNewsFilterDrawer(spaceName)).as("Space Is not selected in News Filter Drawer").isTrue();
    }

    @Then("First created space is selected in News Filter Drawer$")
    public void checkThatFirstSpaceIsSelectedInNewsFilterDrawer() {
        String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
        assertThat(applicationSteps.checkThatSpaceIsNotSelectedInNewsFilterDrawer(randomSpaceName)).as("Space Is not selected in News Filter Drawer").isTrue();
    }

    @Then("I close the News Filter Drawer$")
    public void closeNewsFilterDrawer() {
        applicationSteps.closeNewsFilterDrawer();
    }

    @Then("News Filter Drawer is closed and the Filter button is not applied$")
    public void newsFilterDrawerClosed() {
        applicationSteps.newsFilterDrawerClosed();
    }

    @When("I tick the space '(.*)' in News Filter Drawer$")
    public void tickTheSearchedSpaceInNewsFilterDrawer(String spaceName) {
        applicationSteps.tickTheSearchedSpaceInNewsFilterDrawer(spaceName);

    }

    @When("Apply Button in Filter News Drawer is disabled$")
    public void checkThatApplyBtnInFilterNewsDrawerIsDisabled() {
        applicationSteps.checkThatApplyBtnInFilterNewsDrawerIsDisabled();
    }

    @When("I tick the second created space in News Filter Drawer$")
    public void tickTheSecondSearchedSpaceInNewsFilterDrawer() {
        String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
        applicationSteps.tickTheSearchedSpaceInNewsFilterDrawer(secondRandomSpaceName);

    }

    @When("I tick the first created space in News Filter Drawer$")
    public void tickTheFirstSearchedSpaceInNewsFilterDrawer() {
        String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
        applicationSteps.tickTheSearchedSpaceInNewsFilterDrawer(randomSpaceName);

    }

    @When("Reset Button in Filter News Drawer is disabled$")
    public void checkThatResetBtnInFilterNewsDrawerIsDisplayed() {
        applicationSteps.checkThatResetBtnInFilterNewsDrawerIsDisplayed();
    }

    @When("I close the Filter by spaces$")
    public void closeFilterBySpaces() {
        applicationSteps.closeFilterBySpaces();

    }

    @When("The Filter by Spaces is applied$")
    public void checkThatFilterIsApplied() {
        applicationSteps.checkThatFilterIsApplied();
    }

    @When("News Article with title '(.*)' and summary '(.*)' is displayed in News Feed page$")
    public void checkThatNewsArticleIsDisplayedInNewsFeedPage(String articleTitle, String articleSummary) {
        applicationSteps.checkThatNewsArticleIsDisplayedInNewsFeedPage(articleTitle, articleSummary);
    }

    @When("I click on News Article with title '(.*)' and summary '(.*)' to access to the details$")
    public void clickNewsArticleInNewsFeedPage(String articleTitle, String articleSummary) {
        applicationSteps.clickNewsArticleInNewsFeedPage(articleTitle, articleSummary);
    }

    @When("News Article with title '(.*)' and summary '(.*)' is not displayed in News Feed page$")
    public void checkThatNewsArticleIsNotDisplayedInNewsFeedPage(String articleTitle, String articleSummary) {
        applicationSteps.checkThatNewsArticleIsNotDisplayedInNewsFeedPage(articleTitle, articleSummary);
    }

    @When("^I go to Perk Store AppCenter Application$")
    public void goToPerkStoreAppCenterApplication() {
        applicationSteps.goToPerkStoreAppCenterApplication();

    }

    @Then("^Perk Store Application Page is displayed$")
    public void isPerkStorePageOpened() {
        applicationSteps.isPerkStorePageOpened();

    }

    @When("^I go to Tasks AppCenter Application$")
    public void goToTasksAppCenterApplication() {
        applicationSteps.goToTasksAppCenterApplication();

    }

    @Then("^Tasks Application Page is displayed$")
    public void isTasksPageOpened() {
        applicationSteps.isTasksPageOpened();

    }

    @When("^I go to Send FeedBack AppCenter Application$")
    public void goToSendFeedbackAppCenterApplication() {
        applicationSteps.goToSendFeedbackAppCenterApplication();

    }

    @Then("^Send Feedback Application Page is displayed$")
    public void isSendFeedbackPageOpened() {
        applicationSteps.isSendFeedbackPageOpened();

    }

    @When("^I go to AppCenter '(.*)' Application Page$")
    public void goToTheAppcenterApplicationPage(String app) {
        applicationSteps.goToTheAppcenterApplicationPage(app);

    }

    @When("^AppCenter created application is removed From Favorites$")
    public void checkThatAppcenterCreatedApplicationIsNotDisplayed() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.checkThatAppcenterApplicationIsNotDisplayed(randomApplicationTitle);

    }

    @When("^I remove Application '(.*)' From Favorites$")
    @And("^I add Application '(.*)' To Favorites$")
    public void addRemoveApplicationToFavorites(String app) {
        applicationSteps.addRemoveApplicationToFavorites(app);

    }

    @When("^AppCenter Application '(.*)' is added To Favorites$")
    public void checkThatAppcenterApplicationIsDisplayed(String app) {
        applicationSteps.checkThatAppcenterApplicationIsDisplayed(app);

    }

    @When("^AppCenter created application is added To Favorites$")
    public void checkThatAppcenterRandomApplicationIsDisplayed() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.checkThatAppcenterApplicationIsDisplayed(randomApplicationTitle);

    }

    @When("^I close AppCenter Drawer$")
    public void closeAppCenterDrawer() {
        applicationSteps.closeAppCenterDrawer();

    }

    @Then("^Application '(.*)' is displayed in Favorites Applications$")
    public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {
        applicationSteps.checkThatApplicationIsDisplayedInFavoriteApps(app);

    }

    @Then("^The created application is displayed in Favorites Applications$")
    public void checkThatRandomApplicationIsDisplayedInFavoriteApps() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.checkThatApplicationIsDisplayedInFavoriteApps(randomApplicationTitle);

    }

    @When("The message 'You can’t set more than 12 favorites' is displayed$")
    public void maxFavoriteAppsIsDisplayed() {
        applicationSteps.maxFavoriteAppsIsDisplayed();
    }

    @Then("^Application '(.*)' is not displayed in Favorites Applications$")
    public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {
        applicationSteps.checkThatApplicationIsNotDisplayedInFavoriteApps(app);

    }

    @Then("Star button for adding the created application to Favorites is displayed")
    public void starButtonForCreatedRandomAppIsNotSelected() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.starButtonIsNotSelected(randomApplicationTitle);
    }

    @Then("^The created application is not displayed in Favorites Applications$")
    public void checkThatCreatedApplicationIsNotDisplayedInFavoriteApps() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.checkThatApplicationIsNotDisplayedInFavoriteApps(randomApplicationTitle);

    }

    @Then("^First added application is not displayed in Favorites Applications$")
    public void checkThatRandomApplicationIsNotDisplayedInFavoriteApps() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.checkThatApplicationIsNotDisplayedInFavoriteApps(randomApplicationTitle);

    }

    @When("^AppCenter Application '(.*)' is removed From Favorites$")
    public void checkThatAppcenterApplicationIsNotDisplayed(String app) {
        applicationSteps.checkThatAppcenterApplicationIsNotDisplayed(app);

    }

    @When("^'(.*)' Application Open Button is displayed$")
    public void checkThatOpenApplicationButtonIsDisplayed(String app) {
        applicationSteps.checkThatOpenApplicationButtonIsDisplayed(app);

    }

    @When("^The created application Open Button is displayed$")
    public void checkThatRandomApplicationOpenButtonIsDisplayed() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.checkThatOpenApplicationButtonIsDisplayed(randomApplicationTitle);

    }

    @When("^I click on '(.*)' Application Open Button$")
    public void clickOnOpenApplicationButton(String app) {
        applicationSteps.clickOnOpenApplicationButton(app);

    }

    @When("^I see All Applications$")
    public void seeAllApplications() {
        applicationSteps.seeAllApplications();

    }

    @Then("^All Applications Page is Displayed$")
    public void isAllApplicationsPageDisplayed() {
        applicationSteps.isAllApplicationsPageDisplayed();

    }

    @Then("Star button for removing application '(.*)' from Favorites is displayed")
    public void starButtonIsSelected(String appTitle) {
        applicationSteps.starButtonIsSelected(appTitle);
    }

    @Then("Star button for removing the created application from Favorites is displayed")
    public void starButtonIsSelected() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.starButtonIsSelected(randomApplicationTitle);
    }

    @Then("Star button for adding application '(.*)' to Favorites is displayed")
    public void starButtonIsNotSelected(String appTitle) {
        applicationSteps.starButtonIsNotSelected(appTitle);
    }

    @Then("Star button for adding the first added application to Favorites is displayed")
    public void starButtonForFirstRandomAppIsNotSelected() {
        String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
        applicationSteps.starButtonIsNotSelected(randomApplicationTitle);
    }

    @Then("^Add Application '(.*)' To Favorites Btn Is Displayed$")
    public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {
        applicationSteps.checkThatAddApplicationBtnToFavoritesIsDisplayed(app);

    }

    @Then("^I go to '(.*)' application$")
    public void goToApplication(String application) {
        applicationSteps.goToApplication(application);
    }

    @And("^I go to Challenge Application$")
    public void goToChallengeApplication() {
        applicationSteps.goToChallengeApplication();
    }

    @Then("^Challenge Application Page is displayed$")
    public void isChallengePageOpened() {
        applicationSteps.isChallengePageOpened();
    }

    @When("News Article with title '(.*)' is displayed in Latest News$")
    public void checkThatNewsArticleIsDisplayedInLatestNews(String articleTitle) {
        applicationSteps.checkThatNewsArticleIsDisplayedInLatestNews(articleTitle);
    }

    @When("News Article with title '(.*)' is displayed in Slider News$")
    public void checkThatNewsArticleIsDisplayedInSliderNews(String articleTitle) {
        applicationSteps.checkThatNewsArticleIsDisplayedInSliderNews(articleTitle);
    }

}
