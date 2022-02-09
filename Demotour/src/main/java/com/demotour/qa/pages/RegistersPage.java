package com.demotour.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.demotour.qa.base.TestBase;

public class RegistersPage extends TestBase{
	
	@FindBy(xpath="//a[text()='REGISTER']")
	WebElement RegisterB;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement seleniumHeading;
	
	@FindBy(xpath="//a[text()='SUPPORT']")
	WebElement support;
	
	@FindBy(xpath="//a[text()='CONTACT']")
	WebElement contact;
	
	@FindBy(xpath="//a[text()='SIGN-ON']")
	WebElement logout;
	
	@FindBy( xpath="//a[text()='Radio & Checkbox Demo']")
	WebElement rc;
	
	public RegistersPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public RadioPage selectSelenium()
	{
		RegisterB.click();
		
		//Actions action =new Actions(driver);
		//action.moveToElement(seleniumHeading).build().perform();
		seleniumHeading.click();
		rc.click();
		
		
		return new RadioPage();
	}
	
	public String registerPageTitle()
	{
		RegisterB.click();
		return driver.getTitle();
	}
			
	
	
	

}
