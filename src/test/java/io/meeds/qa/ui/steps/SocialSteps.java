package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.space.SpaceHomePage;

public class SocialSteps {
  private SpaceHomePage spaceHomePage;

  public void cancelUpdateActivityComment(String comment) {
    spaceHomePage.cancelUpdateActivityComment(comment);
  }

  public void checkSearchedUserWellMatched(String user) {
    spaceHomePage.checkSearchedUserWellMatched(user);
  }

  public void editComment() {
    spaceHomePage.editComment();
  }

  public void filterByMyConnections() {

    spaceHomePage.filterByMyConnections();
  }

  public void goToPeopleMenu() {
    spaceHomePage.goToPeopleMenu();
  }

  public void insertNameContact(String contact) {
    spaceHomePage.insertNameContact(contact);
  }

  public void updateActivityComment(String comment) {
    spaceHomePage.updateActivityComment(comment);
  }
}
