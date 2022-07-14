package com.qa.testBase ;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class write extends TestBase{
	
	String result;
	
	@DataProvider(name = "testData")
	public Object[][] testdata() throws IOException{
	
	String path ="C:\\Users\\Shubham\\Desktop\\data.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(file);
		Sheet a = wb.getSheet("Sheet1");
		
		int exactRow = a.getLastRowNum() + 1;
		int exactCell= a.getRow(0).getLastCellNum();
		
		String [][] d = new String[exactRow][exactCell];
		
		for(int i =0; i<exactRow; i++)
		{for (int j=0; j<exactCell; j++)
		   { 
			String value = a.getRow(i).getCell(j).getStringCellValue();
			d[i][j] = value;
			
			
			
				
			}
		
		
		}

		return d;
		
		
	}
	
	
	@Test(dataProvider = "testData")
	public void logintest(String email, String pass) throws InterruptedException {
		
	  driver.findElement(By.xpath("//a[@id ='login2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id ='loginusername']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id ='loginpassword']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[text() ='Log in']")).click();
		Thread.sleep(15000);
	
	boolean logout = driver.findElement(By.xpath("//a[@id ='logout2']")).isDisplayed();
	 Assert.assertEquals(logout, true);
	
	 
	 
	 
	 }
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

