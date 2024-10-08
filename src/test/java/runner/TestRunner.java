package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue= {"stepDefinition","hooks"},
		plugin ={"pretty","json:target/jsonReports/cucumber-report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	//	)
	//	,tags="@newtab")
        ,tags="@api")
//rs14 Test@Selenium01
public class TestRunner {
//to execute cases
} 
