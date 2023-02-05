package io.meeds.qa.ui.steps.definition;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.meeds.qa.ui.steps.AddUserSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import net.thucydides.core.annotations.Steps;

public class AddUserStepDefinition {

  @Steps
  private AddUserSteps addUserSteps;

  @Steps
  private HomeSteps    homeSteps;

  @Given("^I create a dedicated user to be an administrator$")
  public void addRandomAdminUser() {
    addUserSteps.addRandomUser("firstAdmin", true);
  }

  @Given("^I create the (.*) random user if not existing$")
  @And("^I create the (.*) random user$")
  public void addRandomUser(String prefix) {
    addUserSteps.addRandomUser(prefix, true);
  }

  @Given("^I create the (.*) random user if not existing, no wait$")
  public void addRandomUserNoWait(String prefix) {
    addUserSteps.addRandomUser(prefix, false);
  }

  @Given("^The following user is created$")
  public void addUser(Map<String, String> userDetails) {
    homeSteps.goToAddUser();
    addUserSteps.addUser(userDetails);
  }

  @Given("^I check that the (.*) random user is deleted$")
  public void checkCreatedUserIsDeleted(String userPrefix) {
    String userLastName = sessionVariableCalled(userPrefix + "UserLastName");
    addUserSteps.checkUserIsDeleted(userLastName);
  }

  @Given("^Popup is displayed to inform user that we can't delete your user account while being logged in with it$")
  public void checkPopupCantDeleteLoggedUser() {
    addUserSteps.checkPopupCantDeleteLoggedUser();
  }

  @Given("^Add Users drawer is opened$")
  public void checkThatAddUserDrawerIsDisplayed() {
    addUserSteps.checkThatAddUserDrawerIsDisplayed();
  }

  @Given("^I check that '(.*)' is deleted'$")
  public void checkUserIsDeleted(String fullName) {
    addUserSteps.checkUserIsDeleted(fullName);
  }

  @Given("^I click to delete user$")
  public void clickToDeleteUser() {
    addUserSteps.clickToDeleteUser();
  }

  @Given("^I delete user$")
  public void deleteUser() {
    addUserSteps.deleteUser();
  }

  @Given("^I enable User Status '(.*)'$")
  @And("^I disable User Status '(.*)'$")
  public void enableDisableUser(String userPrefix) {
    addUserSteps.enableDisableUser(sessionVariableCalled(userPrefix + "UserName"));
  }

  @Given("^I enter the user's informations$")
  public void enterUserInformations(Map<String, String> userDetails) {
    homeSteps.goToAddUser();
    addUserSteps.enterUserInformations(userDetails);
  }

  @Given("^I go to Add Users page$")
  public void goToAddUser() {
    homeSteps.goToAddUser();
  }

  @Given("^The (.*) created user is displayed$")
  public void isFirstUserNameDisplayed(String userPrefix) {
    addUserSteps.isUserNameDisplayed(sessionVariableCalled(userPrefix + "UserName"));
  }

  @Given("^The user '(.*)' is displayed$")
  public void isUserNameDisplayed(String user) {
    addUserSteps.isUserNameDisplayed(user);
  }

  @Given("^I add the user$")
  public void saveAddingUser() {
    addUserSteps.saveAddingUser();
  }

  @Given("^I search for the (.*) random user$")
  public void searchForCreatedUser(String userPrefix) {
    String userName = sessionVariableCalled(userPrefix + "UserName");
    addUserSteps.searchForUsersByName(userName);
  }

  @Given("^I search for user '(.*)'$")
  public void searchForUser(String user) {
    addUserSteps.searchForUsersByName(user);
  }

  @Given("^I search for '(.*)' Users$")
  public void searchForUsersByStatus(String status) {
    addUserSteps.searchForUsersByStatus(status);
  }

}
