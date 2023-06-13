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
