@gamification
@programs
Feature: Programs

  @test
  Scenario: Add an enabled program
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
    And The program title should be displayed on the card
    And I filter programs by value 'ENABLED'
    Then The program title should be displayed on the card

  Scenario: Add a disabled program
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
    And I edit the program
    And I click on 'Next' button in drawer
    And I switch program as disabled
    And I click on 'Save' button in drawer
    Then Confirmation message is displayed 'Program successfully updated'

    When I close the notification
    And I select engagement Programs tab
    And The program card should not be displayed
    And I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

  @test
  Scenario: Edit program
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
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
    And The program title should be displayed on the card
    And I edit the created program
    Then Confirmation message is displayed 'Program successfully updated'
    When I close the notification
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
    And The program title should be displayed on the card
    And I delete the created program
    Then Confirmation message is displayed 'Program has been successfully removed'

    When I close the notification
    Then The program card should not be displayed

  Scenario: Quick filter on program
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I join the random space
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter the program title 'Enabled program'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details
    Then Confirmation message is displayed 'New program created successfully'
    When I close the notification

    When I select engagement Programs tab
    Then The program card title 'Enabled program' should be displayed

    When I click on the button add program
    Then The drawer add program should be displayed
    And I enter the program title 'Disabled program'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details
    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    And I edit the program
    And I click on 'Next' button in drawer
    And I switch program as disabled
    And I click on 'Save' button in drawer
    Then Confirmation message is displayed 'Program successfully updated'

    And I select engagement Programs tab
    And I filter programs by value 'ALL'
    Then The program card title 'Disabled program' should be displayed
    And The program card title 'Enabled program' should be displayed
