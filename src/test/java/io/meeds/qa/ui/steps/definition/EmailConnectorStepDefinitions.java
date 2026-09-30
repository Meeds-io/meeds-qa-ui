/*
 * This file is part of the Meeds project (https://meeds.io/).
 *
 * Copyright (C) 2026 Meeds Association contact@meeds.io
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.steps.definition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.EmailConnectorSteps;
import net.thucydides.core.annotations.Steps;

/**
 * Step definitions of the eXo email-connector add-on scenarios
 * (features/EmailConnector): the mail server fixture, the Email settings and
 * mailbox sharing, the mail drawer and its shared mailboxes.
 */
public class EmailConnectorStepDefinitions {

  @Steps
  private EmailConnectorSteps emailConnectorSteps;

  // --- Mail server fixture ---

  /**
   * Checks the environment provides the given mail accounts.
   *
   * @param aliases the account aliases, comma separated
   */
  @Given("^The mail server fixture provides the mail accounts '([^']*)'$")
  public void checkMailAccountsConfigured(String aliases) {
    emailConnectorSteps.checkMailAccountsConfigured(aliases);
  }

  /**
   * Connects a random user's mailbox to a mail account, unless already done.
   *
   * @param userPrefix the random user's prefix
   * @param alias the mail account alias
   */
  @Given("^The '([^']*)' random user is connected to the '([^']*)' mail account$")
  public void connectMailAccount(String userPrefix, String alias) {
    emailConnectorSteps.connectMailAccount(userPrefix, alias);
  }

  /**
   * Sends a new email from a random user's own mailbox to a mail account.
   *
   * @param senderPrefix the sender's random user prefix
   * @param emailLabel the label the email is kept under
   * @param alias the recipient mail account alias
   */
  @Given("^The '([^']*)' random user sends a new email '([^']*)' to the '([^']*)' mail account$")
  public void sendEmail(String senderPrefix, String emailLabel, String alias) {
    emailConnectorSteps.sendEmail(senderPrefix, emailLabel, alias, false);
  }

  /**
   * Sends a new email asking for a read receipt from a random user's own mailbox
   * to a mail account.
   *
   * @param senderPrefix the sender's random user prefix
   * @param emailLabel the label the email is kept under
   * @param alias the recipient mail account alias
   */
  @Given("^The '([^']*)' random user sends a new email '([^']*)' asking for a read receipt to the '([^']*)' mail account$")
  public void sendEmailAskingForReadReceipt(String senderPrefix, String emailLabel, String alias) {
    emailConnectorSteps.sendEmail(senderPrefix, emailLabel, alias, true);
  }

  /**
   * Runs an action of the reading pane on a kept email of a random user's own
   * Inbox.
   *
   * @param userPrefix the random user's prefix
   * @param actionLabel the action's title
   * @param emailLabel the label the email was kept under
   */
  @Given("^The '([^']*)' random user runs '([^']*)' on the '([^']*)' email of their own Inbox$")
  public void runOwnMailboxAction(String userPrefix, String actionLabel, String emailLabel) {
    emailConnectorSteps.runOwnMailboxAction(userPrefix, emailLabel, actionLabel);
  }

  /**
   * Marks a scenario the suite cannot drive: it is reported pending, never
   * green, whatever filter runs it.
   *
   * @param reason why, and what a tester checks by hand
   */
  @Given("^This round-trip is checked by hand: (.*)$")
  public void checkedByHand(String reason) {
    throw new PendingException("Checked by hand: " + reason);
  }

  // --- Email settings and mailbox sharing ---

  /**
   * Opens the Email section of the settings page.
   */
  @When("^I open the email settings$")
  public void openEmailSettings() {
    emailConnectorSteps.openEmailSettings();
  }

  /**
   * Opens the "Mailbox sharing" drawer.
   */
  @When("^I open the mailbox sharing drawer$")
  public void openMailboxSharingDrawer() {
    emailConnectorSteps.openMailboxSharingDrawer();
  }

  /**
   * Checks the "Mailbox sharing" row shows a text.
   *
   * @param text the text
   */
  @Then("^The mailbox sharing setting shows '([^']*)'$")
  public void checkSharingRowShows(String text) {
    emailConnectorSteps.checkSharingRowShows(text);
  }

  /**
   * Selects a tab of the "Mailbox sharing" drawer.
   *
   * @param tabLabel the tab's label
   */
  @When("^I select the mailbox sharing tab '([^']*)'$")
  public void selectSharingTab(String tabLabel) {
    emailConnectorSteps.selectSharingTab(tabLabel);
  }

  /**
   * Checks a tab of the "Mailbox sharing" drawer is displayed.
   *
   * @param tabLabel the tab's label
   */
  @Then("^The mailbox sharing tab '([^']*)' is displayed$")
  public void checkSharingTabDisplayed(String tabLabel) {
    emailConnectorSteps.checkSharingTabDisplayed(tabLabel);
  }

  /**
   * Checks a tab of the "Mailbox sharing" drawer is the selected one.
   *
   * @param tabLabel the tab's label
   */
  @Then("^The mailbox sharing tab '([^']*)' is selected$")
  public void checkSharingTabSelected(String tabLabel) {
    emailConnectorSteps.checkSharingTabSelected(tabLabel);
  }

  /**
   * Removes every access to the current user's mailbox.
   */
  @When("^I remove every access to my mailbox$")
  public void removeEveryAccess() {
    emailConnectorSteps.removeEveryAccess();
  }

  /**
   * Shares the current user's mailbox with a random user.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param presetLabel Reader or Editor
   */
  @When("^I share my mailbox with the '([^']*)' random user as '([^']*)'$")
  public void shareMailbox(String granteePrefix, String presetLabel) {
    emailConnectorSteps.shareMailbox(granteePrefix, presetLabel);
  }

  /**
   * Starts from a fresh share the grantee has not answered yet; the owner stays
   * logged in.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param granteePrefix the grantee's random user prefix
   * @param presetLabel Reader or Editor
   */
  @Given("^The mailbox of the '([^']*)' random user is shared with the '([^']*)' random user as '([^']*)'$")
  public void shareMailboxFreshly(String ownerPrefix, String granteePrefix, String presetLabel) {
    emailConnectorSteps.shareMailboxFreshly(ownerPrefix, granteePrefix, presetLabel);
  }

  /**
   * Starts from a share the grantee accepted; the grantee stays logged in.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param ownerPrefix the owner's random user prefix
   * @param presetLabel Reader or Editor
   */
  @Given("^The '([^']*)' random user uses the mailbox of the '([^']*)' random user as '([^']*)'$")
  public void useSharedMailbox(String granteePrefix, String ownerPrefix, String presetLabel) {
    emailConnectorSteps.useSharedMailbox(granteePrefix, ownerPrefix, presetLabel);
  }

  /**
   * Checks a grantee's row in the "Who can open mine" tab.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param presetLabel the access chip
   * @param statusLabel the status chip
   */
  @Then("^The '([^']*)' random user is listed with '([^']*)' access and status '([^']*)'$")
  public void checkGranteeRow(String granteePrefix, String presetLabel, String statusLabel) {
    emailConnectorSteps.checkGranteeRow(granteePrefix, presetLabel, statusLabel);
  }

  /**
   * Checks a grantee's row in the "Who can open mine" tab shows a line of text.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param text the line of text
   */
  @Then("^The '([^']*)' random user row says '([^']*)'$")
  public void checkGranteeRowText(String granteePrefix, String text) {
    emailConnectorSteps.checkGranteeRowText(granteePrefix, text);
  }

  /**
   * Removes a grantee's access, confirmed.
   *
   * @param granteePrefix the grantee's random user prefix
   */
  @When("^I remove the access of the '([^']*)' random user$")
  public void removeAccess(String granteePrefix) {
    emailConnectorSteps.removeAccess(granteePrefix);
  }

  /**
   * Changes a grantee's access to a preset.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param presetLabel Reader or Editor
   */
  @When("^I change the access of the '([^']*)' random user to '([^']*)'$")
  public void changeAccess(String granteePrefix, String presetLabel) {
    emailConnectorSteps.changeAccess(granteePrefix, presetLabel);
  }

  /**
   * Extends an Inbox-only share to the owner's other folders, confirmed.
   *
   * @param granteePrefix the grantee's random user prefix
   */
  @When("^I extend the access of the '([^']*)' random user to the other folders$")
  public void extendAccess(String granteePrefix) {
    emailConnectorSteps.extendAccess(granteePrefix);
  }

  /**
   * Checks the owner's mailbox is offered in the "Shared with me" tab with the
   * given answers.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param answers the buttons, comma separated
   */
  @Then("^The mailbox of the '([^']*)' random user is offered with the answers '([^']*)'$")
  public void checkSharedMailboxAnswers(String ownerPrefix, String answers) {
    emailConnectorSteps.checkSharedMailboxAnswers(ownerPrefix, answers);
  }

  /**
   * Checks the owner's row in the "Shared with me" tab shows a line of text.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param text the line of text
   */
  @Then("^The mailbox of the '([^']*)' random user shows '([^']*)'$")
  public void checkSharedMailboxRowText(String ownerPrefix, String text) {
    emailConnectorSteps.checkSharedMailboxRowText(ownerPrefix, text);
  }

  /**
   * Answers the owner's share in the "Shared with me" tab.
   *
   * @param answer Accept or Decline
   * @param ownerPrefix the owner's random user prefix
   */
  @When("^I answer '([^']*)' to the mailbox of the '([^']*)' random user$")
  public void answerSharedMailbox(String answer, String ownerPrefix) {
    emailConnectorSteps.answerSharedMailbox(ownerPrefix, answer);
  }

  /**
   * Leaves the owner's mailbox, confirmed.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @When("^I leave the mailbox of the '([^']*)' random user$")
  public void leaveSharedMailbox(String ownerPrefix) {
    emailConnectorSteps.leaveSharedMailbox(ownerPrefix);
  }

  /**
   * Makes the owner's mailbox count, or not, in the unread badge.
   *
   * @param state on or off
   * @param ownerPrefix the owner's random user prefix
   */
  @When("^I switch (on|off) the unread badge of the mailbox of the '([^']*)' random user$")
  public void setSharedMailboxBadge(String state, String ownerPrefix) {
    emailConnectorSteps.setSharedMailboxBadge(ownerPrefix, "on".equals(state));
  }

  /**
   * Reads and keeps the unread badge of the Email application.
   */
  @Given("^I remember the unread badge of the Email application$")
  public void rememberEmailApplicationBadge() {
    emailConnectorSteps.rememberEmailApplicationBadge();
  }

  /**
   * Checks the unread badge of the Email application rose above the kept value.
   */
  @Then("^The unread badge of the Email application is higher than remembered$")
  public void checkEmailApplicationBadgeAboveRemembered() {
    emailConnectorSteps.checkEmailApplicationBadgeAboveRemembered();
  }

  /**
   * Checks the unread badge of the Email application is back to the kept value.
   */
  @Then("^The unread badge of the Email application is back to the remembered value$")
  public void checkEmailApplicationBadgeBackToRemembered() {
    emailConnectorSteps.checkEmailApplicationBadgeBackToRemembered();
  }

  /**
   * Checks an Email setting row is visible outside "Advanced settings".
   *
   * @param title the row's title
   */
  @Then("^The email setting '([^']*)' is displayed outside Advanced settings$")
  public void checkSettingOutsideAdvanced(String title) {
    emailConnectorSteps.checkSettingOutsideAdvanced(title);
  }

  /**
   * Checks an Email setting row is inside "Advanced settings".
   *
   * @param title the row's title
   */
  @Then("^The email setting '([^']*)' is inside Advanced settings$")
  public void checkSettingInsideAdvanced(String title) {
    emailConnectorSteps.checkSettingInsideAdvanced(title);
  }

  /**
   * Forgets whether "Advanced settings" was left open.
   */
  @Given("^I forget whether the Advanced email settings were open$")
  public void forgetAdvancedSettingsState() {
    emailConnectorSteps.forgetAdvancedSettingsState();
  }

  /**
   * Opens or closes "Advanced settings".
   */
  @When("^I open or close the Advanced email settings$")
  public void toggleAdvancedSettings() {
    emailConnectorSteps.toggleAdvancedSettings();
  }

  /**
   * Checks whether "Advanced settings" is open.
   *
   * @param state expanded or collapsed
   */
  @Then("^The Advanced email settings are (expanded|collapsed)$")
  public void checkAdvancedSettingsExpanded(String state) {
    emailConnectorSteps.checkAdvancedSettingsExpanded("expanded".equals(state));
  }

  /**
   * Checks "Reset &amp; re-sync" is the last advanced setting.
   */
  @Then("^Reset & re-sync is the last Advanced email setting$")
  public void checkResetIsLastAdvancedSetting() {
    emailConnectorSteps.checkResetIsLastAdvancedSetting();
  }

  /**
   * Opens or closes the read receipts choices.
   */
  @When("^I open or close the read receipt choices$")
  public void toggleReadReceiptChoices() {
    emailConnectorSteps.toggleReadReceiptChoices();
  }

  /**
   * Chooses a read receipt policy.
   *
   * @param policyLabel the choice
   */
  @When("^I choose '([^']*)' for read receipts$")
  public void chooseReadReceiptPolicy(String policyLabel) {
    emailConnectorSteps.chooseReadReceiptPolicy(policyLabel);
  }

  /**
   * Checks the read receipts row summary.
   *
   * @param summary the expected summary
   */
  @Then("^The read receipts summary is '([^']*)'$")
  public void checkReadReceiptSummary(String summary) {
    emailConnectorSteps.checkReadReceiptSummary(summary);
  }

  // --- Mail drawer ---

  /**
   * Opens the user's own mailbox.
   */
  @When("^I open my mailbox$")
  public void openMailBox() {
    emailConnectorSteps.openMailBox();
  }

  /**
   * Reloads the page the mailbox was opened from.
   */
  @When("^I reload my mailbox$")
  public void reloadMailBox() {
    emailConnectorSteps.reloadMailBox();
  }

  /**
   * Opens the owner's mailbox from its deep link.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @When("^I open the mailbox of the '([^']*)' random user from its link$")
  public void openSharedMailBoxLink(String ownerPrefix) {
    emailConnectorSteps.openSharedMailBoxLink(ownerPrefix);
  }

  /**
   * Keeps the deep link to the owner's mailbox.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @Given("^I keep the link to the mailbox of the '([^']*)' random user$")
  public void rememberSharedMailBoxLink(String ownerPrefix) {
    emailConnectorSteps.rememberSharedMailBoxLink(ownerPrefix);
  }

  /**
   * Opens the deep link kept for the owner's mailbox.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @When("^I open the kept link to the mailbox of the '([^']*)' random user$")
  public void openRememberedSharedMailBoxLink(String ownerPrefix) {
    emailConnectorSteps.openRememberedSharedMailBoxLink(ownerPrefix);
  }

  /**
   * Forgets the full-screen column widths.
   */
  @Given("^I forget the mailbox column widths$")
  public void forgetColumnWidths() {
    emailConnectorSteps.forgetColumnWidths();
  }

  /**
   * Forgets which shared mailboxes' moves were confirmed in this tab.
   */
  @Given("^I forget the shared mailbox moves confirmed in this session$")
  public void forgetConfirmedSharedMailboxMoves() {
    emailConnectorSteps.forgetConfirmedSharedMailboxMoves();
  }

  /**
   * Switches the mail drawer to full screen.
   */
  @When("^I open the mailbox in full screen$")
  public void expandMailBox() {
    emailConnectorSteps.expandMailBox();
  }

  /**
   * Opens the mailbox switcher.
   */
  @When("^I open the mailbox switcher$")
  public void openMailboxSwitcher() {
    emailConnectorSteps.openMailboxSwitcher();
  }

  /**
   * Checks the mailbox switcher offers an entry.
   *
   * @param label the entry's text
   */
  @Then("^The mailbox switcher offers '([^']*)'$")
  public void checkMailboxSwitcherOffers(String label) {
    emailConnectorSteps.checkMailboxSwitcherOffers(label);
  }

  /**
   * Checks the mailbox switcher offers the owner's mailbox.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @Then("^The mailbox switcher offers the mailbox of the '([^']*)' random user$")
  public void checkMailboxSwitcherOffersMailboxOf(String ownerPrefix) {
    emailConnectorSteps.checkMailboxSwitcherOffersMailboxOf(ownerPrefix);
  }

  /**
   * Chooses an entry of the mailbox switcher.
   *
   * @param label the entry's text
   */
  @When("^I choose '([^']*)' in the mailbox switcher$")
  public void chooseMailboxSwitcherEntry(String label) {
    emailConnectorSteps.chooseMailboxSwitcherEntry(label);
  }

  /**
   * Switches to the owner's mailbox with the mailbox switcher.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @When("^I switch to the mailbox of the '([^']*)' random user$")
  public void switchToMailboxOf(String ownerPrefix) {
    emailConnectorSteps.switchToMailboxOf(ownerPrefix);
  }

  /**
   * Checks, from the server, that the owner's mailbox is no longer shared with
   * the user.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @Then("^The mailbox of the '([^']*)' random user is no longer among my shared mailboxes$")
  public void checkSharedMailboxGone(String ownerPrefix) {
    emailConnectorSteps.checkSharedMailboxGone(ownerPrefix);
  }

  /**
   * Checks a kept email is not in one of the user's own folders.
   *
   * @param emailLabel the label the email was kept under
   * @param folderLabel the folder's label
   */
  @Then("^The '([^']*)' email is not in my own '([^']*)' folder$")
  public void checkEmailNotInOwnFolder(String emailLabel, String folderLabel) {
    emailConnectorSteps.checkEmailNotInOwnFolder(emailLabel, folderLabel);
  }

  /**
   * Checks the mailbox switcher is displayed.
   */
  @Then("^The mailbox switcher is displayed$")
  public void checkMailboxSwitcherDisplayed() {
    emailConnectorSteps.checkMailboxSwitcherDisplayed();
  }

  /**
   * Checks the mailbox switcher is not displayed.
   */
  @Then("^The mailbox switcher is not displayed$")
  public void checkMailboxSwitcherNotDisplayed() {
    emailConnectorSteps.checkMailboxSwitcherNotDisplayed();
  }

  /**
   * Checks the shared mailbox band names the owner and the access level.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param levelLabel the access level
   */
  @Then("^The shared mailbox band shows the mailbox of the '([^']*)' random user with '([^']*)' access$")
  public void checkSharedMailboxBand(String ownerPrefix, String levelLabel) {
    emailConnectorSteps.checkSharedMailboxBand(ownerPrefix, levelLabel);
  }

  /**
   * Checks no shared mailbox band is displayed.
   */
  @Then("^The shared mailbox band is not displayed$")
  public void checkSharedMailboxBandNotDisplayed() {
    emailConnectorSteps.checkSharedMailboxBandNotDisplayed();
  }

  /**
   * Scrolls the shared list to its end and checks the band stays in view.
   */
  @Then("^The shared mailbox band stays in view when the mail list is scrolled to its end$")
  public void checkSharedMailboxBandStaysInViewWhenScrolling() {
    emailConnectorSteps.checkSharedMailboxBandStaysInViewWhenScrolling();
  }

  /**
   * Checks the folder column is titled with the owner's name.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @Then("^The folder column is titled with the name of the '([^']*)' random user$")
  public void checkFolderColumnTitledWithOwner(String ownerPrefix) {
    emailConnectorSteps.checkFolderColumnTitledWithOwner(ownerPrefix);
  }

  /**
   * Checks the folder column lists a folder.
   *
   * @param folderLabel the folder's label
   */
  @Then("^The folder column lists '([^']*)'$")
  public void checkFolderListed(String folderLabel) {
    emailConnectorSteps.checkFolderListed(folderLabel);
  }

  /**
   * Checks the folder column lists a folder exactly once.
   *
   * @param folderLabel the folder's label
   */
  @Then("^The folder column lists '([^']*)' once$")
  public void checkFolderListedOnce(String folderLabel) {
    emailConnectorSteps.checkFolderListedOnce(folderLabel);
  }

  /**
   * Checks the folder column does not list a folder.
   *
   * @param folderLabel the folder's label
   */
  @Then("^The folder column does not list '([^']*)'$")
  public void checkFolderNotListed(String folderLabel) {
    emailConnectorSteps.checkFolderNotListed(folderLabel);
  }

  /**
   * Checks the folder column does not offer "Manage folders".
   */
  @Then("^The folder column does not offer to manage folders$")
  public void checkManageFoldersButtonNotDisplayed() {
    emailConnectorSteps.checkManageFoldersButton(false);
  }

  /**
   * Opens a folder of the folder column.
   *
   * @param folderLabel the folder's label
   */
  @When("^I open the folder '([^']*)'$")
  public void openFolder(String folderLabel) {
    emailConnectorSteps.openFolder(folderLabel);
  }

  /**
   * Opens a kept email of the folder shown.
   *
   * @param emailLabel the label the email was kept under
   */
  @When("^I open the '([^']*)' email$")
  public void openEmail(String emailLabel) {
    emailConnectorSteps.openEmail(emailLabel);
  }

  /**
   * Checks a kept email is listed in the folder shown.
   *
   * @param emailLabel the label the email was kept under
   */
  @Then("^The '([^']*)' email is listed$")
  public void checkEmailListed(String emailLabel) {
    emailConnectorSteps.checkEmailListed(emailLabel);
  }

  /**
   * Checks a kept email is not listed in the folder shown.
   *
   * @param emailLabel the label the email was kept under
   */
  @Then("^The '([^']*)' email is not listed$")
  public void checkEmailNotListed(String emailLabel) {
    emailConnectorSteps.checkEmailNotListed(emailLabel);
  }

  /**
   * Clicks an action of the reading pane.
   *
   * @param actionLabel the action's title
   */
  @When("^I click on '([^']*)' in the reading pane$")
  public void clickReadingPaneAction(String actionLabel) {
    emailConnectorSteps.clickReadingPaneAction(actionLabel);
  }

  /**
   * Checks the reading pane offers the given actions.
   *
   * @param actionLabels the actions' titles, comma separated
   */
  @Then("^The reading pane offers '([^']*)'$")
  public void checkReadingPaneActionsDisplayed(String actionLabels) {
    emailConnectorSteps.checkReadingPaneActionsDisplayed(actionLabels);
  }

  /**
   * Checks the reading pane offers none of the given actions.
   *
   * @param actionLabels the actions' titles, comma separated
   */
  @Then("^The reading pane does not offer '([^']*)'$")
  public void checkReadingPaneActionsNotDisplayed(String actionLabels) {
    emailConnectorSteps.checkReadingPaneActionsNotDisplayed(actionLabels);
  }

  /**
   * Checks the reading pane says the owner shares only the Inbox.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @Then("^The reading pane says the '([^']*)' random user shares only the Inbox$")
  public void checkInboxOnlyHint(String ownerPrefix) {
    emailConnectorSteps.checkInboxOnlyHint(ownerPrefix);
  }

  /**
   * Checks whether the reader is still open.
   *
   * @param state still open or closed
   */
  @Then("^The reading pane is (still open|closed)$")
  public void checkReadingPaneOpened(String state) {
    emailConnectorSteps.checkReadingPaneOpened("still open".equals(state));
  }

  /**
   * Checks whether a read receipt request is shown.
   *
   * @param negation "not " when it should not be
   */
  @Then("^The read receipt request is (not )?displayed$")
  public void checkReadReceiptRequest(String negation) {
    emailConnectorSteps.checkReadReceiptRequest(negation == null);
  }

  /**
   * Checks the confirmation asked before taking mail out of the owner's mailbox.
   *
   * @param titlePrefix the start of its title
   * @param ownerPrefix the owner's random user prefix
   */
  @Then("^The confirmation '([^']*)' the mailbox of the '([^']*)' random user is displayed$")
  public void checkSharedMailboxConfirmation(String titlePrefix, String ownerPrefix) {
    emailConnectorSteps.checkSharedMailboxConfirmation(titlePrefix, ownerPrefix);
  }

  /**
   * Answers the shared mailbox confirmation.
   *
   * @param buttonLabel Continue or Cancel
   */
  @When("^I answer '([^']*)' to the shared mailbox confirmation$")
  public void answerSharedMailboxConfirmation(String buttonLabel) {
    emailConnectorSteps.answerSharedMailboxConfirmation(buttonLabel);
  }

  /**
   * Opens the composer.
   */
  @When("^I start a new email$")
  public void startNewEmail() {
    emailConnectorSteps.startNewEmail();
  }

  /**
   * Checks the composer's shared mailbox notice names the owner.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  @Then("^The composer says I write as myself from the mailbox of the '([^']*)' random user$")
  public void checkComposerSharedMailboxNotice(String ownerPrefix) {
    emailConnectorSteps.checkComposerSharedMailboxNotice(ownerPrefix);
  }

  /**
   * Checks the composer offers to copy the owner, and whether it is ticked.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param state ticked or not ticked
   */
  @Then("^The composer offers to copy the '([^']*)' random user, (ticked|not ticked)$")
  public void checkComposerCopyOwner(String ownerPrefix, String state) {
    emailConnectorSteps.checkComposerCopyOwner(ownerPrefix, "ticked".equals(state));
  }

  /**
   * Checks a column width of the full-screen mailbox.
   *
   * @param handleLabel the handle's name
   * @param width the expected width in pixels
   */
  @Then("^The column handle '([^']*)' is at (\\d+) pixels$")
  public void checkColumnWidth(String handleLabel, int width) {
    emailConnectorSteps.checkColumnWidth(handleLabel, width);
  }

  /**
   * Drags a column handle of the full-screen mailbox.
   *
   * @param handleLabel the handle's name
   * @param offset the horizontal move in pixels
   */
  @When("^I drag the column handle '([^']*)' by (-?\\d+) pixels$")
  public void dragColumnHandle(String handleLabel, int offset) {
    emailConnectorSteps.dragColumnHandle(handleLabel, offset);
  }

  /**
   * Double-clicks a column handle of the full-screen mailbox.
   *
   * @param handleLabel the handle's name
   */
  @When("^I double-click the column handle '([^']*)'$")
  public void doubleClickColumnHandle(String handleLabel) {
    emailConnectorSteps.doubleClickColumnHandle(handleLabel);
  }

}
