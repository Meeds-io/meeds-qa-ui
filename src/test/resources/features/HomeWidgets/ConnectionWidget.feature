@smoke
@widget
@connection
Feature: Space widgets checking
  As a user
  I want to check the connections in home page
  In order to validate the page

  Scenario: US 3.3.3_(02) [BACK] No Connection requests number
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create the second random user if not existing
    And I create the third random user if not existing
    And I create the fourth random user if not existing
    And I create the fifth random user if not existing
    And I connect to fifth user
    And I connect with the first created user
    And I connect to fifth user
    And I connect with the second created user
    And I connect to fifth user
    And I connect with the third created user
    And I connect to fifth user
    And I connect with the fourth created user
    And I connect to fifth user
    When I connect with the fifth created user
    Then the number of connection requests is '5'

  Scenario: US 3.3.4_(01) [BACK]Connections requests to join: See All
    Given I am authenticated as admin

    And I create the first random user if not existing
    And I create the second random user if not existing
    And I create the third random user if not existing
    And I create the fourth random user if not existing
    And I refresh the page
    And I create the fifth random user if not existing
    And I connect to fifth user
    And I connect with the first created user
    And I connect to fifth user
    And I connect with the second created user
    And I connect to fifth user
    And I connect with the third created user
    And I connect to fifth user
    And I connect with the fourth created user
    And I connect to fifth user
    When I connect with the fifth created user
    Then The 'Connections' badge is '5'
    When I click on connections badge
    Then the drawer with '3' connections is opened
    And I click on see all
    And the 'People' page is opened

  @test
  Scenario:US 3.3.4_(02)[BACK]Connections requests : accept and reject
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create the second random user if not existing
    And I create the third random user if not existing
    And I connect to third user
    And I connect with the first created user
    And I connect to third user
    And I connect with the second created user
    And I connect to third user

    When I connect with the third created user
    Then The 'Connections' badge is '3'
    When I click on connections badge
    And I accept the following connection invitation
      | Admin |
    Then The 'Connections' number is '1'

    Then The 'Connections' badge is '2'
    When I click on connections badge
    And I accept the following connection invitation from random user
      | first |
      | second |
    Then The badge isn't displayed

  @test
  Scenario: US_3.3.7 [BACK]Common Connections for users requests
    Given I am authenticated as admin
    When I create the first random user if not existing
    And I create the second random user if not existing
    And I create the third random user if not existing
    And I create the fourth random user if not existing
    And I create the fifth random user if not existing
    And I connect with the first created user
    And I connect to third user
    And I connect to fourth user
    And I connect with the second created user
    And I connect to third user
    And I connect to fourth user
    And I connect with the third created user
    Then The 'Connections' badge is '2'
    When I click on connections badge
    And I accept the following connection invitation from random user
      | first |
      | second |
    And I connect with the fourth created user
    Then The 'Connections' badge is '2'
    When I click on connections badge
    And I accept the following connection invitation from random user
      | first |
      | second |
    And I connect with the second created user
    And I connect to first user
    And I connect with the fifth created user
    And I connect to first user
    And I connect with the first created user
    Then The 'Connections' badge is '2'
    When I click on connections badge
    Then the drawer with '2' connections is opened
