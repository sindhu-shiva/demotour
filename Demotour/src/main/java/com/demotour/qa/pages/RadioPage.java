package com.demotour.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demotour.qa.base.TestBase;

public class RadioPage extends TestBase{
	
	@FindBy(xpath="//input[@value='Option 1']")
	WebElement r1;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement seleniumHeading;
	
	@FindBy(xpath="//a[text()='REGISTER']")
	WebElement RegisterB;
	
	@FindBy( xpath="//a[text()='Drag and Drop Action']")
	WebElement dd;
	
	@FindBy( xpath="//a[text()='Radio & Checkbox Demo']")
	WebElement rc;
	
	public RadioPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void radioSelection()
	{
		
		r1.click();
	}
	
	public String radioPagetitle()
	{
		seleniumHeading.click();
		rc.click();
		return driver.getTitle();
	}
	public void checkboxSelection(String name)
	{
		
		WebElement ele= driver.findElement(By.xpath("//input[@value='"+name+"']"));
		ele.click();
	}
	
	public DragPage selectDragDrop()
	{
		seleniumHeading.click();
		
		
		dd.click();
		
		return new DragPage();

}
}
