@gamification
@rules
Feature: Rules

  Scenario: Quick filter rules
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I go to engagement application 'programs'
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    When I add an event 'Receive kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

    When I close the notification
    And The action 'Receive kudos' is displayed in program detail

    When I search for the 'Not found' rule in program detail rule filter
    Then Rule not found. Please try again is displayed

    When I clear rules search filter
    Then The action 'Receive kudos' is displayed in program detail

  Scenario: Space host can add action in program
    Given I am authenticated as 'admin' random user
    And I inject the random space
    And I create the firstrule random user if not existing, no wait

    When I login as 'firstrule' random user
    And I go to the random space

    When I login as 'admin' random user
    And I go to the random space
    And I click on 'Members' space menu tab
    And I search for 'firstrule' random user
    And I click on three dots menu
    And I set as a space manager

    When I go to 'Contributions' application
    And I go to engagement application 'programs'
    And I click on the button add program
    And I enter the program title 'Test Rule Space Host'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I login as 'firstrule' random user
    And I go to 'Contributions' application
    And I go to engagement application 'programs'
    And I filter programs by value 'ALL'
    And I open 'Test Rule Space Host' program card

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Join space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Join space'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

    When I close the notification
    Then The action 'Join space' is displayed in program detail
    And The button 'Activate the program' is displayed

  Scenario: Space member as program owner can add action
    Given I am authenticated as 'admin' random user
    And I inject the random space
    And I create the secondrule random user if not existing, no wait

    When I login as 'secondrule' random user
    And I go to the random space

    When I login as 'admin' random user
    And I go to 'Contributions' application
    And I go to engagement application 'programs'
    And I click on the button add program
    And I enter the program title 'Test Rule Program Owner'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I set user 'secondrule' as program owner
    And I save the program details

    When I login as 'secondrule' random user
    And I go to 'Contributions' application
    And I filter programs by value 'ALL'
    Then I open 'Test Rule Program Owner' program card

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Join space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Join space'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

    When I close the notification
    Then The action 'Join space' is displayed in program detail
