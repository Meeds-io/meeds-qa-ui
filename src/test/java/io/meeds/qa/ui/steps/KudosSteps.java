package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.HomePage;
import io.meeds.qa.ui.pages.page.factory.Kudos.KudosPage;
import io.meeds.qa.ui.pages.page.factory.people.UserProfilePage;

public class KudosSteps {
  private HomePage        homePage;

  private KudosPage       kudosPage;

  private UserProfilePage userProfile;

  public void addActivityCommentKudosFromDrawer(String kudos) {
    kudosPage.addActivityCommentKudosFromDrawer(kudos);
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

  public void SearchUserCard(String user) {
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
    userProfile.sendKudos(kudosMessage);
  }

  public void updateKudosCommentMessage(String kudos) {
    kudosPage.updateKudosCommentMessage(kudos);
  }

  public void updateKudosMessage(String kudos) {
    kudosPage.updateKudosMessage(kudos);
  }

}
