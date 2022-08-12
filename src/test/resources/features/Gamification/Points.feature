@gamification
Feature: Gamification point

  @smoke
  Scenario: check my points
    Given I am authenticated as admin
    And I go to my profile
    Then The following items are displayed
      | Weekly points |
      | Weekly rank   |
