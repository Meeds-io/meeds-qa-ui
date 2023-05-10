@gamification
Feature: Gamification point

  @smoke
  Scenario: check my points
    Given I am authenticated as 'admin' random user
    And I go to My Profile page
    Then The following items are displayed
      | Weekly points |
      | Weekly rank   |
