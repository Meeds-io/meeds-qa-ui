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

import java.time.Duration;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.meeds.qa.ui.hook.TestHooks;
import io.meeds.qa.ui.pages.AddUserPage;
import io.meeds.qa.ui.pages.HomePage;
import net.serenitybdd.core.Serenity;

public class AddUserSteps {

  private AddUserPage         addUserPage;

  private HomePage            homePage;

  public void addRandomUser(String userPrefix, boolean waitSearchable) {
    addRandomUser(userPrefix, waitSearchable, false);
  }

  public void addRandomUser(String userPrefix, boolean waitSearchable, boolean injectUsingRest) {

    if (StringUtils.isBlank(sessionVariableCalled(userPrefix + "UserName"))) {
      String userName = "user" + userPrefix + getRandomString();
      String firstName = getRandomString(userPrefix);
      String lastName = getRandomString(userName);
      String email = userName + "@aa.bb";
      String password = "Test1234@" + getRandomString(userPrefix);

      if (injectUsingRest) {
        addRandomUser(userPrefix, userName, firstName, lastName, email, password);
      } else {
        homePage.goToAddUser();
        addRandomUser(userName, firstName, lastName, email, password);
        if (waitSearchable) {
          // Wait for ElasticSearch index creation asynchronously
          addUserPage.waitFor(3).seconds();
        } else {
          addUserPage.waitForDrawerToClose();
        }
      }

      setSessionVariable(userPrefix + "UserName").to(userName);
      setSessionVariable(userPrefix + "UserFirstName").to(firstName);
      setSessionVariable(userPrefix + "UserLastName").to(lastName);
      setSessionVariable(userPrefix + "UserPassword").to(password);
      setSessionVariable(userName + "-password").to(password);
      TestHooks.userWithPrefixCreated(userPrefix, userName, firstName, lastName, email, password);
    }
  }

  public void addAdminUser(String userPrefix) {
    String adminUsername = sessionVariableCalled(userPrefix + "UserName");
    String firstName = "Admin";
    String lastName = "User";
    String email = adminUsername + "@localhost.com";
    String password = getRandomString(userPrefix);

    addRandomUser(userPrefix, adminUsername, firstName, lastName, email, password);
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

  public void addUserRole(String userPrefix, String groupId, String membershipType) {
    String userName = sessionVariableCalled(userPrefix + "UserName");
    String addUserScript =
                         String.format("""
                              const callback = arguments[arguments.length - 1];
                              fetch("/portal/rest/v1/groups/memberships/bulk?membershipId=", {
                                "headers": {
                                  "content-type": "application/json",
                                },
                                "body": `[{"userName":"%s","groupId":"%s","membershipType":"%s"}]`,
                                "method": "POST",
                                "credentials": "include"
                              })
                              .then(resp => {
                                if (!resp || !resp.ok) {
                                  throw new Error("Error adding user role");
                                }
                              })
                              .then(user => callback(true))
                              .catch(() => callback(false));
                             """,
                                       userName,
                                       groupId,
                                       membershipType);
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(),
                                           Duration.ofSeconds(3),
                                           Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeAsyncScript(addUserScript)
                                                            .toString()
                                                            .equals("true"));
  }

  private void addRandomUser(String userPrefix,
                             String userName,
                             String firstName,
                             String lastName,
                             String email,
                             String password) {
    String addUserScript =
                         String.format("""
                              const callback = arguments[arguments.length - 1];
                              fetch("/portal/rest/v1/users", {
                                "headers": {
                                  "content-type": "application/json",
                                },
                                "body": `{"enabled":true,"userName":"%s","firstName":"%s","lastName":"%s","email":"%s","password":"%s","confirmNewPassword":"%s"}`,
                                "method": "POST",
                                "credentials": "include"
                              })
                              .then(resp => {
                                if (!resp || !resp.ok) {
                                  throw new Error("Error creating user");
                                }
                              })
                              .then(user => callback(true))
                              .catch(() => callback(false));
                             """,
                                       userName,
                                       firstName,
                                       lastName,
                                       email,
                                       password,
                                       password);
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(),
                                           Duration.ofSeconds(10),
                                           Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeAsyncScript(addUserScript)
                                                            .toString()
                                                            .equals("true"));

    setSessionVariable(userPrefix + "UserName").to(userName);
    setSessionVariable(userPrefix + "UserFirstName").to(firstName);
    setSessionVariable(userPrefix + "UserLastName").to(lastName);
    setSessionVariable(userPrefix + "UserPassword").to(password);
    setSessionVariable(userName + "-password").to(password);
    TestHooks.userWithPrefixCreated(userPrefix, userName, firstName, lastName, email, password);
  }

}
