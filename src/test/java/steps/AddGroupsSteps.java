package steps;

import pages.page.factory.HomePage;
import pages.page.factory.administration.AddGroupsPage;

public class AddGroupsSteps {

    private AddGroupsPage addGroupsPage;
    private HomePage homePage;

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
