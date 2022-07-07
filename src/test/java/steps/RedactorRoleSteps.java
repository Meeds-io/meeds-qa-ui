package steps;

import pages.page.factory.NewComposer.RedactorRolePage;

public class RedactorRoleSteps {
    private RedactorRolePage redactorRolePage;

    public void setRedactor() {
        redactorRolePage.setRedactor();
    }

    public void setAsSpaceManager() {
        redactorRolePage.setAsSpaceManager();
    }

    public void checkPostDrawer() {
        redactorRolePage.checkPostDrawer();
    }

    public void ThreeDotsMenu() {
        redactorRolePage.ThreeDotsMenu();
    }

}
