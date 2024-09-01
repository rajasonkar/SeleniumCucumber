package pages;

import java.io.IOException;

import org.junit.Assert;

import com.google.gson.JsonObject;

import helper.ApiHelper;
import utils.DataFromPropertyFile;

public class ApiPage{

	ApiHelper apiHelper = new ApiHelper();
	DataFromPropertyFile dfpr = new DataFromPropertyFile();
	public void setBaseUrl(String app) throws IOException 
	{
		if(app.equalsIgnoreCase("token"))
		apiHelper.setBaseApiURL(dfpr.readData("apiBaseUrl"));
		else if(app.equalsIgnoreCase("books"))
			apiHelper.setBaseApiURL(dfpr.readData("booksBaseUrl"));
	}
	public void setHeader() 
	{
		apiHelper.addHeader("Content-Type", "application/json");
	}
	
	public void addBody() throws IOException 
	{
		JsonObject js = new JsonObject();
		js.addProperty("userName", dfpr.readData("username"));
		js.addProperty("password", dfpr.readData("password"));
		apiHelper.addbody(js);
	}
	public void execute(String requestType,String endpoint) 
	{
		apiHelper.executeRequest(requestType, endpoint);
	}
	public void verifyToken(int statusCode) 
	{
		Assert.assertTrue(statusCode== apiHelper.getStatusCode());
	}
	public String getJsonPathString() 
	{
		return apiHelper.getResponseData("token");
	}
	public void printBookName(String jpath) 
	{
		 apiHelper.printBooks(jpath);
	}
	public void printHeader() 
	{
		apiHelper.printHeadrs();
	}
}
