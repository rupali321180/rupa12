package Restassured;

import org.apache.commons.lang3.RandomStringUtils;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Exec_ute {
	
	String shopperId;
	String email;
	String  token;
@Test(priority = 0)
public void post() {
	
		String random = RandomStringUtils.randomAlphanumeric(3);
	  String randomemail =random + "@gmail.com";
	 Response res= RestAssured.
				given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
						+ "  \"city\": \"Bangalore\",\r\n"
						+ "  \"country\": \"India\",\r\n"
						+ "  \"email\": \""+randomemail+"\",\r\n"
						+ "  \"firstName\": \"niki\",\r\n"
						+ "  \"gender\": \"FEMALE\",\r\n"
						+ "  \"imageId\": \"string\",\r\n"
						+ "  \"jwtToken\": \"string\",\r\n"
						+ "  \"lastName\": \"das\",\r\n"
						+ "  \"password\": \"rupaniki@343\",\r\n"
						+ "  \"phone\": \"9765604380\",\r\n"
						+ "  \"role\": \"ADMIN\",\r\n"
						+ "  \"state\": \"karnataka\",\r\n"
						+ "  \"status\": \"ACTIVE\",\r\n"
						+ "  \"token\": \"string\",\r\n"
						+ "  \"zoneId\": \"ALPHA\"\r\n"
						+ "}").
				contentType("application/json").when().post("/admin").then().assertThat().statusCode(201).and()
				.contentType("application/json")
				.extract().response();
	 System.out.println("create account response body is");
		System.out.println(res.asPrettyString());
		
		JsonPath js = new JsonPath(res.asPrettyString());
		email = js.getString("data.email");
		System.out.println(email);
	  shopperId = js.getString("data.userId");
	   System.out.println(shopperId);
		
	}
	 
	 @Test(priority = 1)
	 public void login()
	 {
		 Response res= RestAssured.
					given().baseUri("https://www.shoppersstack.com/shopping"). 
		 body("{\r\n"
		 		+ "  \"email\": \""+email+"\",\r\n"
		 		+ "  \"password\": \"rupaniki@343\",\r\n"
		 		+ "  \"role\": \"ADMIN\"\r\n"
		 		+ "}").
		 contentType("application/json").when().post("/users/login").then().assertThat().statusCode(200).and()
			.contentType("application/json")
			.extract().response();
	        System.out.println(res.asPrettyString());
	        
	     JsonPath js = new JsonPath(res.asPrettyString());
		 token= js.getString("data.jwtToken");
		System.out.println(token);
		 
		 }
	 
	 
	 
	 @Test(priority = 2)
	 public void get()
	 {
		 
		 Response res= RestAssured.
					given().baseUri("https://www.shoppersstack.com/shopping").  
		 auth().oauth2(token)
		 .when().get("/admin/"+shopperId).then().assertThat().statusCode(200).
		 extract().response();
	        System.out.println(res.asPrettyString());
	        
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	 
	 
}
