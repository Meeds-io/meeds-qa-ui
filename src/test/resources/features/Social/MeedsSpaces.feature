@spaces
Feature: Meeds Space
  As a user
  I want to check spaces page

  Scenario: SPC_MNG-1 : Spaces avatar and title
    Given I am authenticated as admin

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

  Scenario: SPC_MNG-3 : Home space page banner
    Given I am authenticated as admin

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

    When I upload the Space banner 'cap02.png'
    And I go to the random space
    Then Space banner is changed successfully

  Scenario: SPC_MNG-4 : Clickable Space avatar
    Given I am authenticated as admin

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

    When I go to space Home
    Then Space Top Bar Elements are displayed

  Scenario: [SPACES-2] Spaces Cards bloc
    Given I am authenticated as admin

    When I create or check that thirty spaces are created
    And I go to spaces page
    Then I check that only 20 spaces are displayed
    When I click on Show more button
    Then I check that other spaces are displayed

  Scenario: SPACES-4: Spaces Request
    Given I am authenticated as admin
    And I create the first random user if not existing
    And I create a first random space with the first created user as member
    And I create a second random space with the first created user as member
    And I create a third random space with the first created user as member

    When I connect with the first created user
    And I go to Stream page
    Then The Spaces badge is '3'
    When I click on spaces badge
    And I accept the invitation of the first created space
    Then The Spaces badge is '2'
    And I reject the invitation of the second created space
    And I refresh the page
    And I click on space invitation widget
    And The third created space is displayed in Spaces Requests section
    And The first created space is not displayed in Spaces Requests section
    And The second created space is not displayed in Spaces Requests section

  Scenario: [SPC_MNG-8] Spaces applications management
    Given I am authenticated as admin
    When I create a random space
    And I add application 'Notes' in random space if not existing
    When I go to Settings in space tab
    Then I check that general settings section is displayed with his edit icon
    And I check that Applications section is displayed with his edit icon

    When I click on arrow icon of application space settings
    Then Space application settings page is opened
    And Application card is displayed
    And Plus button is displayed

    When I click on three dots icon of 'Notes' application
    Then 'Remove' option of the application 'Notes' is displayed
    And 'Move before' option of the application 'Notes' is displayed
    When I click to move 'Notes' application before
    And I click on three dots icon of 'Notes' application
    Then 'Move after' option of the application 'Notes' is displayed
    And I click on 'Remove' option from application 'Notes' menu
    And  I confirm to remove the application

    When I click on plus button to add application
    Then I check that space application installer drawer is displayed
    And I check that applications are displayed
    And I click to add application 'Notes'
    Then I check that application 'Notes' is added to applications page
