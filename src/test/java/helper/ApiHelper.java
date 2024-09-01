package helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.Books;
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
	
		List<Books> abc =response.getBody().jsonPath().getList("books", Books.class);
	//	List<Books> abc =response.body().jsonPath().getList("books", Books.class);
	//	above both code are valid line 63 and 63 getBody()s/body()
		for(Books b : abc) 
		{
			System.out.println(b.getTitle());
			System.out.println(b.getIsbn());
		}
				
		}
	public void printHeadrs() 
	{
		   Headers header =response.getHeaders();
			System.out.println(response.getHeaders());
			System.out.println("header by key --------------------------------------");
			System.out.println(header.get("Connection"));
			System.out.println("header by value --------------------------------------");
			System.out.println(header.getValue("Connection"));
			System.out.println("using for loop printing all---------------------------------------");
			
			for(Header head : header.asList()) 
			{
				System.out.println(head);
			}

			System.out.println("checking session id "+response.getSessionId());

	}
}
