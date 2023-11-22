@activitystream
Feature: Activities

  Scenario: delete your activity
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity to delete'
    And I publish the activity
    Then the activity 'activity to delete' is displayed in activity stream
    When I click to delete from the dropdownActivitymenu
    And I click on Yes button
    Then the confirmation popup is not displayed
    And the activity 'activity to delete' is no more displayed in the activity stream

  Scenario:  delete your comment
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with comment to delete'
    And I publish the activity
    Then the activity 'activity with comment to delete' is displayed in activity stream
    When I add in activity 'activity with comment to delete' a comment 'A comment to delete'
    And I open in activity 'activity with comment to delete' the Comments drawer
    Then Activity Comment 'A comment to delete' is displayed in Comments drawer
    And Activity Comment 'A comment to delete' is displayed in activity stream
    When In activity 'activity with comment to delete' I delete the comment 'A comment to delete'
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'A comment to delete' is not displayed in activity 'activity with comment to delete'

  Scenario: comment your activity
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity to comment'
    And I publish the activity
    Then the activity 'activity to comment' is displayed in activity stream
    When I add in activity 'activity to comment' a comment 'comment to display'
    And I open in activity 'activity to comment' the Comments drawer
    Then Activity Comment 'comment to display' is displayed in Comments drawer
    And Activity Comment 'comment to display' is displayed in activity stream
    
  Scenario: share an activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I create the first random user if not existing, no wait
    And I login as 'first' random user
    And I create the firstspace random space
    And I create the secondspace random space
    And I go to the firstspace random space
    When I click on post in space
    And I enter an activity 'Share an activity to a space'
    And I publish the activity
    Then the activity 'Share an activity to a space' is displayed in activity stream
    When I click on share the activity 'Share an activity to a space'
    And I select the space 'secondspace' in the share activity drawer
    And I click on the share activity button
    And I go to the secondspace random space
    Then the activity 'Share an activity to a space' is displayed in activity stream
