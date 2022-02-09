package com.demotour.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demotour.qa.base.TestBase;

public class DragPage extends TestBase{
	

	@FindBy(xpath="//li[@id='credit1']/descendant::a[text()=' SALES ']")
	WebElement sales;
	
	@FindBy(xpath="//li[@id='fourth']/descendant::a[text()=' 5000 ']")
	WebElement amount;
	
	@FindBy(xpath="//ol[@class='field15 ui-droppable ui-sortable']/descendant::li")
	WebElement CA;
	
	
	@FindBy(xpath="//ol[@class='field13 ui-droppable ui-sortable' and @id='amt7']/descendant::li")
	WebElement DAM;
	
	@FindBy(xpath="//ol[@class='field13 ui-droppable ui-sortable' and @id='amt8']/descendant::li")
	WebElement CAM;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement seleniumHeading;
	
	@FindBy( xpath="//a[text()='Drag and Drop Action']")
	WebElement dd;
	
	public DragPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void dragdrop(){
		seleniumHeading.click();
		dd.click();
		
		
		Actions act=new Actions(driver);
		
		WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
		WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));
		
		act.dragAndDrop(From1, To1).build().perform();;
		act.dragAndDrop(amount, DAM).build().perform();
		act.dragAndDrop(amount, CAM).build().perform();
		act.dragAndDrop(sales,CA).build().perform();
		
	}
}
