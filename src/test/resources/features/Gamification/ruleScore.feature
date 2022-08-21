@gamification
Feature: Check the rules score increase
  for different type of activity on the plf

  Scenario: Send a Kudos
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    When I connect with the first created user
    And I go to my profile
    And I check my points
    And I go to the second user profile
    And I send kudos with message 'rule score kudos'
    When I go to my profile
    Then My points augmented

  Scenario: Receive a connection request
    Given I am authenticated as admin
    And I create the firstgami random user if not existing, no wait
    And I create the secondgami random user if not existing
    When I connect with the secondgami created user
    And I go to my profile
    And I check my points
    And I connect with the firstgami created user
    And I connect to secondgami user
    And I connect with the secondgami created user
    When I go to my profile
    Then My points augmented

  Scenario: Like a comment (in space)
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    When I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'CommentPost'
    And I publish the activity
    And the activity 'CommentPost' is displayed in activity stream
    And I connect with the second created user
    And I go to the random space
    And the activity 'CommentPost' is displayed in activity stream
    And I add in activity 'CommentPost' a comment 'commenttest'
    And I open in activity 'CommentPost' the Comments drawer
    Then Activity Comment 'commenttest' is displayed in Comments drawer
    And Activity Comment 'commenttest' is displayed in activity stream
    When I connect with the first created user
    And I go to my profile
    And I check my points
    And I go to the random space
    And Activity Comment 'commenttest' is displayed in activity stream
    And I like the activity comment 'commenttest'
    And I go to my profile
    Then My points augmented

  Scenario: Receive a like on a post
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    And I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'PostToBeLiked'
    And I publish the activity
    And the activity 'PostToBeLiked' is displayed in activity stream
    And I go to my profile
    And I check my points
    And I go to the random space
    And the activity 'PostToBeLiked' is displayed in activity stream
    And I like the activity 'PostToBeLiked'
    And I connect with the first created user
    And I go to my profile
    Then My points augmented

  Scenario: Create a new wiki page
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I connect with the first created user
    And I go to my profile
    And I check my points
    And I go to the random space
    And I go to notes application of the space
    And I click to add note
    Then Create note form is opened successfully in new tab
    And I close browser tab 1
    And I go to my profile
    Then My points augmented

  Scenario: Receive relationship request
    Given I am authenticated as admin
    And I create the thirdgami random user if not existing, no wait
    And I create the fourthgami random user if not existing
    And I connect with the thirdgami created user
    And I go to my profile
    And I check my points
    And I connect to fourthgami user
    And I connect with the fourthgami created user
    And I accept the connection invitation sent by 'thirdgami' user
    And I connect with the thirdgami created user
    And I go to my profile
    Then My points augmented
