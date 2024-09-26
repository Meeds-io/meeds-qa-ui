@gamification
@actions
Feature: Actions

  Scenario: Announce a challenge
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing, no wait
    And I create the random space if not existing
    And I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open

    Then The button 'Start' is disabled in drawer

    When I enter the rule title 'Challenge to announce'
    And I select a 'manual' application
    Then The button 'Start' is enabled in drawer

    When I click on 'Start' button in drawer
    And I add rule random description
    Then The button 'Next' is enabled in drawer
    And I click on 'Next' button in drawer

    Then The button 'Duration' is not displayed in drawer

    When I set rule end date
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Challenge to announce' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification

    When I login as 'first' random user
    And I go to the random space

    And I go to 'programs' in site 'contribute'
    And I open random program card
    And I announce challenge 'Challenge to announce' with message 'announcement10'

    And I click on 'See' link

    Then The activity 'Challenge to announce' is displayed

    When I go to '/portal/contribute/contributions/achievements#yours'
    Then Achievement for 'Challenge to announce' is pending

    When I go to 'programs' in site 'contribute'
    And I open random program card

    When I open program action 'Challenge to announce'
    Then The program action contains duration limitation
    And I close the opened drawer

    When I login as 'admin' random user

    When I go to 'programs' in site 'contribute'
    And I open random program card
    And I edit program action 'Challenge to announce'
    And I click on 'Next' button in drawer
    And I delete rule duration
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Update' button in drawer
    And I close the notification

    When I open program action 'Challenge to announce'
    Then The program action does not contain duration limitation
    And I close the opened drawer

  Scenario: Cannot Announce a disabled challenge
    Given I am authenticated as 'admin' random user
    And I inject a random space

    And I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open

    When I enter the rule title 'Challenge to disable'
    And I select a 'manual' application
    Then The button 'Start' is enabled in drawer

    When I click on 'Start' button in drawer
    And I add rule random description
    Then The button 'Next' is enabled in drawer

    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

  Scenario: Announce an action from its activity
    Given I am authenticated as 'admin' random user
    And I inject the random space

    And I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open

    When I enter the rule title 'Announce an action from its activity'
    And I select a 'manual' application
    Then The button 'Start' is enabled in drawer

    And I click on 'Start' button in drawer
    And I add rule random description
    Then The button 'Next' is enabled in drawer

    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification

    Then The action 'Announce an action from its activity' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    When I close the notification

    When I go to Stream page
    Then The activity 'Announce an action from its activity' is not displayed

    When I go to 'programs' in site 'contribute'
    And I open random program card
    And I edit program action 'Announce an action from its activity'
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I enable rule publication
    And I set rule publication message 'Action publication message'
    And I click on 'Update' button in drawer
    Then Confirmation message is displayed 'Action has been successfully updated'
    When I close the notification

    When I go to Stream page
    Then The activity 'Announce an action from its activity' is displayed
    And The message 'Action publication message' is displayed

    When I click on 'Announce an action from its activity' text
    Then '0' participants is displayed in action drawer

    When I click on 'Contribute' button in drawer
    And I announce action with message 'announcement12'
    And I close the notification
    Then The comment 'announcement12' is displayed

    When I click on 'Announce an action from its activity' text
    Then '0' participants is displayed in action drawer

    When I go to the action from opened drawer
    Then '0' participants is displayed in action drawer

    When I go to the activity of opened action
    And I click on 'Announce an action from its activity' text
    Then '0' participants is displayed in action drawer

    When I go to '/portal/contribute/contributions/achievements#yours'
    Then Achievement for 'Announce an action from its activity' is pending
    Then I click on 'Review' button
    Then I wait for application loading
    When I accept the achievements 'Announce an action from its activity'

    Then I go to Stream page
    Then The activity 'Announce an action from its activity' is displayed

    When I click on 'Announce an action from its activity' text
    Then '1' participants is displayed in action drawer

    When I go to the action from opened drawer
    Then '1' participants is displayed in action drawer

    When I go to the activity of opened action
    And I click on 'Announce an action from its activity' text
    Then '1' participants is displayed in action drawer

    When I go to the random space
    Then The activity 'Announce an action from its activity' is displayed
    And The comment 'announcement12' is displayed in Comments drawer of activity 'Announce an action from its activity'

    When I click on three dots button related to activity 'Announce an action from its activity'
    And I click on 'Hide' menu item
    And I confirm
    Then The activity 'Announce an action from its activity' is not displayed

    When I go to 'programs' in site 'contribute'
    And I open random program card
    And I click on 'Announce an action from its activity' text
    And I go to the activity of opened action
    And I click on three dots button related to activity 'Announce an action from its activity'
    And I click on 'Unhide' menu item
    And I go to the random space

    Then The activity 'Announce an action from its activity' is displayed

    When I go to 'programs' in site 'contribute'
    And I open random program card
    And I click on 'Add Action' button
    And I wait for drawer to open

    When I enter the rule title 'Action with second activity'
    And I select a 'manual' application
    And I click on 'Start' button in drawer
    And I add rule random description
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    And I close the notification

    When I go to the random space
    Then The message 'Action with second activity' is displayed
    And The button 'Contribute' is displayed

  Scenario: Cannot Announce a disabled challenge
    Given I am authenticated as 'admin' random user
    And I inject a random space

    And I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open

    When I enter the rule title 'Challenge to disable'
    Then The button 'Start' is disabled in drawer

    When I select a 'manual' application
    Then The button 'Start' is enabled in drawer

    When I click on 'Start' button in drawer
    And I add rule random description
    Then The button 'Next' is enabled in drawer

    When I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

    When I close the notification
    Then The action 'Challenge to disable' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification

    When I disable program action 'Challenge to disable'
    Then Confirmation message is displayed 'Action status successfully updated'

    When I close the notification
    Then The action 'Challenge to disable' is not displayed in program detail

    When I filter program actions by value 'ALL'
    And I open program action 'Challenge to disable'

    Then I cannot announce program action
    And I close the opened drawer

  Scenario: Cancel an announcement
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing, no wait
    And I inject the random space
    And I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Announce activity to delete'
    And I select a 'manual' application
    Then The button 'Start' is enabled in drawer

    When I click on 'Start' button in drawer
    And I add rule random description
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'
    When I close the notification
    Then The action 'Announce activity to delete' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification

    When I login as 'first' random user
    And I go to the random space

    And I go to 'programs' in site 'contribute'
    And I open random program card
    And I announce challenge 'Announce activity to delete' with message 'announcement8'

    When I click on 'See' link
    Then The comment 'announcement8' is displayed in Comments drawer

    When I open in activity 'Announce activity to delete' the Comments drawer
    And I click on the first comment 'announcement8' three dots icon from comments drawer
    And I click on 'Cancel' button related to comment 'announcement8'
    And I click on Yes button

    And I close the opened drawer
    And I announce challenge 'Announce activity to delete' with message 'announcement11' from activity
    And I open in activity 'Announce activity to delete' the Comments drawer
    And I click on the comment 'announcement11' three dots icon from comments drawer
    And I click on 'Cancel' button related to comment 'announcement11'
    And I click on Yes button

    And I go to '/portal/contribute/contributions/achievements#yours'
    Then Achievement for 'Announce activity to delete' is canceled

  Scenario: Overview top challenge
    Given I am authenticated as 'admin' random user
    When I inject the first random user if not existing, no wait
    And I inject the random space
    And I go to 'programs' in site 'contribute'
    And I click on the button add program
    And I enter a random program title
    And I add program with random description
    And I click on 'Next' button in drawer
    And I add an audience space
    And I save the program details

    And I click on 'Add action' button
    And I wait for drawer to open
    And I enter the rule title 'Top challenge'
    And I select a 'manual' application
    Then The button 'Start' is enabled in drawer

    When I click on 'Start' button in drawer
    And I add rule random description
    And I click on 'Next' button in drawer
    And I set rule end date
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Add' button in drawer

    Then Confirmation message is displayed 'Action has been successfully created'

    When I close the notification
    Then The action 'Top challenge' is displayed in program detail

    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'

    When I close the notification
    Then The button 'Activate the program' is not displayed

    When I login as 'first' random user
    And I go to the random space

    And I go to 'programs' in site 'contribute'
    And I open random program card
    And I announce challenge 'Top challenge' with message 'announcement7'
    And I close the notification
    And I announce challenge 'Top challenge' with message 'announcement6'
    And I close the notification
    And I announce challenge 'Top challenge' with message 'announcement5'
    And I close the notification
    And I announce challenge 'Top challenge' with message 'announcement4'
    And I close the notification

    And I go to 'dashboard' in site 'mycraft'
    Then 'Top challenge' is displayed in challenge portlet with '4' participants

    When I login as 'admin' random user

    And I go to 'programs' in site 'contribute'
    And I filter programs by value 'ALL'
    And I delete the created program
    And I login as 'first' random user
    And I go to 'dashboard' in site 'mycraft'

    Then 'Top challenge' with '4' participants is not displayed in challenge portlet
