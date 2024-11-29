package com.MySeleniumProject.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SecondTestClass {
	@Test
	public void Secondtest1() {
		System.out.println("My Second Class First Test");
	}

	@Test(dataProvider  = "testData")
	public void Secondtest2(String name, String Pass) {
		System.out.println("My Second Class Second Test");
		System.out.println(name+" yyyyyyyyyyyyyy "+ Pass);
	}

	@Test
	public void Secondtest3() {
		System.out.println("My  Second Class Third Test");
	}

	@Test
	@Parameters({"URL"})
	public void Secondtest4(String URL) {
		System.out.println("My Second Class Fourth Test");
		System.out.println("&&&&&&&"+ URL +"&&&&&&&&&");
	}
	
	
	@DataProvider(name = "dataProviderMethod")
	public Object[][] testData() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Kamalesh";
		data[0][1]= "12345";
		
		data[1][0] = "Vimal";
		data[1][1]= "12345";
		
		data[2][0] = "Vijay";
		data[2][1]= "12345";
		
		return data;
		
	}

}
