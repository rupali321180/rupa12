package pojo;

import org.testng.annotations.Test;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;



public class Createshopper {
	@Test
	public void create() throws JsonProcessingException
	{

		CreateshopperPojo rcb=new CreateshopperPojo();
		rcb.setCity("Bangalore");
		rcb.setCountry("India");
		rcb.setEmail("ab13223@gmail.com");
		rcb.setFirstName("virat");
		rcb.setGender("FEMALE");
		rcb.setLastName("kohli");
		rcb.setPassword("rcb@1817");
		rcb.setPhone("7654345678");
		rcb.setState("karnataka");
		rcb.setZoneId("ALPHA");
		

		ObjectMapper obj= new ObjectMapper();
		String jsonbody = obj.writerWithDefaultPrettyPrinter().writeValueAsString(rcb);
		System.out.println(jsonbody);
		
		
		
		RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body(jsonbody).contentType("application/json").when().
		post("/shoppers").then().statusCode(201).log().all();
		
			
			
			
			
			
			
			
			
		}
			
			
}
