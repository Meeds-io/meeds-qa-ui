@smoke
Feature: Gamification point

  Scenario: check my points
    Given I am authenticated as admin
    And I go to my profile
    Then The following items are displayed
      | Weekly points |
      | Weekly rank   |

  Scenario: check badges pop-over in my badges
    Given I am authenticated as admin
    And I go to my profile

    When I open achievement tab
    And The following items are displayed
      | Achievements |

    And I open badge details
    Then  The following items are displayed
      | badge details |
