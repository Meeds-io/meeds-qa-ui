@smoke
Feature: Insert videos
  As a user
  I want to publish videos via the new composer
  In order to share them with my collaborators

  @test
  Scenario: CAP15-[US-InsertVideo-01]Post a message with a video link
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'https://www.youtube.com/watch?v=9UMxZofMNbA'
    And I wait '5' seconds
    And I publish the activity
    Then the activity 'https://www.youtube.com/watch?v=9UMxZofMNbA' is displayed in activity stream
    And the video 'https://www.youtube.com/watch?v=9UMxZofMNbA' is displayed in the activity stream
