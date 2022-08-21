@challenge
Feature: Challenges

  Scenario: [Challenge_App_US02][02] First screen of the App ( manager of a space+ admin)
    Given I am authenticated as admin
    And I create the fifthchgadm random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the fifthchgadm created user
    And I connect with the fifthchgadm created user
    And I create a random space
    When I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    And Add challenge button should be displayed

  Scenario: [Challenge_App_US02][01] First screen of the App ( not manager of any space)
    Given I am authenticated as admin
    And I create the sixth random user if not existing
    And I connect with the sixth created user
    When I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    And Add challenge button should not be displayed

  Scenario: Challenge_App_Admin_US01 Challenge App
    Given I am authenticated as admin
    And I create the firstchgadm random user if not existing, no wait
    And I create the secondchgadm random user if not existing
    And I create a random space
    And I connect with the firstchgadm created user
    And I go to the random space
    And I connect with the secondchgadm created user
    And I go to the random space
    And I change user admin
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the firstchgadm created user
    And I add the role 'member' to the secondchgadm created user
    When I go to the random space
    And I go to the Space Members tab
    And I promote 'firstchgadm' random user as a space manager
    And I promote 'secondchgadm' random user as a space manager
    And I connect with the firstchgadm created user
    And I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    When I click on the button add challenge
    Then The drawer add challenge should be displayed
    When I enter the challenge title 'challengeStartTomorrow1'
    And I select a space audience
    And I select the program 'Social'
    And I select tomorrow for start date
    And I select next week for end date
    And I add challenge with description 'challengeStartTomorrowDescription1'
    Then The message 'New challenge created successfully.' should be displayed
    And I refresh the page
    And The challenge card title 'challengeStartTomorrow1' should not be displayed
    And I filter challenges by value 'NOT_STARTED'
    And The challenge card title 'challengeStartTomorrow1' should be displayed
    When I connect with the secondchgadm created user
    And I go to the random space
    And I go To AppCenter Drawer
    And I go to Challenge Application
    Then Challenge Application Page is displayed
    When I click on the button add challenge
    And I enter the challenge title 'challenge2'
    And I select a space audience
    And I select the program 'Teamwork'
    And I select today for start date
    And I select next week for end date
    And I add challenge with description 'description2'
    Then The message 'New challenge created successfully.' should be displayed
    When I refresh the page
    Then The challenge card title 'challengeStartTomorrow1' should not be displayed
    And The challenge card title 'challenge2' should be displayed
    And I filter challenges by value 'ALL'
    And The challenge card title 'challengeStartTomorrow1' should be displayed
    And The challenge card title 'challenge2' should be displayed
    And Add challenge button should be displayed

  Scenario: Challenge_App_Admin_US02 Challenge CARD
    Given I am authenticated as admin
    And I create the firstchgadm random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the firstchgadm created user
    And I connect with the firstchgadm created user
    And I create a random space
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

  @test
  Scenario: Challenge_App_US01 Post the challenge on the space stream
    Given I am authenticated as admin
    And I create the firstchgadm random user if not existing, no wait
    And I create the secondchgadm random user if not existing
    And I go to groups Management page
    And I open the group 'Platform'
    When I select the group 'Administration'
    And I add the role 'member' to the firstchgadm created user
    And I connect with the firstchgadm created user
    And I create a random space
    And I connect with the secondchgadm created user
    And I go to the random space
    And I connect with the firstchgadm created user
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
    And I assign the announcement to the secondchgadm user
    And I create announcement with random description
    Then The message 'Announcement created successfully.' should be displayed
    When I connect with the secondchgadm created user
    And I go to the random space
    Then The announcement activity with random description and random challenge title is posted by the 'firstchgadm' with winner name 'secondchgadm'
