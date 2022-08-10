package io.meeds.qa.ui.hook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.meeds.qa.ui.steps.AdminApplicationSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.LoginSteps;
import io.meeds.qa.ui.steps.ManageBadgesSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import io.meeds.qa.ui.steps.definition.ManageSpaceStepDefinitions;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class TestHooks {

  protected static final Map<String, String> SPACES = new HashMap<>();

  protected static final Map<String, String> USERS  = new HashMap<>();

  static {
    SPACES.put("spaceName", null);
    SPACES.put("randomSpaceName", null);
    SPACES.put("secondRandomSpaceName", null);
    SPACES.put("thirdRandomSpaceName", null);
    SPACES.put("fourthRandomSpaceName", null);
    SPACES.put("fifthRandomSpaceName", null);
  }

  @Steps
  private ManageSpaceSteps           manageSpaceSteps;

  @Steps
  private ManageSpaceStepDefinitions manageSpaceStepDefinitions;

  @Steps
  private HomeSteps                  homeSteps;

  @Steps
  private LoginSteps                 loginSteps;

  @Steps
  private ManageBadgesSteps          manageBadgesSteps;

  @Steps
  private AdminApplicationSteps      adminApplicationSteps;

  private boolean                    adminLoggedIn;

  @Before
  public void initDatas() {
    String adminPassword = System.getProperty("adminPassword");
    Serenity.setSessionVariable("admin-password").to(adminPassword);
    adminLoggedIn = false;
    loginSteps.open();
    Serenity.getWebdriverManager().getCurrentDriver().manage().deleteAllCookies();

    SPACES.entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey()).to(entry.getValue());
      }
    });
    USERS.entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey()).to(entry.getValue());
      }
    });
  }

  @After
  public void deleteDatas() {
    deleteGamificationBadges();
    setSpaceNames();
    deleteAppCenterApplications();
  }

  public static void spaceWithPrefixDeleted(String spaceNamePrefix) {
    SPACES.put(spaceNamePrefix, null);
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
    USERS.put(userName + "-password", password);
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

  private void setSpaceNames() {
    SPACES.keySet().forEach(key -> {
      String value = Serenity.sessionVariableCalled(key);
      if (StringUtils.isNotBlank(value)) {
        Serenity.setSessionVariable(key).to(value);
      }
    });
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
