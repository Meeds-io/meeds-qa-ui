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
package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class UnifiedSearchPage extends GenericPage {
  public UnifiedSearchPage(WebDriver driver) {
    super(driver);
  }

  public void clickFavoriteBtn() {
    ElementFacade favoritesBtnElement = favoritesBtnElement();
    favoritesBtnElement.waitUntilVisible();
    favoritesBtnElement.waitUntilClickable();
    favoritesBtnElement.click();
  }

  public void favoriteSearchedActivity(String activity) {
    getFavoriteIconSearchedActivity(activity).click();
    toolbarSearchButtonElement().hover(); // A trick to hover outside user
                                          // popover to be
    // closed
  }

  public void goToTheSearchedActivity() {
    elementAccessToSearchedActivityElement().click();
  }

  public void goToTheSearchedApplication(String appName) {
    getApplicationSearchTitle(appName).click();
  }

  public void goToTheSearchedSpace(String space) {
    getSpaceSearchTitle(space).click();
  }

  public void isSearchedActivityTitleNotVisible(String activity) {
    retryOnCondition(() -> getActivitySearchTitle(activity).checkNotVisible(), () -> {
      waitFor(1).seconds(); // The element can be not indexed yet
      refreshPage();
    });
  }

  public void isSearchedActivityTitleVisible(String activity) {
    retryOnCondition(() -> getActivitySearchTitle(activity).checkVisible(), () -> {
      waitFor(1).seconds(); // The element can be not indexed yet
      refreshPage();
    });
  }

  public void isSearchedApplicationDescriptionVisible(String appDesc) {
    getApplicationSearchDescription(appDesc).assertVisible();
  }

  public void isSearchedApplicationNameVisible(String appName) {
    getApplicationSearchTitle(appName).assertVisible();
  }

  public void isSearchedApplicationPictureVisible() {
    elementApplicationSearchPictureElement().assertVisible();
  }

  public void isSearchedSpaceNameVisible(String space) {
    getSpaceSearchTitle(space).assertVisible();
  }

  public void isSearchedUserNameVisible(String user) {
    getUserSearchTitle(user).assertVisible();
  }

  public void openSearchApplication() {
    toolbarSearchButtonElement().click();
  }

  public void search(String text) {
    openSearchApplication();
    searchInputElement().setTextValue(text);
    waitFor(300).milliseconds(); // Wait for search to be used
    waitForLoading();
  }

  public void selectDropDown(String object) {
    shipFormAllElement().click();
    getObjectFromDropDown(object).click();

  }

  private ElementFacade elementAccessToSearchedActivityElement() {
    return findByXPathOrCSS("(//*[@class='v-list-item__content']//*[@class='v-list-item__title'])[1]");
  }

  private ElementFacade elementApplicationSearchPictureElement() {
    return findByXPathOrCSS("//*[@class='v-responsive v-image appImage']");
  }

  private ElementFacade favoritesBtnElement() {
    return findByXPathOrCSS("//*[contains(@class, 'searchConnectorsParent')]//i[contains(@class, 'fa-star')]//ancestor::*[contains(@class, 'v-chip--clickable')]");
  }

  private ElementFacade getActivitySearchTitle(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s') or contains(@title, '%s')]//ancestor::*[contains(@class, 'searchCard')]",
                                          activity,
                                          activity));
  }

  private ElementFacade getApplicationSearchDescription(String appDesc) {
    return findByXPathOrCSS(String.format("//*[@title='%s']", appDesc));
  }

  private ElementFacade getApplicationSearchTitle(String appName) {
    return findByXPathOrCSS(String.format("//*[@title='%s']", appName));
  }

  private ElementFacade getFavoriteIconSearchedActivity(String activity) {
    return findByXPathOrCSS(String.format(
                                          "(//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'searchCard')]//*[contains(@class, 'fa-star')])[1]",
                                          activity));
  }

  private ElementFacade getObjectFromDropDown(String object) {
    return findByXPathOrCSS(String.format("//div[@class='v-input--selection-controls__input']//preceding::span[@class='subtitle-1'and contains(text(),'%s')]",
                                          object));
  }

  private ElementFacade getSpaceSearchTitle(String space) {
    return findByXPathOrCSS(String.format("//*[@class='spaceCardFront']//*[contains(text(),'%s')]", space));
  }

  private ElementFacade getUserSearchTitle(String user) {
    return findByXPathOrCSS(String.format("//*[@id='searchDialog']//a[@title='%s']", user));
  }

  private TextBoxElementFacade searchInputElement() {
    return findTextBoxByXPathOrCSS("//*[@id='SearchApplication']//input[@id = 'searchInput']");
  }

  private ElementFacade shipFormAllElement() {
    return findByXPathOrCSS("//span[@class='me-8' and contains(text(),'All')]");
  }

  private ElementFacade toolbarSearchButtonElement() {
    return findByXPathOrCSS("//*[@id='SearchApplication']//i[contains(@class,'fa-search')]//ancestor::button");
  }

}
