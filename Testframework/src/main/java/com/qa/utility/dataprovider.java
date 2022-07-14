package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pageLayer.redbusHomepage;
import com.qa.testBase.TestBase;

public class dataprovider  {
	
	@DataProvider(name = "testdata")
	public Object[][] mydata() throws IOException{
		
		String path = "C:\\Users\\Shubham\\Desktop\\data1.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(file);
		Sheet a = wb.getSheet("Sheet3");
		
		int row = a.getLastRowNum();
		int exactRow = row+1;
		
		int exactCell = a.getRow(0).getLastCellNum()-1;
		
		String [][] d = new String [exactRow-1][exactCell];
		
		for (int i =0; i<exactRow;i++)
		{ if(i==0)
		   {continue;}
			for(int j=0; j<exactCell; j++)
		{ String value = a.getRow(i).getCell(j).getStringCellValue();
			d [i-1][j] = value;
		}
			
    }
	
		return d;
	}
	
	
	
}
	
	


