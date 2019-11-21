package com.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase  {
	
public WebDriver driver;
public Properties prop;


	public void initialization(String browser, String url) throws Throwable {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		}else if(browser.equalsIgnoreCase("ff")) {
			
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}else {
			
			System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/mens-footwear/sports-shoes/pr?sid=osp,cil,1cu&otracker=nmenu_sub_Men_0_Sports%20Shoes");
		
		
	}
	

	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
}
