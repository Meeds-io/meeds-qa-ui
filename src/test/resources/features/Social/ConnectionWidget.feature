@smoke
@widget
@connection
Feature: Connection widgets checking
  As a user
  I want to check the connections in home page
  In order to validate the page

  Scenario: Connection widget accept and refuse user connections
    Given I am authenticated as 'admin' if random users doesn't exists
      | firstcommconn  |
      | secondcommconn  |
      | thirdcommconn  |
      | fourthcommconn  |
      | fifthcommconn  |
    And I inject the firstcommconn random user if not existing, no wait
    And I inject the secondcommconn random user if not existing, no wait
    And I inject the thirdcommconn random user if not existing, no wait
    And I inject the fourthcommconn random user if not existing, no wait
    And I inject the fifthcommconn random user if not existing, no wait
    And I go to the fifthcommconn user profile
    And I connect to the user using the profile
    And I login as 'firstcommconn' random user
    And I go to the fifthcommconn user profile
    And I connect to the user using the profile
    And I login as 'secondcommconn' random user
    And I go to the fifthcommconn user profile
    And I connect to the user using the profile
    And I login as 'thirdcommconn' random user
    And I go to the fifthcommconn user profile
    And I connect to the user using the profile
    And I login as 'fourthcommconn' random user
    And I go to the fifthcommconn user profile
    And I connect to the user using the profile
    When I login as 'fifthcommconn' random user
    And I go to My Profile page
    Then the number of connection requests is '5'
    When I click on connections badge
    Then the drawer with '3' connections is opened
    And I click on see all
    And The page '/people/receivedInvitations' is opened

    When I go to My Profile page
    And I click on connections badge
    And I accept the following connection invitation from random user
      | firstcommconn |
      | secondcommconn |

    When I close the opened drawer
    Then The 'Connections' badge is '3'

    When I click on connections badge
    Then the drawer with '3' connections is opened

    When I accept the following connection invitation from random user
      | admin |
    Then The 'Connections' badge is '2'

    When I click on connections badge
    And I reject the following connection invitation from random user
      | thirdcommconn |
      | fourthcommconn |
    Then The badge isn't displayed
