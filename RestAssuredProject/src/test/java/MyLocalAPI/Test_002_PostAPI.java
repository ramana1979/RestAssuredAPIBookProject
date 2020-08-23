package MyLocalAPI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_002_PostAPI {
	/*@Test
	public void PostDetails()
	{
		JSONObject object=new JSONObject();
		object.put("title", "API");
		object.put("author", "Ramana");
		object.put("title", "Automation");
		object.put("author", "Venkat");
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(object.toJSONString())
		.when()
		.post("http://localhost:3000/posts")
		.then()
		.statusCode(201)
		.log().all();
	}*/
	@Test
	public void searchByID()
	{
		System.out.println("Searching by the title");
		baseURI="http://localhost:3000/";
		given()
		.param("title", "API")
		.get("/posts")
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	@Test
	public void serachByTitle()
	{
		System.out.println("Searching by Title");
		baseURI="http://localhost:3000/";
		given()
		.param("title", "Automation")
		.get("/posts")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	

}
