Feature: Redactor Role
  Aa a space manager
  I can set / remove redactor role from any user

  Scenario: CAP112 [US-General-06] Add the redactor role for a space member
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    When I connect with the first created user
    And I create a random space
    And I connect with the second created user
    Then I go to the random space
    And I connect with the first created user
    And I go to the random space
    And I click on 'Members' space menu tab
    And I enter the contact name of the second user
    Then The search result is well matched with the username entered of the second user
    And I click on three dots menu
    And I set as a redactor
    When I connect with the second created user
    And I go to the random space
    And I click on post in space
    Then "write a short message" drawer  is visible