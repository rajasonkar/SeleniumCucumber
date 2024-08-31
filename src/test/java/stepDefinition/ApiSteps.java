package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import pages.ApiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiSteps {

	ApiPage apiPage = new ApiPage();
	@Given("^I set the base url for (.*)$")
	public void setBaseURl(String app) throws IOException 
	{
		apiPage.setBaseUrl(app);
	}
//	@Given("I generate the auth token")
//	public void generateToken() 
//	{
//		JsonObject js = new JsonObject();
//		js.addProperty("userName", "rs14");
//		js.addProperty("password", "Test@Selenium01");
//		RestAssured.baseURI = "https://demoqa.com/Account/v1/";
//			
//		//https://demoqa.com/Account/v1/GenerateToken
//		ValidatableResponse hs = RestAssured.given().header("Content-Type", "application/json").
//				body(js).log().all().post("GenerateToken").then().log().all();
//	}
	@When("I set the headers for request")
	public void setHeader() 
	{		
		apiPage.setHeader();
	}
	@When("I add the request body to request")
	public void setBody() throws IOException 
	{
		apiPage.addBody();
	}
	@When("^I execute the (.*) request for (.*)$")
	public void executeRequest(String requestType,String endpoint) 
	{		apiPage.execute(requestType,endpoint);
	}
	@Then("^I verify the status code as (.*)$")
	public void VerifyStatusCode(int code) 
	{		apiPage.verifyToken(code);
	}
	@Then("I verify the token generated")
	public void VerifyTokenGenaerated() 
	{		System.out.println(apiPage.getJsonPathString());
	}
/////////////////////////////////////////////////////////////////
	//booksApi  I print the all the books
	@Then("I print the all the books")
	public void printAllTheBooks() 
	{	
		apiPage.printBookName("books.title");
	}
	
	
}
