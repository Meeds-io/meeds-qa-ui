Feature: Edit sections in Settings page
  As a user
  I want to edit in Settings page many sections

  Scenario: : SETTINGS-5 : Language and its drawer
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |

    And I go to Settings page
    Then Settings Page Is Opened

    When I click on Edit language and I change it 'French'
    And I cancel editing language

    Then Language 'English' is displayed

    When I click on Edit language and I change it 'French'
    And I accept editing language

    Then Language 'French' is displayed

    When I click on Edit language and I change it 'English'
    And I accept editing language

    Then Language 'English / English' is displayed

  Scenario: : SETTINGS-6 : TimeZone view and drawer
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |

    And I go to Settings page
    Then Settings Page Is Opened

    When I click on Edit time zone and I change it '+02:00'
    And I cancel editing time zone

    Then Time zone '(GMT +01:00) Central European Time' is displayed

    When I click on Edit time zone and I change it '+02:00'
    And I accept editing language

    Then Time zone '(GMT +02:00) Central African Time' is displayed

    When I click on Edit time zone and I change it '+01:00'
    And I accept editing language

    Then Time zone '(GMT +01:00) Central European Time' is displayed

  Scenario: : SETTINGS-7 : Security on settings
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |

    And I create the first random user
    And I connect with the first created user
    And I go to Settings page
    Then Settings Page Is Opened

    When I enter the old password and the new random password
    And I cancel editing password

    Then I connect with the first created user

    When I go to Settings page
    Then Settings Page Is Opened

    When I enter the old password and the new random password
    And I accept editing password

    Then I connect with the first created user with the edited password

    When I go to Settings page
    Then Settings Page Is Opened

    When I enter the edited password and the old password
    And I accept editing password

    Then I connect with the first created user

  Scenario: : SETTINGS-8 : Notifications section (Disable Notifications)
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |

    When I create the first random user

    Then I connect with the first created user

    And I go to Settings page
    Then Settings Page Is Opened

    When I disable notification via Mail
    And I disable notification on Mobile
    And I disable notification on Site

    Then The 'DisabledNotifications' is displayed

    When I enable notification via Mail
    And I enable notification on Mobile
    And I enable notification on Site

    Then The 'EnabledNotifications' is displayed

  Scenario: SETTINGS-4 : Add the favorite icon for Homepage default view
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |

    And I open Navigation menu
    And I mouse over the stream icon in sidebar menu
    And I click on home icon
    And I click to confirm the new home page
    And I click on home page button
    Then Activity Stream page is displayed




