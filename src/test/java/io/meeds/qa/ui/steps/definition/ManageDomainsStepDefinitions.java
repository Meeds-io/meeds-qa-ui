package io.meeds.qa.ui.steps.definition;

import java.util.Random;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ManageDomainsSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ManageDomainsStepDefinitions {
  public static String getRandomString() {
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 6; i++) {
      char c = chars[random.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  @Steps
  private ManageDomainsSteps manageDomainsSteps;

  @And("^I add new Domain with name '(.*)' and '(.*)' as description$")
  public void addDomain(String name, String description) {
    manageDomainsSteps.addDomain(name, description);
  }

  @And("I add new Domain with random name and random description")
  public void addRandomDomain() {
    String domainName = "domain1" + getRandomString();
    String domainDescription = "desc1" + getRandomString();
    Serenity.setSessionVariable("domainName").to(domainName);
    Serenity.setSessionVariable("domainDescription").to(domainDescription);
    manageDomainsSteps.addDomain(domainName, domainDescription);
  }

  @When("^Alert publishing activity '(.*)' is displayed in language arabic$")
  public void checkAlertPublishingActivity(String alert) {
    manageDomainsSteps.checkAlertPublishingActivity(alert);
  }

  @When("^Automatic Translation '(.*)' page is displayed$")
  public void checkTitlePageAutomaticTranslation(String title) {
    manageDomainsSteps.checkTitlePageAutomaticTranslation(title);
  }

  @When("^I confirm the deletion of the domain an it is deleted successfully$")
  public void confirmDeletion() {
    manageDomainsSteps.confirmDomainDeletion();
  }

  @Then("I confirm the addition of the new domain")
  public void confirmNewDomain() {
    manageDomainsSteps.confirmDomain();
  }

  @When("^I click on delete icon to delete the new added domain$")
  public void deleteDomain() {
    manageDomainsSteps.deleteDomain();
  }

  @And("^The domain '(.*)' is not displayed in the domain list$")
  public void domainNameIsNotDisplayed(String domainName) {
    manageDomainsSteps.domainNameIsNotDisplayed(domainName);
  }

  @And("^I click on edit icon and edit the domain name to '(.*)' and I save changes$")
  public void editDomainName(String name) {
    manageDomainsSteps.editDomainName(name);
  }

  @And("I click on edit icon and enter the updated domain name and I save changes")
  public void editRandomDomainName() {
    String updatedDomainName = "updated1" + getRandomString();
    Serenity.setSessionVariable("updatedDomainName").to(updatedDomainName);
    manageDomainsSteps.editDomainName(updatedDomainName);
  }

  @When("^I go to administration$")
  public void goToAdministration() {
    manageDomainsSteps.goToAdministration();
  }

  @When("^I select Automatic Translation$")
  public void goToAutomaticTranslation() {
    manageDomainsSteps.goToAutomaticTranslation();
  }

  @When("^I go to administration then I select manage domains$")
  public void goToManageDomainMenu() {
    manageDomainsSteps.goToManageDomainMenu();
  }

  @And("^The new domain is added successfully and its name '(.*)' is displayed in the domain list$")
  @Then("^The new domain is updated successfully and its name '(.*)' is displayed in the domain list$")
  public void isDomainNameDisplayedInSearchResults(String name) {
    manageDomainsSteps.isDomainNameDisplayedInSearchResults(name);
  }

  @And("The random domain is added successfully and its name is displayed in the domain list")
  public void isRandomDomainNameDisplayedInSearchResults() {
    String domainName = Serenity.sessionVariableCalled("domainName");
    manageDomainsSteps.isDomainNameDisplayedInSearchResults(domainName);
  }

  @Then("The random domain is updated successfully and its name is displayed in the domain list")
  public void isRandomUpdatedDomainDisplayedInSearchResults() {
    String updatedDomainName = Serenity.sessionVariableCalled("updatedDomainName");
    manageDomainsSteps.isDomainNameDisplayedInSearchResults(updatedDomainName);
  }

  @And("The random domain is not displayed in the domain list")
  public void randomDomainNameIsNotDisplayed() {
    String domainName = Serenity.sessionVariableCalled("domainName");
    manageDomainsSteps.domainNameIsNotDisplayed(domainName);
  }

  @Then("The searched domain with its random name is displayed in the list of search results")
  public void randomSearchedDomainNameDisplayed() {
    String domainName = Serenity.sessionVariableCalled("domainName");
    manageDomainsSteps.searchedDomainNameDisplayed(domainName);
  }

  @And("^I search for '(.*)' domain$")
  public void searchDomain(String domain) {
    manageDomainsSteps.searchDomain(domain);
  }

  @Then("^Searched domain name '(.*)' is displayed in the list of search results$")
  public void searchedDomainNameDisplayed(String domain) {
    manageDomainsSteps.searchedDomainNameDisplayed(domain);
  }

  @And("I search for the random domain")
  public void searchRandomDomain() {
    String domainName = Serenity.sessionVariableCalled("domainName");
    manageDomainsSteps.searchDomain(domainName);
  }
}
