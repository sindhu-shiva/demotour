package com.demotour.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		
		prop= new Properties ();
		
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("C:\\Users\\91973\\eclipse-workspace\\Demotour"
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
	
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	
	driver.get(prop.getProperty("url"));
	}
	
}


