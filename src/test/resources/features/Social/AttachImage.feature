@attachment
Feature: Attach images activities

  Scenario: Attach and preview an image to an activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached image to preview'
    And I attach an image to the activity
    And I publish the activity
    Then the activity 'activity with attached image to preview' is displayed in activity stream
    And The attached images should be displayed in the published activity 'activity with attached image to preview'

    When I click on attached image related to activity 'activity with attached image to preview'
    Then the preview of the attached image is displayed
    And The preview arrows are not displayed

    When I click on close icon in preview attached image
    Then the preview of the attached image is not displayed

  Scenario: Attached gif image should not be edited
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached gif image'
    And I attach a gif image to the activity
    And I publish the activity
    Then the activity 'activity with attached gif image' is displayed in activity stream
    And The attached images should be displayed in the published activity 'activity with attached gif image'

    When I click on modify the activity 'activity with attached gif image'
    And I enter an activity 'activity with attached gif image'
    Then The attached images should be displayed in the activity 'activity with attached gif image' drawer with the edit icon
      
    When I click on edit an attached image
    Then The attached image crop drawer displayed
    And the crop zone should be blurred 

  Scenario: Attach images to an activity comment
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity comment with attached image'
    And I publish the activity
    Then the activity 'activity comment with attached image' is displayed in activity stream
    
    When I open in activity 'activity comment with attached image' the Comments drawer
    And I attach an image to the activity comment 
    And I add in activity 'activity comment with attached image' a comment 'comment with an attached image'
    Then The comment 'comment with an attached image' is displayed in Comments drawer of activity 'activity comment with attached image'

  Scenario: Edit an activity - Remove images
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached image to remove'
    And I attach an image to the activity
    And I publish the activity
    Then the activity 'activity with attached image to remove' is displayed in activity stream
      
    When I click on modify the activity 'activity with attached image to remove'
    And I enter an activity 'activity with attached image to remove'
    Then The attached images should be displayed in the activity 'activity with attached image to remove' drawer with the delete icon
      
    When I click on delete an attached image
    Then The attached image is not displayed
      
    When I click on Update
    Then The attached images should not be displayed in the published activity 'activity with attached image to remove'

  Scenario: Edit an activity - add images
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I inject the random space
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached image, add images'
    And I attach an image to the activity
    And I publish the activity
    Then the activity 'activity with attached image, add images' is displayed in activity stream
      
    When I click on modify the activity 'activity with attached image, add images'
    And I enter an activity 'activity with attached image, add images'
    And The attached images should be displayed in the activity 'activity with attached image, add images' drawer with the delete icon
    
    When I attach an image to the activity
    And I click on Update
    Then the activity 'activity with attached image, add images' is displayed in activity stream
    And The second attached image should be displayed in the published activity 'activity with attached image, add images'

  Scenario: Edit an activity - Edit images
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached image, edit image'
    And I attach an image to the activity
    And I publish the activity
    Then the activity 'activity with attached image, edit image' is displayed in activity stream
      
    When I click on modify the activity 'activity with attached image, edit image'
    And I enter an activity 'activity with attached image, edit image'
    Then The attached images should be displayed in the activity 'activity with attached image, edit image' drawer with the edit icon
      
    When I click on edit an attached image
    Then The attached image crop drawer displayed
    And The cancel option is displayed
    
    When I click to zoom attached image
    And I update the attached image
    And I click on Update
    
    Then The attached images should be displayed in the published activity 'activity with attached image, edit image'

  Scenario: Send a kudos with attached image
    Given I am authenticated as 'admin' random user
    And I inject the 'first' random user
    And I inject the 'second' random user
    And I login as 'first' random user
    And I inject the random space
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with kudos attached image'
    And I publish the activity
    Then the activity 'activity with kudos attached image' is displayed in activity stream
    
    When I login as 'second' random user
    And I go to the random space
    Then the activity 'activity with kudos attached image' is displayed in activity stream
    
    When I click on the kudos button on first displayed Activity
    
    And I attach an image to the kudos
    And I send to the comment activity a kudos message 'Kudos with attached image'
    And I open in activity 'activity with kudos attached image' the Comments drawer
    Then Comment 'Kudos with attached image' is not displayed in the drawer
    And The attached images should be displayed in the activity comment 'Kudos with attached image'

  Scenario: Announce an action with attached image
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

    When I enter the rule title 'Announce an action with attached image'
    Then The button 'Start' is disabled in drawer

    When I select a 'manual' application
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

    Then The action 'Announce an action with attached image' is displayed in program detail
    When I click on 'Activate the program' button
    Then Confirmation message is displayed 'Program activated'
    When I close the notification

    When I go to Stream page
    Then The activity 'Announce an action with attached image' is not displayed
    
    When I go to 'programs' in site 'contribute'
    And I open random program card
    And I edit program action 'Announce an action with attached image'
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I click on 'Next' button in drawer
    And I enable rule publication
    And I set rule publication message 'Action publication message'
    And I attach an image to the program action
    And I click on 'Update' button in drawer
    Then Confirmation message is displayed 'Action has been successfully updated'
    When I close the notification

    When I go to Stream page
    Then The activity 'Announce an action with attached image' is displayed
    And The message 'Action publication message' is displayed
    And The attached images should be displayed in the published activity 'Announce an action with attached image'
    When I click on 'Announce an action with attached image' text
    Then '0' participants is displayed in action drawer

    When I click on 'Contribute' button in drawer
    And I attach an image to the announcement
    And I announce action with message 'announcement with attached image'
    And I close the notification
    Then The comment 'announcement with attached image' is displayed
    And The attached images should be displayed in the activity comment 'announcement with attached image'

  Scenario: Attach an image to a task description
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing

    And I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I create the random project with the first created user as participant

    When I select projects tab
    And I search for the created project
    And I open the created project
    And I click on plus Button To Add Task
    And I enter title for task 'Task with attached image'
    And I click on save Button To Add Task
    And I open the task 'Task with attached image'
    And I enter description for task 'Task Description'
    And I attach image to the task description
    And I click on apply Button To Add description
    Then The description in the task 'Task Description' is displayed
    And The attached image is displayed in the task description

  Scenario: Edit task description with attached image
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing

    And I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I create the random project with the first created user as participant

    When I select projects tab
    And I search for the created project
    And I open the created project
    And I click on plus Button To Add Task
    And I enter title for task 'Task with description attached images'
    And I click on save Button To Add Task
    And I open the task 'Task with description attached images'
    And I enter description for task 'Task Description attached images'
    And I click on apply Button To Add description
    Then The description in the task 'Task Description attached images' is displayed
    
    When I click to edit task description
    And I attach image to the task description
    And I click on apply Button To Add description

    And The attached image is displayed in the task description

    And I click to edit task description
    And I enter description for task 'Task Description attached images edited'
    And I click on apply Button To Add description
    And The attached image is displayed in the task description

  Scenario: Attach image to task description without saving
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing

    And I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I create the random project with the first created user as participant

    When I select projects tab
    And I search for the created project
    And I open the created project
    And I click on plus Button To Add Task
    And I enter title for task 'Task with description attached images'
    And I click on save Button To Add Task
    And I open the task 'Task with description attached images'
    And I enter description for task 'Task Description attached images'
    And I click on apply Button To Add description
    Then The description in the task 'Task Description attached images' is displayed
    
    When I click to edit task description
    And I attach image to the task description
    And I click on apply Button To Add description

    And The attached image is displayed in the task description
    
    When I click to edit task description
    And I enter description for task 'Task Description attached images edited'
    And I attach a second image to the task description
    
    When I click outside the task description
    Then The new attached image is not displayed

  Scenario: Attach image to task comment
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing

    And I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I create the random project with the first created user as participant

    When I select projects tab
    And I search for the created project
    And I open the created project
    And I click on plus Button To Add Task
    And I enter title for task 'Task with comment attached images'
    And I click on save Button To Add Task

    When I open the task 'Task with comment attached images'
    And I add a Task comment 'Comment of a Task with attached images' with attached images

    When I open the task 'Task with comment attached images'
    Then The attached images are displayed in the task comment
