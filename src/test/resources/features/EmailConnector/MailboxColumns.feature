# Resizable columns of the full-screen mailbox (eXo email-connector add-on, EXO-90576).
# Covers exoplatform/email-connector #450. Defaults: folders 200 px, list 420 px.
# Fixture (@mailServer): see the header of MailboxDelegation.feature; the browser
# window must be at least 1400 px wide, or the reader's 480 px minimum makes the
# list give way before the widths asked here.
@emailConnector @mailServer
Feature: Full-screen mailbox - resizable columns
  As a user reading my mail in full screen I want to drag the column dividers to the
  widths I like, keep them after a reload, and get the defaults back with a double-click

  Background:
    Given The mail server fixture provides the mail accounts 'owner'
    And I am authenticated as 'admin' if random users doesn't exists
      | mailowner |
    And I inject the mailowner random user if not existing
    And The 'mailowner' random user is connected to the 'owner' mail account

  @PR450
  Scenario: The columns are resized by dragging, kept after a reload, and reset by a double-click
    Given I login as 'mailowner' random user
    And I open my mailbox
    And I forget the mailbox column widths
    When I open my mailbox
    And I open the mailbox in full screen
    Then The column handle 'Resize the folders column' is at 200 pixels
    And The column handle 'Resize the mail list' is at 420 pixels

    When I drag the column handle 'Resize the folders column' by 80 pixels
    And I drag the column handle 'Resize the mail list' by 60 pixels
    Then The column handle 'Resize the folders column' is at 280 pixels
    And The column handle 'Resize the mail list' is at 480 pixels

    When I reload my mailbox
    And I open the mailbox in full screen
    Then The column handle 'Resize the folders column' is at 280 pixels
    And The column handle 'Resize the mail list' is at 480 pixels

    When I double-click the column handle 'Resize the folders column'
    Then The column handle 'Resize the folders column' is at 200 pixels
    When I double-click the column handle 'Resize the mail list'
    Then The column handle 'Resize the mail list' is at 420 pixels
