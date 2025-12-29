package BookingAPITest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BookingAPITest {
	
	public String token;
	int bookingId;
	
	@BeforeTest
	public void getToken() {
		
		System.out.println("Starting of Before Method");
		
		baseURI = "https://restful-booker.herokuapp.com";
		
		Credentials cred = new Credentials.CredentialsBuilder()
				.username("admin")
				.password("password123")
				.build();
		
		token = given()
			.contentType(ContentType.JSON)
			.body(cred)
		.when()	
			.post("/auth")
		.then()
			.assertThat()
			.statusCode(200)
			.and()
			.extract()
			.path("token");
		
		System.out.println("Token is: "+token);
		
		System.out.println("Ending of Before Method");
	}
	
	@BeforeMethod
	public void setUp() {
		bookingId =	createBooking();
	}
	
	@Test
	public void getBookingTest() {
		
		System.out.println("Starting of Test Method");		

		given()
			.pathParam("bookingId", bookingId)
		.when()
			.get("/booking/{bookingId}")
		.then()
			.assertThat()
			.statusCode(200)
			.and()
			.body("firstname", equalTo("Jim"))
			.and()
			.body("bookingdates.checkin", equalTo("2018-01-01"));
		
		System.out.println("Ending of Test Method");	
	}
	
	@Test
	public void getAllBookingTest() {
		System.out.println("Starting of get all booking test method");
		
		Response res = when()
			.get("/booking");
		
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(), 200);
		
		System.out.println("Ending of get all booking test method");
	}
	
	@Test
	public void createBookingTest() {
		
		System.out.println("Starting of Create Booking Method");
		
		Assert.assertNotNull(bookingId);
		
		System.out.println("Ending of Create Booking Method");	
	}
	
	@Test
	public void updateBookingTest() {
		System.out.println("Starting of Update Booking Method");
		
		given()
			.contentType(ContentType.JSON)
			.header("Accept", "application/json")
			.header("Cookie", "token="+token)
			.body("{\n"
					+ "    \"firstname\" : \"James\",\n"
					+ "    \"lastname\" : \"Brown\",\n"
					+ "    \"totalprice\" : 111,\n"
					+ "    \"depositpaid\" : true,\n"
					+ "    \"bookingdates\" : {\n"
					+ "        \"checkin\" : \"2018-01-01\",\n"
					+ "        \"checkout\" : \"2019-01-01\"\n"
					+ "    },\n"
					+ "    \"additionalneeds\" : \"Dinner\"\n"
					+ "}")
			.pathParam("bookingID", bookingId)
		.when()
			.put("/booking/{bookingID}")
		.then()
			.assertThat()
			.statusCode(200)
			.and()
			.body("firstname", equalTo("James"))
			.and()
			.body("additionalneeds", equalTo("Dinner"));
		
		System.out.println("Ending of Update Booking Method");	
	}
	
	
	@Test
	public void deleteBookingTest() {
		
		System.out.println("Starting of Delete Booking Method");
		
		given()
			.contentType(ContentType.JSON)
			.header("Cookie", "token="+token)
			.pathParam("bookingID", bookingId)
		.when()
			.delete("/booking/{bookingID}")
		.then()
			.assertThat()
			.statusCode(201);
		
		System.out.println("Ending of Delete Booking Method");	
	}
	
	
	public int createBooking() {
		
		System.out.println("Starting of Create Booking Method");
		
		Integer bookingId =  given()
			.contentType(ContentType.JSON)
			.body("{\n"
					+ "    \"firstname\" : \"Jim\",\n"
					+ "    \"lastname\" : \"Brown\",\n"
					+ "    \"totalprice\" : 111,\n"
					+ "    \"depositpaid\" : true,\n"
					+ "    \"bookingdates\" : {\n"
					+ "        \"checkin\" : \"2018-01-01\",\n"
					+ "        \"checkout\" : \"2019-01-01\"\n"
					+ "    },\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\n"
					+ "}")
		.when()
			.post("/booking")
		.then()
			.statusCode(200)
			.and()
			.extract()
			.path("bookingid");

		
		System.out.println("Booking ID is: "+bookingId);
		
		System.out.println("Ending of Before Method");
		
		return bookingId;
	}

}
