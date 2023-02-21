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

import static io.meeds.qa.ui.utils.ExceptionLauncher.LOGGER;
import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeVisibleException;

public class HomePage extends GenericPage {

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void acceptConnectionInvitation(String userName) {
    clickOnElement(getAcceptIconConnectionFromDrawer(userName));
  }

  public void acceptSpaceInvitation(String spaceName) {
    clickOnElement(getAcceptIconSpaceFromDrawer(spaceName));
  }

  public void accessToAdministrationMenu() {
    retryOnCondition(() -> {
      clickOnHamburgerMenu();
      administrationMenuElement().waitUntilVisible();
      ElementFacade administrationIconElement = administrationIconElement();
      if (administrationIconElement.isVisible()) {
        waitFor(300).milliseconds(); // Wait for animations to finish
        Actions action = new Actions(getDriver());
        action.moveToElement(administrationIconElement).build().perform();
        ElementFacade arrowAdminstrationMenuElement = arrowAdminstrationMenuElement();
        if (arrowAdminstrationMenuElement.isVisible()) {
          arrowAdminstrationMenuElement.click();
        } else {
          throw new ElementShouldBeVisibleException(String.format("Administration menu arrow should be visible %s",
                                                                  arrowAdminstrationMenuElement),
                                                    null);
        }
        ElementFacade administrationMenuElement =
                                                findByXPathOrCSS("#AdministrationHamburgerNavigation .subItemTitle");
        if (!administrationMenuElement.isVisible()) {
          throw new ElementShouldBeVisibleException(String.format("Administration menu drawer should be visible %s",
                                                                  administrationMenuElement),
                                                    null);
        }
      } else {
        throw new ElementShouldBeVisibleException(String.format("Administration menu cog icon should be visible %s",
                                                                administrationIconElement),
                                                  null);
      }
    }, Utils::refreshPage);
  }

  public void accessToRecentSpaces() {
    retryOnCondition(() -> {
      clickOnHamburgerMenu();
      ElementFacade recentSpacesIconElement = recentSpacesIconElement();
      if (recentSpacesIconElement.isVisible()) {
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
        ElementFacade recentSpacesMenuElement =
                                              findByXPathOrCSS(".recentSpacesTitle .recentSpacesTitleLabel");
        if (!recentSpacesMenuElement.isVisible()) {
          throw new ElementShouldBeVisibleException(String.format("Recent spaces drawer should be visible %s",
                                                                  recentSpacesMenuElement),
                                                    null);
        }
      } else {
        throw new ElementShouldBeVisibleException(String.format("Recent spaces icon should be visible %s",
                                                                recentSpacesIconElement),
                                                  null);
      }
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

  public void checkFavSuccessMessage(String message) {
    getFavoriteSucessMessage(message).assertVisible();
  }

  public void checkNoActivityDisplayed() {
    contextBoxWelcomeActivityElement().assertVisible();
  }

  public void checkNotExistingSpaceInvitation(String spaceName) {
    checkSpaceFromDrawer(spaceName).assertNotVisible();
  }

  public void checkThatStreamPageIsDisplayed() {
    streamPageViewElement().assertVisible();
  }

  public void clickOnArrowIcon() {
    spaceArrowIconElement().click();
  }

  public void clickOnCommentActivityNotification(String message, String activity, String comment) {
    ElementFacade firstNotificationContentElement = firstNotificationContentElement();
    if (firstNotificationContentElement.getText().contains(message)) {
      Assert.assertTrue(firstNotificationContentElement.getText().contains(message));
      Assert.assertTrue(firstNotificationContentElement.getText().contains(activity));
      Assert.assertTrue(firstNotificationContentElement.getText().contains(comment));
      clickOnElement(firstNotificationContentElement);

    } else {
      ElementFacade secondNotificationContentElement = secondNotificationContentElement();
      Assert.assertTrue(secondNotificationContentElement.getText().contains(message));
      Assert.assertTrue(secondNotificationContentElement.getText().contains(activity));
      Assert.assertTrue(secondNotificationContentElement.getText().contains(comment));
      clickOnElement(secondNotificationContentElement);
    }
  }

  public void clickOnConnectionsBagde() {
    clickOnElement(connectionsBadgeElement());
  }

  public void clickOnHamburgerIcon() {
    clickOnHamburgerMenu();
  }

  public void clickOnHomeIcon() {
    clickOnElement(homeIconElement());
  }

  public void clickOnHomePageButton() {
    clickOnElement(homePageButtonElement());
  }

  public void clickOnSpaceInvitationWidget() {
    clickOnElement(spaceInvitaitationWidgetElement());
  }

  public void clickOnSpacesBagde() {
    clickOnElement(spacesBadgeElement());
  }

  public void clickSeeAll() {
    clickOnElement(seeAllLinkElement());
  }

  public void commentActivityNotificationIsDisplayed(String message, String activity, String comment) {
    ElementFacade firstNotificationContentElement = firstNotificationContentElement();
    String text = firstNotificationContentElement.getText();
    if (text.contains(message)) {
      Assert.assertTrue(text.contains(activity));
      Assert.assertTrue(text.contains(comment));
    } else {
      ElementFacade secondNotificationContentElement = secondNotificationContentElement();
      String secondNotificationText = secondNotificationContentElement.getText();
      Assert.assertTrue(secondNotificationText.contains(message));
      Assert.assertTrue(secondNotificationText.contains(activity));
      Assert.assertTrue(secondNotificationText.contains(comment));
    }
  }

  public void confirmationForChangeSiteHomeLink() {
    clickOnElement(confirmationForChangeSiteHomeLinkElement());
    refreshPage();
  }

  public void deactivateSwitcher() {
    ElementFacade switcherButtonElement = switcherButtonElement();
    assertTrue(switcherButtonElement.isVisible());
    clickOnElement(switcherButtonElement);
  }

  public void favoriteActivity(String activity) {
    clickOnElement(getFavoriteIconActivity(activity));
  }

  public void goToAddGroups() {
    if (!StringUtils.contains(getDriver().getCurrentUrl(), "groupsManagement")) {
      accessToAdministrationMenu();
      clickOnElement(findByXPathOrCSS("//a[contains(@href, '/groupsManagement')]"));
    }
  }

  public void goToAddUser() {
    if (!StringUtils.contains(getDriver().getCurrentUrl(), "usersManagement")) {
      accessToAdministrationMenu();
      clickOnElement(findByXPathOrCSS("//a[contains(@href, '/usersManagement')]"));
    }
  }

  public void goToAppCenterAdminSetupPage() {
    accessToAdministrationMenu();
    clickOnElement(findByXPathOrCSS("//a[contains(@href,'appCenterAdminSetup')]"));
    waitForPageLoading();
  }

  public void goToHomePage() {
    String currentUrl = getDriver().getCurrentUrl();
    if (currentUrl.endsWith("/") && !currentUrl.endsWith("g:")) {
      refreshPage(false);
      return;
    }
    closeAlertIfOpened();
    waitForPageLoading();
    getDriver().get(getDriver().getCurrentUrl().split("/portal/")[0]);
    waitForPageLoading();
  }

  public void goToMyProfile() {
    String currentUrl = getDriver().getCurrentUrl();
    if (currentUrl.endsWith("/profile") && !currentUrl.endsWith("g:")) {
      refreshPage(false);
      return;
    }
    clickOnHamburgerMenu();
    clickOnElement(myProfileButtonElement());
    waitForPageLoading();
  }

  public void goToPeoplePage() {
    String currentUrl = getDriver().getCurrentUrl();
    if (currentUrl.endsWith("/people") && !currentUrl.endsWith("g:")) {
      refreshPage(false);
      return;
    }
    clickOnHamburgerMenu();
    clickOnElement(peoplePageLinkElement());
    waitForPageLoading();
  }

  public void goToSettingsPage() {
    String currentUrl = getDriver().getCurrentUrl();
    if (currentUrl.endsWith("/settings") && !currentUrl.endsWith("g:")) {
      refreshPage(false);
      return;
    }
    clickOnHamburgerMenu();
    clickOnElement(settingsPageLinkElement());
    waitForPageLoading();
  }

  public void goToSpacesPage() {
    String currentUrl = getDriver().getCurrentUrl();
    if (currentUrl.endsWith("/spaces") && !currentUrl.endsWith("g:")) {
      refreshPage(false);
      return;
    }
    clickOnHamburgerMenu();
    openSpacesPageLinkElement().click();
    waitForPageLoading();
  }

  public void goToStreamPage() {
    String currentUrl = getDriver().getCurrentUrl();
    if (currentUrl.endsWith("/stream") && !currentUrl.endsWith("g:")) {
      refreshPage(false);
      return;
    }
    clickOnHamburgerMenu();
    clickOnElement(streamPageLinkElement());
    waitForPageLoading();
  }

  public void goToTasksPage() {
    String currentUrl = getDriver().getCurrentUrl();
    if (currentUrl.endsWith("/tasks") && !currentUrl.endsWith("g:")) {
      refreshPage(false);
      return;
    }
    waitForPageLoading();
    clickOnElement(tasksSnapshotPageButtonElement());
    waitForPageLoading();
  }

  public void hoverOnStreamIcon() {
    waitFor(300).milliseconds(); // Wait until drawer 'open' animation finishes
    streamPageLinkElement().hover();
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

  public boolean isElementVisible(String elementName) {
    switch (elementName) {
    case "Statistique":
      return profileStatsPortletElement().isVisible();
    case "Taches":
      return tasksContainerElement().isVisible();
    case "Wallet":
      return walletBalanceElement().isVisible();
    default:
      throw new IllegalStateException("Unrecognized element");
    }
  }

  public boolean isPortalDisplayed() {
    return getSiteBody().isVisible();
  }

  public boolean isNoConnectionsBadge() {
    return !getConnectionsBadge().isVisible();
  }

  public boolean isNumberOfConnectionsInDrawer(int expectedNumber) {
    int listOfSpaces = getListConnectionInDrawer().size();
    return listOfSpaces == expectedNumber;
  }

  public boolean isNumberOfSpacesInDrawer(int expectedNumber) {
    int listOfSpaces = getListSpaceInDrawer().size();
    return listOfSpaces == expectedNumber;
  }

  public boolean isSpacesBadgeWithNumberVisible(String number) {
    return getSpacesBadgeWithNumber(number).isVisible();
  }

  public void isThirdLevelNavigationDisplayed() {
    thirdLevelNavigationElement().assertVisible();
  }

  public boolean isWidgetWithNumberVisible(String widget, String number) {
    closeAllDrawers();
    return getProfileWidgetContent(widget, number).isVisible();
  }

  public void logout() {
    if (isPortalDisplayed()) {
      clickOnHamburgerMenu();
      logOutMenuElement().click();
      waitForPageLoading();
    }
  }

  public void openAllApplicationPage() {
    waitForPageLoading();
    clickOnElement(viewAllApplicationLinkElement());
    waitForPageLoading();
  }

  public void openAppCenterMenu() {
    waitForPageLoading();
    clickOnElement(appCenterButtonElement());
    waitForLoading();
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

  private ElementFacade administrationIconElement() {
    return findByXPathOrCSS("//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'titleIcon')]");
  }

  private ElementFacade administrationMenuElement() {
    return findByXPathOrCSS("#AdministrationHamburgerNavigation");
  }

  private ElementFacade appCenterButtonElement() {
    return findByXPathOrCSS("#appcenterLauncherButton");
  }

  private ElementFacade arrowAdminstrationMenuElement() {
    return findByXPathOrCSS("//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'fa fa-arrow')]");
  }

  private ElementFacade checkSpaceFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
                                          spaceName));
  }

  private void clickOnHamburgerMenu() {
    closeAllDrawers();
    retryOnCondition(() -> getHamburgerNavigationMenu().click(),
                     () -> {
                       LOGGER.warn("Hamburger Menu isn't visible, retry by waiting until application is built");
                       getHamburgerNavigationMenuDrawer().waitUntilPresent();
                       closeAllDrawers();
                     });
  }

  private ElementFacade confirmationForChangeSiteHomeLinkElement() {
    return findByXPathOrCSS("//*[@class='ignore-vuetify-classes btn btn-primary me-2']");
  }

  private ElementFacade connectionsBadgeElement() {
    return findByXPathOrCSS("(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[2]");
  }

  private ElementFacade contextBoxWelcomeActivityElement() {
    return findByXPathOrCSS("//*[@id='ActivityContextBoxWelcomeActivity']");
  }

  private ElementFacade firstNotificationContentElement() {
    return findByXPathOrCSS("(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[1]");
  }

  private ElementFacade getAcceptIconConnectionFromDrawer(String spaceName) {
    return findByXPathOrCSS(String.format("//aside[contains(@class,'connectionsDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
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

  private ElementFacade getFavoriteSucessMessage(String message) {
    return findByXPathOrCSS(String.format("//div[@class='v-alert__content']//*[contains(text(),'%s')]", message));
  }

  private ElementFacade getHamburgerNavigationMenu() {
    return findByXPathOrCSS(".HamburgerNavigationMenuLink");
  }

  private ElementFacade getSiteBody() {
    return findByXPathOrCSS("#UISiteBody");
  }

  private ElementFacade getHamburgerNavigationMenuDrawer() {
    return findByXPathOrCSS(".HamburgerNavigationMenuLink .v-navigation-drawer");
  }

  private List<WebElementFacade> getListConnectionInDrawer() {
    return findAll("//aside[contains(@class,'connectionsDrawer ')]//div[@role='list']//descendant::div[@role='listitem']");
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

  private ElementFacade homeIconElement() {
    return findByXPathOrCSS("//*[@id='SiteHamburgerNavigation']//a[contains(@href, '/stream')]//*[contains(@class, 'homePage')]");
  }

  private ElementFacade homePageButtonElement() {
    return findByXPathOrCSS("//*[@id='UserHomePortalLink']");
  }

  private ElementFacade logOutMenuElement() {
    return findByXPathOrCSS("//i[contains(@class,'logoutIcon')]");
  }

  private ElementFacade myProfileButtonElement() {
    return findByXPathOrCSS("//*[@id='ProfileHamburgerNavigation']//a[contains(@href, '/profile')]");
  }

  private ElementFacade notificationIconElement() {
    return findByXPathOrCSS("#NotificationPopoverPortlet");
  }

  private ElementFacade openSpacesPageLinkElement() {
    // //*[contains(@class, 'v-list-item__content')] added to avoid clicking on
    // home icon
    return findByXPathOrCSS("//*[@id='SiteHamburgerNavigation']//a[contains(@href, '/spaces')]//*[contains(@class, 'v-list-item__content')]");
  }

  private ElementFacade peoplePageLinkElement() {
    return findByXPathOrCSS("//*[@id='SiteHamburgerNavigation']//a[contains(@href, '/people')]//*[contains(@class, 'v-list-item__content')]");
  }

  private ElementFacade profileStatsPortletElement() {
    return findByXPathOrCSS("#profile-stats-portlet");
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

  private ElementFacade secondNotificationContentElement() {
    return findByXPathOrCSS("(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[2]");
  }

  private ElementFacade seeAllLinkElement() {
    return findByXPathOrCSS("//aside[contains(@class,'v-navigation-drawer')]//span[contains(text(),'See all')]");
  }

  private ElementFacade selectSpacesFilterElement() {
    return findByXPathOrCSS("//*[contains(@class,'selectSpacesFilter')]");
  }

  private ElementFacade settingsPageLinkElement() {
    return findByXPathOrCSS("//i[contains(@class,'settingsIcon')]");
  }

  private TextBoxElementFacade sideBarFilterSpacesElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]");
  }

  private TextBoxElementFacade sideBarFilterSpacesInputElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'recentSpacesTitle')]//*[contains(@class,'recentSpacesTitleLabel')]//*[contains(@class,'v-input recentSpacesFilter')]//input");
  }

  private ElementFacade spaceArrowIconElement() {
    return findByXPathOrCSS("//*[contains(@class,'recentSpacesWrapper')]//*[contains(@class,'clickable fa fa-arrow')]");
  }

  private ElementFacade spaceInvitaitationWidgetElement() {
    return findByXPathOrCSS("//*[@class='v-card v-card--flat v-sheet theme--light']//div[@class='headline text-color font-weight-bold pa-1']");
  }

  private ElementFacade spacesBadgeElement() {
    return findByXPathOrCSS("(//div[contains(@class,'profileCard')]//*[@aria-label='Badge'])[1]");
  }

  private ElementFacade streamPageLinkElement() {
    return findByXPathOrCSS("//*[@id='SiteHamburgerNavigation']//a[contains(@href, '/stream')]//*[contains(@class, 'v-list-item__content')]");
  }

  private ElementFacade streamPageViewElement() {
    return findByXPathOrCSS("//*[@id='StreamPage']");
  }

  private ElementFacade switcherButtonElement() {
    return findByXPathOrCSS("(//*[@class='providersTableRow']//*[@class='center actionContainer']/div)[1]");
  }

  private ElementFacade tasksContainerElement() {
    return findByXPathOrCSS("#tasks");
  }

  private ElementFacade tasksSnapshotPageButtonElement() {
    return findByXPathOrCSS("//*[@id='tasks']//*[@class='body-1 text-uppercase color-title px-0']");
  }

  private ElementFacade thirdLevelNavigationElement() {
    return findByXPathOrCSS("//*[contains(@class,'HamburgerMenuThirdLevelParent')]");
  }

  private ElementFacade viewAllApplicationLinkElement() {
    return findByXPathOrCSS("//a[contains(@class,'seeAllApplicationsBtn')]");
  }

  private void waitUntilAppCenterSearchFinishes(boolean isAdminUI) {
    if (isAdminUI) {
      findByXPathOrCSS("(//*[contains(@class, 'listApplications')]//tr)[3]").waitUntilNotVisible();
    } else {
      findByXPathOrCSS("(//*[contains(@class, 'userAuthorizedApplications')]//*[contains(@class, 'authorizedApplication')])[2]").waitUntilNotVisible();
    }
  }

  private ElementFacade walletBalanceElement() {
    return findByXPathOrCSS("#walletBalance");
  }

}
