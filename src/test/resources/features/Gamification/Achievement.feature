@gamification
@achievements
Feature: Achievements

  Scenario: Achievements for Send/Cancel Kudos from the activity author
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to 'Contributions' application

    When I select engagement Programs tab
    And I click on the button add program
    And I enter the program title 'Achievements program'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Send kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer

    Then The button 'Next' is disabled in drawer

    When I add an event 'Send kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Send kudos' is displayed in program detail

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Receive kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Receive kudos' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I create the fisrtachievement random user if not existing, no wait
    And I create the secondachievement random user if not existing, no wait

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

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is accepted

    When I go to My Profile page
    Then The following items are displayed
      | Weekly points |
      | Weekly rank   |
    And My points augmented

    And I go to the random space
    When In activity 'Achievements - Kudos Post activity' I cancel the sent kudos comment 'Achievements - kudos activity comment to cancel'
    And I refresh the page

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is canceled

    When I login as 'secondachievement' random user
    And I go to 'Contributions' application
    And I select engagement Achievements tab
    And Achievement for 'Receive kudos' is canceled

  Scenario: Achievements for Send/Cancel Kudos from user profile
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to 'Contributions' application
    When I select engagement Programs tab
    And I click on the button add program
    And I enter the program title 'Achievements program'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Send kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Send kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Send kudos' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Receive kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Receive kudos' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I create the thirdachievement random user if not existing, no wait
    And I create the fourachievement random user if not existing

    When I login as 'fourachievement' random user
    When I go to the random space

    When I login as 'thirdachievement' random user
    When I go to the random space
    And I go to the fourachievement user profile
    And I send kudos with message 'Achievements - Kudos Post activity to cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is accepted

    And I go to Stream page
    When I cancel the sent kudos activity 'Achievements - Kudos Post activity to cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is canceled

    When I login as 'fourachievement' random user
    And I go to 'Contributions' application
    And I select engagement Achievements tab
    Then Achievement for 'Receive kudos' is canceled

  Scenario: Achievements listing for program owner/space host
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I create the fifthachievement random user if not existing, no wait
    And I create the sixthachievement random user if not existing, no wait

    When I go to 'Contributions' application
    And I select engagement Programs tab
    And I click on the button add program
    And I enter the random program title 'Test Program Host'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Join space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Join space'
    And I click on 'Next' button in drawer

    Then The button 'Duration' is not displayed in drawer

    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Join space' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I login as 'fifthachievement' random user
    And I go to the random space
    And I go to 'Contributions' application
    When I open 'Test Program Host' random program card
    Then Actions Filter dropdown is displayed
    And Admin Actions Filter dropdown is not displayed
    When I open 'Join space' achivements drawer from program detail
    Then In drawer, user 'fifthachievement' achievement is display 'first'

    When I close the opened drawer
    And I login as 'sixthachievement' random user
    And I go to the random space
    And I go to 'Contributions' application
    When I open 'Test Program Host' random program card
    Then Actions Filter dropdown is displayed
    And Admin Actions Filter dropdown is not displayed

    When I login as 'admin' random user
    And I go to 'Contributions' application
    And I select engagement Achievements tab

    Then The achievement 'Join space' is displayed '2' times when enabling program owner view for 'Test Program Host' random program

    When I go to the random space
    And I click on 'Members' space menu tab
    And I search for 'fifthachievement' random user
    And I click on three dots menu
    And I set as a space manager

    When I login as 'sixthachievement' random user
    And I go to 'Contributions' application
    And I select engagement Achievements tab
    Then The achievement 'Join space' is displayed '1' times
    And The button 'Hosted' is not displayed

    When I login as 'fifthachievement' random user
    And I go to 'Contributions' application

    When I open 'Test Program Host' random program card
    Then Actions Filter dropdown is displayed
    And Admin Actions Filter dropdown is displayed

    When I open 'Join space' achivements drawer from program detail
    And In drawer, user 'sixthachievement' achievement is display 'first'
    Then In drawer, user 'fifthachievement' achievement is display 'second'

    When I close the opened drawer
    And I select engagement Achievements tab
    And I filter achievements using 'Test Program Host' random program
    Then The achievement 'Join space' is displayed '1' times
    And The button 'Hosted' is displayed

    Then The achievement 'Join space' is displayed '2' times when enabling program owner view for 'Test Program Host' random program

  Scenario: Achievements sort
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I inject the 'ninethachievement' random user if not existing, no wait
    And I inject the 'tenthachievement' random user if not existing, no wait

    When I go to 'Contributions' application
    And I click on the button add program
    And I enter the random program title 'Test Program Achievements sort'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Join space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Join space'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer
    And I close the notification

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Announce an achievement'
    And I add rule random description
    And I click on 'Declarative' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer
    And I close the notification

    When I click on 'Activate the program' button
    And I close the notification

    When I login as 'ninethachievement' random user
    And I go to the random space
    And I go to 'Contributions' application
    When I open 'Test Program Achievements sort' random program card
    And I announce challenge 'Announce an achievement'
    And I click on 'See' link

    Then The activity 'Announce an achievement' is displayed
    When I cancel the announcement challenge 'Announce an achievement'

    And I login as 'tenthachievement' random user
    And I go to the random space
    And I go to 'Contributions' application
    When I open 'Test Program Achievements sort' random program card
    And I announce challenge 'Announce an achievement'

    When I select engagement Achievements tab
    And Current user achievement 'Announce an achievement' is displayed 'first'
    And Current user achievement 'Join space' is displayed 'second'

    When I login as 'admin' random user
    And I go to 'Contributions' application
    And I select engagement Achievements tab

    When I click on 'Hosted' button
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

    When I sort table by 'Type'
    And I wait for application loading

    Then Achievement 'Join space' of user 'tenthachievement' is displayed 'first'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'second'
    And Achievement 'Announce an achievement' of user 'tenthachievement' is displayed 'third'
    And Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'fourth'

    When I sort table by 'Type'
    And I wait for application loading

    Then Achievement 'Announce an achievement' of user 'tenthachievement' is displayed 'first'
    And Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'second'
    And Achievement 'Join space' of user 'tenthachievement' is displayed 'third'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'fourth'

    When I sort table by 'Status'
    And I wait for application loading

    Then Achievement 'Announce an achievement' of user 'tenthachievement' is displayed 'first'
    And Achievement 'Join space' of user 'tenthachievement' is displayed 'second'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'third'
    And Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'fourth'

    When I sort table by 'Status'
    And I wait for application loading

    Then Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'first'
    And Achievement 'Announce an achievement' of user 'tenthachievement' is displayed 'second'
    And Achievement 'Join space' of user 'tenthachievement' is displayed 'third'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'fourth'

    When I filter achievements using 'ninethachievement' random user
    Then Achievement 'Announce an achievement' of user 'ninethachievement' is displayed 'first'
    And Achievement 'Join space' of user 'ninethachievement' is displayed 'second'

  Scenario: Cancel Activity changes the Achievement as Rejected
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I create the seventhachievement random user if not existing, no wait

    And I go to 'Contributions' application
    And I select engagement Programs tab

    And I click on the button add program
    And I enter the program title 'Activity Post Achievement Reject'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Post activity in a space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Activity Stream (space) : Post activity'
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

    When I go to 'Contributions' application
    And I select engagement Achievements tab

    Then Achievement for 'Post activity in a space' is rejected

  Scenario: Cancel Comment changes the Achievement as Rejected
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I create the seventhachievement random user if not existing, no wait

    And I go to 'Contributions' application
    And I select engagement Programs tab

    And I click on the button add program
    And I enter the program title 'Comment Post Achievement Reject'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Comment activity in space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Activity Stream (space) : Comment activity'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Comment activity in space' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive comment activity in space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Activity Stream (space) : Receive comment'
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
    And In activity 'Activity with comment to cancel', I click on the comment 'comment to delete' three dots icon
    And In comment 'comment to delete', I click on delete button
    And I click on Yes button
    Then the confirmation popup is not displayed
    And Comment 'comment to delete' is not displayed in activity 'Activity with comment to cancel'

    When I go to 'Contributions' application
    And I select engagement Achievements tab

    Then Achievement for 'Comment activity in space' is rejected
    And Achievement for 'Receive comment activity in space' is rejected

  Scenario: Cancel Like Stream Activity changes the Achievement as Canceled
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I create the seventhachievement random user if not existing, no wait

    And I go to 'Contributions' application
    And I select engagement Programs tab

    And I click on the button add program
    And I enter the program title 'Like Activity Achievement Reject'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Like activity in space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Activity Stream (space) : Like activity'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Like activity in space' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive activity like in space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Activity Stream (space) : Receive like'
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

    When I like the activity 'Activity to like + unlike'
    And I wait for '1' seconds
    And I unlike the activity 'Activity to like + unlike'

    When I go to 'Contributions' application
    And I select engagement Achievements tab

    Then Achievement for 'Receive activity like in space' is canceled
    And Achievement for 'Like activity in space' is canceled

  Scenario: Cancel Like Stream Comment changes the Achievement as Canceled
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I create the seventhachievement random user if not existing, no wait

    And I go to 'Contributions' application
    And I select engagement Programs tab

    And I click on the button add program
    And I enter the program title 'Like Stream Comment Achievement Reject'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    When I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Like stream comment in space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Activity Stream : Like comment in space'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Like stream comment in space' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive Like on stream comment in space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Activity Stream : Receive like comment in space'
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

    When I like the activity comment 'comment to unlike'
    And I wait for '1' seconds
    And I unlike the activity comment 'comment to unlike'

    When I go to 'Contributions' application
    And I select engagement Achievements tab

    Then Achievement for 'Receive Like on stream comment in space' is canceled
    Then Achievement for 'Like stream comment in space' is canceled

  Scenario: Cancel Space Join changes the Achievement as Canceled
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I create the eighthachievement random user if not existing, no wait

    When I go to 'Contributions' application
    And I select engagement Programs tab
    And I click on the button add program
    And I enter the program title 'Cancel Space Join Program'
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add incentive' button
    And I wait for drawer to open
    And I enter the rule title 'Cancel Space Join'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Spaces : Join space'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Cancel Space Join' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    And I close the notification

    When I login as 'eighthachievement' random user
    And I go to the random space
    And I go to 'Contributions' application
    And I select engagement Achievements tab

    Then Achievement for 'Cancel Space Join' is accepted

    And I go to spaces page
    And I search for the random space
    And I leave found space
    And I go to 'Contributions' application
    And I select engagement Achievements tab

    Then Achievement for 'Cancel Space Join' is canceled
