package MyLocalAPI;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.DataProviderWithExcel;
import Util.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_POST_Method {
	
	
	//@Test
	public void PostDetails()
	{
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject object=new JSONObject();
		object.put("author","Charles");
		object.put("title","Computer");
		//Before posting we call header format
		httpRequest.header("Content-Type","application/json");
		//Covert to JSON string format
		httpRequest.body(object.toJSONString());
		//Here applying actual post
		Response resp=httpRequest.request(Method.POST,"/posts");
		
		//Get response body.
		String responseBody=resp.getBody().asString();
		System.out.println(responseBody);
		
		//Verification part has done here.
		Assert.assertEquals(responseBody.contains("Charles"), true);
		Assert.assertEquals(responseBody.contains("Computer"), true);
		int status=resp.getStatusCode();
		Assert.assertEquals(resp.getStatusCode(), 201);
		
	}
//@DataProvider(name="bookData")
public String[][] bookData()
{
	String data[][]={{"Johnson","Health Care" },{"Gandhi","Humanity"},{"Valmiki","Ramayana"}};
	return data;
}
@Test(dataProvider="excelData")
public void getDataFromProvider(String author,String title)
{
	RestAssured.baseURI="http://localhost:3000";
	RequestSpecification httpRequest=RestAssured.given();
	JSONObject object=new JSONObject();
	object.put("author", author);
	object.put("title", title);
	httpRequest.header("Content-Type","application/json");
	httpRequest.body(object.toJSONString());
	
	Response resp=httpRequest.request(Method.POST,"/posts");
	String result=resp.getBody().asString();
	System.out.println(result);
	
	//Verification point
	int status=resp.getStatusCode();
	System.out.println(status);
	Assert.assertEquals(result.contains(author), true);
	Assert.assertEquals(result.contains(title), true);
}
@DataProvider(name="excelData")
Object[][] getEmpData()
{
	 String path="./data/TestData.xlsx";
	 String sheet="sheet1";
	 
	 DataProviderWithExcel excel=new  DataProviderWithExcel();
	 Object[][] empData=excel.getExcelData(path, sheet);
	return empData;
}
}
