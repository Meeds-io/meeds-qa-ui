@programs
Feature: Programs

  Scenario: [Engagement][Program][US] : Add an enabled program
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the firstadm random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role '*' to the firstadm created user
    And I connect with the firstadm created user
    And I create a random space
    And I go To AppCenter Drawer
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then The message 'New program created successfully' should be displayed
    And The program title should be displayed on the card
    And I filter programs by value 'ENABLED'
    Then The program title should be displayed on the card

  Scenario: [Engagement][Program][US] : Add a disabled program
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the firstadm random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role '*' to the firstadm created user
    And I connect with the firstadm created user
    And I create a random space
    And I go To AppCenter Drawer
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add a disabled program with random description
    And I add an audience space
    Then The message 'New program created successfully' should be displayed
    And The program card should not be displayed
    And I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

  Scenario: [Engagement][Program][US] : Edit program
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the firstadm random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role '*' to the firstadm created user
    And I connect with the firstadm created user
    And I create a random space
    And I go To AppCenter Drawer
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then The message 'New program created successfully' should be displayed
    And The program title should be displayed on the card
    And I edit the created program
    Then The message 'Program successfully updated' should be displayed
    And The program title should be updated on the card

  Scenario: [Program][US04] Delete program
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the firstadm random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role '*' to the firstadm created user
    And I connect with the firstadm created user
    And I create a random space
    And I go To AppCenter Drawer
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    Then The message 'New program created successfully' should be displayed
    And The program title should be displayed on the card
    And I delete the created program
    Then The message 'Program has been successfully removed' should be displayed
    And The program card should not be displayed

  Scenario:[Engagement][Program][US] : Quick filter on program
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the firstadm random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role '*' to the firstadm created user
    And I connect with the firstadm created user
    And I create a random space
    And I go To AppCenter Drawer
    And I go to 'Contributions' application
    Then Engagement application center is displayed
    When I select engagement Programs tab
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter the program title 'Enabled program'
    And I add program with random description
    And I add an audience space
    Then The message 'New program created successfully' should be displayed
    And The program card title 'Enabled program' should be displayed
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter the program title 'Disabled program'
    And I add a disabled program with random description
    And I add an audience space
    Then The message 'New program created successfully' should be displayed
    And I filter programs by value 'ALL'
    Then The program card title 'Disabled program' should be displayed
    And The program card title 'Enabled program' should be displayed
