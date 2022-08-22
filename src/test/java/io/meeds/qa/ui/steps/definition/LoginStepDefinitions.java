package io.meeds.qa.ui.steps.definition;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.meeds.qa.ui.steps.LoginSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {

  @Steps
  private LoginSteps loginSteps;

  @Given("^I am authenticated as (.*)$")
  public void login(String username) {
    loginSteps.authenticate(username);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("I logout")
  public void logout() {
    loginSteps.logout();
  }

  @Given("^I change user (.*)$")
  public void logOutLogin(String username) {
    loginSteps.logoutLogin(username);
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
    logOutLogin(userName);
  }

}
