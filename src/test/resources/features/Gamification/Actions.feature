@gamification
@actions
Feature: Actions

  Scenario: Announce a challenge
    Given I am authenticated as 'admin' random user
    And I create the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open

    Then The button 'Next' is disabled in drawer

    When I enter the rule title 'Challenge to announce'
    Then The button 'Next' is disabled in drawer

    And I add rule random description
    Then The button 'Next' is disabled in drawer

    When I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer

    Then The button 'Duration' is not displayed in drawer

    When I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Challenge to announce' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification

    When I login as 'first' random user
    And I go to the random space

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Challenge to announce'

    And I click on 'See' link

    Then The activity 'Challenge to announce' is displayed

    When I go to 'Contributions' application
    And I select engagement Achievements tab
    Then Achievement for 'Challenge to announce' is accepted

    When I select engagement Programs tab
    And I open random program card

    When I open program action 'Challenge to announce'
    Then The program action contains duration limitation
    And I close the opened drawer

    When I login as 'admin' random user

    When I go to 'Contributions' application
    And I select engagement Programs tab
    And I open random program card
    And I edit program action 'Challenge to announce'
    And I click on 'Next' button in drawer
    And I delete rule duration
    And I click on 'Update' button in drawer
    And I close the notification

    When I open program action 'Challenge to announce'
    Then The program action does not contain duration limitation
    And I close the opened drawer

  Scenario: Cannot Announce a disabled challenge
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing

    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open

    When I enter the rule title 'Challenge to disable'
    Then The button 'Next' is disabled in drawer

    And I add rule random description
    Then The button 'Next' is disabled in drawer

    When I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

    When I close the notification
    Then The action 'Challenge to disable' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification

    When I edit program action 'Challenge to disable'
    And I set rule as disabled
    And I click on 'Next' button in drawer
    And I click on 'Update' button in drawer

    Then Confirmation message is displayed 'Action has been successfully updated'

    When I close the notification
    Then The action 'Challenge to disable' is not displayed in program detail

    When I filter program actions by value 'ALL'
    And I open program action 'Challenge to disable'

    Then I cannot announce program action
    And I close the opened drawer

  Scenario: Cancel a challenge
    Given I am authenticated as 'admin' random user
    And I create the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Challenge To Cancel'
    And I add rule random description
    And I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Challenge To Cancel' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification

    When I login as 'first' random user
    And I go to the random space

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Challenge To Cancel'

    And I click on 'See' link

    Then The activity 'Challenge To Cancel' is displayed
    When I cancel the announcement challenge 'Challenge To Cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Challenge To Cancel' is canceled

  Scenario: Delete announce Activity
    Given I am authenticated as 'admin' random user
    And I create the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Announce activity to delete'
    And I add rule random description
    And I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Announce activity to delete' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification

    When I login as 'first' random user
    And I go to the random space

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Announce activity to delete'

    And I go to Stream page
    When I click on three dots button related to activity 'Announce activity to delete'
    And I click on Delete button related to activity 'Announce activity to delete'
    And I click on Yes button
    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Announce activity to delete' is rejected due to activity deletion

  Scenario: Overview top challenge
    Given I am authenticated as 'admin' random user
    When I create the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Top challenge'
    And I add rule random description
    And I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

    When I close the notification
    Then The action 'Top challenge' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification
    Then The button 'Activate the program' is not displayed

    When I login as 'first' random user
    And I go to the random space

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Top challenge'
    And I close the notification
    And I announce challenge 'Top challenge'
    And I close the notification
    And I announce challenge 'Top challenge'
    And I close the notification
    And I announce challenge 'Top challenge'
    And I close the notification

    And I go to Overview page
    Then 'Top challenge' is displayed in challenge portlet with '4' participants

    When I login as 'admin' random user

    And I go to 'Contributions' application
    And I filter programs by value 'ALL'
    And I delete the created program
    And I login as 'first' random user
    And I go to Overview page

    Then 'Top challenge' with '4' participants is not displayed in challenge portlet