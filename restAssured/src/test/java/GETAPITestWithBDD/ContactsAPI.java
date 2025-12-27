package GETAPITestWithBDD;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class ContactsAPI {
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
	}
	
	@Test(enabled=false)
	public void getAllContactsAPITest() {
		
		
		
		given()
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OTI1ZDQ5MTI1MzBlYzAwMTU3MGFiOTMiLCJpYXQiOjE3NjY2NjA5Njh9.-k0zwXdQTB7nJ0b4Zuiq2z6YKr8B1jH5ljIcqKQMFQQ")
					.when()
						.get("/contacts")
							.then()
								.assertThat()
									.statusCode(200).and().contentType(ContentType.JSON).log().body(DEFAULT_URL_ENCODING_ENABLED);
	}
	
	@Test(enabled=false)
	public void negativeTestForContactsAPIAuthorizationTest() {
		
		
		given()
				.header("Authorization", "Bearer Ranjit")
					.when()
						.get("/contacts")
							.then().log().all()
								.assertThat()
									.statusCode(401);
	}
	
	@Test
	public void negativeTestForContactsAPIAuthorizationValidatingBodyTest() {
		
		
		String errorMessage = given()
				.header("Authorization", "Bearer Ranjit")
					.when()
						.get("/contacts")
							.then()
								.extract()
									.path("error");
		System.out.println("Error Merssage: "+errorMessage);
		Assert.assertEquals(errorMessage, "Please authenticate.");
	}

}
