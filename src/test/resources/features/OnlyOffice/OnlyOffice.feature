@onlyoffice
Feature: OnlyOffice online editing
  As a user I want to edit office documents online from a space activity

  Scenario: Open an attached document in the online editor
    Given I am authenticated as 'admin' random user
    And I create a random space
    When I click on post in space
    And I enter an activity 'activity with onlyoffice document'
    And I attach the file 'onlyOffice.docx' to the activity
    And I publish the activity
    And I open the document preview 'onlyOffice.docx'
    Then The online editor is requested in a new tab

  Scenario Outline: Editable document types open in the online editor
    Given I am authenticated as 'admin' random user
    And I create a random space
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with <fileToUpload>'
    And I attach the file '<fileToUpload>' to the activity
    And I publish the activity
    And I open the document preview '<fileToUpload>'
    Then The online editor is requested in a new tab

    Examples:
      | fileToUpload     |
      | onlyOffice.docx  |
      | onlyOffice.pptx  |
      | onlyOffice.xlsx  |

  Scenario Outline: Non-editable document types do not request the online editor
    Given I am authenticated as 'admin' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with <fileToUpload>'
    And I attach the file '<fileToUpload>' to the activity
    And I publish the activity
    And I open the document preview '<fileToUpload>'
    Then The online editor is not requested in a new tab

    Examples:
      | fileToUpload    |
      | onlyOffice.doc  |
      | onlyOffice.ppt  |
      | onlyOffice.xls  |
      | onlyOffice.jpeg |
      | onlyOffice.odp  |
      | onlyOffice.ods  |
      | onlyOffice.odt  |
