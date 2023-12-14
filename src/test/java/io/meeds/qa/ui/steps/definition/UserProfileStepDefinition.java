/*
 * This file is part of the Meeds project (https://meeds.io/).
 * 
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.steps.definition;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;
import static io.meeds.qa.ui.utils.Utils.getRandomString;
import static io.meeds.qa.ui.utils.Utils.refreshPage;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.UserProfileSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UserProfileStepDefinition {

  private static final String IM_PARAM      = "instantMessaging";

  private static final String COMPANY_PARAM = "company";

  private static final String PHONE_PARAM   = "phone";

  @Steps
  private UserProfileSteps    userProfileSteps;

  @And("^I add my profile work experiences$")
  public void addWorkExperiences(Map<String, String> workExperiences) {
    userProfileSteps.addWorkExperiences(workExperiences);
  }

  @Then("My points augmented")
  public void checkMyPointIncrease() {
    int originalWeeklyPoint = Serenity.sessionVariableCalled("originalWeeklyPoint");
    userProfileSteps.checkMyPointIncrease(originalWeeklyPoint);
  }

  @Then("^Updated Profile Contact instantMessaging is displayed$")
  public void checkProfileContactInstantMessagingVisible() {
    String instantMessagingType = "Skype";
    String instantMessaging = Serenity.sessionVariableCalled(IM_PARAM);
    userProfileSteps.checkProfileContactInstantMessagingVisible(instantMessagingType, instantMessaging);
  }

  @Given("^Job title '(.*)' and Organization '(.*)' and Job details '(.*)' and Used skills '(.*)' are displayed in Work experiences section$")
  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    userProfileSteps.checkWorkExperiencesSection(jobTitle, organization, jobDetails, usedSkills);
  }

  @When("^I check my points$")
  public void getMyWeeklyPoint() {
    int originalWeeklyPoint = userProfileSteps.getMyWeeklyPoint();
    Serenity.setSessionVariable("originalWeeklyPoint").to(originalWeeklyPoint);
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
    userProfileSteps.checkProfileContactInstantMessagingVisible("", instantMessaging);
  }

  @Then("^Profile Contact Phone '(.*)' is displayed$")
  public void isProfileContactPhoneVisible(String phone) {
    userProfileSteps.checkProfileContactPhoneVisible("", phone);
  }

  @Then("^Updated Profile Contact Company is displayed$")
  public void isProfileContactRandomCompanyVisible() {
    String company = Serenity.sessionVariableCalled(COMPANY_PARAM);
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

  @Then("^Updated Profile Contact Job is displayed$")
  public void isProfileContactRandomJobVisible() {
    String profileJob = Serenity.sessionVariableCalled("profileJob");
    userProfileSteps.isUserJobVisible(profileJob);
  }

  @Then("^Updated Profile Contact Phone is displayed$")
  public void isProfileContactRandomPhoneVisible() {
    String phoneType = "Work";
    String phone = Serenity.sessionVariableCalled(PHONE_PARAM);
    refreshPage();
    userProfileSteps.checkProfileContactPhoneVisible(phoneType, phone);
  }

  @Then("^Updated Profile Contact Url is displayed$")
  public void isProfileContactRandomUrlVisible() {
    userProfileSteps.isProfileContactUrlVisible("meeds.io");
  }

  @Then("^Received kudos by (.*) user is displayed$")
  public void receivedKudosByRandomUserSectionIsDisplayed(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    userProfileSteps.receivedKudosUsersSectionIsDisplayed(userLastName);
  }

  @Then("No kudos are received")
  public void checkNoReceivedKudos() {
    userProfileSteps.checkNoReceivedKudos();
  }

  @Then("No kudos are sent")
  public void checkNoSentKudos() {
    userProfileSteps.checkNoSentKudos();
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

  @Given("^I update my profile other random informations$")
  public void updateContactOtherRandomInformations() {
    Map<String, String> basicInformations = new HashMap<>();
    String company = getRandomString();
    String phoneType = "WORK";
    String phone = getRandomNumber();
    String instantMessagingType = "SKYPE";
    String instantMessaging = getRandomString() + "." + getRandomString();

    basicInformations.put(COMPANY_PARAM, company);
    basicInformations.put("phoneType", phoneType);
    basicInformations.put(PHONE_PARAM, phone);
    basicInformations.put("instantMessagingType", instantMessagingType);
    basicInformations.put(IM_PARAM, instantMessaging);
    basicInformations.put("url", "https://meeds.io/");

    Serenity.setSessionVariable(COMPANY_PARAM).to(company);
    Serenity.setSessionVariable("phoneType").to(phoneType);
    Serenity.setSessionVariable(PHONE_PARAM).to(phone);
    Serenity.setSessionVariable("instantMessagingType").to(instantMessagingType);
    Serenity.setSessionVariable(IM_PARAM).to(instantMessaging);
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

  @Then("^I upload the Profile avatar '(.*)'$")
  public void uploadProfileAvatar(String fileName) {
    userProfileSteps.uploadProfileAvatar(fileName);
  }

}
