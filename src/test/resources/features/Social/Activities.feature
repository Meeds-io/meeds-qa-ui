# new feature
# Tags: optional
Feature: Activities

  @test
  @activitystream
  Scenario: delete your activity
    Given I am authenticated as admin
    And I create the space
    When I click on post in space
    And I enter an activity 'activitytest'
    And I publish the activity
    Then the activity 'activitytest' is displayed in activity stream
    When I click to delete from the dropdownActivitymenu
    And I click on Yes button
    Then the confirmation popup is not displayed
    And the activity 'activitytest' is no more displayed in the activity stream

  @test
  @activitystream
  Scenario:  delete your comment
    Given I am authenticated as admin
    And I create the space
    When I click on post in space
    And I enter an activity 'activitytest'
    And I publish the activity
    Then the activity 'activitytest' is displayed in activity stream
    When I add in activity 'activitytest' a comment 'commenttest'
    And I open in activity 'activitytest' the Comments drawer
    Then Activity Comment 'commenttest' is displayed in Comments drawer
    And Activity Comment 'commenttest' is displayed in activity stream
    When In activity 'activitytest' I delete the comment 'commenttest'
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttest' is not displayed in activity 'activitytest'

  @test
  @activitystream
  Scenario:   comment your activity
    Given I am authenticated as admin
    And I create the space
    When I click on post in space
    And I enter an activity 'activitytest'
    And I publish the activity
    Then the activity 'activitytest' is displayed in activity stream
    When I add in activity 'activitytest' a comment 'commenttest'
    And I open in activity 'activitytest' the Comments drawer
    Then Activity Comment 'commenttest' is displayed in Comments drawer
    And Activity Comment 'commenttest' is displayed in activity stream
