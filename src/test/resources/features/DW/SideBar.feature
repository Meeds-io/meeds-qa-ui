@secondpart
Feature: DW SideBar

  Scenario: CAP37 - US 6.2.2 [FRONT]_(01) : Filter Recent Spaces in the Second level side bar in Desktop
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user

    When I connect with the first created user
    And I create the random space
    And I create the second random space
    And I hover on Recent spaces
    And I search for the second created space in Side Bar Filter
    Then Second searched space is displayed in Side Bar Filter
    And First searched space is not displayed in Side Bar Filter
