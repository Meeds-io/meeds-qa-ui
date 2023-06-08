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

  public void authenticate(String username) {
    String password = Serenity.sessionVariableCalled(username + "-password");
    loginPage.login(username, password);
  }

  public boolean authenticate(String username, boolean throwException) {
    String password = Serenity.sessionVariableCalled(username + "-password");
    return loginPage.login(username, password, throwException);
  }

  public void authenticateIfRandomSpaceAndUsersNotExists(String username, String spacePrefix, List<String> userPrefixes) {
    boolean spaceDoesntExist = StringUtils.isBlank(spacePrefix) || StringUtils.isBlank(sessionVariableCalled(spacePrefix));
    boolean userDoesntExist = userPrefixes.stream()
                                          .anyMatch(userPrefix -> StringUtils.isBlank(sessionVariableCalled(userPrefix
                                              + "UserName")));
    if (userDoesntExist || spaceDoesntExist) {
      authenticate(username);
    }
  }

  public void authenticateIfUsersNotExists(String username, List<String> userPrefixes) {
    authenticateIfRandomSpaceAndUsersNotExists(username, null, userPrefixes);
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

}
