package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class CartPage extends TestBase{

	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(xpath = "//a[@class = '_2Kn22P gBNbID']")
	private WebElement cartproduct;
	

	
	
	public String getCartProductName()
	{
		String name = cartproduct.getText();
		return name;
		
	}
	
}
