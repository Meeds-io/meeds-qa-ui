package io.meeds.qa.ui.hook;

import static io.meeds.qa.ui.utils.Utils.decorateDriver;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.meeds.qa.ui.steps.AdminApplicationSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.LoginSteps;
import io.meeds.qa.ui.steps.ManageBadgesSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import io.meeds.qa.ui.steps.definition.ManageSpaceStepDefinitions;
import io.meeds.qa.ui.utils.ExceptionLauncher;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class TestHooks {

  protected static final Map<String, String> SPACES      = new HashMap<>();

  protected static final Map<String, String> SPACES_URLS = new HashMap<>();

  protected static final Map<String, String> USERS       = new HashMap<>();

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

  private boolean                    adminLoggedIn;

  @Steps
  private HomeSteps                  homeSteps;

  @Steps
  private LoginSteps                 loginSteps;

  @Steps
  private ManageBadgesSteps          manageBadgesSteps;

  @Steps
  private ManageSpaceStepDefinitions manageSpaceStepDefinitions;

  @Steps
  private ManageSpaceSteps           manageSpaceSteps;

  private void cleanupBrowser() {
    try {
      WebDriver driver = Serenity.getDriver();
      String currentUrl = driver.getCurrentUrl();
      driver.manage().deleteAllCookies();
      driver.get(currentUrl.split("/portal/")[0]);
      closeAlertIfExists(driver);
    } catch (Throwable e) { // NOSONAR
      ExceptionLauncher.LOGGER.warn("Error while cleaning browser", e);
    }
  }

  private void closeAlertIfExists(WebDriver driver) {
    try {
      driver.switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
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

  @After
  public void deleteDatas() {
    homeSteps.refreshPage();
    deleteGamificationBadges();
    deleteAppCenterApplications();
    cleanupBrowser();
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

  @Before
  public void initDatas() {
    String adminPassword = System.getProperty("adminPassword");
    Serenity.setSessionVariable("admin-password").to(adminPassword);
    adminLoggedIn = false;

    decorateDriver(Serenity.getDriver());

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

  private void loginAsAdmin() {
    if (!adminLoggedIn) {
      loginSteps.logoutLogin("admin");
      adminLoggedIn = true;
    }
  }

}
