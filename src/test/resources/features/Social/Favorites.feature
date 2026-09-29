@favorite
Feature: Favorite activities

  Scenario: Bookmark an activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'favorite activity'
    And I publish the activity
    When I go to Stream page
    Then The favorite star should be displayed in the published activity 'favorite activity'
    When I favorite the activity posted in the space
    Then Success message is displayed

  Scenario: Remove the Bookmark for an activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'bookmark activity'
    And I publish the activity
    Then The favorite star should be displayed in the published activity 'bookmark activity'
    When I favorite the activity posted in the space
    Then Success message is displayed
    When I go to Stream page
    And I unbookmark the favorite activity posted in the space
    Then Success message is displayed

  Scenario: Search by favorites (Filter by favorite button)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I post '3' activities with prefix 'act_Fav_US05_01_'
    And I refresh the page
    Then the activity 'act_Fav_US05_01_0' is displayed in activity stream
    And the activity 'act_Fav_US05_01_1' is displayed in activity stream
    And the activity 'act_Fav_US05_01_2' is displayed in activity stream
    When I bookmark the activity 'act_Fav_US05_01_1'
    Then Success message is displayed
    When I bookmark the activity 'act_Fav_US05_01_2'
    Then Success message is displayed
    When I go to Stream page
    And I access to the unified search page
    When I click on the favorite button
    Then The activity is displayed in the search 'act_Fav_US05_01_1'
    And The activity is displayed in the search 'act_Fav_US05_01_2'
    And The activity is not displayed in the search 'act_Fav_US05_01_0'
    When I click on the favorite button
    Then The activity is not displayed in the search 'act_Fav_US05_01_0'
    And The activity is not displayed in the search 'act_Fav_US05_01_1'
    And The activity is not displayed in the search 'act_Fav_US05_01_2'

  Scenario: Search by favorites (Filter by keyword and favorite button)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I post '2' activities with prefix 'activityFavs_US05'
    And I refresh the page
    Then the activity 'activityFavs_US050' is displayed in activity stream
    And the activity 'activityFavs_US051' is displayed in activity stream
    And the activity 'activityFavs_US052' is displayed in activity stream
    When I bookmark the activity 'activityFavs_US051'
    Then Success message is displayed
    When I bookmark the activity 'activityFavs_US052'
    Then Success message is displayed
    When I go to Stream page
    And I start the search for 'activityFavs_US05'
    Then The activity is displayed in the search 'activityFavs_US050'
    And The activity is displayed in the search 'activityFavs_US051'
    And The activity is displayed in the search 'activityFavs_US052'
    When I click on the favorite button
    Then The activity is displayed in the search 'activityFavs_US051'
    And The activity is displayed in the search 'activityFavs_US052'
    And The activity is not displayed in the search 'activityFavs_US050'
    When I click on the favorite button
    Then The activity is displayed in the search 'activityFavs_US051'
    And The activity is displayed in the search 'activityFavs_US052'
    And The activity is displayed in the search 'activityFavs_US050'

  Scenario: Manage favorites from the search card ( Bookmark an activity)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I post '2' activities with prefix 'activityFavs_US06_01_'
    And I refresh the page
    Then the activity 'activityFavs_US06_01_0' is displayed in activity stream
    And the activity 'activityFavs_US06_01_1' is displayed in activity stream
    And the activity 'activityFavs_US06_01_2' is displayed in activity stream
    When  I start the search for 'activityFavs_US06_01_'
    Then The activity is displayed in the search 'activityFavs_US06_01_1'
    And The activity is displayed in the search 'activityFavs_US06_01_2'
    And The activity is displayed in the search 'activityFavs_US06_01_0'
    When I favorite the activity 'activityFavs_US06_01_1' from the search page
    And I click on the favorite button
    And I refresh the page
    Then The activity is displayed in the search 'activityFavs_US06_01_1'
    And The activity is not displayed in the search 'activityFavs_US06_01_2'
    And The activity is not displayed in the search 'activityFavs_US06_01_0'

  Scenario: Manage favorites from the search card ( UnBookmark an activity)
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I inject a random space
    And I go to the random space
    When I post '2' activities with prefix 'activityFavs_US06_02_'
    And I refresh the page
    Then the activity 'activityFavs_US06_02_0' is displayed in activity stream
    And the activity 'activityFavs_US06_02_1' is displayed in activity stream
    And the activity 'activityFavs_US06_02_2' is displayed in activity stream
    When I bookmark the activity 'activityFavs_US06_02_2'
    Then Success message is displayed
    When  I start the search for 'activityFavs_US06_02_'
    Then The activity is displayed in the search 'activityFavs_US06_02_1'
    And The activity is displayed in the search 'activityFavs_US06_02_2'
    And The activity is displayed in the search 'activityFavs_US06_02_0'
    When I favorite the activity 'activityFavs_US06_02_2' from the search page
    And I click on the favorite button
    And I refresh the page
    Then The activity is not displayed in the search 'activityFavs_US06_02_2'
    And The activity is not displayed in the search 'activityFavs_US06_02_1'
    And The activity is not displayed in the search 'activityFavs_US06_02_0'

  Scenario: Bookmark a space as a favorite (space page)
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing
    And I create a random space
    And I login as 'first' random user
    And I go to the random space
    And I 'Join'
    When I go to spaces page
    And  I search for the random space
    Then The favorite icon should be displayed in space card
    When I bookmark the random space as favorite from space card
    Then Confirmation message is displayed 'Favorite added successfully. Find it easily from the search'
    When I close the notification
    Then  I check that the random space is bookmarked as favorite from space card
    When I unfavorite the random space from space card
    Then Confirmation message is displayed 'The item has been removed from favorites successfully.'
    When I close the notification
    Then I check that the random space is unbookmarked from space card

  Scenario: Bookmark space from topbar space popover
    Given I am authenticated as 'admin' random user
    And I inject the first random user if not existing
    And I create a random space
    And I login as 'first' random user
    And I go to the random space
    And I hover on space name from top bar
    Then The favorite icon should be displayed in space popover from topbar
    When I bookmark the random space as favorite from topbar space popover
    Then Confirmation message is displayed 'Favorite added successfully. Find it easily from the search'
    When I close the notification
    And I hover on space name from top bar
    Then  I check that the random space is bookmarked as favorite from topbar space popover
    When I unfavorite the random space from topbar space popover
    Then Confirmation message is displayed 'The item has been removed from favorites successfully.'
    When I close the notification
    And I hover on space name from top bar
    Then I check that the random space is unbookmarked from topbar space popover

  Scenario: Bookmark space from the left menu (desktop)
    Given I am authenticated as 'admin' random user
    And I go to the seven random space
    And I go to the nine random space
    And I access to Recent spaces
    And I search for the nine created space in Side Bar Filter
    Then Nine searched space is displayed in Side Bar Filter
    When I hover on the nine searched Space In side bar filter
    Then The arrow is displayed when hovering on searched space in Side Bar Filter
    When I click on the arrow displayed when hovering the searched space in Side Bar Filter
    Then The third level Navigation should display the space details panel
    And The favorite icon should be displayed on space details panel
    When I bookmark the random space as favorite from Third Navigation Level
    Then Confirmation message is displayed 'Favorite added successfully. Find it easily from the search'
    When I close the notification
    Then I check that the random space is bookmarked as favorite from Third Navigation Level
    When I unfavorite the random space from Third Navigation Level
    Then Confirmation message is displayed 'The item has been removed from favorites successfully.'
    When I close the notification
    Then I check that the random space is unbookmarked from Third Navigation Level

  Scenario: Filter my stream by favorite spaces
    Given I am authenticated as 'admin' random user
    And I go to the ninety random space
    And I click on post in space
    And I enter an activity 'Test1'
    When I publish the activity
    Then the activity 'Test1' is displayed in activity stream
    When I go to the ninetyone random space
    And I click on post in space
    And I enter an activity 'Test2'
    And I publish the activity
    Then the activity 'Test2' is displayed in activity stream
    When I access to Recent spaces
    And I search for the ninety created space in Side Bar Filter
    Then Ninety searched space is displayed in Side Bar Filter
    When I hover on the ninety searched Space In side bar filter
    Then The arrow is displayed when hovering on searched space in Side Bar Filter
    When I click on the arrow displayed when hovering the searched space in Side Bar Filter
    Then The third level Navigation should display the space details panel
    And The favorite icon should be displayed on space details panel
    When I bookmark the random space as favorite from Third Navigation Level
    Then Confirmation message is displayed 'Favorite added successfully. Find it easily from the search'
    When I close the notification
    Then I check that the random space is bookmarked as favorite from Third Navigation Level
    And I refresh the page
    Given I go to Stream page
    Then the activity 'Test1' is displayed in stream page
    And the activity 'Test2' is displayed in stream page
    When I click on filter icon from composer
    And I click on 'My favorite spaces' activity filter radio button
    And I click on 'Apply' button in drawer
    And the activity 'Test1' is displayed in stream page
    Then the activity 'Test2' is not displayed in stream page
    And I click on filter icon from composer
    And I click on 'All' activity filter radio button
    And I click on 'Apply' button in drawer

