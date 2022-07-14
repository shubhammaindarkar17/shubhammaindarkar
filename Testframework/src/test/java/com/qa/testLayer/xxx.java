package com.qa.testLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.qa.pageLayer.redbusHomepage;

public class xxx {
	
	public static ArrayList <String> s = new ArrayList();
	
	@Test(priority =0)
	public void checkrow(){
	
	s.add("120 bus");
	s.add("190 bus");
	
	
	
	System.out.println(s);

	}
	
	public String getbusdata(int i) {
		String bus = s.get(i);
		 return bus;
		}
	
	@Test(priority =1)
    public void savedata() throws IOException  {
		
		String path = "C:\\Users\\Shubham\\Desktop\\data.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(file);
		Sheet a = wb.getSheet("Sheet3");
		
		for (int i =1; i<=s.size();i++)
		{  if (i==s.size())
			{xxx x = new xxx();
			Row row1 = a.getRow(i);
			Cell cell = row1.createCell(3);
			cell.setCellValue(x.getbusdata(i-1));}	
		}
		
		
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		
	}
}
