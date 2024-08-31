@ui
Feature: Create new form
 
 @forms
  Scenario: create form
    Given I navigate to Forms page
    When I enter first testuser and last name lastname
    And I enter email ID abc123abc@abc.com
    And I select gender from radio button
    And I enter mobile number 1234567890
    And I enter date of birth and subject
    And I select the hobbies from checkbox 
    And I uplaod a picture
    And I enter the address
    When I select State NCR from the dropdown
    When I select city Delhi from the dropdown
    And I click on Submit button in form page
    
    