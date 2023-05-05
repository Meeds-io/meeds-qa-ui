@kudos
Feature: Kudos
  As an administrator I can modify kudos parameters

  Scenario: Sending and Receiving a kudos
    Given I connect as admin if random users doesn't exists
      | firstkudos  |
      | secondkudos  |
    And I create the firstkudos random user if not existing, no wait
    And I create the secondkudos random user if not existing
    When I connect with the secondkudos created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Kudos Post activity - EXISTANT-KUDOS 2'
    And I publish the activity
    Then the activity 'Kudos Post activity - EXISTANT-KUDOS 2' is displayed in activity stream

    And I connect with the firstkudos created user
    When I go to the random space
    And I send in the activity 'Kudos Post activity - EXISTANT-KUDOS 2' a kudos message 'Test Auto Kudos Module - EXISTANT-KUDOS 2'

    And I connect with the secondkudos created user
    And I go to My Profile page
    Then '1' kudos are received

  Scenario: User cannot send a kudos to himself
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing

    When I connect with the first created user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'Kudos Post - EXISTANT-KUDOS 5'
    And I publish the activity
    Then the activity 'Kudos Post - EXISTANT-KUDOS 5' is displayed in activity stream
    And kudos icon of the activity 'Kudos Post - EXISTANT-KUDOS 5' is Disabled

  Scenario: Sending a kudos from user profile
    Given I connect as admin if random users doesn't exists
      | thirdkudos  |
      | fourthkudos  |
    And I create the thirdkudos random user if not existing, no wait
    And I create the fourthkudos random user if not existing

    When I connect with the fourthkudos created user
    And I go to the thirdkudos user profile
    And I send kudos with message 'Message for kudos - EXISTANT-KUDOS 7'

    And I connect with the thirdkudos created user
    And I go to My Profile page
    Then '1' kudos are received

  Scenario: Edit a kudos activity
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user

    And I search for second user card
    And I click on three dots menu
    And I click on send kudos button and I send kudos with message 'Message for kudos - US51'
    And I go to Stream page
    Then the kudos activity UI 'Message for kudos - US51' is displayed in stream page
    And I click on three dots menu click on the edit button
    And I set the new kudos 'updated Message for kudos - US51' and I click on update button
    Then the updated Kudos activity 'updated Message for kudos - US51' is displayed in stream page

  Scenario: Send a kudos to someone different from the activity author
    Given I connect as admin if random users doesn't exists
      | fortyonekudos |
      | fortytwokudos |
      | fortythreekudos |
    And I create the fortyonekudos random user if not existing, no wait
    And I create the fortytwokudos random user if not existing, no wait
    And I create the fortythreekudos random user if not existing

    When I connect with the fortyonekudos created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Hello Team - US11'
    And I publish the activity
    Then the activity 'Hello Team - US11' is displayed in activity stream

    And I connect with the fortytwokudos created user
    And I go to the random space

    And I connect with the fortythreekudos created user
    When I go to the random space
    And I send in the activity 'Hello Team - US11' a kudos message 'Kudos Message US11' to 'fortytwokudos' user

    And I connect with the fortytwokudos created user
    And I go to My Profile page
    Then '1' kudos are received

  Scenario: People suggestor in invitation when members cannot be found
    Given I connect as admin if random users doesn't exists
      | fiftyonekudos |
      | fiftytwokudos |
      | fiftythreekudos |
    And I create the fiftyonekudos random user if not existing, no wait
    And I create the fiftytwokudos random user if not existing, no wait
    And I create the fiftythreekudos random user if not existing

    When I connect with the fiftyonekudos created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Hello Team - USX'
    And I publish the activity
    Then the activity 'Hello Team - USX' is displayed in activity stream

    And I connect with the fiftytwokudos created user
    When I go to the random space
    Then I send in the activity 'Hello Team - USX' a kudos message 'Kudos Message USX' to 'fiftythreekudos' user

  Scenario: Cancel Kudos sending from the activity author
    Given I connect as admin if random users doesn't exists
      | cancelfirst  |
      | cancelsecond |
    And I create the cancelfirst random user if not existing, no wait
    And I create the cancelsecond random user if not existing, no wait

    When I connect with the cancelsecond created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Kudos Post activity - Kudos comment to cancel'
    And I publish the activity

    And I connect with the cancelfirst created user
    When I go to the random space
    And I send in the activity 'Kudos Post activity - Kudos comment to cancel' a kudos message 'Kudos comment to cancel'

    And I connect with admin
    When I go to the random space
    Then In activity 'Kudos Post activity - Kudos comment to cancel' the cancel option in kudos comment 'Kudos comment to cancel' is not displayed
    Then In activity 'Kudos Post activity - Kudos comment to cancel' the delete option in kudos comment 'Kudos comment to cancel' is displayed

    When I connect with the cancelfirst created user
    And I go to the random space
    Then In activity 'Kudos Post activity - Kudos comment to cancel' the delete option in kudos comment 'Kudos comment to cancel' is not displayed

    When In activity 'Kudos Post activity - Kudos comment to cancel' I cancel the sent kudos comment 'Kudos comment to cancel'
    Then Comment 'Kudos comment to cancel' is not displayed in activity 'Kudos Post activity - Kudos comment to cancel'
    And I go to My Profile page
    Then '0' kudos are sent

    When I connect with the cancelsecond created user
    And I go to My Profile page
    Then '0' kudos are received

  Scenario: Cancel Kudos sending from user profile
    Given I connect as admin if random users doesn't exists
      | cancelfirst  |
      | cancelsecond |
    And I create the cancelfirst random user if not existing, no wait
    And I create the cancelsecond random user if not existing

    When I connect with the cancelfirst created user
    And I go to the cancelsecond user profile
    And I send kudos with message 'Message for kudos - Kudos to cancel'

    When I connect with the cancelsecond created user
    And I go to Stream page
    Then In kudos activity 'Message for kudos - Kudos to cancel' the cancel option is not displayed

    When I connect with the cancelfirst created user
    And I go to Stream page
    And I cancel the sent kudos activity 'Message for kudos - Kudos to cancel'
    Then the activity 'Message for kudos - Kudos to cancel' is no more displayed in the activity stream

    When I go to My Profile page
    Then '0' kudos are sent