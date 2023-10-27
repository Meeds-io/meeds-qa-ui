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

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;
import net.serenitybdd.markers.IsHidden;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://baseUrl/")
public class LoginPage extends GenericPage implements IsHidden {

  private static final String LAST_LOGGED_IN_USER_COOKIE_NAME = "lastLoggedInUser";

  private String              lastLoggedInUser                = null;

  private HomePage            homePage;

  private String              loginUrl;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void deleteCookies() {
    lastLoggedInUser = null;
    closeAlertIfOpened();
    getDriver().manage().deleteAllCookies();
  }

  public String getLastLoggedInUser() {
    if (lastLoggedInUser != null) {
      return lastLoggedInUser;
    }
    Cookie cookie = getDriver().manage().getCookieNamed(LAST_LOGGED_IN_USER_COOKIE_NAME);
    return cookie == null ? null : cookie.getValue();
  }

  public void login(String login, String password) {
    retryOnCondition(() -> login(login, password, true),
                     () -> logout(Utils.MAX_WAIT_RETRIES));
  }

  public boolean login(String login, String password, boolean throwException) { // NOSONAR
    try {
      if (StringUtils.isBlank(login) || StringUtils.isBlank(password)) {
        return returnError("Username " + login + " and Password " + password + " are mandatory", throwException);
      }
      if (StringUtils.equals(getLastLoggedInUser(), login)) {
        closeAllDrawers();
      } else {
        logout(Utils.MAX_WAIT_RETRIES);
        if (StringUtils.equals(getCurrentUrl(), PUBLIC_SITE_URL)) {
          topbarLoginButton().click();
          verifyPageLoaded();
        }
        if (!usernameInputElement().isVisible()) {
          return returnError("Username Field isn't displayed", throwException);
        } else {
          setLoginUrl(getCurrentUrl());
        }
        usernameInputElement().setTextValue(login);
        if (!passwordInputElement().isVisible()) {
          return returnError("Username Field isn't displayed", throwException);
        }
        passwordInputElement().setTextValue(password);
        if (!loginButtonElement().isEnabled()) {
          return returnError("Login button isn't enabled", throwException);
        }
        loginButtonElement().click();
        verifyPageLoaded();
        if (!homePage.isPortalDisplayed()) {
          return returnError("Home Page isn't displayed", throwException);
        }
        getDriver().manage().addCookie(new Cookie(LAST_LOGGED_IN_USER_COOKIE_NAME, login, "/"));
        lastLoggedInUser = login;
      }
      return true;
    } catch (RuntimeException e) {
      if (throwException) {
        throw e;
      } else {
        LOGGER.warn("An error occurred while login with user {}", login, e);
        return false;
      }
    }
  }

  public void openLoginPage() {
    int maxRetries = 3;
    int i = 0;
    do {
      deleteCookies();
      String currentUrl = getCurrentUrl();
      if (StringUtils.isNotBlank(currentUrl)) {
        getDriver().get(currentUrl);
      } else {
        open();
      }
    } while (!isLoginPageDisplayed() && i++ < maxRetries);
    if (i >= maxRetries) {
      throw new IllegalStateException("Can't display login page after 3 retries");
    }
  }

  @Override
  public String getCurrentUrl() {
    String currentUrl = super.getCurrentUrl();
    return StringUtils.isNotBlank(loginUrl) ? loginUrl : currentUrl;
  }

  public void setLoginUrl(String loginUrl) {
    if (StringUtils.isNotBlank(loginUrl)) {
      this.loginUrl = loginUrl;
    }
  }

  public void waitForUsernameInputDisplay(int retries) {
    while (usernameInputElement().isNotVisible() && retries-- > 0) {
      waitFor(1).seconds();
    }
  }

  public boolean isLoginPageDisplayed() {
    return StringUtils.contains(getDriver().getCurrentUrl(), "/portal/login");
  }

  public void logout() {
    logout(Utils.MAX_WAIT_RETRIES);
    usernameInputElement().assertVisible();
  }

  public void registerLinkIsDisplayed() {
    registerLink().isVisible();
  }

  public void registerLinkIsNotDisplayed() {
    registerLink().isNotVisible();
  }

  private void logout(int max) {
    logout(1, max); // recursive method
  }

  private void logout(int tentative, int max) {
    if (homePage.isPortalDisplayed()) {
      ElementFacade logOutMenuElement = logOutMenuElement();
      if (!logOutMenuElement.isCurrentlyVisible()) {
        closeAllDrawers();
        waitFor(200).milliseconds();
        homePage.clickOnHamburgerMenu();
      }
      logOutMenuElement.click();
      verifyPageLoaded();
      if (usernameInputElement().isVisible()) {
        deleteLastLoginCookie();
      } else {
        LOGGER.warn("Error logout, tentative {}/{}. Retry by refreshing page.", tentative, max);
        Utils.refreshPage(true);
        logout(tentative + 1, max);
      }
    } else if (!isLoginPageDisplayed()) {
      deleteCookies();
      openLoginPage();
    }
  }

  @SuppressWarnings("unchecked")
  public void checkLoginPageDisplay() {
    List<Long> windowDimensions =
                                (List<Long>) ((JavascriptExecutor) getDriver()).executeScript("return [window.innerWidth, window.innerHeight];");
    int windowWidth = windowDimensions.get(0).intValue();
    int windowHeight = windowDimensions.get(1).intValue();

    ElementFacade loginElement = findByXPathOrCSS("#loginApplication");
    loginElement.assertVisible();

    int loginElementTop = loginElement.getLocation().getY();
    int loginElementLeft = loginElement.getLocation().getX();

    assertEquals(0, loginElementTop);
    assertEquals(0, loginElementLeft);

    int loginElementWidth = loginElement.getRect().getWidth();
    int loginElementHeight = loginElement.getRect().getHeight();

    assertEquals(windowWidth, loginElementWidth);
    assertEquals(windowHeight, loginElementHeight);

    ElementFacade brandingLogoElement = findByXPathOrCSS(".brandingLogo");
    brandingLogoElement.assertVisible();

    int brandingLogoElementTop = brandingLogoElement.getLocation().getY();
    int brandingLogoElementLeft = brandingLogoElement.getLocation().getX();
    int brandingLogoElementWidth = brandingLogoElement.getRect().getWidth();
    int brandingLogoElementHeight = brandingLogoElement.getRect().getHeight();

    long diffY = Math.abs(((long) (windowHeight - brandingLogoElementHeight - windowHeight * 0.03d)) - brandingLogoElementTop);
    long diffX = Math.abs(((long) (windowWidth - brandingLogoElementWidth - windowWidth * 0.03d)) - brandingLogoElementLeft);
    assertTrue(diffY <= 2);
    assertTrue(diffX <= 2);
  }

  private boolean returnError(String message, boolean throwException) {
    if (throwException) {
      throw new IllegalStateException(message);
    } else {
      return false;
    }
  }

  private void deleteLastLoginCookie() {
    lastLoggedInUser = null;
    closeAlertIfOpened();
    getDriver().manage().deleteCookieNamed(LAST_LOGGED_IN_USER_COOKIE_NAME);
  }

  private ElementFacade logOutMenuElement() {
    return findByXPathOrCSS("//i[contains(@class,'logoutIcon')]");
  }

  private ElementFacade loginButtonElement() {
    return findButtonByXPathOrCSS("//*[contains(@class, 'loginButton')]//button");
  }

  private ElementFacade registerLink() {
    return findButtonByXPathOrCSS("//a[@href = '/portal/register']");
  }

  private TextBoxElementFacade passwordInputElement() {
    return findTextBoxByXPathOrCSS("//*[@id='password']");
  }

  private TextBoxElementFacade usernameInputElement() {
    return findTextBoxByXPathOrCSS("//*[@id='username']");
  }

  private TextBoxElementFacade topbarLoginButton() {
    return findTextBoxByXPathOrCSS("//*[@id='topbarLogin']");
  }

}
