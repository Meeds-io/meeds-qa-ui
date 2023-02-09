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
    if (StringUtils.equals(getLastLoggedInUser(), login)) {
      closeAllDrawers();
    } else {
      openLoginPage();
      usernameInputElement().setTextValue(login);
      passwordInputElement().setTextValue(password);
      loginButtonElement().click();
      getDriver().manage().addCookie(new Cookie(LAST_LOGGED_IN_USER_COOKIE_NAME, login, "/"));
      lastLoggedInUser = login;
      waitForPageLoading();
    }
  }

  public void logout() {
    openLoginPage();
  }

  public void openLoginPage() {
    int maxRetries = 3;
    int i = 0;
    while (!StringUtils.contains(getDriver().getCurrentUrl(), "/portal/login") && i++ < maxRetries) {
      deleteCookies();
      open();
    }
    if (i >= maxRetries) {
      throw new IllegalStateException("Can't display login page after 3 retries");
    }
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
