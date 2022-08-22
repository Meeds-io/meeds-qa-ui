package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.engagement.ChallengesPage;

public class ChallengeSteps {

  private ChallengesPage challengesPage;

  public void addAnnouncementWithRandomDescription(String announcementDescription) {
    challengesPage.addAnnouncementWithRandomDescription(announcementDescription);
  }

  public void addChallengeWithDescription(String description) {
    challengesPage.addChallengeWithDescription(description);
  }

  public void addChallengeWithRandomDescription(String challengeDescription) {
    challengesPage.addChallengeWithRandomDescription(challengeDescription);
  }

  public void addProgramName(String programName) {
    challengesPage.addProgramName(programName);
  }

  public void addSpaceAudience(String randomSpaceName) {
    challengesPage.addSpaceAudience(randomSpaceName);
  }

  public void assignChallengeToUser(String user) {
    challengesPage.assignChallengeToUser(user);
  }

  public void checkAchievementDescriptionOnAnnouncement(String announcementDescription) {
    challengesPage.checkAchievementDescriptionOnAnnouncement(announcementDescription);
  }

  public void checkAddChallengeBtn() {
    challengesPage.checkAddChallengeBtn();
  }

  public void checkAddChallengeBtnNotDispayed() {
    challengesPage.checkAddChallengeBtnNotDispayed();
  }

  public void checkAddChallengeDrawer() {
    challengesPage.checkAddChallengeDrawer();
  }

  public void checkAnnounceBtn(String title) {
    challengesPage.checkAnnounceBtn(title);
  }

  public void checkAnnouncementActivity(String posterPrefix,
                                        String winnerPrefix,
                                        String challengeName,
                                        String announcementDescription) {
    challengesPage.checkAnnouncementActivity(posterPrefix, winnerPrefix, challengeName, announcementDescription);

  }

  public void checkAnnouncementDrawer() {
    challengesPage.checkAnnouncementDrawer();
  }

  public void checkChallengeCardTitle(String title) {
    challengesPage.checkChallengeCardTitle(title);
  }

  public void checkChallengeTitleOnAnnouncement(String challengeName) {
    challengesPage.checkChallengeTitleOnAnnouncement(challengeName);
  }

  public void checkDateField(String title) {
    challengesPage.checkDateField(title);
  }

  public void checkNoChallengeCardTitle(String title) {
    challengesPage.checkNoChallengeCardTitle(title);
  }

  public void checkSuccessMessage(String message) {
    challengesPage.checkSuccessMessage(message);
  }

  public void checkThreeDotsIconDisplay(String title) {

    challengesPage.checkThreeDotsIconDisplay(title);
  }

  public void checkTitleDisplayOnCard(String challengeName) {
    challengesPage.checkTitleDisplayOnCard(challengeName);
  }

  public void clickAddChallengeBtn() {
    challengesPage.clickAddChallengeBtn();
  }

  public void clickAnnounceBtn(String title) {
    challengesPage.clickAnnounceBtn(title);
  }

  public void enterChallengeTitle(String challengeTitle) {
    challengesPage.enterChallengeTitle(challengeTitle);
  }

  public void enterRandomChallengeTitle(String challengeName) {
    challengesPage.enterRandomChallengeTitle(challengeName);
  }

  public void selectChallengesFilter(String value) {
    challengesPage.selectChallengesFilter(value);
  }

  public void selectEndDateNextWeek() {
    challengesPage.selectEndDateNextWeek();
  }

  public void selectEndDateTomorrow() {
    challengesPage.selectEndDateTomorrow();
  }

  public void selectStartDateToday() {
    challengesPage.selectStartDateToday();
  }

  public void selectStartDateTomorrow() {
    challengesPage.selectStartDateTomorrow();
  }

}
