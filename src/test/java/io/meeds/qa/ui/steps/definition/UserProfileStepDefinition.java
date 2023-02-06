package io.meeds.qa.ui.steps.definition;

import static io.meeds.qa.ui.utils.Utils.getRandomString;
import static io.meeds.qa.ui.utils.Utils.getTheRandomNumber;
import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.UserProfileSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UserProfileStepDefinition {

  @Steps
  private UserProfileSteps userProfileSteps;

  @And("^I add my profile work experiences$")
  public void addWorkExperiences(Map<String, String> workExperiences) {
    userProfileSteps.addWorkExperiences(workExperiences);
  }

  @Then("The achievements drawer is displayed")
  public void checkAchievementsDrawer() {
    userProfileSteps.checkAchievementsDrawer();
  }

  @Then("^The following items are displayed$")
  public void checkListOfItem(List<String> listOfItems) {
    assertThat(userProfileSteps.checkListOfFields(listOfItems)).as(String.format("The item %s is not diplayed",
                                                                                 userProfileSteps.checkListOfFields(listOfItems)))
                                                               .isEmpty();
  }

  @Then("My points augmented")
  public void checkMyPointIncrease() {
    int myPointBeforeKudos = Serenity.sessionVariableCalled("myPointBeforeKudos");
    assertThat(userProfileSteps.wasMyPointIncreased(myPointBeforeKudos)).as("The points did not increase. Old Value = "
        + myPointBeforeKudos)
                                                                        .isTrue();
  }

  @Then("The weekly point chart is displayed")
  public void checkWeeklyPointChart() {
    userProfileSteps.checkWeeklyPointChart();
  }

  @Given("^Job title '(.*)' and Organization '(.*)' and Job details '(.*)' and Used skills '(.*)' are displayed in Work experiences section$")
  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    userProfileSteps.checkWorkExperiencesSection(jobTitle, organization, jobDetails, usedSkills);
  }

  @Then("^I confirm connection$")
  public void clickConfirmConnect() {
    userProfileSteps.clickConfirmConnect();
  }

  @When("^I check my points$")
  public void getMyWeeklyPoint() {
    int myPointBeforeKudos = userProfileSteps.getMyWeeklyPoint();
    Serenity.setSessionVariable("myPointBeforeKudos").to(myPointBeforeKudos);
  }

  @Then("I go to Received Kudos")
  public void goToReceivedKudos() {
    userProfileSteps.goToReceivedKudos();
  }

  @Then("I go to Sent Kudos")
  public void goToSentKudos() {
    userProfileSteps.goToSentKudos();
  }

  @When("^How to earn points page is displayed$")
  public void howToEarnPointsPageIsDisplayed() {
    userProfileSteps.howToEarnPointsPageIsDisplayed();
  }

  @Then("^User Avatar is displayed in Profile Page$")
  public void isAvatarVisible() {
    userProfileSteps.isAvatarVisible();
  }

  @Then("^User Cover is displayed in Profile Page$")
  public void isCoverVisible() {
    userProfileSteps.isCoverVisible();
  }

  @Then("Gained Cauris Section is displayed")
  public void isGainedCaurisVisible() {
    userProfileSteps.isGainedCaurisVisible();
  }

  @Then("Profile avatar is uploaded")
  public void isProfileAvatarUploaded() {
    userProfileSteps.isProfileAvatarUploaded();
  }

  @Then("^Profile Contact Company '(.*)' is displayed$")
  public void isProfileContactCompanyVisible(String company) {
    userProfileSteps.isProfileContactCompanyVisible(company);
  }

  @Then("^Profile Contact Email '(.*)' is displayed$")
  public void isProfileContactEmailVisible(String mail) {
    userProfileSteps.isProfileContactEmailVisible(mail);
  }

  @Then("^Profile Contact Fullname '(.*)' is displayed in '(.*)'$")
  public void isProfileContactFullNameVisible(String title, String fullName) {
    userProfileSteps.isProfileContactFullNameVisible(title, fullName);
  }

  @Then("^Profile Contact instantMessaging '(.*)' is displayed$")
  public void isProfileContactInstantMessagingVisible(String instantMessaging) {
    userProfileSteps.isProfileContactInstantMessagingVisible(instantMessaging);
  }

  @Then("^Profile Contact Phone '(.*)' is displayed$")
  public void isProfileContactPhoneVisible(String phone) {
    refreshPage();
    userProfileSteps.isProfileContactPhoneVisible(phone);
  }

  @Then("^Updated Profile Contact Company is displayed$")
  public void isProfileContactRandomCompanyVisible() {
    String company = Serenity.sessionVariableCalled("company");
    userProfileSteps.isProfileContactCompanyVisible(company);
  }

  @Then("^Updated Profile Contact Email is displayed$")
  public void isProfileContactRandomEmailVisible() {
    String profileMail = Serenity.sessionVariableCalled("profileMail");
    userProfileSteps.isProfileContactEmailVisible(profileMail);
  }

  @Then("^In '(.*)', Updated profile Contact Fullname is displayed$")
  public void isProfileContactRandomFullNameVisible(String title) {
    String profileFirstName = Serenity.sessionVariableCalled("profileFirstName");
    String profileLastName = Serenity.sessionVariableCalled("profileLastName");

    String fullName = profileFirstName + " " + profileLastName;
    userProfileSteps.isProfileContactFullNameVisible(title, fullName);
  }

  @Then("^Updated Profile Contact instantMessaging is displayed$")
  public void isProfileContactRandomInstantMessagingVisible() {
    String instantMessagingType = "Skype";
    String instantMessaging = Serenity.sessionVariableCalled("instantMessaging");
    String instantMessagingInformation = instantMessagingType + ": " + instantMessaging;
    userProfileSteps.isProfileContactInstantMessagingVisible(instantMessagingInformation);
  }

  @Then("^Updated Profile Contact Job is displayed$")
  public void isProfileContactRandomJobVisible() {
    String profileJob = Serenity.sessionVariableCalled("profileJob");
    userProfileSteps.isUserJobVisible(profileJob);
  }

  @Then("^Updated Profile Contact Phone is displayed$")
  public void isProfileContactRandomPhoneVisible() {
    String phoneType = "Work";
    String phone = Serenity.sessionVariableCalled("phone");
    String phoneInformation = phoneType + ": " + phone;
    refreshPage();
    userProfileSteps.isProfileContactPhoneVisible(phoneInformation);
  }

  @Then("^Updated Profile Contact Url is displayed$")
  public void isProfileContactRandomUrlVisible() {
    userProfileSteps.isProfileContactUrlVisible("meeds.io");
  }

  @Then("Received Kudos Section is displayed")
  public void isReceivedKudosVisible() {
    userProfileSteps.isReceivedKudosVisible();
  }

  @Then("Sent Kudos Section is displayed")
  public void isSentKudosVisible() {
    userProfileSteps.isSentKudosVisible();
  }

  @Then("I open achievement tab")
  public void openAchivementTab() {
    userProfileSteps.openAchivementTab();
  }

  @Then("I open badge details")
  public void openBadgeDetails() {
    userProfileSteps.openBadgeDetails();
  }

  @Then("^I open How To Earn Point Page$")
  public void openHowToEarnPointPage() {
    userProfileSteps.openHowToEarnPointPage();
  }

  @Then("^I open Weekly Points Chart$")
  public void openWeeklyPointsChart() {
    userProfileSteps.openWeeklyPointsChart();
  }

  @Then("The profile page is displayed")
  public void profilePageIsDisplayed() {
    userProfileSteps.profilePageIsDisplayed();
  }

  @Then("^Received kudos by (.*) user is displayed$")
  public void receivedKudosByRandomUserSectionIsDisplayed(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    userProfileSteps.receivedKudosUsersSectionIsDisplayed(userLastName);
  }

  @Then("^'(.*)' kudos are received$")
  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    userProfileSteps.receivedKudosSectionIsDisplayed(kudosNumber);
  }

  @Given("^I remove my profile work experiences '(.*)'$")
  public void removeWorkExperience(String jobTitle) {
    userProfileSteps.removeWorkExperience(jobTitle);
  }

  @When("^I send kudos with message '(.*)'$")
  public void sendKudos(String kudosMessage) {
    userProfileSteps.sendKudos(kudosMessage);
  }

  @Then("^'(.*)' kudos are sent$")
  public void sentKudosSectionIsDisplayed(String kudosNumber) {
    userProfileSteps.sentKudosSectionIsDisplayed(kudosNumber);
  }

  @Then("^Sent kudos by user '(.*)' is displayed$")
  public void sentKudosUsersSectionIsDisplayed(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    userProfileSteps.sentKudosUsersSectionIsDisplayed(userLastName);
  }

  @Given("^I update my profile basic informations$")
  public void updateBasicInformation(Map<String, String> basicInformations) {
    userProfileSteps.updateBasicInformation(basicInformations);
  }

  @Given("^I update my profile other informations$")
  public void updateContactOtherInformations(Map<String, String> basicInformations) {
    userProfileSteps.updateContactOtherInformations(basicInformations);
  }

  @Given("^I update my profile other random informations$")
  public void updateContactOtherRandomInformations() {
    Map<String, String> basicInformations = new HashMap<>();
    String company = getRandomString();
    String phoneType = "WORK";
    String phone = getTheRandomNumber();
    String instantMessagingType = "SKYPE";
    String instantMessaging = getRandomString() + "." + getRandomString();

    basicInformations.put("company", company);
    basicInformations.put("phoneType", phoneType);
    basicInformations.put("phone", phone);
    basicInformations.put("instantMessagingType", instantMessagingType);
    basicInformations.put("instantMessaging", instantMessaging);
    basicInformations.put("url", "https://meeds.io/");

    Serenity.setSessionVariable("company").to(company);
    Serenity.setSessionVariable("phoneType").to(phoneType);
    Serenity.setSessionVariable("phone").to(phone);
    Serenity.setSessionVariable("instantMessagingType").to(instantMessagingType);
    Serenity.setSessionVariable("instantMessaging").to(instantMessaging);
    Serenity.setSessionVariable("url").to("https://meeds.io/");

    userProfileSteps.updateContactOtherInformations(basicInformations);
  }

  @Given("^I update my profile random basic informations$")
  public void updateRandomBasicInformation() {
    Map<String, String> basicInformations = new HashMap<>();
    String profileFirstName = getRandomString();
    String profileLastName = getRandomString();
    String profileMail = profileFirstName + "." + profileLastName + "@aa.bb";
    String profileJob = getRandomString() + " " + getRandomString();

    basicInformations.put("firstName", profileFirstName);
    basicInformations.put("lastName", profileLastName);
    basicInformations.put("email", profileMail);
    basicInformations.put("job", profileJob);

    Serenity.setSessionVariable("profileFirstName").to(profileFirstName);
    Serenity.setSessionVariable("profileLastName").to(profileLastName);
    Serenity.setSessionVariable("profileMail").to(profileMail);
    Serenity.setSessionVariable("profileJob").to(profileJob);
    userProfileSteps.updateBasicInformation(basicInformations);
  }

  @Given("^I update my profile work experiences$")
  public void updateWorkExperiences(Map<String, String> workExperiences) {
    userProfileSteps.updateWorkExperiences(workExperiences);
  }

  @Then("^I upload the Profile avatar '(.*)'$")
  public void uploadProfileAvatar(String fileName) {
    userProfileSteps.uploadProfileAvatar(fileName);
  }

}
