# new feature
# Tags: optional
Feature: Social
  As a user I have the right
  to comment on any activity in a space in which I am a member

  @activitystream
  Scenario: Comment on your friends activity
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user
    When I connect with the first created user
    And I create random space with the second created user
    And I click on post in space
    And I enter an activity 'CommentPost'
    And I publish the activity
    And the activity 'CommentPost' is displayed in activity stream
    Then I connect with the second created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    When I go to the created space
    And the activity 'CommentPost' is displayed in activity stream
    And I add in activity 'CommentPost' a comment 'commenttest'
    And I open in activity 'CommentPost' the Comments drawer
    Then Activity Comment 'commenttest' is displayed in Comments drawer
    And Activity Comment 'commenttest' is displayed in activity stream

  @failing
  Scenario: Search users in My connections tab
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user
    And I connect with the first created user
    And I connect to second user
    And I connect with the second created user
    Then The 'Connections' badge is '1'
    When I click on connections badge
    And I accept the following connection invitation sent by first user
    And I refresh the page
    And  I go to Person Page
    When I click on People filter and I select My connections
    And  I enter the contact name of the first user
    Then The search result is well matched with the username entered of the first user

  @activitystream
  Scenario: Cancel edit comment
    Given I am authenticated as admin
    And I create the first random user
    When I connect with the first created user
    And I create the space
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
  @failing
  Scenario: [REPLY_05] The comment is displayed on the buttom of the comment reply section
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user
    And I create the third random user

    When I connect with the first created user
    And I create random space with the second created user
    And I click on post in space
    And I enter an activity 'comment activity'
    And I publish the activity
    Then the activity 'comment activity' is displayed in activity stream

    When I connect with the second created user
    Then The 'Spaces' badge is '1'

    When I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    And I go to the created space
    Then the activity 'comment activity' is displayed in activity stream

    When I add in activity 'comment activity' a comment 'commenttest'
    And I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'comment activity' is displayed in activity stream
    When I add a reply 'reply' to comment 'commenttest' in activity 'comment activity'
    Then In activity 'comment activity' with comment 'commenttest', the reply 'reply' is displayed