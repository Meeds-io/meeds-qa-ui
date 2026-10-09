Feature: Social
  As a user I have the right
  to comment on any activity in a space in which I am a member

  @activitystream
  Scenario: Comment on your friends activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I login as 'first' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'CommentPost'
    And I publish the activity
    And the activity 'CommentPost' is displayed in activity stream
    And I login as 'second' random user
    And I go to the random space
    And the activity 'CommentPost' is displayed in activity stream
    And I add in activity 'CommentPost' a comment 'commenttest'
    Then The comment 'commenttest' is displayed in Comments drawer of activity 'CommentPost'

  @activitystream
  Scenario: Cancel edit comment
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing, no wait
    When I login as 'first' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'CancelEditComment'
    And I publish the activity
    And the activity 'CancelEditComment' is displayed in activity stream
    And I add in activity 'CancelEditComment' a comment 'comment'
    Then The comment 'comment' is displayed in Comments drawer of activity 'CancelEditComment'
    And I Select the comment added and I click on edit button
    And I set the new comment 'updateComment' and I click on cancel button
    Then The comment 'updateComment' is not displayed in Comments drawer of activity 'CancelEditComment'

  @activitystream
  Scenario: [REPLY_05] The comment is displayed on the buttom of the comment reply section
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | third  |
    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing

    When I login as 'first' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'comment activity'
    And I publish the activity
    Then the activity 'comment activity' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'comment activity' is displayed in activity stream

    And I open in activity 'comment activity' the Comments drawer
    And I add in activity 'comment activity' a comment 'commenttest'
    And I login as 'third' random user
    And I go to the random space
    Then the activity 'comment activity' is displayed in activity stream
    And I open in activity 'comment activity' the Comments drawer
    When I add a reply 'reply' to comment 'commenttest' in activity 'comment activity'
    Then In activity 'comment activity' with comment 'commenttest', the reply 'reply' is displayed
