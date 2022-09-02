@people
Feature: Search for Contacts in People page
  As a user
  I want to check in People page all contacts informations

  @ignored
  Scenario: : PEOPLE-6 - Integrate the Suggestions widget in People App
    Given I am authenticated as admin
    And I create a dedicated user to be an administrator
    And I go to groups Management page
    And I open the group 'Platform'
    And I select the group 'Administration'
    And I add the role '*' to the dedicated user to be an administrator
    And I refresh the page
    And I open the group 'Organization'
    And I select the group 'Employees'
    And I add the role 'manager' to the dedicated user to be an administrator
    And I refresh the page
    And I open the group 'Platform'
    And I select the group 'Content Management'
    And I add the role '*' to the dedicated user to be an administrator
    And I refresh the page
    And I open the group 'Organization'
    And I open the group 'Management'
    And I select the group 'Executive Board'
    And I add the role 'manager' to the dedicated user to be an administrator
    And I refresh the page
    And I open the group 'Platform'
    And I select the group 'Users'
    And I add the role '*' to the dedicated user to be an administrator
    And I refresh the page

    When I connect with the dedicated user to be an administrator
    When I create the first random user if not existing
    And I create the second random user if not existing
    And I create the third random user if not existing
    And I refresh the page
    And I create the fourth random user if not existing

    When I go to Person Page
    Then The suggestion widget is existing and displayed two users with Add button and Delete buttons

    When I add the first user suggestion
    Then First User Suggestion is not displayed

    When I delete the user suggestion
    Then User Suggestion after deletion is not displayed

    When I refresh the page
    And I go to Sent Requests
    Then The added user suggestion is displayed
    And The deleted user suggestion is not displayed
    And I close Sent Request button

    Then I go to Sent Requests
    And I delete Sent Request
    And I close Sent Request button

  @smoke
  Scenario: : PEOPLE-7 : Leaderboard in the People Cards list application
    Given I am authenticated as admin

    When I create the first random user if not existing
    And I create the second random user if not existing
    And I create the third random user if not existing
    And I create the fourth random user if not existing

    And I go to Person Page
    Then Leaderboard Widget is displayed with title 'Leaderboard'

    And First two places on Leaderboard are displayed
    And First two users points on Leaderboard are displayed
    And Current User position and points on Leaderboard are displayed
