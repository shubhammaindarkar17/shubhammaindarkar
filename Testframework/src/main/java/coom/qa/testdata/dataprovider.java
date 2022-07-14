package coom.qa.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class dataprovider {
	
	
	
	@DataProvider(name = "searchdata")
	public Object[][] testData() throws EncryptedDocumentException, IOException {
		
		String path = "C:\\Users\\Shubham\\ecli-workspace1\\TestFramework\\TestData.xlsx";
		FileInputStream file = new FileInputStream(path);
		Sheet a = WorkbookFactory.create(file).getSheet("Sheet1");
		
		int r= a.getLastRowNum();
		int exactRow = r+1;
		
		int exactcell = a.getRow(0).getLastCellNum();
		
		String [][] value = new String[exactRow][exactcell];
		
		
		for(int i=0; i<exactRow;i++)
		{ for(int j =0; j<exactcell; j++)
		 {
			 value[i][j] = a.getRow(i).getCell(j).getStringCellValue();
		 }
			
			
		}
		return value;
		
		
	}

}
