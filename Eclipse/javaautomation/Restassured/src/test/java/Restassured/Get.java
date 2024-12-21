package Restassured;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get {

	public static void main(String[] args) {
		
	RestAssured.baseURI="https://restful-booker.herokuapp.com";
	RequestSpecification req = RestAssured.given();
	Response res = req.when().get("/booking");
	System.out.println(res.asPrettyString());
		
	}

}
