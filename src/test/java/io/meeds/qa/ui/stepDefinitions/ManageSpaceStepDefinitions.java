package io.meeds.qa.ui.stepDefinitions;

import static net.serenitybdd.core.Serenity.setSessionVariable;

import java.util.Random;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.pages.page.factory.space.ManageSpacesPage;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ManageSpaceStepDefinitions {
  @Steps
  private ManageSpaceSteps manageSpaceSteps;

  private ManageSpacesPage manageSpacesPage;

  String                   spaceTemplate   = System.getProperty("io.meeds.space.template");

  String                   firstSpaceName  = "topbar01" + getRandomString();

  String                   secondSpaceName = "topbar02" + getRandomString();

  String                   thirdSpaceName  = "topbar03" + getRandomString();

  @Steps
  private HomeSteps        homeSteps;

  public static String getRandomNumber() {
    char[] chars = "0123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 6; i++) {
      char c = chars[random.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

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

  @Given("^I create the space$")
  public void addNewSpaceRandom() {
    homeSteps.goToManageSpacesPage();
    String spaceName = "spaceName" + getRandomNumber();
    setSessionVariable("spaceName").to(spaceName);
    manageSpaceSteps.addSimpleSpace(spaceName);
  }

  @Given("^I create the first space$")
  public void addFirstSpaceRandom() {
    homeSteps.goToManageSpacesPage();
    setSessionVariable("spaceName").to(firstSpaceName);
    manageSpaceSteps.addSimpleSpace(firstSpaceName);
  }

  @Given("^The created space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(String members) {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayedByOtherUser(randomSpaceName, members);
  }

  @Given("^First space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatFirstSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(firstSpaceName, members);
  }

  @Given("First space name is not displayed in spaces page search results$")
  public void checkThatFirstSpaceInSearchResultsIsNotDisplayed() {
    manageSpaceSteps.checkThatSpaceInSearchResultsIsNotDisplayed(firstSpaceName);
  }

  @Given("Second space name is not displayed in spaces page search results$")
  public void checkThatSecondSpaceInSearchResultsIsNotDisplayed() {
    manageSpaceSteps.checkThatSpaceInSearchResultsIsNotDisplayed(secondSpaceName);
  }

  @Given("^Second space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatSecondSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(secondSpaceName, members);
  }

  @Given("^Third space details are displayed in spaces page search results with '(.*)'$")
  public void checkThatThirdSpaceDetailsInSearchResultsAreDisplayed(String members) {
    manageSpaceSteps.checkThatSpaceDetailsInSearchResultsAreDisplayed(thirdSpaceName, members);
  }

  @Given("^I create the second space$")
  public void addSecondSpaceRandom() {
    homeSteps.goToManageSpacesPage();
    setSessionVariable("spaceName").to(secondSpaceName);
    manageSpaceSteps.addSimpleSpace(secondSpaceName);
  }

  @Given("^I create the third space$")
  public void addThirdSpaceRandom() {
    homeSteps.goToManageSpacesPage();
    setSessionVariable("spaceName").to(thirdSpaceName);
    manageSpaceSteps.addSimpleSpace(thirdSpaceName);
  }

  @Given("^Space Avatar is displayed$")
  public void spaceAvatarIsDisplayed() {
    manageSpaceSteps.spaceAvatarIsDisplayed();
  }

  @Given("^I go to space Home$")
  public void goToSpaceHomeViaSpaceAvatar() {
    manageSpaceSteps.goToSpaceHomeViaSpaceAvatar();
  }

  @Given("^Space Name is displayed '(.*)'$")
  public void spaceNameIsDisplayed(String space) {
    manageSpaceSteps.spaceNameIsDisplayed(space);
  }

  @Given("^Space Tabs are displayed in order '(.*)'$")
  public void checkThatSpaceTabsAreDisplayedInOrder(String space) {
    manageSpaceSteps.checkThatSpaceTabsAreDisplayedInOrder(space);
  }

  @Given("^First created space Tabs are displayed in order$")
  public void checkThatFirstSpaceTabsAreDisplayedInOrder() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.checkThatSpaceTabsAreDisplayedInOrder(randomSpaceName);
  }

  @Given("^I upload the Space banner '(.*)'$")
  public void uploadSpaceBanner(String fileName) {
    manageSpaceSteps.uploadSpaceBanner(fileName);
  }

  @Given("^Space banner is changed successfully$")
  public void isSpaceBannerUpdated() {
    manageSpaceSteps.isSpaceBannerUpdated();
  }

  @Given("^I create the space '(.*)'$")
  public void addNewSpace(String spaceName) {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSimpleSpace(spaceName);
  }

  @Given("^I add the space '(.*)' with registration '(.*)'$")
  public void addSpaceWithRegistration(String spaceName, String registration) {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithRegistration(spaceName, registration);
  }

  @Given("^I add the space '(.*)' with registration '(.*)' with the fifth user$")
  public void addSpaceWithRegistrationWithInvitedUser(String spaceName, String registration) {
    String fifthUserFirstName = Serenity.sessionVariableCalled("fifthUserFirstName");
    String fifthUserLastName = Serenity.sessionVariableCalled("fifthUserLastName");

    String fullName = fifthUserFirstName + " " + fifthUserLastName;
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithRegistrationWithInvitedUser(spaceName, registration, fullName);
  }

  @Given("^I create the random space$")
  public void addRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    manageSpaceSteps.addSimpleSpace(randomSpaceName);
  }

  @Given("^I add the random space with registration '(.*)' with the fifth user$")
  public void addRandomSpaceWithRegistrationWithInvitedUser(String registration) {
    String fifthUserName = Serenity.sessionVariableCalled("fifthUserName");
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithRegistrationWithInvitedUser(randomSpaceName, registration, fifthUserName);
  }

  @Given("^The created space was deleted successfully$")
  public void deleteRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.deleteSpace(randomSpaceName.toLowerCase());
  }

  @Given("^I add the random space with registration '(.*)'$")
  public void addRandomSpaceWithRegistration(String registration) {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    manageSpaceSteps.addSpaceWithRegistration(randomSpaceName, registration);
  }

  @Given("^I create random space with the first created Admin user$")
  public void addRandomSpaceWithFirstAdminUser() {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    String firstUserFirstName = Serenity.sessionVariableCalled("firstAdminFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstAdminLastName");

    String fullName = firstUserFirstName + " " + firstUserLastName;
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, fullName);
  }

  @When("^I accept the invitation of the random space$")
  public void acceptInvitationRandomSpace() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    homeSteps.acceptRandomSpaceInvitation(randomSpaceName);
  }

  @Given("^I create the second random space$")
  public void addSecondRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String secondRandomSpaceName = "secondRandomSpaceName" + getRandomNumber();
    setSessionVariable("secondRandomSpaceName").to(secondRandomSpaceName);
    manageSpaceSteps.addSimpleSpace(secondRandomSpaceName);
  }

  @Given("^The second created space was deleted successfully$")
  public void deleteSecondRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    manageSpaceSteps.deleteSpace(secondRandomSpaceName.toLowerCase());
  }

  @Given("^I create the third random space$")
  public void addThirdRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String thirdRandomSpaceName = "thirdRandomSpaceName" + getRandomNumber();
    setSessionVariable("thirdRandomSpaceName").to(thirdRandomSpaceName);
    manageSpaceSteps.addSimpleSpace(thirdRandomSpaceName);
  }

  @Given("^I create the fourth random space$")
  public void addFourthRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String fourthRandomSpaceName = "fourthRandomSpaceName" + getRandomNumber();
    setSessionVariable("fourthRandomSpaceName").to(fourthRandomSpaceName);
    manageSpaceSteps.addSimpleSpace(fourthRandomSpaceName);
  }

  @Given("^The third created space was deleted successfully$")
  public void deleteThirdRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");
    manageSpaceSteps.deleteSpace(thirdRandomSpaceName.toLowerCase());
  }

  @Given("^I go to the created space$")
  public void goToRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.goToSpeceficSpace(randomSpaceName);
  }

  @Given("^I go to the second created space$")
  public void goToSecondRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    manageSpaceSteps.goToSpeceficSpace(secondRandomSpaceName);
  }

  @Given("^I go to the third created space$")
  public void goToThirdRandomSpace() {
    homeSteps.goToManageSpacesPage();
    String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");
    manageSpaceSteps.goToSpeceficSpace(thirdRandomSpaceName);
  }

  @Given("^The created space name is displayed$")
  public void randomSpaceNameIsDisplayed() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.spaceNameIsDisplayed(randomSpaceName);
  }

  @Given("^The second created space name is displayed$")
  public void secondRandomSpaceNameIsDisplayed() {
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    manageSpaceSteps.spaceNameIsDisplayed(secondRandomSpaceName);
  }

  @Given("^I go to space '(.*)'$")
  public void goToSpace(String spaceName) {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.goToSpeceficSpace(spaceName);
  }

  @Given("^I go to the created space to accept to join it$")
  public void goToSpaceToAcceptInvitation() {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.goToSpaceToAcceptInvitation(randomSpaceName);
  }

  @Given("^I go to the space '(.*)' to accept to join it$")
  public void goToJoinSpace(String space) {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.goToSpaceToAcceptInvitation(space);
  }

  @Given("^I create space '(.*)' with user '(.*)'$")
  public void addNewSpaceWithUser(String spaceName, String user) {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithInviteUser(spaceName, user);
  }

  @When("^I accept the invitation of the created space$")
  public void acceptRandomSpace() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    homeSteps.acceptRandomSpaceInvitation(randomSpaceName);
  }

  @When("^I accept the invitation of the second created space$")
  public void acceptSecondRandomSpace() {
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    homeSteps.acceptRandomSpaceInvitation(secondRandomSpaceName);
  }

  @When("^I reject the invitation of the second created space$")
  public void rejectSecondRandomSpace() {
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    homeSteps.rejectRandomSpaceInvitation(secondRandomSpaceName);
  }

  @When("The third created space is displayed in Spaces Requests section")
  public void checkThirdRandomDisplaySpaceInvitation() {
    String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");
    homeSteps.checkRandomDisplaySpaceInvitation(thirdRandomSpaceName);
  }

  @When("The second created space is not displayed in Spaces Requests section")
  public void checkSecondRandomNotDisplaySpaceInvitation() {
    String secondRandomSpaceName = Serenity.sessionVariableCalled("secondRandomSpaceName");
    homeSteps.checkRandomNotDisplaySpaceInvitation(secondRandomSpaceName);
  }

  @When("The first created space is not displayed in Spaces Requests section")
  public void checkFirstRandomDisplaySpaceInvitation() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    homeSteps.checkRandomNotDisplaySpaceInvitation(randomSpaceName);
  }

  @When("^I accept the invitation of the third created space$")
  public void acceptThirdRandomSpace() {
    String thirdRandomSpaceName = Serenity.sessionVariableCalled("thirdRandomSpaceName");
    homeSteps.acceptRandomSpaceInvitation(thirdRandomSpaceName);
  }

  @Given("^I create space '(.*)' with second user$")
  public void addNewSpaceWithSecondUser(String spaceName) {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithInviteUser(spaceName, secondUserName);
  }

  @Given("^I create space '(.*)' with first user$")
  public void addNewSpaceWithFirstUser(String spaceName) {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithInviteUser(spaceName, firstUserName);
  }

  @Given("^I create random space with user '(.*)'$")
  public void addRandomSpaceWithUser(String user) {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, user);
  }

  @Given("^I create random space with the first created user$")
  public void addRandomSpaceWithFirstUser() {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String fullName = firstUserFirstName + " " + firstUserLastName;
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, fullName);
  }

  @Given("^I create second random space with the first created user$")
  public void addSecondRandomSpaceWithFirstUser() {
    homeSteps.goToManageSpacesPage();
    String secondRandomSpaceName = "secondRandomSpaceName" + getRandomNumber();
    setSessionVariable("secondRandomSpaceName").to(secondRandomSpaceName);
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    manageSpaceSteps.addSpaceWithInviteUser(secondRandomSpaceName, firstUserName);
  }

  @Given("^I create third random space with the first created user$")
  public void addThirdRandomSpaceWithFirstUser() {
    homeSteps.goToManageSpacesPage();
    String thirdRandomSpaceName = "thirdRandomSpaceName" + getRandomNumber();
    setSessionVariable("thirdRandomSpaceName").to(thirdRandomSpaceName);
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    manageSpaceSteps.addSpaceWithInviteUser(thirdRandomSpaceName, firstUserName);
  }

  @Given("^I create fourth random space with the first created user$")
  public void addFourthRandomSpaceWithFirstUser() {
    homeSteps.goToManageSpacesPage();
    String fourthRandomSpaceName = "fourthRandomSpaceName" + getRandomNumber();
    setSessionVariable("fourthRandomSpaceName").to(fourthRandomSpaceName);
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    manageSpaceSteps.addSpaceWithInviteUser(fourthRandomSpaceName, firstUserName);
  }

  @Given("^I create fifth random space with the first created user$")
  public void addFifthRandomSpaceWithFirstUser() {
    homeSteps.goToManageSpacesPage();
    String fifthRandomSpaceName = "fifthRandomSpaceName" + getRandomNumber();
    setSessionVariable("fifthRandomSpaceName").to(fifthRandomSpaceName);
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    manageSpaceSteps.addSpaceWithInviteUser(fifthRandomSpaceName, firstUserName);
  }

  @Given("^I create random space with the second created user$")
  public void addRandomSpaceWithSecondUser() {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");

    String secondUserFullName = secondUserFirstName + " " + secondUserLastName;
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, secondUserFullName);
  }

  @Given("^I create second random space with the first created space$")
  public void addSecondRandomSpaceWithSecondUser() {
    homeSteps.goToManageSpacesPage();
    String secondRandomSpaceName = "secondRandomSpaceName" + getRandomNumber();
    setSessionVariable("secondRandomSpaceName").to(secondRandomSpaceName);
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    manageSpaceSteps.addSpaceWithInviteUser(secondRandomSpaceName, randomSpaceName);
  }

  @Then("^The space page is displayed '(.*)'$")
  public void isSpacePageOpened(String space) {
    manageSpacesPage.isSpacePageOpened(space);

  }

  @Given("^The space '(.*)' was deleted successfully$")
  public void deleteSpace(String spaceName) {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.deleteSpace(spaceName.toLowerCase());
  }

  @Given("^The First space was deleted successfully$")
  public void deleteFirstSpace() {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.deleteSpace(firstSpaceName.toLowerCase());
  }

  @Given("^The Second space was deleted successfully$")
  public void deleteSecondSpace() {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.deleteSpace(secondSpaceName.toLowerCase());
  }

  @Given("^The Third space was deleted successfully$")
  public void deleteThirdSpace() {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.deleteSpace(thirdSpaceName.toLowerCase());
  }

  @Given("Space Top Bar Elements are displayed")
  public void checkThatSpaceTopBarElementsAreDisplayed() {
    manageSpacesPage.checkThatSpaceTopBarElementsAreDisplayed();
  }

  @Given("^I search the space '(.*)'$")
  public void searchSpace(String spaceName) {
    manageSpaceSteps.searchSpace(spaceName);
  }

  @Given("^I '(.*)'$")
  public void sendRequestToJoin(String action) {
    manageSpaceSteps.clickSpaceAction(action);
  }

  @Given("^I select the filter '(.*)'$")
  public void selectFilter(String filter) {
    manageSpaceSteps.selectFilter(filter);
  }

  @Given("^I create thirty random space$")
  public void addThirtyRandomSpace() {
    for (int i = 0; i < 30; i++) {
      homeSteps.goToManageSpacesPage();
      String randomSpaceName = "randomSpaceName" + getRandomNumber();
      setSessionVariable("randomSpaceName").to(randomSpaceName);
      manageSpaceSteps.addSimpleSpace(randomSpaceName);
    }
  }

  @Given("^I check that only 20 spaces are displayed$")
  public void checkDisplayOfTwentySpaces() {
    manageSpaceSteps.checkDisplayOfTwentySpaces();
  }

  @Given("^I click on Show more button$")
  public void showMoreSpaces() {
    manageSpaceSteps.showMoreSpaces();
  }

  @Given("^I check that other spaces are displayed$")
  public void checkDisplayOfOtherSpaces() {
    manageSpaceSteps.checkDisplayOfOtherSpaces();
  }

  @Given("^I click on space settings tab$")
  public void clickOnSpaceSettingsTab() {
    manageSpaceSteps.clickOnSpaceSettingsTab();
  }

  @Given("^I check that general settings section is displayed with his edit icon$")
  public void checkGeneralSpaceSettings() {
    manageSpaceSteps.checkGeneralSpaceSettings();
  }

  @Given("^I check that Applications section is displayed with his edit icon$")
  public void checkApplicationsSpaceSettings() {
    manageSpaceSteps.checkApplicationsSpaceSettings();
  }

  @Given("^I click on edit general space settings$")
  public void clickOnGeneralSpaceSettings() {
    manageSpaceSteps.clickOnGeneralSpaceSettings();
  }

  @Given("^I check that avatar section is displayed$")
  public void checkAvatarSection() {
    manageSpaceSteps.checkAvatarSection();
  }

  @Given("^I check that space name section is displayed$")
  public void checkNameSpaceSection() {
    manageSpaceSteps.checkNameSpaceSection();
  }

  @Given("^I check that space description section is displayed$")
  public void checkDescriptionSpaceSection() {
    manageSpaceSteps.checkDescriptionSpaceSection();
  }

  @Given("^I check that space template section is displayed$")
  public void checkSpaceTemplateSection() {
    manageSpaceSteps.checkSpaceTemplateSection();
  }

  @Given("^I check that hidden section and switch button are displayed$")
  public void checkHiddenAndSwitchButtonSection() {
    manageSpaceSteps.checkHiddenAndSwitchButtonSection();
  }

  @Given("^I check that registration section is displayed$")
  public void checkRegistrationSection() {
    manageSpaceSteps.checkRegistrationSection();
  }

  @Given("^I check that cancel button is displayed$")
  public void checkCancelButton() {
    manageSpaceSteps.checkCancelButton();
  }

  @Given("^I check that update button is displayed$")
  public void checkUpdateButton() {
    manageSpaceSteps.checkUpdateButton();
  }

  @And("^I create the space with full template '(.*)'$")
  public void addNewSpaceWithTemplate(String spaceName) {
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceWithTemplate(spaceName, spaceTemplate);
  }

  @And("^I create a space with full template$")
  public void addRandomSpaceWithTemplate() {
    homeSteps.goToManageSpacesPage();
    String spaceName = "spaceName" + getRandomNumber();
    setSessionVariable("spaceName").to(spaceName);
    manageSpaceSteps.addSpaceWithTemplate(spaceName, spaceTemplate);
  }

  @Given("^I click on arrow icon of application space settings$")
  public void clickOnArrowIconAppSpaceSettings() {
    manageSpaceSteps.clickOnArrowIconAppSpaceSettings();
  }

  @Given("^Space application settings page is opened$")
  public void spaceAppSettingsIsOpened() {
    manageSpaceSteps.spaceAppSettingsIsOpened();
  }

  @Given("^Application card is displayed$")
  public void appCardIsDisplayed() {
    manageSpaceSteps.appCardIsDisplayed();
  }

  @Given("^Plus button is displayed$")
  public void plusButtonIsDisplayed() {
    manageSpaceSteps.plusButtonIsDisplayed();
  }

  @Given("^I click on 3dot icon of application card$")
  public void clickOn3dotsAppCard() {
    manageSpaceSteps.clickOn3dotsAppCard();
  }

  @Given("^Remove application button is displayed$")
  public void removeAppButtonIsDisplayed() {
    manageSpaceSteps.removeAppButtonIsDisplayed();
  }

  @Given("^Move before application button is displayed$")
  public void moveBeforeAppButtonIsDisplayed() {
    manageSpaceSteps.moveBeforeAppButtonIsDisplayed();
  }

  @Given("^Move after application button is displayed$")
  public void moveAfterAppButtonIsDisplayed() {
    manageSpaceSteps.moveAfterAppButtonIsDisplayed();
  }

  @Given("^I click on plus button to add application$")
  public void clickOnPlusButton() {
    manageSpaceSteps.clickOnPlusButton();
  }

  @Given("^I check that space application installer drawer is displayed$")
  public void checkSpaceAppInstallerDrawerIsDisplayed() {
    manageSpaceSteps.checkSpaceAppInstallerDrawerIsDisplayed();
  }

  @Given("^I check that applications are displayed$")
  public void checkApplicationsAreDisplayed() {
    manageSpaceSteps.checkApplicationsAreDisplayed();
  }

  @Given("^I click to add application '(.*)'$")
  public void clickToAddApp(String application) {
    manageSpaceSteps.clickToAddApp(application);
  }

  @Given("^I check that application '(.*)' is added to applications page$")
  public void checkThatAppIsDisplayed(String application) {
    manageSpaceSteps.checkThatAppIsDisplayed(application);
  }

  @Given("^I go to members tab$")
  public void goToMembersTab() {
    manageSpaceSteps.goToMembersTab();
  }

  @Given("^I go to Tasks in space tab$")
  public void goToTasksTab() {
    manageSpaceSteps.goToTasksTab();
  }

  @Given("^I go to Settings in space tab$")
  public void goToSettingsTab() {
    manageSpaceSteps.goToSettingsTab();
  }

  @Given("^I add '(.*)' to the space$")
  public void addUserToSpace(String user) {
    manageSpaceSteps.addUserToSpace(user);
  }

  @Given("^I add second user to the space$")
  public void addSecondUserToSpace() {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    manageSpaceSteps.addUserToSpace(secondUserName);
  }

  @Given("^I add third user to the space$")
  public void addThirdUserToSpace() {
    String thirdUserName = Serenity.sessionVariableCalled("thirdUserName");
    manageSpaceSteps.addUserToSpace(thirdUserName);
  }

  @And("^I create the space with template and the first created user$")
  public void addSpaceByTemplateWithFirstUser() {
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");
    String firstUserName = firstUserFirstName + " " + firstUserLastName;
    homeSteps.goToManageSpacesPage();
    manageSpaceSteps.addSpaceByTemplateWithFirstUser(randomSpaceName, firstUserName, spaceTemplate);
  }

  @Given("^I add fourth user to the space$")
  public void addFourthUserToSpace() {
    String fourthUserName = Serenity.sessionVariableCalled("fourthUserName");
    manageSpaceSteps.addUserToSpace(fourthUserName);
  }
}
