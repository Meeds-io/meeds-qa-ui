@users
Feature: Users Management
  As an administrator
  I want to check that i can manage the users

  Scenario: [USR_MNG-1.1] Users Grid
    Given I am authenticated as admin

    When I create the seconddisabled random user if not existing
    And I create the first random user if not existing
    And I go to Add Users page
    And I search for the seconddisabled random user
    When I disable User Status 'seconddisabled'
    And I search for 'ENABLED' Users
    And I search for the first random user
    Then The first created user is displayed
    When I search for 'DISABLED' Users
    And I search for the seconddisabled random user
    Then The seconddisabled created user is displayed
    When I enable User Status 'seconddisabled'
    And I search for 'ENABLED' Users
    And I search for the seconddisabled random user
    Then The seconddisabled created user is displayed
