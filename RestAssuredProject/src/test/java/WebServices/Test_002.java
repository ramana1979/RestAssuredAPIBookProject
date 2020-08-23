package WebServices;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_002 {
	@Test
	public void simpleTest()
	{
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();	
	}
	@Test
	public void verifyBodyById()
	{
		given().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8))
		.body("data.first_name", hasItems("Tobias","Byron","George"));
	
	}

}
