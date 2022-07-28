package io.meeds.qa.ui.hook;

import static io.meeds.qa.ui.steps.GenericSteps.switchToTabByIndex;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.meeds.qa.ui.stepDefinitions.ManageSpaceStepDefinitions;
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

  @Before
  public void initDatas() {
    String adminPassword = System.getProperty("adminPassword");
    Serenity.setSessionVariable("admin-password").to(adminPassword);
  }

  @After
  public void deleteDatas() {
    String badgeName = Serenity.sessionVariableCalled("badgeName");
    String updatedBadgeName = Serenity.sessionVariableCalled("updatedBadgeName");

    List<String> spaces = new ArrayList<>();
    String spaceName = Serenity.sessionVariableCalled("spaceName");
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");
    String fourthRandomSpaceName = Serenity.sessionVariableCalled("fourthRandomSpaceName");
    String fifthRandomSpaceName = Serenity.sessionVariableCalled("fifthRandomSpaceName");

    if (badgeName != null && !badgeName.isEmpty()) {
      loginSteps.logoutLogin("admin");
      manageBadgesSteps.goToManageBadgesMenu();
      manageBadgesSteps.clickOnDeleteBadge(badgeName);
      manageBadgesSteps.confirmDeletionBadge();
    }

    if (updatedBadgeName != null && !updatedBadgeName.isEmpty()) {
      loginSteps.logoutLogin("admin");
      manageBadgesSteps.goToManageBadgesMenu();
      manageBadgesSteps.clickOnDeleteBadge(updatedBadgeName);
      manageBadgesSteps.confirmDeletionBadge();
    }

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

    if (spaces != null && !spaces.isEmpty()) {
      switchToTabByIndex(0);
      loginSteps.logoutLogin("admin");
      homeSteps.goToManageSpacesPage();
      manageSpaceSteps.deleteSpacesList(spaces);
    }
  }

}
