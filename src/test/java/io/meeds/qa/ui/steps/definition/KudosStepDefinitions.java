package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.pages.page.factory.Kudos.KudosPage;
import io.meeds.qa.ui.pages.page.factory.space.SpaceHomePage;
import io.meeds.qa.ui.steps.KudosSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class KudosStepDefinitions {
  @Steps
  private KudosSteps    kudoSteps;

  private SpaceHomePage spaceHomePage;

  private KudosPage     kudosPage;

  @When("^I go to administration then reward then kudos$")
  public void goToAdmin() {
    kudoSteps.goToKudosMenu();
  }

  @And("^I enter a number of kudos'(.*)'$")
  public void kudosSettings(String val) {
    kudoSteps.enterKudosNumber(val);
  }

  @And("I select type period per semester")
  public void selectType() {
    kudoSteps.selectType();
  }

  @And("I save all changes")
  public void saveChanges() {
    kudoSteps.saveChanges();
  }

  @Then("The kudos settings saved with a kudos number equal to '{}' and '{}' period type")
  public void checkKudosSettings(String val, String semester) {
    kudoSteps.checkKudosSettings(val, semester);
  }

  @When("^I sent to the activity '(.*)' a kudos message '(.*)'$")
  public void addActivityKudos(String activity, String kudos) {
    kudosPage.addActivityKudos(spaceHomePage.getActivityElement(activity), kudos);
  }

  @And("^kudos icon of the activity '(.*)' is Disabled$")
  public void checkKudosIcon(String activityId) {
    kudoSteps.checkKudosIcon(activityId);
  }

  @And("^I set the new kudos '(.*)' and I click on update button$")
  public void updateKudosMessage(String kudos) {
    kudoSteps.updateKudosMessage(kudos);
  }

  @And("I search for '{}' card")
  public void SearchUserCard(String user) {
    kudoSteps.SearchUserCard(user);
  }

  @And("I search for second user card")
  public void SearchSecondUserCard() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String fullName = secondUserFirstName + " " + secondUserLastName;
    kudoSteps.SearchUserCard(fullName);
  }

  @And("^I click on send kudos button and I send kudos with message '(.*)'$")
  public void threeDotsMenuSendKudos(String kudosMessage) {
    kudoSteps.threeDotsMenuSendKudos(kudosMessage);
  }

  @And("^the kudos activity UI '(.*)' is displayed in stream page$")
  @Then("^the updated Kudos activity '(.*)' is displayed in stream page$")
  public void checkkudosActivity(String message) {
    kudoSteps.isKudosActivityVisible(message);
  }

  @And("I click on three dots menu click on the edit button")
  public void editKudos() {
    kudoSteps.editKudos();
  }

  @When("^I sent to the comment activity a kudos message '(.*)'$")
  public void addActivityCommentKudos(String kudos) {
    kudosPage.addActivityCommentKudos(kudos);
  }

  @When("^I sent to the comment activity a kudos message '(.*)' from comments drawer$")
  public void addActivityCommentKudosFromDrawer(String kudos) {
    kudoSteps.addActivityCommentKudosFromDrawer(kudos);
  }

  @Given("^I click to edit the kudos text$")
  public void clickEditKudos() {
    kudoSteps.clickEditKudos();
  }

  @Given("^I click to edit the kudos from a reply comment$")
  public void clickEditKudosFromReply() {
    kudoSteps.clickEditKudosFromReply();
  }

  @Given("^I set the new kudos comment text '(.*)' and I click on update button$")
  public void updateKudosCommentMessage(String kudos) {
    kudoSteps.updateKudosCommentMessage(kudos);
  }
}
