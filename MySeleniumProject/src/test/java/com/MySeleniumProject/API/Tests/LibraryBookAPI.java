package com.MySeleniumProject.API.Tests;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.MySeleniumProject.API.Pojo.ConvertRawToJson;
import com.MySeleniumProject.API.Pojo.Payload;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

public class LibraryBookAPI {

	@Test(dataProvider = "BooksData")

	public void addBook(String isbn, String aisle)

	{

		RestAssured.baseURI = "http://216.10.245.166";

		String resp = given().

				header("Content-Type", "application/json").

				body(Payload.craeteBookPayload(isbn, aisle)).

				when().

				post("/Library/Addbook.php").

				then().assertThat().statusCode(200).

				extract().response().asPrettyString();

		JsonPath js = ConvertRawToJson.rawToJson(resp);

		String id = js.get("ID");

		System.out.println(id);

		// deleteBOok

	}

	@DataProvider(name = "BooksData")
	public Object[][] getData() {

		return new Object[][] { { "book1", "123" }, { "book2", "1234" }, { "Book5", "12345" } };

	}

}
