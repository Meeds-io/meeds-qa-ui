# Mailbox delegation, phase 1 (eXo email-connector add-on, EXO-90576).
# Covers exoplatform/email-connector #438 (share, answer), #440 (switcher, deep link,
# identity band, composer, Change access, Reader/Editor controls) and #441 (badge).
#
# @mailServer - the fixture every EmailConnector feature needs, which the default run
# does not have (hence excluded by the pom's default cucumber.filter.tags):
#  - the eXo email-connector add-on deployed, with an IMAP connector enabled by the
#    administrator (its name in io.meeds.email.connector.name, or the first connector
#    offering Connect is used);
#  - an IMAP + SMTP server supporting RFC 4314 ACL and exposing other users' mailboxes
#    (a shared/Other Users namespace, or Stalwart's "Shared Folders" tree): Stalwart
#    0.11+ or Dovecot 2.3+ with ACL and a shared namespace, mail logins being addresses;
#  - mail accounts on that server, passed as system properties, never written here:
#      io.meeds.email.<alias>.address / io.meeds.email.<alias>.password
#    for the aliases owner, delegate and sender (and archiver, see ArchiveFolder.feature).
#    The owner account has Sent, Archive, Trash and Spam folders, and an Inbox holding
#    more mail than one screen of the list;
#  - the application launcher lists the Email application under the title in
#    io.meeds.email.appTitle ("Email" when unset), for the unread badge scenario.
# Run with: -Dcucumber.filter.tags="@emailConnector and not @manual" -Dio.meeds.email.owner.address=...
@emailConnector @mailServer
Feature: Mailbox delegation - share a mailbox and work in it
  As a mailbox owner I want to let a colleague open my mailbox with their own account,
  and as that colleague I want to open it from the mail drawer and always know whose mailbox I am in

  Background:
    Given The mail server fixture provides the mail accounts 'owner, delegate'
    And I am authenticated as 'admin' if random users doesn't exists
      | mailowner    |
      | maildelegate |
    And I inject the mailowner random user if not existing, no wait
    And I inject the maildelegate random user if not existing
    And The 'mailowner' random user is connected to the 'owner' mail account
    And The 'maildelegate' random user is connected to the 'delegate' mail account

  @PR438
  Scenario: The owner shares the mailbox as Reader and the delegate accepts it
    Given I login as 'mailowner' random user
    And I open the email settings
    And I open the mailbox sharing drawer
    And I remove every access to my mailbox
    When I share my mailbox with the 'maildelegate' random user as 'Reader'
    Then Confirmation message is displayed 'Your mailbox is shared'
    And The 'maildelegate' random user is listed with 'Reader' access and status 'Pending'

    When I login as 'maildelegate' random user
    And I open the email settings
    Then The mailbox sharing setting shows '1 waiting for your answer'
    When I open the mailbox sharing drawer
    Then The mailbox sharing tab 'Shared with me' is selected
    And The mailbox of the 'mailowner' random user is offered with the answers 'Accept, Decline'
    When I answer 'Accept' to the mailbox of the 'mailowner' random user
    Then Confirmation message is displayed 'Mailbox added'
    And The mailbox of the 'mailowner' random user shows 'Count this mailbox in my unread badge'

    When I login as 'mailowner' random user
    And I open the email settings
    And I open the mailbox sharing drawer
    Then The 'maildelegate' random user is listed with 'Reader' access and status 'Accepted'

  @PR438
  Scenario: Declining a share keeps the access until the owner removes it
    Given The mailbox of the 'mailowner' random user is shared with the 'maildelegate' random user as 'Reader'
    When I login as 'maildelegate' random user
    And I open the email settings
    And I open the mailbox sharing drawer
    And I answer 'Decline' to the mailbox of the 'mailowner' random user
    Then Confirmation message is displayed 'Answer recorded. The access stays until its owner removes it.'
    And The mailbox of the 'mailowner' random user shows 'The access is still yours until its owner removes it.'
    And The mailbox of the 'mailowner' random user is offered with the answers 'Accept'

    When I login as 'mailowner' random user
    And I open the email settings
    And I open the mailbox sharing drawer
    Then The 'maildelegate' random user is listed with 'Reader' access and status 'Declined'

  @PR438
  Scenario: Leaving a shared mailbox takes it out of the delegate's mail drawer
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open my mailbox
    Then The mailbox switcher is displayed
    When I open the email settings
    And I open the mailbox sharing drawer
    And I select the mailbox sharing tab 'Shared with me'
    And I leave the mailbox of the 'mailowner' random user
    Then Confirmation message is displayed 'Mailbox removed from here. The access stays until its owner removes it.'
    And The mailbox of the 'mailowner' random user is no longer among my shared mailboxes
    When I open my mailbox
    Then The mailbox switcher is not displayed

  @PR440
  Scenario: The delegate switches between their own mailbox and the shared one
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open my mailbox
    And I open the mailbox switcher
    Then The mailbox switcher offers 'My mailbox'
    And The mailbox switcher offers the mailbox of the 'mailowner' random user
    And The mailbox switcher offers 'Manage shared mailboxes'
    When I switch to the mailbox of the 'mailowner' random user
    Then The shared mailbox band shows the mailbox of the 'mailowner' random user with 'Reader' access
    When I open the mailbox switcher
    And I choose 'My mailbox' in the mailbox switcher
    Then The shared mailbox band is not displayed

  @PR440 @PR445
  Scenario: Manage shared mailboxes opens the Shared with me tab on the first click
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open my mailbox
    And I open the mailbox switcher
    And I choose 'Manage shared mailboxes' in the mailbox switcher
    Then The mailbox sharing tab 'Shared with me' is selected
    And The mailbox of the 'mailowner' random user shows 'Count this mailbox in my unread badge'

  @PR440
  Scenario: A deep link opens the mail drawer straight on the shared mailbox
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open the mailbox of the 'mailowner' random user from its link
    Then The shared mailbox band shows the mailbox of the 'mailowner' random user with 'Reader' access

  @PR440
  Scenario: A deep link to a share that is gone opens the delegate's own mailbox and says why
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    And I keep the link to the mailbox of the 'mailowner' random user
    When I login as 'mailowner' random user
    And I open the email settings
    And I open the mailbox sharing drawer
    And I remove the access of the 'maildelegate' random user
    Then Confirmation message is displayed 'Access removed'
    When I login as 'maildelegate' random user
    And I open the kept link to the mailbox of the 'mailowner' random user
    Then Confirmation message is displayed 'This mailbox is no longer shared with you'
    And The shared mailbox band is not displayed

  # Fixture: the owner's Inbox must hold more mail than one screen of the list, or the
  # check fails saying so (a list that does not scroll proves nothing).
  @PR440
  Scenario: The identity band stays visible while the shared list scrolls
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open the mailbox of the 'mailowner' random user from its link
    Then The shared mailbox band stays in view when the mail list is scrolled to its end

  @PR440
  Scenario: Writing from a shared mailbox says who sends, and offers to copy the owner
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open the mailbox of the 'mailowner' random user from its link
    And I start a new email
    Then The composer says I write as myself from the mailbox of the 'mailowner' random user
    And The composer offers to copy the 'mailowner' random user, ticked

  @PR440
  Scenario: The owner changes a Reader into an Editor
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I login as 'mailowner' random user
    And I open the email settings
    And I open the mailbox sharing drawer
    And I change the access of the 'maildelegate' random user to 'Editor'
    Then Confirmation message is displayed 'Access changed'
    And The 'maildelegate' random user is listed with 'Editor' access and status 'Accepted'
    When I login as 'maildelegate' random user
    And I open the mailbox of the 'mailowner' random user from its link
    Then The shared mailbox band shows the mailbox of the 'mailowner' random user with 'Editor' access

  @PR440
  Scenario: A Reader can read the shared mailbox but not take mail out of it
    Given The 'maildelegate' random user sends a new email 'reader-controls' to the 'owner' mail account
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the 'reader-controls' email
    Then The reading pane offers 'Mark as unread'
    And The reading pane does not offer 'Delete, Archive, Mark as spam, Move to…'

  @PR440 @PR449
  Scenario: An Editor can take mail out of the shared mailbox
    Given The 'maildelegate' random user sends a new email 'editor-controls' to the 'owner' mail account
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Editor'
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the 'editor-controls' email
    Then The reading pane offers 'Mark as unread, Delete, Archive, Mark as spam'

  # The sender is a third account, so that the missing prompt is the shared mailbox's
  # doing and not the delegate reading their own email; the owner's prompt is the control.
  @PR440
  Scenario: A read receipt request is not offered to answer from a shared mailbox
    Given The mail server fixture provides the mail accounts 'sender'
    And I am authenticated as 'admin' if random users doesn't exists
      | mailsender |
    And I inject the mailsender random user if not existing
    And The 'mailsender' random user is connected to the 'sender' mail account
    And The 'mailsender' random user sends a new email 'receipt' asking for a read receipt to the 'owner' mail account
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the 'receipt' email
    Then The read receipt request is not displayed
    When I login as 'mailowner' random user
    And I open my mailbox
    And I open the 'receipt' email
    Then The read receipt request is displayed

  @PR440 @PR449
  Scenario: Taking mail out of a shared mailbox is confirmed once per session, naming the owner
    Given The 'maildelegate' random user sends a new email 'confirm-once' to the 'owner' mail account
    And The 'maildelegate' random user sends a new email 'confirm-twice' to the 'owner' mail account
    And The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Editor'
    And I forget the shared mailbox moves confirmed in this session
    When I open the mailbox of the 'mailowner' random user from its link
    And I open the 'confirm-once' email
    And I click on 'Delete' in the reading pane
    Then The confirmation 'Delete from' the mailbox of the 'mailowner' random user is displayed
    When I answer 'Continue' to the shared mailbox confirmation
    Then The 'confirm-once' email is not listed
    When I open the 'confirm-twice' email
    And I click on 'Delete' in the reading pane
    Then The 'confirm-twice' email is not listed

  @PR441
  Scenario: A shared mailbox counts in the unread badge only when the delegate chooses so
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    And The 'maildelegate' random user sends a new email 'badge' to the 'owner' mail account
    And I remember the unread badge of the Email application
    When I open the email settings
    And I open the mailbox sharing drawer
    And I select the mailbox sharing tab 'Shared with me'
    And I switch on the unread badge of the mailbox of the 'mailowner' random user
    Then The unread badge of the Email application is higher than remembered
    When I open the email settings
    And I open the mailbox sharing drawer
    And I select the mailbox sharing tab 'Shared with me'
    And I switch off the unread badge of the mailbox of the 'mailowner' random user
    Then The unread badge of the Email application is back to the remembered value

  # Two browser sessions at once: the owner revokes while the delegate's drawer is open
  # on the shared mailbox, and the delegate's next list refresh must leave it for their
  # own mailbox with "Your access to this mailbox was removed" / "This mailbox is no
  # longer shared with you". The suite drives a single browser, whose cookies are shared
  # by all its tabs, so it cannot hold both users at once. The single-session form of
  # this round-trip is the "share that is gone" deep link scenario above.
  @PR440 @manual
  Scenario: The owner revokes the access while the delegate is inside the shared mailbox
    Given The 'maildelegate' random user uses the mailbox of the 'mailowner' random user as 'Reader'
    When I open the mailbox of the 'mailowner' random user from its link
    Then The shared mailbox band shows the mailbox of the 'mailowner' random user with 'Reader' access
    And This round-trip is checked by hand: in a second browser the owner removes the access; the delegate's next list refresh leaves for their own mailbox with the toast 'This mailbox is no longer shared with you'

  # Needs an access written on the mail server outside eXo (for instance a SETACL made
  # with the server's admin tool, or its webmail), so that "Set to Reader" asks
  # "Replace this access?" first. The suite has no IMAP client to write one.
  @PR440 @manual
  Scenario: Setting a share made outside eXo to a preset asks to replace it first
    Given This round-trip is checked by hand: grant the delegate's address rights on the owner's Inbox from the mail server itself; in 'Who can open mine' the row says 'Granted on your mail server, not from eXo'; 'Set to Reader' asks 'Replace this access?' and 'Replace' then shows 'Access changed' with the row on Reader
