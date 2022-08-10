@challenge
Feature: Challenges

  Scenario: [Challenge_App_US02][02]: First screen of the App ( manager of a space+ admin)
    Given I am authenticated as admin
    And I create the first random user
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the first created user
    And I connect with the first created user
    And I create the first space
    When I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    And Add challenge button should be displayed

  Scenario: [Challenge_App_US02][01]: First screen of the App ( not manager of any space)
    Given I am authenticated as admin
    And I create the first random user
    And I connect with the first created user
    When I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    And Add challenge button should not be displayed

  @failing
  @test
  Scenario: Challenge_App_Admin_US01: Challenge App
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the first created user
    And I add the role 'member' to the second created user
    And I connect with the first created user
    And I create random space with the second created user
    And I connect with the second created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I connect with the first created user
    And I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    When I click on the button add challenge
    Then The drawer add challenge should be displayed
    When I enter the challenge title 'challenge1'
    And I select a space audience
    And I select the program 'Social'
    And I select tomorrow for start date
    And I select next week for end date
    And I add challenge with description 'description1'
    Then The message 'New challenge created successfully.' should be displayed
    And I refresh the page
    And I connect with the second created user
    And I create the second random space
    And I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    #And I refresh the page
    When I click on the button add challenge
    When I enter the challenge title 'challenge2'
    And I select a space audience with second user
    And I select the program 'Teamwork'
    And I select today for start date
    And I select next week for end date
    And I add challenge with description 'description2'
    Then The message 'New challenge created successfully.' should be displayed
    And I refresh the page
    Then The challenge card title 'challenge1' should be displayed
    And The challenge card title 'challenge2' should be displayed
    And Add challenge button should be displayed

  @failing
  Scenario: Challenge_App_Admin_US02: Challenge CARD
    Given I am authenticated as admin
    And I create the first random user
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the first created user
    And I connect with the first created user
    And I create the random space
    And I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    When I click on the button add challenge
    Then The drawer add challenge should be displayed
    And I enter a random challenge title
    And I select a space audience
    And I select the program 'Feedback'
    And I select today for start date
    And I select tomorrow for end date
    And I add challenge with random description
    Then The message 'New challenge created successfully.' should be displayed
    And I refresh the page
    Then The challenge title should be displayed on the card
    And Three dots icon should be displayed on the challenge card
    And Announce button should be displayed on the challenge card
    And Date indication should be displayed on the challenge card

  Scenario:Challenge_App_US01: Post the challenge on the space stream
    Given I am authenticated as admin
    And I create the first random user
    And I create the second random user
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the first created user
    And I connect with the first created user
    And I create random space with the second created user
    And I connect with the second created user
    Then The 'Spaces' badge is '1'
    When I click on spaces badge
    And I accept the invitation of the created space
    And I connect with the first created user
    And I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    When I click on the button add challenge
    Then The drawer add challenge should be displayed
    And I enter a random challenge title
    And I select a space audience
    And I select the program 'Social'
    And I select today for start date
    And I select tomorrow for end date
    And I add challenge with random description
    Then The message 'New challenge created successfully.' should be displayed
    And I refresh the page
    And I click on the announce button
    Then The announcement drawer should be displayed
    And I assign the announcement to the second user
    And I create announcement with random description
    Then The message 'Announcement created successfully.' should be displayed
    When I connect with the second created user
    And I go to Stream page
    Then  The announcement activity is posted by the first user in the created space
    And The winner name should be displayed on the announcement activity
    And The challenge title should be displayed on the announcement activity
    And Achievement description should be displayed on the announcement activity

