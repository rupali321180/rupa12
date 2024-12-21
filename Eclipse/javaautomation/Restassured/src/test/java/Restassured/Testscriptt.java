package Restassured;

import org.json.simple.JSONObject;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testscriptt {
@Test
public void post() {
	RestAssured.baseURI="https://restful-booker.herokuapp.com";
	RequestSpecification req = RestAssured.given();
	JSONObject obj=new JSONObject();   //use for to easily create,parse and manipulate json data
	obj.put("username","admin");
	obj.put("password","password123");
	req.contentType(ContentType.JSON);
	req.body(obj.toJSONString());
	Response res = req.request(Method.POST,"/auth");
	System.out.println(res.asPrettyString());
	
}
@Test
public void get() {
	RestAssured.baseURI="https://restful-booker.herokuapp.com";
	RequestSpecification req = RestAssured.given();
	Response res = req.when().get("/booking");
	System.out.println(res.asPrettyString());
		
	}

}


