@attachment
Feature: Attach images activities

  Scenario: Attach an image to an activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached images'
    And I attach an image to the activity
    And I publish the activity
    Then the activity 'activity with attached images' is displayed in activity stream
    And The attached images should be displayed in the published activity 'activity with attached images'
    
  Scenario: Preview attached images
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached images'
    And I attach an image to the activity
    And I publish the activity
    Then the activity 'activity with attached images' is displayed in activity stream
    And The attached images should be displayed in the published activity 'activity with attached images'
    
    When I click on attached image related to activity 'activity with attached images'
    Then the preview of the attached image is displayed
    
    When I click on close icon in preview attached image
    Then the preview of the attached image is not displayed