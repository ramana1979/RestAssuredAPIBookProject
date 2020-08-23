package MyLocalAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test_001_GetAPI {
	//@Test
	public void GetDetails()
	{
		JSONObject object=new JSONObject();
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(object.toJSONString())
		.when()
		.get("http://localhost:3000/posts")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	@Test
	public void GetParams()
	{
		JSONObject object=new JSONObject();
		baseURI="http://localhost:3000/";
		given()
		//.param("author", "Dob Bosco")
		.param("title", "SQL")
		.get("/posts")
		.then()
		.statusCode(200)
		.log()
		.all();
		
	}
	
	

}
