@task
Feature: Tasks - Projects

  Scenario: Add project with a description
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to 'tasks' in site 'mycraft'
    When I select projects tab
    And I add a new project with a description
    Then Success message is displayed

  Scenario: Clone a project
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
      | taskName | task1414 |
    And I return to Projects tab
    And I clone the project
    Then project is cloned successfully
    And I open the cloned project
    Then task 'Copy of task1414' is cloned successfully

  Scenario: Add Clear typed characters icon "Filter by project"
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to 'tasks' in site 'mycraft'
    When I select projects tab
    And I create the project 'Project2'
    And I search for the project 'Project2'
    Then A clear button is displayed in the search field
    When I click on clear button
    Then The typed project 'Project2' is removed from the Filter by project field
    And The placeholder Filter by project should be displayed
    And The clear button is disappeared from the Filter by project field

  Scenario: check the display of users avatars with managing permissions
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing, no wait
    And I inject the second random user if not existing

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I add the random project with first user as the manager and second user as the participant
    And I search for the created project
    Then The random created project with description 'No description available' is displayed in Project Card
    And User avatar 'admin' is displayed in Project Card
    And Avatar of the first created user is displayed in Project Card
    And Avatar of the second created user is not displayed in Project Card

  Scenario: Project's Tasks "BOARD" view
    Given I am authenticated as 'admin' random user

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I add a new project
    And I open the added project
    Then The created project name is displayed in project details
    And Board view is displayed by default
    And Status column 'To Do' is displayed in the first position
    And Status column 'In Progress' is displayed in the second position
    And Status column 'Waiting On' is displayed in the third position
    And Status column 'Done' is displayed in the last position

  Scenario: Check  message when  Project title is empty
    Given I am authenticated as 'admin' random user

    And I go to 'tasks' in site 'mycraft'

    When I click to add new project
    And I click on save project button
    Then Message Project Title is mandatory is displayed

  Scenario: Project participant cannot open the edit status mode
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing

    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I create the random project with the first created user as participant
    And I search for the created project
    Then The random created project with description 'No description available' is displayed in Project Card

    When I open the created project
    Then The project name is displayed in project details

    When I click on Status name 'To Do'
    Then Status name 'To Do' Edit mode is opened successfully

    When I return to Projects tab
    And I login as 'first' random user
    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I search for the created project
    Then The random created project with description 'No description available' is displayed in Project Card

    When I open the created project
    Then The project name is displayed in project details

    When I click on Status name 'To Do'
    Then Status name 'To Do' Edit mode is not opened successfully

  Scenario: Task card should be well displayed when task title is long
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing

    When I login as 'first' random user
    And I go to 'tasks' in site 'mycraft'

    When I select projects tab
    And I create the project 'teamcap216'
    And I open the project 'teamcap216'
    And I create a random quick task in the random project
      | taskName | testlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtaskname |

    Then Task name 'testlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtaskname' is displayed in project details

    When I hover on task's title 'testlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtaskname'
    Then Task tooltip is displayed 'testlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtasknametestlongtaskname'

  @smoke
  Scenario: check the display "project's creator avatar"
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing
    And I go to 'tasks' in site 'mycraft'
    When I select projects tab
    And I add the random project with first user as the participant
    And I search for the created project
    Then The random created project with description 'No description available' is displayed in Project Card
    When I hover on project manager icon
    Then User avatar 'admin' is displayed in Project Card
    And Avatar of the first created user is not displayed in Project Card

  Scenario: Delete a Project
    Given I am authenticated as 'admin' random user
    And I create a random space
    And I go To AppCenter Drawer
    And I open all application page
    When I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I search for the created project
    And I click on three dots project button
    And I click on delete project button
    And I click on delete to confirm project deletion
    Then the project is deleted successfully from Projects tab

  Scenario: Cancel Deletion of Project
    Given I am authenticated as 'admin' random user
    And I create a random space
    And I go To AppCenter Drawer
    And I open all application page
    When I go to 'tasks' in site 'mycraft'
    And I select projects tab
    And I search for the created project
    And I click on three dots project button
    And I click on delete project button
    And I click on cancel to not confirm project deletion
    And The random created project with description 'No description available' is displayed in Project Card
    And I click on three dots project button
    And I click on delete project button
    And I click on delete to confirm project deletion
    And the project is deleted successfully from Projects tab