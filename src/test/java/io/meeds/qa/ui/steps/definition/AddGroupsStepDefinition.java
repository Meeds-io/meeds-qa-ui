package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.meeds.qa.ui.steps.AddGroupsSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AddGroupsStepDefinition {

  @Steps
  HomeSteps      homeSteps;

  @Steps
  AddGroupsSteps addGroupsSteps;

  @Given("^I open the group '(.*)'$")
  public void openGroup(String group) {
    addGroupsSteps.openGroup(group);
  }

  @Given("^I select the group '(.*)'$")
  public void selectGroup(String group) {
    addGroupsSteps.selectGroup(group);
  }

  @Given("^I add the role '(.*)' to the first created user$")
  public void addMemberInGroup(String role) {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String fullName = firstUserFirstName + " " + firstUserLastName;
    addGroupsSteps.addMemberInGroup(role, fullName);
  }

  @Given("^I add the role '(.*)' to the dedicated user to be an administrator$")
  public void addAdminUserInGroup(String role) {
    String firstAdminFirstName = Serenity.sessionVariableCalled("firstAdminFirstName");
    String firstAdminLastName = Serenity.sessionVariableCalled("firstAdminLastName");

    String fullName = firstAdminFirstName + " " + firstAdminLastName;
    addGroupsSteps.addMemberInGroup(role, fullName);
  }

  @And("^I add the role '(.*)' to the second created user$")
  public void addSecondMemberInGroup(String role) {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    addGroupsSteps.addMemberInGroup(role, fullName);
  }

  @Given("^I add the role '(.*)' to the dedicated user to the selected role$")
  public void addUserInGroup(String role) {
    String firstAdminFirstName = Serenity.sessionVariableCalled("firstAdminFirstName");
    String firstAdminLastName = Serenity.sessionVariableCalled("firstAdminLastName");

    String fullName = firstAdminFirstName + " " + firstAdminLastName;
    addGroupsSteps.addMemberInGroup(role, fullName);
  }
}
