@wallet
@widget
Feature: : Wallet Widget checking
  As a user
  I want to check the news wallet in home page
  In order to validate it

  @smoke
  @failing
  Scenario: : US 3.4.1[BACK]Add wallet widget
    Given I am authenticated as admin
    And the following sections are displayed
      | Wallet |
    When I click on wallet label
    Then The wallet page is not opened
