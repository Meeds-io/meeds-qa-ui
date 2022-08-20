@task
Feature: Filter Drawer

  Scenario: CAP110 - [Filter_Drawer_US03]:Group by Labels [Group and Sort" tab under project]
    Given I am authenticated as admin

    When I create a random space
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task with label 'testlabel110-1' is created in the specific project
      | taskName | task110-1 |
    And I refresh the page
    And The following task with label 'testlabel110-1' is created in the specific project
      | taskName | task110-2 |

    Then Task name 'task110-1' is displayed in project details
    And Task name 'task110-2' is displayed in project details
    And Tasks number '2' is displayed in the column To Do
    And Task label 'testlabel110-1' related to task name 'task110-1' is displayed in project details
    And Task label 'testlabel110-1' related to task name 'task110-2' is displayed in project details

    When I open the Filter drawer
    And I select 'Labels' from Group By Filter section
    And I click on Confirm button

    Then The label 'testlabel110-1' is displayed '(2)' times in project details
    Then Task name 'task110-1' is displayed in project details
    And Task name 'task110-2' is displayed in project details
    And Tasks number '2' is displayed in the column To Do
    And Task label 'testlabel110-1' related to task name 'task110-1' is displayed in project details
    And Task label 'testlabel110-1' related to task name 'task110-2' is displayed in project details

  Scenario: CAP113 - [Filter_Drawer_US03]:Sort by Title ["Group and Sort" tab under project]
    Given I am authenticated as admin

    When I create a random space
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | ctask11 |
    And I refresh the page
    And I create the following task in selected project
      | taskName | atask11 |
    And I refresh the page
    And I create the following task in selected project
      | taskName | btask11 |

    Then Task name 'ctask11' is displayed in project details
    And Task name 'atask11' is displayed in project details
    And Task name 'btask11' is displayed in project details
    And Tasks number '3' is displayed in the column To Do
    When I open the Filter drawer
    And I select 'Title' from Sort By Filter section
    And I click on Confirm button
    And I refresh the page

    Then In project details the task 'atask11' is displayed in '1' place
    And In project details the task 'btask11' is displayed in '2' place
    And In project details the task 'ctask11' is displayed in '3' place

  Scenario: CAP111 - [Filter_Drawer_US03] Group by Completed [Group and Sort tab under project]
    Given I am authenticated as admin

    And I create a random space
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | task111-1 |
    And I refresh the page
    And I create the following task in selected project
      | taskName | task111-2 |
    And I refresh the page
    And I create the following task in selected project
      | taskName | task111-3 |

    Then Task name 'task111-1' is displayed in project details
    And Task name 'task111-2' is displayed in project details
    And Task name 'task111-3' is displayed in project details
    And Tasks number '3' is displayed in the column To Do

    When I mark the task 'task111-1' as completed in project details
    Then An alert message Task successfully marked as archived is displayed
    And Task name 'task111-1' is not displayed in project details

    When I refresh the page
    And I mark the task 'task111-2' as completed in project details
    And I refresh the page
    Then Task name 'task111-1' is not displayed in project details
    And Task name 'task111-2' is not displayed in project details
    And Task name 'task111-3' is displayed in project details
    And Tasks number '1' is displayed in the column To Do

    When I open the Filter drawer
    And I select 'Archived' from Group By Filter section
    And I click on Confirm button

    Then In Section 'Archived', '(2)' tasks are displayed
    And  In Section 'Uncompleted', '(1)' task is displayed
    And Task 'task111-1' is marked as completed and displayed in Completed section
    And Task 'task111-2' is marked as completed and displayed in Completed section
    And Task 'task111-3' is not marked as completed and displayed in Uncompleted section

  Scenario: CAP53 - [Filter_Drawer_US01]: Filter button in a project
    Given I am authenticated as admin

    When I create a random space
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I create the following task in selected project
      | taskName | taskcap53 |

    When I open the Filter drawer
    Then 'Group And Sort' Tab is displayed
    And Confirm button is displayed in the Filter drawer
    And Cancel button is displayed in the Filter drawer
    And Reset button is displayed in the Filter drawer

    When I go to Labels Tab
    Then 'Labels' Tab is displayed
    And Confirm button is displayed in the Filter drawer
    And Cancel button is displayed in the Filter drawer
    And Reset button is displayed in the Filter drawer

    When I go to Filter Tab
    Then 'Filter' Tab is displayed
    And Confirm button is displayed in the Filter drawer
    And Cancel button is displayed in the Filter drawer
    And Reset button is displayed in the Filter drawer

  Scenario: Filter project
    Given I am authenticated as admin
    And I create the first random user if not existing

    When I connect with the first created user
    And I go to the random space
    And I go to the Tasks tab
    And I create the project 'test Project'
    And I search for the created project 'test project'
    And I edit this project title 'test project edited '
    And I refresh the page
    And I search for the created project 'test project edited'
    Then The project 'test project edited' is displayed in project details
