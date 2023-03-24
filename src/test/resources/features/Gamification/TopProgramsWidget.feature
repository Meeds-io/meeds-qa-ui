@gamification
@topprograms
@test
Feature: Programs should be displayed in Top Programs in sorted way
  I should access programs I am member of in Top Programs, sorted by points descending

  Scenario: Top Programs sorted by score descending
    Given I am authenticated as admin

    When I create the first random user if not existing
    And I create the first random space with the first random user as member
    And I create the second random space with the first random user as member
    And I create the fifth random space

    When I go to 'Contributions' application
    And I create the 'first' random program with
      | audience | first |
    And I create the 'second' random program with
      | audience | second |
    And I create the 'fifth' random program with
      | audience | fifth |

    When I select engagement Challenges tab
    And I create the 'first' random challenge with
      | program | first |
      | points | 9997 |
    And I create the 'second' random challenge with
      | program | second |
      | points | 9998 |
    And I create the 'fifth' random challenge with
      | program | fifth |
      | points | 9999 |

    When I connect with the first created user
    And I go to Stream page
    And I click on spaces badge
    And I accept the invitation of the first created space
    And I accept the invitation of the second created space

    When I go to Overview page

    Then The 'second' random program is displayed in 'first' position in Top Programs widget
    And The 'first' random program is displayed in 'second' position in Top Programs widget
    And The 'fifth' random program is not displayed in Top Programs widget

    When I change user admin
    And I go to 'Contributions' application
    And I select engagement Challenges tab
    And I update the 'first' random challenge with
      | points | 9999 |
    Then The 'first' challenge is displayed with '9999' points

    When I connect with the first created user
    When I go to Overview page

    Then The 'first' random program is displayed in 'first' position in Top Programs widget
    And The 'second' random program is displayed in 'second' position in Top Programs widget
    And The 'fifth' random program is not displayed in Top Programs widget
