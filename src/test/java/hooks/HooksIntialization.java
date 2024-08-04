package hooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestBase;

public class HooksIntialization extends TestBase{
	//WebDriver driver;
	
//before and after hook
	//WebDriver driver;
	@Before
	public void launchBrowser() throws IOException {
		driver =startBrowser(driver);
		driver.get(readPropertFileData.readData("URL"));
		
	}
	
	@After
	public void quitBrowser() {
		//WebDriverManager.chromedriver().setup();
		driver.quit();
	}
	@AfterStep
	public void afterStep(Scenario scenario)
	{
		if(scenario.isFailed()) 
		{
			CaptureScreenshot(scenario);
		}
	}
	
	private WebDriver startBrowser(WebDriver driver) 
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
       // options.setCapability("credentials_enable_service", false);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
}
