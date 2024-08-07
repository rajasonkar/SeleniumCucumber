package stepDefinition;

import io.cucumber.java.en.When;
import pages.Widgets;

public class WidgetsPageSteps {
     Widgets widget = new Widgets();
	@When("I click on Menu button")
	public void clickOnMenuButton() 
	{
		widget.clickMenuButton();
	}
	
	@When("I click on the sub sub item 1")
	public void clickOnSubSubItem1() 
	{
		widget.moveToElementAndClickSubSubItem();
	}
	
	
}
