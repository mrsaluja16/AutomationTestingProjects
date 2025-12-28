package CreateContactUsingLombokPojo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createContactAfterLoginTest {
	
	public String getRandomEmail() {
		return "apiAutomation"+System.currentTimeMillis()+"@RJLearning.com";
	}
	
	@Test
	public void createContactAfterLoginUsingPostRequestTest() {
		
		baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		ContactLoginPojoLombok login = new ContactLoginPojoLombok.ContactLoginPojoLombokBuilder()
				.email("mrsaluja16@gmail.com")
				.password("Singh@1608")
				.build();
		
		String token = given()
				.contentType(ContentType.JSON)
				.body(login)
			.when()
				.post("/users/login")
			.then().log().all()
				.assertThat()
				.statusCode(200)
				.extract()
				.path("token");
		
		String appendedToken = "Bearer "+token;
		
		System.out.println("Toke is: "+appendedToken);
		
		System.out.println("-----------------------------------------------------");
		
		ContactPojoLombok contacts = new ContactPojoLombok.ContactPojoLombokBuilder()
				.firstName("Henry")
				.lastName("Jason")
				.birthdate("1983-04-19")
				.email(getRandomEmail())
				.phone("6655443322")
				.street1("Krishna")
				.street2("Nagar")
				.city("Kanpur")
				.stateProvince("Uttar Pradesh")
				.postalCode("201234")
				.country("India")
				.build();
		
		given()
			.header("Authorization", appendedToken)
			.contentType(ContentType.JSON)
			.body(contacts)
		.when()
			.post("/contacts")
		.then().log().all()
			.assertThat()
			.statusCode(201);
			
	}

}
