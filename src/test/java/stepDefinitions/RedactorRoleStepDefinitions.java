package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.RedactorRoleSteps;

public class RedactorRoleStepDefinitions {

    @Steps
    private RedactorRoleSteps redactorRoleSteps;

    @And("I set as a redactor")
    public void setRedactor() {
        redactorRoleSteps.setRedactor();
    }

    @And("I set as a space manager")
    public void setAsSpaceManager() {
        redactorRoleSteps.setAsSpaceManager();
    }

    @Then("\"write a short message\" drawer  is visible")
    public void checkPostDrawer() {
        redactorRoleSteps.checkPostDrawer();

    }

    @Then("I click on three dots menu")
    public void dotsbtn() {
        redactorRoleSteps.ThreeDotsMenu();

    }
}
