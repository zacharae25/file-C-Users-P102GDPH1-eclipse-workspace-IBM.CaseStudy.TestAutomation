package com.qa.testscripts;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.ExcelUtility;

public class TC_Google_04 extends TestBase{
	
	
	@Test(dataProvider="getData")
	public void searchItem(String SearchItem) throws InterruptedException, IOException {
			SoftAssert sAssert = new SoftAssert();
			
		boolean contains = driver.getTitle().contains("Google");
		if(contains) {
			
			sAssert.assertTrue(contains);
			Reporter.log("The user is on google home page",true);
			GoogleOR.getSearchTxtField().clear();
			GoogleOR.getSearchTxtField().sendKeys(SearchItem);
			Thread.sleep(3000);
		
			List<WebElement> allItems = GoogleOR.getAllItems();
			System.out.println("Total no. of items fetched are : " + allItems.size());
			for(WebElement item:allItems) {
				Reporter.log(item.getText(),true);
				
			}
			GoogleOR.getSearchTxtField().submit();
			boolean contains2 = driver.getTitle().contains(SearchItem);
			if(contains2) {
				sAssert.assertTrue(contains2);
				Reporter.log("The title have the search item",true);
			}else {
				sAssert.assertTrue(contains2);
				Reporter.log("The title do not have search item",true);
				captureScreenshot(driver,"searchItem");
			}
		}else {
			sAssert.assertTrue(contains);
			Reporter.log("The user is not on google home page",true);
			captureScreenshot(driver,"searchItem");
		}
		sAssert.assertAll();
	}
	@DataProvider
	public String[][] getData() throws IOException {
		
		String xFile="C:\\Users\\P102GDPH1\\eclipse-workspace\\IBM.CaseStudy.TestAutomation\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheet="Sheet2";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount ; i++) {
			for(int j=0; j<cellCount ; j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
		}
	}
		return data;
	}
}