package Restassured;

import org.apache.commons.lang3.RandomStringUtils;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Create_shopper {
	String firstname;
	String emaiil;
	String token;
	String shopperId;
@Test
public void post() {
	String random = RandomStringUtils.randomAlphanumeric(3);
	  String randomemail =random + "@gmail.com";
	Response res= RestAssured.
			given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
					+ "  \"city\": \"Bhubaneswar\",\r\n"
					+ "  \"country\": \"India\",\r\n"
					+ "  \"email\": \""+randomemail+"\",\r\n"
					+ "  \"firstName\": \"niki\",\r\n"
					+ "  \"gender\": \"FEMALE\",\r\n"
					+ "  \"imageId\": \"string\",\r\n"
					+ "  \"jwtToken\": \"string\",\r\n"
					+ "  \"lastName\": \"das\",\r\n"
					+ "  \"password\": \"rupa niki@343\",\r\n"
					+ "  \"phone\": \"9765604380\",\r\n"
					+ "  \"role\": \"ADMIN\",\r\n"
					+ "  \"state\": \"odisha\",\r\n"
					+ "  \"status\": \"ACTIVE\",\r\n"
					+ "  \"token\": \"string\",\r\n"
					+ "  \"zoneId\": \"string\"\r\n"
					+ "}").
			contentType("application/json").when().post("/admin").then().assertThat().statusCode(201).and()
			.contentType("application/json")
			.extract().response();
	System.out.println("create account response body is");
	System.out.println(res.asPrettyString());
	
	
	JsonPath js=new JsonPath(res.asPrettyString());
	firstname =js.getString("data.firstname");
	System.out.println(firstname);
	shopperId = js.getString("data.userId");
	   System.out.println(shopperId);
	   emaiil = js.getString("data.email");
		System.out.println(emaiil);
			
}
@Test(priority=1)
public void login() {
	Response res1=RestAssured.
			given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
					+ "  \"email\": \""+emaiil+"\",\r\n"
					+ "  \"password\": \"rupa niki@343\",\r\n"
					+ "  \"role\": \"ADMIN\"\r\n"
					+ "}").contentType("application/json").when().post("/users/login").then().assertThat().statusCode(200).and().
			contentType("application/json")
			.extract().response();
	System.out.println(res1.asPrettyString());
	
	JsonPath js = new JsonPath(res1.asPrettyString());
	token= js.getString("data.jwtToken");
	System.out.println(token);
	 
	
}
@Test(priority=2)
public void get() {
	Response ress = RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").auth().oauth2(token)
			.when().get("/admin/"+shopperId).then().statusCode(200).extract().response();
	System.out.println("get response body is");
	System.out.println(ress.asPrettyString());
}


@Test(priority=3)
public void put() {
	Response ress = RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
			+ "  \"city\": \"Bhubaneswar\",\r\n"
			+ "  \"country\": \"India\",\r\n"
			+ "  \"email\": \""+emaiil+"\",\r\n"
			+ "  \"firstName\": \"niki\",\r\n"
			+ "  \"gender\": \"FEMALE\",\r\n"
			+ "  \"imageId\": \"string\",\r\n"
			+ "  \"jwtToken\": \"string\",\r\n"
			+ "  \"lastName\": \"dasniki\",\r\n"
			+ "  \"password\": \"rupa niki@343\",\r\n"
			+ "  \"phone\": \"9765604380\",\r\n"
			+ "  \"role\": \"ADMIN\",\r\n"
			+ "  \"state\": \"odisha\",\r\n"
			+ "  \"status\": \"ACTIVE\",\r\n"
			+ "  \"token\": \"string\",\r\n"
			+ "  \"zoneId\": \"string\"\r\n"
			+ "}").auth().oauth2(token).contentType("application/json")
			.when().put("/admin/"+shopperId).then().statusCode(200).extract().response();
	System.out.println("put response body is");
	System.out.println(ress.asPrettyString());
	
}



			
			
			
}


