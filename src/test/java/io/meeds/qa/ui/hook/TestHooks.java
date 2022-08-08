package io.meeds.qa.ui.hook;

import static io.meeds.qa.ui.steps.GenericSteps.switchToTabByIndex;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.meeds.qa.ui.stepDefinitions.ManageSpaceStepDefinitions;
import io.meeds.qa.ui.steps.AdminApplicationSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.LoginSteps;
import io.meeds.qa.ui.steps.ManageBadgesSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class TestHooks {

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
  }

  @After
  public void deleteDatas() {
    deleteGamificationBadges();
    deleteSpaces();
    deleteAppCenterApplications();
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

  private void deleteSpaces() {
    List<String> spaces = new ArrayList<>();
    String spaceName = Serenity.sessionVariableCalled("spaceName");
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");
    String fourthRandomSpaceName = Serenity.sessionVariableCalled("fourthRandomSpaceName");
    String fifthRandomSpaceName = Serenity.sessionVariableCalled("fifthRandomSpaceName");

    if (spaceName != null && !spaceName.isEmpty()) {
      spaces.add(spaceName);
    }

    if (randomSpaceName != null && !randomSpaceName.isEmpty()) {
      spaces.add(randomSpaceName);
    }

    if (secondRandomSpaceName != null && !secondRandomSpaceName.isEmpty()) {
      spaces.add(secondRandomSpaceName);
    }

    if (thirdRandomSpaceName != null && !thirdRandomSpaceName.isEmpty()) {
      spaces.add(thirdRandomSpaceName);
    }

    if (fourthRandomSpaceName != null && !fourthRandomSpaceName.isEmpty()) {
      spaces.add(fourthRandomSpaceName);
    }

    if (fifthRandomSpaceName != null && !fifthRandomSpaceName.isEmpty()) {
      spaces.add(fifthRandomSpaceName);
    }

    if (!spaces.isEmpty()) {
      loginAsAdmin();
      switchToTabByIndex(0);
      homeSteps.goToManageSpacesPage();
      manageSpaceSteps.deleteSpacesList(spaces);
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
