package com.MySeleniumProject.API.Pojo;

import io.restassured.path.json.JsonPath;

public class ConvertRawToJson {
	
	public static JsonPath rawToJson(String Response) {
		
		
		JsonPath js = new JsonPath(Response);
		return js;
	}

}
