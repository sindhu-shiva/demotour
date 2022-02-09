package com.demotour.qa.testcases;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demotour.qa.base.TestBase;
import com.demotour.qa.pages.Homepage;
import com.demotour.qa.pages.LoginPage;
import com.demotour.qa.util.CustomListener;
@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase{
	
	LoginPage lp;
	Homepage hp;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lp= new LoginPage();
		hp=new Homepage();
	}
	
	@Test(priority=0)
	public void loginpagetitleTest()
	{
		
		String title= lp.validatePagetitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}

	
	@Test(enabled=true)
	public void loginpagelogoTest()
	{
		
		Boolean logo1= lp.verifyLogo();
		Assert.assertTrue(logo1);
	}
	
	@Test(priority=1)
	public void loginpagetest() throws InterruptedException
	{
	
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		String Title1 =driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();
		String Title2 =driver.findElement(By.xpath("//b[text()=' Thank you for Loggin. ']")).getText();
		Assert.assertEquals(Title1,"Login Successfully","Login unsuccessful") ;
		Assert.assertEquals(Title2,"Thank you for Loggin.","Login unsuccessful") ;
		
		
		//System.out.println(Title1+ "AND " +Title2);
	}
	
	@Test(groups= "unsuccessful login")
	public void nologintest()
	{
		Assert.assertTrue(true, lp.nologin());
		String errorMsg = "Enter your userName and password correct";
		if(lp.nologin().contains(errorMsg)) 
		{
		    System.out.println("Test Case Passed");
		}else
		{
		    System.out.println("Test Case Failed");
		};
	}
	
	@AfterMethod
	public void teardown()
	{
		//driver.quit();
	}
}

