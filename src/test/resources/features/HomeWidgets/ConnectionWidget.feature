@smoke
@widget
@connection
Feature: Space widgets checking
  As a user
  I want to check the connections in home page
  In order to validate the page

  Scenario: US 3.3.3_(02) [BACK] No Connection requests number
    Given I connect as admin if random users doesn't exists
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
    And I connect with the firstnoconn created user
    And I connect to fifthnoconn user
    And I connect with the secondnoconn created user
    And I connect to fifthnoconn user
    And I connect with the thirdnoconn created user
    And I connect to fifthnoconn user
    And I connect with the fourthnoconn created user
    And I connect to fifthnoconn user
    When I connect with the fifthnoconn created user
    And I go to Stream page
    Then the number of connection requests is '5'

  Scenario: US 3.3.4_(01) [BACK]Connections requests to join: See All
    Given I connect as admin if random users doesn't exists
      | firstconn  |
      | secondconn  |
      | thirdconn  |
      | fourthconn  |
      | fifthconn  |

    And I create the firstconn random user if not existing, no wait
    And I create the secondconn random user if not existing, no wait
    And I create the thirdconn random user if not existing, no wait
    And I create the fourthconn random user if not existing, no wait
    And I create the fifthconn random user if not existing
    And I connect to fifthconn user
    And I connect with the firstconn created user
    And I connect to fifthconn user
    And I connect with the secondconn created user
    And I connect to fifthconn user
    And I connect with the thirdconn created user
    And I connect to fifthconn user
    And I connect with the fourthconn created user
    And I connect to fifthconn user
    When I connect with the fifthconn created user
    And I go to Stream page
    Then The 'Connections' badge is '5'
    When I click on connections badge
    Then the drawer with '3' connections is opened
    And I click on see all
    And The page '/people' is opened

  Scenario:US 3.3.4_(02)[BACK]Connections requests : accept and reject
    Given I connect as admin if random users doesn't exists
      | firstrequ  |
      | secondrequ  |
      | thirdrequ  |
    And I create the firstrequ random user if not existing, no wait
    And I create the secondrequ random user if not existing, no wait
    And I create the thirdrequ random user if not existing
    And I connect to thirdrequ user
    And I connect with the firstrequ created user
    And I connect to thirdrequ user
    And I connect with the secondrequ created user
    And I connect to thirdrequ user

    When I connect with the thirdrequ created user
    And I go to Stream page
    Then The 'Connections' badge is '3'
    When I click on connections badge
    And I accept the following connection invitation
      | Admin |
    Then The 'Connections' number is '1'

    Then The 'Connections' badge is '2'
    When I click on connections badge
    And I accept the following connection invitation from random user
      | firstrequ |
      | secondrequ |
    Then The badge isn't displayed

  Scenario: US_3.3.7 [BACK]Common Connections for users requests
    Given I connect as admin if random users doesn't exists
      | firstcommconn  |
      | secondcommconn  |
      | thirdcommconn  |
      | fourthcommconn  |
      | fifthcommconn  |
    When I create the firstcommconn random user if not existing, no wait
    And I create the secondcommconn random user if not existing, no wait
    And I create the thirdcommconn random user if not existing, no wait
    And I create the fourthcommconn random user if not existing, no wait
    And I create the fifthcommconn random user if not existing
    And I connect with the firstcommconn created user
    And I connect to thirdcommconn user
    And I connect to fourthcommconn user
    And I connect with the secondcommconn created user
    And I connect to thirdcommconn user
    And I connect to fourthcommconn user
    And I connect with the thirdcommconn created user
    And I go to Stream page
    Then The 'Connections' badge is '2'
    When I click on connections badge
    And I accept the following connection invitation from random user
      | firstcommconn |
      | secondcommconn |
    And I connect with the fourthcommconn created user
    And I go to Stream page
    Then The 'Connections' badge is '2'
    When I click on connections badge
    And I accept the following connection invitation from random user
      | firstcommconn |
      | secondcommconn |
    And I connect with the secondcommconn created user
    And I connect to firstcommconn user
    And I connect with the fifthcommconn created user
    And I connect to firstcommconn user
    And I connect with the firstcommconn created user
    And I go to Stream page
    Then The 'Connections' badge is '2'
    When I click on connections badge
    Then the drawer with '2' connections is opened
