package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AlertsFramesWindows;

public class AlertFramesWindowsSteps {
	
	AlertsFramesWindows alertsFramesWindows = new AlertsFramesWindows();
	@When("^I navigate to (.*) page from alertsPage$")
	 public void navigateToBrowseWindowsPage(String buttonClick) 
	 {
		alertsFramesWindows.clickButton(buttonClick);
	 }
	 
	@When("^I click on (.*) in windows page$")
	 public void navigateToPage(String buttonName) 
	 {
		alertsFramesWindows.clickNewTab(buttonName);
	 }
	
	 @Then("^I verify (.*) in new tab and (.*)$")
	 public void verifyText(String message, String URL) 
	 {
		 alertsFramesWindows.switchToNewTab(URL);
		 alertsFramesWindows.verifyText(message);
	 }
	 
	 @Then("I switch back to parent tab")
	 public void switchToParentTab() 
	 {
		 alertsFramesWindows.SwitchToParent();
	 }
	 
	 @When("^I click on Alert buttons (.*)$")
	 public void clickOnAlertButtons(String alertType) 
	 {
		 alertsFramesWindows.alertButton(alertType);
		
	 }
	 @Then("^I accept or reject alert (.*)$")
	 public void acceptRejectAlert(String alertType) 
	 {
		 alertsFramesWindows.alertAction(alertType);
	 }
}
