package pofspecbuilder;

import org.apache.commons.lang3.RandomStringUtils;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Scriptt {
@BeforeMethod
public RequestSpecification request() {
	String random= RandomStringUtils.randomAlphanumeric(4);
	String randomemail= random+"@gmail.com";
	
	RequestSpecBuilder res =new RequestSpecBuilder();
	RequestSpecification reqs = res.setBaseUri("https://www.shoppersstack.com/shopping").setBody("{\r\n"
			+ "  \"city\": \"Bengaluru\",\r\n"
			+ "  \"country\": \"India\",\r\n"
			+ "  \"email\": \""+randomemail+"\",\r\n"
			+ "  \"firstName\": \"rupali  \",\r\n"
			+ "  \"gender\": \"FEMALE\",\r\n"
			+ "  \"lastName\": \"das\",\r\n"
			+ "  \"password\": \"rupaD12$12\",\r\n"
			+ "  \"phone\": 7654567543,\r\n"
			+ "  \"state\": \"odisha\",\r\n"
			+ "  \"zoneId\": \"ALPHA\"\r\n"
			+ "}").setContentType("application/json").build();
	return reqs;
}
@AfterMethod
public ResponseSpecification response() {
	ResponseSpecBuilder rsb=new ResponseSpecBuilder();
	 ResponseSpecification res = rsb.expectStatusCode(201).expectBody("message",Matchers.equalTo("Created")).expectStatusLine("HTTP/1.1 201 ")
			.expectContentType("application/json").expectResponseTime(Matchers.lessThanOrEqualTo(6000l)).build();
	return res;
	
	
	
	
	
}
}
