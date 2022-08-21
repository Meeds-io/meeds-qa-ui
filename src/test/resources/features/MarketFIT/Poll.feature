@poll
Feature: Poll

  @test
  Scenario: Poll_US05_(01) : Post a poll_simple case
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I go to the random space

    When I connect with the first created user
    Then I go to the random space

    When I click on post in space
    And I click on Create Poll
    And I created a simple poll with title 'Poll Test' and Choice One 'QA Test' and Choice Two 'DevJEE'
    And I publish the Poll
    Then The Poll 'Poll Test' is displayed in stream page

  Scenario: Poll_US05_(02) : Post a poll_all options
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I go to the random space

    When I connect with the first created user
    Then I go to the random space

    When I click on post in space
    And I click on Create Poll
    And I try to create a poll with title 'Poll 2 Test' and with a single choice 'QA Test 2'
    Then Create Poll Button is Disabled

    When I added the second choice 'DevJEE' in the poll
    Then Create Poll Button is Enabled

    When I add description with more than 1000 characters In the poll
    Then Create Poll Button is Disabled

    When I add description with less than 1000 characters In the poll
    Then Create Poll Button is Enabled

    When I click Create Poll
    And I publish the Poll
    Then The Poll 'Poll 2 Test' is displayed in stream page

  @test
  Scenario: Poll_US04_(01) : Edit a poll_edit informations
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I go to the random space

    When I connect with the first created user
    Then I go to the random space

    When I click on post in space
    And I click on Create Poll
    And I created a simple poll with title 'Poll test' and Choice One 'Option 1' and Choice Two 'Option 2'
    Then create poll drawer is closed
    When I click on Create Poll
    And I created a simple poll with title ' edited' and Choice One ' edited' and Choice Two ' edited'
    Then create poll drawer is closed

  @test
  Scenario: Poll_US05.1_(01) : Post a poll : create poll activity_with message
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I go to the random space

    When I connect with the first created user
    Then I go to the random space

    When I click on post in space
    And I click on Create Poll
    And I created a simple poll with title 'Poll 3 Test' and Choice One 'QA 3 Test' and Choice Two 'DevX'
    And I add a short message 'Activity Poll' for the Poll
    And I publish the Poll
    Then The Poll 'Poll 3 Test' is displayed in stream page