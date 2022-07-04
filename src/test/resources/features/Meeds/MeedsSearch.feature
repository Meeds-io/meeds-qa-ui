# language: en
@secondpart
Feature: Search for items
  As a user
  I want to search for anything in the portal

  Scenario: SEARCH-2.10 : Redesign the activity card
    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the random space

    When I click on post in space

    And I click on 'write an article'
    And I add an article immediately with the following data
      | Titre   | ArticleTitreSearch210   |
      | Contenu | ArticleContenuSearch210 |

    Then The article is displayed in the activity stream of the space

    When I start the search for 'ArticleTitreSearch210'
    Then The activity is displayed in the search 'ArticleTitreSearch210'
