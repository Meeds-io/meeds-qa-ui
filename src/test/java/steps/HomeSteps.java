package steps;

import pages.page.factory.HomePage;

import java.util.ArrayList;
import java.util.List;

public class HomeSteps {

    private HomePage homePage;

    public void goToManageSpacesPage() {
        homePage.goToSpacesPage();
    }

    public void checkNoActivityDisplayed() {
        homePage.checkNoActivityDisplayed();
    }

    public void goToStreamPage() {
        homePage.goToStreamPage();
    }

    public void selectAllOrMySpaces(String filter) {
        homePage.selectAllOrMySpaces(filter);
    }

    public void goToNewsApp() {
        homePage.goToNewsApp();
    }

    public void hoverOnRecentSpaces() {
        homePage.hoverOnRecentSpaces();
    }

    public void searchedSpaceIsDisplayedInSideBarFilter(String space) {
        homePage.searchedSpaceIsDisplayedInSideBarFilter(space);
    }

    public void searchedSpaceIsNotDisplayedInSideBarFilter(String space) {
        homePage.searchedSpaceIsNotDisplayedInSideBarFilter(space);
    }

    public void searchSpaceInSideBarFilter(String space) {
        homePage.searchSpaceInSideBarFilter(space);
    }

    public void openAppCenterMenu() {
        homePage.openAppCenterMenu();
    }

    public void openAllApplicationPage() {
        homePage.openAllApplicationPage();
    }

    public void searchApplicationCenter(String app) {
        homePage.searchApplicationCenter(app);
    }

    public void goToProfilePage() {
        homePage.goToProfilePage();
    }

    public void goToTasksPage() {
        homePage.goToTasksPage();
    }

    public List<String> checkSections(List<String> elementList) {
        List<String> missingValues = new ArrayList<>();
        for (String elementName : elementList) {
            if (!homePage.isElementVisible(elementName))
                missingValues.add(elementName);
        }
        return missingValues;
    }

    public boolean checkSlider() {
        return homePage.isElementVisible("Article");
    }

    public void commentActivityNotificationIsDisplayed(String message, String activity, String comment) {
        homePage.commentActivityNotificationIsDisplayed(message, activity, comment);
    }

    public void clickOnCommentActivityNotification(String message, String activity, String comment) {
        homePage.clickOnCommentActivityNotification(message, activity, comment);
    }

    public void goToHomePage() {
        homePage.goToHomePage();
    }

    public void openNotifications() {
        homePage.openNotifications();
    }

    public void refreshPage() {
        homePage.refreshPage();
    }

    public boolean isNewsDisplayedInWidget() {
        return homePage.isNewsDisplayedInWidget();
    }

    public void publishedArticleNotificationIsDisplayed(String message, String article, String space) {
        homePage.publishedArticleNotificationIsDisplayed(message, article, space);
    }

    public void clickOnPublishedArticleNotification(String message, String article, String space) {
        homePage.clickOnPublishedArticleNotification(message, article, space);
    }

    public void isNewsTitleDisplayedInWidget(String title) {
        homePage.isNewsTitleDisplayedInWidget(title);
    }

    public void isNewsSummaryDisplayedInWidget(String summary) {
        homePage.isNewsSummaryDisplayedInWidget(summary);
    }

    public void isNewsTitleNotDisplayedInWidget(String title) {
        homePage.isNewsTitleNotDisplayedInWidget(title);
    }

    public void isNewsSummaryNotDisplayedInWidget(String summary) {
        homePage.isNewsSummaryNotDisplayedInWidget(summary);
    }

    public boolean isSeeMoreNewsButtonVisible() {
        return homePage.isSeeMoreNewsButtonVisible();
    }

    public void clickWalletWidget() {
        homePage.clickWalletWidget();
    }

    public boolean checkWalletPage() throws InterruptedException {
        return homePage.isWalletPageOpened();
    }

    public boolean checkPage(String page) {
        return homePage.isPageOpened(page);
    }

    public void goToAddUser() {
        homePage.goToAddUser();
    }

    public void goToAddGroups() {
        homePage.goToAddGroups();
    }

    public boolean isWidgetWithNumberVisible(String widget, String number) {
        return homePage.isWidgetWithNumberVisible(widget, number);
    }

    public boolean isConnectionsBadgeWithNumberVisible(String number) {
        return homePage.isConnectionsBadgeWithNumberVisible(number);
    }

    public boolean isSpacesBadgeWithNumberVisible(String number) {
        return homePage.isSpacesBadgeWithNumberVisible(number);
    }

    public void clickOnConnectionsBagde() {
        homePage.clickOnConnectionsBagde();
    }

    public void checkConnectionsBadge(String badgeNumber) {
        homePage.isConnectionsBadgeWithNumberVisible(badgeNumber);
    }

    public void clickOnSpacesBagde() {
        homePage.clickOnSpacesBagde();
    }

    public void checkSpacesBadge(String badgeNumber) {
        homePage.isSpacesBadgeWithNumberVisible(badgeNumber);
    }

    public boolean isNumberOfSpacesInDrawer(String number) {
        return homePage.isNumberOfSpacesInDrawer(Integer.valueOf(number));
    }

    public boolean isNumberOfConnectionsInDrawer(String number) {
        return homePage.isNumberOfConnectionsInDrawer(Integer.valueOf(number));
    }

    public void rejectSpaceInvitation(List<String> listOfSpaces) {
        for (String spaceName : listOfSpaces)
            homePage.rejectSpaceInvitation(spaceName);
    }

    public void acceptSpaceInvitation(List<String> listOfSpaces) {
        for (String spaceName : listOfSpaces) {
            homePage.acceptSpaceInvitation(spaceName);
        }

    }

    public void acceptRandomSpaceInvitation(String spaceName) {
        homePage.acceptSpaceInvitation(spaceName);
    }

    public void rejectRandomSpaceInvitation(String spaceName) {
        homePage.rejectSpaceInvitation(spaceName);
    }

    public void closeSpaceDrawer() {
        homePage.closeSpaceDrawer();
    }

    public void acceptConnexionInvitation(List<String> listOfPeople) {
        for (String peopleName : listOfPeople)
            homePage.acceptConnexionInvitation(peopleName);
    }

    public void acceptSingleConnectionInvitation(String userName) {
        homePage.acceptConnexionInvitation(userName);
    }

    public void rejectSingleConnectionInvitation(String userName) {
        homePage.rejectConnexionInvitation(userName);
    }

    public void rejectConnexionInvitation(List<String> listOfPeople) {
        for (String peopleName : listOfPeople)
            homePage.rejectConnexionInvitation(peopleName);
    }

    public void openChatDrawer() {
        homePage.openChatDrawer();
    }

    public void goToPeoplePage() {
        homePage.goToPeoplePage();
    }

    public void goToappCenterAdminSetupPage() {
        homePage.goToappCenterAdminSetupPage();
    }

    public void goToMyProfile() {
        homePage.goToMyProfile();
    }

    public void goToSettingsPage() {
        homePage.goToSettingsPage();
    }

    public void clickSeeAll() {
        homePage.clickSeeAll();
    }

    public void clickSeeAllLinkNews() {
        homePage.clickSeeAllLinkNews();
    }

    public void goToWebConferencingAdminPage() {
        homePage.goToWebConferencingAdminPage();
    }

    public void deactivateSwitcher() {
        homePage.deactivateSwitcher();
    }

    public void checkCallButton() {
        homePage.checkCallButton();
    }

    public void checkPhoneIcon() {
        homePage.checkPhoneIcon();
    }

    public void checkSpacePhoneIcon() {
        homePage.checkSpacePhoneIcon();
    }

    public void checkJitsiButtton() {
        homePage.checkJitsiButtton();
    }

    public void openNavigationMenu() {
        homePage.clickOnHamburgerIcon();
    }

    public void hoverOnStreamIcon() {
        homePage.hoverOnStreamIcon();
    }

    public void clickOnHomeIcon() {
        homePage.clickOnHomeIcon();
    }

    public void confirmationForChangeSiteHomeLink() {
        homePage.confirmationForChangeSiteHomeLink();
    }

    public void clickOnHomeButton() {
        homePage.clickOnHomePageButton();
    }

    public void checkThatStreamPageIsDisplayed() {
        homePage.checkThatStreamPageIsDisplayed();
    }

    public void clickOnSpaceInvitationWidget() {
        homePage.clickOnSpaceInvitationWidget();
    }

    public void checkDisplaySpaceInvitation(List<String> listOfSpaces) {
        for (String spaceName : listOfSpaces) {
            homePage.checkExistingSpaceInvitation(spaceName);
        }
    }

    public void checkRandomDisplaySpaceInvitation(String space) {
        homePage.checkExistingSpaceInvitation(space);
    }

    public void checkRandomNotDisplaySpaceInvitation(String space) {
        homePage.checkNotExistingSpaceInvitation(space);
    }

    public void checkNotDisplaySpaceInvitation(List<String> listOfSpaces) {
        for (String spaceName : listOfSpaces) {
            homePage.checkNotExistingSpaceInvitation(spaceName);
        }
    }

    public void checkFavIcon(String activity) {
        homePage.checkFavIcon(activity);
    }

    public void favoriteActivity(String activity) {
        homePage.favoriteActivity(activity);
    }

    public void checkFavSuccessMessage(String message) {
        homePage.checkFavSuccessMessage(message);
    }

    public void unbookmarkActivity(String activity) {
        homePage.unbookmarkActivity(activity);
    }

    public void bookmarkActivity(String activity) {
        homePage.bookmarkActivity(activity);
    }

    public void eventWidgetIsDisplayed() { homePage.eventWidgetIsDisplayed(); }

    public void eventWidgetName() { homePage.eventWidgetName(); }
}