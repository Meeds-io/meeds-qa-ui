package steps;

import org.junit.Assert;
import pages.page.factory.UnifiedSearchPage;

import static pages.page.factory.UnifiedSearchPage.ELEMENT_ICON_SEARCH;
import static pages.page.factory.UnifiedSearchPage.ELEMENT_SEARCH_INPUT_DW;

public class ManageUnifiedSearchSteps {
    private UnifiedSearchPage unifiedSearchPage;

    public void searchInTribe(String element) {
        ELEMENT_ICON_SEARCH.waitUntilVisible();
        ELEMENT_ICON_SEARCH.clickOnElement();
        ELEMENT_SEARCH_INPUT_DW.setTextValue(element);
    }


    public boolean isSearchedUserNameVisible(String user) {
        return unifiedSearchPage.isSearchedUserNameVisible(user);
    }


    public boolean isSearchedApplicationNameVisible(String appName) {
        return unifiedSearchPage.isSearchedApplicationNameVisible(appName);
    }

    public boolean isSearchedApplicationDescriptionVisible(String appDesc) {
        return unifiedSearchPage.isSearchedApplicationDescriptionVisible(appDesc);
    }

    public boolean isSearchedApplicationPictureVisible() {
        return unifiedSearchPage.isSearchedApplicationPictureVisible();
    }

    public boolean isSearchedActivityTitleVisible(String activity) {
        return unifiedSearchPage.isSearchedActivityTitleVisible(activity);
    }

    public boolean isSearchedSpaceNameVisible(String space) {
        return unifiedSearchPage.isSearchedSpaceNameVisible(space);
    }

    public boolean isSearchedAttachedFileVisible(String attachedFile) {
        return unifiedSearchPage.isSearchedAttachedFileVisible(attachedFile);
    }

    public void isImageDisplayedInSearch(String imageName) {
        unifiedSearchPage.isImageDisplayedInSearch(imageName);
    }

    public void goToTheSearchedImage(String imageName) {
        unifiedSearchPage.goToTheSearchedImage(imageName);
    }

    public void goToTheSearchedApplication(String appName) {
        unifiedSearchPage.goToTheSearchedApplication(appName);
    }

    public void goToTheSearchedSpace(String space) {
        unifiedSearchPage.goToTheSearchedSpace(space);
    }

    public void goToTheSearchedFile(String file) {
        unifiedSearchPage.goToTheSearchedFile(file);
    }

    public void goToTheSearchedActivity() {
        unifiedSearchPage.goToTheSearchedActivity();
    }

    public void accessUnifiedSearchPage() {
        ELEMENT_ICON_SEARCH.waitUntilVisible();
        ELEMENT_ICON_SEARCH.clickOnElement();
    }

    public void clickFavoriteBtn() {
        unifiedSearchPage.clickFavoriteBtn();
    }

    public boolean isSearchedActivityTitleNotVisible(String activity) {
        return unifiedSearchPage.isSearchedActivityTitleNotVisible(activity);
    }

    public void favoriteSearchedActivity(String activity) {
        unifiedSearchPage.favoriteSearchedActivity(activity);
    }

    public void selectDropDown(String object) {
        unifiedSearchPage.selectDropDown(object);
    }

}

