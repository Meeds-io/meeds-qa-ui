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

import static io.meeds.qa.ui.utils.Utils.*;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeVisibleException;

public class HomePage extends GenericPage {

  private static final String PORTAL_ROOT_CONTEXT = "/portal/";

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void acceptConnectionInvitation(String userName) {
    getAcceptIconConnectionFromDrawer(userName).click();
  }

  public void acceptSpaceInvitation(String spaceName) {
    getAcceptIconSpaceFromDrawer(spaceName).click();
  }

  public void accessToAdministrationMenu() {
    if (!getCurrentUrl().contains("/portal/administration")) {
      closeAllDrawers();
      closeAllDialogs();
      administrationMenuElement().waitUntilVisible();
      getDriver().navigate().to(administrationMenuElement().getAttribute("href"));
      verifyPageLoaded();
    }
  }

  public void accessToRecentSpaces() {
    retryOnCondition(() -> {
      clickOnHamburgerMenu(true);
      ElementFacade recentSpacesIconElement = recentSpacesIconElement();
      if (recentSpacesIconElement.isVisible()) {
        recentSpacesIconElement.hover();
        Actions action = new Actions(getDriver());
        action.moveToElement(recentSpacesIconElement).build().perform();
        ElementFacade recentSpacesBtnElement = recentSpacesBtnElement();
        if (recentSpacesBtnElement.isVisible()) {
          recentSpacesBtnElement.click();
        } else {
          throw new ElementShouldBeVisibleException(String.format("Recent spaces arrow should be visible %s",
                                                                  recentSpacesBtnElement),
                                                    null);
        }
      } else {
        throw new ElementShouldBeVisibleException(String.format("Recent spaces icon should be visible %s",
                                                                recentSpacesIconElement),
                                                  null);
      }
      findByXPathOrCSS(".recentSpacesTitle .recentSpacesTitleLabel").checkVisible();
    }, Utils::refreshPage);
  }

  public void bookmarkActivity(String activity) {
    clickOnElement(getFavoriteIconActivity(activity));
  }

  public void checkExistingSpaceInvitation(String spaceName) {
    checkSpaceFromDrawer(spaceName).assertVisible();
  }

  public void checkFavIcon(String activity) {
    getFavoriteIconActivity(activity).assertVisible();
  }

  public void checkNoActivityDisplayed() {
    contextBoxWelcomeActivityElement().assertVisible();
  }

  public void checkNotExistingSpaceInvitation(String spaceName) {
    checkSpaceFromDrawer(spaceName).assertNotVisible();
  }

  public void checkPageIsDisplayed(String pageUri) {
    assertThat(getDriver().getCurrentUrl()).contains(pageUri); // NOSONAR
  }

  public void clickOnArrowIcon() {
    spaceArrowIconElement().click();
  }

  public void clickOnCommentActivityNotification(String message, String activity, String comment) {
    commentActivityNotificationIsDisplayed(message, activity, comment);
    notificationContentElement(message, comment).click();
  }

  public void clickOnConnectionsBagde() {
    connectionsBadgeElement().click();
    waitForDrawerToOpen();
    waitForLoading();
  }

  public void clickOnHomeIcon(String pageName) {
    homeHoverButton(pageName).click();
  }

  public void clickOnHomeLink() {
    clickOnElement(homePageLinkElement());
  }

  public void checkHomeButtonPosition(String pageName) {
    if (getStickiedHamburgerMenuParent().isVisible()) {
      clickOnHamburgerMenu(true);
    }
    if (homeButtonElement(pageName).isNotVisible()) {
      hoverOnPageHomeIcon(pageName);
      clickOnHomeIcon(pageName);
      confirmationForChangeSiteHomeLink();
      homeButtonElement(pageName).assertVisible();
    }
  }

  public void clickOnSpaceInvitationWidget() {
    clickOnElement(spaceInvitationWidgetElement());
  }

  public void clickOnSpacesBagde() {
    clickOnElement(spacesBadgeElement());
  }

  public void clickSeeAll() {
    clickOnElement(seeAllLinkElement());
  }

  public void commentActivityNotificationIsDisplayed(String message, String activity, String comment) {
    retryOnCondition(() -> notificationContentElement(message).checkVisible(),
                     () -> waitFor(2).seconds(),
                     10);
    notificationContentElement(message).assertVisible();
    notificationContentElement(message, activity).assertVisible();
    notificationContentElement(message, comment).assertVisible();
  }

  public void confirmationForChangeSiteHomeLink() {
    clickToConfirmDialog();
    waitFor(200).milliseconds(); // Wait for animation until the home icon
                                 // changes its location
  }

  public void deactivateSwitcher() {
    ElementFacade switcherButtonElement = switcherButtonElement();
    assertTrue(switcherButtonElement.isVisible());
    clickOnElement(switcherButtonElement);
  }

  public void favoriteActivity(String activity) {
    clickOnElement(getFavoriteIconActivity(activity));
  }

  public void goToSite(String siteName) {
    goToSite(siteName, false);
  }

  public void goToSite(String siteName, boolean forceRefresh) {
    if (forceRefresh || !StringUtils.contains(getDriver().getCurrentUrl(), PORTAL_ROOT_CONTEXT + siteName)) {
      if (!getStickiedHamburgerMenuParent().isCurrentlyVisible()) {
        clickOnHamburgerMenu(true);
      }
      ElementFacade hamburgerMenuItemLink = hamburgerMenuItemLink(siteName);
      hamburgerMenuItemLink.assertVisible();
      hamburgerMenuItemLink.click();
      waitForPageLoading();
      assertThat(getDriver().getCurrentUrl()).contains(PORTAL_ROOT_CONTEXT + siteName);
    } else {
      closeAllDrawers();
      closeAllDialogs();
    }
  }

  public void goToSiteNavigation(String siteName, String uriPart) {
    retryOnCondition(() -> goToSiteNavigation(siteName, uriPart, false), () -> closeAllDrawers());
    assertThat(getDriver().getCurrentUrl()).contains(PORTAL_ROOT_CONTEXT + siteName);
    assertThat(getDriver().getCurrentUrl()).contains(uriPart);
  }

  public void goToSiteNavigation(String siteName, String uriPart, boolean forceRefresh) {
    if (forceRefresh
        || !StringUtils.contains(getDriver().getCurrentUrl(), PORTAL_ROOT_CONTEXT + siteName)
        || !StringUtils.endsWith(getDriver().getCurrentUrl(), uriPart)) {
      if (!getStickiedHamburgerMenuParent().isCurrentlyVisible()) {
        clickOnHamburgerMenu(true);
      }
      ElementFacade hamburgerMenuItemLink = hamburgerMenuItemLink(siteName);
      hamburgerMenuItemLink.checkVisible();
      hamburgerMenuItemLink.hover();
      Actions action = new Actions(getDriver());
      action.moveToElement(hamburgerMenuItemLink).build().perform();
      ElementFacade hamburgerMenuSiteArrowIcon = hamburgerMenuSiteArrowIcon();
      hamburgerMenuSiteArrowIcon.checkVisible();
      if (hamburgerMenuSiteArrowIcon.hasClass("fa-arrow-right")) {
        hamburgerMenuSiteArrowIcon.click();
      }
      hamburgerMenuSecondLevelItemLink(uriPart).click();
      waitForPageLoading();
    } else {
      closeAllDrawers();
      closeAllDialogs();
    }
  }

  public void goToAddGroups() {
    goToAdministrationPage("Organization/Groups");
  }

  public void goToAddUser() {
    goToAdministrationPage("Organization/Users");
  }

  public void goToMainSettings() {
    goToAdministrationPage("General/Main Settings", true);
  }

  public void goToNotificationAdminPage() {
    goToAdministrationPage("General/Notifications");
  }

  public void goToAppCenterAdminSetupPage() {
    goToAdministrationPage("Applications/Applications center");
  }

  public void goToHomePage() {
    closeAlertIfOpened();
    getDriver().get(getDriver().getCurrentUrl().split(PORTAL_ROOT_CONTEXT)[0]);
    waitForPageLoading();
  }

  public void goToMyProfile() {
    goToPageWithLink("/profile", true);
  }

  public void goToPeoplePage() {
    goToPageWithLink("/people", true);
  }

  public void goToSettingsPage() {
    goToPageWithLink("/settings", true);
  }

  public void goToSpacesPage(boolean stickMenu) {
    goToPageWithLink("/spaces", stickMenu);
  }

  public void goToStreamPage() {
    goToPageWithLink("/dashboard", true);
  }

  public void hoverOnPageHomeIcon(String pageName) {
    waitFor(300).milliseconds(); // Wait until drawer 'open' animation finishes
    hamburgerMenuItemByName(pageName).hover();
  }

  public void hoverSearchedSpaceInSideBarFilter(String space) {
    searchedSpaceInSideBarFilterHover(space).hover();
  }

  public void isArrowDisplayedAfterHoveringOnSpaceName() {
    spaceArrowIconElement().assertVisible();
  }

  public boolean isConnectionsBadgeWithNumberVisible(String number) {
    return getConnectionsBadgeWithNumber(number).isVisible();
  }

  public boolean isPortalDisplayed() {
    return getSiteBody().isCurrentlyVisible();
  }

  public boolean isHamburgerMenuPresent() {
    return getHamburgerNavigationMenu().isCurrentlyVisible();
  }

  public boolean isLoggedIn() {
    return ((JavascriptExecutor) getDriver()).executeScript("return !!window?.eXo?.env?.portal?.userName?.length")
                                             .toString()
                                             .equals("true");
  }

  public boolean isNoConnectionsBadge() {
    return getConnectionsBadge().isNotVisible();
  }

  public void checkNumberOfConnectionsInDrawer(int expectedNumber) {
    waitForLoading();
    assertThat(getListConnectionInDrawer().size()).isEqualTo(expectedNumber);
  }

  public boolean isNumberOfSpacesInDrawer(int expectedNumber) {
    int listOfSpaces = getListSpaceInDrawer().size();
    return listOfSpaces == expectedNumber;
  }

  public boolean isSpacesBadgeWithNumberVisible(String number) {
    return getSpacesBadgeWithNumber(number).isVisible();
  }

  public void checkThirdLevelNavigationDisplayed() {
    thirdLevelNavigationElement().assertVisible();
  }

  public boolean isWidgetWithNumberVisible(String widget, String number) {
    closeAllDrawers();
    return getProfileWidgetContent(widget, number).isVisible();
  }

  public void openAllApplicationPage() {
    waitForPageLoading();
    clickOnElement(viewAllApplicationLinkElement());
    waitForPageLoading();
  }

  public void openConnectionRequestDrawer() {
    ElementFacade badgeButton = findByXPathOrCSS("#profile-stats-connectionsCount .v-badge button");
    clickOnElement(badgeButton);
  }

  public void openNotifications() {
    clickOnElement(notificationIconElement());
  }

  public void rejectConnexionInvitation(String userName) {
    clickOnElement(getRejectIconConnectionFromDrawer(userName));
  }

  public void rejectSpaceInvitation(String spaceName) {
    clickOnElement(getRejectIconSpaceFromDrawer(spaceName));
  }

  public void searchApplicationCenter(String app) {
    ElementFacade adminUiElement = findByXPathOrCSS("//*[contains(@class, 'listApplications')]//tr");
    boolean isAdminUI = adminUiElement.isCurrentlyVisible();
    searchApplicationCenterInputElement().setTextValue(app);
    waitUntilAppCenterSearchFinishes(isAdminUI);
  }

  public void searchedSpaceIsDisplayedInSideBarFilter(String space) {
    recentSpaceElement(space).assertVisible();
  }

  public void searchedSpaceIsNotDisplayedInSideBarFilter(String space) {
    recentSpaceElement(space).assertNotVisible();
  }

  public void searchSpaceInSideBarFilter(String space) {
    clickOnElement(sideBarFilterSpacesElement());
    TextBoxElementFacade sideBarFilterSpacesInputElement = sideBarFilterSpacesInputElement();
    sideBarFilterSpacesInputElement.waitUntilVisible();
    sideBarFilterSpacesInputElement.setTextValue(space);
  }

  public void selectAllOrMySpaces(String filter) {
    selectSpacesFilterElement().selectByVisibleText(filter);
  }

  public void unbookmarkActivity(String activity) {
    clickOnElement(getFavoriteIconActivity(activity));
  }

  public void openHamburgerMenuDrawer() {
    clickOnHamburgerMenu(false);
    myProfileButtonElement().hover();
  }

  public void clickOnHamburgerMenu(boolean stickMenu) {
    if (getCurrentUrl().contains("/portal/administration")) {
      getDriver().navigate().to(getCurrentUrl().split("/portal")[0]);
      verifyPageLoaded();
    }
    retryOnCondition(() -> {
      closeToastNotification(false);
      closeAllDialogs();
      closeAllDrawers();
      int i = MAX_WAIT_RETRIES;
      if (myProfileButtonElement().isNotVisible() && --i > 0) {
        getHamburgerNavigationMenu().click();
        waitForDrawerToOpen();
        if (stickMenu) {
          stickHamburgerMenu();
        }
      }
      myProfileButtonElement().checkVisible();
    }, () -> LOGGER.warn("Hamburger Menu isn't visible, retry by waiting until application is built"));
  }

  public void checkHamburgerMenuSpacePosition(String spaceName, int spaceMenuPosition) {
    if (!getStickiedHamburgerMenuParent().isCurrentlyVisible()) {
      clickOnHamburgerMenu(true);
    }
    recentSpaceFirstLevelMenuItem(spaceName, spaceMenuPosition).assertVisible();
  }

  public void checkHamburgerMenuRecentSpaceMenuApplication(String spaceName, String appName, int appPosition) {
    openHamburgerMenuRecentSpaceDetails(spaceName);
    recentSpaceSecondLevelMenuApplication(appName, appPosition).assertVisible();
  }

  public void checkHamburgerMenuSpaceDescriptionAndName(String randomSpaceName) {
    recentSpaceSecondLevelSpaceName(randomSpaceName).assertVisible();
    recentSpaceSecondLevelSpaceDescription(randomSpaceName).assertVisible();
  }

  public void openHamburgerMenuRecentSpaceDetails(String spaceName) {
    if (!getStickiedHamburgerMenuParent().isCurrentlyVisible()) {
      clickOnHamburgerMenu(true);
    }
    ElementFacade menuItem = recentSpaceFirstLevelMenuItem(spaceName);
    menuItem.assertVisible();
    menuItem.hover();
    waitFor(200).milliseconds(); // Wait for drawer to completely open
    ElementFacade arrowIcon = recentSpaceFirstLevelMenuArrowIcon(spaceName);
    arrowIcon.assertVisible();
    arrowIcon.click();
    waitFor(200).milliseconds(); // Wait for drawer to completely open
    recentSpaceSecondLevelSpaceName(spaceName).waitUntilVisible();
  }

  public void checkHamburgerMenuUnsticked() {
    stickHamburgerMenuElement().checkNotVisible();
  }

  public void checkHamburgerMenuSticked() {
    unstickHamburgerMenuElement().checkVisible();
  }

  public void checkHamburgerMenuNavigations() {
    findByXPathOrCSS(".HamburgerNavigationMenu #ProfileHamburgerNavigation").checkVisible();
    findByXPathOrCSS(".HamburgerNavigationMenu #SiteHamburgerNavigation").checkVisible();
    findByXPathOrCSS(".HamburgerNavigationMenu #RecentSpaceHamburgerNavigation").checkVisible();
    findByXPathOrCSS(".HamburgerNavigationMenu #RecentSpaceHamburgerNavigation").checkVisible();
    findByXPathOrCSS(".HamburgerNavigationMenu #UserHamburgerNavigation .settingsTitle").checkVisible();
    findByXPathOrCSS(".HamburgerNavigationMenu #UserHamburgerNavigation .logoutLinks").checkVisible();
  }

  public void stickHamburgerMenu() {
    stickHamburgerMenuElement().click();
  }

  public void unstickHamburgerMenu() {
    unstickHamburgerMenuElement().click();
  }

  public void checkRedDotInHamburgerMenu() {
    getHamburgerNavigationMenu().assertVisible();
    retryOnCondition(() -> findByXPathOrCSS(".hamburger-unread-badge ").checkVisible());
  }

  public void checkRedDotNotInHamburgerMenu() {
    getHamburgerNavigationMenu().assertVisible();
    retryOnCondition(() -> findByXPathOrCSS(".hamburger-unread-badge ").checkNotVisible());
  }

  public void hoverOnHamburgerMenu() {
    getHamburgerNavigationMenu().hover();
  }

  public void hoverOutsideHamburgerMenu() {
    getDrawerOverlay().hover();
  }

  public void closeHamburgerMenu() {
    getHamburgerNavigationMenuDrawer().checkNotVisible();
  }

  public void waitPortalDisplayed(int retries) {
    while (!isPortalDisplayed() && retries-- > 0) {
      waitFor(1).seconds();
    }
  }

  private void goToAdministrationPage(String uri) {
    goToAdministrationPage(uri, false);
  }

  private void goToAdministrationPage(String menuItem, boolean forceRefresh) {
    if (forceRefresh || !StringUtils.contains(getDriver().getCurrentUrl(), menuItem)) {
      accessToAdministrationMenu();
      String[] menuParts = menuItem.split("/");
      retryOnCondition(() -> {
        if (!administrationMenuItem(menuParts[1]).isCurrentlyVisible()) {
          administrationMenuItem(menuParts[0]).click();
          administrationMenuItem(menuParts[1]).checkVisible();
        }
        administrationMenuItem(menuParts[1]).click();
      });
      waitForPageLoading();
    }
  }

  private void goToPageWithLink(String linkSuffix, boolean stickMenu) {
    closeAllDrawers();
    String currentUrl = getDriver().getCurrentUrl();
    if (currentUrl.endsWith(linkSuffix) && !currentUrl.endsWith("g:")) {
      return;
    } else if (!getStickiedHamburgerMenuParent().isCurrentlyVisible()) {
      clickOnHamburgerMenu(stickMenu);
    }
    String siteName = getSiteName(linkSuffix);
    if (StringUtils.isNotBlank(siteName)) {
      retryOnCondition(() -> {
        ElementFacade menuItem = siteFirstLevelMenuItem(siteName);
        menuItem.assertVisible();
        menuItem.hover();
        ElementFacade arrowIcon = siteFirstLevelMenuItemArrowIcon(siteName);
        arrowIcon.assertVisible();
        arrowIcon.hover();
      });
      siteSecondLevelMenuItem(linkSuffix).checkVisible();
      siteSecondLevelMenuItem(linkSuffix).click();
    } else {
      retryOnCondition(() -> {
        ElementFacade hamburgerMenuItemLink = hamburgerMenuItemLink(linkSuffix);
        hamburgerMenuItemLink.checkVisible();
        hamburgerMenuItemLink.click();
        waitForPageLoading();
      });
    }
    assertThat(getDriver().getCurrentUrl()).endsWith(linkSuffix);
  }

  private ElementFacade administrationMenuItem(String name) {
    return findByXPathOrCSS(String.format("//*[@id = 'siteNavigationTree']//*[contains(text(), '%s')]",
                                          name));
  }

  private ElementFacade stickHamburgerMenuElement() {
    return findByXPathOrCSS(".HamburgerNavigationMenu .fa-angle-double-right");
  }

  private ElementFacade unstickHamburgerMenuElement() {
    return findByXPathOrCSS(".HamburgerNavigationMenu .fa-angle-double-left");
  }

  private ElementFacade siteFirstLevelMenuItem(String siteName) {
    return findByXPathOrCSS(String.format("//*[@role='navigation']//a[contains(@href, '/portal/%s')]",
                                          siteName));
  }

  private ElementFacade siteFirstLevelMenuItemArrowIcon(String siteName) {
    return findByXPathOrCSS(String.format("//*[@role='navigation']//a[contains(@href, '/portal/%s')]//*[contains(@class, 'fa-arrow-right')]",
                                          siteName));
  }

  private ElementFacade siteSecondLevelMenuItem(String link) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'siteDetails')]//a[contains(@href, '%s')]",
                                          link));
  }

  private ElementFacade recentSpaceFirstLevelMenuItem(String spaceName, int spaceMenuPosition) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'spacesNavigationContent')]//a[contains(@class, 'spaceItem')]/parent::*/a[%s]//*[contains(text(), '%s')]",
                                          spaceMenuPosition,
                                          spaceName));
  }

  private ElementFacade recentSpaceFirstLevelMenuItem(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'spacesNavigationContent')]//*[contains(text(), '%s')]//ancestor::a[contains(@class, 'spaceItem')]//*[contains(@class, 'v-image')]",
                                          spaceName));
  }

  private ElementFacade recentSpaceFirstLevelMenuArrowIcon(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'spacesNavigationContent')]//*[contains(text(), '%s')]//ancestor::a[contains(@class, 'spaceItem')]//*[contains(@class, 'fa-arrow')]",
                                          spaceName));
  }

  private ElementFacade recentSpaceSecondLevelMenuApplication(String appName, int appPosition) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'HamburgerMenuSecondLevelParent')]//*[contains(text(), '%s')]//ancestor::a/parent::*/a[%s]",
                                          appName,
                                          appPosition));
  }

  private ElementFacade recentSpaceSecondLevelSpaceName(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'HamburgerMenuSecondLevelParent')]//a/parent::*/*[contains(text(), '%s')]",
                                          spaceName));
  }

  private ElementFacade recentSpaceSecondLevelSpaceDescription(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'HamburgerMenuSecondLevelParent')]//p[contains(text(), '%s')]",
                                          spaceName));
  }

  private ElementFacade administrationMenuElement() {
    return findByXPathOrCSS("//*[@id='platformSettings']//a");
  }

  private ElementFacade checkSpaceFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'spaceDrawer')]//descendant::div[contains(text(),'%s')]//ancestor::*[@role = 'listitem']//*[contains(@class,'check')]",
                                          spaceName));
  }

  private ElementFacade connectionsBadgeElement() {
    return findByXPathOrCSS("(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[2]");
  }

  private ElementFacade contextBoxWelcomeActivityElement() {
    return findByXPathOrCSS("//*[@id='ActivityContextBoxWelcomeActivity']");
  }

  private ElementFacade getAcceptIconConnectionFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'connectionsDrawer')]//descendant::div[contains(text(),'%s')]//ancestor::*[@role = 'listitem']//*[contains(@class,'check')]",
                                          spaceName));
  }

  private ElementFacade getAcceptIconSpaceFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                                          spaceName));
  }

  private ElementFacade getConnectionsBadge() {
    return findByXPathOrCSS("//div[contains(@class,'profileCard')]//*[contains(text(),'Connections')]/preceding::*[@class='v-btn__content'][1]");
  }

  private ElementFacade getConnectionsBadgeWithNumber(String number) {
    return findByXPathOrCSS(
                            String.format("//div[contains(@class,'profileCard')]//*[contains(text(),'Connections')]/preceding::*[@class='v-btn__content' and contains(text(),'%s')][1]",
                                          number));
  }

  private ElementFacade getFavoriteIconActivity(String activity) {
    return findByXPathOrCSS(String.format(
                                          "//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]//preceding::i[contains(@class,'fa-star')][01]",
                                          activity));
  }

  private ElementFacade getHamburgerNavigationMenu() {
    return findByXPathOrCSS(".HamburgerNavigationMenu");
  }

  private ElementFacade getStickiedHamburgerMenuParent() {
    return findByXPathOrCSS("#ParentSiteStickyMenu .HamburgerNavigationMenu");
  }

  private ElementFacade getDrawerOverlay() {
    return findByXPathOrCSS("#drawers-overlay");
  }

  private ElementFacade getSiteBody() {
    return findByXPathOrCSS("#UISiteBody");
  }

  private ElementFacade getHamburgerNavigationMenuDrawer() {
    return findByXPathOrCSS(".HamburgerNavigationMenuLink .v-navigation-drawer");
  }

  private List<WebElementFacade> getListConnectionInDrawer() {
    return findAll("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@class,'connectionsRequests')]//*[contains(@class,'request-user-name')]");
  }

  private List<WebElementFacade> getListSpaceInDrawer() {
    return findAll("//aside[contains(@class,'spaceDrawer ')]//div[@role='list']//descendant::div[@role='listitem']");
  }

  private ElementFacade getProfileWidgetContent(String widget, String number) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'profileCard')]//div[contains(@class,'mx-0')]//span[text()='%s']/../..//span[text()='%s']",
                                          widget,
                                          number));
  }

  private ElementFacade getRejectIconConnectionFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'connectionsDrawer')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
                                          spaceName));
  }

  private ElementFacade getRejectIconSpaceFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
                                          spaceName));
  }

  private ElementFacade getSpacesBadgeWithNumber(String number) {
    return findByXPathOrCSS(
                            String.format("//div[contains(@class,'profileCard')]//*[contains(text(),'Spaces')]/preceding::*[@class='v-btn__content' and contains(text(),'%s')][1]",
                                          number));
  }

  private ElementFacade homeHoverButton(String pageName) {
    return findByXPathOrCSS(String.format("//*[@id='SiteHamburgerNavigation']//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'UserPageLink')]//*[contains(@class, 'homePage')]",
                                          pageName));
  }

  private ElementFacade homeButtonElement(String pageName) {
    return findByXPathOrCSS(String.format("//*[@id='SiteHamburgerNavigation']//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'UserPageLinkHome')]//*[contains(@class, 'homePage')]",
                                          pageName));
  }

  private ElementFacade homePageLinkElement() {
    return findByXPathOrCSS("//*[contains(@class, 'UserPageLinkHome')]//i");
  }

  private ElementFacade myProfileButtonElement() {
    return findByXPathOrCSS("//*[@id='ProfileHamburgerNavigation']//a[contains(@href, '/profile')]//*[contains(@class, 'v-avatar')]");
  }

  private ElementFacade notificationIconElement() {
    return findByXPathOrCSS("#NotificationPopoverPortlet");
  }

  private ElementFacade recentSpaceElement(String space) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'recentSpacesWrapper')]//*[contains(text(), '%s')]",
                                          space));
  }

  private ElementFacade recentSpacesBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'spacesNavigationTitle')]//*[contains(@class,'fa fa-arrow')]");
  }

  private ElementFacade recentSpacesIconElement() {
    return findByXPathOrCSS("//*[contains(@class,'spacesNavigationTitle')]//*[contains(@class,'titleIcon')]");
  }

  private TextBoxElementFacade searchApplicationCenterInputElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-text-field__slot']//input");
  }

  private ElementFacade searchedSpaceInSideBarFilterHover(String space) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'recentSpacesWrapper')]//*[@class='v-list-item__content']//*[contains(text(), '%s')]",
                                          space));
  }

  private ElementFacade seeAllLinkElement() {
    return findByXPathOrCSS("//aside[contains(@class,'v-navigation-drawer')]//span[contains(text(),'See all')]");
  }

  private ElementFacade selectSpacesFilterElement() {
    return findByXPathOrCSS("//*[contains(@class,'selectSpacesFilter')]");
  }

  private TextBoxElementFacade sideBarFilterSpacesElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]");
  }

  private TextBoxElementFacade sideBarFilterSpacesInputElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]//*[contains(@class,'v-input recentSpacesFilter')]//input");
  }

  private ElementFacade spaceArrowIconElement() {
    return findByXPathOrCSS("//*[contains(@class,'recentSpacesWrapper')]//*[contains(@class,'fa-arrow')]");
  }

  private ElementFacade spaceInvitationWidgetElement() {
    return findByXPathOrCSS("//*[@id='profile-stats-spacesCount']//*[contains(@class, 'v-badge')]");
  }

  private ElementFacade spacesBadgeElement() {
    return findByXPathOrCSS("(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[1]");
  }

  private ElementFacade hamburgerMenuItemLink(String pageUri) {
    return Stream.of(hamburgerMenuItemLinkText(pageUri), hamburgerMenuItemLinkParent(pageUri))
                 .filter(ElementFacade::isCurrentlyVisible)
                 .findFirst()
                 .orElseThrow();
  }

  private ElementFacade hamburgerMenuItemLinkText(String pageUri) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'HamburgerNavigationMenu')]//a[contains(@href, '%s')]//*[contains(@class, 'menu-text-color')]",
                                          pageUri));
  }

  private ElementFacade hamburgerMenuItemLinkParent(String pageUri) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'HamburgerNavigationMenu')]//a[contains(@href, '%s')]",
                                          pageUri));
  }

  private ElementFacade hamburgerMenuSecondLevelItemLink(String pageUri) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'HamburgerMenuSecondLevelParent')]//a[contains(@href, '%s')]//*[contains(@class, 'menu-text-color')]",
                                          pageUri));
  }

  private ElementFacade hamburgerMenuItemByName(String pageName) {
    return findByXPathOrCSS(String.format("//*[@id='SiteHamburgerNavigation']//*[contains(text(), '%s')]",
                                          pageName));
  }

  private ElementFacade switcherButtonElement() {
    return findByXPathOrCSS("(//*[@class='providersTableRow']//*[@class='center actionContainer']/div)[1]");
  }

  private ElementFacade thirdLevelNavigationElement() {
    return findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]");
  }

  private ElementFacade viewAllApplicationLinkElement() {
    return findByXPathOrCSS("//a[contains(@class,'seeAllApplicationsBtn')]");
  }

  private ElementFacade hamburgerMenuSiteArrowIcon() {
    return findByXPathOrCSS("//*[contains(@class, 'HamburgerNavigationMenu')]//*[contains(@class,'fa fa-arrow')]");
  }

  private void waitUntilAppCenterSearchFinishes(boolean isAdminUI) {
    if (isAdminUI) {
      findByXPathOrCSS("(//*[contains(@class, 'listApplications')]//tr)[3]").waitUntilNotVisible();
    } else {
      findByXPathOrCSS("(//*[contains(@class, 'userAuthorizedApplications')]//*[contains(@class, 'authorizedApplication')])[2]").waitUntilNotVisible();
    }
  }

  private String getSiteName(String linkSuffix) {
    if (linkSuffix.equals("/programs")
        || linkSuffix.equals("/actions")
        || linkSuffix.equals("/wallet")) {
      return "contribute";
    } else if (linkSuffix.equals("/dashboard")
               || linkSuffix.equals("/tasks")
               || linkSuffix.equals("/contents")
               || linkSuffix.equals("/myteam")) {
      return "mycraft";
    }
    return null;
  }

}
