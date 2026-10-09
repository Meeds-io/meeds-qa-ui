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

  Scenario: View the Agenda application view
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    Then The Agenda application is displayed
    And The add event button is displayed
    And The agenda filter is displayed
    And The agenda views switcher is displayed

  Scenario: Display the Agenda header
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    Then The add event button is displayed
    And The agenda filter is displayed

  Scenario: Display the Now Line
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    Then The agenda now line is displayed
    When I go to the 'day' agenda view
    Then The agenda now line is displayed

  Scenario: Display the agenda settings preferences
    Given I am authenticated as 'admin' random user
    When I go to the settings page
    Then The agenda settings section is displayed
    When I click on edit agenda settings
    Then The agenda preferences drawer is displayed

  Scenario: Close the event creation form
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    And I click on the add event button
    Then The event creation form step 'Event details' is displayed
    When I close the event creation form
    Then The event creation form is closed
    When I click on the add event button
    And I press ESC in the event creation form
    Then The event creation form is closed

  Scenario: Display the event repetition options
    Given I am authenticated as 'admin' random user
    When I go to the Agenda application
    And I click on the add event button
    And I click on the repetition select box
    Then The repetition option 'Do not repeat' is displayed
    And The repetition option 'Daily' is displayed
    And The repetition option 'Working week days' is displayed
    And The repetition option 'Weekly on' is displayed
    And The repetition option 'Monthly on' is displayed
    And The repetition option 'Yearly on' is displayed
    And The repetition option 'Custom' is displayed

  Scenario: Close the event details with ESC
    Given I am authenticated as 'admin' random user
    And I go to the random space
    And I click on 'More/Agenda' space menu tab
    When I add an event titled 'agenda esc event'
    Then The event is created with message 'Event created successfully'
    When I open the event 'agenda esc event' details
    And I press ESC in the event details
    Then The event details are not visible

  Scenario: Open the edit form of an event
    Given I am authenticated as 'admin' random user
    And I go to the random space
    And I click on 'More/Agenda' space menu tab
    When I add an event titled 'agenda update event'
    Then The event is created with message 'Event created successfully'
    When I open the event 'agenda update event' details
    And I open the edit event form
    Then The edit event form is displayed

  Scenario: Cancel and remove an event
    Given I am authenticated as 'admin' random user
    And I go to the random space
    And I click on 'More/Agenda' space menu tab
    When I add an event titled 'agenda remove event'
    Then The event is created with message 'Event created successfully'
    When I open the event 'agenda remove event' details
    And I open the delete event form
    Then The event button 'OK' is displayed
    And The event button 'Cancel' is displayed
    When I click on the 'OK' event button
    Then The event 'agenda remove event' is deleted from the agenda
