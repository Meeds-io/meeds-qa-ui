@spaces
Feature: Meeds Space
  As a user
  I want to check spaces page

  Scenario: [SPACES-2] Spaces Cards bloc
    Given I am authenticated as admin

    When I create or check that thirty spaces are created
    And I go to spaces page
    Then I check that only 20 spaces are displayed
    When I click on Show more button
    Then I check that other spaces are displayed

  Scenario: [SPACES-4] Spaces Request
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create a first random space with the first created user as member
    And I create a second random space with the first created user as member
    And I create a third random space with the first created user as member

    When I connect with the first created user
    Then The 'Spaces' badge is '3'
    When I click on spaces badge
    And I accept the invitation of the first created space
    Then The 'Spaces' badge is '2'
    And I reject the invitation of the second created space
    And I refresh the page
    And I click on space invitation widget
    And The third created space is displayed in Spaces Requests section
    And The first created space is not displayed in Spaces Requests section
    And The second created space is not displayed in Spaces Requests section

  @ignored
  Scenario: [SPC_MNG-7] General Space Settings
    Given I am authenticated as admin
    When I go to the random space
    When I click on space settings tab
    Then I check that general settings section is displayed with his edit icon
    And I check that Applications section is displayed with his edit icon

    When I click on edit general space settings
    Then I check that avatar section is displayed
    And I check that space name section is displayed
    And I check that space description section is displayed
    And I check that space template section is displayed
    And I check that hidden section and switch button are displayed
    And I check that registration section is displayed
    And I check that cancel button is displayed
    And I check that update button is displayed

  @ignored
  Scenario: [SPC_MNG-8] Spaces applications management
    Given I am authenticated as admin
    When I go to the random space
    When I click on space settings tab
    Then I check that general settings section is displayed with his edit icon
    And I check that Applications section is displayed with his edit icon

    When I click on arrow icon of application space settings
    Then Space application settings page is opened
    And Application card is displayed
    And Plus button is displayed

    When I click on 3dot icon of application card
    Then Remove application button is displayed
    And Move before application button is displayed
    And Move after application button is displayed

    When I click on plus button to add application
    Then I check that space application installer drawer is displayed
    And I check that applications are displayed

    When I click to add application 'Wallet'
    Then I check that application 'Wallet' is added to applications page

  @ignored
  Scenario: [SPACES-4.1] Spaces Invitations
    Given I am authenticated with the user with the credentials
      | login    | firas.mejri |
      | password | mejri2020   |
    And I delete Spaces invitations on the badge
    When I log out
    And I am authenticated with the user with the credentials
      | login    | aymen.khalfi |
      | password | aymen2020    |
    And I create the space with user 'firas.mejri'
    And I create the second space with user 'firas.mejri'
    When I change user
      | login    | firas.mejri |
      | password | mejri2020   |
    And I click on Spaces Invitations badge '2'
    And I accept First Space Invitation on the badge
    And I reject Second Space Invitation on the badge
    Then I go to First Space
    And The space home page is visible
    Then I go to Second Space
    And The space home page is not visible

  @ignored
  Scenario: [SPACES-4.2]Spaces Sent Requests
    Given I am authenticated with the user with the credentials
      | login    | aymen.khalfi |
      | password | aymen2020    |
    And I create the space with 'validation' access
    And I create the second space with 'validation' access
    And I change user
      | login    | firas.mejri |
      | password | mejri2020   |
    And I go to First Space
    And I 'Request to Join'
    And I go to Second Space
    And I 'Request to Join'
    And I go to spaces page
    When I click on 'Sent Requests' number
    And I refuse the send request to the first space
    And I change user
      | login    | aymen.khalfi |
      | password | aymen2020    |
    And The First space was deleted successfully
