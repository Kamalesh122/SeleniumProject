package com.MySeleniumProject.API.Tests;

import org.testng.annotations.Test;

public class palindrome {

	@Test

	public void test() {

		int num = 171;
		int temp = 0;
		int reverse = 0;

		while (num < 0) {
			temp = num % 10;
			reverse = reverse + temp * 10;
			num = num / 10;
		}

		System.out.println(reverse);
	}

}
