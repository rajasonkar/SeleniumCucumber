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
	private String parentFrameId = "frame1";
	private By parentFrameText = By.xpath("//body[text()]");
	private By childFrameText = By.xpath("//body/p[text()]");
	private By headerText = By.cssSelector("div#framesWrapper>h1");
	ActionHelper actionHelper = new ActionHelper();
	
	public void clickButton(String buttonToBeClick) 
	{
		actionHelper.scrollToElement(button, buttonToBeClick);
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
	
	public void switchToParentFrame() 
	{
		actionHelper.switchToFrame(parentFrameId);
	}
	public void verifyTFrameext(String frame,String text) 
	{
		if(frame.equalsIgnoreCase("parent")) 
		{
			actionHelper.scrollToElement(parentFrameText);
		Assert.assertEquals(text, actionHelper.getText(parentFrameText));
		System.out.println("Text Verified : "+text);
		}
		else 
		{
			actionHelper.scrollToElement(childFrameText);
			Assert.assertEquals(text, actionHelper.getText(childFrameText));
			System.out.println("Text Verified : "+text);
		}
	}
	
	public void switchToChildFrame() 
	{
		actionHelper.switchToFrame(driver.findElement(By.xpath("//*[@srcdoc]")));
	}
	public void switchToDefaultFrame() 
	{
		actionHelper.switchToDefaultFrame();
	}
	public void verifyTextFrames(String text) 
	{
		Assert.assertEquals(text, actionHelper.getText(headerText));
		System.out.println("Text Verified : "+text);
	}
}
