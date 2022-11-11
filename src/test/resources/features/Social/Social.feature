Feature: Social
  As a user I have the right
  to comment on any activity in a space in which I am a member

  @activitystream
  Scenario: Comment on your friends activity
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    And I connect with the first created user
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
  @exo
  Scenario: Search users in My connections tab
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    And I connect with the first created user
    And I connect to second user
    And I connect with the second created user
    And I go to Stream page
    Then The 'Connections' badge is '1'
    When I click on connections badge
    And I accept the following connection invitation from random user
      | first |
    And I refresh the page
    And  I go to Person Page
    When I click on People filter and I select My connections
    And  I enter the contact name of the first user
    Then The search result is well matched with the username entered of the first user

  @activitystream
  Scenario: Cancel edit comment
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing, no wait
    When I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'CancelEditComment'
    And I publish the activity
    And the activity 'CancelEditComment' is displayed in activity stream
    And I add in activity 'CancelEditComment' a comment 'comment'
    And I open in activity 'CancelEditComment' the Comments drawer
    Then Activity Comment 'comment' is displayed in Comments drawer
    And I Select the comment added and I click on edit button
    And I set the new comment 'updateComment' and I click on cancel button
    Then Comment 'updateComment' is not displayed in activity 'CancelEditComment'
    And Activity Comment 'comment' is displayed in activity stream

  @activitystream
  Scenario: [REPLY_05] The comment is displayed on the buttom of the comment reply section
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    When I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'comment activity'
    And I publish the activity
    Then the activity 'comment activity' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'comment activity' is displayed in activity stream

    When I add in activity 'comment activity' a comment 'commenttest'
    And I connect with the third created user
    And I go to the random space
    Then the activity 'comment activity' is displayed in activity stream
    When I add a reply 'reply' to comment 'commenttest' in activity 'comment activity'
    Then In activity 'comment activity' with comment 'commenttest', the reply 'reply' is displayed