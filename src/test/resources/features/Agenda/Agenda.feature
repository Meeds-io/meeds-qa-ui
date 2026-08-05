@agenda
Feature: Agenda application
  As a user I want to access the Agenda application and open the event creation form

  Scenario: Open the Agenda application and the event creation form
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    Then The Agenda application is displayed
    And The add event button is displayed
    And The agenda views switcher is displayed
    When I click on the add event button
    Then The event creation form step 'Event details' is displayed
    And The event creation form step 'Suggest dates' is displayed

  @test
  Scenario: View the Agenda application view
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    Then The Agenda application is displayed
    And The add event button is displayed
    And The agenda filter is displayed
    And The agenda views switcher is displayed

  @test
  Scenario: Display the Agenda header
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    Then The add event button is displayed
    And The agenda filter is displayed

  @test
  Scenario: Display the Now Line
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    Then The agenda now line is displayed
    When I go to the 'day' agenda view
    Then The agenda now line is displayed

  @test
  Scenario: Display the agenda settings preferences
    Given I am authenticated as 'admin' random user
    When I go to the settings page
    Then The agenda settings section is displayed
    When I click on edit agenda settings
    Then The agenda preferences drawer is displayed
