package pofspecbuilder;

import org.hamcrest.Matchers;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specbuilder {
@BeforeMethod
public RequestSpecification requestt(String url,String body,String content) {
	RequestSpecBuilder res=new RequestSpecBuilder();
	
	RequestSpecification req=res.setBaseUri(url)
			.setBody(body)
			.setContentType(content)
			.build();
	return req;
}
@AfterMethod
public ResponseSpecification response(int code,String key,String value,String line,String content,long time) {
	ResponseSpecBuilder rsb=new ResponseSpecBuilder();
	ResponseSpecification re = rsb.expectStatusCode(code).expectBody(key,Matchers.equalTo(value))
			.expectStatusLine(line)
			.expectContentType(content)
			.expectResponseTime(Matchers.lessThanOrEqualTo(time))
			.build();
	
	
	return re;
}






}
