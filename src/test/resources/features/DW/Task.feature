Feature: Task Drawer Checking

  Scenario: US 3.13.5 [FRONT/BACK] : Comments in Task drawer
    Given I am authenticated as admin
    And I create the first random user

    And I refresh the page
    And I create space project with the first user
    When I go to the home page
    And I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | task1313 |

    And I open the task 'task1313'
    And I add this comment 'taskcomment1212' in task

    When I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space project
    And I refresh the page
    Then The 'Spaces' number is '1'

    When I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I open the task 'task1313'
    And I view all task comments
    And I add other comment 'taskcomment1213' in task

    When I change user admin

    And I go to the home page
    And I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I open the task 'task1313'
    And I view all task comments

    Then 'admin Smith' with the task comment 'taskcomment1212' is displayed in task comments drawer
    And First user with the task comment 'taskcomment1213' is displayed in task comments drawer

    And I close task comments drawer
    And I close task drawer

  Scenario: US 3.13.7 [FRONT/BACK] : Update Project Name in Task Drawer
    Given I am authenticated as admin

    And I create space project
    When I go to the home page
    And I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | task1313 |

    When I go to the home page
    And I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I edit the created project title

    When I go to the home page
    And I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project

    Then The project name is displayed in project details
    And Task name 'task1313' is displayed in project details
    And Tasks number '1' is displayed in the column To Do

  Scenario: US 3.13.9 [FRONT/BACK]_(02) : Mark as Completed in Task Drawer
    Given I am authenticated as admin

    And I create space project
    When I go to the home page
    And I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | task1414 |

    And I open the task 'task1414'
    And I mark the task as completed in task drawer without closing the drawer

    Then The task is marked as completed in task drawer
    And I close task drawer

    And Task name 'task1414' is not displayed in project details
    And Tasks number '0' is displayed in the column To Do

  Scenario: Cap182 - [-2287] [PFR] [Can't add a long comment]Comment button is disabled when exceeds the max chars number
    Given I am authenticated as admin
    And I create the first random user

    When I connect with the first created user
    And I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I select 'Tasks' tab
    And The following task is created
      | taskName | task182 |

    And In Tasks tab, I open the task 'task182'
    Then Edit task drawer is displayed

    When I click on Add new comment button
    Then Comments drawer is displayed
    And Message : Please don't exceed 1250 characters, is displayed
    And Comment button is disabled
    And The max chars number is 1250
    And Next to max chars number a green information icon is displayed

    When I enter a comment with more than 1250 characters
    Then The max chars number has been exceeded and it is displayed in red
    And Next to max chars number a red information icon is displayed

    When I close task comments drawer
    And I add this comment 'taskcomment182' in task
    And In Tasks tab, I open the task 'task182'
    And I view all task comments
    And I click on reply button related to comment 'taskcomment182'
    Then Comments drawer is displayed
    And Message : Please don't exceed 1250 characters, is displayed
    And Reply button is disabled
    And The max chars number is 1250
    And Next to max chars number a green information icon is displayed

    When I enter a reply with more than 1250 characters
    Then The max chars number has been exceeded and it is displayed in red
    And Next to max chars number a red information icon is displayed

    When I close task comments drawer
    And I close task drawer
    And I connect with admin
    And I create space project with the first user
    And I go to the home page
    And I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And The following task is created in the specific project
      | taskName | task183 |

    When I connect with the first created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space project
    And I refresh the page
    Then The 'Spaces' number is '1'

    When I go to Tasks Page
    And I select 'Projects' tab
    And I search for the created project
    And I open the created project
    And I open the task 'task183'
    Then Edit task drawer is displayed

    When I click on Add new comment button
    Then Comments drawer is displayed
    And Message : Please don't exceed 1250 characters, is displayed
    And Comment button is disabled
    And The max chars number is 1250
    And Next to max chars number a green information icon is displayed

    When I enter a comment with more than 1250 characters
    Then The max chars number has been exceeded and it is displayed in red
    And Next to max chars number a red information icon is displayed

    When I close task comments drawer
    And I add this comment 'taskcomment183' in task
    And I open the task 'task183'
    And I view all task comments
    And I click on reply button related to comment 'taskcomment183'
    Then Comments drawer is displayed
    And Message : Please don't exceed 1250 characters, is displayed
    And Reply button is disabled
    And The max chars number is 1250
    And Next to max chars number a green information icon is displayed

    When I enter a reply with more than 1250 characters
    Then The max chars number has been exceeded and it is displayed in red
    And Next to max chars number a red information icon is displayed
    And I close task comments drawer
    And I close task drawer

  Scenario: US 3.13.10 [FRONT/BACK] : Update Status, Due Date and Priority in Task Drawer
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

    When I open the task 'task E'
    And I assign task to me
    And I close task drawer

    When I open the task 'task E'
    And I set task due date TODAY
    And I close task drawer

    When I go to the home page
    Then Tasks widget is displayed
    And Task 'task E' is displayed from tasks widget

    When I open 'task E' from widget
    And I set task priority to 'High'
    And I set task status to 'In Progress'
    And I set task due date TOMORROW
    And I close task drawer

    When I go to Tasks Page
    And I open the created task 'task E'
    Then Task priority 'High' is modified successfully
    And Task status 'In Progress' is modified successfully

