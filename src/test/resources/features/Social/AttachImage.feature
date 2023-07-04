@attachment
Feature: Attach images activities
  @test
  Scenario: [AttachImage_US01.10] Attach an image to an activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached image'
    And I attach an image to the activity
    And I publish the activity