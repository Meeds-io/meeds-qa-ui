package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.KudosSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class KudosStepDefinitions {

  @Steps
  private KudosSteps    kudoSteps;

  @When("^I send to the comment activity a kudos message '(.*)'$")
  public void addActivityCommentKudos(String kudos) {
    kudoSteps.addActivityCommentKudos(kudos);
  }

  @When("^I send to the activity '(.*)' a kudos message '(.*)'$")
  public void addActivityKudos(String activity, String kudos) {
    kudoSteps.addActivityKudos(activity, kudos);
  }

  @And("^the kudos activity UI '(.*)' is displayed in stream page$")
  @Then("^the updated Kudos activity '(.*)' is displayed in stream page$")
  public void checkkudosActivity(String message) {
    kudoSteps.isKudosActivityVisible(message);
  }

  @And("^kudos icon of the activity '(.*)' is Disabled$")
  public void checkKudosIconDisabled(String activityId) {
    kudoSteps.checkKudosIconDisabled(activityId);
  }

  @Then("The kudos settings saved with a kudos number equal to '{}' and '{}' period type")
  public void checkKudosSettings(String val, String semester) {
    kudoSteps.checkKudosSettings(val, semester);
  }

  @Given("^I click to edit the kudos text$")
  public void clickEditKudos() {
    kudoSteps.clickEditKudos();
  }

  @Given("^I click to edit the kudos from a reply comment$")
  public void clickEditKudosFromReply() {
    kudoSteps.clickEditKudosFromReply();
  }

  @And("I click on three dots menu click on the edit button")
  public void editKudos() {
    kudoSteps.editKudos();
  }

  @When("^I go to administration then reward then kudos$")
  public void goToAdmin() {
    kudoSteps.goToKudosMenu();
  }

  @And("^I enter a number of kudos'(.*)'$")
  public void kudosSettings(String val) {
    kudoSteps.enterKudosNumber(val);
  }

  @And("I save all changes")
  public void saveChanges() {
    kudoSteps.saveChanges();
  }

  @And("I search for second user card")
  public void searchSecondUserCard() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    kudoSteps.searchUserCard(fullName);
  }

  @And("I search for '{}' card")
  public void searchUserCard(String user) {
    kudoSteps.searchUserCard(user);
  }

  @And("I select type period per semester")
  public void selectType() {
    kudoSteps.selectType();
  }

  @And("^I click on send kudos button and I send kudos with message '(.*)'$")
  public void threeDotsMenuSendKudos(String kudosMessage) {
    kudoSteps.threeDotsMenuSendKudos(kudosMessage);
  }

  @Given("^I set the new kudos comment text '(.*)' and I click on update button$")
  @And("^I set the new kudos '(.*)' and I click on update button$")
  public void updateKudosMessage(String kudos) {
    kudoSteps.updateKudosMessage(kudos);
  }

  @When("^I send to the activity '(.*)' a kudos message '(.*)' to (.*) created user$")
  public void addActivityKudosToSomeoneDifferent(String activity, String message, String userPrefix) {
    String secondUserFirstName = Serenity.sessionVariableCalled(userPrefix+ "UserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled(userPrefix+ "UserLastName");
    String fullName =  secondUserFirstName + " " + secondUserLastName;
    kudoSteps.addActivityKudosToSomeoneDifferent(activity, message, fullName);
  }

  @When("^I send to the activity '(.*)' a kudos to (.*) to '(.*)'$")
  public void addKudosToSomeoneDifferent(String activity, String userPrefix, String message) {
    String secondUserFirstName = Serenity.sessionVariableCalled(userPrefix + "UserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    String fullName = secondUserFirstName + " " + secondUserLastName;
    kudoSteps.addKudosToSomeoneDifferent(activity, message, fullName);
  }
}
