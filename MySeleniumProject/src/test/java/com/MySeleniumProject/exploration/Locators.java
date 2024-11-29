package com.MySeleniumProject.exploration;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	@Test
	public void parentElement() {

//		int no = 34567;
//		System.out.println("Actual Integer :" + no);
//		int x;
//		int reverse = 0;
//
//		while (no != 0) {
//			x = no % 10;
//			reverse = reverse * 10 + x;
//			no = no / 10;
//		}
//
//		System.out.println("Reversed Integer :"+ reverse);
//	}

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));

		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		submit.click();

		List<WebElement> elements = driver.findElements(By.cssSelector("*.oxd-main-menu-item-wrapper"));
//	   ## To get the immidiate parent 
//	   WebElement parent = element.findElements(By.xpath(".."));
//	   WebElement parent = element.findElements(By.xpath("./.."));

//     ## To get the immidiate parants parant eement
//     WebElement parent = element.findElements(By.xpath("../.."));
//	   System.out.println(parent.getTagName());

// ### Selecting list of webElemnts using traditional method

		/*
		 * for (WebElement webElement : element) { if
		 * (webElement.getText().equalsIgnoreCase("Leave")) { webElement.click(); break;
		 * } }
		 * 
		 * }
		 */
		
// ### Selecting list of webelements uding streams
		
		elements.stream()
		.filter(element -> element.getText().equals("Leave"))
		.findFirst()
		.ifPresent(WebElement::click);
		
		

	}
	
	@Test
	public void implicitWaitExample() {
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		//IMPLICIT WAIT
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//hx[text()='Selenium WebDriver']")).click();
	}
	@Test
	public void explicitWaitExample() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		WebElement ele = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//hx[text()='Selenium WebDriver']")));
		
		ele.click();
	}
	
	@Test
	public void fluentWaitExample() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		// DECLARATION
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		//IMPLEMENTATION
		//WebElement ele = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//hx[text()='Selenium WebDriver']")));
		
		WebElement element = wait.until(new Function<WebDriver , WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//hx[text()='Selenium WebDriver']"));
			}
		});
		
		element.click();
		
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
		
		
	}
	
	public void test1() {
		
		int a= 23;
		int b =5;
		
		
		a= a+b;   //23+5 = 28
		b= a-b;   // 28-5 = 23
		a= a-b;   // 28-23= 5
		
		
//		  FileInputStream file = new FileInputStream(new File("path to excel.xlsx"));
//          Workbook workbook = WorkbookFactory.create(file);
//
//          Sheet sheet = workbook.getSheetAt(0);
//          for (Row row : sheet) {
//              for (Cell cell : row) {
//                  System.out.print(cell.toString() + "\t");
//              }
//              System.out.println();
//          }
//          workbook.close();
//          file.close();
//          
//          
//          TakeScreenshot ss = (driver) TakeScreenShot;
//          
//          
//          
//         driver.window().timeOuts().implicitlyWiat(Duration.ofSeconds(7));
//         
//         
//         
//         WebDriverWait w = new WebDriverWait(driver);
//         w.until(ExpectedCondition.VisibilityOfElement(element));
//         .pollingEvery()
//         
//		
//		Actions a = new Actions();
         
         
        
		
	}

}
