@note
@ignored
Feature: Create Note

  Scenario: CAP01: ManageNote_USXX[01]: Open Create note page in new tab

    Given I am authenticated as admin
    And I create the first random user if not existing
    When I connect with the first created user

    And I go to the random space
    And I go to notes application of the space
    When I click to add note
    Then Create note form is opened successfully in new tab
    And I close the second window

  Scenario: CAP04: Publish note
    Given I am authenticated as admin
    And I go to the random space
    And I go to notes application of the space

    When I click to add note
    Then Create note form is opened successfully in new tab

    When I add note with title 'Notee' and content 'Note Test E'
    And I save Note
    Then Note title 'Notee' and content 'Note Test E' are displayed successfully

  Scenario: CAP05: Publish and post note
    Given I am authenticated as admin
    And I go to the random space
    And I go to notes application of the space

    When I click to add note
    Then Create note form is opened successfully in new tab

    When I add note with title 'Note Published' and content 'Content Note Published'
    And I save and post Note
    Then Note title 'Note Published' and content 'Content Note Published' are displayed successfully

  Scenario: CAP01: CreateEditNotes_US02 : Check Note Activity in AS -create Page

    Given I am authenticated as admin
    And I go to the random space
    And I go to notes application of the space

    When I click to add note
    Then Create note form is opened successfully in new tab
    When I add note with title 'Note A' and content 'Content Note A'
    And I save and post Note
    Then Note title 'Note A' and content 'Content Note A' are displayed successfully

    When I go to space Home
    Then Note activity with title 'Note A' is displayed

    When I go to Stream page
    Then Note activity with title 'Note A' is displayed

  Scenario: CAP05 : Access of Note Activity

    Given I am authenticated as admin
    And I go to the random space
    And I go to notes application of the space

    When I click to add note
    Then Create note form is opened successfully in new tab

    When I add note with title 'Test' and content 'Content Test'
    And I save and post Note
    Then Note title 'Test' and content 'Content Test' are displayed successfully


    When I go to space Home
    Then Note activity with title 'Test' is displayed

    When I access note 'Test' activity
    Then Note title 'Test' and content 'Test' are displayed successfully
