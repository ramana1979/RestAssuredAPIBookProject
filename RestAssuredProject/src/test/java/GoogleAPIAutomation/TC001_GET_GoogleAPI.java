package GoogleAPIAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET_GoogleAPI {
	@Test
	public void GetLocationDetails()
	{
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET, "/posts");
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		int status=response.getStatusCode();
		System.out.println(status);
		Assert.assertEquals(status, 200);
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		/*String content=response.getContentType();
		System.out.println(content);
		Assert.assertEquals(content, "application/json; charset=utf-8");
		*/
		String content=response.header("Content-Type");
		System.out.println(content);
		Assert.assertEquals(content, "application/json; charset=utf-8");
		
		String clen=response.header("content-length");
		System.out.println(clen);
		Assert.assertEquals(clen, "655");
	}
	@Test
	public void getHeader()
	{
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET, "/posts");
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		Headers allHeader=response.headers();
		for(Header header:allHeader)
		{
			System.out.println(header.getName()+"\t"+header.getValue());
		}
	}

}
