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

  @Given("I connect with the first created user")
  public void logoutLoginFirstUser() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    logOutLogin(firstUserName);
  }

  @Given("^I connect with the first created user with the edited password$")
  public void logOutLoginFirstUserEditedPassword() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    logOutLogin(firstUserName);
  }

  @Given("^I connect with the second created user$")
  public void logOutLoginSecondUser() {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    logOutLogin(secondUserName);
  }

  @Given("^I connect with the third created user$")
  public void logOutLoginThirdUser() {
    String thirdUserName = Serenity.sessionVariableCalled("thirdUserName");
    logOutLogin(thirdUserName);
  }

  @Given("^I connect with the fourth created user$")
  public void logOutLoginFourthUser() {
    String fourthUserName = Serenity.sessionVariableCalled("fourthUserName");
    logOutLogin(fourthUserName);
  }

  @Given("^I connect with the fifth created user$")
  public void logOutLoginFifthUser() {
    String fifthUserName = Serenity.sessionVariableCalled("fifthUserName");
    logOutLogin(fifthUserName);
  }

  @Given("^I connect with the dedicated user to be an administrator$")
  public void logOutLoginFirstAdminUser() {
    String firstAdminName = Serenity.sessionVariableCalled("firstAdminName");
    logOutLogin(firstAdminName);
  }

  @Given("^I connect with admin$")
  public void logOutLoginadmin() {
    logOutLogin("admin");
  }

}
