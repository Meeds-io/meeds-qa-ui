@smoke
Feature: Achievements gamification

  Scenario: Check my achievement in user profile menu
    Given I am authenticated as admin
    And I go to my profile
    When I open achievement tab
    And The following items are displayed
      | Achievements            |
      | Total point achievement |

  Scenario:[ID:US16] Add How to earn my points page
    Given I am authenticated as admin
    And I go to my profile
    When I open achievement tab
    And I open How To Earn Point Page
    Then The 'howToEarnPointPage' is displayed
