@kudos
Feature: Kudos gamification

  @smoke
  Scenario: Receive Kudos
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    And I connect with the first created user
    When I go to my profile
    And I check my points
    And I connect with the second created user
    And I go to the first user profile
    And I send kudos with message 'Message for kudos'
    And I connect with the first created user
    When I go to my profile
    Then My points augmented

  @smoke
  Scenario: Post activity (space stream)
    Given I am authenticated as admin
    And I check my points
    When I go to the random space
    And I click on post in space
    And I enter an activity 'kudosPostActivity'
    And I publish the activity
    And the activity 'kudosPostActivity' is displayed in activity stream
    And I go to my profile
    Then My points augmented