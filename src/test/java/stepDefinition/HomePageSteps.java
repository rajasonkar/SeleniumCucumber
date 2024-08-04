package stepDefinition;

import io.cucumber.java.en.Given;
import pages.HomePage;

public class HomePageSteps {
//define homepage steps
	HomePage homePage = new HomePage();

	@Given("^I navigate to (.*) page$")
	public void navigateScreen(String screen) throws InterruptedException 
	{
		homePage.navigateToScreen(screen);
	}
}
