@spaces
Feature: Meeds Space
  As a user
  I want to check spaces page

  Scenario: Spaces avatar and title
    Given I am authenticated as 'admin' random user

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

  Scenario: Clickable Space avatar
    Given I am authenticated as 'admin' random user

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

    When I go to space Home
    Then Space Top Bar Elements are displayed
