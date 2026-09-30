# Mailbox delegation, phase 2.1: work in a shared mailbox's folders (eXo
# email-connector add-on, EXO-90576). Covers exoplatform/email-connector #449.
# Fixture (@mailServer): see the header of MailboxDelegation.feature.
@emailConnector @mailServer
Feature: Mailbox delegation - work in the owner's folders
  As a delegate I want to see the owner's Sent, Archive, Trash and Spam folders under
  the owner's name, and my Delete, Archive and Spam to file mail into the owner's
  folders, never into mine

  Background:
    Given The mail server fixture provides the mail accounts 'owner, delegate'
    And I am authenticated as 'admin' if random users doesn't exists
      | mailowner    |
      | maildelegate |
    And I inject the mailowner random user if not existing, no wait
    And I inject the maildelegate random user if not existing
    And The 'mailowner' random user is connected to the 'owner' mail account
    And The 'maildelegate' random user is connected to the 'delegate' mail account

  @PR449
  Scenario: The owner's folders are listed under the owner's name
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the mailbox in full screen
    Then The folder column is titled with the name of the 'mailowner' random user
    And The folder column lists 'Inbox'
    And The folder column lists 'Sent'
    And The folder column lists 'Archive'
    And The folder column lists 'Trash'
    And The folder column lists 'Spam'
    And The folder column does not list 'Drafts'
    And The folder column does not offer to manage folders

  @PR449
  Scenario Outline: An Editor's <action> files the message into the owner's <folder>, not the delegate's
    Given The 'maildelegate' random user sends a new email '<email>' to the 'owner' mail account
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Editor'
    And I forget the shared mailbox moves confirmed in this session
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the '<email>' email
    And I click on '<action>' in the reading pane
    Then The confirmation '<confirmation>' the mailbox of the 'mailowner' random user is displayed
    When I answer 'Continue' to the shared mailbox confirmation
    Then The '<email>' email is not listed

    When I open the mailbox in full screen
    And I open the folder '<folder>'
    Then The '<email>' email is listed

    # Not in the delegate's own folder - or the delegate has no such folder at all
    # (a Stalwart account has no Archive until it archives once).
    And The '<email>' email is not in my own '<folder>' folder

    When I login as 'mailowner' random user
    And I open my mailbox
    And I open the mailbox in full screen
    And I open the folder '<folder>'
    Then The '<email>' email is listed

    Examples:
      | action       | confirmation        | folder  | email       |
      | Delete       | Delete from         | Trash   | to-trash    |
      | Archive      | Archive from        | Archive | to-archive  |
      | Mark as spam | Report as spam from | Spam    | to-spam     |

  @PR449
  Scenario: Cancelling the confirmation keeps the message open, confirming it closes the reader
    Given The 'maildelegate' random user sends a new email 'cancel-keeps' to the 'owner' mail account
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Editor'
    And I forget the shared mailbox moves confirmed in this session
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the 'cancel-keeps' email
    And I click on 'Delete' in the reading pane
    And I answer 'Cancel' to the shared mailbox confirmation
    Then The reading pane is still open
    And The 'cancel-keeps' email is listed
    When I click on 'Delete' in the reading pane
    And I answer 'Continue' to the shared mailbox confirmation
    Then The reading pane is closed
    And The 'cancel-keeps' email is not listed

  @PR449
  Scenario: A Reader sees the owner's Trash read-only
    Given The 'maildelegate' random user sends a new email 'reader-trash' to the 'owner' mail account
    And The 'mailowner' random user runs 'Delete' on the 'reader-trash' email of their own Inbox
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the mailbox in full screen
    And I open the folder 'Trash'
    And I open the 'reader-trash' email
    Then The reading pane does not offer 'Restore, Delete permanently, Delete, Archive, Mark as spam, Move to…'

  @PR449
  Scenario: Nothing leaves a shared Trash, even for an Editor
    Given The 'maildelegate' random user sends a new email 'editor-trash' to the 'owner' mail account
    And The 'mailowner' random user runs 'Delete' on the 'editor-trash' email of their own Inbox
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Editor'
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the mailbox in full screen
    And I open the folder 'Trash'
    And I open the 'editor-trash' email
    Then The reading pane does not offer 'Restore, Delete permanently, Delete, Archive, Mark as spam, Move to…'

  @PR449
  Scenario: A shared Spam folder offers Delete but not "Not spam"
    Given The 'maildelegate' random user sends a new email 'shared-spam' to the 'owner' mail account
    And The 'mailowner' random user runs 'Mark as spam' on the 'shared-spam' email of their own Inbox
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Editor'
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the mailbox in full screen
    And I open the folder 'Spam'
    And I open the 'shared-spam' email
    Then The reading pane offers 'Delete'
    And The reading pane does not offer 'Not spam'

  # Needs a share eXo wrote before phase 2 (Inbox only: EMAIL_DELEGATION.GRANTED_ROLES
  # unset, ACL on INBOX only), which the current version can no longer create - every
  # new share covers Sent, Archive, Trash and Spam. The QA environment needs such a
  # share seeded for the owner/delegate pair (a phase-1 build, or a data fixture) for
  # these two scenarios to run.
  @PR449 @manual
  Scenario: An Inbox-only share shows a hint instead of Delete and Archive
    Given The 'maildelegate' random user sends a new email 'inbox-only' to the 'owner' mail account
    And I login as 'maildelegate' random user
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the 'inbox-only' email
    Then The reading pane does not offer 'Delete, Archive'
    And The reading pane says the 'mailowner' random user shares only the Inbox

  @PR449 @manual
  Scenario: The owner extends an Inbox-only share, and the owner's other folders appear
    Given I login as 'mailowner' random user
    And I open the email settings
    And I open the mailbox sharing drawer
    Then The 'maildelegate' random user row says 'Sees your Inbox only'
    When I extend the access of the 'maildelegate' random user to the other folders
    Then Confirmation message is displayed 'Your folders are now shared'
    When I login as 'maildelegate' random user
    And I open the mailbox of the 'mailowner' random user from its link
    And I open the mailbox in full screen
    Then The folder column lists 'Sent'
    And The folder column lists 'Trash'
