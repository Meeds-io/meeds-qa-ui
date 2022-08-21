@appcenter
@appcenterAdministration
Feature: UI app administration
  As an admin user
  I want to manage application
  in order to share them with users

  Scenario: CAP47-[Admin_UI_US12] Applications table/Edit action
    Given I am authenticated as admin
    And I go to Administer application center Page
    When I open 'Analytics' edit drawer
    Then Edit application title is displayed 'Analytics' in drawer
    And  Edit application url is displayed './analytics' in drawer
    And Edit application image is displayed 'Analytics.png' in drawer
    And Edit application mandatory active and mobile are displayed in drawer
    And Edit application permissions '/platform/analytics' and '/platform/administrators' are displayed in drawer
    And I refresh the page

  Scenario: CAP79-[Admin_UI_US07][02]:Delete an app
    Given I am authenticated as admin
    And I go to Administer application center Page
    When I add a new random application
    And I search for the random created application
    And I delete the created application
    And I open the app center menu
    And I open all application page
    And I search for the random created application
    Then The random application is not displayed in application list

  Scenario: CAP80-[Admin_UI_US07][03]:Cancel button /close icon
    Given I am authenticated as admin
    And I go to Administer application center Page
    When I add a new random application
    And I search for the random created application
    And I click on delete icon of the created application
    And I click on cancel delete application
    Then Delete popup is not displayed
    And I refresh the page
    And I search for the random created application
    When I click on delete icon of the created application
    And I click on close popup delete application
    Then Delete popup is not displayed

  Scenario: CAP72 - [Admin_UI_US06][02]: Applications table/ Editable fields(Mandatory option)
    Given I am authenticated as admin

    When I create the first random user if not existing
    And I go to Administer application center Page
    And I add a new random application
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed
    When I search for the random created application
    Then The application is not bookmarked as my favorites
    When I bookmark the random application
    Then The application is bookmarked as my favorites
    Then The created application is displayed in Favorites Applications
    When I unbookmark the random application
    Then The application is not bookmarked as my favorites
    Then The created application is not displayed in Favorites Applications

    When I change user admin
    And I go to Administer application center Page
    And I enable Mandatory for the created application

    And I go to Administer application center Page
    And I search for the random created application
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed
    When I search for the random created application
    Then The application bookmark is disabled

  Scenario: CAP71 - [Admin_UI_US06][01]: Applications table/ Editable fields (Active option)
    Given I am authenticated as admin

    And I create the first random user if not existing
    And I go to Administer application center Page
    And I add a new random application

    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed

    When I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And The random application is displayed in application list
    And The application is not bookmarked as my favorites
    And The created application Open Button is displayed
    And AppCenter created application is removed From Favorites

    When I change user admin

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

    When I change user admin

    And I go to Administer application center Page
    And I search for the random created application
    And I enable Active option for the created application
    And I connect with the first created user
    And I see All Applications
    Then All Applications Page is Displayed

    When I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And I search for the random created application
    And The random application is displayed in application list
    And The application is not bookmarked as my favorites
    And The created application Open Button is displayed
    And AppCenter created application is removed From Favorites
