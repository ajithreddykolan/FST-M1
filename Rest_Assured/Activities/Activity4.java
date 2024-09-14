package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity4 {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@DataProvider
	public Object[][] petInfoprovider()
	{
		Object[][]testData= new Object[][]
		{
			{ 77232, "Riley", "alive" }, 
			{ 77233, "Hansel", "alive" }
		 };
				return testData;
	}

	@BeforeClass
	public void setUp()
	{
		requestSpec =new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type", "application/json").build();

		responseSpec=new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType("application/json").
				expectBody("status",equalTo("alive")).build();

	}
    
	@Test(priority = 1)
	public void AddPet()
	{
		//**********Post-https://petstore.swagger.io/v2/pet
		
		String reqBody= "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
		Response response=given().spec(requestSpec).body(reqBody).
				          when().post();
		
		reqBody="{\"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\"}";  
		response=given().spec(requestSpec).body(reqBody).
		         when().post();
		// Assertions
        response.then().spec(responseSpec);
				          
	}

	@Test(dataProvider = "petInfoprovider", priority = 2)
	public void getPetDetails(int id,String name,String status)
	{
		//***********Get-https://petstore.swagger.io/v2/pet/{petId}
		Response response=given().spec(requestSpec).pathParam("petId", id).
				          when().get("/{petId}");
		System.out.println(response.asPrettyString());
		
		//Assertation
		response.then().spec(responseSpec).body("name",equalTo(name));
				         
	}

	@Test(dataProvider = "petInfoprovider",priority = 3)
	public void deletePetDetails(int id,String name,String status)
	{
		//**************Delete-https://petstore.swagger.io/v2/pet/{petId}
		Response response=given().spec(requestSpec).pathParam("petId",id).
				          when().delete("/{petId}");
		//Assertation
		response.then().body("code", equalTo(200));
		
		
	}

}
