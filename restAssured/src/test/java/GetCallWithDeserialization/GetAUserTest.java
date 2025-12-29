package GetCallWithDeserialization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAUserTest {

	@Test
	public void getUserTest() throws Exception, JsonProcessingException {
		
		baseURI = "https://gorest.co.in";
//		https://gorest.co.in/public/v2/users/8311309
		
		Response response = given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
		.when()
			.get("/public/v2/users/8311309");
		
//		deserialization		
		
		String responseBody = response.asString();
		
		ObjectMapper mapper = new ObjectMapper();
		UserPojo userResponse = mapper.readValue(responseBody, UserPojo.class);
		System.out.println(userResponse);
		
		Assert.assertEquals(userResponse.getName(), "Tanya Bhagat");
		Assert.assertEquals(userResponse.getEmail(), "apiautomation1766842822378@learning.com");
		Assert.assertEquals(userResponse.getStatus(), "active");
		Assert.assertEquals(userResponse.getId(), 8311309);
	}
	
	@Test
	public void getUserUsingLombokTest() throws Exception, JsonProcessingException {
		
		System.out.println("Lombok GET call");
		
		baseURI = "https://gorest.co.in";
//		https://gorest.co.in/public/v2/users/8311309
		
		Response response = given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
		.when()
			.get("/public/v2/users/8311309");
		
//		deserialization		
		
		String responseBody = response.asString();
		
		ObjectMapper mapper = new ObjectMapper();
		UserPojoLombok userResponse = mapper.readValue(responseBody, UserPojoLombok.class);
		System.out.println(userResponse);
		
		Assert.assertEquals(userResponse.getName(), "Tanya Bhagat");
		Assert.assertEquals(userResponse.getEmail(), "apiautomation1766842822378@learning.com");
		Assert.assertEquals(userResponse.getStatus(), "active");
		Assert.assertEquals(userResponse.getId(), 8311309);
	}
	
	
}
