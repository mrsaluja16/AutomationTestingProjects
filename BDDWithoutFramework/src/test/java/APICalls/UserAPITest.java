package APICalls;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UserPOJO.LoginLombokPOJO;
import UserPOJO.UserLombokPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

public class UserAPITest {
	
	String token = null;
	String userId = null;
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
	}
	
	public String randomEmail() {
		return "apiautomation"+System.currentTimeMillis()+"@rj.com";
	}
	
	public String randomPassword() {
		return "pass123";
	}
	
	@BeforeMethod
	public void generateToken() {
		LoginLombokPOJO login = new LoginLombokPOJO("mrsaluja16@gmail.com", "Singh@1608");
		token = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(login)
			.when()
				.post("/users/login")
			.then().log().all()
				.statusCode(200).and()
				.extract().path("token");
		System.out.println("Token is: "+token);
	}
	
	public void createUser() {
		
		UserLombokPojo user = new UserLombokPojo("RJFreddy", "RJSharma", randomEmail(), randomPassword());
		
		userId = RestAssured.given()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer "+token)
				.body(user)
			.when()
				.post("/users")
			.then().log().all()
				.assertThat().statusCode(201)
				.and().extract().path("_id");
	}
	
	@Test
	public void getUserProfileTest() {
		RestAssured.given()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer "+token)
			.when()
				.get("/users/me")
			.then()
				.statusCode(200)
				.and().body("firstName", Matchers.equalTo("Ranjeet"));
	}
	
	@Test
	public void createUserTest() {
		createUser();
		System.out.println("New user created whose id is: "+userId);
		Assert.assertNotNull(userId);
	}
	
	@Test
	public void updateUserTest() {
		createUser();
		System.out.println("New user created whose id is: "+userId);
		UserLombokPojo user = new UserLombokPojo("RJGabriel", "RJSharma", randomEmail(), randomPassword());
		RestAssured.given()
				.contentType(ContentType.JSON)
				.header("Authorization" , "Bearer "+token)
				.body(user)
			.when()
				.patch("/users/me")
			.then().log().all()
				.statusCode(200)
				.and()
				.body("firstName", Matchers.equalTo("RJGabriel"));
	}
}
