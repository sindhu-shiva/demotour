package com.demotour.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demotour.qa.base.TestBase;
import com.demotour.qa.pages.DragPage;
import com.demotour.qa.pages.Homepage;
import com.demotour.qa.pages.LoginPage;
import com.demotour.qa.pages.RadioPage;
import com.demotour.qa.pages.RegistersPage;
import com.demotour.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class DragPageTest extends TestBase{
	LoginPage lp;
	Homepage hp;
	RegistersPage rp;
	RadioPage rop;
	DragPage dd;
	
	public DragPageTest()
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
		/*rp= new RegistersPage();
		rop=new RadioPage();*/
		dd=new DragPage();
	}
	
	/*@Test
	public void selection()
	{
		rp.selectSelenium();
		rop.selectDragDrop();
	}*/
	
	@Test
	public void ddFunctioanlity()
	{
		dd.dragdrop();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

