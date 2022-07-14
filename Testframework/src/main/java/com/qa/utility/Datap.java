package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pageLayer.redbusHomepage;

public class Datap{

redbusHomepage h = new redbusHomepage();

	@DataProvider(name = "testData1")
	public Object[][] mydata(ArrayList<String>l) throws IOException{
		
		String path = "C:\\Users\\Shubham\\Desktop\\data.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(file);
		Sheet a = wb.getSheet("Sheet3");
		
		int row = a.getLastRowNum();
		int exactRow = row+1;
		
		int exactCell = a.getRow(0).getLastCellNum()-1;
		
		System.out.println(exactRow);
		System.out.println(exactCell);
	
		
		String [][] d = new String [exactRow-1][exactCell];
		
		for (int i =0; i<exactRow;i++)
		{ if(i==0)
		   {continue;}
			for(int j=0; j<exactCell; j++)
		{ String srccity = a.getRow(i).getCell(j).getStringCellValue();
			d [i-1][j] = srccity;
			
		}
			
			Row row1 = a.getRow(i);
			Cell cell = row1.createCell(3);
			cell.setCellValue(h.getbusdata(i));	
			}
			
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();

			
    
		return d;
	}
	
	
	

	
	
	
	}


