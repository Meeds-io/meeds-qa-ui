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

  Scenario: delete your comment
    Given I am authenticated as 'admin' random user
    And I inject a random space
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with comment to delete'
    And I publish the activity
    Then the activity 'activity with comment to delete' is displayed in activity stream
    When I add in activity 'activity with comment to delete' a comment 'A comment to delete'
    And I open in activity 'activity with comment to delete' the Comments drawer
    Then The comment 'A comment to delete' is displayed in Comments drawer of activity 'activity with comment to delete'

    When I open in activity 'activity with comment to delete' the Comments drawer
    And I click on the comment 'A comment to delete' three dots icon from comments drawer
    And In comment 'A comment to delete', I click on delete button

    And I click on Yes button
    Then the confirmation popup is not displayed
    And The comment 'A comment to delete' is not displayed in Comments drawer of activity 'activity with comment to delete'

  Scenario: comment your activity
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity to comment'
    And I publish the activity
    Then the activity 'activity to comment' is displayed in activity stream
    When I add in activity 'activity to comment' a comment 'comment to display'
    And I open in activity 'activity to comment' the Comments drawer
    Then The comment 'comment to display' is displayed in Comments drawer of activity 'activity to comment'
