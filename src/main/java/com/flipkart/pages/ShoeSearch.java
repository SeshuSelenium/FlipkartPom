package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoeSearch {
	
	public static @FindBy(xpath="//*[text()='Men']") WebElement men;
	
	public static @FindBy(xpath="(//*[text()='Casual Shoes'])[1]") WebElement cosualShoe;
	
	public static @FindBy(xpath = "(//*[text()='Casual Shoes'])[5]") WebElement validateCasualShoe;
	
	public static @FindBy(xpath ="//div[@class='_1qKb_B']/select[@class='fPjUPw']") WebElement min;
	
	public static @FindBy(xpath = "//div[@class='_1qKb_B']/select[@class='fPjUPw']/option[@value='1000']") WebElement minPrice;
	
	public static @FindBy(xpath="//div[@class='_1YoBfV']/select[@class='fPjUPw']") WebElement max;
	
	public static @FindBy(xpath="//div[@class='_1YoBfV']/select[@class='fPjUPw']/option[@value='3000']") WebElement maxPrice;
	
	public static @FindBy(xpath = "//div[text()='Puma']") WebElement pumaBrand;
	
	public static @FindBy(xpath = "(//*[contains(@class,'_2my')])[3]") WebElement selectItem;
	
	public static @FindBy(xpath = "//div[text()='Product Details']") WebElement validateProdectDetails;
	
	public static @FindBy(id = "swatch-3-size") WebElement shoeSize;
	
	public static @FindBy(xpath = "//*[text()='BUY NOW']") WebElement BuyButton;
	
	public static @FindBy(xpath = "//div[@class='_39M2dM _2ZvOfP']/input") WebElement userId_phone;
	
	public static @FindBy(xpath = "//span[text()='CONTINUE']") WebElement continueButton;
	
	public static @FindBy(xpath = "(//div[@class='_39M2dM _2ZvOfP'])[2]/input") WebElement password;
	
	public static @FindBy(xpath = "//span[text()='Login']") WebElement logInButton;
	
	
	
	
	
	
}
