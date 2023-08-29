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

import static net.serenitybdd.core.Serenity.sessionVariableCalled;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.pages.LoginPage;
import net.serenitybdd.core.Serenity;

public class LoginSteps {

  private LoginPage loginPage;

  public void authenticate(String userPrefix) {
    String username = Serenity.sessionVariableCalled(userPrefix + "UserName");
    String password = Serenity.sessionVariableCalled(username + "-password");
    loginPage.login(username, password);
  }

  public boolean authenticate(String userPrefix, boolean throwException) {
    String username = Serenity.sessionVariableCalled(userPrefix + "UserName");
    String password = Serenity.sessionVariableCalled(username + "-password");
    return loginPage.login(username, password, throwException);
  }

  public boolean authenticate(String username, String password, boolean throwException) {
    return loginPage.login(username, password, throwException);
  }

  public void authenticateIfRandomSpaceAndUsersNotExists(String userPrefix, String spacePrefix, List<String> userPrefixes) {
    boolean spaceDoesntExist = StringUtils.isBlank(spacePrefix) || StringUtils.isBlank(sessionVariableCalled(spacePrefix));
    boolean userDoesntExist = userPrefixes.stream()
                                          .anyMatch(userToCreatePrefix -> StringUtils.isBlank(sessionVariableCalled(userToCreatePrefix
                                              + "UserName")));
    if (userDoesntExist || spaceDoesntExist) {
      authenticate(userPrefix);
    }
  }

  public void authenticateIfUsersNotExists(String userPrefix, List<String> userPrefixes) {
    authenticateIfRandomSpaceAndUsersNotExists(userPrefix, null, userPrefixes);
  }

  public void deleteCookies() {
    loginPage.deleteCookies();
  }

  public boolean isLoggedIn() {
    String currentUrl = loginPage.getCurrentUrl();
    return StringUtils.contains(currentUrl, "/portal") && !StringUtils.contains(currentUrl, "/login");
  }

  public void logout() {
    loginPage.logout();
  }

  public void checkLoginPageDisplay() {
    loginPage.checkLoginPageDisplay();
  }

  public void waitForUsernameInputDisplay(int retries) {
    loginPage.waitForUsernameInputDisplay(retries);
  }

  public void checkRegisterLinkIsDisplayed() {
    loginPage.checkLoginPageDisplay();
    loginPage.registerLinkIsDisplayed();
  }

  public void checkRegisterLinkIsNotDisplayed() {
    loginPage.checkLoginPageDisplay();
    loginPage.registerLinkIsNotDisplayed();
  }

}
