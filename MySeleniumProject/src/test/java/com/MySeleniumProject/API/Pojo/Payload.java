package com.MySeleniumProject.API.Pojo;

public class Payload {

	public static String addPlaceBody() {
		return "{\r\n" + "    \"location\": {\r\n" + "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n" + "    },\r\n" + "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"My House 7\",\r\n" + "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 09\",\r\n" + "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n" + "        \"shop\"\r\n" + "    ],\r\n"
				+ "    \"website\": \"http://google.com\",\r\n" + "    \"language\": \"English\"\r\n" + "}";

	}

	public static String deleteBody() {
		return "{\r\n" + "    \"place_id\":\"9a494cbf98f36f931965fa92749aad30\"\r\n" + "}";

	}
	
	public static String updateBody() {
		return "{\r\n"
				+ "\"place_id\":\"9a494cbf98f36f931965fa92749aad30\",\r\n"
				+ "\"address\":\"My House 6, \",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
	}
	
	public static String mocJson() {
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 135,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\",\r\n"
				+ "    \"courses\": [\r\n"
				+ "      {\r\n"
				+ "        \"title\": \"Selenium Python\",\r\n"
				+ "        \"price\": 50,\r\n"
				+ "        \"copies\": 6\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"title\": \"Cypress\",\r\n"
				+ "        \"price\": 40,\r\n"
				+ "        \"copies\": 4\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"title\": \"RPA\",\r\n"
				+ "        \"price\": 45,\r\n"
				+ "        \"copies\": 10\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}";
	}

	public static String craeteBookPayload(String isbn, String aisle) {
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}";
	} 
}
