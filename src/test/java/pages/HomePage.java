package pages;

import org.openqa.selenium.By;

import helper.ActionHelper;
import utils.TestBase;

public class HomePage extends TestBase{
//Define homepage methods
	
	private By elementsButton = By.xpath("//h5[text()='Elements']");
	private By homepageIcon = By.xpath("//div[@id='app']/header/a/img");
	private By formsButton = By.xpath("//h5[text()='Forms']");
	private By practiceForm = By.xpath("//span[text()='Practice Form']");
	private By alertFramesButton = By.xpath("//h5[text()='Alerts, Frame & Windows']");
	private By widgetsButton = By.xpath("//h5[contains(text(),'Widgets')]");
	ActionHelper actionHelper = new ActionHelper();
	
	public void navigateToScreen(String screen) 
	{
		switch(screen) 
		{
		case "Elements":
			navigateToElementsPage();
			break;
		case "Home":
			navigateToHomePage();
			break;
		case "Forms":
			navigateToFormsPage();
			break;
		case "AlertFramesWindows":
			navigateToAlertsFramesPage();
			break;
		case "Widgets":
			navigateToWidgetsPage();
			break;	
		default:
		break;
		}
		
	}
	public void navigateToElementsPage() 
	{
		actionHelper.scrollToElement(driver.findElement(elementsButton));
		actionHelper.click(elementsButton);
	}
	
	public void navigateToHomePage() 
	{
		actionHelper.scrollToElement(driver.findElement(homepageIcon));
		actionHelper.click(homepageIcon);
	}
	
	public void navigateToFormsPage() 
	{
		actionHelper.scrollToElement(driver.findElement(formsButton));
		actionHelper.click(formsButton);
		actionHelper.click(practiceForm);
	}
	public void navigateToAlertsFramesPage() 
	{
		actionHelper.scrollToElement(driver.findElement(alertFramesButton));
		actionHelper.click(alertFramesButton);
		
	}

	public void navigateToWidgetsPage() 
	{
		actionHelper.scrollToElement(driver.findElement(widgetsButton));
		actionHelper.click(widgetsButton);
	}	
}
