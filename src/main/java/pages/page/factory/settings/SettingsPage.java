package pages.page.factory.settings;

import elements.BaseElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.GenericPage;

import static com.openhtmltopdf.util.Util.sleep;
import static org.aspectj.bridge.MessageUtil.info;

public class SettingsPage extends GenericPage {
  public SettingsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "(//*[@class='uiIconEdit uiIconLightBlue pb-2'])[1]")
  private BaseElementFacade ELEMENT_EDIT_LANGUAGE;

  @FindBy(id = "UserSettingLanguage")
  private BaseElementFacade ELEMENT_SETTINGS_PAGE;

  @FindBy(xpath = "(//*[@id='AgendaSettingsApplication']//*[contains(@class,'uiIconEdit')])[1]")
  private BaseElementFacade settingsAgendaEditBtn;

  @FindBy(xpath = "(//*[@id='AgendaSettingsApplication']//*[contains(@class,'v-chip__content')])[1]")
  private BaseElementFacade settingsAgendaViewLabel;

  @FindBy(xpath = "//*[contains(@class,'popupTitle') and contains(text(),'Cancel changes')]/following::*[@class='v-card__text' and contains(text(),'Are you sure to cancel these changes?')]")
  private BaseElementFacade settingsAgendaCancelChangesMessage;

  @FindBy(xpath = "//*[contains(@class,'popupTitle') and contains(text(),'Cancel changes')]/following::button[contains(text(),'No')]")
  private BaseElementFacade settingsAgendaCancelChangesNoButton;

  @FindBy(xpath = "//*[contains(@class,'popupTitle') and contains(text(),'Cancel changes')]/following::button[contains(text(),'Yes')]")
  private BaseElementFacade settingsAgendaCancelChangesYesButton;

  @FindBy(xpath = "(//*[@id='AgendaSettingsApplication']//*[contains(@class,'v-chip__content')])[2]")
  private BaseElementFacade settingsAgendaWeekStartsOnLabel;

  @FindBy(xpath = "(//*[@id='AgendaSettingsApplication']//*[contains(@class,'v-chip__content')])[3]")
  private BaseElementFacade settingsAgendaNotifyMeBeforeTheEventStartsLabel;

  @FindBy(xpath = "(//*[@class='v-list-item__subtitle text-sub-title text-capitalize font-italic'])[1]")
  private BaseElementFacade ELEMENT_LANGUAGE_TXT;

  @FindBy(xpath = "(//*[@id='AgendaSettingsApplication']//*[contains(@class,'v-chip__content')])[3]")
  private BaseElementFacade settingsAgendaWorkingTimeLabel;

  @FindBy(xpath = "(//*[@id='AgendaSettingsApplication']//*[contains(@class,'v-chip__content')])[4]")
  private BaseElementFacade settingsAgendaNotifyMeLastPositionLabel;

  @FindBy(xpath = "(//*[@class='v-list-item__subtitle text-sub-title text-capitalize font-italic'])[2]")
  private BaseElementFacade ELEMENT_TIMEZONE_TXT;

  @FindBy(xpath = "(//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]")
  private BaseElementFacade ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON;

  private BaseElementFacade ELEMENT_CHANGE_LANGUAGE(String language) {
    return findByXpath(String.format("//*[contains(text(),'%s')]", language));
  }

  @FindBy(xpath = "(//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]")
  private BaseElementFacade ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON;

  @FindBy(xpath = "(//*[@class='uiIconEdit uiIconLightBlue pb-2'])[2]")
  private BaseElementFacade ELEMENT_EDIT_TIME_ZONE;

  @FindBy(xpath = "(//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]")
  private BaseElementFacade ELEMENT_DW_CANCEL_CHANGE_TIMEZONE_BUTTON;

  private BaseElementFacade ELEMENT_CHANGE_TIMEZONE(String timeZone) {
    return findByXpath(String.format("//*[contains(text(),'%s')]", timeZone));
  }

  @FindBy(xpath = "(//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default'])[2]")
  private BaseElementFacade ELEMENT_DW_APPLY_CHANGE_TIMEZONE_BUTTON;

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
  private BaseElementFacade ELEMENT_DIGITALWORKPLACE_MANAGE_NOTIFICATIONS;

  @FindBy(xpath = "//select[@name='EMAIL_DIGEST']")
  private BaseElementFacade ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE;

  @FindBy(xpath = "//*[contains(@class,'UserSettingAgendaDrawer ')]//*[contains(text(),'Week Start on:')]/following::*[contains(@class,'d-none d-sm-inline')][1]")
  private BaseElementFacade weekStartOnAgendaPreferencesDrawer;

  @FindBy(xpath = "//*[contains(@class,'UserSettingAgendaDrawer')]//*[contains(@class,'drawerTitle') and contains(text(),'Agenda Preferences')]")
  private BaseElementFacade agendaPreferencesDrawerTitle;

  @FindBy(xpath = "//*[contains(text(),'Show working times:')]/following::input[@type='checkbox' and @aria-checked='true'][1]/following::*[contains(@class,'v-input--selection-controls__ripple')]")
  private BaseElementFacade enabledShowWorkingTimesAgendaPreferencesDrawer;

  @FindBy(xpath = "//*[contains(text(),'Show working times:')]/following::input[@type='checkbox' and @aria-checked='false'][1]/following::*[contains(@class,'v-input--selection-controls__ripple')]")
  private BaseElementFacade disabledShowWorkingTimesAgendaPreferencesDrawer;

  @FindBy(xpath = "//*[contains(@class,'UserSettingAgendaDrawer ')]//*[contains(text(),'Default View:')]/following::*[contains(@class,'d-none d-sm-inline')][1]")
  private BaseElementFacade defaultViewAgendaPreferencesDrawer;

  @FindBy(xpath = "(//*[@class='v-list-item__content pa-0'])[1]")
  private BaseElementFacade ELEMENT_GENERAL_NOTIFICATIONS_SECTION;

  @FindBy(xpath = "(//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]")
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

  @FindBy(xpath = "(//*[contains(text(),'Document Sharing')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_DOCUMENTSHARING_SECTION;

  @FindBy(xpath = "(//*[contains(text(),'News Notifications')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_NEWSNOTIFICATIONS_SECTION;

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

  @FindBy(xpath = "(//div[@class='v-list-item__content']//*[contains(text(),'Agenda')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_AGENDA_SECTION;

  @FindBy(xpath = "(//div[@class='v-list-item__content']//*[contains(text(),'Chat')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_CHAT_SECTION;

  @FindBy(xpath = "//*[contains(@class,'UserSettingAgendaDrawer ')]//*[contains(text(),'Default reminders')]/following::*[contains(@class,'mdi-close')]")
  private BaseElementFacade defaultRemindersCloseBtn;

  @FindBy(xpath = "//*[contains(@class,'UserSettingAgendaDrawer ')]//*[contains(text(),'Default reminders')]/following::*[contains(@class,'add-notification-link')]")
  private BaseElementFacade addReminderBtn;

  @FindBy(xpath = "//*[contains(@class,'UserSettingAgendaDrawer ')]//*[contains(text(),'Cancel')]")
  private BaseElementFacade cancelAgendaPreferencesDrawerBtn;

  @FindBy(xpath = "//*[contains(@class,'UserSettingAgendaDrawer ')]//*[contains(text(),'Save')]")
  private BaseElementFacade saveAgendaPreferencesDrawerBtn;

  public void tribeEnableDisableGeneralNotificationsViaMail() {
    ELEMENT_GENERAL_NOTIFICATION_VIA_MAIL.clickOnElement();

  }

  public void tribeEnableDisableGeneralNotificationsOnSite() {
    ELEMENT_GENERAL_NOTIFICATION_ON_SITE.clickOnElement();

  }

  public void tribeEnableDisableGeneralNotificationsOnMobile() {
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

  public void selectDefaultViewAgendaPreferencesDrawer(String view) {
        defaultViewAgendaPreferencesDrawer.selectByVisibleText(view);
    }

  public void selectWeekStartOnAgendaPreferencesDrawer(String day) {
    weekStartOnAgendaPreferencesDrawer.selectByVisibleText(day);
  }

  public void getTheDisplayedViewAgendaPreferencesDrawer(String view) {
    Assert.assertTrue(defaultViewAgendaPreferencesDrawer.getTextContent().contains(view));
  }

  public void getTheDisplayedWeekStartDayAgendaPreferencesDrawer(String day) {
    Assert.assertTrue(weekStartOnAgendaPreferencesDrawer.getTextContent().contains(day));
  }

  public void showWorkingTimesIsEnabledInAgendaPreferencesDrawer() {
    enabledShowWorkingTimesAgendaPreferencesDrawer.isVisibleAfterWaiting();
  }

  public void showWorkingTimesIsDisabledInAgendaPreferencesDrawer() {
    disabledShowWorkingTimesAgendaPreferencesDrawer.isVisibleAfterWaiting();
  }

  public void enableShowWorkingTimesInAgendaPreferencesDrawer() {
    JavascriptExecutor executor = (JavascriptExecutor)	Serenity.getWebdriverManager().getCurrentDriver();
    executor.executeScript("arguments[0].click();", disabledShowWorkingTimesAgendaPreferencesDrawer);
  }

  public void addReminderBtnIsDisplayedInAgendaPreferencesDrawer() {
    addReminderBtn.isVisibleAfterWaiting();
  }

  public void defaultRemindersCloseBtnIsDisplayedInAgendaPreferencesDrawer() {
    defaultRemindersCloseBtn.isVisibleAfterWaiting();
  }

  public void cancelBtnIsDisplayedInAgendaPreferencesDrawer() {
    cancelAgendaPreferencesDrawerBtn.isVisibleAfterWaiting();
  }

  public void saveBtnIsDisplayedInAgendaPreferencesDrawer() {
    saveAgendaPreferencesDrawerBtn.isVisibleAfterWaiting();
  }

  public void clickOnSaveBtnInAgendaPreferencesDrawer() {
    saveAgendaPreferencesDrawerBtn.clickOnElement();
  }

  public void clickOnCancelBtnInAgendaPreferencesDrawer() {
    cancelAgendaPreferencesDrawerBtn.clickOnElement();
  }

  public void clickOnYesBtnToCancelChangesInAgendaPreferencesDrawer() {
    settingsAgendaCancelChangesYesButton.clickOnElement();
  }

  public void clickOnNoBtnToCancelChangesInAgendaPreferencesDrawer() {
    settingsAgendaCancelChangesNoButton.clickOnElement();
  }

  public void isCancelChangesMessageDisplayedInAgendaPreferencesDrawer() {
    settingsAgendaCancelChangesMessage.isVisibleAfterWaiting();
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

  public void tribeApplyEditGeneralNotifications() {
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
    DAILY, WEEKLY, NEVER

  }

  public void tribeEnableDisableNotificationViaMail() {
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    ELEMENT_NOTIFICATION_VIA_MAIL.waitUntilVisible();
    ELEMENT_NOTIFICATION_VIA_MAIL.waitUntilClickable();
    ELEMENT_NOTIFICATION_VIA_MAIL.click();

  }

  public void goToManageNotifications() {
    ELEMENT_DIGITALWORKPLACE_MANAGE_NOTIFICATIONS.waitUntilVisible();
    ELEMENT_DIGITALWORKPLACE_MANAGE_NOTIFICATIONS.waitUntilClickable();
    ELEMENT_DIGITALWORKPLACE_MANAGE_NOTIFICATIONS.clickOnElement();

  }

  public void editButtonInSettingsAgendaSectionIsDisplayed() {
    settingsAgendaEditBtn.isVisibleAfterWaiting();
  }

  public void clickOnEditButtonInSettingsAgendaSection() {
    settingsAgendaEditBtn.clickOnElement();
  }

  public void goToTribeEditGeneralNotifications() {
    JavascriptExecutor js = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();

    try {
      ELEMENT_EDIT_NOTIFICATIONS_GENERAL.waitUntilClickable();
      ELEMENT_EDIT_NOTIFICATIONS_GENERAL.clickOnElement();

    }catch(Exception ex){
      js.executeScript("arguments[0].click();",ELEMENT_EDIT_NOTIFICATIONS_GENERAL);
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


  public void tribeEnableDisableNotificationOnMobile() {
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

  public void tribeEnableDisableNotificationOnSite() {
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

  public void notifyMeIsDisplayedInSettingsAgendaSection(String minutes) {
    Assert.assertTrue(settingsAgendaNotifyMeBeforeTheEventStartsLabel.getTextContent().contains("Notify me " + minutes + " minutes before the event starts"));
  }

  public void viewLabelIsDisplayedInSettingsAgendaSection(String view) {
    Assert.assertTrue(settingsAgendaViewLabel.getTextContent().contains(view + " view"));
  }

  public void isAgendaPreferencesDrawerTitleDisplayed() {
    agendaPreferencesDrawerTitle.isVisibleAfterWaiting();
  }

  public void isAgendaPreferencesDrawerTitleNotDisplayed() {
    agendaPreferencesDrawerTitle.isNotVisibleAfterWaiting();
  }

  public void notifyMeIsDisplayedInLastPositionInSettingsAgendaSection(String minutes) {
    Assert.assertTrue(settingsAgendaNotifyMeLastPositionLabel.getTextContent().contains("Notify me " + minutes + " minutes before the event starts"));
  }

  public void workingTimeInSettingsAgendaSection(String startTime, String endTime) {
    Assert.assertTrue(settingsAgendaWorkingTimeLabel.getText().contains("Working time from " + startTime + " to " + endTime));
  }

  public void weekStartsIsDisplayedInSettingsAgendaSection(String day) {
    Assert.assertTrue(settingsAgendaWeekStartsOnLabel.getTextContent().contains("Week starts on " + day));
  }

  public void tribeEditPassword(String oldPassword, String password) {

    info("Go to Security Interface");
    ELEMENT_EDIT_PASSWORD.click();

    info("Enter the current password");
    ELEMENT_OLD_PASSWORD.sendKeys(oldPassword);

    info("Enter the new password");
    ELEMENT_NEW_PASSWORD.sendKeys(password);

    info("Confirm the new password");
    ELEMENT_NEW_PASSWORD_CONFIRM.sendKeys(password);

  }

  public void tribeEditLanguage(String language) {
    info("Select language and change it");
    ELEMENT_EDIT_LANGUAGE.waitUntilClickable();
    ELEMENT_EDIT_LANGUAGE.clickOnElement();

    ELEMENT_CHANGE_LANGUAGE(language).waitUntilClickable();
    ELEMENT_CHANGE_LANGUAGE(language).clickOnElement();

  }

  public void checkThatLanguageIsDisplayed(String language ) {
    info("Check that language is displayed");
    Assert.assertTrue(ELEMENT_LANGUAGE_TXT.getText().contains(language));

  }

  public void tribeCancelEditLanguage() {
    info("Cancel editing language");
    ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON.waitUntilClickable();
    ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON.clickOnElement();

  }

  public void checkThatSettingsPageIsOpened() {
    info("Check that Settings Page is opened");
    ELEMENT_SETTINGS_PAGE.isDisplayed();

  }


  public void tribeAcceptEditLanguage() {
    info("Accept editing language");
    ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON.waitUntilClickable();
    ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON.clickOnElement();

  }

  public void tribeCancelEditTimeZone() {
    info("Cancel editing time zone");
    ELEMENT_DW_CANCEL_CHANGE_TIMEZONE_BUTTON.waitUntilClickable();
    ELEMENT_DW_CANCEL_CHANGE_TIMEZONE_BUTTON.clickOnElement();

  }

  public void tribeAcceptEditTimeZone() {
    info("Accept editing time zone");
    ELEMENT_DW_APPLY_CHANGE_TIMEZONE_BUTTON.waitUntilClickable();
    ELEMENT_DW_APPLY_CHANGE_TIMEZONE_BUTTON.clickOnElement();

  }


  public void tribeCancelEditPassword() {
    info("Cancel editing password");
    ELEMENT_CANCEL_EDIT_PASSWORD.waitUntilClickable();
    ELEMENT_CANCEL_EDIT_PASSWORD.clickOnElement();

  }

  public void tribeAcceptEditPassword() {
    info("Accept editing password");
    ELEMENT_CONFIRM_EDIT_PASSWORD.waitUntilClickable();
    ELEMENT_CONFIRM_EDIT_PASSWORD.clickOnElement();

  }

  public void tribeEditTimeZone(String timeZone) {
    info("Select time zone and change it");
    ELEMENT_EDIT_TIME_ZONE.waitUntilClickable();
    ELEMENT_EDIT_TIME_ZONE.clickOnElement();

    ELEMENT_CHANGE_TIMEZONE(timeZone).waitUntilClickable();
    ELEMENT_CHANGE_TIMEZONE(timeZone).clickOnElement();

  }

  public void checkThatTimeZoneIsDisplayed(String timeZone ) {
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

  public void checkThatDocumentSharingSectionIsDisplayed() {
    info("Check that DocumentSharing Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_DOCUMENTSHARING_SECTION.isDisplayed();
  }

  public void checkThatNewsNotificationsSectionIsDisplayed() {
    info("Check that News Notifications Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_NEWSNOTIFICATIONS_SECTION.isDisplayed();
  }

  public void   checkThatTasksSectionIsDisplayed() {
    info("Check that Tasks Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_TASKS_SECTION.isDisplayed();
  }

  public void   checkThatWalletSectionIsDisplayed() {
    info("Check that Wallet Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_WALLET_SECTION.isDisplayed();
  }

  public void   checkThatKudosSectionIsDisplayed() {
    info("Check that Kudos Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_KUDOS_SECTION.isDisplayed();
  }

  public void   checkThatNotesSectionIsDisplayed() {
    info("Check that Notes Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_NOTES_SECTION.isDisplayed();
  }

  public void   checkThatPerkStoreSectionIsDisplayed() {
    info("Check that Perk Store Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_PERKSTORE_SECTION.isDisplayed();
  }

  public void   checkThatAgendaSectionIsDisplayed() {
    info("Check that Agenda Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_AGENDA_SECTION.isDisplayed();
  }

  public void   checkThatChatSectionIsDisplayed() {
    info("Check that Chat Section Is Displayed");
    ELEMENT_MANAGE_NOTIFICATION_CHAT_SECTION.isDisplayed();
  }


}
