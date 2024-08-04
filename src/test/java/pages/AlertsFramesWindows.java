package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import helper.ActionHelper;
import utils.TestBase;

public class AlertsFramesWindows extends TestBase{

	private String button = "//span[text()='%s']";
	private By newTabButton = By.cssSelector("div#tabButtonWrapper>button");
	private By sampleText = By.cssSelector("h1#sampleHeading");
	private By newWindowButton = By.cssSelector("button#windowButton");
	private By simpleAlert = By.cssSelector("button#alertButton");
	private By rejectAlert = By.cssSelector("button#confirmButton");
	
	ActionHelper actionHelper = new ActionHelper();
	
	public void clickButton(String buttonToBeClick) 
	{
		actionHelper.click(button, buttonToBeClick);
	}
	public void clickNewTab(String buttonName) 
	{
		switch(buttonName)
		{
			case "New Tab":
			actionHelper.scrollToElement(newTabButton);	
			actionHelper.click(newTabButton);
			case "New Window":
				actionHelper.scrollToElement(newWindowButton);	
				actionHelper.click(newWindowButton);
		}
	}
	public void switchToNewTab(String url) 
	{
		actionHelper.SwitchtoTab(url);
	}
	public void verifyText(String text) 
	{
		Assert.assertEquals(text, actionHelper.getText(sampleText));
		System.out.println("Text Verified : "+text);
		
	}
	public void SwitchToParent() 
	{
		actionHelper.SwitchtoParentTab();
		System.out.println("Switched back to parent");
		actionHelper.scrollToElement(newTabButton);	
		actionHelper.click(newTabButton);
	}
	
	public void alertAction(String alertType) 
	{
		actionHelper.alertActions(alertType);
	}
	public void alertButton(String alertType) 
	{
		if(alertType.equalsIgnoreCase("simple alert")) 
		{
			actionHelper.scrollToElement(simpleAlert);
			actionHelper.click(simpleAlert);
		}else if (alertType.equalsIgnoreCase("reject alert")) {
			actionHelper.scrollToElement(rejectAlert);
			actionHelper.click(rejectAlert);
		}
	}
}
