package pages;

import org.openqa.selenium.By;

import helper.ActionHelper;
import utils.TestBase;

public class Widgets extends TestBase{

	private By menuButton = By.xpath("//span[@class='text' and text()='Menu']");
	private By mainItem2 = By.xpath("//a[text()='Main Item 2']");
	private By subSubList = By.xpath("//a[contains(text(),'SUB SUB LIST ')]");
	private By subSubItem1 = By.xpath("//a[contains(text(),'Sub Sub Item 1')]");
	
	
	ActionHelper actionHelper = new ActionHelper();
	public void clickMenuButton() 
	{
		actionHelper.scrollToElement(menuButton);
		actionHelper.click(menuButton);
	}
	public void moveToElementAndClickSubSubItem() 
	{
		actionHelper.scrollToElement(mainItem2);
	actionHelper.mouseHover(mainItem2);	
	//actionHelper.scrollToElement(subSubList);
	actionHelper.mouseHover(subSubList);
//	actionHelper.scrollToElement(subSubItem1);
	actionHelper.click(subSubItem1);
	}
}
