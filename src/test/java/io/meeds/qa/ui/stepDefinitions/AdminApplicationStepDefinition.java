package io.meeds.qa.ui.stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.AdminApplicationSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AdminApplicationStepDefinition {
  @Steps
  private AdminApplicationSteps adminApplicationSteps;

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

  @When("^I open '(.*)' edit drawer$")
  public void openEditApplicationDrawer(String applicationName) {
    adminApplicationSteps.goToEditTheApplication(applicationName);
  }

  @When("^I open the added application edit drawer$")
  public void openEditRandomApplicationDrawer() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    adminApplicationSteps.goToEditTheApplication(randomApplicationTitle);
  }

  @When("^I open the second added application edit drawer$")
  public void openEditSecondRandomApplicationDrawer() {
    String secondRandomApplicationTitle = Serenity.sessionVariableCalled("secondRandomApplicationTitle");
    adminApplicationSteps.goToEditTheApplication(secondRandomApplicationTitle);
  }

  @When("^I remove the uploaded image from application drawer$")
  public void removeFileFromApplicationDrawer() {
    adminApplicationSteps.removeFileFromApplicationDrawer();
  }

  @When("^I click on Save in application drawer$")
  public void clickSaveApplicationDrawer() {
    adminApplicationSteps.clickSaveApplicationDrawer();
  }

  @Then("^Application image title '(.*)' is displayed in the drawer$")
  public void checkThatApplicationImageIsDisplayedInDrawer(String image) {
    adminApplicationSteps.checkThatApplicationImageIsDisplayedInDrawer(image);
  }

  @Then("^Application image title '(.*)' is not displayed in the drawer$")
  public void checkThatApplicationImageIsNotDisplayedInDrawer(String image) {
    adminApplicationSteps.checkThatApplicationImageIsNotDisplayedInDrawer(image);
  }

  @Then("^Application Title '(.*)' is displayed in Applications Table$")
  public void appTitleInApplicationsTableIsDisplayed(String appTitle) {
    adminApplicationSteps.appTitleInApplicationsTableIsDisplayed(appTitle);
  }

  @Then("Second application Title is displayed in Applications Table")
  public void secondAppTitleInApplicationsTableIsDisplayed() {
    String secondRandomApplicationTitle = Serenity.sessionVariableCalled("secondRandomApplicationTitle");
    adminApplicationSteps.appTitleInApplicationsTableIsDisplayed(secondRandomApplicationTitle);
  }

  @Then("Second application Url is displayed in Applications Table")
  public void secondAppUrlInApplicationsTableIsDisplayed() {
    String secondRandomApplicationUrl = Serenity.sessionVariableCalled("secondRandomApplicationUrl");
    adminApplicationSteps.appUrlInApplicationsTableIsDisplayed(secondRandomApplicationUrl);
  }

  @Then("Second application Description is displayed in Applications Table")
  public void secondAppDescriptionInApplicationsTableIsDisplayed() {
    String secondRandomApplicationDescription = Serenity.sessionVariableCalled("secondRandomApplicationDescription");
    adminApplicationSteps.appDescriptionInApplicationsTableIsDisplayed(secondRandomApplicationDescription);
  }

  @Then("First application Title is displayed in Applications Table")
  public void firstAppTitleInApplicationsTableIsDisplayed() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    adminApplicationSteps.appTitleInApplicationsTableIsDisplayed(randomApplicationTitle);
  }

  @Then("First application edited Title is displayed in Applications Table")
  public void firstAppEditedTitleInApplicationsTableIsDisplayed() {
    String editedRandomApplicationTitle = Serenity.sessionVariableCalled("editedRandomApplicationTitle");
    adminApplicationSteps.appTitleInApplicationsTableIsDisplayed(editedRandomApplicationTitle);
  }

  @Then("First application Url is displayed in Applications Table")
  public void firstAppUrlInApplicationsTableIsDisplayed() {
    String randomApplicationUrl = Serenity.sessionVariableCalled("randomApplicationUrl");
    adminApplicationSteps.appUrlInApplicationsTableIsDisplayed(randomApplicationUrl);
  }

  @Then("First application edited Url is displayed in Applications Table")
  public void firstAppEditedUrlInApplicationsTableIsDisplayed() {
    String editedRandomApplicationUrl = Serenity.sessionVariableCalled("editedRandomApplicationUrl");
    adminApplicationSteps.appUrlInApplicationsTableIsDisplayed(editedRandomApplicationUrl);
  }

  @Then("First application Description is displayed in Applications Table")
  public void firstAppDescriptionInApplicationsTableIsDisplayed() {
    String randomApplicationDescription = Serenity.sessionVariableCalled("randomApplicationDescription");
    adminApplicationSteps.appDescriptionInApplicationsTableIsDisplayed(randomApplicationDescription);
  }

  @Then("First application edited Description is displayed in Applications Table")
  public void firstAppEditedDescriptionInApplicationsTableIsDisplayed() {
    String editedRandomApplicationDescription = Serenity.sessionVariableCalled("editedRandomApplicationDescription");
    adminApplicationSteps.appDescriptionInApplicationsTableIsDisplayed(editedRandomApplicationDescription);
  }

  @Then("^The image of the application '(.*)' is not displayed in Applications Table$")
  public void checkThatApplicationImageIsNotDisplayedInApplicationsTable(String appTitle) {
    adminApplicationSteps.checkThatApplicationImageIsNotDisplayedInApplicationsTable(appTitle);
  }

  @Then("^Application '(.*)' with permission '(.*)' is displayed in Applications Table$")
  public void appPermissionInApplicationsTableIsDisplayed(String appTitle, String permission) {
    adminApplicationSteps.appPermissionInApplicationsTableIsDisplayed(appTitle, permission);
  }

  @Then("^The added application with permission '(.*)' is displayed in Applications Table$")
  public void randomAppPermissionInApplicationsTableIsDisplayed(String permission) {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    adminApplicationSteps.appPermissionInApplicationsTableIsDisplayed(randomApplicationTitle, permission);
  }

  @Then("^Application Url '(.*)' is displayed in Applications Table$")
  public void appUrlInApplicationsTableIsDisplayed(String appUrl) {
    adminApplicationSteps.appUrlInApplicationsTableIsDisplayed(appUrl);
  }

  @Then("^Application Description '(.*)' is displayed in Applications Table$")
  public void appDescriptionInApplicationsTableIsDisplayed(String appDescription) {
    adminApplicationSteps.appDescriptionInApplicationsTableIsDisplayed(appDescription);
  }

  @When("^I add a new application with the following data$")
  public void addNewApp(Map<String, String> appData) {
    adminApplicationSteps.enterApplicationValues(appData);
    setCurrentlyTestingApplicationTitle(appData.get("title"));
  }

  @When("^I add a new application with the random following data$")
  public void addNewRandomApp() {
    String randomApplicationTitle = "title" + getRandomString();
    String randomApplicationUrl = "./" + getRandomString();

    Serenity.setSessionVariable("randomApplicationTitle").to(randomApplicationTitle);
    Serenity.setSessionVariable("randomApplicationUrl").to(randomApplicationUrl);
    setCurrentlyTestingApplicationTitle(randomApplicationTitle);

    adminApplicationSteps.enterRandomApplicationTitleAndUrl(randomApplicationTitle, randomApplicationUrl);
  }

  @When("^I add a new application with the title, the url and the description$")
  public void addNewAppWithDescription(Map<String, String> appData) {
    adminApplicationSteps.enterApplicationTitleUrlDescription(appData);
    setCurrentlyTestingApplicationTitle(appData.get("title"));
  }

  @When("^I add a new application with the title, the url and the description with image '(.*)'$")
  public void enterApplicationTitleUrlDescriptionWithImage(String image, Map<String, String> applicationData) {
    adminApplicationSteps.enterApplicationTitleUrlDescriptionWithImage(image, applicationData);
    setCurrentlyTestingApplicationTitle(applicationData.get("title"));
  }

  @When("^I add a new random application with the title, the url and the description with image '(.*)'$")
  public void enterRandomApplicationTitleUrlDescriptionWithImage(String image) {
    String randomApplicationTitle = "title" + getRandomString();
    String randomApplicationUrl = "./" + getRandomString();
    String randomApplicationDescription = "desc" + getRandomString();

    Serenity.setSessionVariable("randomApplicationTitle").to(randomApplicationTitle);
    Serenity.setSessionVariable("randomApplicationUrl").to(randomApplicationUrl);
    Serenity.setSessionVariable("randomApplicationDescription").to(randomApplicationDescription);
    setCurrentlyTestingApplicationTitle(randomApplicationTitle);

    adminApplicationSteps.enterRandomApplicationTitleUrlDescriptionImage(randomApplicationTitle,
                                                                         randomApplicationUrl,
                                                                         randomApplicationDescription,
                                                                         image);

  }

  @When("^I add a new random application with the title, the url and the description$")
  public void enterRandomApplicationTitleUrlDescription() {
    String randomApplicationTitle = "title" + getRandomString();
    String randomApplicationUrl = "./" + getRandomString();
    String randomApplicationDescription = "desc" + getRandomString();

    Serenity.setSessionVariable("randomApplicationTitle").to(randomApplicationTitle);
    Serenity.setSessionVariable("randomApplicationUrl").to(randomApplicationUrl);
    Serenity.setSessionVariable("randomApplicationDescription").to(randomApplicationDescription);
    setCurrentlyTestingApplicationTitle(randomApplicationTitle);

    adminApplicationSteps.enterRandomApplicationTitleUrlDescription(randomApplicationTitle,
                                                                    randomApplicationUrl,
                                                                    randomApplicationDescription);

  }

  @When("^I add a second random application with the title, the url and the description with image '(.*)'$")
  public void enterSecondRandomApplicationTitleUrlDescriptionWithImage(String image) {
    String secondRandomApplicationTitle = "title" + getRandomString();
    String secondRandomApplicationUrl = "./" + getRandomString();
    String secondRandomApplicationDescription = "desc" + getRandomString();

    Serenity.setSessionVariable("secondRandomApplicationTitle").to(secondRandomApplicationTitle);
    Serenity.setSessionVariable("secondRandomApplicationUrl").to(secondRandomApplicationUrl);
    Serenity.setSessionVariable("secondRandomApplicationDescription").to(secondRandomApplicationDescription);
    setCurrentlyTestingApplicationTitle(secondRandomApplicationTitle);

    adminApplicationSteps.enterRandomApplicationTitleUrlDescriptionImage(secondRandomApplicationTitle,
                                                                         secondRandomApplicationUrl,
                                                                         secondRandomApplicationDescription,
                                                                         image);

  }

  @When("^I edit the application '*' data$")
  public void editApplicationTitleUrlDescription(String appName, Map<String, String> appData) {
    adminApplicationSteps.editApplicationTitleUrlDescription(appName, appData);
  }

  @When("^I edit the first added application data$")
  public void editRandomApplicationTitleUrlDescription() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    String editedRandomApplicationTitle = "title" + getRandomString();
    String editedRandomApplicationUrl = "./" + getRandomString();
    String editedRandomApplicationDescription = "desc" + getRandomString();

    Serenity.setSessionVariable("editedRandomApplicationTitle").to(editedRandomApplicationTitle);
    Serenity.setSessionVariable("editedRandomApplicationUrl").to(editedRandomApplicationUrl);
    Serenity.setSessionVariable("editedRandomApplicationDescription").to(editedRandomApplicationDescription);

    adminApplicationSteps.editRandomApplicationTitleUrlDescription(randomApplicationTitle,
                                                                   editedRandomApplicationTitle,
                                                                   editedRandomApplicationUrl,
                                                                   editedRandomApplicationDescription);
  }

  @When("^I disable Mandatory '*' for application$")
  @Then("I enable Mandatory '*' for application")
  public void enableDisableMandatoryApplication(String appTitle) throws InterruptedException {
    adminApplicationSteps.enableDisableMandatoryApplication(appTitle);
  }

  @When("^I disable Active option for application '*'$")
  @Then("I enable Active option for application '*'")
  public void enableDisableActiveApplication(String appTitle) {
    adminApplicationSteps.enableDisableActiveApplication(appTitle);
  }

  @When("^I disable Active option for the created application$")
  @Then("I enable Active option for the created application")
  public void enableDisableActiveRandomApplication() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    adminApplicationSteps.enableDisableActiveApplication(randomApplicationTitle);
  }

  @When("^I disable Mandatory for the created application$")
  @Then("I enable Mandatory for the created application")
  public void enableDisableMandatoryRandomApplication() throws InterruptedException {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    adminApplicationSteps.enableDisableMandatoryApplication(randomApplicationTitle);
  }

  @When("^I search for application '*'$")
  public void searchApp(String appTitle) {
    adminApplicationSteps.searchApp(appTitle);
  }

  @When("^I click on '*' active button$")
  public void clickActiveApp(String appName) {
    adminApplicationSteps.clickActiveApp(appName);
  }

  @When("^I click on the added application active button$")
  public void clickRandomActiveApp() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    adminApplicationSteps.clickActiveApp(randomApplicationTitle);
  }

  @When("^I delete the application '*'$")
  public void deleteApp(String appName) {
    adminApplicationSteps.deleteApp(appName, true);
  }

  @When("^I delete the created application$")
  public void deleteRandomApp() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    adminApplicationSteps.deleteApp(randomApplicationTitle, true);
  }

  @When("^I click on delete icon of the application '(.*)'$")
  public void clickDelete(String appName) {
    adminApplicationSteps.deleteApp(appName, false);
  }

  @When("^I click on delete icon of the created application$")
  public void clickDeleteRandomApplication() {
    String randomApplicationTitle = Serenity.sessionVariableCalled("randomApplicationTitle");
    adminApplicationSteps.deleteApp(randomApplicationTitle, false);
  }

  @When("^I click on cancel delete application$")
  public void clickCancelDelete() {
    adminApplicationSteps.clickCancelDelete();
  }

  @When("^I click on close popup delete application$")
  public void clickCloseDeletePopup() {
    adminApplicationSteps.clickCloseDeletePopup();
  }

  @Then("Delete popup is displayed")
  public void checkPopupDeleteVisible() {
    assertThat(adminApplicationSteps.isPopupConfirmDeleteDisplayed()).as("Delete popup is not displayed").isTrue();
  }

  @Then("Delete popup is not displayed")
  public void checkPopupDeleteNotVisible() {
    assertThat(adminApplicationSteps.isPopupConfirmDeleteNotDisplayed()).as("Delete popup still displayed")
                                                                        .isTrue();
  }

  @When("Edit application title is displayed '*' in drawer")
  public void applicationDrawerTitleIsDisplayed(String title) {

    adminApplicationSteps.applicationDrawerTitleIsDisplayed(title);
  }

  @When("Edit application url is displayed '*' in drawer")
  public void applicationDrawerUrlIsDisplayed(String url) {
    adminApplicationSteps.applicationDrawerUrlIsDisplayed(url);
  }

  @When("Edit application mandatory active and mobile are displayed in drawer")
  public void applicationDrawerEnabledButtonsAreIsDisplayed() {
    adminApplicationSteps.applicationDrawerEnabledButtonsAreIsDisplayed();

  }

  @When("Edit application permissions '*' and '*' are displayed in drawer")
  public void applicationDrawerPermissionsIsDisplayed(String firstPermission, String secondPermission) {
    adminApplicationSteps.applicationDrawerPermissionsIsDisplayed(firstPermission, secondPermission);
  }

  @When("Edit application image is displayed '*' in drawer")
  public void applicationDrawerImageIsDisplayed(String image) {
    adminApplicationSteps.applicationDrawerImageIsDisplayed(image);
  }

  private void setCurrentlyTestingApplicationTitle(String applicationTitle) {
    if (Serenity.hasASessionVariableCalled("appCenterAppName")) {
      List<String> appNames = Serenity.sessionVariableCalled("appCenterAppName");
      appNames.add(applicationTitle);
    } else {
      List<String> appNames = new ArrayList<>();
      appNames.add(applicationTitle);
      Serenity.setSessionVariable("appCenterAppName").to(appNames);
    }
  }

}
