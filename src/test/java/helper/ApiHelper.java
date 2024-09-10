package helper;
import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.Books;
import models.Users;
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
	public void addQueryParamter(String key, String value) 
	{
		requestSpecification = requestSpecification.queryParams(key, value);
	}
	public void addHeader(String key, String value) 
	{
		/*
		 * if(value.equals("ContentType.JSON")) { requestSpecification=
		 * restAssured.given().config(RestAssured.config().
		 * encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs(
		 * "ContentType.JSON", ContentType.TEXT))); // encodeContentTypeAs(value,
		 * ContentType.TEXT));
		 * 
		 * } else
		 */ requestSpecification= restAssured.given().header(key,value);
		 
		//if you have some query Parameter
		//requestSpecification = requestSpecification.queryParam(value, null);
		//requestSpecification.pathParams(key, value, null);//
		//requestSpecification= restAssured.given().contentType(ContentType.JSON);need to work
	}
	public void addbody(JsonObject jsonObject) 
	{
		 requestSpecification.body(jsonObject);
	}
	public void addbody(String filePath) throws IOException 
	{
		byte[] inputFile = Files.readAllBytes(Paths.get(filePath));
		requestSpecification.body(inputFile);
		
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
		 else if(requestType.equalsIgnoreCase("put")) 
		 {
			 
			response= requestSpecification.put(endPoint);
		 }
		 else if(requestType.equalsIgnoreCase("patch")) 
		 {
			 
			response= requestSpecification.put(endPoint);
		 }
		 else if(requestType.equalsIgnoreCase("delete")) 
		 {
			 
			response= requestSpecification.delete(endPoint);
		 }
	}
	public int getStatusCode() 
	{
		System.out.println(response.getStatusCode());
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
	public void printUserDeatilsFromResponse() 
	{
		List<Users> user = response.getBody().jsonPath().getList("data",Users.class);
		for(Users u : user) 
		{
			System.out.print(u.getId()+" , ");
			System.out.print(u.getFirst_name()+" , ");
			System.out.print(u.getLast_name()+" , ");
			System.out.print(u.getEmail()+" , ");
			System.out.print(u.getAvatar()+" , ");
			System.out.println("---------------------");
		}
	}
}
