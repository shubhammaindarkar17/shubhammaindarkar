package com.qa.testLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pageLayer.redbusHomepage;
import com.qa.testBase.TestBase;
import com.qa.utility.dataprovider;



public class HomepageTest extends TestBase {			
	
	@Test(dataProvider = "testdata" , priority = 1)
	public void CheckAvailbleBususes(String srccity, String destcity, String date) throws InterruptedException, IOException {
	
		h.enterSourceCity(srccity);
		h.enterDestinationCity(destcity);
		h.enterDate(date);
		h.clickOnSearchButton();
		Thread.sleep(5000);
		
			
		try{ Assert.assertTrue(h.checkfoundbuses());
		h.addbusdata((String)h.getFoundBuses());
		h.writedata();
		System.out.println(h.getFoundBuses());
		
	
		}
		
		catch(Exception e)
		{ h.addbusdata("No Buses Found");
		h.writedata();
		 System.out.println("No Result found");}
		
		}
	

	
  
	

}
