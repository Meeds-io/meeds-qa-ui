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

  @test
  Scenario: Save an article as draft
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I click on write an article
    And I enter the article title 'Draft article to resume later' and content 'Draft article content'
    Then The article draft is saved
