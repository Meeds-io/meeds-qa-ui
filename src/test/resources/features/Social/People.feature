@People

Feature: People

  Scenario: People US1 : People card list application
    Given I am authenticated as 'admin' if random users doesn't exists
      | firstprofile  |
    When I create the firstprofile random user if not existing, no wait
    And  I create the secondprofile random user if not existing, no wait
    And I login as 'firstprofile' random user
    And I go to People Page
    Given People Showing Results is displayed in People page
    Then People card item is displayed on the people page
    Then Contact cover in People page is displayed
