# new feature
# Tags: optional
Feature: Domains Management
  As an administrator user
  I can manage domains list

  @gamification
  Scenario: Add domain
    Given I am authenticated as admin
    When I go to administration then I select manage domains
    And I add new Domain with random name and random description
    And I confirm the addition of the new domain
    Then The random domain is added successfully and its name is displayed in the domain list

  @gamification
  Scenario: Edit domain
    Given I am authenticated as admin
    And I go to administration then I select manage domains
    And I add new Domain with random name and random description
    And I confirm the addition of the new domain
    Then The random domain is added successfully and its name is displayed in the domain list
    When I click on edit icon and enter the updated domain name and I save changes
    Then The random domain is updated successfully and its name is displayed in the domain list

  @gamification
  Scenario: Delete domain
    Given I am authenticated as admin
    And I go to administration then I select manage domains
    And I add new Domain with random name and random description
    And I confirm the addition of the new domain
    And I refresh the page
    And The random domain is added successfully and its name is displayed in the domain list
    When I click on delete icon to delete the new added domain
    Then I confirm the deletion of the domain an it is deleted successfully
    And The random domain is not displayed in the domain list

  @gamification
  Scenario: Domains search
    Given I am authenticated as admin
    When I go to administration then I select manage domains
    And I add new Domain with random name and random description
    And I confirm the addition of the new domain
    And I search for the random domain
    Then The searched domain with its random name is displayed in the list of search results