@smoke
Feature: Activities publication
  As a user
  I want to publish activities
  In order to share them with my collaborators

  @failing
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
