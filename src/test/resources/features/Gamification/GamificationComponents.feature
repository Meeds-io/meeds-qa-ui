@firstpart
Feature: Gamification Components

  Scenario: check badges pop-over in my badges
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user

    When I connect with the first created user

    And I create the random space
    And I create the second random space
    And I create the third random space
    And I create the fourth random space
    And I click on post in space
    And I enter an activity 'kudosPostActivity'
    And I publish the activity
    And I like the activity 'kudosPostActivity'
    And I add in activity 'kudosPostActivity' a comment 'commenttest'
    And I open in activity 'kudosPostActivity' the Comments drawer
    Then Activity Comment 'commenttest' is displayed in Comments drawer
    And Activity Comment 'commenttest' is displayed in activity stream

    When I go to the second created space
    And I click on post in space
    And I enter an activity 'kudosPostActivity2'
    And I publish the activity

    And I like the activity 'kudosPostActivity2'
    And I add in activity 'kudosPostActivity2' a comment 'commenttest2'
    And I open in activity 'kudosPostActivity2' the Comments drawer
    Then Activity Comment 'commenttest2' is displayed in Comments drawer
    And Activity Comment 'commenttest2' is displayed in activity stream

    When I go to my profile
    And I open achievement tab
    And The following items are displayed
      | Achievements |
    And I open badge details
    Then  The following items are displayed
      | badge details |
