package pages.page.factory.Kudos;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class KudosPage extends GenericPage {
    public KudosPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
    public BaseElementFacade menuBtn;

    @FindBy(xpath = "//i[contains(@class,'uiAdministrationIcon')]")
    private BaseElementFacade addministrationMenu;

    @FindBy(xpath = "//i[contains(@class,'uiIcon uiIconToolbarNavItem uiAdministrationIcon')]")
    private BaseElementFacade adminBtn;

    @FindBy(xpath = "//a[@href='/portal/g/:platform:rewarding/rewardAdministration/kudosAdministration']")
    private BaseElementFacade kudosLink;

    @FindBy(xpath = "//input[@name='kudosPerPeriod']")
    private TextBoxElementFacade kudosNumber;

    @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-menu-down theme--light']")
    private BaseElementFacade periodType;

    @FindBy(xpath = "//*[contains(text(),'Semester')]")
    private BaseElementFacade semesterPeriod;

    @FindBy(xpath = "//button[@class='btn btn-primary ignore-vuetify-classes mb-3']")
    private BaseElementFacade saveBtn;

    @FindBy(xpath = "(//*[@class='v-select__selections'])[1]")
    private BaseElementFacade displayedPeriodType;

    @FindBy(xpath = "//*[@id=\"kudosMessage\"]")
    private TextBoxElementFacade kudosMessage;

    @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
    private TextBoxElementFacade kudosField;

    @FindBy(xpath = "//span[@class='v-btn__content' and contains(text(),'Send')]")
    private BaseElementFacade kudosButtonInDrawer;

    @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[@class='v-btn__content'])[3]")
    private BaseElementFacade closeKudosDrawer;

    @FindBy(xpath = "(//*[@class='v-list-item__title peopleActionItem'])[2]")
    public static BaseElementFacade sendKudosMenu;

    @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
    private TextBoxElementFacade searchUsersField;

    @FindBy(xpath = "(//i[@class='v-icon notranslate icon-default-color fas fa-ellipsis-v theme--light'])[1]")
    private TextBoxElementFacade dotsMenu;

    @FindBy(xpath = "//i[@class='v-icon notranslate dark-grey-color fa fa-edit theme--light']")
    public static BaseElementFacade editButton;

    @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
    private BaseElementFacade ckEditorFrameKudos;

    @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
    private TextBoxElementFacade KudosField;

    @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]")
    private BaseElementFacade ckEditorFrameKudosFromDrawer;

    @FindBy(xpath = "//*[@data-cke-title='Rich Text Editor, kudosContent']/following::*[contains(@class,'cke_editable_themed')][1]")
    private TextBoxElementFacade kudosFieldFromDrawer;

    @FindBy(xpath = "//*[contains(@class,'v-card__actions')]//button[@aria-label='Update']")
    public static BaseElementFacade updateKudosButon;

    @FindBy(xpath = "//button[@class='ignore-vuetify-classes btn btn-primary me-3']")
    private BaseElementFacade sendKudosBtn;

    @FindBy(
            xpath = "//*[contains(@id,'Extactivity-content-extensions')]//*[@class='my-4']//*[contains(@class,'rich-editor-content')]//div"
    )
    private BaseElementFacade getKudosActivityText;

    @FindBy(
            xpath = "(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[2]"
    )
    private BaseElementFacade threedotsKudosComment;

    @FindBy(xpath = "//*[@class='v-list-item__title pl-3' and contains(text(),'Edit')]")
    private BaseElementFacade editKudosComment;

    @FindBy(xpath = "//*[@class='cke_inner cke_reset']")
    private BaseElementFacade kudosCommentFilled;

    @FindBy(xpath = "//*[@class='v-btn__content' and contains(text(),'Update')]")
    private BaseElementFacade updateKudosComment;

    @FindBy(
            xpath = "(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[3]"
    )
    private BaseElementFacade threedotsKudosReplyComment;

    private BaseElementFacade getKudosText(String kudos) {
        return findByXpath(String.format("//div[contains(@class,'contentBox')]//*[contains(text(),'%s')]", kudos));
    }

    private BaseElementFacade ELEMENT_kudos_LINK(String id) {
        return findByXpath(String.format("(//span[@class='mx-auto mt-1 mt-lg-0 ms-lg-2'])[3]", id));
    }

    public void addActivityKudos(String activityId, String comment) {
        ELEMENT_kudos_LINK(activityId).clickOnElement();
        ckEditorFrameKudos.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameKudos);
        kudosField.waitUntilVisible();
        kudosField.setTextValue(comment);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        kudosButtonInDrawer.isVisibleAfterWaiting();
        kudosButtonInDrawer.clickOnElement();
        ckEditorFrameKudos.isNotVisibleAfterWaiting();
    }

    private BaseElementFacade getLikeIcon(String activity) {
        return findByXpath(
                String.format("(//div[contains(text(),'%s')]//following::button[contains(@id,'LikeLink')])[1]", activity));
    }

    private BaseElementFacade getKudosiconsss(String activity) {
        return findByXpath(
                String.format("//i[contains(@class,'uiIconKudos')]", activity));
    }

    public void goToKudosMenu() {
        menuBtn.clickOnElement();
        addministrationMenu.clickOnElement();
        kudosLink.clickOnElement();
    }

    public void enterKudosNumber(String val) {
        kudosNumber.clickOnElement();
        kudosNumber.clear();
        kudosNumber.setTextValue(val);
    }

    public void selectType() {
        periodType.waitUntilVisible();
        periodType.clickOnElement();
        semesterPeriod.clickOnElement();

    }

    public void saveChange() {
        saveBtn.clickOnElement();
    }

    public void checkKudosSettings(String kudosNbr, String period) {

        Assert.assertTrue(kudosNumber.getTextValue().contains(kudosNbr));
        Assert.assertTrue(displayedPeriodType.getTextValue().contains(period));
    }

    public void sendMessage(String txt) {

        kudosMessage.setTextValue(txt);
        sendKudosBtn.clickOnElement();
    }

    public void checkKudosIcon(String activityId) {
        ELEMENT_kudos_LINK(activityId).isDisabled();
    }

    public void threeDotsMenuSendKudos() {
        sendKudosMenu.isVisibleAfterWaiting();
        sendKudosMenu.clickOnElement();

    }

    public void searchForUsersByName(String fullName) {
        searchUsersField.waitUntilVisible();
        searchUsersField.setTextValue(fullName);
    }

    public void editKudos() {
        dotsMenu.clickOnElement();
        editButton.clickOnElement();

    }

    public void updateKudosMessage(String comment) {

        ckEditorFrameKudos.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameKudos);
        KudosField.waitUntilVisible();
        KudosField.clear();
        KudosField.setTextValue(comment);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();

        updateKudosButon.clickOnElement();

    }

    public void isKudosActivityVisible(String message) {
        Assert.assertTrue(getKudosActivityText.getText().contains(message));
    }

    public void addActivityCommentKudos(String comment) {
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameKudos);
        kudosField.waitUntilVisible();
        kudosField.setTextValue(comment);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        kudosButtonInDrawer.isVisibleAfterWaiting();
        kudosButtonInDrawer.clickOnElement();
        ckEditorFrameKudos.isNotVisibleAfterWaiting();
    }

    public void addActivityCommentKudosFromDrawer(String comment) {
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameKudosFromDrawer);
        kudosFieldFromDrawer.waitUntilVisible();
        kudosFieldFromDrawer.setTextValue(comment);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        kudosButtonInDrawer.isVisibleAfterWaiting();
        kudosButtonInDrawer.clickOnElement();
        ckEditorFrameKudosFromDrawer.isNotVisibleAfterWaiting();
    }

    public void clickEditKudos() {
        threedotsKudosComment.clickOnElement();
        editKudosComment.clickOnElement();
    }

    public void clickEditKudosFromReply() {
        threedotsKudosReplyComment.clickOnElement();
        editKudosComment.clickOnElement();
    }

    public void updateKudosCommentMessage(String comment) {
        ckEditorFrameKudos.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameKudos);
        KudosField.waitUntilVisible();
        KudosField.clear();
        KudosField.setTextValue(comment);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        updateKudosComment.clickOnElement();
    }

}
