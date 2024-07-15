package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {
	
//GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
	@Test
	public void getReqWithQueryParam() {

		Response response=
				given().
				baseUri("https://petstore.swagger.io/v2/pet").
				header("Content-Type", "application/json").
				queryParam("status", "alive").
				when().
				get("/findByStatus");
		
		System.out.println(response.getHeaders());
		System.out.println(response.getBody().asString());
		System.out.println(response.getBody().asPrettyString());
		
		String petStatus=response.then().extract().path("[0].status");
		System.out.println("pet status is "+ petStatus);
		Assert.assertEquals(petStatus, "alive");
		
		response.then().statusCode(200).body("[0].status", equalTo("alive"));
	}

	//GET https://petstore.swagger.io/v2/pet/{petId}
	@Test
	public void getReqWithPathParam() {

		given().
		baseUri("https://petstore.swagger.io/v2/pet").
		header("Content-Type", "application/json").
		pathParam("petId", 77232).
		log().all().
		when().
		get("/{petId}").
		then().
		statusCode(200).
		body("status", equalTo("alive")).
		body("name", equalTo("Riley")).
		log().all();
		
		
	}

}







