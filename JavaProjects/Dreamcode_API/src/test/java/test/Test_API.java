package test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ValidatableResponse;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Test_API 
{
	@Test
	public void getCity()
	{
		baseURI = "https://api.zippopotam.us/us/";
		String expectedCity = "San Francisco";
		
		given()
		.when()
			.get("/94105")
		.then()
			.assertThat()
			.statusCode(200)
			.extract()
			.response()
		.then()
			.assertThat()
			.body("places[0].'place name'", equalTo(expectedCity))
			.log().all();
	}
}
