@sidebar
Feature: SideBar

  @smoke
  Scenario: CAP37 - US 6.2.2 [FRONT]_(01) : Filter Recent Spaces in the Second level side bar in Desktop
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I create the first random user if not existing, no wait
    When I login as 'first' random user
    And I go to the first random space
    And I go to the second random space
    And I access to Recent spaces
    And I search for the second created space in Side Bar Filter
    Then Second searched space is displayed in Side Bar Filter
    And First searched space is not displayed in Side Bar Filter

  @smoke
  Scenario:CAP34-US 6.5[FRONT]_(01):My Settings in the Side bar for Desktop
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I create the first random user if not existing, no wait
    When I login as 'first' random user
    When I go to Settings page
    Then The page 'settings' that contains 'Manage notifications' is displayed

  @smoke
  Scenario: Stick and Unstick Hamburger Menu
    Given I am authenticated as 'admin' random user
    And I create the hmenu random user, no wait
    When I login as 'hmenu' random user
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
    And I login as 'hmenu' random user
    Then The hamburger menu is displayed as stickied
    And The hamburger menu has all navigation elements into it
    And I unstick the hamburger menu
    Then The hamburger menu is displayed as unstickied
    When I logout
    And I login as 'hmenu' random user
    Then The hamburger menu is displayed as unstickied

  Scenario: Recent Space Hamburger Menu
    Given I am authenticated as 'admin' random user
    And I create the third random space if not existing
    And I create the fourth random space if not existing
    And I go to the fourth random space
    Then The third random space is displayed as second item in recent spaces menu
    Then The fourth random space is displayed as first item in recent spaces menu
    When I close the opened drawer
    And I go to Settings in space tab
    And I click on arrow icon of application space settings
    And I move third application before
    Then Previously third application in settings is displayed as third menu item in fourth random space left menu
    When I close the opened drawer
    And I move second application after
    Then The third application in settings is displayed as fourth menu item in fourth random space left menu
    When I go to the third random space
    Then The third random space is displayed as first item in recent spaces menu
    And The fourth random space is displayed as second item in recent spaces menu
    When I open the third random space menu details
    Then The third random space name and description are displayed in second manu level
    When I open the fourth random space menu details
    Then The fourth random space name and description are displayed in second manu level
    And I close the opened drawer

  Scenario: Display Red Dot In Unstickied Hamburger Menu
    Given I am authenticated as 'admin' random user
    When I create the reddot random user if not existing, no wait
    And I create a random space
    And I login as 'reddot' random user
    And I go to the random space
    And I login as 'admin' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Unread - This is an unread activity for the reddot user'
    And I publish the activity
    And I login as 'reddot' random user
    Then The hamburger menu is displayed as unstickied
    And The red dot is displayed in the hamburger menu
    When I go to the random space
    And I wait '5' seconds
    Then The hamburger menu is displayed as unstickied
    And The red dot is not displayed in the hamburger menu
    When I refresh the page
    Then The hamburger menu is displayed as unstickied
    And The red dot is not displayed in the hamburger menu
    
  Scenario: Open Unstickied Hamburger Menu On Hover in Desktop
    Given I am authenticated as 'admin' if random users doesn't exists
      | hmenu  |
    And I create the hmenu random user, no wait
    And I login as 'hmenu' random user
    And The hamburger menu is displayed as unstickied
    When I hover on the hambuger menu
    And I wait '500' milliseconds
    Then The hamburger menu has all navigation elements into it
    When I hover on the drawer overlay
    And I wait '500' milliseconds
    Then The hamburger menu is closed
    
    
