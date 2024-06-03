@activitystream

Feature: Activity Stream

  Scenario: CAP04 - [ActivityStream_US05] Display 10 activities in Activity Stream
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    And I login as 'first' random user

    And I go to the random space
    When I post '15' activities with prefix 'act_CAP04_'
    And I refresh the page
    Then the activity 'act_CAP04_15' is displayed in activity stream
    And the activity 'act_CAP04_14' is displayed in activity stream
    And the activity 'act_CAP04_6' is displayed in activity stream
    And the activity 'act_CAP04_5' is not displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'act_CAP04_15' is displayed in activity stream
    And the activity 'act_CAP04_14' is displayed in activity stream
    And the activity 'act_CAP04_6' is displayed in activity stream
    And the activity 'act_CAP04_5' is not displayed in activity stream

    When I login as 'first' random user
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

    When I login as 'second' random user
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
    Given I am authenticated as 'admin' if random space and random users doesn't exists
      | first  |
      | second |
      | third |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing

    And I create the random space if not existing

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP100-100'
    And I publish the activity
    Then the activity 'activityTestCAP100-100' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP100-100' is displayed in activity stream
    When I add in activity 'activityTestCAP100-100' a comment 'commenttestCAP100-100'
    Then The comment 'commenttestCAP100-100' is displayed in Comments drawer of activity 'activityTestCAP100-100'

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP100-100' is displayed in activity stream
    Then The comment 'commenttestCAP100-100' is displayed in Comments drawer of activity 'activityTestCAP100-100'
    And I open in activity 'activityTestCAP100-100' the Comments drawer
    When I add a reply 'replyTestCAP100-100' to comment 'commenttestCAP100-100' in activity 'activityTestCAP100-100'
    Then In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-100' is displayed

    When I login as 'admin' random user

    And I go to the random space
    Then the activity 'activityTestCAP100-100' is displayed in activity stream
    Then The comment 'commenttestCAP100-100' is displayed in Comments drawer of activity 'activityTestCAP100-100'
    And I open in activity 'activityTestCAP100-100' the Comments drawer
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-100' is displayed in Comment Drawer
    When I add a reply 'replyTestCAP100-101' to comment 'commenttestCAP100-100' in activity 'activityTestCAP100-100'
    And I open in activity 'activityTestCAP100-100' the Comments drawer
    Then In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-101' is displayed in Comment Drawer

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP100-100' is displayed in activity stream
    Then The comment 'commenttestCAP100-100' is displayed in Comments drawer of activity 'activityTestCAP100-100'
    And I open in activity 'activityTestCAP100-100' the Comments drawer
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-100' is displayed in Comment Drawer
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-101' is displayed in Comment Drawer
    And I open in activity 'activityTestCAP100-100' the Comments drawer
    And I click on the first comment 'commenttestCAP100-100' three dots icon from comments drawer
    And In comment 'commenttestCAP100-100', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-100' is displayed
    And In activity 'activityTestCAP100-100' with comment 'commenttestCAP100-100', the reply 'replyTestCAP100-101' is displayed

  Scenario: CAP102 - [ActivityStream_US38][06] Cancel Delete a reply from the activity stream
    Given I am authenticated as 'admin' if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing

    And I inject a random space

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP102-102'
    And I publish the activity
    Then the activity 'activityTestCAP102-102' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    When I add in activity 'activityTestCAP102-102' a comment 'commenttestCAP102-102'
    Then The comment 'commenttestCAP102-102' is displayed in Comments drawer of activity 'activityTestCAP102-102'

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream

    When I open in activity 'activityTestCAP102-102' the Comments drawer
    And I add a reply 'replyTestCAP102-101' to comment 'commenttestCAP102-102' in activity 'activityTestCAP102-102'
    Then In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is displayed

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    And I open in activity 'activityTestCAP102-102' the Comments drawer
    And In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is displayed in Comment Drawer
    When I add a reply 'replyTestCAP102-102' to comment 'commenttestCAP102-102' in activity 'activityTestCAP102-102'
    Then In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is displayed

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    And I open in activity 'activityTestCAP102-102' the Comments drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is displayed in the drawer
    When I add a reply 'replyTestCAP102-103' to comment 'commenttestCAP102-102' in activity 'activityTestCAP102-102'
    Then In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-103' is displayed

    When I login as 'admin' random user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream

    And I open in activity 'activityTestCAP102-102' the Comments drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is not displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-103' is displayed in the drawer

    When I add a reply 'replyTestCAP102-104' to comment 'commenttestCAP102-102' in activity 'activityTestCAP102-102'
    Then In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', the reply 'replyTestCAP102-104' is displayed

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP102-102' is displayed in activity stream
    And I open in activity 'activityTestCAP102-102' the Comments drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is not displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is not displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-103' is displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-104' is displayed in the drawer
    And I close the opened drawer

    When In activity 'activityTestCAP102-102' with comment 'commenttestCAP102-102', I click on the reply 'replyTestCAP102-103' three dots icon
    And In reply 'replyTestCAP102-103', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And I open in activity 'activityTestCAP102-102' the Comments drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-101' is not displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-102' is not displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-103' is displayed in the drawer
    And In comment 'commenttestCAP102-102', the reply 'replyTestCAP102-104' is displayed in the drawer

  Scenario: CAP103 - [ActivityStream_US39][01] Delete a simple comment from the comment drawer
    Given I am authenticated as 'admin' if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing

    And I create the random space if not existing

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP103-103'
    And I publish the activity
    Then the activity 'activityTestCAP103-103' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream
    When I add in activity 'activityTestCAP103-103' a comment 'commenttestCAP103-103'
    Then The comment 'commenttestCAP103-103' is displayed in Comments drawer of activity 'activityTestCAP103-103'

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream

    When I open in activity 'activityTestCAP103-103' the Comments drawer
    Then '1 comment', only 'commenttestCAP103-103' is displayed in Comments drawer
    And I close the opened drawer

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream

    When I open in activity 'activityTestCAP103-103' the Comments drawer
    Then '1 comment', only 'commenttestCAP103-103' is displayed in Comments drawer
    When In comments drawer, I click on the comment 'commenttestCAP103-103' three dots icon
    And In comment 'commenttestCAP103-103', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttestCAP103-103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the opened drawer
    Then The comment 'commenttestCAP103-103' is not displayed in Comments drawer of activity 'activityTestCAP103-103'

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream

    When I open in activity 'activityTestCAP103-103' the Comments drawer
    Then Comment 'commenttestCAP103-103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the opened drawer
    Then The comment 'commenttestCAP103-103' is not displayed in Comments drawer of activity 'activityTestCAP103-103'

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP103-103' is displayed in activity stream

    When I open in activity 'activityTestCAP103-103' the Comments drawer
    Then Comment 'commenttestCAP103-103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the opened drawer
    Then The comment 'commenttestCAP104-CAP103-103' is not displayed in Comments drawer of activity 'activityTestCAP103-103'

  Scenario: CAP104 - [ActivityStream_US39][02] Cancel Delete a simple comment from the comment drawer
    Given I am authenticated as 'admin' if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing, no wait

    And I create the random space if not existing

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP104-104'
    And I publish the activity
    Then the activity 'activityTestCAP104-104' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream
    When I add in activity 'activityTestCAP104-104' a comment 'commenttestCAP104-104'
    Then The comment 'commenttestCAP104-104' is displayed in Comments drawer of activity 'activityTestCAP104-104'

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream

    When I open in activity 'activityTestCAP104-104' the Comments drawer
    Then '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer
    And I close the opened drawer

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream

    When I open in activity 'activityTestCAP104-104' the Comments drawer
    Then '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer
    When In comments drawer, I click on the comment 'commenttestCAP104-104' three dots icon
    And In comment 'commenttestCAP104-104', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream

    When I open in activity 'activityTestCAP104-104' the Comments drawer
    Then '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP104-104' is displayed in activity stream

    When I open in activity 'activityTestCAP104-104' the Comments drawer
    Then '1 comment', only 'commenttestCAP104-104' is displayed in Comments drawer

  Scenario: CAP105 - [ActivityStream_US39][03] Delete comment with replies from the comment drawer
    Given I am authenticated as 'admin' if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing
    And I inject a random space

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP105-105'
    And I publish the activity
    Then the activity 'activityTestCAP105-105' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream
    When I add in activity 'activityTestCAP105-105' a comment 'commenttestCAP105-105'
    Then The comment 'commenttestCAP105-105' is displayed in Comments drawer of activity 'activityTestCAP105-105'

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    And I add a reply 'replyTest101' to comment 'commenttestCAP105-105' in activity 'activityTestCAP105-105'
    Then In activity 'activityTestCAP105-105' with comment 'commenttestCAP105-105', the reply 'replyTest101' is displayed

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream
    Then The comment 'commenttestCAP105-105' is displayed in Comments drawer of activity 'activityTestCAP105-105'

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    Then In activity 'activityTestCAP105-105' with comment 'commenttestCAP105-105', the reply 'replyTest101' is displayed in Comment Drawer
    When I add a reply 'replyTest102' to comment 'commenttestCAP105-105' in activity 'activityTestCAP105-105'
    Then In activity 'activityTestCAP105-105' with comment 'commenttestCAP105-105', the reply 'replyTest102' is displayed

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream
    Then The comment 'commenttestCAP105-105' is displayed in Comments drawer of activity 'activityTestCAP105-105'

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    Then '1 comment', only 'commenttestCAP105-105' is displayed in Comments drawer
    And I close the opened drawer

    And I open in activity 'activityTestCAP105-105' the Comments drawer
    And I add a reply 'replyTest103' to comment 'commenttestCAP105-105' in activity 'activityTestCAP105-105'

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream

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
    Then The comment 'commenttestCAP105-105' is not displayed in Comments drawer of activity 'activityTestCAP105-105'

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    Then Comment 'commenttestCAP105-105' is not displayed in the drawer
    And No comments displayed in the drawer
    And The reply 'replyTest101' is not displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    And The reply 'replyTest103' is not displayed in the drawer
    When I close the opened drawer
    Then The comment 'commenttestCAP105-105' is not displayed in Comments drawer of activity 'activityTestCAP105-105'

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP105-105' is displayed in activity stream

    When I open in activity 'activityTestCAP105-105' the Comments drawer
    Then Comment 'commenttestCAP105-105' is not displayed in the drawer
    And No comments displayed in the drawer
    And The reply 'replyTest101' is not displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    And The reply 'replyTest103' is not displayed in the drawer
    When I close the opened drawer
    Then The comment 'commenttestCAP105-105' is not displayed in Comments drawer of activity 'activityTestCAP105-105'

  Scenario: CAP106 - [ActivityStream_US39][04] Cancel Delete comment with replies from the comments drawer
    Given I am authenticated as 'admin' if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing

    And I inject a random space

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP106-106'
    And I publish the activity
    Then the activity 'activityTestCAP106-106' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream
    When I add in activity 'activityTestCAP106-106' a comment 'commenttestCAP106-106'
    Then The comment 'commenttestCAP106-106' is displayed in Comments drawer of activity 'activityTestCAP106-106'

    When I open in activity 'activityTestCAP106-106' the Comments drawer
    And I add a reply 'replyTestCAP106-101' to comment 'commenttestCAP106-106' in activity 'activityTestCAP106-106'
    Then In activity 'activityTestCAP106-106' with comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream
    Then The comment 'commenttestCAP106-106' is displayed in Comments drawer of activity 'activityTestCAP106-106'
    And I open in activity 'activityTestCAP106-106' the Comments drawer
    And In activity 'activityTestCAP106-106' with comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed in Comment Drawer
    When I add a reply 'replyTestCAP106-102' to comment 'commenttestCAP106-106' in activity 'activityTestCAP106-106'
    Then In activity 'activityTestCAP106-106' with comment 'commenttestCAP106-106', the reply 'replyTestCAP106-102' is displayed

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream
    Then The comment 'commenttestCAP106-106' is displayed in Comments drawer of activity 'activityTestCAP106-106'

    When I open in activity 'activityTestCAP106-106' the Comments drawer
    Then '1 comment', only 'commenttestCAP106-106' is displayed in Comments drawer
    And I close the opened drawer

    And I open in activity 'activityTestCAP106-106' the Comments drawer
    And I add a reply 'replyTestCAP106-103' to comment 'commenttestCAP106-106' in activity 'activityTestCAP106-106'

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream
    And The comment 'commenttestCAP106-106' is displayed in Comments drawer of activity 'activityTestCAP106-106'

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

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream

    When I open in activity 'activityTestCAP106-106' the Comments drawer
    Then '1 comment', only 'commenttestCAP106-106' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP106-106'
    Then In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-102' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-103' is displayed in the drawer

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP106-106' is displayed in activity stream

    When I open in activity 'activityTestCAP106-106' the Comments drawer
    Then '1 comment', only 'commenttestCAP106-106' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP106-106'
    Then In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-101' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-102' is displayed in the drawer
    And In comment 'commenttestCAP106-106', the reply 'replyTestCAP106-103' is displayed in the drawer

  Scenario: CAP107 - [ActivityStream_US39][05] Delete a reply from comments drawer
    Given I am authenticated as 'admin' if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing

    And I inject a random space

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP107-107'
    And I publish the activity
    Then the activity 'activityTestCAP107-107' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream
    When I add in activity 'activityTestCAP107-107' a comment 'commenttestCAP107-107'
    Then The comment 'commenttestCAP107-107' is displayed in Comments drawer of activity 'activityTestCAP107-107'
    And I open in activity 'activityTestCAP107-107' the Comments drawer
    When I add a reply 'replyTestCAP107-101' to comment 'commenttestCAP107-107' in activity 'activityTestCAP107-107'
    Then In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream
    And I open in activity 'activityTestCAP107-107' the Comments drawer
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed in Comment Drawer
    When I add a reply 'replyTestCAP107-102' to comment 'commenttestCAP107-107' in activity 'activityTestCAP107-107'
    Then In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is displayed

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream

    When I open in activity 'activityTestCAP107-107' the Comments drawer
    Then '1 comment', only 'commenttestCAP107-107' is displayed in Comments drawer
    And I close the opened drawer

    When I open in activity 'activityTestCAP107-107' the Comments drawer
    And I add a reply 'replyTestCAP107-103' to comment 'commenttestCAP107-107' in activity 'activityTestCAP107-107'

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream

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
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is not displayed

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream

    When I open in activity 'activityTestCAP107-107' the Comments drawer
    Then '1 comment', only 'commenttestCAP107-107' is displayed in Comments drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed in the drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed in the drawer
    And The reply 'replyTestCAP107-102' is not displayed in the drawer
    When I close the opened drawer
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is not displayed

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP107-107' is displayed in activity stream

    When I open in activity 'activityTestCAP107-107' the Comments drawer
    Then '1 comment', only 'commenttestCAP107-107' is displayed in Comments drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed in the drawer
    And In comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed in the drawer
    And The reply 'replyTestCAP107-102' is not displayed in the drawer
    When I close the opened drawer
    Then The comment 'commenttestCAP107-107' is displayed in Comments drawer of activity 'activityTestCAP107-107'

    When I close the opened drawer
    And I open in activity 'activityTestCAP107-107' the Comments drawer
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-101' is displayed in Comment Drawer
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-103' is displayed in Comment Drawer
    And In activity 'activityTestCAP107-107' with comment 'commenttestCAP107-107', the reply 'replyTestCAP107-102' is not displayed

  Scenario: CAP108 - [ActivityStream_US39][06] Cancel Delete a reply from the comments drawer
    Given I am authenticated as 'admin' if random space and random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing

    And I inject a random space

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP108-108'
    And I publish the activity
    Then the activity 'activityTestCAP108-108' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream
    When I add in activity 'activityTestCAP108-108' a comment 'commenttestCAP108-108'
    Then The comment 'commenttestCAP108-108' is displayed in Comments drawer of activity 'activityTestCAP108-108'

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    And I add a reply 'replyTestCAP108-101' to comment 'commenttestCAP108-108' in activity 'activityTestCAP108-108'
    Then In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream
    And The comment 'commenttestCAP108-108' is displayed in Comments drawer of activity 'activityTestCAP108-108'

    And I open in activity 'activityTestCAP108-108' the Comments drawer
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed in Comment Drawer
    When I add a reply 'replyTestCAP108-102' to comment 'commenttestCAP108-108' in activity 'activityTestCAP108-108'
    Then In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream
    Then The comment 'commenttestCAP108-108' is displayed in Comments drawer of activity 'activityTestCAP108-108'

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    Then '1 comment', only 'commenttestCAP108-108' is displayed in Comments drawer

    And I add a reply 'replyTestCAP108-103' to comment 'commenttestCAP108-108' in activity 'activityTestCAP108-108'

    When I login as 'first' random user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream

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

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is not displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    Then '1 comment', only 'commenttestCAP108-108' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP108-108'
    Then In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed in the drawer
    When I close the opened drawer


    When I open in activity 'activityTestCAP108-108' the Comments drawer
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is not displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed

    When I login as 'third' random user

    And I go to the random space
    Then the activity 'activityTestCAP108-108' is displayed in activity stream

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    Then '1 comment', only 'commenttestCAP108-108' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttestCAP108-108'
    Then In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed in the drawer
    And In comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed in the drawer
    When I close the opened drawer

    When I open in activity 'activityTestCAP108-108' the Comments drawer
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-101' is not displayed
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-102' is displayed in Comment Drawer
    And In activity 'activityTestCAP108-108' with comment 'commenttestCAP108-108', the reply 'replyTestCAP108-103' is displayed in Comment Drawer

  Scenario: CAP109 - [ActivityStream_US40][01] Like my comment/reply from activity stream
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing
    And I inject a random space

    When I login as 'first' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytest009'
    And I publish the activity
    Then the activity 'activitytest009' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activitytest009' is displayed in activity stream

    When I add in activity 'activitytest009' a comment 'commenttest109'
    Then The comment 'commenttest109' is displayed in Comments drawer of activity 'activitytest009'

    When I open in activity 'activitytest009' the Comments drawer
    And I add a reply 'replyTest101' to comment 'commenttest109' in activity 'activitytest009'
    Then In activity 'activitytest009' with comment 'commenttest109', the reply 'replyTest101' is displayed
    And In comment 'commenttest109', Like label should be black
    And On comment 'commenttest109', '(0)' like is displayed

    When In comments drawer, in comment 'commenttest109', I hover on Like icon
    Then Tooltip Like on 'commenttest109' is displayed in comments drawer

    When In comments drawer, I like the activity comment 'commenttest109'
    Then In comment 'commenttest109', Like label should be blue
    And On comment 'commenttest109', '(1)' like is displayed

    When In comments drawer, in comment 'commenttest109', I hover on Like icon
    Then Tooltip Remove Like on 'commenttest109' is displayed in comments drawer

  Scenario: Unlike my comment/reply from activity stream
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the random space

    And I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP110-010'
    And I publish the activity
    Then the activity 'activityTestCAP110-010' is displayed in activity stream

    And I login as 'second' random user
    And I go to the random space
    Then the activity 'activityTestCAP110-010' is displayed in activity stream

    When I add in activity 'activityTestCAP110-010' a comment 'commenttestCAP110-110'
    Then The comment 'commenttestCAP110-110' is displayed in Comments drawer of activity 'activityTestCAP110-010'
    And I open in activity 'activityTestCAP110-010' the Comments drawer

    When I add a reply 'replyTestCAP110-101' to comment 'commenttestCAP110-110' in activity 'activityTestCAP110-010'
    Then In activity 'activityTestCAP110-010' with comment 'commenttestCAP110-110', the reply 'replyTestCAP110-101' is displayed

    When In comments drawer, I like the activity comment 'commenttestCAP110-110'
    Then In comment 'commenttestCAP110-110', Like label should be blue
    And On comment 'commenttestCAP110-110', '(1)' like is displayed

    When In comments drawer, I unlike the activity comment 'commenttestCAP110-110'
    Then In comments drawer, in comment 'commenttestCAP110-110', Like label should be black
    And In comments drawer, on comment 'commenttestCAP110-110', '(0)' like is displayed

  Scenario: CAP111 - [ActivityStream_US40][03] Like comment/reply of other user from activity stream
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing
    And I inject a random space

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytest011'
    And I publish the activity
    Then the activity 'activitytest011' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activitytest011' is displayed in activity stream

    When I add in activity 'activitytest011' a comment 'commenttest111'
    And I open in activity 'activitytest011' the Comments drawer
    Then The comment 'commenttest111' is displayed in Comments drawer of activity 'activitytest011'

    When I open in activity 'activitytest011' the Comments drawer
    And I add a reply 'replyTest101' to comment 'commenttest111' in activity 'activitytest011'
    Then In activity 'activitytest011' with comment 'commenttest111', the reply 'replyTest101' is displayed

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activitytest011' is displayed in activity stream

    When I open in activity 'activitytest011' the Comments drawer
    Then In comments drawer, in comment 'commenttest111', Like label should be black
    And On comment 'commenttest111', '(0)' like is displayed

    When In comments drawer, in comment 'commenttest111', I hover on Like icon
    Then Tooltip Like on 'commenttest111' is displayed in comments drawer

    When In comments drawer, I like the activity comment 'commenttest111'
    Then In comment 'commenttest111', Like label should be blue
    And On comment 'commenttest111', '(1)' like is displayed

    When In comments drawer, in comment 'commenttest111', I hover on Like icon
    Then Tooltip Remove Like on 'commenttest111' is displayed in comments drawer

  Scenario: CAP112 [ActivityStream_US40][04] Unlike comment/reply of other user from activity stream
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing
    And I inject a random space

    And I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP1112-012'
    And I publish the activity
    Then the activity 'activityTestCAP1112-012' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activityTestCAP1112-012' is displayed in activity stream

    When I add in activity 'activityTestCAP1112-012' a comment 'commenttestCAP112-112'
    Then The comment 'commenttestCAP112-112' is displayed in Comments drawer of activity 'activityTestCAP1112-012'

    When I open in activity 'activityTestCAP1112-012' the Comments drawer
    And I add a reply 'replyTestCAP112-101' to comment 'commenttestCAP112-112' in activity 'activityTestCAP1112-012'
    Then In activity 'activityTestCAP1112-012' with comment 'commenttestCAP112-112', the reply 'replyTestCAP112-101' is displayed

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activityTestCAP1112-012' is displayed in activity stream

    When I open in activity 'activityTestCAP1112-012' the Comments drawer
    When In comments drawer, I like the activity comment 'commenttestCAP112-112'
    Then In comment 'commenttestCAP112-112', Like label should be blue
    And On comment 'commenttestCAP112-112', '(1)' like is displayed

    When In comments drawer, I unlike the activity comment 'commenttestCAP112-112'
    Then In comments drawer, in comment 'commenttestCAP112-112', Like label should be black
    And In comments drawer, on comment 'commenttestCAP112-112', '(0)' like is displayed

  Scenario: CAP115 - [ActivityStream_US41][01] Like my comment/reply from the comment drawer
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    And I inject a random space

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytest015'
    And I publish the activity
    Then the activity 'activitytest015' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activitytest015' is displayed in activity stream

    When I add in activity 'activitytest015' a comment 'commenttest115'
    Then The comment 'commenttest115' is displayed in Comments drawer of activity 'activitytest015'

    When I open in activity 'activitytest015' the Comments drawer
    And I add a reply 'replyTest115' to comment 'commenttest115' in activity 'activitytest015'
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

  Scenario: CAP116 - [ActivityStream_US41][02] Unlike my comment/reply from the comments drawer
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    And I inject a random space

    And I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP1116-016'
    And I publish the activity
    Then the activity 'activityTestCAP1116-016' is displayed in activity stream

    And I login as 'second' random user
    And I go to the random space
    Then the activity 'activityTestCAP1116-016' is displayed in activity stream

    When I add in activity 'activityTestCAP1116-016' a comment 'commenttestCAP116-116'
    Then The comment 'commenttestCAP116-116' is displayed in Comments drawer of activity 'activityTestCAP1116'

    When I open in activity 'activityTestCAP1116-016' the Comments drawer
    And I add a reply 'replyTestCAP116-116' to comment 'commenttestCAP116-116' in activity 'activityTestCAP1116-016'
    Then In activity 'activityTestCAP1116-016' with comment 'commenttestCAP116-116', the reply 'replyTestCAP116-116' is displayed

    When I open in activity 'activityTestCAP1116-016' the Comments drawer
    And In comments drawer, I like the activity comment 'commenttestCAP116-116'
    Then In comments drawer, Like label in comment 'commenttestCAP116-116' should be blue
    And In comments drawer, on comment 'commenttestCAP116-116', '(1)' like is displayed

    When In comments drawer, I unlike the activity comment 'commenttestCAP116-116'
    Then In comments drawer, Like label in comment 'commenttestCAP116-116' should be black
    And In comments drawer, on comment 'commenttestCAP116-116', '(0)' like is displayed
    And I close the opened drawer

  Scenario: CAP157 - [ActivityStream_IMPV15][01] Internal Link opening behaviors inside comments
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP157-157'
    And I publish the activity
    Then the activity 'activityTestCAP157-157' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP157-157' is displayed in activity stream

    When I add in activity 'activityTestCAP157-157' an internal link '/members' as a comment
    Then Internal link '/members' is displayed in Comments drawer of activity 'activityTestCAP157-157'

    When I open in activity 'activityTestCAP157-157' the Comments drawer
    And I click on the internal link '/members'
    Then Space Top Bar Elements are displayed

    When I go to the random space
    And I open in activity 'activityTestCAP157-157' the Comments drawer
    And I open the internal link '/members' in new tab
    Then The internal link '/members' is opened in new tab

  Scenario: CAP158 - [ActivityStream_IMPV15][02] External Link opening behaviors inside comments
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    And I inject a random space

    When I login as 'first' random user

    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTestCAP158-158'
    And I publish the activity
    Then the activity 'activityTestCAP158-158' is displayed in activity stream

    When I login as 'second' random user

    And I go to the random space
    Then the activity 'activityTestCAP158-158' is displayed in activity stream

    When I add in activity 'activityTestCAP158-158' a comment 'https://www.meeds.io/'
    Then The comment 'meeds.io' is displayed in Comments drawer of activity 'activityTestCAP158-158'

    When I click on comment 'meeds.io'
    Then Link 'https://www.meeds.io/' is opened in new tab

    And I open in activity 'activityTestCAP158-158' the Comments drawer
    When I open link 'meeds.io' in new tab
    Then Link 'https://www.meeds.io/' is opened in new tab

  Scenario: Delete a simple comment from the activity stream
    Given I am authenticated as 'admin' random user

    When I inject the random space
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing, no wait
    And I inject the fourth random user if not existing, no wait
    And I inject the firstadm random user if not existing
    And I login as 'firstadm' random user
    And I join the random space
    And I login as 'admin' random user

    And I go to groups Management page
    And I open the group 'Platform'
    And I select the group 'Administration'
    And I add the role '*' to the firstadm created user

    When I login as 'second' random user
    And I go to the random space
    And I login as 'third' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTest97'
    And I publish the activity
    Then the activity 'activityTest97' is displayed in activity stream

    When I login as 'fourth' random user
    And I go to the random space
    Then the activity 'activityTest97' is displayed in activity stream
    When I add in activity 'activityTest97' a comment 'commenttest97'
    Then The comment 'commenttest97' is displayed in Comments drawer of activity 'activityTest97'

    When I login as 'firstadm' random user
    And I go to the random space
    Then the activity 'activityTest97' is displayed in activity stream

    And The comment 'commenttest97' is displayed in Comments drawer of activity 'activityTest97'
    And I close the opened drawer

    When I open in activity 'activityTest97' the Comments drawer
    And I click on the first comment 'commenttest97' three dots icon from comments drawer
    And In comment 'commenttest97', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And The comment 'commenttest97' is not displayed in Comments drawer of activity 'activityTest97'

  Scenario: Cap155 - ActivityStream_US58: Mention a user in the comments
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |
      | fifth  |
      | sixth  |

    When I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing, no wait
    And I inject the fourth random user if not existing, no wait
    And I inject the fifth random user if not existing, no wait
    And I inject the sixth random user if not existing

    And I login as 'first' random user
    And I create a random space
    And I click on post in space
    And I enter an activity 'activityTest155'
    And I publish the activity
    Then the activity 'activityTest155' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activityTest155' is displayed in activity stream

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activityTest155' is displayed in activity stream

    When I login as 'fourth' random user
    And I go to the random space
    Then the activity 'activityTest155' is displayed in activity stream

    When I login as 'second' random user
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

  Scenario: Notifications for comments to my activity
    Given I am authenticated as 'admin' random user

    When I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the random space

    And I login as 'first' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTest146'
    And I publish the activity
    Then the activity 'activityTest146' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activityTest146' is displayed in activity stream
    When I add in activity 'activityTest146' a comment 'commenttest146'
    Then The comment 'commenttest146' is displayed in Comments drawer of activity 'activityTest146'

    When I login as 'first' random user
    And I open Notifications
    Then The notification that shows that activity 'activityTest146' posted by first user is commented by second user with comment 'activityTest146', is displayed

    When I click on the notification that shows that activity 'activityTest146' posted by first user is commented by second user with comment 'activityTest146'
    Then The comment 'commenttest146' is displayed in Comments drawer

  Scenario: Notifications for comment to my comment
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    When I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    And I login as 'first' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activityTest147'
    And I publish the activity
    Then the activity 'activityTest147' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activityTest147' is displayed in activity stream
    When I add in activity 'activityTest147' a comment 'commenttest147'
    Then The comment 'commenttest147' is displayed in Comments drawer of activity 'activityTest147'

    When I login as 'first' random user
    And I go to the random space
    And I add a reply 'replyTest147' to comment 'commenttest147' in activity 'activityTest147'
    Then In activity 'activityTest147' with comment 'commenttest147', the reply 'replyTest147' is displayed

    When I login as 'second' random user
    And I open Notifications
    Then The notification that shows that comment 'commenttest147' posted by second user is replied by first user with 'replyTest147', is displayed

    When I click on the notification that shows that comment 'commenttest147' posted by second user is replied by first user with 'replyTest147'
    Then The comment 'commenttest147' is displayed in Comments drawer
    And In activity 'activityTest147' with comment 'commenttest147', the reply 'replyTest147' is displayed
    And I go to the home page

  Scenario: CAP20 - [ActivityStream_US10][09] Activity with text or link options (3 dots) (Author delete the post)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    When I login as 'first' random user
    And I go to the random space

    When I login as 'second' random user
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
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    When I login as 'first' random user
    And I go to the random space

    When I login as 'second' random user
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

  Scenario: CAP88 - [ActivityStream_US04.1][01] Edit comment from the comment drawer
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing, no wait
    And I inject the fourth random user if not existing

    When I login as 'first' random user
    And I go to the random space

    When I login as 'second' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitycap88'
    And I publish the activity
    Then the activity 'activitycap88' is displayed in activity stream
    When I add in activity 'activitycap88' a comment 'commenttestCAP88-101'
    Then The comment 'commenttestCAP88-101' is displayed in Comments drawer of activity 'activitycap88'

    When I login as 'first' random user
    And I go to the random space
    Then the activity 'activitycap88' is displayed in activity stream
    When I add in activity 'activitycap88' a comment 'commenttestCAP88-102'
    When I open in activity 'activitycap88' the Comments drawer
    And I add a reply 'replyTestCAP88-102' to comment 'commenttestCAP88-102' in activity 'activitycap88'
    Then In activity 'activitycap88' with comment 'commenttestCAP88-102', the reply 'replyTestCAP88-102' is displayed

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activitycap88' is displayed in activity stream
    When I open in activity 'activitycap88' the Comments drawer
    And I add in activity 'activitycap88' a comment 'commenttestCAP88-103'
    When I open in activity 'activitycap88' the Comments drawer
    And I add a reply 'replyTestCAP88-103' to comment 'commenttestCAP88-103' in activity 'activitycap88'
    Then In activity 'activitycap88' with comment 'commenttestCAP88-103', the reply 'replyTestCAP88-103' is displayed

    When I login as 'fourth' random user
    And I go to the random space
    Then the activity 'activitycap88' is displayed in activity stream
    When I open in activity 'activitycap88' the Comments drawer
    And I add in activity 'activitycap88' a comment 'commenttestCAP88-104'
    And I open in activity 'activitycap88' the Comments drawer
    And I add a reply 'replyTestCAP88-104' to comment 'commenttestCAP88-104' in activity 'activitycap88'
    And In activity 'activitycap88' with comment 'commenttestCAP88-104', the reply 'replyTestCAP88-104' is displayed
    And I click on View all X comments
    And I click on the comment 'commenttestCAP88-104' three dots icon from comments drawer
    And In comment 'commenttestCAP88-104', I click on edit button from comments drawer
    And I insert text 'updated' as comment
    Then I click on update comment
    And I open in activity 'activitycap88' the Comments drawer
    Then Comment is displayed in comments drawer at the sixth position

  Scenario: CAP128 - [ActivityStream_US47][01] Send a kudos from a comment
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing

    And I login as 'first' random user
    And I inject a random space
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosCAP128'
    And I publish the activity
    Then the activity 'activitytestkudosCAP128' is displayed in activity stream

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activitytestkudosCAP128' is displayed in activity stream

    When I add in activity 'activitytestkudosCAP128' a comment 'activitytestkudoscommentCAP128'
    Then The comment 'activitytestkudoscommentCAP128' is displayed in Comments drawer of activity 'activitytestkudosCAP128'

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activitytestkudosCAP128' is displayed in activity stream

    When I open in activity 'activitytestkudosCAP128' the Comments drawer
    When In comment 'activitytestkudoscommentCAP128', Kudos label should be black
    Then I click on the kudos button from the comments drawer
    And I send to the comment activity a kudos message 'Test Auto comment Kudos CAP128'

    When I open in activity 'activitytestkudosCAP128' the Comments drawer
    Then In comment 'activitytestkudoscommentCAP128', Kudos label should be blue
    And I click on the kudos button number
    Then '1' kudos are displayed on the reaction drawer

  Scenario: CAP129 - [ActivityStream_US47][03] Send a kudos from the comments drawer
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | sixth  |
      | third  |

    And I inject the first random user if not existing, no wait
    And I inject the sixth random user if not existing, no wait
    And I inject the third random user if not existing

    And I login as 'first' random user
    And I inject a random space
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosCAP129'
    And I publish the activity
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream
    When I add in activity 'activitytestkudosCAP129' a comment 'activitytestkudoscommentCAP129'
    Then The comment 'activitytestkudoscommentCAP129' is displayed in Comments drawer of activity 'activitytestkudosCAP129'

    When I login as 'sixth' random user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream
    And I open in activity 'activitytestkudosCAP129' the Comments drawer
    And In comment 'activitytestkudoscommentCAP129', Kudos label should be black
    When I click on the kudos button from the comments drawer
    And I send to the comment activity a kudos message 'Test Auto comment Kudos'
    And I open in activity 'activitytestkudosCAP129' the Comments drawer
    Then In comment 'activitytestkudoscommentCAP129', Kudos label should be blue
    And I click on the kudos button number from the comments drawer
    Then '1' kudos are displayed on the reaction drawer

  Scenario: CAP220 - [ActivityStream_IMPV07][01] Pagination in comments drawer
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |

    And I inject the first random user if not existing, no wait

    When I login as 'first' random user
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
    Then The comment 'commenttestCAP220-1021' is displayed in Comments drawer of activity 'activitycap220'

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
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | sixth  |
      | third  |
      | fourth  |
    And I inject the first random user if not existing, no wait
    And I inject the sixth random user if not existing, no wait
    And I inject the third random user if not existing, no wait
    And I inject the fourth random user if not existing

    And I login as 'admin' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'stream activité'
    And I publish the activity

    And I login as 'first' random user
    And I go to the random space
    And I like the activity 'stream activité'

    And I login as 'third' random user
    And I go to the random space
    And I like the activity 'stream activité'

    And I login as 'fourth' random user
    And I go to the random space
    And I like the activity 'stream activité'

    And I login as 'sixth' random user
    And I go to the random space
    Then the activity 'stream activité' is displayed in activity stream
    And The activity likers number is not diplayed in 'stream activité'

    When I like the activity 'stream activité'
    Then The activity likers number is diplayed in 'stream activité'

    When I login as 'admin' random user
    And I go to the random space

    When I click on likers number of the activity 'stream activité'
    Then The sixth user is displayed in activity likers drawer
    And I open user profile of sixth user from activity likers drawer
    And The page '/profile' is opened

  Scenario: CAP129 - [ActivityStream_US47][02] Send a kudos from a reply
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | sixth  |
      | third  |
      | fourth  |

    And I inject the first random user if not existing, no wait
    And I inject the sixth random user if not existing, no wait
    And I inject the third random user if not existing, no wait
    And I inject the fourth random user if not existing

    And I login as 'first' random user
    And I inject the random space
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosCAP129'
    And I publish the activity
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream

    When I add in activity 'activitytestkudosCAP129' a comment 'activitytestkudosCAP129comment'
    Then The comment 'activitytestkudosCAP129comment' is displayed in Comments drawer of activity 'activitytestkudosCAP129'

    When I login as 'fourth' random user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream
    And I open in activity 'activitytestkudosCAP129' the Comments drawer
    When I add a reply 'activitytestkudosCAP129commentreply' to comment 'activitytestkudosCAP129comment' in activity 'activitytestkudosCAP129'
    Then In activity 'activitytestkudosCAP129' with comment 'activitytestkudosCAP129comment', the reply 'activitytestkudosCAP129commentreply' is displayed

    When I login as 'sixth' random user
    And I go to the random space
    Then the activity 'activitytestkudosCAP129' is displayed in activity stream
    And I open in activity 'activitytestkudosCAP129' the Comments drawer
    And In reply 'activitytestkudosCAP129commentreply', Kudos label should be black
    When In reply 'activitytestkudosCAP129commentreply', I click on kudos button
    And I send to the comment activity a kudos message 'Test Auto reply Kudos'
    And I open in activity 'activitytestkudosCAP129' the Comments drawer
    Then In reply 'activitytestkudosCAP129commentreply', Kudos label should be blue
    When I click on the kudos button number
    Then '1' kudos are displayed on the reaction drawer

  Scenario: CAP89 - [ActivityStream_US04][03] Edit reply in Activity stream
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing, no wait
    And I inject the fourth random user if not existing

    When I login as 'first' random user
    And I go to the random space

    When I login as 'second' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitycap87'
    And I publish the activity
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest101'
    And I click on comment button related to activity 'activitycap87'
    Then The comment 'commenttest101' is displayed in Comments drawer of activity 'activitycap87'

    When I login as 'first' random user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest102'
    And I click on comment button related to activity 'activitycap87'
    Then Second comment is displayed in comments drawer

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest103'
    And I click on comment button related to activity 'activitycap87'
    Then Third comment is displayed in comments drawer

    When I login as 'fourth' random user
    And I go to the random space
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest104'
    And I click on comment button related to activity 'activitycap87'
    Then Fourth comment is displayed in comments drawer

    When In activity 'activitycap87', I click on the comment 'commenttest104' three dots icon
    And In comment 'commenttest104', I click on edit button
    And I update comment with a new one 'commenttestupdated104'
    And I click on update comment
    And I open in activity 'activitycap87' the Comments drawer
    Then Fourth comment is displayed in comments drawer

  Scenario: [ActivityStream_US52][03] Edit a kudos from a comment
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | fourth  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the fourth random user if not existing

    And I login as 'fourth' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosUS52'
    And I publish the activity
    Then the activity 'activitytestkudosUS52' is displayed in activity stream

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activitytestkudosUS52' is displayed in activity stream

    When I add in activity 'activitytestkudosUS52' a comment 'activitytestkudoscommentUS52'
    Then The comment 'activitytestkudoscommentUS52' is displayed in Comments drawer of activity 'activitytestkudosUS52'

    When I login as 'fourth' random user
    And I go to the random space
    Then the activity 'activitytestkudosUS52' is displayed in activity stream
    When In comment 'activitytestkudoscommentUS52', Kudos label should be black
    And I click on the kudos button from the comment 'activitytestkudoscommentUS52'
    And I send to the comment activity a kudos message 'Test Auto comment Kudos US52'
    And I click to edit the kudos text
    And I set the new kudos comment text 'updated kudos message' and I click on update button
    Then the updated Kudos activity 'updated kudos message' is displayed in stream page

  Scenario: [ActivityStream_US52][05] Edit a kudos from a reply
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
      | third  |
      | fourth  |

    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing, no wait
    And I inject the third random user if not existing, no wait
    And I inject the fourth random user if not existing

    And I login as 'first' random user
    And I inject a random space
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosUS52_05'
    And I publish the activity
    Then the activity 'activitytestkudosUS52_05' is displayed in activity stream

    When I login as 'third' random user
    And I go to the random space
    Then the activity 'activitytestkudosUS52_05' is displayed in activity stream

    When I add in activity 'activitytestkudosUS52_05' a comment 'activitytestkudoscommentUS52_05'
    Then The comment 'activitytestkudoscommentUS52_05' is displayed in Comments drawer of activity 'activitytestkudosUS52_05'

    When I login as 'fourth' random user
    And I go to the random space
    Then the activity 'activitytestkudosUS52_05' is displayed in activity stream
    And I open in activity 'activitytestkudosUS52_05' the Comments drawer
    When I add a reply 'activitytestkudoscommentreplyUS52_05' to comment 'activitytestkudoscommentUS52_05' in activity 'activitytestkudosUS52_05'
    Then In activity 'activitytestkudosUS52_05' with comment 'activitytestkudoscommentUS52_05', the reply 'activitytestkudoscommentreplyUS52_05' is displayed

    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activitytestkudosUS52_05' is displayed in activity stream
    And I open in activity 'activitytestkudosUS52_05' the Comments drawer
    And In reply 'activitytestkudoscommentreplyUS52_05', Kudos label should be black

    When In reply 'activitytestkudoscommentreplyUS52_05', I click on kudos button
    And I send to the comment activity a kudos message 'Test Auto reply Kudos US52_05'
    And I open in activity 'activitytestkudosUS52_05' the Comments drawer
    Then In reply 'activitytestkudoscommentreplyUS52_05', Kudos label should be blue

    When I click to edit the kudos from a reply comment
    And I set the new kudos comment text 'updated kudos message' and I click on update button
    Then the updated Kudos activity 'updated kudos message' is displayed in stream page

  Scenario: CAP132 - [ActivityStream_US52][01] Edit a kudos comment from an activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | fifth  |

    And I inject the first random user if not existing, no wait
    And I inject the fifth random user if not existing

    And I login as 'first' random user
    And I inject the random space
    And I go to the random space
    And I click on post in space
    And I enter an activity 'activitytestkudosUS52_01'
    And I publish the activity
    Then the activity 'activitytestkudosUS52_01' is displayed in activity stream

    When I login as 'fifth' random user
    And I go to the random space
    Then the activity 'activitytestkudosUS52_01' is displayed in activity stream
    Then I click on the kudos button on first displayed Activity
    And I send to the comment activity a kudos message 'Test Auto reply Kudos US52_01'
    And I open in activity 'activitytestkudosUS52_01' the Comments drawer
    Then I click on the first comment 'Test Auto reply Kudos US52_01' three dots icon from comments drawer
    When In comment 'Test Auto reply Kudos US52_01', I click on edit button
    And I set the new kudos comment text 'updated Test Auto reply Kudos US52_01' and I click on update button
    Then the updated Kudos activity 'updated Test Auto reply Kudos US52_01' is displayed in stream page

  Scenario: PinActivity_US01: Space host or redactor can pin an activity (from Space Stream -  Space host Case)
    Given I am authenticated as 'admin' random user
    And I create a random space
    And I go to the random space
    And I click on post in space
    And I enter an activity 'PinTest'
    When I publish the activity
    Then the activity 'PinTest' is displayed in activity stream
    Given I click on three dots button related to activity 'PinTest'
    Then Pin button related to activity 'PinTest' is displayed
    Given I click on Pin button related to activity 'PinTest'
    Then Confirmation message is displayed 'This activity has been pinned to the space stream.'
    When I close the notification
    Then The activity 'PinTest' is pinned in space stream
    Given I go to Stream page
    Then the activity 'PinTest' is displayed in stream page
    Given I click on three dots button related to activity 'PinTest'
    Then Unpin button related to activity 'PinTest' is displayed

  Scenario: Pin Activity US01: Space host or redactor can pin an activity (from General Stream -  Space redactor Case)
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
    And I click on 'Members' space menu tab
    Then The search result is well matched with the username entered of the second user
    And I click on three dots menu
    And I set as a redactor
    Given I click on 'Stream' space menu tab
    And I click on post in space
    And I enter an activity 'PinTest'
    When I publish the activity
    Then the activity 'PinTest' is displayed in activity stream
    When I login as 'second' random user
    And I go to Stream page
    And I click on three dots button related to activity 'PinTest'
    Then Pin button related to activity 'PinTest' is displayed
    Given I click on Pin button related to activity 'PinTest'
    Then Confirmation message is displayed 'This activity has been pinned to the space stream.'
    When I close the notification
    And I go to the random space
    Then The activity 'PinTest' is pinned in space stream
    Given I click on three dots button related to activity 'PinTest'
    Then Unpin button related to activity 'PinTest' is displayed

  Scenario: Pin Activity US03: Unpin an activity
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
    And I click on 'Members' space menu tab
    Then The search result is well matched with the username entered of the second user
    And I click on three dots menu
    And I set as a redactor
    Given I click on 'Stream' space menu tab
    And I click on post in space
    And I enter an activity 'PinTest'
    When I publish the activity
    Then the activity 'PinTest' is displayed in activity stream
    When I login as 'first' random user
    And I go to Stream page
    And I click on three dots button related to activity 'PinTest'
    Then Pin button related to activity 'PinTest' is displayed
    Given I click on Pin button related to activity 'PinTest'
    Then Confirmation message is displayed 'This activity has been pinned to the space stream.'
    When I close the notification
    And I go to the random space
    Then The activity 'PinTest' is pinned in space stream
    Given I click on three dots button related to activity 'PinTest'
    Then Unpin button related to activity 'PinTest' is displayed
    Given I click to the Unpin button related to activity 'PinTest'
    Then Confirmation message is displayed 'This activity has been unpinned.'
    When I close the notification
    Then The activity 'PinTest' should be not pinned in space stream

  Scenario: Pin Activity US04: Pinned activities filter
    Given I am authenticated as 'admin' random user
    And I create a random space
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
    Then Confirmation message is displayed 'This activity has been pinned to the space stream.'
    When I close the notification
    Then The activity 'PinTest' is pinned in space stream
    Given I go to Stream page
    Then the activity 'act_Pin_US04_0' is displayed in stream page
    And the activity 'act_Pin_US04_1' is displayed in stream page
    And the activity 'act_Pin_US04_2' is displayed in stream page
    And the activity 'PinTest' is displayed in stream page
    When I click on filter icon from composer
    And I click on 'Pinned activities' activity filter radio button
    And I click on 'Apply' button in drawer
    And the stream filter is selected
    And the activity 'PinTest' is displayed in stream page
    Then the activity 'act_Pin_US04_0' is not displayed in stream page
    And the activity 'act_Pin_US04_1' is not displayed in stream page
    And the activity 'act_Pin_US04_2' is not displayed in stream page
    When I click on filter icon from composer
    And I click on 'All' activity filter radio button
    And I click on 'Apply' button in drawer
    And the stream filter isn't selected

  Scenario: Access user profile through user avatar
    Given I am authenticated as 'admin' random user
    And I inject the random space
    And I go to the random space

    When I click on user avatar in space stream
    Then The page '/profile' is opened

  Scenario: Open composer drawer
    Given I am authenticated as 'admin' random user
    And I inject the random space
    And I go to the random space

    When I click on post in space
    Then the composer is opened

  Scenario: Send kudos from composer
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the kudosreceiver random user if not existing

    When I login as 'kudosreceiver' random user
    Then I go to the random space

    When I login as 'admin' random user
    And I go to the random space
    And I click on post in space
    And I click on send kudos
    And I send kudos to 'kudosreceiver' with message 'Composer - send Kudos'

    And I login as 'kudosreceiver' random user
    And I go to My Profile page
    Then '1' kudos are received

    Scenario: Open kudos/poll drawer from CTAs below the post CTA
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to the random space

    When I click on kudos button below the post field
    Then the kudos drawer is opened

    When I close kudos drawer 
    And I click on poll button below the post field
    Then The Poll drawer is opened
    And I create a simple poll with title 'Poll from space toolbar' and Choice One 'Option1' and Choice Two 'Option2'
    And I publish the Poll
    Then The Poll 'Poll from space toolbar' is displayed in stream page
