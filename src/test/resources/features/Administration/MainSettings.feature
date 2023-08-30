@administration
@mainSettings
Feature: Main settings page features

  Scenario: Main settings elements are displayed
    Given I am authenticated as 'admin' random user
    And I go to main settings page

    When I open access customizations settings
    Then Access customization settings is displayed
    And The apply button is disabled in Main settings customization

    When I refresh the page
    Then Access customization settings is displayed

    When I go back to Main Settings page
    And I refresh the page

    When I open branding customizations settings
    Then Branding customization settings is displayed
    And The apply button is disabled in Main settings customization

    When I refresh the page
    Then Branding customization settings is displayed
    And The apply button is disabled in Main settings customization

    When I go back to Main Settings page
    And I refresh the page

    When I open login customizations settings
    Then Login customization settings is displayed
    And The apply button is disabled in Main settings customization

    When I refresh the page
    Then Login customization settings is displayed

    When I add login page title 'Test Login Title'
    And The apply button is enabled in Main settings customization

    When I add login page sub title 'Test Login Sub Title'
    And The apply button is enabled in Main settings customization

  Scenario: Main settings - Access modification
    Given I am authenticated as 'admin' random user
    And I inject the random space
    And I go to main settings page

    When I open access customizations settings
    Then Access customization settings is displayed

    When I select 'Open' access type
    And I select 'Restricted' access type
    Then Information message is displayed

    When I close the notification
    Then The 'Open' external user switch button is disabled

    When I select 'Open' access type
    Then Information message is displayed

    When I close the notification
    Then The 'Restricted' external user switch button is disabled

    When I select random space as default for registered users
    Then '1' default spaces are selected for registered users

  Scenario: Main settings - Open Access Type
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to main settings page

    When I open access customizations settings
    Then Access customization settings is displayed

    When I select 'Open' access type
    Then The 'Restricted' external user switch button is disabled

    When I apply main settings customizations

    When I go to the random space
    And I go to members tab
    And I open space invitation drawer
    And I enter email 'openregisteruserinvitation@test.com' to invite in random space
    Then The email 'openregisteruserinvitation@test.com' is set to 'Pending' in invitations list

    When I click on 'Invite' button in drawer
    And I wait '3' seconds
    And I open space invitation drawer
    Then The email 'openregisteruserinvitation@test.com' is set to 'Invitation Sent' in invitations list

    When I logout
    Then Register link is displayed

  Scenario: Main settings - Restricted Access Type
    Given I am authenticated as 'admin' random user
    And I create the random space if not existing
    And I go to main settings page

    When I open access customizations settings
    Then Access customization settings is displayed

    When I select 'Restricted' access type
    Then The 'Open' external user switch button is disabled

    When I apply main settings customizations

    When I go to the random space
    And I go to members tab
    And I open space invitation drawer
    And I enter email 'restrictedregisteruserinvitation@test.com' to invite in random space
    Then The email 'restrictedregisteruserinvitation@test.com' is not displayed in invitations list

    When I logout
    Then Register link is not displayed

    When I am authenticated as 'admin' random user
    And I go to main settings page
    And I open access customizations settings
    Then Access customization settings is displayed

    When I switch 'Restricted' access type to enable external users registration
    And I apply main settings customizations

    When I go to the random space
    And I go to members tab
    And I open space invitation drawer
    And I enter email 'restrictedregisteruserinvitation@test.com' to invite in random space
    Then The email 'restrictedregisteruserinvitation@test.com' is set to 'Pending' in invitations list

    When I click on 'Invite' button in drawer
    And I wait '3' seconds
    And I open space invitation drawer
    Then The email 'restrictedregisteruserinvitation@test.com' is set to 'Invitation Sent' in invitations list

    When I logout
    Then Register link is not displayed