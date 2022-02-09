package com.demotour.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demotour.qa.base.TestBase;
import com.demotour.qa.pages.Homepage;
import com.demotour.qa.pages.LoginPage;
import com.demotour.qa.pages.RegistersPage;
import com.demotour.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class RegisterPageTest extends TestBase{
	
	LoginPage lp;
	Homepage hp;
	RegistersPage rp;
	
	
	public RegisterPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		lp= new LoginPage();
		hp=new Homepage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		rp= new RegistersPage();
		
	}
	
	@Test
	public void registerpagetitle()
	{
		String title=rp.registerPageTitle();
		System.out.println(title);
	}
	@Test
	public void selection()
	{
		rp.selectSelenium();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
