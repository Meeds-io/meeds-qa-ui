Feature: Meeds Space
  As a user
  I want to check spaces page

  Scenario:[SPACES-2] Spaces Cards bloc
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |

    When I create thirty random space
    And I go to spaces page
    Then I check that only 20 spaces are displayed
    When I click on Show more button
    Then I check that other spaces are displayed

  Scenario: [SPACES-4] Spaces Request
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |

    And I create the first random user

    And I refresh the page
    And I create random space with the first created user
    And I create second random space with the first created user
    And I create third random space with the first created user

    When I connect with the first created user
    Then The 'Spaces' badge is '3'
    When I click on spaces badge
    And I accept the invitation of the created space
    Then The 'Spaces' badge is '2'
    And I reject the invitation of the second created space
    And I refresh the page
    And I click on space invitation widget
    Then The third created space is displayed in Spaces Requests section
    And The first created space is not displayed in Spaces Requests section
    And The second created space is not displayed in Spaces Requests section

  Scenario: [SPC_MNG-7] General Space Settings
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |
    When I create the random space
    And I click on space settings tab
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

  Scenario: [SPC_MNG-8] Spaces applications management
    Given I am authenticated as
      | login    | admin  |
      | password | gtngtn |
    When I create the random space
    And I click on space settings tab
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



