package pojoShopper;

import org.testng.annotations.Test;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Runnercreateshopperpojo {

	@Test
	public void create() throws JsonProcessingException {
		
		Createshopper cr=new Createshopper();
		cr.setCity("Bangalore");
		cr.setCountry("India");
		cr.setEmail("rupali1487@gmail.com");
		cr.setFirstName("rupali");
		cr.setGender("FEMALE");
		cr.setLastName("das");
		cr.setPassword("qwerty56@AB");
		cr.setPhone("7654345678");
		cr.setState("odisha");
		cr.setZoneId("ALPHA");
		
		
		ObjectMapper obj=new ObjectMapper();
		String jsonbody = obj.writerWithDefaultPrettyPrinter().writeValueAsString(cr);
		System.out.println(jsonbody);
		
		Response res = RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body(jsonbody).contentType("application/json").when().post("/shoppers")
		.then().statusCode(201).extract().response();
		System.out.println(res.asPrettyString());
		
		Responsebodypojo dt = res.as(Responsebodypojo.class);
		String shopperid = dt.getMessage();
		System.out.println(shopperid);
		
		
		
		
	}
}
