@news
Feature: News articles
  As a user I want to start writing an article from a space activity composer

  Scenario: Open the article editor from the space composer
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    Then The write an article link is displayed in the composer
    When I click on write an article
    Then The article editor is opened

  Scenario: Save an article as draft
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I click on write an article
    And I enter the article title 'Draft article to resume later' and content 'Draft article content'
    Then The article draft is saved

  Scenario: Search for an article by title in the News page
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I click on write an article
    And I add an article titled 'Article searched by title' with content 'Article searched by title content'
    And I go to the news page
    And I search for the article 'Article searched by title'
    Then The searched article 'Article searched by title' is displayed
    When I clear the article search input
    And I search for the article 'wrongArticleName'
    Then No article is found

  Scenario: Search for an article by author in the News page
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I click on write an article
    And I add an article titled 'Article searched by author' with content 'Article searched by author content'
    And I go to the news page
    And I search for the article 'admin'
    Then The searched article 'Article searched by author' is displayed
    When I clear the article search input
    And I search for the article 'wrongAuthorName'
    Then No article is found

  Scenario: The article update button is disabled by default
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I click on write an article
    And I add an article titled 'Article to edit disabled' with content 'Article to edit disabled content'
    Then The article 'Article to edit disabled' is displayed in the space activity stream
    When I close the article editor tab
    And I click on the article title 'Article to edit disabled' in the activity stream
    And I open the edit article form via the three dots menu
    Then The modify article page is displayed
    And The article update button is disabled

  Scenario: Update an article
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I click on write an article
    And I add an article titled 'Article to update' with content 'Article to update content'
    Then The article 'Article to update' is displayed in the space activity stream
    When I close the article editor tab
    And I click on the article title 'Article to update' in the activity stream
    And I open the edit article form via the three dots menu
    And I modify the article title 'Article updated' with content 'Article updated content'
    And I return to the first window
    And I go to the random space
    Then The article 'Article updated' is displayed in the space activity stream

  Scenario: Show the details of a shared article in a space
    Given I am authenticated as 'admin' random user
    And I create the first random space if not existing
    And I go to the random space
    When I click on post in space
    And I click on write an article
    And I add an article titled 'Article shared details' with content 'Article shared details content'
    And I click on the article title 'Article shared details' in the activity stream
    And I click on share article
    And I share the article with the 'first' space and the description 'shared description'
    Then The share confirmation message 'has been shared' is displayed
    When I go to the first random space
    Then The article 'Article shared details' is displayed in the space activity stream
