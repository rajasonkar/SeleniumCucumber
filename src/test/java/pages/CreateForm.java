package pages;

import org.openqa.selenium.By;

import helper.ActionHelper;
import utils.TestBase;

public class CreateForm extends TestBase{
	
	private By firstName = By.cssSelector("input#firstName");

	private By lastName = By.cssSelector("input#lastName");
	ActionHelper actionHelper = new ActionHelper();
	public void enterFirstName (String name) 
	{
		actionHelper.scrollToElement(firstName);
		actionHelper.setText(firstName, name);
	}
	public void enterLastName (String name) 
	{
		actionHelper.setText(lastName, name);
	}

}
