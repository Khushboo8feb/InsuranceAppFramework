package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	 String filePath;
	 Sheet sheet;
	public ExcelOperations(String sheetName) 
	{
		  try {
			filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertiesValueByKey("testDataLocation");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		  File testDataFile = new File(filePath);
		  Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		  sheet = wb.getSheet(sheetName);

	}
	
	public HashMap<String, String> getTestDataInMap(int rowNum) throws EncryptedDocumentException, IOException
	{
		
		//Location - where is excel file
		//Open file - workbook
		
		//sheet.getRow(0).getCell(1).toString();
		//read data row by row annd put in Map
		HashMap<String, String> hm = new HashMap();
		
		for(int i =0; i<sheet.getRow(0).getLastCellNum(); i++)
		{
			//sheet.getRow(rowNum).getCell(i).getStringCellValue();
			hm.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNum).getCell(i).toString());
		}
		
		return hm;
	}
	
	public int getRowCount()
	{
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	public int getColCount()
	{
		int colCount = sheet.getRow(0).getLastCellNum();
		return colCount;
	}
	/*public static void main(String [] args) throws Exception
	{
		ExcelOperations e = new ExcelOperations();
		System.out.println(e.getTestDataInMap(2));
	}*/

}
