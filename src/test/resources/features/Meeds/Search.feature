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

  @ignored
  Scenario: [SEARCH-2.2]Activity cards
    Given I am authenticated as admin
    And I go to search page
    When I search for 'cards' with type 'Activity'
    Then The 'onlyOneActivityCardDiplsayed' is displayed
    When I click on activity 'activity' card
    Then The 'searchedActivityPage' is displayed
    When I go to search page
    And I search for 'search' with type 'Activity'
    Then The 'onlyOneActivityCardDiplsayed' is displayed
    When I click on activity 'activity' card
    And I close the comments drawer
    Then The 'searchedActivityPage' is displayed
    When I go to search page
    And I search for 'activity' with type 'Activity'
    And The 'twoActivitiesCardDiplsayed' is displayed

  @ignored
  Scenario:[SEARCH-2.3] Spaces cards view
    Given I am authenticated as admin
    And I go to search page
    When I search for 'ilyes' with type 'Spaces'
    Then The 'searchedSpaceCard' is displayed
    And I click on 'ilyes' card
    And The page 'ilyes' is opened

  @ignored
  Scenario:[SEARCH-2.5] Tasks cards view
    Given I am authenticated as admin
    And I go to search page
    When I search for 'Task' with type 'Task'
    Then The 'searchedTaskCard' is displayed
