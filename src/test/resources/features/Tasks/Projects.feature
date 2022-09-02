@task
Feature: Tasks - Projects

  Scenario: [User_UI_US18.1] Add project with a description
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing
    And I connect with the first created user
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I add a new project with a description
    Then the project is created successfully and displayed on Projects tab

  Scenario: CAP47 - [Project_manager_US03.2] Clone a project
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing
    And I connect with the first created user
    And I create a random space
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | task1414 |
    And I return to Projects tab
    And I clone the project
    Then project is cloned successfully
    And I open the cloned project
    Then task 'Copy of task1414' is cloned successfully

  Scenario: CAP174 -[US_Filterfield_01] Add Clear typed characters icon "Filter by project"
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing
    And I connect with the first created user
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I create the project 'Project2'
    And I search for the project 'Project2'
    Then A clear button is displayed in the search field
    When I click on clear button
    Then The typed project 'Project2' is removed from the Filter by project field
    And The placeholder Filter by project should be displayed
    And The clear button is disappeared from the Filter by project field

  Scenario: CAP15 [Project_Card_US01] check the display "Spaces Managers avatars"
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I create a random space

    When I connect with the first created user
    And I go to the random space

    When I change user admin

    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I search for the created space
    Then First project name with description 'No description available' is displayed in Project Card
    When I hover on project manager icon
    Then Space manager 'Admin User' is displayed in Project Card
    And First Space member is not displayed in Project Card

    When I go to the random space
    And I go to the Space Members tab
    And I promote 'first' random user as a space manager

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I search for the created space
    Then User avatar 'admin' is displayed in Project Card
    And Avatar of the first created user is displayed in Project Card

  Scenario: CAP17 - [Project_Card_US01] check the display of users avatars with managing permissions
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I create the second random user if not existing

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I add the random project with first user as the manager and second user as the participant
    And I search for the created project
    Then The random created project with description 'No description available' is displayed in Project Card
    And User avatar 'admin' is displayed in Project Card
    And Avatar of the first created user is displayed in Project Card
    And Avatar of the second created user is not displayed in Project Card

  Scenario: CAP19 - [User_UI_US09] Project's Tasks "BOARD" view
    Given I am authenticated as admin

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I add a new project
    And I open the added project
    Then The project name is displayed in project details
    And Board view is displayed by default
    And Status column 'To Do' is displayed in the first position
    And Status column 'In Progress' is displayed in the second position
    And Status column 'Waiting On' is displayed in the third position
    And Status column 'Done' is displayed in the last position

  Scenario: CAP36 [User_UI_US18.1] Check  message when  Project title is empty
    Given I am authenticated as admin

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I click to add new project
    And I click on save project button
    Then Message Project Title is mandatory is displayed

  Scenario: CAP290 - Project participant cannot open the edit status mode
    Given I am authenticated as admin
    And I create the first random user if not existing

    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I create the random project with the first created user as participant
    And I search for the created project
    Then The random created project with description 'No description available' is displayed in Project Card

    When I open the created project
    Then The project name is displayed in project details

    When I click on Status name 'To Do'
    Then Status name 'To Do' Edit mode is opened successfully

    When I return to Projects tab
    And I connect with the first created user
    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I search for the created project
    Then The random created project with description 'No description available' is displayed in Project Card

    When I open the created project
    Then The project name is displayed in project details

    When I click on Status name 'To Do'
    Then Status name 'To Do' Edit mode is not opened successfully

  Scenario: CAP216 - Task card should be well displayed when task title is long
    Given I connect as admin if random users doesn't exists
      | first  |
    And I create the first random user if not existing

    When I connect with the first created user
    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I select 'Projects' tab
    And I create the project 'teamcap216'
    And I open the project 'teamcap216'
    And The task is created in the specific project
      | taskName | testlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtaskname |

    Then Task name 'testlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtaskname' is displayed in project details

    When I hover on task's title 'testlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtaskname'
    Then Task tooltip is displayed 'testlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtaskname'

  @ignored
  Scenario: [US_GanttView_01] Display Gantt tab in Space tasks projects
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create a random space with the first random user
    And I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space project
    And I refresh the page
    Then The 'Spaces' number is '1'
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | task1 |
    When I open the task 'task1'
    And I set task start date TODAY
    And I set task due date TOMORROW
    And I close task drawer
    And I create the following task in selected project
      | taskName | task2 |
    When I open the task 'task2'
    And I set task start date TOMORROW
    And I set task due date Next week
    And I close task drawer
    And I create the following task in selected project
      | taskName | task3 |
    When I open the task 'task3'
    And I set task start date TOMORROW
    And I set task due date TOMORROW
    And I close task drawer
    And I go to the PLAN view
    And I refresh the page
    And I go to the PLAN view
    Then The task name 'task1' should be displayed in PLAN view
    And The task name 'task2' should be displayed in PLAN view
    And The task name 'task3' should be displayed in PLAN view

  @smoke
  @ignored
  Scenario: CAP16 - [Project_Card_US01] check the display "project's creator avatar"
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name 'projectCard1'
    And I click on save project button
    And I search for the project 'projectCard1'
    Then The project 'projectCard1' was deleted successfully

  @ignored
  Scenario: CAP43 [Project_manager_US02] Delete a Project
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name 'deleteProject'
    And I click on save project button
    And I select the 'Delete' action for the project 'deleteProject'
    And I click on delete button
    And These projects are not displayed
      | deleteProject |

  @ignored
  Scenario: CAP44 - [Project_manager_US02] Cancel Deletion of Project
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name 'cancelDelete'
    And I click on save project button
    And I select the 'Delete' action for the project 'cancelDelete'
    And I click on cancel delete button
    And I search for the project 'cancelDelete'
    Then These projects are displayed
      | cancelDelete |
    And The project 'cancelDelete' was deleted successfully