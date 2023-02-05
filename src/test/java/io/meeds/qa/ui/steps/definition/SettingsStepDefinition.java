package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.SettingsSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class SettingsStepDefinition {

  @Steps
  private SettingsSteps settingsSteps;

  @When("^I accept editing language$")
  public void acceptEditLanguage() {
    settingsSteps.acceptEditLanguage();
  }

  @When("I accept editing password")
  public void acceptEditPassword() {
    settingsSteps.acceptEditPassword();
  }

  @When("^I confirm the modification of General Notifications$")
  public void applyEditGeneralNotifications() {
    settingsSteps.applyEditGeneralNotifications();
  }

  @When("^I cancel editing language$")
  public void cancelEditLanguage() {
    settingsSteps.cancelEditLanguage();
  }

  @When("I cancel editing password")
  public void cancelEditPassword() {
    settingsSteps.cancelEditPassword();
  }

  @And("^Activity Stream section is displayed$")
  public void checkThatActivityStreamSectionIsDisplayed() {
    settingsSteps.checkThatActivityStreamSectionIsDisplayed();
  }

  @And("^Connections section is displayed$")
  public void checkThatConnectionsSectionIsDisplayed() {
    settingsSteps.checkThatConnectionsSectionIsDisplayed();
  }

  @And("^General section is displayed$")
  public void checkThatGeneralSectionIsDisplayed() {
    settingsSteps.checkThatGeneralSectionIsDisplayed();
  }

  @And("^Kudos section is displayed$")
  public void checkThatKudosSectionIsDisplayed() {
    settingsSteps.checkThatKudosSectionIsDisplayed();
  }

  @Then("^Language '(.*)' is displayed$")
  public void checkThatLanguageIsDisplayed(String language) {
    settingsSteps.checkThatLanguageIsDisplayed(language);
  }

  @Then("^Manage Notification Page Is Opened$")
  public void checkThatManageNotificationPageIsOpened() {
    settingsSteps.checkThatManageNotificationPageIsOpened();
  }

  @And("^Notes section is displayed$")
  public void checkThatNotesSectionIsDisplayed() {
    settingsSteps.checkThatNotesSectionIsDisplayed();
  }

  @Then("Notification On Mobile is disabled")
  public void checkThatNotificationOnMobileIsDisabled() {
    settingsSteps.checkThatNotificationOnMobileIsDisabled();
  }

  @Then("Notification On Mobile is enabled")
  public void checkThatNotificationOnMobileIsEnabled() {
    settingsSteps.checkThatNotificationOnMobileIsEnabled();
  }

  @Then("Notification On Site is disabled")
  public void checkThatNotificationOnSiteIsDisabled() {
    settingsSteps.checkThatNotificationOnSiteIsDisabled();
  }

  @Then("Notification On Site is enabled")
  public void checkThatNotificationOnSiteIsEnabled() {
    settingsSteps.checkThatNotificationOnSiteIsEnabled();
  }

  @Then("Notification via Mail is disabled")
  public void checkThatNotificationViaMailIsDisabled() {
    settingsSteps.checkThatNotificationViaMailIsDisabled();
  }

  @Then("Notification via Mail is enabled")
  public void checkThatNotificationViaMailIsEnabled() {
    settingsSteps.checkThatNotificationViaMailIsEnabled();
  }

  @And("^Perk Store section is displayed$")
  public void checkThatPerkStoreSectionIsDisplayed() {
    settingsSteps.checkThatPerkStoreSectionIsDisplayed();
  }

  @Then("^Settings Page Is Opened$")
  public void checkThatSettingsPageIsOpened() {
    settingsSteps.checkThatSettingsPageIsOpened();
  }

  @And("^Spaces section is displayed$")
  public void checkThatSpacesSectionIsDisplayed() {
    settingsSteps.checkThatSpacesSectionIsDisplayed();
  }

  @And("^My Tasks section is displayed$")
  public void checkThatTasksSectionIsDisplayed() {
    settingsSteps.checkThatTasksSectionIsDisplayed();
  }

  @And("^Wallet section is displayed$")
  public void checkThatWalletSectionIsDisplayed() {
    settingsSteps.checkThatWalletSectionIsDisplayed();
  }

  @Then("^Daily Email is displayed in General Notifications Section$")
  public void dailyEmailIsDisplayedInGeneralNotificationsSection() {
    settingsSteps.dailyEmailIsDisplayedInGeneralNotificationsSection();
  }

  @When("^I click on Edit language and I change it '(.*)'$")
  public void editLanguage(String language) {
    settingsSteps.editLanguage(language);
  }

  @When("^I enter the old password '(.*)' and the new password '(.*)'$")
  public void editPassword(String oldPassword, String password) {
    settingsSteps.editPassword(oldPassword, password);
  }

  @When("^I enter the edited password and the old password$")
  public void editWithFirstPassword() {
    String firstUserPassword = Serenity.sessionVariableCalled("firstUserPassword");
    String firstUserEditedPassword = Serenity.sessionVariableCalled("firstUserEditedPassword");
    settingsSteps.editPassword(firstUserEditedPassword, firstUserPassword);
  }

  @When("^I enter the old password and the new random password$")
  public void editWithRandomPassword() {
    String firstUserPassword = Serenity.sessionVariableCalled("firstUserPassword");
    String firstUserEditedPassword = "345678nBm";
    Serenity.setSessionVariable("firstUserEditedPassword").to(firstUserEditedPassword);
    settingsSteps.editPassword(firstUserPassword, firstUserEditedPassword);
  }

  @When("I enable notification on Mobile")
  @And("I disable notification on Mobile")
  public void enableDisableNotificationOnMobile() {
    settingsSteps.enableDisableNotificationOnMobile();
  }

  @When("I enable notification on Site")
  @And("I disable notification on Site")
  public void enableDisableNotificationOnSite() {
    settingsSteps.enableDisableNotificationOnSite();
  }

  @When("I enable notification via Mail")
  @And("I disable notification via Mail")
  public void enableDisableNotificationViaMail() {
    settingsSteps.enableDisableNotificationViaMail();
  }

  @Then("^General Notifications Sending Mail Type is Daily$")
  public void generalNotificationsSendingMailTypeIsDaily() {
    settingsSteps.generalNotificationsSendingMailTypeIsDaily();
  }

  @Then("^General Notifications Sending Mail Type is Never$")
  public void generalNotificationsSendingMailTypeIsNever() {
    settingsSteps.generalNotificationsSendingMailTypeIsNever();
  }

  @Then("^General Notifications Sending Mail Type is Weekly$")
  public void generalNotificationsSendingMailTypeIsWeekly() {
    settingsSteps.generalNotificationsSendingMailTypeIsWeekly();
  }

  @When("^I click on Edit General Notifications$")
  public void goToEditGeneralNotifications() {
    settingsSteps.goToEditGeneralNotifications();
  }

  @When("^I go to Manage Notifications$")
  public void goToManageNotifications() {
    settingsSteps.goToManageNotifications();
  }

  @Then("^No Email is displayed in General Notifications Section$")
  public void noEmailIsDisplayedInGeneralNotificationsSection() {
    settingsSteps.noEmailIsDisplayedInGeneralNotificationsSection();
  }

  @Then("^Notify Me By Email is displayed in General Notifications Section$")
  public void notifyMeByEmailIsDisplayedInGeneralNotificationsSection() {
    settingsSteps.notifyMeByEmailIsDisplayedInGeneralNotificationsSection();
  }

  @Then("^Notify Me By Email is not displayed in General Notifications Section$")
  public void notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection() {
    settingsSteps.notifyMeByEmailIsNotDisplayedInGeneralNotificationsSection();
  }

  @Then("^Notify Me On Mobile is displayed in General Notifications Section$")
  public void notifyMeOnMobileIsDisplayedInGeneralNotificationsSection() {
    settingsSteps.notifyMeOnMobileIsDisplayedInGeneralNotificationsSection();
  }

  @Then("^Notify Me On Mobile is not displayed in General Notifications Section$")
  public void notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection() {
    settingsSteps.notifyMeOnMobileIsNotDisplayedInGeneralNotificationsSection();
  }

  @Then("^Notify Me On Site is displayed in General Notifications Section$")
  public void notifyMeOnSiteIsDisplayedInGeneralNotificationsSection() {
    settingsSteps.notifyMeOnSiteIsDisplayedInGeneralNotificationsSection();
  }

  @Then("^Notify Me On Site is not displayed in General Notifications Section$")
  public void notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection() {
    settingsSteps.notifyMeOnSiteIsNotDisplayedInGeneralNotificationsSection();
  }

  @When("^I select General Notifications Sending Mail Type '(.*)'$")
  public void selectSendMeASummaryEmail(String mailSendingType) {
    settingsSteps.selectSendMeASummaryEmail(mailSendingType);
  }

  @Then("^Weekly Email is displayed in General Notifications Section$")
  public void weeklyEmailIsDisplayedInGeneralNotificationsSection() {
    settingsSteps.weeklyEmailIsDisplayedInGeneralNotificationsSection();
  }

}
