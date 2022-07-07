# new feature
# Tags: optional

Feature: Actions available for note


  Scenario: CAP02: DeleteNote_US02: Delete note UX  improvement

    Given I am authenticated as
      | login    | john   |
      | password | gtngtn |

    And I create the space community

    When I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab
    When I add note with title 'Note test' and content 'Note Test'
    And I save Note
    Then Note tile 'Note test' and content 'Note Test' are displayed successfully

    When I click on three dots icon
    And I delete Note
    Then Note 'Note test' is deleted successfully
    And I close the second window
