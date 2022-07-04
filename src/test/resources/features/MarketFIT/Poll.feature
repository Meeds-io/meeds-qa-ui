Feature: Poll

  Scenario: Poll_US05_(01) : Post a poll_simple case
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create random space with the first created user

    When I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    Then I go to the created space

    When I click on post in space
    And I click on Create Poll
    And I created a simple poll with title 'Poll eXo' and Choice One 'QA Test' and Choice Two 'DevJ2EE'
    And I publish the Poll
    Then The Poll 'Poll eXo' is displayed in stream page

  Scenario: Poll_US05_(02) : Post a poll_all options
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create random space with the first created user

    When I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    Then I go to the created space

    When I click on post in space
    And I click on Create Poll
    And I try to create a poll with title 'Poll 2 eXo' and with a single choice 'QA Test 2'
    Then Create Poll Button is Disabled

    When I added the second choice 'DevJ2EE' in the poll
    Then Create Poll Button is Enabled

    When I add description with more than 1000 characters In the poll
    Then Create Poll Button is Disabled

    When I add description with less than 1000 characters In the poll
    Then Create Poll Button is Enabled

    When I click Create Poll
    And I publish the Poll
    Then The Poll 'Poll 2 eXo' is displayed in stream page

  Scenario: Poll_US04_(01) : Edit a poll_edit informations
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create random space with the first created user

    When I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    Then I go to the created space

    When I click on post in space
    And I click on Create Poll
    And I created a simple poll with title 'Poll test' and Choice One 'Option 1' and Choice Two 'Option 2'
    Then create poll drawer is closed
    When I click on Create Poll
    And I created a simple poll with title ' edited' and Choice One ' edited' and Choice Two ' edited'
    Then create poll drawer is closed

  Scenario: Poll_US05.1_(01) : Post a poll : create poll activity_with message
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create random space with the first created user

    When I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    Then I go to the created space

    When I click on post in space
    And I click on Create Poll
    And I created a simple poll with title 'Poll 3 eXo' and Choice One 'QA 3 Test' and Choice Two 'DevX'
    And I add a short message 'Activity Poll' for the Poll
    And I publish the Poll
    Then The Poll 'Poll 3 eXo' is displayed in stream page