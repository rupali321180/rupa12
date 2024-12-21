package Restassured;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Shopper {
String token;
String jwt Token;
@Test
public void post() {
	Response res = RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
			+ "  \"city\": \"Bangalore\",\r\n"
			+ "  \"country\": \"India\",\r\n"
			+ "  \"email\": \"rupali90011@gmail.com\",\r\n"
			+ "  \"firstName\": \"rupa das\",\r\n"
			+ "  \"gender\": \"MALE\",\r\n"
			+ "  \"lastName\": \"das\",\r\n"
			+ "  \"password\": \"rupali@qOO110\",\r\n"
			+ "  \"phone\":7656545673,\r\n"
			+ "  \"state\": \"odisha\",\r\n"
			+ "  \"zoneId\": \"ALPHA\"\r\n"
			+ "}").contentType("application/json").when().post("/shoppers").then().assertThat().statusCode(201).and().contentType("application/json")
			.extract().response();
	System.out.println(res.asPrettyString());
}
@Test
public void login() {
	Response res1=RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
			+ "  \"email\":\"rupali90011@gmail.com\",\r\n"
			+ "  \"password\":\"rupali@qOO110\",\r\n"
			+ "  \"role\": \"SHOPPER\"\r\n"
			+ "}").contentType("application/json").when().post("/users/login").then().assertThat().statusCode(200).and().contentType("application/json")
			.extract().response();
	System.out.println("login account response body is");
	System.out.println(res1.asPrettyString());
	
	JsonPath jp=new JsonPath(res1.asPrettyString());
	token=jp.getString("data.jwtToken");
	System.out.println("token");

			
}
@Test
public void get() {
Response ress= RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").auth().oauth2(token)
.when().get("/shoppers/167147").then().assertThat().contentType("application/json").extract().response();
	System.out.println(ress.asPrettyString());
			
}
@Test
public void patch() {
	Response res2 = RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
			+ "  \"city\": \"Bangalore\",\r\n"
			+ "  \"country\": \"India\",\r\n"
			+ "  \"email\": \""+randomemail+"\",\r\n"
			+ "  \"firstName\": \"rupa das\",\r\n"
			+ "  \"gender\": \"FEMALE\",\r\n"
			+ "  \"lastName\": \"niki rupali\",\r\n"
			+ "  \"password\": \"rupali@qOO234\",\r\n"
			+ "  \"phone\":7656545672,\r\n"
			+ "  \"state\": \"odisha\",\r\n"
			+ "  \"zoneId\": \"ALPHA\"\r\n"
			+ "}").contentType("application/json").auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJydXBhbGk5MDAxQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzMyMjE2MzM1LCJpYXQiOjE3MzIxODAzMzV9.dvokc5nyObotBPp927SpwLIMztb3t6ahaGkTo7gNS1Q\"\r\n"
					+ "    }").when().patch("/shoppers/167147").then().assertThat().statusCode(200).and().contentType("application/json")
			.extract().response();
	System.out.println(res2.asPrettyString());
			
}
			

@Test
public void forgot() {
	Response res3= RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").header("password","rupali@qOO234").headers("role","SHOPPER").when().post("/users/forgot-password")
			.then().assertThat().statusCode(200).and().contentType("application/json")
			.extract().response();
	System.out.println(res3.asPrettyString());
	}
@Test
public void veryfy() {
	Response rese = RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").queryParams("token","YtU3ahbilDM5cCWZl2ksvgeRxKGGKcCJOZOL63DcEoukH").auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJydXBhbGk5MDAxQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzMyMjIzMjAwLCJpYXQiOjE3MzIxODcyMDB9.-Oe0YHY6sTtH4tGuefR_4ox1cNILeDDYcUb4EKTjylU\"\r\n"
			+ "    }").headers("password","rupali@qOO11").when().post("/users/verify-account").then().assertThat().statusCode(200).and().contentType("application/json").extract().response();
	System.out.println(rese.asPrettyString());
	
}

}
