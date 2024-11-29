package com.MySeleniumProject.exploration;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FourthTestClass {
	

	/*
	 * @BeforeTest public void beforetest() {
	 * System.out.println("I will run before the Third Class First Test"); }
	 */
	
	
	  @BeforeSuite public void beforeSuite() {
	  System.out.println("I will run before All the test suite"); }
	  
	  @AfterSuite public void aftereSuite() {
	  System.out.println("I will run after All the the suite"); }
	 
	 
	/*
	 * @AfterTest public void afterTest() {
	 * System.out.println("I will run after the Third Class last test"); }
	 */
	 
	@Test
	public void Fourthtest1() {
		System.out.println("My Fourth Class First Test");
	}

	@Test
	public void Fourthtest2() {
		System.out.println("My Fourth Class Second Test");
	}

	@Test
	public void Fourthtest3() {
		System.out.println("My  Fourth Class Third Test");
	}

	@Test
	public void Fourthtest4() {
		System.out.println("My Fourth Class Fourth Test");
	}

}
