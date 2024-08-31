package helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.*;

public class ApiHelper {

	RestAssured restAssured;
	//JsonObject js;
	RequestSpecification requestSpecification;
	Response response;
	public void setBaseApiURL(String url) 
	{
		 restAssured.baseURI =url;
	}
	public void addHeader(String key, String value) 
	{
		requestSpecification= restAssured.given().header(key,value);
	}
	public void addbody(JsonObject jsonObject) 
	{
		 requestSpecification.body(jsonObject);
	}
	public void executeRequest(String requestType ,String endPoint) 
	{
		 if(requestType.equalsIgnoreCase("get")) 
		 {
			 response= requestSpecification.get(endPoint);
		 }
		 else if(requestType.equalsIgnoreCase("post")) 
		 {
			response= requestSpecification.post(endPoint);
		 }
	}
	public int getStatusCode() 
	{
		return response.getStatusCode();
	}
	public String getResponseData(String jpath) 
	{
		JsonPath jsonpath = new JsonPath(response.getBody().asString());
		System.out.println(response.getBody().path(jpath).toString());
		return jsonpath.getString(jpath);
		
		}
	public void printBooks(String jpath) 
	{
		
		List<Object> listOfBooks= response.body().jsonPath().getList(jpath);
		System.out.println(listOfBooks);
		
		}
}
