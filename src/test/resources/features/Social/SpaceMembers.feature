Feature: Redactor Role
  Aa a space manager
  I can set / remove redactor role from any user

  Scenario: Add the redactor role for a space member
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    When I login as 'first' random user
    And I create a random space
    And I login as 'second' random user
    Then I go to the random space
    And I login as 'first' random user
    And I go to the random space
    And I click on 'Settings' space menu tab
    And I open 'Roles' Section from Space Settings
    And I enable redactional settings for the space
    And I add the 'second' user as redactor
    And I click on 'Apply' button in drawer
    And I close the notification
    When I login as 'second' random user
    And I go to the random space
    And I click on post in space
    Then "write a short message" drawer  is visible