package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AmazonPages;
import com.qa.pages.GooglePages;
import com.qa.pages.GuruPages;
import com.qa.pages.RediffPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	GuruPages GuruOR;
	GooglePages GoogleOR;
	RediffPages RediffOR;
	AmazonPages AmazonOR;
	SoftAssert sAssert;
	FileInputStream fileLoc;
	Properties prop;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser,String Url) throws IOException {
		fileLoc = new FileInputStream("C:\\Users\\P102GDPH1\\eclipse-workspace\\IBM.CaseStudy.TestAutomation\\src\\test\\java\\com\\qa\\testdata\\Credentials.properties");
		prop = new Properties();
		prop.load(fileLoc);
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(Browser.equalsIgnoreCase("Ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		sAssert = new SoftAssert();
		AmazonOR = new AmazonPages(driver);
		driver.get(Url);
		
		RediffOR = new RediffPages(driver);
		driver.get(Url);
		
		GoogleOR = new GooglePages(driver);
		driver.get(Url);
		
		GuruOR = new GuruPages(driver);
		driver.get(Url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File Source = ts.getScreenshotAs(OutputType.FILE);
        File Target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
        FileUtils.copyFile(Source, Target);
    }

}