package WebServices;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test001_GET {
	@Test
	void testGet()
	{
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		
		int status=response.getStatusCode();
		Assert.assertEquals(status, 200);
		
		
	}

}
