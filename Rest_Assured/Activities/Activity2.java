package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Activity2 {

	final static String BASEURI="https://petstore.swagger.io/v2/pet";

	@Test(priority = 1)
	public void postRequest() 
	{
		//https://petstore.swagger.io/v2/pet

		String reqBody = "{\"id\": 77237,\"name\": \"Riley\",\"status\": \"alive\"}";

		Response response=given().log().all().header("Content-Type","application/json").body(reqBody).
				when().post(BASEURI);

		//assertion
		response.then().body("id", equalTo(77237));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));

	}

	@Test(priority = 2)
	public void getRequest()
	{
		//https://petstore.swagger.io/v2/pet/{petId}

		Response response= given().headers("Content-Type","application/json").log().all().
				when().pathParam("petId", "77237").get(BASEURI + "/{petId}");

		response.then().assertThat().statusCode(200);
		response.then().body("id", equalTo(77237));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
	}
	@Test(priority = 3)
	public void deleteRequest()
	{
		//https://petstore.swagger.io/v2/pet/{petId}

		Response response= given().headers("Content-Type","application/json").
				when().pathParam("petId", "77237").delete(BASEURI+"/{petId}");
		
		response.then().assertThat().statusCode(200);
	
	}
}
