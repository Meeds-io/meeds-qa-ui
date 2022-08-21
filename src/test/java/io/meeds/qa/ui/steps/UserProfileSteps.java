package io.meeds.qa.ui.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.meeds.qa.ui.pages.page.factory.people.UserProfilePage;

public class UserProfileSteps {

  private UserProfilePage userProfilePage;

  public void isSentKudosVisible() {
    userProfilePage.isSentKudosVisible();
  }

  public List<String> checkListOfFields(List<String> listIfFields) {
    List<String> missingValues = new ArrayList<>();
    for (String fieldName : listIfFields) {
      if (!userProfilePage.isFieldVisible(fieldName))
        missingValues.add(fieldName);
    }
    return missingValues;
  }

  public void sentKudosUsersSectionIsDisplayed(String user) {
    userProfilePage.sentKudosUsersSectionIsDisplayed(user);
  }

  public void receivedKudosUsersSectionIsDisplayed(String user) {
    userProfilePage.receivedKudosUsersSectionIsDisplayed(user);
  }

  public void profilePageIsDisplayed() {
    userProfilePage.profilePageIsDisplayed();
  }

  public void isReceivedKudosVisible() {
    userProfilePage.isReceivedKudosVisible();
  }

  public void openAchivementTab() {
    userProfilePage.openAchivementTab();
  }

  public void goToReceivedKudos() {
    userProfilePage.goToReceivedKudos();
  }

  public void openBadgeDetails() {
    userProfilePage.openBadgeDetails();
  }

  public void openHowToEarnPointPage() {
    userProfilePage.openHowToEarnPointPage();
  }

  public void goToSentKudos() {
    userProfilePage.goToSentKudos();
  }

  public int getMyWeeklyPoint() {
    return userProfilePage.getMyWeeklyPoint();
  }

  public void sendKudos(String kudosMessage) {
    userProfilePage.clickOnSendKudosBtn();
    userProfilePage.sendKudos(kudosMessage);
  }

  public void howToEarnPointsPageIsDisplayed() {
    userProfilePage.howToEarnPointsPageIsDisplayed();
  }

  public boolean wasMyPointIncreased(int myPointBeforeKudos) {
    int retry = 5;
    int index = 0;
    // Retry at most 3 times until Gamification Points are increased
    while (userProfilePage.getMyWeeklyPoint() <= myPointBeforeKudos && index++ < retry) {
      userProfilePage.waitFor(3).seconds();
      userProfilePage.refreshPage();
    }
    return index < retry;
  }

  public void isProfileAvatarUploaded() {
    userProfilePage.isProfileAvatarUploaded();
  }

  public void uploadProfileAvatar(String fileName) {
    userProfilePage.uploadProfileAvatar(fileName);
  }

  public void sentKudosSectionIsDisplayed(String kudosNumber) {
    userProfilePage.sentKudosSectionIsDisplayed(kudosNumber);
  }

  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    userProfilePage.receivedKudosSectionIsDisplayed(kudosNumber);
  }

  public void isGainedCaurisVisible() {
    userProfilePage.isGainedCaurisVisible();
  }

  public void isCoverVisible() {
    userProfilePage.isCoverVisible();
  }

  public void isProfileContactCompanyVisible(String company) {
    userProfilePage.isProfileContactCompanyVisible(company);
  }

  public void isProfileContactPhoneVisible(String phone) {
    userProfilePage.isProfileContactPhoneVisible(phone);
  }

  public void isProfileContactInstantMessagingVisible(String instantMessaging) {
    userProfilePage.isProfileContactInstantMessagingVisible(instantMessaging);
  }

  public void isProfileContactUrlVisible(String url) {
    userProfilePage.isProfileContactUrlVisible(url);
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

  public void isProfileContactFullNameVisible(String title, String fullName) {
    userProfilePage.isProfileContactFullNameVisible(title, fullName);
  }

  public void updateWorkExperiences(Map<String, String> workExperiences) throws InterruptedException {
    userProfilePage.updateWorkExperiences(workExperiences.get("organization"),
                                      workExperiences.get("jobTitle"),
                                      workExperiences.get("jobDetails"),
                                      workExperiences.get("usedSkills"));
  }

  public void removeWorkExperience(String jobTitle) {
    userProfilePage.removeWorkExperience(jobTitle);
  }

  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    userProfilePage.checkWorkExperiencesSection(jobTitle, organization, jobDetails, usedSkills);
  }

  public void isProfileContactEmailVisible(String mail) {
    userProfilePage.isProfileContactEmailVisible(mail);
  }

  public void openWeeklyPointsChart() {
    userProfilePage.openWeeklyPointsChart();
  }

  public void isProfileContactJobVisible(String job) {
    // Check That Profile Contact Job is displayed
    userProfilePage.refreshPage();
    Assert.assertEquals(userProfilePage.ELEMENT_PROFILE_CONTACT_INFORMATION_JOBTITLE.getText(), job);
  }

  public void isUserJobVisible(String job) {
    Assert.assertEquals(userProfilePage.ELEMENT_PROFILE_JOB.getText(), job);
  }

  public void isAvatarVisible() {
    userProfilePage.isAvatarVisible();
  }

  public void isFullNameVisible(String fullName) {
    // Check That User Fullname is displayed in Profile Page
    Assert.assertEquals(userProfilePage.ELEMENT_PROFILE_FULLNAME.getText(), fullName);
  }

  public void clickConfirmConnect() {
    userProfilePage.clickConfirmConnect();
  }

  public void checkWeeklyPointChart() {
    userProfilePage.checkWeeklyPointChart();
  }

  public void checkAchievementsDrawer() {
    userProfilePage.checkAchievementsDrawer();
  }

  public void refreshPage() {
    userProfilePage.refreshPage();
  }

}
