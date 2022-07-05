package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;
import static steps.GenericSteps.switchToTabByIndex;

import java.io.IOException;

import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import steps.GalenSteps;
import steps.GenericSteps;

public class GenericStepDefinitions {
  @Steps
  GenericSteps genericSteps;

  @When("Confirmation message is displayed '(.*)'")
  public void checkConfirmMessage(String message) {
    assertThat(genericSteps.inConfirmMessageDisplayed(message)).as(String.format("Confirm message %s should be displayed but it is not",
                                                                                 message))
                                                               .isTrue();
  }

  @When("success message is displayed")
  public void checkSuccessMessage() {
    assertThat(genericSteps.isSuccessMessageDisplayed()).as(String.format("Success message should be displayed but it is not"))
                                                        .isTrue();
  }

  @When("The button '(.*)' is displayed")
  public void checkButton(String button) {
    assertThat(genericSteps.isButtonDisplayed(button)).as(String.format("The button %s should be displayed but it is not",
                                                                        button))
                                                      .isTrue();
  }

  @When("^I confirm$")
  public void clickConfirm() {
    genericSteps.clickConfirm();
  }

  @When("^I click on 'OK' button")
  public void clickOkButton() {
    genericSteps.clickOkButton();
  }

  @When("^I confirm to pin the article and I go to the space activity stream$")
  public void clickConfirmAndGoToSpaceStream() {
    genericSteps.clickConfirm();
    switchToTabByIndex(0);
  }

  @Steps
  GalenSteps galenSteps;

  @When("^The '(.*)' is displayed$")
  public void checkPage(String template) throws IOException, InterruptedException {
    Serenity.setSessionVariable("templateName").to(template);
    galenSteps.checkPage("/specs/" + template + ".spec");
    assertThat(galenSteps.getListOfFails()).as(String.format("These pages %s is displayed with errors",
                                                             galenSteps.getListOfFails()))
                                           .isEmpty();
  }
}
