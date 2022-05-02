package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Rediff_06 {
	
	public static void main(String[] args) {
		
		// 1. Open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// 2. Launch the URL for rediff.com 
		driver.get("https://www.rediff.com/"); // rediff web page running on chrome browser
		
		// 3. Get & print the title of the home page	
		boolean contains = driver.getTitle().contains("Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		if(contains) {
			System.out.println("Title of the home page: " + driver.getTitle());
		}
			
		// 4. Click on Sign in
		WebElement SignInBtn = driver.findElement(By.linkText("Sign in"));
		SignInBtn.click();

			
		// 5. Get & Print the title of the Login page
		boolean contains2 = driver.getTitle().contains("Rediffmail");
		if(contains2) {
			System.out.println("Title of the login page: " + driver.getTitle());
			
		}
		
		
		//6. Go Back to the previous page using navigate method
		driver.navigate().back();

		
		//7. Get the title & check if it same as home page
		boolean contains3 = driver.getTitle().contains("Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		if(contains == contains3) {
			System.out.println("Title is same as home page: " + driver.getTitle());
		}
		
		//8. Use forward method & get the page title & check if it same as Login page		
		driver.navigate().forward();
		boolean contains4 = driver.getTitle().contains("Rediffmail");
		if(contains2 == contains4) {
			System.out.println("Title is same as login page: " + driver.getTitle());
		}
		
		
		//9. Close the browser
		driver.close();
		

	}

}

