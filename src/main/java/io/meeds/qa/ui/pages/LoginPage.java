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

import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import net.serenitybdd.markers.IsHidden;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://baseUrl/")
public class LoginPage extends GenericPage implements IsHidden {

  private static final String LAST_LOGGED_IN_USER_COOKIE_NAME = "lastLoggedInUser";

  private String              lastLoggedInUser                = null;

  private HomePage            homePage;

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
    long start = System.currentTimeMillis();
    LOGGER.info("login - Start");
    if (StringUtils.equals(getLastLoggedInUser(), login)) {
      closeAllDrawers();
    } else {
      LOGGER.info("login - logout: {}ms", System.currentTimeMillis() - start);
      logout();
      LOGGER.info("login - setTextValue: {}ms", System.currentTimeMillis() - start);
      usernameInputElement().setTextValue(login);
      passwordInputElement().setTextValue(password);
      loginButtonElement().click();
      LOGGER.info("login - waitForPageLoading: {}ms", System.currentTimeMillis() - start);
      waitForPageLoading();
      LOGGER.info("login - addCookie: {}ms", System.currentTimeMillis() - start);
      assertTrue("The home page should be loaded, but it did not !", homePage.isPortalDisplayed());
      getDriver().manage().addCookie(new Cookie(LAST_LOGGED_IN_USER_COOKIE_NAME, login, "/"));
      lastLoggedInUser = login;
    }
    LOGGER.info("login - End: {}ms", System.currentTimeMillis() - start);
  }

  public void openLoginPage() {
    long start = System.currentTimeMillis();
    LOGGER.info("openLoginPage - Start");
    int maxRetries = 3;
    int i = 0;
    do {
      deleteCookies();
      open();
    } while (!isLoginPageDisplayed() && i++ < maxRetries);
    if (i >= maxRetries) {
      throw new IllegalStateException("Can't display login page after 3 retries");
    }
    LOGGER.info("openLoginPage - End: {}ms", System.currentTimeMillis() - start);
  }

  public boolean isLoginPageDisplayed() {
    return StringUtils.contains(getDriver().getCurrentUrl(), "/portal/login");
  }

  public void logout() {
    if (homePage.isPortalDisplayed()) {
      try {
        ElementFacade logOutMenuElement = logOutMenuElement();
        if (!logOutMenuElement.isCurrentlyVisible()) {
          closeAllDrawers();
          homePage.clickOnHamburgerMenu();
        }
        logOutMenuElement.click();
        waitForPageLoading();
        assertTrue("Login page should be displayed", isLoginPageDisplayed());
        usernameInputElement().checkVisible();
      } finally {
        deleteCookies();
      }
    } else if (!isLoginPageDisplayed()) {
      openLoginPage();
    }
  }

  private ElementFacade logOutMenuElement() {
    return findByXPathOrCSS("//i[contains(@class,'logoutIcon')]");
  }

  private ElementFacade loginButtonElement() {
    return findButtonByXPathOrCSS("//*[contains(@class, 'loginButton')]//button");
  }

  private TextBoxElementFacade passwordInputElement() {
    return findTextBoxByXPathOrCSS("//*[@id='password']");
  }

  private TextBoxElementFacade usernameInputElement() {
    return findTextBoxByXPathOrCSS("//*[@id='username']");
  }

}
