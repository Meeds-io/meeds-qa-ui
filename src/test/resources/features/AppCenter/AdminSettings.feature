Feature: Administration settings
  As an admin user
  I want to manage application
  in order to share them with users

	@appcenter
	@appcenterSettings
  Scenario: CAP50 - Admin_Settings_US06:Active option
    Given I am authenticated as admin
    And I create the first random user
    And I go to Administer application center Page
    When I add a new application with the random following data
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

  @appcenter
  @appcenterSettings
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
    Then The image of the application 'cap02.png' is not displayed in Applications Table

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
    Then The image of the application 'cap03.png' is not displayed in Applications Table

  @appcenter
  @appcenterSettings
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

  @appcenter
  @appcenterSettings
  Scenario: CAP56 - Admin_Settings_US04: Default permissions for an app
    Given I am authenticated as admin
    And I create the first random user

    And I go to Administer application center Page
    When I add a new random application with the title, the url and the description
    Then The added application with permission '*:/platform/users' is displayed in Applications Table

    When I connect with the first created user

    When I see All Applications
    Then Star button for adding the first added application to Favorites is displayed
    And First added application is not displayed in Favorites Applications