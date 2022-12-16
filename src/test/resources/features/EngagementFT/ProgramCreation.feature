@programs

Feature: Programs

  @standardConfigurationOnly
  Scenario: [Engagement][Program][US] : Add an enabled program
    Given I am authenticated as admin
    And I create a random space
    And I go To AppCenter Drawer
    And I go to contributions AppCenter Application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then The message 'New program created successfully.' should be displayed
    And The program title should be displayed on the card
    And I filter programs by value 'ENABLED'
    Then The program title should be displayed on the card

  @standardConfigurationOnly
  Scenario: [Engagement][Program][US] : Add a disabled program
    Given I am authenticated as admin
    And I create a random space
    And I go To AppCenter Drawer
    And I go to contributions AppCenter Application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add a disabled program with random description
    And I add an audience space
    Then The message 'New program created successfully.' should be displayed
    And The program card should not be displayed
    And I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

  @standardConfigurationOnly
  Scenario: [Engagement][Program][US] : Edit program
    Given I am authenticated as admin
    And I create a random space
    And I go To AppCenter Drawer
    And I go to contributions AppCenter Application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then The message 'New program created successfully.' should be displayed
    And The program title should be displayed on the card
    And I edit the created program
    Then The message 'Program updated successfully.' should be displayed
    And The program title should be updated on the card

  @standardConfigurationOnly
  Scenario: [Program][US04] Delete program
    Given I am authenticated as admin
    And I create a random space
    And I go To AppCenter Drawer
    And I go to contributions AppCenter Application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then The message 'New program created successfully.' should be displayed
    And The program title should be displayed on the card
    And I delete the created program
    Then The message 'Program has been removed successfully.' should be displayed
    And The program card should not be displayed

  @standardConfigurationOnly
  Scenario:[Engagement][Program][US] : Quick filter on program
    Given I am authenticated as admin
    And I create a random space
    And I go To AppCenter Drawer
    And I go to contributions AppCenter Application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter the program title 'Enabled program'
    And I add program with random description
    And I add an audience space
    Then The message 'New program created successfully.' should be displayed
    And The program card title 'Enabled program' should be displayed
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter the program title 'Disabled program'
    And I add a disabled program with random description
    And I add an audience space
    Then The message 'New program created successfully.' should be displayed
    And I filter programs by value 'ALL'
    Then The program card title 'Disabled program' should be displayed
    And The program card title 'Enabled program' should be displayed
