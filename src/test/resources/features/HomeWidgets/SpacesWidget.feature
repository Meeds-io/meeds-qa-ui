@space
@widget
Feature: Spaces widget checking
  As a user
  I want to check the spaces in home page
  In order to validate the page
  @exo
  @smoke
  Scenario: US 3.3.2_(02) [BACK] Spaces requests to join: See All
    Given I am authenticated as admin
    And I create the fourth random user if not existing
    And I create a random space with the fourth random user
    And I create a random space with the fourth random user
    And I create a random space with the fourth random user
    And I create a random space with the fourth random user
    And I create a random space with the fourth random user
    When I connect with the fourth created user
    And I go to Stream page
    Then the invitation number for spaces is '5'
    And The 'Spaces' badge is '5'
    When I click on spaces badge
    Then the drawer with '3' spaces is opened
    When I click on see all
    And The 'Invitations Sent' page is opened

  @smoke
  @ignored
  Scenario: US 3.3.2_(03) [BACK] Spaces requests to join: accept and reject
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create a first random space with the first created user as member
    And I create a second random space with the first created user as member
    And I create a third random space with the first created user as member
    When I connect with the first created user
    Then The 'Spaces' badge is '3'
    When I click on spaces badge
    And I accept the invitation of the first created space
    Then The 'Spaces' number is '1'
    And The 'Spaces' badge is '2'
    When I click on spaces badge
    And I reject the invitation of the second created space
    And I accept the invitation of the third created space
    Then The 'Spaces' number is '2'