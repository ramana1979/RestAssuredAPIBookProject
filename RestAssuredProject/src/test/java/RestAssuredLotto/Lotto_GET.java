package RestAssuredLotto;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Lotto_GET {
	@Test
	public void getMethod()
	{
		baseURI="http://localhost:3000/";
		given()
		.get("/lotto").then().body("winners.winnerId", hasItems(23,54))
		.log().all();
		
	}
}
