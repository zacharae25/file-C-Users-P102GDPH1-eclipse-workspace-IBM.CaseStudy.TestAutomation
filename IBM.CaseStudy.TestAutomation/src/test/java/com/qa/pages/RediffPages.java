package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RediffPages {
	WebDriver driver;
	
	@FindBy(id="srchword")
	WebElement SearchTxtField;
	
	public WebElement getSearchTxtField() {
		return SearchTxtField;
	}
	
	@FindAll(@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/a[9]/span"))
	WebElement Category;
	
	public Select getCategory() {
		Select sel = new Select(Category);
		return sel;
	}
	
	@FindBy(id="snsSRC")
	WebElement MagnifierBtn;
	
	public WebElement getMagnifierBtn() {
		return MagnifierBtn;
	}
	
	@FindAll(@FindBy(xpath="/html/body/div[8]/img"))
	List<WebElement> AllItems;
	
	public List<WebElement> getAllItems() {
		return AllItems;
	}

	@FindAll(@FindBy(className="ht5"))
	List<WebElement> AllFooterLinks;
	
	public List<WebElement> getAllFooterLinks() {
		return AllFooterLinks;
	}

	public RediffPages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}


	
}
