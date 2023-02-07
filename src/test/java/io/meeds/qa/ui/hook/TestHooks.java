package io.meeds.qa.ui.hook;

import static net.serenitybdd.core.Serenity.setSessionVariable;
import static io.meeds.qa.ui.utils.Utils.waitRemainingTime;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
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
import io.meeds.qa.ui.utils.ExceptionLauncher;
import io.meeds.qa.ui.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeVisibleException;

public class TestHooks {

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
  AddUserSteps                       addUserSteps;

  @After
  public void deleteDatas() {
    try {
      deleteGamificationBadges();
      deleteAppCenterApplications();
    } catch (Exception e) {
      ExceptionLauncher.LOGGER.warn("Error while deleting previously created data", e);
    }
    genericSteps.closeAllDrawers();
  }

  @Before
  public void initDatas() { // NOSONAR
    String adminPassword = System.getProperty("adminPassword");
    Serenity.setSessionVariable("admin-password").to(adminPassword);

    WebDriver driver = Serenity.getDriver();

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

  private void deleteAppCenterApplications() {
    // cleanup created AppCenter applications
    List<String> appNames = Serenity.sessionVariableCalled("appCenterAppName");
    if (CollectionUtils.isNotEmpty(appNames)) {
      loginAsAdmin();
      homeSteps.goToAppCenterAdminSetupPage();
      for (String appName : appNames) {
        if (adminApplicationSteps.isAppExists(appName)) {
          adminApplicationSteps.deleteApp(appName, true);
        }
      }
    }
  }

  private void deleteGamificationBadges() {
    String badgeName = Serenity.sessionVariableCalled("badgeName");
    String updatedBadgeName = Serenity.sessionVariableCalled("updatedBadgeName");

    if (badgeName != null && !badgeName.isEmpty()) {
      loginAsAdmin();
      manageBadgesSteps.goToManageBadgesMenu();
      manageBadgesSteps.clickOnDeleteBadge(badgeName);
      manageBadgesSteps.confirmDeletionBadge();
    }

    if (updatedBadgeName != null && !updatedBadgeName.isEmpty()) {
      loginAsAdmin();
      manageBadgesSteps.goToManageBadgesMenu();
      manageBadgesSteps.clickOnDeleteBadge(updatedBadgeName);
      manageBadgesSteps.confirmDeletionBadge();
    }
  }

  private boolean isHamburgerNavigationDisplayed() {
    try {
      return loginSteps.isHamburgerNavigationDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  private void loginAsAdmin() {
    loginSteps.authenticate("admin");
  }

  private void warmUp(WebDriver driver) {
    File warmUpFile = new File(WARMUP_FILE_PATH);
    if (warmUpFile.exists()) {
      ExceptionLauncher.LOGGER.debug("Warmup already proceeded. Execute test scenario.");
      return;
    }
    try {
      if (!warmUpFile.createNewFile()) {
        throw new IOException("Warmup File not created");
      }
    } catch (IOException e) {
      // Will attempt to warmup again next time
      ExceptionLauncher.LOGGER.warn("Error creating warmup file {}. Proceed to execute Test scenario without warmup.",
                                    WARMUP_FILE_PATH,
                                    e);
      return;
    }

    ExceptionLauncher.LOGGER.info("---- Start warmup phase with {} retries and wait time of {} seconds",
                                  MAX_WARM_UP_RETRIES,
                                  MAX_WARM_UP_STEP_WAIT);
    long start = System.currentTimeMillis();
    int retryCount = 1;
    boolean homePageDisplayed = false;
    do {
      ExceptionLauncher.LOGGER.info("---- {}/{} Warmup step",
                                    retryCount,
                                    MAX_WARM_UP_RETRIES);
      try {
        driver.navigate().to(System.getProperty("webdriver.base.url"));
        Utils.waitForLoading(WARM_UP_PAGE_LOADING_WAIT, true);
        loginAsAdmin();
        Utils.waitForLoading(WARM_UP_PAGE_LOADING_WAIT, true);
        homePageDisplayed = isHamburgerNavigationDisplayed();
        if (!homePageDisplayed) {
          throw new ElementShouldBeVisibleException("Home Page isn't displayed", null);
        }
        // Make sure to use EN language for admin user
        driver.navigate().to(driver.getCurrentUrl().replace("/portal", "/portal/en"));
        Utils.waitForLoading(WARM_UP_PAGE_LOADING_WAIT, true);
      } catch (Throwable e) { // NOSONAR
        ExceptionLauncher.LOGGER.warn("Error authenticating admin user", e);
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
    if (INIT_DATA) {
      String[] randomUsers = new String[] {
          "first",
          "second",
          "third",
          "fourth",
          "fifth",
          "sixth",
      };
      Arrays.stream(randomUsers).forEach(randomUser -> addUserSteps.addRandomUser(randomUser, false));
      manageSpaceSteps.addOrGoToSpace("randomSpaceName");
    }
    ExceptionLauncher.LOGGER.info("---- End warmup phase in {} seconds", (System.currentTimeMillis() - start) / 1000);
  }

  private void closeCurrentWindow(WebDriver driver) {
    try {
      driver.close(); // Close current window to refresh static resources
    } catch (Throwable e) { // NOSONAR
      // no need to throw an exception, the window may be already closed
    }
  }

}
