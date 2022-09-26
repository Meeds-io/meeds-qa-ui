package io.meeds.qa.ui.steps.definition;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.meeds.qa.ui.hook.TestHooks;
import io.meeds.qa.ui.pages.page.factory.space.ManageSpacesPage;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ManageSpaceStepDefinitions {
  @Steps
  private HomeSteps        homeSteps;

  private ManageSpacesPage manageSpacesPage;

  @Steps
  private ManageSpaceSteps manageSpaceSteps;

  @When("I accept the invitation of the random space")
  public void acceptInvitationRandomSpace() {
    String randomSpaceName = sessionVariableCalled("randomSpaceName");
    homeSteps.acceptRandomSpaceInvitation(randomSpaceName);
  }

  @When("^I accept the invitation of the (.*) created space$")
  public void acceptRandomSpace(String spacePrefix) {
    String randomSpaceName = sessionVariableCalled(spacePrefix + "RandomSpaceName");
    homeSteps.acceptRandomSpaceInvitation(randomSpaceName);
  }

  @When("^I accept the invitation of the third created space$")
  public void acceptThirdRandomSpace() {
    String thirdRandomSpaceName = sessionVariableCalled("thirdRandomSpaceName");
    homeSteps.acceptRandomSpaceInvitation(thirdRandomSpaceName);
  }

  @Given("I create a random space")
  public void addARandomSpace() {
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithRegistration(randomSpaceName, "Open");
  }

  @Given("^I create a random space with the (.*) random user$")
  public void addARandomSpaceWithRandomUserInvited(String userPrefix) {
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + "UserFirstName");
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, userFirstName);
    setSessionVariable("randomSpaceName").to(randomSpaceName);
  }

  @Given("^I create a (.*) random space with the (.*) created user as member$")
  public void addARandomSpaceWithRandomUserInvited(String spacePrefix, String userPrefix) {
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    String userFirstName = Serenity.sessionVariableCalled(userPrefix + "UserFirstName");
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, userFirstName);
    setSessionVariable(spacePrefix + "RandomSpaceName").to(randomSpaceName);
  }

  @Given("^Application card is displayed$")
  public void appCardIsDisplayed() {
    manageSpaceSteps.appCardIsDisplayed();
  }

  @Given("^I check that applications are displayed$")
  public void checkApplicationsAreDisplayed() {
    manageSpaceSteps.checkApplicationsAreDisplayed();
  }

  @Given("^I check that Applications section is displayed with his edit icon$")
  public void checkApplicationsSpaceSettings() {
    manageSpaceSteps.checkApplicationsSpaceSettings();
  }

  @Given("^I check that avatar section is displayed$")
  public void checkAvatarSection() {
    manageSpaceSteps.checkAvatarSection();
  }

  @Given("^I check that cancel button is displayed$")
  public void checkCancelButton() {
    manageSpaceSteps.checkCancelButton();
  }

  @Given("^I check that space description section is displayed$")
  public void checkDescriptionSpaceSection() {
    manageSpaceSteps.checkDescriptionSpaceSection();
  }

  @Given("^I check that other spaces are displayed$")
  public void checkDisplayOfOtherSpaces() {
    manageSpaceSteps.checkDisplayOfOtherSpaces();
  }

  @Given("^I check that only 20 spaces are displayed$")
  public void checkDisplayOfTwentySpaces() {
    manageSpaceSteps.checkDisplayOfTwentySpaces();
  }

  @When("The first created space is not displayed in Spaces Requests section")
  public void checkFirstRandomDisplaySpaceInvitation() {
    String randomSpaceName = sessionVariableCalled("randomSpaceName");
    homeSteps.checkRandomNotDisplaySpaceInvitation(randomSpaceName);
  }

  @Given("^I check that general settings section is displayed with his edit icon$")
  public void checkGeneralSpaceSettings() {
    manageSpaceSteps.checkGeneralSpaceSettings();
  }

  @Given("^I check that hidden section and switch button are displayed$")
  public void checkHiddenAndSwitchButtonSection() {
    manageSpaceSteps.checkHiddenAndSwitchButtonSection();
  }

  @Given("^I check that space name section is displayed$")
  public void checkNameSpaceSection() {
    manageSpaceSteps.checkNameSpaceSection();
  }

  @Given("^I check that registration section is displayed$")
  public void checkRegistrationSection() {
    manageSpaceSteps.checkRegistrationSection();
  }

  @When("The second created space is not displayed in Spaces Requests section")
  public void checkSecondRandomNotDisplaySpaceInvitation() {
    String secondRandomSpaceName = sessionVariableCalled("secondRandomSpaceName");
    homeSteps.checkRandomNotDisplaySpaceInvitation(secondRandomSpaceName);
  }

  @Given("^I check that space application installer drawer is displayed$")
  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    manageSpaceSteps.checkSpaceAppInstallerDrawerIsDisplayed();
  }

  @Given("^I check that space template section is displayed$")
  public void checkSpaceTemplateSection() {
    manageSpaceSteps.checkSpaceTemplateSection();
  }

  @Given("^I check that application '(.*)' is added to applications page$")
  public void checkThatAppIsDisplayed(String application) {
    manageSpaceSteps.checkThatAppIsDisplayed(application);
  }

  @Given("^First space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatFirstSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(sessionVariableCalled("spaceName"), members);
  }

  @Given("First space name is not displayed in spaces page search results$")
  public void checkThatFirstSpaceInSearchResultsIsNotDisplayed() {
    manageSpaceSteps.checkThatSpaceInSearchResultsIsNotDisplayed(sessionVariableCalled("spaceName"));
  }

  @Given("^First created space Tabs are displayed in order$")
  public void checkThatFirstSpaceTabsAreDisplayedInOrder() {
    String randomSpaceName = sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.checkThatSpaceTabsAreDisplayedInOrder(randomSpaceName);
  }

  @Given("^Second space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatSecondSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(sessionVariableCalled("secondRandomSpaceName"), members);
  }

  @Given("Second space name is not displayed in spaces page search results$")
  public void checkThatSecondSpaceInSearchResultsIsNotDisplayed() {
    manageSpaceSteps.checkThatSpaceInSearchResultsIsNotDisplayed(sessionVariableCalled("secondRandomSpaceName"));
  }

  @Given("^The created space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(sessionVariableCalled("randomSpaceName"),
                                                                                 members);
  }

  @Given("^Space Tabs are displayed in order '(.*)'$")
  public void checkThatSpaceTabsAreDisplayedInOrder(String space) {
    manageSpaceSteps.checkThatSpaceTabsAreDisplayedInOrder(space);
  }

  @Given("Space Top Bar Elements are displayed")
  public void checkThatSpaceTopBarElementsAreDisplayed() {
    manageSpacesPage.checkThatSpaceTopBarElementsAreDisplayed();
  }

  @Given("^Third space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatThirdSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(sessionVariableCalled("thirdRandomSpaceName"), members);
  }

  @When("The third created space is displayed in Spaces Requests section")
  public void checkThirdRandomDisplaySpaceInvitation() {
    String thirdRandomSpaceName = sessionVariableCalled("thirdRandomSpaceName");
    homeSteps.checkRandomDisplaySpaceInvitation(thirdRandomSpaceName);
  }

  @Given("I create or check that thirty spaces are created")
  public void checkThirtyRandomSpacesArePresent() {
    manageSpaceSteps.checkThirtyRandomSpacesArePresent();
  }

  @Given("^I check that update button is displayed$")
  public void checkUpdateButton() {
    manageSpaceSteps.checkUpdateButton();
  }

  @Given("^I click on three dots icon of '(.*)' application$")
  public void clickOnThreedotsAppCard(String appName) {
    manageSpaceSteps.clickOnThreeDotsAppCard(appName);
  }

  @Given("^I click on arrow icon of application space settings$")
  public void clickOnArrowIconAppSpaceSettings() {
    manageSpaceSteps.clickOnArrowIconAppSpaceSettings();
  }

  @Given("^I click on edit general space settings$")
  public void clickOnGeneralSpaceSettings() {
    manageSpaceSteps.clickOnGeneralSpaceSettings();
  }

  @Given("^I click on plus button to add application$")
  public void clickOnPlusButton() {
    manageSpaceSteps.clickOnPlusButton();
  }

  @Given("^I click to add application '(.*)'$")
  public void clickToAddApp(String application) {
    manageSpaceSteps.clickToAddApp(application);
  }

  @Given("^The First space was deleted successfully$")
  public void deleteFirstSpace() {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.deleteSpace(sessionVariableCalled("spaceName"));
    TestHooks.spaceWithPrefixDeleted("spaceName");
  }

  @Given("^The Second space was deleted successfully$")
  public void deleteSecondSpace() {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.deleteSpace("secondRandomSpaceName");
    TestHooks.spaceWithPrefixDeleted("secondRandomSpaceName");
  }

  @Given("^I go to members tab$")
  public void goToMembersTab() {
    manageSpaceSteps.goToMembersTab();
  }

  @Given("I go to the random space")
  public void goToRandomSpace() {
    manageSpaceSteps.addOrGoToSpace("randomSpaceName");
  }

  @Given("I go to the random space if not existing")
  public void goToRandomSpaceIfNotExisting() {
    if (StringUtils.isBlank(sessionVariableCalled("randomSpaceName"))) {
      manageSpaceSteps.addOrGoToSpace("randomSpaceName");
    }
  }

  @Given("^I go to the (.*) random space$")
  public void goToRandomSpaceWithPrefix(String spacePrefix) {
    manageSpaceSteps.addOrGoToSpace(spacePrefix + "RandomSpaceName");
  }

  @Given("^I go to Settings in space tab$")
  public void goToSettingsTab() {
    manageSpaceSteps.goToSettingsTab();
  }

  @Given("^I go to space Home$")
  public void goToSpaceHomeViaSpaceAvatar() {
    manageSpaceSteps.goToSpaceHomeViaSpaceAvatar();
  }

  @Given("^I go to Tasks in space tab$")
  public void goToTasksTab() {
    manageSpaceSteps.goToTasksTab();
  }

  @Given("^Space banner is changed successfully$")
  public void isSpaceBannerUpdated() {
    manageSpaceSteps.isSpaceBannerUpdated();
  }

  @Then("^The space page is displayed '(.*)'$")
  public void isSpacePageOpened(String space) {
    manageSpacesPage.isSpacePageOpened(space);
  }

  @Given("^Plus button is displayed$")
  public void plusButtonIsDisplayed() {
    manageSpaceSteps.plusButtonIsDisplayed();
  }

  @Given("^The created space name is displayed$")
  public void randomSpaceNameIsDisplayed() {
    String randomSpaceName = sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.spaceNameIsDisplayed(randomSpaceName);
  }

  @When("^I reject the invitation of the (.*) created space$")
  public void rejectRandomSpace(String spacePrefix) {
    String randomSpaceName = sessionVariableCalled(spacePrefix + "RandomSpaceName");
    homeSteps.rejectRandomSpaceInvitation(randomSpaceName);
  }

  @Given("^'(.*)' option of the application '(.*)' is displayed$")
  public void checkOptionFromApplicationMenuIsDisplayed(String option , String appName) {
    manageSpaceSteps.checkOptionFromApplicationMenuIsDisplayed(appName, option);
  }

  @Given("^I search the space '(.*)'$")
  public void searchSpace(String spaceName) {
    manageSpaceSteps.searchSpace(spaceName);
  }

  @Given("^The second created space name is displayed$")
  public void secondRandomSpaceNameIsDisplayed() {
    String secondRandomSpaceName = sessionVariableCalled("secondRandomSpaceName");
    manageSpaceSteps.spaceNameIsDisplayed(secondRandomSpaceName);
  }

  @Given("^I select the filter '(.*)'$")
  public void selectFilter(String filter) {
    manageSpaceSteps.selectFilter(filter);
  }

  @Given("^I '(.*)'$")
  public void sendRequestToJoin(String action) {
    manageSpaceSteps.clickSpaceAction(action);
  }

  @Given("^I click on Show more button$")
  public void showMoreSpaces() {
    manageSpaceSteps.showMoreSpaces();
  }

  @Given("^Space application settings page is opened$")
  public void spaceAppSettingsIsOpened() {
    manageSpaceSteps.spaceAppSettingsIsOpened();
  }

  @Given("^Space Avatar is displayed$")
  public void spaceAvatarIsDisplayed() {
    manageSpaceSteps.spaceAvatarIsDisplayed();
  }

  @Given("^Space Name is displayed '(.*)'$")
  public void spaceNameIsDisplayed(String space) {
    manageSpaceSteps.spaceNameIsDisplayed(space);
  }

  @Given("^I upload the Space banner '(.*)'$")
  public void uploadSpaceBanner(String fileName) {
    manageSpaceSteps.uploadSpaceBanner(fileName);
  }

  @And("^I confirm to remove the application$")
  public void confirmRemoveApplication() {
    manageSpaceSteps.confirmRemoveApplication();
  }

  @And("^I click on '(.*)' option from application '(.*)' menu$")
  public void removeApplication(String option, String appName) {
    manageSpaceSteps.clickOptionApplicationCard(appName, option);
  }

  @When("^I search for the random space$")
  public void setInSearchRandomSpaceField() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.searchSpace(randomSpaceName);
  }

  @Then("The favorite icon should be displayed in space card")
  public void checkFavIconInSpaceCard() {
    manageSpaceSteps.checkFavIconInSpaceCard();
  }

  @Then("I bookmark the random space as favorite from space card")
  @When("I unfavorite the random space from space card")
  public void clickOnSpaceBookmarkIconFromSpaceCard() {
    manageSpaceSteps.clickOnSpaceBookmarkIconFromSpaceCard();
  }

  @When("I check that the random space is bookmarked as favorite from space card")
  public void checkSpaceBookmarkedFromSpaceCard() {
    manageSpaceSteps.checkSpaceBookmarkedFromSpaceCard();
  }

  @When("I check that the random space is unbookmarked from space card")
  public void checkSpaceUnBookmarkFromSpaceCard() {
    manageSpaceSteps.checkSpaceUnBookmarkFromSpaceCard();
  }

}

