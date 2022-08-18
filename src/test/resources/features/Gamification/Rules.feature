@gamification
Feature: Rules

  Scenario: Comment a post
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user
    When I go to my profile
    And I check my points
    And I go to the random space
    When I click on post in space
    And I enter an activity 'kudosPostActivity'
    And I publish the activity
    And the activity 'kudosPostActivity' is displayed in activity stream
    And I add in activity 'kudosPostActivity' a comment 'commentKudos'
    And I go to my profile
    Then My points augmented

  Scenario: Like a comment
    Given I am authenticated as admin
    And I create the first random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'kudosActivity11'
    And I publish the activity
    And the activity 'kudosActivity11' is displayed in activity stream
    And I add in activity 'kudosActivity11' a comment 'commentKudosPostActivity'
    And I connect with the first created user
    And I go to the random space
    And I go to my profile
    When I check my points
    And I go to the random space
    And I like the activity comment 'commentKudosPostActivity'
    And I go to my profile
    Then My points augmented

  Scenario: Like a post
    Given I am authenticated as admin
    And I create the first random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'kudosActivity12'
    And I publish the activity
    And the activity 'kudosActivity12' is displayed in activity stream
    And I connect with the first created user
    And I go to the random space
    And I go to my profile
    And I check my points
    And I go to the random space
    And I like the activity 'kudosActivity12'
    When I go to my profile
    Then My points augmented

  Scenario: Join a space
    Given I am authenticated as admin
    And I create the first random user
    And I create a random space with the first created user
    And I connect with the first created user
    And I check my points
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the random space
    And I close Space Drawer
    When I go to my profile
    Then My points augmented

  Scenario: Create new task
    Given I am authenticated as admin
    And I check my points
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    And I select 'Tasks' tab
    And The following task is created
      | taskName | taskgamification |
    And I go to my profile
    Then My points augmented

  Scenario: Complete assigned task
    Given I am authenticated as admin
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    And I select 'Tasks' tab
    And The following task is created
      | taskName | taskcompleted |
    And I go to my profile
    And I check my points
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    And I select 'Tasks' tab
    And I start the search for Task 'taskcompleted'
    And I mark the task as completed
    And I go to my profile
    Then My points augmented