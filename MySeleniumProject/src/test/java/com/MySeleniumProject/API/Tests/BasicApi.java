package com.MySeleniumProject.API.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MySeleniumProject.API.Pojo.ConvertRawToJson;
import com.MySeleniumProject.API.Pojo.Payload;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.opentelemetry.api.trace.StatusCode;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class BasicApi {

	@Test
	public void postGLoc() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		
		String response = given().queryParam("key", "qaclick123").header("Content-Type", "Application/json")
				.body(Payload.addPlaceBody()).
				
				
				
				when().post("/maps/api/place/add/json").
				
				
				
				
				
				then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).extract().response().asString();

		System.out.println(response);
		System.out.println(ConvertRawToJson.rawToJson(response).getString("reference"));

	}

	@Test
	public void getGLoc() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123")
				.queryParam("place_id", "3a4ede48e8089d019c9057587bf2185c").when().get("/maps/api/place/get/json")
				.then().extract().response().asPrettyString();

		//System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String place = js.getString("address");
		
		Assert.assertEquals(place, "New Place");

	}

	@Test
	public void deleteLocG() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "Application/json")
				.body(Payload.deleteBody()).when().delete("/maps/api/place/delete/json").then().assertThat()
				.statusCode(200).extract().response().asPrettyString();

		System.out.println(response);
	}

	@Test
	public void updateLocG() {
		String placeId = "3a4ede48e8089d019c9057587bf2185c";
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "Application/json")
				.body("{\r\n"
						+ "    \"place_id\": \""+placeId+"\",\r\n"
						+ "    \"address\": \"New Place\",\r\n"
						+ "    \"key\": \"qaclick123\"\r\n"
						+ "}").when().put(" /maps/api/place/update/json").
				then().log().all().assertThat()
				.statusCode(200).extract().response().asPrettyString();

		System.out.println(response);
	}
	
	@Test
	public void complexjsonValidation() {
		JsonPath js = new JsonPath(Payload.mocJson());
		
		// Get Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount: "+ purchaseAmount);
		
		// Get Cources Array Count
		int coursesCount = js.getInt("dashboard.courses.size()");
		System.out.println("Course Count: "+ coursesCount);
		
		// Print Title of First Course
		String title = js.getString("dashboard.courses[0].title");
		System.out.println("First Course Title: "+ title);
		
		
		for(int i=0;i<coursesCount;i++ ) {
			String allTitle = js.getString("dashboard.courses["+i+"].title");
			System.out.println("Course"+i+": "+allTitle);
		}
		
		for(int i=0;i<coursesCount;i++ ) {
			String allTitle = js.getString("dashboard.courses["+i+"].title");
			if(allTitle.equals("RPA")) {
				System.out.println("Copies Sold By RPA is: "+js.getString("dashboard.courses["+i+"].copies"));
				break;
			}
		}
		
		// Verify sum of all courses amount matches purchase amount
		
		int actualPurchaseAmount=0;
		for(int i=0;i<coursesCount;i++) {
			actualPurchaseAmount += js.getInt("dashboard.courses["+i+"].price");
		}
		
		Assert.assertEquals(actualPurchaseAmount, purchaseAmount);
		
	}
	
	@Test
	public void readJsonFromExternalFile() throws IOException {
		
//		RestAssured.baseURI = "https://rahulshettyacademy.com";
//		
//		String response =given().queryParam("key", "qaclick123").header("Content-Type", "Application/json").   
//				body(new String(Files.readAllBytes(Path.of("D:\\addPlace.json")))).
//		when().put("/maps/api/place/add/json").   
//		then().assertThat().statusCode(200).extract().response().asPrettyString();
//		
//		System.out.println(response);
		
		String a = "Kamalesh";
		String b = null;
		
		if(a.equals(b))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		
	}
}
