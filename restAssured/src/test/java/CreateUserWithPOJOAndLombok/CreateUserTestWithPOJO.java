package CreateUserWithPOJOAndLombok;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUserTestWithPOJO {
	
	public String randomEmail() {
		return "apiautomation"+System.currentTimeMillis()+"@RJLearning.com";
	}
	
	@Test
	public void createUsertest() {
		baseURI = "https://gorest.co.in";
		
		UserPOJO user = new UserPOJO("Tom", randomEmail(), "male", "active");
		
		Integer userID = given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.body(user)
		.when()
			.post("/public/v2/users")
		.then().log().all()
			.statusCode(201)
			.extract()
			.path("id");
		
		System.out.println("---------------------------------------------------------------------------------");
		
		given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
		.when()
			.get("/public/v2/users/"+userID)
		.then().log().all()
			.assertThat()
			.statusCode(200)
			.and()
			.body("id", Matchers.equalTo(userID));
	}

}
