@profile
Feature: Search for User Informations in Profile page
  As a user
  I want to check in Profile page all contact informations


  Scenario: PROFILE-1 : Integrate default user's avatar and cover
    Given I am authenticated as admin

    When I go to My Profile page

    Then User Cover is displayed in Profile Page
    And User Avatar is displayed in Profile Page

  Scenario: PROFILE-2 User avatar and cover block_(01)
    Given I am authenticated as admin

    When I go to My Profile page

    Then User Cover is displayed in Profile Page
    And User Avatar is displayed in Profile Page
    And User Fullname 'Admin User' is displayed in Profile Page
    And User Job '' is displayed in Profile Page

  @test
  Scenario: PROFILE-2 User avatar and cover block_(02)
    Given I am authenticated as admin

    When I go to My Profile page

    Then Profile Contact Fullname 'Contact information' is displayed in 'Admin User'
    And Profile Contact Email 'admin@localhost' is displayed

    When I create the first random user if not existing
    And I connect with the first created user
    And I go to My Profile page

    Then User Job '' is displayed in Profile Page

  Scenario: PROFILE-4 Contact information block_(01) : Add informations
    Given I am authenticated as admin

    When I create the first random user if not existing
    And I connect with the first created user
    And I go to My Profile page
    And I update my profile random basic informations
    Then In 'Contact information', Updated profile Contact Fullname is displayed
    And Updated Profile Contact Email is displayed
    And Updated Profile Contact Job is displayed

  Scenario: PROFILE-4 Contact information block_(02) : Add informations
    Given I am authenticated as admin

    When I create the first random user if not existing
    And I connect with the first created user
    And I go to My Profile page
    And I update my profile random basic informations
    Then In 'Contact information', Updated profile Contact Fullname is displayed
    And Updated Profile Contact Email is displayed
    And Updated Profile Contact Job is displayed

    When I update my profile other random informations
    Then Updated Profile Contact Company is displayed
    And Updated Profile Contact Phone is displayed
    And Updated Profile Contact instantMessaging is displayed
    And Updated Profile Contact Url is displayed

  @test
  Scenario: PROFILE-5 Kudos block
    Given I am authenticated as admin

    When I create the first random user if not existing
    And I create the second random user if not existing
    And I create the third random user if not existing

    When I connect with the first created user

    And I go to the second user profile
    And I send kudos with message 'Message for kudos'

    And I go to the third user profile
    And I send kudos with message 'Message for kudos'

    When I connect with the second created user

    And I go to the first user profile
    And I send kudos with message 'Message for kudos'

    When I connect with the first created user
    And  I go to My Profile page
    Then '2' kudos are sent
    And '1' kudos are received

    When I go to Received Kudos
    Then Received kudos by second user is displayed

    When I go to Sent Kudos
    Then Sent kudos by third user is displayed
    And Sent kudos by second user is displayed
    And I refresh the page

  Scenario: : PROFILE-6 : Rawards Meeds block and its drawer
    Given I am authenticated as admin

    When I go to My Profile page

    Then Received Kudos Section is displayed
    Then Sent Kudos Section is displayed
    Then Gained Cauris Section is displayed

  Scenario: : PROFILE-7 : Work Experiences block and its drawer
    Given I am authenticated as admin

    And I create the first random user if not existing

    When I connect with the first created user

    And I go to My Profile page

    And I add my profile work experiences
      | organization | eXo                                  |
      | jobTitle     | QA Engineer                          |
      | jobDetails   | Tests Automation Consultant          |
      | usedSkills   | Serenity Cucumber Selenium Java Jira |

    And I add my profile work experiences
      | organization | google                |
      | jobTitle     | IT Engineer Developer |
      | jobDetails   | Java Jee Developer    |
      | usedSkills   | Java Jee Spring MVC   |

    Then  Job title 'QA Engineer' and Organization 'eXo' and Job details 'Tests Automation Consultant' and Used skills 'Serenity Cucumber Selenium Java Jira' are displayed in Work experiences section
    And Job title 'IT Engineer Developer' and Organization 'google' and Job details 'Java Jee Developer' and Used skills 'Java Jee Spring MVC' are displayed in Work experiences section

    And I remove my profile work experiences 'QA Engineer'
    And I remove my profile work experiences 'IT Engineer Developer'

  Scenario: : PROFILE-9 : Achievement Drawer in Points
    Given I am authenticated as admin

    And I create the first random user if not existing

    When I connect with the first created user

    And I open Weekly Points Chart
    Then The weekly point chart is displayed

    When I open achievement tab
    Then The achievements drawer is displayed
