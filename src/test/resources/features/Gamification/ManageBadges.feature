@gamification
Feature: Badges Management
  As an administrator user
  I can manage badges list

  Scenario: Add badge
    Given I am authenticated as admin

    When I go to administration then I select manage badges
    And  I add new Badge with random name, description 'badgeDescription', score '500', icon 'badgeIcon.png', and domain 'Social'
    And  I confirm the addition of the new badge

    Then Success alert 'Badge added successfully' is displayed
    And The new badge is added successfully and is displayed with random name, description 'badgeDescription', score '500', domain 'Social', and enabled status in badges list

  Scenario: Edit badge
    Given I am authenticated as admin

    When I go to administration then I select manage badges
    And  I add new Badge to be updated with random name, description 'badgeDescriptionTest', score '100', icon 'badgeIcon.png', and domain 'Teamwork'
    And  I confirm the addition of the new badge

    Then Success alert 'Badge added successfully' is displayed
    And The new badge to be updated is added successfully and is displayed with random name, description 'badgeDescriptionTest', score '100', domain 'Teamwork', and enabled status in badges list

    When I go to administration then I select manage badges
    And I click on the Edit button of the added badge
    And I enter the new badge name
    And I enter the new badge description 'badgeDescriptionUpdated'
    And I enter the new badge score '50'
    And I select the new badge domain 'Feedback'
    And I confirm the edit of the badge

    Then Success alert 'Badge updated successfully' is displayed
    And The badge has been updated successfully and is displayed with random name, description 'badgeDescriptionUpdated', score '50', domain 'Feedback', and enabled status in badges list

  Scenario: Delete badge
    Given I am authenticated as admin

    When I go to administration then I select manage badges
    And  I add new Badge to be deleted with random name, description 'deletedDescription', score '300', icon 'badgeIcon.png', and domain 'Social'
    And  I confirm the addition of the new badge

    Then Success alert 'Badge added successfully' is displayed
    And The new badge to be deleted is added successfully and is displayed with random name, description 'deletedDescription', score '300', domain 'Social', and enabled status in badges list

    When I refresh the page
    And I click on badge name Delete button
    And I confirm the deletion of the badge

    Then Success alert 'Badge deleted successfully' is displayed
    And The deleted badge with random name, description 'deletedDescription', score '300', domain 'Social' is no longer displayed in badges list

  Scenario: Search badge
    Given I am authenticated as admin

    When I go to administration then I select manage badges
    And  I add new Badge with random name, description 'searchedDescription', score '200', icon 'badgeIcon.png', and domain 'Social'
    And  I confirm the addition of the new badge

    Then Success alert 'Badge added successfully' is displayed
    And The new badge is added successfully and is displayed with random name, description 'searchedDescription', score '200', domain 'Social', and enabled status in badges list

    When I refresh the page
    And I search for the random badge name

    Then The new badge is added successfully and is displayed with random name, description 'searchedDescription', score '200', domain 'Social', and enabled status in badges list
