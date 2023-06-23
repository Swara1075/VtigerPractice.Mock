package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell cel = rw.getCell(cellNum);
	    return cel.getStringCellValue();
	  }
	
	public void writeDataIntoExcelFile(String sheetName,int rowNum,int cellNum,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		wb.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	public Object[][] readMultipleDataFromExcel(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCel];
		for(int i = 0; i<lastRow; i++)
		{
			for(int j=0; j<lastCel; j++)
			{
				 data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		
		return data;
		
	}

}
