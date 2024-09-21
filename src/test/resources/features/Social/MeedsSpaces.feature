@spaces
Feature: Meeds Space
  As a user
  I want to check spaces page

  Scenario: Spaces avatar and title
    Given I am authenticated as 'admin' random user

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

  Scenario: Home space page banner
    Given I am authenticated as 'admin' random user

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

    And I click on 'Settings' space menu tab
    And I open 'Overview' Section from Space Settings
    And I close the notification

    When I upload the Space banner 'cap02.png'
    And I click on 'Update' button

    And I go to spaces page
    And  I search for the random space
    Then Space banner is changed successfully

  Scenario: Clickable Space avatar
    Given I am authenticated as 'admin' random user

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

    When I go to space Home
    Then Space Top Bar Elements are displayed

  Scenario: Spaces Cards bloc
    Given I am authenticated as 'admin' random user

    When I create or check that thirty spaces are created
    And I go to spaces page
    Then I check that only 20 spaces are displayed
    When I click on Show more button
    Then I check that other spaces are displayed

  Scenario: Spaces Request
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing
    And I create a first random space with the first created user as member
    And I create a second random space with the first created user as member
    And I create a third random space with the first created user as member

    When I login as 'first' random user
    And I go to My Profile page
    Then The Spaces badge is '3'
    When I click on spaces badge
    And I accept the invitation of the first created space
    Then The Spaces badge is '2'
    And I reject the invitation of the second created space
    And I refresh the page
    And I click on space invitation widget
    And The third created space is displayed in Spaces Requests section
    And The first created space is not displayed in Spaces Requests section
    And The second created space is not displayed in Spaces Requests section
