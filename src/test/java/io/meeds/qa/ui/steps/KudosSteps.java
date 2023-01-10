package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.HomePage;
import io.meeds.qa.ui.pages.page.factory.Kudos.KudosPage;
import io.meeds.qa.ui.pages.page.factory.space.SpaceHomePage;

public class KudosSteps {
  private HomePage  homePage;

  private KudosPage kudosPage;
  private SpaceHomePage spaceHomePage;

  public void addActivityKudos(String activity, String comment) {
    kudosPage.addActivityKudos(activity, comment);
  }

  public void addActivityCommentKudos(String kudos) {
    kudosPage.sendKudosMessageFromOpenedDrawer(kudos);
  }

  public void checkKudosIconDisabled(String activityId) {
    kudosPage.checkKudosIconDisabled(activityId);
  }

  public void checkKudosSettings(String val, String period) {
    kudosPage.checkKudosSettings(val, period);
  }

  public void clickEditKudos() {
    kudosPage.clickEditKudos();
  }

  public void clickEditKudosFromReply() {
    kudosPage.clickEditKudosFromReply();
  }

  public void editKudos() {
    kudosPage.editKudos();
  }

  public void enterKudosNumber(String val) {
    kudosPage.enterKudosNumber(val);
  }

  public void goToKudosMenu() {
    kudosPage.goToKudosMenu();
  }

  public void isKudosActivityVisible(String message) {
    kudosPage.checkKudosActivityVisible(message);
  }

  public void saveChanges() {
    kudosPage.saveChange();
  }

  public void searchUserCard(String user) {
    homePage.refreshPage();
    homePage.goToPeoplePage();
    kudosPage.searchForUsersByName(user);
  }

  public void selectType() {
    kudosPage.selectType();
  }

  public void sendMessage(String txt) {
    kudosPage.sendMessage(txt);
  }

  public void threeDotsMenuSendKudos(String kudosMessage) {
    kudosPage.threeDotsMenuSendKudos();
    kudosPage.sendKudosMessageFromOpenedDrawer(kudosMessage);
  }

  public void updateKudosMessage(String kudos) {
    spaceHomePage.updateCommentText(kudos);
    spaceHomePage.updateComment();
  }

  public void addActivityKudosToSomeoneDifferent(String activity, String message, String user) {
    kudosPage.addActivityKudosToSomeoneDifferent(activity, message, user);
  }

  public void getMessageNotFoundUserInSpace(String Message) {
    kudosPage.getMessageNotFoundUserInSpace(Message);
  }
}
