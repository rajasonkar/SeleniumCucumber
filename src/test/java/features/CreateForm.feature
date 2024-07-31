Feature: Create new form
 
 @forms
  Scenario: create form
    Given I navigate to Forms page
    When I enter first and last name
    And I enter email ID
    And I select gender from radio button
    And I enter mobile number
    And I enter date of birth and subject
    And I select the hobbies from checkbox 
    And I uplaod a picture
    And I enter the address
    Then I verify city dropdown as disabled
    When I select State from the dropdown
    Then I verify city dropdown got enabled
    When I select city from the dropdown
    And I click on Submit button
    
    