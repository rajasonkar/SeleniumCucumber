package utils;

import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class TestBase {
//taskkill /im chromedriver.exe /f
	
public static WebDriver driver;
protected DataFromPropertyFile readPropertFileData = new DataFromPropertyFile();

HashMap<String, Object> data = new HashMap<>();
public void CaptureScreenshot(Scenario scenario) {
TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
byte[] ss = takeScreenshot.getScreenshotAs(OutputType.BYTES);
scenario.attach(ss, "image/png", "screenshot");

}

  public void addRunTimeTestData(String key, String value)
  {
	  data.put(key, value);
  }

  public Object getRunTimeTestData(String key)
  {
	  return data.get(key);
  }
}
