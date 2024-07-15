package project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHub_RestAssured_Project {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	String SSHKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIPHRACLS/DDLgxcOTUlz53S8sRQ0Qko5MO0bkTUtjUMK";
	int SSHKeyId;
	
	@BeforeClass
	public void setUp() {
		requestSpec= new RequestSpecBuilder().
				setBaseUri("https://api.github.com").
				addHeader("Content-Type", "application/json").
				addHeader("Authorization", "token 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").
				build();
		
		responseSpec=new ResponseSpecBuilder().
				expectResponseTime(lessThanOrEqualTo(3000L)).build();
				
	}
	
	@Test(priority=1)
	public void postRequest() {
		Map<String, Object> reqBody= new HashMap<String, Object>();
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key", SSHKey);
		Response response = given().spec(requestSpec).body(reqBody).when().post("/user/keys");
		
		SSHKeyId=response.then().extract().path("id");
		//Assertions
		response.then().spec(responseSpec).statusCode(201);
	}
	
	@Test(priority=2)
	public void getRequest() {
		Response response =		
		given().spec(requestSpec).pathParam("keyId", SSHKeyId).
		when().get("/user/keys/{keyId}");

		Reporter.log(response.asPrettyString());
		response.then().spec(responseSpec).statusCode(200);
		
	}
	
	
	@Test(priority=3)
	public void deleteRequest() {
		Response response =	
		given().spec(requestSpec).pathParam("keyId", SSHKeyId).
		when().delete("/user/keys/{keyId}");
		
		Reporter.log(response.asPrettyString());
		response.then().spec(responseSpec).statusCode(204);
		
	}
	
}
