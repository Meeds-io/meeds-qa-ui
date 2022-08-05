@smoke
Feature: Kudos gamification

  @ignored @Not_enough_kudos
  Scenario: Receive Kudos
    Given I am authenticated with the user with the credentials
      | login    | houssem.riahi |
      | password | houssem2020   |
    When I go to my profile
    And I check my points
    And I change user
      | login    | aymen.khalfi |
      | password | aymen2020    |
    And I go to the profile 'houssem.riahi'
    And I send kudos with message 'Message for kudos'
    And I change user
      | login    | houssem.riahi |
      | password | houssem2020   |
    When I go to my profile
    Then My points augmented

  Scenario: Post activity (space stream)
    Given I am authenticated with the user with the credentials
      | login    | aymen.khalfi |
      | password | aymen2020    |
    And I check my points
    When I create the space
    And I click on post in space
    And I enter an activity 'kudosPostActivity'
    And I publish the activity
    And the activity 'kudosPostActivity' is displayed in activity stream
    And I go to my profile
    Then My points augmented