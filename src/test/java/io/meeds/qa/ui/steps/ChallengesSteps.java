package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.ChallengesPage;
import io.meeds.qa.ui.pages.SpaceHomePage;

public class ChallengesSteps {

  private ChallengesPage challengesPage;

  private SpaceHomePage  spaceHomePage;

  public void clickAddChallengeBtn() {
    challengesPage.clickAddChallengeBtn();
  }

  public void enterChallengeTitle(String challengeTitle) {
    challengesPage.enterChallengeTitle(challengeTitle);
  }

  public void addProgram(String programTitle) {
    challengesPage.addProgram(programTitle);
  }

  public void enterStartedChallenge() {
    challengesPage.enterStartedChallenge();
  }

  public void addChallengeRandomDescription(String challengeDescription) {
    challengesPage.addChallengeRandomDescription(challengeDescription);
  }

  public void cancelAnnouncementChallenge(String announcement) {
    spaceHomePage.openThreeDotsActivityMenu(announcement);
    challengesPage.cancelAnnouncementChallenge(announcement);
    spaceHomePage.clickYesbutton();
  }

  public void isOverviewChallengeDisplayed(String challengeTitle, String participantsCount) {
    challengesPage.isOverviewChallengeDisplayed(challengeTitle, participantsCount);
  }

  public void isOverviewChallengeNotDisplayed(String challengeTitle, String participantsCount) {
    challengesPage.isOverviewChallengeNotDisplayed(challengeTitle, participantsCount);
  }
}
