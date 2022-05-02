package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
public class TC_Guru_09 extends TestBase {

	public static void main(String[] args) throws InterruptedException {			
		
		//1. Open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2. Lunch the URL for Guru99
		driver.get("http://demo.guru99.com/test/newtours/");
		Thread.sleep(3000);
		
		//3. Type username in user text field
		WebElement UserTextField = driver.findElement(By.name("userName"));
		UserTextField.sendKeys("mercury");
		Thread.sleep(3000);
				
		//3. Type username in user text field
		WebElement PassTextField = driver.findElement(By.name("password"));
		PassTextField.sendKeys("mercury");
		Thread.sleep(3000);
		
		//4. click submit
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
	
		driver.quit();
				
	
	}
}

