@chat
Feature: Chat drawer checking
  As a user I want to check the chat drawer in the top bar

  @test
  Scenario: Check opening the chat drawer
    Given I am authenticated as 'admin' random user
    When I create a random space
    And I open the chat drawer
    Then the chat drawer is opened
    And the chat rooms list is displayed
