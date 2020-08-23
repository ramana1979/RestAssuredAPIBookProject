package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.Utilities.RestUtils;
import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC003_POST_Add_Details extends TestBase {
	String author=RestUtils.authorName();
	String title=RestUtils.titleBook();
	@BeforeClass
	void postDetails() throws InterruptedException
	{
		logger.info("******************TC002_POST Add details started*****************");
		RestAssured.baseURI="http://localhost:3000";
		httpRequest=RestAssured.given();
		JSONObject object=new JSONObject();
		object.put("author", author);
		object.put("title", title);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(object.toJSONString());
		response=httpRequest.request(Method.POST,"/posts");
		Thread.sleep(3000);	
	}
	@Test
	void checkResponseBody()
	{
		logger.info("*****************Check the response Body ***************************");
		String responseBody=response.getBody().asString();
		logger.info("Response JSON string "+responseBody);
		Assert.assertEquals(responseBody.contains(author),true);
		Assert.assertEquals(responseBody.contains(title),true);
	}
	@Test
	void checkStatusCode()
	{
		logger.info("*******************Check status code of recoed as 201****************");
		int status=response.getStatusCode();
		logger.info("The Status code "+status);
		Assert.assertEquals(status, 201);
	}
	@Test
	void checkStatusLine()
	{
		logger.info("******************Check the status line *************************");
		String statusLine=response.getStatusLine();
		logger.info("Status Line "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
	}
	@Test
	void checkContentType()
	{
		logger.info("************************Check the content type *******************");
		String contenType=response.header("Content-Type");
		logger.info("Content Type "+contenType);
		Assert.assertEquals(contenType, "application/json; charset=utf-8");
	}
	@Test
	void checkResponseTime()
	{
		logger.info("************************Check the response time *********************");
		long responseTime=response.getTime();
		if(responseTime>2000)
			logger.warn("Response time is greater than 2000");
		Assert.assertTrue(responseTime<2000);
	}
	@Test
	void checkContentLength()
	{
		logger.info("************************Check the Content length *********************");
		String contentLength=response.header("Content-Length");
		logger.info("Content length "+contentLength);
		if(Integer.parseInt(contentLength)>100)
			logger.warn("Content length is less than 100");
		Assert.assertTrue(Integer.parseInt(contentLength)<100);
	}
	/*@Test
	void getResponseLocation()
	{
		logger.info("********************Check Response location *********************");
		String responseLocation=response.header("Location");
		Assert.assertEquals(responseLocation, "http://localhost:3000/posts/23");
	}*/
	@AfterClass
	void tearDown()
	{
		logger.info("*********************TC003 Post Add details finished.**********************");
	}


}
