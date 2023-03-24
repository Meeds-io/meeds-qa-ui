package io.meeds.qa.ui.steps;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.pages.ChallengesPage;
import io.meeds.qa.ui.pages.SpaceHomePage;
import net.serenitybdd.core.Serenity;

public class ChallengesSteps {

  private ChallengesPage challengesPage;

  private SpaceHomePage  spaceHomePage;

  public void updateChallenge(String challengeName, Map<String, String> details) {
    challengesPage.openEditChallengeDrawer(challengeName);

    String challengeTitle = details.get("title");
    String challengeDescription = details.get("description");
    String challengeProgram = details.get("program");
    String challengePoints = details.get("points");
    challengesPage.saveChallenge(challengeTitle, challengeDescription, challengeProgram, challengePoints, false);
  }

  public void createdChallenge(String challengeName, Map<String, String> details) {
    challengesPage.clickAddChallengeBtn();

    String challengeDescription = details.get("description");
    if (StringUtils.isBlank(challengeDescription)) {
      challengeDescription = "challengeDescription" + getRandomNumber();
    }
    String challengeProgram = details.get("program");
    if (StringUtils.isNotBlank(challengeProgram)) {
      challengeProgram = Serenity.sessionVariableCalled("programName" + challengeProgram);
    }
    String challengePoints = details.get("points");

    challengesPage.saveChallenge(challengeName, challengeDescription, challengeProgram, challengePoints, true);
  }

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
    challengesPage.addChallengeDescription(challengeDescription);
    challengesPage.clickOnSaveButton();
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
