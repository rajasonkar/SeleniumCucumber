package stepDefinition;

import io.cucumber.java.en.Given;
import pages.HomePage;

public class HomePageSteps {
//define homepage steps
	HomePage homePage = new HomePage();
	@Given("^I navigate to (.*) page$")
	public void testMethod(String screen) throws InterruptedException 
	{
		switch(screen) 
		{
		case "Elements":
			homePage.navigateToElementsPage();
			break;
		case "Home":
			homePage.navigateToHomePage();
		case "Forms":
			homePage.navigateToFormsPage();
		}
		
	}
}
