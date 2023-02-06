package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.Given;
import io.meeds.qa.ui.steps.AddGroupsSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AddGroupsStepDefinition {

  @Steps
  private AddGroupsSteps addGroupsSteps;

  @Steps
  private HomeSteps      homeSteps;

  @Given("^I add the role '(.*)' to the (.*) created user$")
  public void addMemberInGroup(String role, String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    addGroupsSteps.addMemberInGroup(role, userLastName);
  }

  @Given("^I open the group '(.*)'$")
  public void openGroup(String group) {
    addGroupsSteps.openGroup(group);
  }

  @Given("^I select the group '(.*)'$")
  public void selectGroup(String group) {
    addGroupsSteps.selectGroup(group);
  }

}
