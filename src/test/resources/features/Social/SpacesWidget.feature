@space
@widget
Feature: Spaces widget checking
  As a user
  I want to check the spaces in home page
  In order to validate the page

  @smoke
  Scenario: US 3.3.2_(01) [BACK] No Spaces requests to join
    Given I am authenticated as 'admin' random user
    And I create the third random user if not existing
    When I login as 'third' random user
    And I go to Stream page
    Then The spaces badge isn't displayed


  @smoke
  Scenario: US 3.3.2_(02) [BACK] Spaces requests to join: See All
    Given I am authenticated as 'admin' random user
    And I inject the eighteenth random user if not existing
    And I create a random space with the eighteenth random user
    And I create a random space with the eighteenth random user
    And I create a random space with the eighteenth random user
    And I create a random space with the eighteenth random user
    And I create a random space with the eighteenth random user
    When I login as 'eighteenth' random user
    And I go to Stream page
    Then the invitation number for spaces is '5'
    And The Spaces badge is '5'
    When I click on spaces badge
    Then the drawer with '3' spaces is opened
    When I click on see all
    And The page '/spaces/receivedInvitations' is opened
