package com.qa.pageLayer;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class redbusHomepage extends TestBase{
	
	
	public redbusHomepage()
	{PageFactory.initElements(driver, this);}
	
	@FindBy(xpath ="//input[@id='src']")
	private WebElement src;
	
	@FindBy(xpath= "//ul[@class='autoFill homeSearch']/child::li[1]")
	private WebElement firstsuggetion;
	
	@FindBy (xpath = "//input[@id='dest']")
	private WebElement dest;
	
	@FindBy(xpath = "//input[@id='onward_cal']")
	private WebElement datebox;

	@FindBy(xpath = "//td[@class = 'monthTitle']")
	private WebElement monthtittle;
	
	@FindBy(xpath = "//td[@class = 'monthTitle']//following-sibling::td")
	private WebElement next;
	
	@FindBy(xpath ="//table[@class = 'rb-monthTable first last']//td")
	private List <WebElement> alldates;
	
	@FindBy(xpath = "//button[@id='search_btn']")
	private WebElement search;
	
	@FindBy(xpath= "//span[text()='SORT BY']/parent::div/child::span/span[@class = 'f-bold busFound']")
	private WebElement busfound;
	
	
	public void enterSourceCity(String srccity) {
	src.sendKeys(srccity);
	firstsuggetion.click();
	}
	
	public void enterDestinationCity(String destcity) {
		dest.sendKeys(destcity);
		firstsuggetion.click();
	}
	
	public void pickdate(String date) {
		
		for(WebElement ele :alldates)
		  { String d  = ele.getText();
			if(d.equalsIgnoreCase(date))
			  {ele.click();
			    break;
			  }
		  }
	   }
	
	
	public void enterDate(String Date) {
		
		String [] c = Date.split(" ");
		String date = c[0];
		String month = c[1];
		String year = c[2];
		
		datebox.click();
		String m = monthtittle.getText();
		if(m.startsWith(month + " " + year))
		{ h.pickdate(date);}
		
		else
		{ while(true)
		   {next.click();
			String mo = monthtittle.getText();
		   if(mo.startsWith(month + " " + year))
		     {h.pickdate(date);
		      break;}
		   }
		}
	
	}
	
	public void clickOnSearchButton() {
		search.click();
	}
	
	public boolean checkfoundbuses() {
		 boolean bus = busfound.isDisplayed();
		 return bus;
	}
	
	public String getFoundBuses() {
		
		String result = busfound.getText();
		return result;
	}
	
	
	
	public void addbusdata(String buscount) {
		l.add(buscount);
		
		}
	
	public String getbusdata(int i) {
		String bus = l.get(i);
		return bus;
		}
	
	  public void writedata() throws IOException  {
			
			String path = "C:\\Users\\Shubham\\Desktop\\data1.xlsx";
			FileInputStream file = new FileInputStream(path);
			Workbook wb = new XSSFWorkbook(file);
			Sheet a = wb.getSheet("Sheet3");
			
			for (int i =1; i<=l.size();i++)
			{ if(i==l.size())
			   { Row row1 = a.getRow(i);
				Cell cell = row1.createCell(3);
				cell.setCellValue(h.getbusdata(i-1));	
			   }
			}
			
			
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();
			
		}
	
	
	
	

}
