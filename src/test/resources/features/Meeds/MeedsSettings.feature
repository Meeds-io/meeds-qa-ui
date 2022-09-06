@settings
Feature: Edit sections in Settings page
  As a user
  I want to edit in Settings page many sections

  Scenario: [SETTINGS-5] Language and its drawer
    Given I am authenticated as admin

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
  @ignored
  Scenario: [SETTINGS-6] TimeZone view and drawer
    Given I am authenticated as admin

    And I go to Settings page
    Then Settings Page Is Opened

    When I click on Edit time zone and I change it '+02:00'
    And I cancel editing time zone

    Then Time zone '(GMT +01:00) Central European Standard Time' is displayed

    When I click on Edit time zone and I change it '+02:00'
    And I accept editing language

    Then Time zone '(GMT +02:00) Central Africa Time' is displayed

    When I click on Edit time zone and I change it '+01:00'
    And I accept editing language

    Then Time zone '(GMT +01:00) Central European Standard Time' is displayed

  @ignored
  Scenario: [SETTINGS-7] Security on settings
    Given I connect as admin if random users doesn't exists
      | first  |

    And I create the first random user if not existing
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
    Given I connect as admin if random users doesn't exists
      | first  |

    When I create the first random user if not existing, no wait
    And I connect with the first created user
    And I go to Settings page
    Then Settings Page Is Opened

    When I disable notification via Mail
    Then Notification via Mail is disabled

    When I disable notification on Mobile
    Then Notification On Mobile is disabled

    When I disable notification on Site
    Then Notification On Site is disabled

    When I enable notification via Mail
    Then Notification via Mail is enabled

    When I enable notification on Mobile
    Then Notification On Mobile is enabled

    When I enable notification on Site
    Then Notification On Site is enabled

  Scenario: SETTINGS-4 : Add the favorite icon for Homepage default view
    Given I am authenticated as admin

    And I open Navigation menu
    And I mouse over the stream icon in sidebar menu
    And I click on home icon
    And I click to confirm the new home page
    And I click on home page button
    Then Activity Stream page is displayed