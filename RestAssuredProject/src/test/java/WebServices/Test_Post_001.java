package WebServices;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class Test_Post_001 {
	@Test
	public void simplePost()
	{
		Map<String, Object> object=new HashMap<String,Object>();
		object.put("Ramana", "Software");
		object.put("Pawan", "Army");
		object.put("Kiran", "Student");
		object.put("Prasd", "Student");
		object.put("Haritha", "Student");
		System.out.println(object);
		JSONObject request=new JSONObject(object);
		System.out.println(request);
		System.out.println(request.toJSONString());
	}
	@Test
	public void simplePostMethod()
	{
		//without MAP interface use only the JSONObject with put method.
		JSONObject object=new JSONObject();
		object.put("Ramana", "Software");
		object.put("Kasula", "Software");
		System.out.println(object);
		System.out.println(object.toJSONString());
		given()
		.headers("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(object.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201).log().all();
	}
	@Test
	public void simple_Put_Method()
	{
		JSONObject object=new JSONObject();
		object.put("Prasad", "Student");
		object.put("Kiran", "Student");
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(object.toJSONString())
		.when()
		.put("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test
	public void simple_Delete_Method()
	{
		when()
		.delete("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(204)
		.log().all();
	}
}
