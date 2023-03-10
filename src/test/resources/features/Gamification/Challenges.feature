@gamification
Feature: Challenges

  Scenario: Announce a challenge
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    When I select engagement Challenges tab
    And I click on the button add challenge
    And I enter the challenge title 'Challenge to announce'
    And I enter random program to challenge
    And I enter a started challenge
    And I add challenge random description

    And I connect with the first created user
    And I go to the random space

    And I go to 'Contributions' application
    And I open random program card
    And I announce challenge 'Challenge to announce'

    When I go to 'Contributions' application
    And I select engagement Achievements tab
    Then Achievement for 'Challenge to announce' is accepted

  Scenario: Cancel a challenge
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    When I select engagement Challenges tab
    And I click on the button add challenge
    And I enter the challenge title 'Challenge To Cancel'
    And I enter random program to challenge
    And I enter a started challenge
    And I add challenge random description

    And I connect with the first created user
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
    And I create the first random user if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    When I select engagement Challenges tab
    And I click on the button add challenge
    And I enter the challenge title 'Announce activity to delete'
    And I enter random program to challenge
    And I enter a started challenge
    And I add challenge random description

    And I connect with the first created user
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
    And I create the first random user if not existing
    And I go to 'Contributions' application
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    When I select engagement Challenges tab
    And I click on the button add challenge
    And I enter the challenge title 'Top challenge'
    And I enter random program to challenge
    And I enter a started challenge
    And I add challenge random description

    And I connect with the first created user
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