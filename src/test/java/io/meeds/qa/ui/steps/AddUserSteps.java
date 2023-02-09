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

import static io.meeds.qa.ui.utils.Utils.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.hook.TestHooks;
import io.meeds.qa.ui.pages.AddUserPage;
import io.meeds.qa.ui.pages.HomePage;

public class AddUserSteps {

  private AddUserPage addUserPage;

  private HomePage    homePage;

  public void addRandomUser(String userPrefix, boolean waitSearchable) {
    if (StringUtils.isBlank(sessionVariableCalled(userPrefix + "UserName"))) {
      addUserPage.waitForDrawerToOpen();
      String userName = "user" + userPrefix + getRandomString();
      String firstName = getRandomString(userPrefix);
      String lastName = getRandomString(userName);
      String email = userName + "@aa.bb";
      String password = "123456nBm";

      homePage.goToAddUser();
      addRandomUser(userName, firstName, lastName, email, password);

      setSessionVariable(userPrefix + "UserName").to(userName);
      setSessionVariable(userPrefix + "UserFirstName").to(firstName);
      setSessionVariable(userPrefix + "UserLastName").to(lastName);
      setSessionVariable(userPrefix + "UserPassword").to(password);
      setSessionVariable(userName + "-password").to(password);
      TestHooks.userWithPrefixCreated(userPrefix, userName, firstName, lastName, email, password);

      if (waitSearchable) {
        // Wait for ElasticSearch index creation asynchronously
        addUserPage.waitFor(3).seconds();
      } else {
        addUserPage.waitForDrawerToClose();
      }
    }
  }

  public void addRandomUser(String userName, String firstName, String lastName, String mail, String password) {
    addUserPage.clickAddUserButton();
    addUserPage.setRandomUserDetails(userName, firstName, lastName, mail, password);
    addUserPage.saveAddUserButton();
  }

  public void addUser(Map<String, String> userDetails) {
    addUserPage.clickAddUserButton();
    for (Entry<String, String> field : userDetails.entrySet()) {
      addUserPage.setUserDetails(field.getKey(), field.getValue());
    }
    addUserPage.saveAddUserButton();
  }

  public void checkPopupCantDeleteLoggedUser() {
    addUserPage.checkPopupCantDeleteLoggedUser();
  }

  public void checkThatAddUserDrawerIsDisplayed() {
    addUserPage.clickAddUserButton();
    addUserPage.checkThatAddUserDrawerIsDisplayed();
  }

  public void checkUserIsDeleted(String fullName) {
    addUserPage.checkUserIsDeleted(fullName);
  }

  public void clickToDeleteUser() {
    addUserPage.clickToDeleteUser();
  }

  public void deleteUser() {
    addUserPage.deleteUser();
  }

  public void enableDisableUser(String user) {
    addUserPage.enableDisableUser(user);
  }

  public void enterUserInformations(Map<String, String> userDetails) {
    addUserPage.clickAddUserButton();
    for (Entry<String, String> field : userDetails.entrySet()) {
      addUserPage.setUserDetails(field.getKey(), field.getValue());
    }
  }

  public void isUserNameDisplayed(String user) {
    addUserPage.isUserNameDisplayed(user);
  }

  public void saveAddingUser() {
    addUserPage.saveAddUserButton();
  }

  public void searchForUsersByName(String userName) {
    addUserPage.searchForUserByName(userName, 3);
  }

  public void searchForUsersByStatus(String status) {
    addUserPage.searchForUsersByStatus(status);
  }

}
