package com.qa.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testbase.TestBase;



public class ProductPageTest extends TestBase{

	@Test(dataProvider = "searchdata")
	public void verifyAddToCart(String product) throws InterruptedException {
		Thread.sleep(2000);
		h.closeLoginPopup();
		h.enterProductName(product);
		h.clickOnSearchButton();
		Thread.sleep(3000);
		h.clickOnFirstProduct();
		Thread.sleep(2000);
		p.switchToProductPage();
		Thread.sleep(3000);
		p.clickOnAddToCart();
		Thread.sleep(3000);
		Assert.assertEquals(h.getProductName(),c.getCartProductName());
		
	
		
		
		
		
		
		
	}
}
