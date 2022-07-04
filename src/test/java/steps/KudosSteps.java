package steps;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.page.factory.HomePage;
import pages.page.factory.Kudos.KudosPage;
import pages.page.factory.people.UserProfile;

public class KudosSteps {
    private KudosPage kudosPage;
    private UserProfile userProfile;
    private HomePage homePage;


    public void goToKudosMenu() {
        kudosPage.goToKudosMenu();
    }


    public void enterKudosNumber(String val) {
        kudosPage.enterKudosNumber(val);
    }

    public void selectType() {
        kudosPage.selectType();
    }

    public void saveChanges() {
        kudosPage.saveChange();
    }

    public void checkKudosSettings(String val, String period) {
        kudosPage.checkKudosSettings(val, period);
    }

    public void sendMessage(String txt) {
        kudosPage.sendMessage(txt);
    }

    public void checkKudosIcon(String activityId) {
        kudosPage.checkKudosIcon(activityId);
    }

    public void threeDotsMenuSendKudos(String kudosMessage) {
        kudosPage.threeDotsMenuSendKudos();
        userProfile.sendKudos(kudosMessage);
    }

    public void SearchUserCard(String user) {
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        homePage.goToPeoplePage();
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        kudosPage.searchForUsersByName(user);
    }

    public void updateKudosMessage(String kudos) {
        kudosPage.updateKudosMessage(kudos);
    }

    public void addActivityCommentKudosFromDrawer(String kudos) {
        kudosPage.addActivityCommentKudosFromDrawer(kudos);
    }


    public void isKudosActivityVisible(String message) {
        kudosPage.isKudosActivityVisible(message);
    }

    public void editKudos() {
        kudosPage.editKudos();
    }

    public void clickEditKudos() { kudosPage.clickEditKudos(); }

    public void clickEditKudosFromReply() { kudosPage.clickEditKudosFromReply(); }

    public void updateKudosCommentMessage(String kudos) {
        kudosPage.updateKudosCommentMessage(kudos);
    }

}