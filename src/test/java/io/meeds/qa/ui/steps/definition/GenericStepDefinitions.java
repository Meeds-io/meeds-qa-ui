package io.meeds.qa.ui.steps.definition;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.GenericSteps;
import net.thucydides.core.annotations.Steps;

public class GenericStepDefinitions {

  @Steps
  GenericSteps genericSteps;

  @When("The button '{}' is displayed")
  public void checkButton(String button) {
    assertThat(genericSteps.isButtonDisplayed(button)).as(String.format("The button %s should be displayed but it is not",
                                                                        button))
                                                      .isTrue();
  }

  @When("Confirmation message is displayed '{}'")
  public void checkConfirmMessage(String message) {
    assertThat(genericSteps.inConfirmMessageDisplayed(message)).as(String.format("Confirm message %s should be displayed but it is not",
                                                                                 message))
                                                               .isTrue();
  }

  @When("^The '(.*)' drawer is displayed$")
  public void checkDrawerDisplayed(String title) throws IOException, InterruptedException {
    genericSteps.checkDrawerDisplayed(title);
  }

  @Then("The page {string} is displayed")
  public void checkPage(String pageUri) {
    String currentUrl = genericSteps.getCurrentUrl();
    assertThat(StringUtils.contains(currentUrl, pageUri)).as(String.format("Current URL '%s' doesn't end with '%s'",
                                                                           currentUrl,
                                                                           pageUri))
                                                         .isTrue();

  }

  @Then("The page {string} that contains {string} is displayed")
  public void checkPage(String pageUri ,  String content) {
    String currentUrl = genericSteps.getCurrentUrl();
    assertThat(StringUtils.contains(currentUrl, pageUri)).as(String.format("Current URL '%s' doesn't end with '%s'",
                    currentUrl,
                    pageUri))
            .isTrue();

    assertThat(genericSteps.containsContent(content)).as(String.format("Current Page '%s' doesn't contain '%s'",
                    currentUrl,
                    content))
            .isTrue();
  }

  @When("success message is displayed")
  public void checkSuccessMessage() {
    assertThat(genericSteps.isSuccessMessageDisplayed()).as(String.format("Success message should be displayed but it is not"))
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

  @When("I close browser tab {int}")
  public void closeBrowserTab(int tabIndex) {
    genericSteps.closeBrowserTab(tabIndex);
  }

  @Then("I close the opened drawer")
  public void closeDrawerIfDisplayed() {
    genericSteps.closeDrawerIfDisplayed();
  }

  @When("I wait '{int}' seconds")
  public void waitInSeconds(int seconds) {
    genericSteps.waitInSeconds(seconds);
  }
}
