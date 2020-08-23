package SdetAPITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	@Test
	void getUserDetails()
	{
		//API URI
		RestAssured.baseURI="https://reqres.in/api/users";
		//Create a request
		RequestSpecification httpRequest=RestAssured.given();
		//Create a response
		Response response=httpRequest.request(Method.GET,"/3");
		//Response body
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		//Status code verification
		int status=response.getStatusCode();
		System.out.println(status);
		Assert.assertEquals(status, 200);
		//StatusLine verification
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}

}
