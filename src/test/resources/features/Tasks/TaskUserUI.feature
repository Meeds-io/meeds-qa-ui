@task
@smoke
Feature: Task user ui

  Scenario: CAP123-[User_UI_US02.6]:Filter by button " I Manage" in Projects tab
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name 'manageProject'
    And I save add project
    And I check that the project is added 'Project successfully created'
    And I select the filter project option 'I manage'
    Then These projects are displayed
      | manageProject |
    And These projects are not displayed
      | ilyes    |
      | eXo Auto |
    And The project 'manageProject' was deleted successfully

  Scenario: CAP21-[User_UI_US18.1][User_UI_US18.2]: Check "Add Project" drawer
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    Then The 'addProjectDrawer' is displayed

  Scenario:CAP34-[User_UI_US20]: Check "Edit Project" drawer
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name 'editProject'
    And I save add project
    And I check that the project is added 'Project successfully created'
    And I select the 'Edit' action for the project 'editProject'
    Then The 'editProject' is displayed
    And The project 'editProject' was deleted successfully

  Scenario:CAP35-[User_UI_US20]:Edit a Project
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name in Task application
    And I save add project
    And I check that the project is added 'Project successfully created'
    And I select the 'Edit' action for the project
    And I change the name of the project
    And I save add project
    And I check that the project is added 'Project successfully created'
    Then The new project name is displayed
    And The old project name is not displayed
    And The updated project was deleted successfully

  Scenario: CAP27 - [User_UI_US07]: Project's Tasks access
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I search for the project 'projectTasks'
    And I open the project 'projectTasks'
    And I select the 'Board' view mode
    Then The 'projectTasks' is displayed

  Scenario: CAP28 - [User_UI_US19]: Project's tasks - List view
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I search for the project 'projectTasks'
    And I open the project 'projectTasks'
    And I select the 'List' view mode
    Then The 'projectTasksList' is displayed

  Scenario:CAP06-[User_UI_US03]:Check Space's Project Card
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I search for the project 'spaceWithCoverAvatar'
    Then The 'spaceProjectCard' is displayed

  Scenario:CAP07 - [User_UI_US03]:Check Project Card (When Project not belong to space)
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I search for the project 'projectTasks'
    Then The 'projectNotSpaceCard' is displayed

  Scenario: Check message when Project title is empty
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I save add project
    Then The 'messageAddProject' is displayed

  Scenario: CAP37 - [User_UI_US18.1]: Check message when project title contains less than 3 characters
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name 'pr'
    And I save add project
    Then The 'messageAddProjectLessThen3' is displayed
