package com.MySeleniumProject.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTestClass {

	@BeforeClass
	public void beforeClass() {
		System.out.println("I will run before First Class First Test ");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("I will run After First Class Last Test ");
	}

	@Test(groups = { "Smoke" })
	public void Firsttest1() {
		System.out.println("My First Test");
	}

	@Test(timeOut = 4000)
	public void Firsttest2() {

		String a = "Kamalesh";
		String b = null;
		System.out.println(a.equals(b));
		System.out.println("My Second Test");
	}

	@Test(enabled = false)
	public void Firsttest3() {
		System.out.println("My Third Test");
	}

	@Test()
	@Parameters({ "URL" })
	public void Firsttest4(String URL) {
		System.out.println("My Fourth Test");
		System.out.println("**********" + URL + "*****");
	}

}
