@task
@smoke
Feature: Task user ui

  @ignored
  Scenario: CAP123-[User_UI_US02.6]:Filter by button " I Manage" in Projects tab
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name 'manageProject'
    And I click on save project button
    And I check that the project is added 'Project successfully created'
    And I select the filter project option 'I manage'
    Then These projects are displayed
      | manageProject |
    And These projects are not displayed
      | Test Auto |
    And The project 'manageProject' was deleted successfully

  @ignored
  Scenario:CAP35-[User_UI_US20]:Edit a Project
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name in Task application
    And I click on save project button
    And I check that the project is added 'Project successfully created'
    And I select the 'Edit' action for the project
    And I change the name of the project
    And I click on save project button
    And I check that the project is added 'Project successfully created'
    Then The new project name is displayed
    And The old project name is not displayed
    And The updated project was deleted successfully

  Scenario: CAP37 - [User_UI_US18.1]: Check message when project title contains less than 3 characters
    Given I am authenticated as admin
    And I open the app center menu
    And I open all application page
    When I go to 'Tasks' application
    And I select 'Projects' tab
    And I click on add project button
    And I enter the project name 'pr'
    And I click on save project button
    Then The 'Add Project' drawer is displayed
