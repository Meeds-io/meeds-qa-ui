package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.Social.SocialPage;

public class SocialSteps {
  private SocialPage socialpage;

  public void cancelUpdateActivityComment(String comment) {
    socialpage.cancelUpdateActivityComment(comment);
  }

  public void checkSearchedUserWellMatched(String user) {
    socialpage.checkSearchedUserWellMatched(user);
  }

  public void commentActivity(String activity) {
    socialpage.CommentActivity(activity);
  }

  public void editComment() {
    socialpage.editComment();
  }

  public void filterByMyConnections() {

    socialpage.filterByMyConnections();
  }

  public void goToPeopleMenu() {
    socialpage.GoToPeopleMenu();

  }

  public void insertNameContact(String contact) {
    socialpage.insertNameContact(contact);
  }

  public void updateActivityComment(String comment) {
    socialpage.updateActivityComment(comment);
  }
}
