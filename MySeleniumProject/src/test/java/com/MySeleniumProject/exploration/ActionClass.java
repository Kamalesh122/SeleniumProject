package com.MySeleniumProject.exploration;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass {

	@Test
	public void test1() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Dimension d = new Dimension(400, 400);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement mouseELement = driver.findElement(By.id("mousehover"));
		
		org.openqa.selenium.Rectangle rect = mouseELement.getRect();
		
		System.out.println(rect.height +" "+ rect.width);
		System.out.println(rect.getX() +" "+ rect.getY());
		System.out.println(rect.getDimension());
		

		int y = mouseELement.getLocation().getY();
		int x = mouseELement.getLocation().getX();

		System.out.println("Size Of The Element To Scroll: " + x + " : " + y);

		Actions action = new Actions(driver);
		action.scrollByAmount(x, y).build().perform();
		// action.scrollToElement(mouseELement).perform();

		action.moveToElement(mouseELement).build().perform();

		driver.switchTo().frame("iframe-name");

		WebElement insideFrame = driver.findElement(By.xpath("(//a[@href=\"practice-project\"])[1]"));
		action.click(insideFrame).build().perform();

		driver.switchTo().defaultContent();

		WebElement enterName = driver.findElement(By.cssSelector("#name:nth-child(2)"));
		action.sendKeys(enterName, "Kamalesh Sakthi").build().perform();

		enterName.clear();

		// ((JavascriptExecutor)driver).executeScript("window.scrollBy(22,1341)");

		// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
		// mouseELement);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		action.moveToElement(mouseELement);
	}

	@Test
	public void test2() throws IOException {

		FileInputStream file = new FileInputStream("D:\\Book2.xlsx");
		
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		
//		XSSFWorkbook workBook = new XSSFWorkbook(file);
//
//		XSSFSheet sheet = workBook.getSheetAt(0);
//		System.out.println(workBook.getSheetName(0));
		
//		Row row = sheet.getRow(4);
//		Cell cell = row.getCell(3);
//
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print(cell.toString() + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void reverseString() {
		String s = "Kamalesh";
		String reversed = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reversed += s.charAt(i);
		}
		System.out.println(reversed);
	}

	@Test
	public void findNonDuplicates() {
		int[] arr = { 1, 2, 2, 3, 4, 4, 5, 6, 7, 7 };

		ArrayList<Integer> nonDuplicates = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			boolean isDuplicate = false;
			for (int j = 0; j < arr.length; j++) {
				if (i != j && arr[i] == arr[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				nonDuplicates.add(arr[i]);
			}
		}
		System.out.println(nonDuplicates);
	}
	
	@Test
	public void revreseString() {
		
		String s = "Kamalesh";
		
		//ArrayList<Character> charSequence = new ArrayList();
		char c[] = s.toCharArray();
		
		int left = 0;
		int right = c.length-1;
		char temp;
		
		while(left<right) {
			temp = c[left];
			c[left] = c[right];
			c[right]= temp;
			
			left++;
			right--;
		}
		
		
		System.out.print(c);
	}
	
	@Test
	public void armstrong() {

		int actnumber = 153;
		int number = actnumber;
		int reminder;
		int power = 0;

		while (number != 0) {
			reminder = number % 10;
			power += Math.pow(reminder, 3);
			number /= 10;
		}

		System.out.println(power);

	}
	
	@Test
	public void removeDuplicate() {
		
		int a[]= {1,1,2,2,3,3,3,4,5,6};
		
		ArrayList<Integer> newArray = new ArrayList<>();
 		
		for(int i=0;i<a.length;i++) {
			boolean flag = false;
			for(int j=0;j<a.length;j++) {
				
				if(i!=j && a[i]==a[j]) {
					flag =true;
					break;
				}
				
			}
			if(!flag) {
				newArray.add(a[i]);
			}
		}
		System.out.println(newArray);
	}
	
	@Test
	public void fibanocci() {
		
		int a =0;
		int b =1;
		
		
		System.out.print(a+" "+b+" ");
		
		for(int i=2;i<10;i++) {
			
			
			int c = a+ b;
			System.out.print(c+" ");
			a=b;
			b=c;
			
			
			
		}
		
	}
}
