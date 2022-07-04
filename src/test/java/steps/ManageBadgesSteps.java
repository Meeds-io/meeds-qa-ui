package steps;

import net.serenitybdd.core.Serenity;
import pages.page.factory.administration.ManageBadgesPage;

public class ManageBadgesSteps {

    private ManageBadgesPage manageBadgesPage;

    public void goToManageBadgesMenu() {
        manageBadgesPage.goToManageBadgesMenu();

    }

    public void isSuccessAlertDisplayed(String message) {
        manageBadgesPage.isSuccessAlertDisplayed(message);

    }

    public void addBadge(String name, String description, String score, String icon, String domain) {
        manageBadgesPage.clickOnAddBadge();
        manageBadgesPage.fillForm(name, description, score, icon, domain);

    }

    public void clickOnEditBadge(String badgeName) {
        manageBadgesPage.clickOnEditBadge(badgeName);

    }

    public void confirmDeletionBadge() {
        manageBadgesPage.confirmDeletionBadge();


    }

    public void clickOnDeleteBadge(String badgeName) {
        manageBadgesPage.clickOnDeleteBadge(badgeName);

    }

    public void editBadgeName(String name) {
        manageBadgesPage.editBadgeName(name);

    }

    public void editBadgeDescription(String description) {
        manageBadgesPage.editBadgeDescription(description);

    }

    public void editBadgeScore(String score) {
        manageBadgesPage.editBadgeScore(score);

    }


    public void editBadgeDomain(String domain) {
        manageBadgesPage.editBadgeDomain(domain);

    }

    public void confirmEditBadge() {
        manageBadgesPage.confirmEditBadge();

    }

    public void insertBadgeNameInSearchField(String badgeName) {
        manageBadgesPage.insertBadgeNameInSearchField(badgeName);

    }

    public void isBadgeDisplayedWithEnabledStatus(String badgeName, String badgeDescription, String badgeScore, String badgeDomain) {
        manageBadgesPage.isBadgeDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

    }

    public void isBadgeNotDisplayedWithEnabledStatus(String badgeName, String badgeDescription, String badgeScore, String badgeDomain) {
        manageBadgesPage.isBadgeNotDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

    }

    public void confirmAdditionNewBadge() {
        manageBadgesPage.confirmAdditionNewBadge();

    }

}
