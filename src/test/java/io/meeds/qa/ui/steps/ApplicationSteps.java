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

import io.meeds.qa.ui.pages.ApplicationPage;

public class ApplicationSteps {

  private ApplicationPage applicationPage;

  public void addRemoveApplicationToFavorites(String app) {
    applicationPage.addRemoveApplicationToFavorites(app);
  }

  public void bookmarkApplication(String appTitle) {
    applicationPage.bookmarkApplication(appTitle);
  }

  public void checkApplicationIsNotVisible(String applicationName) {
    applicationPage.checkApplicationIsNotVisible(applicationName);
  }

  public void checkApplicationIsVisible(String applicationName) {
    applicationPage.checkApplicationIsVisible(applicationName);
  }

  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {

    applicationPage.checkThatAddApplicationBtnToFavoritesIsDisplayed(app);
  }

  public void checkThatAppcenterApplicationIsDisplayed(String app) {

    applicationPage.checkThatAppcenterApplicationIsDisplayed(app);
  }

  public void checkThatAppcenterApplicationIsNotDisplayed(String app) {

    applicationPage.checkThatAppcenterApplicationIsNotDisplayed(app);
  }

  public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {

    applicationPage.checkThatApplicationIsDisplayedInFavoriteApps(app);
  }

  public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {

    applicationPage.checkThatApplicationIsNotDisplayedInFavoriteApps(app);
  }

  public void checkThatOpenApplicationButtonIsDisplayed(String app) {
    applicationPage.checkThatOpenApplicationButtonIsDisplayed(app);
  }

  public void clickOnOpenApplicationButton(String app) {
    applicationPage.clickOnOpenApplicationButton(app);
  }

  public void clickOnTheAppLauncherIcon() {
    applicationPage.clickOnTheAppLauncherIcon();
  }

  public void goToApplication(String applicationName) {
    applicationPage.goToApplication(applicationName);
  }

  public void maxFavoriteAppsIsDisplayed() {
    applicationPage.maxFavoriteAppsIsDisplayed();
  }

  public void seeAllApplications() {
    applicationPage.seeAllApplications();
  }

  public void settingsPageIsOpened() {
    applicationPage.settingsPageIsOpened();
  }

  public void starButtonIsDisabled(String appTitle) {
    applicationPage.starButtonIsDisabled(appTitle);
  }

  public void starButtonIsNotSelected(String appTitle) {
    applicationPage.starButtonIsNotSelected(appTitle);
  }

  public void starButtonIsSelected(String appTitle) {
    applicationPage.starButtonIsSelected(appTitle);
  }

  public void unbookmarkApplication(String appTitle) {
    applicationPage.unbookmarkApplication(appTitle);
  }

}
