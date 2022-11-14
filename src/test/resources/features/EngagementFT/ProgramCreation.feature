@programs

Feature: Programs

  @standardConfigurationOnly
  Scenario: [Engagement][Program][US] : Add an enabled program
    Given I am authenticated as admin
    And I go To AppCenter Drawer
    And I go to contributions AppCenter Application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    Then The message 'New program created successfully.' should be displayed
    And The program title should be displayed on the card


  @standardConfigurationOnly
  Scenario: [Engagement][Program][US] : Add a disabled program
    Given I am authenticated as admin
    And I go To AppCenter Drawer
    And I go to contributions AppCenter Application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add a disabled program with random description
    Then The message 'New program created successfully.' should be displayed
    And The program card should not be displayed
