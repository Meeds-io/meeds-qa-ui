package io.meeds.qa.ui.steps;

import java.util.Map;

import io.meeds.qa.ui.pages.ActionsPage;
import io.meeds.qa.ui.pages.RulePage;
import io.meeds.qa.ui.pages.SpaceHomePage;

public class ActionsSteps {

  private ActionsPage   actionsPage;

  private RulePage      rulePage;

  private SpaceHomePage spaceHomePage;

  public void updateAction(String challengeName, Map<String, String> details) {
    actionsPage.openEditChallengeDrawer(challengeName);

    String title = details.get("title");
    String description = details.get("description");
    String points = details.get("points");
    rulePage.saveAction(title, description, points, true, false, false);
  }

  public void searchChallenge(String challengeName) {
    actionsPage.searchAction(challengeName);
  }

  public void cancelAnnouncementChallenge(String announcement) {
    spaceHomePage.openThreeDotsActivityMenu(announcement);
    actionsPage.cancelAnnouncementChallenge(announcement);
    spaceHomePage.clickYesbutton();
  }

  public void isOverviewChallengeDisplayed(String challengeTitle, String participantsCount) {
    actionsPage.isOverviewChallengeDisplayed(challengeTitle, participantsCount);
  }

  public void isOverviewChallengeNotDisplayed(String challengeTitle, String participantsCount) {
    actionsPage.isOverviewChallengeNotDisplayed(challengeTitle, participantsCount);
  }

  public void checkChallengePoints(String challengeName, String points) {
    actionsPage.checkChallengePoints(challengeName, points);
  }

}
