@gamification
@rules
@standardConfigurationOnly
Feature: Rules

  Scenario: Comment a post
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing
    And I connect with the first created user
    When I go to My Profile page
    And I check my points
    And I go to the random space
    When I click on post in space
    And I enter an activity 'kudosPostActivity'
    And I publish the activity
    And the activity 'kudosPostActivity' is displayed in activity stream
    And I add in activity 'kudosPostActivity' a comment 'commentKudos'
    And I go to My Profile page
    Then My points augmented

  Scenario: Like a comment
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I go to the random space
    And I click on post in space
    And I enter an activity 'kudosActivity11'
    And I publish the activity
    And the activity 'kudosActivity11' is displayed in activity stream
    And I add in activity 'kudosActivity11' a comment 'commentKudosPostActivity'
    And I connect with the first created user
    And I go to the random space
    And I go to My Profile page
    When I check my points
    And I go to the random space
    And I like the activity comment 'commentKudosPostActivity'
    And I go to My Profile page
    Then My points augmented

  Scenario: Like a post
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I go to the random space
    And I click on post in space
    And I enter an activity 'kudosActivity12'
    And I publish the activity
    And the activity 'kudosActivity12' is displayed in activity stream
    And I connect with the first created user
    And I go to the random space
    And I go to My Profile page
    And I check my points
    And I go to the random space
    And I like the activity 'kudosActivity12'
    When I go to My Profile page
    Then My points augmented

  Scenario: Create a new task
    Given I am authenticated as admin
    And I check my points
    And I go to 'Tasks' application
    And I select tasks tab
    And I create the following task
      | taskName | taskgamification |
    And I go to My Profile page
    Then My points augmented

  Scenario: Complete assigned task
    Given I am authenticated as admin
    And I go to 'Tasks' application
    And I select tasks tab
    And I create the following task
      | taskName | taskcompleted |
    And I go to My Profile page
    And I check my points
    And I go to 'Tasks' application
    And I select tasks tab
    And I start the search for Task 'taskcompleted'
    And I mark the task as completed
    And I go to My Profile page
    Then My points augmented

  Scenario: Quick filter rules
    Given I am authenticated as admin
    And I create the random space if not existing
    And I go to 'Contributions' application
    And I select engagement Programs tab
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I add an audience space
    And I open random program card
    When I click on the button to add a rule
    And I enter the rule title 'Receive kudos'
    And I add an event 'Receive kudos'
    And I add rule random description

    When I search for the 'Not found' rule in program detail rule filter
    Then Rule not found. Please try again is displayed

    When I clear rules search filter
    Then The Rule 'Receive kudos' is displayed