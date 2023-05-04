package io.meeds.qa.ui.steps;

import java.util.Map;

import io.meeds.qa.ui.pages.ChallengesPage;
import io.meeds.qa.ui.pages.RulePage;
import io.meeds.qa.ui.pages.SpaceHomePage;

public class ChallengesSteps {

  private ChallengesPage challengesPage;

  private RulePage       rulePage;

  private SpaceHomePage  spaceHomePage;

  public void updateChallenge(String challengeName, Map<String, String> details) {
    challengesPage.openEditChallengeDrawer(challengeName);

    String title = details.get("title");
    String description = details.get("description");
    String points = details.get("points");
    rulePage.saveAction(title, description, points, true, false, false);
  }

  public void searchChallenge(String challengeName) {
    challengesPage.searchChallenge(challengeName);
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

  public void checkChallengePoints(String challengeName, String points) {
    challengesPage.checkChallengePoints(challengeName, points);
  }

}
