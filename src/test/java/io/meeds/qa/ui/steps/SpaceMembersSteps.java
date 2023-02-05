package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.space.SpaceMembersPage;

public class SpaceMembersSteps {

  private SpaceMembersPage spaceMembersPage;

  public void checkPostDrawer() {
    spaceMembersPage.checkPostDrawer();
  }

  public void clickOnThreeDotsMenu() {
    spaceMembersPage.clickOnThreeDotsMenu();
  }

  public void setAsSpaceManager() {
    spaceMembersPage.setAsSpaceManager();
  }

  public void setRedactor() {
    spaceMembersPage.setRedactor();
  }

}
