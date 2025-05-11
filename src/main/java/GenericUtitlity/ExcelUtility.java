package GenericUtitlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	
	
	@DataProvider(name="loginDataa")
	public String getexcelSheet(String sheetname , int row , int cell ) throws  EncryptedDocumentException ,IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/Data9.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 return wb.getSheet(sheetname).getRow(row).getCell(cell).toString();			
	}

	@DataProvider(name="loginData")
	public String[][] getData() throws Exception {
		File excelFile = new File("./src/test/resources/TestData/Data9.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Dota");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
	
		String[][] data = new String[noOfRows-1][noOfColumns];
		for (int i = 0; i < noOfRows-1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] =  df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		
 		for (String[] dataArr : data) {
 			System.out.println(Arrays.toString(dataArr));
 		}
		return data;
	}
	
	
	
	
	
}
