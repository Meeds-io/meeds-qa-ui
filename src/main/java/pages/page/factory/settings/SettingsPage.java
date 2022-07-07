package pages.page.factory.settings;

import static org.aspectj.bridge.MessageUtil.info;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class SettingsPage extends GenericPage {
    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//*[@class='uiIconEdit uiIconLightBlue pb-2'])[1]")
    private BaseElementFacade ELEMENT_EDIT_LANGUAGE;

    @FindBy(id = "UserSettingLanguage")
    private BaseElementFacade ELEMENT_SETTINGS_PAGE;

    @FindBy(xpath = "(//*[@class='v-list-item__subtitle text-sub-title text-capitalize font-italic'])[1]")
    private BaseElementFacade ELEMENT_LANGUAGE_TXT;

    @FindBy(xpath = "(//*[@class='v-list-item__subtitle text-sub-title text-capitalize font-italic'])[2]")
    private BaseElementFacade ELEMENT_TIMEZONE_TXT;

    @FindBy(
            xpath = "(//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]"
    )
    private BaseElementFacade ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON;

    private BaseElementFacade ELEMENT_CHANGE_LANGUAGE(String language) {
        return findByXpath(String.format("//*[contains(text(),'%s')]", language));
    }

    @FindBy(
            xpath = "(//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]"
    )
    private BaseElementFacade ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON;

    @FindBy(xpath = "(//*[@class='uiIconEdit uiIconLightBlue pb-2'])[2]")
    private BaseElementFacade ELEMENT_EDIT_TIME_ZONE;

    @FindBy(
            xpath = "(//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]"
    )
    private BaseElementFacade ELEMENT_CANCEL_CHANGE_TIMEZONE_BUTTON;

    private BaseElementFacade ELEMENT_CHANGE_TIMEZONE(String timeZone) {
        return findByXpath(String.format("//*[contains(text(),'%s')]", timeZone));
    }

    @FindBy(xpath = "(//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default'])[2]")
    private BaseElementFacade ELEMENT_APPLY_CHANGE_TIMEZONE_BUTTON;

    @FindBy(xpath = "//*[@class='v-list-item__action']//*[@data-original-title='Edit password']//button")
    private BaseElementFacade ELEMENT_EDIT_PASSWORD;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private BaseElementFacade ELEMENT_OLD_PASSWORD;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private BaseElementFacade ELEMENT_NEW_PASSWORD;

    @FindBy(xpath = "(//input[@type='password'])[3]")
    private BaseElementFacade ELEMENT_NEW_PASSWORD_CONFIRM;

    @FindBy(xpath = "(//input[@type='password'])[3]/following::*[@class='v-btn__content'][1]")
    private BaseElementFacade ELEMENT_CANCEL_EDIT_PASSWORD;

    @FindBy(xpath = "(//input[@type='password'])[3]/following::*[@class='v-btn__content'][2]")
    private BaseElementFacade ELEMENT_CONFIRM_EDIT_PASSWORD;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input'])[1]")
    private BaseElementFacade ELEMENT_NOTIFICATION_VIA_MAIL;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input']//input)[1]")
    private BaseElementFacade ELEMENT_NOTIFICATION_VIA_MAIL_STATUS;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input'])[2]")
    private BaseElementFacade ELEMENT_NOTIFICATION_ON_MOBILE;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input']//input)[2]")
    private BaseElementFacade ELEMENT_NOTIFICATION_ON_MOBILE_STATUS;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input'])[3]")
    private BaseElementFacade ELEMENT_NOTIFICATION_ON_SITE;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input']//input)[3]")
    private BaseElementFacade ELEMENT_NOTIFICATION_ON_SITE_STATUS;

    @FindBy(xpath = "(//*[@class='uiIconEdit uiIconLightBlue pb-2'])[1]")
    private BaseElementFacade ELEMENT_EDIT_NOTIFICATIONS_GENERAL;

    @FindBy(xpath = "(//*[@class='v-list-item__action'])[7]//button")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATIONS;

    @FindBy(xpath = "//select[@name='EMAIL_DIGEST']")
    private BaseElementFacade ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE;

    @FindBy(xpath = "(//*[@class='v-list-item__content pa-0'])[1]")
    private BaseElementFacade ELEMENT_GENERAL_NOTIFICATIONS_SECTION;

    @FindBy(
            xpath = "(//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]"
    )
    private BaseElementFacade ELEMENT_APPLY_EDIT_GENERAL_NOTIFICATIONS_BUTTON;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input'])[1]")
    private BaseElementFacade ELEMENT_GENERAL_NOTIFICATION_VIA_MAIL;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input'])[3]")
    private BaseElementFacade ELEMENT_GENERAL_NOTIFICATION_ON_SITE;

    @FindBy(xpath = "(//*[@class='v-input--selection-controls__input'])[2]")
    private BaseElementFacade ELEMENT_GENERAL_NOTIFICATION_ON_MOBILE;

    @FindBy(xpath = "(//*[contains(text(),'Manage notifications')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_PAGE;

    @FindBy(xpath = "(//*[contains(text(),'Connections')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_GENERAL_SECTION;

    @FindBy(xpath = "(//*[contains(text(),'Connections')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_CONNECTIONS_SECTION;

    @FindBy(xpath = "(//*[contains(text(),'Spaces')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_SPACES_SECTION;

    @FindBy(xpath = "(//*[contains(text(),'Activity Stream')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_ACTIVITYSTREAM_SECTION;

    @FindBy(xpath = "(//*[contains(text(),'My Tasks')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_TASKS_SECTION;

    @FindBy(xpath = "(//div[@class='v-list-item__content']//*[contains(text(),'Wallet')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_WALLET_SECTION;

    @FindBy(xpath = "(///div[@class='v-list-item__content']//*[contains(text(),'Kudos')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_KUDOS_SECTION;

    @FindBy(xpath = "(//div[@class='v-list-item__content']//*[contains(text(),'Notes')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_NOTES_SECTION;

    @FindBy(xpath = "(//*[contains(text(),'Perk store')]")
    private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_PERKSTORE_SECTION;

    public void enableDisableGeneralNotificationsViaMail() {
        ELEMENT_GENERAL_NOTIFICATION_VIA_MAIL.clickOnElement();

    }

    public void enableDisableGeneralNotificationsOnSite() {
        ELEMENT_GENERAL_NOTIFICATION_ON_SITE.clickOnElement();

    }

    public void enableDisableGeneralNotificationsOnMobile() {
        ELEMENT_GENERAL_NOTIFICATION_ON_MOBILE.clickOnElement();
    }

    public void notifyMeByEmailIsDisplayedInGeneralNotificationsSection() {
        info("Check that Notify Me By Email is displayed in General Notifications Section");
        Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me by email"));

    }

    public void notifyMeOnSiteIsDisplayedInGeneralNotificationsSection() {
        info("Check that Notify Me on Site is displayed in General Notifications Section");
        Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me on-site"));

    }

    public void notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection() {
        info("Check that Notify Me on Site is not displayed in General Notifications Section");
        Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me on-site"));

    }

    public void notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection() {
        info("Check that Notify Me By Email is not displayed in General Notifications Section");
        Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me by email"));

    }

    public void notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection() {
        info("Check that Notify Me On Mobile is not displayed in General Notifications Section");
        Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me on mobile"));
    }

    public void notifyMeOnMobileIsDisplayedInGeneralNotificationsSection() {
        info("Check that Notify Me On Mobile is displayed in General Notifications Section");
        Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me on mobile"));
    }

    public void dailyEmailIsDisplayedInGeneralNotificationsSection() {
        info("Check that Daily Email is displayed in General Notifications Section");
        Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Daily digest email notification"));
    }

    public void weeklyEmailIsDisplayedInGeneralNotificationsSection() {
        info("Check that Weeky Email is displayed in General Notifications Section");
        Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Weekly digest email notification"));
    }

    public void noEmailIsDisplayedInGeneralNotificationsSection() {
        info("Check that no Email is displayed in General Notifications Section");
        Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Daily digest email notification"));
        Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Weekly digest email notification"));
    }

    public void applyEditGeneralNotifications() {
        ELEMENT_APPLY_EDIT_GENERAL_NOTIFICATIONS_BUTTON.waitUntilClickable();
        ELEMENT_APPLY_EDIT_GENERAL_NOTIFICATIONS_BUTTON.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    }

    public void selectSendMeASummaryEmail(String mailSendingType) {

        switch (mailSendingType) {
            case "Daily":
                info("Select Daily");
                ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.selectByValue("Daily");
                break;
            case "Weekly":
                info("Select Weekly");
                ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.selectByValue("Weekly");
                break;
            case "Never":
                info("Select Never");
                ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.selectByValue("Never");
                break;
            default:
                info("Do nothing");
                break;

        }
    }

    public void generalNotificationsSendingMailTypeIsWeekly() {
        info("Check that General Notifications Sending Mail Type is Weekly");
        Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.getText().contains("Weekly"));

    }

    public void generalNotificationsSendingMailTypeIsDaily() {
        info("Check that General Notifications Sending Mail Type is Daily");
        Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.getText().contains("Daily"));

    }

    public void generalNotificationsSendingMailTypeIsNever() {
        info("Check that General Notifications Sending Mail Type is Never");
        Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.getText().contains("Never"));

    }

    public enum mailSendingType {
        DAILY,
        WEEKLY,
        NEVER

    }

    public void enableDisableNotificationViaMail() {
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        ELEMENT_NOTIFICATION_VIA_MAIL.waitUntilVisible();
        ELEMENT_NOTIFICATION_VIA_MAIL.waitUntilClickable();
        ELEMENT_NOTIFICATION_VIA_MAIL.click();

    }

    public void goToManageNotifications() {
        ELEMENT_MANAGE_NOTIFICATIONS.waitUntilVisible();
        ELEMENT_MANAGE_NOTIFICATIONS.waitUntilClickable();
        ELEMENT_MANAGE_NOTIFICATIONS.clickOnElement();

    }

    public void goToEditGeneralNotifications() {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();

        try {
            ELEMENT_EDIT_NOTIFICATIONS_GENERAL.waitUntilClickable();
            ELEMENT_EDIT_NOTIFICATIONS_GENERAL.clickOnElement();

        } catch (Exception ex) {
            js.executeScript("arguments[0].click();", ELEMENT_EDIT_NOTIFICATIONS_GENERAL);
        }

    }

    public void chechThatNotificationViaMailIsDisabled() {
        info("Notification Via Mail is disabled");

        Assert.assertTrue(ELEMENT_NOTIFICATION_VIA_MAIL_STATUS.getAttribute("aria-checked").contains("false"));

    }

    public void chechThatNotificationViaMailIsEnabled() {
        info("Notification Via Mail is enabled");
        Assert.assertEquals(ELEMENT_NOTIFICATION_VIA_MAIL_STATUS.waitUntilVisible().getAttribute("aria-checked"), "true");

    }

    public void enableDisableNotificationOnMobile() {
        ELEMENT_NOTIFICATION_ON_MOBILE.waitUntilClickable();
        ELEMENT_NOTIFICATION_ON_MOBILE.click();
        ELEMENT_NOTIFICATION_ON_MOBILE.waitUntilVisible();

    }

    public void chechThatNotificationOnMobileIsDisabled() {
        info("Notification On Mobile is disabled");
        Assert.assertEquals(ELEMENT_NOTIFICATION_ON_MOBILE_STATUS.waitUntilVisible().getAttribute("aria-checked"), "false");

    }

    public void chechThatNotificationOnMobileIsEnabled() {
        info("Notification On Mobile is enabled");
        Assert.assertEquals(ELEMENT_NOTIFICATION_ON_MOBILE_STATUS.waitUntilVisible().getAttribute("aria-checked"), "true");

    }

    public void enableDisableNotificationOnSite() {
        ELEMENT_NOTIFICATION_ON_SITE.waitUntilClickable();
        ELEMENT_NOTIFICATION_ON_SITE.click();
        ELEMENT_NOTIFICATION_ON_SITE.waitUntilVisible();

    }

    public void chechThatNotificationOnSiteIsDisabled() {
        info("Notification On Site is disabled");
        Assert.assertEquals(ELEMENT_NOTIFICATION_ON_SITE_STATUS.waitUntilVisible().getAttribute("aria-checked"), "false");

    }

    public void chechThatNotificationOnSiteIsEnabled() {
        info("Notification On Site is enabled");
        Assert.assertEquals(ELEMENT_NOTIFICATION_ON_SITE_STATUS.waitUntilVisible().getAttribute("aria-checked"), "true");

    }

    public void editPassword(String oldPassword, String password) {

        info("Go to Security Interface");
        ELEMENT_EDIT_PASSWORD.click();

        info("Enter the current password");
        ELEMENT_OLD_PASSWORD.sendKeys(oldPassword);

        info("Enter the new password");
        ELEMENT_NEW_PASSWORD.sendKeys(password);

        info("Confirm the new password");
        ELEMENT_NEW_PASSWORD_CONFIRM.sendKeys(password);

    }

    public void editLanguage(String language) {
        info("Select language and change it");
        ELEMENT_EDIT_LANGUAGE.waitUntilClickable();
        ELEMENT_EDIT_LANGUAGE.clickOnElement();

        ELEMENT_CHANGE_LANGUAGE(language).waitUntilClickable();
        ELEMENT_CHANGE_LANGUAGE(language).clickOnElement();

    }

    public void checkThatLanguageIsDisplayed(String language) {
        info("Check that language is displayed");
        Assert.assertTrue(ELEMENT_LANGUAGE_TXT.getText().contains(language));

    }

    public void cancelEditLanguage() {
        info("Cancel editing language");
        ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON.waitUntilClickable();
        ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON.clickOnElement();

    }

    public void checkThatSettingsPageIsOpened() {
        info("Check that Settings Page is opened");
        ELEMENT_SETTINGS_PAGE.isDisplayed();

    }

    public void acceptEditLanguage() {
        info("Accept editing language");
        ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON.waitUntilClickable();
        ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON.clickOnElement();

    }

    public void cancelEditTimeZone() {
        info("Cancel editing time zone");
        ELEMENT_CANCEL_CHANGE_TIMEZONE_BUTTON.waitUntilClickable();
        ELEMENT_CANCEL_CHANGE_TIMEZONE_BUTTON.clickOnElement();

    }

    public void acceptEditTimeZone() {
        info("Accept editing time zone");
        ELEMENT_APPLY_CHANGE_TIMEZONE_BUTTON.waitUntilClickable();
        ELEMENT_APPLY_CHANGE_TIMEZONE_BUTTON.clickOnElement();

    }

    public void cancelEditPassword() {
        info("Cancel editing password");
        ELEMENT_CANCEL_EDIT_PASSWORD.waitUntilClickable();
        ELEMENT_CANCEL_EDIT_PASSWORD.clickOnElement();

    }

    public void acceptEditPassword() {
        info("Accept editing password");
        ELEMENT_CONFIRM_EDIT_PASSWORD.waitUntilClickable();
        ELEMENT_CONFIRM_EDIT_PASSWORD.clickOnElement();

    }

    public void editTimeZone(String timeZone) {
        info("Select time zone and change it");
        ELEMENT_EDIT_TIME_ZONE.waitUntilClickable();
        ELEMENT_EDIT_TIME_ZONE.clickOnElement();

        ELEMENT_CHANGE_TIMEZONE(timeZone).waitUntilClickable();
        ELEMENT_CHANGE_TIMEZONE(timeZone).clickOnElement();

    }

    public void checkThatTimeZoneIsDisplayed(String timeZone) {
        info("Check that time zone is displayed");
        Assert.assertEquals(ELEMENT_TIMEZONE_TXT.getText(), timeZone);

    }

    public void checkThatManageNotificationPageIsOpened() {
        info("Check that Manage Notification Page is opened");
        ELEMENT_MANAGE_NOTIFICATION_PAGE.isDisplayed();
    }

    public void checkThatGeneralSectionIsDisplayed() {
        info("Check that General Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_GENERAL_SECTION.isDisplayed();
    }

    public void checkThatConnectionsSectionIsDisplayed() {
        info("Check that Connections Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_CONNECTIONS_SECTION.isDisplayed();
    }

    public void checkThatSpacesSectionIsDisplayed() {
        info("Check that Connections Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_SPACES_SECTION.isDisplayed();
    }

    public void checkThatActivityStreamSectionIsDisplayed() {
        info("Check that Activity Stream Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_ACTIVITYSTREAM_SECTION.isDisplayed();
    }

    public void checkThatTasksSectionIsDisplayed() {
        info("Check that Tasks Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_TASKS_SECTION.isDisplayed();
    }

    public void checkThatWalletSectionIsDisplayed() {
        info("Check that Wallet Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_WALLET_SECTION.isDisplayed();
    }

    public void checkThatKudosSectionIsDisplayed() {
        info("Check that Kudos Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_KUDOS_SECTION.isDisplayed();
    }

    public void checkThatNotesSectionIsDisplayed() {
        info("Check that Notes Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_NOTES_SECTION.isDisplayed();
    }

    public void checkThatPerkStoreSectionIsDisplayed() {
        info("Check that Perk Store Section Is Displayed");
        ELEMENT_MANAGE_NOTIFICATION_PERKSTORE_SECTION.isDisplayed();
    }

}
