@task
Feature: Tasks

  @smoke
  Scenario: CAP81 - [User_UI_US22]: Mark as completed for "TASKS" in a Project (Manager case)
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user
    And I create space project
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | tasktest |
    And I mark the task as completed from the task card
    Then An alert message Task successfully marked as completed is displayed
    And Task name 'tasktest' is not displayed in project details
    And Tasks number '0' is displayed in the column To Do

  @smoke
  Scenario: CAP176 - [US_Filterfield_01]: Add Clear typed characters icon (Filter by task under TASKS tab)
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Tasks' tab
    And The following task is created
      | taskName | task1 |
    And I start the search for Task 'task1'
    Then A clear button is displayed in the Filter by task field
    When I click on clear button in the Filter by task field
    Then The typed task 'task1' is removed from Filter by task field
    And The placeholder Filter by task should be displayed
    And The clear button is disappeared from Filter by task field

  @smoke
  Scenario: CAP94_[Add_Task_Drawer_US04]: (3 dots menu-Delete action) "Tasks TAB"
    Given I am authenticated as admin

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Tasks' tab
    And The following task is created
      | taskName | testE |
    When I open the created task 'testE'
    And I click on three dots task option
    Then Delete task option is displayed
    When I click on task delete option
    And I confirm deletion Task message
    And I close task drawer
    Then Task '<TestE>' is deleted successfully

  Scenario: CAP82 - [User_UI_US22]: Mark as completed for "TASKS" in a Project (Participant case)
    Given I am authenticated as admin
    And I create the first random user

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I create the random project with the first created user as participant
    And I connect with the first created user

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | task11 |
    And I mark the task as completed from the task card
    Then An alert message Task successfully marked as completed is displayed
    And Task name 'task11' is not displayed in project details
    And Tasks number '0' is displayed in the column To Do

  @smoke
  Scenario: CAP95 - [Add_Task_Drawer_US04]: 3 dots menu (Delete action) "Task under project"
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I add this project 'newtestessai'
    And I open the project 'newtestessai'
    And The task is created in the specific project
      | taskName | taskessai |

    When I open the task 'taskessai'
    And I click on three dots task option
    Then Delete task option is displayed
    When I click on task delete option
    And I confirm deletion Task message
    Then An alert message Task successfully deleted is displayed
    When I close task drawer
    Then Task name 'taskessai' is not displayed in project details

  Scenario: [CERF-77][BUG]: Check tasks display in snapshot's Tasks gadget
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user

    And I connect with the second created user
    And I create space project with the first user

    When I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space project
    And I refresh the page
    Then The 'Spaces' number is '1'

    When I connect with the second created user
    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | task test |

    When I open the task 'task test'
    And I assign task to the first user
    And I close task drawer

    When I open the task 'task test'
    And I set task due date TODAY
    And I close task drawer

    When I connect with the first created user
    And I go to the home page
    Then Tasks widget is displayed
    And Task 'task test' is displayed from tasks widget

  @ignored
  Scenario: CAP188 - [MARM-1][BUG][Lost Projects] check that project isn't lost after renaming space name
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user

    When I create the random space
    And I refresh the page
    And I go to Tasks in space tab
    And I add this project 'new project test'
    Then the project is created successfully and displayed on Tasks Space tab

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And Project 'new project test' is displayed in Tasks App Center

    When I go to the created space
    And I go to Settings in space tab
    And I click on edit general space settings
    Then I edit the old Space Name with a new random Space Name

    When I refresh the page
    And I go to Tasks in space tab
    And I add this project 'second project test'
    Then the project is created successfully and displayed on Tasks Space tab
    And Project 'second project test' is displayed in Tasks space

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And Project 'new project test' is displayed in Tasks App Center
    And Project 'second project test' is displayed in Tasks App Center

  Scenario:[BUG]: Create Task with a new status
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I add this project 'eXoProject'
    And I open the project 'eXoProject'
    And I click on three dots icon of the first status column
    And I click on Add Status Before option
    And I Type a Status name 'exoQA'
    And I click on Validate Name
    Then Status column 'To Do' is moved to the second position
    And Status column 'exoQA' is moved to the first position

    When I click on plus Button To Add Task
    And I enter tile for task 'Automation Test Task'
    And I click on save Button To Add Task
    Then In column status 'exoQA' , Task name 'Automation Test Task' is displayed

    When I click on three dots icon of the fifth status column
    And I click on Add Status After option of the fifth status column
    And I Type a Status name 'exoDev'
    And I click on Validate Name
    And I click on plus Button To Add Task of the sixth status column
    And I enter tile for task 'Collaboration FT Task'
    And I click on save Button To Add Task
    Then In column status 'exoDev' , Task name 'Collaboration FT Task' is displayed

  @smoke
  Scenario: CAP269 - [NF] [US_Sharedlabels_02]: Manage labels in Project (Create labels)
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    And I add this project 'project test labels'
    And I click on three dots project button
    And I click on Edit project button
    And I enter label 'label1' in the project
    Then Label 'label1' is displayed in edit project drawer

    When I close the project drawer
    And I click on three dots project button
    And I click on Edit project button
    And I enter four label 'label2' 'label3' 'label4' 'label5' in the project
    Then Label 'label2' is displayed in edit project drawer
    And Label 'label3' is displayed in edit project drawer
    And Label 'label4' is displayed in edit project drawer
    And Label 'label5' is displayed in edit project drawer

  @smoke
  Scenario: [CERF-94] [MARM-33]: Mark task as completed from the task drawer [1]
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user
    And I create space project

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | task E |
    And I open the task 'task E'
    And I mark the task as completed in task drawer without closing the drawer
    Then The task is marked as completed in task drawer

    When I close task drawer
    Then An alert message Task successfully marked as completed is displayed
    And Task name 'taskE' is not displayed in project details
    And Tasks number '0' is displayed in the column To Do

  Scenario: CAP270 - [NF] [US_Sharedlabels_02]: Manage labels in Project (Delete labels)
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    And I add this project 'project test labels'
    And I click on three dots project button
    And I click on Edit project button
    And I enter label 'label1' in the project
    Then Label 'label1' is displayed in edit project drawer

    When I close the project drawer
    And I click on three dots project button
    And I click on Edit project button
    And I enter four label 'label2' 'label3' 'label4' 'label5' in the project
    Then Label 'label2' is displayed in edit project drawer
    And Label 'label3' is displayed in edit project drawer
    And Label 'label4' is displayed in edit project drawer
    And Label 'label5' is displayed in edit project drawer

    When I close the project drawer
    And I click on three dots project button
    And I click on Edit project button
    And I Remove Label 'label2' in edit project drawer
    And I close the project drawer
    And I click on three dots project button
    And I click on Edit project button
    Then Label 'label2' is Not displayed in edit project drawer
    And Label 'label1' is displayed in edit project drawer
    And Label 'label3' is displayed in edit project drawer
    And Label 'label4' is displayed in edit project drawer
    And Label 'label5' is displayed in edit project drawer

  Scenario: CAP264 - [NF] [US_Sharedlabels_01]:All project members can use added labels
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
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

    When I connect with the first created user
    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    And Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | newtask |
    Then Task 'newtask' is displayed from tasks widget

    When I connect with the second created user
    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    And Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    Then Task 'newtask' is displayed from tasks widget

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
    And I close task drawer
    And I open the task 'newtask'
    Then Label 'label1' is displayed in edit task drawer and x icon is not displayed
    And Label 'label2' is displayed in edit task drawer and x icon is not displayed
    And Label 'label3' is displayed in edit task drawer and x icon is not displayed
    And Label 'label4' is displayed in edit task drawer and x icon is not displayed
    And Label 'label5' is displayed in edit task drawer and x icon is not displayed
    And Label 'label6' is displayed in edit task drawer and x icon is not displayed
    And I close task drawer

  @ignored
  Scenario:[Task]: when click on notification, user is redirected under the specific project
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user

    When I connect with the second created user
    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I create the project 'Test Compagne' with the first created user as manager
    And I open the project 'Test Compagne'
    And The task is created in the specific project
      | taskName | Security |
    And I open the task 'Security'
    And I click on Add new comment button
    And I enter a comment 'Start working on it' with mentioning the first user in task

    When I connect with the first created user
    And I open Notifications
    And I click on the notification that mentione first user in a task in Project 'Test Compagne' project
    Then First user with the task comment 'Start working on it' is displayed in task comments drawer

  @smoke
  Scenario: CAP190 -[IMP] [US_SortGroupeBy_01]: Memorize Group and Sort filters (Group by)
    Given I am authenticated as admin
    And  I create the first random user
    And  I connect with the first created user
    When I go To AppCenter Drawer
    And  I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I add this project 'project01'
    And I open the project 'project01'
    When I click on plus Button To Add Task
    And I enter tile for task 'Task01'
    And I assign task to me
    And I click on save Button To Add Task
    When I click on plus Button To Add Task
    And I enter tile for task 'Task02'
    And I click on save Button To Add Task
    And I click on Filter button
    And I click on Assignee radio button
    And I click on Confirm filter button
    Then I check that tasks are grouped by Assignee
    Then I exit from project
    And I add this project 'project02'
    And I open the project 'project02'
    And I click on Filter button
    Then I check that grouping is not applied
    And I close Sort And Filter drawer
    Then I exit from project
    And I open the project 'project01'
    And I click on Filter button
    Then I check that grouping is still applied
    And I refresh the page
    And I click on Filter button
    Then I check that grouping is still applied
    And I clear browsing data cache and cookies
    Then I check that grouping is still applied

  @smoke
  Scenario: CAP33 - [Filter_Drawer_US09]: "Sort And Filter" drawer - Check "Group and Sort" tab
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Tasks' tab
    And I click on filter tasks button in Tasks Tab
    Then The 'groupAndSortDrawer' is displayed
    And I select the 'Filter' filter type
    Then The 'FilterDrawer' is displayed
    And I select the 'Labels' filter type
    Then The 'LabelsDrawer' is displayed

  @smoke
  Scenario: CAP50 - [Add_Task_Drawer_US01] [Tasks_tab_US05]: Add Task in "TASKS" tab
    Given I am authenticated as admin
    And I create the first random user
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I click on add tasks button
    Then The 'taskDrawer' is displayed

  Scenario: CAP341 [TASK]: when refresh task drawer, the description should not be lost
    Given I am authenticated as admin
    And I create the first random user

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I create the random project with the first created user as participant

    When I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I click on plus Button To Add Task
    And I enter tile for task 'Test Tasks'
    And I enter description for task 'Automation Test Task'
    And I click on save Button To Add Task
    And I open the task 'Test Tasks'
    Then The description in the task 'Automation Test Task' is displayed
    And I close task drawer
    And Task 'Test Tasks' is displayed from tasks widget

    When I connect with the first created user
    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    And Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I open the task 'Test Tasks'
    Then I edit description of the task 'Edit Automation Test Task'
    And I refresh the page
    And The edit description in the task 'Edit Automation Test Task' is displayed

  Scenario: [IMP] [US_ChangesDrawer_01]: Display last Update and Changes drawer
    Given I am authenticated as admin
    And  I create the first random user
    And  I connect with the first created user
    When I go To AppCenter Drawer
    And  I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I add this project 'project001'
    And I open the project 'project001'
    When I click on plus Button To Add Task
    And I enter tile for task 'Task001'
    And I click on save Button To Add Task
    And I open the task 'Task001'
    Then I check that Edit task drawer is displayed
    And I check the timestamp update just below Task title Last Update
    When I hover on the Changes timestamp
    Then I check a tooltip is displayed Click to view all changes
    When I click on the timestamp
    Then I check that a new second level drawer Changes is opened
    And I switch to TASKS tab
    Then I check that Edit task drawer is displayed
    And I check the timestamp update just below Task title Last Update
    When I hover on the Changes timestamp
    Then I check a tooltip is displayed Click to view all changes
    When I click on the timestamp
    Then I check that a new second level drawer Changes is opened

  Scenario:[CERF-133][TASK][BUG]:Description update should not be lost due to cloning task and assigning it or changing its status
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user

    And I create space project
    And I refresh the page
    And I go to Tasks in space tab
    And I search for the created project
    And I open the created project

    When I click on plus Button To Add Task
    And I enter tile for task 'Automation Test Task'
    And I enter Description for this task 'Decription Task'
    And I click on save Button To Add Task in space project
    And I open the task 'Automation Test Task'
    And I update task Description 'updated'
    And I click on update button
    And I clone Task in space project
    Then task 'Copy of Automation Test Task' is cloned successfully

    When I assign task to me
    And I close task drawer of cloned task
    And I open the task 'Copy of Automation Test Task'
    Then The update description 'Decription Task updated' is displayed in cloned task

    When I close task drawer of cloned task
    And I open the task 'Automation Test Task'
    Then The update description 'Decription Task updated' is displayed in origin task