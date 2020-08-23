package MyLocalAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Verify_GET_Result {
	//@Test
	public void verifyStringFromJSONBody()
	{
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET, "/posts/5");
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains("DevOps"),true);
		Assert.assertEquals(responseBody.contains("KasulaDBA"), true);
	}
	//This test case validate all the values from response body.
	@Test
	public void validateJSONStringValues()
	{
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/posts/5");
		String sBody=response.getBody().asString();
		JsonPath path=response.jsonPath();
		System.out.println(path.get("author"));
		System.out.println(path.get("title"));
		System.out.println(path.get("id"));
		Assert.assertEquals(path.get("title"), "DevOps");
	}

}
