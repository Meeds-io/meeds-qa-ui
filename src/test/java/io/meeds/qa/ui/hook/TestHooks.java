package io.meeds.qa.ui.hook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.meeds.qa.ui.steps.AdminApplicationSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.LoginSteps;
import io.meeds.qa.ui.steps.ManageBadgesSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import io.meeds.qa.ui.steps.definition.ManageSpaceStepDefinitions;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class TestHooks {

  protected static final ThreadLocal<Map<String, String>> SPACES = new ThreadLocal<>();

  protected static final ThreadLocal<Map<String, String>> USERS  = new ThreadLocal<>();

  @Steps
  private ManageSpaceSteps                                manageSpaceSteps;

  @Steps
  private ManageSpaceStepDefinitions                      manageSpaceStepDefinitions;

  @Steps
  private HomeSteps                                       homeSteps;

  @Steps
  private LoginSteps                                      loginSteps;

  @Steps
  private ManageBadgesSteps                               manageBadgesSteps;

  @Steps
  private AdminApplicationSteps                           adminApplicationSteps;

  private boolean                                         adminLoggedIn;

  @BeforeAll
  public static void setup() {
    SPACES.set(new HashMap<>());
    USERS.set(new HashMap<>());
  }

  @AfterAll
  public static void teardown() {
    SPACES.remove();
    USERS.remove();
  }

  @Before
  public void initDatas() {
    String adminPassword = System.getProperty("adminPassword");
    Serenity.setSessionVariable("admin-password").to(adminPassword);
    adminLoggedIn = false;
    loginSteps.open();
    WebDriver driver = Serenity.getDriver();
    driver.manage().deleteAllCookies();
    driver.navigate().refresh();

    SPACES.get().entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey()).to(entry.getValue());
      }
    });
    USERS.get().entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey()).to(entry.getValue());
      }
    });
  }

  @After
  public void deleteDatas() {
    deleteGamificationBadges();
    deleteAppCenterApplications();
  }

  public static void spaceWithPrefixDeleted(String spaceNamePrefix) {
    SPACES.get().put(spaceNamePrefix, null);
  }

  public static void spaceWithPrefixCreated(String spaceNamePrefix, String spaceName) {
    SPACES.get().put(spaceNamePrefix, spaceName);
  }

  public static void userWithPrefixCreated(String userPrefix,
                                           String userName,
                                           String firstName,
                                           String lastName,
                                           String email,
                                           String password) {
    USERS.get().put(userPrefix + "UserName", userName);
    USERS.get().put(userPrefix + "UserFirstName", firstName);
    USERS.get().put(userPrefix + "UserLastName", lastName);
    USERS.get().put(userPrefix + "UserPassword", password);
    USERS.get().put(userName + "-password", password);
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

  private void loginAsAdmin() {
    if (!adminLoggedIn) {
      loginSteps.logoutLogin("admin");
      adminLoggedIn = true;
    }
  }

}
