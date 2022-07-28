package io.meeds.qa.ui.stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.GalenSteps;
import io.meeds.qa.ui.steps.GenericSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

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
