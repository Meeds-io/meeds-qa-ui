package io.meeds.qa.ui.steps.definition;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import io.cucumber.java.en.Given;
import io.meeds.qa.ui.steps.LoginSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {

  @Steps
  private LoginSteps loginSteps;

  @Given("^I am authenticated as (.*)$")
  public void authenticate(String username) {
    loginSteps.authenticate(username);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect as (.*) if random users doesn't exists$")
  public void authenticateIfUsersNotExists(String username, List<String> userPrefixes) {
    loginSteps.authenticateIfUsersNotExists("admin", userPrefixes);
  }

  @Given("^I connect as (.*) if random space and random users doesn't exists$")
  public void authenticateIfRandomSpaceAndUsersNotExists(String username, List<String> userPrefixes) {
    loginSteps.authenticateIfRandomSpaceAndUsersNotExists(username, "randomSpaceName", userPrefixes);
  }

  @Given("I logout")
  public void logout() {
    loginSteps.logout();
  }

  @Given("^I change user (.*)$")
  public void logOutLogin(String username) {
    authenticate(username);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with admin$")
  public void logOutLoginadmin() {
    logOutLogin("admin");
  }

  @Given("^I connect with the dedicated user to be an administrator$")
  public void logOutLoginFirstAdminUser() {
    String firstAdminName = Serenity.sessionVariableCalled("firstAdminName");
    logOutLogin(firstAdminName);
  }

  @Given("I connect with the first created user with the edited password")
  public void logOutLoginFirstUserEditedPassword() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    logOutLogin(firstUserName);
  }

  @Given("^I connect with the (.*) created user$")
  public void logoutLoginUser(String userPrefix) {
    String userName = Serenity.sessionVariableCalled(userPrefix + "UserName");
    authenticate(userName);
  }

}
