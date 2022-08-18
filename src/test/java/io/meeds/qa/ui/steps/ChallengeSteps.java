package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.engagement.ChallengesPage;

public class ChallengeSteps {

  private ChallengesPage challengesPage;

  public void checkAddChallengeBtn() {
    challengesPage.checkAddChallengeBtn();
  }

  public void isAddChallengeBtnDisplayed() {
    challengesPage.isAddChallengeBtnDisplayed();
  }

  public void clickAddChallengeBtn() {
    challengesPage.clickAddChallengeBtn();
  }

  public void checkAddChallengeDrawer() {
    challengesPage.checkAddChallengeDrawer();
  }

  public void enterChallengeTitle(String challengeTitle) {
    challengesPage.enterChallengeTitle(challengeTitle);
  }

  public void addSpaceAudience(String randomSpaceName) {
    challengesPage.addSpaceAudience(randomSpaceName);
  }

  public void addProgramName(String programName) {
    challengesPage.addProgramName(programName);
  }

  public void selectStartDateTomorrow() {
    challengesPage.selectStartDateTomorrow();
  }

  public void selectEndDateNextWeek() {
    challengesPage.selectEndDateNextWeek();
  }

  public void addChallengeWithDescription(String description) {
    challengesPage.addChallengeWithDescription(description);
  }

  public void checkSuccessMessage(String message) {
    challengesPage.checkSuccessMessage(message);
  }

  public void selectStartDateToday() {
    challengesPage.selectStartDateToday();
  }

  public void addSpaceAudienceWithSecondUser(String secondRandomSpaceName) {
    challengesPage.addSpaceAudienceWithSecondUser(secondRandomSpaceName);
  }

  public void checkChallengeCardTitle(String title) {
    challengesPage.checkChallengeCardTitle(title);
  }

  public void enterRandomChallengeTitle(String challengeName) {
    challengesPage.enterRandomChallengeTitle(challengeName);
  }

  public void addChallengeWithRandomDescription(String challengeDescription) {
    challengesPage.addChallengeWithRandomDescription(challengeDescription);
  }

  public void selectEndDateTomorrow() {
    challengesPage.selectEndDateTomorrow();
  }

  public void checkTitleDisplayOnCard(String challengeName) {
    challengesPage.checkTitleDisplayOnCard(challengeName);
  }

  public void checkThreeDotsIconDisplay(String title) {

    challengesPage.checkThreeDotsIconDisplay(title);
  }

  public void checkAnnounceBtn(String title) {
    challengesPage.checkAnnounceBtn(title);
  }

  public void checkDateField(String title) {
    challengesPage.checkDateField(title);
  }

  public void clickAnnounceBtn() {
    challengesPage.clickAnnounceBtn();
  }

  public void checkAnnouncementDrawer() {
    challengesPage.checkAnnouncementDrawer();
  }

  public void assignChallengeToSecondUser(String user) {
    challengesPage.assignChallengeToSecondUser(user);
  }

  public void addAnnouncementWithRandomDescription(String announcementDescription) {
    challengesPage.addAnnouncementWithRandomDescription(announcementDescription);
  }

  public void checkAnnouncementActivityTopBar(String user, String space) {
    challengesPage.checkAnnouncementActivityTopBar(user, space);

  }

  public void checkWinnerNameOnAnnouncement(String user) {
    challengesPage.checkWinnerNameOnAnnouncement(user);

  }

  public void checkChallengeTitleOnAnnouncement(String challengeName) {
    challengesPage.checkChallengeTitleOnAnnouncement(challengeName);
  }

  public void checkAchievementDescriptionOnAnnouncement(String announcementDescription) {
    challengesPage.checkAchievementDescriptionOnAnnouncement(announcementDescription);
  }

}
