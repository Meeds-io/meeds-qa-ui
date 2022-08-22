package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.UnifiedSearchPage;

public class ManageUnifiedSearchSteps {
  private UnifiedSearchPage unifiedSearchPage;

  public void accessUnifiedSearchPage() {
    unifiedSearchPage.openSearchApplication();
  }

  public void clickFavoriteBtn() {
    unifiedSearchPage.clickFavoriteBtn();
  }

  public void favoriteSearchedActivity(String activity) {
    unifiedSearchPage.favoriteSearchedActivity(activity);
  }

  public void goToTheSearchedActivity() {
    unifiedSearchPage.goToTheSearchedActivity();
  }

  public void goToTheSearchedApplication(String appName) {
    unifiedSearchPage.goToTheSearchedApplication(appName);
  }

  public void goToTheSearchedSpace(String space) {
    unifiedSearchPage.goToTheSearchedSpace(space);
  }

  public void isSearchedActivityTitleNotVisible(String activity) {
    unifiedSearchPage.isSearchedActivityTitleNotVisible(activity);
  }

  public void isSearchedActivityTitleVisible(String activity) {
    unifiedSearchPage.isSearchedActivityTitleVisible(activity);
  }

  public void isSearchedApplicationDescriptionVisible(String appDesc) {
    unifiedSearchPage.isSearchedApplicationDescriptionVisible(appDesc);
  }

  public void isSearchedApplicationNameVisible(String appName) {
    unifiedSearchPage.isSearchedApplicationNameVisible(appName);
  }

  public void isSearchedApplicationPictureVisible() {
    unifiedSearchPage.isSearchedApplicationPictureVisible();
  }

  public void isSearchedSpaceNameVisible(String space) {
    unifiedSearchPage.isSearchedSpaceNameVisible(space);
  }

  public void isSearchedUserNameVisible(String user) {
    unifiedSearchPage.isSearchedUserNameVisible(user);
  }

  public void search(String text) {
    unifiedSearchPage.search(text);
  }

  public void selectDropDown(String object) {
    unifiedSearchPage.selectDropDown(object);
  }

}
