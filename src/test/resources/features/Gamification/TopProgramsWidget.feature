@gamification
@topprograms
Feature: Programs should be displayed in Top Programs in sorted way
  I should access programs I am member of in Top Programs, sorted by points descending

  Scenario: Top Programs sorted by score descending
    Given I am authenticated as admin

    When I create the thirtyone random user if not existing
    And I create the thirtyone random space with the thirtyone random user as member
    And I create the thirtytwo random space with the thirtyone random user as member
    And I create the thirtythree random space

    When I go to 'Contributions' application
    And I create the 'thirtyone' random program with
      | audience | thirtyone |
    And I create the 'thirtytwo' random program with
      | audience | thirtytwo |
    And I create the 'thirtythree' random program with
      | audience | thirtythree |

    When I select engagement Challenges tab
    And I create the 'thirtyone' random challenge with
      | program | thirtyone |
      | points | 9997 |
    And I create the 'thirtytwo' random challenge with
      | program | thirtytwo |
      | points | 9998 |
    And I create the 'thirtythree' random challenge with
      | program | thirtythree |
      | points | 9999 |

    When I connect with the thirtyone created user
    And I go to Stream page
    And I click on spaces badge
    And I accept the invitation of the thirtyone created space
    And I accept the invitation of the thirtytwo created space

    When I go to Overview page

    Then The 'thirtytwo' random program is displayed in 'first' position in Top Programs widget
    And The 'thirtyone' random program is displayed in 'second' position in Top Programs widget
    And The 'thirtythree' random program is not displayed in Top Programs widget

    When I change user admin
    And I go to 'Contributions' application
    And I select engagement Challenges tab
    And I update the 'thirtyone' random challenge with
      | points | 9999 |
    Then The 'thirtyone' challenge is displayed with '9999' points

    When I connect with the thirtyone created user
    When I go to Overview page

    Then The 'thirtyone' random program is displayed in 'first' position in Top Programs widget
    And The 'thirtytwo' random program is displayed in 'second' position in Top Programs widget
    And The 'thirtythree' random program is not displayed in Top Programs widget
