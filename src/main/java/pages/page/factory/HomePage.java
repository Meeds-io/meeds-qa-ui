package pages.page.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import elements.TextBoxElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;
import pages.GenericPage;
import static org.aspectj.bridge.MessageUtil.info;

public class HomePage extends GenericPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
    private BaseElementFacade hamburgerNavigationMenuLink;

    @FindBy(xpath = "//*[contains(@class,'selectSpacesFilter')]")
    private BaseElementFacade selectSpacesFilter;

    @FindBy(xpath = "//a[@href='/portal/meeds/spaces']")
    private BaseElementFacade openSpacesPageLink;

    @FindBy(xpath = "//a[@href='/portal/meeds/stream']")
    private BaseElementFacade streamPageLink;

    @FindBy(xpath = "(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[2]")
    private BaseElementFacade connectionsBadge;

    @FindBy(xpath = "(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[1]")
    private BaseElementFacade spacesBadge;

    @FindBy(xpath = "//*[@id='ActivityContextBoxWelcomeActivity']")
    private BaseElementFacade contextBoxWelcomeActivity;

    @FindBy(xpath = "//a[@href='/portal/dw/home']")
    private BaseElementFacade homePageLink;

    @FindBy(xpath = "//*[@id='tasks']//*[@class='body-1 text-uppercase color-title px-0']")
    private BaseElementFacade tasksSnapshotPageButton;

    @FindBy(xpath = "//i[contains(@class,'uiIconPeople')]")
    private BaseElementFacade personnePageLink;

    @FindBy(xpath = "//i[contains(@class,'settingsIcon')]")
    private BaseElementFacade settingsPageLink;

    @FindBy(xpath = "//a[@href='/portal/dw/profile']")
    private BaseElementFacade myProfilePageLink;

    @FindBy(xpath = "//a[contains(@class,'seeAllApplicationsBtn')]")
    private BaseElementFacade viewAllApplicationLink;

    @FindBy(xpath = "//*[@class='v-text-field__slot']//input")
    private TextBoxElementFacade searchApplicationCenterInput;

    @FindBy(id = "appcenterLauncherButton")
    private BaseElementFacade appCenterButton;

    @FindBy(xpath = "//aside[contains(@class,'appCenterDrawer ')]//span[contains(text(),'News')]")
    private BaseElementFacade newsMenuButton;

    @FindBy(xpath = "//*[contains(@class,'spacesNavigationTitle')]//*[contains(@class,'titleLabel')]")
    private BaseElementFacade recentSpacesBtn;

    @FindBy(xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]")
    private TextBoxElementFacade sideBarFilterSpaces;

    @FindBy(xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]//*[contains(@class,'v-input recentSpacesFilter')]//input")
    private TextBoxElementFacade sideBarFilterSpacesInput;

    @FindBy(xpath = "//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleIcon')]//button")
    private BaseElementFacade filterSpacesSearchIcon;

    @FindBy(xpath = "//*[contains(@class,'recentSpacesWrapper')]//*[@class='v-list-item__content']//div")
    private BaseElementFacade sideBarFilterSearchedSpace;

    @FindBy(id = "newsListViewApp")
    private BaseElementFacade newsSlider;

    @FindBy(id = "LatestNewsContainer")
    private BaseElementFacade LatestNewsContainer;

    @FindBy(id = "profile-stats-portlet")
    private BaseElementFacade profileStatsPortlet;

    @FindBy(id = "tasks")
    private BaseElementFacade tasksContainer;

    @FindBy(xpath = "//*[@id='WalletApp']")
    public static BaseElementFacade walletApplication;

    @FindBy(id = "DocumentsContainer")
    private BaseElementFacade DocumentsContainer;

    @FindBy(id = "walletBalance")
    private BaseElementFacade walletBalance;

    @FindBy(xpath = "//*[@id='walletBalance']//*[contains(@class,'big-number')]")
    private BaseElementFacade walletBalanceNumber;

    @FindBy(xpath = "//*[@id='newsListViewApp']//*[contains(@class,'headerLatestNews')]")
    private BaseElementFacade newsInWidget;

    @FindBy(xpath = "//div[@id='latestNewsDetails']//button[contains(@class,'caption ')]")
    private BaseElementFacade seeMoreNewsButton;

    @FindBy(xpath = "//i[contains(@class,'uiAdministrationIcon')]")
    private BaseElementFacade addministrationMenu;

    @FindBy(xpath = "//a[contains(@href,'appCenterAdminSetup')]")
    private BaseElementFacade applicationAdminPageLink;

    @FindBy(id = "miniChatDrawer")
    private BaseElementFacade chatButton;

    @FindBy(id = "NotificationPopoverPortlet")
    private BaseElementFacade notificationIcon;

    @FindBy(xpath = "//i[contains(@class,'logoutIcon')]")
    private BaseElementFacade logOutMenu;

    @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/usersManagement']")
    private BaseElementFacade addUserLink;

    @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/groupsManagement']")
    private BaseElementFacade addGroupsLink;

    @FindBy(xpath = "//a[@href='/portal/dw/profile']")
    private BaseElementFacade myProfileButton;

    @FindBy(xpath = "//aside[contains(@class,'spaceDrawer')]//button[contains(@class,'closeIcon')]")
    private BaseElementFacade closeSpaceDrawerButton;

    @FindBy(xpath = "//aside[contains(@class,'v-navigation-drawer')]//span[contains(text(),'See all')]")
    private BaseElementFacade seeAllLink;

    @FindBy(xpath = "//span[contains(text(),'See all')]")
    private BaseElementFacade seeAllLinkNews;

    @FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/webconferencing']")
    private BaseElementFacade webConferencingLink;

    @FindBy(xpath = "(//*[@class='providersTableRow']//*[@class='center actionContainer']/div)[1]")
    private BaseElementFacade switcherButton;

    @FindBy(xpath = "//*[@id='profileHeaderActions']//button[contains(@class,'jitsiCallAction')]")
    private BaseElementFacade callButton;

    @FindBy(xpath = " //*[contains(@class,'v-list-item__action drawerIcons')]//*[contains(@class,'call-button-mini')]")
    private BaseElementFacade phoneIcon;

    @FindBy(xpath = "//*[@class='UITopBarContainerItem top-bar-logo-containerTDContainer']//*[@class='single-btn-container']")
    private BaseElementFacade spacePhoneIcon;

    @FindBy(xpath = "//*[@id='room-detail']//button[contains(@class,'jitsiCallAction')]")
    private BaseElementFacade jitsiButton;

    @FindBy(xpath = "//a[@href='/portal/dw/stream']//div[@class='v-list-item__icon']")
    private BaseElementFacade homeIcon;

    @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[1]")
    private BaseElementFacade firstNotificationContent;

    @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[2]")
    private BaseElementFacade secondNotificationContent;

    @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
    private BaseElementFacade confirmationForChangeSiteHomeLink;

    @FindBy(xpath = "//*[@id='UserHomePortalLink']")
    private BaseElementFacade homePageButton;

    @FindBy(xpath = "(//*[@class='lastUpdatedTime'])[1]")
    private BaseElementFacade firstNotificationTimeStamp;

    @FindBy(xpath = "(//*[@class='lastUpdatedTime'])[2]")
    private BaseElementFacade secondNotificationTimeStamp;

    @FindBy(xpath = "//*[@id='StreamPage']")
    private BaseElementFacade streamPageView;

    @FindBy(xpath = "//*[@class='v-card v-card--flat v-sheet theme--light']//div[@class='headline text-color font-weight-bold pa-1']")
    private BaseElementFacade spaceInvitaitationWidget;

    @FindBy(xpath = "//*[@id='AgendaTimelineApplication']")
    private BaseElementFacade eventWidgetBlock;

    @FindBy(xpath = "//*[@id='AgendaTimelineApplication']//*[contains(text(),'Agenda')]")
    private BaseElementFacade eventWidgetName;

    private BaseElementFacade getProfileWidgetContent(String widget, String number) {
        return findByXpath(String.format("//div[contains(@class,'profileCard')]//div[contains(@class,'mx-0')]//span[text()='%s']/../..//span[text()='%s']",
                widget,
                number));
    }

    private List<WebElementFacade> getListSpaceInDrawer() {
        return findAll("//aside[contains(@class,'spaceDrawer ')]//div[@role='list']//descendant::div[@role='listitem']");
    }

    private List<WebElementFacade> getListConnectionInDrawer() {
        return findAll("//aside[contains(@class,'connectionsDrawer ')]//div[@role='list']//descendant::div[@role='listitem']");
    }

    private BaseElementFacade getConnectionsBadgeWithNumber(String number) {
        return findByXpath(
                String.format("//div[contains(@class,'profileCard')]//*[contains(text(),'Connections')]/preceding::*[@class='v-btn__content' and contains(text(),'%s')][1]", number));
    }

    private BaseElementFacade getSpacesBadgeWithNumber(String number) {
        return findByXpath(
                String.format("//div[contains(@class,'profileCard')]//*[contains(text(),'Spaces')]/preceding::*[@class='v-btn__content' and contains(text(),'%s')][1]", number));
    }

    private BaseElementFacade getRejectIconSpaceFromDrawer(String spaceName) {
        return findByXpath(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
                spaceName));
    }

    private BaseElementFacade getAcceptIconSpaceFromDrawer(String spaceName) {
        return findByXpath(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                spaceName));
    }

    private BaseElementFacade getAcceptIconConnexionFromDrawer(String spaceName) {
        return findByXpath(String.format("//aside[contains(@class,'connectionsDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                spaceName));
    }

    private BaseElementFacade getRejectIconConnexionFromDrawer(String spaceName) {
        return findByXpath(String.format("//aside[contains(@class,'connectionsDrawer')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
                spaceName));
    }

    private BaseElementFacade getNewsInWidgetTitle(String newsTitle) {
        return findByXpath(String.format("//div[@id='latestNewsDetails']//div[contains(@class,'v-responsive__content')]/preceding::*[contains(@class,'contentTitle') and contains(text(),'%s')]",
                newsTitle));
    }

    private BaseElementFacade getNewsInWidgetSummary(String newsSummary) {
        return findByXpath(String.format("//div[@id='latestNewsDetails']//div[contains(@class,'v-responsive__content')]/preceding::*[contains(@class,'contentBody') and contains(text(),'%s')]",
                newsSummary));
    }

    private BaseElementFacade getLatestNewsSecondaryBlocTitle(String newsTitle) {
        return findByXpath(String.format("//div[@id='latestNewsDetails']//*[contains(@class,'v-list-item__title') and contains(text(),'%s')]",
                newsTitle));
    }

    private BaseElementFacade getLatestNewsSecondaryBlocSummary(String newsSummary) {
        return findByXpath(String.format("//div[@id='latestNewsDetails']//*[contains(@class,'v-list-item__subtitle') and contains(text(),'%s')]",
                newsSummary));
    }

    private BaseElementFacade checkSpaceFromDrawer(String spaceName) {
        return findByXpath(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                spaceName));
    }

    Map<String, BaseElementFacade> MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH = new HashMap<String, BaseElementFacade>() {
        {
            put("Article", newsSlider);
            put("Dernières actualités", LatestNewsContainer);
            put("Statistique", profileStatsPortlet);
            put("Taches", tasksContainer);
            put("Documents", DocumentsContainer);
            put("Wallet", walletBalance);

        }
    };

    public void hoverOnRecentSpaces() {
        hamburgerNavigationMenuLink.clickOnElement();
        recentSpacesBtn.hover("//*[contains(@class,'spacesNavigationTitle')]//*[contains(@class,'titleLabel')]");
    }

    public void goToSpacesPage() {
        hamburgerNavigationMenuLink.clickOnElement();
        openSpacesPageLink.clickOnElement();
    }

    public void searchSpaceInSideBarFilter(String space) {
        sideBarFilterSpaces.clickOnElement();
        sideBarFilterSpacesInput.setTextValue(space);
        filterSpacesSearchIcon.clickOnElement();
    }

    public void checkNoActivityDisplayed() {
        contextBoxWelcomeActivity.isVisibleAfterWaiting();
    }

    public void goToStreamPage() {
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        hamburgerNavigationMenuLink.clickOnElement();
        streamPageLink.clickOnElement();
    }

    public void selectAllOrMySpaces(String filter) {
        selectSpacesFilter.selectByVisibleText(filter);
    }

    public void goToNewsApp() {
        appCenterButton.clickOnElement();
        newsMenuButton.clickOnElement();
    }

    public void commentActivityNotificationIsDisplayed(String message, String activity, String comment) {
        if (firstNotificationContent.getText().contains(message)) {
            Assert.assertTrue(firstNotificationContent.getText().contains(message));
            Assert.assertTrue(firstNotificationContent.getText().contains(activity));
            Assert.assertTrue(firstNotificationContent.getText().contains(comment));

        } else {
            Assert.assertTrue(secondNotificationContent.getText().contains(message));
            Assert.assertTrue(secondNotificationContent.getText().contains(activity));
            Assert.assertTrue(secondNotificationContent.getText().contains(comment));
        }
    }

    public void clickOnCommentActivityNotification(String message, String activity, String comment) {
        if (firstNotificationContent.getText().contains(message)) {
            Assert.assertTrue(firstNotificationContent.getText().contains(message));
            Assert.assertTrue(firstNotificationContent.getText().contains(activity));
            Assert.assertTrue(firstNotificationContent.getText().contains(comment));
            firstNotificationContent.clickOnElement();

        } else {
            Assert.assertTrue(secondNotificationContent.getText().contains(message));
            Assert.assertTrue(secondNotificationContent.getText().contains(activity));
            Assert.assertTrue(secondNotificationContent.getText().contains(comment));
            secondNotificationContent.clickOnElement();
        }
    }

    public void openAppCenterMenu() {
        appCenterButton.clickOnElement();
    }

    public void goToAddUser() {
        hamburgerNavigationMenuLink.clickOnElement();
        addministrationMenu.clickOnElement();
        addUserLink.clickOnElement();
    }

    public void goToAddGroups() {
        hamburgerNavigationMenuLink.clickOnElement();
        addministrationMenu.clickOnElement();
        addGroupsLink.clickOnElement();
    }

    public boolean isHomePageDisplayed() {
        return hamburgerNavigationMenuLink.isVisibleAfterWaiting();
    }

    public boolean isElementVisible(String elementName) {
        return MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.get(elementName).isVisibleAfterWaiting();
    }

    public void goToHomePage() {
        hamburgerNavigationMenuLink.clickOnElement();
        homePageLink.clickOnElement();
    }

    public void refreshPage() {
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    }

    public void openNotifications() {
        notificationIcon.clickOnElement();
    }

    public void goToSettingsPageViaUrl() {
        hamburgerNavigationMenuLink.clickOnElement();
        homePageLink.clickOnElement();
    }

    public void goToPeoplePage() {
        hamburgerNavigationMenuLink.clickOnElement();
        personnePageLink.clickOnElement();
    }

    public boolean isNewsDisplayedInWidget() {
        return newsInWidget.isVisibleAfterWaiting();
    }

    public void isNewsTitleDisplayedInWidget(String title) {
        if (getNewsInWidgetTitle(title).isVisibleAfterWaiting()) {
            getNewsInWidgetTitle(title).isVisibleAfterWaiting();
        }

        if (getLatestNewsSecondaryBlocTitle(title).isVisibleAfterWaiting()) {
            getLatestNewsSecondaryBlocTitle(title).isVisibleAfterWaiting();
        }
    }

    public void isNewsSummaryDisplayedInWidget(String summary) {
        if (getNewsInWidgetSummary(summary).isVisibleAfterWaiting()) {
            getNewsInWidgetSummary(summary).isVisibleAfterWaiting();
        }

        if (getLatestNewsSecondaryBlocSummary(summary).isVisibleAfterWaiting()) {
            getLatestNewsSecondaryBlocSummary(summary).isVisibleAfterWaiting();
        }
    }

    public void isNewsTitleNotDisplayedInWidget(String title) {
        getNewsInWidgetTitle(title).isNotVisibleAfterWaiting();
        getLatestNewsSecondaryBlocTitle(title).isNotVisibleAfterWaiting();
    }

    public void searchedSpaceIsDisplayedInSideBarFilter(String space) {
        Assert.assertTrue(sideBarFilterSearchedSpace.getTextValue().contains(space));
    }

    public void searchedSpaceIsNotDisplayedInSideBarFilter(String space) {
        Assert.assertFalse(sideBarFilterSearchedSpace.getTextValue().contains(space));
    }

    public void isNewsSummaryNotDisplayedInWidget(String summary) {
        getNewsInWidgetSummary(summary).isNotVisibleAfterWaiting();
        getLatestNewsSecondaryBlocSummary(summary).isNotVisibleAfterWaiting();
    }

    public boolean isSeeMoreNewsButtonVisible() {
        return seeMoreNewsButton.isVisibleAfterWaiting();
    }

    public void clickWalletWidget() {
        walletBalanceNumber.waitUntilVisible();
        walletBalanceNumber.clickOnElement();
    }

    public boolean isWalletPageOpened() throws InterruptedException {
        Thread.sleep(5000);
        walletApplication.isVisibleAfterWaiting();
        return Serenity.getWebdriverManager().getCurrentDriver().getTitle().equals("Wallet");
    }

    public boolean isPageOpened(String page) {
        return Serenity.getWebdriverManager().getCurrentDriver().getTitle().equals(page);
    }

    public void logout() {
        hamburgerNavigationMenuLink.clickOnElement();
        logOutMenu.clickOnElement();
    }

    public boolean isWidgetWithNumberVisible(String widget, String number) {
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        return getProfileWidgetContent(widget, number).isVisibleAfterWaiting();
    }

    public boolean isConnectionsBadgeWithNumberVisible(String number) {
        return getConnectionsBadgeWithNumber(number).isVisibleAfterWaiting();
    }

    public boolean isSpacesBadgeWithNumberVisible(String number) {
        return getSpacesBadgeWithNumber(number).isVisibleAfterWaiting();
    }

    public void clickOnSpacesBagde() {
        spacesBadge.clickOnElement();
    }

    public void clickOnConnectionsBagde() {
        connectionsBadge.clickOnElement();
    }

    public boolean isNumberOfSpacesInDrawer(int expectedNumber) {
        int listOfSpaces = getListSpaceInDrawer().size();
        return listOfSpaces == expectedNumber;
    }

    public boolean isNumberOfConnectionsInDrawer(int expectedNumber) {
        int listOfSpaces = getListConnectionInDrawer().size();
        return listOfSpaces == expectedNumber;
    }

    public void rejectSpaceInvitation(String spaceName) {
        getRejectIconSpaceFromDrawer(spaceName).clickOnElement();
    }

    public void acceptSpaceInvitation(String spaceName) {
        getAcceptIconSpaceFromDrawer(spaceName).clickOnElement();
    }

    public void acceptConnexionInvitation(String userName) {
        getAcceptIconConnexionFromDrawer(userName).clickOnElement();
    }

    public void rejectConnexionInvitation(String userName) {
        getRejectIconConnexionFromDrawer(userName).clickOnElement();
    }

    public void openChatDrawer() {
        if (closeSpaceDrawerButton.isNotVisibleAfterWaiting())
            chatButton.clickOnElement();
        else {
            closeSpaceDrawer();
            chatButton.clickOnElement();
        }
    }

    public void closeSpaceDrawer() {
        closeSpaceDrawerButton.clickOnElement();
    }

    public void openAllApplicationPage() {
        viewAllApplicationLink.clickOnElement();
    }

    public void searchApplicationCenter(String app) {
        searchApplicationCenterInput.setTextValue(app);
    }

    public void goToappCenterAdminSetupPage() {
        hamburgerNavigationMenuLink.clickOnElement();
        addministrationMenu.clickOnElement();
        applicationAdminPageLink.clickOnElement();
    }

    public void publishedArticleNotificationIsDisplayed(String message, String article, String space) {
        if (firstNotificationContent.getText().contains(message)) {
            Assert.assertTrue(firstNotificationContent.getText().contains(message));
            Assert.assertTrue(firstNotificationContent.getText().contains(article));
            Assert.assertTrue(firstNotificationContent.getText().contains(space));
            firstNotificationTimeStamp.isVisibleAfterWaiting();

        } else {
            Assert.assertTrue(secondNotificationContent.getText().contains(message));
            Assert.assertTrue(secondNotificationContent.getText().contains(article));
            Assert.assertTrue(secondNotificationContent.getText().contains(space));
            secondNotificationTimeStamp.isVisibleAfterWaiting();
        }
    }

    public void clickOnPublishedArticleNotification(String message, String article, String space) {
        if (firstNotificationContent.getText().contains(message)) {
            Assert.assertTrue(firstNotificationContent.getText().contains(message));
            Assert.assertTrue(firstNotificationContent.getText().contains(article));
            Assert.assertTrue(firstNotificationContent.getText().contains(space));
            firstNotificationTimeStamp.isVisibleAfterWaiting();
            firstNotificationContent.clickOnElement();


        } else {
            Assert.assertTrue(secondNotificationContent.getText().contains(message));
            Assert.assertTrue(secondNotificationContent.getText().contains(article));
            Assert.assertTrue(secondNotificationContent.getText().contains(space));
            secondNotificationTimeStamp.isVisibleAfterWaiting();
            secondNotificationContent.clickOnElement();
        }
    }

    public void goToSettingsPage() {
        hamburgerNavigationMenuLink.clickOnElement();
        settingsPageLink.clickOnElement();
    }

    public void goToMyProfile() {
        hamburgerNavigationMenuLink.clickOnElement();
        myProfileButton.clickOnElement();
    }

    public void goToProfilePage() {
        hamburgerNavigationMenuLink.clickOnElement();
        myProfilePageLink.clickOnElement();
    }

    public void goToTasksPage() {
        tasksSnapshotPageButton.waitUntilVisible();
        tasksSnapshotPageButton.clickOnElement();
    }

    public void clickSeeAll() {
        seeAllLink.clickOnElement();
    }

    public void clickSeeAllLinkNews() {
        seeAllLinkNews.clickOnElement();
    }

    public void goToWebConferencingAdminPage() {
        hamburgerNavigationMenuLink.clickOnElement();
        addministrationMenu.clickOnElement();
        webConferencingLink.clickOnElement();
    }

    public void deactivateSwitcher() {
        switcherButton.isVisible();
        switcherButton.clickOnElement();
    }

    public void checkCallButton() {
        callButton.isVisibleAfterWaiting();
    }

    public void checkPhoneIcon() {
        phoneIcon.isVisibleAfterWaiting();
    }

    public void checkSpacePhoneIcon() {
        spacePhoneIcon.isVisibleAfterWaiting();
    }

    public void checkJitsiButtton() {
        jitsiButton.isVisibleAfterWaiting();
    }

    public void clickOnHamburgerIcon() {
        hamburgerNavigationMenuLink.clickOnElement();
    }

    public void hoverOnStreamIcon() {
        streamPageLink.hover("//a[@href='/portal/dw/stream']");
    }

    public void clickOnHomeIcon() {
        homeIcon.clickOnElement();
    }

    public void confirmationForChangeSiteHomeLink() {
        confirmationForChangeSiteHomeLink.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    }

    public void clickOnHomePageButton() {
        homePageButton.clickOnElement();
    }

    public void checkThatStreamPageIsDisplayed() {
        streamPageView.isDisplayed();
    }

    public void clickOnSpaceInvitationWidget() {
        spaceInvitaitationWidget.clickOnElement();
    }

    public void checkExistingSpaceInvitation(String spaceName) {
        checkSpaceFromDrawer(spaceName).isDisplayed();
    }

    public void checkNotExistingSpaceInvitation(String spaceName) {
        checkSpaceFromDrawer(spaceName).isNotVisibleAfterWaiting();
    }

    private BaseElementFacade getFavoriteIconActivity(String activity) {
        return findByXpath(String.format(
                "//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::i[contains(@class,'fa-star')][01]",
                activity));
    }

    public void checkFavIcon(String activity) {
        getFavoriteIconActivity(activity).shouldBeVisible();
    }

    public void favoriteActivity(String activity) {
        getFavoriteIconActivity(activity).clickOnElement();
    }

    private BaseElementFacade getFavoriteSucessMessage(String message) {
        return findByXpath(String.format("//div[@class='v-alert__content']//*[contains(text(),'%s')]", message));
    }

    public void checkFavSuccessMessage(String message) {
        getFavoriteSucessMessage(message).isVisibleAfterWaiting();
    }

    public void unbookmarkActivity(String activity) {
        getFavoriteIconActivity(activity).clickOnElement();
    }

    public void bookmarkActivity(String activity) {
        getFavoriteIconActivity(activity).clickOnElement();
    }

    public void eventWidgetIsDisplayed() { eventWidgetBlock.isDisplayed(); }

    public void eventWidgetName() { eventWidgetBlock.isDisplayed(); }
}
