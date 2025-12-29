package PUTCallWithBDD;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class UpdateUserTest {
	
	public String getRandomEmail() {
		return "apiAutomation"+System.currentTimeMillis()+"@RJLearning.com";
	}

	@Test
	public void createUserThenUpdateUserTest() {
		baseURI = "https://gorest.co.in";
		
//		1. POST		
		System.out.println(">>>>>>>>>>>>>>>Create User");
		
		String token = "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd";
		
		UserPojoLombokNoId userP = new UserPojoLombokNoId.UserPojoLombokNoIdBuilder()
				.name("Keith Humes")
				.email(getRandomEmail())
				.gender("male")
				.status("active")
				.build();
		
		Integer userID = given()
			.contentType(ContentType.JSON)
			.header("Authorization", token)
			.body(userP)
		.when()
			.post("/public/v2/users")
		.then()
			.assertThat()
			.statusCode(201)
			.extract()
			.path("id");
			
		System.out.println("Newly created user id is: "+userID);
		
//		2. GET User to verify		
		System.out.println(">>>>>>>>>>>>>>>GET User");
		given()
			.contentType(ContentType.JSON)
			.header("Authorization", token)
		.when()
			.get("/public/v2/users/"+userID)
		.then()
			.and()
			.body("id", equalTo(userID));
		
//		3. PUT call to update the user name
		System.out.println(">>>>>>>>>>>>>>>Update User");
		userP.setName("Dune Jonas");
		userP.setStatus("inactive");
		
		given()
			.contentType(ContentType.JSON)
			.header("Authorization", token)
			.body(userP)
		.when()
			.put("/public/v2/users/"+userID)
		.then()
			.assertThat()
			.statusCode(200)
			.body("id", equalTo(userID))
			.and()
			.body("name", equalTo(userP.getName()))
			.and()
			.body("status", equalTo(userP.getStatus()));
		
//		4. Get user to verify
		System.out.println(">>>>>>>>>>>>>>>GET User");
		given()
			.contentType(ContentType.JSON)
			.header("Authorization", token)
		.when()
			.get("/public/v2/users/"+userID)
		.then()
			.and()
			.body("id", equalTo(userID))
			.and()
			.body("name", equalTo(userP.getName()))
			.and()
			.body("status", equalTo(userP.getStatus()));
	}
	
}
