# new feature
# Tags: optional
@firstpart
Feature: Redactor Role
  Aa a space manager
  I can set / remove redactor role from any user

  Scenario: CAP112 - [US-General-06] : Add the redactor role for a space member
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create the second random user
    When I connect with the first created user
    And I create random space with the second created user
    And I connect with the second created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I connect with the first created user
    And I go to the created space
    And I go to 'Members' tab
    And I enter the contact name of the second user
    Then The search result is well matched with the username entered of the second user
    And I click on three dots menu
    And I set as a redactor
    When I connect with the second created user
    And I go to the created space
    And I click on post in space
    Then "write a short message" drawer  is visible