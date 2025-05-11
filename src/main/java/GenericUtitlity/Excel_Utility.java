package GenericUtitlity;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
public class Excel_Utility {

	
	
	 @org.testng.annotations.DataProvider(name = "excelData")
	    public static Object[][] getExcelData() {
	        String filePath = "./src/test/resources/TestData/Data9.xlsx";
	        String sheetName = "Gota";

	        Object[][] data = null;

	        try {
	            FileInputStream fis = new FileInputStream(filePath);
	            Workbook workbook = WorkbookFactory.create(fis);
	            Sheet sheet = workbook.getSheet(sheetName);

	            int rowCount = sheet.getPhysicalNumberOfRows();
	            int colCount = sheet.getRow(0).getLastCellNum(); // Handles empty cells better

	            data = new Object[rowCount - 1][colCount]; // Skip header row

	            for (int i = 1; i < rowCount; i++) {
	                Row row = sheet.getRow(i);
	                for (int j = 0; j < colCount; j++) {
	                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                    data[i - 1][j] = cell.toString();
	                }
	            }

	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return data;
	    }
}
	
	
	