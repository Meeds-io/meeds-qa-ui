# new feature
# Tags: optional

Feature: Edit Note

  Scenario: Open edit Note page in new tab
    Given I am authenticated as
      | login    | john     |
      | password | gtngtn   |
    And I create the space community
    And I go to notes application of the space

    When I click to add note
    And I create note page with title 'testA' and content 'testA'
    Then Note tile 'testA' and content 'testA' are displayed successfully

    When I click to edit note
    Then Edit note form is opened successfully in new tab
    And I close the third window
    And I close the second window

  Scenario: edit note
    Given I am authenticated as
      | login    | john     |
      | password | gtngtn   |
    And I create the space community
    And I go to notes application of the space

    When I click to add note
    And I create note page with title 'testA' and content 'testA'
    Then Note tile 'testA' and content 'testA' are displayed successfully

    When I click to edit note
    Then Edit note form is opened successfully in new tab

    When I edit note page with random title and random content
    Then Note page title and content are edited successfully

    And I close the third window
    And I close the second window

