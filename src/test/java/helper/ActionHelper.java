package helper;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestBase;

public class ActionHelper extends TestBase{
//add genric selenium methods
	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Alert alert ;
	public void scrollToElement(WebElement element) 
	{
		js.executeScript("arguments[0].scrollIntoView();", element );
	}
	public void scrollToElement(By element) 
	{
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element) );
	}
	
	public void elementAvailability(String options, By webElement) 
	{
		switch (options) {
		case "visible":
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
			break;
		case "clickable":
			driverWait.until(ExpectedConditions.elementToBeClickable(webElement));
			break;
		case "invisible":
			driverWait.until(ExpectedConditions.invisibilityOfElementLocated(webElement));
		}
	}
	
	public void click(By webElement) 
	{
		elementAvailability("visible", webElement);
		elementAvailability("clickable", webElement);
		driver.findElement(webElement).click();
	}
	
	public void setText(By webElement, String text) 
	{
		elementAvailability("visible", webElement);
		driver.findElement(webElement).clear();
		driver.findElement(webElement).sendKeys(text);
	}
	public void selectValueFromDropDown(By webElement, String value) 
	{
		elementAvailability("visible", webElement);
		WebElement element = driver.findElement(webElement);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	public boolean checkIsDisabled(By webElement) 
	{
		
		return driver.findElement(webElement).isEnabled();
	}
	public void uploadFile(String path, By element) 
	{
		scrollToElement(element);
		File file = new File(path);
		driver.findElement(element).sendKeys(file.getAbsolutePath());
	}
	public String getText(By webElement) 
	{
		return driver.findElement(webElement).getText();
	}
	public String getTextByAttribute(String attributeValue, By webElement) 
	{
		return driver.findElement(webElement).getAttribute(attributeValue);
	}
	
	public void click(String webElement, String textToBeInserted) 
	{

		driver.findElement(By.xpath(String.format(webElement, textToBeInserted))).click();
	}
	
	public void SwitchtoTab(String Url) 
	{
		addRunTimeTestData("parentWindow", driver.getWindowHandle());
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext()) 
		{
			driver.switchTo().window(itr.next());
			if(driver.getCurrentUrl().equalsIgnoreCase(Url))
				break;
		}
		
	}
	public void SwitchtoParentTab() 
	{
		
	driver.switchTo().window(getRunTimeTestData("parentWindow").toString());
		
	}
	
	public void alertActions(String alertType)
	{
		alert = driver.switchTo().alert();
		if(alertType.equalsIgnoreCase("simple alert")) 
		{
			driverWait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		}
		else if (alertType.equalsIgnoreCase("reject alert")) 
		{
			driverWait.until(ExpectedConditions.alertIsPresent());
			alert.dismiss();
		}
	}
}
