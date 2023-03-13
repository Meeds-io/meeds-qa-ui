@notes
Feature: Notes
  I want to manage notes

  @notes
  @smoke
  Scenario: Edit a Note in full screen
    Given I connect as admin if random users doesn't exists
      | hamburgermenu  |
    And I create the hamburgermenu random user if not existing, no wait
    When I connect with the hamburgermenu created user
    And I go to the random space
    And I open hamburger menu drawer
    And I stick the hamburger menu
    And I click on 'Notes' space menu tab
    Then The hamburger menu is displayed as stickied
    And I edit displayed note
    Then The notes editor is displayed in full page
    When I close current browser tab
    And I unstick the hamburger menu
    Then The hamburger menu is displayed as unstickied
