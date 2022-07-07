package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.fr.Et;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import pages.page.factory.space.ManageSpacesPage;
import steps.HomeSteps;
import steps.ManageUnifiedSearchSteps;

public class ManageUnifiedSearchStepDefinitions {
    @Steps
    private ManageUnifiedSearchSteps manageUnifiedSearchSteps;

    private ManageSpacesPage manageSpacesPage;

    @Steps
    private HomeSteps homeSteps;

    @When("^I start the search for the user created by the name '(.*)'$")
    @Et("^I launch the search for the space created '(.*)'$")
    @Then("^I start the search for '(.*)'$")
    public void search(String element) {
        manageUnifiedSearchSteps.search(element);
    }

    @And("^I launch the search for the first random created space$")
    @Then("^I start the search for the first random created space$")
    public void searchForFirstRandomCreatedSpace() {
        String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
        manageUnifiedSearchSteps.search(randomSpaceName);
    }

    @Then("^The user's full name is displayed in the search '(.*)'$")
    public void isSearchedUserNameVisible(String fullname) {
        manageUnifiedSearchSteps.isSearchedUserNameVisible(fullname);
    }

    @Then("^The full name of the application is displayed in the search '(.*)'$")
    public void isSearchedApplicationNameVisible(String appName) {
        manageUnifiedSearchSteps.isSearchedApplicationNameVisible(appName);
    }

    @Then("^The full name of the space is displayed in the search '(.*)'$")
    public void isSearchedSpaceNameVisible(String space) {
        manageUnifiedSearchSteps.isSearchedSpaceNameVisible(space);
    }

    @Then("^The full name of the first created space is displayed in the search$")
    public void isSearchedFirsRandomSpaceNameVisible() {
        String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
        manageUnifiedSearchSteps.isSearchedSpaceNameVisible(randomSpaceName);
    }

    @Then("^The attached image is displayed in the search '(.*)'$")
    public void isImageDisplayedInSearch(String imageName) {
        manageUnifiedSearchSteps.isImageDisplayedInSearch(imageName);
    }

    @Then("^The user's full name is displayed in the search with last name Smith$")
    public void isSearchedRandomUserNameVisibleWithSameLastName() {
        String randomUserFirstName = Serenity.sessionVariableCalled("randomUserFirstName");
        String randomUserLastName = Serenity.sessionVariableCalled("randomUserLastName");

        String fullName = randomUserFirstName + " " + randomUserLastName;
        manageUnifiedSearchSteps.isSearchedUserNameVisible(fullName);
    }

    @Then("^The description of the application is displayed in the search '(.*)'$")
    public void isSearchedApplicationDescriptionVisible(String appDesc) {
        manageUnifiedSearchSteps.isSearchedApplicationDescriptionVisible(appDesc);
    }

    @Then("^The app logo is displayed in the search$")
    public void isSearchedApplicationPictureVisible() {
        manageUnifiedSearchSteps.isSearchedApplicationPictureVisible();
    }

    @When("^I click on the space '(.*)'$")
    public void goToTheSearchedSpace(String space) {
        manageUnifiedSearchSteps.goToTheSearchedSpace(space);
    }

    @When("^I click on the first created space$")
    public void goToTheFirsRandomSearchedSpace() {
        String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
        manageUnifiedSearchSteps.goToTheSearchedSpace(randomSpaceName);
    }

    @When("^I click on the application '(.*)'$")
    public void goToTheSearchedApplication(String appName) {
        manageUnifiedSearchSteps.goToTheSearchedApplication(appName);
    }

    @Then("^I click on the searched image '(.*)'$")
    public void goToTheSearchedImage(String image) {
        manageUnifiedSearchSteps.goToTheSearchedImage(image);
    }

    @When("^I click on the activity '(.*)'$")
    public void goToTheSearchedActivity(String activity) {
        manageUnifiedSearchSteps.goToTheSearchedActivity();
    }

    @Then("^The task is displayed in the search '(.*)'$")
    @When("^The activity is displayed in the search '(.*)'$")
    public void isSearchedActivityTitleVisible(String activity) {
        manageUnifiedSearchSteps.isSearchedActivityTitleVisible(activity);
    }

    @And("I access to the unified search page")
    public void accessUnifiedSearchPage() {
        manageUnifiedSearchSteps.accessUnifiedSearchPage();
    }

    @When("^I click on the favorite button$")
    public void clickFavoriteBtn() {
        manageUnifiedSearchSteps.clickFavoriteBtn();
    }

    @When("^The activity is not displayed in the search '(.*)'$")
    public void isSearchedActivityTitleNotVisible(String activity) {
        manageUnifiedSearchSteps.isSearchedActivityTitleNotVisible(activity);
    }

    @When("I favorite the activity '(.*)' from the search page")
    public void favoriteSearchedActivity(String activity) {
        manageUnifiedSearchSteps.favoriteSearchedActivity(activity);
    }

    @And("^I select an object from the drop-down menu '(.*)'")
    public void selectDropDown(String object) {
        manageUnifiedSearchSteps.selectDropDown(object);
    }

}
