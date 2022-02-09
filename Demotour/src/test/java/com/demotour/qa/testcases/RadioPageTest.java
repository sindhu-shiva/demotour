package com.demotour.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demotour.qa.base.TestBase;
import com.demotour.qa.pages.Homepage;
import com.demotour.qa.pages.LoginPage;
import com.demotour.qa.pages.RadioPage;
import com.demotour.qa.pages.RegistersPage;
import com.demotour.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class RadioPageTest extends TestBase{
	
	LoginPage lp;
	Homepage hp;
	RegistersPage rp;
	RadioPage rop;
	
	
	public RadioPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		lp=new LoginPage();
		hp=new Homepage();
		rp=new RegistersPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		rp.selectSelenium();
		rop=new RadioPage();
		
		
	}		
	@Test(priority=0)
	public void titlepagecheck()
	{
		String actualTitle=rop.radioPagetitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,"Radio Button & Check Box Demo","Title is not matching");
	}
	
	@Test
	public void selectionRadiobox()
	{
		
		rop.radioSelection();
	}
	
	@Test
	public void selectionCheckbox()
	{
		
		//rop.checkboxSelection();
		rop.checkboxSelection("checkbox1");
		
	}
	
	@Test
	public void MultipleselectionCheckbox()
	{
		
		rop.checkboxSelection("checkbox2");
		rop.checkboxSelection("checkbox3");
		
	}
	
	@Test
	public void MovetoDragDropPage()
	{
		rop.selectDragDrop();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}

}
