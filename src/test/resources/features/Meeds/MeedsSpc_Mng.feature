@spacesMgmt
Feature: Spaces Management
  As a user
  I want to check that Space details and sections are displayed

  Scenario: SPC_MNG-1 : Spaces avatar and title
    Given I am authenticated as admin

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed

  Scenario: SPC_MNG-2 : Space applications
    Given I am authenticated as admin

    When I go to the random space

    Then Space Avatar is displayed
    And The created space name is displayed
    And First created space Tabs are displayed in order


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
    Then First created space Tabs are displayed in order
