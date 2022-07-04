package steps;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.page.factory.HomePage;
import pages.page.factory.people.PeoplePage;
import pages.page.factory.settings.SettingsPage;

import static org.aspectj.bridge.MessageUtil.info;

public class SettingsSteps {

	private SettingsPage settingsPage;
	private HomePage homePage;

	public void tribeApplyEditGeneralNotifications() {
		settingsPage.tribeApplyEditGeneralNotifications();

	}

	public void notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection() {
		settingsPage.notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection();


	}

	public void notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection() {
		settingsPage.notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection();


	}

	public void notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection() {
		settingsPage.notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection();


	}

	public void tribeEnableDisableGeneralNotificationsViaMail() {
		settingsPage.tribeEnableDisableGeneralNotificationsViaMail();

	}

	public void tribeEnableDisableGeneralNotificationsOnSite() {
		settingsPage.tribeEnableDisableGeneralNotificationsOnSite();

	}

	public void tribeEnableDisableGeneralNotificationsOnMobile() {
		settingsPage.tribeEnableDisableGeneralNotificationsOnMobile();

	}

	public void notifyMeByEmailIsDisplayedInGeneralNotificationsSection() {
		settingsPage.notifyMeByEmailIsDisplayedInGeneralNotificationsSection();


	}

	public void notifyMeOnSiteIsDisplayedInGeneralNotificationsSection() {
		settingsPage.notifyMeOnSiteIsDisplayedInGeneralNotificationsSection();


	}

	public void notifyMeOnMobileIsDisplayedInGeneralNotificationsSection() {
		settingsPage.notifyMeOnMobileIsDisplayedInGeneralNotificationsSection();


	}

	public void dailyEmailIsDisplayedInGeneralNotificationsSection() {
		settingsPage.dailyEmailIsDisplayedInGeneralNotificationsSection();

	}

	public void weeklyEmailIsDisplayedInGeneralNotificationsSection() {
		settingsPage.weeklyEmailIsDisplayedInGeneralNotificationsSection();

	}

	public void noEmailIsDisplayedInGeneralNotificationsSection() {
		settingsPage.noEmailIsDisplayedInGeneralNotificationsSection();

	}

	public void selectSendMeASummaryEmail(String mailSendingType) {
		settingsPage.selectSendMeASummaryEmail(mailSendingType);

	}

	public void goToManageNotifications() {
		settingsPage.goToManageNotifications();

	}

	public void goToTribeEditGeneralNotifications() {
		settingsPage.goToTribeEditGeneralNotifications();

	}

	public void generalNotificationsSendingMailTypeIsWeekly() {
		settingsPage.generalNotificationsSendingMailTypeIsWeekly();


	}

	public void generalNotificationsSendingMailTypeIsDaily() {
		settingsPage.generalNotificationsSendingMailTypeIsDaily();


	}

	public void generalNotificationsSendingMailTypeIsNever() {
		settingsPage.generalNotificationsSendingMailTypeIsNever();


	}

	public void tribeEditLanguage(String language) {
  settingsPage.tribeEditLanguage(language);

	}

	public void tribeCancelEditLanguage() {
		settingsPage.tribeCancelEditLanguage();

	}

	public void tribeAcceptEditLanguage() {
		settingsPage.tribeAcceptEditLanguage();

	}

	public void checkThatLanguageIsDisplayed(String language ) {
		settingsPage.checkThatLanguageIsDisplayed(language);

	}

	public void editButtonInSettingsAgendaSectionIsDisplayed() {
		settingsPage.editButtonInSettingsAgendaSectionIsDisplayed();
	}

	public void clickOnEditButtonInSettingsAgendaSection() {
		settingsPage.clickOnEditButtonInSettingsAgendaSection();
	}

	public void selectDefaultViewAgendaPreferencesDrawer(String view) {
		settingsPage.selectDefaultViewAgendaPreferencesDrawer(view);
	}

	public void selectWeekStartOnAgendaPreferencesDrawer(String day) {
		settingsPage.selectWeekStartOnAgendaPreferencesDrawer(day);
	}

	public void isAgendaPreferencesDrawerTitleDisplayed() {
		settingsPage.isAgendaPreferencesDrawerTitleDisplayed();
	}

	public void isAgendaPreferencesDrawerTitleNotDisplayed() {
		settingsPage.isAgendaPreferencesDrawerTitleNotDisplayed();
	}

	public void getTheDisplayedViewAgendaPreferencesDrawer(String view) {
		settingsPage.getTheDisplayedViewAgendaPreferencesDrawer(view);
	}

	public void getTheDisplayedWeekStartDayAgendaPreferencesDrawer(String day) {
		settingsPage.getTheDisplayedWeekStartDayAgendaPreferencesDrawer(day);
	}

	public void showWorkingTimesIsEnabledInAgendaPreferencesDrawer() {
		settingsPage.showWorkingTimesIsEnabledInAgendaPreferencesDrawer();
	}

	public void showWorkingTimesIsDisabledInAgendaPreferencesDrawer() {
		settingsPage.showWorkingTimesIsDisabledInAgendaPreferencesDrawer();
	}

	public void enableShowWorkingTimesInAgendaPreferencesDrawer() {
		settingsPage.enableShowWorkingTimesInAgendaPreferencesDrawer();
	}

	public void addReminderBtnIsDisplayedInAgendaPreferencesDrawer() {
		settingsPage.addReminderBtnIsDisplayedInAgendaPreferencesDrawer();
	}

	public void defaultRemindersCloseBtnIsDisplayedInAgendaPreferencesDrawer() {
		settingsPage.defaultRemindersCloseBtnIsDisplayedInAgendaPreferencesDrawer();
	}

	public void cancelBtnIsDisplayedInAgendaPreferencesDrawer() {
		settingsPage.cancelBtnIsDisplayedInAgendaPreferencesDrawer();
	}

	public void saveBtnIsDisplayedInAgendaPreferencesDrawer() {
		settingsPage.saveBtnIsDisplayedInAgendaPreferencesDrawer();
	}

	public void clickOnSaveBtnInAgendaPreferencesDrawer() {
		settingsPage.clickOnSaveBtnInAgendaPreferencesDrawer();
	}

	public void clickOnCancelBtnInAgendaPreferencesDrawer() {
		settingsPage.clickOnCancelBtnInAgendaPreferencesDrawer();
	}

	public void clickOnYesBtnToCancelChangesInAgendaPreferencesDrawer() {
		settingsPage.clickOnYesBtnToCancelChangesInAgendaPreferencesDrawer();
	}

	public void clickOnNoBtnToCancelChangesInAgendaPreferencesDrawer() {
		settingsPage.clickOnNoBtnToCancelChangesInAgendaPreferencesDrawer();
	}

	public void isCancelChangesMessageDisplayedInAgendaPreferencesDrawer() {
		settingsPage.isCancelChangesMessageDisplayedInAgendaPreferencesDrawer();
	}

	public void notifyMeIsDisplayedInSettingsAgendaSection(String minutes) {
		settingsPage.notifyMeIsDisplayedInSettingsAgendaSection(minutes);
	}

	public void viewLabelIsDisplayedInSettingsAgendaSection(String view) {
		settingsPage.viewLabelIsDisplayedInSettingsAgendaSection(view);
	}

	public void notifyMeIsDisplayedInLastPositionInSettingsAgendaSection(String minutes) {
		settingsPage.notifyMeIsDisplayedInLastPositionInSettingsAgendaSection(minutes);
	}

	public void workingTimeInSettingsAgendaSection(String startTime, String endTime) {
		settingsPage.workingTimeInSettingsAgendaSection(startTime, endTime);
	}

	public void weekStartsIsDisplayedInSettingsAgendaSection(String day) {
		settingsPage.weekStartsIsDisplayedInSettingsAgendaSection(day);
	}

	public void checkThatSettingsPageIsOpened() {
		settingsPage.checkThatSettingsPageIsOpened();

	}

	public void tribeEditTimeZone(String timeZone) {
		settingsPage.tribeEditTimeZone(timeZone);

	}

	public void tribeCancelEditTimeZone() {
		settingsPage.tribeCancelEditTimeZone();

	}

	public void tribeAcceptEditTimeZone() {
		settingsPage.tribeAcceptEditTimeZone();

	}

	public void checkThatTimeZoneIsDisplayed(String timeZone ) {
		settingsPage.checkThatTimeZoneIsDisplayed(timeZone);

	}

	public void tribeCancelEditPassword() {
		settingsPage.tribeCancelEditPassword();

	}

	public void tribeAcceptEditPassword() {
		settingsPage.tribeAcceptEditPassword();

	}

	public void tribeEditPassword(String oldPassword, String password) {
		settingsPage.tribeEditPassword(oldPassword,password);

	}

	public void tribeEnableDisableNotificationViaMail() {
   settingsPage.tribeEnableDisableNotificationViaMail();

	}

	public void chechThatNotificationViaMailIsDisabled() {
	 settingsPage.chechThatNotificationViaMailIsDisabled();

	}

	public void chechThatNotificationViaMailIsEnabled() {
		settingsPage.chechThatNotificationViaMailIsEnabled();

	}

	public void tribeEnableDisableNotificationOnMobile() {
		settingsPage.tribeEnableDisableNotificationOnMobile();

	}

	public void chechThatNotificationOnMobileIsDisabled() {
		settingsPage.chechThatNotificationOnMobileIsDisabled();

	}

	public void chechThatNotificationOnMobileIsEnabled() {
		settingsPage.chechThatNotificationOnMobileIsEnabled();

	}

	public void tribeEnableDisableNotificationOnSite() {
		settingsPage.tribeEnableDisableNotificationOnSite();

	}

	public void chechThatNotificationOnSiteIsDisabled() {
		settingsPage.chechThatNotificationOnSiteIsDisabled();

	}

	public void chechThatNotificationOnSiteIsEnabled() {
		settingsPage.chechThatNotificationOnSiteIsEnabled();

	}

	public void checkThatManageNotificationPageIsOpened() {
		settingsPage.checkThatManageNotificationPageIsOpened();

	}

	public void checkThatGeneralSectionIsDisplayed() {
		settingsPage.checkThatGeneralSectionIsDisplayed();

	}

	public void checkThatConnectionsSectionIsDisplayed() {
		settingsPage.checkThatConnectionsSectionIsDisplayed();

	}

	public void checkThatSpacesSectionIsDisplayed() {
		settingsPage.checkThatSpacesSectionIsDisplayed();

	}

	public void checkThatActivityStreamSectionIsDisplayed() {
		settingsPage.checkThatActivityStreamSectionIsDisplayed();

	}

	public void checkThatDocumentSharingSectionIsDisplayed() {
		settingsPage.checkThatDocumentSharingSectionIsDisplayed();

	}

	public void checkThatNewsNotificationsSectionIsDisplayed() {
		settingsPage.checkThatNewsNotificationsSectionIsDisplayed();

	}

	public void checkThatTasksSectionIsDisplayed() {
		settingsPage.checkThatTasksSectionIsDisplayed();

	}

	public void checkThatWalletSectionIsDisplayed() {
		settingsPage.checkThatWalletSectionIsDisplayed();

	}

	public void checkThatKudosSectionIsDisplayed() {
		settingsPage.checkThatKudosSectionIsDisplayed();

	}

	public void checkThatNotesSectionIsDisplayed() {
		settingsPage.checkThatNotesSectionIsDisplayed();

	}

	public void checkThatPerkStoreSectionIsDisplayed() {
		settingsPage.checkThatPerkStoreSectionIsDisplayed();

	}

	public void checkThatAgendaSectionIsDisplayed() {
		settingsPage.checkThatAgendaSectionIsDisplayed();

	}

	public void checkThatChatSectionIsDisplayed() {
		settingsPage.checkThatChatSectionIsDisplayed();

	}
}
