Feature: UI app administration
  As an admin user
  I want to manage application
  in order to share them with users

  @appcenter
  Scenario: CAP47-[Admin_UI_US12]:Applications table/Edit action
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |
    And I go to Administer application center Page
    When I open 'Tasks' edit drawer
    Then Edit application title is displayed 'Tasks' in drawer
    And  Edit application url is displayed './tasks' in drawer
    And Edit application image is displayed 'Tasks.png' in drawer
    And Edit application mandatory active and mobile are displayed in drawer
    And Edit application permissions '/platform/users' and '/platform/externals' are displayed in drawer
    And I refresh the page

  @appcenter
  Scenario: CAP79-[Admin_UI_US07][02]:Delete an app
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |
    And I go to Administer application center Page
    When I add a new application with the random following data
    And I search for the random created application
    And I delete the created application
    And I open the app center menu
    And I open all application page
    And I search for the random created application
    Then The random application is not displayed in application list

  @appcenter
  Scenario:CAP80-[Admin_UI_US07][03]:Cancel button /close icon
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |
    And I go to Administer application center Page
    When I add a new application with the random following data
    And I search for the random created application
    And I click on delete icon of the created application
    And I click on cancel delete application
    Then Delete popup is not displayed
    When I click on delete icon of the created application
    And I click on close popup delete application
    Then Delete popup is not displayed

  @appcenter
  Scenario: CAP72 - [Admin_UI_US06][02]: Applications table/ Editable fields(Mandatory option)
    Given I am authenticated as
      | login    | superadmin |
      | password | password   |

    When I create the first random user
    And I go to Administer application center Page
    And I add a new application with the random following data
    And I search for the random created application
    And I enable Mandatory for the created application
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed
    When I search for the random created application
    Then The created application is displayed in Favorites Applications
    And Star button for removing the created application from Favorites is displayed
    And AppCenter created application is added To Favorites
    And I close AppCenter Drawer

    When I change user
      | login    | superadmin |
      | password | password   |

    And I go to Administer application center Page
    And I search for the random created application
    And I disable Mandatory for the created application
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed
    When I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And Star button for adding the created application to Favorites is displayed
    And AppCenter created application is removed From Favorites
    And I close AppCenter Drawer

  @appcenter
  Scenario: CAP71 - [Admin_UI_US06][01]: Applications table/ Editable fields (Active option)
    Given I am authenticated as
      | login    | superadmin |
      | password | password   |

    And I create the first random user
    And I go to Administer application center Page
    And I add a new application with the random following data

    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed

    When I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And The random application is displayed in application list
    And Star button for adding the created application to Favorites is displayed
    And The created application Open Button is displayed
    And AppCenter created application is removed From Favorites
    And I close AppCenter Drawer

    When I change user
      | login    | superadmin |
      | password | password   |

    And I go to Administer application center Page
    And I search for the random created application
    And I disable Active option for the created application
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed

    When I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And I refresh the page
    And The random application is not displayed in application list
    And AppCenter created application is removed From Favorites
    And I close AppCenter Drawer

    When I change user
      | login    | superadmin |
      | password | password   |

    And I go to Administer application center Page
    And I search for the random created application
    And I enable Active option for the created application
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed

    When I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And The random application is displayed in application list
    And Star button for adding the created application to Favorites is displayed
    And The created application Open Button is displayed
    And AppCenter created application is removed From Favorites
    And I close AppCenter Drawer