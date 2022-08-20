package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.administration.AddGroupsPage;

public class AddGroupsSteps {

  private AddGroupsPage addGroupsPage;

  public void openGroup(String group) {
    addGroupsPage.openGroup(group);
  }

  public void selectGroup(String group) {
    addGroupsPage.selectGroup(group);
  }

  public void addMemberInGroup(String role, String member) {
    addGroupsPage.addMemberInGroup(role, member);
  }

}
