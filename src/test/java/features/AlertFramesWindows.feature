Feature: Alert, Frames and windows

@newtab
  Scenario Outline: Switch to new tab and window
    Given I navigate to AlertFramesWindows page
    When I navigate to Browser Windows page from alertsPage
    And I click on <screen> in windows page
    Then I verify This is a sample page in new tab and <URL>
    And I switch back to parent tab
    
    Examples:
    |screen 		| URL											|
    |New Tab		|https://demoqa.com/sample|
    |New Window	|https://demoqa.com/sample|
   
   @alerts 
 Scenario Outline: Switch to alert
    Given I navigate to AlertFramesWindows page
    When I navigate to Alerts page from alertsPage
    And I click on Alert buttons <buttons>
    Then I accept or reject alert <buttons>
    
    Examples:
    |buttons|
    |simple alert|
    |reject alert|