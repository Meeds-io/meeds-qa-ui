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
package io.meeds.qa.ui.hook;

import static io.meeds.qa.ui.utils.ExceptionLauncher.LOGGER;
import static io.meeds.qa.ui.utils.Utils.DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.waitRemainingTime;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.meeds.qa.ui.steps.AddUserSteps;
import io.meeds.qa.ui.steps.AdminApplicationSteps;
import io.meeds.qa.ui.steps.GenericSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.LoginSteps;
import io.meeds.qa.ui.steps.ManageBadgesSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import io.meeds.qa.ui.steps.definition.ManageSpaceStepDefinitions;
import io.meeds.qa.ui.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeVisibleException;

public class TestHooks {

  private static final String                ADMIN_PREFIX              = "admin";

  private static final String                ADMIN_USERNAME            = System.getProperty("adminUser", "admin");

  private static final String                ADMIN_PASSWORD            = System.getProperty("adminPassword", "Test1234@");

  protected static final String[]            ADMIN_GROUPS              = System.getProperty("io.meeds.admin.groups",
                                                                                            "/platform/administrators,/platform/rewarding,/platform/analytics")
                                                                               .split(",");

  protected static final boolean             INIT_DATA                 =
                                                       Boolean.parseBoolean(System.getProperty("io.meeds.initData",
                                                                                               "true")
                                                                                  .toLowerCase());

  protected static final String              WARMUP_FILE_PATH          = System.getProperty("io.meeds.warmUp.file",
                                                                                            "warmUpFile.tmp");

  private static final int                   WARM_UP_PAGE_LOADING_WAIT = 10;

  private static final int                   MAX_WARM_UP_STEP_WAIT     = 5;

  private static final int                   MAX_WARM_UP_RETRIES       = 100;

  protected static final Map<String, String> SPACES                    = new HashMap<>();

  protected static final Map<String, String> SPACES_URLS               = new HashMap<>();

  protected static final Map<String, String> USERS                     = new HashMap<>();

  public static void spaceWithPrefixCreated(String spaceNamePrefix, String spaceName, String spaceUrl) {
    SPACES.put(spaceNamePrefix, spaceName);
    SPACES_URLS.put(spaceNamePrefix, spaceUrl);
    setSessionVariable(spaceNamePrefix).to(spaceName);
    setSessionVariable(spaceNamePrefix + "-url").to(spaceUrl);
  }

  public static void spaceWithPrefixDeleted(String spaceNamePrefix) {
    SPACES.remove(spaceNamePrefix);
    SPACES_URLS.remove(spaceNamePrefix);
  }

  public static void userWithPrefixCreated(String userPrefix,
                                           String userName,
                                           String firstName,
                                           String lastName,
                                           String email,
                                           String password) {
    USERS.put(userPrefix + "UserName", userName);
    USERS.put(userPrefix + "UserFirstName", firstName);
    USERS.put(userPrefix + "UserLastName", lastName);
    USERS.put(userPrefix + "UserPassword", password);
    USERS.put(userPrefix + "UserEmail", email);
    USERS.put(userName + "-password", password);
  }

  @Steps
  private AdminApplicationSteps      adminApplicationSteps;

  @Steps
  private HomeSteps                  homeSteps;

  @Steps
  private LoginSteps                 loginSteps;

  @Steps
  private GenericSteps               genericSteps;

  @Steps
  private ManageBadgesSteps          manageBadgesSteps;

  @Steps
  private ManageSpaceStepDefinitions manageSpaceStepDefinitions;

  @Steps
  private ManageSpaceSteps           manageSpaceSteps;

  @Steps
  private AddUserSteps               addUserSteps;

  @After
  public void deleteDatas() {
    genericSteps.closeAllDrawers();
    genericSteps.closeAllDialogs();
  }

  @Before
  public void initDatas() { // NOSONAR
    WebDriver driver = Serenity.getDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT));

    warmUp(driver);
    checkPageState(driver);

    SPACES.entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey()).to(entry.getValue());
      }
    });
    SPACES_URLS.entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey() + "-url").to(entry.getValue());
      }
    });
    USERS.entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey()).to(entry.getValue());
      }
    });
  }

  private void checkPageState(WebDriver driver) {
    try {
      driver.switchTo().alert().accept();
      driver.navigate().refresh();
    } catch (Throwable e) { // NOSONAR
      // Normal Behavior
    }
  }

  private void closeCurrentWindow(WebDriver driver) {
    try {
      driver.close(); // Close current window to refresh static resources
    } catch (Throwable e) { // NOSONAR
      // no need to throw an exception, the window may be already closed
    }
  }

  private boolean isPortalDisplayed() {
    try {
      return homeSteps.isPortalDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  private void loginAsAdmin() {
    try {
      loginSteps.logout();
    } catch (Exception e) {
      LOGGER.warn("Can't logout admin user. Proceed to login phase", e);
    }
    if (!loginSteps.authenticate(ADMIN_USERNAME, ADMIN_PASSWORD, false)) {
      throw new IllegalStateException("Couldn't login with admin");
    }
  }

  private void loginAsRandomAdmin() {
    try {
      loginSteps.logout();
    } catch (Exception e) {
      LOGGER.warn("Can't logout admin user. Proceed to login phase", e);
    }
    if (!loginSteps.authenticate(ADMIN_PREFIX, false)) {
      throw new IllegalStateException("Couldn't login with random admin");
    }
  }

  private void warmUp(WebDriver driver) {
    File warmUpFile = new File(WARMUP_FILE_PATH);
    if (warmUpFile.exists()) {
      LOGGER.debug("Warmup already proceeded. Execute test scenario.");
      return;
    }
    try {
      if (!warmUpFile.createNewFile()) {
        throw new IOException("Warmup File not created");
      }
    } catch (IOException e) {
      // Will attempt to warmup again next time
      LOGGER.warn("Error creating warmup file {}. Proceed to execute Test scenario without warmup.",
                  WARMUP_FILE_PATH,
                  e);
      return;
    }

    LOGGER.info("---- Start warmup phase with {} retries and wait time of {} seconds",
                MAX_WARM_UP_RETRIES,
                MAX_WARM_UP_STEP_WAIT);
    long start = System.currentTimeMillis();
    int retryCount = 1;
    boolean homePageDisplayed = false;
    do {
      LOGGER.info("---- {}/{} Warmup step",
                  retryCount,
                  MAX_WARM_UP_RETRIES);
      try {
        driver.navigate().to(System.getProperty("webdriver.base.url"));
        Utils.waitForLoading(WARM_UP_PAGE_LOADING_WAIT, true);
        driver.navigate().refresh();
        loginAsAdmin();
        Utils.waitForLoading(WARM_UP_PAGE_LOADING_WAIT, true);
        homePageDisplayed = isPortalDisplayed();
        if (!homePageDisplayed) {
          throw new ElementShouldBeVisibleException("Home Page isn't displayed", null);
        }
        // Make sure to use EN language for admin user
        driver.navigate().to(driver.getCurrentUrl().replace("/portal", "/portal/en"));
        Utils.waitForLoading(WARM_UP_PAGE_LOADING_WAIT, true);
      } catch (Throwable e) { // NOSONAR
        LOGGER.warn("Error authenticating admin user", e);
        closeCurrentWindow(driver);
        waitRemainingTime(WARM_UP_PAGE_LOADING_WAIT * 1000l, start);
      }
    } while (!homePageDisplayed && retryCount++ < MAX_WARM_UP_RETRIES);
    if (!homePageDisplayed) {
      // Retry warm up next scenario
      warmUpFile.deleteOnExit();
      // Close Window and retry next scenario
      closeCurrentWindow(driver);
      throw new ElementShouldBeVisibleException("Home Page isn't displayed", null);
    }

    addAdminRandomUser();
    loginAsRandomAdmin();
    if (INIT_DATA) {
      injectData();
    }

    LOGGER.info("---- End warmup phase in {} seconds", (System.currentTimeMillis() - start) / 1000);
  }

  private void injectData() {
    manageSpaceSteps.addOrGoToSpace("randomSpaceName");
    String[] randomUsers = new String[] {
        "first",
        "second",
        "third",
        "fourth",
        "fifth",
        "sixth",
        "firstgami",
        "secondgami",
        "firstkudos",
        "secondkudos",
        "thirdkudos",
        "fourthkudos",
        "fortyonekudos",
        "fortytwokudos",
        "fortythreekudos",
        "fiftyonekudos",
        "fiftytwokudos",
        "fiftythreekudos",
        "firstnoconn",
        "secondnoconn",
        "thirdnoconn",
        "fourthnoconn",
        "fifthnoconn",
        "firstconn",
        "secondconn",
        "thirdconn",
        "fourthconn",
        "fifthconn",
        "firstrequ",
        "secondrequ",
        "thirdrequ",
        "firstcommconn",
        "secondcommconn",
        "thirdcommconn",
        "fourthcommconn",
        "fifthcommconn",
        "firstprofile",
        "secondprofile",
        "fifthkudos",
        "sixthkudos",
        "seventhkudos",
        "thirdprofile",
        "firstlang",
        "seconddisabled",
        "eighteenth",
        "fisrtachievement",
        "secondachievement",
        "thirdachievement",
        "fourachievement",
        "fifthachievement",
        "sixthachievement",
        "seventhachievement",
        "eighthachievement",
        "firstrule",
        "secondrule",
        "reddot",
        "homeicon",
    };
    if (!Arrays.stream(randomUsers).map(this::addRandomUser).allMatch(userCreated -> userCreated)) {
      throw new IllegalStateException("Some users wasn't created successfully in WarmUp phase");
    }
  }

  private void addAdminRandomUser() {
    this.addRandomUser(ADMIN_PREFIX);
    Arrays.stream(ADMIN_GROUPS).forEach(groupId -> addUserSteps.addUserRole(ADMIN_PREFIX, groupId, "*"));
  }

  private boolean addRandomUser(String randomUser) {
    LOGGER.info("Injecting new random user {}", randomUser);
    try {
      addUserSteps.addRandomUser(randomUser, false, true);
      return true;
    } catch (Exception e) {
      LOGGER.warn("Error creating User {} in Warmup phase. Error: {}", randomUser, e.getMessage());
      return false;
    }
  }

}
