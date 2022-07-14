package com.qa.pageLayer;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class ProductPage extends TestBase{
	
	
	
	public ProductPage()
	{ 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath= "//button[@class = '_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addtocart;
	
	
	
	public void switchToProductPage() throws InterruptedException{
		Set <String> windowid = driver.getWindowHandles();
		 l = new ArrayList(windowid);
		driver.switchTo().window((String) l.get(1));}

	
	
	public void clickOnAddToCart() throws InterruptedException {
		addtocart.click();
	}
	
	public void clickOnGoToCart() {
		addtocart.click();
	}
	
	
		
	

}
