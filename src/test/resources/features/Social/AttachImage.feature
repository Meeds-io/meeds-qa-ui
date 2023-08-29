@attachment
Feature: Attach images activities

  Scenario: Attach and preview an image to an activity
    Given I am authenticated as 'admin' if random users doesn't exists
      | first  |
    And I inject the first random user if not existing
    And I login as 'first' random user
    And I go to the random space
    When I click on post in space
    And I enter an activity 'activity with attached images'
    And I attach an image to the activity
    And I publish the activity
    Then the activity 'activity with attached images' is displayed in activity stream
    And The attached images should be displayed in the published activity 'activity with attached images'
    
    When I click on attached image related to activity 'activity with attached images'
    Then the preview of the attached image is displayed
    
    When I click on close icon in preview attached image
    Then the preview of the attached image is not displayed
	    
	Scenario: Edit an activity - Remove images
	  Given I am authenticated as 'admin' if random users doesn't exists
	    | first  |
	  And I inject the first random user if not existing
	  And I login as 'first' random user
	  And I go to the random space
	  When I click on post in space
	  And I enter an activity 'activity with attached images'
	  And I attach an image to the activity
	  And I publish the activity
	  Then the activity 'activity with attached images' is displayed in activity stream
	    
	  When I click on modify the activity 'activity with attached images'
	  And I enter an activity 'activity with attached images'
	  Then The attached images should be displayed in the activity 'activity with attached images' drawer with the delete icon
	    
	  When I click on delete an attached image
	  Then The attached image is not displayed
	    
	  When I click on Update
	  Then The attached images should not be displayed in the published activity 'activity with attached images'
    
    
    