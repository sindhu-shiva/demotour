package com.demotour.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demotour.qa.base.TestBase;

public class Homepage extends TestBase{

	@FindBy(xpath="//a[text()='REGISTER']")
	WebElement RegisterB;
	
	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(xpath="//input[@name='userName' and @id='userName']")
	WebElement email;
	
	@FindBy(name="address1")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postalCode")
	WebElement postalCode;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="email")
	WebElement un;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmpwd;
	
	@FindBy(name="submit")
	WebElement submit;
	
	public Homepage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public RegistersPage addingnewuser(String fn, String ln, String phno, String em, String add, String cty, String s, String postc, String uname, String pwd, String Cpwd)
	{
		RegisterB.click();
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		phone.sendKeys(phno);
		email.sendKeys(em);
		address.sendKeys(add);
		city.sendKeys(cty);
		state.sendKeys(s);
		postalCode.sendKeys(postc);
		
		Select dropdown= new Select(country);
		dropdown.selectByVisibleText("INDIA");
		
		un.sendKeys(uname);
		password.sendKeys(pwd);
		confirmpwd.sendKeys(Cpwd);
		submit.click();
		
		return new RegistersPage();
	
	}
	
	public String Homepagetitle()
	{
		return driver.getTitle();
	}
    
}
