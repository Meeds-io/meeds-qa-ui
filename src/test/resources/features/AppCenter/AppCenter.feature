@appcenter
Feature: Application center Addon
  As an admin user
  I want to manage application
  in order to share them with users

  Scenario: Delete an app
    Given I am authenticated as 'admin' random user
    And I go to Administer application center Page
    When I add a new random application
    And I search for the random created application
    And I delete the created application
    And I go To AppCenter Drawer
    And I open all application page
    And I search for the random created application
    Then The random application is not displayed in application list

  Scenario: Cancel button /close icon
    Given I am authenticated as 'admin' random user
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

  Scenario: Applications table/ Editable fields(Mandatory option)
    Given I am authenticated as 'admin' random user

    When I inject the first random user if not existing, no wait
    And I go to Administer application center Page
    And I add a new random application
    And I login as 'first' random user
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

    When I login as 'admin' random user
    And I go to Administer application center Page
    And I enable Mandatory for the created application

    And I go to Administer application center Page
    And I search for the random created application
    And I login as 'first' random user
    And I see All Applications
    Then The application bookmark is disabled

  Scenario: Applications table/ Editable fields (Active option)
    Given I am authenticated as 'admin' random user

    And I inject the first random user if not existing, no wait
    And I go to Administer application center Page
    And I add a new random application

    And I login as 'first' random user
    And I see All Applications

    When I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And The random application is displayed in application list
    And The application is not bookmarked as my favorites
    And The created application Open Button is displayed
    And AppCenter created application is removed From Favorites

    When I login as 'admin' random user

    And I go to Administer application center Page
    And I search for the random created application
    And I disable Active option for the created application
    And I login as 'first' random user
    And I see All Applications
    And I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And I refresh the page
    And The random application is not displayed in application list
    And AppCenter created application is removed From Favorites

    When I login as 'admin' random user

    And I go to Administer application center Page
    And I search for the random created application
    And I enable Active option for the created application
    And I login as 'first' random user
    And I see All Applications
    And I search for the random created application
    Then The created application is not displayed in Favorites Applications
    And I search for the random created application
    And The random application is displayed in application list
    And The application is not bookmarked as my favorites
    And The created application Open Button is displayed
    And AppCenter created application is removed From Favorites

  Scenario: AppCenter active option
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing, no wait
    And I go to Administer application center Page
    When I add a new random application
    And I login as 'first' random user
    And I go To AppCenter Drawer
    And I open all application page
    And I search for the random created application
    Then The random application is displayed in application list
    When I login as 'admin' random user
    And I go to Administer application center Page
    And I click on the added application active button
    And I login as 'first' random user
    And I go To AppCenter Drawer
    And I open all application page
    And I search for the random created application
    Then The random application is not displayed in application list

  Scenario: Edit in AppCenter which contain an attached image
    Given I am authenticated as 'admin' random user

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

  Scenario: Edit in AppCenter title ,URL and description fields
    Given I am authenticated as 'admin' random user

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

  Scenario: AppCenter default permissions for an app
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing, no wait

    And I go to Administer application center Page
    When I add a new random application with the title, the url and the description
    And I search for the random created application
    Then The added application with permission '*:/platform/users' is displayed in Applications Table

    When I login as 'first' random user

    When I see All Applications
    And I search for the random created application
    Then The application is not bookmarked as my favorites
    And The created application is not displayed in Favorites Applications
