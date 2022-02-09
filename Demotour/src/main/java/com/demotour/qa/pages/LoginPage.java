package com.demotour.qa.pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demotour.qa.base.TestBase;



public class LoginPage extends TestBase {
	
	@FindBy( name="userName")
	WebElement username;
	
	@FindBy( name="password")
	WebElement password;
	
	@FindBy( xpath="//input[@name='submit']")
	WebElement signinb;
	
	@FindBy(  xpath="//a[text()='SIGN-ON']")
	WebElement signOn;

	@FindBy( xpath="//a[text()='REGISTER']")
	WebElement register;
	
	@FindBy( xpath="//img[@alt='Mercury Tours']")
	WebElement logo;//
	
	
	@FindBy( xpath="//td/descendant::input[3]/following-sibling::span")
	WebElement msg;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void register()
	{
		register.click();
	}
	
	public String validatePagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public Homepage login(String username1, String Password1) throws InterruptedException 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('Style','background:yellow; border:2x solid red;');", username);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('Style','background:; border:');", username);
		
		username.sendKeys(username1);
		password.sendKeys(Password1);
		signinb.click();
	    
		return new Homepage();	
		
	}
	
	public String nologin()
	{
		
		String m= msg.getText();
		return m;
	}
	
	
	}

