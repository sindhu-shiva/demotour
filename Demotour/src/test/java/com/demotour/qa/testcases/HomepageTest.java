package com.demotour.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demotour.qa.base.TestBase;
import com.demotour.qa.pages.Homepage;
import com.demotour.qa.pages.LoginPage;
import com.demotour.qa.pages.RegistersPage;
import com.demotour.qa.util.CustomListener;
import com.demotour.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class HomepageTest extends TestBase{
	
	LoginPage lp;
	Homepage hp;
	RegistersPage rp; 
	
	
	 HomepageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		//testUtil= new TestUtil();
		lp= new LoginPage();
		hp=new Homepage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		rp= new RegistersPage();
		
	}
	
	/*@DataProvider
	
	public Object[][] fetchData()
	{
		
		Object data[][] =TestUtil.getTestData();
				return data;
	}*/
	
	@Test
	
	public void homepagetitletest()
	{
		Assert.assertEquals(hp.Homepagetitle(), "Login: Mercury Tours");
	}
	@Test
	public void checkValuespositiveTest()
	{
		//hp.addingnewuser( fn1,  ln1,  phno1,  em1,  add1,  cty1,  s1,  postc1,  uname1,  pwd1,  Cpwd1);
		hp.addingnewuser("nian", "ks", "1234567", "a@b.com", "a", "c", "v", "123", "sinshi", "ram", "ram");
	}
	
	@Test
	public void checkValuesNegTest()
	{
		//hp.addingnewuser( fn1,  ln1,  phno1,  em1,  add1,  cty1,  s1,  postc1,  uname1,  pwd1,  Cpwd1);
		hp.addingnewuser("nian", "ks", "1234567", "a@b.com", "a", "c", "v", "123", "sinshii", "ram","");
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
