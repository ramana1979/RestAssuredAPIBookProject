package MyLocalAPI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_001_PatchMethod {
	@Test
	public void PatchMethod()
	{
		JSONObject object=new JSONObject();
		object.put("author", "KasulaDBA");
		
		baseURI="http://localhost:3000/";
		given()
		.header("Content-type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(object.toJSONString())
		.when()
		.patch("/posts/5")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
