package GETAPITestWithBDD;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.object.HasEqualValues;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetUserWithQueryParam {
	
	@BeforeTest
	public void setUp() {
		baseURI = "https://gorest.co.in";
	}
	
	@Test(enabled = false)
	public void getSingleUserUsingNameAndStatusTest() {
		
		given().log().all()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.queryParam("name", "naveen")
			.queryParam("status", "active")
			.when()
			.get("/public/v2/users")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.and()
			.contentType(ContentType.JSON);
			
		
	}
	
	@Test
	public void getSingleUserUsingHashMapTest() {
		
		Map<String, String> userQueryMap = new HashMap<String, String>();
		userQueryMap.put("name", "naveen");
		userQueryMap.put("status","active");
		userQueryMap.put("gender","male");
		
		given().log().all()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.queryParams(userQueryMap)
			.when()
			.get("/public/v2/users")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.and()
			.contentType(ContentType.JSON);
			
		
	}

}
