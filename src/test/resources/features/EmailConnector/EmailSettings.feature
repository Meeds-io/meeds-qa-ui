# The Email section of the user settings (eXo email-connector add-on, EXO-90576).
# Covers exoplatform/email-connector #445: one sharing row with a drawer of two tabs,
# and the rarely used settings under a collapsed, remembered "Advanced settings".
# Fixture (@mailServer): see the header of MailboxDelegation.feature.
@emailConnector @mailServer
Feature: Email settings - one sharing entry, and the rest under Advanced
  As a user with a connected mailbox I want the Email settings to open on what I change,
  with sharing in one place and the rarely used settings folded away

  Background:
    Given The mail server fixture provides the mail accounts 'owner'
    And I am authenticated as 'admin' if random users doesn't exists
      | mailowner |
    And I inject the mailowner random user if not existing
    And The 'mailowner' random user is connected to the 'owner' mail account

  @PR445
  Scenario: Mailbox sharing is one row, opening one drawer with two tabs
    Given I login as 'mailowner' random user
    When I open the email settings
    Then The email setting 'Mailbox sharing' is displayed outside Advanced settings
    When I open the mailbox sharing drawer
    Then The mailbox sharing tab 'Who can open mine' is displayed
    And The mailbox sharing tab 'Shared with me' is displayed
    And The mailbox sharing tab 'Who can open mine' is selected
    When I select the mailbox sharing tab 'Shared with me'
    Then The mailbox sharing tab 'Shared with me' is selected

  @PR445
  Scenario: Advanced settings are collapsed by default, remembered after a reload, with Reset last
    Given I login as 'mailowner' random user
    And I open the email settings
    And I forget whether the Advanced email settings were open
    When I open the email settings
    Then The email setting 'Default view' is displayed outside Advanced settings
    And The email setting 'Notifications' is displayed outside Advanced settings
    And The email setting 'Signature' is displayed outside Advanced settings
    And The email setting 'Mailbox sharing' is displayed outside Advanced settings
    And The Advanced email settings are collapsed
    When I open or close the Advanced email settings
    Then The Advanced email settings are expanded
    And The email setting 'Folders' is inside Advanced settings
    And The email setting 'Read receipts' is inside Advanced settings
    And Reset & re-sync is the last Advanced email setting
    When I open the email settings
    Then The Advanced email settings are expanded
    When I open or close the Advanced email settings
    And I open the email settings
    Then The Advanced email settings are collapsed

  @PR445
  Scenario: The read receipts row expands to its choices and its summary follows them
    Given I login as 'mailowner' random user
    And I open the email settings
    And I forget whether the Advanced email settings were open
    And I open the email settings
    And I open or close the Advanced email settings
    When I open or close the read receipt choices
    And I choose 'Never send' for read receipts
    Then The read receipts summary is 'Never send · requested by default: off'
    When I choose 'Ask me' for read receipts
    Then The read receipts summary is 'Ask me · requested by default: off'
