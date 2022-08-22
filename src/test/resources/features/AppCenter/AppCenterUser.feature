@appcenter
@appcenterUser
Feature: To be able to access applications
  As a user
  I want to access any application from the app center

  @smoke
  Scenario: CAP31-US 7.7[FRONT]_(01):My applications button on Desktop
    Given I am authenticated as admin
    Then my applications button is displayed

  Scenario: CAP06 - Open an application from the AppCenter drawer
    Given I am authenticated as admin
    When I go To AppCenter Drawer
    And I go to Perk Store AppCenter Application
    Then Perk Store Application Page is displayed
    When I go To AppCenter Drawer
    And I go to Wallet AppCenter Application
    Then Wallet Application Page is displayed

  Scenario: CAP07 - Open an external application from the drawer
    Given I am authenticated as admin
    And I go to Administer application center Page

    And I add a new application with the following data
      | Application title    | appCenterCAP07 |
      | Application description | App center CAP07   |
      | Application url | ./cap07   |
    And I disable Mandatory 'appCenterCAP07' for application
    When I see All Applications
    Then All Applications Page is Displayed
    When I add Application 'appCenterCAP07' To Favorites
    Then AppCenter Application 'appCenterCAP07' is added To Favorites

    When I go to Tasks AppCenter Application
    Then Tasks Application Page is displayed

    When I see All Applications
    Then All Applications Page is Displayed
    And The message 'You can’t set more than 12 favorites' is displayed

    When I remove Application 'appCenterCAP07' From Favorites
    Then AppCenter Application 'appCenterCAP07' is removed From Favorites

  Scenario: CAP19 - [User_UI_US12][02]: Design V6-Open button of an external app card
    Given I am authenticated as admin

    When I see All Applications
    Then All Applications Page is Displayed

    When I click on 'Tasks' Application Open Button
    Then Tasks Application Page is displayed

  Scenario: CAP34 - [User_UI_US021][02]: Check the display of Mandatory apps when its no longer considered as mandatory app
    Given I am authenticated as admin
    When I go to Administer application center Page
    And I add a new application with the following data
      | Application title    | appCenterCAP34 |
      | Application description | App center CAP34   |
      | Application url | ./cap34   |
    And I search for application 'appCenterCAP34'
    Then AppCenter Application 'appCenterCAP34' is removed From Favorites

    And I see All Applications
    Then The application 'appCenterCAP34' is not bookmarked as my favorites
    And Application 'appCenterCAP34' is not displayed in Favorites Applications

    When I bookmark the application 'appCenterCAP34'
    Then The application 'appCenterCAP34' is bookmarked as my favorites
    And Application 'appCenterCAP34' is displayed in Favorites Applications

    When I unbookmark the application 'appCenterCAP34'
    Then The application 'appCenterCAP34' is not bookmarked as my favorites
    And Application 'appCenterCAP34' is not displayed in Favorites Applications

    When I go to Administer application center Page
    And I search for application 'appCenterCAP34'
    And I enable Mandatory 'appCenterCAP34' for application

    Then AppCenter Application 'appCenterCAP34' is added To Favorites