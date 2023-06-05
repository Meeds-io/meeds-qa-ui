@gamification
@programs
Feature: Programs

  Scenario: Create a program
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I join the random space
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details
    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    Then The button 'Activate the program' is not displayed

    When I edit the program
    And I click on 'Next' button in drawer
    Then The program status switch is not displayed 

    When I close the opened drawer
    And I select engagement Programs tab
    Then The program card should not be displayed

    When I filter programs by value 'ENABLED'
    Then The program card should not be displayed

    When I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

    When I filter programs by value 'ALL'
    Then The program title should be displayed on the card

  Scenario: Edit program
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to 'Contributions' application
    Then Engagement application center is displayed

    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed

    When I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details
    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    And I select engagement Programs tab
    And I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

    When I edit the created program
    Then Confirmation message is displayed 'Program successfully updated'

    When I close the notification
    And I filter programs by value 'DISABLED'
    Then The program title should be updated on the card

  Scenario: Delete program
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I join the random space
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details
    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    And I select engagement Programs tab
    And I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

    When I delete the created program
    Then Confirmation message is displayed 'Program has been successfully removed'

    When I close the notification
    And I filter programs by value 'ALL'
    Then The program card should not be displayed
