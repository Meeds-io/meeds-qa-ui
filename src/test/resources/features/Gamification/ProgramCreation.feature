@programs
Feature: Programs

  Scenario: [Engagement][Program][US] : Add an enabled program
    Given I am authenticated as admin
    And I go to the random space
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then Confirmation message is displayed 'New program created successfully'
    And The program title should be displayed on the card
    And I filter programs by value 'ENABLED'
    Then The program title should be displayed on the card

  Scenario: [Engagement][Program][US] : Add a disabled program
    Given I am authenticated as admin
    And I go to the random space
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add a disabled program with random description
    And I add an audience space
    Then Confirmation message is displayed 'New program created successfully'
    And The program card should not be displayed
    And I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

  Scenario: [Engagement][Program][US] : Edit program
    Given I am authenticated as admin
    And I go to the random space
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then Confirmation message is displayed 'New program created successfully'
    And The program title should be displayed on the card
    And I edit the created program
    Then Confirmation message is displayed 'Program successfully updated'
    And The program title should be updated on the card

  Scenario: [Program][US04] Delete program
    Given I am authenticated as admin
    And I go to the random space
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then Confirmation message is displayed 'New program created successfully'
    And The program title should be displayed on the card
    And I delete the created program
    Then Confirmation message is displayed 'Program has been successfully removed'
    And The program card should not be displayed

  Scenario:[Engagement][Program][US] : Quick filter on program
    Given I am authenticated as admin
    And I go to the random space
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter the program title 'Enabled program'
    And I add program with random description
    And I add an audience space
    Then Confirmation message is displayed 'New program created successfully'
    And The program card title 'Enabled program' should be displayed
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter the program title 'Disabled program'
    And I add a disabled program with random description
    And I add an audience space
    Then Confirmation message is displayed 'New program created successfully'
    And I filter programs by value 'ALL'
    Then The program card title 'Disabled program' should be displayed
    And The program card title 'Enabled program' should be displayed

  Scenario: Overview programs display
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I go to the random space
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space

    And I open random program card
    When I click on the button add action
    And I enter the rule title 'Post activity'
    And I add an event 'Post activity'
    And I enter the rule score '99999999'
    And I add rule random description

    And I connect with the first created user
    And I go to the random space
    When I go to Overview page
    Then The created program is the most awarded program

    When I connect with admin
    And I go to 'Contributions' application
    And I disable the created program
    And I connect with the first created user
    And I go to Overview page
    Then The created program is not the most awarded program
