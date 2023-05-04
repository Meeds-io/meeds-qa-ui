@gamification
@challenge
Feature: Challenges

  Scenario: Announce a challenge
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    And I save the program details
    And I open random program card
    And I click on 'Add Action' button
    And I wait for drawer to open

    Then The button 'Next' is disabled in drawer

    When I enter the rule title 'Challenge to announce'
    Then The button 'Next' is disabled in drawer

    And I add rule random description
    Then The button 'Next' is disabled in drawer

    When I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Challenge to announce' is displayed in program detail

    When I connect with the first created user
    And I go to the random space

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Challenge to announce'

    When I go to 'Contributions' application
    And I select engagement Achievements tab
    Then Achievement for 'Challenge to announce' is accepted

  Scenario: Cancel a challenge
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    And I save the program details
    And I open random program card
    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Challenge To Cancel'
    And I add rule random description
    And I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Challenge To Cancel' is displayed in program detail

    When I connect with the first created user
    And I go to the random space

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Challenge To Cancel'

    And I go to Stream page
    When I cancel the announcement challenge 'Challenge To Cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Challenge To Cancel' is canceled

  Scenario: Delete announce Activity
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    And I save the program details
    And I open random program card
    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Announce activity to delete'
    And I add rule random description
    And I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Announce activity to delete' is displayed in program detail

    When I connect with the first created user
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
    Given I am authenticated as admin
    When I create the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    And I save the program details
    And I open random program card
    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Top challenge'
    And I add rule random description
    And I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Top challenge' is displayed in program detail

    When I connect with the first created user
    And I go to the random space

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Top challenge'
    And I announce challenge 'Top challenge'
    And I announce challenge 'Top challenge'
    And I announce challenge 'Top challenge'

    And I go to Overview page
    Then 'Top challenge' is displayed in challenge portlet with '4' participants

    When I change user admin

    And I go to 'Contributions' application
    And I delete the created program
    And I connect with the first created user
    And I go to Overview page

    Then 'Top challenge' with '4' participants is not displayed in challenge portlet