package stepDefinition;

import io.cucumber.java.en.Given;

public class HomePageSteps {
//define homepage steps
	
	@Given("I want to write a step with precondition")
	public void testMethod() 
	{
		System.out.println("testing");
	}
}
