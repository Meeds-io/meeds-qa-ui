package steps;

import pages.page.factory.HomePage;
import pages.page.factory.Social.SocialPage;

public class SocialSteps {
    private SocialPage socialpage;

    private HomePage homePage;

    public void commentActivity(String activity) {
        socialpage.CommentActivity(activity);
    }

    public void goToPeopleMenu() {
        socialpage.GoToPeopleMenu();

    }

    public void filterByMyConnections() {

        socialpage.filterByMyConnections();
    }

    public void insertNameContact(String contact) {
        socialpage.insertNameContact(contact);
    }

    public void editComment() {
        socialpage.editComment();
    }

    public void checkSearchedUserWellMatched(String user) {
        socialpage.checkSearchedUserWellMatched(user);
    }

    public void updateActivityComment(String comment) {
        socialpage.updateActivityComment(comment);
    }

    public void cancelUpdateActivityComment(String comment) {
        socialpage.cancelUpdateActivityComment(comment);
    }
}
