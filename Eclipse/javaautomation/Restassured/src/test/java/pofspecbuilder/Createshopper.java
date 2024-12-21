package pofspecbuilder;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Createshopper {
@Test
public void create() {
	Scriptt s=new Scriptt();
	RequestSpecification request=s.request();
	ResponseSpecification response=s.response();
	
	
	 Response res = RestAssured.given().spec(request).when().post("/shoppers").then().spec(response).extract().response();
	 System.out.println(res.asPrettyString());
	
	
	
}
}
