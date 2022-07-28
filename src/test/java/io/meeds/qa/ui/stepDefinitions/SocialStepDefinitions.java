package io.meeds.qa.ui.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.PeopleSteps;
import io.meeds.qa.ui.steps.SocialSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class SocialStepDefinitions {
  @Steps
  private SocialSteps socialSteps;

  private PeopleSteps peopleSteps;

  @And("I add a comment in activity '(.*)'$")
  public void commentActivity(String activity) {
    socialSteps.commentActivity(activity);
  }

  @When("I go to people page")
  public void goToPeoplePage() {
    socialSteps.goToPeopleMenu();
  }

  @And("I click on People filter and I select My connections")
  public void filterByMyConnections() {
    socialSteps.filterByMyConnections();

  }

  @And("I enter the contact name '(.*)'")
  public void insertNameContact(String user) {
    socialSteps.insertNameContact(user);
  }

  @And("I enter the contact name of the first user")
  public void insertNameOfFirstContact() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String fullName = firstUserFirstName + " " + firstUserLastName;
    socialSteps.insertNameContact(fullName);
  }

  @And("I enter the contact name of the second user")
  public void insertNameOfSecondContact() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    socialSteps.insertNameContact(fullName);
  }

  @Given("The search result is well matched with the username entered '(.*)'")
  public void checkSearchedUserWellMatched(String user) {
    socialSteps.checkSearchedUserWellMatched(user);
  }

  @Given("The search result is well matched with the username entered of the first user")
  public void checkSearchedFirstUserWellMatched() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    socialSteps.checkSearchedUserWellMatched(firstUserName);
  }

  @Given("The search result is well matched with the username entered of the second user")
  public void checkSearchedSecondUserWellMatched() {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    socialSteps.checkSearchedUserWellMatched(secondUserName);
  }

  @And("I Select the comment added and I click on edit button")
  public void editComment() {
    socialSteps.editComment();
  }

  @When("I set the new comment '(.*)' and I click on update button")
  public void updateActivityComment(String comment) {
    socialSteps.updateActivityComment(comment);
  }

  @When("I set the new comment '(.*)' and I click on cancel button")
  public void cancelUpdateActivityComment(String comment) {
    socialSteps.cancelUpdateActivityComment(comment);
  }
}
