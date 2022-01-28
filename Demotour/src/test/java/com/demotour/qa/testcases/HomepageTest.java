package com.demotour.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demotour.qa.base.TestBase;
import com.demotour.qa.pages.Homepage;
import com.demotour.qa.pages.LoginPage;
import com.demotour.qa.pages.RegistersPage;
import com.demotour.qa.util.TestUtil;

public class HomepageTest extends TestBase{
	
	LoginPage lp;
	Homepage hp;
	
	RegistersPage rp; 
	
	String sheetName= "sheet1";
	
	 HomepageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		//testUtil= new TestUtil();
		lp= new LoginPage();
		hp=new Homepage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		rp= new RegistersPage();
		
	}
	
	@DataProvider
	
	public Object[][] fetchData()
	{
		
		Object data[][] =TestUtil.getTestData(sheetName);
				return data;
	}
	
	@Test(dataProvider= "fetchData")
	public void checkValues(String fn1, String ln1, String phno1, String em1, String add1, String cty1, String s1, String postc1, String uname1, String pwd1, String Cpwd1)
	{
		hp.addingnewuser ( fn1,  ln1,  phno1,  em1,  add1,  cty1,  s1,  postc1,  uname1,  pwd1,  Cpwd1);
	}
	

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
