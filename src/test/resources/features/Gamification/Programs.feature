@gamification
@programs
Feature: Programs

  Scenario: Create a program with space audience
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I join the random space
    And I go to 'Contributions' application
    And I click on the button add program
    Then The drawer add program should be displayed

    When I expand the drawer

    Then The button 'Next' is not displayed in drawer
    And The button 'Create' is displayed in drawer
    And The button 'Create' is disabled in drawer

    When I enter a random program title
    Then The button 'Create' is disabled in drawer

    When I enter a random description for program
    Then The button 'Create' is disabled in drawer

    When I add an audience space

    Then The button 'Create' is enabled in drawer
    When I enter the program title 'Test for a long Text having more than 50 characters'
    Then The button 'Create' is disabled in drawer
    When I enter a random program title
    Then The button 'Create' is enabled in drawer

    When I enter the program description 'Test for a long Text having more than 1300 characters' '30' times
    Then The button 'Create' is disabled in drawer
    When I enter a random description for program
    Then The button 'Create' is enabled in drawer

    When I save the program details
    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    Then The button 'Activate the program' is not displayed

    When I edit the program from detail
    And I click on 'Next' button in drawer
    Then The program status switch is not displayed 

    When I close the opened drawer
    And I click on program title to go back
    Then The program card should not be displayed

    When I filter programs by value 'ENABLED'
    Then The program card should not be displayed

    When I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

    When I filter programs by value 'ALL'
    Then The program title should be displayed on the card

  Scenario: Translate a program with its associated rule
    Given I am authenticated as 'admin' random user
    And I inject the 'fourty' random user if not existing, no wait

    And I go to 'Contributions' application
    And I click on the button add program
    And I wait for drawer to open

    Then The 'first' translations button is not primary
    And The 'second' translations button is not primary

    When I enter a random program title
    And I open translations drawer for the 'first' input
    And I add the following 'field' translations
      | fr | French Program Title |
    And I click on 'Apply' button in second level drawer
    Then The 'first' translations button is primary
    And The 'second' translations button is not primary

    When I enter a random description for program
    And I open translations drawer for the 'second' input
    And I add the following 'rich editor' translations
      | fr | French Program Description |
    And I click on 'Apply' button in second level drawer
    Then The 'first' translations button is primary
    And The 'second' translations button is primary

    And I click on 'Next' button in drawer

    When I enable the switch button 'All'
    And I click on 'Create' button in drawer

    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    And I click on 'Add action' button
    And I wait for drawer to open
    When I enter the rule title 'Program Translation Action'

    And I open translations drawer for the 'first' input
    And I add the following 'field' translations
      | fr | French Action Title |
    And I click on 'Apply' button in second level drawer
    Then The 'first' translations button is primary
    And The 'second' translations button is not primary

    When I add rule random description
    And I open translations drawer for the 'second' input
    And I add the following 'rich editor' translations
      | fr | French Action Description |
    And I click on 'Apply' button in second level drawer
    Then The 'first' translations button is primary
    And The 'second' translations button is primary

    When I click on 'Manually' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    And I click on 'Activate the program' button
    Then Success message is displayed
    When I close the notification

    When I login as 'fourty' random user
    And I go to 'Contributions' application
    And I switch the page to 'en' language
    And I open random program card
    And I switch the page to 'fr' language
    Then The message 'French Program Title' is displayed in page
    And The message 'French Program Description' is displayed in page
    And The message 'French Action Title' is displayed in page

    When I switch the page to 'en' language
    Then The message 'French Program Title' is not displayed in page
    And The message 'French Program Description' is not displayed in page
    And The message 'French Action Title' is not displayed in page

  Scenario: Attach a cover and avatar to a program
    Given I am authenticated as 'admin' random user
    And I inject the 'first' random user if not existing, no wait

    And I go to 'Contributions' application
    And I click on the button add program
    And I wait for drawer to open
    And I expand the drawer

    When I enter a random program title
    When I enter a random description for program

    And I attach an avatar to the program
    And I attach a cover to the program

    And I enable the switch button 'All'
    And I click on 'Create' button in drawer
    And I close the notification

    Then The program is displayed with specific cover

    And I click on 'Add action' button
    And I wait for drawer to open
    When I enter the rule title 'Program With Image Action'
    When I add rule random description
    When I click on 'Manually' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer
    And I close the notification

    When I open program action 'Program With Image Action'
    Then The program is displayed with specific avatar

    When I close the opened drawer
    And I edit the program from detail
    And I wait for drawer to open
    And I expand the drawer
    Then The button 'Save' is disabled in drawer

    When I delete the specific avatar of the program
    Then The button 'Save' is enabled in drawer

    When I delete the specific cover of the program
    Then The button 'Save' is enabled in drawer

    When I click on 'Save' button in drawer
    And I close the notification

    Then The program is displayed with default cover

    When I open program action 'Program With Image Action'
    Then The program is displayed with default avatar

  Scenario: Create a program with internal users as audience
    Given I am authenticated as 'admin' random user
    And I inject the 'first' random user if not existing, no wait
    And I inject the 'firstexternal' random user with the following memberships
      | member:/platform/externals |

    And I go to 'Contributions' application
    And I go to engagement application 'programs'
    And I click on the button add program
    And I enter a random program title
    And I enter a random description for program

    When I click on 'Next' button in drawer
    Then The message 'Select a space' is displayed
    And The message 'Any rewarding administrator' is not displayed

    When I enable the switch button 'All'
    Then The message 'Select a space' is not displayed
    And The message 'Any rewarding administrator' is displayed

    And I save the program details

    Then Success message is displayed
    When I close the notification

    And I click on 'Add action' button
    And I wait for drawer to open
    When I enter the rule title 'Internal users action'
    When I add rule random description
    When I click on 'Manually' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Success message is displayed
    When I close the notification

    And I click on 'Activate the program' button
    Then Success message is displayed
    When I close the notification

    When I login as 'first' random user

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Internal users action' with message 'announcement3'

    When I go to 'Contributions' application
    And I go to engagement application 'achievements'
    Then Achievement for 'Internal users action' is accepted

    When I login as 'admin' random user
    And I go to 'Contributions' application

    When I edit the program from list
    And I click on 'Next' button in drawer
    And I set user 'first' as program owner
    And I click on 'Save' button in drawer
    Then Success message is displayed
    And I close the notification

    When I edit the program from list
    And I click on 'Next' button in drawer
    And I set user 'firstexternal' as program owner
    Then The button 'Save' is disabled in drawer
    And I close the opened drawer
    And I confirm

    When I login as 'first' random user
    And I go to 'Contributions' application
    And I edit the program from list
    And I add rule random description
    And I click on 'Next' button in drawer
    And I click on 'Save' button in drawer

    Then Success message is displayed
    And I close the notification

  Scenario: Can't Activate program when no active action
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I join the random space

    And I go to 'Contributions' application
    And I go to engagement application 'programs'
    And I click on the button add program
    And I enter a random program title
    And I enter a random description for program
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details
    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    Then The button 'Activate the program' is not displayed

    And I click on 'Add action' button
    And I wait for drawer to open
    Then The button 'Next' is disabled
    When I enter the rule title 'Program activation test'
    Then The button 'Next' is disabled
    When I add rule random description
    Then The button 'Next' is disabled
    When I click on 'Manually' button in drawer
    And I click on 'Next' button in drawer
    Then The button 'Add' is enabled
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

    When I close the notification
    Then The button 'Activate the program' is displayed

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I edit program action 'Program activation test'
    And I set rule as disabled
    And I click on 'Next' button in drawer
    And I click on 'Update' button in drawer

    Then Confirmation message is displayed 'Action has been successfully updated'
    And I close the notification

    Then The button 'Activate the program' is not displayed
    And The message 'No active action' is displayed

    When I filter program actions by value 'ALL'
    And I edit program action 'Program activation test'
    And I set rule as enabled
    And I click on 'Next' button in drawer
    And I click on 'Update' button in drawer

    Then The button 'Activate the program' is displayed

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    Then The button 'Activate the program' is not displayed
    And The message 'No active action' is not displayed

    When I delete program action 'Program activation test'

  Scenario: Edit program
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    Then The drawer add program should be displayed

    When I enter a random program title
    And I enter a random description for program
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details
    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    And I click on go back button
    And I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

    When I change the created program with a random description
    Then Confirmation message is displayed 'Program successfully updated'

    When I close the notification
    And I filter programs by value 'DISABLED'
    Then The program title should be updated on the card

  Scenario: Delete program
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I join the random space
    And I go to 'Contributions' application
    And I click on the button add program
    Then The drawer add program should be displayed
    And I enter a random program title
    And I enter a random description for program
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details
    Then Confirmation message is displayed 'New program created successfully'

    When I close the notification
    And I go to engagement application 'programs'
    And I filter programs by value 'DISABLED'
    Then The program title should be displayed on the card

    When I delete the created program
    Then Confirmation message is displayed 'Program has been successfully removed'

    When I close the notification
    And I filter programs by value 'ALL'
    Then The program card should not be displayed
