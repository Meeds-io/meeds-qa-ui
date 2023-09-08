@notificationSettings
Feature: Title of your feature

  Scenario: Enable/Disbale global email notification channel
    Given I am authenticated as 'admin' random user

    When I go to notification administration Page
    And I disable email notifications for all users
    And I go to Settings page

    Then The email notification setting is hidden

    When I go to manage notifications from settings page
    Then The email notification settings are hidden in all notification types

    When I go to notification administration Page
    And I enable email notifications for all users
    And I go to Settings page

    Then The email notification setting is displayed

    When I enable email notification personal setting
    And I go to manage notifications from settings page
    Then The email notification settings are displayed in some notification types

  Scenario: Enable/Disbale email channel for a notification type
    Given I am authenticated as 'admin' random user

    When I go to notification administration Page
    And I disable email notification for 'A connection request is sent'
    And I go to Settings page
    And I go to manage notifications from settings page
    Then The email notification setting for 'Someone sends me a connection request' is hidden

    When I go to notification administration Page
    And I enable email notification for 'A connection request is sent'
    And I go to Settings page
    And I go to manage notifications from settings page
    Then The email notification setting for 'Someone sends me a connection request' is displayed

  Scenario: Edit email sender
    Given I am authenticated as 'admin' random user

    When I go to notification administration Page

    And I edit notification sender information
    And I set the following information
      | name  | Test Name |
      | email | hub@email.com |
    And I click on 'Apply' button in drawer
    Then The message 'Test Name <hub@email.com>' is displayed in page

    When I go to notification administration Page
    And I edit notification sender information
    And I set the following information
      | name  | Fake Hub  |
      | email | test @email.com |
    And I click on 'Apply' button in drawer
    Then The 'Manage notifications settings' drawer is displayed

    When I go to notification administration Page
    And I edit notification sender information
    And I set the following information
      | name  | |
      | email | test@email.com |
    And I click on 'Apply' button in drawer
    Then The 'Manage notifications settings' drawer is displayed

    When I go to notification administration Page
    And I edit notification sender information
    And I set the following information
      | name  | Hub Name |
      | email | test @email.com |
    And I click on 'Apply' button in drawer
    Then The 'Manage notifications settings' drawer is displayed

    When I go to notification administration Page
    And I edit notification sender information
    And I set the following information
      | name  | Hub Name |
      | email | test@email.com |
    And I click on 'Apply' button in drawer
    Then The message 'Hub Name <test@email.com>' is displayed in page
