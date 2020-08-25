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
	
	/**
	 * Creata a request and response for API http://localhost:3000/posts/ and wiat for 3 seconds.
	 * @throws InterruptedException
	 */
	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		logger.info("*************Started TC_001 get all employees Started ***************");
		RestAssured.baseURI="http://localhost:3000";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/posts");
		Thread.sleep(3); 
	}
	/**
	 * After sending request get response. Response body will be checking here. 
	 */
	@Test
	void checkResponseBody()
	{
		logger.info("****************Check the response body**************");
		String responseBody=response.getBody().asString();
		logger.info("Response body "+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	/**
	 * After successful we get success code 200. Verifying code here.
	 */
	@Test
	void checkStatusCode()
	{
		logger.info("*****************Check Status Code*****************");
		int status=response.getStatusCode();
		logger.info("Status "+status);
		Assert.assertEquals(status, 200);
	}
	/**
	 * check and verifying response time. >2000 mil.seconds send warning msg.
	 */
	@Test
	void checkResponseTime()
	{
		logger.info("*****************Check Response Time***********************");
		long responseTime=response.getTime();
		logger.info("Response Time "+responseTime);
		if(responseTime>2000)
			logger.warn("Response time is greate than 2000");
		Assert.assertTrue(responseTime<2000);
	}
	/**
	 * Verifying status line will be like OK,Created,Updated etc.
	 */
	@Test
	void checkStatusLine()
	{
		logger.info("*******************Check the status line of body");
		String statusLine=response.getStatusLine();
		logger.info("Status Line "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	/**
	 * Verifying content length
	 */
	@Test
	void checkContentType()
	{
		logger.info("*******************Check the Content-Type body");
		String content_type=response.header("Content-Type");
		logger.info("Content Type "+content_type);
		Assert.assertEquals(content_type, "application/json; charset=utf-8");
	}
	//Verifying server name of API
	@Test
	void checkServerType()
	{
		logger.info("*******************Check the Server *************************");
		String server=response.header("Server");
		logger.info("Server name "+server);
		Assert.assertEquals(server, null);
	}
	//Verifying content encoding for GET method as gzip
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
	//Verifying the cookie if we have.
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
