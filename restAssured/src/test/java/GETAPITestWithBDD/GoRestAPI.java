package GETAPITestWithBDD;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;;

public class GoRestAPI {
	
	@BeforeTest
	public void setUp() {
		baseURI = "https://gorest.co.in";
	}
	
	@Test(enabled=false)
	public void getSingleUserTest() {
		Response res = given()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
				.when()
					.get("/public/v2/users/7681898");
		
		System.out.println("Status code: "+res.statusCode());
		System.out.println("Status line: "+res.statusLine());
		
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertTrue(res.statusLine().contains("200 OK"));
		
		res.prettyPrint();
	}
	
	@Test(enabled=false)
	public void getSingleUserValidateBodyTest() {
		Response res = given()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
				.when()
					.get("/public/v2/users/7681898");
		
		res.prettyPrint();
		
		JsonPath js = res.jsonPath();
		int userId = js.getInt("id");
		System.out.println("User id: "+userId);
		Assert.assertEquals(userId, 7681898);
		
		String name = js.getString("name");
		System.out.println("Name is: "+name);
		Assert.assertEquals(name, "Gov. Dhanesh Dubashi");
		
		String status = js.getString("status");
		System.out.println("Status is: "+status);
		Assert.assertEquals(status, "active");
	}
	
	@Test
	public void getAllUsersValidatingDataTest() {
		Response res = given()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
				.when()
					.get("/public/v2/users");
		
		//res.prettyPrint();
		System.out.println("Status code: "+res.statusCode());
		System.out.println("Status line: "+res.statusLine());
		
		JsonPath js = res.jsonPath();
		List<Integer> idList = js.getList("id");
		System.out.println("Id's are: "+idList);
		
		List<String> nameList = js.getList("name");
		System.out.println("Names are: "+nameList);
		
		
	}

}
