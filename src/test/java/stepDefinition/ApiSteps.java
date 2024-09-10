package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import pages.ApiPage;
import utils.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiSteps {

	ApiPage apiPage = new ApiPage();
	TestBase testBase = new TestBase();
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
//			s
//		//https://demoqa.com/Account/v1/GenerateToken
//		ValidatableResponse hs = RestAssured.given().header("Content-Type", "application/json").
//				body(js).log().all().post("GenerateToken").then().log().all();
//	}
	@When("^I set the headers for request as (.*) as (.*)$")
	public void setHeader(String key, String value) 
	{		
		apiPage.setHeader(key, value);
	}
	@When("I add the request body to request")
	public void setBody() throws IOException 
	{
		apiPage.addBody();
	}
	
	@When("^I add the (.*) file to request body$")
	public void setBodyusingJsonFile(String fileName) throws IOException 
	{
		apiPage.addBodyJsonFile(fileName);
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
	{		System.out.println(apiPage.getJsonPathString("token"));
	}
/////////////////////////////////////////////////////////////////
	//booksApi  I print the all the books
	@Then("I print the all the books")
	public void printAllTheBooks() 
	{	
		apiPage.printBookName("books.title");
	}
	
	@Then("I print all the headers")
	public void printAllTheHeaders() 
	{	
		apiPage.printHeader();
	}
	@Then("^I get (.*) from the response generated$")
	public void getdataFromResponse(String key) 
	{	
		String data = apiPage.getJsonPathString(key);
		System.out.println(data);
	    testBase.addRunTimeTestData(key, data);
	    
	}
	@When("^I execute the update (.*) request having (.*) for (.*)$")
	public void executeUpdateRequest(String requestType,String pathToAdd,String endpoint) 
	{		
		endpoint = endpoint + testBase.getRunTimeTestData(pathToAdd);
		apiPage.execute(requestType,endpoint);
	}
	
	@When("^I add the query parameter as (.*) (.*)$")
	public void addQueryParameter(String key,String value) 
	{		
		apiPage.setQueryParam(key,value);
	}
	@When("I print all the details from the response of all users")
	public void printAllUsersDetails() 
	{
		apiPage.printUserDetails();
	}
}
