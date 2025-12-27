package GETAPITestWithBDD;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetUserPostWithPathParam {
	
	
	
	@DataProvider
	public Object[][] getUserData() {
		return new Object[][] {
			{7681898, "Adsidue conqueror sto aut absconditus verbera."},
			{7681900, "Angustus sit incidunt demulceo vitiosus adimpleo."},
			{7681902, "Canonicus voluptatem iure dignissimos facere ager."}
		};
	}
	
	//@Test(dataProvider="getUserData")
	public void getUserWithPathParamTest(int userId, String title) {
		baseURI = "https://gorest.co.in";
		given()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.pathParam("userId", userId)
				.when()
					.get("/public/v2/users/{userId}/posts")
					.then().log().body()
					.assertThat()
					.statusCode(200)
					.and()
					.body("title", hasItem(title));
	}
	
	@Test
	public void getUserWithPathParamUsingHashMapTest() {
		baseURI = "https://reqres.in";
		
		Map<String, String> pathParamMap = new HashMap<String, String>();
		pathParamMap.put("firstPath", "api");
		pathParamMap.put("secondPath", "register");
		
		given()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.pathParams(pathParamMap)
			.queryParam("id", 1)
				.when()
					.get("/{firstPath}/{secondPath}")
					.then().log().body()
					.assertThat()
					.statusCode(200);
	}

}
