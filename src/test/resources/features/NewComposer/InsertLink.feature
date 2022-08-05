@smoke
Feature: Insert links
  As a user
  I want to publish links via the new composer
  In order to share them with my collaborators

  Scenario: CAP29-[US-insertLink-01]: insert a link from composer drawer (space case)
    Given I am authenticated as admin
    And I create the space
    When I click on post in space
    And I enter an activity 'https://www.exoplatform.com/'
    And I publish the activity
    Then the activity 'https://www.exoplatform.com/' is displayed in activity stream
    And The link preview 'https://www.exoplatform.com/' is displayed in activity stream