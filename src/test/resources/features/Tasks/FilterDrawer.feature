Feature: Filter Drawer

  @task
  Scenario: CAP110 - [Filter_Drawer_US03]:Group by Labels [Group and Sort" tab under project]
    Given I am authenticated as admin

    When I create space project
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task with label 'test007' is created in the specific project
      | taskName | task11 |
    And I refresh the page
    And The following task with label 'test007' is created in the specific project
      | taskName | task12 |

    Then Task name 'task11' is displayed in project details
    And Task name 'task12' is displayed in project details
    And Tasks number '2' is displayed in the column To Do
    And Task label 'test007' related to task name 'task11' is displayed in project details
    And Task label 'test007' related to task name 'task12' is displayed in project details

    When I open the Filter drawer
    And I select 'Labels' from Group By Filter section
    And I click on Confirm button

    Then The label 'test007' is displayed '(2)' times in project details
    Then Task name 'task11' is displayed in project details
    And Task name 'task12' is displayed in project details
    And Tasks number '2' is displayed in the column To Do
    And Task label 'test007' related to task name 'task11' is displayed in project details
    And Task label 'test007' related to task name 'task12' is displayed in project details

  @task
  Scenario: CAP113 - [Filter_Drawer_US03]:Sort by Title ["Group and Sort" tab under project]
    Given I am authenticated as admin

    When I create space project
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | ctask11 |
    And I refresh the page
    And The following task is created in the specific project
      | taskName | atask11 |
    And I refresh the page
    And The following task is created in the specific project
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

  @task
  Scenario: CAP111 - [Filter_Drawer_US03]:Group by Completed [Group and Sort" tab under project]
    Given I am authenticated as admin

    And I create space project
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | task11 |
    And I refresh the page
    And The following task is created in the specific project
      | taskName | task12 |
    And I refresh the page
    And The following task is created in the specific project
      | taskName | task13 |

    Then Task name 'task11' is displayed in project details
    And Task name 'task12' is displayed in project details
    And Task name 'task13' is displayed in project details
    And Tasks number '3' is displayed in the column To Do

    When I mark the task 'task11' as completed in project details
    And I wait 1 second
    Then Task name 'task11' is not displayed in project details
    And Alert 'Task successfully marked as completed' is displayed

    When I refresh the page
    And I mark the task 'task12' as completed in project details
    And I refresh the page
    Then Task name 'task11' is not displayed in project details
    And Task name 'task12' is not displayed in project details
    And Task name 'task13' is displayed in project details
    And Tasks number '1' is displayed in the column To Do

    When I open the Filter drawer
    And I select 'Archived' from Group By Filter section
    And I click on Confirm button

    Then In Section 'Archived', '(2)' tasks are displayed
    And  In Section 'Uncompleted', '(1)' task is displayed
    And Task 'task11' is marked as completed and displayed in Completed section
    And Task 'task12' is marked as completed and displayed in Completed section
    And Task 'task13' is not marked as completed and displayed in Uncompleted section

  @task
  Scenario: CAP53 - [Filter_Drawer_US01]: Filter button in a project
    Given I am authenticated as admin

    When I create space project
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
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

  @task
  Scenario: [Regression][Tasks]Problem to filter project
    Given I am authenticated as admin

    And I create the first random user

    When I connect with the first created user
    And I create the random space
    And I go to the Tasks tab
    And I add this project 'test Project'
    And I search for the created project 'test project'
    And I edit this project title 'test project edited '
    And I refresh the page
    And I search for the created project 'test project edited'
    Then The project 'test project edited' is displayed in project details

