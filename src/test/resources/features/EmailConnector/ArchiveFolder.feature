# Archive creates the Archive folder on first use (eXo email-connector add-on,
# EXO-90576). Covers exoplatform/email-connector #451.
# Fixture (@mailServer): see the header of MailboxDelegation.feature, plus an
# 'archiver' account (io.meeds.email.archiver.address / .password) whose mailbox has
# NO Archive folder when the run starts - a fresh Stalwart account has none (Inbox,
# Drafts, Sent Items, Deleted Items, Junk Mail). The scenario creates one, so the
# account must be reset (or its Archive folder deleted) before each run; the first
# check fails, saying so, when it was not.
@emailConnector @mailServer
Feature: Archive into a folder created on first use
  As a user whose mailbox has no Archive folder I want Archive to create it the first
  time, and to file into that same folder afterwards

  Background:
    Given The mail server fixture provides the mail accounts 'archiver, delegate'
    And I am authenticated as 'admin' if random users doesn't exists
      | mailarchiver |
      | maildelegate |
    And I inject the mailarchiver random user if not existing, no wait
    And I inject the maildelegate random user if not existing
    And The 'mailarchiver' random user is connected to the 'archiver' mail account
    And The 'maildelegate' random user is connected to the 'delegate' mail account

  @PR451
  Scenario: The first Archive creates the folder, the second one reuses it
    Given The 'maildelegate' random user sends a new email 'first-archive' to the 'archiver' mail account
    And The 'maildelegate' random user sends a new email 'second-archive' to the 'archiver' mail account
    When I login as 'mailarchiver' random user
    And I open my mailbox
    And I open the mailbox in full screen
    Then The folder column does not list 'Archive'

    When I open the 'first-archive' email
    And I click on 'Archive' in the reading pane
    Then The 'first-archive' email is not listed
    And The folder column lists 'Archive'

    When I open the 'second-archive' email
    And I click on 'Archive' in the reading pane
    Then The 'second-archive' email is not listed
    When I open the folder 'Archive'
    Then The 'first-archive' email is listed
    And The 'second-archive' email is listed
    And The folder column lists 'Archive' once

  # Needs a mail server that refuses the CREATE (a quota, or an ACL withholding 'k' on
  # the mailbox root) for this one account; the suite cannot set that up, and the
  # add-on only refuses without creating, which leaves nothing to observe on a server
  # that accepts. Expected: an error toast "1 email cannot be archived" and the message
  # still in the Inbox.
  @PR451 @manual
  Scenario: A server that refuses to create the Archive folder leaves the message in the Inbox
    Given The 'maildelegate' random user sends a new email 'refused-archive' to the 'archiver' mail account
    When I login as 'mailarchiver' random user
    And I open my mailbox
    And I open the 'refused-archive' email
    And I click on 'Archive' in the reading pane
    Then Confirmation message is displayed '1 email cannot be archived'
    And The 'refused-archive' email is listed
