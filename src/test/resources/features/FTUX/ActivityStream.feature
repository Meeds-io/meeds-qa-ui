@activitystream
Feature: Activity Stream

  @ignored
  Scenario: CAP02 - ActivityStream_US03: new Activity body with text display
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    And I connect with the second created user
    And I go to the random space

    When I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP02-02' mentioning the second user
    And I publish the activity
    Then In post 'activityTestCAP02-02', the mentioned second user is displayed

    When In post 'activityTestCAP02-02', I mouse over the mentioned second user
    Then User Popover of the second user is displayed

    When I click on the second user Popover
    Then The profile page is displayed

  @test
  Scenario: CAP04 - [ActivityStream_US05] Display 10 activities in Activity Stream
    Given I connect as admin if random users doesn't exists
      | first  |
      | second |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    And I connect with the first created user

    And I go to the random space
    When I post '15' activities with prefix 'act_CAP04_'
    And I refresh the page
    Then the activity 'act_CAP04_15' is displayed in activity stream
    And the activity 'act_CAP04_14' is displayed in activity stream
    And the activity 'act_CAP04_6' is displayed in activity stream
    And the activity 'act_CAP04_5' is not displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'act_CAP04_15' is displayed in activity stream
    And the activity 'act_CAP04_14' is displayed in activity stream
    And the activity 'act_CAP04_6' is displayed in activity stream
    And the activity 'act_CAP04_5' is not displayed in activity stream

    When I connect with the first created user
    And I go to the random space
    And I click on modify the activity 'act_CAP04_15'
    And I enter an activity 'act15updated'
    And I click on Update
    And I click on modify the activity 'act_CAP04_14'
    And I enter an activity 'act14updated'
    And I click on Update
    Then the activity 'act15updated' is displayed in activity stream
    And the activity 'act14updated' is displayed in activity stream
    And the activity 'act_CAP04_15' is not displayed in activity stream

    When I click on Load more button
    Then the activity 'act_CAP04_5' is displayed in activity stream

    When I click on modify the activity 'act_CAP04_5'
    And I enter an activity 'act5updated'
    And I click on Update

    When I connect with the second created user
    And I go to the random space

    Then the activity 'act5updated' is displayed in activity stream
    And the activity 'act15updated' is displayed in activity stream
    And the activity 'act14updated' is displayed in activity stream
    And the activity 'act_CAP04_5' is not displayed in activity stream
    And the activity 'act_CAP04_6' is not displayed in activity stream

    When I click on Load more button
    Then the activity 'act_CAP04_6' is displayed in activity stream
    Then the activity 'act_CAP04_1' is displayed in activity stream

  Scenario: CAP100 - [ActivityStream_US38][04] Cancel Delete comment with replies from the activity stream
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second |
      | third |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP100-100'
    And I publish the activity
    Then the activity 'activityTestCAP100-100' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP100-100' is displayed in activity stream
    When I add in activity 'activityTestCAP100-100' a comment 'commenttestCAP100-100'
    And I open in activity 'activityTestCAP100-100' the Comments drawer
    Then Activity Comment 'commenttestCAP100-100' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP100-100' is displayed in activity stream

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP100-100' is displayed in activity stream
    And Activity Comment 'commenttestCAP100-100' is displayed in activity stream
    When I add a reply 'replyTestCAP100-100' to comment 'commenttestCAP100-100' in activity 'activityTestCAP100-100'
    Then In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-100' is displayed

    When I change user admin

    And I go to the random space
    Then the activity 'activityTestCAP100-100' is displayed in activity stream
    And Activity Comment 'commenttestCAP100-100' is displayed in activity stream
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-100' is displayed
    When I add a reply 'replyTestCAP100-101' to comment 'commenttestCAP100-100' in activity 'activityTestCAP100-100'
    Then In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-101' is displayed

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP100-100' is displayed in activity stream
    And Activity Comment 'commenttestCAP100-100' is displayed in activity stream
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-100' is displayed
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-101' is displayed

    When In activity 'activityTestCAP100-100', I click on the comment 'commenttestCAP100-100' three dots icon
    And In comment 'commenttestCAP100-100', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And Activity Comment 'commenttestCAP100-100' is displayed in activity stream
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-100' is displayed
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-101' is displayed

  @ignored
  Scenario: CAP101 - [ActivityStream_US38][05] Delete a reply from the activity stream
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP101-101'
    And I publish the activity
    Then the activity 'activityTestCAP101-101' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP101-101' is displayed in activity stream
    When I add in activity 'activityTestCAP101-101' a comment 'commenttestCAP101-101'
    And I open in activity 'activityTestCAP101-101' the Comments drawer
    Then Activity Comment 'commenttestCAP101-101' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP101-101' is displayed in activity stream

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP101-101' is displayed in activity stream
    And Activity Comment 'commenttestCAP101-101' is displayed in activity stream
    When I add a reply 'replyTestCAP101-101' to comment 'commenttestCAP101-101' in activity 'activityTestCAP101-101'
    Then In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-101' is displayed

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP101-101' is displayed in activity stream
    And Activity Comment 'commenttestCAP101-101' is displayed in activity stream
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-101' is displayed
    When I add a reply 'replyTestCAP101-102' to comment 'commenttestCAP101-101' in activity 'activityTestCAP101-101'
    Then In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-102' is displayed

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP101-101' is displayed in activity stream
    And Activity Comment 'commenttestCAP101-101' is displayed in activity stream
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-101' is displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-102' is displayed
    When I add a reply 'replyTestCAP101-103' to comment 'commenttestCAP101-101' in activity 'activityTestCAP101-101'
    Then In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-103' is displayed

    When I change user admin

    And I go to the random space
    Then the activity 'activityTestCAP101-101' is displayed in activity stream
    And Activity Comment 'commenttestCAP101-101' is displayed in activity stream
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-101' is not displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-102' is displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-103' is displayed
    When I add a reply 'replyTestCAP101-104' to comment 'commenttestCAP101-101' in activity 'activityTestCAP101-101'
    Then In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-104' is displayed

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP101-101' is displayed in activity stream
    And Activity Comment 'commenttestCAP101-101' is displayed in activity stream
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-101' is not displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-102' is not displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-103' is displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-104' is displayed

    When In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', I click on the reply 'replyTestCAP101-103' three dots icon
    And In reply 'replyTestCAP101-103', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Activity Comment 'commenttestCAP101-101' is displayed in activity stream
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-101' is not displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-103' is not displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-101', the reply 'replyTestCAP101-102' is displayed
    And In activity 'activityTestCAP101-101' with comment 'commenttestCAP101-100', the reply 'replyTestCAP101-104' is displayed

  Scenario: CAP102 - [ActivityStream_US38][06] Cancel Delete a reply from the activity stream
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP102-102'
    And I publish the activity
    Then the activity 'activityTestCAP102-102' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    When I add in activity 'activityTestCAP102-102' a comment 'commenttestCAP102-102'
    And I open in activity 'activityTestCAP102-102' the Comments drawer
    Then Activity Comment 'commenttestCAP102-102' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP102-102' is displayed in activity stream

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    And Activity Comment 'commenttestCAP102-102' is displayed in activity stream
    When I add a reply 'replyTestCAP102-101' to comment 'commenttestCAP102-102' in activity 'activityTestCAP102-102'
    Then In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is displayed

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    And Activity Comment 'commenttestCAP102-102' is displayed in activity stream
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is displayed
    When I add a reply 'replyTestCAP102-102' to comment 'commenttestCAP102-102' in activity 'activityTestCAP102-102'
    Then In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is displayed

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    And Activity Comment 'commenttestCAP102-102' is displayed in activity stream
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is displayed
    When I add a reply 'replyTestCAP102-103' to comment 'commenttestCAP102-102' in activity 'activityTestCAP102-102'
    Then In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-103' is displayed

    When I change user admin

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    And Activity Comment 'commenttestCAP102-102' is displayed in activity stream
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is not displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-103' is displayed
    When I add a reply 'replyTestCAP102-104' to comment 'commenttestCAP102-102' in activity 'activityTestCAP102-102'
    Then In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-104' is displayed

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    And Activity Comment 'commenttestCAP102-102' is displayed in activity stream
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is not displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is not displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-103' is displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-104' is displayed

    When In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', I click on the reply 'replyTestCAP102-103' three dots icon
    And In reply 'replyTestCAP102-103', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And Activity Comment 'commenttestCAP102-102' is displayed in activity stream
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is not displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is not displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-103' is displayed
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-104' is displayed

  Scenario: CAP103 - [ActivityStream_US39][01] Delete a simple comment from the comment drawer
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP103-103'
    And I publish the activity
    Then the activity 'activityTestCAP103-103' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream
    When I add in activity 'activityTestCAP103-103' a comment 'commenttestCAP103-103'
    And I open in activity 'activityTestCAP103-103' the Comments drawer
    Then Activity Comment 'commenttestCAP103-103' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP103-103' is displayed in activity stream

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream
    And Activity Comment 'commenttestCAP103-103' is displayed in activity stream

    When I open in activity 'activityTestCAP103-103' the Comments drawer
    Then '1 comment', only 'commenttestCAP103-103' is displayed in Comments drawer
    And I close the opened drawer

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream
    And Activity Comment 'commenttestCAP103-103' is displayed in activity stream

    When I open in activity 'activityTestCAP103-103' the Comments drawer
    Then '1 comment', only 'commenttestCAP103-103' is displayed in Comments drawer
    When In comments drawer, I click on the comment 'commenttestCAP103-103' three dots icon
    And In comment 'commenttestCAP103-103', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttestCAP103-103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the opened drawer
    Then Comment 'commenttestCAP103-103' is not displayed in activity 'activityTestCAP103-103'

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream

    When I open in activity 'activityTestCAP103-103' the Comments drawer
    Then Comment 'commenttestCAP103-103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the opened drawer
    Then Comment 'commenttestCAP103-103' is not displayed in activity 'activityTestCAP103-103'

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream

    When I open in activity 'activityTestCAP103-103' the Comments drawer
    Then Comment 'commenttestCAP103-103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the opened drawer
    Then Comment 'commenttestCAP104-CAP103-103' is not displayed in activity 'activityTestCAP103-103'

  Scenario: CAP104 - [ActivityStream_US39][02] Cancel Delete a simple comment from the comment drawer
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing, no wait

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP104-104'
    And I publish the activity
    Then the activity 'activityTestCAP104-104' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream
    When I add in activity 'activityTestCAP104-104' a comment 'commenttestCAP104-104'
    And I open in activity 'activityTestCAP104-104' the Comments drawer
    Then Activity Comment 'commenttestCAP104-104' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP104-104' is displayed in activity stream

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream
    And Activity Comment 'commenttestCAP104-104' is displayed in activity stream

    When I open in activity 'activityTestCAP104-104' the Comments drawer
    Then '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer
    And I close the opened drawer

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream
    And Activity Comment 'commenttestCAP104-104' is displayed in activity stream

    When I open in activity 'activityTestCAP104-104' the Comments drawer
    Then '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer
    When In comments drawer, I click on the comment 'commenttestCAP104-104' three dots icon
    And In comment 'commenttestCAP104-104', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP104-104' is displayed in activity stream

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream

    When I open in activity 'activityTestCAP104-104' the Comments drawer
    Then '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP104-104' is displayed in activity stream

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream

    When I open in activity 'activityTestCAP104-104' the Comments drawer
    Then '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP104-104' is displayed in activity stream

  Scenario: CAP105 - [ActivityStream_US39][03] Delete comment with replies from the comment drawer
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP105-105'
    And I publish the activity
    Then the activity 'activityTestCAP105-105' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream
    When I add in activity 'activityTestCAP105-105' a comment 'commenttestCAP105-105'
    And I open in activity 'activityTestCAP105-105' the Comments drawer
    Then Activity Comment 'commenttestCAP105-105' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP105-105' is displayed in activity stream
    When I add a reply 'replyTest101' to comment 'commenttestCAP105-105' in activity 'activityTestCAP105-105'
    Then In activity 'activityTestCAP105-105' with comment 'commenttestCAP105-105', the reply 'replyTest101' is displayed

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream
    And Activity Comment 'commenttestCAP105-105' is displayed in activity stream
    And In activity 'activityTestCAP105-105' with comment 'commenttestCAP105-105', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttestCAP105-105' in activity 'activityTestCAP105-105'
    Then In activity 'activityTestCAP105-105' with comment 'commenttestCAP105-105', the reply 'replyTest102' is displayed

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream
    And Activity Comment 'commenttestCAP105-105' is displayed in activity stream

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    Then '1 comment', only 'commenttestCAP105-105' is displayed in Comments drawer
    And I close the opened drawer
    And I add a reply 'replyTest103' to comment 'commenttestCAP105-105' in activity 'activityTestCAP105-105'

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream
    And Activity Comment 'commenttestCAP105-105' is displayed in activity stream

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    Then '1 comment', only 'commenttestCAP105-105' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP105-105'
    Then In comment 'commenttestCAP105-105', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttestCAP105-105', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttestCAP105-105', the reply 'replyTest103' is displayed in the drawer
    When In comments drawer, I click on the comment 'commenttestCAP105-105' three dots icon
    And In comment 'commenttestCAP105-105', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttestCAP105-105' is not displayed in the drawer
    And No comments displayed in the drawer
    And The reply 'replyTest101' is not displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    And The reply 'replyTest103' is not displayed in the drawer
    When I close the opened drawer
    Then Comment 'commenttestCAP105-105' is not displayed in activity 'activityTestCAP105-105'

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    Then Comment 'commenttestCAP105-105' is not displayed in the drawer
    And No comments displayed in the drawer
    And The reply 'replyTest101' is not displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    And The reply 'replyTest103' is not displayed in the drawer
    When I close the opened drawer
    Then Comment 'commenttestCAP105-105' is not displayed in activity 'activityTestCAP105-105'

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    Then Comment 'commenttestCAP105-105' is not displayed in the drawer
    And No comments displayed in the drawer
    And The reply 'replyTest101' is not displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    And The reply 'replyTest103' is not displayed in the drawer
    When I close the opened drawer
    Then Comment 'commenttestCAP105-105' is not displayed in activity 'activityTestCAP105-105'

  Scenario: CAP106 - [ActivityStream_US39][04] Cancel Delete comment with replies from the comments drawer
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP106-106'
    And I publish the activity
    Then the activity 'activityTestCAP106-106' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream
    When I add in activity 'activityTestCAP106-106' a comment 'commenttestCAP106-106'
    And I open in activity 'activityTestCAP106-106' the Comments drawer
    Then Activity Comment 'commenttestCAP106-106' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP106-106' is displayed in activity stream
    When I add a reply 'replyTestCAP106-101' to comment 'commenttestCAP106-106' in activity 'activityTestCAP106-106'
    Then In activity 'activityTestCAP106-106' with comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream
    And Activity Comment 'commenttestCAP106-106' is displayed in activity stream
    And In activity 'activityTestCAP106-106' with comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed
    When I add a reply 'replyTestCAP106-102' to comment 'commenttestCAP106-106' in activity 'activityTestCAP106-106'
    Then In activity 'activityTestCAP106-106' with comment 'commenttestCAP106-106', the reply 'replyTestCAP106-102' is displayed

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream
    And Activity Comment 'commenttestCAP106-106' is displayed in activity stream

    When I open in activity 'activityTestCAP106-106' the Comments drawer
    Then '1 comment', only 'commenttestCAP106-106' is displayed in Comments drawer
    And I close the opened drawer
    And I add a reply 'replyTestCAP106-103' to comment 'commenttestCAP106-106' in activity 'activityTestCAP106-106'

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream
    And Activity Comment 'commenttestCAP106-106' is displayed in activity stream

    When I open in activity 'activityTestCAP106-106' the Comments drawer
    Then '1 comment', only 'commenttestCAP106-106' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP106-106'
    Then In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-102' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-103' is displayed in the drawer
    When In comments drawer, I click on the comment 'commenttestCAP106-106' three dots icon
    And In comment 'commenttestCAP106-106', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttestCAP106-106' is displayed in Comments drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-102' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-103' is displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP106-106' is displayed in activity stream

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream

    When I open in activity 'activityTestCAP106-106' the Comments drawer
    Then '1 comment', only 'commenttestCAP106-106' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP106-106'
    Then In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-102' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-103' is displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP106-106' is displayed in activity stream

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream

    When I open in activity 'activityTestCAP106-106' the Comments drawer
    Then '1 comment', only 'commenttestCAP106-106' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP106-106'
    Then In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-102' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-103' is displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP106-106' is displayed in activity stream

  Scenario: CAP107 - [ActivityStream_US39][05] Delete a reply from comments drawer
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP107-107'
    And I publish the activity
    Then the activity 'activityTestCAP107-107' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream
    When I add in activity 'activityTestCAP107-107' a comment 'commenttestCAP107-107'
    And I open in activity 'activityTestCAP107-107' the Comments drawer
    Then Activity Comment 'commenttestCAP107-107' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP107-107' is displayed in activity stream
    When I add a reply 'replyTestCAP107-101' to comment 'commenttestCAP107-107' in activity 'activityTestCAP107-107'
    Then In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream
    And Activity Comment 'commenttestCAP107-107' is displayed in activity stream
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed
    When I add a reply 'replyTestCAP107-102' to comment 'commenttestCAP107-107' in activity 'activityTestCAP107-107'
    Then In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is displayed

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream
    And Activity Comment 'commenttestCAP107-107' is displayed in activity stream

    When I open in activity 'activityTestCAP107-107' the Comments drawer
    Then '1 comment', only 'commenttestCAP107-107' is displayed in Comments drawer
    And I close the opened drawer
    And I add a reply 'replyTestCAP107-103' to comment 'commenttestCAP107-107' in activity 'activityTestCAP107-107'

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream
    And Activity Comment 'commenttestCAP107-107' is displayed in activity stream

    When I open in activity 'activityTestCAP107-107' the Comments drawer
    Then '1 comment', only 'commenttestCAP107-107' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP107-107'
    Then In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed in the drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is displayed in the drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed in the drawer
    When In comments drawer, I click on the reply 'replyTestCAP107-102' three dots icon
    And In reply 'replyTestCAP107-102', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttestCAP107-107' is displayed in Comments drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed in the drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed in the drawer
    And The reply 'replyTestCAP107-102' is not displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP107-107' is displayed in activity stream
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is not displayed

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream

    When I open in activity 'activityTestCAP107-107' the Comments drawer
    Then '1 comment', only 'commenttestCAP107-107' is displayed in Comments drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed in the drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed in the drawer
    And The reply 'replyTestCAP107-102' is not displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP107-107' is displayed in activity stream
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is not displayed

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream

    When I open in activity 'activityTestCAP107-107' the Comments drawer
    Then '1 comment', only 'commenttestCAP107-107' is displayed in Comments drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed in the drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed in the drawer
    And The reply 'replyTestCAP107-102' is not displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP107-107' is displayed in activity stream
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is not displayed

  Scenario: CAP108 - [ActivityStream_US39][06] Cancel Delete a reply from the comments drawer
    Given I connect as admin if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I go to the random space if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP108-108'
    And I publish the activity
    Then the activity 'activityTestCAP108-108' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream
    When I add in activity 'activityTestCAP108-108' a comment 'commenttestCAP108-108'
    And I open in activity 'activityTestCAP108-108' the Comments drawer
    Then Activity Comment 'commenttestCAP108-108' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP108-108' is displayed in activity stream
    When I add a reply 'replyTestCAP108-101' to comment 'commenttestCAP108-108' in activity 'activityTestCAP108-108'
    Then In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream
    And Activity Comment 'commenttestCAP108-108' is displayed in activity stream
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed
    When I add a reply 'replyTestCAP108-102' to comment 'commenttestCAP108-108' in activity 'activityTestCAP108-108'
    Then In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream
    And Activity Comment 'commenttestCAP108-108' is displayed in activity stream

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    Then '1 comment', only 'commenttestCAP108-108' is displayed in Comments drawer
    And I close the opened drawer
    And I add a reply 'replyTestCAP108-103' to comment 'commenttestCAP108-108' in activity 'activityTestCAP108-108'

    When I connect with the first created user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream
    And Activity Comment 'commenttestCAP108-108' is displayed in activity stream

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    Then '1 comment', only 'commenttestCAP108-108' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP108-108'
    Then In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed in the drawer
    When In comments drawer, I click on the reply 'replyTestCAP108-102' three dots icon
    And In reply 'replyTestCAP108-102', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttestCAP108-108' is displayed in Comments drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP108-108' is displayed in activity stream
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is not displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    Then '1 comment', only 'commenttestCAP108-108' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP108-108'
    Then In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP108-108' is displayed in activity stream
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is not displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed

    When I connect with the third created user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    Then '1 comment', only 'commenttestCAP108-108' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP108-108'
    Then In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed in the drawer
    When I close the opened drawer
    Then Activity Comment 'commenttestCAP108-108' is displayed in activity stream
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is not displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed

  Scenario: CAP109 - [ActivityStream_US40][01] Like my comment/reply from activity stream
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytest009'
    And I publish the activity
    Then the activity 'activitytest009' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activitytest009' is displayed in activity stream

    When I add in activity 'activitytest009' a comment 'commenttest109'
    And I open in activity 'activitytest009' the Comments drawer
    Then Activity Comment 'commenttest109' is displayed in Comments drawer
    And Activity Comment 'commenttest109' is displayed in activity stream

    When I add a reply 'replyTest101' to comment 'commenttest109' in activity 'activitytest009'
    Then In activity 'activitytest009' with comment 'commenttest109', the reply 'replyTest101' is displayed
    And In comment 'commenttest109', Like label should be black
    And On comment 'commenttest109', '(0)' like is displayed

    When In comment 'commenttest109', I hover on Like icon
    Then Tooltip Like on 'commenttest109' is displayed in activity stream

    When I like the activity comment 'commenttest109'
    Then In comment 'commenttest109', Like label should be blue
    And On comment 'commenttest109', '(1)' like is displayed

    When In comment 'commenttest109', I hover on Like icon
    Then Tooltip Remove Like on 'commenttest109' is displayed in activity stream

  Scenario: CAP110 - [ActivityStream_US40][02] DisLike my comment/reply from activity stream
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    And I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP110-010'
    And I publish the activity
    Then the activity 'activityTestCAP110-010' is displayed in activity stream

    And I connect with the second created user
    And I go to the random space
    Then the activity 'activityTestCAP110-010' is displayed in activity stream

    When I add in activity 'activityTestCAP110-010' a comment 'commenttestCAP110-110'
    And I open in activity 'activityTestCAP110-010' the Comments drawer
    Then Activity Comment 'commenttestCAP110-110' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP110-110' is displayed in activity stream

    When I add a reply 'replyTestCAP110-101' to comment 'commenttestCAP110-110' in activity 'activityTestCAP110-010'
    Then In activity 'activityTestCAP110-010' with comment 'commenttestCAP110-110', the reply 'replyTestCAP110-101' is displayed

    When I like the activity comment 'commenttestCAP110-110'
    Then In comment 'commenttestCAP110-110', Like label should be blue
    And On comment 'commenttestCAP110-110', '(1)' like is displayed

    When I unlike the activity comment 'commenttestCAP110-110'
    And In comment 'commenttestCAP110-110', Like label should be black
    And On comment 'commenttestCAP110-110', '(0)' like is displayed

  Scenario: CAP111 - [ActivityStream_US40][03] Like comment/reply of other user from activity stream
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
    And I enter an activity 'activitytest011'
    And I publish the activity
    Then the activity 'activitytest011' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activitytest011' is displayed in activity stream

    When I add in activity 'activitytest011' a comment 'commenttest111'
    And I open in activity 'activitytest011' the Comments drawer
    Then Activity Comment 'commenttest111' is displayed in Comments drawer
    And Activity Comment 'commenttest111' is displayed in activity stream

    When I add a reply 'replyTest101' to comment 'commenttest111' in activity 'activitytest011'
    Then In activity 'activitytest011' with comment 'commenttest111', the reply 'replyTest101' is displayed

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activitytest011' is displayed in activity stream

    And In comment 'commenttest111', Like label should be black
    And On comment 'commenttest111', '(0)' like is displayed

    When In comment 'commenttest111', I hover on Like icon
    Then Tooltip Like on 'commenttest111' is displayed in activity stream

    When I like the activity comment 'commenttest111'
    Then In comment 'commenttest111', Like label should be blue
    And On comment 'commenttest111', '(1)' like is displayed

    When In comment 'commenttest111', I hover on Like icon
    Then Tooltip Remove Like on 'commenttest111' is displayed in activity stream

  Scenario: CAP112 [ActivityStream_US40][04] DisLike comment/reply of other user from activity stream
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP1112-012'
    And I publish the activity
    Then the activity 'activityTestCAP1112-012' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activityTestCAP1112-012' is displayed in activity stream

    When I add in activity 'activityTestCAP1112-012' a comment 'commenttestCAP112-112'
    And I open in activity 'activityTestCAP1112-012' the Comments drawer
    Then Activity Comment 'commenttestCAP112-112' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP112-112' is displayed in activity stream

    When I add a reply 'replyTestCAP112-101' to comment 'commenttestCAP112-112' in activity 'activityTestCAP1112-012'
    Then In activity 'activityTestCAP1112-012' with comment 'commenttestCAP112-112', the reply 'replyTestCAP112-101' is displayed

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activityTestCAP1112-012' is displayed in activity stream

    When I like the activity comment 'commenttestCAP112-112'
    Then In comment 'commenttestCAP112-112', Like label should be blue
    And On comment 'commenttestCAP112-112', '(1)' like is displayed

    When I unlike the activity comment 'commenttestCAP112-112'
    And In comment 'commenttestCAP112-112', Like label should be black
    And On comment 'commenttestCAP112-112', '(0)' like is displayed

  Scenario: CAP115 - [ActivityStream_US41][01] Like my comment/reply from the comment drawer
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytest015'
    And I publish the activity
    Then the activity 'activitytest015' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activitytest015' is displayed in activity stream

    When I add in activity 'activitytest015' a comment 'commenttest115'
    And I open in activity 'activitytest015' the Comments drawer
    Then Activity Comment 'commenttest115' is displayed in Comments drawer
    And Activity Comment 'commenttest115' is displayed in activity stream

    When I add a reply 'replyTest115' to comment 'commenttest115' in activity 'activitytest015'
    Then In activity 'activitytest015' with comment 'commenttest115', the reply 'replyTest115' is displayed

    When I open in activity 'activitytest015' the Comments drawer
    Then In comments drawer, Like label in comment 'commenttest115' should be black
    And In comments drawer, on comment 'commenttest115', '(0)' like is displayed

    When In comments drawer, in comment 'commenttest115', I hover on Like icon
    And Tooltip Like on 'commenttest115' is displayed in comments drawer

    When In comments drawer, I like the activity comment 'commenttest115'
    Then In comments drawer, Like label in comment 'commenttest115' should be blue
    And In comments drawer, on comment 'commenttest115', '(1)' like is displayed

    When In comments drawer, in comment 'commenttest115', I hover on Like icon
    And Tooltip Remove Like on 'commenttest115' is displayed in comments drawer
    And I close the opened drawer

  Scenario: CAP116 - [ActivityStream_US41][02] DisLike my comment/reply from the comments drawer
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    And I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP1116-016'
    And I publish the activity
    Then the activity 'activityTestCAP1116-016' is displayed in activity stream

    And I connect with the second created user
    And I go to the random space
    Then the activity 'activityTestCAP1116-016' is displayed in activity stream

    When I add in activity 'activityTestCAP1116-016' a comment 'commenttestCAP116-116'
    And I open in activity 'activityTestCAP1116-016' the Comments drawer
    Then Activity Comment 'commenttestCAP116-116' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP116-116' is displayed in activity stream

    When I add a reply 'replyTestCAP116-116' to comment 'commenttestCAP116-116' in activity 'activityTestCAP1116-016'
    Then In activity 'activityTestCAP1116-016' with comment 'commenttestCAP116-116', the reply 'replyTestCAP116-116' is displayed

    When I open in activity 'activityTestCAP1116-016' the Comments drawer
    And In comments drawer, I like the activity comment 'commenttestCAP116-116'
    Then In comments drawer, Like label in comment 'commenttestCAP116-116' should be blue
    And In comments drawer, on comment 'commenttestCAP116-116', '(1)' like is displayed

    When In comments drawer, I unlike the activity comment 'commenttestCAP116-116'
    Then In comments drawer, Like label in comment 'commenttestCAP116-116' should be black
    And In comments drawer, on comment 'commenttestCAP116-116', '(0)' like is displayed
    And I close the opened drawer

  Scenario: CAP121 - [ActivityStream_IMPV14][01] Display maximum only the last 2 comments/replies below each activity
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTest121'
    And I publish the activity
    Then the activity 'activityTest121' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTest121' is displayed in activity stream
    When I add in activity 'activityTest121' a comment 'commenttest101'
    And I open in activity 'activityTest121' the Comments drawer
    Then First comment 'commenttest101' is displayed in comments drawer

    When I add in activity 'activityTest121' a comment 'commenttest102'
    And I open in activity 'activityTest121' the Comments drawer
    Then Second comment 'commenttest102' is displayed in comments drawer

    When I add in activity 'activityTest121' a comment 'commenttest103'
    And I open in activity 'activityTest121' the Comments drawer
    Then Third comment 'commenttest103' is displayed in comments drawer

    When I add in activity 'activityTest121' a comment 'commenttest104'
    And I open in activity 'activityTest121' the Comments drawer
    Then Fourth comment 'commenttest104' is displayed in comments drawer
    And First comment 'commenttest103' is displayed in activity stream
    And Second comment 'commenttest104' is displayed in activity stream
    And Comment 'commenttest101' is not displayed in activity 'activityTest121'
    And Comment 'commenttest102' is not displayed in activity 'activityTest121'

  Scenario: CAP122 - [ActivityStream_IMPV14][02] Display maximum only the last 2 comments/replies below each activity
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP122-122-02'
    And I publish the activity
    Then the activity 'activityTestCAP122-122-02' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP122-122-02' is displayed in activity stream

    When I add in activity 'activityTestCAP122-122-02' a comment 'commenttestCAP122-101-02'
    And I add in activity 'activityTestCAP122-122-02' a comment 'commenttestCAP122-102-02'
    And I add in activity 'activityTestCAP122-122-02' a comment 'commenttestCAP122-103-02'
    And I add in activity 'activityTestCAP122-122-02' a comment 'commenttestCAP122-104-02'

    Then First comment 'commenttestCAP122-103-02' is displayed in activity stream
    And Second comment 'commenttestCAP122-104-02' is displayed in activity stream
    And Comment 'commenttestCAP122-101-02' is not displayed in activity 'activityTestCAP122-122-02'
    And Comment 'commenttestCAP122-102-02' is not displayed in activity 'activityTestCAP122-122-02'

    When I add a reply 'replyTestCAP122-101-02' to comment 'commenttestCAP122-103-02' in activity 'activityTestCAP122-122-02'
    And I add a reply 'replyTestCAP122-102-02' to comment 'commenttestCAP122-103-02' in activity 'activityTestCAP122-122-02'

    And I add a reply 'replyTestCAP122-103-02' to comment 'commenttestCAP122-104-02' in activity 'activityTestCAP122-122-02'
    And I add a reply 'replyTestCAP122-104-02' to comment 'commenttestCAP122-104-02' in activity 'activityTestCAP122-122-02'

    Then Comment 'commenttestCAP122-101-02' is not displayed in activity 'activityTestCAP122-122-02'
    And Comment 'commenttestCAP122-102-02' is not displayed in activity 'activityTestCAP122-122-02'
    And In activity 'activityTestCAP122-122-02' with comment 'commenttestCAP122-103-02', the reply 'replyTestCAP122-101-02' is displayed
    And In activity 'activityTestCAP122-122-02' with comment 'commenttestCAP122-103-02', the reply 'replyTestCAP122-102-02' is displayed
    And In activity 'activityTestCAP122-122-02' with comment 'commenttestCAP122-104-02', the reply 'replyTestCAP122-103-02' is displayed
    And In activity 'activityTestCAP122-122-02' with comment 'commenttestCAP122-104-02', the reply 'replyTestCAP122-104-02' is displayed

  Scenario: CAP123 - [ActivityStream_IMPV14][03] Display maximum only the last 2 comments/replies below each activity
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP123-123'
    And I publish the activity
    Then the activity 'activityTestCAP123-123' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP123-123' is displayed in activity stream

    When I add in activity 'activityTestCAP123-123' a comment 'commenttestCAP123-101'
    And I add in activity 'activityTestCAP123-123' a comment 'commenttestCAP123-102'
    And I add in activity 'activityTestCAP123-123' a comment 'commenttestCAP123-103'
    And I add in activity 'activityTestCAP123-123' a comment 'commenttestCAP123-104'

    Then First comment 'commenttestCAP123-103' is displayed in activity stream
    And Second comment 'commenttestCAP123-104' is displayed in activity stream
    And Comment 'commenttestCAP123-101' is not displayed in activity 'activityTestCAP123-123'
    And Comment 'commenttestCAP123-102' is not displayed in activity 'activityTestCAP123-123'

    When I add a reply 'replyTestCAP123-101' to comment 'commenttestCAP123-103' in activity 'activityTestCAP123-123'
    And I add a reply 'replyTestCAP123-102' to comment 'commenttestCAP123-103' in activity 'activityTestCAP123-123'
    And I add a reply 'replyTestCAP123-103' to comment 'commenttestCAP123-103' in activity 'activityTestCAP123-123'

    And I add a reply 'replyTestCAP123-104' to comment 'commenttestCAP123-104' in activity 'activityTestCAP123-123'
    And I add a reply 'replyTestCAP123-105' to comment 'commenttestCAP123-104' in activity 'activityTestCAP123-123'
    And I add a reply 'replyTestCAP123-106' to comment 'commenttestCAP123-104' in activity 'activityTestCAP123-123'

    Then Comment 'commenttestCAP123-101' is not displayed in activity 'activityTestCAP123-123'
    And Comment 'commenttestCAP123-102' is not displayed in activity 'activityTestCAP123-123'
    And In activity 'activityTestCAP123-123' with comment 'commenttestCAP123-103', the reply 'replyTestCAP123-102' is displayed
    And In activity 'activityTestCAP123-123' with comment 'commenttestCAP123-103', the reply 'replyTestCAP123-103' is displayed
    And In activity 'activityTestCAP123-123' with comment 'commenttestCAP123-103', the reply 'replyTestCAP123-101' is not displayed

    And In activity 'activityTestCAP123-123' with comment 'commenttestCAP123-104', the reply 'replyTestCAP123-105' is displayed
    And In activity 'activityTestCAP123-123' with comment 'commenttestCAP123-104', the reply 'replyTestCAP123-106' is displayed
    And In activity 'activityTestCAP123-123' with comment 'commenttestCAP123-104', the reply 'replyTestCAP123-104' is not displayed

    When I click on View All replies related to the comment 'commenttestCAP123-103' in activity stream
    Then In comment 'commenttestCAP123-103', the reply 'replyTestCAP123-101' is displayed in the drawer
    And In comment 'commenttestCAP123-103', the reply 'replyTestCAP123-102' is displayed in the drawer
    And In comment 'commenttestCAP123-103', the reply 'replyTestCAP123-103' is displayed in the drawer

    And In comment 'commenttestCAP123-104', the reply 'replyTestCAP123-105' is displayed in the drawer
    And In comment 'commenttestCAP123-104', the reply 'replyTestCAP123-106' is displayed in the drawer
    And In comment 'commenttestCAP123-104', the reply 'replyTestCAP123-104' is not displayed in the drawer

    When I close the opened drawer
    And I click on View All replies related to the comment 'commenttestCAP123-104' in activity stream
    Then In comment 'commenttestCAP123-104', the reply 'replyTestCAP123-105' is displayed in the drawer
    And In comment 'commenttestCAP123-104', the reply 'replyTestCAP123-106' is displayed in the drawer
    And In comment 'commenttestCAP123-104', the reply 'replyTestCAP123-104' is displayed in the drawer

    And In comment 'commenttestCAP123-103', the reply 'replyTestCAP123-101' is not displayed in the drawer
    And In comment 'commenttestCAP123-103', the reply 'replyTestCAP123-102' is displayed in the drawer
    And In comment 'commenttestCAP123-103', the reply 'replyTestCAP123-103' is displayed in the drawer
    And I close the opened drawer

  Scenario: CAP157 - [ActivityStream_IMPV15][01] Internal Link opening behaviors inside comments
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP157-157'
    And I publish the activity
    Then the activity 'activityTestCAP157-157' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP157-157' is displayed in activity stream

    When I add in activity 'activityTestCAP157-157' an internal link 'portal/meeds/spaces' as a comment
    And I open in activity 'activityTestCAP157-157' the Comments drawer
    Then Internal link 'portal/meeds/spaces' is displayed in Comments drawer as a comment
    And Internal link 'portal/meeds/spaces' is displayed in activity stream as a comment

    When I click on the internal link 'portal/meeds/spaces'
    Then Space Top Bar Elements are displayed

    When I go to the random space
    And I open the internal link 'portal/meeds/spaces' in new tab
    Then The internal link 'portal/meeds/spaces' is opened in new tab

  Scenario: CAP158 - [ActivityStream_IMPV15][02] External Link opening behaviors inside comments
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP158-158'
    And I publish the activity
    Then the activity 'activityTestCAP158-158' is displayed in activity stream

    When I connect with the second created user

    And I go to the random space
    Then the activity 'activityTestCAP158-158' is displayed in activity stream

    When I add in activity 'activityTestCAP158-158' a comment 'https://www.meeds.io/'
    And I open in activity 'activityTestCAP158-158' the Comments drawer
    Then Activity Comment 'https://www.meeds.io/' is displayed in Comments drawer
    And Activity Comment 'https://www.meeds.io/' is displayed in activity stream

    When I click on comment 'https://www.meeds.io/'
    Then Link 'https://www.meeds.io/' is opened in new tab

    When I open link 'https://www.meeds.io/' in new tab
    Then Link 'https://www.meeds.io/' is opened in new tab

  @ignored
  Scenario: CAP12 - [ActivityStream_US10][01] Activity with text or link options (3 dots) (Author)
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user

    And I go to the random space
    Then The created space name is displayed

    When I connect with the second created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'https://www.meeds.io/'
    And I insert text 'activity-cap12'
    And I publish the activity
    And I click on three dots button related to activity 'activity-cap12'
    Then Edit button related to activity 'activity-cap12' is displayed
    And Delete button related to activity 'activity-cap12' is displayed
    And Copy link button related to activity 'activity-cap12' is displayed

    When I go to Stream page
    Then The activity 'activity-cap12' posted by the second user in the created space is displayed with its timestamp in streams page

    When I click on three dots button related to activity 'activity-cap12'
    Then Edit button related to activity 'activity-cap12' is displayed
    And Delete button related to activity 'activity-cap12' is displayed
    And Copy link button related to activity 'activity-cap12' is displayed

  @ignored
  Scenario: CAP13 - [ActivityStream_US10][02] Activity with text or link options (3 dots) (Space manager)
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    When I connect with the first created user

    And I go to the random space
    Then The created space name is displayed

    When I connect with the second created user

    And I go to the random space
    Then The created space name is displayed

    When I connect with the third created user

    And I go to the random space
    Then The created space name is displayed

    When I connect with the first created user

    And I go to the random space
    And I go to 'Members' tab
    And I promote 'third' random user as a space manager

    And I connect with the second created user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'https://www.meeds.io/'
    And I insert text 'activity-CAP13'
    And I publish the activity
    Then the activity 'activity-CAP13' is displayed in activity stream

    When I click on three dots button related to activity 'activity-CAP13'
    Then Delete button related to activity 'activity-CAP13' is displayed
    And Copy link button related to activity 'activity-CAP13' is displayed

    And I connect with the third created user

    And I go to the random space
    Then the activity 'activity-CAP13' is displayed in activity stream

    When I click on three dots button related to activity 'activity-CAP13'
    Then Delete button related to activity 'activity-CAP13' is displayed
    And Copy link button related to activity 'activity-CAP13' is displayed

    When I go to Stream page
    Then The activity 'activity-CAP13' posted by the second user in the created space is displayed with its timestamp in streams page

    When I click on three dots button related to activity 'activity-CAP13'
    Then Delete button related to activity 'activity-CAP13' is displayed
    And Copy link button related to activity 'activity-CAP13' is displayed

  Scenario: CAP97 - [ActivityStream_US38][01] Delete a simple comment from the activity stream
    Given I am authenticated as admin

    When I create the firstadm random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing, no wait
    And I create the fourth random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    And I select the group 'Administration'
    And I add the role '*' to the firstadm created user

    When I connect with the second created user
    And I go to the random space
    And I connect with the third created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTest97'
    And I publish the activity
    Then the activity 'activityTest97' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activityTest97' is displayed in activity stream
    When I add in activity 'activityTest97' a comment 'commenttest97'
    And I open in activity 'activityTest97' the Comments drawer
    Then Activity Comment 'commenttest97' is displayed in Comments drawer
    And Activity Comment 'commenttest97' is displayed in activity stream

    When I connect with the firstadm created user
    And I go to the random space
    Then the activity 'activityTest97' is displayed in activity stream
    And Activity Comment 'commenttest97' is displayed in activity stream

    When In activity 'activityTest97', I click on the comment 'commenttest97' three dots icon
    And In comment 'commenttest97', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttest97' is not displayed in activity 'activityTest97'

  @ignored
  Scenario: CAP99 - [ActivityStream_US38][03] Delete comment with replies from the activity stream
    Given I am authenticated as admin

    When I create the firstadm random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing, no wait
    And I create the fourth random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    And I select the group 'Administration'
    And I add the role '*' to the firstadm created user

    When I connect with the second created user
    And I go to the random space
    And I connect with the third created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTest99'
    And I publish the activity
    Then the activity 'activityTest99' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activityTest99' is displayed in activity stream
    When I add in activity 'activityTest99' a comment 'commenttest99'
    And I open in activity 'activityTest99' the Comments drawer
    Then Activity Comment 'commenttest99' is displayed in Comments drawer
    And Activity Comment 'commenttest99' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activityTest99' is displayed in activity stream
    And Activity Comment 'commenttest99' is displayed in activity stream
    When I add a reply 'replyTest100' to comment 'commenttest99' in activity 'activityTest99'
    Then In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest100' is displayed
    When I add a reply 'replyTest101' to comment 'commenttest99' in activity 'activityTest99'
    Then In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttest99' in activity 'activityTest99'
    Then In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest102' is displayed

    When I connect with the firstadm created user
    And I go to the random space
    Then the activity 'activityTest99' is displayed in activity stream
    And Activity Comment 'commenttest99' is displayed in activity stream
    And In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest100' is not displayed
    And In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest101' is displayed
    And In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest102' is displayed

    When In activity 'activityTest99', I click on the comment 'commenttest99' three dots icon
    And In comment 'commenttest99', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttest99' is not displayed in activity 'activityTest99'
    And In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest100' is not displayed
    And In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest101' is not displayed
    And In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest102' is not displayed

  Scenario: Cap155 - ActivityStream_US58: Mention a user in the comments
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |
      | fifth  |
      | sixth  |

    When I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing, no wait
    And I create the fourth random user if not existing, no wait
    And I create the fifth random user if not existing, no wait
    And I create the sixth random user if not existing

    And I connect with the first created user
    And I create a random space
    And I click on post in space
    And I enter an activity 'activityTest155'
    And I publish the activity
    Then the activity 'activityTest155' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activityTest155' is displayed in activity stream

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activityTest155' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activityTest155' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activityTest155' is displayed in activity stream

    When I click on comment button related to activity 'activityTest155'
    And I enter a comment 'comTest155' with mentioning the first user
    Then First User is mentioned in the comment

    When I enter a comment 'comTest155' with mentioning the third user
    Then Third User is mentioned in the comment

    When I enter a comment 'comTest155' with mentioning the fourth user
    Then Fourth User is mentioned in the comment

    When I enter a comment 'comTest155' with attempting to mention the fifth user
    Then Fifth User is not mentioned in the comment

    When I enter a comment 'comTest155' with attempting to mention the sixth user
    Then Sixth User is not mentioned in the comment
    And I close the opened drawer

  Scenario: Cap146 - [ActivityStream_US40][01] Notifications for comments to my activity
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    When I create the first random user if not existing, no wait
    And I create the second random user if not existing

    And I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTest146'
    And I publish the activity
    Then the activity 'activityTest146' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activityTest146' is displayed in activity stream
    When I add in activity 'activityTest146' a comment 'commenttest146'
    And I open in activity 'activityTest146' the Comments drawer
    Then Activity Comment 'commenttest146' is displayed in Comments drawer
    And Activity Comment 'commenttest146' is displayed in activity stream

    When I connect with the first created user
    And I open Notifications
    Then The notification that shows that activity 'activityTest146' posted by first user is commented by second user with comment 'activityTest146', is displayed

    When I click on the notification that shows that activity 'activityTest146' posted by first user is commented by second user with comment 'activityTest146'
    Then Activity Comment 'commenttest146' is displayed in Comments drawer
    And Activity Comment 'commenttest146' is displayed in activity stream
    And I go to the home page

  Scenario: Cap147 - [ActivityStream_US40][02] Notifications for comment to my comment
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    When I create the first random user if not existing, no wait
    And I create the second random user if not existing

    And I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTest147'
    And I publish the activity
    Then the activity 'activityTest147' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activityTest147' is displayed in activity stream
    When I add in activity 'activityTest147' a comment 'commenttest147'
    And I open in activity 'activityTest147' the Comments drawer
    Then Activity Comment 'commenttest147' is displayed in Comments drawer
    And Activity Comment 'commenttest147' is displayed in activity stream

    When I connect with the first created user
    And I go to the random space
    Then the activity 'activityTest147' is displayed in activity stream
    And Activity Comment 'commenttest147' is displayed in activity stream
    When I add a reply 'replyTest147' to comment 'commenttest147' in activity 'activityTest147'
    Then In activity 'activityTest147' with comment 'commenttest147', the reply 'replyTest147' is displayed

    When I connect with the second created user
    And I open Notifications
    Then The notification that shows that comment 'commenttest147' posted by second user is replied by first user with 'replyTest147', is displayed

    When I click on the notification that shows that comment 'commenttest147' posted by second user is replied by first user with 'replyTest147'
    Then Activity Comment 'commenttest147' is displayed in Comments drawer
    And Activity Comment 'commenttest147' is displayed in activity stream
    And In activity 'activityTest147' with comment 'commenttest147', the reply 'replyTest147' is displayed
    And I go to the home page

  Scenario: CAP20 - [ActivityStream_US10][09] Activity with text or link options (3 dots) (Author delete the post)
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user
    And I go to the random space

    When I connect with the second created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityus1009cap20'
    And I publish the activity
    Then the activity 'activityus1009cap20' is displayed in activity stream

    When I click on three dots button related to activity 'activityus1009cap20'
    And I click on Delete button related to activity 'activityus1009cap20'
    Then The confirmation popup is displayed

    When I click on Yes button
    Then the confirmation popup is not displayed
    And the activity 'activityus1009cap20' is not displayed in activity stream

    When I go to Stream page
    Then the activity 'activityus1009cap20' is not displayed in stream page

  Scenario: CAP21 - [ActivityStream_US10][10] Activity with text or link options (3 dots) ( Author cancel delete post)
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I connect with the first created user
    And I go to the random space

    When I connect with the second created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityus1010cap21'
    And I publish the activity
    Then the activity 'activityus1010cap21' is displayed in activity stream

    When I click on three dots button related to activity 'activityus1010cap21'
    And I click on Delete button related to activity 'activityus1010cap21'
    Then The confirmation popup is displayed

    When I click on Cancel button
    Then the confirmation popup is not displayed
    And the activity 'activityus1010cap21' is displayed in activity stream

    When I go to Stream page
    Then the activity 'activityus1010cap21' is displayed in stream page

  @ignored
  Scenario: CAP87 - [ActivityStream_US04][01] Edit comment in Activity stream
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing, no wait
    And I create the fourth random user if not existing

    When I connect with the first created user
    And I go to the random space

    When I connect with the second created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitycap87'
    And I publish the activity
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest101'
    And I open in activity 'activitycap87' the Comments drawer
    Then Activity Comment 'commenttest101' is displayed in Comments drawer
    And Activity Comment 'commenttest101' is displayed in activity stream

    When I connect with the first created user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream
    When I add in activity 'activitycap87' a comment 'commenttest102'
    And I add a reply 'replyTest102' to comment 'commenttest102' in activity 'activitycap87'
    Then In activity 'activitycap87' with comment 'commenttest102', the reply 'replyTest102' is displayed

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream
    When I add in activity 'activitycap87' a comment 'commenttest103'
    And I add a reply 'replyTest103' to comment 'commenttest103' in activity 'activitycap87'
    Then In activity 'activitycap87' with comment 'commenttest103', the reply 'replyTest103' is displayed

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream

    When In activity 'activitycap87' I enter the link 'https://www.meeds.io/' as comment
    And I insert text ' commenttest104' as comment
    And I publish the comment
    And I open in activity 'activitycap87' the Comments drawer
    Then Comment 'https://www.meeds.io/ commenttest104' is displayed in comments drawer at the sixth position

    When I add a reply 'replyTest104' to comment 'commenttest104' in activity 'activitycap87'
    Then In activity 'activitycap87' with comment 'commenttest104', the reply 'replyTest104' is displayed

    When In activity 'activitycap87', I click on the comment 'commenttest104' three dots icon
    And In comment 'commenttest104', I click on edit button
    And I insert text 'commenttestupdated104 ' as comment
    And I click on update comment
    And I open in activity 'activitycap87' the Comments drawer
    Then Comment 'commenttestupdated104 https://www.meeds.io/ commenttest104' is displayed in comments drawer at the sixth position

  Scenario: CAP88 - [ActivityStream_US04.1][01] Edit comment from the comment drawer
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing, no wait
    And I create the fourth random user if not existing

    When I connect with the first created user
    And I go to the random space

    When I connect with the second created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitycap88'
    And I publish the activity
    Then the activity 'activitycap88' is displayed in activity stream
    When I add in activity 'activitycap88' a comment 'commenttestCAP88-101'
    And I open in activity 'activitycap88' the Comments drawer
    Then Activity Comment 'commenttestCAP88-101' is displayed in Comments drawer
    And Activity Comment 'commenttestCAP88-101' is displayed in activity stream

    When I connect with the first created user
    And I go to the random space
    Then the activity 'activitycap88' is displayed in activity stream
    When I add in activity 'activitycap88' a comment 'commenttestCAP88-102'
    And I add a reply 'replyTestCAP88-102' to comment 'commenttestCAP88-102' in activity 'activitycap88'
    Then In activity 'activitycap88' with comment 'commenttestCAP88-102', the reply 'replyTestCAP88-102' is displayed

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activitycap88' is displayed in activity stream
    When I add in activity 'activitycap88' a comment 'commenttestCAP88-103'
    And I add a reply 'replyTestCAP88-103' to comment 'commenttestCAP88-103' in activity 'activitycap88'
    Then In activity 'activitycap88' with comment 'commenttestCAP88-103', the reply 'replyTestCAP88-103' is displayed

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activitycap88' is displayed in activity stream
    When I add in activity 'activitycap88' a comment 'commenttestCAP88-104'
    And I add a reply 'replyTestCAP88-104' to comment 'commenttestCAP88-104' in activity 'activitycap88'
    And In activity 'activitycap88' with comment 'commenttestCAP88-104', the reply 'replyTestCAP88-104' is displayed
    And I click on View all X comments
    And I click on the comment 'commenttestCAP88-104' three dots icon from comments drawer
    And In comment 'commenttestCAP88-104', I click on edit button from comments drawer
    And I insert text 'updated' as comment
    Then I click on update comment
    And I open in activity 'activitycap88' the Comments drawer
    Then Comment 'updatedcommenttest104' is displayed in comments drawer at the sixth position

  @ignored
  Scenario: [ActivityStream_US32][02] space note page
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing
    When I connect with the first created user

    And I go to the random space
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab

    When I add note with title 'Long Name Long Name Long Name Long Name Long Name Long Name Long Name' and content 'Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content'
    And I save and post Note
    Then Note title 'Long Name Long Name Long Name Long Name Long Name Long Name Long Name' and content 'Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content' are displayed successfully

    When I go to Stream page
    Then the activity 'Long Name Long Name Long Name Long Name Long Name Long Name Long Name' is displayed in activity stream

  Scenario: CAP128 - [ActivityStream_US47][01] Send a kudos from a comment
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing

    And I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosCAP128'
    And I publish the activity
    Then the activity 'activitytestkudosCAP128' is displayed in activity stream

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activitytestkudosCAP128' is displayed in activity stream

    When I add in activity 'activitytestkudosCAP128' a comment 'activitytestkudoscommentCAP128'
    And I open in activity 'activitytestkudosCAP128' the Comments drawer
    Then Activity Comment 'activitytestkudoscommentCAP128' is displayed in Comments drawer
    And Activity Comment 'activitytestkudoscommentCAP128' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activitytestkudosCAP128' is displayed in activity stream
    When In comment 'activitytestkudoscommentCAP128', Kudos label should be black
    Then I click on the kudos button from the comment
    And I send to the comment activity a kudos message 'Test Auto comment Kudos CAP128'
    Then In comment 'activitytestkudoscommentCAP128', Kudos label should be blue
    And I click on the kudos button number
    Then '1' kudos are displayed on the reaction drawer

  Scenario: CAP129 - [ActivityStream_US47][03] Send a kudos from the comments drawer
    Given I connect as admin if random users doesn't exists
      | first  |
      | sixth  |
      | third  |

    And I create the first random user if not existing, no wait
    And I create the sixth random user if not existing, no wait
    And I create the third random user if not existing

    And I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosCAP129'
    And I publish the activity
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream
    When I add in activity 'activitytestkudosCAP129' a comment 'activitytestkudoscommentCAP129'
    And Activity Comment 'activitytestkudoscommentCAP129' is displayed in activity stream
    And I open in activity 'activitytestkudosCAP129' the Comments drawer
    Then Activity Comment 'activitytestkudoscommentCAP129' is displayed in Comments drawer

    When I connect with the sixth created user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream
    And I open in activity 'activitytestkudosCAP129' the Comments drawer
    And In comment 'activitytestkudoscommentCAP129', Kudos label should be black
    When I click on the kudos button from the comments drawer
    And I send to the comment activity a kudos message 'Test Auto comment Kudos'
    Then In comment 'activitytestkudoscommentCAP129', Kudos label should be blue
    And I click on the kudos button number from the comments drawer
    Then '1' kudos are displayed on the reaction drawer

  @test
  Scenario: CAP220 - [ActivityStream_IMPV07][01] Pagination in comments drawer
    Given I connect as admin if random users doesn't exists
      | first  |

    And I create the first random user if not existing, no wait

    When I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitycap220'
    And I publish the activity
    Then the activity 'activitycap220' is displayed in activity stream

    When I add in activity 'activitycap220' a comment 'commenttestCAP220-101'
    And I add in activity 'activitycap220' a comment 'commenttestCAP220-102'
    And I add in comment 'commenttestCAP220-102' of activity 'activitycap220' the following replies
      | replyTest102  |
      | replyTest103  |
      | replyTest104  |
    And I add in activity 'activitycap220' the following comments
      | commenttestCAP220-103  |
      | commenttestCAP220-104  |
      | commenttestCAP220-105  |
      | commenttestCAP220-106  |
      | commenttestCAP220-107  |
      | commenttestCAP220-108  |
      | commenttestCAP220-109  |
      | commenttestCAP220-1010  |
      | commenttestCAP220-1011  |
      | commenttestCAP220-1012  |
      | commenttestCAP220-1013  |
      | commenttestCAP220-1014  |
      | commenttestCAP220-1015  |
      | commenttestCAP220-1016  |
      | commenttestCAP220-1017  |
      | commenttestCAP220-1018  |
      | commenttestCAP220-1019  |
      | commenttestCAP220-1020  |
      | commenttestCAP220-1021  |
      | commenttestCAP220-1022  |
      | commenttestCAP220-1023  |
      | commenttestCAP220-1024  |
    And I click on comment button related to activity 'activitycap220'
    Then Activity Comment 'commenttestCAP220-1021' is displayed in Comments drawer

    When I click on comment button related to activity 'activitycap220'
    And I go to the comments drawer first page
    And Comment 'commenttestCAP220-1011' is not displayed in the drawer
    Then Check Ten comment is displayed in comments drawer

    When I click on comment button related to activity 'activitycap220'
    And I go to the comments drawer second page
    And Comment 'commenttestCAP220-1010' is not displayed in the drawer
    And Comment 'commenttestCAP220-1021' is not displayed in the drawer
    Then Check Ten comment is displayed in comments drawer

    When I click on comment button related to activity 'activitycap220'
    And Comment 'commenttestCAP220-1020' is not displayed in the drawer
    Then Check Four comment is displayed in comments drawer

  Scenario: [STREAM-12] Activity Likers in drawer
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I go to the random space
    And I click on post in space
    And I enter an activity 'stream activité'
    And I publish the activity
    And I connect with the first created user
    And I go to the random space
    And I like the activity 'stream activité'
    And I change user admin
    And I go to the random space
    And I like the activity 'stream activité'
    When I click on likers number of the activity 'stream activité'
    Then The first user is displayed in activity likers drawer
    And I open user profile of first user from activity likers drawer
    And The 'Profile' page is opened

  Scenario: CAP129 - [ActivityStream_US47][02] Send a kudos from a reply
    Given I connect as admin if random users doesn't exists
      | first  |
      | sixth  |
      | third  |
      | fourth  |

    And I create the first random user if not existing, no wait
    And I create the sixth random user if not existing, no wait
    And I create the third random user if not existing, no wait
    And I create the fourth random user if not existing

    And I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosCAP129'
    And I publish the activity
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream

    When I add in activity 'activitytestkudosCAP129' a comment 'activitytestkudosCAP129comment'
    And I open in activity 'activitytestkudosCAP129' the Comments drawer
    Then Activity Comment 'activitytestkudosCAP129comment' is displayed in Comments drawer
    And Activity Comment 'activitytestkudosCAP129comment' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream
    When I add a reply 'activitytestkudosCAP129commentreply' to comment 'activitytestkudosCAP129comment' in activity 'activitytestkudosCAP129'
    Then In activity 'activitytestkudosCAP129' with comment 'activitytestkudosCAP129comment', the reply 'activitytestkudosCAP129commentreply' is displayed

    When I connect with the sixth created user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream
    And In reply 'activitytestkudosCAP129commentreply', Kudos label should be black
    When In reply 'activitytestkudosCAP129commentreply', I click on kudos button
    And I send to the comment activity a kudos message 'Test Auto reply Kudos'
    Then In reply 'activitytestkudosCAP129commentreply', Kudos label should be blue
    When I click on the kudos button number
    Then '1' kudos are displayed on the reaction drawer

  Scenario: CAP89 - [ActivityStream_US04][03] Edit reply in Activity stream
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing, no wait
    And I create the fourth random user if not existing

    When I connect with the first created user
    And I go to the random space

    When I connect with the second created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitycap87'
    And I publish the activity
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest101'
    And I click on comment button related to activity 'activitycap87'
    Then Activity Comment 'commenttest101' is displayed in Comments drawer
    And Activity Comment 'commenttest101' is displayed in activity stream

    When I connect with the first created user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest102'
    And I click on comment button related to activity 'activitycap87'
    Then Second comment 'commenttest102' is displayed in comments drawer

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest103'
    And I click on comment button related to activity 'activitycap87'
    Then Third comment 'commenttest103' is displayed in comments drawer

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest104'
    And I click on comment button related to activity 'activitycap87'
    Then Fourth comment 'commenttest104' is displayed in comments drawer

    When In activity 'activitycap87', I click on the comment 'commenttest104' three dots icon
    And In comment 'commenttest104', I click on edit button
    And I update comment with a new one 'commenttestupdated104'
    And I click on update comment
    And I open in activity 'activitycap87' the Comments drawer
    Then Fourth comment 'commenttestupdated104' is displayed in comments drawer

  Scenario: [ActivityStream_US52][03] Edit a kudos from a comment
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | fourth  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the fourth random user if not existing

    And I connect with the fourth created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosUS52'
    And I publish the activity
    Then the activity 'activitytestkudosUS52' is displayed in activity stream

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activitytestkudosUS52' is displayed in activity stream

    When I add in activity 'activitytestkudosUS52' a comment 'activitytestkudoscommentUS52'
    And I open in activity 'activitytestkudosUS52' the Comments drawer
    Then Activity Comment 'activitytestkudoscommentUS52' is displayed in Comments drawer
    And Activity Comment 'activitytestkudoscommentUS52' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activitytestkudosUS52' is displayed in activity stream
    When In comment 'activitytestkudoscommentUS52', Kudos label should be black
    And I click on the kudos button from the comment
    And I send to the comment activity a kudos message 'Test Auto comment Kudos US52'
    And I click to edit the kudos text
    And I set the new kudos comment text 'updated kudos message' and I click on update button
    Then the updated Kudos activity 'updated kudos message' is displayed in stream page

  Scenario: [ActivityStream_US52][05] Edit a kudos from a reply
    Given I connect as admin if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |

    And I create the first random user if not existing, no wait
    And I create the second random user if not existing, no wait
    And I create the third random user if not existing, no wait
    And I create the fourth random user if not existing

    And I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosUS52_05'
    And I publish the activity
    Then the activity 'activitytestkudosUS52_05' is displayed in activity stream

    When I connect with the third created user
    And I go to the random space
    Then the activity 'activitytestkudosUS52_05' is displayed in activity stream

    When I add in activity 'activitytestkudosUS52_05' a comment 'activitytestkudoscommentUS52_05'
    And I open in activity 'activitytestkudosUS52_05' the Comments drawer
    Then Activity Comment 'activitytestkudoscommentUS52_05' is displayed in Comments drawer
    And Activity Comment 'activitytestkudoscommentUS52_05' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the random space
    Then the activity 'activitytestkudosUS52_05' is displayed in activity stream
    When I add a reply 'activitytestkudoscommentreplyUS52_05' to comment 'activitytestkudoscommentUS52_05' in activity 'activitytestkudosUS52_05'
    Then In activity 'activitytestkudoUS52_05s' with comment 'activitytestkudoscommentUS52_05', the reply 'activitytestkudoscommentreplyUS52_05' is displayed

    When I connect with the second created user
    And I go to the random space
    Then the activity 'activitytestkudosUS52_05' is displayed in activity stream
    And In reply 'activitytestkudoscommentreplyUS52_05', Kudos label should be black

    When In reply 'activitytestkudoscommentreplyUS52_05', I click on kudos button
    And I send to the comment activity a kudos message 'Test Auto reply Kudos US52_05'
    Then In reply 'activitytestkudoscommentreplyUS52_05', Kudos label should be blue

    When I click to edit the kudos from a reply comment
    And I set the new kudos comment text 'updated kudos message' and I click on update button
    Then the updated Kudos activity 'updated kudos message' is displayed in stream page

  Scenario: CAP132 - [ActivityStream_US52][01] Edit a kudos comment from an activity
    Given I connect as admin if random users doesn't exists
      | first  |
      | fifth  |

    And I create the first random user if not existing, no wait
    And I create the fifth random user if not existing

    And I connect with the first created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosUS52_01'
    And I publish the activity
    Then the activity 'activitytestkudosUS52_01' is displayed in activity stream

    When I connect with the fifth created user
    And I go to the random space
    Then the activity 'activitytestkudosUS52_01' is displayed in activity stream
    Then I click on the kudos button on first displayed Activity
    And I send to the comment activity a kudos message 'Test Auto reply Kudos US52_01'
    Then In activity 'activitytestkudosUS52_01', I click on the comment 'Test Auto reply Kudos US52_01' three dots icon
    When In comment 'Test Auto reply Kudos US52_01', I click on edit button
    And I set the new kudos comment text 'updated Test Auto reply Kudos US52_01' and I click on update button
    Then the updated Kudos activity 'updated Test Auto reply Kudos US52_01' is displayed in stream page

  @smoke
  @ignored
  Scenario: Mention from user activity stream should push the activity in "My Activities" of the mentioned user
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I go to the random space
    When I click on Post button
    And I enter the activity 'activityWithMentionedUser', and I mention the user 'aymen khal'
    And I publish the activity
    Then In the created space, in post 'activityWithMentionedUser', the mentioned user 'aymen khal' is displayed

    When I am authenticated as admin
    And I open Notifications
    Then Notification when mentioning a user in activity, 'Houssem Riahi has mentioned you' 'activityWithMentionedUser aymen khal' is displayed
    And Notification : 'Houssem Riahi has posted an activity' in the created space 'activityWithMentionedUser aymen khal', is displayed

    When I click on the activity notification which is mentioning the user, 'Houssem Riahi has mentioned you' 'activityWithMentionedUser aymen khal'
    Then In the created space, in post 'activityWithMentionedUser', the mentioned user 'aymen khal' is displayed

  @smoke
  @ignored
  Scenario: Mention a member in comment from a space should push activity in "My Activities" of the member
    Given I connect as admin if random users doesn't exists
      | first  |

    And I create the first random user if not existing
    When I go to the random space
    And I connect with the first created user
    And I go to the random space
    When I click on Post button
    And I enter the activity 'actTest', and I mention the user 'aymen khal'
    And I publish the activity
    Then In the created space, in post 'actTest', the mentioned user 'aymen khal' is displayed

    When I am authenticated as admin
    And I open Notifications
    Then Notification when mentioning a user in activity, 'Houssem Riahi has mentioned you' 'actTest aymen khal' is displayed
    And Notification : 'Houssem Riahi has posted an activity' in the created space 'actTest aymen khal', is displayed
    And I close Notifications drawer

    When I go to First Space
    Then In the created space, in post 'actTest', the mentioned user 'aymen khal' is displayed

    When I add in activity 'actTest' a comment 'comTest' with mentioning the user 'Houssem Riahi'
    And I open in activity 'actTest' the Comments drawer
    Then Activity Comment 'comTest Houssem Riahi' is displayed in Comments drawer
    And Activity Comment 'comTest Houssem Riahi' is displayed in activity stream

    When I change user
      | login    | houssem.riahi |
      | password | houssem2020   |
    And I open Notifications
    Then Notification when mentioning a user in activity, 'aymen khal has mentioned you' 'actTest aymen khal' is displayed
    And Notification : 'aymen khal has commented on a post' 'actTest aymen khal' 'comTest Houssem Riahi', is displayed

    When I click on the activity comment notification which is mentioning the user, 'aymen khal has commented on a post' 'actTest aymen khal' 'comTest Houssem Riahi'
    Then Activity Comment 'comTest Houssem Riahi' is displayed in Comments drawer
    And Activity Comment 'comTest Houssem Riahi' is displayed in activity stream

    When I go to the home page
    And I open Notifications
    And I click on the activity notification which is mentioning the user, 'aymen khal has mentioned you' 'actTest aymen khal'
    Then Activity Comment 'comTest Houssem Riahi' is displayed in Comments drawer
    And Activity Comment 'comTest Houssem Riahi' is displayed in activity stream
    And I go to the home page

  Scenario: PinActivity_US01: Space host or redactor can pin an activity (from Space Stream -  Space host Case)
    Given I am authenticated as admin
    And I create a random space
    And I go to the random space
    And I click on post in space
    And I enter an activity 'PinTest'
    When I publish the activity
    Then the activity 'PinTest' is displayed in activity stream
    Given I click on three dots button related to activity 'PinTest'
    Then Pin button related to activity 'PinTest' is displayed
    Given I click on Pin button related to activity 'PinTest'
    Then The message 'This activity has been pinned to the space stream.' should be displayed
    And The activity 'PinTest' is pinned in space stream
    Given I go to Stream page
    Then the activity 'PinTest' is displayed in stream page
    Given I click on three dots button related to activity 'PinTest'
    Then Unpin button related to activity 'PinTest' is displayed

  Scenario: Pin Activity US01: Space host or redactor can pin an activity (from General Stream -  Space redactor Case)
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
    And I go to 'Members' tab
    And I enter the contact name of the second user
    Then The search result is well matched with the username entered of the second user
    And I click on three dots menu
    And I set as a redactor
    Given I go to 'Stream' tab
    And I click on post in space
    And I enter an activity 'PinTest'
    When I publish the activity
    Then the activity 'PinTest' is displayed in activity stream
    When I connect with the second created user
    And I go to Stream page
    And I click on three dots button related to activity 'PinTest'
    Then Pin button related to activity 'PinTest' is displayed
    Given I click on Pin button related to activity 'PinTest'
    Then The message 'This activity has been pinned to the space stream.' should be displayed
    Given I go to the random space
    Then The activity 'PinTest' is pinned in space stream
    Given I click on three dots button related to activity 'PinTest'
    Then Unpin button related to activity 'PinTest' is displayed

  Scenario: Pin Activity US03: Unpin an activity
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
    And I go to 'Members' tab
    And I enter the contact name of the second user
    Then The search result is well matched with the username entered of the second user
    And I click on three dots menu
    And I set as a redactor
    Given I go to 'Stream' tab
    And I click on post in space
    And I enter an activity 'PinTest'
    When I publish the activity
    Then the activity 'PinTest' is displayed in activity stream
    When I connect with the first created user
    And I go to Stream page
    And I click on three dots button related to activity 'PinTest'
    Then Pin button related to activity 'PinTest' is displayed
    Given I click on Pin button related to activity 'PinTest'
    Then The message 'This activity has been pinned to the space stream.' should be displayed
    Given I go to the random space
    Then The activity 'PinTest' is pinned in space stream
    Given I click on three dots button related to activity 'PinTest'
    Then Unpin button related to activity 'PinTest' is displayed
    Given I click to the Unpin button related to activity 'PinTest'
    Then The message 'This activity has been unpinned.' should be displayed
    And The activity 'PinTest' should be not pinned in space stream

  @test
  Scenario: Pin Activity US04: Pinned activities filter
    Given I am authenticated as admin
    And I create a random space
    And I go to the random space
    And I click on post in space
    And I enter an activity 'PinTest'
    When I publish the activity
    Then the activity 'PinTest' is displayed in activity stream
    When I post '3' activities with prefix 'act_Pin_US04_'
    And I refresh the page
    Then the activity 'act_Pin_US04_0' is displayed in activity stream
    And the activity 'act_Pin_US04_1' is displayed in activity stream
    And the activity 'act_Pin_US04_2' is displayed in activity stream
    Given I click on three dots button related to activity 'PinTest'
    Then Pin button related to activity 'PinTest' is displayed
    Given I click on Pin button related to activity 'PinTest'
    Then The message 'This activity has been pinned to the space stream.' should be displayed
    And The activity 'PinTest' is pinned in space stream
    Given I go to Stream page
    Then the activity 'act_Pin_US04_0' is displayed in stream page
    And the activity 'act_Pin_US04_1' is displayed in stream page
    And the activity 'act_Pin_US04_2' is displayed in stream page
    And the activity 'PinTest' is displayed in stream page
    When I select 'Pinned activities' from the filter proposed
    And the activity 'PinTest' is displayed in stream page
    Then the activity 'act_Pin_US04_0' is not displayed in stream page
    And the activity 'act_Pin_US04_1' is not displayed in stream page
    And the activity 'act_Pin_US04_2' is not displayed in stream page
    When I select 'All' from the filter proposed