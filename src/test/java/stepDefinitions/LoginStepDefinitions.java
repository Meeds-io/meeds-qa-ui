package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import cucumber.api.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import steps.LoginSteps;

public class LoginStepDefinitions {
    @Steps
    private LoginSteps loginSteps;

    @Given("^I am authenticated as$")
    public void login(Map<String, String> credentials) {
        loginSteps.authenticate(credentials);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I change user$")
    public void logOutLogin(Map<String, String> credentials) {
        loginSteps.logOutLogin(credentials);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I connect with the first created user$")
    public void logOutLoginFirstUser() {
        String firstUserName = Serenity.sessionVariableCalled("firstUserName");
        String firstUserPassword = Serenity.sessionVariableCalled("firstUserPassword");

        loginSteps.logOutLoginFirstUser(firstUserName, firstUserPassword);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I connect with the first created user with the edited password$")
    public void logOutLoginFirstUserEditedPassword() {
        String firstUserName = Serenity.sessionVariableCalled("firstUserName");
        String firstUserEditedPassword = Serenity.sessionVariableCalled("firstUserEditedPassword");

        loginSteps.logOutLoginFirstUser(firstUserName, firstUserEditedPassword);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I connect with the second created user$")
    public void logOutLoginSecondUser() {
        String secondUserName = Serenity.sessionVariableCalled("secondUserName");
        String secondUserPassword = Serenity.sessionVariableCalled("secondUserPassword");

        loginSteps.logOutLoginFirstUser(secondUserName, secondUserPassword);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I connect with the third created user$")
    public void logOutLoginThirdUser() {
        String thirdUserName = Serenity.sessionVariableCalled("thirdUserName");
        String thirdUserPassword = Serenity.sessionVariableCalled("thirdUserPassword");

        loginSteps.logOutLoginFirstUser(thirdUserName, thirdUserPassword);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I connect with the fourth created user$")
    public void logOutLoginFourthUser() {
        String fourthUserName = Serenity.sessionVariableCalled("fourthUserName");
        String fourthUserPassword = Serenity.sessionVariableCalled("fourthUserPassword");

        loginSteps.logOutLoginFirstUser(fourthUserName, fourthUserPassword);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I connect with the fifth created user$")
    public void logOutLoginFifthUser() {
        String fifthUserName = Serenity.sessionVariableCalled("fifthUserName");
        String fifthUserPassword = Serenity.sessionVariableCalled("fifthUserPassword");

        loginSteps.logOutLoginFirstUser(fifthUserName, fifthUserPassword);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I connect with the dedicated user to be an administrator$")
    public void logOutLoginFirstAdminUser() {
        String firstAdminName = Serenity.sessionVariableCalled("firstAdminName");
        String firstAdminPassword = Serenity.sessionVariableCalled("firstAdminPassword");

        loginSteps.logOutLoginFirstUser(firstAdminName, firstAdminPassword);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^I connect with admin$")
    public void logOutLoginadmin() {
        loginSteps.logOutLoginFirstUser("admin", "gtngtn");
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

}
