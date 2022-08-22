@task
Feature: Project manager deletes, moves after/before a status column

  Scenario: CAP136 - [Project_Board_US04] Three dots menu - Delete
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I connect with the first created user
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I add a new project
    And I open the added project
    And I click on three dots icon of the first status column
    And I click on Delete option
    And I confirm the deletion message
    Then Status 'To Do' is deleted successfully

  Scenario: CAP247 - [US_TaskStatusColumn_01] Move Status column after in Board view
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I connect with the first created user
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I add a new project
    And I open the added project
    And I click on three dots icon of the first status column
    And I check that Move Status column before option is not displayed
    And I click on Move Status column after option
    Then An alert message Status column is moved successfully is displayed
    And Status column 'To Do' is moved to the second position
    And Status column 'In Progress' is moved to the first position

  Scenario: CAP339 - [NewF] [US_TaskStatusColumn_01] Move Status column before in Board view
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I connect with the first created user
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Projects' tab
    And I add a new project
    And I open the added project
    And I click on three dots icon of the last status column
    And I check that Move Status column after option is not displayed
    And I click on Move Status column before option
    Then An alert message Status column is moved successfully is displayed
    And Status column 'Done' is moved to the third position
    And Status column 'Waiting On' is moved to the last position