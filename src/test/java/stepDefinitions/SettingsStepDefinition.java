package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import steps.SettingsSteps;

public class SettingsStepDefinition {

    @Steps
    private SettingsSteps settingsSteps;

    @When("^I click on Edit language and I change it '(.*)'$")
    public void tribeEditLanguage(String language) {
        settingsSteps.tribeEditLanguage(language);
    }

    @When("^I accept editing language$")
    public void tribeAcceptEditLanguage() {
        settingsSteps.tribeAcceptEditLanguage();
    }

    @When("^Edit button is displayed in Settings Agenda section$")
    public void editButtonInSettingsAgendaSectionIsDisplayed() {
        settingsSteps.editButtonInSettingsAgendaSectionIsDisplayed();
    }

    @When("^I click on Edit button in Settings Agenda section$")
    public void clickOnEditButtonInSettingsAgendaSection() {
        settingsSteps.clickOnEditButtonInSettingsAgendaSection();
    }

    @When("^I select '(.*)' as the default view in Agenda Preferences drawer$")
    public void selectDefaultViewAgendaPreferencesDrawer(String view) {
        settingsSteps.selectDefaultViewAgendaPreferencesDrawer(view);
    }

    @When("^I select '(.*)' as the week start day in Agenda Preferences drawer$")
    public void selectWeekStartOnAgendaPreferencesDrawer(String day) {
        settingsSteps.selectWeekStartOnAgendaPreferencesDrawer(day);
    }

    @When("^Agenda Preferences drawer is displayed$")
    public void isAgendaPreferencesDrawerTitleDisplayed() {
        settingsSteps.isAgendaPreferencesDrawerTitleDisplayed();
    }

    @When("^Agenda Preferences drawer is not displayed$")
    public void isAgendaPreferencesDrawerTitleNotDisplayed() {
        settingsSteps.isAgendaPreferencesDrawerTitleNotDisplayed();
    }

    @When("^The view '(.*)' is selected in Agenda Preferences drawer$")
    public void getTheDisplayedViewAgendaPreferencesDrawer(String view) {
        settingsSteps.getTheDisplayedViewAgendaPreferencesDrawer(view);
    }

    @When("^The week start day '(.*)' is selected in Agenda Preferences drawer$")
    public void getTheDisplayedWeekStartDayAgendaPreferencesDrawer(String day) {
        settingsSteps.getTheDisplayedWeekStartDayAgendaPreferencesDrawer(day);
    }

    @When("^Show working times is enabled in Agenda Preferences drawer$")
    public void showWorkingTimesIsEnabledInAgendaPreferencesDrawer() {
        settingsSteps.showWorkingTimesIsEnabledInAgendaPreferencesDrawer();
    }

    @When("^Show working times is disabled in Agenda Preferences drawer$")
    public void showWorkingTimesIsDisabledInAgendaPreferencesDrawer() {
        settingsSteps.showWorkingTimesIsDisabledInAgendaPreferencesDrawer();
    }

    @When("^I enable Show working times in Agenda Preferences drawer$")
    public void enableShowWorkingTimesInAgendaPreferencesDrawer() {
        settingsSteps.enableShowWorkingTimesInAgendaPreferencesDrawer();
    }

    @When("^Add Reminder button is displayed in Agenda Preferences drawer$")
    public void addReminderBtnIsDisplayedInAgendaPreferencesDrawer() {
        settingsSteps.addReminderBtnIsDisplayedInAgendaPreferencesDrawer();
    }

    @When("^Default Reminder close button is displayed in Agenda Preferences drawer$")
    public void defaultRemindersCloseBtnIsDisplayedInAgendaPreferencesDrawer() {
        settingsSteps.defaultRemindersCloseBtnIsDisplayedInAgendaPreferencesDrawer();
    }

    @When("^Cancel button is displayed in Agenda Preferences drawer$")
    public void cancelBtnIsDisplayedInAgendaPreferencesDrawer() {
        settingsSteps.cancelBtnIsDisplayedInAgendaPreferencesDrawer();
    }

    @When("^Save button is displayed in Agenda Preferences drawer$")
    public void saveBtnIsDisplayedInAgendaPreferencesDrawer() {
        settingsSteps.saveBtnIsDisplayedInAgendaPreferencesDrawer();
    }

    @When("^I click on Save button in Agenda Preferences drawer$")
    public void clickOnSaveBtnInAgendaPreferencesDrawer() {
        settingsSteps.clickOnSaveBtnInAgendaPreferencesDrawer();
    }

    @When("^I click on Cancel button in Agenda Preferences drawer$")
    public void clickOnCancelBtnInAgendaPreferencesDrawer() {
        settingsSteps.clickOnCancelBtnInAgendaPreferencesDrawer();
    }

    @When("^I click on Yes button to cancel changes in Agenda Preferences drawer$")
    public void clickOnYesBtnToCancelChangesInAgendaPreferencesDrawer() {
        settingsSteps.clickOnYesBtnToCancelChangesInAgendaPreferencesDrawer();
    }

    @When("^I click on No button to cancel changes in Agenda Preferences drawer$")
    public void clickOnNoBtnToCancelChangesInAgendaPreferencesDrawer() {
        settingsSteps.clickOnNoBtnToCancelChangesInAgendaPreferencesDrawer();
    }

    @When("^Cancel changes message is displayed in Agenda Preferences drawer$")
    public void isCancelChangesMessageDisplayedInAgendaPreferencesDrawer() {
        settingsSteps.isCancelChangesMessageDisplayedInAgendaPreferencesDrawer();
    }

    @When("^I cancel editing language$")
    public void tribeCancelEditLanguage() {
        settingsSteps.tribeCancelEditLanguage();
    }

    @Then("^Settings Page Is Opened$")
    public void checkThatSettingsPageIsOpened() {
        settingsSteps.checkThatSettingsPageIsOpened();
    }

    @When("^'(.*)' view, is displayed in Settings Agenda section$")
    public void viewLabelIsDisplayedInSettingsAgendaSection(String view) {
        settingsSteps.viewLabelIsDisplayedInSettingsAgendaSection(view);
    }

    @When("^Week starts on '(.*)', is displayed in Settings Agenda section$")
    public void weekStartsIsDisplayedInSettingsAgendaSection(String day) {
        settingsSteps.weekStartsIsDisplayedInSettingsAgendaSection(day);
    }

    @When("^Notify me '(.*)' minutes before the event starts, is displayed in Settings Agenda section$")
    public void notifyMeIsDisplayedInSettingsAgendaSection(String minutes) {
        settingsSteps.notifyMeIsDisplayedInSettingsAgendaSection(minutes);
    }

    @Then("^Notify me '(.*)' minutes before the event starts, is displayed in last position in Settings Agenda section$")
    public void notifyMeIsDisplayedInLastPositionInSettingsAgendaSection(String minutes) {
        settingsSteps.notifyMeIsDisplayedInLastPositionInSettingsAgendaSection(minutes);
    }

    @Then("^Working time from '(.*)' to '(.*)', is displayed in Settings Agenda section$")
    public void workingTimeInSettingsAgendaSection(String startTime, String endTime) {
        settingsSteps.workingTimeInSettingsAgendaSection(startTime, endTime);
    }

    @When("^I enter the old password and the new random password$")
    public void editWithRandomPassword() {
        String firstUserPassword = Serenity.sessionVariableCalled("firstUserPassword");
        String firstUserEditedPassword = "345678nBm";
        Serenity.setSessionVariable("firstUserEditedPassword").to(firstUserEditedPassword);
        settingsSteps.tribeEditPassword(firstUserPassword, firstUserEditedPassword);
    }

    @When("^I enter the edited password and the old password$")
    public void editWithFirstPassword() {
        String firstUserPassword = Serenity.sessionVariableCalled("firstUserPassword");
        String firstUserEditedPassword = Serenity.sessionVariableCalled("firstUserEditedPassword");
        settingsSteps.tribeEditPassword(firstUserEditedPassword, firstUserPassword);
    }

    @Then("^Language '(.*)' is displayed$")
    public void checkThatLanguageIsDisplayed(String language) {
        settingsSteps.checkThatLanguageIsDisplayed(language);
    }

    @When("^I click on Edit time zone and I change it '(.*)'$")
    public void tribeEditTimeZone(String timeZone) {
        settingsSteps.tribeEditTimeZone(timeZone);
    }

    @When("^I accept editing time zone$")
    public void tribeAcceptEditTimeZone() {
        settingsSteps.tribeAcceptEditTimeZone();
    }

    @When("^I cancel editing time zone$")
    public void tribeCancelEditTimeZone() {
        settingsSteps.tribeCancelEditTimeZone();
    }

    @Then("^Time zone '(.*)' is displayed$")
    public void checkThatTimeZoneIsDisplayed(String timeZone) {
        settingsSteps.checkThatTimeZoneIsDisplayed(timeZone);
    }

    @When("^I accept editing password$")
    public void tribeAcceptEditPassword() {
        settingsSteps.tribeAcceptEditPassword();
    }

    @When("^I cancel editing password$")
    public void tribeCancelEditPassword() {
        settingsSteps.tribeCancelEditPassword();
    }

    @When("^I enter the old password '(.*)' and the new password '(.*)'$")
    public void tribeEditPassword(String oldPassword, String password) {
        settingsSteps.tribeEditPassword(oldPassword, password);
    }

    @When("^I enable notification on Site$")
    @And("^I disable notification on Site$")
    public void tribeEnableDisableNotificationOnSite() {
        settingsSteps.tribeEnableDisableNotificationOnSite();
    }

    @Then("^Notification On Site is disabled$")
    public void chechThatNotificationOnSiteIsDisabled() {
        settingsSteps.chechThatNotificationOnSiteIsDisabled();
    }

    @Then("^Notification On Site is enabled$")
    public void chechThatNotificationOnSiteIsEnabled() {
        settingsSteps.chechThatNotificationOnSiteIsEnabled();
    }

    @When("^I enable notification on Mobile$")
    @And("^I disable notification on Mobile$")
    public void tribeEnableDisableNotificationOnMobile() {
        settingsSteps.tribeEnableDisableNotificationOnMobile();
    }

    @Then("^Notification On Mobile is disabled$")
    public void chechThatNotificationOnMobileIsDisabled() {
        settingsSteps.chechThatNotificationOnMobileIsDisabled();
    }

    @Then("^Notification On Mobile is enabled$")
    public void chechThatNotificationOnMobileIsEnabled() {
        settingsSteps.chechThatNotificationOnMobileIsEnabled();
    }

    @When("^I enable notification via Mail$")
    @And("^I disable notification via Mail$")
    public void tribeEnableDisableNotificationViaMail() {
        settingsSteps.tribeEnableDisableNotificationViaMail();
    }

    @Then("^Notification via Mail is disabled$")
    public void chechThatNotificationViaMailIsDisabled() {
        settingsSteps.chechThatNotificationViaMailIsDisabled();
    }

    @Then("^Notification via Mail is enabled$")
    public void chechThatNotificationViaMailIsEnabled() {
        settingsSteps.chechThatNotificationViaMailIsEnabled();
    }

    @Then("^General Notifications Sending Mail Type is Daily$")
    public void generalNotificationsSendingMailTypeIsDaily() {
        settingsSteps.generalNotificationsSendingMailTypeIsDaily();
    }

    @Then("^General Notifications Sending Mail Type is Weekly$")
    public void generalNotificationsSendingMailTypeIsWeekly() {
        settingsSteps.generalNotificationsSendingMailTypeIsWeekly();
    }

    @Then("^General Notifications Sending Mail Type is Never$")
    public void generalNotificationsSendingMailTypeIsNever() {
        settingsSteps.generalNotificationsSendingMailTypeIsNever();
    }

    @When("^I click on Edit General Notifications$")
    public void goToTribeEditGeneralNotifications() {
        settingsSteps.goToTribeEditGeneralNotifications();
    }

    @When("^I go to Manage Notifications$")
    public void goToManageNotifications() {
        settingsSteps.goToManageNotifications();
    }

    @When("^I confirm the modification of General Notifications$")
    public void tribeApplyEditGeneralNotifications() {
        settingsSteps.tribeApplyEditGeneralNotifications();
    }

    @When("^I select General Notifications Sending Mail Type '(.*)'$")
    public void selectSendMeASummaryEmail(String mailSendingType) {
        settingsSteps.selectSendMeASummaryEmail(mailSendingType);
    }

    @Then("^Daily Email is displayed in General Notifications Section$")
    public void dailyEmailIsDisplayedInGeneralNotificationsSection() {
        settingsSteps.dailyEmailIsDisplayedInGeneralNotificationsSection();
    }

    @Then("^Weekly Email is displayed in General Notifications Section$")
    public void weeklyEmailIsDisplayedInGeneralNotificationsSection() {
        settingsSteps.weeklyEmailIsDisplayedInGeneralNotificationsSection();
    }

    @Then("^No Email is displayed in General Notifications Section$")
    public void noEmailIsDisplayedInGeneralNotificationsSection() {
        settingsSteps.noEmailIsDisplayedInGeneralNotificationsSection();
    }

    @Then("^Notify Me By Email is displayed in General Notifications Section$")
    public void notifyMeByEmailIsDisplayedInGeneralNotificationsSection() {
        settingsSteps.notifyMeByEmailIsDisplayedInGeneralNotificationsSection();
    }

    @Then("^Notify Me On Mobile is displayed in General Notifications Section$")
    public void notifyMeOnMobileIsDisplayedInGeneralNotificationsSection() {
        settingsSteps.notifyMeOnMobileIsDisplayedInGeneralNotificationsSection();
    }

    @Then("^Notify Me On Site is displayed in General Notifications Section$")
    public void notifyMeOnSiteIsDisplayedInGeneralNotificationsSection() {
        settingsSteps.notifyMeOnSiteIsDisplayedInGeneralNotificationsSection();
    }

    @When("^I enable General notifications Via Mail$")
    @And("^I disable General notifications Via Mail$")
    public void tribeEnableDisableGeneralNotificationsViaMail() {
        settingsSteps.tribeEnableDisableGeneralNotificationsViaMail();

    }

    @When("^I enable General notifications On Site$")
    @And("^I disable General notifications On Site$")
    public void tribeEnableDisableGeneralNotificationsOnSite() {
        settingsSteps.tribeEnableDisableGeneralNotificationsOnSite();

    }

    @When("^I enable General notifications On Mobile$")
    @And("^I disable General notifications On Mobile$")
    public void tribeEnableDisableGeneralNotificationsOnMobile() {
        settingsSteps.tribeEnableDisableGeneralNotificationsOnMobile();

    }

    @Then("^Notify Me By Email is not displayed in General Notifications Section$")
    public void notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection() {
        settingsSteps.notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection();
    }

    @Then("^Notify Me On Mobile is not displayed in General Notifications Section$")
    public void notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection() {
        settingsSteps.notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection();
    }

    @Then("^Notify Me On Site is not displayed in General Notifications Section$")
    public void notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection() {
        settingsSteps.notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection();
    }

    @Then("^Manage Notification Page Is Opened$")
    public void checkThatManageNotificationPageIsOpened() {
        settingsSteps.checkThatManageNotificationPageIsOpened();
    }


    @And("^General section is displayed")
    public void checkThatGeneralSectionIsDisplayed() {
        settingsSteps.checkThatGeneralSectionIsDisplayed();
    }

    @And("^Connections section is displayed")
    public void checkThatConnectionsSectionIsDisplayed() {
        settingsSteps.checkThatConnectionsSectionIsDisplayed();
    }

    @And("^Spaces section is displayed")
    public void checkThatSpacesSectionIsDisplayed() {
        settingsSteps.checkThatSpacesSectionIsDisplayed();
    }

    @And("^Activity Stream section is displayed")
    public void checkThatActivityStreamSectionIsDisplayed() {
        settingsSteps.checkThatActivityStreamSectionIsDisplayed();
    }

    @And("^Document Sharing section is displayed")
    public void checkThatDocumentSharingSectionIsDisplayed() {
        settingsSteps.checkThatDocumentSharingSectionIsDisplayed();
    }

    @And("^News Notifications section is displayed")
    public void checkThatNewsNotificationsSectionIsDisplayed() {
        settingsSteps.checkThatNewsNotificationsSectionIsDisplayed();
    }

    @And("^My Tasks section is displayed")
    public void checkThatTasksSectionIsDisplayed() {
        settingsSteps.checkThatTasksSectionIsDisplayed();
    }

    @And("^Wallet section is displayed")
    public void checkThatWalletSectionIsDisplayed() {
        settingsSteps.checkThatWalletSectionIsDisplayed();
    }

    @And("^Kudos section is displayed")
    public void checkThatKudosSectionIsDisplayed() {
        settingsSteps.checkThatKudosSectionIsDisplayed();
    }

    @And("^Notes section is displayed")
    public void checkThatNotesSectionIsDisplayed() {
        settingsSteps.checkThatNotesSectionIsDisplayed();
    }

    @And("^Perk Store section is displayed")
    public void checkThatPerkStoreSectionIsDisplayed() {
        settingsSteps.checkThatPerkStoreSectionIsDisplayed();
    }

    @And("^Agenda Store section is displayed")
    public void checkThatAgendaSectionIsDisplayed() {
        settingsSteps.checkThatAgendaSectionIsDisplayed();
    }

    @And("^Chat Store section is displayed")
    public void checkThatChatSectionIsDisplayed() {
        settingsSteps.checkThatChatSectionIsDisplayed();
    }

}

