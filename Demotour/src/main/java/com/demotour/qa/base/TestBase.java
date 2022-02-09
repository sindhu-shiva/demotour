package com.demotour.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		
		prop= new Properties ();
		
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("C:\\Users\\91973\\git\\demotour\\Demotour"
						+ "\\src\\main\\java\\com\\demotour\\qa\\config\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				try {
					prop.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}


public static void initialization()
{
	String browsername= prop.getProperty("browser");
	
	if (browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	else
		if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\SeleniumDrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	
	driver.get(prop.getProperty("url"));
	}


public void failed(String failedTestMethod)
{
	
	File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(scrFile, new File("C:\\Users\\91973\\git\\demotour\\Demotour\\ScreenShot\\"
				+failedTestMethod +"_"+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}


