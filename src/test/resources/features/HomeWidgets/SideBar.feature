@sidebar
Feature: SideBar

  @smoke
  Scenario: CAP37 - US 6.2.2 [FRONT]_(01) : Filter Recent Spaces in the Second level side bar in Desktop
    Given I am authenticated as admin
    And I create the first random user
    When I connect with the first created user
    And I create the random space
    And I create the second random space
    And I hover on Recent spaces
    And I search for the second created space in Side Bar Filter
    Then Second searched space is displayed in Side Bar Filter
    And First searched space is not displayed in Side Bar Filter

  @smoke
  Scenario:CAP34-US 6.5[FRONT]_(01):My Settings in the Side bar for Desktop
    Given I am authenticated as admin
    And I create the first random user
    When I connect with the first created user
    When I go to Settings page
    Then The page 'settings' that contains 'Manage notifications' is displayed
