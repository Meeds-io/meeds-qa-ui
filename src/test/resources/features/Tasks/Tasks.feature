@task
Feature: Tasks

  @smoke
  Scenario: Mark as completed for "TASKS" in a Project (Manager case)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I create a random space
    And I go to 'tasks' in site 'mycraft'
    When I select projects tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | tasktest |
    And I mark the task as completed from the task card
    Then Success message is displayed
    And Task name 'tasktest' is not displayed in project details
    And Tasks number '0' is displayed in the column To Do

  @smoke
  Scenario: Add Clear typed characters icon (Filter by task under TASKS tab)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to 'tasks' in site 'mycraft'
    When I select tasks tab
    And I create the following task
      | taskName | task1 |
    And I start the search for Task 'task1'
    Then A clear button is displayed in the Filter by task field
    When I click on clear button in the Filter by task field
    Then The typed task 'task1' is removed from Filter by task field
    And The placeholder Filter by task should be displayed
    And The clear button is disappeared from Filter by task field

  @smoke
  Scenario: (3 dots menu-Delete action) "Tasks TAB"
    Given I am authenticated as 'admin' random user

    And I go to 'tasks' in site 'mycraft'
    When I select tasks tab
    And I create the following task
      | taskName | testE |
    When I open the created task 'testE'
    And I click on three dots task option
    Then Delete task option is displayed
    When I click on task delete option
    And I confirm deletion Task message
    And I close the opened drawer
    Then Task '<TestE>' is deleted successfully

  Scenario: Mark as completed for "TASKS" in a Project (Participant case)
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I create the random project with the first created user as participant
    And I login as 'first' random user

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | task11 |
    And I mark the task as completed from the task card
    Then Success message is displayed
    And Task name 'task11' is not displayed in project details
    And Tasks number '0' is displayed in the column To Do

  @smoke
  @standardConfigurationOnly
  Scenario: 3 dots menu (Delete action) "Task under project"
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I create the project 'newtestessai'
    And I open the project 'newtestessai'
    And I create a random quick task in the random project
      | taskName | taskessai |

    When I open the task 'taskessai'
    And I click on three dots task option
    Then Delete task option is displayed
    When I click on task delete option
    And I confirm deletion Task message
    Then Success message is displayed
    When I close the opened drawer
    Then Task name 'taskessai' is not displayed in project details

  Scenario: Check tasks display in project
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
      | second  |
    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    And I login as 'second' random user
    And I create a random space

    When I login as 'first' random user
    Then I go to the random space

    When I login as 'second' random user
    And I go to 'tasks' in site 'mycraft'
    When I select projects tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | task test |

    When I open the task 'task test'
    And I assign task to the first user
    And I close the opened drawer

    When I open the task 'task test'
    And I set task due date TODAY
    And I close the opened drawer

  Scenario: check that project isn't lost after renaming space name
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user

    And I create a random space
    And I go to Tasks in space tab
    And I create the project 'new project test'
    Then Success message is displayed

    And I go to 'tasks' in site 'mycraft'
    And Project 'new project test' is displayed in Tasks App Center

    When I go to the random space
    And I go to Settings in space tab
    And I click on edit general space settings
    Then I edit the old Space Name with a new random Space Name

    When I refresh the page
    And I go to Tasks in space tab
    And I create the project 'second project test'
    Then Success message is displayed
    And Project 'second project test' is displayed in Tasks space

    And I go to 'tasks' in site 'mycraft'
    And Project 'new project test' is displayed in Tasks App Center
    And Project 'second project test' is displayed in Tasks App Center

  Scenario: Create Task with a new status
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing, no wait
    And I login as 'first' random user

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I create the project 'TestProject'
    And I open the project 'TestProject'
    And I click on three dots icon of the first status column
    And I click on Add Status Before option
    And I Type a Status name 'TestStatus'
    And I click on Validate Name
    Then Status column 'To Do' is moved to the second position
    And Status column 'TestStatus' is moved to the first position

    When I click on plus Button To Add Task
    And I enter title for task 'Automation Test Task'
    And I click on save Button To Add Task
    Then In column status 'TestStatus' , Task name 'Automation Test Task' is displayed

    When I click on three dots icon of the fifth status column
    And I click on Add Status After option of the fifth status column
    And I Type a Status name 'TestStatus2'
    And I click on Validate Name
    And I click on plus Button To Add Task of the sixth status column
    And I enter title for task 'Collaboration FT Task'
    And I click on save Button To Add Task
    Then In column status 'TestStatus2' , Task name 'Collaboration FT Task' is displayed

  @smoke
  Scenario: Manage labels in Project
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user

    And I go to 'tasks' in site 'mycraft'
    And I create the project 'project test labels'
    And I click on three dots project button
    And I click on Edit project button
    And I enter label 'label1' in the project
    Then Label 'label1' is displayed in edit project drawer

    When I close the opened drawer
    And I click on three dots project button
    And I click on Edit project button
    And I enter four label 'label2' 'label3' 'label4' 'label5' in the project
    Then Label 'label2' is displayed in edit project drawer
    And Label 'label3' is displayed in edit project drawer
    And Label 'label4' is displayed in edit project drawer
    And Label 'label5' is displayed in edit project drawer

    When I Remove Label 'label2' in edit project drawer
    Then Label 'label2' is Not displayed in edit project drawer
    And I close the opened drawer
    And I click on three dots project button
    And I click on Edit project button
    Then Label 'label2' is Not displayed in edit project drawer
    And Label 'label1' is displayed in edit project drawer
    And Label 'label3' is displayed in edit project drawer
    And Label 'label4' is displayed in edit project drawer
    And Label 'label5' is displayed in edit project drawer

  @smoke
  Scenario: Mark task as completed from the task drawer [1]
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I create a random space

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | task E |
    And I open the task 'task E'
    And I mark the task as completed in task drawer without closing the drawer
    Then The task is marked as completed in task drawer
    Then Success message is displayed

    When I close the opened drawer
    And Task name 'taskE' is not displayed in project details
    And Tasks number '0' is displayed in the column To Do

  Scenario: All project members can use added labels
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I create the random project with the first created user as participant
    And I click on three dots project button
    And I click on Edit project button
    And I add second user as the participant in the project
    And I enter six label 'label1' 'label2' 'label3' 'label4' 'label5' 'label6' in the project
    Then Label 'label1' is displayed in edit project drawer
    And Label 'label2' is displayed in edit project drawer
    And Label 'label3' is displayed in edit project drawer
    And Label 'label4' is displayed in edit project drawer
    And Label 'label5' is displayed in edit project drawer
    And Label 'label6' is displayed in edit project drawer
    And I click on save project button

    When I login as 'first' random user
    And I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | newtask |
    Then Task name 'newtask' is displayed in project details

    When I login as 'second' random user
    And I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I search for the created project
    And I open the created project
    And Task name 'newtask' is displayed in project details

    When I open the task 'newtask'
    And I add Label 'label1' to task
    And I refresh the page
    And I add Label 'label2' to task
    And I refresh the page
    And I add Label 'label3' to task
    And I refresh the page
    And I add Label 'label4' to task
    And I refresh the page
    And I add Label 'label5' to task
    And I refresh the page
    And I add Label 'label6' to task
    And I close the opened drawer
    And I open the task 'newtask'
    Then Label 'label1' is displayed in edit task drawer and x icon is not displayed
    And Label 'label2' is displayed in edit task drawer and x icon is not displayed
    And Label 'label3' is displayed in edit task drawer and x icon is not displayed
    And Label 'label4' is displayed in edit task drawer and x icon is not displayed
    And Label 'label5' is displayed in edit task drawer and x icon is not displayed
    And Label 'label6' is displayed in edit task drawer and x icon is not displayed
    And I close the opened drawer

  Scenario: when click on notification, user is redirected under the specific project
    Given I am authenticated as 'admin' if random users doesn't exists
      | third  |
      | second  |
    And I inject the third random user if not existing, no wait
    And I inject the second random user if not existing

    When I login as 'second' random user
    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I create the project 'Test Compagne' with the 'third' created user as manager
    And I open the project 'Test Compagne'
    And I create a random quick task in the random project
      | taskName | Security |
    And I open the task 'Security'
    And I click on Add new comment button
    And I enter a comment 'Start working on it' with mentioning the 'third' user in task

    When I login as 'third' random user
    And I open Notifications
    And I click on the notification that mention third user in a task in Project 'Test Compagne' project
    Then Third user with the task comment 'Start working on it' is displayed in task comments drawer

  @smoke
  Scenario: Memorize Group and Sort filters (Group by)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And  I inject the first random user if not existing
    And  I login as 'first' random user
    And  I go to 'tasks' in site 'mycraft'
    And I create the project 'project01'
    And I open the project 'project01'
    When I click on plus Button To Add Task
    And I enter title for task 'Task01'
    And I assign task to me
    And I click on save Button To Add Task
    When I click on plus Button To Add Task
    And I enter title for task 'Task02'
    And I click on save Button To Add Task
    And I click on Filter button
    And I click on Assignee radio button
    And I click on Confirm filter button
    Then I check that tasks are grouped by Assignee
    Then I exit from project
    And I create the project 'project02'
    And I open the project 'project02'
    And I refresh the page
    And I click on Filter button
    Then I check that grouping 'none' is selected
    And I close the opened drawer
    Then I exit from project
    And I open the project 'project01'
    And I refresh the page
    And I click on Filter button
    Then I check that grouping 'assignee' is selected
    And I refresh the page
    And I click on Filter button
    Then I check that grouping 'assignee' is selected
    And I clear browsing data cache and cookies
    Then I check that grouping 'assignee' is selected
    And I refresh the page
    
  Scenario: when refresh task drawer, the description should not be lost
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing

    And I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I create the random project with the first created user as participant

    When I select projects tab
    And I search for the created project
    And I open the created project
    And I click on plus Button To Add Task
    And I enter title for task 'Test Tasks'
    And I enter description for task 'Automation Test Task'
    And I click on save Button To Add Task
    And I open the task 'Test Tasks'
    Then The description in the task 'Automation Test Task' is displayed
    And I close the opened drawer
    And Task name 'Test Tasks' is displayed in project details

    When I login as 'first' random user
    And I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I search for the created project
    And I open the created project
    And I open the task 'Test Tasks'
    And I edit description of the task 'Edit Automation Test Task'
    Then The edit description in the task 'Edit Automation Test Task' is displayed
    When I refresh the page
    Then The edit description in the task 'Edit Automation Test Task' is displayed

  Scenario: Display last Update and Changes drawer
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And  I inject the first random user if not existing
    And  I login as 'first' random user
    And  I go to 'tasks' in site 'mycraft'
    And I create the project 'project001'
    And I open the project 'project001'
    When I click on plus Button To Add Task
    And I enter title for task 'Task001'
    And I click on save Button To Add Task
    And I open the task 'Task001'
    And I check the timestamp update just below Task title Last Update
    When I hover on the Changes timestamp
    Then I check a tooltip is displayed Click to view all changes
    When I click on the timestamp
    Then I check that a new second level drawer Changes is opened
    And I switch to TASKS tab
    And I check the timestamp update just below Task title Last Update
    When I hover on the Changes timestamp
    Then I check a tooltip is displayed Click to view all changes
    When I click on the timestamp
    Then I check that a new second level drawer Changes is opened

  Scenario: Description update should not be lost due to cloning task and assigning it or changing its status
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user

    And I create a random space
    And I refresh the page
    And I go to Tasks in space tab
    And I search for the created project
    And I open the created project

    When I click on plus Button To Add Task
    And I enter title for task 'Automation Test Task'
    And I enter Description for this task 'Decription Task'
    And I click on save Button To Add Task in space project
    And I open the task 'Automation Test Task'
    And I update task Description 'updated'
    And I click on update button
    And I clone Task in space project
    Then task 'Copy of Automation Test Task' is cloned successfully

    When I assign task to me
    And I close the opened drawer
    And I open the task 'Copy of Automation Test Task'
    Then The update description 'Decription Task updated' is displayed in cloned task

    When I close the opened drawer
    And I open the task 'Automation Test Task'
    Then The update description 'Decription Task updated' is displayed in origin task

  Scenario: Check message when project title contains less than 3 characters
    Given I am authenticated as 'admin' random user
    And I go To AppCenter Drawer
    And I open all application page
    When I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I click on add project button
    And I enter the project name 'pr'
    And I click on save project button
    Then The 'Add Project' drawer is displayed

  @functional
  Scenario: CAP54 - [Filter_Drawer_US04]: [Filter button in a project] Open and navigate on tabs in Filter Tasks drawer
    Given I am authenticated as 'admin' if random users doesn't exists
      | first |
    And I create the first random user if not existing
    And I login as 'first' random user
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select projects tab
    And I create the project 'Automation test project'
    And I open the project 'Automation test project'
    And I click on filter tasks button
    Then The 'Sort And Filter' drawer is displayed
    When I select the 'Filter' filter type
    Then 'Filter' Tab is displayed
    When I select the 'Group and Sort' filter type
    Then 'Group And Sort' Tab is displayed
    When I select the 'Labels' filter type
    Then 'Labels' Tab is displayed
    
  @functional
  Scenario:  Add Task in "TASKS" tab (task NOT belong to project)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first |
    And I create the first random user if not existing
    And I login as 'first' random user
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select tasks tab
    And I click on add new task button
    Then The 'Add Task' drawer is displayed
    When I set task name 'Test add task'
    And I click on save new task button
    Then Success message is displayed
