package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class HomePage extends TestBase {
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	private WebElement closeloginpopup;
	
	@FindBy(xpath= "//input[@name  = 'q']")
	private WebElement searchbox;
	
	@FindBy(xpath = "//button[@class  = 'L0Z3Pu']")
	private WebElement searchbutton;

	@FindBy(xpath ="//div[@class  = '_4rR01T'][1]")
	private WebElement product;
	
	
	
	public void closeLoginPopup()
	{ closeloginpopup.click();
		
	}
	
	public void enterProductName(String productname)
	{ searchbox.sendKeys(productname);
		
	}
	
	public void clickOnSearchButton()
	{ searchbutton.click();
		
	}
	
	public void clickOnFirstProduct()
	{ productname = product.getText();
		product.click();
		
	}
	
	public String getProductName() {
		
		return productname;
	}
	
	
}
