package createadminpojo;

import org.testng.annotations.Test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Createadminn {
	
	
@Test
public void create() throws JsonProcessingException {
	
	Createadmin ct=new Createadmin();
	ct.setCity("bengalore");
	ct.setCountry("India");
	ct.setEmail("rupali12@gmail.com");
	ct.setFirstName("rupali");
	ct.setGender("FEMALE");
	ct.setLastName("das");
	ct.setPassword("rupali$12AC");
	ct.setPhone("6543456789");
	ct.setRole("ADMIN");
	ct.setState("karnataka");

	
ObjectMapper obj=new ObjectMapper();
String jsonbody =obj.writerWithDefaultPrettyPrinter().writeValueAsString(ct);
System.out.println(jsonbody);

RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body(jsonbody).contentType("application/json").when().post("/admin")
.then().statusCode(201).log().all();


}
}
