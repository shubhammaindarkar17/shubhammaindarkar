package com.qa.testbase;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.pageLayer.CartPage;
import com.qa.pageLayer.HomePage;
import com.qa.pageLayer.ProductPage;

import coom.qa.testdata.dataprovider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends dataprovider{

	public static WebDriver driver;
	public static HomePage h;
	public static ProductPage p;
	public static CartPage c;
	
	public static String productname;
	
	public static ArrayList l; 
	
	
	@BeforeMethod
	public void startup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com/");
		
		

		
		h = new HomePage();
		p = new ProductPage();
		c = new CartPage();
		
	}
	
	
	
	
	@AfterMethod
     public void teraDown()
     {
		driver.quit();
     }
}
