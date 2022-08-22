package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.NewComposer.RedactorRolePage;

public class RedactorRoleSteps {
  private RedactorRolePage redactorRolePage;

  public void checkPostDrawer() {
    redactorRolePage.checkPostDrawer();
  }

  public void setAsSpaceManager() {
    redactorRolePage.setAsSpaceManager();
  }

  public void setRedactor() {
    redactorRolePage.setRedactor();
  }

  public void ThreeDotsMenu() {
    redactorRolePage.ThreeDotsMenu();
  }

}
