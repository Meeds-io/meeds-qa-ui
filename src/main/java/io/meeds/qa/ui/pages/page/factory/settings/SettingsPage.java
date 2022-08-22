package io.meeds.qa.ui.pages.page.factory.settings;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SettingsPage extends GenericPage {
  @FindBy(
      xpath = "(//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]"
  )
  private BaseElementFacade ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON;

  @FindBy(xpath = "(//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default'])[2]")
  private BaseElementFacade ELEMENT_APPLY_CHANGE_TIMEZONE_BUTTON;

  @FindBy(
      xpath = "(//button[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]"
  )
  private BaseElementFacade ELEMENT_APPLY_EDIT_GENERAL_NOTIFICATIONS_BUTTON;

  @FindBy(
      xpath = "(//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]"
  )
  private BaseElementFacade ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON;

  @FindBy(
      xpath = "(//button[@class='btn me-2 v-btn v-btn--contained theme--light v-size--default']//*[@class='v-btn__content'])[1]"
  )
  private BaseElementFacade ELEMENT_CANCEL_CHANGE_TIMEZONE_BUTTON;

  @FindBy(xpath = "(//input[@type='password'])[3]/following::*[@class='v-btn__content'][1]")
  private BaseElementFacade ELEMENT_CANCEL_EDIT_PASSWORD;

  @FindBy(xpath = "(//input[@type='password'])[3]/following::*[@class='v-btn__content'][2]")
  private BaseElementFacade ELEMENT_CONFIRM_EDIT_PASSWORD;

  @FindBy(xpath = "(//*[@class='uiIconEdit uiIconLightBlue pb-2'])[1]")
  private BaseElementFacade ELEMENT_EDIT_NOTIFICATIONS_GENERAL;

  @FindBy(xpath = "//*[@class='v-list-item__action']//*[@data-original-title='Edit password']//button")
  private BaseElementFacade ELEMENT_EDIT_PASSWORD;

  @FindBy(xpath = "(//*[@class='uiIconEdit uiIconLightBlue pb-2'])[2]")
  private BaseElementFacade ELEMENT_EDIT_TIME_ZONE;

  @FindBy(xpath = "(//*[@class='v-list-item__content pa-0'])[1]")
  private BaseElementFacade ELEMENT_GENERAL_NOTIFICATIONS_SECTION;

  @FindBy(xpath = "//select[@name='EMAIL_DIGEST']")
  private BaseElementFacade ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE;

  @FindBy(xpath = "(//*[@class='v-list-item__subtitle text-sub-title text-capitalize font-italic'])[1]")
  private BaseElementFacade ELEMENT_LANGUAGE_TXT;

  @FindBy(xpath = "(//*[contains(text(),'Activity Stream')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_ACTIVITYSTREAM_SECTION;

  @FindBy(xpath = "(//*[contains(text(),'Connections')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_CONNECTIONS_SECTION;

  @FindBy(xpath = "(//*[contains(text(),'Connections')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_GENERAL_SECTION;

  @FindBy(xpath = "(///div[@class='v-list-item__content']//*[contains(text(),'Kudos')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_KUDOS_SECTION;

  @FindBy(xpath = "(//div[@class='v-list-item__content']//*[contains(text(),'Notes')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_NOTES_SECTION;

  @FindBy(xpath = "(//*[contains(text(),'Manage notifications')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_PAGE;

  @FindBy(xpath = "(//*[contains(text(),'Perk store')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_PERKSTORE_SECTION;

  @FindBy(xpath = "(//*[contains(text(),'Spaces')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_SPACES_SECTION;

  @FindBy(xpath = "(//*[contains(text(),'My Tasks')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_TASKS_SECTION;

  @FindBy(xpath = "(//div[@class='v-list-item__content']//*[contains(text(),'Wallet')]")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATION_WALLET_SECTION;

  @FindBy(xpath = "(//*[@class='v-list-item__action'])[7]//button")
  private BaseElementFacade ELEMENT_MANAGE_NOTIFICATIONS;

  @FindBy(xpath = "(//input[@type='password'])[2]")
  private BaseElementFacade ELEMENT_NEW_PASSWORD;

  @FindBy(xpath = "(//input[@type='password'])[3]")
  private BaseElementFacade ELEMENT_NEW_PASSWORD_CONFIRM;

  @FindBy(xpath = "(//input[@type='password'])[1]")
  private BaseElementFacade ELEMENT_OLD_PASSWORD;

  @FindBy(xpath = "(//*[@class='v-list-item__subtitle text-sub-title text-capitalize font-italic'])[2]")
  private BaseElementFacade ELEMENT_TIMEZONE_TXT;

  public SettingsPage(WebDriver driver) {
    super(driver);
  }

  public void acceptEditLanguage() {
    // Accept editing language
    ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON.waitUntilClickable();
    ELEMENT_APPLY_CHANGE_LANGUAGE_BUTTON.clickOnElement();

  }

  public void acceptEditPassword() {
    // Accept editing password
    ELEMENT_CONFIRM_EDIT_PASSWORD.waitUntilClickable();
    ELEMENT_CONFIRM_EDIT_PASSWORD.clickOnElement();

  }

  public void acceptEditTimeZone() {
    // Accept editing time zone
    ELEMENT_APPLY_CHANGE_TIMEZONE_BUTTON.waitUntilClickable();
    ELEMENT_APPLY_CHANGE_TIMEZONE_BUTTON.clickOnElement();

  }

  public void applyEditGeneralNotifications() {
    ELEMENT_APPLY_EDIT_GENERAL_NOTIFICATIONS_BUTTON.waitUntilClickable();
    ELEMENT_APPLY_EDIT_GENERAL_NOTIFICATIONS_BUTTON.clickOnElement();
    driver.navigate().refresh();
  }

  public void cancelEditLanguage() {
    // Cancel editing language
    ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON.waitUntilClickable();
    ELEMENT_CANCEL_CHANGE_LANGUAGE_BUTTON.clickOnElement();

  }

  public void cancelEditPassword() {
    // Cancel editing password
    ELEMENT_CANCEL_EDIT_PASSWORD.waitUntilClickable();
    ELEMENT_CANCEL_EDIT_PASSWORD.clickOnElement();

  }

  public void cancelEditTimeZone() {
    // Cancel editing time zone
    ELEMENT_CANCEL_CHANGE_TIMEZONE_BUTTON.waitUntilClickable();
    ELEMENT_CANCEL_CHANGE_TIMEZONE_BUTTON.clickOnElement();

  }

  public void checkThatActivityStreamSectionIsDisplayed() {
    // Check that Activity Stream Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_ACTIVITYSTREAM_SECTION);
  }

  public void checkThatConnectionsSectionIsDisplayed() {
    // Check that Connections Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_CONNECTIONS_SECTION);
  }

  public void checkThatGeneralSectionIsDisplayed() {
    // Check that General Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_GENERAL_SECTION);
  }

  public void checkThatKudosSectionIsDisplayed() {
    // Check that Kudos Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_KUDOS_SECTION);
  }

  public void checkThatLanguageIsDisplayed(String language) {
    // Check that language is displayed
    Assert.assertTrue(ELEMENT_LANGUAGE_TXT.getText().contains(language));
  }

  public void checkThatManageNotificationPageIsOpened() {
    // Check that Manage Notification Page is opened
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_PAGE);
  }

  public void checkThatNotesSectionIsDisplayed() {
    // Check that Notes Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_NOTES_SECTION);
  }

  public void checkThatNotificationOnMobileIsDisabled() {
    // Notification On Mobile is disabled
    Assert.assertEquals(findByXPathOrCSS("(//*[@class='v-input--selection-controls__input']//input)[2]").getAttribute("aria-checked"),
                        "false");

  }

  public void checkThatNotificationOnMobileIsEnabled() {
    // Notification On Mobile is enabled
    Assert.assertEquals(findByXPathOrCSS("(//*[@class='v-input--selection-controls__input']//input)[2]").getAttribute("aria-checked"),
                        "true");

  }

  public void checkThatNotificationOnSiteIsDisabled() {
    // Notification On Site is disabled
    Assert.assertEquals(findByXPathOrCSS("(//*[@class='v-input--selection-controls__input']//input)[3]").getAttribute("aria-checked"),
                        "false");

  }

  public void checkThatNotificationOnSiteIsEnabled() {
    // Notification On Site is enabled
    Assert.assertEquals(findByXPathOrCSS("(//*[@class='v-input--selection-controls__input']//input)[3]").getAttribute("aria-checked"),
                        "true");

  }

  public void checkThatNotificationViaMailIsDisabled() {
    // Notification Via Mail is disabled
    Assert.assertTrue(findByXPathOrCSS("(//*[@class='v-input--selection-controls__input']//input)[1]").getAttribute("aria-checked")
                                                                                                      .contains("false"));
  }

  public void checkThatNotificationViaMailIsEnabled() {
    // Notification Via Mail is enabled
    Assert.assertEquals(findByXPathOrCSS("(//*[@class='v-input--selection-controls__input']//input)[1]").getAttribute("aria-checked"),
                        "true");

  }

  public void checkThatPerkStoreSectionIsDisplayed() {
    // Check that Perk Store Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_PERKSTORE_SECTION);
  }

  public void checkThatSettingsPageIsOpened() {
    // Check that Settings Page is opened
    assertWebElementVisible(findByXPathOrCSS("#UserSettingLanguage"));
  }

  public void checkThatSpacesSectionIsDisplayed() {
    // Check that Connections Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_SPACES_SECTION);
  }

  public void checkThatTasksSectionIsDisplayed() {
    // Check that Tasks Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_TASKS_SECTION);
  }

  public void checkThatTimeZoneIsDisplayed(String timeZone) {
    // Check that time zone is displayed
    Assert.assertEquals(ELEMENT_TIMEZONE_TXT.getText(), timeZone);

  }

  public void checkThatWalletSectionIsDisplayed() {
    // Check that Wallet Section Is Displayed
    assertWebElementVisible(ELEMENT_MANAGE_NOTIFICATION_WALLET_SECTION);
  }

  public void dailyEmailIsDisplayedInGeneralNotificationsSection() {
    // Check that Daily Email is displayed in General Notifications Section
    Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Daily digest email notification"));
  }

  public void editLanguage(String language) {
    // Select language and change it
    findByXPathOrCSS("#UserSettingLanguage button").clickOnElement();

    ELEMENT_CHANGE_LANGUAGE(language).waitUntilClickable();
    ELEMENT_CHANGE_LANGUAGE(language).clickOnElement();

  }

  public void editPassword(String oldPassword, String password) {

    // Go to Security Interface
    ELEMENT_EDIT_PASSWORD.click();

    // Enter the current password
    ELEMENT_OLD_PASSWORD.sendKeys(oldPassword);

    // Enter the new password
    ELEMENT_NEW_PASSWORD.sendKeys(password);

    // Confirm the new password
    ELEMENT_NEW_PASSWORD_CONFIRM.sendKeys(password);

  }

  public void editTimeZone(String timeZone) {
    // Select time zone and change it
    ELEMENT_EDIT_TIME_ZONE.waitUntilClickable();
    ELEMENT_EDIT_TIME_ZONE.clickOnElement();

    ELEMENT_CHANGE_TIMEZONE(timeZone).waitUntilClickable();
    ELEMENT_CHANGE_TIMEZONE(timeZone).clickOnElement();

  }

  private BaseElementFacade ELEMENT_CHANGE_LANGUAGE(String language) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", language));
  }

  private BaseElementFacade ELEMENT_CHANGE_TIMEZONE(String timeZone) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", timeZone));
  }

  public void enableDisableGeneralNotificationsOnMobile() {
    findByXPathOrCSS("(//*[@class='v-input--selection-controls__input'])[2]").clickOnElement();
  }

  public void enableDisableGeneralNotificationsOnSite() {
    findByXPathOrCSS("(//*[@class='v-input--selection-controls__input'])[3]").clickOnElement();

  }

  public void enableDisableGeneralNotificationsViaMail() {
    findByXPathOrCSS("(//*[@class='v-input--selection-controls__input'])[1]").clickOnElement();

  }

  public void enableDisableNotificationOnMobile() {
    findByXPathOrCSS("(//*[@class='v-input--selection-controls__input'])[2]").click();
  }

  public void enableDisableNotificationOnSite() {
    findByXPathOrCSS("(//*[@class='v-input--selection-controls__input'])[3]").click();
  }

  public void enableDisableNotificationViaMail() {
    findByXPathOrCSS("(//*[@class='v-input--selection-controls__input'])[1]").click();
  }

  public void generalNotificationsSendingMailTypeIsDaily() {
    // Check that General Notifications Sending Mail Type is Daily
    Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.getText().contains("Daily"));

  }

  public void generalNotificationsSendingMailTypeIsNever() {
    // Check that General Notifications Sending Mail Type is Never
    Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.getText().contains("Never"));

  }

  public void generalNotificationsSendingMailTypeIsWeekly() {
    // Check that General Notifications Sending Mail Type is Weekly
    Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.getText().contains("Weekly"));

  }

  public void goToEditGeneralNotifications() {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    try {
      ELEMENT_EDIT_NOTIFICATIONS_GENERAL.waitUntilClickable();
      ELEMENT_EDIT_NOTIFICATIONS_GENERAL.clickOnElement();

    } catch (Exception ex) {
      js.executeScript("arguments[0].click();", ELEMENT_EDIT_NOTIFICATIONS_GENERAL);
    }

  }

  public void goToManageNotifications() {
    clickOnElement(ELEMENT_MANAGE_NOTIFICATIONS);
  }

  public void noEmailIsDisplayedInGeneralNotificationsSection() {
    // Check that no Email is displayed in General Notifications Section
    Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Daily digest email notification"));
    Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Weekly digest email notification"));
  }

  public void notifyMeByEmailIsDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me By Email is displayed in General Notifications
    // Section
    Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me by email"));

  }

  public void notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me By Email is not displayed in General Notifications
    // Section
    Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me by email"));

  }

  public void notifyMeOnMobileIsDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me On Mobile is displayed in General Notifications
    // Section
    Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me on mobile"));
  }

  public void notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me On Mobile is not displayed in General Notifications
    // Section
    Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me on mobile"));
  }

  public void notifyMeOnSiteIsDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me on Site is displayed in General Notifications
    // Section
    Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me on-site"));

  }

  public void notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection() {
    // Check that Notify Me on Site is not displayed in General Notifications
    // Section
    Assert.assertFalse(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Notify me on-site"));

  }

  public void selectSendMeASummaryEmail(String mailSendingType) {

    switch (mailSendingType) {
      case "Daily":
        // Select Daily
        ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.selectByValue("Daily");
        break;
      case "Weekly":
        // Select Weekly
        ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.selectByValue("Weekly");
        break;
      case "Never":
        // Select Never
        ELEMENT_GENERAL_NOTIFICATIONS_SELECT_MAIL_SENDING_TYPE.selectByValue("Never");
        break;
      default:
        // Do nothing
        break;

    }
  }

  public void weeklyEmailIsDisplayedInGeneralNotificationsSection() {
    // Check that Weeky Email is displayed in General Notifications Section
    Assert.assertTrue(ELEMENT_GENERAL_NOTIFICATIONS_SECTION.getText().contains("Weekly digest email notification"));
  }

  public enum mailSendingType {
    DAILY,
    NEVER,
    WEEKLY

  }

}
