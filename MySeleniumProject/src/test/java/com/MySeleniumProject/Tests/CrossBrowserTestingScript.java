package com.MySeleniumProject.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestingScript {

	WebDriver driver;
//cross browser testing
	@BeforeTest
	@Parameters({ "browser" })
	public void setup(String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("Incorrect Browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void verifyTitle() throws IOException {
		driver.get("https://www.browserstack.com/");
		System.out.println("Title is: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		driver.quit();
//		
//		
//		Actions act = new Actions(driver);
//		act.scrollToElement(WebElement).perform());
//		act.moveToElement(null).perform();
//		act.click().perform();
//		act.sendKeys(null).perform();
//		act.doubleClick().perform();
//		act.dragAndDrop(, null)
//		act.clickAndHold(null).release(targ).perform();
//		act.Ke
//		
//		
//		WebElement ele = driver.findElement(By.id(""));
//		
//		File file = ele.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("screenshot.png"));
//		
		

	
	
	
	}

}