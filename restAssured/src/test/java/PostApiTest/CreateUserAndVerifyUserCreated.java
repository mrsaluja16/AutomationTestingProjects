package PostApiTest;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUserAndVerifyUserCreated {
	
//	1. Post - Create a user -- get userID
//	2. Get - Get a user -- check user with user id from above and check if the get call retrun 200 OK
	
	public String getRandomEmailId() {
		return "apiautomation"+System.currentTimeMillis()+"@RJLearning.com";
	}
	
	@Test
	public void createUserWithJsonEmailReplacedTest() throws Exception {
		
		String randomEmail = getRandomEmailId();
		
		String json = new String(Files.readAllBytes(Paths.get("./src/test/resources/jsons/userData.json")));
		String editedJson = json.replace("{{email}}", randomEmail);
		
		System.out.println("Edited json value is: "+editedJson);
		
		baseURI = "https://gorest.co.in";		
		
		//1. Create a user and get user id
		Integer userId = given()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.contentType(ContentType.JSON)
			.body(editedJson)
		.when()
			.post("/public/v2/users")
		.then().log().all()
			.assertThat()
			.statusCode(201)
			.and()
			.extract()
			.path("id");
		System.out.println("User id is: "+userId);
		
		System.out.println("----------------------------------------");
		
		given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
		.when()
			.get("/public/v2/users/"+userId)
		.then().log().all()
			.assertThat()
			.statusCode(200)
			.and()
			.body("id", equalTo(userId));
			
	}

}
