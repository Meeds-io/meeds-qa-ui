@People

Feature: People

  Scenario: People US1 : People card list application
    Given I am authenticated as 'admin' if random users doesn't exists
      | first |
    When I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I login as 'first' random user
    And I go to People Page
    When I search the second user profile
    Then User profile 'second' is displayed