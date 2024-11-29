package com.MySeleniumProject.API.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MySeleniumProject.API.Pojo.CreateOrderResponse;
import com.MySeleniumProject.API.Pojo.EcomAddProductBody;
import com.MySeleniumProject.API.Pojo.EcomAddProductResponse;
import com.MySeleniumProject.API.Pojo.EcomLoginBody;
import com.MySeleniumProject.API.Pojo.EcomLoginResponse;
import com.MySeleniumProject.API.Pojo.OrderDetails;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EndToEndTest {

	@Test
	public void ecomE2ETest() {
		EcomLoginBody body = new EcomLoginBody();
		body.setUserEmail("sakthikamalesh67@gmail.com");
		body.setUserPassword("testing123$");

		// Login
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setBody(body)
				.setContentType(ContentType.JSON).build();

		EcomLoginResponse response =

				given().body(body).spec(req).

						when().post("/api/ecom/auth/login").

						then().extract().response().as(EcomLoginResponse.class);

		String token = response.getToken();
		System.out.println("Token: " + token);

		// Create Product
		RequestSpecification createProductReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();

		given().log().all().param("productName", "Laptop").multiPart("productImage", "Laptop")
				.param("productFor", new File("C:\\Users\\kamalesh.sakthi\\Pictures"))
				.param("productDescription", "Electronic").param("productPrice", "12")
				.param("productSubCategory", "Laptop").param("productAddedBy", "650d30b27244490f95b613a9");

		EcomAddProductResponse addProductResponse = createProductReq.when().post("/api/ecom/product/add-product").then()
				.extract().as(EcomAddProductResponse.class);
		String orderId = addProductResponse.getProductId();

		// Create Order
		RequestSpecification createOrderReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setBody(body).addHeader("Authorization", token).setContentType(ContentType.JSON).build();

		OrderDetails od = new OrderDetails();
		od.setCountry("India");
		od.setProductOrderedId(orderId);

		// List of Items to add
		List<OrderDetails> orderList = new ArrayList<OrderDetails>();
		orderList.add(od);

		// add the list items to class
		EcomAddProductBody addProductBody = new EcomAddProductBody();
		addProductBody.setOrders(orderList);

		RequestSpecification createOrderRequest = given().spec(createOrderReq).body(addProductBody);

		CreateOrderResponse cresponse = createOrderRequest.when().post("/api/ecom/order/create-order").then().extract()
				.as(CreateOrderResponse.class);
		System.out.println(cresponse.getProductOrderId());
		System.out.println(cresponse.getMessage());

		Assert.assertEquals(cresponse.getOrders(), orderId);
	}

}
