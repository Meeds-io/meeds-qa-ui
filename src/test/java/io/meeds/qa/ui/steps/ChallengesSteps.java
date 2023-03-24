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

  public void clickAddChallengeBtn() {
    challengesPage.clickAddChallengeBtn();
  }

  public void createRandomChallenge(String challengeName, Map<String, String> details) {
    challengesPage.clickAddChallengeBtn();

    String challengeProgram = details.get("program");
    String challengeDescription = details.get("description");
    String challengePoints = details.get("points");
    if (StringUtils.isBlank(challengeDescription)) {
      challengeDescription = "challengeDescription" + getRandomNumber();
    }
    if (StringUtils.isNotBlank(challengeProgram)) {
      challengeProgram = Serenity.sessionVariableCalled("programName" + challengeProgram);
    }
    challengesPage.saveChallenge(challengeName, challengeDescription, challengeProgram, challengePoints);
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
