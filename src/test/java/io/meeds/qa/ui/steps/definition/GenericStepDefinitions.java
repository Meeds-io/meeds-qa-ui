package io.meeds.qa.ui.steps.definition;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.GalenSteps;
import io.meeds.qa.ui.steps.GenericSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class GenericStepDefinitions {
  @Steps
  GenericSteps genericSteps;

  @Steps
  GalenSteps   galenSteps;

  @When("Confirmation message is displayed '{}'")
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

  @When("The button '{}' is displayed")
  public void checkButton(String button) {
    assertThat(genericSteps.isButtonDisplayed(button)).as(String.format("The button %s should be displayed but it is not",
                                                                        button))
                                                      .isTrue();
  }

  @When("^I confirm$")
  public void clickConfirm() {
    genericSteps.clickConfirm();
  }

  @When("^I click on 'OK' button$")
  public void clickOkButton() {
    genericSteps.clickOkButton();
  }

  @When("I wait '{int}' seconds")
  public void waitInSeconds(int seconds) {
    genericSteps.waitInSeconds(seconds);
  }

  @When("^The '(.*)' is displayed$")
  public void checkPage(String template) throws IOException, InterruptedException {
    Serenity.setSessionVariable("templateName").to(template);
    galenSteps.checkPage("/specs/" + template + ".spec");
    assertThat(galenSteps.getListOfFails()).as(String.format("These pages %s is displayed with errors",
                                                             galenSteps.getListOfFails()))
                                           .isEmpty();
  }

  @Then("The page {string} that contains {string} is displayed")
  public void checkPage(String pageUri, String content) {
    WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
    String currentUrl = driver.getCurrentUrl();
    assertThat(StringUtils.contains(currentUrl, pageUri)).as(String.format("Current URL '%s' doesn't end with '%s'",
                                                                           currentUrl,
                                                                           pageUri))
                                                         .isTrue();
    assertThat(genericSteps.containsContent(content)).as(String.format("Current Page '%s' doesn't contain '%s'",
                                                                       currentUrl,
                                                                       content))
                                                     .isTrue();
  }
}
