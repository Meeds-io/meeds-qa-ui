package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.ApplicationSteps;
import io.meeds.qa.ui.steps.GenericSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ApplicationStepDefinition {
  @Steps
  private ApplicationSteps applicationSteps;

  @Steps
  private GenericSteps     genericSteps;

  @When("^I remove Application '(.*)' From Favorites$")
  @And("^I add Application '(.*)' To Favorites$")
  public void addRemoveApplicationToFavorites(String app) {
    applicationSteps.addRemoveApplicationToFavorites(app);

  }

  @Then("^I bookmark the application '(.*)'$")
  public void bookmarkApplication(String appTitle) {
    applicationSteps.bookmarkApplication(appTitle);
  }

  @Then("I bookmark the random application")
  public void bookmarkRandomApplication() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.bookmarkApplication(randomApplicationTitle);
  }

  @Then("^The application '(.*)' is not displayed in application list$")
  public void checkApplicationNotVisible(String appName) {
    applicationSteps.checkApplicationIsNotVisible(appName);
  }

  @Then("^The application '(.*)' is displayed in application list$")
  public void checkApplicationVisible(String appName) {
    applicationSteps.checkApplicationIsVisible(appName);
  }

  @Then("The random application is not displayed in application list")
  public void checkRandomApplicationNotVisible() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.checkApplicationIsNotVisible(randomApplicationTitle);
  }

  @Then("The random application is displayed in application list")
  public void checkRandomApplicationVisible() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.checkApplicationIsVisible(randomApplicationTitle);
  }

  @Then("^Add Application '(.*)' To Favorites Btn Is Displayed$")
  public void checkThatAddApplicationBtnToFavoritesIsDisplayed(String app) {
    applicationSteps.checkThatAddApplicationBtnToFavoritesIsDisplayed(app);

  }

  @When("^AppCenter Application '(.*)' is added To Favorites$")
  public void checkThatAppcenterApplicationIsDisplayed(String app) {
    applicationSteps.checkThatAppcenterApplicationIsDisplayed(app);

  }

  @When("^AppCenter Application '(.*)' is removed From Favorites$")
  public void checkThatAppcenterApplicationIsNotDisplayed(String app) {
    applicationSteps.checkThatAppcenterApplicationIsNotDisplayed(app);

  }

  @When("^AppCenter created application is removed From Favorites$")
  public void checkThatAppcenterCreatedApplicationIsNotDisplayed() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.checkThatAppcenterApplicationIsNotDisplayed(randomApplicationTitle);

  }

  @When("^AppCenter created application is added To Favorites$")
  public void checkThatAppcenterRandomApplicationIsDisplayed() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.checkThatAppcenterApplicationIsDisplayed(randomApplicationTitle);

  }

  @Then("^Application '(.*)' is displayed in Favorites Applications$")
  public void checkThatApplicationIsDisplayedInFavoriteApps(String app) {
    applicationSteps.checkThatApplicationIsDisplayedInFavoriteApps(app);

  }

  @Then("^Application '(.*)' is not displayed in Favorites Applications$")
  public void checkThatApplicationIsNotDisplayedInFavoriteApps(String app) {
    applicationSteps.checkThatApplicationIsNotDisplayedInFavoriteApps(app);

  }

  @Then("The created application is not displayed in Favorites Applications")
  public void checkThatCreatedApplicationIsNotDisplayedInFavoriteApps() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.checkThatApplicationIsNotDisplayedInFavoriteApps(randomApplicationTitle);
  }

  @When("^'(.*)' Application Open Button is displayed$")
  public void checkThatOpenApplicationButtonIsDisplayed(String app) {
    applicationSteps.checkThatOpenApplicationButtonIsDisplayed(app);
  }

  @Then("The created application is displayed in Favorites Applications")
  public void checkThatRandomApplicationIsDisplayedInFavoriteApps() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.checkThatApplicationIsDisplayedInFavoriteApps(randomApplicationTitle);
  }

  @When("The created application Open Button is displayed")
  public void checkThatRandomApplicationOpenButtonIsDisplayed() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.checkThatOpenApplicationButtonIsDisplayed(randomApplicationTitle);

  }

  @When("^I click on '(.*)' Application Open Button$")
  public void clickOnOpenApplicationButton(String app) {
    applicationSteps.clickOnOpenApplicationButton(app);

  }

  @Then("I go To AppCenter Drawer")
  public void clickOnTheAppLauncherIcon() {
    applicationSteps.clickOnTheAppLauncherIcon();
  }

  @Then("^I go to '(.*)' application$")
  public void goToApplication(String application) {
    applicationSteps.goToApplication(application);
  }

  @Then("^The Page '(.*)' is displayed$")
  public void isPageOpened(String uriPart) {
    genericSteps.isPageOpened(uriPart);
  }

  @When("The message 'You can’t set more than 12 favorites' is displayed$")
  public void maxFavoriteAppsIsDisplayed() {
    applicationSteps.maxFavoriteAppsIsDisplayed();
  }

  @When("I see All Applications")
  public void seeAllApplications() {
    applicationSteps.seeAllApplications();

  }

  @Then("Settings Application Page is displayed")
  public void settingsPageIsOpened() {
    applicationSteps.settingsPageIsOpened();
  }

  @Then("The application is not bookmarked as my favorites")
  public void starButtonForCreatedRandomAppIsNotSelected() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.starButtonIsNotSelected(randomApplicationTitle);
  }

  @Then("The application bookmark is disabled")
  public void starButtonIsDisabled() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.starButtonIsDisabled(randomApplicationTitle);
  }

  @Then("^The application '(.*)' is not bookmarked as my favorites$")
  public void starButtonIsNotSelected(String appTitle) {
    applicationSteps.starButtonIsNotSelected(appTitle);
  }

  @Then("The application is bookmarked as my favorites")
  public void starButtonIsSelected() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.starButtonIsSelected(randomApplicationTitle);
  }

  @Then("^The application '(.*)' is bookmarked as my favorites$")
  public void starButtonIsSelected(String appTitle) {
    applicationSteps.starButtonIsSelected(appTitle);
  }

  @Then("^I unbookmark the application '(.*)'$")
  public void unbookmarkApplication(String appTitle) {
    applicationSteps.unbookmarkApplication(appTitle);
  }

  @Then("I unbookmark the random application")
  public void unbookmarkRandomApplication() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    applicationSteps.unbookmarkApplication(randomApplicationTitle);
  }

}
