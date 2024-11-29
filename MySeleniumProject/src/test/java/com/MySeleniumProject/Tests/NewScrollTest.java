package com.MySeleniumProject.Tests;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewScrollTest {

	@Test
	public void scrollToTest() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		// options.addArguments("--headless");
		// options.setExperimentalOption("exclude-switches",Arrays.asList("disable-popup-blocking"));
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.angelone.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement alertElement = driver.findElement(By.cssSelector("*.wzrk-alert.wiz-show-animate"));
		WebElement alertAccept = driver.findElement(By.cssSelector("button#wzrk-confirm"));

		// Alert alert = driver.switchTo().alert();
		// alert.accept();

//		wait.until(d->{
//			alertAccept.click();
//			return true;
//		});

		if (alertElement.isDisplayed()) {
//			Alert alert = driver.switchTo().alert();
//			alert.dismiss();
			alertAccept.click();
		}
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("menu-item-457564"))).perform();

		WebElement stocks = driver.findElement(By.id("menu-item-457565"));

		stocks.click();

		WebElement stockUniverseTab = driver.findElement(By.xpath("//h2[text()=\"STOCK UNIVERSE\"]"));

		WebElement nifty = driver.findElement(By.cssSelector("[data-value=\"nifty-100\"]"));

		if (stockUniverseTab.isDisplayed())
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nifty);

	}

	@Test
	public void  test() {
		int nums[] = { 1,10,6,7,7,1 };
		int count = 1;
		Arrays.sort(nums);
		int max = nums[nums.length - 1];
//		int result = 0;
//
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] + max == 0) {
//				result = max;
//				break;
//			} else {
//				result = -1;
//			}
//
//		}
//		
//		for(int i=0;i<nums.length;i++) {
//			for(int j=0;j<nums.length;j++) {
//				if(max==nums[j+1]) {
//					max= nums[j+1];
//					break;
//				}
//			}
//			count++;
//			max = nums[nums.length - count];
//			if(nums[i]==max) {
//				max = nums[i];
//				break;
//			}else {
//				max=-1;
//			}
//		}
//		
//	
//		System.out.print(max);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
