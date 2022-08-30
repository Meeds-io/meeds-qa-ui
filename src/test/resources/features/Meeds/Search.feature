@search
Feature: Meeds Search

  @ignored
  Scenario:[SEARCH-2.1]People cards view
    Given I am authenticated as admin
    When I go to Person Page
    And I search the user 'First Name'
    Then The page 'search' that contains 'connect' is displayed
    Then The page 'search' that contains 'First Name' is displayed

  @ignored
  Scenario: [SEARCH-2.9] Applications cards view
    Given I am authenticated as admin
    And I go to search page
    When I search for 'Wallet' with type 'Applications'
    Then The 'Wallet' card is visible
    And I click on 'Wallet' card
    And The wallet page is not opened
