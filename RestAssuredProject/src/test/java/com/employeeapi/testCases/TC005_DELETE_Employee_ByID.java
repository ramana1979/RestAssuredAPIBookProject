package com.employeeapi.testCases;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_DELETE_Employee_ByID extends TestBase{
	
	@BeforeClass
	void getDeleteEmployeeByID() throws InterruptedException
	{
		logger.info("*****************TC005 Delete employee By ID Started***********");
		RestAssured.baseURI="http://localhost:3000";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/posts");
		
		//Now create a instance of JsonPath form response interface
		JsonPath eval=response.jsonPath();
		int empid=eval.get("[0].id");
		response=httpRequest.request(Method.DELETE,"/posts/"+id);
		Thread.sleep(3000);
	}
	@Test
	void checkResponseBody()
	{
		logger.info("************Check the response body ***********************");
		String responseBody=response.getBody().asString();
		Assert.assertTrue(responseBody!=null);
	}
	@Test
	void checkStatusCode()
	{
		logger.info("**********************Check the status code *********************");
		int status=response.getStatusCode();
		logger.info("Status Code is "+status);
		Assert.assertEquals(status, 200);
	}
	@Test
	void checkStatusLine()
	{
		logger.info("*******************Check the status Line**************************");
		String statusLine=response.getStatusLine();
		logger.info("Status Line "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	@Test
	void checkContentType()
	{
		logger.info("*******************Check content type of header part***************");
		String contentType=response.header("Content-Type");
		logger.info("Content Type "+contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
	@Test
	void checkContentLength()
	{
		logger.info("*************************Check content length of header part**************");
		String contentLength=response.header("Content-Length");
		logger.info("Content length "+contentLength);
	}
	@Test
	void getResponseTime()
	{
		logger.info("******************Check the response time************************");
		long responseTime=response.getTime();
		logger.info("Response Time "+responseTime);
		if(responseTime>2000)
			logger.warn("Response time is greater than 2000");
		Assert.assertTrue(responseTime<2000);
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("***************TC005-Delete-Employyes By ID is Finish********************");
	}

}
