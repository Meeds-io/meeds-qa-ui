/*
 * This file is part of the Meeds project (https://meeds.io/).
 * 
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.UnifiedSearchPage;

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
