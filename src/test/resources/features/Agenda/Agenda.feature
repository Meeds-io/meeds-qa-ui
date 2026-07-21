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
