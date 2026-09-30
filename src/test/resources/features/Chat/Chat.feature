@chat
Feature: Chat drawer checking
  As a user I want to check the chat drawer in the top bar

  # Suspected product defect or Matrix setup: the chat drawer lists no discussion, even for a member of several spaces
  @ignore @Product_bug_chat_space_rooms
  Scenario: Check opening the chat drawer
    Given I am authenticated as 'admin' random user
    When I create a random space
    And I open the chat drawer
    Then the chat drawer is opened
    And the chat rooms list is displayed
