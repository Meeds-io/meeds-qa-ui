@gamification
@rules
@standardConfigurationOnly
Feature: Check the rules score increase
  for different type of activity on the plf

  # Instable Use Case
  @skip
  Scenario: Receive a connection request
    Given I am authenticated as 'admin' if random users doesn't exists
      | firstgami  |
      | secondgami  |
    And I create the firstgami random user if not existing, no wait
    And I create the secondgami random user if not existing
    When I login as 'secondgami' random user
    And I go to My Profile page
    And I check my points
    And I login as 'firstgami' random user
    And I connect to secondgami user
    And I login as 'secondgami' random user
    When I go to My Profile page
    Then My points augmented

  Scenario: Like a comment (in space)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    When I login as 'first' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'CommentPost'
    And I publish the activity
    And the activity 'CommentPost' is displayed in activity stream
    And I login as 'second' random user
    And I go to the random space
    And the activity 'CommentPost' is displayed in activity stream
    And I add in activity 'CommentPost' a comment 'commenttest'
    And I open in activity 'CommentPost' the Comments drawer
    Then Activity Comment 'commenttest' is displayed in Comments drawer
    And Activity Comment 'commenttest' is displayed in activity stream
    When I login as 'first' random user
    And I go to My Profile page
    And I check my points
    And I go to the random space
    And Activity Comment 'commenttest' is displayed in activity stream
    And I like the activity comment 'commenttest'
    And I go to My Profile page
    Then My points augmented

  Scenario: Receive a like on a post
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    And I login as 'first' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'PostToBeLiked'
    And I publish the activity
    And the activity 'PostToBeLiked' is displayed in activity stream
    And I go to My Profile page
    And I check my points
    And I go to the random space
    And the activity 'PostToBeLiked' is displayed in activity stream
    And I like the activity 'PostToBeLiked'
    And I login as 'first' random user
    And I go to My Profile page
    Then My points augmented

  # Instable Use Case
  @skip
  Scenario: Receive relationship request
    Given I am authenticated as 'admin' if random users doesn't exists
      | thirdgami  |
      | fourthgami  |
    And I create the thirdgami random user if not existing, no wait
    And I create the fourthgami random user if not existing
    And I login as 'thirdgami' random user
    And I go to My Profile page
    And I check my points
    And I connect to fourthgami user
    And I login as 'fourthgami' random user
    And I accept the connection invitation sent by 'thirdgami' user
    And I login as 'thirdgami' random user
    And I go to My Profile page
    Then My points augmented
