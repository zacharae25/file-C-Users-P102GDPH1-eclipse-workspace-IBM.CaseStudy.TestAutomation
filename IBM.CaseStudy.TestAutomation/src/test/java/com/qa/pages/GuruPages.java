package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuruPages{
	

	WebDriver driver;
	
	@FindBy(name="userName")
	WebElement UserTxtField;
	
	public WebElement getUserTxtField() {
		return UserTxtField;
	}
	
	@FindBy(name="password")
	WebElement PassTextField;
	
	public WebElement getPassTextFeild() {
		return PassTextField;
	}
	
	@FindBy(name="submit")
	WebElement SubmitBtn;
	
	public WebElement SubmitBtn() {
		return SubmitBtn;
	}
	
	@FindBy(xpath ="/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a")
		WebElement FlightCategory;
		
		public WebElement FlightCategory() {
			return FlightCategory;
		}
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font")
	WebElement TypeCategory;
		
		public WebElement TypeCategory() {
			return TypeCategory;
		}
		
	@FindBy(name = "passCount")
		WebElement  Passenger;
		
		public WebElement  Passenger() {
			return  Passenger;
		}
	
	@FindBy(name = "fromPort")
		WebElement  DepartingFrom;
		
		public WebElement  DepartingFrom() {
			return DepartingFrom;
		}
		
	@FindBy(name = "fromMonth")
		WebElement  OnCategory;
		
		public WebElement  OnCategory() {
			return  OnCategory;
		}
		
	@FindBy(name = "toPort")
		WebElement  ArrivingInr;
		
		public WebElement  ArrivingIn() {
			return  ArrivingInr;
		}
		
		
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font")
		WebElement  ServiceClass;
		
		public WebElement  ServiceClass() {
			return ServiceClass;
		}
		
		
	@FindBy(name = "airline")
		WebElement  Airline;
		
		public WebElement  Airline() {
			return Airline;
		}
		
	@FindBy(name = "findFlights")
		WebElement  Flights;
		
		public WebElement Flights() {
			return  Flights;
		}
		
	public GuruPages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
}

