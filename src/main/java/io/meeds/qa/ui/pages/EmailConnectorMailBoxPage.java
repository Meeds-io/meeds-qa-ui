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
package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.ExceptionLauncher.LOGGER;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

/**
 * The mail drawer of the eXo email-connector add-on: its mailbox switcher and
 * the shared mailbox band (EXO-90531), the full-screen folder column
 * (EXO-90415, EXO-90548) with its resizable columns (EXO-90575), the reading
 * pane's actions and the composer. Labels are the English bundles of the add-on
 * (emailConnectorMailBox_en.properties).
 */
public class EmailConnectorMailBoxPage extends GenericPage {

  /** The localStorage key holding the full-screen column widths (EXO-90575). */
  private static final String COLUMN_WIDTHS_KEY      = "emailConnector.mailBox.columnWidths";

  /** The localStorage key remembering the folder column folded to a rail. */
  private static final String NAVIGATION_RAIL_KEY    = "emailConnector.mailBox.navigationRail";

  /** The narrowest window the default and dragged column widths all fit in. */
  private static final int    MIN_COLUMNS_WINDOW     = 1400;

  /** The sessionStorage key holding the shared mailboxes whose moves were confirmed. */
  private static final String CONFIRMED_MOVES_KEY    = "emailConnector.sharedMailbox.confirmed";

  /** The mail drawer. */
  private static final String MAIL_DRAWER            = "//*[@id='emailBoxDrawer']";

  /** The drawer holding the reading pane's actions: the reader, or the full-screen drawer. */
  private static final String READING_PANE_HEADER    = "//*[(@id='emailDetailDrawer' or @id='emailBoxDrawer') and contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'drawerHeader')]";

  /** The drawer holding the conversation shown: the reader, or the full-screen drawer. */
  private static final String READING_PANE           = "//*[(@id='emailDetailDrawer' or @id='emailBoxDrawer') and contains(@class, 'v-navigation-drawer--open')]";

  /**
   * Builds the page on the current web driver.
   *
   * @param driver the web driver
   */
  public EmailConnectorMailBoxPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Opens the mail drawer on the user's own mailbox, the way the platform's
   * quick action does: the {@code openEmailBox} URL parameter.
   */
  public void openMailBox() {
    goToPage("/portal/dw/?openEmailBox=true");
    waitForMailBoxDrawer();
  }

  /**
   * Opens the mail drawer on a mailbox shared with the user, by its deep link
   * {@code ?openEmailBox=true&mailbox=<delegationId>} (EXO-90531).
   *
   * @param delegationId the share's id, what the link's {@code mailbox} names
   */
  public void openSharedMailBoxLink(String delegationId) {
    goToPage("/portal/dw/?openEmailBox=true&mailbox=" + delegationId);
    waitForMailBoxDrawer();
  }

  /**
   * Reloads the page the mail drawer was opened from; its URL reopens it, on the
   * mailbox the URL names: the user's own, or the shared one a deep link named,
   * whatever the switcher chose since.
   */
  public void reloadMailBox() {
    getDriver().navigate().refresh();
    verifyPageLoaded();
    waitForMailBoxDrawer();
  }

  /**
   * Reads, with the user's own session, the id of the share through which a
   * person's mailbox is open to the user. The deep link carries that id, which
   * no screen shows: it is read from the endpoint the mailbox switcher itself
   * reads, {@code GET /email-connector/rest/user-email-setting/delegations/mailboxes}.
   *
   * @param ownerFullName the owner's full name, as the switcher shows it
   * @return the share's id, null when no such mailbox is shared with the user
   * @throws AssertionError when the endpoint cannot be read: a failed read is
   *           never taken for "not shared"
   */
  public String getSharedMailboxId(String ownerFullName) {
    Object delegationId =
                        ((JavascriptExecutor) getDriver()).executeAsyncScript("const ownerFullName = arguments[0];"
                            + "const done = arguments[arguments.length - 1];"
                            + "fetch('/email-connector/rest/user-email-setting/delegations/mailboxes', {credentials: 'include', cache: 'no-store'})"
                            + ".then(resp => {"
                            + "  if (!resp.ok) { throw new Error(String(resp.status)); }"
                            + "  return resp.json();"
                            + "})"
                            + ".then(entries => {"
                            + "  const entry = (entries || []).find(item => item.ownerFullName === ownerFullName);"
                            + "  done(entry ? String(entry.delegationId) : null);"
                            + "})"
                            + ".catch(error => done('ERROR ' + error.message));", ownerFullName);
    String result = delegationId == null ? null : delegationId.toString();
    assertThat(result).as("The mailboxes shared with the user could not be read").doesNotStartWith("ERROR");
    return result;
  }

  /**
   * Forgets the full-screen column widths, so the columns open at their
   * defaults.
   */
  public void forgetColumnWidths() {
    ((JavascriptExecutor) getDriver()).executeScript("try { window.localStorage.removeItem(arguments[0]);"
        + " window.localStorage.removeItem(arguments[1]); } catch (e) { /* no storage */ }",
                                                     COLUMN_WIDTHS_KEY,
                                                     NAVIGATION_RAIL_KEY);
    Object width = ((JavascriptExecutor) getDriver()).executeScript("return window.innerWidth;");
    assertThat(((Number) width).intValue()).as("The browser window must be at least %s px wide for the column widths to be kept unclamped",
                                               MIN_COLUMNS_WINDOW)
                                           .isGreaterThanOrEqualTo(MIN_COLUMNS_WINDOW);
  }

  /**
   * Checks, from the endpoint the mailbox switcher reads, that a person's mailbox
   * is no longer among the mailboxes shared with the user, before the drawer's
   * own view of it is checked: the drawer does not wait for that list before it
   * shows the user's own mailbox, so its missing switcher alone proves nothing.
   *
   * @param ownerFullName the owner's full name
   */
  public void checkSharedMailboxGone(String ownerFullName) {
    retryOnCondition(() -> assertThat(getSharedMailboxId(ownerFullName)).as("The mailbox of %s should no longer be shared with the user",
                                                                            ownerFullName)
                                                                        .isNull());
  }

  /**
   * Checks an email is not in one of the user's own folders: either the folder
   * is not there at all, or it is and the email is not listed in it. Opens the
   * user's own mailbox by its own URL, without a shared mailbox's {@code mailbox}
   * parameter, so that no reload can bring a shared mailbox back.
   *
   * @param subject the email's subject
   * @param folderLabel the folder's label
   */
  public void checkEmailNotInOwnFolder(String subject, String folderLabel) {
    openMailBox();
    expandMailBox();
    if (folderEntryElement(folderLabel).isCurrentlyVisible()) {
      folderEntryElement(folderLabel).click();
      waitForLoading();
      emailRowElement(subject).assertNotVisible();
    }
  }

  /**
   * Forgets, for this browser tab, which shared mailboxes' moves were already
   * confirmed, so the next move out of a shared mailbox asks again.
   */
  public void forgetConfirmedSharedMailboxMoves() {
    ((JavascriptExecutor) getDriver()).executeScript("try { window.sessionStorage.removeItem(arguments[0]); } catch (e) { /* no storage */ }",
                                                     CONFIRMED_MOVES_KEY);
  }

  /**
   * Switches the mail drawer to full screen, unless it already is.
   */
  public void expandMailBox() {
    ElementFacade expandIcon = expandIconElement();
    if (expandIcon.isCurrentlyVisible()) {
      expandIcon.click();
      waitForLoading();
    }
    folderColumnElement().assertVisible();
  }

  /**
   * Opens the mailbox switcher of the drawer's title.
   */
  public void openMailboxSwitcher() {
    mailboxSwitcherElement().click();
    waitMenuToDisplay();
  }

  /**
   * Checks the opened mailbox switcher offers an entry.
   *
   * @param label a text of the entry: My mailbox, the owner's name, Manage
   *          shared mailboxes
   */
  public void checkMailboxSwitcherOffers(String label) {
    switcherEntryElement(label).assertVisible();
  }

  /**
   * Chooses an entry of the opened mailbox switcher.
   *
   * @param label a text of the entry
   */
  public void chooseMailboxSwitcherEntry(String label) {
    switcherEntryElement(label).click();
    waitForLoading();
  }

  /**
   * Checks the mail drawer shows its mailbox switcher: a mailbox is shared with
   * the user.
   */
  public void checkMailboxSwitcherDisplayed() {
    retryOnCondition(() -> mailboxSwitcherElement().assertVisible(), this::reloadMailBox);
  }

  /**
   * Checks the mail drawer shows no mailbox switcher: nothing is shared with the
   * user.
   */
  public void checkMailboxSwitcherNotDisplayed() {
    mailboxSwitcherElement().assertNotVisible();
  }

  /**
   * Checks the band saying whose mailbox the user is in: the owner's name and the
   * access level.
   *
   * @param ownerName a name of the owner
   * @param levelLabel the access level (Reader, Editor, Custom rights)
   */
  public void checkSharedMailboxBand(String ownerName, String levelLabel) {
    retryOnCondition(() -> {
      ElementFacade band = sharedMailboxBandElement();
      band.assertVisible();
      assertThat(band.getText()).as("The shared mailbox band")
                                .contains("You are in")
                                .contains(ownerName)
                                .contains(levelLabel);
    });
  }

  /**
   * Checks no shared mailbox band is shown: the user is in their own mailbox.
   */
  public void checkSharedMailboxBandNotDisplayed() {
    sharedMailboxBandElement().assertNotVisible();
  }

  /**
   * Scrolls the list holding the shared mailbox band to its end, and checks the
   * band is still in view. The list must be longer than its pane: a list that
   * does not scroll proves nothing, and fails the check with the fixture it
   * needs.
   */
  public void checkSharedMailboxBandStaysInViewWhenScrolling() {
    ElementFacade band = sharedMailboxBandElement();
    band.assertVisible();
    Object result = ((JavascriptExecutor) getDriver()).executeScript("const band = arguments[0];"
        + "let pane = band.parentElement;"
        + "while (pane && !(pane.scrollHeight > pane.clientHeight"
        + "  && ['auto', 'scroll'].includes(window.getComputedStyle(pane).overflowY))) {"
        + "  pane = pane.parentElement;"
        + "}"
        + "if (!pane) { return 'not-scrollable'; }"
        + "pane.scrollTop = pane.scrollHeight;"
        + "const bandBox = band.getBoundingClientRect();"
        + "const paneBox = pane.getBoundingClientRect();"
        + "return pane.scrollTop > 0 && bandBox.height > 0 && bandBox.top >= paneBox.top - 1"
        + "  && bandBox.bottom <= paneBox.bottom + 1 ? 'in-view' : 'out-of-view';",
                                                                      band);
    assertThat(result).as("The shared mailbox list must be long enough to scroll (fixture: the owner's Inbox holds more mail than one screen), and the band must stay in view")
                      .isEqualTo("in-view");
  }

  /**
   * Checks the folder column is titled with the given name: the owner's name in
   * a shared mailbox, "Folders" in the user's own.
   *
   * @param title the expected title
   */
  public void checkFolderColumnTitle(String title) {
    folderColumnTitleElement(title).assertVisible();
  }

  /**
   * Checks the folder column lists a folder.
   *
   * @param folderLabel the folder's label
   */
  public void checkFolderListed(String folderLabel) {
    retryOnCondition(() -> folderEntryElement(folderLabel).assertVisible());
  }

  /**
   * Checks the folder column lists a folder exactly once.
   *
   * @param folderLabel the folder's label
   */
  public void checkFolderListedOnce(String folderLabel) {
    checkFolderListed(folderLabel);
    String folderXPath = String.format(MAIL_DRAWER
        + "//*[@role='option' and .//*[contains(@class, 'v-list-item__title') and normalize-space(.)='%s']]", folderLabel);
    assertThat(findAll(folderXPath)).as("The folder '%s' should be listed once", folderLabel).hasSize(1);
  }

  /**
   * Checks the folder column does not list a folder.
   *
   * @param folderLabel the folder's label
   */
  public void checkFolderNotListed(String folderLabel) {
    folderEntryElement(folderLabel).assertNotVisible();
  }

  /**
   * Checks whether the folder column offers its "Manage folders" button.
   *
   * @param displayed whether the button should be there
   */
  public void checkManageFoldersButton(boolean displayed) {
    if (displayed) {
      manageFoldersButtonElement().assertVisible();
    } else {
      manageFoldersButtonElement().assertNotVisible();
    }
  }

  /**
   * Opens a folder from the full-screen folder column.
   *
   * @param folderLabel the folder's label
   */
  public void openFolder(String folderLabel) {
    retryOnCondition(() -> folderEntryElement(folderLabel).click(), this::reloadExpandedMailBox);
    waitForLoading();
  }

  /**
   * Checks an email is listed in the folder shown, reloading the mailbox on the
   * same folder while the synchronisation brings it.
   *
   * @param subject the email's subject
   * @param folderLabel the folder shown, blank for the Inbox the drawer opens on
   */
  public void checkEmailListed(String subject, String folderLabel) {
    retryOnCondition(() -> emailRowElement(subject).assertVisible(), () -> reloadOnFolder(folderLabel));
  }

  /**
   * Checks an email is not listed in the folder shown.
   *
   * @param subject the email's subject
   */
  public void checkEmailNotListed(String subject) {
    emailRowElement(subject).assertNotVisible();
  }

  /**
   * Opens an email of the folder shown, reloading the mailbox on the same folder
   * while the synchronisation brings it.
   *
   * @param subject the email's subject
   * @param folderLabel the folder shown, blank for the Inbox the drawer opens on
   */
  public void openEmail(String subject, String folderLabel) {
    checkEmailListed(subject, folderLabel);
    emailRowElement(subject).click();
    waitForLoading();
    readingPaneElement().assertVisible();
  }

  /**
   * Clicks an action of the reading pane's toolbar.
   *
   * @param actionLabel the action's title (Delete, Archive, Mark as spam, ...)
   */
  public void clickReadingPaneAction(String actionLabel) {
    ElementFacade action = readingPaneActionElement(actionLabel);
    action.assertVisible();
    action.click();
    waitForLoading();
  }

  /**
   * Checks the reading pane's toolbar offers an action.
   *
   * @param actionLabel the action's title
   */
  public void checkReadingPaneActionDisplayed(String actionLabel) {
    readingPaneActionElement(actionLabel).assertVisible();
  }

  /**
   * Checks the reading pane's toolbar does not offer an action.
   *
   * @param actionLabel the action's title
   */
  public void checkReadingPaneActionNotDisplayed(String actionLabel) {
    readingPaneActionElement(actionLabel).assertNotVisible();
  }

  /**
   * Checks the reading pane's toolbar shows a hint instead of its actions.
   *
   * @param hint the hint's text
   */
  public void checkReadingPaneHint(String hint) {
    readingPaneTextElement(hint).assertVisible();
  }

  /**
   * Checks whether the reading pane is still open.
   *
   * @param opened whether it should be
   */
  public void checkReadingPaneOpened(boolean opened) {
    if (opened) {
      emailDetailDrawerElement().assertVisible();
    } else {
      emailDetailDrawerElement().assertNotVisible();
    }
  }

  /**
   * Checks whether the reading pane shows a read receipt request to answer.
   *
   * @param displayed whether the request should be there
   */
  public void checkReadReceiptRequest(boolean displayed) {
    if (displayed) {
      readReceiptBannerElement().assertVisible();
    } else {
      readReceiptBannerElement().assertNotVisible();
    }
  }

  /**
   * Checks the confirmation asked before taking mail out of a shared mailbox.
   *
   * @param titlePrefix the start of its title (Delete from, Archive from, Report
   *          as spam from)
   * @param ownerName a name of the owner, which the title carries
   */
  public void checkSharedMailboxConfirmation(String titlePrefix, String ownerName) {
    ElementFacade title = sharedMailboxConfirmTitleElement();
    title.assertVisible();
    assertThat(title.getText()).as("The shared mailbox confirmation title")
                               .startsWith(titlePrefix)
                               .contains(ownerName);
  }

  /**
   * Answers the confirmation asked before taking mail out of a shared mailbox.
   *
   * @param buttonLabel Continue or Cancel
   */
  public void answerSharedMailboxConfirmation(String buttonLabel) {
    ElementFacade button = sharedMailboxConfirmButtonElement(buttonLabel);
    button.assertVisible();
    button.click();
    button.waitUntilNotVisible();
    waitForLoading();
  }

  /**
   * Opens the composer from the mail drawer's "Write an email" button.
   */
  public void startNewEmail() {
    newEmailButtonElement().click();
    findByXPathOrCSS("//*[@id='newEmailDrawer' and contains(@class, 'v-navigation-drawer--open')]").waitUntilVisible();
    composerSubjectElement().assertVisible();
  }

  /**
   * Fills the composer and sends the email.
   *
   * @param recipient the recipient's address
   * @param subject the subject
   * @param requestReadReceipt whether to ask for a read receipt
   */
  public void sendEmail(String recipient, String subject, boolean requestReadReceipt) {
    TextBoxElementFacade toField = composerToElement();
    toField.assertVisible();
    toField.sendKeys(recipient);
    toField.sendKeys(Keys.TAB);
    composerSubjectElement().setTextValue(subject);
    if (requestReadReceipt) {
      composerMoreOptionsElement().click();
      composerReadReceiptToggleElement().click();
      assertThat(composerReadReceiptToggleElement().getAttribute("aria-checked")).as("The read receipt should be requested")
                                                                                .isEqualTo("true");
      composerSubjectElement().click();
    }
    ElementFacade sendButton = composerSendButtonElement();
    sendButton.assertEnabled();
    sendButton.click();
    waitForLoading();
  }

  /**
   * Checks the composer's shared mailbox notice: the email is written as the
   * user, from the owner's mailbox.
   *
   * @param ownerName a name of the owner
   */
  public void checkComposerSharedMailboxNotice(String ownerName) {
    ElementFacade notice = composerSharedMailboxNoticeElement();
    notice.assertVisible();
    assertThat(notice.getText()).as("The composer's shared mailbox notice")
                                .contains("Writing as you from")
                                .contains(ownerName)
                                .contains("sent from your address, copy in your own Sent.");
  }

  /**
   * Checks the composer's "Copy &lt;owner&gt;" choice and whether it is ticked.
   *
   * @param ownerFullName the owner's full name, as the choice names it
   * @param checked whether it should be ticked
   */
  public void checkComposerCopyOwner(String ownerFullName, boolean checked) {
    composerCopyOwnerLabelElement("Copy " + ownerFullName).assertVisible();
    assertThat(composerCopyOwnerCheckboxElement().isSelected()).as("'Copy %s' should be %s",
                                                                   ownerFullName,
                                                                   checked ? "ticked" : "not ticked")
                                                               .isEqualTo(checked);
  }

  /**
   * Reads the width, in pixels, a column handle of the full-screen mailbox
   * announces.
   *
   * @param handleLabel the handle's name (Resize the folders column, Resize the
   *          mail list)
   * @return its width in pixels
   */
  public int getColumnWidth(String handleLabel) {
    ElementFacade handle = columnHandleElement(handleLabel);
    handle.assertVisible();
    return Integer.parseInt(handle.getAttribute("aria-valuenow"));
  }

  /**
   * Drags a column handle of the full-screen mailbox with the mouse.
   *
   * @param handleLabel the handle's name
   * @param offset the horizontal move, in pixels
   */
  public void dragColumnHandle(String handleLabel, int offset) {
    ElementFacade handle = columnHandleElement(handleLabel);
    handle.assertVisible();
    new Actions(getDriver()).moveToElement(handle)
                            .clickAndHold()
                            .moveByOffset(offset / 2, 0)
                            .moveByOffset(offset - offset / 2, 0)
                            .release()
                            .perform();
    waitForLoading();
  }

  /**
   * Double-clicks a column handle of the full-screen mailbox, which resets its
   * column.
   *
   * @param handleLabel the handle's name
   */
  public void doubleClickColumnHandle(String handleLabel) {
    ElementFacade handle = columnHandleElement(handleLabel);
    handle.assertVisible();
    new Actions(getDriver()).doubleClick(handle).perform();
    waitForLoading();
  }

  /**
   * Reads the unread badge of an application in the opened application
   * launcher.
   *
   * @param applicationTitle the application's title in the launcher
   * @return the count, 0 when no badge is shown
   */
  public int getApplicationBadge(String applicationTitle) {
    applicationLauncherItemElement(applicationTitle).assertVisible();
    ElementFacade badge = applicationBadgeElement(applicationTitle);
    if (!badge.isCurrentlyVisible()) {
      return 0;
    }
    String count = StringUtils.trim(badge.getText());
    return StringUtils.isNumeric(count) ? Integer.parseInt(count) : Integer.MAX_VALUE;
  }

  /**
   * Waits for the mail drawer to be open and its list loaded.
   */
  private void waitForMailBoxDrawer() {
    retryOnCondition(() -> mailBoxDrawerElement().assertVisible(), () -> {
      getDriver().navigate().refresh();
      verifyPageLoaded();
    });
    try {
      waitForDrawerToLoad();
    } catch (TimeoutException e) {
      // A synchronisation running in the background keeps the drawer's progress
      // bar on: the list is there, and the steps that read it retry on their own.
      LOGGER.debug("The mail drawer is still showing its progress bar", e);
    }
  }

  /**
   * Reloads the mailbox and brings it back to full screen.
   */
  private void reloadExpandedMailBox() {
    reloadMailBox();
    expandMailBox();
  }

  /**
   * Reloads the mailbox and shows the given folder again.
   *
   * @param folderLabel the folder, blank for the Inbox the drawer opens on
   */
  private void reloadOnFolder(String folderLabel) {
    if (StringUtils.isBlank(folderLabel)) {
      boolean expanded = folderColumnElement().isCurrentlyVisible();
      reloadMailBox();
      if (expanded) {
        expandMailBox();
      }
    } else {
      reloadExpandedMailBox();
      folderEntryElement(folderLabel).click();
      waitForLoading();
    }
  }

  /**
   * @return the open mail drawer
   */
  private ElementFacade mailBoxDrawerElement() {
    return findByXPathOrCSS(MAIL_DRAWER + "[contains(@class, 'v-navigation-drawer--open')]");
  }

  /**
   * @return the mail drawer's full-screen icon
   */
  private ElementFacade expandIconElement() {
    return findByXPathOrCSS(MAIL_DRAWER + "//*[contains(@class, 'fa-expand-alt')]");
  }

  /**
   * @return the full-screen folder column
   */
  private ElementFacade folderColumnElement() {
    return findByXPathOrCSS("(" + MAIL_DRAWER + "//*[@role='option'])[1]");
  }

  /**
   * @param title a title
   * @return the folder column's title, when it is that one
   */
  private ElementFacade folderColumnTitleElement(String title) {
    return findByXPathOrCSS(String.format(MAIL_DRAWER
        + "//*[contains(@class, 'v-subheader')]//span[contains(normalize-space(.), '%s')]", title));
  }

  /**
   * @param folderLabel a folder's label
   * @return the folder's entry in the folder column
   */
  private ElementFacade folderEntryElement(String folderLabel) {
    return findByXPathOrCSS(String.format(MAIL_DRAWER
        + "//*[@role='option' and .//*[contains(@class, 'v-list-item__title') and normalize-space(.)='%s']]", folderLabel));
  }

  /**
   * @return the folder column's "Manage folders" button
   */
  private ElementFacade manageFoldersButtonElement() {
    return findByXPathOrCSS(MAIL_DRAWER + "//button[@title='Manage folders']");
  }

  /**
   * @return the mailbox switcher of the drawer's title
   */
  private ElementFacade mailboxSwitcherElement() {
    return findByXPathOrCSS(MAIL_DRAWER + "//button[@aria-label='Switch mailbox']");
  }

  /**
   * @param label a text of an entry
   * @return the entry of the opened mailbox switcher
   */
  private ElementFacade switcherEntryElement(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'v-list-item__title') and contains(normalize-space(.), '%s')]",
                                          label));
  }

  /**
   * @return the band saying whose mailbox the user is in
   */
  private ElementFacade sharedMailboxBandElement() {
    return findByXPathOrCSS(MAIL_DRAWER + "//*[contains(@class, 'v-alert') and @role='status']");
  }

  /**
   * @param subject an email's subject
   * @return the email's row in the list shown
   */
  private ElementFacade emailRowElement(String subject) {
    return findByXPathOrCSS(String.format(MAIL_DRAWER
        + "//*[@data-thread-key and .//*[contains(@class, 'v-list-item__subtitle') and normalize-space(.)='%s']]", subject));
  }

  /**
   * @return the conversation shown, in the reader or in the full-screen drawer
   */
  private ElementFacade readingPaneElement() {
    return findByXPathOrCSS("//*[@id='emailDetailDrawer' and contains(@class, 'v-navigation-drawer--open')] | " + MAIL_DRAWER
        + "//*[@aria-current='true']");
  }

  /**
   * @return the reader drawer, open
   */
  private ElementFacade emailDetailDrawerElement() {
    return findByXPathOrCSS("//*[@id='emailDetailDrawer' and contains(@class, 'v-navigation-drawer--open')]");
  }

  /**
   * @param actionLabel an action's title
   * @return the action of the reading pane's toolbar
   */
  private ElementFacade readingPaneActionElement(String actionLabel) {
    return findByXPathOrCSS(String.format("(" + READING_PANE_HEADER + "//button[@title='%s'])[last()]", actionLabel));
  }

  /**
   * @param text a text
   * @return that text in the reading pane's toolbar
   */
  private ElementFacade readingPaneTextElement(String text) {
    return findByXPathOrCSS(String.format("(" + READING_PANE_HEADER + "//*[contains(normalize-space(text()), '%s')])[last()]",
                                          text));
  }

  /**
   * @return the read receipt request of the conversation shown
   */
  private ElementFacade readReceiptBannerElement() {
    return findByXPathOrCSS(READING_PANE + "//*[contains(@class, 'read-receipt-banner')]");
  }

  /**
   * @return the title of the shared mailbox confirmation
   */
  private ElementFacade sharedMailboxConfirmTitleElement() {
    return findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//*[contains(@class, 'popupHeader')]//*[contains(@class, 'text-title')]");
  }

  /**
   * @param buttonLabel Continue or Cancel
   * @return the button of the shared mailbox confirmation
   */
  private ElementFacade sharedMailboxConfirmButtonElement(String buttonLabel) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-dialog--active')]//button[normalize-space(.)='%s']",
                                          buttonLabel));
  }

  /**
   * @return the mail drawer's "Write an email" button
   */
  private ElementFacade newEmailButtonElement() {
    return findByXPathOrCSS(MAIL_DRAWER + "//button[@title='Write an email']");
  }

  /**
   * @return the composer's To field
   */
  private TextBoxElementFacade composerToElement() {
    return findTextBoxByXPathOrCSS("//*[@id='newEmailDrawer']//input[@id='to']");
  }

  /**
   * @return the composer's Subject field
   */
  private TextBoxElementFacade composerSubjectElement() {
    return findTextBoxByXPathOrCSS("//*[@id='newEmailDrawer']//textarea[@placeholder='Subject']");
  }

  /**
   * @return the composer's options button
   */
  private ElementFacade composerMoreOptionsElement() {
    return findByXPathOrCSS("//*[@id='newEmailDrawer']//button[contains(@class, 'composer-more-options')]");
  }

  /**
   * @return the composer's "Request a read receipt" option
   */
  private ElementFacade composerReadReceiptToggleElement() {
    return findByXPathOrCSS("//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'read-receipt-toggle')]");
  }

  /**
   * @return the composer's Send button
   */
  private ElementFacade composerSendButtonElement() {
    return findByXPathOrCSS("//*[@id='newEmailDrawer']//button[contains(@class, 'composer-send-button')]");
  }

  /**
   * @return the composer's shared mailbox notice
   */
  private ElementFacade composerSharedMailboxNoticeElement() {
    return findByXPathOrCSS("//*[@id='newEmailDrawer']//*[contains(@class, 'v-alert') and @role='status']");
  }

  /**
   * @param label the choice's label
   * @return the composer's "Copy &lt;owner&gt;" label
   */
  private ElementFacade composerCopyOwnerLabelElement(String label) {
    return findByXPathOrCSS(String.format("//*[@id='newEmailDrawer']//label[@for='emailSharedMailboxCopyOwner' and contains(normalize-space(.), '%s')]",
                                          label));
  }

  /**
   * @return the composer's "Copy &lt;owner&gt;" checkbox
   */
  private ElementFacade composerCopyOwnerCheckboxElement() {
    return findByXPathOrCSS("//*[@id='newEmailDrawer']//input[@id='emailSharedMailboxCopyOwner']");
  }

  /**
   * @param handleLabel a handle's name
   * @return the column handle of the full-screen mailbox
   */
  private ElementFacade columnHandleElement(String handleLabel) {
    return findByXPathOrCSS(String.format(MAIL_DRAWER + "//*[@role='separator' and @aria-label='%s']", handleLabel));
  }

  /**
   * @param applicationTitle an application's title
   * @return the application's item in the opened application launcher
   */
  private ElementFacade applicationLauncherItemElement(String applicationTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'appLauncherItemContainer')][.//*[contains(text(), '%s')]]",
                                          applicationTitle));
  }

  /**
   * @param applicationTitle an application's title
   * @return the unread badge of the application's item in the opened launcher
   */
  private ElementFacade applicationBadgeElement(String applicationTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'appLauncherItemContainer')][.//*[contains(text(), '%s')]]//*[contains(@class, 'badge-display')]//*[contains(@class, 'v-badge__badge')]",
                                          applicationTitle));
  }

}
