@achievements
Feature: Achievements

  # Bug detected and qualified as non-bloquer
  @ignored
  Scenario: Achievements for Send/Cancel Kudos from the activity author
    Given I am authenticated as admin
    And I create the random space if not existing
    And I go to 'Contributions' application
    When I select engagement Programs tab
    And I click on the button add program
    And I enter the program title 'Achievements program'
    And I add program with random description
    And I add an audience space
    And I open 'Achievements program' program card
    And I click on the button to add a rule
    And I enter the rule title 'Send kudos'
    And I add an event 'Send kudos'
    And I add rule random description

    And I click on the button to add a rule
    And I enter the rule title 'Receive kudos'
    And I add an event 'Receive kudos'
    And I add rule random description

    And I create the fisrtachievement random user if not existing, no wait
    And I create the secondachievement random user if not existing, no wait
    When I connect with the secondachievement created user
    And I go to the random space
    And I click on post in space
    And I enter an activity 'Achievements - Kudos Post activity'
    And I publish the activity

    And I connect with the fisrtachievement created user
    When I go to the random space
    And I send in the activity 'Achievements - Kudos Post activity' a kudos message 'Achievements - kudos activity comment to cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is accepted

    And I go to the random space
    When In activity 'Achievements - Kudos Post activity' I cancel the sent kudos comment 'Achievements - kudos activity comment to cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is canceled

  # Bug detected and qualified as non-bloquer
  @ignored
  Scenario: Achievements for Send/Cancel Kudos from user profile
    Given I am authenticated as admin
    And I create the random space if not existing
    And I go to 'Contributions' application
    When I select engagement Programs tab
    And I click on the button add program
    And I enter the program title 'Achievements program'
    And I add program with random description
    And I add an audience space
    And I open 'Achievements program' program card
    And I click on the button to add a rule
    And I enter the rule title 'Send kudos'
    And I add an event 'Send kudos'
    And I add rule random description

    And I click on the button to add a rule
    And I enter the rule title 'Receive kudos'
    And I add an event 'Receive kudos'
    And I add rule random description

    And I create the thirdachievement random user if not existing, no wait
    And I create the fourachievement random user if not existing

    When I connect with the thirdachievement created user
    When I go to the random space
    And I go to the fourachievement user profile
    And I send kudos with message 'Achievements - Kudos Post activity to cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is accepted

    And I go to Stream page
    When I cancel the sent kudos activity 'Achievements - Kudos Post activity to cancel'

    And I go to 'Contributions' application
    When I select engagement Achievements tab
    Then Achievement for 'Send kudos' is canceled



    