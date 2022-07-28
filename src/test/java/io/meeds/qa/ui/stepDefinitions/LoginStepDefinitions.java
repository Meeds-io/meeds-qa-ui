package io.meeds.qa.ui.stepDefinitions;

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

  @Given("^I change user (.*)$")
  public void logOutLogin(String username) {
    loginSteps.logoutLogin(username);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with the first created user$")
  public void logoutLoginFirstUser() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");

    loginSteps.logoutLogin(firstUserName);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with the first created user with the edited password$")
  public void logOutLoginFirstUserEditedPassword() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");

    loginSteps.logoutLogin(firstUserName);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with the second created user$")
  public void logOutLoginSecondUser() {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");

    loginSteps.logoutLogin(secondUserName);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with the third created user$")
  public void logOutLoginThirdUser() {
    String thirdUserName = Serenity.sessionVariableCalled("thirdUserName");

    loginSteps.logoutLogin(thirdUserName);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with the fourth created user$")
  public void logOutLoginFourthUser() {
    String fourthUserName = Serenity.sessionVariableCalled("fourthUserName");

    loginSteps.logoutLogin(fourthUserName);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with the fifth created user$")
  public void logOutLoginFifthUser() {
    String fifthUserName = Serenity.sessionVariableCalled("fifthUserName");

    loginSteps.logoutLogin(fifthUserName);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with the dedicated user to be an administrator$")
  public void logOutLoginFirstAdminUser() {
    String firstAdminName = Serenity.sessionVariableCalled("firstAdminName");

    loginSteps.logoutLogin(firstAdminName);
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

  @Given("^I connect with admin$")
  public void logOutLoginadmin() {
    loginSteps.logoutLogin("admin");
    assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
  }

}
