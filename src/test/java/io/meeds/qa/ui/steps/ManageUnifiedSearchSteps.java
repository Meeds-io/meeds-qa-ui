package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.UnifiedSearchPage;

public class ManageUnifiedSearchSteps {
  private UnifiedSearchPage unifiedSearchPage;

  public void search(String text) {
    unifiedSearchPage.search(text);
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

  public void goToTheSearchedApplication(String appName) {
    unifiedSearchPage.goToTheSearchedApplication(appName);
  }

  public void goToTheSearchedSpace(String space) {
    unifiedSearchPage.goToTheSearchedSpace(space);
  }

  public void goToTheSearchedActivity() {
    unifiedSearchPage.goToTheSearchedActivity();
  }

  public void accessUnifiedSearchPage() {
    unifiedSearchPage.openSearchApplication();
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
