package MyLocalAPI;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_001_DeleteMethod {
	/*@Test
	public void DeleteMethod()
	{
		baseURI="http://localhost:3000/";
	given()
	.delete("/posts/4")
	.then()
	.statusCode(200)
	.log().all();
	}*/
	
	/*@DataProvider(name="deleteForId")
	public Object[] dataForDelete()
	{
		return new Object[]
				{
					1,2,12
				};
	}
	@Test(dataProvider="deleteForId")
	public void DeteleByID(int d)
	{
		baseURI="http://localhost:3000";
		given()
		.delete("/posts/" +d)
		.then()
		.statusCode(200)
		.log()
		.all();
	}*/
	@Parameters({"userId"})
	@Test
	public void DeleteByID(int d)
	{
		baseURI="http://localhost:3000";
		given()
		.delete("/posts/" +d)
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	
}
