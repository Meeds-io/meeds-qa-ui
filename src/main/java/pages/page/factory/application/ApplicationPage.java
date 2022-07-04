package pages.page.factory.application;

import java.util.HashMap;
import java.util.Map;

import elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.webelements.Checkbox;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

import static org.aspectj.bridge.MessageUtil.info;

public class ApplicationPage extends GenericPage {
    public ApplicationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/portal/dw/agenda']//following::i[contains(@class,'mdi-star')]")
    private BaseElementFacade agendaFavoriteIcon;

    @FindBy(xpath = "//div[@class='userFavoriteApplications']//a[@href='/portal/dw/agenda']")
    private BaseElementFacade agendaAppInFavoriteAppList;

    @FindBy(xpath = "//*[@class='maxFavorite']//span[contains(text(),'You can’t set more than 12 favorites')]")
    private BaseElementFacade maxFavoriteApps;

    private BaseElementFacade getApplication(String appName) {
        return findByXpath(String.format("//div[@class='authorisedAppContent']//div[contains(text(),'%s')]", appName));
    }

    Map<String, BaseElementFacade> MAPPING_FIELD_Name_TO_BASEELEMENTFACADE_XPATH = new HashMap<String, BaseElementFacade>() {
        {
            put("Agenda", agendaAppInFavoriteAppList);
        }
    };

    public void clickFavoriteAgenda() {
        agendaFavoriteIcon.clickOnElement();
    }

    public void maxFavoriteAppsIsDisplayed() {
        maxFavoriteApps.isVisibleAfterWaiting();
    }

    public boolean isAppDisplayedInFavoriteList(String appName) {
        return MAPPING_FIELD_Name_TO_BASEELEMENTFACADE_XPATH.get(appName).isVisibleAfterWaiting();
    }

    public boolean isAppNotDisplayedInFavoriteList(String appName) {
        return MAPPING_FIELD_Name_TO_BASEELEMENTFACADE_XPATH.get(appName).isNotVisibleAfterWaiting();
    }

    public boolean isApplicationVisible(String application) {
        return getApplication(application).isVisibleAfterWaiting();
    }

    @FindBy(xpath = "//*[@id='WalletApp']")
    public static BaseElementFacade ELEMENT_WALLET_APPLICATION_PAGE;

    @FindBy(xpath = "//*[@id='AgendaApplication']")
    public static BaseElementFacade ELEMENT_AGENDA_APPLICATION_PAGE;

    @FindBy(xpath = "//*[@id='TasksManagementPortlet']")
    public static BaseElementFacade ELEMENT_TASKS_APPLICATION_PAGE;

    @FindBy(xpath = "//*[@class='newsApp']")
    public static BaseElementFacade ELEMENT_NEWS_APPLICATION_PAGE;

    @FindBy(xpath = "//*[contains(@class,'uiIcon uiIcon24x24 settingsIcon')]")
    public static BaseElementFacade newsFeedFilter;

    @FindBy(xpath = "//*[@class='uiIcon uiIcon24x24 settingsIcon primary--text mb-1']")
    public static BaseElementFacade newsFeedFilterApplied;

    @FindBy(xpath = "//input[@placeholder='Filter by spaces']")
    public static TextBoxElementFacade searchSpaceNameNewsFeedFilter;

    @FindBy(xpath = "//*[@class='drawer filterSpacesDrawer open']//*[@class='closebtn']")
    public static BaseElementFacade closeNewsFeedFilterButton;

    @FindBy(xpath = "//input[@placeholder='Filter by spaces']/preceding::input[@type='checkbox']/preceding::i[1]")
    public static BaseElementFacade deselectNewsFilterButton;

    @FindBy(xpath = "//*[@class='drawer filterSpacesDrawer open']//*[@class='btn btn-primary' and @disabled='disabled']")
    public static BaseElementFacade newsFeedFilterApplyButtonDisabled;

    @FindBy(xpath = "//*[@class='drawer filterSpacesDrawer open']//*[@class='btn btn-primary']")
    public static BaseElementFacade newsFeedFilterApplyButtonEnabled;

    @FindBy(xpath = "//*[contains(@class,'mdi mdi-close')]")
    public static BaseElementFacade closeFilterNewsApp;

    @FindBy(xpath = "//*[@class='drawer filterSpacesDrawer open']//*[@class='btn reset' and @disabled='disabled']")
    public static BaseElementFacade newsFeedFilterResetButtonDisabled;

    @FindBy(xpath = "//*[@class='drawer filterSpacesDrawer open']//*[@class='btn reset']")
    public static BaseElementFacade newsFeedFilterResetButtonEnabled;

    @FindBy(xpath = "//*[@class='drawer filterSpacesDrawer open']//*[@class='btn reset']")
    public static BaseElementFacade settingsPage;

    @FindBy(xpath = "//*[@class='UIJCRExplorerPortlet']")
    public static BaseElementFacade ELEMENT_DRIVES_APPLICATION_PAGE;

    @FindBy(xpath = "//*[@id='UIWikiPortlet']")
    public static BaseElementFacade ELEMENT_NOTES_APPLICATION_PAGE;

    @FindBy(xpath = "//*[@id='PerkStoreApp']")
    public static BaseElementFacade ELEMENT_PERK_STORE_APPLICATION_PAGE;

    @FindBy(xpath = "(//*[contains(@class,'drawerParent appCenterDrawer')]//*[@class='v-btn__content'])[1]")
    public static BaseElementFacade ELEMENT_CLOSE_APPCENTER_DRAWER;

    @FindBy(xpath = "//*[@id='UIForumPortlet']")
    public static BaseElementFacade ELEMENT_FORUMS_APPLICATION_PAGE;

    @FindBy(xpath = "//*[@id='ticketAddon']")
    public static BaseElementFacade ELEMENT_SEND_FEEDBACK_APPLICATION_PAGE;

    @FindBy(xpath = "(//*[contains(@class,'drawerParent appCenterDrawer')]//*[@class='v-btn__content'])[2]")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_SEE_ALL_APPLICATIONS;

    @FindBy(xpath = "//*[@class='userAuthorizedApplications']")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_ALL_APPLICATIONS_PAGE;

    @FindBy(xpath = "//*[@href='/portal/dw/agenda']//*[@class='appLauncherImage']")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_AGENDA;

    @FindBy(xpath = "//*[@href='/portal/dw/tasks']//*[@class='appLauncherImage']")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_TASKS;

    @FindBy(xpath = "//*[@href='/portal/dw/news']//*[@class='appLauncherImage']")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_NEWS;

    @FindBy(xpath = "//*[@href='/portal/dw/perkstore']//*[@class='appLauncherImage']")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_PERK_STORE;

    @FindBy(xpath = "//*[@href='/portal/dw/wallet']//*[@class='appLauncherImage']")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_WALLET;

    @FindBy(xpath = "//*[@href='/portal/dw/tribe-feedback']//*[@class='appLauncherImage']")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_SEND_FEEDBACK;

    @FindBy(xpath = "//*[@id='appcenterLauncherButton']")
    public static BaseElementFacade ELEMENT_TRIBE_APPLICATIONS_TOPBAR;

    @FindBy(xpath = "//*[@href='/portal/dw/processes']//*[@class='appLauncherImage']")
    public static BaseElementFacade ELEMENT_TRIBE_APPCENTER_PROCESSES;

    @FindBy(xpath = "//*[@id='ProcessesApplication']")
    public static BaseElementFacade ELEMENT_PROCESSES_APPLICATION_PAGE;

    @FindBy(xpath = "//*[@id='UIDocumentNodeList']//*[@class='fileInfoBottom']//a")
    public static BaseElementFacade uploadedFileVersion;

    @FindBy(xpath = "//*[@id='UIDocumentNodeList']//*[@class='fileInfoBottom']")
    public static BaseElementFacade uploadedFileMessage;

    @FindBy(xpath = "//*[@id='ECMContextMenu']//*[@class='uiIconEcmsDelete']")
    public static BaseElementFacade deleteUploadedFileDrives;

    @FindBy(xpath = "(//*[@class='PopupContent popupContent']//*[@class='UIForm UIDeleteFileConfirmMessage'])[1]//button[1]")
    public static BaseElementFacade confirmDeleteUploadedFileDrives;

    private BaseElementFacade drivesFolder(String folderType) {
        return findByXpath(String.format("//*[@class='nodeName' and contains(text(),'%s')]", folderType));
    }

    private BaseElementFacade uploadedFileName(String uploadedFileName) {
        return findByXpath(String.format("//*[@id='UIDocumentNodeList']//*[@class='nodeName' and contains(text(),'%s')]", uploadedFileName));
    }

    public BaseElementFacade tickNewsFeedFilterSpaceName(String spaceName) {
        return findByXpath(String.format("//label[contains(text(),'%s')]//preceding::input[@type='checkbox'][1]", spaceName));
    }

    private BaseElementFacade newsArticleIsDisplayedInSliderNews(String articleTitle) {
        return findByXpath(String.format("//*[contains(@class,'flex flex-row flex-grow-1 align-center')]//*[contains(@class,'articleTitle text-h4') and contains(text(),'%s')]", articleTitle));
    }

    private BaseElementFacade newsArticleIsDisplayedInNewsFeedPage(String articleTitle, String articleSummary) {
        return findByXpath(String.format("(//*[@id='newsListItems']//*[contains(text(),'%s')])[1]/following::*[@class='newsItemContentDetails']//*[contains(text(),'%s')]", articleTitle, articleSummary));
    }

    private BaseElementFacade checkUploadedFileName(String uploadedFileName) {
        return findByXpath(String.format("//*[@id='UIDocumentNodeList']//*[@class='nodeName' and contains(text(),'%s')]//preceding::span[@class='uiCheckbox'][1]", uploadedFileName));
    }

    private BaseElementFacade newsArticleIsDisplayedInLatestNews(String articleTitle) {
        return findByXpath(String.format("//*[@class='articleInfos']//*[@class='articleTitle' and contains(text(),'%s')]", articleTitle));
    }

    private BaseElementFacade uploadedFileLabel(String uploadedFileExtension) {
        return findByXpath(String.format("//*[@id='UIDocumentNodeList']//*[@class='nodeLabel fileExtension' and contains(text(),'%s')]", uploadedFileExtension));
    }

    public void uploadedFileNameIsDisplayed(String uploadedFileName) {
        uploadedFileName(uploadedFileName).isVisibleAfterWaiting();
    }

    public void uploadedFileNameIsNotDisplayed(String uploadedFileName) {
        uploadedFileName(uploadedFileName).isNotVisibleAfterWaiting();
    }

    public void openNewsFilterDrawer() {
        newsFeedFilter.waitUntilVisible();
        newsFeedFilter.clickOnElement();
    }

    public void closeNewsFilterDrawer() {
        closeNewsFeedFilterButton.waitUntilVisible();
        closeNewsFeedFilterButton.clickOnElement();
    }

    public void newsFilterDrawerClosed() {
        newsFeedFilterApplyButtonEnabled.isNotVisibleAfterWaiting();
        newsFeedFilter.isVisibleAfterWaiting();
        newsFeedFilterApplied.isNotVisibleAfterWaiting();
    }

    public void tickTheSearchedSpaceInNewsFilterDrawer(String spaceName) {
        JavascriptExecutor executor = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
        executor.executeScript("arguments[0].click();", deselectNewsFilterButton);
        searchSpaceNameNewsFeedFilter.sendKeys(spaceName);
        JavascriptExecutor executor1 = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
        executor1.executeScript("arguments[0].click();", tickNewsFeedFilterSpaceName(spaceName));
        tickNewsFeedFilterSpaceName(spaceName).isSelected();

    }

    public void resetNewsFilterDrawer() {
        newsFeedFilterResetButtonEnabled.waitUntilVisible();
        newsFeedFilterResetButtonEnabled.clickOnElement();

    }

    public void checkThatNewsArticleIsDisplayedInLatestNews(String articleTitle) {
        newsArticleIsDisplayedInLatestNews(articleTitle).isVisibleAfterWaiting();
    }

    public void checkThatApplyBtnInFilterNewsDrawerIsDisabled() {
        newsFeedFilterApplyButtonDisabled.isVisibleAfterWaiting();
    }

    public void checkThatNewsArticleIsDisplayedInSliderNews(String articleTitle) {
        newsArticleIsDisplayedInSliderNews(articleTitle).isVisibleAfterWaiting();
    }

    public void checkThatResetBtnInFilterNewsDrawerIsDisplayed() {
        newsFeedFilterResetButtonDisabled.isVisibleAfterWaiting();
    }

    public void closeFilterBySpaces() {
        closeFilterNewsApp.waitUntilVisible();
        closeFilterNewsApp.clickOnElement();
    }

    public void checkThatFilterIsApplied() {
        newsFeedFilterApplied.isVisibleAfterWaiting();
    }

    public void checkThatNewsArticleIsDisplayedInNewsFeedPage(String articleTitle, String articleSummary) {
        newsArticleIsDisplayedInNewsFeedPage(articleTitle, articleSummary).isVisibleAfterWaiting();
    }

    public void clickNewsArticleInNewsFeedPage(String articleTitle, String articleSummary) {
        newsArticleIsDisplayedInNewsFeedPage(articleTitle, articleSummary).clickOnElement();
    }

    public void checkThatNewsArticleIsNotDisplayedInNewsFeedPage(String articleTitle, String articleSummary) {
        newsArticleIsDisplayedInNewsFeedPage(articleTitle, articleSummary).isNotVisibleAfterWaiting();
    }

    public void deleteFileInDrives(String uploadedFileName) {
        checkUploadedFileName(uploadedFileName).clickOnElement();
        deleteUploadedFileDrives.clickOnElement();
        confirmDeleteUploadedFileDrives.waitUntilVisible();
        confirmDeleteUploadedFileDrives.clickOnElement();
    }

    public void uploadedFileLabelIsDisplayed(String uploadedFileExtension) {
        uploadedFileLabel(uploadedFileExtension).isVisibleAfterWaiting();
    }

    public void uploadedFileVersionIsDisplayed(String fileVersion) {
        Assert.assertEquals(uploadedFileVersion.getText(), fileVersion);
    }

    public void uploadedFileMessageIsDisplayed(String fileMessage) {
        Assert.assertTrue(uploadedFileMessage.getText().contains(fileMessage));
    }

    private BaseElementFacade ELEMENT_TRIBE_APPCENTER_ADD_APP_TO_FAVORITES_BTN(String app) {
        return findByXpath(String.format("(//*[@class='authorisedAppContent']//*[@class='tooltipContent']//div[contains(text(),'%s')]/following::*[@class='v-card__actions applicationActions']//button)[1]", app));
    }

    private BaseElementFacade addToAppCenterFavoriteIsDisplayed(String app) {
        return findByXpath(String.format("(//*[@class='authorisedAppContent']//*[@class='tooltipContent']//div[contains(text(),'%s')]/following::*[@class='v-card__actions applicationActions']//*[@title='Add to favorites applications']//button)[1]", app));
    }

    private BaseElementFacade removeFromAppCenterFavoriteIsDisplayed(String app) {
        return findByXpath(String.format("(//*[@class='authorisedAppContent']//*[@class='tooltipContent']//div[contains(text(),'%s')]/following::*[@class='v-card__actions applicationActions']//*[@title='Remove from favorites']//button)[1]", app));
    }

    private BaseElementFacade ELEMENT_TRIBE_APPCENTER_ALL_APPLICATIONS_OPEN_APP_BTN(String app) {
        return findByXpath(String.format("(//*[@class='authorisedAppContent']//*[@class='tooltipContent']//div[contains(text(),'%s')]/following::*[@class='v-card__actions applicationActions']//a)[1]", app));
    }

    private BaseElementFacade ELEMENT_TRIBE_APPCENTER_APPLICATION_TITLE(String app) {
        return findByXpath(String.format("//*[@class='appLauncherTitle' and contains(text(),'%s')]", app));
    }

    private BaseElementFacade ELEMENT_TRIBE_FAVORITE_APPLICATION_TITLE(String app) {
        return findByXpath(String.format("//*[@class='favAppTitle' and contains(text(),'%s')]", app));
    }

    public boolean isWalletPageOpened() {

        return ELEMENT_WALLET_APPLICATION_PAGE.isVisibleAfterWaiting();
    }

    public void starButtonIsNotSelected(String appTitle) {

        addToAppCenterFavoriteIsDisplayed(appTitle).isVisibleAfterWaiting();
    }

    public void starButtonIsSelected(String appTitle) {

        removeFromAppCenterFavoriteIsDisplayed(appTitle).isVisibleAfterWaiting();
    }

    public void selectFolder(String folderType) {
        drivesFolder(folderType).waitUntilVisible();
        drivesFolder(folderType).clickOnElement();
    }

    public boolean isForumsPageOpened() {

        return ELEMENT_FORUMS_APPLICATION_PAGE.isVisibleAfterWaiting();
    }

    public void addRemoveApplicationToFavorites(String app) {

        info("Add/ Remove the application " + app + " To Favorites");
        ELEMENT_TRIBE_APPCENTER_ADD_APP_TO_FAVORITES_BTN(app).waitUntilClickable();
        ELEMENT_TRIBE_APPCENTER_ADD_APP_TO_FAVORITES_BTN(app).clickOnElement();
    }

    public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {

        info("Check that add application " + app + " to favorites Button is displayed");
        ELEMENT_TRIBE_APPCENTER_ADD_APP_TO_FAVORITES_BTN(app).isVisibleAfterWaiting();
    }

    public void checkThatOpenApplicationButtonIsDisplayed(String app) {

        info("Check that open application " + app + " Button is displayed");
        ELEMENT_TRIBE_APPCENTER_ALL_APPLICATIONS_OPEN_APP_BTN(app).isVisibleAfterWaiting();
    }

    public void settingsPageIsOpened() {
        settingsPage.isVisibleAfterWaiting();
    }

    public void clickOnOpenApplicationButton(String app) {

        info("Click on open application " + app);
        ELEMENT_TRIBE_APPCENTER_ALL_APPLICATIONS_OPEN_APP_BTN(app).clickOnElement();
    }

    public void checkThatAppcenterApplicationIsDisplayed(String app) {

        info("Check that AppCenter Application " + app + " is displayed");
        ELEMENT_TRIBE_APPLICATIONS_TOPBAR.clickOnElement();
        ELEMENT_TRIBE_APPCENTER_APPLICATION_TITLE(app).isVisibleAfterWaiting();
    }

    public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {

        info("Check that " + app + " is displayed in Favorite Applications");
        ELEMENT_TRIBE_FAVORITE_APPLICATION_TITLE(app).isVisibleAfterWaiting();
    }


    public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {

        info("Check that " + app + " is not displayed in Favorite Applications");
        ELEMENT_TRIBE_FAVORITE_APPLICATION_TITLE(app).isNotVisibleAfterWaiting();
    }

    public void checkThatAppcenterApplicationIsNotDisplayed(String app) {

        info("Check that AppCenter Application " + app + " is not displayed");
        ELEMENT_TRIBE_APPLICATIONS_TOPBAR.clickOnElement();
        ELEMENT_TRIBE_APPCENTER_APPLICATION_TITLE(app).isNotVisibleAfterWaiting();
    }

    public void goToTheAppcenterApplicationPage(String app) {

        ELEMENT_TRIBE_APPCENTER_APPLICATION_TITLE(app).clickOnElement();
    }

    public void goToApplication(String application) {
        getApplication(application).clickOnElement();
    }


    @FindBy(xpath = "//*[@href='/portal/dw/challenges']//*[@class='appLauncherImage']")
    public static BaseElementFacade challengeApplication;

    public void goToChallengeApplication() {
        challengeApplication.waitUntilVisible();
        challengeApplication.clickOnElement();
    }

    @FindBy(xpath = "//*[@id='ChallengesApplication']")
    public static BaseElementFacade elementChallengeApplicationPage;

}
