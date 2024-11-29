package com.MySeleniumProject.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.codegen.model.Action;

public class ThirdTestClass {

//	  @BeforeTest public void beforetest() {
//	  System.out.println("I will run before the Third Class First Test"); }
//	 

//	  @BeforeSuite public void beforeSuite() {
//	  System.out.println("I will run before Third Class First the suite"); }
//	  
//	  @AfterSuite public void aftereSuite() {
//	  System.out.println("I will run after Third Class Last  the suite"); }

//	  @AfterTest public void afterTest() {
//	  System.out.println("I will run after the Third Class last test"); }

	@Test(groups = { "Smoke" })
	public void Thirdtest1() {
		System.out.println("My Third Class First Test");
	}

	@Test
	public void Thirdtest2() {
		System.out.println("My Third Class Second Test");
	}

	@Test
	public void Thirdtest3() {
		System.out.println("My  Third Class Third Test");
	}

	@Test(groups = { "Smoke" })
	public void Thirdtest4() throws IOException {
		System.out.println("My Third Class Fourth Test");

		FileInputStream file = new FileInputStream("D:\\Book1.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int sheets = workbook.getNumberOfSheets();
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

	@Test
	public void pattern() {

		int k = 1;

		for (int i = 1; i <= 10; i++) {

			for (int j = 1; j <= 10 - i; j++) {
				System.out.print(k + " ");
				k++;
			}

			System.out.println();
		}

	}

	@Test
	public void pattern2() {
		int k = 1;

		// 5

//		for(int i=5; i>1; i--) {
//			for(int j=0; j<=5-i;j++) {
//				System.out.print(k + " ");
//				k++;
//			}
//			System.out.println();
//		}
//		

		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
				k++;
			}
			System.out.println();
		}

	}

	@Test
	public void multiDimentional() {
		int mu[][] = { { 1, 2, 99 }, { 3, 4, 5 }, { 7, 8, 0 } };

		int min = 1;
		int k = 0;

		for (int i = 0; i < mu.length; i++) {
			for (int j = 0; j < mu.length; j++) {
				if (mu[i][j] < min) {
					min = mu[i][j];
					k = j;
				}
			}
		}
		System.out.println(min + " " + k);

		int l = 0;
		int max = mu[0][0];

		while (l < 3) {

			if (mu[l][k] > max)
				max = mu[l][k];
			l++;

		}
		System.out.println(max);
	}

	@Test
	public void clanderInstance() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("M/dd/yyyy hh:mm:ss");
		System.out.println(s.format(c.getTime()));

		System.out.println(c.get(Calendar.DAY_OF_MONTH));

		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		System.out.println(Calendar.DAY_OF_WEEK_IN_MONTH);

		Date d = new Date(0);
		System.out.println(s.format(d));

	}

	@Test
	public void maxElement() {

		int a[] = { 1, 22, 5, 6, 8, 9 };
		int max = a[0];
		int secondMax = a[0];

		int sorted[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				secondMax = max;
				max = a[i];
			} else if (a[i] > secondMax && a[i] != max) {

				secondMax = a[i];
			}

		}
		System.out.println(max + " " + secondMax);
	}

	@Test
	public void Pattern() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if (i==1 && (j > 0 && j < 4)) {
					System.out.print("  ");
				} else {
					System.out.print("1 ");
				}
			}
			System.out.println();
		}

	}
	
	@Test
	public void PalindromTest() {
		String str1 = "mam";

		char c[] = str1.toCharArray();
		String revresed = "";

		for (int i = c.length - 1; i >= 0; i--) {
			revresed += c[i];
		}
		
		System.out.println(revresed);
		if (str1.equals(revresed)) {
			System.out.println("Given String is Palindrome");
		} else {
			System.out.println("Given String is Not a Palindrome");
		}
	}
	
	@Test
	public void fileUploadFromLocal() throws AWTException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

		// Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement upload = driver.findElement(By.cssSelector("input[name=\"upfile\"]"));
		// wait.until(ExpectedConditions.visibilityOf(upload)).click();
		Actions action = new Actions(driver);
		action.moveToElement(upload).perform();
		action.click(upload).perform();

		String filePath = "C:\\Users\\kamalesh.sakthi\\Pictures\\Aruna.jpg";

		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}