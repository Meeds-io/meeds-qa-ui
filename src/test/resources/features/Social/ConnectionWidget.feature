@smoke
@widget
@connection
Feature: Connection widgets checking
  As a user
  I want to check the connections in home page
  In order to validate the page

  Scenario: US 3.3.3_(01)[BACK] No Connection requests to join
    Given I am authenticated as 'admin' if random users doesn't exists
      | simpleuser  |
    And I create the simpleuser random user if not existing, no wait
    When I login as 'simpleuser' random user
    And I go to Stream page
    Then The badge isn't displayed

  Scenario: US 3.3.3_(02) [BACK] No Connection requests number
    Given I am authenticated as 'admin' if random users doesn't exists
      | firstnoconn  |
      | secondnoconn  |
      | thirdnoconn  |
      | fourthnoconn  |
      | fifthnoconn  |
    And I create the firstnoconn random user if not existing, no wait
    And I create the secondnoconn random user if not existing, no wait
    And I create the thirdnoconn random user if not existing, no wait
    And I create the fourthnoconn random user if not existing, no wait
    And I create the fifthnoconn random user if not existing
    And I connect to fifthnoconn user
    And I login as 'firstnoconn' random user
    And I connect to fifthnoconn user
    And I login as 'secondnoconn' random user
    And I connect to fifthnoconn user
    And I login as 'thirdnoconn' random user
    And I connect to fifthnoconn user
    And I login as 'fourthnoconn' random user
    And I connect to fifthnoconn user
    When I login as 'fifthnoconn' random user
    And I go to Stream page
    Then the number of connection requests is '5'

  Scenario: US 3.3.4_(01) [BACK]Connections requests to join: See All
    Given I am authenticated as 'admin' random user
    And I inject the firstconn random user, no wait
    And I inject the secondconn random user, no wait
    And I inject the thirdconn random user, no wait
    And I inject the fourthconn random user, no wait
    And I inject the fifthconn random user
    And I connect to fifthconn user
    And I login as 'firstconn' random user
    And I connect to fifthconn user
    And I login as 'secondconn' random user
    And I connect to fifthconn user
    And I login as 'thirdconn' random user
    And I connect to fifthconn user
    And I login as 'fourthconn' random user
    And I connect to fifthconn user
    When I login as 'fifthconn' random user
    And I wait '3' seconds
    And I go to Stream page
    Then The 'Connections' badge is '5'
    When I click on connections badge
    Then the drawer with '3' connections is opened
    And I click on see all
    And The page '/connexions/receivedInvitations' is opened

  Scenario:US 3.3.4_(02)[BACK]Connections requests : accept and reject
    Given I am authenticated as 'admin' if random users doesn't exists
      | firstrequ  |
      | secondrequ  |
      | thirdrequ  |
    And I create the firstrequ random user if not existing, no wait
    And I create the secondrequ random user if not existing, no wait
    And I create the thirdrequ random user if not existing
    And I login as 'firstrequ' random user
    And I connect to thirdrequ user
    And I login as 'secondrequ' random user
    And I connect to thirdrequ user
    And I login as 'admin' random user
    And I connect to thirdrequ user

    When I login as 'thirdrequ' random user
    And I go to Stream page
    Then The 'Connections' badge is '3'
    When I click on connections badge
    And I accept the following connection invitation
      | admin |
    Then The 'Connections' number is '1'

    Then The 'Connections' badge is '2'
    When I click on connections badge
    And I accept the following connection invitation from random user
      | firstrequ |
      | secondrequ |
    Then The badge isn't displayed

  Scenario: US_3.3.7 [BACK]Common Connections for users requests
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
    And I connect to fifthcommconn user
    And I login as 'firstcommconn' random user
    And I connect to fifthcommconn user
    And I login as 'secondcommconn' random user
    And I connect to fifthcommconn user
    And I login as 'thirdcommconn' random user
    And I connect to fifthcommconn user
    And I login as 'fourthcommconn' random user
    And I connect to fifthcommconn user
    When I login as 'fifthcommconn' random user
    And I go to Stream page
    Then the number of connection requests is '5'
    When I click on connections badge
    Then the drawer with '3' connections is opened
    And I click on see all
    And The page '/people/receivedInvitations' is opened

    When I go to Stream page
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
