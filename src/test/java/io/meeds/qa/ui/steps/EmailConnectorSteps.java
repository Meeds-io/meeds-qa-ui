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
package io.meeds.qa.ui.steps;

import static io.meeds.qa.ui.utils.Utils.getRandomString;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.pages.ApplicationPage;
import io.meeds.qa.ui.pages.EmailConnectorMailBoxPage;
import io.meeds.qa.ui.pages.EmailConnectorSettingsPage;
import io.meeds.qa.ui.pages.LoginPage;
import io.meeds.qa.ui.utils.Utils;

/**
 * Steps of the eXo email-connector add-on: connecting a mailbox, sharing it
 * (mailbox delegation, EXO-90503 to EXO-90559 and EXO-90548), working in a
 * shared mailbox, and the full-screen mailbox (EXO-90574, EXO-90575).
 * <p>
 * The mail accounts come from the environment, never from the scenarios: an
 * account alias {@code <alias>} (owner, delegate, sender, archiver) reads the
 * system properties {@code io.meeds.email.<alias>.address} and
 * {@code io.meeds.email.<alias>.password}. The connector the accounts use is
 * {@code io.meeds.email.connector.name} (the first one offering Connect when
 * unset), and the application launcher title of the Email application is
 * {@code io.meeds.email.appTitle} ("Email" when unset).
 */
public class EmailConnectorSteps {

  /** The prefix of the mail account system properties. */
  private static final String        MAIL_ACCOUNT_PROPERTY_PREFIX = "io.meeds.email.";

  /** How often the unread badge is read again while it catches up. */
  private static final int           BADGE_RETRIES                = 12;

  private EmailConnectorMailBoxPage  emailConnectorMailBoxPage;

  private EmailConnectorSettingsPage emailConnectorSettingsPage;

  private ApplicationPage            applicationPage;

  private LoginPage                  loginPage;

  /**
   * Checks the environment provides the given mail accounts, and fails with the
   * list of the missing system properties otherwise.
   *
   * @param aliases the account aliases, comma separated
   */
  public void checkMailAccountsConfigured(String aliases) {
    List<String> missing = new ArrayList<>();
    for (String alias : StringUtils.split(aliases, ",")) {
      String trimmedAlias = alias.trim();
      if (StringUtils.isBlank(mailAccountProperty(trimmedAlias, "address"))) {
        missing.add(MAIL_ACCOUNT_PROPERTY_PREFIX + trimmedAlias + ".address");
      }
      if (StringUtils.isBlank(mailAccountProperty(trimmedAlias, "password"))) {
        missing.add(MAIL_ACCOUNT_PROPERTY_PREFIX + trimmedAlias + ".password");
      }
    }
    assertThat(missing).as("The mail server fixture is not configured: pass these system properties to the test run")
                       .isEmpty();
  }

  /**
   * Logs in as a random user and connects the user's mailbox to a mail account,
   * unless the Email settings already show that account.
   *
   * @param userPrefix the random user's prefix
   * @param alias the mail account alias
   */
  public void connectMailAccount(String userPrefix, String alias) {
    authenticate(userPrefix);
    emailConnectorSettingsPage.openEmailSettings();
    String address = mailAccountProperty(alias, "address");
    if (!emailConnectorSettingsPage.isConnectedTo(address)) {
      emailConnectorSettingsPage.connectMailbox(System.getProperty(MAIL_ACCOUNT_PROPERTY_PREFIX + "connector.name"),
                                                address,
                                                mailAccountProperty(alias, "password"));
      emailConnectorSettingsPage.checkConfirmMessageIsDisplayed("Connection to the email done successfully");
    }
  }

  /**
   * Opens the settings page on its Email section.
   */
  public void openEmailSettings() {
    emailConnectorSettingsPage.openEmailSettings();
  }

  /**
   * Opens the "Mailbox sharing" drawer.
   */
  public void openMailboxSharingDrawer() {
    emailConnectorSettingsPage.openMailboxSharingDrawer();
  }

  /**
   * Checks the "Mailbox sharing" row shows a text.
   *
   * @param text the text
   */
  public void checkSharingRowShows(String text) {
    emailConnectorSettingsPage.checkSharingRowShows(text);
  }

  /**
   * Selects a tab of the "Mailbox sharing" drawer.
   *
   * @param tabLabel the tab's label
   */
  public void selectSharingTab(String tabLabel) {
    emailConnectorSettingsPage.selectSharingTab(tabLabel);
  }

  /**
   * Checks a tab of the "Mailbox sharing" drawer is displayed.
   *
   * @param tabLabel the tab's label
   */
  public void checkSharingTabDisplayed(String tabLabel) {
    emailConnectorSettingsPage.checkSharingTabDisplayed(tabLabel);
  }

  /**
   * Checks a tab of the "Mailbox sharing" drawer is the selected one.
   *
   * @param tabLabel the tab's label
   */
  public void checkSharingTabSelected(String tabLabel) {
    emailConnectorSettingsPage.checkSharingTabSelected(tabLabel);
  }

  /**
   * Removes every access to the current user's mailbox.
   */
  public void removeEveryAccess() {
    emailConnectorSettingsPage.removeEveryAccess();
  }

  /**
   * Shares the current user's mailbox with a random user.
   *
   * @param granteePrefix the random user's prefix
   * @param presetLabel Reader or Editor
   */
  public void shareMailbox(String granteePrefix, String presetLabel) {
    emailConnectorSettingsPage.shareMailbox(firstName(granteePrefix), presetLabel);
  }

  /**
   * Starts a scenario from a fresh share: the owner removes every access to
   * their mailbox, then shares it with the grantee, who has not answered yet.
   * The owner stays logged in.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param granteePrefix the grantee's random user prefix
   * @param presetLabel Reader or Editor
   */
  public void shareMailboxFreshly(String ownerPrefix, String granteePrefix, String presetLabel) {
    authenticate(ownerPrefix);
    emailConnectorSettingsPage.openEmailSettings();
    emailConnectorSettingsPage.openMailboxSharingDrawer();
    emailConnectorSettingsPage.removeEveryAccess();
    shareMailbox(granteePrefix, presetLabel);
    emailConnectorSettingsPage.checkConfirmMessageIsDisplayed("Your mailbox is shared");
    emailConnectorSettingsPage.closeAllDrawers();
  }

  /**
   * Starts a scenario from a share in use: {@link #shareMailboxFreshly} then the
   * grantee accepts it. The grantee stays logged in.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param ownerPrefix the owner's random user prefix
   * @param presetLabel Reader or Editor
   */
  public void useSharedMailbox(String granteePrefix, String ownerPrefix, String presetLabel) {
    shareMailboxFreshly(ownerPrefix, granteePrefix, presetLabel);
    authenticate(granteePrefix);
    emailConnectorSettingsPage.openEmailSettings();
    emailConnectorSettingsPage.openMailboxSharingDrawer();
    emailConnectorSettingsPage.selectSharingTab("Shared with me");
    emailConnectorSettingsPage.answerSharedMailbox(firstName(ownerPrefix), "Accept");
    emailConnectorSettingsPage.checkConfirmMessageIsDisplayed("Mailbox added");
    emailConnectorSettingsPage.closeAllDrawers();
  }

  /**
   * Checks a grantee's row in the "Who can open mine" tab.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param presetLabel the access chip
   * @param statusLabel the status chip
   */
  public void checkGranteeRow(String granteePrefix, String presetLabel, String statusLabel) {
    emailConnectorSettingsPage.checkGranteeRow(firstName(granteePrefix), presetLabel, statusLabel);
  }

  /**
   * Checks a grantee's row in the "Who can open mine" tab shows a line of text.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param text the line of text
   */
  public void checkGranteeRowText(String granteePrefix, String text) {
    emailConnectorSettingsPage.checkGranteeRowText(firstName(granteePrefix), text);
  }

  /**
   * Runs an action of a grantee's row menu.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param actionLabel the menu item
   */
  public void clickGranteeMenuAction(String granteePrefix, String actionLabel) {
    emailConnectorSettingsPage.clickGranteeMenuAction(firstName(granteePrefix), actionLabel);
  }

  /**
   * Removes a grantee's access and confirms.
   *
   * @param granteePrefix the grantee's random user prefix
   */
  public void removeAccess(String granteePrefix) {
    emailConnectorSettingsPage.clickGranteeMenuAction(firstName(granteePrefix), "Remove access");
    emailConnectorSettingsPage.clickToConfirmDialog();
  }

  /**
   * Changes a grantee's access to a preset. A share whose rights eXo named
   * changes at once; the owner is asked first only for a share made outside eXo.
   *
   * @param granteePrefix the grantee's random user prefix
   * @param presetLabel Reader or Editor
   */
  public void changeAccess(String granteePrefix, String presetLabel) {
    emailConnectorSettingsPage.clickGranteeMenuAction(firstName(granteePrefix), presetLabel);
  }

  /**
   * Extends an Inbox-only share to the owner's other folders, and confirms.
   *
   * @param granteePrefix the grantee's random user prefix
   */
  public void extendAccess(String granteePrefix) {
    emailConnectorSettingsPage.clickGranteeMenuAction(firstName(granteePrefix), "Share Sent, Archive, Trash and Spam too");
    emailConnectorSettingsPage.clickToConfirmDialog();
  }

  /**
   * Checks the owner's mailbox is offered in the "Shared with me" tab with the
   * given answers.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param answers the buttons, comma separated
   */
  public void checkSharedMailboxAnswers(String ownerPrefix, String answers) {
    emailConnectorSettingsPage.checkSharedMailboxAnswers(firstName(ownerPrefix), answers);
  }

  /**
   * Checks the owner's row in the "Shared with me" tab shows a line of text.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param text the line of text
   */
  public void checkSharedMailboxRowText(String ownerPrefix, String text) {
    emailConnectorSettingsPage.checkSharedMailboxRowText(firstName(ownerPrefix), text);
  }

  /**
   * Answers the owner's share in the "Shared with me" tab.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param answer Accept or Decline
   */
  public void answerSharedMailbox(String ownerPrefix, String answer) {
    emailConnectorSettingsPage.answerSharedMailbox(firstName(ownerPrefix), answer);
  }

  /**
   * Leaves the owner's mailbox from the "Shared with me" tab.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void leaveSharedMailbox(String ownerPrefix) {
    emailConnectorSettingsPage.leaveSharedMailbox(firstName(ownerPrefix));
  }

  /**
   * Sets whether the owner's mailbox counts in the user's unread badge.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param enabled whether it counts
   */
  public void setSharedMailboxBadge(String ownerPrefix, boolean enabled) {
    emailConnectorSettingsPage.setSharedMailboxBadge(firstName(ownerPrefix), enabled);
  }

  /**
   * Forgets whether "Advanced settings" was left open.
   */
  public void forgetAdvancedSettingsState() {
    emailConnectorSettingsPage.forgetAdvancedSettingsState();
  }

  /**
   * Opens or closes "Advanced settings".
   */
  public void toggleAdvancedSettings() {
    emailConnectorSettingsPage.toggleAdvancedSettings();
  }

  /**
   * Checks whether "Advanced settings" is open.
   *
   * @param expanded whether it should be
   */
  public void checkAdvancedSettingsExpanded(boolean expanded) {
    emailConnectorSettingsPage.checkAdvancedSettingsExpanded(expanded);
  }

  /**
   * Checks an Email setting row is visible outside "Advanced settings".
   *
   * @param title the row's title
   */
  public void checkSettingOutsideAdvanced(String title) {
    emailConnectorSettingsPage.checkSettingOutsideAdvanced(title);
  }

  /**
   * Checks an Email setting row is inside "Advanced settings".
   *
   * @param title the row's title
   */
  public void checkSettingInsideAdvanced(String title) {
    emailConnectorSettingsPage.checkSettingInsideAdvanced(title);
  }

  /**
   * Checks "Reset &amp; re-sync" is the last advanced setting.
   */
  public void checkResetIsLastAdvancedSetting() {
    emailConnectorSettingsPage.checkResetIsLastAdvancedSetting();
  }

  /**
   * Opens or closes the read receipts choices.
   */
  public void toggleReadReceiptChoices() {
    emailConnectorSettingsPage.toggleReadReceiptChoices();
  }

  /**
   * Chooses a read receipt policy.
   *
   * @param policyLabel the choice
   */
  public void chooseReadReceiptPolicy(String policyLabel) {
    emailConnectorSettingsPage.chooseReadReceiptPolicy(policyLabel);
  }

  /**
   * Checks the read receipts row summary.
   *
   * @param summary the expected summary
   */
  public void checkReadReceiptSummary(String summary) {
    emailConnectorSettingsPage.checkReadReceiptSummary(summary);
  }

  /**
   * Opens the user's own mailbox, on the Inbox it opens on.
   */
  public void openMailBox() {
    emailConnectorMailBoxPage.openMailBox();
    forgetFolderShown();
  }

  /**
   * Reloads the page the mailbox was opened from.
   */
  public void reloadMailBox() {
    emailConnectorMailBoxPage.reloadMailBox();
  }

  /**
   * Opens the owner's mailbox from its deep link.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void openSharedMailBoxLink(String ownerPrefix) {
    rememberSharedMailBoxLink(ownerPrefix);
    openRememberedSharedMailBoxLink(ownerPrefix);
  }

  /**
   * Reads and keeps the id of the share through which the owner's mailbox is
   * open to the current user.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void rememberSharedMailBoxLink(String ownerPrefix) {
    String delegationId = emailConnectorMailBoxPage.getSharedMailboxId(fullName(ownerPrefix));
    assertThat(delegationId).as("The mailbox of %s should be shared with the current user", fullName(ownerPrefix))
                            .isNotBlank();
    setSessionVariable(sharedMailboxIdKey(ownerPrefix)).to(delegationId);
  }

  /**
   * Opens the deep link kept for the owner's mailbox.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void openRememberedSharedMailBoxLink(String ownerPrefix) {
    String delegationId = sessionVariableCalled(sharedMailboxIdKey(ownerPrefix));
    assertThat(delegationId).as("No link was kept for the mailbox of %s", ownerPrefix).isNotBlank();
    emailConnectorMailBoxPage.openSharedMailBoxLink(delegationId);
    forgetFolderShown();
  }

  /**
   * Forgets the full-screen column widths.
   */
  public void forgetColumnWidths() {
    emailConnectorMailBoxPage.forgetColumnWidths();
  }

  /**
   * Forgets which shared mailboxes' moves were confirmed in this tab.
   */
  public void forgetConfirmedSharedMailboxMoves() {
    emailConnectorMailBoxPage.forgetConfirmedSharedMailboxMoves();
  }

  /**
   * Switches the mail drawer to full screen.
   */
  public void expandMailBox() {
    emailConnectorMailBoxPage.expandMailBox();
  }

  /**
   * Opens the mailbox switcher.
   */
  public void openMailboxSwitcher() {
    emailConnectorMailBoxPage.openMailboxSwitcher();
  }

  /**
   * Checks the mailbox switcher offers an entry.
   *
   * @param label the entry's text
   */
  public void checkMailboxSwitcherOffers(String label) {
    emailConnectorMailBoxPage.checkMailboxSwitcherOffers(label);
  }

  /**
   * Checks the mailbox switcher offers the owner's mailbox.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void checkMailboxSwitcherOffersMailboxOf(String ownerPrefix) {
    emailConnectorMailBoxPage.checkMailboxSwitcherOffers(fullName(ownerPrefix));
  }

  /**
   * Chooses an entry of the mailbox switcher.
   *
   * @param label the entry's text
   */
  public void chooseMailboxSwitcherEntry(String label) {
    emailConnectorMailBoxPage.chooseMailboxSwitcherEntry(label);
    forgetFolderShown();
  }

  /**
   * Switches to the owner's mailbox with the mailbox switcher.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void switchToMailboxOf(String ownerPrefix) {
    emailConnectorMailBoxPage.chooseMailboxSwitcherEntry(fullName(ownerPrefix));
    forgetFolderShown();
  }

  /**
   * Checks the owner's mailbox is no longer among the user's shared mailboxes.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void checkSharedMailboxGone(String ownerPrefix) {
    emailConnectorMailBoxPage.checkSharedMailboxGone(fullName(ownerPrefix));
  }

  /**
   * Checks a kept email is not in one of the user's own folders.
   *
   * @param emailLabel the label the email was kept under
   * @param folderLabel the folder's label
   */
  public void checkEmailNotInOwnFolder(String emailLabel, String folderLabel) {
    emailConnectorMailBoxPage.checkEmailNotInOwnFolder(emailSubject(emailLabel), folderLabel);
    forgetFolderShown();
  }

  /**
   * Checks the mailbox switcher is displayed.
   */
  public void checkMailboxSwitcherDisplayed() {
    emailConnectorMailBoxPage.checkMailboxSwitcherDisplayed();
  }

  /**
   * Checks the mailbox switcher is not displayed.
   */
  public void checkMailboxSwitcherNotDisplayed() {
    emailConnectorMailBoxPage.checkMailboxSwitcherNotDisplayed();
  }

  /**
   * Checks the shared mailbox band names the owner and the access level.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param levelLabel the access level
   */
  public void checkSharedMailboxBand(String ownerPrefix, String levelLabel) {
    emailConnectorMailBoxPage.checkSharedMailboxBand(fullName(ownerPrefix), levelLabel);
  }

  /**
   * Checks no shared mailbox band is displayed.
   */
  public void checkSharedMailboxBandNotDisplayed() {
    emailConnectorMailBoxPage.checkSharedMailboxBandNotDisplayed();
  }

  /**
   * Scrolls the shared list and checks the band stays in view.
   */
  public void checkSharedMailboxBandStaysInViewWhenScrolling() {
    emailConnectorMailBoxPage.checkSharedMailboxBandStaysInViewWhenScrolling();
  }

  /**
   * Checks the folder column is titled with the owner's full name.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void checkFolderColumnTitledWithOwner(String ownerPrefix) {
    emailConnectorMailBoxPage.checkFolderColumnTitle(fullName(ownerPrefix));
  }

  /**
   * Checks the folder column lists a folder.
   *
   * @param folderLabel the folder's label
   */
  public void checkFolderListed(String folderLabel) {
    emailConnectorMailBoxPage.checkFolderListed(folderLabel);
  }

  /**
   * Checks the folder column lists a folder exactly once.
   *
   * @param folderLabel the folder's label
   */
  public void checkFolderListedOnce(String folderLabel) {
    emailConnectorMailBoxPage.checkFolderListedOnce(folderLabel);
  }

  /**
   * Checks the folder column does not list a folder.
   *
   * @param folderLabel the folder's label
   */
  public void checkFolderNotListed(String folderLabel) {
    emailConnectorMailBoxPage.checkFolderNotListed(folderLabel);
  }

  /**
   * Checks whether the folder column offers "Manage folders".
   *
   * @param displayed whether it should
   */
  public void checkManageFoldersButton(boolean displayed) {
    emailConnectorMailBoxPage.checkManageFoldersButton(displayed);
  }

  /**
   * Opens a folder of the folder column, and keeps it as the folder shown.
   *
   * @param folderLabel the folder's label
   */
  public void openFolder(String folderLabel) {
    emailConnectorMailBoxPage.openFolder(folderLabel);
    setSessionVariable("emailConnectorFolder").to(folderLabel);
  }

  /**
   * Forgets the folder shown: the mailbox is back on the Inbox it opens on.
   */
  public void forgetFolderShown() {
    setSessionVariable("emailConnectorFolder").to(null);
  }

  /**
   * Checks a kept email is listed in the folder shown.
   *
   * @param emailLabel the label the email was kept under
   */
  public void checkEmailListed(String emailLabel) {
    emailConnectorMailBoxPage.checkEmailListed(emailSubject(emailLabel), folderShown());
  }

  /**
   * Checks a kept email is not listed in the folder shown.
   *
   * @param emailLabel the label the email was kept under
   */
  public void checkEmailNotListed(String emailLabel) {
    emailConnectorMailBoxPage.checkEmailNotListed(emailSubject(emailLabel));
  }

  /**
   * Opens a kept email of the folder shown.
   *
   * @param emailLabel the label the email was kept under
   */
  public void openEmail(String emailLabel) {
    emailConnectorMailBoxPage.openEmail(emailSubject(emailLabel), folderShown());
  }

  /**
   * Clicks an action of the reading pane.
   *
   * @param actionLabel the action's title
   */
  public void clickReadingPaneAction(String actionLabel) {
    emailConnectorMailBoxPage.clickReadingPaneAction(actionLabel);
  }

  /**
   * Checks the reading pane offers each of the given actions.
   *
   * @param actionLabels the actions' titles, comma separated
   */
  public void checkReadingPaneActionsDisplayed(String actionLabels) {
    for (String actionLabel : StringUtils.split(actionLabels, ",")) {
      emailConnectorMailBoxPage.checkReadingPaneActionDisplayed(actionLabel.trim());
    }
  }

  /**
   * Checks the reading pane offers none of the given actions.
   *
   * @param actionLabels the actions' titles, comma separated
   */
  public void checkReadingPaneActionsNotDisplayed(String actionLabels) {
    for (String actionLabel : StringUtils.split(actionLabels, ",")) {
      emailConnectorMailBoxPage.checkReadingPaneActionNotDisplayed(actionLabel.trim());
    }
  }

  /**
   * Checks the reading pane shows the Inbox-only hint naming the owner.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void checkInboxOnlyHint(String ownerPrefix) {
    emailConnectorMailBoxPage.checkReadingPaneHint(fullName(ownerPrefix)
        + " shares only the Inbox with you: ask them to extend access to delete or archive");
  }

  /**
   * Checks whether the reader is still open.
   *
   * @param opened whether it should be
   */
  public void checkReadingPaneOpened(boolean opened) {
    emailConnectorMailBoxPage.checkReadingPaneOpened(opened);
  }

  /**
   * Checks whether a read receipt request is shown.
   *
   * @param displayed whether it should be
   */
  public void checkReadReceiptRequest(boolean displayed) {
    emailConnectorMailBoxPage.checkReadReceiptRequest(displayed);
  }

  /**
   * Checks the confirmation asked before taking mail out of the owner's mailbox.
   *
   * @param titlePrefix the start of its title
   * @param ownerPrefix the owner's random user prefix
   */
  public void checkSharedMailboxConfirmation(String titlePrefix, String ownerPrefix) {
    emailConnectorMailBoxPage.checkSharedMailboxConfirmation(titlePrefix, fullName(ownerPrefix));
  }

  /**
   * Answers the confirmation asked before taking mail out of a shared mailbox.
   *
   * @param buttonLabel Continue or Cancel
   */
  public void answerSharedMailboxConfirmation(String buttonLabel) {
    emailConnectorMailBoxPage.answerSharedMailboxConfirmation(buttonLabel);
  }

  /**
   * Opens the composer.
   */
  public void startNewEmail() {
    emailConnectorMailBoxPage.startNewEmail();
  }

  /**
   * Checks the composer's shared mailbox notice names the owner.
   *
   * @param ownerPrefix the owner's random user prefix
   */
  public void checkComposerSharedMailboxNotice(String ownerPrefix) {
    emailConnectorMailBoxPage.checkComposerSharedMailboxNotice(fullName(ownerPrefix));
  }

  /**
   * Checks the composer's "Copy &lt;owner&gt;" choice.
   *
   * @param ownerPrefix the owner's random user prefix
   * @param checked whether it should be ticked
   */
  public void checkComposerCopyOwner(String ownerPrefix, boolean checked) {
    emailConnectorMailBoxPage.checkComposerCopyOwner(fullName(ownerPrefix), checked);
  }

  /**
   * Logs in as a random user and sends, from that user's own mailbox, a new email
   * with a random subject to a mail account; the subject is kept under a label.
   *
   * @param senderPrefix the sender's random user prefix
   * @param emailLabel the label the email is kept under
   * @param alias the recipient mail account alias
   * @param requestReadReceipt whether the email asks for a read receipt
   */
  public void sendEmail(String senderPrefix, String emailLabel, String alias, boolean requestReadReceipt) {
    authenticate(senderPrefix);
    emailConnectorMailBoxPage.openMailBox();
    emailConnectorMailBoxPage.startNewEmail();
    String subject = getRandomString("EXO-90576 " + emailLabel);
    emailConnectorMailBoxPage.sendEmail(mailAccountProperty(alias, "address"), subject, requestReadReceipt);
    emailConnectorMailBoxPage.checkConfirmMessageIsDisplayed("Email sent successfully");
    setSessionVariable(emailSubjectKey(emailLabel)).to(subject);
    emailConnectorMailBoxPage.closeAllDrawers();
  }

  /**
   * Logs in as a random user, opens a kept email in that user's own Inbox and
   * runs an action of the reading pane on it.
   *
   * @param userPrefix the random user's prefix
   * @param emailLabel the label the email was kept under
   * @param actionLabel the action's title
   */
  public void runOwnMailboxAction(String userPrefix, String emailLabel, String actionLabel) {
    authenticate(userPrefix);
    emailConnectorMailBoxPage.openMailBox();
    forgetFolderShown();
    emailConnectorMailBoxPage.openEmail(emailSubject(emailLabel), null);
    emailConnectorMailBoxPage.clickReadingPaneAction(actionLabel);
    emailConnectorMailBoxPage.closeAllDrawers();
  }

  /**
   * Reads a column width of the full-screen mailbox and checks it is the
   * expected one, give or take a few pixels of pointer rounding.
   *
   * @param handleLabel the handle's name
   * @param expectedWidth the expected width in pixels
   */
  public void checkColumnWidth(String handleLabel, int expectedWidth) {
    retryOnCondition(() -> assertThat(emailConnectorMailBoxPage.getColumnWidth(handleLabel)).as("The width behind '%s'",
                                                                                                 handleLabel)
                                                                                             .isBetween(expectedWidth - 8,
                                                                                                        expectedWidth + 8));
  }

  /**
   * Drags a column handle of the full-screen mailbox.
   *
   * @param handleLabel the handle's name
   * @param offset the horizontal move in pixels
   */
  public void dragColumnHandle(String handleLabel, int offset) {
    emailConnectorMailBoxPage.dragColumnHandle(handleLabel, offset);
  }

  /**
   * Double-clicks a column handle of the full-screen mailbox.
   *
   * @param handleLabel the handle's name
   */
  public void doubleClickColumnHandle(String handleLabel) {
    emailConnectorMailBoxPage.doubleClickColumnHandle(handleLabel);
  }

  /**
   * Reads and keeps the unread badge of the Email application.
   */
  public void rememberEmailApplicationBadge() {
    setSessionVariable("emailConnectorBadge").to(readEmailApplicationBadge());
  }

  /**
   * Checks the unread badge of the Email application rises above the kept value,
   * reading it again while the badge catches up with the synchronisation.
   */
  public void checkEmailApplicationBadgeAboveRemembered() {
    int remembered = sessionVariableCalled("emailConnectorBadge");
    retryOnCondition(() -> assertThat(readEmailApplicationBadge()).as("The Email application badge").isGreaterThan(remembered),
                     Utils::refreshPage,
                     BADGE_RETRIES);
  }

  /**
   * Checks the unread badge of the Email application is back to the kept value.
   */
  public void checkEmailApplicationBadgeBackToRemembered() {
    int remembered = sessionVariableCalled("emailConnectorBadge");
    retryOnCondition(() -> assertThat(readEmailApplicationBadge()).as("The Email application badge").isEqualTo(remembered),
                     Utils::refreshPage,
                     BADGE_RETRIES);
  }

  /**
   * Opens the application launcher and reads the Email application's badge.
   *
   * @return the unread count, 0 without a badge
   */
  private int readEmailApplicationBadge() {
    applicationPage.clickOnTheAppLauncherIcon();
    int badge = emailConnectorMailBoxPage.getApplicationBadge(System.getProperty(MAIL_ACCOUNT_PROPERTY_PREFIX + "appTitle",
                                                                                 "Email"));
    emailConnectorMailBoxPage.closeAllDrawers();
    return badge;
  }

  /**
   * Logs in as a random user, as the suite's login step does.
   *
   * @param userPrefix the random user's prefix
   */
  private void authenticate(String userPrefix) {
    String username = sessionVariableCalled(userPrefix + "UserName");
    loginPage.login(username, sessionVariableCalled(username + "-password"));
  }

  /**
   * @param alias a mail account alias
   * @param key address or password
   * @return the system property describing that account
   */
  private String mailAccountProperty(String alias, String key) {
    return System.getProperty(MAIL_ACCOUNT_PROPERTY_PREFIX + alias + "." + key);
  }

  /**
   * @param userPrefix a random user's prefix
   * @return the random user's first name, unique to the run
   */
  private String firstName(String userPrefix) {
    String firstName = sessionVariableCalled(userPrefix + "UserFirstName");
    assertThat(firstName).as("The random user '%s' should exist", userPrefix).isNotBlank();
    return firstName;
  }

  /**
   * @param userPrefix a random user's prefix
   * @return the random user's full name, as eXo displays it
   */
  private String fullName(String userPrefix) {
    return firstName(userPrefix) + " " + sessionVariableCalled(userPrefix + "UserLastName");
  }

  /**
   * @param emailLabel a label an email is kept under
   * @return the email's subject
   */
  private String emailSubject(String emailLabel) {
    String subject = sessionVariableCalled(emailSubjectKey(emailLabel));
    assertThat(subject).as("No email was sent under the label '%s'", emailLabel).isNotBlank();
    return subject;
  }

  /**
   * @return the folder shown, null for the Inbox the mailbox opens on
   */
  private String folderShown() {
    return sessionVariableCalled("emailConnectorFolder");
  }

  /**
   * @param emailLabel a label an email is kept under
   * @return the session variable holding its subject
   */
  private String emailSubjectKey(String emailLabel) {
    return "emailConnectorSubject-" + emailLabel;
  }

  /**
   * @param ownerPrefix an owner's random user prefix
   * @return the session variable holding the id of the share of the owner's
   *         mailbox
   */
  private String sharedMailboxIdKey(String ownerPrefix) {
    return "emailConnectorSharedMailbox-" + ownerPrefix;
  }

}
