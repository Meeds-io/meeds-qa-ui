@login
Feature: Check login features
  I want to login to Meeds

  Scenario: Check login display
    Given I am authenticated as 'admin' random user
    And I logout
    Then I check login page display
