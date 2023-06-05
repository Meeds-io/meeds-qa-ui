Feature: Redactor Role
  Aa a space manager
  I can set / remove redactor role from any user

  Scenario: CAP112 [US-General-06] Add the redactor role for a space member
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    When I login as 'first' random user
    And I create a random space
    And I login as 'second' random user
    Then I go to the random space
    And I login as 'first' random user
    And I go to the random space
    And I click on 'Members' space menu tab
    Then The search result is well matched with the username entered of the second user
    And I click on three dots menu
    And I set as a redactor
    When I login as 'second' random user
    And I go to the random space
    And I click on post in space
    Then "write a short message" drawer  is visible