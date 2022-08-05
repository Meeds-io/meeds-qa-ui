@smoke
Feature: Activities publication
  As a user
  I want to publish activities
  In order to share them with my collaborators

  Scenario: CAP03 - [US-ShortMessage-01]: post a short message from drawer
    Given I am authenticated as admin
    And I create the space
    When I click on post in space
    And I enter an activity 'activité CAP03'
    And I publish the activity
    Then the activity 'activité CAP03' is displayed in activity stream

  Scenario:CAP63-[US-ShortMessage-02 ]:check the display "Switch to an article" link when exceeds 1300 characters (redactor case)
    Given I am authenticated as admin
    And I create the space
    When I click on post in space
    And I enter an activity more than 1300 characters
    Then Switch to an article link is displayed
    And I close activity drawer

  Scenario:CAP64-[US-ShortMessage-02 ]: when user click on "Switch to an article",he is redirected to a new tab (redactor case)
    Given I am authenticated as admin
    And I create the space
    When I click on post in space
    And I enter an activity more than 1300 characters
    And I click on switch to an article
    And I go to the second window
    Then The form add an article is displayed
    And the article is displayed with the correct content
    And I close activity drawer

  Scenario:CAP86-[US-ShortMessage-03]: check that attachments are displayed when user switch to "write an article" Form
    Given I am authenticated as admin
    And I create the space
    When I click on post in space
    And I enter an activity more than 1300 characters
    And I attach the file 'text.txt'
    And I click on switch to an article
    And I go to the second window
    Then The form add an article is displayed
    And the article is displayed with the correct content
    And the attached file is displayed
    And I close activity drawer