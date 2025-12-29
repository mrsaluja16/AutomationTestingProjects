package DELETECallWithBDD;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUserAndDeleteUserAndVerifyUserDeleted {
	
	public String getRandomEmail() {
		return "apiAutomation"+System.currentTimeMillis()+"@RJLearning.com";
	}
	
	@Test
	public void createUserThenDeleteItTest() {
	
		baseURI = "https://gorest.co.in";
		String token = "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd";
		
		UserPojoLombokNoIdForDeleteCall userD = new UserPojoLombokNoIdForDeleteCall.UserPojoLombokNoIdForDeleteCallBuilder()
				.name("Halina Desu")
				.email(getRandomEmail())
				.gender("female")
				.status("active")
				.build();
		
//	1. Create user using POST call
	
		Integer userID = given()
			.contentType(ContentType.JSON)
			.header("Authorization", token)
			.body(userD)
		.when()
			.post("/public/v2/users")
		.then()
			.assertThat()
			.statusCode(201)
			.and()
			.extract()
			.path("id");
		
		System.out.println("User is created");
		System.out.println("user id is: "+userID);
				
//	2. Check user is created using GET call
		
		given()
			.contentType(ContentType.JSON)
			.header("Authorization", token)
		.when()
			.get("/public/v2/users/"+userID)
		.then()
			.body("id", equalTo(userID));
		
		System.out.println("User is fetched");
		
//	3. Delete user 
		
		given()
			.contentType(ContentType.JSON)
			.header("Authorization", token)
		.when()
			.delete("/public/v2/users/"+userID)
		.then()
			.assertThat()
			.statusCode(204);
		
		System.out.println("User is deleted");
		
//	4. Check user is deleted using GET call

		given()
			.contentType(ContentType.JSON)
			.header("Authorization", token)
		.when()
			.get("/public/v2/users/"+userID)
		.then()
			.assertThat()
			.statusCode(404)
			.and()
			.body("message", equalTo("Resource not found"));
		
		System.out.println("User is fetched but not found");
	}
}
