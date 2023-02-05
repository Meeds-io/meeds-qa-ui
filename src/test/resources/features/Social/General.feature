@smoke
@activitycomposer
Feature: General new composer
  As a user
  I want to handle activities via the new composer
  In order to share them with my collaborators

  Scenario: CAP97 [US-General-04] update posts - text update (space case)
    Given I am authenticated as admin
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activité CAP97'
    And I publish the activity
    And I click on modify the activity
    And I enter an activity 'activité CAP97 edited'
    And I click on Update
    And the activity 'activité CAP97 edited' is displayed in activity stream

  Scenario: CAP109-[US-General-07]update posts - text update with normal Link (space case)
    Given I am authenticated as admin
    And I go to the random space
    When I click on post in space
    And I enter an activity 'https://www.meeds.io/'
    And I wait '5' seconds
    And I insert text 'activity109'
    And I publish the activity
    And I click on modify the activity
    And I insert text 'modifier le lien'
    And I click on Update
    Then the activity 'modifier le lien' is displayed in activity stream
    And The link is displayed with the preview

  Scenario: CAP110 - [US-General-07] update posts - text update with video Link (space case)
    Given I am authenticated as admin
    And I go to the random space
    When I click on post in space
    And I enter an activity 'https://www.youtube.com/watch?v=wgpduVyZT50'
    And I wait '5' seconds
    And I insert text 'activity110'
    And I publish the activity
    And I click on modify the activity
    And I insert text 'modifier le lien'
    And I click on Update
    Then the activity 'modifier le lien' is displayed in activity stream
    And the video 'https://www.youtube.com/watch?v=wgpduVyZT50' is displayed in the activity stream
