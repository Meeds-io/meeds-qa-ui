# new feature
# Tags: optional
Feature: Favorite activities


  @executetest
  Scenario: [Favs_US03]: Bookmark an activity
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the first random user
    And I connect with the first created user
    And I create the space
    When I click on post in space
    And I enter an activity 'favorite activity'
    And I publish the activity
    When I go to Stream page
    Then The favorite star should be displayed in the published activity 'favorite activity'
    When I favorite the activity posted in the space
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed

  Scenario: [Favs_US04]: Remove the Bookmark for an activity
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I connect with the first created user
    And I create the space
    When I click on post in space
    And I enter an activity 'bookmark activity'
    And I publish the activity
    Then The favorite star should be displayed in the published activity 'bookmark activity'
    When I favorite the activity posted in the space
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I go to Stream page
    And I unbookmark the favorite activity posted in the space
    Then The favorite success message 'The item has been removed from favorites successfully.' should be displayed

  Scenario: [Favs_US05][01]: Search by favorites (Filter by favorite button)
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I connect with the first created user
    And I create the space
    When I post '2' activities
    And I refresh the page
    Then the activity 'act0' is displayed in activity stream
    And the activity 'act1' is displayed in activity stream
    And the activity 'act2' is displayed in activity stream
    When I bookmark the activity 'act1'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I bookmark the activity 'act2'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I go to Stream page
    And I access to the unified search page
    When I click on the favorite button
    Then The activity is displayed in the search 'act1'
    And The activity is displayed in the search 'act2'
    And The activity is not displayed in the search 'act0'
    When I click on the favorite button
    Then The activity is not displayed in the search 'act0'
    And The activity is not displayed in the search 'act1'
    And The activity is not displayed in the search 'act2'

  Scenario:  [Favs_US05][02]: Search by favorites (Filter by keyword and favorite button)
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I connect with the first created user
    And I create the space
    When I post many activities '2'
    And I refresh the page
    Then the activity 'activity0' is displayed in activity stream
    And the activity 'activity1' is displayed in activity stream
    And the activity 'activity2' is displayed in activity stream
    When I bookmark the activity 'activity1'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I bookmark the activity 'activity2'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I go to Stream page
    And I start the search for 'activity'
    Then The activity is displayed in the search 'activity0'
    And The activity is displayed in the search 'activity1'
    And The activity is displayed in the search 'activity2'
    When I click on the favorite button
    Then The activity is displayed in the search 'activity1'
    And The activity is displayed in the search 'activity2'
    And The activity is not displayed in the search 'activity0'
    When I click on the favorite button
    Then The activity is displayed in the search 'activity1'
    And The activity is displayed in the search 'activity2'
    And The activity is displayed in the search 'activity0'

  Scenario: [Favs_US06][01]: Manage favorites from the search card ( Bookmark an activity)
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I connect with the first created user
    And I create the space
    When I post many activities '2'
    And I refresh the page
    Then the activity 'activity0' is displayed in activity stream
    And the activity 'activity1' is displayed in activity stream
    And the activity 'activity2' is displayed in activity stream
    When  I start the search for 'activity'
    Then The activity is displayed in the search 'activity1'
    And The activity is displayed in the search 'activity2'
    And The activity is displayed in the search 'activity0'
    When I favorite the activity 'activity1' from the search page
    And I click on the favorite button
    And I refresh the page
    Then The activity is displayed in the search 'activity1'
    And The activity is not displayed in the search 'activity2'
    And The activity is not displayed in the search 'activity0'

  Scenario: [Favs_US06][02]: Manage favorites from the search card ( UnBookmark an activity)
    Given I am authenticated as
      | login    | root     |
      | password | password |
    And I create the first random user
    And I connect with the first created user
    And I create the space
    When I post many activities '2'
    And I refresh the page
    Then the activity 'activity0' is displayed in activity stream
    And the activity 'activity1' is displayed in activity stream
    And the activity 'activity2' is displayed in activity stream
    When I bookmark the activity 'activity2'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When  I start the search for 'activity'
    Then The activity is displayed in the search 'activity1'
    And The activity is displayed in the search 'activity2'
    And The activity is displayed in the search 'activity0'
    When I favorite the activity 'activity2' from the search page
    And I click on the favorite button
    And I refresh the page
    Then The activity is not displayed in the search 'activity2'
    And The activity is not displayed in the search 'activity1'
    And The activity is not displayed in the search 'activity0'

  Scenario: [Favs_US10 ][01]: Bookmark a news by the article creator
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the space
    When I click on post in space
    And I click on 'write an article'
    And I add an article immediately with the following data
      | Titre   | ArticleFavorite01 |
      | Contenu | ArticleFavorite01 |
    Then The article is displayed in the activity stream of the space
    When I close the second window
    And I click on the title of the article in the activity stream
    When I favorite the article from it's details page
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed

  @ignored @favoriteXpathtoadapt
  Scenario: [Favs_US11][03]: check removed bookmarked news from news details
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the space
    When I click on post in space
    And I click on 'write an article'
    And I add an article immediately with the following data
      | Titre   | ArticleFavorite02 |
      | Contenu | ArticleFavorite02 |
    Then The article is displayed in the activity stream of the space
    When I close the second window
    Then I favorite the article from the activity stream
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I click on the title of the article in the activity stream
    And I unbookmark the article from it's details page
    Then The favorite success message 'The item has been removed from favorites successfully.' should be displayed

  @ignored @favoriteXpathtoadapt
  Scenario: [Favs_US12][01]: Search by favorites and news
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the space
    When I click on post in space
    And I click on 'write an article'
    And I add an article immediately with the following data
      | Titre   | ArticleFavorite03 |
      | Contenu | ArticleFavorite03 |
    Then The article is displayed in the activity stream of the space
    When I close the second window
    When I click on post in space
    And I click on 'write an article'
    And I add an article immediately with the following data
      | Titre   | ArticleFavorite04 |
      | Contenu | ArticleFavorite04 |
    Then The article is displayed in the activity stream of the space
    When I close the second window
    And I bookmark the activity 'ArticleFavorite04'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I access to the news details page from the article 'ArticleFavorite03'
    And I favorite the article from it's details page
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I access to the unified search page
    And I click on the favorite button
    And I select an object from the drop-down menu 'News'
    Then The activity is displayed in the search 'ArticleFavorite03'
    And The activity is displayed in the search 'ArticleFavorite04'

  @ignored @favoriteXpathtoadapt
  Scenario: [Favs_US12][03]: Search by favorites and news (article bookmarked/unbookmarked from the news details)
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the space
    When I click on post in space
    And I click on 'write an article'
    And I add an article immediately with the following data
      | Titre   | ArticleFavorite05 |
      | Contenu | ArticleFavorite05 |
    Then The article is displayed in the activity stream of the space
    When I close the second window
    And I bookmark the activity 'ArticleFavorite05'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I access to the unified search page
    And I click on the favorite button
    And I select an object from the drop-down menu 'News'
    Then The activity is displayed in the search 'ArticleFavorite05'
    When I go to Stream page
    When I access to the news details page from the article 'ArticleFavorite05'
    And I unbookmark the article from it's details page
    Then The favorite success message 'The item has been removed from favorites successfully.' should be displayed
    When I access to the unified search page
    And I click on the favorite button
    And I select an object from the drop-down menu 'News'
    Then The activity is not displayed in the search 'ArticleFavorite05'

  Scenario: [Fav_US13][01]: Bookmark a note from it's details
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the first random user
    And I create the space community with the first created user
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab
    When I add note with title 'Note1' and content 'Content1'
    And I save and post Note
    Then Note tile 'Note1' and content 'Content1' are displayed successfully
    And I close the second window
    And I go to space Home
    Then Note activity with title 'Note1' is displayed
    When I connect with the first created user
    And I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    When  I go to Stream page
    And I access note 'Note1' activity
    Then Note tile 'Note1' and content 'Content1' are displayed successfully
    When I favorite the note from it's details page
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When  I go to Stream page
    Then The star icon of note activity should be yellow


  Scenario: [Fav_US13][02]: Bookmark a note from it's activity
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the space community
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab
    When I add note with title 'Note2' and content 'Content2'
    And I save and post Note
    Then Note tile 'Note2' and content 'Content2' are displayed successfully
    And I close the second window
    And I go to space Home
    Then Note activity with title 'Note2' is displayed
    And The star icon of note activity should be grey
    When I bookmark the activity 'Note2'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    And I access note 'Note2' activity
    Then Note tile 'Note2' and content 'Content2' are displayed successfully
    And The star icon of the note details page should be yellow


  Scenario: [Fav_US14][01]: Remove the bookmark for a note from it's details
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the first random user
    And I create the space community with the first created user
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab
    When I add note with title 'Note3' and content 'Content3'
    And I save and post Note
    Then Note tile 'Note3' and content 'Content3' are displayed successfully
    And I close the second window
    When I connect with the first created user
    And I click on spaces badge
    And I accept the invitation of the created space
    And I refresh the page
    When  I go to Stream page
    And  I bookmark the activity 'Note3'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I access note 'Note3' activity
    Then Note tile 'Note3' and content 'Content3' are displayed successfully
    And The star icon of the note details page should be yellow
    And I unfavorite the note from its details page
    Then The favorite success message 'The item has been removed from favorites successfully.' should be displayed
    When  I go to Stream page
    Then The star icon of note activity should be grey


  Scenario:[Fav_US14][02]: Remove the bookmark for a note from it's activity
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the space community
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab
    When I add note with title 'Note4' and content 'Content4'
    And I save and post Note
    Then Note tile 'Note4' and content 'Content4' are displayed successfully
    And I close the second window
    And I go to space Home
    Then Note activity with title 'Note4' is displayed
    When  I bookmark the activity 'Note4'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    And I unbookmark the activity 'Note4'
    Then The favorite success message 'The item has been removed from favorites successfully.' should be displayed
    When I access note 'Note4' activity
    Then The star icon of the note page should be grey

  Scenario:[Fav_US15][01]: Search by favorites and notes
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |
    And I create the space community
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab
    When I add note with title 'Note5' and content 'Content5'
    And I save and post Note
    Then Note tile 'Note5' and content 'Content5' are displayed successfully
    And I close the second window
    And I go to space Home
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab
    When I add note with title 'Note6' and content 'Content6'
    And I save and post Note
    Then Note tile 'Note6' and content 'Content6' are displayed successfully
    And I close the second window
    When I go to Stream page
    When  I bookmark the activity 'Note5'
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I access note 'Note6' activity
    Then Note tile 'Note6' and content 'Content6' are displayed successfully
    And I favorite the note from it's details page
    Then The favorite success message 'Favorite added successfully. Find it easily from the search' should be displayed
    When I access to the unified search page
    And I click on the favorite button
    And I select an object from the drop-down menu 'Notes'
    Then The activity is displayed in the search 'Note5'
    And The activity is displayed in the search 'Note6'

