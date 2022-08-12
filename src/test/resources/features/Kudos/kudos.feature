@kudos
Feature: Kudos
  As an administrator I can modify kudos parameters

  Scenario: [EXISTANT-KUDOS 3] Select the number of Kudos that a user is allowed to send per period
    Given I am authenticated as admin

    When I go to administration then reward then kudos
    And  I enter a number of kudos'8'
    And  I select type period per semester
    And I save all changes
    Then The kudos settings saved with a kudos number equal to '8' and 'Semester' period type

  Scenario: [EXISTANT-KUDOS 2] Sending and Receiving Kudos
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user
    When I connect with the second created user
    And I create random space with the first created user
    And I go to the created space
    And I click on post in space
    And I enter an activity 'Kudos Post activity'
    And I publish the activity
    Then the activity 'Kudos Post activity' is displayed in activity stream

    And I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    When I go to the created space
    And I sent to the activity 'Kudos Post activity' a kudos message 'Test Auto Kudos Module'

    And I connect with the second created user
    And I go to My Profile page
    Then '1' kudos are received

  Scenario: [EXISTANT-KUDOS 5] check that user cannot send kudos to himself
    Given I am authenticated as admin
    And I create the first random user

    When I connect with the first created user
    And I create the space
    When I click on post in space
    And I enter an activity 'Kudos Post'
    And I publish the activity
    Then the activity 'Kudos Post' is displayed in activity stream
    And kudos icon of the activity 'Kudos Post' is Disabled

  Scenario: [EXISTANT-KUDOS 7] Sending Kudos from user profile
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user

    When I connect with the second created user
    And I go to the first user profile
    And I send kudos with message 'Message for kudos'

    And I connect with the first created user
    And I go to My Profile page
    Then '1' kudos are received

  Scenario: [ActivityStream_US51][01]: Edit a kudos activity
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user
    When I connect with the first created user

    And I search for second user card
    And I click on three dots menu
    And I click on send kudos button and I send kudos with message 'Message for kudos'
    And I go to Stream page
    Then the kudos activity UI 'Message for kudos' is displayed in stream page
    And I click on three dots menu click on the edit button
    And I set the new kudos 'updated kudos message ' and I click on update button
    Then the updated Kudos activity 'updated kudos message ' is displayed in stream page
