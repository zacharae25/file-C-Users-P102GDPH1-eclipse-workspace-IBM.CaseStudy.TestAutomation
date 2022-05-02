package com.qa.testscripts;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.ExcelUtility;

public class TC_Rediff_01 extends TestBase{

	@Test
	public void searchItem() throws InterruptedException {
		SoftAssert sAssert = new SoftAssert();
		
		boolean contains = driver.getTitle().contains("Online Shopping");
		if(contains) {
			Reporter.log("The user is on Rediff home page",true);
			sAssert.assertTrue(contains);

			RediffOR.getCategory().selectByVisibleText("Books");
			Thread.sleep(2000);	
			RediffOR.getSearchTxtField().sendKeys("Da vinci code");
			Thread.sleep(2000);	
			RediffOR.getMagnifierBtn().click();

			boolean contains2 = driver.getTitle().contains("Da vinci code");
			if(contains2) {
				Reporter.log("The title have the search item");
				sAssert.assertTrue(contains2);

				List<WebElement> allItems = RediffOR.getAllItems(	);
				System.out.println("Total no. of items fetched are : " + allItems.size());
				
				for(WebElement item:allItems) {
					Reporter.log(item.getText(),true);
				}
			}else {
				Reporter.log("The title do not have search item",true);
				sAssert.assertTrue(contains2);
			}
		}else {
			sAssert.assertTrue(contains);
			Reporter.log("The user is not on Rediff home page",true);
		}
		sAssert.assertAll();
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		
		String xFile="C:\\Users\\P102GDPH1\\eclipse-workspace\\IBM.CaseStudy.TestAutomation\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheet="Sheet1";
		
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