@appcenter
@appcenterUser
Feature: To be able to access applications
  As a user
  I want to access any application from the app center

  @smoke
  Scenario: CAP31-US 7.7[FRONT]_(01):My applications button on Desktop
    Given I am authenticated as admin
    Then my applications button is displayed

  Scenario: CAP06 - Open an exo application from the drawer
    Given I am authenticated as admin
    When I go To AppCenter Drawer
    And I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed
    When I go To AppCenter Drawer
    And I go to Wallet AppCenter Application
    Then Wallet Application Page is displayed

  Scenario: CAP07 - Open an external application from the drawer
    Given I am authenticated as admin
    And I go to Administer application center Page
    And I disable Mandatory 'Tasks' for application
    When I see All Applications
    Then All Applications Page is Displayed
    When I add Application 'Tasks' To Favorites
    Then AppCenter Application 'Tasks' is added To Favorites

    When I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I see All Applications
    Then All Applications Page is Displayed

    When I remove Application 'Tasks' From Favorites
    Then AppCenter Application 'Tasks' is removed From Favorites
    And I refresh the page
    And I go to Administer application center Page
    And I enable Mandatory 'Tasks' for application

  Scenario: CAP16 - Design V6-Buttons of an Application card
    Given I am authenticated as admin

    When I see All Applications
    Then All Applications Page is Displayed

    Then Add Application 'Notes' To Favorites Btn Is Displayed

    Then 'Notes' Application Open Button is displayed

  Scenario: CAP17 - Design V6-Star button of an app card
    Given I am authenticated as admin
    And I go to Administer application center Page
    And I disable Mandatory 'Challenges' for application
    And I create the first random user
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the first created user
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed

    When I add Application 'Challenges' To Favorites
    Then AppCenter Application 'Challenges' is added To Favorites

    When I go to Challenges AppCenter Application
    Then Challenges Application Page is displayed

    When I see All Applications
    Then All Applications Page is Displayed

    When I remove Application 'Challenges' From Favorites
    Then AppCenter Application 'Challenges' is removed From Favorites
    And I refresh the page
    And I go to Administer application center Page
    And I enable Mandatory 'Challenges' for application

  Scenario: CAP18 - Design V6-Open button of an exo app card
    Given I am authenticated as admin

    When I see All Applications
    Then All Applications Page is Displayed

  Scenario: CAP19 - [User_UI_US12][02]: Design V6-Open button of an external app card
    Given I am authenticated as admin

    When I see All Applications
    Then All Applications Page is Displayed

    When Star button for adding application 'Tasks' to Favorites is displayed
    And I click on 'Tasks' Application Open Button
    Then Tasks Application Page is displayed

  Scenario: CAP24 - Unfavorite app from right panel "Favorite applications"
    Given I am authenticated as admin
    And I go to Administer application center Page
    And I disable Mandatory 'Tasks' for application
    And I create the first random user
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the first created user
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed

    When I add Application 'Tasks' To Favorites
    Then Application 'Tasks' is displayed in Favorites Applications
    And AppCenter Application 'Tasks' is added To Favorites

    When I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I see All Applications
    Then All Applications Page is Displayed

    When I remove Application 'Tasks' From Favorites
    Then Application 'Tasks' is not displayed in Favorites Applications
    And AppCenter Application 'Tasks' is removed From Favorites
    And I refresh the page
    And I go to Administer application center Page
    And I enable Mandatory 'Tasks' for application

  Scenario: CAP26 - [User_Settings_US03]: Max number of fav apps/Mandatory apps
    Given I am authenticated as admin
    And I go to Administer application center Page
    And I disable Mandatory 'Tasks' for application
    And I create the first random user
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the first created user
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed

    When I add Application 'Tasks' To Favorites
    Then Application 'Tasks' is displayed in Favorites Applications
    And The message 'You can’t set more than 12 favorites' is displayed
    Then AppCenter Application 'Tasks' is added To Favorites

    When I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I see All Applications
    Then All Applications Page is Displayed

    When I remove Application 'Tasks' From Favorites
    Then Application 'Tasks' is not displayed in Favorites Applications
    Then AppCenter Application 'Tasks' is removed From Favorites
    And I refresh the page
    And I go to Administer application center Page
    And I enable Mandatory 'Tasks' for application

  Scenario: CAP34 - [User_UI_US021][02]: Check the display of Mandatory apps when its no longer considered as mandatory app
    Given I am authenticated as admin
    When I go to Administer application center Page
    And I search for application 'Perks'
    And I disable Mandatory 'Perks' for application
    Then AppCenter Application 'Perks' is removed From Favorites

    When I close AppCenter Drawer
    And I see All Applications
    Then Star button for adding application 'Perks' to Favorites is displayed
    And Application 'Perks' is not displayed in Favorites Applications

    When I go to Administer application center Page
    And I search for application 'Perks'
    And I enable Mandatory 'Perks' for application

    Then AppCenter Application 'Perks' is added To Favorites