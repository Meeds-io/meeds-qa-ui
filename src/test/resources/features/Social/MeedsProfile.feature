@profile
Feature: Search for User Informations in Profile page
  As a user
  I want to check in Profile page all contact informations

  Scenario: PROFILE-1 : Integrate default user's avatar and cover
    Given I am authenticated as admin

    When I go to My Profile page

    Then User Cover is displayed in Profile Page
    And User Avatar is displayed in Profile Page

  Scenario: PROFILE-4 Contact information block_(01) : Add informations
    Given I am authenticated as admin

    When I create the firstprofile random user if not existing, no wait
    And I connect with the firstprofile created user
    And I go to My Profile page
    And I update my profile random basic informations
    And I refresh the page
    Then In 'Your contact informations', Updated profile Contact Fullname is displayed
    And Updated Profile Contact Email is displayed
    And Updated Profile Contact Job is displayed

  Scenario: PROFILE-4 Contact information block_(02) : Add informations
    Given I am authenticated as admin

    When I create the secondprofile random user if not existing, no wait
    And I connect with the secondprofile created user
    And I go to My Profile page
    And I update my profile random basic informations
    Then In 'Your contact informations', Updated profile Contact Fullname is displayed
    And Updated Profile Contact Email is displayed
    And Updated Profile Contact Job is displayed

    When I update my profile other random informations
    Then Updated Profile Contact Company is displayed
    And Updated Profile Contact Phone is displayed
    And Updated Profile Contact instantMessaging is displayed
    And Updated Profile Contact Url is displayed

  Scenario: PROFILE-5 Kudos block
    Given I am authenticated as admin

    When I create the fifthkudos random user if not existing, no wait
    And I create the sixthkudos random user if not existing, no wait
    And I create the seventhkudos random user if not existing

    When I connect with the fifthkudos created user

    And I go to the sixthkudos user profile
    And I send kudos with message 'Message for kudos'

    And I go to the seventhkudos user profile
    And I send kudos with message 'Message for kudos'

    When I connect with the sixthkudos created user

    And I go to the fifthkudos user profile
    And I send kudos with message 'Message for kudos'

    When I connect with the fifthkudos created user
    And  I go to My Profile page
    Then '2' kudos are sent
    And '1' kudos are received

    When I go to Received Kudos
    Then Received kudos by sixthkudos user is displayed

    When I go to Sent Kudos
    Then Sent kudos by user 'seventhkudos' is displayed
    And Sent kudos by user 'sixthkudos' is displayed

  Scenario: : PROFILE-6 : Received and sent kudos section
    Given I am authenticated as admin

    When I go to My Profile page

    Then Received Kudos Section is displayed
    Then Sent Kudos Section is displayed

  Scenario: : PROFILE-7 : Work Experiences block and its drawer
    Given I am authenticated as admin

    And I create the thirdprofile random user if not existing, no wait

    When I connect with the thirdprofile created user

    And I go to My Profile page

    And I add my profile work experiences
      | organization | Test                                 |
      | jobTitle     | QA Engineer                          |
      | jobDetails   | Tests Automation Consultant          |
      | usedSkills   | Serenity Cucumber Selenium Java Jira |
    Then  Job title 'QA Engineer' and Organization 'Test' and Job details 'Tests Automation Consultant' and Used skills 'Serenity Cucumber Selenium Java Jira' are displayed in Work experiences section

    And I add my profile work experiences
      | organization | google                |
      | jobTitle     | IT Engineer Developer |
      | jobDetails   | Java Jee Developer    |
      | usedSkills   | Java Jee Spring MVC   |

    Then  Job title 'QA Engineer' and Organization 'Test' and Job details 'Tests Automation Consultant' and Used skills 'Serenity Cucumber Selenium Java Jira' are displayed in Work experiences section
    And Job title 'IT Engineer Developer' and Organization 'google' and Job details 'Java Jee Developer' and Used skills 'Java Jee Spring MVC' are displayed in Work experiences section

    And I remove my profile work experiences 'QA Engineer'
    And I remove my profile work experiences 'IT Engineer Developer'
