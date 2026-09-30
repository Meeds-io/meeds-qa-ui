@attachment
Feature: Attach documents to activities
  As a user I want to attach a document to a space activity from the composer

  Scenario: Attach a document to an activity by uploading it
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with uploaded document'
    And I upload the document 'text.txt' to the activity
    Then The document 'text.txt' is attached in the documents drawer
