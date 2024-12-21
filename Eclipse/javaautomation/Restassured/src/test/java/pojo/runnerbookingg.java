package pojo;

import org.testng.annotations.Test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class runnerbookingg {
@Test
public void create() throws JsonProcessingException {
	createebooking cr=new createebooking();
	cr.setFirstname("rupali");
	cr.setLastname("das");
	cr.setTotalprice(2000);
	cr.setDepositpaid(true);
	
	
	Bookingg b=new Bookingg();
	b.setCheckin("2018-01-01");
	b.setCheckout("2019-01-01");
	
	cr.setBookingdates(b);
	cr.setAdditionalneeds("Breakfast");
	
	ObjectMapper obj=new ObjectMapper();
	String jsonbody = obj.writeValueAsString(cr);
	System.out.println(jsonbody);
	
	RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").
	body(jsonbody).contentType("application/json").when().post("booking").then().statusCode(200).log().all();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
