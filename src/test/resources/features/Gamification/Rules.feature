@gamification
@rules
Feature: Rules

  Scenario: Quick filter rules
    Given I am authenticated as admin
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I select engagement Programs tab
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    And I save the program details
    And I open random program card

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    When I add an event 'Receive kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Receive kudos' is displayed in program detail

    When I search for the 'Not found' rule in program detail rule filter
    Then Rule not found. Please try again is displayed

    When I clear rules search filter
    Then The action 'Receive kudos' is displayed in program detail
