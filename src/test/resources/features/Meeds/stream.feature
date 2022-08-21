@activitystream
Feature: Meeds stream

  @ignored
  Scenario: [STREAM-12] Activity Likers in drawer
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create a random space with the first random user
    And I click on post in space
    And I enter an activity 'stream activité'
    And I publish the activity
    And I connect with the first created user
    And I go to First Space
    And I 'Accept'
    And I go to First Space
    And I like the activity 'stream activité'
    And I change user admin
    And I go to First Space
    And I like the activity 'stream activité'
    When I click likers number of the activity 'stream activité'
    Then The 'likersList' is displayed
    And I hover on user 'firas' and go to profile after click
    And The page 'Profile' is opened

  @ignored
  Scenario:[STREAM-22]_(04) Space Popover : User is member of space
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create a random space with the first random user
    And I click on post in space
    And I enter an activity 'stream activité'
    And I publish the activity
    And I connect with the first created user
    And I go to First Space
    And I 'Accept'
    And I go to stream page
    When In activity, I hover on space name
    Then The 'spacePopoverMember' is displayed

  @ignored
  Scenario:[Streem]_(02) User popover new UI : Users are not connect
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create a random space with the first random user
    And I click on post in space
    And I enter an activity 'stream activité'
    And I publish the activity
    And I connect with the first created user
    And I go to First Space
    And I 'Accept'
    And I go to stream page
    And I hover on user name 'aymen.khalfi' activity
    Then The 'userPopoverNotConnected' is displayed
