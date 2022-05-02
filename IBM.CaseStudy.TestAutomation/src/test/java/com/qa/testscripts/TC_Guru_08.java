package com.qa.testscripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Guru_08 {
	
	
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
			
		//4. Type username in pass text field
		WebElement PassTextField = driver.findElement(By.name("password"));
		PassTextField.sendKeys("mercury");
		
		//5. click submit
		driver.findElement(By.name("submit")).click();
	
		//3. Select flights in FightCategory
		WebElement FlightCategory= driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a"));
		FlightCategory.click();
		
		//3. Select what type
		WebElement TypeCategory= driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font"));
		TypeCategory.click();
		
		//3. Choose how many passenger
		WebElement Passenger = driver.findElement(By.name("passCount"));
		Passenger.sendKeys("4");
		
		//3. Choose Departing location
		WebElement DepartingFrom = driver.findElement(By.name("fromPort"));
		DepartingFrom.sendKeys("London");
		
		//3. Choose Departing Dates
		WebElement OnCategory = driver.findElement(By.name("fromMonth"));
		OnCategory.sendKeys("May");
		
		//3. Choose Arriving
		WebElement ArrivingIn = driver.findElement(By.name("toPort"));
		ArrivingIn.sendKeys("Sydney");
		
		//3. Choose Service Class
		WebElement ServiceClass = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font"));
		ServiceClass.sendKeys("First Class");
		
		//3. Choose what Airline
		WebElement Airline= driver.findElement(By.name("airline"));
		Airline.sendKeys("Blue Skies Airline");
					
		//4. Click continue to book a flight
		driver.findElement(By.name("findFlights")).click();
		Thread.sleep(3000);
	
		driver.quit();
			
	
	}
} 
