package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestBase;

public class HooksIntialization extends TestBase{
	WebDriver driver ; 
	/*
	 * public HooksIntialization(WebDriver driver) { super(driver);
	 * 
	 * }
	 */

//before and after hook
	
	@Before
	public void launchBrowser() throws IOException {
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
       // options.setCapability("credentials_enable_service", false);
		driver = new ChromeDriver(options);
		driver.get(readPropertFileData.readData("URL"));
		
	}
	
	@After
	public void quitBrowser() {
		//WebDriverManager.chromedriver().setup();
		driver.quit();
	}
}
