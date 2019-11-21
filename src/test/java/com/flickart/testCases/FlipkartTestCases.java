package com.flickart.testCases;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.flipkar.retry.RetryAnalyser;
import com.flipkart.base.TestBase;
import com.flipkart.pages.ShoeSearch;
@Listeners(com.flipkart.listeners.ListenerTest.class)
public class FlipkartTestCases extends TestBase {
	public static Actions action;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	
	
	
	@BeforeTest
	public void start() throws Throwable {
		
		InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\flipkart\\resource\\config.properties");
		
		prop = new Properties();
		
		prop.load(input);
		
		
		initialization(prop.getProperty("browser"), prop.getProperty("url"));
		
	}
	
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void shoBooking() throws InterruptedException {
		
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 30);
		
		ShoeSearch ss = PageFactory.initElements(driver, ShoeSearch.class);
		
		String parentWindow = driver.getWindowHandle();
		
		action = new Actions(driver);
		
		Thread.sleep(5000);
		
//		action.moveToElement(ss.men).build().perform();
		
		WebElement men =driver.findElement(By.xpath("//*[text()='Men']"));
		
		action.moveToElement(men).build().perform();
		
		Thread.sleep(1000);
		
//		action.moveToElement(ss.cosualShoe).click().build().perform();
		
		WebElement shoes = driver.findElement(By.xpath("(//*[text()='Casual Shoes'])[1]"));
		
		action.moveToElement(shoes).click().build().perform();
		
		String actual = ss.validateCasualShoe.getText();
		
		if(actual.equalsIgnoreCase("Casual Shoes")) {
			System.out.println("actual and  expected matched");
		}else {
			System.out.println("actual and  expected not match");
		}
		
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		
		ss.min.click();
		
		ss.minPrice.click();
		
		js.executeScript("window.scrollBy(0,100)");
		
		Thread.sleep(5000);
		
		ss.max.click();
		
		ss.maxPrice.click();
		
		Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,300)");
		
		ss.pumaBrand.click();
		
		Thread.sleep(5000);
		
		WebElement item = wait.until(ExpectedConditions.elementToBeClickable(ss.selectItem));
		
		item.click();
		
		Set<String> childWindows = driver.getWindowHandles();
		for(String names : childWindows)
		if(!parentWindow.equals(names)) {
			driver.switchTo().window(names);
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(ss.validateProdectDetails));
		
		String proDetails = ss.validateProdectDetails.getText();
		
		if(proDetails.equalsIgnoreCase("Product Details")) {
			System.out.println("product details available");
		}else { 
			System.out.println("product details not available");
		}
		
		Thread.sleep(5000);
		
	
		js.executeScript("window.scrollBy(0,300)");
		
		
		WebElement size =wait.until(ExpectedConditions.elementToBeClickable(ss.shoeSize));
		
		size.click();
		
		ss.BuyButton.click();
		
		WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(ss.continueButton));
		
		ss.userId_phone.sendKeys(prop.getProperty("userId_phone"));
		
		continueButton.click();
		
		ss.password.sendKeys(prop.getProperty("password"));
		
		ss.logInButton.click();
	}
	
	@Test
	public void testFail() {
		Assert.assertTrue(false);
	}
	

}
