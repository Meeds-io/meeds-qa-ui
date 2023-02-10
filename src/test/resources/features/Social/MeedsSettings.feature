@settings
Feature: Edit sections in Settings page
  As a user
  I want to edit in Settings page many sections

  Scenario: [SETTINGS-5] Language and its drawer
    Given I connect as admin if random users doesn't exists
      | firstlang  |
    And I create the firstlang random user if not existing
    And I connect with the firstlang created user

    And I go to Settings page
    Then Settings Page Is Opened

    When I click on Edit language and I change it 'French'
    And I cancel editing language

    Then Language 'English' is displayed

    When I click on Edit language and I change it 'French'
    And I accept editing language

    Then Language 'French' is displayed

    When I click on Edit language and I change it 'English'
    And I accept editing language

    When I refresh the page
    Then Language 'English / English' is displayed

  Scenario: SETTINGS-4 : Add the favorite icon for Homepage default view
    Given I am authenticated as admin

    And I open Navigation menu
    And I mouse over the stream icon in sidebar menu
    And I click on home icon
    And I click to confirm the new home page
    And I click on home page button
    Then Activity Stream page is displayed
