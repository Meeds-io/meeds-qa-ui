@sidebar
Feature: SideBar

  @smoke
  Scenario: CAP37 - US 6.2.2 [FRONT]_(01) : Filter Recent Spaces in the Second level side bar in Desktop
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing
    When I connect with the first created user
    And I go to the first random space
    And I go to the second random space
    And I access to Recent spaces
    And I search for the second created space in Side Bar Filter
    Then Second searched space is displayed in Side Bar Filter
    And First searched space is not displayed in Side Bar Filter

  @smoke
  Scenario:CAP34-US 6.5[FRONT]_(01):My Settings in the Side bar for Desktop
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing
    When I connect with the first created user
    When I go to Settings page
    Then The page 'settings' that contains 'Manage notifications' is displayed

  @smoke
  Scenario: Stick and Unstick Hamburger Menu
    Given I connect as admin if random users doesn't exists
      | hamburgermenu  |
    And I create the hamburgermenu random user if not existing
    When I connect with the hamburgermenu created user
    Then The hamburger menu is displayed as unstickied
    When I open hamburger menu drawer
    Then The hamburger menu has all navigation elements into it
    And I stick the hamburger menu
    Then The hamburger menu is displayed as stickied
    And The hamburger menu has all navigation elements into it
    When I refresh the page
    Then The hamburger menu is displayed as stickied
    And The hamburger menu has all navigation elements into it
    When I logout
    And I connect with the hamburgermenu created user
    Then The hamburger menu is displayed as stickied
    And The hamburger menu has all navigation elements into it
    And I unstick the hamburger menu
    Then The hamburger menu is displayed as unstickied
    When I logout
    And I connect with the hamburgermenu created user
    Then The hamburger menu is displayed as unstickied
