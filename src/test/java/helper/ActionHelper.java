package helper;

import java.time.Duration;

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
	
}
