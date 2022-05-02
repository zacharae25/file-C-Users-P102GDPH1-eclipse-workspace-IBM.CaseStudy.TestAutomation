package com.qa.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

public class GooglePages {
WebDriver driver;
	
	@FindBy(name="q")
	WebElement SearchTxtField;
	
	public WebElement getSearchTxtField() {
		return SearchTxtField;
	}
	
	@FindAll(@FindBy(className="sbct"))
	List<WebElement> AllItems;

	
	public List<WebElement> getAllItems() {
		return AllItems;
}
	
	public GooglePages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
}