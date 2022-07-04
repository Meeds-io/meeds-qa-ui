package testHooks;

import cucumber.api.java.After;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import stepDefinitions.ManageSpaceStepDefinitions;
import steps.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static steps.GenericSteps.switchToTabByIndex;

public class AfterHooks {
    @Steps
    private ManageSpaceSteps manageSpaceSteps;

    @Steps
    private ManageSpaceStepDefinitions manageSpaceStepDefinitions;

    @Steps
    private HomeSteps homeSteps;

    @Steps
    private ChatSteps chatSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private ManageBadgesSteps manageBadgesSteps;

    Map<String, String> credentials = new HashMap<String, String>() {
        {
            put("login", "root");
            put("password", "password");

        }
    };

    Map<String, String> secondCredentials = new HashMap<String, String>() {
        {
            put("login", "john");
            put("password", "gtngtn");

        }
    };

    @After
    public void deleteDatas() {
        String roomName = Serenity.sessionVariableCalled("roomName");
        String badgeName = Serenity.sessionVariableCalled("badgeName");
        String updatedBadgeName = Serenity.sessionVariableCalled("updatedBadgeName");
        List<String> spaces = new ArrayList<>();
        String spaceName = Serenity.sessionVariableCalled("spaceName");
        String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
        String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
        String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");
        String fourthRandomSpaceName = Serenity.sessionVariableCalled("fourthRandomSpaceName");
        String fifthRandomSpaceName = Serenity.sessionVariableCalled("fifthRandomSpaceName");

        if (roomName != null) {
            loginSteps.logOutLogin(secondCredentials);
            homeSteps.openChatDrawer();
            chatSteps.deleteRoom(roomName);
        }

        if (badgeName != null && !badgeName.isEmpty()) {
            loginSteps.logOutLogin(secondCredentials);
            manageBadgesSteps.goToManageBadgesMenu();
            manageBadgesSteps.clickOnDeleteBadge(badgeName);
            manageBadgesSteps.confirmDeletionBadge();
        }

        if (updatedBadgeName != null && !updatedBadgeName.isEmpty()) {
            loginSteps.logOutLogin(secondCredentials);
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
            loginSteps.logOutLogin(credentials);
            homeSteps.goToManageSpacesPage();
            manageSpaceSteps.deleteSpacesList(spaces);
        }
    }

}
