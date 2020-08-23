package MyLocalAPI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_DataDriven_PostMethod {
	@DataProvider(name="DataForPost")
	public Object[][] dataForPost()
	{
		/*Object[][] data=new Object[2][2];
		data[0][0]="DWH Testing";
		data[0][1]="RamanaETL";
		
		data[1][0]="Oracle";
		data[1][1]="KasulaDBA";
		
		return data;*/
		//OR we can use like below.
		return new Object[][]
				{
					{"Tocat Server","Dob Bosco"},
					{"Facebook","Jokowiz"}
				};
	}
	@Test(dataProvider="DataForPost")
	public void test_post(String title,String author )
	{
		JSONObject object = new JSONObject();
		object.put("title",title);
		object.put("author", author);
		baseURI="http://localhost:3000/";
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("Content-Type","application/json")
		.body(object.toJSONString())
		.when().post("/posts")
		.then()
		.statusCode(201)
		.log().all();
	}

}
