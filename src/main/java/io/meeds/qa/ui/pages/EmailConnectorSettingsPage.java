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

import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

/**
 * The Email section of the user settings page, contributed by the eXo
 * email-connector add-on: the mailbox connection, the "Mailbox sharing" row and
 * its drawer (tabs "Who can open mine" / "Shared with me", EXO-90503, EXO-90531,
 * EXO-90559) and the "Advanced settings" section. Labels are the English
 * bundles of the add-on (emailConnectorUserSetting_en.properties).
 */
public class EmailConnectorSettingsPage extends GenericPage {

  /** The localStorage key remembering whether "Advanced settings" is open. */
  private static final String ADVANCED_EXPANDED_KEY = "emailConnector.userSetting.advancedExpanded";

  /** An XPath predicate matching a Vuetify list item, not its inner parts. */
  private static final String LIST_ITEM             = "contains(concat(' ', normalize-space(@class), ' '), ' v-list-item ')";

  /** The mailbox sharing drawer. */
  private static final String SHARING_DRAWER        = "//*[@id='userSettingMailboxSharingDrawer']";

  /**
   * Builds the page on the current web driver.
   *
   * @param driver the web driver
   */
  public EmailConnectorSettingsPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Opens the user settings page and waits for its Email section.
   */
  public void openEmailSettings() {
    goToPage("/portal/dw/settings");
    retryOnCondition(() -> emailSettingsApplicationElement().assertVisible(), () -> {
      getDriver().navigate().refresh();
      verifyPageLoaded();
    });
  }

  /**
   * Tells whether the current user's mailbox is connected to the given address.
   * Asked of the server, from the endpoint the Email section itself reads
   * ({@code GET /email-connector/rest/user-email-setting}): the section shows
   * "Connect your email box to the platform" until that answer arrives, so the
   * screen cannot tell a mailbox not connected from a section still loading.
   *
   * @param emailAddress the mailbox address
   * @return true when that address is the connected mailbox
   */
  public boolean isConnectedTo(String emailAddress) {
    Object connected = ((JavascriptExecutor) getDriver()).executeAsyncScript("const address = arguments[0].toLowerCase();"
        + "const done = arguments[arguments.length - 1];"
        + "fetch('/email-connector/rest/user-email-setting', {credentials: 'include', cache: 'no-store'})"
        + ".then(resp => resp.ok ? resp.json() : null)"
        + ".then(setting => done(!!setting && !!setting.connected"
        + "  && String(setting.emailAddress || '').toLowerCase() === address))"
        + ".catch(() => done(false));", emailAddress);
    return Boolean.TRUE.equals(connected);
  }

  /**
   * Connects the current user's mailbox from the Email section: the connectors
   * drawer, the connector's Connect button, then the address and password form.
   *
   * @param connectorName the connector to use, as its administrator named it;
   *          blank for the first connector offering Connect
   * @param emailAddress the mailbox address
   * @param password the mailbox password
   */
  public void connectMailbox(String connectorName, String emailAddress, String password) {
    editConnectionButtonElement().click();
    waitForOpenedDrawer("userSettingConnectorsDrawer");
    connectButtonElement(connectorName).click();
    waitForOpenedDrawer("userSettingDrawer");
    emailAddressInputElement().setTextValue(emailAddress);
    mailPasswordInputElement().setTextValue(password);
    ElementFacade saveButton = connectionSaveButtonElement();
    saveButton.assertEnabled();
    saveButton.click();
    waitForLoading();
  }

  /**
   * Opens the "Mailbox sharing" drawer from its settings row.
   */
  public void openMailboxSharingDrawer() {
    sharingEditButtonElement().click();
    waitForOpenedDrawer("userSettingMailboxSharingDrawer");
    waitForDrawerToLoad();
  }

  /**
   * Checks the "Mailbox sharing" settings row shows the given text in its
   * summary lines.
   *
   * @param text a text of the summary, or of the pending-invitations line
   */
  public void checkSharingRowShows(String text) {
    retryOnCondition(() -> sharingRowTextElement(text).assertVisible(), this::openEmailSettings);
  }

  /**
   * Selects a tab of the "Mailbox sharing" drawer.
   *
   * @param tabLabel the tab's label
   */
  public void selectSharingTab(String tabLabel) {
    sharingTabElement(tabLabel).click();
    waitForLoading();
  }

  /**
   * Checks a tab of the "Mailbox sharing" drawer is the selected one.
   *
   * @param tabLabel the tab's label
   */
  public void checkSharingTabSelected(String tabLabel) {
    ElementFacade tab = sharingTabElement(tabLabel);
    tab.assertVisible();
    assertThat(tab.getAttribute("aria-selected")).as("The sharing tab '%s' should be selected", tabLabel)
                                                 .isEqualTo("true");
  }

  /**
   * Checks the "Mailbox sharing" drawer shows a tab with the given label.
   *
   * @param tabLabel the tab's label
   */
  public void checkSharingTabDisplayed(String tabLabel) {
    sharingTabElement(tabLabel).assertVisible();
  }

  /**
   * Removes, one by one, every access the "Who can open mine" tab offers to
   * remove, so that a scenario starts from a mailbox shared with nobody even
   * when a previous run left an access on the mail server.
   */
  public void removeEveryAccess() {
    selectSharingTab("Who can open mine");
    sharingHintElement().assertVisible();
    waitForDrawerToLoad();
    int remaining = MAX_WAIT_RETRIES * 4;
    while (remaining-- > 0 && firstGranteeMenuElement().isCurrentlyVisible()) {
      firstGranteeMenuElement().click();
      clickOpenedMenuItem("Remove access");
      clickToConfirmDialog();
      waitForLoading();
      waitForDrawerToLoad();
    }
    assertThat(firstGranteeMenuElement().isCurrentlyVisible()).as("Every access to the mailbox should have been removed")
                                                             .isFalse();
  }

  /**
   * Shares the current user's mailbox with a person, from the drawer's Share
   * button.
   *
   * @param granteeName a name the person is found by in the people suggester
   * @param presetLabel the access to give, as the invite drawer names it
   *          (Reader or Editor)
   */
  public void shareMailbox(String granteeName, String presetLabel) {
    selectSharingTab("Who can open mine");
    shareButtonElement().click();
    waitForOpenedDrawer("userSettingSharingInviteDrawer");
    assertThat(mentionInField(granteeSuggesterElement(), granteeName, 5)).as("The person '%s' should be suggested",
                                                                             granteeName)
                                                                         .isTrue();
    presetRadioElement(presetLabel).click();
    ElementFacade shareButton = inviteShareButtonElement();
    shareButton.assertEnabled();
    shareButton.click();
    waitForLoading();
  }

  /**
   * Checks a person's row in the "Who can open mine" tab shows the given access
   * and status.
   *
   * @param granteeName a name shown on the person's row
   * @param presetLabel the access chip (Reader, Editor, ...)
   * @param statusLabel the status chip (Pending, Accepted, Declined, ...)
   */
  public void checkGranteeRow(String granteeName, String presetLabel, String statusLabel) {
    selectSharingTab("Who can open mine");
    retryOnCondition(() -> {
      granteeChipElement(granteeName, presetLabel).assertVisible();
      granteeChipElement(granteeName, statusLabel).assertVisible();
    }, this::reopenMailboxSharingDrawer);
  }

  /**
   * Checks a person's row in the "Who can open mine" tab shows the given line of
   * text, for instance "Sees your Inbox only".
   *
   * @param granteeName a name shown on the person's row
   * @param text the line of text
   */
  public void checkGranteeRowText(String granteeName, String text) {
    selectSharingTab("Who can open mine");
    granteeRowTextElement(granteeName, text).assertVisible();
  }

  /**
   * Runs an action of a person's row menu in the "Who can open mine" tab.
   *
   * @param granteeName a name shown on the person's row
   * @param actionLabel the menu item (Reader, Editor, Remove access, ...)
   */
  public void clickGranteeMenuAction(String granteeName, String actionLabel) {
    selectSharingTab("Who can open mine");
    granteeMenuElement(granteeName).click();
    clickOpenedMenuItem(actionLabel);
  }

  /**
   * Checks the mailbox of a person is in the "Shared with me" tab, offering the
   * given answers as buttons.
   *
   * @param ownerName a name shown on the owner's row
   * @param answers the buttons expected on the row, comma separated
   */
  public void checkSharedMailboxAnswers(String ownerName, String answers) {
    selectSharingTab("Shared with me");
    retryOnCondition(() -> {
      for (String answer : StringUtils.split(answers, ",")) {
        sharedMailboxAnswerElement(ownerName, answer.trim()).assertVisible();
      }
    }, this::reopenMailboxSharingDrawerOnSharedWithMe);
  }

  /**
   * Checks the row of a mailbox in the "Shared with me" tab shows the given line
   * of text.
   *
   * @param ownerName a name shown on the owner's row
   * @param text the line of text, for instance its note
   */
  public void checkSharedMailboxRowText(String ownerName, String text) {
    selectSharingTab("Shared with me");
    retryOnCondition(() -> sharedMailboxRowTextElement(ownerName, text).assertVisible(),
                     this::reopenMailboxSharingDrawerOnSharedWithMe);
  }

  /**
   * Answers a share in the "Shared with me" tab with one of the row's buttons.
   *
   * @param ownerName a name shown on the owner's row
   * @param answer the button (Accept, Decline)
   */
  public void answerSharedMailbox(String ownerName, String answer) {
    selectSharingTab("Shared with me");
    retryOnCondition(() -> sharedMailboxAnswerElement(ownerName, answer).assertVisible(),
                     this::reopenMailboxSharingDrawerOnSharedWithMe);
    sharedMailboxAnswerElement(ownerName, answer).click();
    waitForLoading();
  }

  /**
   * Leaves a mailbox shared with the user, from its row menu, and confirms.
   *
   * @param ownerName a name shown on the owner's row
   */
  public void leaveSharedMailbox(String ownerName) {
    selectSharingTab("Shared with me");
    sharedMailboxMenuElement(ownerName).click();
    clickOpenedMenuItem("Leave");
    clickToConfirmDialog();
    waitForLoading();
  }

  /**
   * Sets the "Count this mailbox in my unread badge" switch of a mailbox shared
   * with the user.
   *
   * @param ownerName a name shown on the owner's row
   * @param enabled whether the mailbox should count
   */
  public void setSharedMailboxBadge(String ownerName, boolean enabled) {
    selectSharingTab("Shared with me");
    ElementFacade switchInput = sharedMailboxBadgeSwitchElement(ownerName);
    switchInput.assertVisible();
    boolean checked = StringUtils.equals(switchInput.getAttribute("aria-checked"), "true");
    if (checked != enabled) {
      sharedMailboxBadgeSwitchElement(ownerName).findByXPath("./ancestor::*[contains(@class, 'v-input--selection-controls__input')]")
                                                .click();
      waitForLoading();
    }
  }

  /**
   * Forgets whether "Advanced settings" was left open, so the section shows in
   * its default state on the next visit.
   */
  public void forgetAdvancedSettingsState() {
    ((JavascriptExecutor) getDriver()).executeScript("try { window.localStorage.removeItem(arguments[0]); } catch (e) { /* no storage */ }",
                                                     ADVANCED_EXPANDED_KEY);
  }

  /**
   * Opens or closes "Advanced settings" with its header button.
   */
  public void toggleAdvancedSettings() {
    advancedToggleElement().click();
    waitForLoading();
  }

  /**
   * Checks whether "Advanced settings" is open: the header button's state and the
   * section's content agree.
   *
   * @param expanded whether the section should be open
   */
  public void checkAdvancedSettingsExpanded(boolean expanded) {
    ElementFacade toggle = advancedToggleElement();
    toggle.assertVisible();
    assertThat(toggle.getAttribute("aria-expanded")).as("The Advanced settings header should say whether it is open")
                                                    .isEqualTo(String.valueOf(expanded));
    if (expanded) {
      advancedContentElement().assertVisible();
    } else {
      advancedContentElement().assertNotVisible();
    }
  }

  /**
   * Checks an Email setting row, by its title, is visible outside "Advanced
   * settings".
   *
   * @param title the row's title
   */
  public void checkSettingOutsideAdvanced(String title) {
    settingRowOutsideAdvancedElement(title).assertVisible();
  }

  /**
   * Checks an Email setting row, by its title, is inside "Advanced settings".
   *
   * @param title the row's title
   */
  public void checkSettingInsideAdvanced(String title) {
    settingRowInsideAdvancedElement(title).assertVisible();
  }

  /**
   * Checks "Reset &amp; re-sync" is the last row of "Advanced settings".
   */
  public void checkResetIsLastAdvancedSetting() {
    lastAdvancedRowElement().assertVisible();
    assertThat(lastAdvancedRowElement().getText()).as("Reset & re-sync should be the last advanced setting")
                                                  .contains("Reset & re-sync");
  }

  /**
   * Opens or closes the read receipts choices with the row's expand button.
   */
  public void toggleReadReceiptChoices() {
    readReceiptToggleElement().click();
    waitForLoading();
  }

  /**
   * Chooses what to do when somebody asks for a read receipt.
   *
   * @param policyLabel the choice (Ask me, Never send, Always send)
   */
  public void chooseReadReceiptPolicy(String policyLabel) {
    readReceiptPolicyElement(policyLabel).click();
    waitForLoading();
  }

  /**
   * Checks the read receipts row summary.
   *
   * @param summary the expected summary
   */
  public void checkReadReceiptSummary(String summary) {
    retryOnCondition(() -> assertThat(readReceiptSummaryElement().getText()).as("The read receipts summary")
                                                                            .isEqualTo(summary));
  }

  /**
   * Waits for a drawer, by its id, to be open. The suite's
   * {@code waitForDrawerToOpen(String, boolean)} waits for any open drawer.
   *
   * @param drawerId the drawer's id
   */
  private void waitForOpenedDrawer(String drawerId) {
    findByXPathOrCSS(String.format("//*[@id='%s' and contains(@class, 'v-navigation-drawer--open')]", drawerId)).waitUntilVisible();
  }

  /**
   * Closes the sharing drawer and opens it again, so that its tabs read the
   * server again.
   */
  private void reopenMailboxSharingDrawer() {
    closeAllDrawers();
    openMailboxSharingDrawer();
    selectSharingTab("Who can open mine");
  }

  /**
   * Reopens the sharing drawer on its "Shared with me" tab.
   */
  private void reopenMailboxSharingDrawerOnSharedWithMe() {
    reopenMailboxSharingDrawer();
    selectSharingTab("Shared with me");
  }

  /**
   * Clicks an item of the menu currently open.
   *
   * @param label the item's label
   */
  private void clickOpenedMenuItem(String label) {
    ElementFacade item = openedMenuItemElement(label);
    item.assertVisible();
    item.click();
    waitForLoading();
  }

  /**
   * @return the Email section of the settings page
   */
  private ElementFacade emailSettingsApplicationElement() {
    return findByXPathOrCSS("//*[@id='emailConnectorUserSetting']");
  }

  /**
   * @return the hint heading the "Who can open mine" tab once it has loaded
   */
  private ElementFacade sharingHintElement() {
    return findByXPathOrCSS(SHARING_DRAWER + "//*[contains(normalize-space(text()), 'This list comes from your mail server')]");
  }

  /**
   * @return the button opening the connectors drawer
   */
  private ElementFacade editConnectionButtonElement() {
    return findByXPathOrCSS("(//*[@id='emailConnectorUserSetting']//button[@title='Edit Connection Information'])[1]");
  }

  /**
   * @param connectorName the connector's name, blank for the first one offering
   *          Connect
   * @return the connector's Connect button
   */
  private ElementFacade connectButtonElement(String connectorName) {
    if (StringUtils.isBlank(connectorName)) {
      return findByXPathOrCSS("(//*[@id='userSettingConnectorsDrawer']//button[normalize-space(.)='Connect' and not(@disabled)])[1]");
    }
    return findByXPathOrCSS(String.format("//*[@id='userSettingConnectorsDrawer']//*[%s][.//span[normalize-space(.)='%s']]//button[normalize-space(.)='Connect']",
                                          LIST_ITEM,
                                          connectorName));
  }

  /**
   * @return the address field of the connection drawer
   */
  private TextBoxElementFacade emailAddressInputElement() {
    return findTextBoxByXPathOrCSS("//*[@id='userSettingDrawer']//input[@id='email']");
  }

  /**
   * @return the password field of the connection drawer
   */
  private TextBoxElementFacade mailPasswordInputElement() {
    return findTextBoxByXPathOrCSS("//*[@id='userSettingDrawer']//input[@id='password']");
  }

  /**
   * @return the Save button of the connection drawer
   */
  private ElementFacade connectionSaveButtonElement() {
    return findByXPathOrCSS("(//*[@id='userSettingDrawer']//button[contains(normalize-space(.), 'Save')])[last()]");
  }

  /**
   * @return the edit button of the "Mailbox sharing" row
   */
  private ElementFacade sharingEditButtonElement() {
    return findByXPathOrCSS("//*[@id='emailConnectorUserSetting']//button[@title='Manage mailbox sharing']");
  }

  /**
   * @param text a text of the row's summary lines
   * @return that line of the "Mailbox sharing" row
   */
  private ElementFacade sharingRowTextElement(String text) {
    return findByXPathOrCSS(String.format("//*[@id='emailConnectorUserSetting']//*[%s][.//*[contains(@class, 'v-list-item__title') and normalize-space(.)='Mailbox sharing']]//*[contains(@class, 'v-list-item__subtitle') and contains(normalize-space(.), '%s')]",
                                          LIST_ITEM,
                                          text));
  }

  /**
   * @param tabLabel a tab's label
   * @return the tab of the sharing drawer
   */
  private ElementFacade sharingTabElement(String tabLabel) {
    return findByXPathOrCSS(String.format(SHARING_DRAWER + "//*[@role='tab' and contains(normalize-space(.), '%s')]", tabLabel));
  }

  /**
   * @return the Share button of the sharing drawer's first tab
   */
  private ElementFacade shareButtonElement() {
    return findByXPathOrCSS(SHARING_DRAWER + "//button[@title='Share']");
  }

  /**
   * @return the people suggester of the invite drawer
   */
  private TextBoxElementFacade granteeSuggesterElement() {
    return findTextBoxByXPathOrCSS("//*[@id='userSettingSharingInviteDrawer']//input[@content-class='identitySuggesterContent']");
  }

  /**
   * @param presetLabel Reader or Editor
   * @return the radio button of that access in the invite drawer
   */
  private ElementFacade presetRadioElement(String presetLabel) {
    return findByXPathOrCSS(String.format("//*[@id='userSettingSharingInviteDrawer']//*[contains(@class, 'v-radio')][.//span[normalize-space(.)='%s']]//input/parent::*",
                                          presetLabel));
  }

  /**
   * @return the Share button of the invite drawer
   */
  private ElementFacade inviteShareButtonElement() {
    return findByXPathOrCSS("(//*[@id='userSettingSharingInviteDrawer']//button[normalize-space(.)='Share'])[last()]");
  }

  /**
   * @return the menu button of the first row of the "Who can open mine" tab
   */
  private ElementFacade firstGranteeMenuElement() {
    return findByXPathOrCSS("(" + SHARING_DRAWER + "//button[@aria-label='More actions'])[1]");
  }

  /**
   * @param name a name shown on a row of the sharing drawer
   * @return the row
   */
  private String sharingRowXPath(String name) {
    return String.format(SHARING_DRAWER + "//*[%s][.//*[contains(normalize-space(text()), '%s')]]", LIST_ITEM, name);
  }

  /**
   * @param granteeName a name shown on the person's row
   * @param chipLabel a chip's label
   * @return the chip on the person's row
   */
  private ElementFacade granteeChipElement(String granteeName, String chipLabel) {
    return findByXPathOrCSS(sharingRowXPath(granteeName)
        + String.format("//*[contains(@class, 'v-chip') and normalize-space(.)='%s']", chipLabel));
  }

  /**
   * @param granteeName a name shown on the person's row
   * @param text a line of text
   * @return that line on the person's row
   */
  private ElementFacade granteeRowTextElement(String granteeName, String text) {
    return findByXPathOrCSS(sharingRowXPath(granteeName) + String.format("//*[contains(normalize-space(text()), '%s')]", text));
  }

  /**
   * @param granteeName a name shown on the person's row
   * @return the person's row menu button
   */
  private ElementFacade granteeMenuElement(String granteeName) {
    return findByXPathOrCSS(sharingRowXPath(granteeName) + "//button[@aria-label='More actions']");
  }

  /**
   * @param ownerName a name shown on the owner's row
   * @param answer a button label
   * @return the button on the owner's row of the "Shared with me" tab
   */
  private ElementFacade sharedMailboxAnswerElement(String ownerName, String answer) {
    return findByXPathOrCSS(sharingRowXPath(ownerName) + String.format("//button[normalize-space(.)='%s']", answer));
  }

  /**
   * @param ownerName a name shown on the owner's row
   * @param text a line of text
   * @return that line on the owner's row of the "Shared with me" tab
   */
  private ElementFacade sharedMailboxRowTextElement(String ownerName, String text) {
    return findByXPathOrCSS(sharingRowXPath(ownerName) + String.format("//*[contains(normalize-space(text()), '%s')]", text));
  }

  /**
   * @param ownerName a name shown on the owner's row
   * @return the owner's row menu button in the "Shared with me" tab
   */
  private ElementFacade sharedMailboxMenuElement(String ownerName) {
    return findByXPathOrCSS(sharingRowXPath(ownerName) + "//button[@aria-label='More actions']");
  }

  /**
   * @param ownerName a name shown on the owner's row
   * @return the input of the owner's row badge switch
   */
  private ElementFacade sharedMailboxBadgeSwitchElement(String ownerName) {
    return findByXPathOrCSS(sharingRowXPath(ownerName)
        + "//input[@role='switch' and @aria-label='Count this mailbox in my unread badge']");
  }

  /**
   * @param label a menu item's label
   * @return the item of the menu currently open
   */
  private ElementFacade openedMenuItemElement(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'v-list-item__title') and normalize-space(.)='%s']",
                                          label));
  }

  /**
   * @return the header button of "Advanced settings"
   */
  private ElementFacade advancedToggleElement() {
    return findByXPathOrCSS("//*[@id='emailConnectorUserSetting']//button[@aria-controls='emailConnectorAdvancedSettings']");
  }

  /**
   * @return the content of "Advanced settings"
   */
  private ElementFacade advancedContentElement() {
    return findByXPathOrCSS("//*[@id='emailConnectorAdvancedSettings']");
  }

  /**
   * @param title a setting row's title
   * @return the row, outside "Advanced settings"
   */
  private ElementFacade settingRowOutsideAdvancedElement(String title) {
    return findByXPathOrCSS(String.format("//*[@id='emailConnectorUserSetting']//*[contains(@class, 'v-list-item__title') and normalize-space(.)='%s' and not(ancestor::*[@id='emailConnectorAdvancedSettings'])]",
                                          title));
  }

  /**
   * @param title a setting row's title
   * @return the row, inside "Advanced settings"
   */
  private ElementFacade settingRowInsideAdvancedElement(String title) {
    return findByXPathOrCSS(String.format("//*[@id='emailConnectorAdvancedSettings']//*[contains(@class, 'v-list-item__title') and normalize-space(.)='%s']",
                                          title));
  }

  /**
   * @return the last setting row of "Advanced settings"
   */
  private ElementFacade lastAdvancedRowElement() {
    return findByXPathOrCSS(String.format("(//*[@id='emailConnectorAdvancedSettings']//*[%s])[last()]", LIST_ITEM));
  }

  /**
   * @return the expand button of the read receipts row
   */
  private ElementFacade readReceiptToggleElement() {
    return findByXPathOrCSS("//*[@id='emailConnectorUserSetting']//button[@aria-controls='emailConnectorReadReceiptChoices']");
  }

  /**
   * @param policyLabel a read receipt choice
   * @return its radio button
   */
  private ElementFacade readReceiptPolicyElement(String policyLabel) {
    return findByXPathOrCSS(String.format("//*[@id='emailConnectorReadReceiptChoices']//*[contains(@class, 'v-radio')][.//label[normalize-space(.)='%s']]//input/parent::*",
                                          policyLabel));
  }

  /**
   * @return the summary line of the read receipts row
   */
  private ElementFacade readReceiptSummaryElement() {
    return findByXPathOrCSS("//*[contains(@class, 'read-receipt-settings')]//*[contains(@class, 'v-list-item__subtitle')]");
  }

}
