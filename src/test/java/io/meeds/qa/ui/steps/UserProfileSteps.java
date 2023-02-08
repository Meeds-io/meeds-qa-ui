package io.meeds.qa.ui.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.meeds.qa.ui.pages.page.factory.kudos.KudosAdministrationPage;
import io.meeds.qa.ui.pages.page.factory.people.UserProfilePage;
import io.meeds.qa.ui.utils.Utils;

public class UserProfileSteps {

  private UserProfilePage         userProfilePage;

  private KudosAdministrationPage kudosPage;

  public void addWorkExperiences(Map<String, String> workExperiences) {
    userProfilePage.addWorkExperiences(workExperiences.get("organization"),
                                       workExperiences.get("jobTitle"),
                                       workExperiences.get("jobDetails"),
                                       workExperiences.get("usedSkills"));
  }

  public void checkAchievementsDrawer() {
    userProfilePage.checkAchievementsDrawer();
  }

  public List<String> checkListOfFields(List<String> listIfFields) {
    List<String> missingValues = new ArrayList<>();
    for (String fieldName : listIfFields) {
      if (!userProfilePage.checkFieldVisible(fieldName))
        missingValues.add(fieldName);
    }
    return missingValues;
  }

  public void checkProfileContactInstantMessagingVisible(String instantMessagingType, String instantMessaging) {
    userProfilePage.checkProfileContactInstantMessagingVisible(instantMessagingType, instantMessaging);
  }

  public void checkProfileContactPhoneVisible(String phoneType, String phone) {
    userProfilePage.checkProfileContactPhoneVisible(phoneType, phone);
  }

  public void checkWeeklyPointChart() {
    userProfilePage.checkWeeklyPointChart();
  }

  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    userProfilePage.checkWorkExperiencesSection(jobTitle, organization, jobDetails, usedSkills);
  }

  public void clickConfirmConnect() {
    userProfilePage.clickConfirmConnect();
  }

  public int getMyWeeklyPoint() {
    return userProfilePage.getMyWeeklyPoint();
  }

  public void goToReceivedKudos() {
    userProfilePage.goToReceivedKudos();
  }

  public void goToSentKudos() {
    userProfilePage.goToSentKudos();
  }

  public void howToEarnPointsPageIsDisplayed() {
    userProfilePage.howToEarnPointsPageIsDisplayed();
  }

  public void isAvatarVisible() {
    userProfilePage.checkAvatarVisible();
  }

  public void isCoverVisible() {
    userProfilePage.checkCoverVisible();
  }

  public void isGainedCaurisVisible() {
    userProfilePage.checkGainedCaurisVisible();
  }

  public void isProfileAvatarUploaded() {
    userProfilePage.checkProfileAvatarUploaded();
  }

  public void isProfileContactCompanyVisible(String company) {
    userProfilePage.checkProfileContactCompanyVisible(company);
  }

  public void isProfileContactEmailVisible(String mail) {
    userProfilePage.checkProfileContactEmailVisible(mail);
  }

  public void isProfileContactFullNameVisible(String title, String fullName) {
    userProfilePage.checkProfileContactFullNameVisible(title, fullName);
  }

  public void isProfileContactUrlVisible(String url) {
    userProfilePage.checkProfileContactUrlVisible(url);
  }

  public void isReceivedKudosVisible() {
    userProfilePage.checkReceivedKudosVisible();
  }

  public void isSentKudosVisible() {
    userProfilePage.checkSentKudosVisible();
  }

  public void isUserJobVisible(String job) {
    userProfilePage.checkProfileContactJobTitleVisible(job);
  }

  public void openAchivementTab() {
    userProfilePage.openAchivementTab();
  }

  public void openBadgeDetails() {
    userProfilePage.openBadgeDetails();
  }

  public void openHowToEarnPointPage() {
    userProfilePage.openHowToEarnPointPage();
  }

  public void openWeeklyPointsChart() {
    userProfilePage.openWeeklyPointsChart();
  }

  public void profilePageIsDisplayed() {
    userProfilePage.profilePageIsDisplayed();
  }

  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    userProfilePage.receivedKudosSectionIsDisplayed(kudosNumber);
  }

  public void receivedKudosUsersSectionIsDisplayed(String user) {
    userProfilePage.receivedKudosUsersSectionIsDisplayed(user);
  }

  public void removeWorkExperience(String jobTitle) {
    userProfilePage.removeWorkExperience(jobTitle);
  }

  public void sendKudos(String kudosMessage) {
    userProfilePage.clickOnSendKudosBtn();
    kudosPage.sendKudosMessageFromOpenedDrawer(kudosMessage);
  }

  public void sentKudosSectionIsDisplayed(String kudosNumber) {
    userProfilePage.sentKudosSectionIsDisplayed(kudosNumber);
  }

  public void sentKudosUsersSectionIsDisplayed(String user) {
    userProfilePage.sentKudosUsersSectionIsDisplayed(user);
  }

  public void updateBasicInformation(Map<String, String> basicInformations) {
    userProfilePage.updateBasicInformation(basicInformations.get("firstName"),
                                           basicInformations.get("lastName"),
                                           basicInformations.get("email"),
                                           basicInformations.get("job"));
  }

  public void updateContactOtherInformations(Map<String, String> basicInformations) {
    userProfilePage.updateContactOtherInformations(basicInformations.get("company"),
                                                   basicInformations.get("phoneType"),
                                                   basicInformations.get("phone"),
                                                   basicInformations.get("instantMessagingType"),
                                                   basicInformations.get("instantMessaging"),
                                                   basicInformations.get("url"));
  }

  public void updateWorkExperiences(Map<String, String> workExperiences) {
    userProfilePage.updateWorkExperiences(workExperiences.get("organization"),
                                          workExperiences.get("jobTitle"),
                                          workExperiences.get("jobDetails"),
                                          workExperiences.get("usedSkills"));
  }

  public void uploadProfileAvatar(String fileName) {
    userProfilePage.uploadProfileAvatar(fileName);
  }

  public boolean wasMyPointIncreased(int myPointBeforeKudos) {
    int retry = 5;
    int index = 0;
    // Retry at most 3 times until Gamification Points are increased
    while (userProfilePage.getMyWeeklyPoint() <= myPointBeforeKudos && index++ < retry) {
      userProfilePage.waitFor(3).seconds();
      Utils.refreshPage();
    }
    return index < retry;
  }

}
