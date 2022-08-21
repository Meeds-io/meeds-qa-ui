package io.meeds.qa.ui.steps.definition;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

  public static String getTheRandomNumber() {
    char[] chars = "0123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      char c = chars[random.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  @Then("The profile page is displayed")
  public void profilePageIsDisplayed() {
    userProfileSteps.profilePageIsDisplayed();
  }

  @Then("Sent Kudos Section is displayed")
  public void isSentKudosVisible() {
    userProfileSteps.isSentKudosVisible();
  }

  @Then("^The following items are displayed$")
  public void checkListOfItem(List<String> listOfItems) {
    assertThat(userProfileSteps.checkListOfFields(listOfItems)).as(String.format("The item %s is not diplayed",
                                                                                 userProfileSteps.checkListOfFields(listOfItems)))
                                                               .isEmpty();
  }

  @Then("I open achievement tab")
  public void openAchivementTab() {
    userProfileSteps.openAchivementTab();
  }

  @When("^I send kudos with message '(.*)'$")
  public void sendKudos(String kudosMessage) {
    userProfileSteps.sendKudos(kudosMessage);
  }

  @Then("I open badge details")
  public void openBadgeDetails() {
    userProfileSteps.openBadgeDetails();
  }

  @Then("^'(.*)' kudos are sent$")
  public void sentKudosSectionIsDisplayed(String kudosNumber) {
    userProfileSteps.sentKudosSectionIsDisplayed(kudosNumber);
  }

  @Then("^'(.*)' kudos are received$")
  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    userProfileSteps.receivedKudosSectionIsDisplayed(kudosNumber);
  }

  @Then("^I open How To Earn Point Page$")
  public void openHowToEarnPointPage() {
    userProfileSteps.openHowToEarnPointPage();
  }

  @When("^I check my points$")
  public void getMyWeeklyPoint() {
    int myPointBeforeKudos = userProfileSteps.getMyWeeklyPoint();
    Serenity.setSessionVariable("myPointBeforeKudos").to(myPointBeforeKudos);
  }

  @When("^How to earn points page is displayed$")
  public void howToEarnPointsPageIsDisplayed() {
    userProfileSteps.howToEarnPointsPageIsDisplayed();
  }

  @Then("^I confirm connection$")
  public void clickConfirmConnect() {
    userProfileSteps.clickConfirmConnect();
  }

  @Then("My points augmented")
  public void checkMyPointIncrease() {
    int myPointBeforeKudos = Serenity.sessionVariableCalled("myPointBeforeKudos");
    assertThat(userProfileSteps.wasMyPointIncreased(myPointBeforeKudos)).as("The points did not increase. Old Value = "+ myPointBeforeKudos)
                                                                        .isTrue();
  }

  @Then("Received Kudos Section is displayed")
  public void isReceivedKudosVisible() {
    userProfileSteps.isReceivedKudosVisible();
  }

  @Then("I go to Received Kudos")
  public void goToReceivedKudos() {
    userProfileSteps.goToReceivedKudos();
  }

  @Then("^I upload the Profile avatar '(.*)'$")
  public void uploadProfileAvatar(String fileName) {
    userProfileSteps.uploadProfileAvatar(fileName);
  }

  @Then("I go to Sent Kudos")
  public void goToSentKudos() {
    userProfileSteps.goToSentKudos();
  }

  @Then("^Sent kudos by user '(.*)' is displayed$")
  public void sentKudosUsersSectionIsDisplayed(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    userProfileSteps.sentKudosUsersSectionIsDisplayed(userLastName);
  }

  @Then("Profile avatar is uploaded")
  public void isProfileAvatarUploaded() {
    userProfileSteps.isProfileAvatarUploaded();
  }

  @Then("Gained Cauris Section is displayed")
  public void isGainedCaurisVisible() {
    userProfileSteps.isGainedCaurisVisible();
  }

  @Then("^User Cover is displayed in Profile Page$")
  public void isCoverVisible() {
    userProfileSteps.isCoverVisible();
  }

  @Then("^User Avatar is displayed in Profile Page$")
  public void isAvatarVisible() {
    userProfileSteps.isAvatarVisible();
  }

  @Then("^User Fullname '(.*)' is displayed in Profile Page$")
  public void isFullNameVisible(String fullName) {
    userProfileSteps.isFullNameVisible(fullName);
  }

  @Then("^User Job '(.*)' is displayed in Profile Page$")
  public void isUserJobVisible(String job) {
    userProfileSteps.isUserJobVisible(job);
  }

  @Then("^Profile Contact Fullname '(.*)' is displayed in '(.*)'$")
  public void isProfileContactFullNameVisible(String title, String fullName) {
    userProfileSteps.isProfileContactFullNameVisible(title, fullName);
  }

  @Then("^In '(.*)', Updated profile Contact Fullname is displayed$")
  public void isProfileContactRandomFullNameVisible(String title) {
    String profileFirstName = Serenity.sessionVariableCalled("profileFirstName");
    String profileLastName = Serenity.sessionVariableCalled("profileLastName");

    String fullName = profileFirstName + " " + profileLastName;
    userProfileSteps.isProfileContactFullNameVisible(title, fullName);
  }

  @Then("^Updated Profile Contact Email is displayed$")
  public void isProfileContactRandomEmailVisible() {
    String profileMail = Serenity.sessionVariableCalled("profileMail");
    userProfileSteps.isProfileContactEmailVisible(profileMail);
  }

  @Then("^Updated Profile Contact Company is displayed$")
  public void isProfileContactRandomCompanyVisible() {
    String company = Serenity.sessionVariableCalled("company");
    userProfileSteps.isProfileContactCompanyVisible(company);
  }

  @Then("^Updated Profile Contact Phone is displayed$")
  public void isProfileContactRandomPhoneVisible() {
    String phoneType = "Work";
    String phone = Serenity.sessionVariableCalled("phone");
    String phoneInformation = phoneType + ": " + phone;
    userProfileSteps.refreshPage();
    userProfileSteps.isProfileContactPhoneVisible(phoneInformation);
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
    userProfileSteps.isProfileContactJobVisible(profileJob);
  }

  @Then("^Updated Profile Contact Url is displayed$")
  public void isProfileContactRandomUrlVisible() {
    String url = "community-preprod.exoplatform.com/portal/meeds/profile/khalil_riahi";
    userProfileSteps.isProfileContactUrlVisible(url);
  }

  @Given("^I update my profile basic informations$")
  public void updateBasicInformation(Map<String, String> basicInformations) {
    userProfileSteps.updateBasicInformation(basicInformations);
  }

  @Given("^I update my profile other informations$")
  public void updateContactOtherInformations(Map<String, String> basicInformations) {
    userProfileSteps.updateContactOtherInformations(basicInformations);
  }

  @Then("^Profile Contact Company '(.*)' is displayed$")
  public void isProfileContactCompanyVisible(String company) {
    userProfileSteps.isProfileContactCompanyVisible(company);
  }

  @Then("^Received kudos by (.*) user is displayed$")
  public void receivedKudosByRandomUserSectionIsDisplayed(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    userProfileSteps.receivedKudosUsersSectionIsDisplayed(userLastName);
  }

  @Given("^I update my profile work experiences$")
  @And("^I add my profile work experiences$")
  public void updateWorkExperiences(Map<String, String> workExperiences) throws InterruptedException {
    userProfileSteps.updateWorkExperiences(workExperiences);
  }

  @Given("^I remove my profile work experiences '(.*)'$")
  public void removeWorkExperience(String jobTitle) {
    userProfileSteps.removeWorkExperience(jobTitle);
  }

  @Given("^I update my profile random basic informations$")
  public void updateRandomBasicInformation() {
    Map<String, String> basicInformations = new HashMap<String, String>() {
      {
        String profileFirstName = getRandomString();
        String profileLastName = getRandomString();
        String profileMail = profileFirstName + "." + profileLastName + "@aa.bb";
        String profileJob = getRandomString() + " " + getRandomString();

        put("firstName", profileFirstName);
        put("lastName", profileLastName);
        put("email", profileMail);
        put("job", profileJob);

        Serenity.setSessionVariable("profileFirstName").to(profileFirstName);
        Serenity.setSessionVariable("profileLastName").to(profileLastName);
        Serenity.setSessionVariable("profileMail").to(profileMail);
        Serenity.setSessionVariable("profileJob").to(profileJob);
      }
    };
    userProfileSteps.updateBasicInformation(basicInformations);
  }

  @Given("^I update my profile other random informations$")
  public void updateContactOtherRandomInformations() {
    Map<String, String> basicInformations = new HashMap<String, String>() {
      {
        String company = getRandomString();
        String phoneType = "WORK";
        String phone = getTheRandomNumber();
        String instantMessagingType = "SKYPE";
        String instantMessaging = getRandomString() + "." + getRandomString();
        String url = "https://community-preprod.exoplatform.com/portal/meeds/profile/khalil_riahi";

        put("company", company);
        put("phoneType", phoneType);
        put("phone", phone);
        put("instantMessagingType", instantMessagingType);
        put("instantMessaging", instantMessaging);
        put("url", url);

        Serenity.setSessionVariable("company").to(company);
        Serenity.setSessionVariable("phoneType").to(phoneType);
        Serenity.setSessionVariable("phone").to(phone);
        Serenity.setSessionVariable("instantMessagingType").to(instantMessagingType);
        Serenity.setSessionVariable("instantMessaging").to(instantMessaging);
        Serenity.setSessionVariable("url").to(url);
      }
    };

    userProfileSteps.updateContactOtherInformations(basicInformations);
  }

  @Given("^Job title '(.*)' and Organization '(.*)' and Job details '(.*)' and Used skills '(.*)' are displayed in Work experiences section$")
  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    userProfileSteps.checkWorkExperiencesSection(jobTitle, organization, jobDetails, usedSkills);
  }

  @Then("^Profile Contact Phone '(.*)' is displayed$")
  public void isProfileContactPhoneVisible(String phone) {
    userProfileSteps.refreshPage();
    userProfileSteps.isProfileContactPhoneVisible(phone);
  }

  @Then("^Profile Contact instantMessaging '(.*)' is displayed$")
  public void isProfileContactInstantMessagingVisible(String instantMessaging) {
    userProfileSteps.isProfileContactInstantMessagingVisible(instantMessaging);
  }

  @Then("^I open Weekly Points Chart$")
  public void openWeeklyPointsChart() {
    userProfileSteps.openWeeklyPointsChart();
  }

  @Then("^Profile Contact Url '(.*)' is displayed$")
  public void isProfileContactUrlVisible(String url) {
    userProfileSteps.isProfileContactUrlVisible(url);
  }

  @Then("^Profile Contact Email '(.*)' is displayed$")
  public void isProfileContactEmailVisible(String mail) {
    userProfileSteps.isProfileContactEmailVisible(mail);
  }

  @Then("^Profile Contact Job '(.*)' is displayed$")
  public void isProfileContactJobVisible(String job) {
    userProfileSteps.isProfileContactJobVisible(job);
  }

  @Then("The weekly point chart is displayed")
  public void checkWeeklyPointChart() {
    userProfileSteps.checkWeeklyPointChart();
  }

  @Then("The achievements drawer is displayed")
  public void checkAchievementsDrawer() {
    userProfileSteps.checkAchievementsDrawer();
  }

}
