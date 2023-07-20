/**
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
package io.meeds.qa.ui.cleanup;

import static io.meeds.qa.ui.hook.TestInitHook.ADMIN_PASSWORD;
import static io.meeds.qa.ui.hook.TestInitHook.ADMIN_USERNAME;
import static io.meeds.qa.ui.hook.TestInitHook.SPACE_NAMES;
import static io.meeds.qa.ui.hook.TestInitHook.USER_NAMES;
import static io.meeds.qa.ui.utils.ExceptionLauncher.LOGGER;

import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.AfterAll;
import io.meeds.qa.ui.hook.TestInitHook;
import net.serenitybdd.core.Serenity;

public class TestCleanupHook { // NOSONAR

  /**
   * Experimental overall cleanup phase, not relevant to use right now, but to improve later
   */
  public static final boolean CLEAN_DATA          =
                                         Boolean.parseBoolean(System.getProperty("io.meeds.cleanData", "false")
                                                                    .toLowerCase());

  private static final String DELETE_SPACE_SCRIPT =
                                                  """
                                                       const callback = arguments && arguments.length && arguments[arguments.length - 1] || null;
                                                       fetch("/portal/rest/v1/social/spaces/byPrettyName/%s", {
                                                         "headers": {
                                                           "content-type": "application/json",
                                                         },
                                                         "method": "GET",
                                                         "credentials": "include"
                                                       })
                                                       .then(resp => {
                                                         if (!resp || !resp.ok) {
                                                           throw new Error("Error getting space");
                                                         } else {
                                                           return resp.json();
                                                         }
                                                       })
                                                       .then(space =>
                                                         space && space.id && fetch("/portal/rest/v1/social/spaces/" + space.id, {
                                                           "headers": {
                                                             "content-type": "application/json",
                                                           },
                                                           "method": "DELETE",
                                                           "credentials": "include"
                                                         })
                                                         .then(resp => {
                                                           if (resp && !resp.ok) {
                                                             throw new Error("Error deleting space");
                                                           }
                                                         })
                                                       )
                                                       .then(() => callback && callback(true))
                                                       .catch(() => callback && callback(false));
                                                      """;

  private static final String DELETE_USER_SCRIPT  =
                                                 """
                                                      const callback = arguments && arguments.length && arguments[arguments.length - 1] || null;
                                                      fetch("/portal/rest/v1/social/users/%s", {
                                                        "headers": {
                                                          "content-type": "application/json",
                                                        },
                                                        "method": "DELETE",
                                                        "credentials": "include"
                                                      })
                                                      .then(resp => {
                                                        if (resp && !resp.ok) {
                                                          throw new Error("Error deleting user");
                                                        }
                                                      })
                                                      .then(() => callback && callback(true))
                                                      .catch(() => callback && callback(false));
                                                     """;

  @AfterAll
  public static void cleanDatas() {
    if (TestInitHook.instance == null || !CLEAN_DATA) {
      return;
    }
    LOGGER.info("---- Start cleanup phase");
    long start = System.currentTimeMillis();
    try {
      TestInitHook.instance.genericSteps.closeAllDrawers();
      TestInitHook.instance.genericSteps.closeAllDialogs();
      TestInitHook.instance.loginSteps.logout();
    } catch (Exception e) {
      LOGGER.warn("Can't logout admin user. Proceed to login phase", e);
    }
    if (!TestInitHook.instance.loginSteps.authenticate(ADMIN_USERNAME, ADMIN_PASSWORD, false)) {
      LOGGER.warn("Couldn't login with admin, cleanup phase aborted");
    }
    deleteSpaces();
    deleteUsers();
    LOGGER.info("---- End cleanup phase in {} ms", System.currentTimeMillis() - start);
  }

  private static void deleteSpaces() {
    SPACE_NAMES.forEach(TestCleanupHook::deleteSpace);
  }

  private static void deleteUsers() {
    USER_NAMES.forEach(TestCleanupHook::deleteUser);
  }

  private static void deleteSpace(String spaceName) {
    Object result = ((JavascriptExecutor) Serenity.getDriver()).executeAsyncScript(String.format(DELETE_SPACE_SCRIPT, spaceName));
    LOGGER.info("Delete created space in Tests {}, result = {}", spaceName, result);
  }

  private static void deleteUser(String userName) {
    Object result = ((JavascriptExecutor) Serenity.getDriver()).executeAsyncScript(String.format(DELETE_USER_SCRIPT, userName));
    LOGGER.info("Delete created user in Tests {}, result = {}", userName, result);
  }

}
