@appcenter
Feature: Application center Addon
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

  Scenario: CAP79-[Admin_UI_US07][02]Delete an app
    Given I am authenticated as admin
    And I go to Administer application center Page
    When I add a new random application
    And I search for the random created application
    And I delete the created application
    And I open the app center menu
    And I open all application page
    And I search for the random created application
    Then The random application is not displayed in application list

  Scenario: CAP80-[Admin_UI_US07][03]Cancel button /close icon
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

  Scenario: CAP72 - [Admin_UI_US06][02] Applications table/ Editable fields(Mandatory option)
    Given I am authenticated as admin

    When I create the first random user if not existing, no wait
    And I go to Administer application center Page
    And I add a new random application
    And I connect with the first created user
    And I see All Applications
    Then The message 'You can’t set more than 12 favorites' is displayed
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
    Then The application bookmark is disabled

  Scenario: CAP71 - [Admin_UI_US06][01] Applications table/ Editable fields (Active option)
    Given I am authenticated as admin

    And I create the first random user if not existing, no wait
    And I go to Administer application center Page
    And I add a new random application

    And I connect with the first created user
    And I see All Applications

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
    And I search for the random created application
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
    And I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And I search for the random created application
    And The random application is displayed in application list
    And The application is not bookmarked as my favorites
    And The created application Open Button is displayed
    And AppCenter created application is removed From Favorites

  Scenario: CAP50 - Admin_Settings_US06 - Active option
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait
    And I go to Administer application center Page
    When I add a new random application
    And I connect with the first created user
    And I open the app center menu
    And I open all application page
    And I search for the random created application
    Then The random application is displayed in application list
    When I change user admin
    And I go to Administer application center Page
    And I click on the added application active button
    And I connect with the first created user
    And I open the app center menu
    And I open all application page
    And I search for the random created application
    Then The random application is not displayed in application list

  Scenario: CAP53 - Edit an app which contain an attached image
    Given I am authenticated as admin

    When I go to Administer application center Page
    And I add a new random application with the title, the url and the description with image <cap02.png>
    And I search for the random created application
    Then The added application with permission '*:/platform/users' is displayed in Applications Table

    When I open the added application edit drawer
    Then Application image title 'cap02.png' is displayed in the drawer
    When I remove the uploaded image from application drawer
    Then Application image title 'cap02.png' is not displayed in the drawer

    When I click on Save in application drawer
    Then The image of the application is not displayed in Applications Table

    When I add a second random application with the title, the url and the description with image <cap03.png>
    And I search for the second random created application
    Then Second application Title is displayed in Applications Table
    And Second application Url is displayed in Applications Table
    And Second application Description is displayed in Applications Table

    When I open the second added application edit drawer
    Then Application image title 'cap03.png' is displayed in the drawer
    When I remove the uploaded image from application drawer
    Then Application image title 'cap03.png' is not displayed in the drawer
    When I click on Save in application drawer
    Then The image of the second application is not displayed in Applications Table

  Scenario: CAP55 - Edit the title ,URL, description field for an app
    Given I am authenticated as admin

    And I go to Administer application center Page
    When I add a new random application with the title, the url and the description
    And I search for the random created application
    Then First application Title is displayed in Applications Table
    And First application Url is displayed in Applications Table
    And First application Description is displayed in Applications Table

    When I edit the first added application data
    And I search for the edited random application
    Then First application edited Title is displayed in Applications Table
    And First application edited Url is displayed in Applications Table
    And First application edited Description is displayed in Applications Table

  Scenario: CAP56 - Admin_Settings_US04: Default permissions for an app
    Given I am authenticated as admin
    And I create the first random user if not existing, no wait

    And I go to Administer application center Page
    When I add a new random application with the title, the url and the description
    And I search for the random created application
    Then The added application with permission '*:/platform/users' is displayed in Applications Table

    When I connect with the first created user

    When I see All Applications
    And I search for the random created application
    Then The application is not bookmarked as my favorites
    And The created application is not displayed in Favorites Applications
