@achievements
Feature: Achievements

  Scenario: Achievements for Send/Cancel Kudos from the activity author
    Given I am authenticated as admin
    And I create the random space if not existing
    And I go to 'Contributions' application

    When I select engagement Programs tab
    And I click on the button add program
    And I enter the program title 'Achievements program'
    And I add program with random description
    And I add an audience space
    And I save the program details
    And I open 'Achievements program' program card

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Send kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer

    Then The button 'Next' is disabled in drawer

    When I add an event 'Send kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Send kudos' is displayed in program detail

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Receive kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Receive kudos' is displayed in program detail

    When I create the fisrtachievement random user if not existing, no wait
    And I create the secondachievement random user if not existing, no wait
    When I connect with the secondachievement created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Achievements - Kudos Post activity'
    And I publish the activity

    And I connect with the fisrtachievement created user
    When I go to the random space
    And I send in the activity 'Achievements - Kudos Post activity' a kudos message 'Achievements - kudos activity comment to cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is accepted

    And I go to the random space
    When In activity 'Achievements - Kudos Post activity' I cancel the sent kudos comment 'Achievements - kudos activity comment to cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is canceled
    And Achievement for 'Receive kudos' is rejected

  Scenario: Achievements for Send/Cancel Kudos from user profile
    Given I am authenticated as admin
    And I create the random space if not existing
    And I go to 'Contributions' application
    When I select engagement Programs tab
    And I click on the button add program
    And I enter the program title 'Achievements program'
    And I add program with random description
    And I add an audience space
    And I save the program details
    And I open 'Achievements program' program card

    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Send kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Send kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Send kudos' is displayed in program detail

    When I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Receive kudos'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Receive kudos'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Receive kudos' is displayed in program detail

    And I create the thirdachievement random user if not existing, no wait
    And I create the fourachievement random user if not existing

    When I connect with the thirdachievement created user
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
    And Achievement for 'Receive kudos' is rejected

  Scenario: Achievements listing for program owner/space host
    Given I am authenticated as admin
    And I create the random space if not existing
    And I create the fifthachievement random user if not existing, no wait
    And I create the sixthachievement random user if not existing, no wait

    When I go to 'Contributions' application
    And I select engagement Programs tab
    And I click on the button add program
    And I enter the program title 'Test Program Host'
    And I add program with random description
    And I add an audience space
    And I save the program details

    When I open 'Test Program Host' program card
    And I click on 'Add Action' button
    And I wait for drawer to open
    And I enter the rule title 'Join space'
    And I add rule random description
    And I click on 'Automatic' button in drawer
    And I add an event 'Join space'
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And The action 'Join space' is displayed in program detail

    When I connect with the fifthachievement created user
    And I go to the random space
    And I go to 'Contributions' application
    When I open 'Test Program Host' program card
    Then Actions Filter dropdown is not displayed

    And I connect with the sixthachievement created user
    And I go to the random space
    And I go to 'Contributions' application
    When I open 'Test Program Host' program card
    Then Actions Filter dropdown is not displayed

    When I change user admin
    And I go to 'Contributions' application
    And I select engagement Achievements tab
    And I filter achievements using 'Test Program Host' program

    Then The achievement 'Join space' is displayed '2' times

    When I go to the random space
    And I click on 'Members' space menu tab
    And I search for 'fifthachievement' random user
    And I click on three dots menu
    And I set as a space manager

    When I connect with the sixthachievement created user
    And I go to 'Contributions' application
    And I select engagement Achievements tab
    Then The achievement 'Join space' is displayed '1' times
    And The switch button 'Display achievements from programs you host' is displayed

    When I enable the switch button 'Display achievements from programs you host'
    Then The achievement 'Join space' is displayed '0' times

    When I connect with the fifthachievement created user
    And I go to 'Contributions' application

    When I open 'Test Program Host' program card
    Then Actions Filter dropdown is displayed

    When I select engagement Achievements tab
    Then The achievement 'Join space' is displayed '1' times
    And The switch button 'Display achievements from programs you host' is displayed

    When I enable the switch button 'Display achievements from programs you host'
    Then The achievement 'Join space' is displayed '2' times
