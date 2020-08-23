package com.employeeapi.testCases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
//import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import io.restassured.response.ResponseBody;

public class TC001_Get_All_Employees extends TestBase {
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		logger.info("*************Started TC_001 get all employees Started ***************");
		RestAssured.baseURI="http://localhost:3000";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/posts");
		Thread.sleep(3); 
	}
	@Test
	void checkResponseBody()
	{
		logger.info("****************Check the response body**************");
		String responseBody=response.getBody().asString();
		logger.info("Response body "+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	@Test
	void checkStatusCode()
	{
		logger.info("*****************Check Status Code*****************");
		int status=response.getStatusCode();
		logger.info("Status "+status);
		Assert.assertEquals(status, 200);
	}
	//@Test
	void checkResponseTime()
	{
		logger.info("*****************Check Response Time***********************");
		long responseTime=response.getTime();
		logger.info("Response Time "+responseTime);
		if(responseTime>2000)
			logger.warn("Response time is greate than 2000");
		Assert.assertTrue(responseTime<2000);
	}
	@Test
	void checkStatusLine()
	{
		logger.info("*******************Check the status line of body");
		String statusLine=response.getStatusLine();
		logger.info("Status Line "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	/*@Test
	void checkContentType()
	{
		logger.info("*******************Check the Content-Type body");
		String content_type=response.header("Content-Type");
		logger.info("Content Type "+content_type);
		Assert.assertEquals(content_type, "application/json; charset=utf-8");
	}*/
	@Test
	void checkServerType()
	{
		logger.info("*******************Check the Server *************************");
		String server=response.header("Server");
		logger.info("Server name "+server);
		Assert.assertEquals(server, null);
	}
	@Test
	void checkContentEncoding()
	{
		logger.info("*******************Check the Content-Type Encoding*************");
		String contentEncoding=response.header("Content-Encoding");
		logger.info("Content Encoding "+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}
	//@Test
	void checkContentLength()
	{
		logger.info("*******************Check the Content Length*******************");
		String contentLength=response.header("Content-Length");
		logger.info("Content Length "+contentLength);
		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content length is less than 100");
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
	}
	@Test
	void checkCookies()
	{
		logger.info("***************Check cookies***************");
		String cookie=response.getCookie("PHPSESSID");
		logger.info("Cookie name "+cookie);
	}
	@AfterClass
	void tearDown()
	{
		logger.info("******************Finish TC001_Get_All_Employees********************");
	}
}
