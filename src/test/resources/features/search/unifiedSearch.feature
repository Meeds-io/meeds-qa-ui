@unifiedSearch
Feature: unifiedSearch
  @smoke
  Scenario: search US2.9 : Applications cards view
    Given I am authenticated as 'admin' if random users doesn't exists
      | first |
    When I create the first random user if not existing, no wait
    And I login as 'first' random user
    And I access to the unified search page
    And I select an object from the drop-down menu 'Applications'
    And I start the search for the application created by the name 'wallet'
    Then The full name of the application is displayed in the search 'Wallet'
    Then The description of the application is displayed in the search 'Wallet'
