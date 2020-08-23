package SdetAPITest;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC001_POST_Request {
	@Test
	void registrationSuccessful()
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject object=new JSONObject();
		
		object.put("name", "morpheus");
		object.put("job", "leader");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(object.toJSONString());
		
		Response reponse=httpRequest.request(Method.POST,"/api/users");
		String reponseBody=reponse.getBody().asString();
		System.out.println(reponseBody);
		int status=reponse.getStatusCode();
		System.out.println(status);
		Assert.assertEquals(status, 201);
		String statusLine=reponse.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		String code=reponse.jsonPath().get("SuccessCode");
		System.out.println(code);
		
		
	}

}
