package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity3 {
	
  final static String BASEURI="https://petstore.swagger.io/v2/user";
	
	
  @Test(priority=1)
  public void postRequest_addUserfromFile() throws IOException 
  {
	  //**************post=https://petstore.swagger.io/v2/user*****************
	  
	
	  FileInputStream inputJson=new FileInputStream("src/test/java/activities/activity2_createUser.json");  //import json file
	  String reqBody=new String(inputJson.readAllBytes());  //Read JSON file as string
	  
	  Response response=given().headers("Content-Type","application/json").body(reqBody).
			            when().post(BASEURI);
	  
	  inputJson.close();// close the file
	  response.then().log().all() ;    //print response in console
	  response.then().statusCode(200);
	  response.then().body("message", equalTo("5005"));
	    
  }
  
  
  @Test(priority=2)
  public void getRequest()
  {
	  //*************GET=https://petstore.swagger.io/v2/user/{username}**********
	  
	  File OUTPUTJSON=new File("src/test/java/activities/activity2_getUserInfo.json");// to write the response in json 
	  
	  Response response=given().log().all().headers("Content-Type","application/json").pathParam("username", "RachelRoss5").
			            when().get(BASEURI +"/{username}");
	  
	  String resBody= response.getBody().asPrettyString();
	  
	  try {
		// create JSON file
		  OUTPUTJSON.createNewFile();
		  //write the response body to external file
		  FileWriter writer=new FileWriter(OUTPUTJSON.getPath());
		  writer.write(resBody);
		  writer.close();	
	      } 
	  catch (Exception e) 
	  {
	      e.printStackTrace();
	  }
	  
	  //Assertation
	  response.then().body("id",equalTo(5005));
	  response.then().body("username",equalTo("RachelRoss5"));
	  response.then().body("firstName",equalTo("Rachel"));
	  response.then().body("lastName",equalTo("Ross"));
	  response.then().body("email",equalTo("rachelross@mail.com"));
	  response.then().body("password",equalTo("password123"));
	  response.then().body("phone",equalTo("9812763455"));
	  
  }
  
  @Test(priority=3)
  public void deleteRequest_deletUser()
  {
	 // https://petstore.swagger.io/v2/user/{username}
	  Response response=given().log().all().headers("Content-Type","application/json").pathParam("username", "RachelRoss5").
	                    when().delete(BASEURI +"/{username}");
	  response.then().log().all();
	  response.then().assertThat().statusCode(200);
	  response.then().body("message", equalTo("RachelRoss5"));
  }
}
