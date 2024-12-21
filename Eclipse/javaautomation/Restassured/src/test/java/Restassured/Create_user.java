package Restassured;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Create_user {
		// TODO Auto-generated method stub
@Test
public void post() {
	Response res = RestAssured.given().baseUri("https://petstore.swagger.io/v2").body("{\r\n"
			+ "  \"id\": 0,\r\n"
			+ "  \"username\": \"rupali\",\r\n"
			+ "  \"firstName\": \"niki\",\r\n"
			+ "  \"lastName\": \"das\",\r\n"
			+ "  \"email\": \"rupali312@gmail.com\",\r\n"
			+ "  \"password\": \"rupali31234\",\r\n"
			+ "  \"phone\": \"7654565892\",\r\n"
			+ "  \"userStatus\": 0\r\n"
			+ "}").contentType("application/json").when().post("/user").then().assertThat().statusCode(200).and()
			.contentType("application/json")
			.extract().response();
	System.out.println(res.asPrettyString());
	
}
	@Test
	public void get() {
		Response res = RestAssured.given().baseUri("https://petstore.swagger.io/v2").contentType("application/json").when().get("user/rupali")
				.then().assertThat().statusCode(200).and()
				.contentType("application/json")
				.extract().response();
		System.out.println(res.asPrettyString());
				
				
				
	}	
	@Test
	public void put() {
		 Response res= RestAssured.given().baseUri("https://petstore.swagger.io/v2").body("{\r\n"
		 		+ "  \"id\": 0,\r\n"
		 		+ "  \"username\": \"rupali dass\",\r\n"
		 		+ "  \"firstName\": \"niki das\",\r\n"
		 		+ "  \"lastName\": \"das\",\r\n"
		 		+ "  \"email\": \"rupali@gmail.com\",\r\n"
		 		+ "  \"password\": \"rupali1234\",\r\n"
		 		+ "  \"phone\": \"7654567892\",\r\n"
		 		+ "  \"userStatus\": 0\r\n"
		 		+ "}").contentType("application/json").when().put("/user/rupali")
		.then().assertThat().statusCode(200).and().
		contentType("application/json")
		.extract().response();
		System.out.println(res.asPrettyString());
	}
	
	
	
	
	
	
	
	
}


