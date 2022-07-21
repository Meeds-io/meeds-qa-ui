Feature: Activity Stream

  Scenario: CAP01 - ActivityStream_US01: Activity topbar section
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create the second random user

    And I connect with the first created user
    And I create the random space

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest01'
    And I publish the activity
    Then the activity 'activityTest01' is displayed in activity stream

    When I connect with the first created user
    And I go to the created space
    Then The activity 'activityTest01' posted by the second user in the created space is displayed with its timestamp in activity stream

    When I go to Stream page
    Then The activity 'activityTest01' posted by the second user in the created space is displayed with its timestamp in streams page

  Scenario: CAP02 - ActivityStream_US03: new Activity body with text display
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    And I connect with the second created user
    And I create the random space

    When I connect with the first created user
    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest02' mentioning the second user
    And I publish the activity
    Then In post 'activityTest02', the mentioned second user is displayed

    When In post 'activityTest02', I mouse over the mentioned second user
    Then User Popover of the second user is displayed

    When I click on the second user Popover
    Then The profile page is displayed

  Scenario: CAP03 - [ActivityStream_US05][01]: Display first 10 created activities in new Activity Stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the first random user
    And I create the second random user

    And I connect with the first created user
    And I create the random space
    And I post '30' activities
    And I refresh the page
    Then the activity 'act30' is displayed in activity stream
    And the activity 'act29' is displayed in activity stream
    And the activity 'act28' is displayed in activity stream
    And the activity 'act27' is displayed in activity stream
    And the activity 'act26' is displayed in activity stream
    And the activity 'act25' is displayed in activity stream
    And the activity 'act24' is displayed in activity stream
    And the activity 'act23' is displayed in activity stream
    And the activity 'act22' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'

    Then the activity 'act30' is displayed in activity stream
    And the activity 'act29' is displayed in activity stream
    And the activity 'act28' is displayed in activity stream
    And the activity 'act27' is displayed in activity stream
    And the activity 'act26' is displayed in activity stream
    And the activity 'act25' is displayed in activity stream
    And the activity 'act24' is displayed in activity stream
    And the activity 'act23' is displayed in activity stream
    And the activity 'act22' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I click on Load more button
    Then the activity 'act30' is displayed in activity stream
    And the activity 'act20' is displayed in activity stream
    And the activity 'act19' is displayed in activity stream
    And the activity 'act18' is displayed in activity stream
    And the activity 'act17' is displayed in activity stream
    And the activity 'act15' is displayed in activity stream
    And the activity 'act14' is displayed in activity stream
    And the activity 'act13' is displayed in activity stream
    And the activity 'act12' is displayed in activity stream
    And the activity 'act11' is displayed in activity stream
    And the activity 'act10' is not displayed in activity stream

    When I go to Stream page
    Then the activity 'act30' is displayed in stream page
    And the activity 'act29' is displayed in stream page
    And the activity 'act28' is displayed in stream page
    And the activity 'act27' is displayed in stream page
    And the activity 'act26' is displayed in stream page
    And the activity 'act25' is displayed in stream page
    And the activity 'act24' is displayed in stream page
    And the activity 'act23' is displayed in stream page
    And the activity 'act22' is displayed in stream page
    And the activity 'act21' is displayed in stream page
    And the activity 'act20' is not displayed in stream page

    When I click on Load more button
    Then the activity 'act30' is displayed in stream page
    And the activity 'act20' is displayed in stream page
    And the activity 'act19' is displayed in stream page
    And the activity 'act18' is displayed in stream page
    And the activity 'act17' is displayed in stream page
    And the activity 'act15' is displayed in stream page
    And the activity 'act14' is displayed in stream page
    And the activity 'act13' is displayed in stream page
    And the activity 'act12' is displayed in stream page
    And the activity 'act11' is displayed in stream page
    And the activity 'act10' is not displayed in stream page

  Scenario: CAP04 - [ActivityStream_US05][02]: Display first 10 activities in new Activity Stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    And I connect with the first created user

    When I create the random space
    And I post '30' activities
    And I refresh the page
    Then the activity 'act30' is displayed in activity stream
    And the activity 'act29' is displayed in activity stream
    And the activity 'act28' is displayed in activity stream
    And the activity 'act27' is displayed in activity stream
    And the activity 'act26' is displayed in activity stream
    And the activity 'act25' is displayed in activity stream
    And the activity 'act24' is displayed in activity stream
    And the activity 'act23' is displayed in activity stream
    And the activity 'act22' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'act30' is displayed in activity stream
    And the activity 'act29' is displayed in activity stream
    And the activity 'act28' is displayed in activity stream
    And the activity 'act27' is displayed in activity stream
    And the activity 'act26' is displayed in activity stream
    And the activity 'act25' is displayed in activity stream
    And the activity 'act24' is displayed in activity stream
    And the activity 'act23' is displayed in activity stream
    And the activity 'act22' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I connect with the first created user
    And I go to the created space
    And I click on modify the activity 'act30'
    And I enter an activity 'act30updated'
    And I click on Update
    And I click on modify the activity 'act29'
    And I enter an activity 'act29updated'
    And I click on Update
    And I click on modify the activity 'act28'
    And I enter an activity 'act28updated'
    And I click on Update
    And I click on modify the activity 'act27'
    And I enter an activity 'act27updated'
    And I click on Update
    And I click on modify the activity 'act26'
    And I enter an activity 'act26updated'
    And I click on Update
    And I click on modify the activity 'act25'
    And I enter an activity 'act25updated'
    And I click on Update
    And I click on modify the activity 'act24'
    And I enter an activity 'act24updated'
    And I click on Update
    And I click on modify the activity 'act23'
    And I enter an activity 'act23updated'
    And I click on Update
    And I click on modify the activity 'act22'
    And I enter an activity 'act22updated'
    And I click on Update
    And I click on modify the activity 'act21'
    And I enter an activity 'act21updated'
    And I click on Update
    Then the activity 'act30updated' is displayed in activity stream
    And the activity 'act21updated' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I click on Load more button
    Then the activity 'act20' is displayed in activity stream

    When I click on modify the activity 'act20'
    And I enter an activity 'act20updated'
    And I click on Update
    And I click on modify the activity 'act19'
    And I enter an activity 'act19updated'
    And I click on Update
    And I click on modify the activity 'act18'
    And I enter an activity 'act18updated'
    And I click on Update
    And I click on modify the activity 'act17'
    And I enter an activity 'act17updated'
    And I click on Update
    And I click on modify the activity 'act16'
    And I enter an activity 'act16updated'
    And I click on Update
    And I click on modify the activity 'act15'
    And I enter an activity 'act15updated'
    And I click on Update
    And I click on modify the activity 'act14'
    And I enter an activity 'act14updated'
    And I click on Update
    And I click on modify the activity 'act13'
    And I enter an activity 'act13updated'
    And I click on Update
    And I click on modify the activity 'act12'
    And I enter an activity 'act12updated'
    And I click on Update
    And I click on modify the activity 'act11'
    And I enter an activity 'act11updated'
    And I click on Update

    When I connect with the second created user
    And I go to the created space

    Then the activity 'act11updated' is displayed in activity stream
    And the activity 'act12updated' is displayed in activity stream
    And the activity 'act13updated' is displayed in activity stream
    And the activity 'act14updated' is displayed in activity stream
    And the activity 'act15updated' is displayed in activity stream
    And the activity 'act16updated' is displayed in activity stream
    And the activity 'act17updated' is displayed in activity stream
    And the activity 'act18updated' is displayed in activity stream
    And the activity 'act19updated' is displayed in activity stream
    And the activity 'act20updated' is displayed in activity stream
    And the activity 'act21' is not displayed in activity stream
    And the activity 'act21updated' is not displayed in activity stream

    When I click on Load more button
    Then the activity 'act21updated' is displayed in activity stream
    And the activity 'act22updated' is displayed in activity stream
    And the activity 'act23updated' is displayed in activity stream
    And the activity 'act24updated' is displayed in activity stream
    And the activity 'act25updated' is displayed in activity stream
    And the activity 'act26updated' is displayed in activity stream
    And the activity 'act27updated' is displayed in activity stream
    And the activity 'act28updated' is displayed in activity stream
    And the activity 'act29updated' is displayed in activity stream
    And the activity 'act30updated' is displayed in activity stream
    And the activity 'act10' is not displayed in activity stream

    When I go to Stream page
    Then the activity 'act11updated' is displayed in stream page
    And the activity 'act12updated' is displayed in stream page
    And the activity 'act13updated' is displayed in stream page
    And the activity 'act14updated' is displayed in stream page
    And the activity 'act15updated' is displayed in stream page
    And the activity 'act16updated' is displayed in stream page
    And the activity 'act17updated' is displayed in stream page
    And the activity 'act18updated' is displayed in stream page
    And the activity 'act19updated' is displayed in stream page
    And the activity 'act20updated' is displayed in stream page
    And the activity 'act21updated' is not displayed in stream page

    When I click on Load more button
    Then the activity 'act21updated' is displayed in stream page
    And the activity 'act22updated' is displayed in stream page
    And the activity 'act23updated' is displayed in stream page
    And the activity 'act24updated' is displayed in stream page
    And the activity 'act25updated' is displayed in stream page
    And the activity 'act26updated' is displayed in stream page
    And the activity 'act27updated' is displayed in stream page
    And the activity 'act28updated' is displayed in stream page
    And the activity 'act29updated' is displayed in stream page
    And the activity 'act30updated' is displayed in stream page
    And the activity 'act10' is not displayed in stream page

  Scenario: CAP05 - [ActivityStream_US05][03]: Display first 10 activities in new Activity Stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    And I connect with the first created user

    When I create the random space
    And I post '30' activities
    And I refresh the page
    Then the activity 'act30' is displayed in activity stream
    And the activity 'act29' is displayed in activity stream
    And the activity 'act28' is displayed in activity stream
    And the activity 'act27' is displayed in activity stream
    And the activity 'act26' is displayed in activity stream
    And the activity 'act25' is displayed in activity stream
    And the activity 'act24' is displayed in activity stream
    And the activity 'act23' is displayed in activity stream
    And the activity 'act22' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'act30' is displayed in activity stream
    And the activity 'act29' is displayed in activity stream
    And the activity 'act28' is displayed in activity stream
    And the activity 'act27' is displayed in activity stream
    And the activity 'act26' is displayed in activity stream
    And the activity 'act25' is displayed in activity stream
    And the activity 'act24' is displayed in activity stream
    And the activity 'act23' is displayed in activity stream
    And the activity 'act22' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I connect with the first created user
    And I go to the created space
    And I like the activity 'act30'
    And I like the activity 'act29'
    And I like the activity 'act28'
    And I like the activity 'act27'
    And I like the activity 'act26'
    And I like the activity 'act25'
    And I like the activity 'act24'
    And I like the activity 'act23'
    And I like the activity 'act22'
    And I like the activity 'act21'
    Then the activity 'act30' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I click on Load more button
    Then the activity 'act20' is displayed in activity stream

    When I like the activity 'act20'
    And I like the activity 'act19'
    And I like the activity 'act18'
    And I like the activity 'act17'
    And I like the activity 'act16'
    And I like the activity 'act15'
    And I like the activity 'act14'
    And I like the activity 'act13'
    And I like the activity 'act12'
    And I like the activity 'act11'

    When I connect with the second created user
    And I go to the created space

    Then the activity 'act30' is displayed in activity stream
    And the activity 'act29' is displayed in activity stream
    And the activity 'act28' is displayed in activity stream
    And the activity 'act27' is displayed in activity stream
    And the activity 'act26' is displayed in activity stream
    And the activity 'act25' is displayed in activity stream
    And the activity 'act24' is displayed in activity stream
    And the activity 'act23' is displayed in activity stream
    And the activity 'act22' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is not displayed in activity stream

    When I click on Load more button
    Then the activity 'act30' is displayed in activity stream
    And the activity 'act21' is displayed in activity stream
    And the activity 'act20' is displayed in activity stream
    And the activity 'act19' is displayed in activity stream
    And the activity 'act18' is displayed in activity stream
    And the activity 'act17' is displayed in activity stream
    And the activity 'act15' is displayed in activity stream
    And the activity 'act14' is displayed in activity stream
    And the activity 'act13' is displayed in activity stream
    And the activity 'act12' is displayed in activity stream
    And the activity 'act11' is displayed in activity stream
    And the activity 'act10' is not displayed in activity stream

    When I go to Stream page
    Then the activity 'act30' is displayed in stream page
    And the activity 'act29' is displayed in stream page
    And the activity 'act28' is displayed in stream page
    And the activity 'act27' is displayed in stream page
    And the activity 'act26' is displayed in stream page
    And the activity 'act25' is displayed in stream page
    And the activity 'act24' is displayed in stream page
    And the activity 'act23' is displayed in stream page
    And the activity 'act22' is displayed in stream page
    And the activity 'act21' is displayed in stream page
    And the activity 'act20' is not displayed in stream page

    When I click on Load more button
    Then the activity 'act30' is displayed in stream page
    And the activity 'act20' is displayed in stream page
    And the activity 'act19' is displayed in stream page
    And the activity 'act18' is displayed in stream page
    And the activity 'act17' is displayed in stream page
    And the activity 'act15' is displayed in stream page
    And the activity 'act14' is displayed in stream page
    And the activity 'act13' is displayed in stream page
    And the activity 'act12' is displayed in stream page
    And the activity 'act11' is displayed in stream page
    And the activity 'act10' is not displayed in stream page

  Scenario: CAP100 - [ActivityStream_US38][04]: Cancel Delete comment with replies from the activity stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest100'
    And I publish the activity
    Then the activity 'activityTest100' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest100' is displayed in activity stream
    When I add in activity 'activityTest100' a comment 'commenttest100'
    And I open in activity 'activityTest100' the Comments drawer
    Then Activity Comment 'commenttest100' is displayed in Comments drawer
    And Activity Comment 'commenttest100' is displayed in activity stream

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest100' is displayed in activity stream
    And Activity Comment 'commenttest100' is displayed in activity stream
    When I add a reply 'replyTest100' to comment 'commenttest100' in activity 'activityTest100'
    Then In activity 'activityTest100' with comment 'commenttest100', the reply 'replyTest100' is displayed

    When I change user
      | login    | john   |
      | password | gtngtn |

    And I go to the created space
    Then the activity 'activityTest100' is displayed in activity stream
    And Activity Comment 'commenttest100' is displayed in activity stream
    And In activity 'activityTest100' with comment 'commenttest100', the reply 'replyTest100' is displayed
    When I add a reply 'replyTest101' to comment 'commenttest100' in activity 'activityTest100'
    Then In activity 'activityTest100' with comment 'commenttest100', the reply 'replyTest101' is displayed

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest100' is displayed in activity stream
    And Activity Comment 'commenttest100' is displayed in activity stream
    And In activity 'activityTest100' with comment 'commenttest100', the reply 'replyTest100' is displayed
    And In activity 'activityTest100' with comment 'commenttest100', the reply 'replyTest101' is displayed

    When In activity 'activityTest100', I click on the comment 'commenttest100' three dots icon
    And In comment 'commenttest100', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And Activity Comment 'commenttest100' is displayed in activity stream
    And In activity 'activityTest100' with comment 'commenttest100', the reply 'replyTest100' is displayed
    And In activity 'activityTest100' with comment 'commenttest100', the reply 'replyTest101' is displayed

  Scenario: CAP101 - [ActivityStream_US38][05]: Delete a reply from the activity stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest101'
    And I publish the activity
    Then the activity 'activityTest101' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest101' is displayed in activity stream
    When I add in activity 'activityTest101' a comment 'commenttest101'
    And I open in activity 'activityTest101' the Comments drawer
    Then Activity Comment 'commenttest101' is displayed in Comments drawer
    And Activity Comment 'commenttest101' is displayed in activity stream

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest101' is displayed in activity stream
    And Activity Comment 'commenttest101' is displayed in activity stream
    When I add a reply 'replyTest101' to comment 'commenttest101' in activity 'activityTest101'
    Then In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest101' is displayed

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest101' is displayed in activity stream
    And Activity Comment 'commenttest101' is displayed in activity stream
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttest101' in activity 'activityTest101'
    Then In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest102' is displayed

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest101' is displayed in activity stream
    And Activity Comment 'commenttest101' is displayed in activity stream
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest101' is displayed
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest102' is displayed
    When I add a reply 'replyTest103' to comment 'commenttest101' in activity 'activityTest101'
    Then In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest103' is displayed

    When I change user
      | login    | john   |
      | password | gtngtn |

    And I go to the created space
    Then the activity 'activityTest101' is displayed in activity stream
    And Activity Comment 'commenttest101' is displayed in activity stream
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest101' is not displayed
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest102' is displayed
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest103' is displayed
    When I add a reply 'replyTest104' to comment 'commenttest101' in activity 'activityTest101'
    Then In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest104' is displayed

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest101' is displayed in activity stream
    And Activity Comment 'commenttest101' is displayed in activity stream
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest101' is not displayed
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest102' is not displayed
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest103' is displayed
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest104' is displayed

    When In activity 'activityTest101' with comment 'commenttest101', I click on the reply 'replyTest103' three dots icon
    And In reply 'replyTest103', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Activity Comment 'commenttest101' is displayed in activity stream
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest101' is not displayed
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest103' is not displayed
    And In activity 'activityTest101' with comment 'commenttest101', the reply 'replyTest102' is displayed
    And In activity 'activityTest101' with comment 'commenttest100', the reply 'replyTest104' is displayed

  Scenario: CAP102 - [ActivityStream_US38][06]: Cancel Delete a reply from the activity stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest102'
    And I publish the activity
    Then the activity 'activityTest102' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest102' is displayed in activity stream
    When I add in activity 'activityTest102' a comment 'commenttest102'
    And I open in activity 'activityTest102' the Comments drawer
    Then Activity Comment 'commenttest102' is displayed in Comments drawer
    And Activity Comment 'commenttest102' is displayed in activity stream

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest102' is displayed in activity stream
    And Activity Comment 'commenttest102' is displayed in activity stream
    When I add a reply 'replyTest101' to comment 'commenttest102' in activity 'activityTest102'
    Then In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest101' is displayed

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest102' is displayed in activity stream
    And Activity Comment 'commenttest102' is displayed in activity stream
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttest102' in activity 'activityTest102'
    Then In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest102' is displayed

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest102' is displayed in activity stream
    And Activity Comment 'commenttest102' is displayed in activity stream
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest101' is displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest102' is displayed
    When I add a reply 'replyTest103' to comment 'commenttest102' in activity 'activityTest102'
    Then In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest103' is displayed

    When I change user
      | login    | john   |
      | password | gtngtn |

    And I go to the created space
    Then the activity 'activityTest102' is displayed in activity stream
    And Activity Comment 'commenttest102' is displayed in activity stream
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest101' is not displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest102' is displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest103' is displayed
    When I add a reply 'replyTest104' to comment 'commenttest102' in activity 'activityTest102'
    Then In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest104' is displayed

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest102' is displayed in activity stream
    And Activity Comment 'commenttest102' is displayed in activity stream
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest101' is not displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest102' is not displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest103' is displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest104' is displayed

    When In activity 'activityTest102' with comment 'commenttest102', I click on the reply 'replyTest103' three dots icon
    And In reply 'replyTest103', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And Activity Comment 'commenttest102' is displayed in activity stream
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest101' is not displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest102' is not displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest103' is displayed
    And In activity 'activityTest102' with comment 'commenttest102', the reply 'replyTest104' is displayed

  Scenario: CAP103 - [ActivityStream_US39][01]: Delete a simple comment from the comment drawer
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest103'
    And I publish the activity
    Then the activity 'activityTest103' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest103' is displayed in activity stream
    When I add in activity 'activityTest103' a comment 'commenttest103'
    And I open in activity 'activityTest103' the Comments drawer
    Then Activity Comment 'commenttest103' is displayed in Comments drawer
    And Activity Comment 'commenttest103' is displayed in activity stream

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest103' is displayed in activity stream
    And Activity Comment 'commenttest103' is displayed in activity stream

    When I open in activity 'activityTest103' the Comments drawer
    Then '1 comment', only 'commenttest103' is displayed in Comments drawer
    And I close the comments drawer

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest103' is displayed in activity stream
    And Activity Comment 'commenttest103' is displayed in activity stream

    When I open in activity 'activityTest103' the Comments drawer
    Then '1 comment', only 'commenttest103' is displayed in Comments drawer
    When In comments drawer, I click on the comment 'commenttest103' three dots icon
    And In comment 'commenttest103', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttest103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the comments drawer
    Then Comment 'commenttest103' is not displayed in activity 'activityTest103'

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest103' is displayed in activity stream

    When I open in activity 'activityTest103' the Comments drawer
    Then Comment 'commenttest103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the comments drawer
    Then Comment 'commenttest103' is not displayed in activity 'activityTest103'

    When I connect with the third created user

    And I go to the created space
    Then the activity 'activityTest103' is displayed in activity stream

    When I open in activity 'activityTest103' the Comments drawer
    Then Comment 'commenttest103' is not displayed in the drawer
    And No comments displayed in the drawer
    When I close the comments drawer
    Then Comment 'commenttest103' is not displayed in activity 'activityTest103'

  Scenario: CAP104 - [ActivityStream_US39][02]: Cancel Delete a simple comment from the comment drawer
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest104'
    And I publish the activity
    Then the activity 'activityTest104' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest104' is displayed in activity stream
    When I add in activity 'activityTest104' a comment 'commenttest104'
    And I open in activity 'activityTest104' the Comments drawer
    Then Activity Comment 'commenttest104' is displayed in Comments drawer
    And Activity Comment 'commenttest104' is displayed in activity stream

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest104' is displayed in activity stream
    And Activity Comment 'commenttest104' is displayed in activity stream

    When I open in activity 'activityTest104' the Comments drawer
    Then '1 comment', only 'commenttest104' is displayed in Comments drawer
    And I close the comments drawer

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest104' is displayed in activity stream
    And Activity Comment 'commenttest104' is displayed in activity stream

    When I open in activity 'activityTest104' the Comments drawer
    Then '1 comment', only 'commenttest104' is displayed in Comments drawer
    When In comments drawer, I click on the comment 'commenttest104' three dots icon
    And In comment 'commenttest104', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttest104' is displayed in Comments drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest104' is displayed in activity stream

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest104' is displayed in activity stream

    When I open in activity 'activityTest104' the Comments drawer
    Then '1 comment', only 'commenttest104' is displayed in Comments drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest104' is displayed in activity stream

    When I connect with the third created user

    And I go to the created space
    Then the activity 'activityTest104' is displayed in activity stream

    When I open in activity 'activityTest104' the Comments drawer
    Then '1 comment', only 'commenttest104' is displayed in Comments drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest104' is displayed in activity stream

  Scenario: CAP105 - [ActivityStream_US39][03]: Delete comment with replies from the comment drawer
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest105'
    And I publish the activity
    Then the activity 'activityTest105' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest105' is displayed in activity stream
    When I add in activity 'activityTest105' a comment 'commenttest105'
    And I open in activity 'activityTest105' the Comments drawer
    Then Activity Comment 'commenttest105' is displayed in Comments drawer
    And Activity Comment 'commenttest105' is displayed in activity stream
    When I add a reply 'replyTest101' to comment 'commenttest105' in activity 'activityTest105'
    Then In activity 'activityTest105' with comment 'commenttest105', the reply 'replyTest101' is displayed

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest105' is displayed in activity stream
    And Activity Comment 'commenttest105' is displayed in activity stream
    And In activity 'activityTest105' with comment 'commenttest105', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttest105' in activity 'activityTest105'
    Then In activity 'activityTest105' with comment 'commenttest105', the reply 'replyTest102' is displayed

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest105' is displayed in activity stream
    And Activity Comment 'commenttest105' is displayed in activity stream

    When I open in activity 'activityTest105' the Comments drawer
    Then '1 comment', only 'commenttest105' is displayed in Comments drawer
    And I close the comments drawer
    And I add a reply 'replyTest103' to comment 'commenttest105' in activity 'activityTest105'

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest105' is displayed in activity stream
    And Activity Comment 'commenttest105' is displayed in activity stream

    When I open in activity 'activityTest105' the Comments drawer
    Then '1 comment', only 'commenttest105' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttest105'
    Then In comment 'commenttest105', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest105', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest105', the reply 'replyTest103' is displayed in the drawer
    When In comments drawer, I click on the comment 'commenttest105' three dots icon
    And In comment 'commenttest105', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttest105' is not displayed in the drawer
    And No comments displayed in the drawer
    And The reply 'replyTest101' is not displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    And The reply 'replyTest103' is not displayed in the drawer
    When I close the comments drawer
    Then Comment 'commenttest105' is not displayed in activity 'activityTest105'

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest105' is displayed in activity stream

    When I open in activity 'activityTest105' the Comments drawer
    Then Comment 'commenttest105' is not displayed in the drawer
    And No comments displayed in the drawer
    And The reply 'replyTest101' is not displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    And The reply 'replyTest103' is not displayed in the drawer
    When I close the comments drawer
    Then Comment 'commenttest105' is not displayed in activity 'activityTest105'

    When I connect with the third created user

    And I go to the created space
    Then the activity 'activityTest105' is displayed in activity stream

    When I open in activity 'activityTest105' the Comments drawer
    Then Comment 'commenttest105' is not displayed in the drawer
    And No comments displayed in the drawer
    And The reply 'replyTest101' is not displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    And The reply 'replyTest103' is not displayed in the drawer
    When I close the comments drawer
    Then Comment 'commenttest105' is not displayed in activity 'activityTest105'

  Scenario: CAP106 - [ActivityStream_US39][04]: Cancel Delete comment with replies from the comments drawer
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest106'
    And I publish the activity
    Then the activity 'activityTest106' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest106' is displayed in activity stream
    When I add in activity 'activityTest106' a comment 'commenttest106'
    And I open in activity 'activityTest106' the Comments drawer
    Then Activity Comment 'commenttest106' is displayed in Comments drawer
    And Activity Comment 'commenttest106' is displayed in activity stream
    When I add a reply 'replyTest101' to comment 'commenttest106' in activity 'activityTest106'
    Then In activity 'activityTest106' with comment 'commenttest106', the reply 'replyTest101' is displayed

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest106' is displayed in activity stream
    And Activity Comment 'commenttest106' is displayed in activity stream
    And In activity 'activityTest106' with comment 'commenttest106', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttest106' in activity 'activityTest106'
    Then In activity 'activityTest106' with comment 'commenttest106', the reply 'replyTest102' is displayed

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest106' is displayed in activity stream
    And Activity Comment 'commenttest106' is displayed in activity stream

    When I open in activity 'activityTest106' the Comments drawer
    Then '1 comment', only 'commenttest106' is displayed in Comments drawer
    And I close the comments drawer
    And I add a reply 'replyTest103' to comment 'commenttest106' in activity 'activityTest106'

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest106' is displayed in activity stream
    And Activity Comment 'commenttest106' is displayed in activity stream

    When I open in activity 'activityTest106' the Comments drawer
    Then '1 comment', only 'commenttest106' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttest106'
    Then In comment 'commenttest106', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest106', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest106', the reply 'replyTest103' is displayed in the drawer
    When In comments drawer, I click on the comment 'commenttest106' three dots icon
    And In comment 'commenttest106', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttest106' is displayed in Comments drawer
    And In comment 'commenttest106', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest106', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest106', the reply 'replyTest103' is displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest106' is displayed in activity stream

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest106' is displayed in activity stream

    When I open in activity 'activityTest106' the Comments drawer
    Then '1 comment', only 'commenttest106' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttest106'
    Then In comment 'commenttest106', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest106', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest106', the reply 'replyTest103' is displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest106' is displayed in activity stream

    When I connect with the third created user

    And I go to the created space
    Then the activity 'activityTest106' is displayed in activity stream

    When I open in activity 'activityTest106' the Comments drawer
    Then '1 comment', only 'commenttest106' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttest106'
    Then In comment 'commenttest106', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest106', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest106', the reply 'replyTest103' is displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest106' is displayed in activity stream

  Scenario: CAP107 - [ActivityStream_US39][05]: Delete a reply from comments drawer
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest107'
    And I publish the activity
    Then the activity 'activityTest107' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest107' is displayed in activity stream
    When I add in activity 'activityTest107' a comment 'commenttest107'
    And I open in activity 'activityTest107' the Comments drawer
    Then Activity Comment 'commenttest107' is displayed in Comments drawer
    And Activity Comment 'commenttest107' is displayed in activity stream
    When I add a reply 'replyTest101' to comment 'commenttest107' in activity 'activityTest107'
    Then In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest101' is displayed

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest107' is displayed in activity stream
    And Activity Comment 'commenttest107' is displayed in activity stream
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttest107' in activity 'activityTest107'
    Then In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest102' is displayed

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest107' is displayed in activity stream
    And Activity Comment 'commenttest107' is displayed in activity stream

    When I open in activity 'activityTest107' the Comments drawer
    Then '1 comment', only 'commenttest107' is displayed in Comments drawer
    And I close the comments drawer
    And I add a reply 'replyTest103' to comment 'commenttest107' in activity 'activityTest107'

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest107' is displayed in activity stream
    And Activity Comment 'commenttest107' is displayed in activity stream

    When I open in activity 'activityTest107' the Comments drawer
    Then '1 comment', only 'commenttest107' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttest107'
    Then In comment 'commenttest107', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest107', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest107', the reply 'replyTest103' is displayed in the drawer
    When In comments drawer, I click on the reply 'replyTest102' three dots icon
    And In reply 'replyTest102', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttest107' is displayed in Comments drawer
    And In comment 'commenttest107', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest107', the reply 'replyTest103' is displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest107' is displayed in activity stream
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest101' is displayed
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest103' is displayed
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest102' is not displayed

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest107' is displayed in activity stream

    When I open in activity 'activityTest107' the Comments drawer
    Then '1 comment', only 'commenttest107' is displayed in Comments drawer
    And In comment 'commenttest107', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest107', the reply 'replyTest103' is displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest107' is displayed in activity stream
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest101' is displayed
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest103' is displayed
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest102' is not displayed

    When I connect with the third created user

    And I go to the created space
    Then the activity 'activityTest107' is displayed in activity stream

    When I open in activity 'activityTest107' the Comments drawer
    Then '1 comment', only 'commenttest107' is displayed in Comments drawer
    And In comment 'commenttest107', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest107', the reply 'replyTest103' is displayed in the drawer
    And The reply 'replyTest102' is not displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest107' is displayed in activity stream
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest101' is displayed
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest103' is displayed
    And In activity 'activityTest107' with comment 'commenttest107', the reply 'replyTest102' is not displayed

  Scenario: CAP108 - [ActivityStream_US39][06]: Cancel Delete a reply from the comments drawer
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I add the random space with registration 'Open'

    When I connect with the first created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest108'
    And I publish the activity
    Then the activity 'activityTest108' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest108' is displayed in activity stream
    When I add in activity 'activityTest108' a comment 'commenttest108'
    And I open in activity 'activityTest108' the Comments drawer
    Then Activity Comment 'commenttest108' is displayed in Comments drawer
    And Activity Comment 'commenttest108' is displayed in activity stream
    When I add a reply 'replyTest101' to comment 'commenttest108' in activity 'activityTest108'
    Then In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest101' is displayed

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest108' is displayed in activity stream
    And Activity Comment 'commenttest108' is displayed in activity stream
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttest108' in activity 'activityTest108'
    Then In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest102' is displayed

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest108' is displayed in activity stream
    And Activity Comment 'commenttest108' is displayed in activity stream

    When I open in activity 'activityTest108' the Comments drawer
    Then '1 comment', only 'commenttest108' is displayed in Comments drawer
    And I close the comments drawer
    And I add a reply 'replyTest103' to comment 'commenttest108' in activity 'activityTest108'

    When I connect with the first created user

    And I go to the created space
    Then the activity 'activityTest108' is displayed in activity stream
    And Activity Comment 'commenttest108' is displayed in activity stream

    When I open in activity 'activityTest108' the Comments drawer
    Then '1 comment', only 'commenttest108' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttest108'
    Then In comment 'commenttest108', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest108', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest108', the reply 'replyTest103' is displayed in the drawer
    When In comments drawer, I click on the reply 'replyTest102' three dots icon
    And In reply 'replyTest102', I click on delete button
    And I click on Cancel button
    Then the confirmation popup is not displayed
    And '1 comment', only 'commenttest108' is displayed in Comments drawer
    And In comment 'commenttest108', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest108', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest108', the reply 'replyTest103' is displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest108' is displayed in activity stream
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest101' is displayed
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest102' is displayed
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest103' is displayed

    When I connect with the second created user

    And I go to the created space
    Then the activity 'activityTest108' is displayed in activity stream

    When I open in activity 'activityTest108' the Comments drawer
    Then '1 comment', only 'commenttest108' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttest108'
    Then In comment 'commenttest108', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest108', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest108', the reply 'replyTest103' is displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest108' is displayed in activity stream
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest101' is displayed
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest102' is displayed
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest103' is displayed

    When I connect with the third created user

    And I go to the created space
    Then the activity 'activityTest108' is displayed in activity stream

    When I open in activity 'activityTest108' the Comments drawer
    Then '1 comment', only 'commenttest108' is displayed in Comments drawer
    When I click on View All replies related to the comment 'commenttest108'
    Then In comment 'commenttest108', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest108', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest108', the reply 'replyTest103' is displayed in the drawer
    When I close the comments drawer
    Then Activity Comment 'commenttest108' is displayed in activity stream
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest101' is displayed
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest102' is displayed
    And In activity 'activityTest108' with comment 'commenttest108', the reply 'replyTest103' is displayed

  Scenario: CAP109 - [ActivityStream_US40][01]: Like my comment/reply from activity stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user
    And I create random space with the second created user
    And I click on post in space
    And I enter an activity 'activitytest009'
    And I publish the activity
    Then the activity 'activitytest009' is displayed in activity stream

    When I connect with the second created user
    Then The 'Spaces' badge is '1'

    When I click on spaces badge
    And I accept the invitation of the created space
    And I close Space Drawer
    And I go to the created space
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

  Scenario: CAP110 - [ActivityStream_US40][02]: DisLike my comment/reply from activity stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    And I connect with the first created user

    And I create random space with the second created user
    And I click on post in space
    And I enter an activity 'activitytest010'
    And I publish the activity
    Then the activity 'activitytest010' is displayed in activity stream

    When I connect with the second created user
    Then The 'Spaces' badge is '1'

    When I click on spaces badge
    And I accept the invitation of the created space
    And I close Space Drawer
    And I go to the created space
    Then the activity 'activitytest010' is displayed in activity stream

    When I add in activity 'activitytest010' a comment 'commenttest110'
    And I open in activity 'activitytest010' the Comments drawer
    Then Activity Comment 'commenttest110' is displayed in Comments drawer
    And Activity Comment 'commenttest110' is displayed in activity stream

    When I add a reply 'replyTest101' to comment 'commenttest110' in activity 'activitytest010'
    Then In activity 'activitytest010' with comment 'commenttest110', the reply 'replyTest101' is displayed

    When I like the activity comment 'commenttest110'
    Then In comment 'commenttest110', Like label should be blue
    And On comment 'commenttest110', '(1)' like is displayed

    When I like the activity comment 'commenttest110'
    And In comment 'commenttest110', Like label should be black
    And On comment 'commenttest110', '(0)' like is displayed

  Scenario: CAP111 - [ActivityStream_US40][03]: Like comment/reply of other user from activity stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    When I connect with the first created user

    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytest011'
    And I publish the activity
    Then the activity 'activitytest011' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytest011' is displayed in activity stream

    When I add in activity 'activitytest011' a comment 'commenttest111'
    And I open in activity 'activitytest011' the Comments drawer
    Then Activity Comment 'commenttest111' is displayed in Comments drawer
    And Activity Comment 'commenttest111' is displayed in activity stream

    When I add a reply 'replyTest101' to comment 'commenttest111' in activity 'activitytest011'
    Then In activity 'activitytest011' with comment 'commenttest111', the reply 'replyTest101' is displayed

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
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

  Scenario: CAP112 - [ActivityStream_US40][04]: DisLike comment/reply of other user from activity stream
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I connect with the first created user

    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytest012'
    And I publish the activity
    Then the activity 'activitytest012' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytest012' is displayed in activity stream

    When I add in activity 'activitytest012' a comment 'commenttest112'
    And I open in activity 'activitytest012' the Comments drawer
    Then Activity Comment 'commenttest112' is displayed in Comments drawer
    And Activity Comment 'commenttest112' is displayed in activity stream

    When I add a reply 'replyTest101' to comment 'commenttest112' in activity 'activitytest012'
    Then In activity 'activitytest012' with comment 'commenttest112', the reply 'replyTest101' is displayed

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytest012' is displayed in activity stream

    When I like the activity comment 'commenttest112'
    Then In comment 'commenttest112', Like label should be blue
    And On comment 'commenttest112', '(1)' like is displayed

    When I like the activity comment 'commenttest112'
    And In comment 'commenttest112', Like label should be black
    And On comment 'commenttest112', '(0)' like is displayed

  Scenario: CAP115 - [ActivityStream_US41][01 ]: Like my comment/reply from the comment drawer
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user

    And I create random space with the second created user
    And I click on post in space
    And I enter an activity 'activitytest015'
    And I publish the activity
    Then the activity 'activitytest015' is displayed in activity stream

    When I connect with the second created user
    Then The 'Spaces' badge is '1'

    When I click on spaces badge
    And I accept the invitation of the created space
    And I close Space Drawer
    And I go to the created space
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
    And I close the comments drawer

  Scenario: CAP116 - [ActivityStream_US41][02]: DisLike my comment/reply from the comments drawer
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    And I connect with the first created user

    And I create random space with the second created user
    And I click on post in space
    And I enter an activity 'activitytest016'
    And I publish the activity
    Then the activity 'activitytest016' is displayed in activity stream

    When I connect with the second created user
    Then The 'Spaces' badge is '1'

    When I click on spaces badge
    And I accept the invitation of the created space
    And I close Space Drawer
    And I go to the created space
    Then the activity 'activitytest016' is displayed in activity stream

    When I add in activity 'activitytest016' a comment 'commenttest116'
    And I open in activity 'activitytest016' the Comments drawer
    Then Activity Comment 'commenttest116' is displayed in Comments drawer
    And Activity Comment 'commenttest116' is displayed in activity stream

    When I add a reply 'replyTest116' to comment 'commenttest116' in activity 'activitytest016'
    Then In activity 'activitytest016' with comment 'commenttest116', the reply 'replyTest116' is displayed

    When I open in activity 'activitytest016' the Comments drawer
    And In comments drawer, I like the activity comment 'commenttest116'
    Then In comments drawer, Like label in comment 'commenttest116' should be blue
    And In comments drawer, on comment 'commenttest116', '(1)' like is displayed

    When In comments drawer, I like the activity comment 'commenttest116'
    Then In comments drawer, Like label in comment 'commenttest116' should be black
    And In comments drawer, on comment 'commenttest116', '(0)' like is displayed
    And I close the comments drawer

  Scenario: CAP121 - [ActivityStream_IMPV14][01]: Display maximum only the last 2 comments/replies below each activity
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user

    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activityTest121'
    And I publish the activity
    Then the activity 'activityTest121' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
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

  Scenario: CAP122 - [ActivityStream_IMPV14][02]: Display maximum only the last 2 comments/replies below each activity
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user

    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activityTest122'
    And I publish the activity
    Then the activity 'activityTest122' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest122' is displayed in activity stream

    When I add in activity 'activityTest122' a comment 'commenttest101'
    And I add in activity 'activityTest122' a comment 'commenttest102'
    And I add in activity 'activityTest122' a comment 'commenttest103'
    And I add in activity 'activityTest122' a comment 'commenttest104'

    Then First comment 'commenttest103' is displayed in activity stream
    And Second comment 'commenttest104' is displayed in activity stream
    And Comment 'commenttest101' is not displayed in activity 'activityTest122'
    And Comment 'commenttest102' is not displayed in activity 'activityTest122'

    When I add a reply 'replyTest101' to comment 'commenttest103' in activity 'activityTest122'
    And I add a reply 'replyTest102' to comment 'commenttest103' in activity 'activityTest122'

    And I add a reply 'replyTest103' to comment 'commenttest104' in activity 'activityTest122'
    And I add a reply 'replyTest104' to comment 'commenttest104' in activity 'activityTest122'

    Then Comment 'commenttest101' is not displayed in activity 'activityTest122'
    And Comment 'commenttest102' is not displayed in activity 'activityTest122'
    And In activity 'activityTest122' with comment 'commenttest103', the reply 'replyTest101' is displayed
    And In activity 'activityTest122' with comment 'commenttest103', the reply 'replyTest102' is displayed
    And In activity 'activityTest122' with comment 'commenttest104', the reply 'replyTest103' is displayed
    And In activity 'activityTest122' with comment 'commenttest104', the reply 'replyTest104' is displayed

  Scenario: CAP123 - [ActivityStream_IMPV14][03]: Display maximum only the last 2 comments/replies below each activity
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user

    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activityTest123'
    And I publish the activity
    Then the activity 'activityTest123' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest123' is displayed in activity stream

    When I add in activity 'activityTest123' a comment 'commenttest101'
    And I add in activity 'activityTest123' a comment 'commenttest102'
    And I add in activity 'activityTest123' a comment 'commenttest103'
    And I add in activity 'activityTest123' a comment 'commenttest104'

    Then First comment 'commenttest103' is displayed in activity stream
    And Second comment 'commenttest104' is displayed in activity stream
    And Comment 'commenttest101' is not displayed in activity 'activityTest123'
    And Comment 'commenttest102' is not displayed in activity 'activityTest123'

    When I add a reply 'replyTest101' to comment 'commenttest103' in activity 'activityTest123'
    And I add a reply 'replyTest102' to comment 'commenttest103' in activity 'activityTest123'
    And I add a reply 'replyTest103' to comment 'commenttest103' in activity 'activityTest123'

    And I add a reply 'replyTest104' to comment 'commenttest104' in activity 'activityTest123'
    And I add a reply 'replyTest105' to comment 'commenttest104' in activity 'activityTest123'
    And I add a reply 'replyTest106' to comment 'commenttest104' in activity 'activityTest123'

    Then Comment 'commenttest101' is not displayed in activity 'activityTest123'
    And Comment 'commenttest102' is not displayed in activity 'activityTest123'
    And In activity 'activityTest123' with comment 'commenttest103', the reply 'replyTest102' is displayed
    And In activity 'activityTest123' with comment 'commenttest103', the reply 'replyTest103' is displayed
    And In activity 'activityTest123' with comment 'commenttest103', the reply 'replyTest101' is not displayed

    And In activity 'activityTest123' with comment 'commenttest104', the reply 'replyTest105' is displayed
    And In activity 'activityTest123' with comment 'commenttest104', the reply 'replyTest106' is displayed
    And In activity 'activityTest123' with comment 'commenttest104', the reply 'replyTest104' is not displayed

    When I click on View All replies related to the comment 'commenttest103' in activity stream
    Then In comment 'commenttest103', the reply 'replyTest101' is displayed in the drawer
    And In comment 'commenttest103', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest103', the reply 'replyTest103' is displayed in the drawer

    And In comment 'commenttest104', the reply 'replyTest105' is displayed in the drawer
    And In comment 'commenttest104', the reply 'replyTest106' is displayed in the drawer
    And In comment 'commenttest104', the reply 'replyTest104' is not displayed in the drawer

    When I close the comments drawer
    And I click on View All replies related to the comment 'commenttest104' in activity stream
    Then In comment 'commenttest104', the reply 'replyTest105' is displayed in the drawer
    And In comment 'commenttest104', the reply 'replyTest106' is displayed in the drawer
    And In comment 'commenttest104', the reply 'replyTest104' is displayed in the drawer

    And In comment 'commenttest103', the reply 'replyTest101' is not displayed in the drawer
    And In comment 'commenttest103', the reply 'replyTest102' is displayed in the drawer
    And In comment 'commenttest103', the reply 'replyTest103' is displayed in the drawer
    And I close the comments drawer

  Scenario: CAP157 - [ActivityStream_IMPV15][01]: Internal Link opening behaviors inside comments
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user

    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytest157'
    And I publish the activity
    Then the activity 'activitytest157' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytest157' is displayed in activity stream

    When I add in activity 'activitytest157' an internal link 'portal/meeds/spaces' as a comment
    And I open in activity 'activitytest157' the Comments drawer
    Then Internal link 'portal/meeds/spaces' is displayed in Comments drawer as a comment
    And Internal link 'portal/meeds/spaces' is displayed in activity stream as a comment

    When I click on the internal link 'portal/meeds/spaces'
    Then Space Top Bar Elements are displayed

    When I go to the created space
    And I open the internal link 'portal/meeds/spaces' in new tab
    Then The internal link 'portal/meeds/spaces' is opened in new tab

  Scenario: CAP158 - [ActivityStream_IMPV15][02]: External Link opening behaviors inside comments
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user

    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytest158'
    And I publish the activity
    Then the activity 'activitytest158' is displayed in activity stream

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytest158' is displayed in activity stream

    When I add in activity 'activitytest158' a comment 'https://www.exoplatform.com/'
    And I open in activity 'activitytest158' the Comments drawer
    Then Activity Comment 'https://www.exoplatform.com/' is displayed in Comments drawer
    And Activity Comment 'https://www.exoplatform.com/' is displayed in activity stream

    When I click on comment 'https://www.exoplatform.com/'
    Then Link 'https://www.exoplatform.com/' is opened in new tab

    When I open link 'https://www.exoplatform.com/' in new tab
    Then Link 'https://www.exoplatform.com/' is opened in new tab

  Scenario: CAP12 - [ActivityStream_US10][01]: Activity with text or link options (3 dots) (Author)
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user

    And I add the random space with registration 'Open'
    Then The created space name is displayed

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'https://www.exoplatform.com/'
    And I insert text 'activity12'
    And I publish the activity
    And I click on three dots button related to activity 'activity12'
    Then Edit button related to activity 'activity12' is displayed
    And Delete button related to activity 'activity12' is displayed
    And Copy link button related to activity 'activity12' is displayed

    When I go to Stream page
    Then The activity 'activity12' posted by the second user in the created space is displayed with its timestamp in streams page

    When I click on three dots button related to activity 'activity12'
    Then Edit button related to activity 'activity12' is displayed
    And Delete button related to activity 'activity12' is displayed
    And Copy link button related to activity 'activity12' is displayed

  Scenario: CAP13 - [ActivityStream_US10][02]: Activity with text or link options (3 dots) (Space manager)
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user
    And I create the third random user

    When I connect with the first created user

    And I add the random space with registration 'Open'
    Then The created space name is displayed

    When I connect with the second created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then The created space name is displayed

    When I connect with the third created user

    And I go to the created space to accept to join it
    And I 'Join'
    Then The created space name is displayed

    When I connect with the first created user

    And I go to the created space
    And I go to 'Members' tab
    And I promote the third user as a space manager

    And I connect with the second created user

    And I go to the created space
    And I click on post in space
    And I enter an activity 'https://www.exoplatform.com/'
    And I insert text 'activity13'
    And I publish the activity
    Then the activity 'activity13' is displayed in activity stream

    When I click on three dots button related to activity 'activity13'
    Then Delete button related to activity 'activity13' is displayed
    And Copy link button related to activity 'activity13' is displayed

    And I connect with the third created user

    And I go to the created space
    Then the activity 'activity13' is displayed in activity stream

    When I click on three dots button related to activity 'activity13'
    Then Delete button related to activity 'activity13' is displayed
    And Copy link button related to activity 'activity13' is displayed

    When I go to Stream page
    Then The activity 'activity13' posted by the second user in the created space is displayed with its timestamp in streams page

    When I click on three dots button related to activity 'activity13'
    Then Delete button related to activity 'activity13' is displayed
    And Copy link button related to activity 'activity13' is displayed

  Scenario: CAP97 - [ActivityStream_US38][01]: Delete a simple comment from the activity stream
    Given I am authenticated as
      | login    | root     |
      | password | password |

    When I create the first random user
    And I create the second random user
    And I create the third random user
    And I create the fourth random user
    And I go to groups Management page
    And I open the group 'Platform'
    And I select the group 'Administration'
    And I add the role '*' to the first created user

    When I connect with the second created user
    And I add the random space with registration 'Open'
    And I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest97'
    And I publish the activity
    Then the activity 'activityTest97' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest97' is displayed in activity stream
    When I add in activity 'activityTest97' a comment 'commenttest97'
    And I open in activity 'activityTest97' the Comments drawer
    Then Activity Comment 'commenttest97' is displayed in Comments drawer
    And Activity Comment 'commenttest97' is displayed in activity stream

    When I connect with the first created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest97' is displayed in activity stream
    And Activity Comment 'commenttest97' is displayed in activity stream

    When In activity 'activityTest97', I click on the comment 'commenttest97' three dots icon
    And In comment 'commenttest97', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'commenttest97' is not displayed in activity 'activityTest97'

  Scenario: CAP99 - [ActivityStream_US38][03]: Delete comment with replies from the activity stream
    Given I am authenticated as
      | login    | root     |
      | password | password |

    When I create the first random user
    And I create the second random user
    And I create the third random user
    And I create the fourth random user
    And I go to groups Management page
    And I open the group 'Platform'
    And I select the group 'Administration'
    And I add the role '*' to the first created user

    When I connect with the second created user
    And I add the random space with registration 'Open'
    And I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activityTest99'
    And I publish the activity
    Then the activity 'activityTest99' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest99' is displayed in activity stream
    When I add in activity 'activityTest99' a comment 'commenttest99'
    And I open in activity 'activityTest99' the Comments drawer
    Then Activity Comment 'commenttest99' is displayed in Comments drawer
    And Activity Comment 'commenttest99' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space
    Then the activity 'activityTest99' is displayed in activity stream
    And Activity Comment 'commenttest99' is displayed in activity stream
    When I add a reply 'replyTest100' to comment 'commenttest99' in activity 'activityTest99'
    Then In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest100' is displayed
    When I add a reply 'replyTest101' to comment 'commenttest99' in activity 'activityTest99'
    Then In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest101' is displayed
    When I add a reply 'replyTest102' to comment 'commenttest99' in activity 'activityTest99'
    Then In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest102' is displayed

    When I connect with the first created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest99' is displayed in activity stream
    And Activity Comment 'commenttest99' is displayed in activity stream
    And In activity 'activityTest99' with comment 'commenttest99', the reply 'replyTest100' is displayed
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
    Given I am authenticated as
      | login    | root     |
      | password | password |

    When I create the first random user
    And I create the second random user
    And I create the third random user
    And I create the fourth random user
    And I create the fifth random user
    And I create the sixth random user

    And I connect with the first created user
    And I add the random space with registration 'Open' with the fifth user
    And I click on post in space
    And I enter an activity 'activityTest155'
    And I publish the activity
    Then the activity 'activityTest155' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest155' is displayed in activity stream

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest155' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest155' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    Then the activity 'activityTest155' is displayed in activity stream

    When I click on comment button related to activity 'activityTest155'
    And I enter a comment 'comTest' with mentioning the first user
    Then First User is mentioned in the comment

    When I enter a comment 'comTest' with mentioning the third user
    Then Third User is mentioned in the comment

    When I enter a comment 'comTest' with mentioning the fourth user
    Then Fourth User is mentioned in the comment

    When I enter a comment 'comTest' with mentioning the fifth user
    Then Fifth User is not mentioned in the comment

    When I enter a comment 'comTest' with mentioning the sixth user
    Then Sixth User is not mentioned in the comment
    And I close the comments drawer

  Scenario: Cap146 - [ActivityStream_US40][01 ]: Notifications for comments to my activity
    Given I am authenticated as
      | login    | root     |
      | password | password |

    When I create the first random user
    And I create the second random user

    And I connect with the first created user
    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activityTest146'
    And I publish the activity
    Then the activity 'activityTest146' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
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

  Scenario: Cap147 - [ActivityStream_US40][02]: Notifications for comment to my comment
    Given I am authenticated as
      | login    | root     |
      | password | password |

    When I create the first random user
    And I create the second random user

    And I connect with the first created user
    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activityTest147'
    And I publish the activity
    Then the activity 'activityTest147' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activityTest147' is displayed in activity stream
    When I add in activity 'activityTest147' a comment 'commenttest147'
    And I open in activity 'activityTest147' the Comments drawer
    Then Activity Comment 'commenttest147' is displayed in Comments drawer
    And Activity Comment 'commenttest147' is displayed in activity stream

    When I connect with the first created user
    And I go to the created space
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

  Scenario: CAP20 - [ActivityStream_US10][09]: Activity with text or link options (3 dots) (Author delete the post)
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user
    And I add the random space with registration 'Open'

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
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

  Scenario: CAP21 - [ActivityStream_US10][10]: Activity with text or link options (3 dots) ( Author cancel delete post)
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user
    And I add the random space with registration 'Open'

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
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

  Scenario: CAP87 - [ActivityStream_US04][01]: Edit comment in Activity stream
    Given I am authenticated as
      | login    | root     |
      | password | password |

    And I create the first random user
    And I create the second random user
    And I create the third random user
    And I create the fourth random user

    When I connect with the first created user
    And I add the random space with registration 'Open'

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activitycap87'
    And I publish the activity
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest101'
    And I open in activity 'activitycap87' the Comments drawer
    Then Activity Comment 'commenttest101' is displayed in Comments drawer
    And Activity Comment 'commenttest101' is displayed in activity stream

    When I connect with the first created user
    And I go to the created space
    Then the activity 'activitycap87' is displayed in activity stream
    When I add in activity 'activitycap87' a comment 'commenttest102'
    And I add a reply 'replyTest102' to comment 'commenttest102' in activity 'activitycap87'
    Then In activity 'activitycap87' with comment 'commenttest102', the reply 'replyTest102' is displayed

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitycap87' is displayed in activity stream
    When I add in activity 'activitycap87' a comment 'commenttest103'
    And I add a reply 'replyTest103' to comment 'commenttest103' in activity 'activitycap87'
    Then In activity 'activitycap87' with comment 'commenttest103', the reply 'replyTest103' is displayed

    When I connect with the fourth created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitycap87' is displayed in activity stream

    When In activity 'activitycap87' I enter the link 'https://www.exoplatform.com/' as comment
    And I insert text 'commenttest104' as comment
    And I publish the comment
    And I open in activity 'activitycap87' the Comments drawer
    Then Comment 'https://www.exoplatform.com/commenttest104' is displayed in comments drawer at the sixth position

    When I add a reply 'replyTest104' to comment 'commenttest104' in activity 'activitycap87'
    Then In activity 'activitycap87' with comment 'commenttest104', the reply 'replyTest104' is displayed

    When In activity 'activitycap87', I click on the comment 'commenttest104' three dots icon
    And In comment 'commenttest104', I click on edit button
    And I insert text 'commenttestupdated104' as comment
    And I click on update comment
    And I open in activity 'activitycap87' the Comments drawer
    Then Comment 'commenttestupdated104https://www.exoplatform.com/commenttest104' is displayed in comments drawer at the sixth position

  Scenario: CAP88 - [ActivityStream_US04.1][01]: Edit comment from the comment drawer
    Given I am authenticated as
      | login    | root     |
      | password | password |

    And I create the first random user
    And I create the second random user
    And I create the third random user
    And I create the fourth random user

    When I connect with the first created user
    And I add the random space with registration 'Open'

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activitycap87'
    And I publish the activity
    Then the activity 'activitycap87' is displayed in activity stream
    When I add in activity 'activitycap87' a comment 'commenttest101'
    And I open in activity 'activitycap87' the Comments drawer
    Then Activity Comment 'commenttest101' is displayed in Comments drawer
    And Activity Comment 'commenttest101' is displayed in activity stream

    When I connect with the first created user
    And I go to the created space
    Then the activity 'activitycap87' is displayed in activity stream
    When I add in activity 'activitycap87' a comment 'commenttest102'
    And I add a reply 'replyTest102' to comment 'commenttest102' in activity 'activitycap87'
    Then In activity 'activitycap87' with comment 'commenttest102', the reply 'replyTest102' is displayed

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitycap87' is displayed in activity stream
    When I add in activity 'activitycap87' a comment 'commenttest103'
    And I add a reply 'replyTest103' to comment 'commenttest103' in activity 'activitycap87'
    Then In activity 'activitycap87' with comment 'commenttest103', the reply 'replyTest103' is displayed

    When I connect with the fourth created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitycap87' is displayed in activity stream
    When I add in activity 'activitycap87' a comment 'commenttest104'
    And I add a reply 'replyTest104' to comment 'commenttest104' in activity 'activitycap87'
    And In activity 'activitycap87' with comment 'commenttest104', the reply 'replyTest104' is displayed
    And I click on View all X comments
    And I click on the comment 'commenttest104' three dots icon from comments drawer
    And In comment 'commenttest104', I click on edit button from comments drawer
    And I insert text 'updated' as comment
    Then I click on update comment
    And I open in activity 'activitycap87' the Comments drawer
    Then Comment 'updatedcommenttest104' is displayed in comments drawer at the sixth position


  Scenario: [ActivityStream_US32][02]: space note page
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the first random user
    And I create the second random user
    When I connect with the first created user

    And I create the space community
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab

    When I add note with title 'Long Name Long Name Long Name Long Name Long Name Long Name Long Name' and content 'Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content'
    And I save and post Note
    Then Note tile 'Long Name Long Name Long Name Long Name Long Name Long Name Long Name' and content 'Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content Long Content' are displayed successfully

    When I go to Stream page
    Then the activity 'Long Name Long Name Long Name Long Name Long Name Long Name Long Name' is displayed in activity stream

  Scenario: CAP128 - [ActivityStream_US47][01]: Send a kudos from a comment

    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I connect with the first created user
    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytestkudos'
    And I publish the activity
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I add in activity 'activitytestkudos' a comment 'activitytestkudoscomment'
    And I open in activity 'activitytestkudos' the Comments drawer
    Then Activity Comment 'activitytestkudoscomment' is displayed in Comments drawer
    And Activity Comment 'activitytestkudoscomment' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    When In comment 'activitytestkudoscomment', Kudos label should be black
    Then I click on the kudos button from the comment
    And I sent to the comment activity a kudos message 'Test Auto comment Kudos'
    Then In comment 'activitytestkudoscomment', the Kudos label should be blue
    And I click on the kudos button number
    Then '1' kudos are displayed on the reaction drawer

  Scenario: CAP129 - [ActivityStream_US47][03]: Send a kudos from the comments drawer

    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I connect with the first created user
    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytestkudos'
    And I publish the activity
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    When I add in activity 'activitytestkudos' a comment 'activitytestkudoscomment'
    And Activity Comment 'activitytestkudoscomment' is displayed in activity stream
    And I open in activity 'activitytestkudos' the Comments drawer
    Then Activity Comment 'activitytestkudoscomment' is displayed in Comments drawer

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    And I open in activity 'activitytestkudos' the Comments drawer
    When In comment 'activitytestkudoscomment', Kudos label should be black
    Then I click on the kudos button from the comments drawer
    And I sent to the comment activity a kudos message 'Test Auto comment Kudos' from comments drawer
    Then In comment 'activitytestkudoscomment', the Kudos label should be blue
    And I click on the kudos button number from the comments drawer
    And I close the comments drawer
    Then '1' kudos are displayed on the reaction drawer


  Scenario: CAP220 - [ActivityStream_IMPV07][01]: Pagination in comments drawer
    Given I am authenticated as
      | login    | root     |
      | password | password |

    And I create the first random user
    And I create the second random user

    When I connect with the first created user
    And I add the random space with registration 'Open'
    And I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activitycap87'
    And I publish the activity
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest101'
    And I add in activity 'activitycap87' a comment 'commenttest102'
    And I add a reply 'replyTest102' to comment 'commenttest102' in activity 'activitycap87'
    And I add a reply 'replyTest103' to comment 'commenttest102' in activity 'activitycap87'
    And I add a reply 'replyTest104' to comment 'commenttest102' in activity 'activitycap87'
    And I add in activity 'activitycap87' a comment 'commenttest103'
    And I add in activity 'activitycap87' a comment 'commenttest104'
    And I add in activity 'activitycap87' a comment 'commenttest105'
    And I add in activity 'activitycap87' a comment 'commenttest106'
    And I add in activity 'activitycap87' a comment 'commenttest107'
    And I add in activity 'activitycap87' a comment 'commenttest108'
    And I add in activity 'activitycap87' a comment 'commenttest109'
    And I add in activity 'activitycap87' a comment 'commenttest1010'
    And I add in activity 'activitycap87' a comment 'commenttest1011'
    And I add in activity 'activitycap87' a comment 'commenttest1012'
    And I add in activity 'activitycap87' a comment 'commenttest1013'
    And I add in activity 'activitycap87' a comment 'commenttest1014'
    And I add in activity 'activitycap87' a comment 'commenttest1015'
    And I add in activity 'activitycap87' a comment 'commenttest1016'
    And I add in activity 'activitycap87' a comment 'commenttest1017'
    And I add in activity 'activitycap87' a comment 'commenttest1018'
    And I add in activity 'activitycap87' a comment 'commenttest1019'
    And I add in activity 'activitycap87' a comment 'commenttest1020'
    And I add in activity 'activitycap87' a comment 'commenttest1021'
    And I add in activity 'activitycap87' a comment 'commenttest1022'
    And I add in activity 'activitycap87' a comment 'commenttest1023'
    And I add in activity 'activitycap87' a comment 'commenttest1024'
    And I click on comment button related to activity 'activitycap87'
    Then Activity Comment 'commenttest1021' is displayed in Comments drawer

    When I click on comment button related to activity 'activitycap87'
    And I go to the comments drawer first page
    And Comment 'commenttest1011' is not displayed in the drawer
    Then Check Ten comment is displayed in comments drawer

    When I click on comment button related to activity 'activitycap87'
    And I go to the comments drawer second page
    And Comment 'commenttest1010' is not displayed in the drawer
    And Comment 'commenttest1021' is not displayed in the drawer
    Then Check Ten comment is displayed in comments drawer

    When I click on comment button related to activity 'activitycap87'
    And Comment 'commenttest1020' is not displayed in the drawer
    Then Check Four comment is displayed in comments drawer

  Scenario: CAP129 - [ActivityStream_US47][02]: Send a kudos from a replay

    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create the second random user
    And I create the third random user
    And I create the fourth random user

    And I connect with the first created user
    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytestkudos'
    And I publish the activity
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I add in activity 'activitytestkudos' a comment 'activitytestkudoscomment'
    And I open in activity 'activitytestkudos' the Comments drawer
    Then Activity Comment 'activitytestkudoscomment' is displayed in Comments drawer
    And Activity Comment 'activitytestkudoscomment' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    When I add a reply 'activitytestkudoscommentreplay' to comment 'activitytestkudoscomment' in activity 'activitytestkudos'
    Then In activity 'activitytestkudos' with comment 'activitytestkudoscomment', the reply 'activitytestkudoscommentreplay' is displayed

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    And In replay 'activitytestkudoscommentreplay', Kudos label should be black
    When In replay 'activitytestkudoscommentreplay', I click on kudos button
    And I sent to the comment activity a kudos message 'Test Auto replay Kudos'
    Then In replay 'activitytestkudoscommentreplay', the Kudos label should be blue
    When I click on the kudos button number
    Then '1' kudos are displayed on the reaction drawer

  Scenario: CAP89 - [ActivityStream_US04][03]: Edit reply in Activity stream
    Given I am authenticated as
      | login    | root     |
      | password | password |

    And I create the first random user
    And I create the second random user
    And I create the third random user
    And I create the fourth random user

    When I connect with the first created user
    And I add the random space with registration 'Open'

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    And I click on post in space
    And I enter an activity 'activitycap87'
    And I publish the activity
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest101'
    And I click on comment button related to activity 'activitycap87'
    Then Activity Comment 'commenttest101' is displayed in Comments drawer
    And Activity Comment 'commenttest101' is displayed in activity stream

    When I connect with the first created user
    And I go to the created space
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest102'
    And I click on comment button related to activity 'activitycap87'
    Then Second comment 'commenttest102' is displayed in comments drawer

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitycap87' is displayed in activity stream

    When I add in activity 'activitycap87' a comment 'commenttest103'
    And I click on comment button related to activity 'activitycap87'
    Then Third comment 'commenttest103' is displayed in comments drawer

    When I connect with the fourth created user
    And I go to the created space to accept to join it
    And I 'Join'
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

  Scenario: [ActivityStream_US52][03]: Edit a kudos from a comment
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create the second random user
    And I create the third random user

    And I connect with the first created user
    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytestkudos'
    And I publish the activity
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I add in activity 'activitytestkudos' a comment 'activitytestkudoscomment'
    And I open in activity 'activitytestkudos' the Comments drawer
    Then Activity Comment 'activitytestkudoscomment' is displayed in Comments drawer
    And Activity Comment 'activitytestkudoscomment' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    When In comment 'activitytestkudoscomment', Kudos label should be black
    And I click on the kudos button from the comment
    And I sent to the comment activity a kudos message 'Test Auto comment Kudos'
    And I click to edit the kudos text
    And I set the new kudos comment text 'updated kudos message ' and I click on update button
    Then the updated Kudos activity 'updated kudos message ' is displayed in stream page

  Scenario: [ActivityStream_US52][05]: Edit a kudos from a reply
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create the second random user
    And I create the third random user
    And I create the fourth random user

    And I connect with the first created user
    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytestkudos'
    And I publish the activity
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I connect with the third created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I add in activity 'activitytestkudos' a comment 'activitytestkudoscomment'
    And I open in activity 'activitytestkudos' the Comments drawer
    Then Activity Comment 'activitytestkudoscomment' is displayed in Comments drawer
    And Activity Comment 'activitytestkudoscomment' is displayed in activity stream

    When I connect with the fourth created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    When I add a reply 'activitytestkudoscommentreplay' to comment 'activitytestkudoscomment' in activity 'activitytestkudos'
    Then In activity 'activitytestkudos' with comment 'activitytestkudoscomment', the reply 'activitytestkudoscommentreplay' is displayed

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    And In replay 'activitytestkudoscommentreplay', Kudos label should be black

    When In replay 'activitytestkudoscommentreplay', I click on kudos button
    And I sent to the comment activity a kudos message 'Test Auto replay Kudos'
    Then In replay 'activitytestkudoscommentreplay', the Kudos label should be blue

    When I click to edit the kudos from a reply comment
    And I set the new kudos comment text 'updated kudos message ' and I click on update button
    Then the updated Kudos activity 'updated kudos message ' is displayed in stream page

  Scenario: CAP132 - [ActivityStream_US52][01]: Edit a kudos comment from an activity
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I create the second random user

    And I connect with the first created user
    And I add the random space with registration 'Open'
    And I click on post in space
    And I enter an activity 'activitytestkudos'
    And I publish the activity
    Then the activity 'activitytestkudos' is displayed in activity stream

    When I connect with the second created user
    And I go to the created space to accept to join it
    And I 'Join'
    Then the activity 'activitytestkudos' is displayed in activity stream
    Then I click on the kudos button from the Activity Stream
    And I sent to the comment activity a kudos message 'Test Auto replay Kudos'
    Then In activity 'activitytestkudos', I click on the comment 'Test Auto replay Kudos' three dots icon
    When In comment 'Test Auto replay Kudos', I click on edit button
    And I set the new kudos comment text 'updated Test Auto replay Kudos' and I click on update button
    Then the updated Kudos activity 'updated Test Auto replay Kudos' is displayed in stream page
