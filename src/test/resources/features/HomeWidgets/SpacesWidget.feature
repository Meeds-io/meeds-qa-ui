@space
@widget
Feature: Spaces widget checking
  As a user
  I want to check the spaces in home page
  In order to validate the page

  @smoke
  Scenario: US 3.3.2_(02) [BACK] Spaces requests to join: See All
    Given I am authenticated as admin
    And I create the first random user
    When I create random space with the first created user
    And I create second random space with the first created user
    And I create third random space with the first created user
    And I create fourth random space with the first created user
    And I create fifth random space with the first created user
    And I connect with the first created user
    Then the invitation number for spaces is '5'
    And The 'Spaces' badge is '5'
    When I click on spaces badge
    Then the drawer with '3' spaces is opened
    When I click on see all
    And the 'Invitations Sent' page is opened

  @ignore
  @smoke
  Scenario: US 3.3.2_(03) [BACK] Spaces requests to join: accept and reject
    Given I am authenticated as admin
    And I create the first random user
    When I create random space with the first created user
    And I create second random space with the first created user
    And I create third random space with the first created user
    When I connect with the first created user
    Then The 'Spaces' badge is '3'
    When I click on spaces badge
    And I accept the invitation of the created space
    Then The 'Spaces' number is '1'
    And The 'Spaces' badge is '2'
    When I click on spaces badge
    And I accept the invitation of the third created space
    And I reject the invitation of the second created space
    Then The 'Spaces' number is '2'