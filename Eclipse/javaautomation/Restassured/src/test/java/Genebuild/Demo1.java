package Genebuild;

import org.apache.commons.lang3.RandomStringUtils;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Demo1 {
@BeforeMethod

public RequestSpecification request() {
	String random=RandomStringUtils.randomAlphanumeric(5);
	String remail= random+ "@gmail.com";
	RequestSpecBuilder res=new RequestSpecBuilder();
	RequestSpecification req = res.setBaseUri("https://www.shoppersstack.com/shopping")
			.setBody("{\r\n"
					+ "  \"city\": \"Bengalore\",\r\n"
					+ "  \"country\": \"India\",\r\n"
					+ "  \"email\": \""+remail+"\",\r\n"
					+ "  \"firstName\": \"rupali\",\r\n"
					+ "  \"gender\": \"FEMALE\",\r\n"
					+ "  \"lastName\": \"Das\",\r\n"
					+ "  \"password\": \"rupali12A43$\",\r\n"
					+ "  \"phone\": 7654567896,\r\n"
					+ "  \"state\": \"odisha\",\r\n"
					+ "  \"zoneId\": \"ALPHA\"\r\n"
					+ "}").setContentType("application/json").build();
	return req;
}
@AfterMethod
public ResponseSpecBuilder response() {
	ResponseSpecBuilder resq =new ResponseSpecBuilder();
	resq.expectStatusCode(201).expectBody("message",Matchers.equalTo("Created")).expectStatusLine("HTTP/1.1 201")
	.expectContentType("application/json").expectResponseTime(Matchers.lessThanOrEqualTo(60001)).build();
	return resq;

}


















}
