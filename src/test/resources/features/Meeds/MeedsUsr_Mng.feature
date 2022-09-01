@users
Feature: Users Management
  As an administrator
  I want to check that i can manage the users

  Scenario: [USR_MNG-1.1] Users Grid
    Given I am authenticated as admin

    When I create the first random user if not existing
    And I create the second random user if not existing
    And I search for second created user
    When I disable the second created User Status
    And I refresh the page
    And I search for 'ENABLED' Users
    Then The first created user is displayed
    When I search for 'DISABLED' Users
    Then The second created user is displayed

  @ignored
  Scenario: [USR_MNG-1.5] Delete User
    Given I am authenticated as admin

    When I create the firsttodelete random user if not existing

    Then I search for the firsttodelete random user
    And I delete user

    When I refresh the page
    And I search for the firsttodelete random user
    Then I check that the firsttodelete random user is deleted

    When I refresh the page
    And I search for created user 'admin'
    And I click to delete user
    Then Popup is displayed to inform user that we can't delete your user account while being logged in with it