package GETAPITestWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ProductAPI {
	
	@BeforeMethod
	public void setUp() {
		baseURI = "https://fakestoreapi.com";
	}
	
	@Test(enabled=false)
	public void getAllProductsTest() {
		Response res = given().when().get("/products");
		
		System.out.println("status code: "+res.statusCode());
		System.out.println("status code: "+res.statusLine());
		
//		res.prettyPrint();
		
		JsonPath js = res.jsonPath();
		List<Integer> idList = js.getList("id");
		System.out.println("Ids are: "+idList);
		
		List<Double> priceList = js.getList("price");
		System.out.println("Price List are: "+priceList);
		
		List<Double> rateList = js.getList("rating.rate");
		System.out.println("Rate List are: "+rateList);
		
		List<Integer> countList = js.getList("rating.count");
		System.out.println("Count List are: "+countList);
		
		for(int i=0; i<idList.size(); i++) {
			int id = idList.get(i);
			Object price = priceList.get(i);
			Object rate = rateList.get(i);
			int count = countList.get(i);
			
			System.out.println("ID: "+id+", Price: "+price+", Rate: "+rate+", Count: "+count);
		}
	}
	
	@Test
	public void getAllProductsCountTest() {
		given().when().get("/products")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.body("$.size()", Matchers.equalTo(20));
	}

}
