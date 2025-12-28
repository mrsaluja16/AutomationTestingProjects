package CreateUserWithPOJOAndLombok;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUserWithLombokTest {
	
	public String randomEmail() {
		return "apiautomation"+System.currentTimeMillis()+"@RJLearning.com";
	}
	
	@Test
	public void createUsertest() {
		baseURI = "https://gorest.co.in";
		
		UserPOJOLombok userL = new UserPOJOLombok("Kajal", randomEmail(), "female", "active");
		
		Integer userID = given()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
				.body(userL)
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
	
	@Test
	public void createUserWithLombokBuilderTest() {
		baseURI = "https://gorest.co.in";
		
		//Builder pattern using Lombok
		UserPOJOLombok userBuilder =  new UserPOJOLombok.UserPOJOLombokBuilder()
			.name("Jerry")
			.email(randomEmail())
			.status("active")
			.gender("male")
			.build();
		
		System.out.println("------------------>>>>>>>>>>>>>>>>>>>>"+userBuilder);
		
		Integer userID = given()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
				.body(userBuilder)
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
