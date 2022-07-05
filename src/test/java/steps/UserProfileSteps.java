package steps;

import static org.aspectj.bridge.MessageUtil.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import net.serenitybdd.core.Serenity;
import pages.page.factory.people.UserProfile;

public class UserProfileSteps {

  private UserProfile userProfile;

  public void isSentKudosVisible() {
    userProfile.isSentKudosVisible();
  }

  public List<String> checkListOfFields(List<String> listIfFields) {
    List<String> missingValues = new ArrayList<>();
    for (String fieldName : listIfFields) {
      if (!userProfile.isFieldVisible(fieldName))
        missingValues.add(fieldName);
    }
    return missingValues;
  }

  public void sentKudosUsersSectionIsDisplayed(String user) {
    userProfile.sentKudosUsersSectionIsDisplayed(user);
  }

  public void receivedKudosUsersSectionIsDisplayed(String user) {
    userProfile.receivedKudosUsersSectionIsDisplayed(user);
  }

  public void profilePageIsDisplayed() {
    userProfile.profilePageIsDisplayed();
  }

  public void isReceivedKudosVisible() {
    userProfile.isReceivedKudosVisible();
  }

  public void openAchivementTab() {
    userProfile.openAchivementTab();
  }

  public void goToReceivedKudos() {
    userProfile.goToReceivedKudos();
  }

  public void openBadgeDetails() {
    userProfile.openBadgeDetails();
  }

  public void openHowToEarnPointPage() {
    userProfile.openHowToEarnPointPage();
  }

  public void goToSentKudos() {
    userProfile.goToSentKudos();
  }

  public int getMyWeeklyPoint() {
    return userProfile.getMyWeeklyPoint();
  }

  public void sendKudos(String kudosMessage) {
    userProfile.clickOnSendKudosBtn();
    userProfile.sendKudos(kudosMessage);
  }

  public void howToEarnPointsPageIsDisplayed() {
    userProfile.howToEarnPointsPageIsDisplayed();
  }

  public boolean wasMyPointIncreased(int myPointBeforeKudos) {
    return userProfile.getMyWeeklyPoint() > myPointBeforeKudos;
  }

  public void isProfileAvatarUploaded() {
    userProfile.isProfileAvatarUploaded();
  }

  public void uploadProfileAvatar(String fileName) {
    userProfile.uploadProfileAvatar(fileName);
  }

  public void sentKudosSectionIsDisplayed(String kudosNumber) {
    userProfile.sentKudosSectionIsDisplayed(kudosNumber);
  }

  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    userProfile.receivedKudosSectionIsDisplayed(kudosNumber);
  }

  public void isGainedCaurisVisible() {
    userProfile.isGainedCaurisVisible();
  }

  public void isCoverVisible() {
    info("Check That User Cover is displayed in Profile Page");
    userProfile.ELEMENT_PROFILE_COVER_DW.isVisibleAfterWaiting();
  }

  public void isProfileContactCompanyVisible(String company) {
    userProfile.isProfileContactCompanyVisible(company);
  }

  public void isProfileContactPhoneVisible(String phone) {
    userProfile.isProfileContactPhoneVisible(phone);
  }

  public void isProfileContactInstantMessagingVisible(String instantMessaging) {
    userProfile.isProfileContactInstantMessagingVisible(instantMessaging);
  }

  public void isProfileContactUrlVisible(String url) {
    userProfile.isProfileContactUrlVisible(url);
  }

  public void updateBasicInformation(Map<String, String> basicInformations) {
    userProfile.updateBasicInformation(basicInformations.get("firstName"),
                                       basicInformations.get("lastName"),
                                       basicInformations.get("email"),
                                       basicInformations.get("job"));
  }

  public void updateContactOtherInformations(Map<String, String> basicInformations) {
    userProfile.updateContactOtherInformations(basicInformations.get("company"),
                                               basicInformations.get("phoneType"),
                                               basicInformations.get("phone"),
                                               basicInformations.get("instantMessagingType"),
                                               basicInformations.get("instantMessaging"),
                                               basicInformations.get("url"));
  }

  public void isProfileContactFullNameVisible(String title, String fullName) {
    info("Check That Profile Contact Fullname is displayed");
    Assert.assertEquals(userProfile.ELEMENT_PROFILE_CONTACT_INFORMATION_TITLE_DW.getText(), title);
    Assert.assertEquals(userProfile.ELEMENT_PROFILE_CONTACT_INFORMATION_FULLNAME_DW.getText(), fullName);
  }

  public void updateWorkExperiences(Map<String, String> workExperiences) throws InterruptedException {
    userProfile.updateWorkExperiences(workExperiences.get("organization"),
                                      workExperiences.get("jobTitle"),
                                      workExperiences.get("jobDetails"),
                                      workExperiences.get("usedSkills"));
  }

  public void removeWorkExperience(String jobTitle) {
    userProfile.removeWorkExperience(jobTitle);
  }

  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    userProfile.checkWorkExperiencesSection(jobTitle, organization, jobDetails, usedSkills);
  }

  public void isProfileContactEmailVisible(String mail) {
    userProfile.ELEMENT_PROFILE_CONTACT_INFORMATION_EMAIL_DW.isVisibleAfterWaiting();
    Assert.assertEquals(userProfile.ELEMENT_PROFILE_CONTACT_INFORMATION_EMAIL_DW.getText(), mail);
    String contactEmail = userProfile.ELEMENT_PROFILE_CONTACT_INFORMATION_EMAIL_DW.getText();
    info("Check That Profile Contact Email is displayed" + contactEmail);
  }

  public void openWeeklyPointsChart() {
    userProfile.openWeeklyPointsChart();
  }

  public void openAchievementsTab() {
    userProfile.openAchievementsTab();
  }

  public void isProfileContactJobVisible(String job) {
    info("Check That Profile Contact Job is displayed");
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    Assert.assertEquals(userProfile.ELEMENT_PROFILE_CONTACT_INFORMATION_JOBTITLE_DW.getText(), job);
  }

  public void isUserJobVisible(String job) {
    Assert.assertEquals(userProfile.ELEMENT_PROFILE_JOB_DW.getText(), job);
  }

  public void isAvatarVisible() {
    info("Check That User Avatar is displayed in Profile Page");
    userProfile.ELEMENT_PROFILE_AVATAR_DW.isVisibleAfterWaiting();
  }

  public void isFullNameVisible(String fullName) {
    info("Check That User Fullname is displayed in Profile Page");
    Assert.assertEquals(userProfile.ELEMENT_PROFILE_FULLNAME_DW.getText(), fullName);
  }

  public void clickConfirmConnect() {
    userProfile.clickConfirmConnect();
  }

}
