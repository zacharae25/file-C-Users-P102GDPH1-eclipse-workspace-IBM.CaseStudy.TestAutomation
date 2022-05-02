package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Destination_05 {

	public static void main(String[] args) throws InterruptedException {
		//1. Open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2. Launch the URL for destinationqa.com/aut/RadioButtons.html
		driver.get("http://destinationqa.com/aut/RadioButtons.html"); // destination web page running on chrome browser
		
		//3. Select Monday Radio button
		
		WebElement MondayBtn = driver.findElement(By.xpath("//*[@id=\"daysofweek\"]/p[1]/input"));
		MondayBtn.click();
		
		//4. Check Yellow & Orange check box are selected by default
		
		WebElement OrangeBtn = driver.findElement(By.xpath("//*[@id=\"colors\"]/p[2]/input"));
		OrangeBtn.click();
		WebElement RedBtn = driver.findElement(By.xpath("//*[@id=\"colors\"]/p[1]/input"));
		RedBtn.click();
				
		
	}
}

