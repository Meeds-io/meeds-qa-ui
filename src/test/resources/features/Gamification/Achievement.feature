@gamification
@achievements
Feature: Achievements

  Scenario: Achievements for Send/Cancel Kudos from the activity author
    Given I am authenticated as 'admin' random user
    And I inject the random space if not existing
    And I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter the program title 'Achievements program'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Send kudos'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Send kudos' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Send kudos' is displayed in program detail

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive kudos'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Receive kudos' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Receive kudos' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I inject the fisrtachievement random user if not existing, no wait
    And I inject the secondachievement random user if not existing, no wait
    And I login as 'secondachievement' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Achievements - Kudos Post activity'
    And I publish the activity

    And I login as 'fisrtachievement' random user

    And I go to My Profile page
    Then I check my points

    When I go to the random space
    And I send in the activity 'Achievements - Kudos Post activity' a kudos message 'Achievements - kudos activity comment to cancel'

    And I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Send kudos' is accepted

    When I go to My Profile page
    Then My points augmented

    And I go to the random space
    And I open in activity 'Achievements - Kudos Post activity' the Comments drawer
    When In activity 'Achievements - Kudos Post activity' I cancel the sent kudos comment 'Achievements - kudos activity comment to cancel'

    And I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Send kudos' is canceled

    When I login as 'secondachievement' random user
    And I go to 'achievements' in site 'mycraft'
    And Achievement for 'Receive kudos' is canceled

  Scenario: Achievements for Send/Cancel Kudos from user profile
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter the program title 'Achievements program'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Send kudos'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Send kudos' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Send kudos' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive kudos'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Receive kudos' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Receive kudos' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I inject the thirdachievement random user if not existing, no wait
    And I inject the fourachievement random user if not existing

    When I login as 'fourachievement' random user
    When I go to the random space

    When I login as 'thirdachievement' random user
    When I go to the random space
    And I go to the fourachievement user profile
    And I send kudos with message 'Achievements - Kudos Post activity to cancel'

    And I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Send kudos' is accepted

    And I go to Stream page
    When I cancel the sent kudos activity 'Achievements - Kudos Post activity to cancel'

    And I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Send kudos' is canceled

    When I login as 'fourachievement' random user
    And I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Receive kudos' is canceled

  Scenario: Achievements listing for program owner/space host
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the fifthachievement random user, no wait
    And I inject the sixthachievement random user, no wait

    When I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter the random program title 'Test Program Host'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Join space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Join space' event
    And I click on 'Next' button in drawer

    Then The button 'Duration' is not displayed in drawer

    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Join space' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I login as 'fifthachievement' random user
    And I go to the random space
    And I go to 'programs' in site 'contribute'
    When I open 'Test Program Host' random program card
    Then Actions Filter dropdown is displayed
    And Admin Actions Filter dropdown is not displayed
    When I open 'Join space' achivements drawer from program detail
    Then In drawer, user 'fifthachievement' achievement is display 'first'

    When I close the opened drawer
    And I login as 'sixthachievement' random user
    And I go to the random space
    And I go to 'programs' in site 'contribute'
    When I open 'Test Program Host' random program card
    Then Actions Filter dropdown is displayed
    And Admin Actions Filter dropdown is not displayed

    When I login as 'admin' random user
    And I go to 'achievements' in site 'mycraft'

    Then The achievement 'Join space' is displayed '2' times when enabling program owner view for 'Test Program Host' random program

    When I go to the random space
    And I click on 'Members' space menu tab
    And I promote 'fifthachievement' random user as a space manager

    When I login as 'sixthachievement' random user
    And I go to 'achievements' in site 'mycraft'
    Then The achievement 'Join space' is displayed '1' times
    And The button 'Review' is not displayed

    When I login as 'fifthachievement' random user
    And I go to 'programs' in site 'contribute'

    When I open 'Test Program Host' random program card
    Then Actions Filter dropdown is displayed
    And Admin Actions Filter dropdown is displayed

    When I open 'Join space' achivements drawer from program detail
    And In drawer, user 'sixthachievement' achievement is display 'first'
    Then In drawer, user 'fifthachievement' achievement is display 'second'

    When I close the opened drawer
    And I go to 'achievements' in site 'mycraft'
    And I filter achievements using 'Test Program Host' random program
    Then The achievement 'Join space' is displayed '1' times
    And The button 'Review' is displayed

    Then The achievement 'Join space' is displayed '2' times when enabling program owner view for 'Test Program Host' random program

  Scenario: Achievements sort
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the 'ninethachievement' random user, no wait
    And I inject the 'tenthachievement' random user, no wait

    When I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter the random program title 'Test Program Achievements sort'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Join space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Join space' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer
    And I close the notification

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Announce an achievement'
    And I select a 'Let them submit their contribution' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer
    And I close the notification

    When I click on 'Activate the program' button
    And I close the notification

    When I login as 'ninethachievement' random user
    And I go to the random space
    And I go to 'programs' in site 'contribute'
    When I open 'Test Program Achievements sort' random program card
    And I announce challenge 'Announce an achievement' with message 'announcement1'
    And I click on 'See' link

    Then The comment 'announcement1' is displayed in Comments drawer

    When I open in activity 'Announce an achievement' the Comments drawer
    And I click on the first comment 'announcement1' three dots icon from comments drawer
    And I click on 'Cancel' button related to comment 'announcement1'
    And I click on Yes button

    When I login as 'tenthachievement' random user
    And I go to the random space
    And I go to 'programs' in site 'contribute'
    When I open 'Test Program Achievements sort' random program card
    And I announce challenge 'Announce an achievement' with message 'announcement2'

    When I go to 'achievements' in site 'mycraft'
    When I filter achievements using 'Test Program Achievements sort' random program
    And Current user achievement 'Announce an achievement' is displayed 'first'
    And Current user achievement 'Join space' is displayed 'second'

    When I login as 'admin' random user
    And I go to 'achievements' in site 'mycraft'

    When I click on 'Review' button
    Then I wait for application loading

    When I filter achievements using 'Test Program Achievements sort' random program
    And I wait for application loading

    Then Achievement 'Announce an achievement' of user 'tenthachievement' is displayed 'first'
    And Achievement 'Join space' of user 'tenthachievement' is displayed 'second'
    And Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'third'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'fourth'

    When I sort table by 'Date'
    And I wait for application loading

    Then Achievement 'Join space' of user 'ninethachievement' is displayed 'first'
    And Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'second'
    And Achievement 'Join space' of user 'tenthachievement' is displayed 'third'
    And Achievement 'Announce an achievement' of user 'tenthachievement' is displayed 'fourth'

    When I sort table by 'Status'
    And I wait for application loading

    Then Achievement 'Join space' of user 'tenthachievement' is displayed 'first'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'second'
    And Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'third'
    And Achievement 'Announce an achievement' of user 'tenthachievement' is displayed 'fourth'

    When I sort table by 'Status'
    And I wait for application loading

    Then Achievement 'Announce an achievement' of user 'tenthachievement' is displayed 'first'
    And Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'second'
    And Achievement 'Join space' of user 'tenthachievement' is displayed 'third'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'fourth'

    When I filter achievements using 'ninethachievement' random user
    Then Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'first'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'second'

  Scenario: Cancel Activity changes the Achievement as Rejected
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the seventhachievement random user if not existing, no wait

    And I go to 'programs' in site 'contribute'

    And I click on the button add program
    And I enter the program title 'Activity Post Achievement Reject'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Post activity in a space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Add a Post' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Post activity in a space' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I login as 'seventhachievement' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Activity to cancel'
    And I publish the activity
    Then the activity 'Activity to cancel' is displayed in activity stream

    When I click to delete from the dropdownActivitymenu
    And I click on Yes button
    Then the confirmation popup is not displayed
    And the activity 'Activity to cancel' is no more displayed in the activity stream
    When I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Post activity in a space' is rejected due to activity deletion

  Scenario: Cancel Comment changes the Achievement as Rejected
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the seventhachievement random user if not existing, no wait

    And I go to 'programs' in site 'contribute'

    And I click on the button add program
    And I enter the program title 'Comment Post Achievement Reject'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Comment activity in space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Comment a Post' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Comment activity in space' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive comment activity in space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Receive a Comment' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Receive comment activity in space' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I login as 'seventhachievement' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Activity with comment to cancel'
    And I publish the activity
    Then the activity 'Activity with comment to cancel' is displayed in activity stream
    When I add in activity 'Activity with comment to cancel' a comment 'comment to delete'
    And I open in activity 'Activity with comment to cancel' the Comments drawer
    And I click on the comment 'comment to delete' three dots icon from comments drawer
    And In comment 'comment to delete', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And The comment 'comment to delete' is not displayed in Comments drawer of activity 'Activity with comment to cancel'

    When I go to 'achievements' in site 'mycraft'

    Then Achievement for 'Comment activity in space' is rejected due to activity deletion
    And Achievement for 'Receive comment activity in space' is rejected due to activity deletion

  Scenario: Cancel Like Stream Activity changes the Achievement as Canceled
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the seventhachievement random user if not existing, no wait

    And I go to 'programs' in site 'contribute'

    And I click on the button add program
    And I enter the program title 'Like Activity Achievement Reject'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Like activity in space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Like a Post' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Like activity in space' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive activity like in space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Receive a Like' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Receive activity like in space' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I login as 'seventhachievement' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Activity to like + unlike'
    And I publish the activity
    Then the activity 'Activity to like + unlike' is displayed in activity stream

    When I login as 'admin' random user
    And I go to the random space
    And I like the activity 'Activity to like + unlike'
    And I wait for '1' seconds
    And I unlike the activity 'Activity to like + unlike'

    When I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Like activity in space' is canceled

    When I login as 'seventhachievement' random user
    And I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Receive activity like in space' is canceled

  Scenario: Cancel Like Stream Comment changes the Achievement as Canceled
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the seventhachievement random user if not existing, no wait

    And I go to 'programs' in site 'contribute'

    And I click on the button add program
    And I enter the program title 'Like Stream Comment Achievement Reject'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Like stream comment in space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Like a Comment' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Like stream comment in space' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive Like on stream comment in space'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Receive a Like on a Comment' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Receive Like on stream comment in space' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I login as 'seventhachievement' random user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Activity with comment to like + unlike'
    And I publish the activity
    Then the activity 'Activity with comment to like + unlike' is displayed in activity stream

    When I add in activity 'Activity with comment to like + unlike' a comment 'comment to unlike'

    When I login as 'admin' random user
    And I go to the random space
    And I open in activity 'Activity with comment to like + unlike' the Comments drawer
    And I like the activity comment 'comment to unlike'
    And I wait for '1' seconds
    And I unlike the activity comment 'comment to unlike'

    When I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Like stream comment in space' is canceled

    When I login as 'seventhachievement' random user
    And I go to 'achievements' in site 'mycraft'
    Then Achievement for 'Receive Like on stream comment in space' is canceled

  Scenario: Cancel Space Join changes the Achievement as Canceled
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the eighthachievement random user if not existing, no wait

    When I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter the program title 'Cancel Space Join Program'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Space Join'
    And I select a 'Boost collaboration' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I select a 'Join space' event
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I select 'Accepted' as default contribution status
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Space Join' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I login as 'eighthachievement' random user
    And I go to the random space
    And I go to 'achievements' in site 'mycraft'

    Then Achievement for 'Space Join' is accepted

    And I go to spaces page
    And I search for the random space
    And I leave found space
    And I go to 'achievements' in site 'mycraft'

    Then Achievement for 'Space Join' is canceled
